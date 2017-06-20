package cn.com.brilliance.begen.service;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.model.*;

public interface TruleGroupService {

	public List<TruleGroup> init(TruleGroup truleGroup,Map queryFields);
	
	public void delete(String id);
	
	public  List<TruleGroup> getTruleGroupListOfQuery(Map queryFields);
	
	public TruleGroup saveTruleGroup(TruleGroup truleGroup);
	
	public  TruleGroup getTruleGroup(String id);

    public TruleGroup saveAll(TruleGroup truleGroup );
	
	public void deleteAll(List<TruleGroup> truleGroups);
}
