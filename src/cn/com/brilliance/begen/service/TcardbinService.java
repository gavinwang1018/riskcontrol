package cn.com.brilliance.begen.service;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.model.*;

public interface TcardbinService {

	public List<Tcardbin> init(Tcardbin tcardbin,Map queryFields);
	
	public void delete(String id);
	
	public  List<Tcardbin> getTcardbinListOfQuery(Map queryFields);
	
	public Tcardbin saveTcardbin(Tcardbin tcardbin);
	
	public  Tcardbin getTcardbin(String id);

    public Tcardbin saveAll(Tcardbin tcardbin );
	
	public void deleteAll(List<Tcardbin> tcardbins);
}
