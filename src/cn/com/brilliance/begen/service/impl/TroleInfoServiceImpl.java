package cn.com.brilliance.begen.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;

public class TroleInfoServiceImpl implements TroleInfoService{

	private TroleInfoDAO troleInfoDAO = null;

	public TroleInfoDAO getTroleInfoDAO() {
		return troleInfoDAO;
	}

	public void setTroleInfoDAO(TroleInfoDAO troleInfoDAO) {
		this.troleInfoDAO = troleInfoDAO;
	}

	public List<TroleInfo> init(TroleInfo troleInfo,Map queryFields){
        if (troleInfo != null) {
            return troleInfoDAO.getTroleInfoList(troleInfo);
        }
        else {
            return getTroleInfoListOfQuery(queryFields);
        }
	}
	
	public void delete(String id){
        troleInfoDAO.removeTroleInfo(id);
		CmsUtil.deleteFile("glp_study/"+ id);	
	}
	
	public  List<TroleInfo> getTroleInfoListOfQuery(Map queryFields){
		return troleInfoDAO.getTroleInfoListOfQuery(queryFields);
	}
	
	public  TroleInfo getTroleInfo(String id){
		return troleInfoDAO.getTroleInfo(id);
	}
	
	public TroleInfo saveTroleInfo(TroleInfo troleInfo){
		return troleInfoDAO.saveTroleInfo(troleInfo);
	}
	

    public TroleInfo saveAll(TroleInfo troleInfo ){
		return troleInfo;
	}
	
	public void deleteAll(List<TroleInfo> troleInfos){
		for (int i = troleInfos.size() - 1; i >= 0 ; i--){
			TroleInfo troleInfo = troleInfos.get(i);
			if (troleInfo.is_checked_flag()){
				delete(troleInfo.getId());
				troleInfos.remove(i);
			}
		}
	}
	
}
