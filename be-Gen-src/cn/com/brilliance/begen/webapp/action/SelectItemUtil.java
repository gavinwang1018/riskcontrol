package cn.com.brilliance.begen.webapp.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.model.*;

public class SelectItemUtil {
	private static ApplicationContext ctx = null;
	
	private Map queryMap = new HashMap();	
	
	
	public Map getQueryMap() {
		return queryMap;
	}

	public void setQueryMap(Map queryMap) {
		this.queryMap = queryMap;
	}
	
	public void reload(){
		
	}

	private Object getBean(String name) {
		if (ctx == null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			ctx = WebApplicationContextUtils
					.getRequiredWebApplicationContext((ServletContext) facesContext
							.getExternalContext().getContext());
		}
		return ctx.getBean(name);
	}


//  start:  Generated for sys_org From Template: SelectItemUtil.java.vm
	public List getSysOrgItems() {
		List itemlist = new ArrayList();
		SysOrgDAO sysOrgDAO = (SysOrgDAO)getBean("sysOrgDAO");
		List list = sysOrgDAO.getSysOrgList(new SysOrg());
		for(int i=0;i<list.size();i++) {
			SysOrg sysOrg = (SysOrg)list.get(i);
			itemlist.add(new SelectItem(sysOrg.getId(),sysOrg.getOrgId()));
		}
		return itemlist;
	}
	
	

//  end:  Generated for sys_org From Template: SelectItemUtil.java.vm

//  start:  Generated for sys_role From Template: SelectItemUtil.java.vm
	public List getSysRoleItems() {
		List itemlist = new ArrayList();
		SysRoleDAO sysRoleDAO = (SysRoleDAO)getBean("sysRoleDAO");
		List list = sysRoleDAO.getSysRoleList(new SysRole());
		for(int i=0;i<list.size();i++) {
			SysRole sysRole = (SysRole)list.get(i);
			itemlist.add(new SelectItem(sysRole.getId(),sysRole.getRoleId()));
		}
		return itemlist;
	}
	
	

//  end:  Generated for sys_role From Template: SelectItemUtil.java.vm
//  start:  Generated for sys_role_authority From Template: SelectItemUtil.java.vm
	public List getSysRoleAuthorityItems() {
		List itemlist = new ArrayList();
		SysRoleAuthorityDAO sysRoleAuthorityDAO = (SysRoleAuthorityDAO)getBean("sysRoleAuthorityDAO");
		List list = sysRoleAuthorityDAO.getSysRoleAuthorityList(new SysRoleAuthority());
		for(int i=0;i<list.size();i++) {
			SysRoleAuthority sysRoleAuthority = (SysRoleAuthority)list.get(i);
			itemlist.add(new SelectItem(sysRoleAuthority.getId()));
		}
		return itemlist;
	}
	
	

//  end:  Generated for sys_role_authority From Template: SelectItemUtil.java.vm

//  start:  Generated for sys_user From Template: SelectItemUtil.java.vm
	public List getSysUserItems() {
		List itemlist = new ArrayList();
		SysUserDAO sysUserDAO = (SysUserDAO)getBean("sysUserDAO");
		List list = sysUserDAO.getSysUserList(new SysUser());
		for(int i=0;i<list.size();i++) {
			SysUser sysUser = (SysUser)list.get(i);
			itemlist.add(new SelectItem(sysUser.getId(),sysUser.getUserId()));
		}
		return itemlist;
	}
	
	

//  end:  Generated for sys_user From Template: SelectItemUtil.java.vm
//  start:  Generated for sys_user_authority From Template: SelectItemUtil.java.vm
	public List getSysUserAuthorityItems() {
		List itemlist = new ArrayList();
		SysUserAuthorityDAO sysUserAuthorityDAO = (SysUserAuthorityDAO)getBean("sysUserAuthorityDAO");
		List list = sysUserAuthorityDAO.getSysUserAuthorityList(new SysUserAuthority());
		for(int i=0;i<list.size();i++) {
			SysUserAuthority sysUserAuthority = (SysUserAuthority)list.get(i);
			itemlist.add(new SelectItem(sysUserAuthority.getId()));
		}
		return itemlist;
	}
	
	

//  end:  Generated for sys_user_authority From Template: SelectItemUtil.java.vm
//  start:  Generated for sys_user_role From Template: SelectItemUtil.java.vm
	public List getSysUserRoleItems() {
		List itemlist = new ArrayList();
		SysUserRoleDAO sysUserRoleDAO = (SysUserRoleDAO)getBean("sysUserRoleDAO");
		List list = sysUserRoleDAO.getSysUserRoleList(new SysUserRole());
		for(int i=0;i<list.size();i++) {
			SysUserRole sysUserRole = (SysUserRole)list.get(i);
			itemlist.add(new SelectItem(sysUserRole.getId()));
		}
		return itemlist;
	}

//  end:  Generated for crm_distribution_aim From Template: SelectItemUtil.java.vm
//  start:  Generated for sys_daily_ins From Template: SelectItemUtil.java.vm
	
	public List getSysDailyInsItems() {
		List itemlist = new ArrayList();
		SysDailyInsDAO sysDailyInsDAO = (SysDailyInsDAO)getBean("sysDailyInsDAO");
		List list = sysDailyInsDAO.getSysDailyInsListOfQuery(this.queryMap);
		for(int i=0;i<list.size();i++) {
			SysDailyIns sysDailyIns = (SysDailyIns)list.get(i);
			itemlist.add(new SelectItem(String.valueOf(sysDailyIns.getId())));
		}
		return itemlist;
	}
	
	

//  end:  Generated for sys_daily_ins From Template: SelectItemUtil.java.vm
//  start:  Generated for epc_ins_task From Template: SelectItemUtil.java.vm
	
	public List getEpcInsTaskItems() {
		List itemlist = new ArrayList();
		EpcInsTaskDAO epcInsTaskDAO = (EpcInsTaskDAO)getBean("epcInsTaskDAO");
		List list = epcInsTaskDAO.getEpcInsTaskListOfQuery(this.queryMap);
		for(int i=0;i<list.size();i++) {
			EpcInsTask epcInsTask = (EpcInsTask)list.get(i);
			itemlist.add(new SelectItem(String.valueOf(epcInsTask.getId()),String.valueOf(epcInsTask.getProcessInsId())));
		}
		return itemlist;
	}
	
	

//  end:  Generated for epc_ins_task From Template: SelectItemUtil.java.vm
//  start:  Generated for epc_ins_proc From Template: SelectItemUtil.java.vm
	
	public List getEpcInsProcItems() {
		List itemlist = new ArrayList();
		EpcInsProcDAO epcInsProcDAO = (EpcInsProcDAO)getBean("epcInsProcDAO");
		List list = epcInsProcDAO.getEpcInsProcListOfQuery(this.queryMap);
		for(int i=0;i<list.size();i++) {
			EpcInsProc epcInsProc = (EpcInsProc)list.get(i);
			itemlist.add(new SelectItem(String.valueOf(epcInsProc.getId()),String.valueOf(epcInsProc.getProcessDefId())));
		}
		return itemlist;
	}
	
	

//  end:  Generated for epc_ins_proc From Template: SelectItemUtil.java.vm
//  start:  Generated for sys_message From Template: SelectItemUtil.java.vm
	
	public List getSysMessageItems() {
		List itemlist = new ArrayList();
		SysMessageDAO sysMessageDAO = (SysMessageDAO)getBean("sysMessageDAO");
		List list = sysMessageDAO.getSysMessageListOfQuery(this.queryMap);
		for(int i=0;i<list.size();i++) {
			SysMessage sysMessage = (SysMessage)list.get(i);
			itemlist.add(new SelectItem(String.valueOf(sysMessage.getId())));
		}
		return itemlist;
	}
	
	

//  end:  Generated for sys_message From Template: SelectItemUtil.java.vm
//  start:  Generated for sys_workflow_ins_proc From Template: SelectItemUtil.java.vm
	
	public List getSysWorkflowInsProcItems() {
		List itemlist = new ArrayList();
		SysWorkflowInsProcDAO sysWorkflowInsProcDAO = (SysWorkflowInsProcDAO)getBean("sysWorkflowInsProcDAO");
		List list = sysWorkflowInsProcDAO.getSysWorkflowInsProcListOfQuery(this.queryMap);
		for(int i=0;i<list.size();i++) {
			SysWorkflowInsProc sysWorkflowInsProc = (SysWorkflowInsProc)list.get(i);
			itemlist.add(new SelectItem(String.valueOf(sysWorkflowInsProc.getId())));
		}
		return itemlist;
	}
	
	

//  end:  Generated for sys_workflow_ins_proc From Template: SelectItemUtil.java.vm
//  start:  Generated for sys_workflow_ins_task From Template: SelectItemUtil.java.vm
	
	public List getSysWorkflowInsTaskItems() {
		List itemlist = new ArrayList();
		SysWorkflowInsTaskDAO sysWorkflowInsTaskDAO = (SysWorkflowInsTaskDAO)getBean("sysWorkflowInsTaskDAO");
		List list = sysWorkflowInsTaskDAO.getSysWorkflowInsTaskListOfQuery(this.queryMap);
		for(int i=0;i<list.size();i++) {
			SysWorkflowInsTask sysWorkflowInsTask = (SysWorkflowInsTask)list.get(i);
			itemlist.add(new SelectItem(String.valueOf(sysWorkflowInsTask.getId())));
		}
		return itemlist;
	}
	
	

//  end:  Generated for sys_workflow_ins_task From Template: SelectItemUtil.java.vm
//  start:  Generated for sys_transmit From Template: SelectItemUtil.java.vm
	
	public List getSysTransmitItems() {
		List itemlist = new ArrayList();
		SysTransmitDAO sysTransmitDAO = (SysTransmitDAO)getBean("sysTransmitDAO");
		List list = sysTransmitDAO.getSysTransmitListOfQuery(this.queryMap);
		for(int i=0;i<list.size();i++) {
			SysTransmit sysTransmit = (SysTransmit)list.get(i);
			itemlist.add(new SelectItem(String.valueOf(sysTransmit.getId())));
		}
		return itemlist;
	}
	
	

//  end:  Generated for sys_transmit From Template: SelectItemUtil.java.vm
//  start:  Generated for sys_transmit_detail From Template: SelectItemUtil.java.vm
	
	public List getSysTransmitDetailItems() {
		List itemlist = new ArrayList();
		SysTransmitDetailDAO sysTransmitDetailDAO = (SysTransmitDetailDAO)getBean("sysTransmitDetailDAO");
		List list = sysTransmitDetailDAO.getSysTransmitDetailListOfQuery(this.queryMap);
		for(int i=0;i<list.size();i++) {
			SysTransmitDetail sysTransmitDetail = (SysTransmitDetail)list.get(i);
			itemlist.add(new SelectItem(String.valueOf(sysTransmitDetail.getId())));
		}
		return itemlist;
	}
	
	

//  end:  Generated for sys_transmit_detail From Template: SelectItemUtil.java.vm
//  start:  Generated for sys_loginfo From Template: SelectItemUtil.java.vm
	
	public List getSysLoginfoItems() {
		List itemlist = new ArrayList();
		SysLoginfoDAO sysLoginfoDAO = (SysLoginfoDAO)getBean("sysLoginfoDAO");
		List list = sysLoginfoDAO.getSysLoginfoListOfQuery(this.queryMap);
		for(int i=0;i<list.size();i++) {
			SysLoginfo sysLoginfo = (SysLoginfo)list.get(i);
			itemlist.add(new SelectItem(String.valueOf(sysLoginfo.getId())));
		}
		return itemlist;
	}
	
	

//  end:  Generated for sys_loginfo From Template: SelectItemUtil.java.vm
//  start:  Generated for t_user_info From Template: SelectItemUtil.java.vm
	
	public List getTuserInfoItems() {
		List itemlist = new ArrayList();
		TuserInfoDAO tuserInfoDAO = (TuserInfoDAO)getBean("tuserInfoDAO");
		List list = tuserInfoDAO.getTuserInfoListOfQuery(this.queryMap);
		for(int i=0;i<list.size();i++) {
			TuserInfo tuserInfo = (TuserInfo)list.get(i);
			itemlist.add(new SelectItem(String.valueOf(tuserInfo.getId())));
		}
		return itemlist;
	}
	
	

//  end:  Generated for t_user_info From Template: SelectItemUtil.java.vm
//  start:  Generated for t_organize_info From Template: SelectItemUtil.java.vm
	
	public List getTorganizeInfoItems() {
		List itemlist = new ArrayList();
		TorganizeInfoDAO torganizeInfoDAO = (TorganizeInfoDAO)getBean("torganizeInfoDAO");
		List list = torganizeInfoDAO.getTorganizeInfoListOfQuery(this.queryMap);
		for(int i=0;i<list.size();i++) {
			TorganizeInfo torganizeInfo = (TorganizeInfo)list.get(i);
			itemlist.add(new SelectItem(String.valueOf(torganizeInfo.getId()),String.valueOf(torganizeInfo.getName())));
		}
		return itemlist;
	}
	
	

//  end:  Generated for t_organize_info From Template: SelectItemUtil.java.vm
//  start:  Generated for t_rule_instance From Template: SelectItemUtil.java.vm
	
	public List getTruleInstanceItems() {
		List itemlist = new ArrayList();
		TruleInstanceDAO truleInstanceDAO = (TruleInstanceDAO)getBean("truleInstanceDAO");
		List list = truleInstanceDAO.getTruleInstanceListOfQuery(this.queryMap);
		for(int i=0;i<list.size();i++) {
			TruleInstance truleInstance = (TruleInstance)list.get(i);
			itemlist.add(new SelectItem(String.valueOf(truleInstance.getId())));
		}
		return itemlist;
	}
	
	

//  end:  Generated for t_rule_instance From Template: SelectItemUtil.java.vm
//  start:  Generated for t_mchnt From Template: SelectItemUtil.java.vm
	
	public List getTmchntItems() {
		List itemlist = new ArrayList();
		TmchntDAO tmchntDAO = (TmchntDAO)getBean("tmchntDAO");
		List list = tmchntDAO.getTmchntListOfQuery(this.queryMap);
		for(int i=0;i<list.size();i++) {
			Tmchnt tmchnt = (Tmchnt)list.get(i);
			itemlist.add(new SelectItem(String.valueOf(tmchnt.getId())));
		}
		return itemlist;
	}
	
	

//  end:  Generated for t_mchnt From Template: SelectItemUtil.java.vm
//  start:  Generated for t_mcc From Template: SelectItemUtil.java.vm
	
	public List getTmccItems() {
		List itemlist = new ArrayList();
		TmccDAO tmccDAO = (TmccDAO)getBean("tmccDAO");
		List list = tmccDAO.getTmccListOfQuery(this.queryMap);
		for(int i=0;i<list.size();i++) {
			Tmcc tmcc = (Tmcc)list.get(i);
			itemlist.add(new SelectItem(String.valueOf(tmcc.getId()),tmcc.getId() + "(" + tmcc.getMccName() + ")"));
		}
		return itemlist;
	}
	
	

//  end:  Generated for t_mcc From Template: SelectItemUtil.java.vm
//  start:  Generated for t_cardbin From Template: SelectItemUtil.java.vm
	
	public List getTcardbinItems() {
		List itemlist = new ArrayList();
		TcardbinDAO tcardbinDAO = (TcardbinDAO)getBean("tcardbinDAO");
		List list = tcardbinDAO.getTcardbinListOfQuery(this.queryMap);
		for(int i=0;i<list.size();i++) {
			Tcardbin tcardbin = (Tcardbin)list.get(i);
			itemlist.add(new SelectItem(String.valueOf(tcardbin.getId())));
		}
		return itemlist;
	}
	
	

//  end:  Generated for t_cardbin From Template: SelectItemUtil.java.vm
//  start:  Generated for t_riskcase_rulegroup From Template: SelectItemUtil.java.vm
	
	public List getTriskcaseRulegroupItems() {
		List itemlist = new ArrayList();
		TriskcaseRulegroupDAO triskcaseRulegroupDAO = (TriskcaseRulegroupDAO)getBean("triskcaseRulegroupDAO");
		List list = triskcaseRulegroupDAO.getTriskcaseRulegroupListOfQuery(this.queryMap);
		for(int i=0;i<list.size();i++) {
			TriskcaseRulegroup triskcaseRulegroup = (TriskcaseRulegroup)list.get(i);
			itemlist.add(new SelectItem(String.valueOf(triskcaseRulegroup.getId())));
		}
		return itemlist;
	}
	
	

//  end:  Generated for t_riskcase_rulegroup From Template: SelectItemUtil.java.vm
//  start:  Generated for t_riskcase_attachment From Template: SelectItemUtil.java.vm
	
	public List getTriskcaseAttachmentItems() {
		List itemlist = new ArrayList();
		TriskcaseAttachmentDAO triskcaseAttachmentDAO = (TriskcaseAttachmentDAO)getBean("triskcaseAttachmentDAO");
		List list = triskcaseAttachmentDAO.getTriskcaseAttachmentListOfQuery(this.queryMap);
		for(int i=0;i<list.size();i++) {
			TriskcaseAttachment triskcaseAttachment = (TriskcaseAttachment)list.get(i);
			itemlist.add(new SelectItem(String.valueOf(triskcaseAttachment.getId())));
		}
		return itemlist;
	}
	
	

//  end:  Generated for t_riskcase_attachment From Template: SelectItemUtil.java.vm
//  start:  Generated for t_riskcase_log From Template: SelectItemUtil.java.vm
	
	public List getTriskcaseLogItems() {
		List itemlist = new ArrayList();
		TriskcaseLogDAO triskcaseLogDAO = (TriskcaseLogDAO)getBean("triskcaseLogDAO");
		List list = triskcaseLogDAO.getTriskcaseLogListOfQuery(this.queryMap);
		for(int i=0;i<list.size();i++) {
			TriskcaseLog triskcaseLog = (TriskcaseLog)list.get(i);
			itemlist.add(new SelectItem(String.valueOf(triskcaseLog.getId())));
		}
		return itemlist;
	}
	
	

//  end:  Generated for t_riskcase_log From Template: SelectItemUtil.java.vm
//  start:  Generated for t_riskcase From Template: SelectItemUtil.java.vm
	
	public List getTriskcaseItems() {
		List itemlist = new ArrayList();
		TriskcaseDAO triskcaseDAO = (TriskcaseDAO)getBean("triskcaseDAO");
		List list = triskcaseDAO.getTriskcaseListOfQuery(this.queryMap);
		for(int i=0;i<list.size();i++) {
			Triskcase triskcase = (Triskcase)list.get(i);
			itemlist.add(new SelectItem(String.valueOf(triskcase.getId())));
		}
		return itemlist;
	}
	
	

//  end:  Generated for t_riskcase From Template: SelectItemUtil.java.vm
	
//  start:  Generated for t_role_info From Template: SelectItemUtil.java.vm
	
	public List getTroleInfoItems() {
		List itemlist = new ArrayList();
		TroleInfoDAO troleInfoDAO = (TroleInfoDAO)getBean("troleInfoDAO");
		List list = troleInfoDAO.getTroleInfoListOfQuery(this.queryMap);
		for(int i=0;i<list.size();i++) {
			TroleInfo troleInfo = (TroleInfo)list.get(i);
			itemlist.add(new SelectItem(String.valueOf(troleInfo.getId())));
		}
		return itemlist;
	}
	
	

//  end:  Generated for t_role_info From Template: SelectItemUtil.java.vm
//  start:  Generated for t_organize_user From Template: SelectItemUtil.java.vm
	
	public List getTorganizeUserItems() {
		List itemlist = new ArrayList();
		TorganizeUserDAO torganizeUserDAO = (TorganizeUserDAO)getBean("torganizeUserDAO");
		List list = torganizeUserDAO.getTorganizeUserListOfQuery(this.queryMap);
		for(int i=0;i<list.size();i++) {
			TorganizeUser torganizeUser = (TorganizeUser)list.get(i);
			itemlist.add(new SelectItem(String.valueOf(torganizeUser.getId())));
		}
		return itemlist;
	}
	
	

//  end:  Generated for t_organize_user From Template: SelectItemUtil.java.vm
//  start:  Generated for t_role_user From Template: SelectItemUtil.java.vm
	
	public List getTroleUserItems() {
		List itemlist = new ArrayList();
		TroleUserDAO troleUserDAO = (TroleUserDAO)getBean("troleUserDAO");
		List list = troleUserDAO.getTroleUserListOfQuery(this.queryMap);
		for(int i=0;i<list.size();i++) {
			TroleUser troleUser = (TroleUser)list.get(i);
			itemlist.add(new SelectItem(String.valueOf(troleUser.getId())));
		}
		return itemlist;
	}
	
	

//  end:  Generated for t_role_user From Template: SelectItemUtil.java.vm
//  start:  Generated for t_rule_instance_mcc From Template: SelectItemUtil.java.vm
	
	public List getTruleInstanceMccItems() {
		List itemlist = new ArrayList();
		TruleInstanceMccDAO truleInstanceMccDAO = (TruleInstanceMccDAO)getBean("truleInstanceMccDAO");
		List list = truleInstanceMccDAO.getTruleInstanceMccListOfQuery(this.queryMap);
		for(int i=0;i<list.size();i++) {
			TruleInstanceMcc truleInstanceMcc = (TruleInstanceMcc)list.get(i);
			itemlist.add(new SelectItem(String.valueOf(truleInstanceMcc.getId())));
		}
		return itemlist;
	}
	
	

//  end:  Generated for t_rule_instance_mcc From Template: SelectItemUtil.java.vm
//  start:  Generated for t_rule From Template: SelectItemUtil.java.vm
	
	public List getTruleItems() {
		List itemlist = new ArrayList();
		TruleDAO truleDAO = (TruleDAO)getBean("truleDAO");
		List list = truleDAO.getTruleListOfQuery(this.queryMap);
		for(int i=0;i<list.size();i++) {
			Trule trule = (Trule)list.get(i);
			itemlist.add(new SelectItem(String.valueOf(trule.getId()),String.valueOf(trule.getDescription())));
		}
		return itemlist;
	}
	
	

//  end:  Generated for t_rule From Template: SelectItemUtil.java.vm
//  start:  Generated for t_basearg From Template: SelectItemUtil.java.vm
	
	public List getTbaseargItems() {
		List itemlist = new ArrayList();
		TbaseargDAO tbaseargDAO = (TbaseargDAO)getBean("tbaseargDAO");
		List list = tbaseargDAO.getTbaseargListOfQuery(this.queryMap);
		for(int i=0;i<list.size();i++) {
			Tbasearg tbasearg = (Tbasearg)list.get(i);
			itemlist.add(new SelectItem(String.valueOf(tbasearg.getId())));
		}
		return itemlist;
	}
	
	

//  end:  Generated for t_basearg From Template: SelectItemUtil.java.vm
//  start:  Generated for t_permission From Template: SelectItemUtil.java.vm
	
	public List getTpermissionItems() {
		List itemlist = new ArrayList();
		TpermissionDAO tpermissionDAO = (TpermissionDAO)getBean("tpermissionDAO");
		List list = tpermissionDAO.getTpermissionListOfQuery(this.queryMap);
		for(int i=0;i<list.size();i++) {
			Tpermission tpermission = (Tpermission)list.get(i);
			itemlist.add(new SelectItem(String.valueOf(tpermission.getId())));
		}
		return itemlist;
	}
	
	

//  end:  Generated for t_permission From Template: SelectItemUtil.java.vm
//  start:  Generated for t_keo_mchnt From Template: SelectItemUtil.java.vm
	
	public List getTkeoMchntItems() {
		List itemlist = new ArrayList();
		TkeoMchntDAO tkeoMchntDAO = (TkeoMchntDAO)getBean("tkeoMchntDAO");
		List list = tkeoMchntDAO.getTkeoMchntListOfQuery(this.queryMap);
		for(int i=0;i<list.size();i++) {
			TkeoMchnt tkeoMchnt = (TkeoMchnt)list.get(i);
			itemlist.add(new SelectItem(String.valueOf(tkeoMchnt.getId())));
		}
		return itemlist;
	}
	
	

//  end:  Generated for t_keo_mchnt From Template: SelectItemUtil.java.vm
//  start:  Generated for t_rule_group From Template: SelectItemUtil.java.vm
	
	public List getTruleGroupItems() {
		List itemlist = new ArrayList();
		TruleGroupDAO truleGroupDAO = (TruleGroupDAO)getBean("truleGroupDAO");
		List list = truleGroupDAO.getTruleGroupListOfQuery(this.queryMap);
		for(int i=0;i<list.size();i++) {
			TruleGroup truleGroup = (TruleGroup)list.get(i);
			itemlist.add(new SelectItem(String.valueOf(truleGroup.getId())));
		}
		return itemlist;
	}
	
	

//  end:  Generated for t_rule_group From Template: SelectItemUtil.java.vm
//  start:  Generated for t_rule_instance_group From Template: SelectItemUtil.java.vm
	
	public List getTruleInstanceGroupItems() {
		List itemlist = new ArrayList();
		TruleInstanceGroupDAO truleInstanceGroupDAO = (TruleInstanceGroupDAO)getBean("truleInstanceGroupDAO");
		List list = truleInstanceGroupDAO.getTruleInstanceGroupListOfQuery(this.queryMap);
		for(int i=0;i<list.size();i++) {
			TruleInstanceGroup truleInstanceGroup = (TruleInstanceGroup)list.get(i);
			itemlist.add(new SelectItem(String.valueOf(truleInstanceGroup.getId())));
		}
		return itemlist;
	}
	
	

//  end:  Generated for t_rule_instance_group From Template: SelectItemUtil.java.vm
//  start:  Generated for t_rule_instance_group_segment From Template: SelectItemUtil.java.vm
	
	public List getTruleInstanceGroupSegmentItems() {
		List itemlist = new ArrayList();
		TruleInstanceGroupSegmentDAO truleInstanceGroupSegmentDAO = (TruleInstanceGroupSegmentDAO)getBean("truleInstanceGroupSegmentDAO");
		List list = truleInstanceGroupSegmentDAO.getTruleInstanceGroupSegmentListOfQuery(this.queryMap);
		for(int i=0;i<list.size();i++) {
			TruleInstanceGroupSegment truleInstanceGroupSegment = (TruleInstanceGroupSegment)list.get(i);
			itemlist.add(new SelectItem(String.valueOf(truleInstanceGroupSegment.getId())));
		}
		return itemlist;
	}
	
	

//  end:  Generated for t_rule_instance_group_segment From Template: SelectItemUtil.java.vm
//  start:  Generated for t_mchnt_app From Template: SelectItemUtil.java.vm
	
	public List getTmchntAppItems() {
		List itemlist = new ArrayList();
		TmchntAppDAO tmchntAppDAO = (TmchntAppDAO)getBean("tmchntAppDAO");
		List list = tmchntAppDAO.getTmchntAppListOfQuery(this.queryMap);
		for(int i=0;i<list.size();i++) {
			TmchntApp tmchntApp = (TmchntApp)list.get(i);
			itemlist.add(new SelectItem(String.valueOf(tmchntApp.getId())));
		}
		return itemlist;
	}
	
	

//  end:  Generated for t_mchnt_app From Template: SelectItemUtil.java.vm
//  start:  Generated for t_riskcase_record From Template: SelectItemUtil.java.vm
	
	public List getTriskcaseRecordItems() {
		List itemlist = new ArrayList();
		TriskcaseRecordDAO triskcaseRecordDAO = (TriskcaseRecordDAO)getBean("triskcaseRecordDAO");
		List list = triskcaseRecordDAO.getTriskcaseRecordListOfQuery(this.queryMap);
		for(int i=0;i<list.size();i++) {
			TriskcaseRecord triskcaseRecord = (TriskcaseRecord)list.get(i);
			itemlist.add(new SelectItem(String.valueOf(triskcaseRecord.getId())));
		}
		return itemlist;
	}
	
	

//  end:  Generated for t_riskcase_record From Template: SelectItemUtil.java.vm
//  start:  Generated for t_riskprocess_timelimit From Template: SelectItemUtil.java.vm
	
	public List getTriskprocessTimelimitItems() {
		List itemlist = new ArrayList();
		TriskprocessTimelimitDAO triskprocessTimelimitDAO = (TriskprocessTimelimitDAO)getBean("triskprocessTimelimitDAO");
		List list = triskprocessTimelimitDAO.getTriskprocessTimelimitListOfQuery(this.queryMap);
		for(int i=0;i<list.size();i++) {
			TriskprocessTimelimit triskprocessTimelimit = (TriskprocessTimelimit)list.get(i);
			itemlist.add(new SelectItem(String.valueOf(triskprocessTimelimit.getId())));
		}
		return itemlist;
	}
	
	

//  end:  Generated for t_riskprocess_timelimit From Template: SelectItemUtil.java.vm
//  start:  Generated for t_trans_info From Template: SelectItemUtil.java.vm
	
	public List getTtransInfoItems() {
		List itemlist = new ArrayList();
		TtransInfoDAO ttransInfoDAO = (TtransInfoDAO)getBean("ttransInfoDAO");
		List list = ttransInfoDAO.getTtransInfoListOfQuery(this.queryMap);
		for(int i=0;i<list.size();i++) {
			TtransInfo ttransInfo = (TtransInfo)list.get(i);
			itemlist.add(new SelectItem(String.valueOf(ttransInfo.getId())));
		}
		return itemlist;
	}
	
	

//  end:  Generated for t_trans_info From Template: SelectItemUtil.java.vm
/*add getXXXItems() before*/
}