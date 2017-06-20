package cn.com.brilliance.begen.service;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.model.*;

public interface SysWorkflowInsProcService {

	public List<SysWorkflowInsProc> init(SysWorkflowInsProc sysWorkflowInsProc,Map queryFields);
	
	public void delete(String id);
	
	public  List<SysWorkflowInsProc> getSysWorkflowInsProcListOfQuery(Map queryFields);
	
	public SysWorkflowInsProc saveSysWorkflowInsProc(SysWorkflowInsProc sysWorkflowInsProc);
	
	public  SysWorkflowInsProc getSysWorkflowInsProc(String id);

    public SysWorkflowInsProc saveAll(SysWorkflowInsProc sysWorkflowInsProc ,List<String> sysWorkflowInsTaskDeleteList,List<SysWorkflowInsTask> sysWorkflowInsTasks);
	
	public void deleteAll(List<SysWorkflowInsProc> sysWorkflowInsProcs);
}
