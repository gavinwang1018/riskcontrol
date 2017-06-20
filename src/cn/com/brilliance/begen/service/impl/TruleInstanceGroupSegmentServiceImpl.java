package cn.com.brilliance.begen.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;

public class TruleInstanceGroupSegmentServiceImpl implements TruleInstanceGroupSegmentService{

	private TruleInstanceGroupSegmentDAO truleInstanceGroupSegmentDAO = null;

	public TruleInstanceGroupSegmentDAO getTruleInstanceGroupSegmentDAO() {
		return truleInstanceGroupSegmentDAO;
	}

	public void setTruleInstanceGroupSegmentDAO(TruleInstanceGroupSegmentDAO truleInstanceGroupSegmentDAO) {
		this.truleInstanceGroupSegmentDAO = truleInstanceGroupSegmentDAO;
	}

	public List<TruleInstanceGroupSegment> init(TruleInstanceGroupSegment truleInstanceGroupSegment,Map queryFields){
        if (truleInstanceGroupSegment != null) {
            return truleInstanceGroupSegmentDAO.getTruleInstanceGroupSegmentList(truleInstanceGroupSegment);
        }
        else {
            return getTruleInstanceGroupSegmentListOfQuery(queryFields);
        }
	}
	
	public void delete(String id){
        truleInstanceGroupSegmentDAO.removeTruleInstanceGroupSegment(id);
		CmsUtil.deleteFile("glp_study/"+ id);	
	}
	
	public  List<TruleInstanceGroupSegment> getTruleInstanceGroupSegmentListOfQuery(Map queryFields){
		return truleInstanceGroupSegmentDAO.getTruleInstanceGroupSegmentListOfQuery(queryFields);
	}
	
	public  TruleInstanceGroupSegment getTruleInstanceGroupSegment(String id){
		return truleInstanceGroupSegmentDAO.getTruleInstanceGroupSegment(id);
	}
	
	public TruleInstanceGroupSegment saveTruleInstanceGroupSegment(TruleInstanceGroupSegment truleInstanceGroupSegment){
		return truleInstanceGroupSegmentDAO.saveTruleInstanceGroupSegment(truleInstanceGroupSegment);
	}
	

    public TruleInstanceGroupSegment saveAll(TruleInstanceGroupSegment truleInstanceGroupSegment ){
		return truleInstanceGroupSegment;
	}
	
	public void deleteAll(List<TruleInstanceGroupSegment> truleInstanceGroupSegments){
		for (int i = truleInstanceGroupSegments.size() - 1; i >= 0 ; i--){
			TruleInstanceGroupSegment truleInstanceGroupSegment = truleInstanceGroupSegments.get(i);
			if (truleInstanceGroupSegment.is_checked_flag()){
				delete(truleInstanceGroupSegment.getId());
				truleInstanceGroupSegments.remove(i);
			}
		}
	}
	
}
