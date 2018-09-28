package com.ys.hmawfm.wfms.workflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class WorkflowAdapter {
	
	public static Workflow convert(String workflowJson){
		
		_log.debug(workflowJson);
		
		Workflow workflow = new Workflow();

		try{
			
	        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject(workflowJson);
			
			Iterator<?> keys = jsonObject.keys();
	        while( keys.hasNext() ){
	        	
	            String key = (String)keys.next();
	            
	            if(key.equalsIgnoreCase("workflow")){
	                
	            	String value = jsonObject.getString(key); 
	        		workflow.setWorkflow(value);
	        		
	            } else if(key.equalsIgnoreCase("steps")){
	                
	            	JSONArray value = jsonObject.getJSONArray(key); 
	            	
	            	Map<Integer, WorkflowStep> steps = convertSteps(value);

	        		_log.debug( "convertSteps returns:" );
	        		_log.debug( steps );
	        		
	        		
	        		workflow.setSteps(steps);
	        
	            }
	        }
	
		} catch(JSONException ex) {
			_log.error( "Unable to parse workflowJson" );
			_log.error( "WorkflowAdapter.convert :"+ex);
		} 
        
		_log.debug( workflow.toString() );
		
		return workflow;
		
	}
	
	public static Map<Integer, WorkflowStep> convertSteps(JSONArray jsonArray)
			throws JSONException {
		
		Map<Integer, WorkflowStep> stepMap = new HashMap<Integer, WorkflowStep>();
		
		for (int i = 0; i < jsonArray.length(); i++) {
			
			WorkflowStep workflowStep = new WorkflowStep();
			
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			
			int stepId = -1;
			
			Iterator<?> keys = jsonObject.keys();
	        while( keys.hasNext() ){
	        	
	            String key = (String)keys.next();
	            JSONArray stepProcessArray = null;
	            
	            _log.debug("Processing key of: "+key);
	            
	    	    if(key.equalsIgnoreCase("step")){

	    	    	stepId = jsonObject.getInt(key); 
	            	workflowStep.setStep(stepId);
	            	
                }else if(key.equalsIgnoreCase("approvers")){

                	stepProcessArray = jsonObject.getJSONArray(key); 
	            	workflowStep.setApprovers( toStringList(stepProcessArray) );
                	
                } else if(key.equalsIgnoreCase("onView")){

                	stepProcessArray = jsonObject.getJSONArray(key); 
	            	workflowStep.setOnView( toStepProcessList(stepProcessArray) );
                	
                } else if(key.equalsIgnoreCase("onSave")){

                	stepProcessArray = jsonObject.getJSONArray(key); 
	            	workflowStep.setOnSave( toStepProcessList(stepProcessArray) );;
                	
                } 
                else if(key.equalsIgnoreCase("onSubmit")){

                	stepProcessArray = jsonObject.getJSONArray(key); 
	            	workflowStep.setOnSubmit( toStepProcessList(stepProcessArray) );;
                	
                }else if(key.equalsIgnoreCase("onDiscard")){
                     //System.out.print(key);
                	stepProcessArray = jsonObject.getJSONArray(key); 
	            	workflowStep.setOnDiscard( toStepProcessList(stepProcessArray) );
	            	//_log.info("Adding onApprove:"+stepProcessArray);
	            	//_log.info("Using toStepProcessList onApprove:"+toStepProcessList(stepProcessArray));
                	
                } else if(key.equalsIgnoreCase("onApprove")){

                	stepProcessArray = jsonObject.getJSONArray(key); 
	            	workflowStep.setOnApprove( toStepProcessList(stepProcessArray) );

	            	_log.debug("Adding onApprove:"+stepProcessArray);
	            	_log.debug("Using toStepProcessList onApprove:"+toStepProcessList(stepProcessArray));
	            	
                } else if(key.equalsIgnoreCase("onDisapprove")){

                	stepProcessArray = jsonObject.getJSONArray(key); 
	            	workflowStep.setOnDisapprove( toStepProcessList(stepProcessArray) );
                	
                }
                else if(key.equalsIgnoreCase("onSubmit")){

                	stepProcessArray = jsonObject.getJSONArray(key); 
	            	workflowStep.setOnSubmit( toStepProcessList(stepProcessArray) );
                	
                }
	        }
	        
    	    if(stepId>=0) {
    	    	_log.debug("Adding step:"+stepId);
    	    	stepMap.put(stepId, workflowStep);
    	    } else {
    	    	_log.error("Step not found");
    	    }
		}	
		
		return stepMap;
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
	
	private static List<Map<String,String>> toStepProcessList(JSONArray jsonArray)
			throws JSONException {

		List<Map<String,String>> values = new ArrayList<Map<String,String>>();
		
		if(null!=jsonArray){
			
			for (int i = 0; i < jsonArray.length(); i++) {
				
				Map<String,String> process = new HashMap<String,String>();

				JSONObject jsonObject = jsonArray.getJSONObject(i);

				Iterator<?> keys = jsonObject.keys();
		        while( keys.hasNext() ){
		        	
		            String key = (String)keys.next();
		            
		    	    if(key.equalsIgnoreCase("email")){

		    	    	JSONObject emailArray = jsonObject.getJSONObject(key); 
		    	    	process.put(key, emailArray.toString() );

	                } else {

		    	    	process.put(key,jsonObject.getString(key) );
		    	    	
	                }
		        }
		        
				values.add(process);	
			}
		}
				
		return values; 
	}
	

	public static Map<String,String> jsonToMap(String json) {
	
		Map<String,String> map = new HashMap<String,String>();

		try{
	        JSONObject jsonObject =  JSONFactoryUtil.createJSONObject(json);
			
			Iterator<?> keys = jsonObject.keys();
	        while( keys.hasNext() ){
	            String key = (String)keys.next();
	    		map.put(key,jsonObject.getString(key));
	        }
		} catch(JSONException ex) {
			_log.error( "Unable to parse jsonEmailContent" );
			_log.error( "WorkflowAdapter.jsonToMap :"+ex);
		} 
		return map;
	}
	private static Log _log = LogFactoryUtil.getLog(WorkflowAdapter.class.getName());

}
