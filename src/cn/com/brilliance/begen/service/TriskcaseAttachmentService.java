package cn.com.brilliance.begen.service;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.model.*;

public interface TriskcaseAttachmentService {

	public List<TriskcaseAttachment> init(TriskcaseAttachment triskcaseAttachment,Map queryFields);
	
	public void delete(String id);
	
	public  List<TriskcaseAttachment> getTriskcaseAttachmentListOfQuery(Map queryFields);
	
	public TriskcaseAttachment saveTriskcaseAttachment(TriskcaseAttachment triskcaseAttachment);
	
	public  TriskcaseAttachment getTriskcaseAttachment(String id);

    public TriskcaseAttachment saveAll(TriskcaseAttachment triskcaseAttachment );
	
	public void deleteAll(List<TriskcaseAttachment> triskcaseAttachments);
}
