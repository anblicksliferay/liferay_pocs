package com.ys.delphi.subscriptions.portlet;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.Phone;
import javax.portlet.Portlet;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.PhoneLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.ys.delphi.subscriptions.model.ProductProcess;
import com.ys.delphi.subscriptions.model.ProductProcessQuery;
import com.ys.delphi.subscriptions.model.RegionSiteServerList;
import com.ys.delphi.subscriptions.model.SubscribedDataProcess;
import com.ys.delphi.subscriptions.model.Subscription;
import com.ys.delphi.subscriptions.model.SubscriptionUpdate;
import com.ys.delphi.subscriptions.service.MySubscriptionService;
import com.ys.delphi.subscriptions.service.impl.MySubscriptionsImpl;
import com.ys.delphi.yieldalarm.YieldAlarmThresholdCalculator;
import com.ys.delphi.yieldalarm.model.YieldAlarmSubscriptionModel;
import com.ys.delphi.yieldalarm.model.YieldAlarmThresholdModel;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true, 
		property = {
			"com.liferay.portlet.display-category=Delphi",
			"com.liferay.portlet.header-portlet-css=/css/main.css", 
			"com.liferay.portlet.header-portlet-css=/css/bootstrap-chosen.css", 
			"com.liferay.portlet.header-portlet-javascript=/js/main.js", 
			"com.liferay.portlet.instanceable=false",
			"javax.portlet.display-name=MySubscriptions Portlet",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/html/viewSubscriptions.jsp",
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user" 
		},
		service = Portlet.class
	)
public class MySubscriptions extends MVCPortlet {
	
	private static Log _log = LogFactoryUtil.getLog(MySubscriptions.class);
	private MySubscriptionService subscriptionService = new MySubscriptionsImpl();
	long userId;
	//private AlertService alertService = new AlertServiceImpl();
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		//String userName = user.getFullName();
		userId = user.getUserId();
		_log.debug(userId);
		//_log.debug(userName);
		List<Subscription> subscriptions = new ArrayList<Subscription>();
		RegionSiteServerList regionSiteServerList = null;
		try {
			subscriptions = subscriptionService.getSubscriptions(userId);
			regionSiteServerList = subscriptionService.getRegionSiteServerList();
			_log.debug("in MySubscription portlet doViewww, regionSiteServerList is >> "+regionSiteServerList);
			renderRequest.setAttribute("regionSiteServerList", regionSiteServerList.toJSON());

			//regionSiteServerList = subscriptionService.getRegionSiteServerList();
			//renderRequest.setAttribute("userName", userName);
			renderRequest.setAttribute("subscriptions", toFormattedString(subscriptions));
		} catch (Exception e) {
			_log.error(e.getMessage());
			e.printStackTrace();
		}
				
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
		_log.debug("serveResource command is: "+cmd +" with cmdType(optional): "+cmdType +" with context(optional): "+context);
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		//String userName = user.getFullName();
		userId = user.getUserId();
		
		try{
			if(cmd.equalsIgnoreCase("phone")){
				
				processPhoneUpdate(resourceRequest, resourceResponse, 
									user, cmd, context );
				
			} else if(cmd.equalsIgnoreCase("list")){
				
				ProductProcessQuery pp = createProductProcessQuery (context);			
				List<ProductProcess> productProcesses = subscriptionService.getProductProcessList(pp);				
				writeJSON(resourceRequest, resourceResponse,toProductProcesss(productProcesses));			
				
			} else if(cmd.equalsIgnoreCase("update")){
				
				if(cmdType.equalsIgnoreCase("update")){
					_log.debug("Code started to save the updated value in DB");
					//this code is for saving the edit data in DB
					JSONObject json = JSONFactoryUtil.createJSONObject(context);
					long subscriptionId = json.getInt("subscriptionId");
					SubscriptionUpdate subscriptionUpdate =  createSubscriptionUpdate(context);
					subscriptionService.updateSubscription(subscriptionUpdate, subscriptionId);
					//resourceResponse.setRenderParameter("jspPage","/html/viewSubscriptions.jsp");
					json.put("msg", "Record updated successfully");
					writeJSON(resourceRequest, resourceResponse, json);
				}else{
					_log.debug("Pulling Saved Subscription with ID in Context as:" + context.toString());
					//this code is for pulling the saved subscription record and displaying in page
					List<SubscribedDataProcess> subscribedDataProcess = subscriptionService.getSubscriptionList(context);
					writeJSON(resourceRequest, resourceResponse,toSubscribedDataList(subscribedDataProcess));
				}
				
			}else if(cmd.equalsIgnoreCase("add")){
				
				SubscriptionUpdate subscriptionUpdate =  createSubscriptionUpdate(context);
				subscriptionService.addSubscription(subscriptionUpdate);
				JSONObject json = JSONFactoryUtil.createJSONObject();
				json.put("msg", "Record added successfully");
				writeJSON(resourceRequest, resourceResponse, json);
				
			} else if(cmd.equalsIgnoreCase("onOffNotification")){
				
				JSONObject json = JSONFactoryUtil.createJSONObject(context);
				boolean onOffNotification = json.getBoolean("onOffNotification");
				long subId = json.getLong("subId");
				_log.debug("onOffNotification resource request ,subId : "+subId +" , onOffNotification : "+onOffNotification);
				subscriptionService.updateOnOffNotification(subId, onOffNotification);
				json.put("msg", "onOffNotification updated successfully");
				writeJSON(resourceRequest, resourceResponse, json);
				
			} else if(cmd.equalsIgnoreCase("onAllOffNotification")){
				
				JSONObject json = JSONFactoryUtil.createJSONObject(context);
				boolean onAllOffNotification = json.getBoolean("onAllOffNotification");
				long subId = json.getLong("subId");
				_log.debug("onAllOffNotification resource request ,subId : "+subId +" , onOffNotification : "+onAllOffNotification);
				subscriptionService.updateAllOnOffNotification(userId, onAllOffNotification);
				json.put("msg", "onAllOffNotification updated successfully");
				writeJSON(resourceRequest, resourceResponse, json);
				
			} else if(cmd.equalsIgnoreCase("checkDuplicateAlert")){
				JSONObject json = JSONFactoryUtil.createJSONObject(context);
				String alertName = json.getString("alertName");
				
				_log.debug("checkDuplicateAlert resource request ,userId : "+userId +" , alertName : "+alertName);
				boolean isAlertDuplicate = subscriptionService.isAlertNameDuplicate(userId, alertName);
				json.put("msg", isAlertDuplicate);
				writeJSON(resourceRequest, resourceResponse, json);
				
			}
			else if(cmd.equalsIgnoreCase("calculateYield")){
				List<YieldAlarmSubscriptionModel> subscriptionModel = createSubscriptionModel(context);
				YieldAlarmThresholdCalculator yieldCalculator = new YieldAlarmThresholdCalculator();
				YieldAlarmThresholdModel calculateYieldAlarmThreshold = yieldCalculator.calculateYieldAlarmThreshold(subscriptionModel);
				JSONObject json = JSONFactoryUtil.createJSONObject(context);
				JSONObject yieldInfo = getCalculateYieldThresholdResponse(calculateYieldAlarmThreshold);
				json.put("yieldInfo", yieldInfo);
				writeJSON(resourceRequest, resourceResponse,json);				
			}
		}catch(Exception e){
			JSONObject json = JSONFactoryUtil.createJSONObject();
			json.put("error", "update/list was Unsuccessful");
			writeJSON(resourceRequest, resourceResponse, json);
		}
	}
	private SubscriptionUpdate createSubscriptionUpdate(String context){
		SubscriptionUpdate subscriptionUpdate = null;
		try {
			JSONObject json = JSONFactoryUtil.createJSONObject(context);
			String subscriptionName = json.getString("subscriptionName");
			String subscriptionType = json.getString("subscriptionType");
			String subscriptionDesc = json.getString("subscriptionDesc");
			if(subscriptionDesc.isEmpty()){
				subscriptionDesc = " ";
			}
			int infoNotify = json.getInt("infoNotify");

			int warningNotify = json.getInt("warningNotify");
			
			int criticalNotify = json.getInt("criticalNotify");
			
			List<String> productType  = getListObject(json.getString("productType"));
			List<String>  productFamily = getListObject(json.getString("productFamily"));
			List<String>  partNumber = getListObject(json.getString("partNumber"));
			List<String>  processNames = getListObject(json.getString("processNames"));
			List<String>  stationNames = getListObject(json.getString("stationNames"));
			List<String> regionNames = getListObject(json.getString("regionNames"));
			List<String> siteNames = getListObject(json.getString("siteNames"));
			List<String> serverNames = getListObject(json.getString("serverNames"));
	
			 subscriptionUpdate = new SubscriptionUpdate(userId, subscriptionName, subscriptionType, subscriptionDesc, infoNotify,  warningNotify,  criticalNotify,  productType, productFamily, partNumber, processNames, stationNames, regionNames, siteNames, serverNames);		 
			 //cycleTimeUpdate = new CycleTimeUpdate(partNumber, process, station, serverList, customCycleTime);
			 
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return subscriptionUpdate;
	}
	
	private JSONObject getCalculateYieldThresholdResponse(YieldAlarmThresholdModel model){
		JSONObject yieldInfo = JSONFactoryUtil.createJSONObject();
		double threshold = model.getThreshold();
		double standardDeviation = model.getStandardDeviation();
		DecimalFormat newFormat = new DecimalFormat("#.#");
		double info = Double.valueOf(newFormat.format(threshold - standardDeviation)); ; 
		double warn =  Double.valueOf(newFormat.format(threshold - (1.5*standardDeviation)));
		double error =  Double.valueOf(newFormat.format(threshold - (2*standardDeviation)));
		
		yieldInfo.put("calc-now-yield ", Double.toString(threshold));
		yieldInfo.put("calc-now-deviation", Double.toString(standardDeviation));
		yieldInfo.put("calc-now-info", Double.toString(info));
		yieldInfo.put("calc-now-warn", Double.toString(warn));
		yieldInfo.put("calc-now-error", Double.toString(error));
		return yieldInfo ; 
	}
	private List<YieldAlarmSubscriptionModel> createSubscriptionModel(String context){

		List<YieldAlarmSubscriptionModel>  modelLst = new ArrayList<YieldAlarmSubscriptionModel>();;
		try {
			JSONObject json = JSONFactoryUtil.createJSONObject(context);
			List<String> productType  = getListObject(json.getString("productType"));
			List<String>  productFamily = getListObject(json.getString("productFamily"));
			List<String>  processNames = getListObject(json.getString("processNames"));
			List<String>  stationNames = getListObject(json.getString("stationNames"));
			List<String> regionNames = getListObject(json.getString("regionNames"));
			List<String> siteNames = getListObject(json.getString("siteNames"));
			List<String> serverNames = getListObject(json.getString("serverNames"));
			int count = productType.size();
			for(int i=0; i< count; i++){
				YieldAlarmSubscriptionModel model = new YieldAlarmSubscriptionModel();
				model.setProcess(processNames.get(i).replaceAll("[^\\w\\s]",""));
				model.setServer(serverNames.get(i).replaceAll("\\[", "").replaceAll("\\]","").replaceAll("\"", ""));
				model.setStation(stationNames.get(i).replaceAll("[^\\w\\s]",""));
				model.setProductFamily(productFamily.get(i).replaceAll("[^\\w\\s]",""));
				model.setProductType(productType.get(i).replaceAll("[^\\w\\s]",""));
				model.setSite(siteNames.get(i).replaceAll("[^\\w\\s]",""));
				model.setRegion(regionNames.get(i).replaceAll("[^\\w\\s]",""));
				modelLst.add(model);
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return modelLst;
	}
	private List<String> getListObject(String listObject){
		String[] serversArray = listObject.split(",");		
		return Arrays.asList(serversArray);
	}
	
	public void  addSubscription(ActionRequest actionRequest, ActionResponse actionResponse){
	    //Some logic here
		RegionSiteServerList regionSiteServerList = null;;
		try {
			regionSiteServerList = subscriptionService.getRegionSiteServerList();
			actionRequest.setAttribute("regionSiteServerList", regionSiteServerList.toJSON());
		} catch (Exception e) {
			_log.error(e.getMessage());
			e.printStackTrace();
		}
		
		try{
			ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			User user = themeDisplay.getUser();
			long userId = user.getUserId();
			if(subscriptionService.isUserPushDeviceRegistered(userId))
				actionRequest.setAttribute("pushDevice", "true");
			else
				actionRequest.setAttribute("pushDevice", "false");
			
			// set the user communication preference in the request
			setUserCommunicationPreference(userId,actionRequest);
		}
		catch(Exception ex){
			_log.error(ex);
		}
		actionRequest.setAttribute("actionType", "add");
		actionResponse.setRenderParameter("jspPage","/html/editSubscriptions.jsp");
	}
	
	private void setUserCommunicationPreference(long userId, ActionRequest actionRequest){
		
		int subscriptionInfo = 0 ; 
		int subscriptionWarning = 0 ; 
		int subscriptionCritical = 0 ; 
		try{
			String preference = subscriptionService.getUserCommunicationPreference(userId);
			JSONObject json = JSONFactoryUtil.createJSONObject(preference);
			boolean infoMail = json.getBoolean("emailProcessInfo");
			boolean warnMail = json.getBoolean("emailProcessWarning");
			boolean criticalMail = json.getBoolean("emailProcessCritical");

			boolean infoSMS = json.getBoolean("smsProcessInfo");
			boolean warnSMS = json.getBoolean("smsProcessWarning");
			boolean criticalSMS = json.getBoolean("smsProcessCritical");
			
			boolean infoPush = json.getBoolean("pushProcessInfo");
			boolean warnPush = json.getBoolean("pushProcessWarning");
			boolean criticalPush = json.getBoolean("pushProcessCritical");
			
			if(infoMail)
				subscriptionInfo = subscriptionInfo + 1 ;
			if(infoSMS)
				subscriptionInfo = subscriptionInfo + 2 ;
			if(infoPush)
				subscriptionInfo = subscriptionInfo + 4 ;
			
			if(warnMail)
				subscriptionWarning = subscriptionWarning + 1 ;
			if(warnSMS)
				subscriptionWarning = subscriptionWarning + 2 ;
			if(warnPush)
				subscriptionWarning = subscriptionWarning + 4 ;
			
			if(criticalMail)
				subscriptionCritical = subscriptionCritical + 1 ;
			if(criticalSMS)
				subscriptionCritical = subscriptionCritical + 2 ;
			if(criticalPush)
				subscriptionCritical = subscriptionCritical + 4 ;
			
		}
		catch(Exception ex){
			_log.error(ex);
		}
		actionRequest.setAttribute("subscriptionInfo", Integer.toString(subscriptionInfo));
		actionRequest.setAttribute("subscriptionWarning", Integer.toString(subscriptionWarning));
		actionRequest.setAttribute("subscriptionCritical", Integer.toString(subscriptionCritical));
	}
	
	public void editSubscription(ActionRequest actionRequest, ActionResponse actionResponse){
	    //Some logic here
		RegionSiteServerList regionSiteServerList = null;;
		try {
			regionSiteServerList = subscriptionService.getRegionSiteServerList();
			actionRequest.setAttribute("regionSiteServerList", regionSiteServerList.toJSON());
		} catch (Exception e) {
			_log.error(e.getMessage());
			e.printStackTrace();
		}
		
		String subscriptionName = actionRequest.getParameter("subscriptionName");
		String subscriptionDesc = actionRequest.getParameter("subscriptionDesc");
		String subscriptionType = actionRequest.getParameter("subscriptionType");

		_log.debug(subscriptionName);
		
		int subscriptionId = 0;
		int subscriptionInfo = 0;
		int subscriptionWarning = 0;
		int subscriptionCritical = 0;
		
		try{
			subscriptionId = Integer.parseInt(actionRequest.getParameter("subscriptionid"));
			subscriptionInfo = Integer.parseInt(actionRequest.getParameter("subscriptionInfo"));
			subscriptionWarning = Integer.parseInt(actionRequest.getParameter("subscriptionWarning"));
			subscriptionCritical = Integer.parseInt(actionRequest.getParameter("subscriptionCritical"));
		}catch(java.lang.NumberFormatException jnex){
			_log.error(jnex.getMessage());
		}
		
		try{
			ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			User user = themeDisplay.getUser();
			long userId = user.getUserId();
			if(subscriptionService.isUserPushDeviceRegistered(userId))
				actionRequest.setAttribute("pushDevice", "true");
			else
				actionRequest.setAttribute("pushDevice", "false");
		}
		catch(Exception ex){
			_log.error(ex);
		}
		
		Subscription subscription = new Subscription(subscriptionId, subscriptionName, subscriptionType, subscriptionDesc, subscriptionInfo, subscriptionWarning, subscriptionCritical);
		actionRequest.setAttribute("subscription", subscription);
		actionRequest.setAttribute("actionType", "edit");
		_log.debug("Subscription Id passed is:" + subscriptionId);
		actionResponse.setRenderParameter("jspPage","/html/editSubscriptions.jsp");
	}

	public void deleteSubscription(ActionRequest actionRequest, ActionResponse actionResponse){
		long subscriptionId = Long.parseLong(actionRequest.getParameter("subid"));
		_log.debug("Subscription Id passed is:" + actionRequest.getParameter("subid"));
		_log.debug("inside delete");
		try{
			subscriptionService.deleteSubscription(subscriptionId);
		}catch(Exception e) {
			_log.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
	private ProductProcessQuery createProductProcessQuery(String context) {
		ProductProcessQuery pp = null;
		try {
			JSONObject json = JSONFactoryUtil.createJSONObject(context);
			String regionName = json.getString("regionName");
			String siteName = json.getString("siteName");
			String serverName = json.getString("serverName");
			pp = new ProductProcessQuery(regionName, siteName, serverName);			

		} catch (JSONException e) {
			_log.error(e);
			e.printStackTrace();
		}
		return pp;

	}
	public String toFormattedString(List<Subscription> subscriptions){
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(Subscription r : subscriptions){
			//sb.append(r.toString()).append(",");
			sb.append("[\""+r.getSubscriptionID() + 
					"\",\""+r.getSubscriptionType() + 
					"\",\"" + 
					"\",\"" + 
					"\",\""+r.getSubscriptionInfo() + 
					"\",\""+r.getSubscriptionWarning() + 
					"\",\""+r.getSubscriptionCritical() + 
					"\",\""+r.getSubscriptionDesc() + 
					"\",\""+r.getSubscriptionName() + 
					"\",\""+r.isOnOffNotification() +"\"],");
			
			//sb.append();
		}
		sb.append("]");
		return sb.toString();
	}
	
	private JSONArray toProductProcesss(List<ProductProcess> productProcesses){
		  JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		  
		  for(ProductProcess p: productProcesses){
			  jsonArray.put(p.toJSON());
		  }
		  return jsonArray;
	  }
	
	private JSONObject toSubscribedDataList(List<SubscribedDataProcess> subDataProcess){
		  JSONObject response = JSONFactoryUtil.createJSONObject();
		  JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		  
		  for(SubscribedDataProcess p: subDataProcess){
			  jsonArray.put(p.toJSON());
		  }
		  
		  response.put("subscriptionList",jsonArray);
		  
		  return response;
	  }
	
	private void processPhoneUpdate(ResourceRequest resourceRequest,  ResourceResponse resourceResponse,
			User user, String cmd, String context) throws IOException{

		try{
			JSONObject jsonRequestContext = JSONFactoryUtil.createJSONObject(context);
			String phoneNumber = jsonRequestContext.getString("phoneNumber");
	
			List<Phone> phones = user.getPhones();
			boolean primaryExists = false;
			
			_log.debug("Received phoneNumber of:"+phoneNumber);
			JSONObject json = JSONFactoryUtil.createJSONObject();
			
			for(Phone phone:phones){
				if(phone.isPrimary()){
					primaryExists = true;
					phone.setNumber(phoneNumber);
					_log.debug("Setting phoneNumber based on found Phone of:"+phoneNumber);
					PhoneLocalServiceUtil.updatePhone(phone);
					break;
				}
			}
			
			if(!primaryExists){
				
				PhoneLocalServiceUtil.addPhone(user.getUserId(), Contact.class.getName(), user.getContactId(), phoneNumber, "", 11008, true, new ServiceContext());
				
			}
			
			json = JSONFactoryUtil.createJSONObject();
			json.put("success", "message returned");
			json.put("phoneNumber", phoneNumber);

			writeJSON(resourceRequest, resourceResponse, json);
			
		} catch(Exception e) {
			JSONObject jsonError = JSONFactoryUtil.createJSONObject();
			jsonError.put("error", "Update Phone was Unsuccessful");
			writeJSON(resourceRequest, resourceResponse, jsonError);
		}
		
	}

}
