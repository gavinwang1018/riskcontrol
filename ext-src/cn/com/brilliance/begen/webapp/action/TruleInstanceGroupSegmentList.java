package cn.com.brilliance.begen.webapp.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.SelectItem;

import cn.com.brilliance.begen.common.webapp.action.ListPage;
import cn.com.brilliance.begen.dao.TruleInstanceDAO;
import cn.com.brilliance.begen.exception.BeGenException;
import cn.com.brilliance.begen.model.TruleInstance;
import cn.com.brilliance.begen.model.TruleInstanceGroup;
import cn.com.brilliance.begen.model.TruleInstanceGroupSegment;
import cn.com.brilliance.begen.service.TruleInstanceGroupSegmentService;
import cn.com.brilliance.begen.service.TruleInstanceGroupService;

/**
 * TruleInstanceGroupSegment对象List.
 * 
 * @author Administrator.
 * 
 */
public class TruleInstanceGroupSegmentList extends BasePage implements ListPage {

	private TruleInstanceGroupSegmentService service = (TruleInstanceGroupSegmentService) getBean("truleInstanceGroupSegmentService");

	private TruleInstanceGroupService truleInstanceGroupService = (TruleInstanceGroupService) getBean("truleInstanceGroupService");

	private java.lang.String belongToInst;
	
	/**
	 * truleInstanceGroupSegments.
	 */
	private List<TruleInstanceGroupSegment> truleInstanceGroupSegments;

	private String truleGroupId;

	/**
	 * dataTable.
	 */
	private HtmlDataTable dataTable;

	/**
	 * truleInstanceGroupSegment.
	 */
	private TruleInstanceGroupSegment truleInstanceGroupSegment = null;

	/**
	 * queryFields.
	 */
	private Map queryFields = new HashMap(); // 查询条件Map

	private Integer rowIndex;

	private boolean unload = false;

	private List<String> deleteList = new ArrayList<String>();

	/**
	 * sortColumn.
	 */
	private String sortColumn;

	/**
	 * ascending.
	 */
	private boolean ascending;

	/**
	 * 默认构造函数.
	 */
	public TruleInstanceGroupSegmentList() {
		super();
	}

	public boolean isAscending() {
		return ascending;
	}

	public void setAscending(boolean ascending) {
		this.ascending = ascending;
	}

	public String getSortColumn() {
		return this.sortColumn;
	}

	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}

	/**
	 * Returns the TruleInstanceGroupSegment.
	 * 
	 * @return TruleInstanceGroupSegment.
	 */
	public void setTruleInstanceGroupSegment(
			TruleInstanceGroupSegment truleInstanceGroupSegment) {
		this.truleInstanceGroupSegment = truleInstanceGroupSegment;
	}

	/**
	 * Sets the TruleInstanceGroupSegment.
	 * 
	 * @param truleInstanceGroupSegment
	 *            The truleInstanceGroupSegment to set.
	 */
	public TruleInstanceGroupSegment getTruleInstanceGroupSegment() {
		return this.truleInstanceGroupSegment;
	}

	/**
	 * Returns the Map.
	 * 
	 * @return Map.
	 */
	public Map getQueryFields() {
		return queryFields;
	}

	/**
	 * Sets the Map.
	 * 
	 * @param queryFields
	 *            The Map to set.
	 */
	public void setQueryFields(Map queryFields) {
		this.queryFields = queryFields;
	}

	/**
	 * 获得TruleInstanceGroupSegment对象列表.
	 * 
	 * @return List.
	 */
	public List<TruleInstanceGroupSegment> getTruleInstanceGroupSegments() {
		return this.truleInstanceGroupSegments;
	}

	public void initTruleInstanceGroupSegments() {
		try {
			if (this.sortColumn != null)
				queryFields.put("_order", this.sortColumn + " "
						+ (this.ascending ? "asc" : "desc"));

			if (truleGroupId != null && !"".equals(truleGroupId)
					&& !"undefined".equals(truleGroupId)) {
				Map truleInstanceGroupFields = new HashMap();
				truleInstanceGroupFields.put("ruleGroupId", truleGroupId);
				List truleInstanceGroupList = truleInstanceGroupService
						.getTruleInstanceGroupListOfQuery(truleInstanceGroupFields);
				String truleInstanceGroups = "";
				for (int i = 0; i < truleInstanceGroupList.size(); i++) {
					TruleInstanceGroup truleInstanceGroup = (TruleInstanceGroup) truleInstanceGroupList
							.get(i);
					truleInstanceGroups = truleInstanceGroups
							+ truleInstanceGroup.getId() + ",";
				}
				String truleInstanceGroupsStr = "";
				if (truleInstanceGroups.length() > 0) {
					truleInstanceGroupsStr = truleInstanceGroups.substring(0,
							truleInstanceGroups.length() - 1);
				}
				if (!"".equals(truleInstanceGroupsStr)) {
					String hsql = "rule_Instance_Group_Id in ("
							+ truleInstanceGroupsStr + ") order by id desc";
					this.queryFields.put("_hsql", hsql);
					this.truleInstanceGroupSegments = service.init(
							this.truleInstanceGroupSegment, this.queryFields);
				} else {
					this.truleInstanceGroupSegments = new ArrayList();
				}

			} else {
				this.truleInstanceGroupSegments = new ArrayList();
			}
			unload = true;
		} catch (BeGenException e) {
			// TODO Auto-generated catch block
			this.addMessage(e.getCode(), e.getMsg(), e);
		}
	}

	/**
	 * Sets the TruleInstanceGroupSegments.
	 * 
	 * @param truleInstanceGroupSegments
	 *            The TruleInstanceGroupSegments to set.
	 */
	public void setTruleInstanceGroupSegments(List truleInstanceGroupSegments) {
		this.truleInstanceGroupSegments = truleInstanceGroupSegments;
	}

	/**
	 * Returns the dataTable.
	 * 
	 * @return dataTable.
	 */
	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	/**
	 * Sets the dataTable.
	 * 
	 * @param dataTable
	 *            The HtmlDataTable to set.
	 */
	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}

	/**
	 * 删除TruleInstanceGroupSegment对象.
	 * 
	 * @return String.
	 */
	public void delete() {
		try {
			TruleInstanceGroupSegment truleInstanceGroupSegment = truleInstanceGroupSegments
					.get(rowIndex);
			service.delete(truleInstanceGroupSegment.getId());
			addMessage("truleInstanceGroupSegment.message.deleted",
					truleInstanceGroupSegment.getId());
			this.truleInstanceGroupSegments.remove(rowIndex.intValue());
		} catch (BeGenException e) {
			// TODO Auto-generated catch block
			this.addMessage(e.getCode(), e.getMsg(), e);
		}
	}

	/**
	 * 删除TruleInstanceGroupSegment对象 (子表有数据不允许删除）.
	 * 
	 * @return String.
	 */
	public String deleteOfNoChild() {
		try {
			TruleInstanceGroupSegment truleInstanceGroupSegment = truleInstanceGroupSegments
					.get(rowIndex);

			service.delete(this.truleInstanceGroupSegment.getId());
			addMessage("truleInstanceGroupSegment.message.deleted",
					this.truleInstanceGroupSegment.getId());
		} catch (BeGenException e) {
			// TODO Auto-generated catch block
			this.addMessage(e.getCode(), e.getMsg(), e);
			return null;
		}
		return null;
	}

	/**
	 * 查询TruleInstanceGroupSegment对象.
	 * 
	 * @return String.
	 */
	public String query() {
		try {
			this.truleInstanceGroupSegments = service
					.getTruleInstanceGroupSegmentListOfQuery(this.queryFields);
		} catch (BeGenException e) {
			// TODO Auto-generated catch block
			this.addMessage(e.getCode(), e.getMsg(), e);
		}
		return null;
	}

	public String add() {
		return this.getSuccessAction();
	}

	public List getTruleInstanceItems() {
		List truleInstanceItems = new ArrayList();

		TruleInstanceDAO truleInstanceDAO = (TruleInstanceDAO) getBean("truleInstanceDAO");
		Map map = new HashMap();
		map.put("enable", "true");
		if (!"*".equals(belongToInst)) {
			map.put("belongToInst", belongToInst);
		} else {
			map.put("belongToInst", "0");// 选全部时为总公司的
		}
		map.put("_order", "code asc");
		List list = truleInstanceDAO.getTruleInstanceListOfQuery(map);
		for (int i = 0; i < list.size(); i++) {
			TruleInstance truleInstance = (TruleInstance) list.get(i);
			String cycleLabel = getCycleLabel(truleInstance.getCycle());
			String versionBm = truleInstance.getVersionBm();
			if(versionBm == null) versionBm = "";
			truleInstanceItems.add(new SelectItem(String.valueOf(truleInstance
					.getId()), String.valueOf(truleInstance.getCode() + "("
					+ cycleLabel + ")-" + versionBm + "-"
					+ truleInstance.getDescription())));
		}
		return truleInstanceItems;
	}
	
	private String getCycleLabel(String cycle) {
		if ("1".equals(cycle)) {
			return "天";
		} else if ("2".equals(cycle)) {
			return "周";
		} else if ("3".equals(cycle)) {
			return "半月";
		} else if ("4".equals(cycle)) {
			return "月";
		}
		return "";
	}
	
	public void multiAdd() {
		TruleInstanceGroupSegment truleInstanceGroupSegment = new TruleInstanceGroupSegment();
		truleInstanceGroupSegment.set_record_index(-1);
		truleInstanceGroupSegment
				.set_edit_flag(TruleInstanceGroupSegment.EDIT_FLAG_ADD);
		this.truleInstanceGroupSegments.add(truleInstanceGroupSegment);
	}

	public void popupAdd() {
		TruleInstanceGroupSegment truleInstanceGroupSegment = new TruleInstanceGroupSegment();
		truleInstanceGroupSegment.set_record_index(-1);
		truleInstanceGroupSegment
				.set_edit_flag(TruleInstanceGroupSegment.EDIT_FLAG_ADD);
		this.getRequest().getSession().setAttribute("__pop_object",
				truleInstanceGroupSegment);
	}

	public void popupEdit() {
		TruleInstanceGroupSegment truleInstanceGroupSegment = truleInstanceGroupSegments
				.get(rowIndex);
		truleInstanceGroupSegment.set_record_index(rowIndex);
		if (TruleInstanceGroupSegment.EDIT_FLAG_ADD != truleInstanceGroupSegment
				.get_edit_flag()) {
			truleInstanceGroupSegment
					.set_edit_flag(TruleInstanceGroupSegment.EDIT_FLAG_EDIT);
		}
		this.getRequest().getSession().setAttribute("__pop_object",
				truleInstanceGroupSegment);
	}

	public void popupView() {
		TruleInstanceGroupSegment truleInstanceGroupSegment = truleInstanceGroupSegments
				.get(rowIndex.intValue());
		this.getRequest().getSession().setAttribute("__pop_object",
				truleInstanceGroupSegment);
	}

	public void popupRefresh() {
		TruleInstanceGroupSegment truleInstanceGroupSegment = (TruleInstanceGroupSegment) this
				.getRequest().getSession().getAttribute("__pop_object");
		if (truleInstanceGroupSegment.get_record_index() != -1) {
			this.truleInstanceGroupSegments.remove(truleInstanceGroupSegment
					.get_record_index());
			this.truleInstanceGroupSegments.add(truleInstanceGroupSegment
					.get_record_index(), truleInstanceGroupSegment);
		} else {
			this.truleInstanceGroupSegments.add(truleInstanceGroupSegment);
		}
		this.getRequest().getSession().removeAttribute("__pop_object");
	}

	public String edit() {
		TruleInstanceGroupSegment truleInstanceGroupSegment = truleInstanceGroupSegments
				.get(rowIndex.intValue());
		truleInstanceGroupSegment.set_record_index(rowIndex);
		if (TruleInstanceGroupSegment.EDIT_FLAG_ADD != truleInstanceGroupSegment
				.get_edit_flag()) {
			truleInstanceGroupSegment
					.set_edit_flag(TruleInstanceGroupSegment.EDIT_FLAG_EDIT);
			this
					.setValueBinding(
							"#{truleInstanceGroupSegmentForm.truleInstanceGroupSegmentPrimaryKey}",
							truleInstanceGroupSegment.getId());
		}
		return this.getSuccessAction();
	}

	public String view() {
		TruleInstanceGroupSegment truleInstanceGroupSegment = truleInstanceGroupSegments
				.get(rowIndex.intValue());
		this
				.setValueBinding(
						"#{truleInstanceGroupSegmentForm.truleInstanceGroupSegmentPrimaryKey}",
						truleInstanceGroupSegment.getId());
		return this.getSuccessAction();
	}

	public String getHistoryUrlParameter() {
		Iterator iter = this.getQueryFields().keySet().iterator();
		String url = "";
		while (iter.hasNext()) {
			String key = (String) iter.next();
			String value = (String) this.getQueryFields().get(key);
			if (value != null && !"".equals(value))
				url += key + "=" + value + "&";
		}
		return url;
	}

	public void deleteBuffer() {
		TruleInstanceGroupSegment truleInstanceGroupSegment = truleInstanceGroupSegments
				.get(rowIndex.intValue());
		if (TruleInstanceGroupSegment.EDIT_FLAG_ADD != truleInstanceGroupSegment
				.get_edit_flag()) {
			deleteList.add(truleInstanceGroupSegment.getId());
		}
		truleInstanceGroupSegments.remove(rowIndex.intValue());
	}

	public void moveUpBuffer() {
		int i = rowIndex;
		int j = getMovedTruleInstanceGroupSegmentIndex(i, -1);
		if (j == -1)
			return;
		TruleInstanceGroupSegment truleInstanceGroupSegment = truleInstanceGroupSegments
				.get(i);
		truleInstanceGroupSegments.add(j, truleInstanceGroupSegment);
		truleInstanceGroupSegments.remove(i + 1);
	}

	private int getMovedTruleInstanceGroupSegmentIndex(int index, int step) {
		if (index + step >= 0
				&& index + step < truleInstanceGroupSegments.size()) {
			TruleInstanceGroupSegment truleInstanceGroupSegment = truleInstanceGroupSegments
					.get(index + step);
			if (TruleInstanceGroupSegment.EDIT_FLAG_DELETE == truleInstanceGroupSegment
					.get_edit_flag())
				return index
						+ step
						+ getMovedTruleInstanceGroupSegmentIndex(index + step,
								step);
			else
				return index + step;
		} else {
			return -1;
		}
	}

	public void moveDownBuffer() {
		int i = rowIndex;
		int j = getMovedTruleInstanceGroupSegmentIndex(i, 1);
		if (j == -1)
			return;
		TruleInstanceGroupSegment truleInstanceGroupSegment = truleInstanceGroupSegments
				.get(j);
		truleInstanceGroupSegments.add(i, truleInstanceGroupSegment);
		truleInstanceGroupSegments.remove(j + 1);
	}

	public Integer getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(Integer rowIndex) {
		this.rowIndex = rowIndex;
	}

	public List<String> getDeleteList() {
		return deleteList;
	}

	public void setDeleteList(List<String> deleteList) {
		this.deleteList = deleteList;
	}

	public String save() {
		try {
			for (int i = 0; i < truleInstanceGroupSegments.size(); i++) {
				TruleInstanceGroupSegment truleInstanceGroupSegment = (TruleInstanceGroupSegment) this.truleInstanceGroupSegments
						.get(i);
				service
						.saveTruleInstanceGroupSegment(truleInstanceGroupSegment);
			}
			addMessage("truleInstanceGroupSegment.message.savedAll", null);
			return this.getSuccessAction();
		} catch (BeGenException e) {
			// TODO Auto-generated catch block
			this.addMessage(e.getCode(), e.getMsg(), e);
		}
		return null;
	}

	public void deleteChecked() {
		for (TruleInstanceGroupSegment truleInstanceGroupSegment : this.truleInstanceGroupSegments) {
			if (truleInstanceGroupSegment.is_checked_flag()) {
				service.delete(truleInstanceGroupSegment.getId());
			}
		}
	}

	public void deleteAll() {
		service.deleteAll(this.truleInstanceGroupSegments);
	}

	/**
	 * @return the truleGroupId
	 */
	public String getTruleGroupId() {
		return truleGroupId;
	}

	/**
	 * @param truleGroupId
	 *            the truleGroupId to set
	 */
	public void setTruleGroupId(String truleGroupId) {
		this.truleGroupId = truleGroupId;
	}

	/**
	 * @return the belongToInst
	 */
	public java.lang.String getBelongToInst() {
		return belongToInst;
	}

	/**
	 * @param belongToInst the belongToInst to set
	 */
	public void setBelongToInst(java.lang.String belongToInst) {
		this.belongToInst = belongToInst;
	}
	
}
