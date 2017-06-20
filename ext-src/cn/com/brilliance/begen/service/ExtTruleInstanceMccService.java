package cn.com.brilliance.begen.service;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.model.ExtTruleInstanceMcc;

public interface ExtTruleInstanceMccService {

	public List<ExtTruleInstanceMcc> init(ExtTruleInstanceMcc truleInstanceMcc,Map queryFields);
	
	public void delete(String id);
	
	public  List<ExtTruleInstanceMcc> getExtTruleInstanceMccListOfQuery(Map queryFields);
	
	public ExtTruleInstanceMcc saveExtTruleInstanceMcc(ExtTruleInstanceMcc truleInstanceMcc);
	
	public  ExtTruleInstanceMcc getExtTruleInstanceMcc(String id);

    public ExtTruleInstanceMcc saveAll(ExtTruleInstanceMcc truleInstanceMcc );
	
	public void deleteAll(List<ExtTruleInstanceMcc> truleInstanceMccs);
}
