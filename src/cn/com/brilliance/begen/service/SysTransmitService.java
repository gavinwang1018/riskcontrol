package cn.com.brilliance.begen.service;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.model.*;

public interface SysTransmitService {

	public List<SysTransmit> init(SysTransmit sysTransmit,Map queryFields);
	
	public void delete(String id);
	
	public  List<SysTransmit> getSysTransmitListOfQuery(Map queryFields);
	
	public SysTransmit saveSysTransmit(SysTransmit sysTransmit);
	
	public  SysTransmit getSysTransmit(String id);

    public SysTransmit saveAll(SysTransmit sysTransmit ,List<String> sysTransmitDetailDeleteList,List<SysTransmitDetail> sysTransmitDetails);
	
	public void deleteAll(List<SysTransmit> sysTransmits);
}
