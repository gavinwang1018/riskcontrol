package cn.com.brilliance.begen.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;

public class TriskcaseAttachmentServiceImpl implements TriskcaseAttachmentService{

	private TriskcaseAttachmentDAO triskcaseAttachmentDAO = null;

	public TriskcaseAttachmentDAO getTriskcaseAttachmentDAO() {
		return triskcaseAttachmentDAO;
	}

	public void setTriskcaseAttachmentDAO(TriskcaseAttachmentDAO triskcaseAttachmentDAO) {
		this.triskcaseAttachmentDAO = triskcaseAttachmentDAO;
	}

	public List<TriskcaseAttachment> init(TriskcaseAttachment triskcaseAttachment,Map queryFields){
        if (triskcaseAttachment != null) {
            return triskcaseAttachmentDAO.getTriskcaseAttachmentList(triskcaseAttachment);
        }
        else {
            return getTriskcaseAttachmentListOfQuery(queryFields);
        }
	}
	
	public void delete(String id){
        triskcaseAttachmentDAO.removeTriskcaseAttachment(id);
		CmsUtil.deleteFile("glp_study/"+ id);	
	}
	
	public  List<TriskcaseAttachment> getTriskcaseAttachmentListOfQuery(Map queryFields){
		return triskcaseAttachmentDAO.getTriskcaseAttachmentListOfQuery(queryFields);
	}
	
	public  TriskcaseAttachment getTriskcaseAttachment(String id){
		return triskcaseAttachmentDAO.getTriskcaseAttachment(id);
	}
	
	public TriskcaseAttachment saveTriskcaseAttachment(TriskcaseAttachment triskcaseAttachment){
		return triskcaseAttachmentDAO.saveTriskcaseAttachment(triskcaseAttachment);
	}
	

    public TriskcaseAttachment saveAll(TriskcaseAttachment triskcaseAttachment ){
		return triskcaseAttachment;
	}
	
	public void deleteAll(List<TriskcaseAttachment> triskcaseAttachments){
		for (int i = triskcaseAttachments.size() - 1; i >= 0 ; i--){
			TriskcaseAttachment triskcaseAttachment = triskcaseAttachments.get(i);
			if (triskcaseAttachment.is_checked_flag()){
				delete(triskcaseAttachment.getId());
				triskcaseAttachments.remove(i);
			}
		}
	}
	
}
