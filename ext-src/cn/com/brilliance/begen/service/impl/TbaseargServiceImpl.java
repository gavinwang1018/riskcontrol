package cn.com.brilliance.begen.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;

public class TbaseargServiceImpl implements TbaseargService{

	private TbaseargDAO tbaseargDAO = null;

	public TbaseargDAO getTbaseargDAO() {
		return tbaseargDAO;
	}

	public void setTbaseargDAO(TbaseargDAO tbaseargDAO) {
		this.tbaseargDAO = tbaseargDAO;
	}

	public List<Tbasearg> init(Tbasearg tbasearg,Map queryFields){
        if (tbasearg != null) {
            return tbaseargDAO.getTbaseargList(tbasearg);
        }
        else {
            return getTbaseargListOfQuery(queryFields);
        }
	}
	
	public void delete(String id){
        tbaseargDAO.removeTbasearg(id);
		CmsUtil.deleteFile("glp_study/"+ id);	
	}
	
	public  List<Tbasearg> getTbaseargListOfQuery(Map queryFields){
		return tbaseargDAO.getTbaseargListOfQuery(queryFields);
	}
	
	public List<Tbasearg> getTbaseargByType(Map queryFields,String simbol){
		return tbaseargDAO.getTbaseargByType(queryFields,simbol);
	}
	
	
	public  Tbasearg getTbasearg(String id){
		return tbaseargDAO.getTbasearg(id);
	}
	
	public Tbasearg saveTbasearg(Tbasearg tbasearg){
		return tbaseargDAO.saveTbasearg(tbasearg);
	}
	

    public Tbasearg saveAll(Tbasearg tbasearg ){
		return tbasearg;
	}
	
	public void deleteAll(List<Tbasearg> tbaseargs){
		for (int i = tbaseargs.size() - 1; i >= 0 ; i--){
			Tbasearg tbasearg = tbaseargs.get(i);
			if (tbasearg.is_checked_flag()){
				delete(tbasearg.getId());
				tbaseargs.remove(i);
			}
		}
	}
	
}
