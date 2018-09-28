package com.al.servicemandi.sms.portlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * @author Ashok Leyland
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.servicemandi",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=SMS Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
		
	},
	service = Portlet.class
)
public class ServiceMandiSmsPortlet extends MVCPortlet {

	//"add-process-action-success-action=false"
	
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		boolean isSMSPortletCalled = false;
		logger.info("textLink method in ServiceMandiSmsPortlet Class");
		String mobileNumber = ParamUtil.get(resourceRequest, "mobile","0");
		//String appUrl = "https://play.google.com/store/apps/details?id=com.ubercab";
		String appUrl = "https://play.google.com/store/apps/details?id=com.servicemandi.mechanic&hl=en";
		String data = "";
		data += "method=sendMessage";
		data += "&userid=2000167350"; // your loginId
		data += "&password=" + URLEncoder.encode("B9sPfP", "UTF-8"); // your password
		data += "&msg=" + URLEncoder.encode("Please download ServiceMandi app from here "+appUrl, "UTF-8");
		data += "&send_to=" + URLEncoder.encode(mobileNumber, "UTF-8"); // a valid 10 digit phone no.
		data += "&v=1.1";
		data += "&msg_type=TEXT"; // Can by "FLASH" or "UNICODE_TEXT" or “BINARY”
		data += "&auth_scheme=PLAIN";
		URL url = new URL("http://enterprise.smsgupshup.com/GatewayAPI/rest?" + data);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setUseCaches(false);
		conn.connect();
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		StringBuffer buffer = new StringBuffer();
		while ((line = rd.readLine()) != null) {
			buffer.append(line).append("\n");
		}
		logger.info(buffer.toString());
		rd.close();
		// Commented and added  to send show success fail message 
		//conn.disconnect();
		
		String conncetionResponse = null;
		conncetionResponse = conn.getResponseMessage();
		int responseCode = conn.getResponseCode();
		
		resourceResponse.setContentType("text/html");
		PrintWriter writer = resourceResponse.getWriter();
		JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			conn.disconnect();
		//	SessionMessages.add(actionRequest,
		//			PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		 jsonObject.put("sendStatus", "Success");
		logger.info("SMS has been sent successfully"+responseCode);
		}else{
		//	SessionMessages.add(actionRequest, 
		//			PortalUtil.getPortletId(actionRequest) 
		//			+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		 jsonObject.put("sendStatus", "Failure");
		logger.info("There is problem in Request URL to send SMS"+responseCode);
		}
		logger.info("URL Respond Data"+conncetionResponse);
		
		writer.print(jsonObject.toString());
        writer.flush();
        writer.close();
        		
		// Commented and added By to send show success fail message 
	}
	
	private Log logger = LogFactoryUtil.getLog(ServiceMandiSmsPortlet.class);
	
}