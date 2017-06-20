package cn.com.brilliance.begen.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;

public class TmccServiceImpl implements TmccService{

	private TmccDAO tmccDAO = null;

	public TmccDAO getTmccDAO() {
		return tmccDAO;
	}

	public void setTmccDAO(TmccDAO tmccDAO) {
		this.tmccDAO = tmccDAO;
	}

	public List<Tmcc> init(Tmcc tmcc,Map queryFields){
        if (tmcc != null) {
            return tmccDAO.getTmccList(tmcc);
        }
        else {
            return getTmccListOfQuery(queryFields);
        }
	}
	
	public void delete(String id){
        tmccDAO.removeTmcc(id);
		CmsUtil.deleteFile("glp_study/"+ id);	
	}
	
	public  List<Tmcc> getTmccListOfQuery(Map queryFields){
		return tmccDAO.getTmccListOfQuery(queryFields);
	}
	
	public  Tmcc getTmcc(String id){
		return tmccDAO.getTmcc(id);
	}
	
	public Tmcc saveTmcc(Tmcc tmcc){
		return tmccDAO.saveTmcc(tmcc);
	}
	

    public Tmcc saveAll(Tmcc tmcc ){
		return tmcc;
	}
	
	public void deleteAll(List<Tmcc> tmccs){
		for (int i = tmccs.size() - 1; i >= 0 ; i--){
			Tmcc tmcc = tmccs.get(i);
			if (tmcc.is_checked_flag()){
				delete(tmcc.getId());
				tmccs.remove(i);
			}
		}
	}
	
}
