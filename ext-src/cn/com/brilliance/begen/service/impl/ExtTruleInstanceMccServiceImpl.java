package cn.com.brilliance.begen.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;

public class ExtTruleInstanceMccServiceImpl implements ExtTruleInstanceMccService{

	private ExtTruleInstanceMccDAO extTruleInstanceMccDAO = null;

	public ExtTruleInstanceMccDAO getExtTruleInstanceMccDAO() {
		return extTruleInstanceMccDAO;
	}

	public void setExtTruleInstanceMccDAO(ExtTruleInstanceMccDAO truleInstanceMccDAO) {
		this.extTruleInstanceMccDAO = truleInstanceMccDAO;
	}

	public List<ExtTruleInstanceMcc> init(ExtTruleInstanceMcc truleInstanceMcc,Map queryFields){
        if (truleInstanceMcc != null) {
            return extTruleInstanceMccDAO.getExtTruleInstanceMccList(truleInstanceMcc);
        }
        else {
            return getExtTruleInstanceMccListOfQuery(queryFields);
        }
	}
	
	public void delete(String id){
		extTruleInstanceMccDAO.removeExtTruleInstanceMcc(id);
		CmsUtil.deleteFile("glp_study/"+ id);	
	}
	
	public  List<ExtTruleInstanceMcc> getExtTruleInstanceMccListOfQuery(Map queryFields){
		return extTruleInstanceMccDAO.getExtTruleInstanceMccListOfQuery(queryFields);
	}
	
	public  ExtTruleInstanceMcc getExtTruleInstanceMcc(String id){
		return extTruleInstanceMccDAO.getExtTruleInstanceMcc(id);
	}
	
	public ExtTruleInstanceMcc saveExtTruleInstanceMcc(ExtTruleInstanceMcc truleInstanceMcc){
		return extTruleInstanceMccDAO.saveExtTruleInstanceMcc(truleInstanceMcc);
	}
	

    public ExtTruleInstanceMcc saveAll(ExtTruleInstanceMcc truleInstanceMcc ){
		return truleInstanceMcc;
	}
	
	public void deleteAll(List<ExtTruleInstanceMcc> truleInstanceMccs){
		for (int i = truleInstanceMccs.size() - 1; i >= 0 ; i--){
			ExtTruleInstanceMcc truleInstanceMcc = truleInstanceMccs.get(i);
			if (truleInstanceMcc.is_checked_flag()){
				delete(truleInstanceMcc.getId());
				truleInstanceMccs.remove(i);
			}
		}
	}
	
}
