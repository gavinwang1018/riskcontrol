package cn.com.brilliance.begen.service;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.model.*;

public interface EpcInsTaskService {

	public List<EpcInsTask> init(EpcInsTask epcInsTask,Map queryFields);
	
	public void delete(String id);
	
	public  List<EpcInsTask> getEpcInsTaskListOfQuery(Map queryFields);
	
	public EpcInsTask saveEpcInsTask(EpcInsTask epcInsTask);
	
	public  EpcInsTask getEpcInsTask(String id);

    public EpcInsTask saveAll(EpcInsTask epcInsTask );
	
	public void deleteAll(List<EpcInsTask> epcInsTasks);
}
