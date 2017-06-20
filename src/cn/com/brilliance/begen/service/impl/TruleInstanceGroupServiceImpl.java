package cn.com.brilliance.begen.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;

public class TruleInstanceGroupServiceImpl implements TruleInstanceGroupService{

	private TruleInstanceGroupDAO truleInstanceGroupDAO = null;

	public TruleInstanceGroupDAO getTruleInstanceGroupDAO() {
		return truleInstanceGroupDAO;
	}

	public void setTruleInstanceGroupDAO(TruleInstanceGroupDAO truleInstanceGroupDAO) {
		this.truleInstanceGroupDAO = truleInstanceGroupDAO;
	}

	public List<TruleInstanceGroup> init(TruleInstanceGroup truleInstanceGroup,Map queryFields){
        if (truleInstanceGroup != null) {
            return truleInstanceGroupDAO.getTruleInstanceGroupList(truleInstanceGroup);
        }
        else {
            return getTruleInstanceGroupListOfQuery(queryFields);
        }
	}
	
	public void delete(String id){
        truleInstanceGroupDAO.removeTruleInstanceGroup(id);
		CmsUtil.deleteFile("glp_study/"+ id);	
	}
	
	public  List<TruleInstanceGroup> getTruleInstanceGroupListOfQuery(Map queryFields){
		return truleInstanceGroupDAO.getTruleInstanceGroupListOfQuery(queryFields);
	}
	
	public  TruleInstanceGroup getTruleInstanceGroup(String id){
		return truleInstanceGroupDAO.getTruleInstanceGroup(id);
	}
	
	public TruleInstanceGroup saveTruleInstanceGroup(TruleInstanceGroup truleInstanceGroup){
		return truleInstanceGroupDAO.saveTruleInstanceGroup(truleInstanceGroup);
	}
	

    public TruleInstanceGroup saveAll(TruleInstanceGroup truleInstanceGroup ){
		return truleInstanceGroup;
	}
	
	public void deleteAll(List<TruleInstanceGroup> truleInstanceGroups){
		for (int i = truleInstanceGroups.size() - 1; i >= 0 ; i--){
			TruleInstanceGroup truleInstanceGroup = truleInstanceGroups.get(i);
			if (truleInstanceGroup.is_checked_flag()){
				delete(truleInstanceGroup.getId());
				truleInstanceGroups.remove(i);
			}
		}
	}
	
}
