package cn.com.brilliance.begen.service;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.model.*;

public interface TriskcaseRecordService {

	public List<TriskcaseRecord> init(TriskcaseRecord triskcaseRecord,Map queryFields);
	
	public void delete(String id);
	
	public  List<TriskcaseRecord> getTriskcaseRecordListOfQuery(Map queryFields);
	
	public TriskcaseRecord saveTriskcaseRecord(TriskcaseRecord triskcaseRecord);
	
	public  TriskcaseRecord getTriskcaseRecord(String id);

    public TriskcaseRecord saveAll(TriskcaseRecord triskcaseRecord );
	
	public void deleteAll(List<TriskcaseRecord> triskcaseRecords);
}
