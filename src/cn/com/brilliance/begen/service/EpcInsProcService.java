package cn.com.brilliance.begen.service;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.model.*;

public interface EpcInsProcService {

	public List<EpcInsProc> init(EpcInsProc epcInsProc,Map queryFields);
	
	public void delete(String id);
	
	public  List<EpcInsProc> getEpcInsProcListOfQuery(Map queryFields);
	
	public EpcInsProc saveEpcInsProc(EpcInsProc epcInsProc);
	
	public  EpcInsProc getEpcInsProc(String id);

    public EpcInsProc saveAll(EpcInsProc epcInsProc ,List<String> epcInsTaskDeleteList,List<EpcInsTask> epcInsTasks);
	
	public void deleteAll(List<EpcInsProc> epcInsProcs);
}
