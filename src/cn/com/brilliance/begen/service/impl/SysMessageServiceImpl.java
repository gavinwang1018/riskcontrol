package cn.com.brilliance.begen.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;

public class SysMessageServiceImpl implements SysMessageService{

	private SysMessageDAO sysMessageDAO = null;

	public SysMessageDAO getSysMessageDAO() {
		return sysMessageDAO;
	}

	public void setSysMessageDAO(SysMessageDAO sysMessageDAO) {
		this.sysMessageDAO = sysMessageDAO;
	}

	public List<SysMessage> init(SysMessage sysMessage,Map queryFields){
        if (sysMessage != null) {
            return sysMessageDAO.getSysMessageList(sysMessage);
        }
        else {
            return getSysMessageListOfQuery(queryFields);
        }
	}
	
	public void delete(String id){
        sysMessageDAO.removeSysMessage(id);
		CmsUtil.deleteFile("glp_study/"+ id);	
	}
	
	public  List<SysMessage> getSysMessageListOfQuery(Map queryFields){
		return sysMessageDAO.getSysMessageListOfQuery(queryFields);
	}
	
	public  SysMessage getSysMessage(String id){
		return sysMessageDAO.getSysMessage(id);
	}
	
	public SysMessage saveSysMessage(SysMessage sysMessage){
		return sysMessageDAO.saveSysMessage(sysMessage);
	}
	

    public SysMessage saveAll(SysMessage sysMessage ){
		return sysMessage;
	}
	
	public void deleteAll(List<SysMessage> sysMessages){
		for (int i = sysMessages.size() - 1; i >= 0 ; i--){
			SysMessage sysMessage = sysMessages.get(i);
			if (sysMessage.is_checked_flag()){
				delete(sysMessage.getId());
				sysMessages.remove(i);
			}
		}
	}
	
}
