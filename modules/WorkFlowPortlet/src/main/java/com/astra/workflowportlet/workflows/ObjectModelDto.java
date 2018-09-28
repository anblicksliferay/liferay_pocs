package com.astra.workflowportlet.workflows;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ObjectModelDto {
	private String stepNumber;
	private String nextApprover;
	private String currentStatus;
	

}
