package cn.com.brilliance.begen.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;

public class TriskcaseLogServiceImpl implements TriskcaseLogService{

	private TriskcaseLogDAO triskcaseLogDAO = null;

	public TriskcaseLogDAO getTriskcaseLogDAO() {
		return triskcaseLogDAO;
	}

	public void setTriskcaseLogDAO(TriskcaseLogDAO triskcaseLogDAO) {
		this.triskcaseLogDAO = triskcaseLogDAO;
	}

	public List<TriskcaseLog> init(TriskcaseLog triskcaseLog,Map queryFields){
        if (triskcaseLog != null) {
            return triskcaseLogDAO.getTriskcaseLogList(triskcaseLog);
        }
        else {
            return getTriskcaseLogListOfQuery(queryFields);
        }
	}
	
	public void delete(String id){
        triskcaseLogDAO.removeTriskcaseLog(id);
		CmsUtil.deleteFile("glp_study/"+ id);	
	}
	
	public  List<TriskcaseLog> getTriskcaseLogListOfQuery(Map queryFields){
		return triskcaseLogDAO.getTriskcaseLogListOfQuery(queryFields);
	}
	
	public  TriskcaseLog getTriskcaseLog(String id){
		return triskcaseLogDAO.getTriskcaseLog(id);
	}
	
	public TriskcaseLog saveTriskcaseLog(TriskcaseLog triskcaseLog){
		return triskcaseLogDAO.saveTriskcaseLog(triskcaseLog);
	}
	

    public TriskcaseLog saveAll(TriskcaseLog triskcaseLog ){
		return triskcaseLog;
	}
	
	public void deleteAll(List<TriskcaseLog> triskcaseLogs){
		for (int i = triskcaseLogs.size() - 1; i >= 0 ; i--){
			TriskcaseLog triskcaseLog = triskcaseLogs.get(i);
			if (triskcaseLog.is_checked_flag()){
				delete(triskcaseLog.getId());
				triskcaseLogs.remove(i);
			}
		}
	}
	
}
