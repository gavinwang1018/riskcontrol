package cn.com.brilliance.begen.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;

public class TroleUserServiceImpl implements TroleUserService{

	private TroleUserDAO troleUserDAO = null;

	public TroleUserDAO getTroleUserDAO() {
		return troleUserDAO;
	}

	public void setTroleUserDAO(TroleUserDAO troleUserDAO) {
		this.troleUserDAO = troleUserDAO;
	}

	public List<TroleUser> init(TroleUser troleUser,Map queryFields){
        if (troleUser != null) {
            return troleUserDAO.getTroleUserList(troleUser);
        }
        else {
            return getTroleUserListOfQuery(queryFields);
        }
	}
	
	public void delete(String id){
        troleUserDAO.removeTroleUser(id);
		CmsUtil.deleteFile("glp_study/"+ id);	
	}
	
	public  List<TroleUser> getTroleUserListOfQuery(Map queryFields){
		return troleUserDAO.getTroleUserListOfQuery(queryFields);
	}
	
	public  TroleUser getTroleUser(String id){
		return troleUserDAO.getTroleUser(id);
	}
	
	public TroleUser saveTroleUser(TroleUser troleUser){
		return troleUserDAO.saveTroleUser(troleUser);
	}
	

    public TroleUser saveAll(TroleUser troleUser ){
		return troleUser;
	}
	
	public void deleteAll(List<TroleUser> troleUsers){
		for (int i = troleUsers.size() - 1; i >= 0 ; i--){
			TroleUser troleUser = troleUsers.get(i);
			if (troleUser.is_checked_flag()){
				delete(troleUser.getId());
				troleUsers.remove(i);
			}
		}
	}
	
}
