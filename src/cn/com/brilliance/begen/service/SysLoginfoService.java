package cn.com.brilliance.begen.service;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.model.*;

public interface SysLoginfoService {

	public List<SysLoginfo> init(SysLoginfo sysLoginfo,Map queryFields);
	
	public void delete(String id);
	
	public  List<SysLoginfo> getSysLoginfoListOfQuery(Map queryFields);
	
	public SysLoginfo saveSysLoginfo(SysLoginfo sysLoginfo);
	
	public  SysLoginfo getSysLoginfo(String id);

    public SysLoginfo saveAll(SysLoginfo sysLoginfo );
	
	public void deleteAll(List<SysLoginfo> sysLoginfos);
}
