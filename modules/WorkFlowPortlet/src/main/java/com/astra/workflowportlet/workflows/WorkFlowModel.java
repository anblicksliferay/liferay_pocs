package com.astra.workflowportlet.workflows;

import com.liferay.portal.kernel.json.JSONArray;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor 
public class WorkFlowModel {
	private String workflowName;
	private String currentStepNumber;
	private JSONArray Approvers;
	private JSONArray Action;
	

}
