package cn.com.brilliance.begen.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;

public class TruleGroupServiceImpl implements TruleGroupService{

	private TruleGroupDAO truleGroupDAO = null;

	public TruleGroupDAO getTruleGroupDAO() {
		return truleGroupDAO;
	}

	public void setTruleGroupDAO(TruleGroupDAO truleGroupDAO) {
		this.truleGroupDAO = truleGroupDAO;
	}

	public List<TruleGroup> init(TruleGroup truleGroup,Map queryFields){
        if (truleGroup != null) {
            return truleGroupDAO.getTruleGroupList(truleGroup);
        }
        else {
            return getTruleGroupListOfQuery(queryFields);
        }
	}
	
	public void delete(String id){
        truleGroupDAO.removeTruleGroup(id);
		CmsUtil.deleteFile("glp_study/"+ id);	
	}
	
	public  List<TruleGroup> getTruleGroupListOfQuery(Map queryFields){
		return truleGroupDAO.getTruleGroupListOfQuery(queryFields);
	}
	
	public  TruleGroup getTruleGroup(String id){
		return truleGroupDAO.getTruleGroup(id);
	}
	
	public TruleGroup saveTruleGroup(TruleGroup truleGroup){
		return truleGroupDAO.saveTruleGroup(truleGroup);
	}
	

    public TruleGroup saveAll(TruleGroup truleGroup ){
		return truleGroup;
	}
	
	public void deleteAll(List<TruleGroup> truleGroups){
		for (int i = truleGroups.size() - 1; i >= 0 ; i--){
			TruleGroup truleGroup = truleGroups.get(i);
			if (truleGroup.is_checked_flag()){
				delete(truleGroup.getId());
				truleGroups.remove(i);
			}
		}
	}
	
}
