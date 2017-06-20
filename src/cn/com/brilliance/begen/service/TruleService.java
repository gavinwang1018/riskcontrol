package cn.com.brilliance.begen.service;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.model.*;

public interface TruleService {

	public List<Trule> init(Trule trule,Map queryFields);
	
	public void delete(String id);
	
	public  List<Trule> getTruleListOfQuery(Map queryFields);
	
	public Trule saveTrule(Trule trule);
	
	public  Trule getTrule(String id);

    public Trule saveAll(Trule trule );
	
	public void deleteAll(List<Trule> trules);
}
