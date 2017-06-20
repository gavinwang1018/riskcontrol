package cn.com.brilliance.begen.service;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.model.*;

public interface SysWorkflowInsTaskService {

	public List<SysWorkflowInsTask> init(SysWorkflowInsTask sysWorkflowInsTask,Map queryFields);
	
	public void delete(String id);
	
	public  List<SysWorkflowInsTask> getSysWorkflowInsTaskListOfQuery(Map queryFields);
	
	public SysWorkflowInsTask saveSysWorkflowInsTask(SysWorkflowInsTask sysWorkflowInsTask);
	
	public  SysWorkflowInsTask getSysWorkflowInsTask(String id);

    public SysWorkflowInsTask saveAll(SysWorkflowInsTask sysWorkflowInsTask );
	
	public void deleteAll(List<SysWorkflowInsTask> sysWorkflowInsTasks);
}
