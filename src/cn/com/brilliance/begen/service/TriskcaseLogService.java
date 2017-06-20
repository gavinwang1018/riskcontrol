package cn.com.brilliance.begen.service;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.model.*;

public interface TriskcaseLogService {

	public List<TriskcaseLog> init(TriskcaseLog triskcaseLog,Map queryFields);
	
	public void delete(String id);
	
	public  List<TriskcaseLog> getTriskcaseLogListOfQuery(Map queryFields);
	
	public TriskcaseLog saveTriskcaseLog(TriskcaseLog triskcaseLog);
	
	public  TriskcaseLog getTriskcaseLog(String id);

    public TriskcaseLog saveAll(TriskcaseLog triskcaseLog );
	
	public void deleteAll(List<TriskcaseLog> triskcaseLogs);
}
