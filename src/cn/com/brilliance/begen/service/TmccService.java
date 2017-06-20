package cn.com.brilliance.begen.service;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.model.*;

public interface TmccService {

	public List<Tmcc> init(Tmcc tmcc,Map queryFields);
	
	public void delete(String id);
	
	public  List<Tmcc> getTmccListOfQuery(Map queryFields);
	
	public Tmcc saveTmcc(Tmcc tmcc);
	
	public  Tmcc getTmcc(String id);

    public Tmcc saveAll(Tmcc tmcc );
	
	public void deleteAll(List<Tmcc> tmccs);
}
