package cn.com.brilliance.begen.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;

public class SysDailyInsServiceImpl implements SysDailyInsService{

	private SysDailyInsDAO sysDailyInsDAO = null;

	public SysDailyInsDAO getSysDailyInsDAO() {
		return sysDailyInsDAO;
	}

	public void setSysDailyInsDAO(SysDailyInsDAO sysDailyInsDAO) {
		this.sysDailyInsDAO = sysDailyInsDAO;
	}

	public List<SysDailyIns> init(SysDailyIns sysDailyIns,Map queryFields){
        if (sysDailyIns != null) {
            return sysDailyInsDAO.getSysDailyInsList(sysDailyIns);
        }
        else {
            return getSysDailyInsListOfQuery(queryFields);
        }
	}
	
	public void delete(String id){
        sysDailyInsDAO.removeSysDailyIns(id);
		CmsUtil.deleteFile("glp_study/"+ id);	
	}
	
	public  List<SysDailyIns> getSysDailyInsListOfQuery(Map queryFields){
		return sysDailyInsDAO.getSysDailyInsListOfQuery(queryFields);
	}
	
	public  SysDailyIns getSysDailyIns(String id){
		return sysDailyInsDAO.getSysDailyIns(id);
	}
	
	public SysDailyIns saveSysDailyIns(SysDailyIns sysDailyIns){
		return sysDailyInsDAO.saveSysDailyIns(sysDailyIns);
	}
	

    public SysDailyIns saveAll(SysDailyIns sysDailyIns ){
		return sysDailyIns;
	}
	
	public void deleteAll(List<SysDailyIns> sysDailyInss){
		for (int i = sysDailyInss.size() - 1; i >= 0 ; i--){
			SysDailyIns sysDailyIns = sysDailyInss.get(i);
			if (sysDailyIns.is_checked_flag()){
				delete(sysDailyIns.getId());
				sysDailyInss.remove(i);
			}
		}
	}
	
}
