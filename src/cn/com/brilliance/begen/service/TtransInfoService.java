package cn.com.brilliance.begen.service;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.model.*;

public interface TtransInfoService {

	public List<TtransInfo> init(TtransInfo ttransInfo,Map queryFields);
	
	public void delete(String id);
	
	public  List<TtransInfo> getTtransInfoListOfQuery(Map queryFields);
	
	public TtransInfo saveTtransInfo(TtransInfo ttransInfo);
	
	public  TtransInfo getTtransInfo(String id);

    public TtransInfo saveAll(TtransInfo ttransInfo );
	
	public void deleteAll(List<TtransInfo> ttransInfos);

	public int getTtransInfoListOfQueryCount(Map queryFields);
}
