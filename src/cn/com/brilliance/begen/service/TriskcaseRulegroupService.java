package cn.com.brilliance.begen.service;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.model.*;

public interface TriskcaseRulegroupService {

	public List<TriskcaseRulegroup> init(TriskcaseRulegroup triskcaseRulegroup,Map queryFields);
	
	public void delete(String id);
	
	public  List<TriskcaseRulegroup> getTriskcaseRulegroupListOfQuery(Map queryFields);
	
	public TriskcaseRulegroup saveTriskcaseRulegroup(TriskcaseRulegroup triskcaseRulegroup);
	
	public  TriskcaseRulegroup getTriskcaseRulegroup(String id);

    public TriskcaseRulegroup saveAll(TriskcaseRulegroup triskcaseRulegroup );
	
	public void deleteAll(List<TriskcaseRulegroup> triskcaseRulegroups);
}
