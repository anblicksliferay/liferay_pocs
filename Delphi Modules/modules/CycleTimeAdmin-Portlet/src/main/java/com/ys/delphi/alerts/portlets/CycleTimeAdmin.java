package com.ys.delphi.alerts.portlets;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.ys.delphi.alerts.models.CycleTimeUpdate;
import com.ys.delphi.alerts.models.ProductProcess;
import com.ys.delphi.alerts.models.ProductProcessQuery;
import com.ys.delphi.alerts.models.RegionSiteServerList;
import com.ys.delphi.alerts.service.AlertService;
import com.ys.delphi.alerts.service.UserDefaultsService;
import com.ys.delphi.alerts.service.Impl.AlertServiceImpl;
import com.ys.delphi.alerts.service.Impl.UserDefaultsServiceImpl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

/**
 * Portlet implementation class CycleTimeAdmin
 */
@Component(
		immediate = true, 
		property = {
			"com.liferay.portlet.display-category=Delphi",
			"com.liferay.portlet.header-portlet-css=/css/main-admin.css", 
			"com.liferay.portlet.header-portlet-javascript=/js/main.js",
			"com.liferay.portlet.instanceable=false",
			"javax.portlet.display-name=CycleTime Admin Portlet",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/html/cycletimeadmin/view.jsp",
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user" 
		},
		service = Portlet.class
	)

public class CycleTimeAdmin extends MVCPortlet {
	private static Log _log = LogFactoryUtil.getLog(CycleTimeAdmin.class);
	private AlertService alertService = new AlertServiceImpl();
	private static String PAGEID = "DelphiCycleTimeAdmin" ; 
	private UserDefaultsService userDefaultService = new UserDefaultsServiceImpl() ;

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		RegionSiteServerList regionSiteServerList = null;;
		try {
			regionSiteServerList = alertService.getRegionSiteServerList();
			renderRequest.setAttribute("regionSiteServerList", regionSiteServerList.toJSON());
		} catch (Exception e) {
			_log.error(e.getMessage());
			e.printStackTrace();
		}
		setUserDefault(renderRequest);
		PortletRequestDispatcher prd = getPortletContext()
				.getRequestDispatcher(getInitParameter("view-template"));		
		prd.include(renderRequest, renderResponse);
	}
	
	private void setUserDefault(RenderRequest renderRequest){
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		long userId = user.getUserId();

		Map<String, String> model = userDefaultService.fetchUserDefaults(userId,PAGEID);
		renderRequest.setAttribute("userDefaultModel", model);	
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {		
		String cmd = ParamUtil.getString(resourceRequest, "cmd");
		String cmdType = ParamUtil.getString(resourceRequest, "cmdType");
		String context = ParamUtil.getString(resourceRequest, "context");
		_log.info("CycleTimeAdmin serveResource command is: "+cmd +" with cmdType(optional): "+cmdType +" with context(optional): "+context);
		try{
			if(cmdType.equalsIgnoreCase("storeDefault")){
				ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
				User user = themeDisplay.getUser();
				//String userName = user.getFullName();
				long userId = user.getUserId();
				try{
					JSONObject jsonRequestContext = JSONFactoryUtil.createJSONObject(context);
					String id = jsonRequestContext.getString("fieldid");
					String value = jsonRequestContext.getString("fieldvalue");
					userDefaultService.updateDefaults(userId, CycleTimeAdmin.PAGEID, id, value);
					JSONObject returnObject = JSONFactoryUtil.createJSONObject();
					returnObject.put("data", "storeDefault request completed sucessfully" );
					writeJSON(resourceRequest, resourceResponse, returnObject);
				}
				catch(Exception ex){
					JSONObject json = JSONFactoryUtil.createJSONObject();
					json.put("error", "storeDefault Unsuccessful");
					writeJSON(resourceRequest, resourceResponse, json);
				}
			}else if(cmd.equalsIgnoreCase("list")){
				ProductProcessQuery pp = createProductProcessQuery (context);			
				List<ProductProcess> productProcesses = alertService.getProductProcessList(pp);				
				writeJSON(resourceRequest, resourceResponse,toProductProcesss(productProcesses));			
			} else if(cmd.equalsIgnoreCase("update")){
				CycleTimeUpdate cycleTimeUpdate =  createCycleTimeUpdate(context);
				alertService.updateProductProcess(cycleTimeUpdate);
				JSONObject json = JSONFactoryUtil.createJSONObject();
				json.put("msg", "update was successful");
				writeJSON(resourceRequest, resourceResponse, json);
			}
		}catch(Exception e){
			JSONObject json = JSONFactoryUtil.createJSONObject();
			json.put("error", "update/list was Unsuccessful");
			writeJSON(resourceRequest, resourceResponse, json);
		}
	}
	private CycleTimeUpdate createCycleTimeUpdate(String context){
		CycleTimeUpdate cycleTimeUpdate = null;
		try {
			JSONObject json = JSONFactoryUtil.createJSONObject(context);
			String partNumber = json.getString("partNumber");
			String process = json.getString("process");
			String station = json.getString("station");
			List<String> serverList = getServerNames(json.getString("serverName"));
			int customCycleTime = json.getInt("customCycleTime");	
			//convert to milliseconds
			customCycleTime = customCycleTime * 1000;
			
			cycleTimeUpdate = new CycleTimeUpdate(partNumber, process, station, serverList, customCycleTime);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cycleTimeUpdate;
	}
	
	private List<String> getServerNames(String servers){
		String[] serversArray = servers.split(",");		
		return Arrays.asList(serversArray);
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
	
	private JSONArray toProductProcesss(List<ProductProcess> productProcesses){
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		for(ProductProcess p: productProcesses){
			jsonArray.put(p.toJSON());
		}
		return jsonArray;
	}

}