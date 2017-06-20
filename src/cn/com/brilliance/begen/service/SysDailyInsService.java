package cn.com.brilliance.begen.service;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.model.*;

public interface SysDailyInsService {

	public List<SysDailyIns> init(SysDailyIns sysDailyIns,Map queryFields);
	
	public void delete(String id);
	
	public  List<SysDailyIns> getSysDailyInsListOfQuery(Map queryFields);
	
	public SysDailyIns saveSysDailyIns(SysDailyIns sysDailyIns);
	
	public  SysDailyIns getSysDailyIns(String id);

    public SysDailyIns saveAll(SysDailyIns sysDailyIns );
	
	public void deleteAll(List<SysDailyIns> sysDailyInss);
}
