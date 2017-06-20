package cn.com.brilliance.begen.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;

public class SysWorkflowInsTaskServiceImpl implements SysWorkflowInsTaskService{

	private SysWorkflowInsTaskDAO sysWorkflowInsTaskDAO = null;

	public SysWorkflowInsTaskDAO getSysWorkflowInsTaskDAO() {
		return sysWorkflowInsTaskDAO;
	}

	public void setSysWorkflowInsTaskDAO(SysWorkflowInsTaskDAO sysWorkflowInsTaskDAO) {
		this.sysWorkflowInsTaskDAO = sysWorkflowInsTaskDAO;
	}

	public List<SysWorkflowInsTask> init(SysWorkflowInsTask sysWorkflowInsTask,Map queryFields){
        if (sysWorkflowInsTask != null) {
            return sysWorkflowInsTaskDAO.getSysWorkflowInsTaskList(sysWorkflowInsTask);
        }
        else {
            return getSysWorkflowInsTaskListOfQuery(queryFields);
        }
	}
	
	public void delete(String id){
        sysWorkflowInsTaskDAO.removeSysWorkflowInsTask(id);
		CmsUtil.deleteFile("glp_study/"+ id);	
	}
	
	public  List<SysWorkflowInsTask> getSysWorkflowInsTaskListOfQuery(Map queryFields){
		return sysWorkflowInsTaskDAO.getSysWorkflowInsTaskListOfQuery(queryFields);
	}
	
	public  SysWorkflowInsTask getSysWorkflowInsTask(String id){
		return sysWorkflowInsTaskDAO.getSysWorkflowInsTask(id);
	}
	
	public SysWorkflowInsTask saveSysWorkflowInsTask(SysWorkflowInsTask sysWorkflowInsTask){
		return sysWorkflowInsTaskDAO.saveSysWorkflowInsTask(sysWorkflowInsTask);
	}
	

    public SysWorkflowInsTask saveAll(SysWorkflowInsTask sysWorkflowInsTask ){
		return sysWorkflowInsTask;
	}
	
	public void deleteAll(List<SysWorkflowInsTask> sysWorkflowInsTasks){
		for (int i = sysWorkflowInsTasks.size() - 1; i >= 0 ; i--){
			SysWorkflowInsTask sysWorkflowInsTask = sysWorkflowInsTasks.get(i);
			if (sysWorkflowInsTask.is_checked_flag()){
				delete(sysWorkflowInsTask.getId());
				sysWorkflowInsTasks.remove(i);
			}
		}
	}
	
}
