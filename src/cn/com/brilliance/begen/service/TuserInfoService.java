package cn.com.brilliance.begen.service;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.model.*;

public interface TuserInfoService {

	public List<TuserInfo> init(TuserInfo tuserInfo,Map queryFields);
	
	public void delete(String id);
	
	public  List<TuserInfo> getTuserInfoListOfQuery(Map queryFields);
	
	public TuserInfo saveTuserInfo(TuserInfo tuserInfo);
	
	public  TuserInfo getTuserInfo(String id);

    public TuserInfo saveAll(TuserInfo tuserInfo );
	
	public void deleteAll(List<TuserInfo> tuserInfos);
}
