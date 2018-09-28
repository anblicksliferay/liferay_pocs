package com.ys.delphi.notification.portlet;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.ys.delphi.notification.consumer.FISAlarmConsumer;
import com.ys.delphi.notification.util.DailyTimerTasks;
import com.ys.delphi.notification.util.SubscriptionDenormalizer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Delphi",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Kafka-meessage-consumer-admin",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/kafkamessageconsumeradmin/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class KafkaMessageConsumerAdmin extends MVCPortlet {
	private static Log _log = LogFactoryUtil.getLog(KafkaMessageConsumerAdmin.class);
	private FISAlarmConsumer consumer = null;
	private  ExecutorService executor= null;
	private Future<Boolean > future;
	private String notficationURL = StringPool.BLANK;
	
	
	@Override
	public void init() throws PortletException {
		super.init();
		 String consumerStartFlag = PropsUtil.get("kafka.start.consumer");
		 if(consumerStartFlag == null || consumerStartFlag.trim().equalsIgnoreCase("true")){
				long offset = getOffsetFromFile();
				startConsumer(offset); 
		 }
		 
		Timer time = new Timer(true);
		String frequency = PropsUtil.get("frequency.explode.process");	
		long duration = 3600*24*1000 ; // every day
		if(frequency != null && !frequency.isEmpty()){
			duration =  Long.getLong(frequency);
		}
		DailyTimerTasks dtt = new DailyTimerTasks();
		_log.info("Starting DailyTimerTasks  for every " + duration);
		time.schedule(dtt, 0, duration); 
	}

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		setNotificationURL( renderRequest);
		long offset = getOffsetFromFile();
		renderRequest.setAttribute("offset", offset);
		PortletRequestDispatcher prd = getPortletContext()
				.getRequestDispatcher(getInitParameter("view-template"));		
		prd.include(renderRequest, renderResponse);
	}
 
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		String cmd = ParamUtil.getString(resourceRequest, "cmd");
		String cmdType = ParamUtil.getString(resourceRequest, "cmdType");
		String context = ParamUtil.getString(resourceRequest, "context");
		_log.info("serveResource command is: "+cmd +" with cmdType(optional): "+cmdType +" with context(optional): "+context);
		
		JSONObject msg = JSONFactoryUtil.createJSONObject();
		String message = StringPool.BLANK;
		
		if(cmd.equalsIgnoreCase("list")){
			message=Boolean.toString(consumer.isFlag());
		}else if(cmd.equalsIgnoreCase("start")){
			JSONObject data;
			try {
				data = JSONFactoryUtil.createJSONObject(context);
				long offset= data.getLong("offset");				
				startConsumer(offset);
			} catch (Exception e) {
				_log.error(e.getMessage());
				e.printStackTrace();
			}
						
		}else if(cmd.equalsIgnoreCase("send")){
			JSONObject data;
			try {
				data = JSONFactoryUtil.createJSONObject(context);
				_log.info("data :"+data.toString());
				long offset = getOffsetFromFile();
				consumer = FISAlarmConsumer.getInstance(offset);
				consumer.processMessage(data.toString());
			} catch (Exception e) {
				_log.error(e.getMessage());
				e.printStackTrace();
			}
					
		}else {
			message=stopConsumer();
			stopConsumer();
		}
		
		
		_log.info("msg : "+message);
		msg.put("msg",message); //needs actual counts
		writeJSON(resourceRequest, resourceResponse, msg);
		
	}
	
	private String startConsumer(long offset){
		executor = Executors.newFixedThreadPool(1);
		consumer = FISAlarmConsumer.getInstance(offset);
		consumer.setOffset(offset);
		String message="Trying to Start Consumer";
		_log.info(message);
		consumer.setFlag(true);
			message = "Starting consumer";
			_log.info(message);
			future = executor.submit(consumer);
		
		return message;
		
	}
	
	private String stopConsumer(){
		consumer.setFlag(false);
		String message="Trying to Stop Consumer";
		_log.info(message);
		try {
			boolean status = future.get(2000, TimeUnit.MILLISECONDS);
			_log.info("status : "+status);
			if(future.isDone()){
				_log.info("Consumer Stopped");
				message="Consumer STOPPED";
			}else{
				_log.info("Consumer NOT Stopped");
				message="Consumer NOT STOPPED";
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
			message="Issue in Stopping consumer";
			e.printStackTrace();
		}
		
		shutdownAndAwaitTermination(executor);
		consumer.clearQueue();
		
		return message;
		
	}

	@Override
	public void destroy() {
		if(future != null){
			future.cancel(true);
		}
		if(consumer != null)
		{		
			shutdownAndAwaitTermination(consumer.getExecutor());
		
		}
		
		if(executor != null)
		shutdownAndAwaitTermination(executor);
		super.destroy();
	}

	 private void shutdownAndAwaitTermination(ExecutorService pool) {
		 if(pool == null){
			 _log.error("pool is null while shutting down");
			 return;
		 }
		 _log.info("Shutting down executor");
		   pool.shutdown(); // Disable new tasks from being submitted
		   try {
		     // Wait a while for existing tasks to terminate
		     if (!pool.awaitTermination(2, TimeUnit.SECONDS)) {
		       pool.shutdownNow(); // Cancel currently executing tasks
		       // Wait a while for tasks to respond to being cancelled
		       if (!pool.awaitTermination(60, TimeUnit.SECONDS))
		           _log.error("Pool did not terminate");
		     }
		   } catch (InterruptedException ie) {
		     // (Re-)Cancel if current thread also interrupted
		     pool.shutdownNow();
		     // Preserve interrupt status
		     Thread.currentThread().interrupt();
		   }
		 }
	 private void setNotificationURL(RenderRequest renderRequest){
			StringBuffer url = new StringBuffer();
			url.append(com.liferay.portal.kernel.util.PortalUtil.getPortalURL(renderRequest));
			url.append(PropsUtil.get("notification.url"));
			
			this.notficationURL= url.toString();
		}
	 
	 
	 private String FILE_NAME= PropsUtil.get("kafka.offset.file");
	 private long getOffsetFromFile(){
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

}
