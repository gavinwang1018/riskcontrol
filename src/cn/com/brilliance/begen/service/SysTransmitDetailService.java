package cn.com.brilliance.begen.service;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.model.*;

public interface SysTransmitDetailService {

	public List<SysTransmitDetail> init(SysTransmitDetail sysTransmitDetail,Map queryFields);
	
	public void delete(String id);
	
	public  List<SysTransmitDetail> getSysTransmitDetailListOfQuery(Map queryFields);
	
	public SysTransmitDetail saveSysTransmitDetail(SysTransmitDetail sysTransmitDetail);
	
	public  SysTransmitDetail getSysTransmitDetail(String id);

    public SysTransmitDetail saveAll(SysTransmitDetail sysTransmitDetail );
	
	public void deleteAll(List<SysTransmitDetail> sysTransmitDetails);
}
