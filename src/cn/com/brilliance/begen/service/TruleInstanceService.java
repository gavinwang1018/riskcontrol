package cn.com.brilliance.begen.service;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.model.*;

public interface TruleInstanceService {

	public List<TruleInstance> init(TruleInstance truleInstance,Map queryFields);
	
	public void delete(String id);
	
	public  List<TruleInstance> getTruleInstanceListOfQuery(Map queryFields);
	
	public TruleInstance saveTruleInstance(TruleInstance truleInstance);
	
	public  TruleInstance getTruleInstance(String id);

    public TruleInstance saveAll(TruleInstance truleInstance );
	
	public void deleteAll(List<TruleInstance> truleInstances);
	
	public void rollback();
}
