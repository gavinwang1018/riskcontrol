package cn.com.brilliance.begen.service;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.model.*;

public interface TruleInstanceGroupService {

	public List<TruleInstanceGroup> init(TruleInstanceGroup truleInstanceGroup,Map queryFields);
	
	public void delete(String id);
	
	public  List<TruleInstanceGroup> getTruleInstanceGroupListOfQuery(Map queryFields);
	
	public TruleInstanceGroup saveTruleInstanceGroup(TruleInstanceGroup truleInstanceGroup);
	
	public  TruleInstanceGroup getTruleInstanceGroup(String id);

    public TruleInstanceGroup saveAll(TruleInstanceGroup truleInstanceGroup );
	
	public void deleteAll(List<TruleInstanceGroup> truleInstanceGroups);
}
