package cn.com.brilliance.begen.service;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.model.*;

public interface TriskcaseService {

	public List<Triskcase> init(Triskcase triskcase,Map queryFields);
	
	public void delete(String id);
	
	public  List<Triskcase> getTriskcaseListOfQuery(Map queryFields);
	
	public Triskcase saveTriskcase(Triskcase triskcase);
	
	public  Triskcase getTriskcase(String id);

    public Triskcase saveAll(Triskcase triskcase ,List<String> triskcaseRecordDeleteList,List<TriskcaseRecord> triskcaseRecords,List<String> triskcaseAttachmentDeleteList,List<TriskcaseAttachment> triskcaseAttachments);
	
	public void deleteAll(List<Triskcase> triskcases);
	
	public int getTriskcaseListOfCount(Map queryFields);
}
