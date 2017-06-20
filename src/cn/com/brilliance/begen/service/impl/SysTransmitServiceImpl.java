package cn.com.brilliance.begen.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;

public class SysTransmitServiceImpl implements SysTransmitService{

	private SysTransmitDAO sysTransmitDAO = null;

	public SysTransmitDAO getSysTransmitDAO() {
		return sysTransmitDAO;
	}

	public void setSysTransmitDAO(SysTransmitDAO sysTransmitDAO) {
		this.sysTransmitDAO = sysTransmitDAO;
	}

	public List<SysTransmit> init(SysTransmit sysTransmit,Map queryFields){
        if (sysTransmit != null) {
            return sysTransmitDAO.getSysTransmitList(sysTransmit);
        }
        else {
            return getSysTransmitListOfQuery(queryFields);
        }
	}
	
	public void delete(String id){
        sysTransmitDAO.removeSysTransmit(id);
		CmsUtil.deleteFile("glp_study/"+ id);	
	}
	
	public  List<SysTransmit> getSysTransmitListOfQuery(Map queryFields){
		return sysTransmitDAO.getSysTransmitListOfQuery(queryFields);
	}
	
	public  SysTransmit getSysTransmit(String id){
		return sysTransmitDAO.getSysTransmit(id);
	}
	
	public SysTransmit saveSysTransmit(SysTransmit sysTransmit){
		return sysTransmitDAO.saveSysTransmit(sysTransmit);
	}
	

    public SysTransmit saveAll(SysTransmit sysTransmit ,List<String> sysTransmitDetailDeleteList,List<SysTransmitDetail> sysTransmitDetails){
		sysTransmit = saveSysTransmit(sysTransmit);
    	SysTransmitDetailService sysTransmitDetailservice = (SysTransmitDetailService)Tools.getBean("sysTransmitDetailService");
    	for(String id : sysTransmitDetailDeleteList){
    		sysTransmitDetailservice.delete(id);
    	}		
		if(sysTransmitDetails != null){
			for(SysTransmitDetail sysTransmitDetail : sysTransmitDetails){    		
        		if (sysTransmitDetail.get_edit_flag() == SysTransmitDetail.EDIT_FLAG_ADD || sysTransmitDetail.get_edit_flag() == SysTransmitDetail.EDIT_FLAG_EDIT){
           			sysTransmitDetail.setTransmitId(sysTransmit.getId());
        			sysTransmitDetailservice.saveSysTransmitDetail(sysTransmitDetail);
        		}
        	}
		}	
		return sysTransmit;
	}
	
	public void deleteAll(List<SysTransmit> sysTransmits){
		for (int i = sysTransmits.size() - 1; i >= 0 ; i--){
			SysTransmit sysTransmit = sysTransmits.get(i);
			if (sysTransmit.is_checked_flag()){
				delete(sysTransmit.getId());
				sysTransmits.remove(i);
			}
		}
	}
	
}
