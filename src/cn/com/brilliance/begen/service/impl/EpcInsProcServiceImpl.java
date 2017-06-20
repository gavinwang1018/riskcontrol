package cn.com.brilliance.begen.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;

public class EpcInsProcServiceImpl implements EpcInsProcService{

	private EpcInsProcDAO epcInsProcDAO = null;

	public EpcInsProcDAO getEpcInsProcDAO() {
		return epcInsProcDAO;
	}

	public void setEpcInsProcDAO(EpcInsProcDAO epcInsProcDAO) {
		this.epcInsProcDAO = epcInsProcDAO;
	}

	public List<EpcInsProc> init(EpcInsProc epcInsProc,Map queryFields){
        if (epcInsProc != null) {
            return epcInsProcDAO.getEpcInsProcList(epcInsProc);
        }
        else {
            return getEpcInsProcListOfQuery(queryFields);
        }
	}
	
	public void delete(String id){
        epcInsProcDAO.removeEpcInsProc(id);
		CmsUtil.deleteFile("glp_study/"+ id);	
	}
	
	public  List<EpcInsProc> getEpcInsProcListOfQuery(Map queryFields){
		return epcInsProcDAO.getEpcInsProcListOfQuery(queryFields);
	}
	
	public  EpcInsProc getEpcInsProc(String id){
		return epcInsProcDAO.getEpcInsProc(id);
	}
	
	public EpcInsProc saveEpcInsProc(EpcInsProc epcInsProc){
		return epcInsProcDAO.saveEpcInsProc(epcInsProc);
	}
	

    public EpcInsProc saveAll(EpcInsProc epcInsProc ,List<String> epcInsTaskDeleteList,List<EpcInsTask> epcInsTasks){
		epcInsProc = saveEpcInsProc(epcInsProc);
    	EpcInsTaskService epcInsTaskservice = (EpcInsTaskService)Tools.getBean("epcInsTaskService");
    	for(String id : epcInsTaskDeleteList){
    		epcInsTaskservice.delete(id);
    	}		
		if(epcInsTasks != null){
			for(EpcInsTask epcInsTask : epcInsTasks){    		
        		if (epcInsTask.get_edit_flag() == EpcInsTask.EDIT_FLAG_ADD || epcInsTask.get_edit_flag() == EpcInsTask.EDIT_FLAG_EDIT){
           			epcInsTask.setProcessInsId(epcInsProc.getId());
        			epcInsTaskservice.saveEpcInsTask(epcInsTask);
        		}
        	}
		}	
		return epcInsProc;
	}
	
	public void deleteAll(List<EpcInsProc> epcInsProcs){
		for (int i = epcInsProcs.size() - 1; i >= 0 ; i--){
			EpcInsProc epcInsProc = epcInsProcs.get(i);
			if (epcInsProc.is_checked_flag()){
				delete(epcInsProc.getId());
				epcInsProcs.remove(i);
			}
		}
	}
	
}
