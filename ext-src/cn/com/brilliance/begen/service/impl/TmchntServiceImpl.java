package cn.com.brilliance.begen.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;

public class TmchntServiceImpl implements TmchntService{

	private TmchntDAO tmchntDAO = null;

	public TmchntDAO getTmchntDAO() {
		return tmchntDAO;
	}

	public void setTmchntDAO(TmchntDAO tmchntDAO) {
		this.tmchntDAO = tmchntDAO;
	}

	public List<Tmchnt> init(Tmchnt tmchnt,Map queryFields){
        if (tmchnt != null) {
            return tmchntDAO.getTmchntList(tmchnt);
        }
        else {
            return getTmchntListOfQuery(queryFields);
        }
	}
	
	public void delete(String id){
        tmchntDAO.removeTmchnt(id);
		CmsUtil.deleteFile("glp_study/"+ id);	
	}
	
	public  List<Tmchnt> getTmchntListOfQuery(Map queryFields){
		return tmchntDAO.getTmchntListOfQuery(queryFields);
	}
	
	public  Tmchnt getTmchnt(String id){
		return tmchntDAO.getTmchnt(id);
	}
	
	public Tmchnt saveTmchnt(Tmchnt tmchnt){
		return tmchntDAO.saveTmchnt(tmchnt);
	}
	

    public Tmchnt saveAll(Tmchnt tmchnt ,List<String> tmchntAppDeleteList,List<TmchntApp> tmchntApps){
		tmchnt = saveTmchnt(tmchnt);
    	TmchntAppService tmchntAppservice = (TmchntAppService)Tools.getBean("tmchntAppService");
    	for(String id : tmchntAppDeleteList){
    		tmchntAppservice.delete(id);
    	}		
		if(tmchntApps != null){
			for(TmchntApp tmchntApp : tmchntApps){    		
        		if (tmchntApp.get_edit_flag() == TmchntApp.EDIT_FLAG_ADD || tmchntApp.get_edit_flag() == TmchntApp.EDIT_FLAG_EDIT){
           			tmchntApp.setMchntId(tmchnt.getId());
        			tmchntAppservice.saveTmchntApp(tmchntApp);
        		}
        	}
		}	
		return tmchnt;
	}
	
	public void deleteAll(List<Tmchnt> tmchnts){
		for (int i = tmchnts.size() - 1; i >= 0 ; i--){
			Tmchnt tmchnt = tmchnts.get(i);
			if (tmchnt.is_checked_flag()){
				delete(tmchnt.getId());
				tmchnts.remove(i);
			}
		}
	}
	
	/**
	 * �����̻�idȡ�̻���Ӧ�ý����ʺ�
	 */
	public String getTmchntAccountNo(String id){
		
		return tmchntDAO.getTmchntAccountNo(id);
	}
	
	/**
	 *  �������̻���Ϣ
	 */
	public void saveKeoMchnt(TkeoMchnt keoMchnt){
		TkeoMchntDAO  tkeoMchntdao = null;
		tkeoMchntdao.saveTkeoMchnt(keoMchnt);
		
	}
	/**
	 * �����̻�ID,���������Լ��������Ͳ�ѯ�̻������Ϣ
	 */
	public TkeoMchnt getKeoMchnt(String merId, String orgId,String type){
		TkeoMchnt tkoMchnt = new TkeoMchnt();
		TkeoMchntDAO  tkeoMchntdao = null;
		
		tkoMchnt = tkeoMchntdao.getKeoMchntByMerId(merId,type);
		
		return tkoMchnt;
		
	}
	
	public Tmchnt getTmchntByName(String merNo, String subinst, String netWorkTransfer){
		return tmchntDAO.getTmchntByName(merNo,subinst,netWorkTransfer);
	}
	
	
	public List<Tmchnt> getMerListOfQuery(int firstpage, int pagesize,Map queryFields){
		return tmchntDAO.getMerListOfQuery(firstpage, pagesize,queryFields);
	}
	
	public int getMerListOfQueryNumber(Map queryFields){
		return tmchntDAO.getMerListOfQueryNumber(queryFields);
	}
	
	public int getTmchntListOfQueryCount(Map queryFields){
		return tmchntDAO.getTmchntListOfQueryCount(queryFields);
	}
}
