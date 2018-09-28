package com.testformByAdmin;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.io.IOUtils;
import org.osgi.service.component.annotations.Component;

import com.ddt.model.Loc_Course_Info;
import com.ddt.service.Loc_Course_InfoLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONObjectWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

	@Component(immediate=true, 
		property={
				"com.liferay.portlet.display-category=AshokLeyLand",
				"com.liferay.portlet.instanceable=true",
				"javax.portlet.security-role-ref=power-user,user", 
				"javax.portlet.init-param.template-path=/",
				"javax.portlet.init-param.view-template=/dashboard/view.jsp",
				"javax.portlet.display-name=TestMonailByadmin Portlet"
				},
	service={Portlet.class})
public class TestMonailByadmin extends MVCPortlet
			{
			  public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
			  {
			    try
			    {
			      Long id = Long.valueOf(CounterLocalServiceUtil.increment());
			      Loc_Course_Info loc_Course_Info = Loc_Course_InfoLocalServiceUtil.createLoc_Course_Info(id.longValue());
			      loc_Course_Info.setId(id.longValue());
			      loc_Course_Info.setCouserId(CounterLocalServiceUtil.increment());
			      loc_Course_Info.setLocationId(CounterLocalServiceUtil.increment());
			      loc_Course_Info.setLocationName("TS");
			      loc_Course_Info.setCouserName(" Basic Course _ High cost Fees ");
			      loc_Course_Info.setCreateDate(new Date());
			   //  Loc_Course_InfoLocalServiceUtil.updateLoc_Course_Info(loc_Course_Info);
			    }
			    catch (Exception localException) {
			    	localException.printStackTrace();
			    }
			    renderRequest.setAttribute("loca_course", getJsonLocation());
			    super.doView(renderRequest, renderResponse);
			  }
			  
			
			  public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			    throws IOException, PortletException
			  {
			    String cmd = ParamUtil.getString(resourceRequest, "cmd");
			    String cmdType = ParamUtil.getString(resourceRequest, "cmdType");
			       String context = ParamUtil.getString(resourceRequest, "context");
			    if (cmd.equalsIgnoreCase("list")) {
			    	  Long id = Long.valueOf(CounterLocalServiceUtil.increment());
				      Loc_Course_Info loc_Course_Info = Loc_Course_InfoLocalServiceUtil.createLoc_Course_Info(id.longValue());
				      loc_Course_Info.setId(id.longValue());
				      loc_Course_Info.setCouserId(CounterLocalServiceUtil.increment());
				      loc_Course_Info.setLocationId(CounterLocalServiceUtil.increment());
				      loc_Course_Info.setLocationName("TS");
				      loc_Course_Info.setCouserName(" Basic Course _TS_Chandra ");
				      loc_Course_Info.setCreateDate(new Date());
				   Loc_Course_InfoLocalServiceUtil.updateLoc_Course_Info(loc_Course_Info);
			        String location = ParamUtil.getString(resourceRequest, "location");
				    System.out.println(context); 
				    try {
						JSONObject contextjson = JSONFactoryUtil.createJSONObject(context);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
			
			 try
			      {
                   if (location.equalsIgnoreCase("ALL"))  writeJSON(resourceRequest, resourceResponse, getJsonLocation());
			        writeJSON(resourceRequest, resourceResponse, OnLocationgetJsonLocation(location));
			      }
			      catch (Exception ex) {
			        JSONObject json = JSONFactoryUtil.createJSONObject();
			        json.put("error", "storeDefault Unsuccessful");
			        writeJSON(resourceRequest, resourceResponse, json);
			      }
			    }
			    else if(cmd.equalsIgnoreCase("cmd")){ 
			    	   String locationid = ParamUtil.getString(resourceRequest, "locationid");
			    	File outputFile = new File("D:/liferay-ce-portal-7.0-ga5/tomcat-8.0.32/temp/upload_00000082.pdf");
			    	resourceResponse.setContentType("application/pdf");		
             		OutputStream out = resourceResponse.getPortletOutputStream();
					InputStream in = new FileInputStream(outputFile);
					IOUtils.copy(in, out);
					out.flush();
			    }
			  }
			  
			  public static String OnLocationgetJsonLocation(String location)
			  {
			    JSONObject json = JSONFactoryUtil.createJSONObject();
			    JSONArray jsonData = JSONFactoryUtil.createJSONArray();
			    List<Loc_Course_Info> list_locations = Loc_Course_InfoLocalServiceUtil.getLoc_Course_Infos(0, 
			      Loc_Course_InfoLocalServiceUtil.getLoc_Course_InfosCount());
			    for (Loc_Course_Info listModel : list_locations) {
			      if (listModel.getLocationName().equals(location)) jsonData.put(TOJson(listModel));
			    }
			    json.put("Loc_CourseData", jsonData);
			    return json.toString();
			  }
			  
			  public static String getJsonLocation()
			  {
			    JSONObject json = JSONFactoryUtil.createJSONObject();
			    JSONArray jsonData = JSONFactoryUtil.createJSONArray();
			    List<Loc_Course_Info> list_locations = Loc_Course_InfoLocalServiceUtil.getLoc_Course_Infos(0, 
			      Loc_Course_InfoLocalServiceUtil.getLoc_Course_InfosCount());
			    for (Loc_Course_Info listModel : list_locations) {
			      jsonData.put(TOJson(listModel));
			    }
			    json.put("Loc_CourseData", jsonData);
			    return json.toString();
			  }
			  
			  public static JSONObject TOJson(Loc_Course_Info listModel) 
			  {
				  
                    JSONObject json = JSONFactoryUtil.createJSONObject();
                    JSONArray dropdownJson = JSONFactoryUtil.createJSONArray();
					    json.put("CourseId", listModel.getCouserId());
					    json.put("CousrseName", listModel.getCouserName());
					    json.put("LocationId", listModel.getLocationId());
					    json.put("LocationName", listModel.getLocationName());
					    json.put("CreatDate",  new SimpleDateFormat("dd-MM-yyyy HH:mm:ss  ").format(listModel.getCreateDate()));
					    json.put("Fees", 5000);
					    json.put("Status", "Pending");
					    json.put("DropdwonData", ToDropDownJson(listModel));
					    return json;	
			  }
			  
			  public static String ToDropDownJson(Loc_Course_Info listModel) 
			  {
				   JSONArray dropdownJson = JSONFactoryUtil.createJSONArray();
					      for(int i=0;i<2;i++){
					    	  JSONObject json = JSONFactoryUtil.createJSONObject();
					    	    json.put("key", listModel.getCouserId()+i);
					    	    json.put("value", listModel.getCouserId()+i);
					    	    dropdownJson.put(json);
					      }
                    					return  dropdownJson.toString();	
			  }
}
