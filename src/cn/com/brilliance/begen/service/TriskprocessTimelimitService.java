package cn.com.brilliance.begen.service;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.model.*;

public interface TriskprocessTimelimitService {

	public List<TriskprocessTimelimit> init(TriskprocessTimelimit triskprocessTimelimit,Map queryFields);
	
	public void delete(String id);
	
	public  List<TriskprocessTimelimit> getTriskprocessTimelimitListOfQuery(Map queryFields);
	
	public TriskprocessTimelimit saveTriskprocessTimelimit(TriskprocessTimelimit triskprocessTimelimit);
	
	public  TriskprocessTimelimit getTriskprocessTimelimit(String id);

    public TriskprocessTimelimit saveAll(TriskprocessTimelimit triskprocessTimelimit );
	
	public void deleteAll(List<TriskprocessTimelimit> triskprocessTimelimits);
}
