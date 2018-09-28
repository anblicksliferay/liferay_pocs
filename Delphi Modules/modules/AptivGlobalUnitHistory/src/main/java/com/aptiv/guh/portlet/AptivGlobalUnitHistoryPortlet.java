package com.aptiv.guh.portlet;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.aptiv.guh.model.FisEvent;
import com.aptiv.guh.model.FisBarCode;
import com.aptiv.guh.service.GUHService;
import com.aptiv.guh.service.impl.GUHServiceImpl;
import com.aptiv.guh.util.GUHUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import org.apache.commons.lang3.StringEscapeUtils;
import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "com.liferay.portlet.display-category=Aptiv",
		"com.liferay.portlet.instanceable=true", "com.liferay.portlet.header-portlet-javascript=/js/main.js",
		"javax.portlet.display-name=Aptiv Global Unit History Portlet",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/viewGlobalUnitHistory.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)

public class AptivGlobalUnitHistoryPortlet extends MVCPortlet {
	private static Log _log = LogFactoryUtil.getLog(AptivGlobalUnitHistoryPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		_log.debug(
				"in the DelphiGlobalunithistoryPortletmvcportletPortlet, forwaring to viewGlobalUnitHistory jsp");
		PortletRequestDispatcher prd = getPortletContext().getRequestDispatcher(getInitParameter("view-template"));
		prd.include(renderRequest, renderResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		
		String cmd = ParamUtil.getString(resourceRequest, "cmd");
		String cmdType = ParamUtil.getString(resourceRequest, "cmdType");
		String context = ParamUtil.getString(resourceRequest, "context");
		_log.debug(	"in the serverResource of GUH portlet. command is: "+ 
					cmd +" with cmdType(optional): " +
					cmdType + " with context(optional): " + context);
		
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();

		long userId = user.getUserId();
		
		JSONObject returnObject  = JSONFactoryUtil.createJSONObject();
		returnObject.put("command", cmd);

		GUHService guhService = new GUHServiceImpl();
		
		try{
			if(cmd.equalsIgnoreCase("searchguh")){
				List<FisEvent> unitHistory = new ArrayList<FisEvent>();
				String status = searchGUH(userId, returnJSONString(context, "id"),unitHistory );
				returnObject.put("data",  convertToJSONArray(unitHistory));
				if(status.equalsIgnoreCase("Multiple")){
					returnObject.put("multiple", "true"); 
				}
				else{
					returnObject.put("multiple", "false"); 
				}
				returnObject.put("viewedTodaycategory", "21" );
				returnObject.put("viewedTodayData", getCodeList(userId, 21) );
			
				returnObject.put("queuedDatacategory", "1" );
				returnObject.put("queuedData", getCodeList(userId, 1) );
			
				returnObject.put("savedcategory", "3" );
				returnObject.put("savedData", getCodeList(userId, 3) );
				
				returnObject.put("weekcategory", "22" );
				returnObject.put("weekdData", getCodeList(userId, 22) );
				
				writeJSON(resourceRequest, resourceResponse, returnObject);
				
			} else if(cmd.equalsIgnoreCase("addToGUHQueue")){

				if(cmdType.equalsIgnoreCase("delete")){
					guhService.deleteBarCode(userId, returnJSONString(context, "id"));
					returnObject.put("data", "value deleted for '"+returnJSONString(context, "id")+"'" );
				} else {
					guhService.queueBarCode(userId, returnJSONString(context, "id"));
					returnObject.put("data", "value queued for ["+returnJSONString(context, "id")+"]" );

				
				}
				
				returnObject.put("viewedTodaycategory", "21" );
				returnObject.put("viewedTodayData", getCodeList(userId, 21) );
			
				returnObject.put("queuedDatacategory", "1" );
				returnObject.put("queuedData", getCodeList(userId, 1) );
			
				returnObject.put("savedcategory", "3" );
				returnObject.put("savedData", getCodeList(userId, 3) );
				
				returnObject.put("weekcategory", "22" );
				returnObject.put("weekdData", getCodeList(userId, 22) );
				
				writeJSON(resourceRequest, resourceResponse, returnObject);
				
			} else if(cmd.equalsIgnoreCase("saveGUH")){
				
				guhService.addBarCodeToSaved(userId, returnJSONString(context, "id"));

				returnObject.put("data", "value saved for ["+returnJSONString(context, "id")+"]" );
				
				returnObject.put("viewedTodaycategory", "21" );
				returnObject.put("viewedTodayData", getCodeList(userId, 21) );
			
				returnObject.put("queuedDatacategory", "1" );
				returnObject.put("queuedData", getCodeList(userId, 1) );
			
				returnObject.put("savedcategory", "3" );
				returnObject.put("savedData", getCodeList(userId, 3) );
				
				returnObject.put("weekcategory", "22" );
				returnObject.put("weekdData", getCodeList(userId, 22) );
				
				
				writeJSON(resourceRequest, resourceResponse, returnObject);
				writeJSON(resourceRequest, resourceResponse, returnObject);

			} else if(cmd.equalsIgnoreCase("getlist")){
				
				returnObject.put("category", returnJSONInteger(context, "category") );
				returnObject.put("data", getCodeList(userId, returnJSONInteger(context, "category") ) );
				
				writeJSON(resourceRequest, resourceResponse, returnObject);
				
			} else {
				_log.error("[UNUSED SERVE RESOURCE COMMAND]: "+cmd);
			}
			
		}catch(Exception e){
			_log.error(e);
			JSONObject json = JSONFactoryUtil.createJSONObject();
			json.put("error", "update/list was Unsuccessful");
			writeJSON(resourceRequest, resourceResponse, json);
		}
	}

	private JSONArray getCodeList(long userId, int category){
		_log.debug("in the serverResource of GUH portlet, getCodeList >> "+category);

		GUHService guhService = new GUHServiceImpl();
		
		List<FisBarCode> codeList = new ArrayList<>();
		try {
			if(category == 21) { // view today
				codeList = guhService.getViewedBarCodesForToday(userId);
			}else if(category == 22){ // view last week
				codeList = guhService.getViewedBarCodesForLastWeek(userId);
			}
			else{
				codeList = guhService.getBarCodes(userId, category);
			}
		} catch (Exception e) {
			_log.error(e);
			e.printStackTrace();
		}

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
	  
		for(FisBarCode p: codeList){
			jsonArray.put(p.toJSON());
		}
		return jsonArray;
	}
	private String searchGUH(long userId, String rawBarCode, List<FisEvent> unitHistory){
		_log.debug("in the serverResource of GUH portlet, unitBarCode >> "+rawBarCode);
		GUHService guhService = new GUHServiceImpl();
		String unescapedBarCode = StringEscapeUtils.unescapeJava(rawBarCode).trim();
		_log.debug("escaped bar code -->   "+ unescapedBarCode);
		String status = "SEARCH" ;
		// in case bar code is empty then no need for any further processing
		if(unescapedBarCode == null || unescapedBarCode.equals("")){
			return status ; 
		}
		String unitBarCode = GUHUtils.resolveBarCode(unescapedBarCode);
		if(unitBarCode == null ){
			// means this barCode doesn't exist
			try{
				guhService.insertBarCodeInTrackingTable(userId, unescapedBarCode);
			}catch(Exception ex){
				_log.error(ex);
				ex.printStackTrace();
			}
		}
		else{
			try {
				status = guhService.getEventListForPartNumber(unitBarCode, unitHistory);
				if(!unitHistory.isEmpty()){
					// in case GUH was found then add this part to view list
					guhService.viewBarCode(userId, unitBarCode);
				}

			} catch (Exception e) {
				_log.error(e);
				e.printStackTrace();
			}
		}
		
		
		
		return status; 
	}

	private JSONArray convertToJSONArray(List<FisEvent> unitHistory){
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		  
		for(FisEvent p: unitHistory){
			jsonArray.put(p.toJSON());
		}
		return jsonArray;
	}
	
	private String returnJSONString(String context, String contextkey){
		String returnValue = "";
		try {
			JSONObject json = JSONFactoryUtil.createJSONObject(context);	
			returnValue = json.getString(contextkey);
			
		} catch (JSONException e) {
			_log.error(e);
			e.printStackTrace();
		}
		return returnValue;
	}

	private int returnJSONInteger(String context, String contextkey){
		int returnValue = -1;
		try {
			JSONObject json = JSONFactoryUtil.createJSONObject(context);	
			returnValue = json.getInt(contextkey);
			
		} catch (JSONException e) {
			_log.error(e);
			e.printStackTrace();
		}
		return returnValue;
	}
	
}