package cn.com.brilliance.begen.service;

import java.util.List;


public interface PermissionWorkflowManager {
	public void create(String processDefName,String dataObjectName,Object obj,String currentUser);
	
	public void accept(String taskId,String dataObjectName,Object obj,String currentUser);
	
	public void reject(String taskId,String dataObjectName,Object obj,String currentUser);
	
	public List getTodoActivityList(String userId);	
	
}
