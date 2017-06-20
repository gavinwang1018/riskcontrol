package cn.com.brilliance.begen.service;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.model.*;

public interface TruleInstanceMccService {

	public List<TruleInstanceMcc> init(TruleInstanceMcc truleInstanceMcc,Map queryFields);
	
	public void delete(String id);
	
	public  List<TruleInstanceMcc> getTruleInstanceMccListOfQuery(Map queryFields);
	
	public TruleInstanceMcc saveTruleInstanceMcc(TruleInstanceMcc truleInstanceMcc);
	
	public  TruleInstanceMcc getTruleInstanceMcc(String id);

    public TruleInstanceMcc saveAll(TruleInstanceMcc truleInstanceMcc );
	
	public void deleteAll(List<TruleInstanceMcc> truleInstanceMccs);
    /**
     * ÊÂÎñ»Ø¹ö
     */
	public void rollback();
}
