package com.ys.delphi.notification.consumer;


import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.ys.delphi.notification.model.FisAlarm;
import com.ys.delphi.notification.model.KafkaMessage;
import com.ys.delphi.notification.model.SubscriptionList;
import com.ys.delphi.notification.service.NotificationService;
import com.ys.delphi.notification.service.impl.NotificationServiceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class FISAlarmConsumer  implements Callable<Boolean> {

	private static Log _log = LogFactoryUtil.getLog(FISAlarmConsumer.class);
	private NotificationService notificationService = new NotificationServiceImpl();
	
	String FILE_NAME= PropsUtil.get("kafka.offset.file");
	private static FISAlarmConsumer fisAlarmConsumer;
	private static Lock lock =  new ReentrantLock();
	private volatile boolean flag = false;
	private volatile boolean pause = false;	
	private final long pause_interval = 2000;//in MiliSeconds

	private final ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(1000000);
	
	private final ThreadPoolExecutor   executor = new ThreadPoolExecutor(4, 4, 0L, TimeUnit.MILLISECONDS,queue,(Runnable r, ThreadPoolExecutor executor) ->{
		_log.error(r.toString() + " was rejected, resubmitting");		
		executor.submit(r);
	} );
	private  String server = PropsUtil.get("kafka.bootstrap.servers");
	private  String groupId = PropsUtil.get("kafka.group.id");
	private  List<String> topics = Arrays
			.asList(PropsUtil.get("kafka.topics"));

	
	private final KafkaConsumer<String, String> consumer;
	private final long polling_interval = 5000;//in MiliSeconds
	private volatile long  offset = 0;

	private FISAlarmConsumer(long offset) {
		Properties props = new Properties();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, server);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.ByteArrayDeserializer");
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest"); 
		props.put(ConsumerConfig.CLIENT_ID_CONFIG, "offset123");
		// setting the context class loader to null. 
		Thread.currentThread().setContextClassLoader(null);
		this.consumer = new KafkaConsumer<String, String>(props);
		
		this.offset = offset;
		 _log.debug("offset : " + offset);
	}
	public static FISAlarmConsumer getInstance(long offset) {
		lock.lock();
		try {
			if (fisAlarmConsumer == null) {
				fisAlarmConsumer = new FISAlarmConsumer(offset);
			}
		} finally {
			lock.unlock();
		}
		return fisAlarmConsumer;
	}

	
	@Override
	public Boolean call() throws Exception {
		_log.debug("inside call, flag : "+flag);		
		try{
			consumer.subscribe(topics, new ConsumerRebalanceListener() {
				
				@Override
				public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
					_log.debug(Arrays.toString(partitions.toArray()) +" topic-partitions are revoked from this consumer\n");
					
				}
				
				@Override
				public void onPartitionsAssigned(Collection<TopicPartition> partitions) {
					
					_log.info(Arrays.toString(partitions.toArray()) +" topic-partitions are assigned from this consumer\n");
	                    Iterator<TopicPartition> topicPartitionIterator = partitions.iterator();
	                    while(topicPartitionIterator.hasNext()){
	                    	List<TopicPartition> individualPartition = new ArrayList<>();
	                        TopicPartition topicPartition = topicPartitionIterator.next();
	                        _log.info("Current offset is " + consumer.position(topicPartition) + " committed offset is ->" + consumer.committed(topicPartition) );
	                        if(offset == -2) {
	                            _log.info("Leaving it alone");
	                        }else if(offset ==0){
	                        	_log.info("Setting offset to begining");
	                        	individualPartition.add(topicPartition);
	                            consumer.seekToBeginning(individualPartition);
	                        }else if(offset == -1){
	                            _log.info("Setting it to the end ");
	                            individualPartition.add(topicPartition);
	                            consumer.seekToEnd(individualPartition);
	                        }else {
	                            _log.info("Resetting offset to " + offset);
	                            consumer.seek(topicPartition, offset);
	                        }
	                    }
					
				}
			});

			while (flag) { // check for the stop signal
				while(pause){ // check for the pause signal
					Thread.sleep(pause_interval);
				}
				ConsumerRecords<String, String> records = consumer
						.poll(polling_interval);				
				
				_log.debug("Size of the queue is --> " + queue.size());
				_log.debug("records size : " +records.count());

				saveOffsetToFile(offset);									
				consumer.commitAsync();
				
			 	for (ConsumerRecord<String, String> record : records) {
					_log.debug("partition : " + record.partition());
					_log.debug("offset : " + record.offset());
					_log.debug("value : " + record.value());
					offset = record.offset();
					
					String jsonData =record.value();
					if(queue.remainingCapacity() < 100){
						_log.error("queue capacity is less than 100, put the consumer to sleep for 5 seconds");
						Thread.sleep(5000);
					}
					
						executor.execute(() -> { 
							_log.debug(Thread.currentThread().getName());												
							 try {
									processMessage( jsonData);
								} catch (Exception e) {
									_log.error(e.getMessage());
									e.printStackTrace();
								}			 
							

						});
					
					
				}
							
			}	
		}catch(Exception e ){
			_log.error(e.getMessage());
			e.printStackTrace();
		}
		finally{
			consumer.unsubscribe();
		}
			_log.debug("outside while run, flag : "+flag);	
			return flag;
	
	}

		
	public long getOffset() {
		return offset;
	}
	public void setOffset(long offset) {
		if(offset > 0){
			this.offset = offset;
		}
		
	}
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public void processMessage(String jsonData) throws Exception{
		while(pause){
			Thread.sleep(pause_interval);
		}
		
		_log.debug("msg : "+jsonData);
		Instant startInstant = Instant.now();
		try {
			JSONObject msg = JSONFactoryUtil.createJSONObject(jsonData);
		String alarmId = msg.getString("Id");
		 String startTime =  msg.getString("time");
		 String active =  msg.getString("active");	
		 String notification = "false";
		 try{
			 notification =  msg.getString("notification");
		 }
		 catch(Exception ex){
			_log.error(ex);
		 }
		 
		 if(active.equalsIgnoreCase("false")){
			 _log.debug("Just updateing the notification table to disable notification");
			 notificationService.inActiveFisNotification(alarmId, startTime);
			 return;
		 }

		 
		 DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS");
		 KafkaMessage kafkaMessage = new KafkaMessage(alarmId, DateTime.parse(startTime,fmt));
		 _log.debug("kafkaMessage :"+kafkaMessage);		
		
		 FisAlarm fisAlarm  = null;
		 for(int i = BigDecimal.ZERO.intValue();i <= 5;i++){
			 fisAlarm = notificationService.getFisAlarm( kafkaMessage);
			 if(fisAlarm == null){
				 _log.debug("fisAlarm is null, retrying after 30,000 miliseconds");
				 Thread.sleep(30000);
			 }else{
				 break;
			 }
		 }
		 
		 // deactivate all existing alarms for this cycle time alerts
		 if(fisAlarm.getAlertType().equalsIgnoreCase("CYCLETIME ALERT") || fisAlarm.getAlertType().equalsIgnoreCase("YIELD ALERT")){
			 notificationService.inActiveFisNotification(alarmId, startTime);
		 }
		 
		SubscriptionList subscriptionList =  notificationService.getSubscriberUserList(fisAlarm);
		_log.debug("SubscriptionList Size : "+subscriptionList.size());
		if(subscriptionList.isEmpty()){
			_log.debug("This message will not be processed as there is no subscriber");
			return;
		}
		notificationService.saveFisNotification(fisAlarm, subscriptionList);
		 
		if(fisAlarm.isAlarmActive() && notification.equalsIgnoreCase("true")){
			for(int i =0;i < subscriptionList.size();i++){
				Message message = new Message();
				message.put("userId", subscriptionList.getUserList().get(i));
				message.put("subName", subscriptionList.getSubscriptionNameList().get(i));
				message.put("subDesc", subscriptionList.getSubscriptionDescList().get(i));
				message.put("emailSMSNotification", subscriptionList.getEmailSMSNotificationList().get(i));
				message.put("fisAlarm", fisAlarm.toJSON().toString());				
				MessageBusUtil.sendMessage("liferay/bulk/mail/destination", message);
			}
			
		}else{

			_log.debug("alram is not active, no email/SMS will be sent");
		}
		
		} catch (Exception e) {
			_log.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
	private synchronized long getOffsetFromFile(){
		long offset = 0;
		Properties props = new Properties();
	    InputStream is = null;
	    _log.debug("Offset fileName : "+FILE_NAME);
		try {			
			File f = new File(FILE_NAME);
			 is = new FileInputStream( f );
			 props.load( is );		
			 offset = Long.parseLong(props.getProperty("offset"));
			 _log.info("getOffsetFromFile, offset : " + offset);
		} catch (Exception io) {
			_log.error(io.getMessage());
			io.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return offset;
	}
	private void saveOffsetToFile(long offset){
		 _log.debug("saveOffsetToFile, offset : " + offset);
		 if(offset < 0){
			 _log.error("offset is negative, not saving");
			 return;
		 }
		Properties props = new Properties();
	   OutputStream output = null;

		try {			
			File f = new File(FILE_NAME);
			output = new FileOutputStream( f );
			 props.setProperty("offset", Long.toString(offset));
			 props.store(output, null);
		} catch (Exception io) {
			_log.error(io.getMessage());
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}
	
	public ExecutorService getExecutor() {
		return executor;
	}
	
	public void clearQueue() {
		this.queue.clear();
	}
	
	public void pauseConsumer(){
		this.pause = true ;
	}
	
	public void resumeConsumer(){
		this.pause = false ;
	}
	
}
