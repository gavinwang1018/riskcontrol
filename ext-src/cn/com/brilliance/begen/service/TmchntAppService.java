package cn.com.brilliance.begen.service;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.model.*;

public interface TmchntAppService {

	public List<TmchntApp> init(TmchntApp tmchntApp,Map queryFields);
	
	public void delete(String id);
	
	public  List<TmchntApp> getTmchntAppListOfQuery(Map queryFields);
	
	public TmchntApp saveTmchntApp(TmchntApp tmchntApp);
	
	public  TmchntApp getTmchntApp(String id);

    public TmchntApp saveAll(TmchntApp tmchntApp );
	
	public void deleteAll(List<TmchntApp> tmchntApps);
	
	public String getTmchntAppMain(String id);
	
}
