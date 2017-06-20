package cn.com.brilliance.begen.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;

public class TriskprocessTimelimitServiceImpl implements TriskprocessTimelimitService{

	private TriskprocessTimelimitDAO triskprocessTimelimitDAO = null;

	public TriskprocessTimelimitDAO getTriskprocessTimelimitDAO() {
		return triskprocessTimelimitDAO;
	}

	public void setTriskprocessTimelimitDAO(TriskprocessTimelimitDAO triskprocessTimelimitDAO) {
		this.triskprocessTimelimitDAO = triskprocessTimelimitDAO;
	}

	public List<TriskprocessTimelimit> init(TriskprocessTimelimit triskprocessTimelimit,Map queryFields){
        if (triskprocessTimelimit != null) {
            return triskprocessTimelimitDAO.getTriskprocessTimelimitList(triskprocessTimelimit);
        }
        else {
            return getTriskprocessTimelimitListOfQuery(queryFields);
        }
	}
	
	public void delete(String id){
        triskprocessTimelimitDAO.removeTriskprocessTimelimit(id);
		CmsUtil.deleteFile("glp_study/"+ id);	
	}
	
	public  List<TriskprocessTimelimit> getTriskprocessTimelimitListOfQuery(Map queryFields){
		return triskprocessTimelimitDAO.getTriskprocessTimelimitListOfQuery(queryFields);
	}
	
	public  TriskprocessTimelimit getTriskprocessTimelimit(String id){
		return triskprocessTimelimitDAO.getTriskprocessTimelimit(id);
	}
	
	public TriskprocessTimelimit saveTriskprocessTimelimit(TriskprocessTimelimit triskprocessTimelimit){
		return triskprocessTimelimitDAO.saveTriskprocessTimelimit(triskprocessTimelimit);
	}
	

    public TriskprocessTimelimit saveAll(TriskprocessTimelimit triskprocessTimelimit ){
		return triskprocessTimelimit;
	}
	
	public void deleteAll(List<TriskprocessTimelimit> triskprocessTimelimits){
		for (int i = triskprocessTimelimits.size() - 1; i >= 0 ; i--){
			TriskprocessTimelimit triskprocessTimelimit = triskprocessTimelimits.get(i);
			if (triskprocessTimelimit.is_checked_flag()){
				delete(triskprocessTimelimit.getId());
				triskprocessTimelimits.remove(i);
			}
		}
	}
	
}
