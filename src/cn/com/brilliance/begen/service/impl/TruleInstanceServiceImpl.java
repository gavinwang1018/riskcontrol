package cn.com.brilliance.begen.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;

public class TruleInstanceServiceImpl implements TruleInstanceService{

	private TruleInstanceDAO truleInstanceDAO = null;

	public TruleInstanceDAO getTruleInstanceDAO() {
		return truleInstanceDAO;
	}

	public void setTruleInstanceDAO(TruleInstanceDAO truleInstanceDAO) {
		this.truleInstanceDAO = truleInstanceDAO;
	}

	public List<TruleInstance> init(TruleInstance truleInstance,Map queryFields){
        if (truleInstance != null) {
            return truleInstanceDAO.getTruleInstanceList(truleInstance);
        }
        else {
            return getTruleInstanceListOfQuery(queryFields);
        }
	}
	
	public void delete(String id){
        truleInstanceDAO.removeTruleInstance(id);
		CmsUtil.deleteFile("glp_study/"+ id);	
	}
	
	public  List<TruleInstance> getTruleInstanceListOfQuery(Map queryFields){
		return truleInstanceDAO.getTruleInstanceListOfQuery(queryFields);
	}
	
	public  TruleInstance getTruleInstance(String id){
		return truleInstanceDAO.getTruleInstance(id);
	}
	
	public TruleInstance saveTruleInstance(TruleInstance truleInstance){
		return truleInstanceDAO.saveTruleInstance(truleInstance);
	}
	

    public TruleInstance saveAll(TruleInstance truleInstance ){
		return truleInstance;
	}
	
	public void deleteAll(List<TruleInstance> truleInstances){
		for (int i = truleInstances.size() - 1; i >= 0 ; i--){
			TruleInstance truleInstance = truleInstances.get(i);
			if (truleInstance.is_checked_flag()){
				delete(truleInstance.getId());
				truleInstances.remove(i);
			}
		}
	}
	
	public void rollback(){
		truleInstanceDAO.rollback();
	}
	
}
