package cn.com.brilliance.begen.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;

public class SysWorkflowInsProcServiceImpl implements SysWorkflowInsProcService{

	private SysWorkflowInsProcDAO sysWorkflowInsProcDAO = null;

	public SysWorkflowInsProcDAO getSysWorkflowInsProcDAO() {
		return sysWorkflowInsProcDAO;
	}

	public void setSysWorkflowInsProcDAO(SysWorkflowInsProcDAO sysWorkflowInsProcDAO) {
		this.sysWorkflowInsProcDAO = sysWorkflowInsProcDAO;
	}

	public List<SysWorkflowInsProc> init(SysWorkflowInsProc sysWorkflowInsProc,Map queryFields){
        if (sysWorkflowInsProc != null) {
            return sysWorkflowInsProcDAO.getSysWorkflowInsProcList(sysWorkflowInsProc);
        }
        else {
            return getSysWorkflowInsProcListOfQuery(queryFields);
        }
	}
	
	public void delete(String id){
        sysWorkflowInsProcDAO.removeSysWorkflowInsProc(id);
		CmsUtil.deleteFile("glp_study/"+ id);	
	}
	
	public  List<SysWorkflowInsProc> getSysWorkflowInsProcListOfQuery(Map queryFields){
		return sysWorkflowInsProcDAO.getSysWorkflowInsProcListOfQuery(queryFields);
	}
	
	public  SysWorkflowInsProc getSysWorkflowInsProc(String id){
		return sysWorkflowInsProcDAO.getSysWorkflowInsProc(id);
	}
	
	public SysWorkflowInsProc saveSysWorkflowInsProc(SysWorkflowInsProc sysWorkflowInsProc){
		return sysWorkflowInsProcDAO.saveSysWorkflowInsProc(sysWorkflowInsProc);
	}
	

    public SysWorkflowInsProc saveAll(SysWorkflowInsProc sysWorkflowInsProc ,List<String> sysWorkflowInsTaskDeleteList,List<SysWorkflowInsTask> sysWorkflowInsTasks){
		sysWorkflowInsProc = saveSysWorkflowInsProc(sysWorkflowInsProc);
    	SysWorkflowInsTaskService sysWorkflowInsTaskservice = (SysWorkflowInsTaskService)Tools.getBean("sysWorkflowInsTaskService");
    	for(String id : sysWorkflowInsTaskDeleteList){
    		sysWorkflowInsTaskservice.delete(id);
    	}		
		if(sysWorkflowInsTasks != null){
			for(SysWorkflowInsTask sysWorkflowInsTask : sysWorkflowInsTasks){    		
        		if (sysWorkflowInsTask.get_edit_flag() == SysWorkflowInsTask.EDIT_FLAG_ADD || sysWorkflowInsTask.get_edit_flag() == SysWorkflowInsTask.EDIT_FLAG_EDIT){
           			sysWorkflowInsTask.setProcessInsId(sysWorkflowInsProc.getId());
        			sysWorkflowInsTaskservice.saveSysWorkflowInsTask(sysWorkflowInsTask);
        		}
        	}
		}	
		return sysWorkflowInsProc;
	}
	
	public void deleteAll(List<SysWorkflowInsProc> sysWorkflowInsProcs){
		for (int i = sysWorkflowInsProcs.size() - 1; i >= 0 ; i--){
			SysWorkflowInsProc sysWorkflowInsProc = sysWorkflowInsProcs.get(i);
			if (sysWorkflowInsProc.is_checked_flag()){
				delete(sysWorkflowInsProc.getId());
				sysWorkflowInsProcs.remove(i);
			}
		}
	}
	
}
