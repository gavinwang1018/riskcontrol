package cn.com.brilliance.begen.webapp.action;

public class ActionParameter {
	private String successAction = null;
	private String failureAction = null;
	
	
	public String getFailureAction() {
		return failureAction;
	}

	public void setFailureAction(String failureAction) {
		this.failureAction = failureAction;
	}

	public String getSuccessAction() {
		return successAction;
	}

	public void setSuccessAction(String action) {
		this.successAction = action;
	}
}
