package cn.com.brilliance.begen.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;

public class TruleServiceImpl implements TruleService{

	private TruleDAO truleDAO = null;

	public TruleDAO getTruleDAO() {
		return truleDAO;
	}

	public void setTruleDAO(TruleDAO truleDAO) {
		this.truleDAO = truleDAO;
	}

	public List<Trule> init(Trule trule,Map queryFields){
        if (trule != null) {
            return truleDAO.getTruleList(trule);
        }
        else {
            return getTruleListOfQuery(queryFields);
        }
	}
	
	public void delete(String id){
        truleDAO.removeTrule(id);
		CmsUtil.deleteFile("glp_study/"+ id);	
	}
	
	public  List<Trule> getTruleListOfQuery(Map queryFields){
		return truleDAO.getTruleListOfQuery(queryFields);
	}
	
	public  Trule getTrule(String id){
		return truleDAO.getTrule(id);
	}
	
	public Trule saveTrule(Trule trule){
		return truleDAO.saveTrule(trule);
	}
	

    public Trule saveAll(Trule trule ){
		return trule;
	}
	
	public void deleteAll(List<Trule> trules){
		for (int i = trules.size() - 1; i >= 0 ; i--){
			Trule trule = trules.get(i);
			if (trule.is_checked_flag()){
				delete(trule.getId());
				trules.remove(i);
			}
		}
	}
	
}
