package cn.com.brilliance.begen.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;

public class TpermissionServiceImpl implements TpermissionService{

	private TpermissionDAO tpermissionDAO = null;

	public TpermissionDAO getTpermissionDAO() {
		return tpermissionDAO;
	}

	public void setTpermissionDAO(TpermissionDAO tpermissionDAO) {
		this.tpermissionDAO = tpermissionDAO;
	}

	public List<Tpermission> init(Tpermission tpermission,Map queryFields){
        if (tpermission != null) {
            return tpermissionDAO.getTpermissionList(tpermission);
        }
        else {
            return getTpermissionListOfQuery(queryFields);
        }
	}
	
	public void delete(String id){
        tpermissionDAO.removeTpermission(id);
		CmsUtil.deleteFile("glp_study/"+ id);	
	}
	
	public  List<Tpermission> getTpermissionListOfQuery(Map queryFields){
		return tpermissionDAO.getTpermissionListOfQuery(queryFields);
	}
	
	public  Tpermission getTpermission(String id){
		return tpermissionDAO.getTpermission(id);
	}
	
	public Tpermission saveTpermission(Tpermission tpermission){
		return tpermissionDAO.saveTpermission(tpermission);
	}
	

    public Tpermission saveAll(Tpermission tpermission ){
		return tpermission;
	}
	
	public void deleteAll(List<Tpermission> tpermissions){
		for (int i = tpermissions.size() - 1; i >= 0 ; i--){
			Tpermission tpermission = tpermissions.get(i);
			if (tpermission.is_checked_flag()){
				delete(tpermission.getId());
				tpermissions.remove(i);
			}
		}
	}
	
}
