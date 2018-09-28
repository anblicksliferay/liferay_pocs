package com.ys.hmawfm.wfms.services.rest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
//import org.codehaus.jackson.JsonGenerationException;
//import org.codehaus.jackson.JsonNode;
//import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;


public class CostCenterService {

	private String host;
	private String port;
	private String serviceUrl;
	private String userID;
	private String password;

	private static final String HMAServiceNow_HOST = "hma.servicenow.host";
	private static final String HMAServiceNow_PORT = "hma.servicenow.port";
	private static final String HMAServiceNow_USER = "hma.servicenow.userid";
	private static final String HMAServiceNow_PASSWORD = "hma.servicenow.password";

	public CostCenterService() {
		host = PropsUtil.get(HMAServiceNow_HOST);
		port = PropsUtil.get(HMAServiceNow_PORT);
		userID = PropsUtil.get(HMAServiceNow_USER);
		password = PropsUtil.get(HMAServiceNow_PASSWORD);
		serviceUrl = "/api/now/table/cmn_cost_center";
	}

	public JSONObject  userIsSameDepartment(String deptName) throws  IOException, JSONException, com.liferay.portal.kernel.json.JSONException {
		
		  String serviceUrlNew = "/api/now/table/cmn_cost_center";
		  JSONObject jSonObject=null;
		  if(Validator.isNotNull(deptName)){
		  String getUrl = "https://" + host + serviceUrlNew + "?user_name=" + deptName;
		  //System.out.println("getUrl " + getUrl);
		  RestTemplate restTemplate = new RestTemplate();
		  restTemplate.setRequestFactory(new SimpleClientHttpRequestFactory());
		  
		   jSonObject = getResponseObject(getUrl, deptName, "code");
		  }
		  else{
			  
			  //_log.info("cannot make a serviceNow Connection with departNumber");
		  }
		  return jSonObject;
		 }
	
	
	public Boolean  userIsSameDepartmentOnServiceNow(String deptName,String username,String deptRoleKey) throws  IOException, JSONException, com.liferay.portal.kernel.json.JSONException {
	 boolean flag=false;
		String serviceUrlNew = "/api/now/table/u_cost_center_department_division";
		HttpEntity<String> entity = getHttpEntity();
		  String getUrl = "https://" + host + serviceUrlNew + "?cc_code=" + deptName+"&"+deptRoleKey+"="+username+"";
			//https://qsnhma.service-now.com/api/now/table/u_cost_center_department_division?sysparm_limit=1&cc_code=V5290&mpwrrep_user_name=HA26033
	//	System.out.println(getUrl);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setRequestFactory(new SimpleClientHttpRequestFactory());
		HttpEntity<String> response = null;
		try {
			response = restTemplate.exchange(getUrl, HttpMethod.GET, entity, String.class);
		} catch (Exception ex) {
			//_log.error("CostCenterService.getAllCostCenters():", ex);
		}
		if (null != response) {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(response.getBody());
			////_log.info("Response Body \t"+node);
			JSONObject jsonObject=JSONFactoryUtil.createJSONObject(node.toString());
		      if(node.toString().length()>14){
		    	  flag=true;
		      }
		      else flag =false;
		}
		
		return flag;
	
		 }
	public Boolean isUserhaveRoles( String userParamater, String screenName) throws  IOException, JSONException, com.liferay.portal.kernel.json.JSONException {
	
		 boolean flag=false;
		 String serviceUrl_CC = "/api/now/table/u_cost_center_department_division";
			HttpEntity<String> entity = getHttpEntity();
			  String getUrl = "https://" + host + serviceUrl_CC + "?"+userParamater+"=" + screenName+"";
			// _log.info(getUrl );
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.setRequestFactory(new SimpleClientHttpRequestFactory());
			HttpEntity<String> response = null;
			try {
				response = restTemplate.exchange(getUrl, HttpMethod.GET, entity, String.class);
			} catch (Exception ex) {
				//_log.error("CostCenterService.getAllCostCenters():", ex);
			}
			if (null != response) {
				ObjectMapper mapper = new ObjectMapper();
				JsonNode node = mapper.readTree(response.getBody());
				////_log.info("Response Body \t"+node);
				JSONObject jsonObject=JSONFactoryUtil.createJSONObject(node.toString());
			      if(node.toString().length()>14){
			    	  flag=true;
			      }
			      else flag =false;
			}
			
			return flag;
	}
	public  String getsameDeptNumbersOnAbbrivationCode(String cc_u_abbreviation) throws  IOException, JSONException {
		//Map<String, String> returnMap = new HashMap<String, String>();
		String serviceUrl_CC = "/api/now/table/u_cost_center_department_division";
		HttpEntity<String> entity = getHttpEntity();
		  String getUrl = "https://" + host + serviceUrl_CC + "?dpt_u_abbreviation=" + cc_u_abbreviation+"";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setRequestFactory(new SimpleClientHttpRequestFactory());
		HttpEntity<String> response = null;
		try {
			response = restTemplate.exchange(getUrl, HttpMethod.GET, entity, String.class);
		} catch (Exception ex) {
			//_log.error("CostCenterService.getAllCostCenters():", ex);
		}
		if (null != response) {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(response.getBody());
	      return node.toString();
		}
		return "errorMessage";
	}
	
	public  String getccCodesonRequisitonGrid( String userParamater,  String screenName) throws  IOException, JSONException {
		//Map<String, String> returnMap = new HashMap<String, String>();
		String serviceUrl_CC = "/api/now/table/u_cost_center_department_division";
		HttpEntity<String> entity = getHttpEntity();
		  String getUrl = "https://" + host + serviceUrl_CC + "?"+userParamater+"=" + screenName+"";
		// _log.info(getUrl );
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setRequestFactory(new SimpleClientHttpRequestFactory());
		HttpEntity<String> response = null;
		try {
			response = restTemplate.exchange(getUrl, HttpMethod.GET, entity, String.class);
		} catch (Exception ex) {
			//_log.error("CostCenterService.getAllCostCenters():", ex);
		}
		if (null != response) {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(response.getBody());
	      return node.toString();
		}
		return "errorMessage";
	}
	public JSONObject  singleCalluserIsSameDepartment(String deptName) throws  IOException, JSONException, com.liferay.portal.kernel.json.JSONException {
		
		  String serviceUrlNew = "/api/now/table/u_cost_center_department_division";
		  JSONObject jSonObject=null;
		  if(Validator.isNotNull(deptName)){
		  String getUrl = "https://" + host + serviceUrlNew + "?cc_code=" + deptName;
		  RestTemplate restTemplate = new RestTemplate();
		  restTemplate.setRequestFactory(new SimpleClientHttpRequestFactory());
		  
		   jSonObject = getResponseObject(getUrl, deptName, "cc_code");
		  }
		  else{
			  
			  _log.info("cannot make a serviceNow Connection with departNumber");
		  }
		  return jSonObject;
		 }
	public JSONObject getResponseObject(String getUrl, String column, String checkNode)	{
		JSONObject jsonObjLiferay=null;
		HttpEntity<String> response = null;
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> entity = null;
		JSONArray jsonArray  = null;
		JSONObject jsonObjLiferayFinal = null;
		
		
		try{
			entity = getHttpEntity();
		}catch(IOException ioEx){ioEx.printStackTrace();}
		
		
		try {
				if(null != entity ){
				   response = restTemplate.exchange(getUrl, HttpMethod.GET, entity, String.class);
				}
			  } catch (Exception ex) { ex.printStackTrace();}
			 
		
		try{
			  if (null != response) {
				  ObjectMapper mapper = new ObjectMapper();
				  JsonNode node = mapper.readTree(response.getBody());
			   if(node.toString().length()>15){
				  jsonObjLiferay = JSONFactoryUtil.createJSONObject(node.toString());
				  String roleUuid = jsonObjLiferay.getString("result");
				
				  if(! roleUuid.substring(0,1).equals("[")){
					  
					  roleUuid = "["+roleUuid +"]";
				  }
				  jsonArray = JSONFactoryUtil.createJSONArray(roleUuid);
				  
				  for(int i=0; i < jsonArray.length();i++){
					  JSONObject jsonObjLiferayLocal =jsonArray.getJSONObject(i);
					  if(column.equals(jsonObjLiferayLocal.getString(checkNode).toString())){
						  jsonObjLiferayFinal=jsonArray.getJSONObject(i);
					  } 
				  }
				  
			   }
			   }
			} catch (Exception ex) { ex.printStackTrace();}
		 return jsonObjLiferayFinal;
	}
	
	public String getResponseString(String getUrl)	{
		JSONObject jsonObjLiferay=null;
		HttpEntity<String> response = null;
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> entity = null;
		//JSONArray jsonArray  = null;
		//JSONObject jsonObjLiferayFinal = null;
		 String roleUuid = "";
		
		try{
			entity = getHttpEntity();
		}catch(IOException ioEx){ioEx.printStackTrace();}
		
		
		try {
				if(null != entity ){
				   response = restTemplate.exchange(getUrl, HttpMethod.GET, entity, String.class);
				}
			  } catch (Exception ex) { ex.printStackTrace();}
			 
		
		try{
			  if (null != response) {
				  ObjectMapper mapper = new ObjectMapper();
				  JsonNode node = mapper.readTree(response.getBody());
			   
				  jsonObjLiferay = JSONFactoryUtil.createJSONObject(node.toString());
				   roleUuid = jsonObjLiferay.getString("result");
				  /*if(! roleUuid.substring(0,1).equals("[")){
					  roleUuid = "["+roleUuid +"]";
				  }*/
				  ////System.out.println("roleUuid Later :" + roleUuid);
			   }
			} catch (Exception ex) { ex.printStackTrace();}
		 return roleUuid;
	}
	
	
	/**
	 * 
	 * @return String
	 * @throws JsonGenerationException
	 * @throws IOException
	 * @throws JSONException
	 */
	public  String getAllCostCenters() throws  IOException, JSONException {
		//Map<String, String> returnMap = new HashMap<String, String>();
		HttpEntity<String> entity = getHttpEntity();
		String getUrl = "https://" + host + serviceUrl;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setRequestFactory(new SimpleClientHttpRequestFactory());
		HttpEntity<String> response = null;
		try {
			response = restTemplate.exchange(getUrl, HttpMethod.GET, entity, String.class);
		} catch (Exception ex) {
			//_log.error("CostCenterService.getAllCostCenters():", ex);
		}
		if (null != response) {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(response.getBody());
	      return node.toString();
		}
		return "errorMessage";
	}
	
	public  String getAllCostCenterswithAbbrevation() throws  IOException, JSONException {
		//Map<String, String> returnMap = new HashMap<String, String>();
		String serviceUrl = "/api/now/table/u_cost_center_department_division";
		HttpEntity<String> entity = getHttpEntity();
		String getUrl = "https://" + host + serviceUrl;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setRequestFactory(new SimpleClientHttpRequestFactory());
		HttpEntity<String> response = null;
		try {
			response = restTemplate.exchange(getUrl, HttpMethod.GET, entity, String.class);
		} catch (Exception ex) {
			//_log.error("CostCenterService.getAllCostCenters():", ex);
		}
		if (null != response) {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(response.getBody());
	      return node.toString();
		}
		return "errorMessage";
	}
	
	public  String getAllDeptmanagerDetailsforCOSApproval(String deptno) throws  IOException, JSONException {
		//Map<String, String> returnMap = new HashMap<String, String>();
		String serviceUrl = "/api/now/table/u_cost_center_department_division?cc_code="+deptno;
		HttpEntity<String> entity = getHttpEntity();
		String getUrl = "https://" + host + serviceUrl;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setRequestFactory(new SimpleClientHttpRequestFactory());
		HttpEntity<String> response = null;
		try {
			response = restTemplate.exchange(getUrl, HttpMethod.GET, entity, String.class);
		} catch (Exception ex) {
			//_log.error("CostCenterService.getAllCostCenters():", ex);
		}
		if (null != response) {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(response.getBody());
	      return node.toString();
		}
		return "errorMessage";
	}
	
	
	

	public Map<String, String> getCostCenterById(String costCenterId) throws  IOException {

		Map<String, String> returnMap = new HashMap<String, String>();

		HttpEntity<String> entity = getHttpEntity();

		String getUrl = "https://" + host + serviceUrl + "?code=" + costCenterId;
		

		RestTemplate restTemplate = new RestTemplate();

		restTemplate.setRequestFactory(new SimpleClientHttpRequestFactory());

		HttpEntity<String> response = null;

		try {
			response = restTemplate.exchange(getUrl, HttpMethod.GET, entity, String.class);
			
		} catch (Exception ex) {
			// //System.out.println("error" + ex);
		}
		if (null != response) {
			// //System.out.println("response getCostCenters: " +
			// response.getBody());

			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(response.getBody());

			// JsonNode itemNode = node.get("items");
			//System.out.println("itemNode getCostCenters" + node);
		}
		return returnMap;
	}

	public HttpEntity<String> getHttpEntity() throws IOException {

		String plainCreds = userID + ":" + password;
		byte[] message = plainCreds.getBytes("UTF-8");
		String base64Creds = DatatypeConverter.printBase64Binary(message);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Creds);

		return new HttpEntity<String>(headers);

	}

	/*public boolean userIsSameDepartment(String screenName) throws JsonProcessingException, IOException, JSONException {

		String serviceUrlNew = "/api/now/table/sys_user";
		HttpEntity<String> entity = getHttpEntity();
		String getUrl = "https://" + host + serviceUrlNew + "?user_name=" + screenName;
		//System.out.println("getUrl " + getUrl);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setRequestFactory(new SimpleClientHttpRequestFactory());
		HttpEntity<String> response = null;

		try {
			response = restTemplate.exchange(getUrl, HttpMethod.GET, entity, String.class);

		} catch (Exception ex) {
			// //System.out.println("error" + ex);

		}
		// JSONObject jsonObj;
		if (null != response) {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(response.getBody());
			//System.out.println(node.toString());
			org.json.JSONObject jsonObj = new org.json.JSONObject(node.toString());
			String str = jsonObj.getString("result").toString();
			org.json.JSONArray array = new org.json.JSONArray(str);
			// here check the lenght of array if lenght <0 returns flase else
			// true
			if (array.length() > 0) {
				for (int i = 0; i < array.length(); i++) {
					jsonObj = array.getJSONObject(0);
				}
				//System.out.println("----user Name form ServiceNow RestAPI------" + jsonObj.getString("user_name"));

				return true;
			}
		}

		return false;
	}
*/
	public boolean userIsDepartmentManager() {

		return false;
	}

	public boolean userIsDepartmentManpower() {

		return false;
	}
	
	private Log _log = LogFactoryUtil.getLog(CostCenterService.class
			.getName());

}