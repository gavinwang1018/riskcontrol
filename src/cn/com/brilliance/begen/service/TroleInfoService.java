package cn.com.brilliance.begen.service;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.model.*;

public interface TroleInfoService {

	public List<TroleInfo> init(TroleInfo troleInfo,Map queryFields);
	
	public void delete(String id);
	
	public  List<TroleInfo> getTroleInfoListOfQuery(Map queryFields);
	
	public TroleInfo saveTroleInfo(TroleInfo troleInfo);
	
	public  TroleInfo getTroleInfo(String id);

    public TroleInfo saveAll(TroleInfo troleInfo );
	
	public void deleteAll(List<TroleInfo> troleInfos);
}
