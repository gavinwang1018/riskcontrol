package cn.com.brilliance.begen.service;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.model.*;

public interface TruleInstanceGroupSegmentService {

	public List<TruleInstanceGroupSegment> init(TruleInstanceGroupSegment truleInstanceGroupSegment,Map queryFields);
	
	public void delete(String id);
	
	public  List<TruleInstanceGroupSegment> getTruleInstanceGroupSegmentListOfQuery(Map queryFields);
	
	public TruleInstanceGroupSegment saveTruleInstanceGroupSegment(TruleInstanceGroupSegment truleInstanceGroupSegment);
	
	public  TruleInstanceGroupSegment getTruleInstanceGroupSegment(String id);

    public TruleInstanceGroupSegment saveAll(TruleInstanceGroupSegment truleInstanceGroupSegment );
	
	public void deleteAll(List<TruleInstanceGroupSegment> truleInstanceGroupSegments);
}
