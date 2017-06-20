package cn.com.brilliance.begen.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;

public class TkeoMchntServiceImpl implements TkeoMchntService{

	private TkeoMchntDAO tkeoMchntDAO = null;

	public TkeoMchntDAO getTkeoMchntDAO() {
		return tkeoMchntDAO;
	}

	public void setTkeoMchntDAO(TkeoMchntDAO tkeoMchntDAO) {
		this.tkeoMchntDAO = tkeoMchntDAO;
	}

	public List<TkeoMchnt> init(TkeoMchnt tkeoMchnt,Map queryFields){
        if (tkeoMchnt != null) {
            return tkeoMchntDAO.getTkeoMchntList(tkeoMchnt);
        }
        else {
            return getTkeoMchntListOfQuery(queryFields);
        }
	}
	
	public void delete(String id){
        tkeoMchntDAO.removeTkeoMchnt(id);
		CmsUtil.deleteFile("glp_study/"+ id);	
	}
	
	public  List<TkeoMchnt> getTkeoMchntListOfQuery(Map queryFields){
		return tkeoMchntDAO.getTkeoMchntListOfQuery(queryFields);
	}
	
	public  TkeoMchnt getTkeoMchnt(String id){
		return tkeoMchntDAO.getTkeoMchnt(id);
	}
	
	public TkeoMchnt saveTkeoMchnt(TkeoMchnt tkeoMchnt){
		return tkeoMchntDAO.saveTkeoMchnt(tkeoMchnt);
	}
	

    public TkeoMchnt saveAll(TkeoMchnt tkeoMchnt ){
		return tkeoMchnt;
	}
	
	public void deleteAll(List<TkeoMchnt> tkeoMchnts){
		for (int i = tkeoMchnts.size() - 1; i >= 0 ; i--){
			TkeoMchnt tkeoMchnt = tkeoMchnts.get(i);
			if (tkeoMchnt.is_checked_flag()){
				delete(tkeoMchnt.getId());
				tkeoMchnts.remove(i);
			}
		}
	}
	
	/**
	 * 根据商户ID,所属机构以及风险类型查询商户监控信息
	 */
	public TkeoMchnt getKeoMchnt(String merId,String type){
		TkeoMchnt tkoMchnt = new TkeoMchnt();
		TkeoMchntDAO  tkeoMchntdao = null;
		
		tkoMchnt = tkeoMchntDAO.getKeoMchntByMerId(merId,type);
		
		return tkoMchnt;
		
	}
	
	public int getTkeoMchntListOfQueryCount(Map queryFields){
		return tkeoMchntDAO.getTkeoMchntListOfQueryCount(queryFields);
	}
}
