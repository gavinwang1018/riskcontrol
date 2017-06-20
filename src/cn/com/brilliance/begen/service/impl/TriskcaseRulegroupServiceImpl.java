package cn.com.brilliance.begen.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;

public class TriskcaseRulegroupServiceImpl implements TriskcaseRulegroupService{

	private TriskcaseRulegroupDAO triskcaseRulegroupDAO = null;

	public TriskcaseRulegroupDAO getTriskcaseRulegroupDAO() {
		return triskcaseRulegroupDAO;
	}

	public void setTriskcaseRulegroupDAO(TriskcaseRulegroupDAO triskcaseRulegroupDAO) {
		this.triskcaseRulegroupDAO = triskcaseRulegroupDAO;
	}

	public List<TriskcaseRulegroup> init(TriskcaseRulegroup triskcaseRulegroup,Map queryFields){
        if (triskcaseRulegroup != null) {
            return triskcaseRulegroupDAO.getTriskcaseRulegroupList(triskcaseRulegroup);
        }
        else {
            return getTriskcaseRulegroupListOfQuery(queryFields);
        }
	}
	
	public void delete(String id){
        triskcaseRulegroupDAO.removeTriskcaseRulegroup(id);
		CmsUtil.deleteFile("glp_study/"+ id);	
	}
	
	public  List<TriskcaseRulegroup> getTriskcaseRulegroupListOfQuery(Map queryFields){
		return triskcaseRulegroupDAO.getTriskcaseRulegroupListOfQuery(queryFields);
	}
	
	public  TriskcaseRulegroup getTriskcaseRulegroup(String id){
		return triskcaseRulegroupDAO.getTriskcaseRulegroup(id);
	}
	
	public TriskcaseRulegroup saveTriskcaseRulegroup(TriskcaseRulegroup triskcaseRulegroup){
		return triskcaseRulegroupDAO.saveTriskcaseRulegroup(triskcaseRulegroup);
	}
	

    public TriskcaseRulegroup saveAll(TriskcaseRulegroup triskcaseRulegroup ){
		return triskcaseRulegroup;
	}
	
	public void deleteAll(List<TriskcaseRulegroup> triskcaseRulegroups){
		for (int i = triskcaseRulegroups.size() - 1; i >= 0 ; i--){
			TriskcaseRulegroup triskcaseRulegroup = triskcaseRulegroups.get(i);
			if (triskcaseRulegroup.is_checked_flag()){
				delete(triskcaseRulegroup.getId());
				triskcaseRulegroups.remove(i);
			}
		}
	}
	
}
