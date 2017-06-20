package cn.com.brilliance.begen.webapp.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Date;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import cn.com.brilliance.begen.dao.TorganizeInfoDAO;
import cn.com.brilliance.begen.dao.TruleInstanceMccDAO;
import cn.com.brilliance.begen.exception.BeGenException;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;
import cn.com.brilliance.begen.webapp.action.BasePage;
import cn.com.brilliance.begen.webapp.servlet.UserBean;
import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.common.webapp.action.FormPage;
import cn.com.brilliance.risk.ext.common.Function;
import cn.com.brilliance.risk.ext.common.NumberComparator;
import cn.com.brilliance.risk.model.comm.TruleInstanceUtil;

/**
 * TruleInstance对象Form.
 * 
 * @author Administrator.
 * 
 */
public class TruleInstanceForm extends BasePage implements FormPage {

	private TruleInstanceService service = (TruleInstanceService) getBean("truleInstanceService");
	
	private TruleInstanceGroupService truleInstanceGroupService = (TruleInstanceGroupService)getBean("truleInstanceGroupService");
	
	private TruleInstanceGroupSegmentService truleInstanceGroupSegmentService = (TruleInstanceGroupSegmentService) getBean("truleInstanceGroupSegmentService");

	private String lookupKey;

	/**
	 * truleInstance对象.
	 */
	private TruleInstance truleInstance;
 
	/**
	 * TruleInstance对象主键.
	 */
	private java.lang.String truleInstancePrimaryKey;

	public String getLookupKey() {
		return lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}

	/**
	 * Returns the TruleInstance.
	 * 
	 * @return TruleInstance.
	 */
	public TruleInstance getTruleInstance() {
		if (truleInstance == null) {
			truleInstance = new TruleInstance();
		}
		return truleInstance;
	}

	/**
	 * Sets the TruleInstance.
	 * 
	 * @param truleInstance
	 *            The truleInstance to set.
	 */
	public void setTruleInstance(TruleInstance truleInstance) {
		this.truleInstance = truleInstance;
	}

	/**
	 * Returns the truleInstancePrimaryKey.
	 * 
	 * @return TruleInstancePrimaryKey.
	 */
	public java.lang.String getTruleInstancePrimaryKey() {
		return truleInstancePrimaryKey;
	}

	/**
	 * Sets the truleInstancePrimaryKey.
	 * 
	 * @param truleInstancePrimaryKey
	 *            The TruleInstancePrimaryKey to set.
	 */
	public void setTruleInstancePrimaryKey(
			java.lang.String truleInstancePrimaryKey) {
		this.truleInstancePrimaryKey = truleInstancePrimaryKey;
		initTruleInstance();
	}

	public void initTruleInstance() {
		try {
			if (truleInstancePrimaryKey == null
					|| truleInstancePrimaryKey.equals("")) {
				return;
			}
			TruleInstance instance = service.getTruleInstance(truleInstancePrimaryKey);
			instance.set_checked_flag(true);
			this.setTruleInstance(instance);
		} catch (BeGenException e) {
			// TODO Auto-generated catch block
			this.addMessage(e.getCode(), e.getMsg(), e);
		}
	}

	/**
	 * 存储TruleInstance对象.
	 * 
	 * @return String.
	 */
	public String save() {
		try {
			if (truleInstancePrimaryKey == null
					&& this.truleInstance.getId() != null) {
				// 判断记录是否重复，并提示错误信息
				if (service.getTruleInstance(this.truleInstance.getId()) != null) {
					addMessage("error.database.duplicatekey", "ID["
							+ this.truleInstance.getId() + "]");
					return null;
				}
			}

			UserBean userBean = getUserBean();
			if (truleInstancePrimaryKey == null
					|| truleInstancePrimaryKey.equals(this.truleInstance
							.getId())) {
				this.truleInstance = service
						.saveTruleInstance(this.truleInstance);
				String key = truleInstance.getId();
				this.truleInstancePrimaryKey = key;
				if (truleInstancePrimaryKey == null) {
					addMessage("truleInstance.message.added",
							this.truleInstance.getId());
				} else {
					addMessage("truleInstance.message.saved",
							this.truleInstance.getId());
				}
			} else {
				addMessageString("exception.save.primarykey");
				return null;
			}
		} catch (BeGenException e) {
			// TODO Auto-generated catch block
			this.addMessage(e.getCode(), e.getMsg(), e);
			return getFailureAction();
		}
		return getSuccessAction();
	}

	public String saveAndNew() {
		try {
			String action = save();
			if (action == null) {
				return null;
			}
			TruleInstance truleInstance = new TruleInstance();
			this.truleInstance = truleInstance;
			truleInstancePrimaryKey = null;
		} catch (BeGenException e) {
			// TODO Auto-generated catch block
			this.addMessage(e.getCode(), e.getMsg(), e);
			return getFailureAction();
		}
		return null;
	}

	/**
	 * 删除TruleInstance对象.
	 * 
	 * @return String.
	 */
	public String delete() {
		try {
			service.delete(this.truleInstance.getId());
			CmsUtil.deleteFile("t_rule_instance/" + this.truleInstance.getId());
			addMessage("truleInstance.message.deleted", this.truleInstance
					.getId());

		} catch (BeGenException e) {
			// TODO Auto-generated catch block
			this.addMessage(e.getCode(), e.getMsg(), e);
			return getFailureAction();
		}
		return getSuccessAction();
	}

	/**
	 * 删除TruleInstance对象 (子表有数据不允许删除）.
	 * 
	 * @return String.
	 */
	public String deleteOfNoChild() {
		try {
			TruleInstance truleInstance = service
					.getTruleInstance(this.truleInstance.getId());
			service.delete(this.truleInstance.getId());
			addMessage("truleInstance.message.deleted", this.truleInstance
					.getId());

		} catch (BeGenException e) {
			// TODO Auto-generated catch block
			this.addMessage(e.getCode(), e.getMsg(), e);
			return getFailureAction();
		}
		return getSuccessAction();
	}

	public String edit() {

		return getSuccessAction();
	}

	public String getHistoryUrlParameter() {
		if (this.truleInstancePrimaryKey == null)
			return "_key=" + this.truleInstance.getId();
		return "_key=" + this.truleInstancePrimaryKey;
	}

	public String popSave() {
		this.getRequest().getSession().setAttribute("__pop_object",
				this.truleInstance);
		this.getRequest().getSession().setAttribute("__pop_data_object",
				"TruleInstance");
		return "popSuccess";
	}

	public String saveMultiAll() {
		try {
			if (truleInstancePrimaryKey == null
					&& this.truleInstance.getId() != null) {
				// 判断记录是否重复，并提示错误信息
				if (service.getTruleInstance(this.truleInstance.getId()) != null) {
					addMessage("error.database.duplicatekey", "ID["
							+ this.truleInstance.getId() + "]");
					return null;
				}
			}

			UserBean userBean = getUserBean();
			if (truleInstancePrimaryKey == null
					|| truleInstancePrimaryKey.equals(this.truleInstance
							.getId())) {
				this.truleInstance = service.saveAll(this.truleInstance);

				String key = truleInstance.getId();
				this.truleInstancePrimaryKey = key;
				if (truleInstancePrimaryKey == null) {
					addMessage("truleInstance.message.added",
							this.truleInstance.getId());
				} else {
					addMessage("truleInstance.message.saved",
							this.truleInstance.getId());
				}
			} else {
				addMessageString("exception.save.primarykey");
				return null;
			}
		} catch (BeGenException e) {
			// TODO Auto-generated catch block
			this.addMessage(e.getCode(), e.getMsg(), e);
			return getFailureAction();
		}

		return this.getSuccessAction();
	}

	public void loadTruleInstance() {
		TruleInstance truleInstance = (TruleInstance) this.getRequest()
				.getSession().getAttribute("__pop_object");
		this.truleInstance = truleInstance;
		this.getRequest().getSession().removeAttribute("__pop_object");
	}

	private void saveTruleInstanceParam(){//无机构无回溯时间未判断激活
		TruleService truleService = (TruleService) getBean("truleService");
		UserBean user = getUserBean();
		
		this.truleInstance.setCode(this.truleInstance.getCode());

		if(truleService.getTrule(this.truleInstance.getCode()).getSupportTrace().equals(new Boolean(true))){
			this.truleInstance.setSupportTrace(this.truleInstance.getSupportTrace());
		}else{
			this.truleInstance.setSupportTrace(truleService.getTrule(this.truleInstance.getCode()).getSupportTrace());
		}
		this.truleInstance.setTransInfo(truleService.getTrule(this.truleInstance.getCode()).getTransInfo());
		this.truleInstance.setType(truleService.getTrule(this.truleInstance.getCode()).getType());
		this.truleInstance.setTimeParam("1");
	}
	
	private String getMaxVersion(String code){
		TruleInstanceService truleInstanceService = (TruleInstanceService) getBean("truleInstanceService");
		Map queryFields = new HashMap();
		queryFields.put("code", code);
		List<TruleInstance> list = truleInstanceService.getTruleInstanceListOfQuery(queryFields);
		List<Integer> arrayList = new ArrayList();
		String versionBm = "";
		for (TruleInstance instance : list) {
			String str = instance.getVersionBm();
			if(null != str){
				int ver = Integer.parseInt(str.substring(4, 8));
				arrayList.add(ver);
			}
		}
		if(!arrayList.isEmpty()){
			int v = 0;
			for (Integer intVersion : arrayList) {
				if(intVersion>v){
					v = intVersion;
				}
			}
			String version = Integer.toString(v+1);
			String zero="0"; versionBm="";
			
				for (int i = 0; i < 4-version.trim().length(); i++) {
					versionBm += zero;
				}
				
				versionBm = "S"+code+versionBm+version;
		}else{
			versionBm = "S"+code+"0001";
		}
		return versionBm;
	}
	
	//belongToInst 页面上的belongToInst值    enable页面上的enable值
	public void setTruleInstanceEnable(String belongToInst,Boolean enable, List<TruleInstance> instancelist, TruleInstanceService truleInstanceService){
		if(belongToInst.equals("*")){//所有机构
			if(enable.equals(new Boolean(true))){
				Map queryFields = new HashMap();
				queryFields.put("code", this.truleInstance.getCode());
				queryFields.put("cycle", this.truleInstance.getCycle());
				List<TruleInstance> truleList = truleInstanceService.getTruleInstanceListOfQuery(queryFields);
				for (TruleInstance instance : truleList) {
					instance.setEnable(false);
					truleInstanceService.saveTruleInstance(instance);
				}
			}else{//enable为false  所有机构
				List instlist = getInsts();
				for (int i = 0; i < instlist.size(); i++) {
					Map queryFields = new HashMap();
					queryFields.put("belongToInst", belongToInst);
					queryFields.put("code", this.truleInstance.getCode());
					queryFields.put("cycle", this.truleInstance.getCycle());
					List<TruleInstance> truleList = truleInstanceService.getTruleInstanceListOfQuery(queryFields);
					int n=0;
					for (TruleInstance instance : truleList) {
						if(instance.getEnable()){
							n++;
						}
					}
					if(n==0){
						enable=true;
					}
				}
			}
		}else{//单独机构
			if(enable.equals(new Boolean(true))){
				Map queryFields = new HashMap();
				queryFields.put("belongToInst", belongToInst);
				queryFields.put("code", this.truleInstance.getCode());
				queryFields.put("cycle", this.truleInstance.getCycle());
				List<TruleInstance> truleList = truleInstanceService.getTruleInstanceListOfQuery(queryFields);
				for (TruleInstance instance : truleList) {
					instance.setEnable(false);
					truleInstanceService.saveTruleInstance(instance);
				}
			}else{//enable为false  单个机构
				Map queryFields = new HashMap();
				queryFields.put("belongToInst", belongToInst);
				queryFields.put("code", this.truleInstance.getCode());
				queryFields.put("cycle", this.truleInstance.getCycle());
				List<TruleInstance> truleList = truleInstanceService.getTruleInstanceListOfQuery(queryFields);
				int i=0;
				for (TruleInstance instance : truleList) {
					if(instance.getEnable()){
						i++;
					}
				}
				if(i==0){//数据库没有激活的，则此记录必须为激活
					enable=true;
				}
			}
		}
	}
	
	
	public String saveAllData() {
		try {
			List<TruleInstanceMcc> bigList = (List<TruleInstanceMcc>) getValueBinding("#{extTruleInstanceMccList.truleInstanceMccs}");
			
			List<TruleInstanceMcc> mccList = (List<TruleInstanceMcc>) getValueBinding("#{truleInstanceMccList.mccList}");

			TruleInstanceMccService truleInstanceMccService = (TruleInstanceMccService) getBean("truleInstanceMccService");

			TmccService tmccService = (TmccService) getBean("tmccService");

			if(mccList==null){mccList = new ArrayList<TruleInstanceMcc>();}
			
			TruleInstanceService truleInstanceService =(TruleInstanceService) getBean("truleInstanceService");
			Map instanceMap = new HashMap();
			instanceMap.put("code", this.truleInstance.getCode());//规则编码
			List<TruleInstance> instancelist = truleInstanceService.getTruleInstanceListOfQuery(instanceMap);

			if (truleInstancePrimaryKey == null && this.truleInstance.getId() != null) {
				// 判断记录是否重复，并提示错误信息
				if (service.getTruleInstance(this.truleInstance.getId()) != null) {
					addMessage("error.database.duplicatekey", "ID["
							+ this.truleInstance.getId() + "]");
					return null;
				}
			} else if (("").equals(truleInstancePrimaryKey)
					|| truleInstancePrimaryKey == null) {
				this.truleInstance.setVersionBm(getMaxVersion(this.truleInstance.getCode()));
				//子规则实例表单
				if(null==parameterNull()){return null;}
				String code = this.truleInstance.getCode();
				
				if(null==mccParamNull(code, bigList, mccList)){return null;}
				//根据不同子规则,mcc会有不同参数设置修改,为存入数据库做准备
				
				//装入临时变量用于所有机构循环
				String description = this.truleInstance.getDescription();
				String cycle = this.truleInstance.getCycle();
				String timeParam = this.truleInstance.getTimeParam();
				Date beginTraceDate = this.truleInstance.getBeginTraceDate();
				Date endTraceDate = this.truleInstance.getEndTraceDate();
				Boolean supportTrace = this.truleInstance.getSupportTrace();
				if(code.equals("R01") || code.equals("R04") || code.equals("R05") || code.equals("R06") || code.equals("R07")
						|| code.equals("R10") || code.equals("R11") || code.equals("R28") || code.equals("R31")
						|| code.equals("R35") || code.equals("R36") || code.equals("R37")){
					this.truleInstance.setSupportTrace(new Boolean(false));
					supportTrace = new Boolean(false);
				}
				Boolean enable = this.truleInstance.getEnable();
//				判断机构是否为 全部
				if(this.truleInstance.getBelongToInst().equals("*")){
					
					saveTruleInstanceParam();
					setTruleInstanceEnable(this.truleInstance.getBelongToInst(), enable, instancelist, truleInstanceService);
					if(null==parameterNull()){return null;}
					code = this.truleInstance.getCode();
					
					
					
					if(null==mccParamNull(code, bigList, mccList)){return null;}
					List instList = getInsts();//公司list
					Map queryFields = new HashMap();
					queryFields.put("code", code);
					List<TruleInstance> dblist = truleInstanceService.getTruleInstanceListOfQuery(queryFields);//暂时数据库里根据code查到的truleInstace  list
					for (int i = 0; i < instList.size(); i++) {
						TorganizeInfo info = (TorganizeInfo) instList.get(i);
						TruleInstance truleInstance = new TruleInstance();
						truleInstance.setDescription(description);
//						setTruleInstanceEnable(dblist, truleInstanceService, enable, instList, truleInstance);
						truleInstance.setEnable(enable);
						truleInstance.setCycle(cycle);
						truleInstance.setTimeParam(timeParam);
						truleInstance.setBeginTraceDate(beginTraceDate);
						truleInstance.setEndTraceDate(endTraceDate);
						truleInstance.setSupportTrace(supportTrace);
						truleInstance.setBelongToInst(info.getId());
						truleInstance.setCode(code);
						truleInstance.setVersionBm(getMaxVersion(code));
						truleInstance.setId("");
						truleInstance.setType("1");
						
						truleInstance = service.saveTruleInstance(truleInstance);
						String truleInstanceId = truleInstance.getId();
						if(null == saveMcc( bigList, mccList, truleInstanceId, truleInstanceMccService, truleInstanceService, tmccService)){return null;}
					}
					addMessage("truleInstance.message.added", "全部");
				}else{
					setTruleInstanceEnable(this.truleInstance.getBelongToInst(), enable, instancelist, truleInstanceService);
					this.truleInstance.setType("1");
					TruleInstance truleInstance = service.saveTruleInstance(this.truleInstance);
					String truleInstanceId = truleInstance.getId();
					if(null == saveMcc( bigList, mccList, truleInstanceId, truleInstanceMccService, truleInstanceService, tmccService)){return null;}
				}
			} else {//编辑
				String oldruleInstanceId = this.truleInstance.getId();
				String oldbelongToInst = this.truleInstance.getBelongToInst();
				
				this.truleInstance.setVersionBm(getMaxVersion(this.truleInstance.getCode()));
				
				if(null==parameterNull()){return null;}
				String code = this.truleInstance.getCode();
				
				
				
				if(null==mccParamNull(code, bigList, mccList)){return null;}
				String description = this.truleInstance.getDescription();
				Boolean enable = this.truleInstance.getEnable();
				String cycle = this.truleInstance.getCycle();
				String timeParam = this.truleInstance.getTimeParam();
				Date beginTraceDate = this.truleInstance.getBeginTraceDate();
				Date endTraceDate = this.truleInstance.getEndTraceDate();
				Boolean supportTrace = this.truleInstance.getSupportTrace();
				if(code.equals("R01") || code.equals("R04") || code.equals("R05") || code.equals("R06") || code.equals("R07")
						|| code.equals("R10") || code.equals("R11") || code.equals("R28") || code.equals("R31")
						|| code.equals("R35") || code.equals("R36") || code.equals("R37")){
					this.truleInstance.setSupportTrace(new Boolean(false));
					supportTrace = new Boolean(false);
				}
				setTruleInstanceEnable(this.truleInstance.getBelongToInst(), enable, instancelist, truleInstanceService);
				
				this.truleInstance.setId("");
				
				if(this.truleInstance.getBelongToInst().equals("*")){
					List instList = getInsts();
					saveTruleInstanceParam();
					List list = getInsts();
					Map queryFields = new HashMap();
					queryFields.put("code", code);
					List<TruleInstance> dblist = truleInstanceService.getTruleInstanceListOfQuery(queryFields);
//					setTruleInstanceEnable(dblist, truleInstanceService, enable, instList, truleInstance);
					for (int i = 0; i < list.size(); i++) {
						TorganizeInfo info = (TorganizeInfo) list.get(i);
						TruleInstance truleInstance = new TruleInstance();
						truleInstance.setDescription(description);

						truleInstance.setEnable(enable);
						truleInstance.setCycle(cycle);
						truleInstance.setTimeParam(timeParam);
						truleInstance.setBeginTraceDate(beginTraceDate);
						truleInstance.setEndTraceDate(endTraceDate);
						truleInstance.setSupportTrace(supportTrace);
						truleInstance.setBelongToInst(info.getId());
						truleInstance.setCode(code);
						truleInstance.setVersionBm(getMaxVersion(code));
						truleInstance.setId("");
						
						truleInstance = service.saveTruleInstance(truleInstance);
						String truleInstanceId = truleInstance.getId();

						if(null == saveMcc(bigList, mccList, truleInstanceId, truleInstanceMccService, truleInstanceService, tmccService)){return null;}
						
						String belongToInst = truleInstance.getBelongToInst();
						if (belongToInst.equals(oldbelongToInst)) {
							updateRuleGroup(oldruleInstanceId, truleInstanceId);
						}
						
					}
					addMessage("truleInstance.message.added", "全部");
				}else{
					setTruleInstanceEnable(this.truleInstance.getBelongToInst(), enable, instancelist, truleInstanceService);
					TruleInstance truleInstance = service.saveTruleInstance(this.truleInstance);

					String truleInstanceId = truleInstance.getId();
					
					String belongToInst = truleInstance.getBelongToInst();
					if (belongToInst.equals(oldbelongToInst)) {
						updateRuleGroup(oldruleInstanceId, truleInstanceId);
					}
					
					if(null == saveMcc( bigList, mccList, truleInstanceId, truleInstanceMccService, truleInstanceService, tmccService)){return null;}
				}
			}
		} catch (BeGenException e) {
			// TODO Auto-generated catch block
			this.addMessage(e.getCode(), e.getMsg(), e);
			return getFailureAction();
		}

		return "t_rule_instance/t_rule_instance_list_List";

	}
	
	private void updateRuleGroup(String oldruleInstanceId, String ruleInstanceId) {
		Map queryFields = new HashMap();
		queryFields.put("ruleInstanceId", oldruleInstanceId);
		List<TruleInstanceGroup> ruleInstanceGroupList = truleInstanceGroupService
				.getTruleInstanceGroupListOfQuery(queryFields);
		for (TruleInstanceGroup tg : ruleInstanceGroupList) {
			tg.setRuleInstanceId(ruleInstanceId);
			truleInstanceGroupService.saveTruleInstanceGroup(tg);
		}
		queryFields = new HashMap();
		queryFields.put("ruleInstanceId", oldruleInstanceId);
		List<TruleInstanceGroupSegment> ruleSegmentList = truleInstanceGroupSegmentService
				.getTruleInstanceGroupSegmentListOfQuery(queryFields);
		for (TruleInstanceGroupSegment tgs : ruleSegmentList) {
			tgs.setRuleInstanceId(ruleInstanceId);
			truleInstanceGroupSegmentService.saveTruleInstanceGroupSegment(tgs);
		}
	}

	public String saveAllData2() {
		try {
			List<TruleInstanceMcc> bigList = (List<TruleInstanceMcc>) getValueBinding("#{extTruleInstanceMccList.truleInstanceMccs}");

			List<TruleInstanceMcc> mccList = (List<TruleInstanceMcc>) getValueBinding("#{truleInstanceMccList.mccList}");
			
			TruleInstanceMccService truleInstanceMccService = (TruleInstanceMccService) getBean("truleInstanceMccService");

			TmccService tmccService = (TmccService) getBean("tmccService");
			UserBean userBean = getUserBean();

			if(mccList==null){mccList = new ArrayList<TruleInstanceMcc>();}
			
			TruleInstanceService truleInstanceService =(TruleInstanceService) getBean("truleInstanceService");
			Map instanceMap = new HashMap();
			instanceMap.put("code", this.truleInstance.getCode());//规则编码
			List<TruleInstance> instancelist = truleInstanceService.getTruleInstanceListOfQuery(instanceMap);
//			setTruleInstanceEnable(instancelist, truleInstanceService);
			if (truleInstancePrimaryKey == null && this.truleInstance.getId() != null) {
				// 判断记录是否重复，并提示错误信息
				if (service.getTruleInstance(this.truleInstance.getId()) != null) {
					addMessage("error.database.duplicatekey", "ID["
							+ this.truleInstance.getId() + "]");
					return null;
				}
			} else if (("").equals(truleInstancePrimaryKey)
					|| truleInstancePrimaryKey == null) {
				this.truleInstance.setVersionBm(getMaxVersion(this.truleInstance.getCode()));
				if(null==parameterNull()){return null;}
				String code = this.truleInstance.getCode();
				if(null==mccParamNull(code, bigList, mccList)){return null;}
				String description = this.truleInstance.getDescription();
				Boolean enable = this.truleInstance.getEnable();
				String cycle = this.truleInstance.getCycle();
				String timeParam = this.truleInstance.getTimeParam();
				Date beginTraceDate = this.truleInstance.getBeginTraceDate();
				Date endTraceDate = this.truleInstance.getEndTraceDate();
				Boolean supportTrace = this.truleInstance.getSupportTrace();
				if(code.equals("R01") || code.equals("R04") || code.equals("R05") || code.equals("R06") || code.equals("R07")
						|| code.equals("R10") || code.equals("R11") || code.equals("R28") || code.equals("R31")
						|| code.equals("R35") || code.equals("R36") || code.equals("R37")){
					this.truleInstance.setSupportTrace(new Boolean(false));
					supportTrace = new Boolean(false);
				}

				//全部机构判断
				if(this.truleInstance.getBelongToInst().equals("*")){
					setTruleInstanceEnable(this.truleInstance.getBelongToInst(), enable, instancelist, truleInstanceService);
					saveTruleInstanceParam();
//					setTruleInstanceEnable(instancelist, truleInstanceService);
					if(null==parameterNull()){return null;}
					code = this.truleInstance.getCode();
					if(null==mccParamNull(code, bigList, mccList)){return null;}
					List instList = getInsts();//公司list
					Map queryFields = new HashMap();
					queryFields.put("code", code);
					List<TruleInstance> dblist = truleInstanceService.getTruleInstanceListOfQuery(queryFields);//暂时数据库里根据code查到的truleInstace  list
					
					for (int i = 0; i < instList.size(); i++) {
						TorganizeInfo info = (TorganizeInfo) instList.get(i);
						TruleInstance truleInstance = new TruleInstance();
						truleInstance.setDescription(description);
//						setTruleInstanceEnable(dblist, truleInstanceService, enable, instList, truleInstance);
						truleInstance.setEnable(enable);
						truleInstance.setCycle(cycle);
						truleInstance.setTimeParam(timeParam);
						truleInstance.setBeginTraceDate(beginTraceDate);
						truleInstance.setEndTraceDate(endTraceDate);
						truleInstance.setSupportTrace(supportTrace);
						truleInstance.setBelongToInst(info.getId());
						truleInstance.setCode(code);
						truleInstance.setVersionBm(getMaxVersion(code));
						truleInstance.setId("");
						truleInstance.setType("1");
						
						truleInstance = service.saveTruleInstance(truleInstance);
						String truleInstanceId = truleInstance.getId();
						
						if(null == saveMcc2(truleInstanceMccService, bigList, truleInstanceId)){return null;}
					}
					addMessage("truleInstance.message.added", "全部");
				}else{//单个所属机构
					setTruleInstanceEnable(this.truleInstance.getBelongToInst(), enable, instancelist, truleInstanceService);
					this.truleInstance.setType("1");
					this.truleInstance = service.saveTruleInstance(this.truleInstance);
//				取得参数设置
					String truleInstanceId = truleInstance.getId();
					try {
						if(null==saveMcc2(truleInstanceMccService, bigList, truleInstanceId)){return null;}
						addMessage("truleInstance.message.added", this.truleInstance.getId());
					} catch (BeGenException be) {
						this.addMessage(be.getCode(), be.getMsg(), be);
						truleInstanceService.rollback();
						return null;
					}	
				}
			} else {//编辑页面
				String oldruleInstanceId = this.truleInstance.getId();
				String oldbelongToInst = this.truleInstance.getBelongToInst();
				
				this.truleInstance.setVersionBm(getMaxVersion(this.truleInstance.getCode()));
				if(null==parameterNull()){return null;}
				String code = this.truleInstance.getCode();
				if(null==mccParamNull(code, bigList, mccList)){return null;}
				String description = this.truleInstance.getDescription();
				Boolean enable = this.truleInstance.getEnable();
				String cycle = this.truleInstance.getCycle();
				String timeParam = this.truleInstance.getTimeParam();
				Date beginTraceDate = this.truleInstance.getBeginTraceDate();
				Date endTraceDate = this.truleInstance.getEndTraceDate();
				Boolean supportTrace = this.truleInstance.getSupportTrace();
				if(code.equals("R01") || code.equals("R04") || code.equals("R05") || code.equals("R06") || code.equals("R07")
						|| code.equals("R10") || code.equals("R11") || code.equals("R28") || code.equals("R31")
						|| code.equals("R35") || code.equals("R36") || code.equals("R37")){
					this.truleInstance.setSupportTrace(new Boolean(false));
					supportTrace = new Boolean(false);
				}
				
				this.truleInstance.setId("");
				
				
				if(this.truleInstance.getBelongToInst().equals("*")){//无mcc编辑页面 全部机构
					setTruleInstanceEnable(this.truleInstance.getBelongToInst(), enable, instancelist, truleInstanceService);
					List instList = getInsts();
					saveTruleInstanceParam();
					List list = getInsts();
					Map queryFields = new HashMap();
					queryFields.put("code", code);
					List<TruleInstance> dblist = truleInstanceService.getTruleInstanceListOfQuery(queryFields);
//					setTruleInstanceEnable(dblist, truleInstanceService, enable, instList, truleInstance);
					for (int i = 0; i < list.size(); i++) {
						TorganizeInfo info = (TorganizeInfo) list.get(i);
						TruleInstance truleInstance = new TruleInstance();
						truleInstance.setDescription(description);

						truleInstance.setEnable(enable);
						truleInstance.setCycle(cycle);
						truleInstance.setTimeParam(timeParam);
						truleInstance.setBeginTraceDate(beginTraceDate);
						truleInstance.setEndTraceDate(endTraceDate);
						truleInstance.setSupportTrace(supportTrace);
						truleInstance.setBelongToInst(info.getId());
						truleInstance.setCode(code);
						truleInstance.setVersionBm(getMaxVersion(code));
						truleInstance.setId("");
						
						truleInstance = service.saveTruleInstance(truleInstance);
						String truleInstanceId = truleInstance.getId();
						
						String belongToInst = truleInstance.getBelongToInst();
						if (belongToInst.equals(oldbelongToInst)) {
							updateRuleGroup(oldruleInstanceId, truleInstanceId);
						}
						if(null == saveMcc2(truleInstanceMccService, bigList, truleInstanceId)){return null;}
						
					}
					addMessage("truleInstance.message.added", "全部");
				}else{//无mcc编辑页面 单个
					setTruleInstanceEnable(this.truleInstance.getBelongToInst(), enable, instancelist, truleInstanceService);
					this.truleInstance = service.saveTruleInstance(this.truleInstance);

					String truleInstanceId = truleInstance.getId();
					
					String belongToInst = truleInstance.getBelongToInst();
					if (belongToInst.equals(oldbelongToInst)) {
						updateRuleGroup(oldruleInstanceId, truleInstanceId);
					}
					if(null == saveMcc2(truleInstanceMccService, bigList, truleInstanceId)){return null;}
					addMessage("truleInstance.message.added", this.truleInstance.getId());
				}
			}
		} catch (BeGenException e) {
			this.addMessage(e.getCode(), e.getMsg(), e);
			return getFailureAction();
		}
		return "t_rule_instance/t_rule_instance_list_List";

	}
	
	public boolean isRightDate(Date beginDate, Date endDate){
		boolean flag = false;
		if(beginDate.equals(endDate) && this.truleInstance.getCycle().equals("1")){
			flag = true;
		}
		if(Tools.isOneWeek(beginDate, endDate) && this.truleInstance.getCycle().equals("2")){
			flag = true;
		}
		if(Tools.isHalfOneMonth(beginDate, endDate) && this.truleInstance.getCycle().equals("3")){
			flag = true;
		}
		if(Tools.isOneMonth(beginDate, endDate) && this.truleInstance.getCycle().equals("4")){
			flag = true;
		}
		return flag;
	}

	public List getCycleNames(){
		List list = new ArrayList();list.add("");
		list.add("天");list.add("周");
		list.add("半月");list.add("月");
		return list ;
	}
	
	public String parameterNull(){
		if(truleInstance.getCode()==null||("").equals(truleInstance.getCode())){
			addMessage("truleInstance.code.message.isNull", "["+truleInstance.getCode()+"]");
			return null;
		}
		if(truleInstance.getDescription()==null||("").equals(truleInstance.getDescription())){
			addMessage("truleInstance.description.message.isNull", "["+truleInstance.getDescription()+"]");
			return null;
		}
		if(truleInstance.getTimeParam()==null||("").equals(truleInstance.getTimeParam())){
			addMessage("truleInstance.timeParam.message.isNull", "["+truleInstance.getTimeParam()+"]");
			return null;
		}
		if(null != this.truleInstance.getBeginTraceDate() && null != this.truleInstance.getEndTraceDate()){
			if(this.isRightDate(this.truleInstance.getBeginTraceDate(), this.truleInstance.getEndTraceDate())==false){
				addMessage("truleInstance.cycle.beginEndDate.isFalse", "["
						+ getCycleNames().get(Integer.parseInt(this.truleInstance.getCycle())) + "]");
				return null;
			}
		}
		return "empty";
	}

	
	public String mccParamNull(String code, List<TruleInstanceMcc> bigList, List<TruleInstanceMcc> mccList){
		for (int i = 0; i < bigList.size(); i++) {
//			五大类参数1判断
			if(bigList.get(i).getParam1() == null||"".equals(bigList.get(i).getParam1())){
				if(!code.equals("R18")){
					addMessage("truleInstance.bigList.isNull", "[ 参数1 ]");
					return null;
				}
			}else{
				if(code.equals("R02")||code.equals("R03")||code.equals("R04")||code.equals("R05")||code.equals("R09")||code.equals("R28")
						||code.equals("R11")||code.equals("R16")||code.equals("R17")||code.equals("R16")||code.equals("R35")||code.equals("R36")){
					if(null==resetMccDecimal(bigList.get(i).getParam1())) return null;
				}
				if(code.equals("R01")||code.equals("R08")||code.equals("R15")||code.equals("R20")||code.equals("R29")){
					if(null==resetMccNumeric(bigList.get(i).getParam1())){ return null;}else{
						bigList.get(i).setParam1(Integer.toString(Integer.parseInt(bigList.get(i).getParam1())*100));
					}
				}
				if(code.equals("R06")||code.equals("R07")||code.equals("R10")||code.equals("R14")||code.equals("R19")||code.equals("R25")||code.equals("R26")
						||code.equals("R37")){
					if(null==resetMccNumeric(bigList.get(i).getParam1())) return null;
				}
				if(code.equals("R13")){
					if(null==resetMccRightTime(bigList.get(i).getParam1())) return null;
				}
				if(code.equals("R14")||code.equals("R15")||code.equals("R29")||code.equals("R19")){
					if(Integer.parseInt(bigList.get(i).getParam1())==0){
						if(code.equals("R14")) addMessageString("退单笔数   必须大于0");
						if(code.equals("R15")) addMessageString("退单金额   必须大于0");
						if(code.equals("R29")) addMessageString("预警系数   必须大于0");
						if(code.equals("R19")) addMessageString("交易总笔数小阀值    必须大于0");
						return null;
					}
				}
			}
//			五大类参数2判断
			if (code.equals("R13")||code.equals("R10")||code.equals("R31")||code.equals("R08")) {
				if (bigList.get(i).getParam2()==null||"".equals(bigList.get(i).getParam2())) {
					addMessage("truleInstance.bigList.isNull", "[ 参数2 ]");
					return null;
				}else{
					if(code.equals("R08")){
						if(null==resetMccDecimal(bigList.get(i).getParam2())) return null;
					}
					if(code.equals("R10")){
						if(null==resetMccBgthan1(bigList.get(i).getParam2())) return null;
					}
					if(code.equals("R13")){
						if(null==resetMccRightTime(bigList.get(i).getParam2())) return null;
					}

				}
			}
			if(code.equals("R20")||code.equals("R19")){
				if (bigList.get(i).getParam2()==null||"".equals(bigList.get(i).getParam2())) {
					bigList.get(i).setParam2("99999999999999999999");//设为最大值49...9中间9个9
				}else{
					if(code.equals("R19")){
						if(null==resetMccNumeric(bigList.get(i).getParam2())) return null;
					}else{
						if(Integer.parseInt(bigList.get(i).getParam2())==0){
							addMessageString("交易总笔数大阀值   必须大于0");
							return null;
						}
					}
					if(code.equals("R20")){
						if(null==resetMccNumeric(bigList.get(i).getParam2())){ return null;}else{
							bigList.get(i).setParam2(Integer.toString(Integer.parseInt(bigList.get(i).getParam2())*100));
						}
					}
				}
			}
			
			if(code.equals("R13")||code.equals("R31")){
				if (bigList.get(i).getParam3()==null||"".equals(bigList.get(i).getParam3())) {
					addMessage("truleInstance.bigList.isNull", "[ 参数3 ]");
					return null;
				}
			}
			if(code.equals("R13")){
				if (bigList.get(i).getParam3()!=null||!"".equals(bigList.get(i).getParam3())) {
					if(Integer.parseInt(bigList.get(i).getParam3())==0){
						addMessageString("该段时间的商户累计触发交易笔数   必须大于0");
						return null;
					}
				}
			}
			
			//判断最大值>最小值
			if(code.equals("R20")||code.equals("R19")){
				if(null==resetMccStr2BiggerThanStr(bigList.get(i).getParam1(), bigList.get(i).getParam2())
						&& !bigList.get(i).getParam2().equals("4999999999")) {
					return null;
				}
			}
		}
		if(!mccList.isEmpty()){
			for (int i = 0; i < mccList.size(); i++){
//				MCC参数1判断
				if(mccList.get(i).getParam1()==null||"".equals(mccList.get(i).getParam1())){
					if(!code.equals("R18")){
						addMessage("truleInstance.mccList.isNull", "[ 参数1 ]");
						return null;
					}
				}else{
					if(code.equals("R02")||code.equals("R03")||code.equals("R04")||code.equals("R05")||code.equals("R09")||code.equals("R28")
							||code.equals("R11")||code.equals("R16")||code.equals("R17")||code.equals("R16")||code.equals("R35")||code.equals("R36")){
						if(null==resetMccDecimal(mccList.get(i).getParam1())) return null;
					}
					if(code.equals("R01")||code.equals("R08")||code.equals("R15")||code.equals("R20")||code.equals("R29")){
						if(null==resetMccNumeric(mccList.get(i).getParam1())){ return null;}else{
							mccList.get(i).setParam1(Integer.toString(Integer.parseInt(mccList.get(i).getParam1())*100));
						}
					}
					if(code.equals("R14")||code.equals("R19")||code.equals("R25")||code.equals("R26")){
						if(null==resetMccNumeric(mccList.get(i).getParam1())) return null;
					}
					if(code.equals("R13")){
						if(null==resetMccRightTime(mccList.get(i).getParam1())) return null;
					}
					if(code.equals("R14")||code.equals("R15")||code.equals("R29")||code.equals("R19")){
						if(Integer.parseInt(mccList.get(i).getParam1())==0){
							if(code.equals("R14")) addMessageString("退单笔数   必须大于0");
							if(code.equals("R15")) addMessageString("退单金额   必须大于0");
							if(code.equals("R29")) addMessageString("预警系数   必须大于0");
							if(code.equals("R19")) addMessageString("交易总笔数小阀值    必须大于0");
							return null;
						}
					}
				}
//				MCC参数2判断
				if (code.equals("R13")||code.equals("R10")||code.equals("R31")||code.equals("R08")) {
					if (mccList.get(i).getParam2()==null||"".equals(mccList.get(i).getParam2())) {
						addMessage("truleInstance.mccList.isNull", "[ 参数2 ]");
						return null;
					}else{
						if(code.equals("R13")){
							if(null==resetMccRightTime(mccList.get(i).getParam2())) return null;
						}
						if(code.equals("R08")){
							if(null==resetMccDecimal(mccList.get(i).getParam2())) return null;
						}
					}
				}else{
					if(code.equals("R10")){
						if(null==resetMccDecimal(mccList.get(i).getParam2())) return null;
					}
				}
				if(code.equals("R20")||code.equals("R19")){
					if (mccList.get(i).getParam2()==null||"".equals(mccList.get(i).getParam2())) {
						mccList.get(i).setParam2("99999999999999999999");//设为数据库最大值，20个9
					}else{
						if(code.equals("R19")){
							if(null==resetMccNumeric(mccList.get(i).getParam2())) return null;
						}else{
							if(Integer.parseInt(mccList.get(i).getParam2())==0){
								addMessageString("交易总笔数大阀值   必须大于0");
								return null;
							}
						}
						if(code.equals("R20")){
							if(null==resetMccNumeric(mccList.get(i).getParam2())){ return null;}else{
								mccList.get(i).setParam2(Integer.toString(Integer.parseInt(mccList.get(i).getParam2())*100));
							}
						}
					}
				}
				if(code.equals("R13")){
					if (mccList.get(i).getParam3()==null||"".equals(mccList.get(i).getParam3())) {
						addMessage("truleInstance.bigList.isNull", "[ 参数3 ]");
						return null;
					}else{
						if(Integer.parseInt(mccList.get(i).getParam3())==0){
							addMessageString("该段时间的商户累计触发交易笔数   必须大于0");
							return null;
						}
					}
				}
				if(code.equals("R20")||code.equals("R19")){
					if(null==resetMccStr2BiggerThanStr(mccList.get(i).getParam1(), mccList.get(i).getParam2())) {return null;}
				}
			}
		}
		
		return "empty";
	}
	
	public String resetMccStr2BiggerThanStr(String str, String str2){
		if(str2.equals("99999999999999999999") || str2.equals("")){
			return "empty";
		}
		int s2 = Integer.parseInt(str2);
		int s1 = Integer.parseInt(str);
		if(s1>=s2){
			addMessage("truleInstance.R20.Param2BiggerThanParam1", "["+"参数2  必须大于 参数1"+"]");
			return null;
		}		
		return "empty";
	}
	
	public String resetMccNumeric(String str){
			if(TruleInstanceUtil.isNumeric(str)){
			}else{
				addMessage("truleInstance.isNotNumeric", "[ 参数 ]");
				return null;
			}
		return "empty";
	}
	
	public String resetMccDecimal(String str){
		if(TruleInstanceUtil.isDecimal(str)){
		}else{
			addMessage("truleInstance.isNotDecimal", "[ 参数 ]");
			return null;
		}
		return "empty";
	}
	
	public String resetMccRightTime(String str){
		if(TruleInstanceUtil.isRightTime(str)){
		}else{
			addMessage("truleInstance.isNotRightTime", "[参数]");
			return null;
		}
		return "empty";
	}
	
	public String resetMccBgthan1(String str){
		if(TruleInstanceUtil.resetMccBgthan1(str)){
			
		}else{
			addMessage("truleInstance.isNotBiggerThan1", "[ 参数 ]");
			return null;
		}
		return "empty";
	}
	
	public String resetMccRightPeriod(String beginDate, String endDate){
			if(TruleInstanceUtil.isRightDatePeriod(beginDate, endDate)){
			}else{
				addMessage("truleInstance.R31.date", "[开始时间和结束时间]");
				return null;
			}
		return "empty";
	}
	
	public String saveMcc( List<TruleInstanceMcc> bigList, List<TruleInstanceMcc> mccList, String truleInstanceId, TruleInstanceMccService truleInstanceMccService, TruleInstanceService truleInstanceService, TmccService tmccService){
		//bigList 五大类  mccList mcc  truleInstanceId 表单保存后的id  
		List temp = new ArrayList();
		for (TruleInstanceMcc mcc : mccList) {
			temp.add(mcc.getMccIdOfTmcc().getMccCode());
		}
		int k=0;
		for (int i = 0; i < temp.size(); i++) {
			for (TruleInstanceMcc mcc : mccList) {
				if(mcc.getMccIdOfTmcc().getMccCode().equals(temp.get(i))){
					k++;
					if(k==2){
						addMessage("mcc.mccCode.multiple", "["+mcc.getMccIdOfTmcc().getMccCode()+"-"+mcc.getMccIdOfTmcc().getMccName()+"]");
						return null;
					}
				}
			}
			k=0;
		}
		try {
			for (TruleInstanceMcc bigmcc : bigList) {
				bigmcc.setRuleInstanceId(truleInstanceId);

				Map queryFields = new HashMap();
				queryFields.put("bigmccCode", bigmcc.getBigmccCode());
				List<Tmcc> tmccList = tmccService.getTmccListOfQuery(queryFields);
				bigmcc.setMccId(tmccList.get(0).getId());
				bigmcc.setMccCode("*");

				if (bigmcc.getMccId() == null) {
					addMessage("bigmcc.mccId.message.isNull", "[" + bigmcc.getMccId() + "]");
					return null;
				}
				if (bigmcc.getRuleInstanceId() == null) {
					addMessage("bigmcc.ruleInstanceId.message.isNull", "[" + bigmcc.getRuleInstanceId() + "]");
					return null;
				}
				truleInstanceMccService.saveTruleInstanceMcc(bigmcc);
			}
		} catch (BeGenException be) {
			this.addMessage(be.getCode(), be.getMsg(), be);
			truleInstanceService.rollback();
			return null;
			
		}	
		try {
			for (TruleInstanceMcc mcc : mccList) {
				TruleInstanceMcc mcc2 = new TruleInstanceMcc();
				mcc2.setParam1(mcc.getParam1());
				mcc2.setParam2(mcc.getParam2());
				if(mcc.getParam3()!=null && !"".equals(mcc.getParam3())){
					mcc2.setParam3(mcc.getParam3());
				}
				mcc2.setRuleInstanceId(truleInstanceId);
				mcc2.setMccCode(mcc.getMccIdOfTmcc().getMccCode());
				mcc2.setBigmccCode(mcc.getMccIdOfTmcc().getBigmccCode());
				if (mcc2.getRuleInstanceId() == null) {
					addMessage("mcc.ruleInstanceId.message.isNull", "["
							+ mcc2.getRuleInstanceId() + "]");
					return null;
				}
				mcc2.setMccId(mcc.getMccId());

				truleInstanceMccService.saveTruleInstanceMcc(mcc2);
			}
			if(this.truleInstance.getBelongToInst().equals("*")){
				
			}else{
				addMessage("truleInstance.message.added",
						truleInstanceId);
			}
		} catch (BeGenException be) {
			// TODO: handle exception
			this.addMessage(be.getCode(), be.getMsg(), be);
			
			truleInstanceMccService.rollback();
			return null;
			
		}
		return "empty";
	}
	
	public List getInsts() {
		UserBean userBean = getUserBean();
		return Function.getParentCompanyList(userBean);
	}
	
	public String saveMcc2(TruleInstanceMccService truleInstanceMccService, List<TruleInstanceMcc> bigList, String truleInstanceId){
		for (TruleInstanceMcc bigmcc : bigList) {
			TruleInstanceMcc mcc = new TruleInstanceMcc();
			mcc.setParam1(bigmcc.getParam1());
			mcc.setParam2(bigmcc.getParam2());
			if(this.truleInstance.getCode().equals("R31")){
				if(null==resetMccRightPeriod(bigmcc.getParam1(), bigmcc.getParam2())){
					addMessage("truleInstance.R31.date", "[开始时间和结束时间]");
					return null;
				}else{
					String param1 = bigmcc.getParam1().substring(0, 4)+bigmcc.getParam1().substring(5, 7)+bigmcc.getParam1().substring(8, 10);
					mcc.setParam1(param1);
					String param2 = bigmcc.getParam2().substring(0, 4)+bigmcc.getParam2().substring(5, 7)+bigmcc.getParam2().substring(8, 10);
					mcc.setParam2(param2);
					mcc.setParam3(bigmcc.getParam3());
					addMessage("truleInstance.message.added",
							this.truleInstance.getId());
				}
			}



			mcc.setRuleInstanceId(truleInstanceId);

			mcc.setBigmccCode("*");
			mcc.setMccId("742");//五大类中随便填找tule表的一个ID置入
			mcc.setMccCode("*");

			if (mcc.getMccId() == null) {
				addMessage("bigmcc.mccId.message.isNull", "["+ mcc.getMccId() + "]");
				return null;
			}
			if (mcc.getRuleInstanceId() == null) {
				addMessage("bigmcc.ruleInstanceId.message.isNull", "[" + mcc.getRuleInstanceId() + "]");
				return null;
			}
			truleInstanceMccService.saveTruleInstanceMcc(mcc);
		}
		return "empty";
	}
	
	public List getCycles() {
		HttpServletRequest request = (HttpServletRequest) FacesContext
		.getCurrentInstance().getExternalContext().getRequest();
		String cycle = request.getParameter("cycle");
		List cycleList = null;
		if(cycle == null || "".equals(cycle)){
			TruleService truleService = (TruleService) getBean("truleService");
			Trule trule = truleService.getTrule(this.truleInstance.getCode());
			String truleCycle = trule.getCycle();
			cycleList = cyclesToolList(truleCycle, cycleList);
		}else{
			cycleList = cyclesToolList(cycle, cycleList);
		}
		return cycleList;
	}
	
	private List cyclesToolList(String cycle, List cycleList){
		char[] ch;
		ch = cycle.toCharArray();
		Map<String,String> cycleMap = new HashMap();
		if(ch[0]=='1'){
			cycleMap.put("1","天");
		}
		if(ch[1]=='1'){
			cycleMap.put("2","周");
		}
		if(ch[2]=='1'){
			cycleMap.put("3","半月");
		}
		if(ch[3]=='1'){
			cycleMap.put("4","月");
		}
		
		List list = new ArrayList();
		for (Iterator iter = cycleMap.keySet().iterator(); iter.hasNext();) {
			String str = (String) iter.next();
			list.add(str);
		}
		Comparator c = new NumberComparator();
		Collections.sort(list, c);
		cycleList = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			String value = String.valueOf(list.get(i));
			cycleList.add(new SelectItem(value,cycleMap.get(value)));
		}
		return cycleList;
	}
}
