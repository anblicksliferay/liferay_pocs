/**
\ * HMA Weekend Work portlet
 * @author Youngsoft, Inc
 *
 *
 */

package com.ys.hmawfm.wfms.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONObject;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.ys.hmawfm.wfms.services.model.WFMS_Config;
import com.ys.hmawfm.wfms.services.service.WFMS_ConfigLocalServiceUtil;

public class ConfigUtility {
	
	/**
	 * 
	 * @param configKey
	 * @return String[]
	 */
	public static String[] getInputValuesFromConfig(String configKey) {
		try{
			WFMS_Config wfms_config = WFMS_ConfigLocalServiceUtil.getByConfigKey(configKey);
			JSONArray configValues = null;
			
			if(wfms_config!=null){
				configValues = JSONFactoryUtil.createJSONArray( wfms_config.getContent() );
			}
			String[] values = new String[0];
			if(null!=configValues){
				values = new String[configValues.length()];
				for (int i = 0; i < configValues.length(); i++) {
					values[i]=configValues.getString(i);
				}
			}
			return values;
		} catch(JSONException ex) {
			_log.info("Unable to parse WFMS_Config for " + configKey);
			_log.error("ConfigUtility.getInputValuesFromConfig :"+ex);
			return new String[0];
		} catch(SystemException ex) {
			_log.info("No WFMS_Config found with the configKey: "+configKey);
			_log.error("ConfigUtility.getInputValuesFromConfig :"+ex);
			return new String[0];
		}
	}
	
	/**
	 * 
	 * @param configKey
	 * @returns map
	 * @throws SystemException
	 * @throws JSONException
	 */
	public static Map<String, String> getInputValuesForMap(String configKey) throws SystemException, JSONException
	{
		HashMap<String, String> map = new HashMap<String, String>();
		try{
			WFMS_Config wfms_config = WFMS_ConfigLocalServiceUtil.getByConfigKey(configKey);
	        JSONObject jObject =  JSONFactoryUtil.createJSONObject(wfms_config.getContent());
	        Iterator<?> keys = jObject.keys();
	        while( keys.hasNext() ){
	            String key = (String)keys.next();
	            String value = jObject.getString(key); 
	            map.put(key, value);
	        }
		}catch(java.lang.NullPointerException npex){
			_log.error("ConfigUtility.getInputValuesForMap NullPointerException for key:"+npex);
		}
		return map;
	}
	
	/**
	 * 
	 * @param configKey
	 * @returns map
	 * @throws SystemException
	 * @throws JSONException
	 */
	public static Map<String, String[]> getOptionGroupValuesFromConfig(String configKey) throws SystemException, JSONException
	{
		HashMap<String, String[]> map = new HashMap<String, String[]>();
		try{
			WFMS_Config wfms_config = WFMS_ConfigLocalServiceUtil.getByConfigKey(configKey);
	        JSONObject jObject =  JSONFactoryUtil.createJSONObject(wfms_config.getContent());
	        Iterator<?> keys = jObject.keys();
	        while( keys.hasNext() ){
	            String key = (String)keys.next();
	            JSONArray value = jObject.getJSONArray(key); 
	            
	            _log.debug("key"+key);
	            _log.debug("value"+value);
	            
	            map.put(key, toStringList(value) );
	        }
		}catch(java.lang.NullPointerException npex){
			_log.error("ConfigUtility.getInputValuesForMap NullPointerException for key:"+npex);
		}
		return map;
	}
	
	private static String[] toStringList(JSONArray jsonArray) 
			throws JSONException {
		
		String[] values = new String[0];
		if(null!=jsonArray){
			values = new String[jsonArray.length()];
			for (int i = 0; i < jsonArray.length(); i++) {
				values[i]=jsonArray.getString(i);
			}
		}
				
		return values; 
	}
	public static String getOptionGroup(String configKey) throws SystemException, JSONException
	{
		
			
	
		try {
			if(Validator.isNotNull(configKey)){
			WFMS_Config wfms_config = WFMS_ConfigLocalServiceUtil.getByConfigKey(configKey);
			
		//	System.out.println(wfms_config.getContent()+"wfms_config.getContent()--------");
	       // JSONObject jObject = new JSONObject(wfms_config.getContent());
	     com.liferay.portal.kernel.json.JSONObject jObject= JSONFactoryUtil.createJSONObject(wfms_config.getContent());
	     //   com.liferay.portal.kernel.json.JSONArray jsonArray= JSONFactoryUtil.createJSONArray(wfms_config.getContent());
		//	 for (int index = 0;index < jsonArray.length(); index++) {
				 Iterator<?> keys = jObject.keys();
			        while( keys.hasNext() ){
			            String key = (String)keys.next();
			          //  JSONArray value = jObject.getJSONArray(key); 
			            
			            _log.debug("key"+key);
			        //    _log.debug("value"+value);
			            
			          //  map.put(key, toStringList(value) );
			        }
				 
				 
				 
				     /*   com.liferay.portal.kernel.json.JSONObject jsonObject = jsonArray.getJSONObject(index);
				        System.out.println(jsonObject.getString(arg0));
				      if(jsonObject.getString("icdCode").equalsIgnoreCase(jsonObject.getString("icdCode"))){
				    	  
				    	  System.out.println("width"+jsonObject.getString("chapter"));
				    	  
				      }
	        */
	      //  }
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return"";
	}
	
	
	private static Log _log = LogFactoryUtil.getLog(ConfigUtility.class.getName());
}
