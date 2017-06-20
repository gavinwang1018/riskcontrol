package cn.com.brilliance.begen.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;

public class TruleInstanceMccServiceImpl implements TruleInstanceMccService{

	private TruleInstanceMccDAO truleInstanceMccDAO = null;

	public TruleInstanceMccDAO getTruleInstanceMccDAO() {
		return truleInstanceMccDAO;
	}

	public void setTruleInstanceMccDAO(TruleInstanceMccDAO truleInstanceMccDAO) {
		this.truleInstanceMccDAO = truleInstanceMccDAO;
	}

	public List<TruleInstanceMcc> init(TruleInstanceMcc truleInstanceMcc,Map queryFields){
        if (truleInstanceMcc != null) {
            return truleInstanceMccDAO.getTruleInstanceMccList(truleInstanceMcc);
        }
        else {
            return getTruleInstanceMccListOfQuery(queryFields);
        }
	}
	
	public void delete(String id){
        truleInstanceMccDAO.removeTruleInstanceMcc(id);
		CmsUtil.deleteFile("glp_study/"+ id);	
	}
	
	public  List<TruleInstanceMcc> getTruleInstanceMccListOfQuery(Map queryFields){
		return truleInstanceMccDAO.getTruleInstanceMccListOfQuery(queryFields);
	}
	
	public  TruleInstanceMcc getTruleInstanceMcc(String id){
		return truleInstanceMccDAO.getTruleInstanceMcc(id);
	}
	
	public TruleInstanceMcc saveTruleInstanceMcc(TruleInstanceMcc truleInstanceMcc){
		return truleInstanceMccDAO.saveTruleInstanceMcc(truleInstanceMcc);
	}
	

    public TruleInstanceMcc saveAll(TruleInstanceMcc truleInstanceMcc ){
		return truleInstanceMcc;
	}
	
	public void deleteAll(List<TruleInstanceMcc> truleInstanceMccs){
		for (int i = truleInstanceMccs.size() - 1; i >= 0 ; i--){
			TruleInstanceMcc truleInstanceMcc = truleInstanceMccs.get(i);
			if (truleInstanceMcc.is_checked_flag()){
				delete(truleInstanceMcc.getId());
				truleInstanceMccs.remove(i);
			}
		}
	}

	public void rollback(){
		truleInstanceMccDAO.rollback();
	}
}
