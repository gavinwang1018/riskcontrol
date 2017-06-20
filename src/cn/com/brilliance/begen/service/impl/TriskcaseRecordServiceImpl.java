package cn.com.brilliance.begen.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;

public class TriskcaseRecordServiceImpl implements TriskcaseRecordService{

	private TriskcaseRecordDAO triskcaseRecordDAO = null;

	public TriskcaseRecordDAO getTriskcaseRecordDAO() {
		return triskcaseRecordDAO;
	}

	public void setTriskcaseRecordDAO(TriskcaseRecordDAO triskcaseRecordDAO) {
		this.triskcaseRecordDAO = triskcaseRecordDAO;
	}

	public List<TriskcaseRecord> init(TriskcaseRecord triskcaseRecord,Map queryFields){
        if (triskcaseRecord != null) {
            return triskcaseRecordDAO.getTriskcaseRecordList(triskcaseRecord);
        }
        else {
            return getTriskcaseRecordListOfQuery(queryFields);
        }
	}
	
	public void delete(String id){
        triskcaseRecordDAO.removeTriskcaseRecord(id);
		CmsUtil.deleteFile("glp_study/"+ id);	
	}
	
	public  List<TriskcaseRecord> getTriskcaseRecordListOfQuery(Map queryFields){
		return triskcaseRecordDAO.getTriskcaseRecordListOfQuery(queryFields);
	}
	
	public  TriskcaseRecord getTriskcaseRecord(String id){
		return triskcaseRecordDAO.getTriskcaseRecord(id);
	}
	
	public TriskcaseRecord saveTriskcaseRecord(TriskcaseRecord triskcaseRecord){
		return triskcaseRecordDAO.saveTriskcaseRecord(triskcaseRecord);
	}
	

    public TriskcaseRecord saveAll(TriskcaseRecord triskcaseRecord ){
		return triskcaseRecord;
	}
	
	public void deleteAll(List<TriskcaseRecord> triskcaseRecords){
		for (int i = triskcaseRecords.size() - 1; i >= 0 ; i--){
			TriskcaseRecord triskcaseRecord = triskcaseRecords.get(i);
			if (triskcaseRecord.is_checked_flag()){
				delete(triskcaseRecord.getId());
				triskcaseRecords.remove(i);
			}
		}
	}
	
}
