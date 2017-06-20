package cn.com.brilliance.begen.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;

public class SysTransmitDetailServiceImpl implements SysTransmitDetailService{

	private SysTransmitDetailDAO sysTransmitDetailDAO = null;

	public SysTransmitDetailDAO getSysTransmitDetailDAO() {
		return sysTransmitDetailDAO;
	}

	public void setSysTransmitDetailDAO(SysTransmitDetailDAO sysTransmitDetailDAO) {
		this.sysTransmitDetailDAO = sysTransmitDetailDAO;
	}

	public List<SysTransmitDetail> init(SysTransmitDetail sysTransmitDetail,Map queryFields){
        if (sysTransmitDetail != null) {
            return sysTransmitDetailDAO.getSysTransmitDetailList(sysTransmitDetail);
        }
        else {
            return getSysTransmitDetailListOfQuery(queryFields);
        }
	}
	
	public void delete(String id){
        sysTransmitDetailDAO.removeSysTransmitDetail(id);
		CmsUtil.deleteFile("glp_study/"+ id);	
	}
	
	public  List<SysTransmitDetail> getSysTransmitDetailListOfQuery(Map queryFields){
		return sysTransmitDetailDAO.getSysTransmitDetailListOfQuery(queryFields);
	}
	
	public  SysTransmitDetail getSysTransmitDetail(String id){
		return sysTransmitDetailDAO.getSysTransmitDetail(id);
	}
	
	public SysTransmitDetail saveSysTransmitDetail(SysTransmitDetail sysTransmitDetail){
		return sysTransmitDetailDAO.saveSysTransmitDetail(sysTransmitDetail);
	}
	

    public SysTransmitDetail saveAll(SysTransmitDetail sysTransmitDetail ){
		return sysTransmitDetail;
	}
	
	public void deleteAll(List<SysTransmitDetail> sysTransmitDetails){
		for (int i = sysTransmitDetails.size() - 1; i >= 0 ; i--){
			SysTransmitDetail sysTransmitDetail = sysTransmitDetails.get(i);
			if (sysTransmitDetail.is_checked_flag()){
				delete(sysTransmitDetail.getId());
				sysTransmitDetails.remove(i);
			}
		}
	}
	
}
