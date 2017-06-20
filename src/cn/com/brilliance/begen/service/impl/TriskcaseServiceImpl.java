package cn.com.brilliance.begen.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;

public class TriskcaseServiceImpl implements TriskcaseService{

	private TriskcaseDAO triskcaseDAO = null;

	public TriskcaseDAO getTriskcaseDAO() {
		return triskcaseDAO;
	}

	public void setTriskcaseDAO(TriskcaseDAO triskcaseDAO) {
		this.triskcaseDAO = triskcaseDAO;
	}

	public List<Triskcase> init(Triskcase triskcase,Map queryFields){
        if (triskcase != null) {
            return triskcaseDAO.getTriskcaseList(triskcase);
        }
        else {
            return getTriskcaseListOfQuery(queryFields);
        }
	}
	
	public void delete(String id){
        triskcaseDAO.removeTriskcase(id);
		CmsUtil.deleteFile("glp_study/"+ id);	
	}
	
	public  List<Triskcase> getTriskcaseListOfQuery(Map queryFields){
		return triskcaseDAO.getTriskcaseListOfQuery(queryFields);
	}
	
	public  Triskcase getTriskcase(String id){
		return triskcaseDAO.getTriskcase(id);
	}
	
	public Triskcase saveTriskcase(Triskcase triskcase){
		return triskcaseDAO.saveTriskcase(triskcase);
	}
	

    public Triskcase saveAll(Triskcase triskcase ,List<String> triskcaseRecordDeleteList,List<TriskcaseRecord> triskcaseRecords,List<String> triskcaseAttachmentDeleteList,List<TriskcaseAttachment> triskcaseAttachments){
		triskcase = saveTriskcase(triskcase);
    	TriskcaseRecordService triskcaseRecordservice = (TriskcaseRecordService)Tools.getBean("triskcaseRecordService");
    	for(String id : triskcaseRecordDeleteList){
    		triskcaseRecordservice.delete(id);
    	}		
		if(triskcaseRecords != null){
			for(TriskcaseRecord triskcaseRecord : triskcaseRecords){    		
        		if (triskcaseRecord.get_edit_flag() == TriskcaseRecord.EDIT_FLAG_ADD || triskcaseRecord.get_edit_flag() == TriskcaseRecord.EDIT_FLAG_EDIT){
           			triskcaseRecord.setRiskcaseId(triskcase.getId());
        			triskcaseRecordservice.saveTriskcaseRecord(triskcaseRecord);
        		}
        	}
		}	
		triskcase = saveTriskcase(triskcase);
    	TriskcaseAttachmentService triskcaseAttachmentservice = (TriskcaseAttachmentService)Tools.getBean("triskcaseAttachmentService");
    	for(String id : triskcaseAttachmentDeleteList){
    		triskcaseAttachmentservice.delete(id);
    	}		
		if(triskcaseAttachments != null){
			for(TriskcaseAttachment triskcaseAttachment : triskcaseAttachments){    		
        		if (triskcaseAttachment.get_edit_flag() == TriskcaseAttachment.EDIT_FLAG_ADD || triskcaseAttachment.get_edit_flag() == TriskcaseAttachment.EDIT_FLAG_EDIT){
           			triskcaseAttachment.setRiskcaseId(triskcase.getId());
        			triskcaseAttachmentservice.saveTriskcaseAttachment(triskcaseAttachment);
        		}
        	}
		}	
		return triskcase;
	}
	
	public void deleteAll(List<Triskcase> triskcases){
		for (int i = triskcases.size() - 1; i >= 0 ; i--){
			Triskcase triskcase = triskcases.get(i);
			if (triskcase.is_checked_flag()){
				delete(triskcase.getId());
				triskcases.remove(i);
			}
		}
	}
	
	public int getTriskcaseListOfCount(Map queryFields) {
		return triskcaseDAO.getTriskcaseListOfCount(queryFields);
	}
	
}
