package cn.com.brilliance.begen.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;

public class TuserInfoServiceImpl implements TuserInfoService{

	private TuserInfoDAO tuserInfoDAO = null;

	public TuserInfoDAO getTuserInfoDAO() {
		return tuserInfoDAO;
	}

	public void setTuserInfoDAO(TuserInfoDAO tuserInfoDAO) {
		this.tuserInfoDAO = tuserInfoDAO;
	}

	public List<TuserInfo> init(TuserInfo tuserInfo,Map queryFields){
        if (tuserInfo != null) {
            return tuserInfoDAO.getTuserInfoList(tuserInfo);
        }
        else {
            return getTuserInfoListOfQuery(queryFields);
        }
	}
	
	public void delete(String id){
        tuserInfoDAO.removeTuserInfo(id);
		CmsUtil.deleteFile("glp_study/"+ id);	
	}
	
	public  List<TuserInfo> getTuserInfoListOfQuery(Map queryFields){
		return tuserInfoDAO.getTuserInfoListOfQuery(queryFields);
	}
	
	public  TuserInfo getTuserInfo(String id){
		return tuserInfoDAO.getTuserInfo(id);
	}
	
	public TuserInfo saveTuserInfo(TuserInfo tuserInfo){
		return tuserInfoDAO.saveTuserInfo(tuserInfo);
	}
	

    public TuserInfo saveAll(TuserInfo tuserInfo ){
		return tuserInfo;
	}
	
	public void deleteAll(List<TuserInfo> tuserInfos){
		for (int i = tuserInfos.size() - 1; i >= 0 ; i--){
			TuserInfo tuserInfo = tuserInfos.get(i);
			if (tuserInfo.is_checked_flag()){
				delete(tuserInfo.getId());
				tuserInfos.remove(i);
			}
		}
	}
	
}
