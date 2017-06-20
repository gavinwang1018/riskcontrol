package cn.com.brilliance.begen.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.SysDataObjectDAO;
import cn.com.brilliance.begen.dao.SysFieldDAO;
import cn.com.brilliance.begen.dao.SysFormLayoutDAO;
import cn.com.brilliance.begen.dao.SysOrgDAO;
import cn.com.brilliance.begen.dao.SysRoleDAO;
import cn.com.brilliance.begen.dao.SysUserDAO;
import cn.com.brilliance.begen.dao.SysWorkflowDefDAO;
import cn.com.brilliance.begen.dao.SysWorkflowInsProcDAO;
import cn.com.brilliance.begen.dao.SysWorkflowInsTaskDAO;
import cn.com.brilliance.begen.dao.SysWorkflowStateDAO;
import cn.com.brilliance.begen.exception.SystemException;
import cn.com.brilliance.begen.model.SysDataObject;
import cn.com.brilliance.begen.model.SysField;
import cn.com.brilliance.begen.model.SysFormLayout;
import cn.com.brilliance.begen.model.SysUser;
import cn.com.brilliance.begen.model.SysUserRole;
import cn.com.brilliance.begen.model.SysWorkflowDef;
import cn.com.brilliance.begen.model.SysWorkflowInsProc;
import cn.com.brilliance.begen.model.SysWorkflowInsTask;
import cn.com.brilliance.begen.model.SysWorkflowState;
import cn.com.brilliance.begen.service.PermissionWorkflowManager;

public class PermissionWorkflowManagerImpl implements PermissionWorkflowManager {

	public void accept(String taskId,String dataObjectName,Object obj,String currentUser) {
		// TODO Auto-generated method stub
		SysWorkflowInsTaskDAO sysWorkflowInsTaskDAO = (SysWorkflowInsTaskDAO) Tools.getBean("sysWorkflowInsTaskDAO");
		SysWorkflowStateDAO sysWorkflowStateDAO = (SysWorkflowStateDAO) Tools.getBean("sysWorkflowStateDAO");		
		SysWorkflowInsTask sysWorkflowInsTask = sysWorkflowInsTaskDAO.getSysWorkflowInsTask(taskId);
		String stateId = sysWorkflowInsTask.getStateDefId();
		String processInsId = sysWorkflowInsTask.getProcessInsId();
		SysWorkflowState sysWorkflowState = sysWorkflowStateDAO.getSysWorkflowState(stateId);
		String defId = sysWorkflowState.getWorkflowId();		
		//保存表单数据		
		obj = Tools.saveDataObjectBean(dataObjectName, obj);
		//结束当前任务
		closeTaskIns(taskId,currentUser);
		if ("2".equals(sysWorkflowState.getAuthLevel())){
			//结束流程
			closeProcessIns(processInsId);
		}
		else{
			//创建审核2
			sysWorkflowState = getSysWorkflowStateDef(defId,"2");
			if (sysWorkflowState == null){
				closeProcessIns(processInsId);
			}
			else{
				String nextStateId = sysWorkflowState.getId();
				createTaskIns(processInsId, nextStateId,
						Tools.evaluateFormula(sysWorkflowState.getTitle(), obj),currentUser,
						Tools.evaluateFormula(sysWorkflowState.getReceiptUser(), obj),
						Tools.evaluateFormula(sysWorkflowState.getReceiptRole(), obj),
						Tools.evaluateFormula(sysWorkflowState.getReceiptOrg(), obj));
			}
		}
	}

	public void create(String processDefName,String dataObjectName,Object obj,String currentUser) {
		// TODO Auto-generated method stub
		SysWorkflowDefDAO sysWorkflowDefDAO = (SysWorkflowDefDAO)Tools.getBean("sysWorkflowDefDAO");
		SysWorkflowInsProcDAO sysWorkflowInsProcDAO = (SysWorkflowInsProcDAO) Tools.getBean("sysWorkflowInsProcDAO");		
		SysWorkflowDef sysWorkflowDef = new SysWorkflowDef();
		sysWorkflowDef.setWorkflowName(processDefName);
		List list = sysWorkflowDefDAO.getSysWorkflowDefList(sysWorkflowDef);
		if(list.size() > 0){
			sysWorkflowDef = (SysWorkflowDef)list.get(0);
			String dataObjectId = sysWorkflowDef.getDataObject();			
			//保存表单数据
			obj = Tools.saveDataObjectBean(dataObjectName, obj);
			String keyName = getDataObjectKeyName(dataObjectId);
			if(keyName != null){
				//创建流程实例
				String dataObjectKey = Tools.getProperty(obj, keyName);
				SysWorkflowInsProc sysWorkflowInsProc = new SysWorkflowInsProc();
				sysWorkflowInsProc.setProcessDefId(sysWorkflowDef.getId());
				sysWorkflowInsProc.setProcessState("0");
				sysWorkflowInsProc.setProcessStart(new Date());
				sysWorkflowInsProc.setDataObjectKey(dataObjectKey);
				sysWorkflowInsProc = sysWorkflowInsProcDAO.saveSysWorkflowInsProc(sysWorkflowInsProc);
				//创建申请实例
				SysWorkflowState sysWorkflowState = getSysWorkflowStateDef(sysWorkflowDef.getId(),"0");
				String taskId = createTaskIns(sysWorkflowInsProc.getId(), sysWorkflowState.getId(),
						Tools.evaluateFormula(sysWorkflowState.getTitle(), obj),currentUser,
						Tools.evaluateFormula(sysWorkflowState.getReceiptUser(), obj),
						Tools.evaluateFormula(sysWorkflowState.getReceiptRole(), obj),
						Tools.evaluateFormula(sysWorkflowState.getReceiptOrg(), obj));
				closeTaskIns(taskId,currentUser);
				//创建审批实例
				sysWorkflowState = getSysWorkflowStateDef(sysWorkflowDef.getId(),"1");
				createTaskIns(sysWorkflowInsProc.getId(), sysWorkflowState.getId(),
						Tools.evaluateFormula(sysWorkflowState.getTitle(), obj),currentUser,
						Tools.evaluateFormula(sysWorkflowState.getReceiptUser(), obj),
						Tools.evaluateFormula(sysWorkflowState.getReceiptRole(), obj),
						Tools.evaluateFormula(sysWorkflowState.getReceiptOrg(), obj));
			}				
		}
	}

	public List getTodoActivityList(String userId) {
		// TODO Auto-generated method stub
		List<Map> todoList = new ArrayList<Map>();
		SysUserDAO sysUserDAO = (SysUserDAO)Tools.getBean("sysUserDAO");
		SysOrgDAO  sysOrgDAO = (SysOrgDAO)Tools.getBean("sysOrgDAO");
		SysRoleDAO sysRoleDAO = (SysRoleDAO)Tools.getBean("sysRoleDAO"); 
		SysWorkflowInsTaskDAO sysWorkflowInsTaskDAO = (SysWorkflowInsTaskDAO) Tools.getBean("sysWorkflowInsTaskDAO");
		SysWorkflowInsProcDAO sysWorkflowInsProcDAO = (SysWorkflowInsProcDAO) Tools.getBean("sysWorkflowInsProcDAO");
		SysWorkflowStateDAO sysWorkflowStateDAO = (SysWorkflowStateDAO) Tools.getBean("sysWorkflowStateDAO");
    	
		SysUser sysUser = sysUserDAO.getSysUser(userId);
    	if(sysUser == null){    	
    		throw new SystemException("无该用户.");
    	}    	
    	String userOrg = sysUser.getOrgId();
    	Set userRoleSet = sysUser.getSysUserRoleGroup();
    	String hsql = "(receipt_org like '%"+userOrg+"%' ";
        Iterator it = userRoleSet.iterator();
        while(it.hasNext()){
            hsql += " or receipt_role like '%";
            hsql += ((SysUserRole)it.next()).getRoleId();
            hsql += "%'";
        }
        hsql += " or receipt_user like '%"+userId+"%' ) and (instance_state = '0' )";
        Map queryMap = new HashMap();
        queryMap.put("_hsql",hsql);
		List list = sysWorkflowInsTaskDAO.getSysWorkflowInsTaskListOfQuery(queryMap);		
		try {
			for (int i = 0; i < list.size(); i++) {
				Map dataMap = new HashMap();
				SysWorkflowInsTask sysWorkflowInsTask = (SysWorkflowInsTask) list
						.get(i);				
				dataMap.put("id", sysWorkflowInsTask.getId());
				dataMap.put("taskTitle", sysWorkflowInsTask.getTaskTitle());
				dataMap.put("instanceStart", sysWorkflowInsTask.getInstanceStart());
				dataMap.put("operator", sysUserDAO.getSysUser(sysWorkflowInsTask.getOperator()).getUserId());
				List userIdList = Tools.string2List(sysWorkflowInsTask.getReceiptUser(),";");
				List userList = new ArrayList();
				for (int j = 0; j < userIdList.size(); j++) {
					userList.add(sysUserDAO.getSysUser((String)userIdList.get(j)).getUserId());
				}				
				dataMap.put("receiptUser", Tools.list2String(userList, ";"));
				List orgIdList = Tools.string2List(sysWorkflowInsTask.getReceiptOrg(),";");
				List orgList = new ArrayList();
				for (int j = 0; j < orgIdList.size(); j++) {
					orgList.add(sysOrgDAO.getSysOrg((String)orgIdList.get(j)).getOrgId());
				}	
				dataMap.put("receiptOrg", Tools.list2String(orgList, ";"));
				List roleIdList = Tools.string2List(sysWorkflowInsTask.getReceiptRole(),";");
				List roleList = new ArrayList();
				for (int j = 0; j < orgIdList.size(); j++) {
					roleList.add(sysRoleDAO.getSysRole((String)roleIdList.get(j)).getRoleId());
				}	
				dataMap.put("receiptRole", Tools.list2String(roleList, ";"));
				String stateDefId = sysWorkflowInsTask.getStateDefId();
				String processInsId = sysWorkflowInsTask.getProcessInsId();
				String key = sysWorkflowInsProcDAO.getSysWorkflowInsProc(
						processInsId).getDataObjectKey();
				SysWorkflowState state = sysWorkflowStateDAO
						.getSysWorkflowState(stateDefId);
				if (state != null) {
					dataMap.put("url", getApplyUrl(state, key));
				}
				todoList.add(dataMap);
			}
		} catch (Exception e) {
			throw new SystemException(e.getMessage());
		}		
		return todoList;
	}
	private String getApplyUrl(SysWorkflowState sysWorkflowState,String dataObjectKey){
		SysWorkflowDefDAO sysWorkflowDefDAO = (SysWorkflowDefDAO)Tools.getBean("sysWorkflowDefDAO");
		SysDataObjectDAO sysDataObjectDAO = (SysDataObjectDAO) Tools.getBean("sysDataObjectDAO");
		SysFormLayoutDAO sysFormLayoutDAO = (SysFormLayoutDAO) Tools.getBean("sysFormLayoutDAO");
		String workflowId = sysWorkflowState.getWorkflowId();
		SysWorkflowDef sysWorkflowDef = sysWorkflowDefDAO.getSysWorkflowDef(workflowId);
		String dataObjectId = sysWorkflowDef.getDataObject();
		SysDataObject sysDataObject = sysDataObjectDAO.getSysDataObject(dataObjectId);
		String dataObjectName = sysDataObject.getName();     
		String formlayoutId = sysWorkflowState.getFormLayout();
		SysFormLayout sysFormLayout = sysFormLayoutDAO.getSysFormLayout(formlayoutId);
    	String layoutName = sysFormLayout.getName();
    	String url = "#";
    	if ("0".equals(sysWorkflowState.getAuthLevel())){
	 		url = dataObjectName + "/" +  layoutName + "_EditForm.faces";	
	 		if(dataObjectKey != null){
	 			url  = url + "?_key=" + dataObjectKey;
	 		}
    	}
    	else {
        	if("1".equals(sysWorkflowState.getLayoutType())){
        		url = dataObjectName + "/" +  layoutName + "_EditForm.faces?_key=" + dataObjectKey;
        	}
        	else if("2".equals(sysWorkflowState.getLayoutType())){
        		url = dataObjectName + "/" +  layoutName + "_ViewForm.faces?_key=" + dataObjectKey;
        	}       	
    	}
    	return url;
	}

	public void reject(String taskId,String dataObjectName,Object obj,String currentUser) {
		// TODO Auto-generated method stub
		SysWorkflowInsTaskDAO sysWorkflowInsTaskDAO = (SysWorkflowInsTaskDAO) Tools.getBean("sysWorkflowInsTaskDAO");
		SysWorkflowStateDAO sysWorkflowStateDAO = (SysWorkflowStateDAO) Tools.getBean("sysWorkflowStateDAO");
		SysWorkflowDefDAO sysWorkflowDefDAO = (SysWorkflowDefDAO)Tools.getBean("sysWorkflowDefDAO");
		SysWorkflowInsTask sysWorkflowInsTask = sysWorkflowInsTaskDAO.getSysWorkflowInsTask(taskId);
		String stateId = sysWorkflowInsTask.getStateDefId();
		String processInsId = sysWorkflowInsTask.getProcessInsId();
		SysWorkflowState sysWorkflowState = sysWorkflowStateDAO.getSysWorkflowState(stateId);
		String defId = sysWorkflowState.getWorkflowId();
		SysWorkflowDef sysWorkflowDef = sysWorkflowDefDAO.getSysWorkflowDef(defId);
		//保存表单数据		
		obj = Tools.saveDataObjectBean(dataObjectName, obj);
		//打回当前任务
		rollbackTaskIns(taskId,currentUser);
		if ("0".equals(sysWorkflowDef.getRollBack())){
			//结束流程
			rejectProcessIns(processInsId);
		}
		else if ("1".equals(sysWorkflowDef.getRollBack()) || "1".equals(sysWorkflowState.getAuthLevel())){
			//打回申请人
			sysWorkflowState = getSysWorkflowStateDef(defId,"0");
			String nextStateId = sysWorkflowState.getId();
			createTaskIns(processInsId, nextStateId,
					Tools.evaluateFormula(sysWorkflowState.getTitle(), obj),currentUser,
					Tools.evaluateFormula(sysWorkflowState.getReceiptUser(), obj),
					Tools.evaluateFormula(sysWorkflowState.getReceiptRole(), obj),
					Tools.evaluateFormula(sysWorkflowState.getReceiptOrg(), obj));
		}
		else{
			//打回审核1
			sysWorkflowState = getSysWorkflowStateDef(defId,"1");
			String nextStateId = sysWorkflowState.getId();
			createTaskIns(processInsId, nextStateId,
					Tools.evaluateFormula(sysWorkflowState.getTitle(), obj),currentUser,
					Tools.evaluateFormula(sysWorkflowState.getReceiptUser(), obj),
					Tools.evaluateFormula(sysWorkflowState.getReceiptRole(), obj),
					Tools.evaluateFormula(sysWorkflowState.getReceiptOrg(), obj));
		}
	}
	
	private String createTaskIns(String processInsId,String stateId,String title,String currentUser,String user,String role,String org){
		SysWorkflowInsTaskDAO sysWorkflowInsTaskDAO = (SysWorkflowInsTaskDAO) Tools.getBean("sysWorkflowInsTaskDAO");
		SysWorkflowInsTask sysWorkflowInsTask  = new SysWorkflowInsTask();
		sysWorkflowInsTask.setOperator(currentUser);
		sysWorkflowInsTask.setInstanceStart(new Date());
		sysWorkflowInsTask.setInstanceState("0");
		sysWorkflowInsTask.setProcessInsId(processInsId);
		sysWorkflowInsTask.setTaskTitle(title);
		sysWorkflowInsTask.setStateDefId(stateId);
		sysWorkflowInsTask.setReceiptOrg(org);
		sysWorkflowInsTask.setReceiptRole(role);
		sysWorkflowInsTask.setReceiptUser(user);
		sysWorkflowInsTask = sysWorkflowInsTaskDAO.saveSysWorkflowInsTask(sysWorkflowInsTask);
		return sysWorkflowInsTask.getId();
	}
	
	private void endTaskIns(String taskId,String state,String currentUser){
		SysWorkflowInsTaskDAO sysWorkflowInsTaskDAO = (SysWorkflowInsTaskDAO) Tools.getBean("sysWorkflowInsTaskDAO");
		SysWorkflowInsTask sysWorkflowInsTask = sysWorkflowInsTaskDAO.getSysWorkflowInsTask(taskId);
		sysWorkflowInsTask.setInstanceEnd(new Date());
		sysWorkflowInsTask.setInstanceState(state);
		sysWorkflowInsTask.setTaskOperator(currentUser);
		sysWorkflowInsTaskDAO.saveSysWorkflowInsTask(sysWorkflowInsTask);
	}		
	
	private void closeTaskIns(String taskId,String currentUser){
		endTaskIns(taskId,"2",currentUser);
	}
	
	private void rollbackTaskIns(String taskId,String currentUser){
		endTaskIns(taskId,"1",currentUser);
	}
	
	private void closeProcessIns(String processInsId){
		endProcessIns(processInsId,"2");
	}
	
	private void rejectProcessIns(String processInsId){
		endProcessIns(processInsId,"1");
	}	

	
	private void endProcessIns(String processInsId,String state){
		SysWorkflowInsProcDAO sysWorkflowInsProcDAO = (SysWorkflowInsProcDAO) Tools.getBean("sysWorkflowInsProcDAO");	
		SysWorkflowInsProc sysWorkflowInsProc = sysWorkflowInsProcDAO.getSysWorkflowInsProc(processInsId);
		sysWorkflowInsProc.setProcessEnd(new Date());
		sysWorkflowInsProc.setProcessState(state);
		sysWorkflowInsProcDAO.saveSysWorkflowInsProc(sysWorkflowInsProc);
	}

	
	private SysWorkflowState getSysWorkflowStateDef(String workflowId,String authLevel){
		SysWorkflowStateDAO sysWorkflowStateDAO = (SysWorkflowStateDAO) Tools.getBean("sysWorkflowStateDAO");
		SysWorkflowState sysWorkflowState = new SysWorkflowState();
		sysWorkflowState.setWorkflowId(workflowId);
		sysWorkflowState.setAuthLevel(authLevel);
		List stateList = sysWorkflowStateDAO.getSysWorkflowStateList(sysWorkflowState);
		if(stateList.size() > 0){
			return (SysWorkflowState)stateList.get(0);			
		}
		return null;
	}
	
	private String getDataObjectKeyName(String dataObjectId){
		SysFieldDAO sysFieldDAO = (SysFieldDAO) Tools.getBean("sysFieldDAO");
		SysField sysField = new SysField();
		sysField.setDataObject(dataObjectId);
		sysField.setPrimateKey(true);
		List fieldList = sysFieldDAO.getSysFieldList(sysField);
		if(fieldList.size() > 0){
			sysField = (SysField)fieldList.get(0);
			return sysField.getName();
		}
		return null;
	}


}
