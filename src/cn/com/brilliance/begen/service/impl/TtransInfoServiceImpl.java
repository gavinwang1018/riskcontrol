package cn.com.brilliance.begen.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;

public class TtransInfoServiceImpl implements TtransInfoService{

	private TtransInfoDAO ttransInfoDAO = null;

	public TtransInfoDAO getTtransInfoDAO() {
		return ttransInfoDAO;
	}

	public void setTtransInfoDAO(TtransInfoDAO ttransInfoDAO) {
		this.ttransInfoDAO = ttransInfoDAO;
	}

	public List<TtransInfo> init(TtransInfo ttransInfo,Map queryFields){
        if (ttransInfo != null) {
            return ttransInfoDAO.getTtransInfoList(ttransInfo);
        }
        else {
            return getTtransInfoListOfQuery(queryFields);
        }
	}
	
	public void delete(String id){
        ttransInfoDAO.removeTtransInfo(id);
		CmsUtil.deleteFile("glp_study/"+ id);	
	}
	
	public  List<TtransInfo> getTtransInfoListOfQuery(Map queryFields){
		return ttransInfoDAO.getTtransInfoListOfQuery(queryFields);
	}
	
	public  TtransInfo getTtransInfo(String id){
		return ttransInfoDAO.getTtransInfo(id);
	}
	
	public TtransInfo saveTtransInfo(TtransInfo ttransInfo){
		return ttransInfoDAO.saveTtransInfo(ttransInfo);
	}
	

    public TtransInfo saveAll(TtransInfo ttransInfo ){
		return ttransInfo;
	}
	
	public void deleteAll(List<TtransInfo> ttransInfos){
		for (int i = ttransInfos.size() - 1; i >= 0 ; i--){
			TtransInfo ttransInfo = ttransInfos.get(i);
			if (ttransInfo.is_checked_flag()){
				delete(ttransInfo.getId());
				ttransInfos.remove(i);
			}
		}
	}
	
	public int getTtransInfoListOfQueryCount(Map queryFields){
		return ttransInfoDAO.getTmchntListOfQueryCount(queryFields);
	}
	
}
