package cn.com.brilliance.begen.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;

public class TcardbinServiceImpl implements TcardbinService{

	private TcardbinDAO tcardbinDAO = null;

	public TcardbinDAO getTcardbinDAO() {
		return tcardbinDAO;
	}

	public void setTcardbinDAO(TcardbinDAO tcardbinDAO) {
		this.tcardbinDAO = tcardbinDAO;
	}

	public List<Tcardbin> init(Tcardbin tcardbin,Map queryFields){
        if (tcardbin != null) {
            return tcardbinDAO.getTcardbinList(tcardbin);
        }
        else {
            return getTcardbinListOfQuery(queryFields);
        }
	}
	
	public void delete(String id){
        tcardbinDAO.removeTcardbin(id);
		CmsUtil.deleteFile("glp_study/"+ id);	
	}
	
	public  List<Tcardbin> getTcardbinListOfQuery(Map queryFields){
		return tcardbinDAO.getTcardbinListOfQuery(queryFields);
	}
	
	public  Tcardbin getTcardbin(String id){
		return tcardbinDAO.getTcardbin(id);
	}
	
	public Tcardbin saveTcardbin(Tcardbin tcardbin){
		return tcardbinDAO.saveTcardbin(tcardbin);
	}
	

    public Tcardbin saveAll(Tcardbin tcardbin ){
		return tcardbin;
	}
	
	public void deleteAll(List<Tcardbin> tcardbins){
		for (int i = tcardbins.size() - 1; i >= 0 ; i--){
			Tcardbin tcardbin = tcardbins.get(i);
			if (tcardbin.is_checked_flag()){
				delete(tcardbin.getId());
				tcardbins.remove(i);
			}
		}
	}
	
}
