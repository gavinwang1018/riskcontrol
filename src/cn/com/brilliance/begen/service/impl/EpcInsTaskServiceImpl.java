package cn.com.brilliance.begen.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;

public class EpcInsTaskServiceImpl implements EpcInsTaskService{

	private EpcInsTaskDAO epcInsTaskDAO = null;

	public EpcInsTaskDAO getEpcInsTaskDAO() {
		return epcInsTaskDAO;
	}

	public void setEpcInsTaskDAO(EpcInsTaskDAO epcInsTaskDAO) {
		this.epcInsTaskDAO = epcInsTaskDAO;
	}

	public List<EpcInsTask> init(EpcInsTask epcInsTask,Map queryFields){
        if (epcInsTask != null) {
            return epcInsTaskDAO.getEpcInsTaskList(epcInsTask);
        }
        else {
            return getEpcInsTaskListOfQuery(queryFields);
        }
	}
	
	public void delete(String id){
        epcInsTaskDAO.removeEpcInsTask(id);
		CmsUtil.deleteFile("glp_study/"+ id);	
	}
	
	public  List<EpcInsTask> getEpcInsTaskListOfQuery(Map queryFields){
		return epcInsTaskDAO.getEpcInsTaskListOfQuery(queryFields);
	}
	
	public  EpcInsTask getEpcInsTask(String id){
		return epcInsTaskDAO.getEpcInsTask(id);
	}
	
	public EpcInsTask saveEpcInsTask(EpcInsTask epcInsTask){
		return epcInsTaskDAO.saveEpcInsTask(epcInsTask);
	}
	

    public EpcInsTask saveAll(EpcInsTask epcInsTask ){
		return epcInsTask;
	}
	
	public void deleteAll(List<EpcInsTask> epcInsTasks){
		for (int i = epcInsTasks.size() - 1; i >= 0 ; i--){
			EpcInsTask epcInsTask = epcInsTasks.get(i);
			if (epcInsTask.is_checked_flag()){
				delete(epcInsTask.getId());
				epcInsTasks.remove(i);
			}
		}
	}
	
}
