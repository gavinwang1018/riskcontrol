package cn.com.brilliance.begen.service;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.model.*;

public interface TkeoMchntService {

	public List<TkeoMchnt> init(TkeoMchnt tkeoMchnt,Map queryFields);
	
	public void delete(String id);
	
	public  List<TkeoMchnt> getTkeoMchntListOfQuery(Map queryFields);
	
	public TkeoMchnt saveTkeoMchnt(TkeoMchnt tkeoMchnt);
	
	public  TkeoMchnt getTkeoMchnt(String id);

    public TkeoMchnt saveAll(TkeoMchnt tkeoMchnt );
	
	public void deleteAll(List<TkeoMchnt> tkeoMchnts);
	
	public TkeoMchnt getKeoMchnt(String id,String type);
	
	public int getTkeoMchntListOfQueryCount(Map queryFields);
}
