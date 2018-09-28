package com.ys.delphi.notification.service.impl;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.ys.delphi.notification.model.ChangeOverHistory;
import com.ys.delphi.notification.model.FisAlarm;
import com.ys.delphi.notification.model.KafkaMessage;
import com.ys.delphi.notification.model.Notification;
import com.ys.delphi.notification.model.NotificationHistory;
import com.ys.delphi.notification.model.NotificationHistoryWithThreshold;
import com.ys.delphi.notification.model.NotificationList;
import com.ys.delphi.notification.model.NotificationQuery;
import com.ys.delphi.notification.model.RegionSiteServer;
import com.ys.delphi.notification.model.RegionSiteServerList;
import com.ys.delphi.notification.model.SubscriptionList;
import com.ys.delphi.notification.service.NotificationService;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;

public class NotificationServiceImpl implements NotificationService{
	private static Log _log = LogFactoryUtil.getLog(NotificationServiceImpl.class);
	private static String CRITICAL="Critical";
	private static String WARNINIG = "Warn";
	private static String INFO = "Info";
	private static String CYCLETIME_ALERT="CYCLETIME ALERT";
	private static String CHANGEOVER_ALERT="CHANGEOVER ALERT";
	private static String DOWNTIME_ALERT="DOWNTIME ALERT";
	private static String YIELD_ALERT="YIELD ALERT";

	private static String ACTIVE="Active";
	private static String IN_ACTIVE="Inactive";
	
	@Override
	public NotificationList getNotifications(NotificationQuery notificationQuery) throws Exception{
		_log.debug(notificationQuery);
		NotificationList notificationList = new NotificationList();
		List<Notification> notifications = new ArrayList<Notification>();
		notificationList.setNotifications(notifications);
		
		String alarmId = StringPool.BLANK;
		String name = StringPool.BLANK;
		String server = StringPool.BLANK;
		String region = StringPool.BLANK;
		String location = StringPool.BLANK;
		String partNumber = StringPool.BLANK;
		String process = StringPool.BLANK;
		String station = StringPool.BLANK ;
		String level = StringPool.BLANK;
		String duration = StringPool.BLANK;
		String status = StringPool.BLANK ;
		String alertType = StringPool.BLANK;
		String localStartDate = StringPool.BLANK;
		
		double deviation = 0;
		BigDecimal threshold= null;
		int subId = 0;
		Timestamp startTimeUTC = null;
		Timestamp eventDate = null;
		
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		String subscriptionIds = getSubScriptionId(notificationQuery.getUserId());
		if(!subscriptionIds.isEmpty()){

			try{
				connection = DelphiHbaseServerConnection.getConnection();
				StringBuilder sb = new StringBuilder("Select fis_notifications.AID as alarmId ,fis_notifications.SID as subId, fis_notifications.RN as region , fis_notifications.LOC as location ,fis_notifications.SNM as name, fis_notifications.SV as server, fis_notifications.PN as partNumber, fis_notifications.PR as process, fis_notifications.SN as station, fis_notifications.TH as threshold, fis_notifications.L as level, fis_notifications.A as status, fis_notifications.D as deviation, fis_notifications.T as alertType, fis_notifications.EVL as localStartDate ,fis_notifications.EV as eventDate ,fis_notifications.ST as startTimeUTC   from  fis_notifications   where   fis_notifications.UID = ?");
				sb.append("  and fis_notifications.SID in  ("+subscriptionIds+")  ");

				if(notificationQuery.getRegionSiteServer() != null ){
					if(notificationQuery.getRegionSiteServer().getRegionName() != null && !notificationQuery.getRegionSiteServer().getRegionName().trim().isEmpty()){
						sb.append( " and  fis_notifications.RN ='").append(notificationQuery.getRegionSiteServer().getRegionName()).append("'");
					}
					if(notificationQuery.getRegionSiteServer().getSiteName() != null && !notificationQuery.getRegionSiteServer().getSiteName().trim().isEmpty() ){
						sb.append( " and fis_notifications.LOC ='").append(notificationQuery.getRegionSiteServer().getSiteName()).append("'");
					}
					if(notificationQuery.getRegionSiteServer().getServerName() != null && !notificationQuery.getRegionSiteServer().getServerName().trim().isEmpty() ){
						sb.append( " and fis_notifications.SV ='").append(notificationQuery.getRegionSiteServer().getServerName()).append("'");
					}
				}
				
				/* if(notificationQuery.getStartDate() != null &&  notificationQuery.getEndDate() != null){
					sb.append("  and fis_notifications.ST between ? and ? ");
				}*/
				
				if(notificationQuery.getDays() > 0){
					sb.append("  and fis_notifications.ST > CURRENT_DATE() - ").append(notificationQuery.getDays());
				}
				_log.debug(sb.toString());
				ps = connection.prepareStatement(sb.toString());
				ps.setString(1, Long.toString(notificationQuery.getUserId()));
				/* if(notificationQuery.getStartDate() != null &&  notificationQuery.getEndDate() != null){
					ps.setDate(2, new java.sql.Date(notificationQuery.getStartDate().getMillis()));
					ps.setDate(3, new java.sql.Date(notificationQuery.getEndDate().getMillis()));
				}*/
				
				rs = ps.executeQuery();
				
				while(rs.next()){	
					alarmId =  GetterUtil.getString(rs.getString("alarmId"));
					name =  GetterUtil.getString(rs.getString("name"));
					server =  GetterUtil.getString(rs.getString("server"));
					partNumber =  GetterUtil.getString(rs.getString("partNumber"));
					region =  GetterUtil.getString(rs.getString("region"));
					location =  GetterUtil.getString(rs.getString("location"));
					process =  GetterUtil.getString(rs.getString("process"));
					station =  GetterUtil.getString(rs.getString ("station"));
					level =  GetterUtil.getString(rs.getString("level"));
					status = GetterUtil.getBoolean(rs.getBoolean("status"))?ACTIVE:IN_ACTIVE ;
					alertType =  GetterUtil.getString(rs.getString("alertType")); 
					deviation = GetterUtil.getDouble(rs.getDouble("deviation"));
					localStartDate =  GetterUtil.getString(rs.getString("localStartDate"));	
					eventDate =   rs.getTimestamp("eventDate");
					threshold = rs.getBigDecimal("threshold");
					startTimeUTC = rs.getTimestamp("startTimeUTC");
					subId = rs.getInt("subId");
	
					if(alertType.equalsIgnoreCase(DOWNTIME_ALERT)){
						startTimeUTC = eventDate;
					}
					
					if(status.equalsIgnoreCase(ACTIVE)){
						duration = getDuration(startTimeUTC);
					}else{
						duration= StringPool.BLANK;
					}
					
					_log.debug("name=" + name + ", partNumber=" + partNumber
					+ ", process=" + process + ", station=" + station + ", level="
					+ level + ", duration=" + duration + ", status=" + status
					+ ", alertType=" + alertType + ", deviation=" + deviation
					+ ", server=" + server + ", threshold="
					+ threshold +", localStartDate = "+localStartDate+", startTimeUTC = "+startTimeUTC+" , duration = "+duration+", alarmId = "+alarmId);
					String 	thresholdInString = covertToMMSS(threshold);
					
					if(alertType.equalsIgnoreCase(DOWNTIME_ALERT)){
						eventDate = startTimeUTC;
					}
					notifications.add(new Notification(name,  partNumber,  process,
								station,  level,  duration,  status,
								alertType,  deviation,  localStartDate,  server,thresholdInString,subId,region,location,eventDate.toString(),alarmId));
				}
				
			} catch (Exception e1) {
				_log.error(e1);
				_log.debug(e1.getStackTrace());;
				throw new Exception(e1);
			} finally {
					DelphiHbaseServerConnection.close(connection, ps, rs);
			
			}
		}
		
		//_log.debug("size of notificationList : "+notificationList.getNotifications().size());
//		populateSubscriptionData(notifications);
		return notificationList;
	}

	private String getDuration(java.sql.Timestamp startTimeUTC){	
		
		if(startTimeUTC == null){
			return StringPool.BLANK;
		}
		DateTime now = DateTime.now();			
			
		long diff = now.getMillis() - startTimeUTC.getTime();		
		LocalTime interval = LocalTime.fromMillisOfDay(diff);
		
		_log.debug("startTimeUTC.getTime() :  "+startTimeUTC.getTime());
		
		_log.debug(" now : "+now.toString());
		_log.debug(" interval : "+interval.toString());
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("days", Math.floor(diff/(1000*60*60*24)));
		String hours = (interval.getHourOfDay() < 9 ? "0"+ interval.getHourOfDay(): Integer.toString(interval.getHourOfDay()));
		String minutes = (interval.getMinuteOfHour() < 9 ? "0"+ interval.getMinuteOfHour(): Integer.toString(interval.getMinuteOfHour()));
		String seconds = (interval.getSecondOfMinute() < 9 ? "0"+ interval.getSecondOfMinute(): Integer.toString(interval.getSecondOfMinute()));
		
		json.put("hours", hours);
		json.put("minutes", minutes);
		json.put("seconds", seconds);
		
		return json.toString();
	}
	
	private static String covertToMMSS(BigDecimal bigDecimal){		
		if(bigDecimal== null){
			return "00:00";
		}
		LocalTime localTime = LocalTime.fromMillisOfDay(bigDecimal.longValue());
		
		return (localTime.getMinuteOfHour() <10?"0"+localTime.getMinuteOfHour() : localTime.getMinuteOfHour())
				+":"+(localTime.getSecondOfMinute() < 10 ? "0"+ localTime.getSecondOfMinute(): localTime.getSecondOfMinute());
	}
	
	private String getSubScriptionId(long userId) throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;		
	
		StringBuilder query = new StringBuilder("Select SUBSCRIPTION_ID as id ");
		
		query.append(" from fis_subscriptions_catalog  where USER_ID  = ?");		
		_log.debug("subscription query : "+query);
		List<Integer> subscriptions = new ArrayList<Integer>();
		Integer subscription_id = 0;
		try {
			con = DataAccess.getConnection();
									
				ps = con.prepareStatement(query.toString());				
				ps.setLong(1, userId);				
				rs = ps.executeQuery();				
				while(rs.next()){	
					subscription_id =  GetterUtil.getInteger(rs.getString("id"));
					subscriptions.add(subscription_id);
					_log.debug("subscription_id :"+subscription_id);
				}
		} catch (Exception e) {
			
			_log.error("getSubScriptionId failed for user with id "+userId +", "+ e.getMessage());
			_log.debug(e.getStackTrace());;
			throw new Exception(e);
		} finally {
			DataAccess.cleanUp(con,ps,rs);
		}
		
		StringBuffer sb = new StringBuffer();
		if(subscriptions.size() == 1){
			sb.append(subscriptions.get(0));
		}
		else if (subscriptions.size() > 1) {
			for( int i = 0; i < subscriptions.size() -1; i++){
				sb.append(subscriptions.get(i)).append(",");
			}			
			sb.append(subscriptions.get(subscriptions.size() -1));
		}
		_log.debug("subscription_ids :"+sb.toString());
		return sb.toString();
	}
	
	private void populateSubscriptionData(List<Notification> notifications) throws Exception{

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;		
		
		String subscriptionDesc = StringPool.BLANK;
		String productType = StringPool.BLANK;
		String productFamily = StringPool.BLANK;
		
		StringBuilder query = new StringBuilder("Select SUB_DESC as subscriptionDesc , PRODUCT_TYPE as productType, PRODUCT_FAMILY as productFamily, PART_NUMBER as partNumber, PROCESS as process ");
		
		query.append(" from fis_subscription_expanded sub, fis_subscriptions_catalog cat where sub.SUBSCRIPTION_ID = cat.SUBSCRIPTION_ID and cat.SUBSCRIPTION_ID = ?");
		query.append(" and sub.STATION = ? ");
		query.append(" and (sub.SERVER = ? OR sub.SERVER = ?)");
		query.append(" and sub.PART_NUMBER = ? ");
		query.append(" and sub.PROCESS = ? ");
		_log.debug("subscription query : "+query);
		
		try {
			con = DataAccess.getConnection();
			Iterator<Notification> iterator = notifications.iterator();
			while(iterator.hasNext()){
				Notification notification = iterator.next();
				if(notification.getAlertType().equalsIgnoreCase(YIELD_ALERT)){
					notification.setProductFamily("-");
					notification.setProductType("-");
					String yieldSubQuery = "Select SUB_DESC as subscriptionDesc from fis_subscriptions_catalog  where SUBSCRIPTION_ID = ?" ; 
					ps = con.prepareStatement(yieldSubQuery);
					ps.setInt(1, notification.getSubId());
					rs = ps.executeQuery();
					if(rs.next()){	
						subscriptionDesc =  GetterUtil.getString(rs.getString("subscriptionDesc"));					
						notification.setDesc(subscriptionDesc);
					}
					else{
						_log.debug("The subscription does not exit, drop the record");
						iterator.remove();
					}
				}else{
					ps = con.prepareStatement(query.toString());
					
					ps.setInt(1, notification.getSubId());
					ps.setString(2, notification.getStation());
					ps.setString(3, notification.getServer().substring(0, notification.getServer().indexOf('.')));
					ps.setString(4, notification.getServer());				
					ps.setString(5, notification.getPartNumber());
					ps.setString(6, notification.getProcess());

					rs = ps.executeQuery();
					
					if(rs.next()){	
						subscriptionDesc =  GetterUtil.getString(rs.getString("subscriptionDesc"));					
						productType =  GetterUtil.getString(rs.getString("productType"));
						productFamily =  GetterUtil.getString(rs.getString("productFamily"));

						_log.debug("subscriptionDesc :"+subscriptionDesc);
						_log.debug("productType :"+productType);
						_log.debug("productFamily :"+productFamily);
						notification.setDesc(subscriptionDesc);
						notification.setProductFamily(productFamily);
						notification.setProductType(productType);
						
					}else{
						_log.debug("The subscription does not exit, drop the record");
						iterator.remove();
					}
				}
				
				DataAccess.cleanUp(rs);
				DataAccess.cleanUp(ps);
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
			_log.debug(e.getStackTrace());
			throw new Exception(e);
		} finally {
			DataAccess.cleanUp(con,ps,rs);
		}
	}
	
	@Override
	public RegionSiteServerList getRegionSiteServerList() throws Exception {
		_log.debug("getRegionSiteList");
		RegionSiteServerList  regionSiteList = new RegionSiteServerList();
		List<RegionSiteServer> regionSiteServers = new ArrayList<RegionSiteServer>();
		regionSiteList.setRegiosSitesSerevers(regionSiteServers);
		
		Connection connection = null;
		PreparedStatement delphiStmt = null;
		ResultSet delphiRS = null;
		
		try{
			connection = DelphiHbaseServerConnection.getConnection();
			delphiStmt  = connection.prepareStatement("Select distinct RN, LOC, SV From FIS_PART_THRESHOLDS");
			
			delphiRS = delphiStmt.executeQuery();
			while (delphiRS.next()) {
				RegionSiteServer rs = new RegionSiteServer( delphiRS.getString("SV"), delphiRS.getString("RN"), delphiRS.getString("LOC"));
				regionSiteServers.add(rs);
			}
			
		} catch(Exception e){
			_log.error("error while retrieving data from table");
			_log.error(e);
		} finally {
			DelphiHbaseServerConnection.close(connection, delphiStmt, delphiRS);
		}
		
		return regionSiteList;
	}

	@Override
	public FisAlarm getFisAlarm(KafkaMessage kafkaMessage) throws Exception {
		_log.debug("kafkaMessage : "+kafkaMessage);
		FisAlarm fisAlarm = null;
		Connection connection = null;
		String alarmId = StringPool.BLANK;
		String serverName = StringPool.BLANK;
		String partNumber =  StringPool.BLANK;
		String process = StringPool.BLANK;
		String station = StringPool.BLANK;
		Timestamp eventTimeUTC  =null;
		String eventTimeLocal  = StringPool.BLANK;	
		String alarmLevel  = StringPool.BLANK;
		double deviation   =Double.MIN_VALUE;
		String alertType =  StringPool.BLANK;
		long count = Long.MIN_VALUE;
		boolean isAlarmActive = false;
		DateTime alarmStartTime = null ;
		BigDecimal thresholdDuration = BigDecimal.ZERO;
		String productType = StringPool.BLANK;
		String productFamily = StringPool.BLANK;
		String region = StringPool.BLANK;
		String location = StringPool.BLANK;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			connection = DelphiHbaseServerConnection.getConnection();			
				ps = connection.prepareStatement("Select * from FIS_ALARMS where ID = ? and ST = ?");
				ps.setString(1, kafkaMessage.getAlarmId());
				ps.setTimestamp(2, new java.sql.Timestamp(kafkaMessage.getAlarmStartTime().getMillis()));
				rs=  ps.executeQuery();
				
				if (rs.next()) {
					alarmId = GetterUtil.getString(rs.getString("ID"));
				   serverName = GetterUtil.getString(rs.getString("SV"));
					partNumber =  GetterUtil.getString(rs.getString("PN"));
					process = GetterUtil.getString(rs.getString("PR"));
					station = GetterUtil.getString(rs.getString("SN"));
					eventTimeUTC  = rs.getTimestamp("EV");
					eventTimeLocal  = GetterUtil.getString(rs.getString("EVL")); // var char	
					alarmLevel  = GetterUtil.getString(rs.getString("L"));
					if(alarmLevel.equalsIgnoreCase(CRITICAL)){
						alarmLevel = CRITICAL;
					}else if(alarmLevel.equalsIgnoreCase(WARNINIG)){
						alarmLevel = WARNINIG;
					} else{
						alarmLevel =INFO;
					}
					deviation   =GetterUtil.getDouble(rs.getDouble("D"));
					alertType =  GetterUtil.getString(rs.getString("T"));
					count = GetterUtil.getLong(rs.getInt("C"));
					isAlarmActive = GetterUtil.getBoolean(rs.getBoolean("A"));
					alarmStartTime = new DateTime(rs.getTimestamp("ST")) ;
				}else{
					_log.debug("fis alam could not be found");
					return fisAlarm;
				}
				rs.close();
				ps.close();				
				if(!alertType.equalsIgnoreCase(YIELD_ALERT)){
					ps = connection.prepareStatement("Select T as defaultTime, M as customTime, RN as region, LOC as location, PT as productType, PF as productFamily from FIS_PART_THRESHOLDS where PN = ? and PR = ? and SN = ? and SV = ?");
					ps.setString(1,partNumber);
					ps.setString(2, process);
					ps.setString(3, station);
					ps.setString(4, serverName);
					
					rs = ps.executeQuery();
					
					if (rs.next()) {
						productType = rs.getString("productType");
						productFamily = rs.getString("productFamily");
						BigDecimal defaultTime = rs.getBigDecimal("defaultTime");
						BigDecimal customTime = rs.getBigDecimal("customTime");
						
						_log.debug("customTime :"+customTime);
						region = rs.getString("region");
						location = rs.getString("location");
						thresholdDuration = customTime;
						if(customTime ==null || (customTime.compareTo(BigDecimal.ZERO) == 0)){
							thresholdDuration = defaultTime;
						}
					}
				}
				else{
					// In case of Yield Alert populate fields differently
					productType = "-";
					productFamily = "-";
					region = "-" ; 
					location = "-";
					thresholdDuration = new BigDecimal(getThresholdForYieldAlarm(kafkaMessage.getAlarmId())); 
				}
				fisAlarm = new FisAlarm(alarmId, serverName, partNumber, process, station, (eventTimeUTC == null ? StringPool.BLANK:eventTimeUTC.toString()), eventTimeLocal, alarmLevel, deviation, alertType, count, isAlarmActive, alarmStartTime, thresholdDuration, region, location, productType, productFamily);
				_log.debug(fisAlarm);				
				
		} catch (SQLException e) {
			_log.error(e.getMessage());
			_log.debug(e.getStackTrace());
			throw new Exception(e);
		} finally {
			DelphiHbaseServerConnection.close(connection, ps, rs);
		}		
		return fisAlarm;
	}
	
	private double getThresholdForYieldAlarm(String subscriptionId) throws Exception {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		double threshold = 0.0 ; 
		
		StringBuilder query = new StringBuilder("select THRESHOLD FROM YIELD_ALARM_THRESHOLD  where SUBSCRIPTION_ID = ? order by CREATED_TIME desc  fetch first 1 row only");
		
		_log.debug("subscription query : "+query);
		try {
			con = DataAccess.getConnection();
			ps = con.prepareStatement(query.toString());
			ps.setLong(1, Long.parseLong(subscriptionId));
			rs = ps.executeQuery();
			
			while(rs.next()){	
				threshold = rs.getDouble("THRESHOLD");
			}				
		} catch (Exception e) {
			_log.error(e.getMessage());
			_log.debug(e.getStackTrace());
			throw new Exception(e);
		} finally {
			DataAccess.cleanUp(con,ps,rs);
		}
		return threshold;
	}
	
	@Override
	public ChangeOverHistory getChangeOverHistory(String server,
			String station, String process, String eventTimeUTC) throws Exception{
		_log.info("getChangeOverHistory : server = "+server+" , station : "+station+" , process : "+process+" , eventTimeUTC: "+eventTimeUTC);		
		String previousPartNumber = StringPool.BLANK;		
		String previousProductFamily  = StringPool.BLANK;
		String previousProductType  = StringPool.BLANK;
		BigDecimal cycleTime= BigDecimal.ZERO;
		
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			connection = DelphiHbaseServerConnection.getConnection();
			String query = "Select \"fis_partnumber_0\" as previousPartNumber , \"CycleTime\" as cycleTime from FIS_CYCLE_TIME where \"fis_station\" = ? and SERVERNAME = ? and  \"fis_process\" = ?   and \"fis_event_utc\" = to_Date('"+eventTimeUTC+"') LIMIT 1";
			_log.info("getChangeOverHistory query :"+query);
			ps = connection.prepareStatement(query);			ps.setString(1, station);
			ps.setString(2, server);
			ps.setString(3, process);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {					
				previousPartNumber = rs.getString("previousPartNumber");
				cycleTime = rs.getBigDecimal("cycleTime");
				_log.info("previousPartNumber : "+previousPartNumber);
			}else{
				_log.error("Could not find previous part");
				throw new Exception("Could not find previous part");
			}
				
			rs.close();
			ps.close();
			
			ps = connection.prepareStatement("Select PF as productFamily, PT as productType from FIS_PART_THRESHOLDS where PN = ? and PR = ? and SN = ? and SV = ?");
			ps.setString(1, previousPartNumber);
			ps.setString(2, process);
			ps.setString(3, station);
			ps.setString(4, server);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				previousProductFamily = rs.getString("productFamily");
				previousProductType = rs.getString("productType");
			}
	
		} catch(Exception e){
			_log.error(e.getMessage());
			throw new Exception(e);
		} finally {
			DelphiHbaseServerConnection.close(connection, ps, rs);
		}
							
		ChangeOverHistory changeOverHistory = new ChangeOverHistory(previousPartNumber, previousProductType, previousProductFamily,cycleTime);
		_log.info(changeOverHistory);
		return changeOverHistory;
	}

	@Override
	public void saveFisNotification(FisAlarm alarm,SubscriptionList subscriptionList) throws Exception {
		
		StringBuilder insertQuery = new StringBuilder("Upsert into fis_notifications(UID,SID,SNM,AID,RN,LOC,SV,SN,PR,PN,EV,EVL,L,D,TH,T,A,ST");
		if(alarm.isAlarmActive()){
			insertQuery.append(",NT");
		}
		insertQuery.append(")  values (?,?,?,");
		insertQuery.append("'").append(alarm.getAlarmId()).append("',");
		insertQuery.append("'").append(alarm.getRegion()).append("',");
		insertQuery.append("'").append(alarm.getLocation()).append("',");
		insertQuery.append("'").append(alarm.getServerName()).append("',");
		insertQuery.append("'").append(alarm.getStation()).append("',");
		
		insertQuery.append("'").append(alarm.getProcess()).append("',");
		insertQuery.append("'").append(alarm.getPartNumber()).append("',");
		//insertQuery.append(" ?, ");
		insertQuery.append("TO_DATE('").append(alarm.getEventTimeUTC().toString()).append("'),");
		
		insertQuery.append("'").append(alarm.getEventTimeLocal()).append("',");
		insertQuery.append("'").append(alarm.getAlarmLevel()).append("',");
		insertQuery.append(" ?, ");
		//insertQuery.append(alarm.getDeviation()).append(",");
		insertQuery.append(" ?, ");
		//insertQuery.append(alarm.getThresholdDuration()).append(",");
		insertQuery.append("'").append(alarm.getAlertType()).append("',");
		insertQuery.append(" ?, ");
		//insertQuery.append(alarm.isAlarmActive()).append(",");
		insertQuery.append(" ? ");
		//insertQuery.append("TO_DATE('").append(alarm.getAlarmStartTime().toString()).append("')");
		
		if(alarm.isAlarmActive()){
			insertQuery.append(", CURRENT_TIME()");
		}
		
		insertQuery.append(")");
		
		_log.debug("fis_notifcation query : "+insertQuery);
		Connection connection = null;
		PreparedStatement ps = null;
		
		try{
			connection = DelphiHbaseServerConnection.getConnection();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(insertQuery.toString());
			
			for (int i = 0; i<subscriptionList.size();i++){
				ps.setString(1, subscriptionList.getUserList().get(i).toString());
				ps.setInt(2, subscriptionList.getSubscriptionIdList().get(i));
				ps.setString(3, subscriptionList.getSubscriptionNameList().get(i));
				// ps.setTimestamp(4, new java.sql.Timestamp(alarm.getEventTimeUTC().getMillis()));
				ps.setBigDecimal(4, BigDecimal.valueOf(alarm.getDeviation()));
				ps.setBigDecimal(5, alarm.getThresholdDuration());
				ps.setBoolean(6, alarm.isAlarmActive());
				ps.setTimestamp(7, new java.sql.Timestamp(alarm.getAlarmStartTime().getMillis()));
				ps.addBatch();
			}
			
			int[] count = ps.executeBatch();
			connection.commit();
			_log.debug("fis_notification table, records inserted : "+count.length);
			
		} catch(Exception e){
			_log.error(e.getMessage());
			throw new Exception(e);
		} finally {
			DelphiHbaseServerConnection.close(connection, ps, null);
		}		
	}

	@Override
	public SubscriptionList getSubscriberUserList(FisAlarm alarm) throws Exception {
		
		if(alarm.getAlertType().equalsIgnoreCase(YIELD_ALERT)){
			return getSubscriberUserListForYield(alarm);
		}
		
		SubscriptionList subscriptionList = new SubscriptionList();
		String downTime = "Down Time";
		String cycleTime="Cycle Time";
		String changeOver = "Change Over";
		
		String alertType = StringPool.BLANK;
		String serverName = "All";
		
		if(alarm.getAlertType().equalsIgnoreCase(CYCLETIME_ALERT)){
			alertType = cycleTime;
		}else if(alarm.getAlertType().equalsIgnoreCase(CHANGEOVER_ALERT)){
			alertType = changeOver;
		}else{
			alertType = downTime;
		}
		
		if(alarm.getServerName().indexOf('.') > -1){
			serverName=alarm.getServerName().substring(0,alarm.getServerName().indexOf('.'));
		}
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int userId =0;
		String subscriptionName = StringPool.BLANK;
		String subscriptionDesc = StringPool.BLANK;
		int emailSMSNotification = 0;
		int subscriptionId = 0;
		boolean isNotificationOn = false;
		
		StringBuilder query = new StringBuilder("Select USER_ID as userId, SUB_NAME as subscriptionName , SUB_TYPE as subscriptionDesc, sub.SUBSCRIPTION_ID as subscriptionId , NOTIFICATION_ON_OFF as isNotificationOn,  ");
		if(alarm.getAlarmLevel().equalsIgnoreCase(CRITICAL)){
			query.append("SUB_LEVEL_CRIT_NOTIFY as emailSMSNotification ");
		}else if(alarm.getAlarmLevel().equalsIgnoreCase(WARNINIG)){
			query.append("SUB_LEVEL_WARN_NOTIFY as emailSMSNotification ");
		}else {
			query.append("SUB_LEVEL_INFO_NOTIFY as emailSMSNotification ");
		}
		
		query.append(" from fis_subscription_expanded sub, fis_subscriptions_catalog cat ");
		query.append(" where sub.SUBSCRIPTION_ID = cat.SUBSCRIPTION_ID and ( sub.SERVER = ? OR sub.SERVER = ? ) and sub.STATION = ? and sub.PART_NUMBER = ? and sub.PROCESS = ? ");
		query.append(" and cat.SUB_TYPE = ?");
		
		_log.debug("subscription query : "+query);
		_log.debug(alarm);
		try {
			con = DataAccess.getConnection();
			ps = con.prepareStatement(query.toString());
			ps.setString(1, serverName);
			ps.setString(2, alarm.getServerName());
			ps.setString(3, alarm.getStation());
			ps.setString(4, alarm.getPartNumber());
			ps.setString(5, alarm.getProcess());
			ps.setString(6, alertType);
			
			rs = ps.executeQuery();
			
			while(rs.next()){				
				userId = rs.getInt("userId");
				subscriptionName = rs.getString("subscriptionName");
				subscriptionDesc = rs.getString("subscriptionDesc");
				emailSMSNotification = rs.getInt("emailSMSNotification");
				subscriptionId = rs.getInt("subscriptionId");
				isNotificationOn = rs.getBoolean("isNotificationOn");
				if(!isNotificationOn){
					emailSMSNotification = 0;
				}
				subscriptionList.add(userId, subscriptionName, subscriptionDesc, emailSMSNotification,subscriptionId);
			}			
			
		} catch (Exception e) {
			_log.error(e.getMessage());
			_log.debug(e.getStackTrace());
			throw new Exception(e);
		} finally {
			DataAccess.cleanUp(con,ps,rs);
		}
		_log.debug("subscriptionList size : "+subscriptionList.size());
		return subscriptionList;
	}

	private SubscriptionList getSubscriberUserListForYield(FisAlarm alarm) throws Exception {
		SubscriptionList subscriptionList = new SubscriptionList();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int userId =0;
		String subscriptionName = StringPool.BLANK;
		String subscriptionDesc = StringPool.BLANK;
		int emailSMSNotification = 0;
		int subscriptionId = 0;
		boolean isNotificationOn = false;
		
		StringBuilder query = new StringBuilder("Select USER_ID as userId, SUB_NAME as subscriptionName , SUB_TYPE as subscriptionDesc, SUBSCRIPTION_ID as subscriptionId , NOTIFICATION_ON_OFF as isNotificationOn,  ");
		if(alarm.getAlarmLevel().equalsIgnoreCase(CRITICAL)){
			query.append("SUB_LEVEL_CRIT_NOTIFY as emailSMSNotification ");
		}else if(alarm.getAlarmLevel().equalsIgnoreCase(WARNINIG)){
			query.append("SUB_LEVEL_WARN_NOTIFY as emailSMSNotification ");
		}else {
			query.append("SUB_LEVEL_INFO_NOTIFY as emailSMSNotification ");
		}
		
		query.append(" from fis_subscriptions_catalog ");
		query.append(" where SUBSCRIPTION_ID = ? " ) ; 
		
		_log.debug("subscription query : "+query);
		_log.debug(alarm);
		try {
			con = DataAccess.getConnection();
			ps = con.prepareStatement(query.toString());
			ps.setLong(1, Long.parseLong(alarm.getAlarmId()));
			rs = ps.executeQuery();
			
			while(rs.next()){				
				userId = rs.getInt("userId");
				subscriptionName = rs.getString("subscriptionName");
				subscriptionDesc = rs.getString("subscriptionDesc");
				emailSMSNotification = rs.getInt("emailSMSNotification");
				subscriptionId = rs.getInt("subscriptionId");
				isNotificationOn = rs.getBoolean("isNotificationOn");
				if(!isNotificationOn){
					emailSMSNotification = 0;
				}
				subscriptionList.add(userId, subscriptionName, subscriptionDesc, emailSMSNotification,subscriptionId);
			}			
			
		} catch (Exception e) {
			_log.error(e.getMessage());
			_log.debug(e.getStackTrace());
			throw new Exception(e);
		} finally {
			DataAccess.cleanUp(con,ps,rs);
		}
		_log.debug("subscriptionList size : "+subscriptionList.size());
		return subscriptionList;
	}

	
	@Override
	public List<NotificationHistory> getNotificationHistory(String server,
			String station, String process, String partNumber) throws Exception {
		List<NotificationHistory> notificationHistories = new ArrayList<NotificationHistory>(5);
		long cycleTime = 0;
		String date = StringPool.BLANK;
		String time = StringPool.BLANK;
		LocalTime interval = null;
		
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			connection = DelphiHbaseServerConnection.getConnection();
			ps = connection.prepareStatement("Select \"CycleTime\" as cycleTime, \"fis_date\" as date ,\"fis_time\" as time  from FIS_CYCLE_TIME where \"fis_station\" = ? and SERVERNAME = ? and  \"fis_process\" = ?  and \"fis_partnumber\" = ? and  \"CycleTimeType\" = ?  ORDER BY \"fis_event_utc\" DESC LIMIT 5");
				ps.setString(1, station);
				ps.setString(2, server);
				ps.setString(3, process);
				ps.setString(4, partNumber);
				ps.setString(5, "CYCLETIME");
				
				rs = ps.executeQuery();
				NotificationHistory notificationHistory = null;
				while (rs.next()) {
					cycleTime = rs.getLong("cycleTime");
					_log.debug("cycleTime :"+cycleTime);
					date = rs.getString("date");
					time = rs.getString("time");
					interval = LocalTime.fromMillisOfDay(cycleTime);
					_log.debug("interval : "+interval);
					
					notificationHistory = new NotificationHistory(date, time, interval);
					_log.debug("notificationHistory : "+notificationHistory);
					notificationHistories.add(notificationHistory);
				}
				
				
		} catch(Exception e){
			_log.error(e.getMessage());
			_log.debug(e.getStackTrace());
			throw new Exception(e);
		} finally {
			DelphiHbaseServerConnection.close(connection, ps, rs);
		}
		return notificationHistories;
	}


	@Override
	public void inActiveFisNotification(String aid, String startTime)
			throws Exception {
		_log.debug("inActiveFisNotification,aid="+aid+" , startTime : "+startTime);
		Connection connection = null;
		PreparedStatement ps = null;
		try{
			connection = DelphiHbaseServerConnection.getConnection();
			connection.setAutoCommit(false);
			String upsertQuery = "upsert into fis_notifications(UID,SID,ST,A) SELECT UID,SID,ST,false FROM fis_notifications where AID = '"+aid+"' and A = true";
			ps = connection.prepareStatement(upsertQuery.toString());
			ps.executeUpdate();			
			connection.commit();			
		} catch(Exception e){
			_log.error(e.getMessage());
			_log.debug(e.getStackTrace());
			throw new Exception(e);
		} finally {
			DelphiHbaseServerConnection.close(connection, ps, null);
		}
	}
	@Override
	public String getInactiveDownTimeDuration(String alarmId, String eventTimeUTC) throws Exception{
	_log.info("getInactiveDownTimeDuration :  alarmId : "+alarmId+" , eventTimeUTC: "+eventTimeUTC);
	
	Timestamp endTimeUTC = null;		
	Timestamp startTimeUTC = null;
	
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	try{
		connection = DelphiHbaseServerConnection.getConnection();
		String query = "Select EV, ET from FIS_ALARMS where ID= ? and EV=to_Date('"+eventTimeUTC+"') and A=false limit 1";
		_log.info("getInactiveDownTimeDuration query :"+query);
		ps = connection.prepareStatement(query);
			ps.setString(1, alarmId);
			rs = ps.executeQuery();
			
			if (rs.next()) {					
				endTimeUTC = rs.getTimestamp("ET");
				startTimeUTC = rs.getTimestamp("EV");
				_log.info("endTimeUTC : "+endTimeUTC);
			}else{
				_log.error("Could not find ET");
				//throw new Exception("Could not find ET");
			}
			} catch(Exception e){
				_log.error(e.getMessage());
				throw new Exception(e);
			} finally {
				DelphiHbaseServerConnection.close(connection, ps, rs);
			}
							
			
		return getDuration(startTimeUTC,endTimeUTC);
	}
	
	private String getDuration(java.sql.Timestamp startTimeUTC,java.sql.Timestamp endTimeUTC){	
		JSONObject json = JSONFactoryUtil.createJSONObject();
		if(startTimeUTC == null || endTimeUTC == null){			
			json.put("days", "0");
			json.put("hours", "00");
			json.put("minutes", "00");
			json.put("seconds", "00");
			json.toString();
		}
				
			
		long diff = endTimeUTC.getTime() - startTimeUTC.getTime();		
		LocalTime interval = LocalTime.fromMillisOfDay(diff);
		
		_log.debug("startTimeUTC.getTime() :  "+startTimeUTC.getTime());
		_log.debug("endTimeUTC.getTime() :  "+endTimeUTC.getTime());		
	
		_log.debug(" interval : "+interval.toString());
		
		String hours = (interval.getHourOfDay() < 9 ? "0"+ interval.getHourOfDay(): Integer.toString(interval.getHourOfDay()));
		String minutes = (interval.getMinuteOfHour() < 9 ? "0"+ interval.getMinuteOfHour(): Integer.toString(interval.getMinuteOfHour()));
		String seconds = (interval.getSecondOfMinute() < 9 ? "0"+ interval.getSecondOfMinute(): Integer.toString(interval.getSecondOfMinute()));
		
		json.put("hours", hours);
		json.put("minutes", minutes);
		json.put("seconds", seconds);		
		json.put("days", Math.floor(diff/(1000*60*60*24)));
		
		
		return json.toString();
	}


	@Override
	public JSONObject getActiveNotificationCount(
			NotificationQuery notificationQuery) throws Exception {
		_log.debug(notificationQuery);
		
		int criticalCount = 0;
		int warnCount = 0;
		int infoCount = 0;
		
		String subscriptionIds = getSubScriptionId(notificationQuery.getUserId());
		if(!subscriptionIds.isEmpty()){
		
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		try{
			connection = DelphiHbaseServerConnection.getConnection();
			StringBuilder sb = new StringBuilder("Select  fis_notifications.L as level, count(L) as count from  fis_notifications   where fis_notifications.A = true and  fis_notifications.UID = ?");
			sb.append("  and fis_notifications.SID in  ("+subscriptionIds+")  ");
			if(notificationQuery.getRegionSiteServer() != null ){
				if(notificationQuery.getRegionSiteServer().getRegionName() != null && !notificationQuery.getRegionSiteServer().getRegionName().trim().isEmpty()){
					sb.append( " and  fis_notifications.RN ='").append(notificationQuery.getRegionSiteServer().getRegionName()).append("'");
				}
				if(notificationQuery.getRegionSiteServer().getSiteName() != null && !notificationQuery.getRegionSiteServer().getSiteName().trim().isEmpty() ){
					sb.append( " and fis_notifications.LOC ='").append(notificationQuery.getRegionSiteServer().getSiteName()).append("'");
				}
				if(notificationQuery.getRegionSiteServer().getServerName() != null && !notificationQuery.getRegionSiteServer().getServerName().trim().isEmpty() ){
					sb.append( " and fis_notifications.SV ='").append(notificationQuery.getRegionSiteServer().getServerName()).append("'");
				}
			}

			if(notificationQuery.getStartDate() != null &&  notificationQuery.getEndDate() != null){
				sb.append("  and fis_notifications.ST between ? and ? ");
			}
			sb.append("  group by L ");
			_log.debug(sb.toString());
			ps = connection.prepareStatement(sb.toString());
			ps.setString(1, Long.toString(notificationQuery.getUserId()));			
			if(notificationQuery.getStartDate() != null &&  notificationQuery.getEndDate() != null){
				ps.setDate(2, new java.sql.Date(notificationQuery.getStartDate().getMillis()));
				ps.setDate(3, new java.sql.Date(notificationQuery.getEndDate().getMillis()));
			}
			
			rs = ps.executeQuery();
			String level = null;
			while(rs.next()){					
				level =  GetterUtil.getString(rs.getString("level"));
				int count = GetterUtil.getInteger(rs.getInt("count"));
				if(level.equalsIgnoreCase(CRITICAL)){
					criticalCount = count;
				}else if(level.equalsIgnoreCase(WARNINIG)){
					warnCount = count;
				}else{
					infoCount = count;
				}
			}			
		} catch (Exception e1) {
			_log.error(e1);
			_log.debug(e1.getStackTrace());
			throw new Exception(e1);
		} finally {
				DelphiHbaseServerConnection.close(connection, ps, rs);
		}
		}
		JSONObject jsonNotificationCount = JSONFactoryUtil.createJSONObject();
		jsonNotificationCount.put("crit",Integer.toString(criticalCount)); 
		jsonNotificationCount.put("warn",Integer.toString(warnCount));
		jsonNotificationCount.put("info",Integer.toString(infoCount));
		
		_log.debug(jsonNotificationCount.toString());

		return jsonNotificationCount;
	}
	
	@Override
	public NotificationList getActiveNotificationsForLast3Days(NotificationQuery notificationQuery) throws Exception{
		_log.debug(notificationQuery);
		NotificationList notificationList = new NotificationList();
		List<Notification> notifications = new ArrayList<Notification>();
		notificationList.setNotifications(notifications);
		
		String alarmId = StringPool.BLANK;
		String name = StringPool.BLANK;
		String server = StringPool.BLANK;
		String region = StringPool.BLANK;
		String location = StringPool.BLANK;
		String partNumber = StringPool.BLANK;
		String process = StringPool.BLANK;
		String station = StringPool.BLANK ;
		String level = StringPool.BLANK;
		String duration = StringPool.BLANK;
		String status = StringPool.BLANK ;
		String alertType = StringPool.BLANK;
		double deviation = 0;
		String localStartDate = StringPool.BLANK;
		java.sql.Timestamp startTimeUTC = null;
		java.sql.Timestamp eventDate = null;
		BigDecimal threshold= null;
		int subId = 0;
		
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		String subscriptionIds = getSubScriptionId(notificationQuery.getUserId());
		if(!subscriptionIds.isEmpty()){
			try{
				connection = DelphiHbaseServerConnection.getConnection();
				StringBuilder sb = new StringBuilder("Select fis_notifications.AID as alarmId ,fis_notifications.SID as subId, fis_notifications.RN as region , fis_notifications.LOC as location ,fis_notifications.SNM as name, fis_notifications.SV as server, fis_notifications.PN as partNumber, fis_notifications.PR as process, fis_notifications.SN as station, fis_notifications.TH as threshold, fis_notifications.L as level, fis_notifications.A as status, fis_notifications.D as deviation, fis_notifications.T as alertType, fis_notifications.EVL as localStartDate ,fis_notifications.EV as eventDate ,fis_notifications.ST as startTimeUTC   from  fis_notifications   where  fis_notifications.A = true and  fis_notifications.UID = ?");
				sb.append("  and fis_notifications.SID in  ("+subscriptionIds+")  ");

				if(notificationQuery.getRegionSiteServer() != null ){
					if(notificationQuery.getRegionSiteServer().getRegionName() != null && !notificationQuery.getRegionSiteServer().getRegionName().trim().isEmpty()){
						sb.append( " and  fis_notifications.RN ='").append(notificationQuery.getRegionSiteServer().getRegionName()).append("'");
					}
					if(notificationQuery.getRegionSiteServer().getSiteName() != null && !notificationQuery.getRegionSiteServer().getSiteName().trim().isEmpty() ){
						sb.append( " and fis_notifications.LOC ='").append(notificationQuery.getRegionSiteServer().getSiteName()).append("'");
					}
					if(notificationQuery.getRegionSiteServer().getServerName() != null && !notificationQuery.getRegionSiteServer().getServerName().trim().isEmpty() ){
						sb.append( " and fis_notifications.SV ='").append(notificationQuery.getRegionSiteServer().getServerName()).append("'");
					}
				}
				
				/* if(notificationQuery.getStartDate() != null &&  notificationQuery.getEndDate() != null){
					sb.append("  and fis_notifications.ST between ? and ? ");
				}*/
				
				sb.append("  and fis_notifications.ST > CURRENT_DATE() - ").append(3);
				_log.debug(sb.toString());
				ps = connection.prepareStatement(sb.toString());
				ps.setString(1, Long.toString(notificationQuery.getUserId()));
				/* if(notificationQuery.getStartDate() != null &&  notificationQuery.getEndDate() != null){
					ps.setDate(2, new java.sql.Date(notificationQuery.getStartDate().getMillis()));
					ps.setDate(3, new java.sql.Date(notificationQuery.getEndDate().getMillis()));
				}*/
				
				rs = ps.executeQuery();
				
				while(rs.next()){	
					alarmId =  GetterUtil.getString(rs.getString("alarmId"));
					name =  GetterUtil.getString(rs.getString("name"));
					server =  GetterUtil.getString(rs.getString("server"));
					partNumber =  GetterUtil.getString(rs.getString("partNumber"));
					region =  GetterUtil.getString(rs.getString("region"));
					location =  GetterUtil.getString(rs.getString("location"));
					process =  GetterUtil.getString(rs.getString("process"));
					station =  GetterUtil.getString(rs.getString ("station"));
					level =  GetterUtil.getString(rs.getString("level"));
					status = GetterUtil.getBoolean(rs.getBoolean("status"))?ACTIVE:IN_ACTIVE ;
					alertType =  GetterUtil.getString(rs.getString("alertType")); 
					deviation = GetterUtil.getDouble(rs.getDouble("deviation"));
					localStartDate =  GetterUtil.getString(rs.getString("localStartDate"));	
					eventDate =   rs.getTimestamp("eventDate");
					threshold = rs.getBigDecimal("threshold");
					startTimeUTC = rs.getTimestamp("startTimeUTC");				
					subId = rs.getInt("subId");
	
					if(alertType.equalsIgnoreCase(DOWNTIME_ALERT)){
						startTimeUTC = eventDate;
					}
					if(status.equalsIgnoreCase(ACTIVE)){
						duration = getDuration(startTimeUTC);
					}else{
						duration= StringPool.BLANK;
					}
					
					_log.debug("name=" + name + ", partNumber=" + partNumber
					+ ", process=" + process + ", station=" + station + ", level="
					+ level + ", duration=" + duration + ", status=" + status
					+ ", alertType=" + alertType + ", deviation=" + deviation
					+ ", server=" + server + ", threshold="
					+ threshold +", localStartDate = "+localStartDate+", startTimeUTC = "+startTimeUTC+" , duration = "+duration+", alarmId = "+alarmId);
					String 	thresholdInString = covertToMMSS(threshold);
					
	
					notifications.add(new Notification(name,  partNumber,  process,
								station,  level,  duration,  status,
								alertType,  deviation,  localStartDate,  server,thresholdInString,subId,region,location,eventDate.toString(),alarmId));
				}
				
			} catch (Exception e1) {
				_log.error(e1);
				_log.debug(e1.getStackTrace());
				throw new Exception(e1);
			} finally {
					DelphiHbaseServerConnection.close(connection, ps, rs);
			}
		}
		
		//_log.debug("size of notificationList : "+notificationList.getNotifications().size());
//		populateSubscriptionData(notifications);
		return notificationList;
	}

	@Override
	public List<NotificationHistoryWithThreshold> getNotificationHistoryWithThreshold(String server, String station,
			String process, String partNumber,  int duration) throws Exception {
		List<NotificationHistoryWithThreshold> notificationHistories = new ArrayList<NotificationHistoryWithThreshold>(5);
		
		fetchNotificationHistory(server, station, process, partNumber,  notificationHistories, duration);
		
		Map<String, Integer> thresholdMap = new HashMap<String, Integer>();
		Map<String, Integer> manualThresholdMap = new HashMap<String, Integer>();

		// calculate and set threshold for each data point
		if(notificationHistories.size() >0 ){
			// now fetch the threshold information from the database
			fetchThresholdData(server, station, process, partNumber, duration, thresholdMap, manualThresholdMap);
			
			long threshold[] = fetchCurrentThresholdData(server, station, process, partNumber);
			_log.debug("current threshold calculated- "  +  threshold[0] + "current threshold manual - "  +  threshold[1]);

			// now update the threshold for each entry in Notification History Map
			updateNotificationHistoryWithThreshold(notificationHistories, thresholdMap, manualThresholdMap, threshold);
		}
		
		// calculate and set alarm data points
		if(notificationHistories.size() >0 ){
			Map<Long, String> alarmMap = new HashMap<Long, String>();
			fetchAlarmHistory(server, station, process, partNumber,  alarmMap, duration);
			updateNotificationHistoryWithAlarmData(notificationHistories, alarmMap);
		}

		return notificationHistories ;
	}
	
	private void fetchNotificationHistory(String server, String station,
			String process, String partNumber,List<NotificationHistoryWithThreshold> notificationHistories ,  int durationHours)throws Exception {
		long cycleTime = 0;
		String date = StringPool.BLANK;
		String time = StringPool.BLANK;
		LocalTime interval = null;
		
		double durationH = durationHours ;
		double duration = durationH/24 ; 
		DecimalFormat newFormat = new DecimalFormat("#.##");
		duration =  Double.valueOf(newFormat.format(duration));
		
		_log.debug("duration ---> " + duration);
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			connection = DelphiHbaseServerConnection.getConnection();
			ps = connection.prepareStatement("Select \"CycleTime\" as cycleTime, \"fis_date\" as date ,\"fis_time\" as time , \"fis_event_utc\" as event from FIS_CYCLE_TIME where \"fis_station\" = ? and SERVERNAME = ? and  \"fis_process\" = ?  and \"fis_partnumber\" = ? and  \"CycleTimeType\" = ?  and \"fis_event_utc\" > CURRENT_DATE() - ? ORDER BY \"fis_event_utc\" DESC");
			ps.setString(1, station);
			ps.setString(2, server);
			ps.setString(3, process);
			ps.setString(4, partNumber);
			ps.setString(5, "CYCLETIME");
			ps.setDouble(6, duration);

			rs = ps.executeQuery();
			NotificationHistoryWithThreshold notificationHistory = null;
			while (rs.next()) {
				cycleTime = rs.getLong("cycleTime");
//				_log.info("cycleTime :"+cycleTime);
				date = rs.getString("date");
				time = rs.getString("time");
				long eventUTC = rs.getTimestamp("event").getTime(); 
				notificationHistory = new NotificationHistoryWithThreshold(date, time, cycleTime,0);
				notificationHistory.setEventTS(eventUTC);
//				_log.info("notificationHistory : "+notificationHistory);
				notificationHistories.add(notificationHistory);
			}		
		} catch(Exception e){
			_log.error(e.getMessage());
			_log.debug(e.getStackTrace());;
			throw new Exception(e);
		} finally {
			DelphiHbaseServerConnection.close(connection, ps, rs);
		}
	}
	
	
	private void fetchAlarmHistory(String server, String station,
			String process, String partNumber,Map<Long, String> alarmMap ,  int durationHours)throws Exception {

		double durationH = durationHours ;
		double duration = durationH/24 ; 
		DecimalFormat newFormat = new DecimalFormat("#.##");
		duration =  Double.valueOf(newFormat.format(duration));
		
		_log.debug("duration ---> " + duration);
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			connection = DelphiHbaseServerConnection.getConnection();
			ps = connection.prepareStatement("select EV,L,A from FIS_ALARMS  where SN = ? and SV = ? and PR = ? and PN = ? and T = 'CYCLETIME ALERT' and EV > CURRENT_DATE() - ? order by EV desc");
			ps.setString(1, station);
			ps.setString(2, server);
			ps.setString(3, process);
			ps.setString(4, partNumber);
			ps.setDouble(5, duration);
			rs = ps.executeQuery();
			while (rs.next()) {
				long eventUTC = rs.getTimestamp("EV").getTime();
				String level = rs.getString("L");
				alarmMap.put(eventUTC, level);
			}		
		} catch(Exception e){
			_log.error(e.getMessage());
			_log.debug(e.getStackTrace());;
		} finally {
			DelphiHbaseServerConnection.close(connection, ps, rs);
		}
	}

	private long[] fetchCurrentThresholdData(String server, String station,
			String process, String partNumber)throws Exception {
		
		long threshold[] = new long[2] ; 
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			connection = DelphiHbaseServerConnection.getConnection();
			
			ps = connection.prepareStatement("Select  T as T ,M as M  from FIS_PART_THRESHOLDS where \"SN\" = ? and SV = ? and  \"PR\" = ?  and \"PN\" = ? ");
			ps.setString(1, station);
			ps.setString(2, server);
			ps.setString(3, process);
			ps.setString(4, partNumber);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				int calculatedT = GetterUtil.getInteger(rs.getBigDecimal("T"));
				int manual = GetterUtil.getInteger(rs.getBigDecimal("M"));
				threshold[0] = calculatedT ; 
				threshold[1] = manual ; 
			}		
		} catch(Exception e){
			_log.error(e.getMessage());
			_log.debug(e.getStackTrace());;
			throw new Exception(e);
		} finally {
			DelphiHbaseServerConnection.close(connection, ps, rs);
		}
		return threshold ; 
	}
	
	private void fetchThresholdData(String server, String station,
			String process, String partNumber, long durationHours, Map<String, Integer> thresholdMap, Map<String, Integer> manualThresholdMap)throws Exception {
				
		double durationH = durationHours ;
		double duration = durationH/24 ; 
		DecimalFormat newFormat = new DecimalFormat("#.##");
		duration =  Double.valueOf(newFormat.format(duration));
		
		_log.debug("duration ---> " + duration);
		
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			connection = DelphiHbaseServerConnection.getConnection();
			_log.debug("SN - "+ station );
			_log.debug("SV - "+ server );
			_log.debug("PR - "+ process );
			_log.debug("PN - "+ partNumber );
			ps = connection.prepareStatement("Select to_char(CD-1, 'yyyy-MM-dd') as date, T as T ,M as M  from FIS_PART_THRESHOLD_HISTORY where \"SN\" = ? and SV = ? and  \"PR\" = ?  and \"PN\" = ? and  \"CD\" > CURRENT_DATE() - ? ORDER BY \"CD\" ASC");
			ps.setString(1, station);
			ps.setString(2, server);
			ps.setString(3, process);
			ps.setString(4, partNumber);
			ps.setDouble(5, duration);

			rs = ps.executeQuery();
			while (rs.next()) {
				String date = rs.getString("date");

				int threshhold = GetterUtil.getInteger(rs.getBigDecimal("T"));
				int manual = GetterUtil.getInteger(rs.getBigDecimal("M"));
				
				thresholdMap.put(date, threshhold);	
				manualThresholdMap.put(date, manual);	
			}		
		} catch(Exception e){
			_log.error(e.getMessage());
			_log.debug(e.getStackTrace());;
			throw new Exception(e);
		} finally {
			DelphiHbaseServerConnection.close(connection, ps, rs);
		}
	}
	
	private void updateNotificationHistoryWithThreshold(List<NotificationHistoryWithThreshold> historyLst, Map<String, Integer> thresholdMap,Map<String, Integer> manualThresholdMap, long currentThreshold[]){

		for(NotificationHistoryWithThreshold history: historyLst){
			// set automatic
			if(thresholdMap.containsKey(history.getDate())){
				_log.debug("threashold date match found");
				history.setThreshold(thresholdMap.get(history.getDate()));
			}
			else{
				_log.debug("setting default threshold");
				history.setThreshold(currentThreshold[0]);
			}
			
			// set manual
			if(manualThresholdMap.containsKey(history.getDate())){
				_log.debug("threashold date match found");
				history.setManualThreshold(manualThresholdMap.get(history.getDate()));
			}
			else{
				_log.debug("setting default threshold");
				history.setManualThreshold(currentThreshold[1]);
			}
		}
	}
	
	private void  updateNotificationHistoryWithAlarmData(List<NotificationHistoryWithThreshold> notificationHistories, Map<Long, String> alarmMap){
		for(NotificationHistoryWithThreshold history: notificationHistories){
			if(alarmMap.containsKey(history.getEventTS())){
				history.setAlertLevel(alarmMap.get(history.getEventTS()));
			}
			else{
				history.setAlertLevel("");
			}
		}
	}

	@Override
	public void inactivateNotificationsAfter30Days() throws Exception {
		_log.debug("inactivateNotificationsAfter30Days");
		Connection connection = null;
		PreparedStatement ps = null;
		try{
			connection = DelphiHbaseServerConnection.getConnection();
			connection.setAutoCommit(false);
			String upsertQuery = "upsert into fis_notifications(UID,SID,ST,A) SELECT UID,SID,ST,false FROM fis_notifications where  A = true  and ST < CURRENT_DATE() - 30 ";
			ps = connection.prepareStatement(upsertQuery.toString());
			ps.executeUpdate();			
			connection.commit();			
		} catch(Exception e){
			_log.error(e.getMessage());
			_log.debug(e.getStackTrace());
			throw new Exception(e);
		} finally {
			DelphiHbaseServerConnection.close(connection, ps, null);
		}
	}
	
	public String[] getProductTypeProductFamiliy(String server,String station,String process, String partNumber) throws Exception{
		String[] returnStringArr = new String[2];
		returnStringArr[0] = "";
		returnStringArr[1] = "";

		Connection connection = null;
		PreparedStatement delphiStmt = null;
		ResultSet delphiRS = null;
		
		try{
			connection = DelphiHbaseServerConnection.getConnection();
			delphiStmt  = connection.prepareStatement("Select PT as PT, PF as PF from FIS_PART_THRESHOLDS where \"SN\" = ? and SV = ? and  \"PR\" = ?  and \"PN\" = ? ");
			delphiStmt.setString(1, station);
			delphiStmt.setString(2, server);
			delphiStmt.setString(3, process);
			delphiStmt.setString(4, partNumber);
			delphiRS = delphiStmt.executeQuery();
			while (delphiRS.next()) {
				returnStringArr[0] = delphiRS.getString("PT") ; 
				returnStringArr[1] = delphiRS.getString("PF") ; 
			}
			
		} catch(Exception e){
			_log.error("error while retrieving data from table");
			_log.error(e);
		} finally {
			DelphiHbaseServerConnection.close(connection, delphiStmt, delphiRS);
		}
		return returnStringArr ; 
	}
}