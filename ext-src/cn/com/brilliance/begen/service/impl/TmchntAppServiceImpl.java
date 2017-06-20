package cn.com.brilliance.begen.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;

public class TmchntAppServiceImpl implements TmchntAppService{

	private TmchntAppDAO tmchntAppDAO = null;

	public TmchntAppDAO getTmchntAppDAO() {
		return tmchntAppDAO;
	}

	public void setTmchntAppDAO(TmchntAppDAO tmchntAppDAO) {
		this.tmchntAppDAO = tmchntAppDAO;
	}

	public List<TmchntApp> init(TmchntApp tmchntApp,Map queryFields){
        if (tmchntApp != null) {
            return tmchntAppDAO.getTmchntAppList(tmchntApp);
        }
        else {
            return getTmchntAppListOfQuery(queryFields);
        }
	}
	
	public void delete(String id){
        tmchntAppDAO.removeTmchntApp(id);
		CmsUtil.deleteFile("glp_study/"+ id);	
	}
	
	public  List<TmchntApp> getTmchntAppListOfQuery(Map queryFields){
		return tmchntAppDAO.getTmchntAppListOfQuery(queryFields);
	}
	
	public  TmchntApp getTmchntApp(String id){
		return tmchntAppDAO.getTmchntApp(id);
	}
	
	public TmchntApp saveTmchntApp(TmchntApp tmchntApp){
		return tmchntAppDAO.saveTmchntApp(tmchntApp);
	}
	

    public TmchntApp saveAll(TmchntApp tmchntApp ){
		return tmchntApp;
	}
	
	public void deleteAll(List<TmchntApp> tmchntApps){
		for (int i = tmchntApps.size() - 1; i >= 0 ; i--){
			TmchntApp tmchntApp = tmchntApps.get(i);
			if (tmchntApp.is_checked_flag()){
				delete(tmchntApp.getId());
				tmchntApps.remove(i);
			}
		}
	}
	
	public String getTmchntAppMain(String id){
		return tmchntAppDAO.getTmchntAppMain(id);
	}
	
	
	
}
