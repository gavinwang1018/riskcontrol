package cn.com.brilliance.begen.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.model.*;

public interface TmchntService {

	public List<Tmchnt> init(Tmchnt tmchnt,Map queryFields);
	
	public void delete(String id);
	
	public  List<Tmchnt> getTmchntListOfQuery(Map queryFields);
	
	public Tmchnt saveTmchnt(Tmchnt tmchnt);
	
	public  Tmchnt getTmchnt(String id);

    public Tmchnt saveAll(Tmchnt tmchnt ,List<String> tmchntAppDeleteList,List<TmchntApp> tmchntApps);
	
	public void deleteAll(List<Tmchnt> tmchnts);
	
	public String getTmchntAccountNo(String id);
	
	public void saveKeoMchnt(TkeoMchnt keoTmchnts);
	
	public Tmchnt getTmchntByName(String name, String subInst, String netWorkTransfer);
	
	public List<Tmchnt> getMerListOfQuery(int firstpage, int pagesize,Map queryFields);
	
	public int getMerListOfQueryNumber(Map queryFields);
	
	public int getTmchntListOfQueryCount(Map queryFields);
}
