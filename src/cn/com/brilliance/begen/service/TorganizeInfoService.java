package cn.com.brilliance.begen.service;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.model.*;

public interface TorganizeInfoService {

	public List<TorganizeInfo> init(TorganizeInfo torganizeInfo,Map queryFields);
	
	public void delete(String id);
	
	public  List<TorganizeInfo> getTorganizeInfoListOfQuery(Map queryFields);
	
	public TorganizeInfo saveTorganizeInfo(TorganizeInfo torganizeInfo);
	
	public  TorganizeInfo getTorganizeInfo(String id);

    public TorganizeInfo saveAll(TorganizeInfo torganizeInfo ,List<String> tmchntAppDeleteList,List<TmchntApp> tmchntApps,List<String> triskprocessTimelimitDeleteList,List<TriskprocessTimelimit> triskprocessTimelimits);
	
	public void deleteAll(List<TorganizeInfo> torganizeInfos);
}
