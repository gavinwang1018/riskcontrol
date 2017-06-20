package cn.com.brilliance.begen.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;

public class TorganizeInfoServiceImpl implements TorganizeInfoService{

	private TorganizeInfoDAO torganizeInfoDAO = null;

	public TorganizeInfoDAO getTorganizeInfoDAO() {
		return torganizeInfoDAO;
	}

	public void setTorganizeInfoDAO(TorganizeInfoDAO torganizeInfoDAO) {
		this.torganizeInfoDAO = torganizeInfoDAO;
	}

	public List<TorganizeInfo> init(TorganizeInfo torganizeInfo,Map queryFields){
        if (torganizeInfo != null) {
            return torganizeInfoDAO.getTorganizeInfoList(torganizeInfo);
        }
        else {
            return getTorganizeInfoListOfQuery(queryFields);
        }
	}
	
	public void delete(String id){
        torganizeInfoDAO.removeTorganizeInfo(id);
		CmsUtil.deleteFile("glp_study/"+ id);	
	}
	
	public  List<TorganizeInfo> getTorganizeInfoListOfQuery(Map queryFields){
		return torganizeInfoDAO.getTorganizeInfoListOfQuery(queryFields);
	}
	
	public  TorganizeInfo getTorganizeInfo(String id){
		return torganizeInfoDAO.getTorganizeInfo(id);
	}
	
	public TorganizeInfo saveTorganizeInfo(TorganizeInfo torganizeInfo){
		return torganizeInfoDAO.saveTorganizeInfo(torganizeInfo);
	}
	

    public TorganizeInfo saveAll(TorganizeInfo torganizeInfo ,List<String> tmchntAppDeleteList,List<TmchntApp> tmchntApps,List<String> triskprocessTimelimitDeleteList,List<TriskprocessTimelimit> triskprocessTimelimits){
		torganizeInfo = saveTorganizeInfo(torganizeInfo);
    	TmchntAppService tmchntAppservice = (TmchntAppService)Tools.getBean("tmchntAppService");
    	for(String id : tmchntAppDeleteList){
    		tmchntAppservice.delete(id);
    	}		
		if(tmchntApps != null){
			for(TmchntApp tmchntApp : tmchntApps){    		
        		if (tmchntApp.get_edit_flag() == TmchntApp.EDIT_FLAG_ADD || tmchntApp.get_edit_flag() == TmchntApp.EDIT_FLAG_EDIT){
           			tmchntApp.setBelongToInst(torganizeInfo.getId());
        			tmchntAppservice.saveTmchntApp(tmchntApp);
        		}
        	}
		}	
		torganizeInfo = saveTorganizeInfo(torganizeInfo);
    	TriskprocessTimelimitService triskprocessTimelimitservice = (TriskprocessTimelimitService)Tools.getBean("triskprocessTimelimitService");
    	for(String id : triskprocessTimelimitDeleteList){
    		triskprocessTimelimitservice.delete(id);
    	}		
		if(triskprocessTimelimits != null){
			for(TriskprocessTimelimit triskprocessTimelimit : triskprocessTimelimits){    		
        		if (triskprocessTimelimit.get_edit_flag() == TriskprocessTimelimit.EDIT_FLAG_ADD || triskprocessTimelimit.get_edit_flag() == TriskprocessTimelimit.EDIT_FLAG_EDIT){
           			triskprocessTimelimit.setBelongToInst(torganizeInfo.getId());
        			triskprocessTimelimitservice.saveTriskprocessTimelimit(triskprocessTimelimit);
        		}
        	}
		}	
		return torganizeInfo;
	}
	
	public void deleteAll(List<TorganizeInfo> torganizeInfos){
		for (int i = torganizeInfos.size() - 1; i >= 0 ; i--){
			TorganizeInfo torganizeInfo = torganizeInfos.get(i);
			if (torganizeInfo.is_checked_flag()){
				delete(torganizeInfo.getId());
				torganizeInfos.remove(i);
			}
		}
	}
	
}
