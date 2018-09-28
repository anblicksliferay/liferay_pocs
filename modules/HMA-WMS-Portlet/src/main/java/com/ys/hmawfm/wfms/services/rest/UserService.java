package com.ys.hmawfm.wfms.services.rest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.util.PropsUtil;

public class UserService {

	private String host;
	private String port;
	private String serviceUrl;
	private String userID;
	private String password;

	private static final String HMAServiceNow_HOST = "hma.servicenow.host";
	private static final String HMAServiceNow_PORT = "hma.servicenow.port";
	private static final String HMAServiceNow_USER = "hma.servicenow.userid";
	private static final String HMAServiceNow_PASSWORD = "hma.servicenow.password";
	private JsonNode jsonnode;

	public UserService() {
		host = PropsUtil.get(HMAServiceNow_HOST);
		port = PropsUtil.get(HMAServiceNow_PORT);
		userID = PropsUtil.get(HMAServiceNow_USER);
		password = PropsUtil.get(HMAServiceNow_PASSWORD);
		serviceUrl = "/api/now/table/sys_user";
	}

	public Map<String, String> getAllUsers() throws  IOException {

		Map<String, String> returnMap = new HashMap<String, String>();
		
		HttpEntity<String> entity = getHttpEntity();
	
		String getUrl = "https://" + host + serviceUrl;
		System.out.println("getUrl " + getUrl);
	
		RestTemplate restTemplate = new RestTemplate();
		
		restTemplate.setRequestFactory( new SimpleClientHttpRequestFactory() );
		
		HttpEntity<String> response = null;

		try {
			response = restTemplate.exchange(getUrl, HttpMethod.GET, entity, String.class);
		} catch (Exception ex) {
			// System.out.println("error" + ex);
		}
		if (null != response) {
			//System.out.println("response getCostCenters: " + response.getBody());

			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(response.getBody());

			// JsonNode itemNode = node.get("items");
			System.out.println("getAllUsers returns:" + node);
		}
		return returnMap;
	}

	public Map<String, String> getUserById(String userId) throws  IOException {

		Map<String, String> returnMap = new HashMap<String, String>();
		
		HttpEntity<String> entity = getHttpEntity();
	
		String getUrl = "https://" + host + serviceUrl + "?code="+userId;
		System.out.println("getUrl " + getUrl);
	
		RestTemplate restTemplate = new RestTemplate();
		
		restTemplate.setRequestFactory( new SimpleClientHttpRequestFactory() );
		
		HttpEntity<String> response = null;
	
		try {
			response = restTemplate.exchange(getUrl, HttpMethod.GET, entity, String.class);
		} catch (Exception ex) {
			// System.out.println("error" + ex);
		}
		if (null != response) {
			//System.out.println("response getCostCenters: " + response.getBody());
	
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(response.getBody());
	
			// JsonNode itemNode = node.get("items");
			System.out.println("getDivisionById return: " + node);
			System.out.println("getUsersById returns:" + node);
		}
		return returnMap;
	}
	
	public HttpEntity<String> getHttpEntity() throws IOException{

		String plainCreds = userID + ":" + password;
		byte[] message = plainCreds.getBytes("UTF-8");
		String base64Creds = DatatypeConverter.printBase64Binary(message);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Creds);
	
		return new HttpEntity<String>(headers);
		
	}
	
}