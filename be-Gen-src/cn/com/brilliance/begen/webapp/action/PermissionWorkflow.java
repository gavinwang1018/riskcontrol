package cn.com.brilliance.begen.webapp.action;

import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.exception.SystemException;
import cn.com.brilliance.begen.service.PermissionWorkflowManager;

public class PermissionWorkflow extends BasePage {
	private String workflowDefName;
	
	private String taskInsId;
	
	private String eventType;
	
	private String currentUser;	
	
	private String dataObjectName;
	
	public PermissionWorkflow(){
		currentUser = String.valueOf(this.getUserBean().getTuserInfo().getId());
	}
	
	public String createProcess(){
		PermissionWorkflowManager permissionWorkflowManager = (PermissionWorkflowManager)this.getBean("permissionWorkflowManager");
		Object obj = getFormDataObject(dataObjectName);
		try{
			permissionWorkflowManager.create(workflowDefName, dataObjectName, obj, currentUser);
		}
		catch(SystemException e){
            addMessageString(e.getLocalizedMessage());
            return getFailureAction();
		}
        addMessageString("发起成功!");
		return getSuccessAction();
	}
	
	public String endTask(){
		PermissionWorkflowManager permissionWorkflowManager = (PermissionWorkflowManager)this.getBean("permissionWorkflowManager");
		Object obj = getFormDataObject(dataObjectName);
		try{
			if("accept".equals(eventType)){
				permissionWorkflowManager.accept(taskInsId, dataObjectName, obj, currentUser);
			}
			else if("reject".equals(eventType)){
				permissionWorkflowManager.reject(taskInsId, dataObjectName, obj, currentUser);
			}
		}
		catch(SystemException e){
            addMessageString(e.getLocalizedMessage());
            return getFailureAction();
		}
        addMessageString("审批成功!");
		return getSuccessAction();
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getTaskInsId() {
		return taskInsId;
	}

	public void setTaskInsId(String taksInsId) {
		this.taskInsId = taksInsId;
	}

	public String getWorkflowDefName() {
		return workflowDefName;
	}

	public void setWorkflowDefName(String workflowDefName) {
		this.workflowDefName = workflowDefName;
	}

	public String getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}		
	
    private Object getFormDataObject(String dataObjectName){
		String dataObjectVar = Tools.makeVarName(dataObjectName);
		String str = "#{" + dataObjectVar + "Form." + dataObjectVar + "}";
		return this.getValueBinding(str);			
    }

	public String getDataObjectName() {
		return dataObjectName;
	}

	public void setDataObjectName(String dataObjectName) {
		this.dataObjectName = dataObjectName;
	}
	
}
