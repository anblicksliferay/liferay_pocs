package com.ys.hmawfm.wfms.workflow;

import java.util.List;
import java.util.Map;

public class WorkflowStep {

    private int step;
	   
	private String[] approvers;

    private List<Map<String,String>> onView;

    private List<Map<String,String>> onSave;

    private List<Map<String,String>> onSubmit;
    
    private List<Map<String,String>> onDiscard;

    private List<Map<String,String>> onApprove;

    private List<Map<String,String>> onDisapprove;
    
    private List<Map<String,String>> onWorkflowStart;
    
    private List<Map<String,String>> onLastApproval;


	public int getStep ()
    {
        return step;
    }

    public void setStep (int step)
    {
        this.step = step;
    }

    public String[] getApprovers ()
    {
        return approvers;
    }

    public void setApprovers (String[] approvers)
    {
        this.approvers = approvers;
    }

    public List<Map<String,String>> getOnView ()
    {
        return onView;
    }

    public void setOnView(List<Map<String, String>> onView)
    {
        this.onView = onView;
    }

    public List<Map<String,String>> getOnSave ()
    {
        return onSave;
    }

    public void setOnSave(List<Map<String, String>> onSave)
    {
        this.onSave = onSave;
    }

    public List<Map<String,String>> getOnDiscard() {
		return onDiscard;
	}

	public void setOnDiscard(List<Map<String,String>> onDiscard) {
		this.onDiscard = onDiscard;
	}

	public List<Map<String,String>> getOnDisapprove() {
		return onDisapprove;
	}

	public void setOnDisapprove(List<Map<String,String>> onDisapprove) {
		this.onDisapprove = onDisapprove;
	}

	public List<Map<String,String>> getOnWorkflowStart() {
		return onWorkflowStart;
	}

	public void setOnWorkflowStart(List<Map<String,String>> onWorkflowStart) {
		this.onWorkflowStart = onWorkflowStart;
	}

	public List<Map<String,String>> getOnLastApproval() {
		return onLastApproval;
	}

	public void setOnLastApproval(List<Map<String,String>> onLastApproval) {
		this.onLastApproval = onLastApproval;
	}

	public List<Map<String,String>> getOnApprove() {
		return onApprove;
	}

	public void setOnApprove(List<Map<String,String>> onApprove) {
		this.onApprove = onApprove;
	}

	public List<Map<String,String>> getOnSubmit() {
		return onSubmit;
	}

	public void setOnSubmit(List<Map<String,String>> onSubmit) {
		this.onSubmit = onSubmit;
	}

    @Override
    public String toString()
    {
        return "WorkflowStep [approvers = "+approvers+", onView = "+onView+", onSave = "+onSave+", onApprove = "+onApprove+
        		", onDisapprove = "+onDisapprove+", onSubmit = "+onSubmit+", step = "+step+"]";
    }
}
