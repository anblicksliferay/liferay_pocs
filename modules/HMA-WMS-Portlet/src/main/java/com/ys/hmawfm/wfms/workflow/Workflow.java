package com.ys.hmawfm.wfms.workflow;

import java.util.Map;

public class Workflow {
	
    private Map<Integer,WorkflowStep> steps;

    private String workflow;

    public Map<Integer,WorkflowStep> getSteps ()
    {
        return steps;
    }

    public void setSteps (Map<Integer,WorkflowStep> steps)
    {
        this.steps = steps;
    }

    public String getWorkflow ()
    {
        return workflow;
    }

    public void setWorkflow (String workflow)
    {
        this.workflow = workflow;
    }

    @Override
    public String toString()
    {
        return "Workflow [steps = "+steps+", workflow = "+workflow+"]";
    }
		
}
