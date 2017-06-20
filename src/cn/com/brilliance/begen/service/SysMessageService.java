package cn.com.brilliance.begen.service;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.model.*;

public interface SysMessageService {

	public List<SysMessage> init(SysMessage sysMessage,Map queryFields);
	
	public void delete(String id);
	
	public  List<SysMessage> getSysMessageListOfQuery(Map queryFields);
	
	public SysMessage saveSysMessage(SysMessage sysMessage);
	
	public  SysMessage getSysMessage(String id);

    public SysMessage saveAll(SysMessage sysMessage );
	
	public void deleteAll(List<SysMessage> sysMessages);
}
