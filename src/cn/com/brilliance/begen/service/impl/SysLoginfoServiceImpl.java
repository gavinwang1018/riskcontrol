package cn.com.brilliance.begen.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;

public class SysLoginfoServiceImpl implements SysLoginfoService{

	private SysLoginfoDAO sysLoginfoDAO = null;

	public SysLoginfoDAO getSysLoginfoDAO() {
		return sysLoginfoDAO;
	}

	public void setSysLoginfoDAO(SysLoginfoDAO sysLoginfoDAO) {
		this.sysLoginfoDAO = sysLoginfoDAO;
	}

	public List<SysLoginfo> init(SysLoginfo sysLoginfo,Map queryFields){
        if (sysLoginfo != null) {
            return sysLoginfoDAO.getSysLoginfoList(sysLoginfo);
        }
        else {
            return getSysLoginfoListOfQuery(queryFields);
        }
	}
	
	public void delete(String id){
        sysLoginfoDAO.removeSysLoginfo(id);
		CmsUtil.deleteFile("glp_study/"+ id);	
	}
	
	public  List<SysLoginfo> getSysLoginfoListOfQuery(Map queryFields){
		return sysLoginfoDAO.getSysLoginfoListOfQuery(queryFields);
	}
	
	public  SysLoginfo getSysLoginfo(String id){
		return sysLoginfoDAO.getSysLoginfo(id);
	}
	
	public SysLoginfo saveSysLoginfo(SysLoginfo sysLoginfo){
		return sysLoginfoDAO.saveSysLoginfo(sysLoginfo);
	}
	

    public SysLoginfo saveAll(SysLoginfo sysLoginfo ){
		return sysLoginfo;
	}
	
	public void deleteAll(List<SysLoginfo> sysLoginfos){
		for (int i = sysLoginfos.size() - 1; i >= 0 ; i--){
			SysLoginfo sysLoginfo = sysLoginfos.get(i);
			if (sysLoginfo.is_checked_flag()){
				delete(sysLoginfo.getId());
				sysLoginfos.remove(i);
			}
		}
	}
	
}
