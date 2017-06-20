package cn.com.brilliance.begen.webapp.action;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.common.webapp.action.FormPage;
import cn.com.brilliance.begen.exception.BeGenException;
import cn.com.brilliance.begen.model.TorganizeInfo;
import cn.com.brilliance.begen.model.TruleGroup;
import cn.com.brilliance.begen.model.TruleInstance;
import cn.com.brilliance.begen.model.TruleInstanceGroup;
import cn.com.brilliance.begen.model.TruleInstanceGroupSegment;
import cn.com.brilliance.begen.service.TruleGroupService;
import cn.com.brilliance.begen.service.TruleInstanceGroupSegmentService;
import cn.com.brilliance.begen.service.TruleInstanceGroupService;
import cn.com.brilliance.begen.service.TruleInstanceService;
import cn.com.brilliance.begen.webapp.servlet.UserBean;
import cn.com.brilliance.risk.ext.common.Function;
import cn.com.brilliance.risk.ext.common.LimitComparator;
import cn.com.brilliance.risk.ext.common.TruleInstanceComparator;

/**
 * TruleGroup����Form.
 * 
 * @author Administrator.
 * 
 */
public class TruleGroupForm extends BasePage implements FormPage {

	private TruleGroupService service = (TruleGroupService) getBean("truleGroupService");

	private TruleInstanceGroupSegmentService truleInstanceGroupSegmentService = (TruleInstanceGroupSegmentService) getBean("truleInstanceGroupSegmentService");

	private TruleInstanceGroupService truleInstanceGroupService = (TruleInstanceGroupService) getBean("truleInstanceGroupService");

	private TruleInstanceService truleInstanceService = (TruleInstanceService) getBean("truleInstanceService");

	private String lookupKey;

	/**
	 * truleGroup����.
	 */
	private TruleGroup truleGroup;

	/**
	 * TruleGroup��������.
	 */
	private java.lang.String truleGroupPrimaryKey;

	public String getLookupKey() {
		return lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}

	/**
	 * Returns the TruleGroup.
	 * 
	 * @return TruleGroup.
	 */
	public TruleGroup getTruleGroup() {
		if (truleGroup == null) {
			truleGroup = new TruleGroup();
		}
		return truleGroup;
	}

	/**
	 * Sets the TruleGroup.
	 * 
	 * @param truleGroup
	 *            The truleGroup to set.
	 */
	public void setTruleGroup(TruleGroup truleGroup) {
		this.truleGroup = truleGroup;
	}

	/**
	 * Returns the truleGroupPrimaryKey.
	 * 
	 * @return TruleGroupPrimaryKey.
	 */
	public java.lang.String getTruleGroupPrimaryKey() {
		return truleGroupPrimaryKey;
	}

	/**
	 * Sets the truleGroupPrimaryKey.
	 * 
	 * @param truleGroupPrimaryKey
	 *            The TruleGroupPrimaryKey to set.
	 */
	public void setTruleGroupPrimaryKey(java.lang.String truleGroupPrimaryKey) {
		this.truleGroupPrimaryKey = truleGroupPrimaryKey;
		initTruleGroup();
	}

	public void initTruleGroup() {
		try {
			if (truleGroupPrimaryKey == null || truleGroupPrimaryKey.equals("")) {
				return;
			}
			this.setTruleGroup(service.getTruleGroup(truleGroupPrimaryKey));
		} catch (BeGenException e) {
			// TODO Auto-generated catch block
			this.addMessage(e.getCode(), e.getMsg(), e);
		}
	}

	/**
	 * �洢TruleGroup����.
	 * 
	 * @return String.
	 */
	public String save() {
		try {
			if (truleGroupPrimaryKey == null && this.truleGroup.getId() != null) {
				// �жϼ�¼�Ƿ��ظ�������ʾ������Ϣ
				if (service.getTruleGroup(this.truleGroup.getId()) != null) {
					addMessage("error.database.duplicatekey", "ID["
							+ this.truleGroup.getId() + "]");
					return null;
				}
			}

			UserBean userBean = getUserBean();
			if (truleGroupPrimaryKey == null
					|| truleGroupPrimaryKey.equals(this.truleGroup.getId())) {
				this.truleGroup = service.saveTruleGroup(this.truleGroup);
				String key = truleGroup.getId();
				this.truleGroupPrimaryKey = key;
				if (truleGroupPrimaryKey == null) {
					addMessage("truleGroup.message.added", this.truleGroup
							.getId());
				} else {
					addMessage("truleGroup.message.saved", this.truleGroup
							.getId());
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

	public TruleGroup save(String orgId) {
		if ("*".equals(orgId)) {
			this.save();
		} else {
			TruleGroup truleGroup = new TruleGroup();
			truleGroup.setBelongToInst(orgId);
			truleGroup.setDescription(this.truleGroup.getDescription());
			truleGroup.setEnable(this.truleGroup.getEnable());
			truleGroup.setStatus(this.truleGroup.getStatus());
			truleGroup.setId(null);
			truleGroup = service.saveTruleGroup(truleGroup);
			return truleGroup;
		}
		return null;
	}

	public String saveAndNew() {
		try {
			String action = save();
			if (action == null) {
				return null;
			}
			TruleGroup truleGroup = new TruleGroup();
			this.truleGroup = truleGroup;
			truleGroupPrimaryKey = null;
		} catch (BeGenException e) {
			// TODO Auto-generated catch block
			this.addMessage(e.getCode(), e.getMsg(), e);
			return getFailureAction();
		}
		return null;
	}

	/**
	 * ɾ��TruleGroup����.
	 * 
	 * @return String.
	 */
	public String delete() {
		try {
			service.delete(this.truleGroup.getId());
			CmsUtil.deleteFile("t_rule_group/" + this.truleGroup.getId());
			addMessage("truleGroup.message.deleted", this.truleGroup.getId());

		} catch (BeGenException e) {
			// TODO Auto-generated catch block
			this.addMessage(e.getCode(), e.getMsg(), e);
			return getFailureAction();
		}
		return getSuccessAction();
	}

	/**
	 * ɾ��TruleGroup���� (�ӱ������ݲ�����ɾ����.
	 * 
	 * @return String.
	 */
	public String deleteOfNoChild() {
		try {
			TruleGroup truleGroup = service.getTruleGroup(this.truleGroup
					.getId());
			service.delete(this.truleGroup.getId());
			addMessage("truleGroup.message.deleted", this.truleGroup.getId());

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
		if (this.truleGroupPrimaryKey == null)
			return "_key=" + this.truleGroup.getId();
		return "_key=" + this.truleGroupPrimaryKey;
	}

	public String popSave() {
		this.getRequest().getSession().setAttribute("__pop_object",
				this.truleGroup);
		this.getRequest().getSession().setAttribute("__pop_data_object",
				"TruleGroup");
		return "popSuccess";
	}

	public String saveAll() {
		try {
			if (truleGroupPrimaryKey == null && this.truleGroup.getId() != null) {
				// �жϼ�¼�Ƿ��ظ�������ʾ������Ϣ
				if (service.getTruleGroup(this.truleGroup.getId()) != null) {
					addMessage("error.database.duplicatekey", "ID["
							+ this.truleGroup.getId() + "]");
					return null;
				}
			}

			UserBean userBean = getUserBean();
			if (truleGroupPrimaryKey == null
					|| truleGroupPrimaryKey.equals(this.truleGroup.getId())) {

				this.truleGroup = service.saveAll(this.truleGroup);
				String key = truleGroup.getId();
				this.truleGroupPrimaryKey = key;
				if (truleGroupPrimaryKey == null) {
					addMessage("truleGroup.message.added", this.truleGroup
							.getId());
				} else {
					addMessage("truleGroup.message.saved", this.truleGroup
							.getId());
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

	public String saveMultiAll() {
		try {
			if (truleGroupPrimaryKey == null && this.truleGroup.getId() != null) {
				// �жϼ�¼�Ƿ��ظ�������ʾ������Ϣ
				if (service.getTruleGroup(this.truleGroup.getId()) != null) {
					addMessage("error.database.duplicatekey", "ID["
							+ this.truleGroup.getId() + "]");
					return null;
				}
			}

			UserBean userBean = getUserBean();
			if (truleGroupPrimaryKey == null
					|| truleGroupPrimaryKey.equals(this.truleGroup.getId())) {
				this.truleGroup = service.saveAll(this.truleGroup);

				String key = truleGroup.getId();
				this.truleGroupPrimaryKey = key;
				if (truleGroupPrimaryKey == null) {
					addMessage("truleGroup.message.added", this.truleGroup
							.getId());
				} else {
					addMessage("truleGroup.message.saved", this.truleGroup
							.getId());
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

	public void loadTruleGroup() {
		TruleGroup truleGroup = (TruleGroup) this.getRequest().getSession()
				.getAttribute("__pop_object");
		this.truleGroup = truleGroup;
		this.getRequest().getSession().removeAttribute("__pop_object");
	}

	public String closeRuleGroup() {
		try {
			this.truleGroup.setEnable(new Boolean(false));
			service.saveTruleGroup(this.truleGroup);
			addMessage("truleGroup.message.deleted", this.truleGroup.getId());
		} catch (BeGenException e) {
			// TODO Auto-generated catch block
			this.addMessage(e.getCode(), e.getMsg(), e);
			return getFailureAction();
		}
		return getSuccessAction();
	}

	public String saveData() {
		String belongToInst = this.truleGroup.getBelongToInst();
		List<TruleInstanceGroupSegment> truleInstanceGroupSegmentList = (List<TruleInstanceGroupSegment>) this
				.getValueBinding("#{truleInstanceGroupSegmentList.truleInstanceGroupSegments}");

		if (truleInstanceGroupSegmentList == null
				|| truleInstanceGroupSegmentList.size() == 0) {
			addMessageString("���������Ҫ��������һ������!");
			return null;
		}
//		if (!checkRuleInstance(truleInstanceGroupSegmentList)) {
//			return null;
//		}
		if (!checkLimit(truleInstanceGroupSegmentList)) {
			return null;
		}
		if (checkTuleCycle(truleInstanceGroupSegmentList)) {
			if ("*".equals(belongToInst)) {// ����ѡ��Ϊȫ����
				List orgList = Function.getParentCompanyList(getUserBean());
				saveRuleGroupAndSegmentForAll(truleInstanceGroupSegmentList,
						orgList);
			} else {
				deleteRuleGroup("");
				save();
				saveRuleGroupAndSegment(truleInstanceGroupSegmentList,
						this.truleGroup.getId());
			}
			addMessageString("�����鱣��ɹ�!");
		} else {
			return null;
		}
		return this.getSuccessAction();
	}

	private boolean checkRuleInstance(List truleInstanceGroupSegmentList) {
		Collections.sort(truleInstanceGroupSegmentList,
				new TruleInstanceComparator());
		if (truleInstanceGroupSegmentList == null
				|| truleInstanceGroupSegmentList.size() == 0) {
			return true;
		}

		TruleInstanceGroupSegment truleInstanceGroupSegment = (TruleInstanceGroupSegment) truleInstanceGroupSegmentList
				.get(0);
		String ruleInstanceId = truleInstanceGroupSegment.getRuleInstanceId();

		if (ruleInstanceId == null) {
			addMessageString("�쳣�ӹ���!");
			return false;
		}
		for (int i = 1; i < truleInstanceGroupSegmentList.size(); i++) {
			TruleInstanceGroupSegment _truleInstanceGroupSegment = (TruleInstanceGroupSegment) truleInstanceGroupSegmentList
					.get(i);

			String _ruleInstanceId = _truleInstanceGroupSegment
					.getRuleInstanceId();
			if (ruleInstanceId.equals(_ruleInstanceId)) {
				addMessageString("ͬһ�ӹ�����������������!");
				return false;
			}

		}
		return true;
	}
	
	private boolean checkLimit(List truleInstanceGroupSegmentList) {
		Collections.sort(truleInstanceGroupSegmentList, new LimitComparator());
		if (truleInstanceGroupSegmentList == null
				|| truleInstanceGroupSegmentList.size() == 0) {
			return true;
		}

		for (int i = 0; i < truleInstanceGroupSegmentList.size(); i++) {
			TruleInstanceGroupSegment truleInstanceGroupSegment = (TruleInstanceGroupSegment) truleInstanceGroupSegmentList
					.get(i);

			String ruleInstanceId = truleInstanceGroupSegment
					.getRuleInstanceId();
			Float begin = truleInstanceGroupSegment.getBegin();
			Float end = truleInstanceGroupSegment.getEnd();

			// Float propertion = truleInstanceGroupSegment.getPropertion();
			Float value = truleInstanceGroupSegment.getValue();

			if (begin == null) {
				addMessageString("���޲���Ϊ�գ�");
				return false;
			}

			if (!Function.checkNumber(begin)) {
				addMessageString("�������ֲ��Ϸ������ֵΪ999.99,���Ϊ2λС����");
				return false;
			}

			if (end == null) {
				addMessageString("���޲���Ϊ�գ�");
				return false;
			}
			if (!Function.checkNumber(end)) {
				addMessageString("�������ֲ��Ϸ������ֵΪ999.99,���Ϊ2λС����");
				return false;
			}

			if (value == null) {
				addMessageString("����ֵ����Ϊ�գ�");
				return false;
			}
			if (!Function.checkNumber(value, 12)) {
				addMessageString("����ֵ���ֲ��Ϸ������ֵΪ999999999999��");
				return false;
			}
			/**
			 * if (propertion == null) { addMessageString("����Ȩ�ز���Ϊ�գ�"); return
			 * false; } if (!Function.checkNumber(propertion)) {
			 * addMessageString("����Ȩ�����ֲ��Ϸ������ֵΪ999.99,���Ϊ2λС����"); return false; }
			 */
			Double downLimit = new Double(begin);
			Double upLimit = new Double(end);

			if (i == truleInstanceGroupSegmentList.size() - 1) {
				if (downLimit.compareTo(upLimit) > -1) {
					addMessageString("���޲���С�ڵ�������!");
					return false;
				} else {
					continue;
				}
			}

			TruleInstanceGroupSegment truleInstanceGroupSegmentNext = (TruleInstanceGroupSegment) truleInstanceGroupSegmentList
					.get(i + 1);

			if (truleInstanceGroupSegmentNext.getBegin() == null
					|| truleInstanceGroupSegmentNext.getRuleInstanceId() == null) {
				addMessageString("������ͬ�ӹ�����������޲����ظ�!");
				return false;
			}
			String ruleInstanceIdNext = truleInstanceGroupSegmentNext
					.getRuleInstanceId();

			Double downLimitNext = new Double(truleInstanceGroupSegmentNext
					.getBegin());

			if (ruleInstanceId.equals(ruleInstanceIdNext)) {
				if (downLimit.compareTo(upLimit) > -1) {
					addMessageString("������ͬ�ӹ�����������޲����ظ�!");
					return false;
				}
				if (downLimitNext.compareTo(upLimit) < 0) {
					addMessageString("������ͬ�ӹ�����������޲����ظ�!");
					return false;
				}
				if (downLimitNext.compareTo(upLimit) > 0) {
					addMessageString("������ͬ�ӹ�������޺����ޱ�����������!");
					return false;
				}
			} else {
				continue;
			}
		}
		return true;
	}

	/**
	 * �����֧����û���ӹ����򷵻�""
	 * 
	 * @param code
	 * @param orgId
	 * @return
	 */
	private String getRuleInstanceId(String code, String orgId, String cycle) {
		String ruleInstanceId = "";
		Map queryFields = new HashMap();
		queryFields.put("code", code);
		queryFields.put("cycle", cycle);
		queryFields.put("enable", "true");
		queryFields.put("belongToInst", orgId);
		List truleInstanceList = truleInstanceService
				.getTruleInstanceListOfQuery(queryFields);
		if (truleInstanceList != null && truleInstanceList.size() > 0) {
			TruleInstance truleInstance = (TruleInstance) truleInstanceList
					.get(0);
			ruleInstanceId = truleInstance.getId();
		}
		return ruleInstanceId;
	}

	private TruleInstanceGroup getTruleInstanceGroup(String truleGroupId,
			String ruleInstanceId) {
		TruleInstanceGroup tig = null;
		Map queryFields = new HashMap();
		queryFields.put("ruleGroupId", truleGroupId);
		queryFields.put("ruleInstanceId", ruleInstanceId);
		List list = truleInstanceGroupService
				.getTruleInstanceGroupListOfQuery(queryFields);
		if (list == null || list.size() == 0) {
			TruleInstanceGroup truleInstanceGroup = new TruleInstanceGroup();
			truleInstanceGroup.setRuleGroupId(truleGroupId);
			truleInstanceGroup.setRuleInstanceId(ruleInstanceId);
			tig = truleInstanceGroupService
					.saveTruleInstanceGroup(truleInstanceGroup);
		}
		return tig;
	}

	/**
	 * ���ڻ���ѡ��ȫ���Ĵ���
	 * 
	 * @param truleInstanceGroupSegmentList
	 * @param truleGroupId
	 */
	private void saveRuleGroupAndSegmentForAll(
			List truleInstanceGroupSegmentList, List orgList) {
		for (int k = 0; k < orgList.size(); k++) {
			TorganizeInfo torganizeInfo = (TorganizeInfo) orgList.get(k);
			String orgId = torganizeInfo.getId();
			deleteRuleGroup("all");
			TruleGroup truleGroup = null;

			int n = 0;
			for (int i = 0; i < truleInstanceGroupSegmentList.size(); i++) {
				TruleInstanceGroupSegment tgs = (TruleInstanceGroupSegment) truleInstanceGroupSegmentList
						.get(i);
				String code = tgs.getRuleInstanceIdOfTruleInstance().getCode();
				String cycle = tgs.getRuleInstanceIdOfTruleInstance()
						.getCycle();
				String ruleInstanceId = getRuleInstanceId(code, orgId, cycle);
				if (!"".equals(ruleInstanceId)) {
					if (n == 0) {
						truleGroup = save(orgId);
						n++;
					}
					if (truleGroup != null) {
						String truleGroupId = truleGroup.getId();
						TruleInstanceGroup tig = getTruleInstanceGroup(
								truleGroupId, ruleInstanceId);
						if (tig != null) {
							String ruleInstanceGroupId = tig.getId();

							TruleInstanceGroupSegment truleInstanceGroupSegment = new TruleInstanceGroupSegment();
							Tools.cloneProperties(truleInstanceGroupSegment,
									tgs);
							truleInstanceGroupSegment.setId(null);
							truleInstanceGroupSegment
									.setRuleInstanceId(tig.getRuleInstanceId());
							truleInstanceGroupSegment
									.setRuleInstanceGroupId(ruleInstanceGroupId);

							truleInstanceGroupSegmentService
									.saveTruleInstanceGroupSegment(truleInstanceGroupSegment);
						}
					}
				}
			}
		}
	}

	public void saveRuleGroupAndSegment(List truleInstanceGroupSegmentList,
			String truleGroupId) {
		TruleInstanceGroup tig = null;
		for (int n = 0; n < truleInstanceGroupSegmentList.size(); n++) {
			TruleInstanceGroupSegment tgsn = (TruleInstanceGroupSegment) truleInstanceGroupSegmentList
					.get(n);

			TruleInstanceGroup truleInstanceGroup = new TruleInstanceGroup();
			truleInstanceGroup.setRuleGroupId(truleGroupId);
			truleInstanceGroup.setRuleInstanceId(tgsn.getRuleInstanceId());

			String ruleInstanceId = tgsn.getRuleInstanceId();

			Map queryFields = new HashMap();
			queryFields.put("ruleGroupId", truleGroupId);
			queryFields.put("ruleInstanceId", ruleInstanceId);
			List list = truleInstanceGroupService
					.getTruleInstanceGroupListOfQuery(queryFields);

			if (list == null || list.size() == 0) {
				tig = truleInstanceGroupService
						.saveTruleInstanceGroup(truleInstanceGroup);
			}
			if (tig != null) {
				String ruleInstanceGroupId = tig.getId();
				String code = tgsn.getRuleInstanceIdOfTruleInstance().getCode();
				TruleInstanceGroupSegment truleInstanceGroupSegment = new TruleInstanceGroupSegment();
				Tools.cloneProperties(truleInstanceGroupSegment, tgsn);
				if ("R21".equals(code) || "R23".equals(code)
						|| "R24".equals(code) || "R25".equals(code)
						|| "R26".equals(code) || "R27".equals(code)
						|| "R33".equals(code)) {// ��Щ�Ǿ�̬����
					truleInstanceGroupSegment.setBegin(0f);
					truleInstanceGroupSegment.setEnd(2f);
				}
				truleInstanceGroupSegment.setId(null);
				truleInstanceGroupSegment
						.setRuleInstanceGroupId(ruleInstanceGroupId);

				truleInstanceGroupSegmentService
						.saveTruleInstanceGroupSegment(truleInstanceGroupSegment);
			}
		}
	}

	public boolean checkTuleCycle(List list) {
		if (list != null) {
			Collections.sort(list, new TruleInstanceComparator());
			if (list.size() == 0) {
				return true;
			} else if (list.size() == 1) {
				TruleInstanceGroupSegment truleInstanceGroupSegment = (TruleInstanceGroupSegment) list
						.get(0);
				String type = truleInstanceGroupSegment.getRuleInstanceIdOfTruleInstance().getType();
				if("0".equals(type)){
					return true;
				}
				Float value = truleInstanceGroupSegment.getValue();
				if (value == null) {
					addMessageString("����ֵ����Ϊ��!");
					return false;
				} else {
					return true;
				}
			} else {
				TruleInstanceGroupSegment truleInstanceGroupSegment = (TruleInstanceGroupSegment) list
						.get(0);

				String cycle = truleInstanceGroupSegment
						.getRuleInstanceIdOfTruleInstance().getCycle();
				String type = truleInstanceGroupSegment.getRuleInstanceIdOfTruleInstance().getType();
				
				if(cycle == null && "0".equals(type)){//
					return true;
				}
				for (int i = 1; i < list.size(); i++) {
					TruleInstanceGroupSegment tgs = (TruleInstanceGroupSegment) list
							.get(i);

					String _type = tgs.getRuleInstanceIdOfTruleInstance().getType();
					if("0".equals(_type)){
						continue;
					}
					Float value = tgs.getValue();
					String _cycle = tgs.getRuleInstanceIdOfTruleInstance()
							.getCycle();
					if (value == null) {
						addMessageString("����ֵ����Ϊ��!");
						return false;
					}
					if (!cycle.equals(_cycle)) {
						addMessageString("�ӹ������ڱ���һ��!");
						return false;
					}
				}
			}
			return true;
		} else {
			addMessageString("����ֵ����Ϊ��!");
			return false;
		}
	}

	public void deleteRuleGroup(String flag) {
		String ruleGroupId = this.truleGroup.getId();
		if (ruleGroupId != null && !"".equals(ruleGroupId)
				&& !"all".equals(flag)) {
			Map queryFields = new HashMap();
			queryFields.put("ruleGroupId", ruleGroupId);
			List truleInstanceGroupList = truleInstanceGroupService
					.getTruleInstanceGroupListOfQuery(queryFields);

			for (int i = 0; i < truleInstanceGroupList.size(); i++) {
				TruleInstanceGroup truleInstanceGroup = (TruleInstanceGroup) truleInstanceGroupList
						.get(i);
				String truleInstanceGroupId = truleInstanceGroup.getId();
				Map queryFieldsSegment = new HashMap();
				queryFieldsSegment.put("ruleInstanceGroupId",
						truleInstanceGroupId);
				List segmentList = truleInstanceGroupSegmentService
						.getTruleInstanceGroupSegmentListOfQuery(queryFieldsSegment);

				for (int k = 0; k < segmentList.size(); k++) {
					TruleInstanceGroupSegment truleInstanceGroupSegment = (TruleInstanceGroupSegment) segmentList
							.get(k);

					truleInstanceGroupSegmentService
							.delete(truleInstanceGroupSegment.getId());
				}

				truleInstanceGroupService.delete(truleInstanceGroupId);
			}
		}
	}

}
