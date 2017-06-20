package cn.com.brilliance.begen.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;

public class TorganizeUserServiceImpl implements TorganizeUserService{

	private TorganizeUserDAO torganizeUserDAO = null;

	public TorganizeUserDAO getTorganizeUserDAO() {
		return torganizeUserDAO;
	}

	public void setTorganizeUserDAO(TorganizeUserDAO torganizeUserDAO) {
		this.torganizeUserDAO = torganizeUserDAO;
	}

	public List<TorganizeUser> init(TorganizeUser torganizeUser,Map queryFields){
        if (torganizeUser != null) {
            return torganizeUserDAO.getTorganizeUserList(torganizeUser);
        }
        else {
            return getTorganizeUserListOfQuery(queryFields);
        }
	}
	
	public void delete(String id){
        torganizeUserDAO.removeTorganizeUser(id);
		CmsUtil.deleteFile("glp_study/"+ id);	
	}
	
	public  List<TorganizeUser> getTorganizeUserListOfQuery(Map queryFields){
		return torganizeUserDAO.getTorganizeUserListOfQuery(queryFields);
	}
	
	public  TorganizeUser getTorganizeUser(String id){
		return torganizeUserDAO.getTorganizeUser(id);
	}
	
	public TorganizeUser saveTorganizeUser(TorganizeUser torganizeUser){
		return torganizeUserDAO.saveTorganizeUser(torganizeUser);
	}
	

    public TorganizeUser saveAll(TorganizeUser torganizeUser ){
		return torganizeUser;
	}
	
	public void deleteAll(List<TorganizeUser> torganizeUsers){
		for (int i = torganizeUsers.size() - 1; i >= 0 ; i--){
			TorganizeUser torganizeUser = torganizeUsers.get(i);
			if (torganizeUser.is_checked_flag()){
				delete(torganizeUser.getId());
				torganizeUsers.remove(i);
			}
		}
	}
	
}
