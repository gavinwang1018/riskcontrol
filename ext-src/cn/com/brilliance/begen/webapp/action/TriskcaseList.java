package cn.com.brilliance.begen.webapp.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.DataModel;
import javax.faces.model.SelectItem;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import cn.com.brilliance.begen.dao.TmccDAO;
import cn.com.brilliance.begen.dao.TmchntDAO;
import cn.com.brilliance.begen.dao.TorganizeInfoDAO;
import cn.com.brilliance.begen.dao.TorganizeUserDAO;
import cn.com.brilliance.begen.dao.TriskcaseDAO;
import cn.com.brilliance.begen.dao.TriskcaseRulegroupDAO;
import cn.com.brilliance.begen.dao.TruleGroupDAO;
import cn.com.brilliance.begen.dao.TuserInfoDAO;
import cn.com.brilliance.begen.exception.BeGenException;
import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.TriskcaseService;
import cn.com.brilliance.begen.webapp.action.BasePage;
import cn.com.brilliance.begen.webapp.servlet.UserBean;
import cn.com.brilliance.begen.common.webapp.action.DataPage;
import cn.com.brilliance.begen.common.webapp.action.ListPage;
import cn.com.brilliance.risk.ext.common.ExcelOfRiskcaseUtil;
import cn.com.brilliance.risk.ext.interfaces.DataManageController;

/**
 * Triskcase对象List.
 * 
 * @author Administrator.
 * 
 */
public class TriskcaseList extends BasePage implements ListPage {

	private TriskcaseService service = (TriskcaseService) getBean("triskcaseService");

	private List<SelectItem> truleGroupItems = new ArrayList<SelectItem>();
	
	private List<SelectItem> tmccItems = new ArrayList<SelectItem>();

	private String backComment;

	/**
	 * triskcases.
	 */
	private List<Triskcase> triskcases;

	/**
	 * dataTable.
	 */
	private HtmlDataTable dataTable;

	private boolean emptyList = false;

	/**
	 * triskcase.
	 */
	private Triskcase triskcase = null;

	/**
	 * queryFields.
	 */
	private Map queryFields = new HashMap(); // 查询条件Map

	private Map saveQueryFiellds = new HashMap();

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
	public TriskcaseList() {
		super();
	}

	public void setEmptyList(String emptyListString) {
		if ("true".equalsIgnoreCase(emptyListString)
				|| "yes".equalsIgnoreCase(emptyListString)) {
			this.emptyList = true;
		} else {
			this.emptyList = false;
		}
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
	 * Returns the Triskcase.
	 * 
	 * @return Triskcase.
	 */
	public void setTriskcase(Triskcase triskcase) {
		this.triskcase = triskcase;
	}

	/**
	 * Sets the Triskcase.
	 * 
	 * @param triskcase
	 *            The triskcase to set.
	 */
	public Triskcase getTriskcase() {
		return this.triskcase;
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
	 * 获得Triskcase对象列表.
	 * 
	 * @return List.
	 */
	public DataModel getTriskcases() {
		if (this.emptyList) {
			return null;
		}
		if (dataModel == null) {
			setInitQueryFields();
			dataModel = new LocalDataModel(20);
		}
		if (this.sortColumn != null) {
			sort(this.getSortColumn(), this.isAscending());
		}
		return dataModel;
	}

	public void initTriskcases() {
		try {
			// setInitQueryFields();
			if (dataModel == null) {
				dataModel = new LocalDataModel(20);
			}
			unload = true;
		} catch (BeGenException e) {
			// TODO Auto-generated catch blockx
			this.addMessage(e.getCode(), e.getMsg(), e);
		}
	}

	protected void sort(final String column, final boolean ascending) {
		Comparator comparator = new Comparator() {
			public int compare(Object o1, Object o2) {
				Triskcase t1 = (Triskcase) o1;
				Triskcase t2 = (Triskcase) o2;

				if (column == null) {
					return 0;
				}
				if (column.equals("warnLevel")) {
					return ascending ? t1.getWarnLevel().compareTo(
							t2.getWarnLevel()) : t2.getWarnLevel().compareTo(
							t1.getWarnLevel());
				} else if (column.equals("urgentCnt")) {
					return ascending ? t1.getUrgentCnt().toString().compareTo(
							t2.getUrgentCnt().toString()) : t2.getUrgentCnt()
							.toString().compareTo(t1.getUrgentCnt().toString());
				} else if (column.equals("processLimit")) {
					return ascending ? t1.getProcessLimit().toString()
							.compareTo(t2.getProcessLimit().toString()) : t2
							.getProcessLimit().toString().compareTo(
									t1.getProcessLimit().toString());
				} else if (column.equals("backCnt")) {
					return ascending ? t1.getBackCnt().toString().compareTo(
							t2.getBackCnt().toString()) : t2.getBackCnt()
							.toString().compareTo(t1.getBackCnt().toString());
				} else if (column.equals("caseno")) {
					return ascending ? t1.getCaseno().toString().compareTo(
							t2.getCaseno().toString()) : t2.getCaseno()
							.toString().compareTo(t1.getCaseno().toString());
				} else if (column.equals("casefrom")) {
					return ascending ? t1.getCasefrom().toString().compareTo(
							t2.getCasefrom().toString()) : t2.getCasefrom()
							.toString().compareTo(t1.getCasefrom().toString());
				} else if (column.equals("mchntCd")) {
					return ascending ? t1.getMchntCd().toString().compareTo(
							t2.getMchntCd().toString()) : t2.getMchntCd()
							.toString().compareTo(t1.getMchntCd().toString());
				} else if (column.equals("mchntName")) {
					return ascending ? t1.getMchntName().toString().compareTo(
							t2.getMchntName().toString()) : t2.getMchntName()
							.toString().compareTo(t1.getMchntName().toString());
				} else if (column.equals("transMcc")) {
					String t1tmcc = "0";
					String t2tmcc = "0";
					if (t1.getTransMcc() != null
							&& !"".equals(t1.getTransMcc())) {
						t1tmcc = t1.getTransMcc();
					}
					if (t2.getTransMcc() != null
							&& !"".equals(t2.getTransMcc())) {
						t2tmcc = t2.getTransMcc();
					}
					return ascending ? t1tmcc.compareTo(t2tmcc) : t2tmcc
							.compareTo(t1tmcc);
				} else if (column.equals("belongToInst")) {
					return ascending ? t1.getBelongToInst().toString()
							.compareTo(t2.getBelongToInst().toString()) : t2
							.getBelongToInst().toString().compareTo(
									t1.getBelongToInst().toString());
				} else if (column.equals("submit2Inst")) {
					String t1submit = "0";
					String t2submit = "0";
					if (t1.getSubmit2Inst() != null
							&& !"".equals(t1.getSubmit2Inst())) {
						t1submit = t1.getSubmit2Inst();
					}
					if (t2.getSubmit2Inst() != null
							&& !"".equals(t2.getSubmit2Inst())) {
						t2submit = t2.getSubmit2Inst();
					}
					return ascending ? t1submit.compareTo(t2submit) : t2submit
							.compareTo(t1submit);
				} else if (column.equals("createdate")) {
					return ascending ? t1.getCreatedate().toString().compareTo(
							t2.getCreatedate().toString()) : t2.getCreatedate()
							.toString()
							.compareTo(t1.getCreatedate().toString());
				} else if (column.equals("relativeTransAmt")) {
					Double r1amt = 0.0;
					Double r2amt = 0.0;
					if (t1.getRelativeTransAmt() != null
							&& !"".equals(t1.getRelativeTransAmt())) {
						r1amt = t1.getRelativeTransAmt();
					}
					if (t2.getRelativeTransAmt() != null
							&& !"".equals(t2.getRelativeTransAmt())) {
						r2amt = t2.getRelativeTransAmt();
					}
					return ascending ? r1amt.compareTo(r2amt) : r2amt
							.compareTo(r1amt);
				} else if (column.equals("relativeTransNum")) {
					Long t1num = Long.valueOf("0");
					Long t2num = Long.valueOf("0");
					if (t1.getRelativeTransNum() != null
							&& !"".equals(t1.getRelativeTransNum())) {
						t1num = t1.getRelativeTransNum();
					}
					if (t2.getRelativeTransNum() != null
							&& !"".equals(t2.getRelativeTransNum())) {
						t2num = t2.getRelativeTransNum();
					}
					return ascending ? t1num.compareTo(t2num) : t2num
							.compareTo(t1num);
				} else if (column.equals("triggerRuleNum")) {
					return ascending ? t1.getTriggerRuleNum().toString()
							.compareTo(t2.getTriggerRuleNum().toString()) : t2
							.getTriggerRuleNum().toString().compareTo(
									t1.getTriggerRuleNum().toString());
				} else if (column.equals("status")) {
					return ascending ? t1.getStatus().toString().compareTo(
							t2.getStatus().toString()) : t2.getStatus()
							.toString().compareTo(t1.getStatus().toString());
				} else if (column.equals("way")) {
					return ascending ? t1.getWay().compareTo(t2.getWay())
							: t2.getWay().compareTo(t1.getWay());
				} else if (column.equals("action")) {
					return ascending ? t1.getAction().compareTo(t2.getAction())
							: t2.getAction().compareTo(t1.getAction());
				} else if (column.equals("mchntType")) {
					Integer type1 = 0;
					Integer type2 = 0;
					if("一类".equals(t1.getMchntType())) {
						type1 = 1;
					}
					if("二类".equals(t1.getMchntType())) {
						type1 = 2;
					}
					if("三类".equals(t1.getMchntType())) {
						type1 = 3;
					}
					if("四类".equals(t1.getMchntType())) {
						type1 = 4;
					}
					if("五类".equals(t1.getMchntType())) {
						type1 = 5;
					}	
					if("一类".equals(t2.getMchntType())) {
						type2 = 1;
					}
					if("二类".equals(t2.getMchntType())) {
						type2 = 2;
					}
					if("三类".equals(t2.getMchntType())) {
						type2 = 3;
					}
					if("四类".equals(t2.getMchntType())) {
						type2 = 4;
					}
					if("五类".equals(t2.getMchntType())) {
						type2 = 5;
					}					
					return ascending ? type1.compareTo(type2)
							: type2.compareTo(type1);
				}else
					return 0;
			}
		};
		List list = (List) this.dataModel.getWrappedData();
		if (list != null)
			Collections.sort(list, comparator);
	}

	private void setInitQueryFields() {
		String _hsql = "";
		if(this.queryFields != null && !this.queryFields.isEmpty()) {
			_hsql = (String) this.queryFields.get("_hsql");
		}
		if (_hsql != null && !"".equals(_hsql)) {
			return;
		}
		String hsql = "";
		String status = (String) this.queryFields.get("status");
		if (!"1".equals(getLevel())) {
			List list = getOrganizeIdList();
			if (list != null && list.size() > 0) {
				String str = listToStringOfIn(list);
				UserBean userBean = getUserBean();
				TuserInfo tuserInfo = userBean.getTuserInfo();
				String organizeId = tuserInfo.getOrganizeId();
				if (isThirdDw(organizeId)) {
					if (status != null && !"".equals(status)) {
						hsql = hsql + " submit_2_inst in (" + str
								+ ") and status='" + status + "'";
					} else {
						hsql = hsql
								+ " submit_2_inst in ("
								+ str
								+ ") and (status='2' or status='3' or status='4' or status='5' or status='6')";
					}
				} else {
					if (status != null && !"".equals(status)) {
						if ("2".equals(status)) {
							hsql = hsql + " submit_2_inst = belong_to_inst";
						} else {
							hsql = hsql + " belong_to_inst in (" + str + ")";
						}
						hsql = hsql + " and status='" + status + "'";
					} else {
						hsql = hsql
								+ " belong_to_inst in ("
								+ str
								+ ") and (status='1' or status='2' or status='3' or status='4' or status='5' or status='6')";
					}
				}
			}
		} else {
			if (status != null && !"".equals(status)) {
				hsql = hsql + " status='" + status + "'";
			} else {
				hsql = hsql + " 1=1";
				if (!"".equals(getSysHsql()) && getSysHsql() != null) {
					hsql = hsql + getSysHsql();
				}
			}
		}
		if (!"".equals(hsql)) {
			hsql = hsql
					+ " order by triskcase.backCnt desc,triskcase.urgentCnt desc,triskcase.processLimit asc,triskcase.warnLevel desc";
			this.queryFields.put("_hsql", hsql);
		}
	}

	// public int getRow
	public DataPage getDataPage(int startRow, int pageSize) {
		// access database here, or call EJB to do so
		this.queryFields.put("startRow", String.valueOf(startRow));
		this.queryFields.put("pageSize", String.valueOf(pageSize));
		List subList = service.getTriskcaseListOfQuery(this.queryFields);
		List itemList = new ArrayList();
		if (subList != null && subList.size() > 0) {
			for (int i = 0; i < subList.size(); i++) {
				Triskcase triskcase = (Triskcase) subList.get(i);
				if (triskcase.getSubmit2Inst() == null
						|| "".equals(triskcase.getSubmit2Inst())) {
					if (triskcase.getMchntCd() != null
							&& !"".equals(triskcase.getMchntCd())) {

						triskcase.setSubmit2Inst(getNewSubmit2Inst(triskcase
								.getMchntCd()));
					}
				}
				if (triskcase.getProcessLimit() == null) {
					triskcase.setProcessLimit(getProcessLimitDate());
				}
				for (Iterator iterator = triskcase.getTriskcaseRecordGroup()
						.iterator(); iterator.hasNext();) {
					TriskcaseRecord triskcaseRecord = (TriskcaseRecord) iterator
							.next();
					if (!triskcaseRecord.getIsLocked()) {
						if (triskcaseRecord.getInvestigationResult() != null) {
							triskcase.setAction(triskcaseRecord
									.getInvestigationResult());
						}
						if (triskcaseRecord.getProcess2Type() != null) {
							triskcase.setWay(triskcaseRecord.getProcess2Type());
						}
					}
				}
				if (triskcase.getRelativeTransAmt() != null) {
					double d = triskcase.getRelativeTransAmt().doubleValue();
					triskcase.setRelativeTransAmt(Double.valueOf(d / 100));
				}
				if(triskcase.getTransMcc() != null) {
					triskcase.setMchntType(this.getMchntType(triskcase.getTransMcc()));
				}
				itemList.add(triskcase);
			}
		}
		int total = service.getTriskcaseListOfCount(this.queryFields);
		DataPage dataPage = new DataPage(total, startRow, itemList);
		return dataPage;
	}

	public int fetchRowCount() {
		int total = service.getTriskcaseListOfCount(this.queryFields);
		return total;
	}

	/**
	 * Sets the Triskcases.
	 * 
	 * @param triskcases
	 *            The Triskcases to set.
	 */
	public void setTriskcases(List triskcases) {
		this.triskcases = triskcases;
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
	 * 删除Triskcase对象.
	 * 
	 * @return String.
	 */
	public void delete() {
		try {
			Triskcase triskcase = triskcases.get(rowIndex);
			DataManageController dataManageController = (DataManageController) getBean("dataManageController");
			String sql = "select create_inst from t_riskcase where id='"
					+ triskcase.getId() + "'";
			Map map = dataManageController.queryForMap(sql);
			BigDecimal uploadInstBig = (BigDecimal) map.get("CREATE_INST");
			String uploadInst = String.valueOf(uploadInstBig.intValue());
			UserBean userBean = getUserBean();
			TuserInfo tuserInfo = userBean.getTuserInfo();
			String currentOrganizeId = tuserInfo.getOrganizeId();
			if (uploadInst != null && !"".equals(uploadInst)) {
				if (getOrganizeValue(uploadInst, currentOrganizeId) == -1) {
					this.addMessageString("您无权删除上级机构录入的案例!");
					return;
				}
			}
			service.delete(triskcase.getId());
			addMessage("triskcase.message.deleted", triskcase.getId());
			this.triskcases.remove(rowIndex.intValue());
		} catch (BeGenException e) {
			// TODO Auto-generated catch block
			this.addMessage(e.getCode(), e.getMsg(), e);
		}
	}

	/**
	 * 删除Triskcase对象 (子表有数据不允许删除）.
	 * 
	 * @return String.
	 */
	public String deleteOfNoChild() {
		try {
			Triskcase triskcase = triskcases.get(rowIndex);

			service.delete(this.triskcase.getId());
			addMessage("triskcase.message.deleted", this.triskcase.getId());
		} catch (BeGenException e) {
			// TODO Auto-generated catch block
			this.addMessage(e.getCode(), e.getMsg(), e);
			return null;
		}
		return null;
	}

	/**
	 * 查询Triskcase对象.
	 * 
	 * @return String.
	 */
	public String query() {
		try {
			setQueryFields();
			if (dataModel == null) {
				dataModel = new LocalDataModel(20);
			}
			refreshAfterSearch();
		} catch (BeGenException e) {
			// TODO Auto-generated catch block
			this.addMessage(e.getCode(), e.getMsg(), e);
		}
		return null;
	}
	
  	private void refreshAfterSearch(){
		this.dataTable.setFirst(0);
		//dataTable = new HtmlDataTable();
	}

	private void setQueryFields() {
		String status = (String) this.queryFields.get("status");
		String hsql = " 1=1";
		if (status != null && !"".equals(status)) {
			hsql = hsql + " and status='" + status + "'";
		}
		if (!"".equals(getSysHsql())) {
			hsql = hsql + getSysHsql();
		}
		hsql = hsql + " or ";
		if (!"".equals(hsql)) {
			hsql = hsql.substring(0, hsql.length() - 4);
			hsql = hsql
					+ " order by triskcase.backCnt desc,triskcase.urgentCnt desc,triskcase.processLimit asc,triskcase.warnLevel desc";
			this.queryFields.put("_hsql", hsql);
			this.saveQueryFiellds.putAll(this.queryFields);
			this.saveQueryFiellds.put("_hsql", hsql);
		}
	}

	// 分支机构或地市业务部查询
	public String queryByInst() {
		try {
			setQueryByInstFields();
			if (dataModel == null) {
				dataModel = new LocalDataModel(20);
			}
			refreshAfterSearch();
		} catch (BeGenException e) {
			// TODO Auto-generated catch block
			this.addMessage(e.getCode(), e.getMsg(), e);
		}
		return null;
	}

	private void setQueryByInstFields() {
		List list = getOrganizeIdOfInstList();
		String organizeIdStr = listToStringOfIn(list);
		String status = (String) this.queryFields.get("status");
		String hsql = "";
		if (list == null || list.size() == 0) {
			this.addMessageString("您的帐号不属于任何机构,所以无法查阅案例信息,请联系系统管理员!");
			return;
		} else {
			if ("2".equals(getLevel())) {
				hsql = hsql + " belong_to_inst";
			} else if ("3".equals(getLevel())) {
				hsql = hsql + " submit_2_inst";
			} else {
				hsql = hsql + " belong_to_inst";
			}
			hsql = hsql + " in (" + organizeIdStr + ") and (";
			if (status == null || "".equals(status)) {
				if ("2".equals(getLevel())) {
					hsql = hsql + "status = '1' or";
				}
				hsql = hsql
						+ " status='2' or status='3' or status='4' or status='5' or status='6')";
			} else {
				hsql = hsql + "status='" + status + "')";
			}
			if (!"".equals(getSysHsql())) {
				hsql = hsql + getSysHsql();
			}
			hsql = hsql + " or ";
		}
		if (!"".equals(hsql)) {
			hsql = hsql.substring(0, hsql.length() - 4);
			hsql = hsql
					+ " order by triskcase.backCnt desc,triskcase.urgentCnt desc,triskcase.processLimit asc,triskcase.warnLevel desc";
			this.queryFields.put("_hsql", hsql);
			this.saveQueryFiellds.putAll(this.queryFields);
			this.saveQueryFiellds.put("_hsql", hsql);
		}
	}

	public String add() {
		return this.getSuccessAction();
	}

	public void multiAdd() {
		Triskcase triskcase = new Triskcase();
		triskcase.set_record_index(-1);
		triskcase.set_edit_flag(Triskcase.EDIT_FLAG_ADD);
		this.triskcases.add(triskcase);
	}

	public void popupAdd() {
		Triskcase triskcase = new Triskcase();
		triskcase.set_record_index(-1);
		triskcase.set_edit_flag(Triskcase.EDIT_FLAG_ADD);
		this.getRequest().getSession().setAttribute("__pop_object", triskcase);
	}

	public void popupEdit() {
		Triskcase triskcase = triskcases.get(rowIndex);
		triskcase.set_record_index(rowIndex);
		if (Triskcase.EDIT_FLAG_ADD != triskcase.get_edit_flag()) {
			triskcase.set_edit_flag(Triskcase.EDIT_FLAG_EDIT);
		}
		this.getRequest().getSession().setAttribute("__pop_object", triskcase);
	}

	public void popupView() {
		Triskcase triskcase = triskcases.get(rowIndex.intValue());
		this.getRequest().getSession().setAttribute("__pop_object", triskcase);
	}

	public void popupRefresh() {
		Triskcase triskcase = (Triskcase) this.getRequest().getSession()
				.getAttribute("__pop_object");
		if (triskcase.get_record_index() != -1) {
			this.triskcases.remove(triskcase.get_record_index());
			this.triskcases.add(triskcase.get_record_index(), triskcase);
		} else {
			this.triskcases.add(triskcase);
		}
		this.getRequest().getSession().removeAttribute("__pop_object");
	}

	public String edit() {
		UserBean userBean = getUserBean();
		TuserInfo tuserInfo = userBean.getTuserInfo();
		String currentOrganizeId = tuserInfo.getOrganizeId();
		Triskcase triskcase = (Triskcase) ((List) this.dataModel
				.getWrappedData()).get(rowIndex.intValue() % 20);
		if ("6".equals(triskcase.getStatus())) {
			this.addMessageString("不能修改已结案的案例!");
			return null;
		}
		if ("1".equals(getLevel()) && !"0".equals(triskcase.getStatus())) {
			this.addMessageString("该案例已派发,无法修改该案例的信息!");
			return null;
		}
		if ("2".equals(getLevel())
				&& (!"0".equals(triskcase.getStatus()) && !"1".equals(triskcase
						.getStatus()))) {
			this.addMessageString("该案例已在处理状态,无法修改该案例的信息!");
			return null;
		}
		DataManageController dataManageController = (DataManageController) getBean("dataManageController");
		String sql = "select create_inst from t_riskcase where id='"
				+ triskcase.getId() + "'";
		Map map = dataManageController.queryForMap(sql);
		BigDecimal uploadInstBig = (BigDecimal) map.get("CREATE_INST");
		String uploadInst = "0";
		if (uploadInstBig != null) {
			uploadInst = String.valueOf(uploadInstBig.intValue());
		}
		if (uploadInst != null && !"".equals(uploadInst)) {
			if (getOrganizeValue(uploadInst, currentOrganizeId) == -1) {
				this.addMessageString("您无权编辑上级机构录入的案例!");
				return null;
			}
			if ("1".equals(getLevel())
					&& (!"0".equals(triskcase.getStatus()) && !"1"
							.equals(triskcase.getStatus()))) {
				this.addMessageString("该案例已在处理状态,无法修改该案例的信息!");
				return null;
			}
		}
		triskcase.set_record_index(rowIndex);
		if (Triskcase.EDIT_FLAG_ADD != triskcase.get_edit_flag()) {
			triskcase.set_edit_flag(Triskcase.EDIT_FLAG_EDIT);
			this.setValueBinding("#{triskcaseForm.triskcasePrimaryKey}",
					triskcase.getId());
			this.setValueBinding("#{triskcaseForm.queryFields}",
					this.queryFields);
		}
		return this.getSuccessAction();
	}

	public String choiceInst() {
		Triskcase triskcase = (Triskcase) ((List) this.dataModel
				.getWrappedData()).get(rowIndex.intValue());
		if (!"1".equals(triskcase.getStatus())) {
			this.addMessageString("当前案例状态不是待处理,所以不能选择处理机构!");
			return null;
		}
		triskcase.set_record_index(rowIndex);
		if (Triskcase.EDIT_FLAG_ADD != triskcase.get_edit_flag()) {
			triskcase.set_edit_flag(Triskcase.EDIT_FLAG_EDIT);
			this.setValueBinding("#{triskcaseForm.triskcasePrimaryKey}",
					triskcase.getId());
		}
		return this.getSuccessAction();
	}

	public String view() {
		Triskcase triskcase = (Triskcase) ((List) this.dataModel
				.getWrappedData()).get(rowIndex.intValue() % 20);
		TmchntDAO tmchntDAO = (TmchntDAO) getBean("tmchntDAO");
		Tmchnt tmchnt = new Tmchnt();
		tmchnt.setMerchantno(triskcase.getMchntCd());
		List list = tmchntDAO.getTmchntList(tmchnt);
		if (list != null && list.size() > 0) {
			tmchnt = (Tmchnt) list.get(0);
		}
		Set set = triskcase.getTriskcaseRecordGroup();
		String recordId = "";
		for (Iterator it = set.iterator(); it.hasNext();) {
			TriskcaseRecord triskcaseRecord = (TriskcaseRecord) it.next();
			if (triskcaseRecord != null) {
				if (!triskcaseRecord.getIsLocked()) {
					recordId = triskcaseRecord.getId();
					break;
				}
			}
		}
		this.setValueBinding("#{triskcaseForm.triskcasePrimaryKey}", triskcase
				.getId());
		this.setValueBinding(
				"#{triskcaseRecordForm.triskcaseRecordPrimaryKey}", recordId);
		this.setValueBinding("#{triskcaseForm.tmchntPrimaryKey}", tmchnt
				.getId());
		if(!this.saveQueryFiellds.isEmpty()) { 
			this.setValueBinding("#{triskcaseForm.queryFields}",
					this.saveQueryFiellds);
		} else {
			this.setValueBinding("#{triskcaseForm.queryFields}",
					this.queryFields);
		}
		this.setValueBinding("#{triskcaseForm.relativeAmt}", this
				.getRelativeAmt());
		this.setValueBinding("#{triskcaseForm.allAmt}", this.getAllAmt());
		return this.getSuccessAction();
	}

	private Double getRelativeAmt() {
		Triskcase triskcase = (Triskcase) ((List) this.dataModel
				.getWrappedData()).get(rowIndex.intValue() % 20);
		return triskcase.getRelativeTransAmt();
	}

	private Double getAllAmt() {
		Triskcase triskcase = (Triskcase) ((List) this.dataModel
				.getWrappedData()).get(rowIndex.intValue() % 20);
		return triskcase.getAllTransAmt();
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
		Triskcase triskcase = triskcases.get(rowIndex.intValue());
		if (Triskcase.EDIT_FLAG_ADD != triskcase.get_edit_flag()) {
			deleteList.add(triskcase.getId());
		}
		triskcases.remove(rowIndex.intValue());
	}

	public void moveUpBuffer() {
		int i = rowIndex;
		int j = getMovedTriskcaseIndex(i, -1);
		if (j == -1)
			return;
		Triskcase triskcase = triskcases.get(i);
		triskcases.add(j, triskcase);
		triskcases.remove(i + 1);
	}

	private int getMovedTriskcaseIndex(int index, int step) {
		if (index + step >= 0 && index + step < triskcases.size()) {
			Triskcase triskcase = triskcases.get(index + step);
			if (Triskcase.EDIT_FLAG_DELETE == triskcase.get_edit_flag())
				return index + step
						+ getMovedTriskcaseIndex(index + step, step);
			else
				return index + step;
		} else {
			return -1;
		}
	}

	public void moveDownBuffer() {
		int i = rowIndex;
		int j = getMovedTriskcaseIndex(i, 1);
		if (j == -1)
			return;
		Triskcase triskcase = triskcases.get(j);
		triskcases.add(i, triskcase);
		triskcases.remove(j + 1);
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
			for (int i = 0; i < triskcases.size(); i++) {
				Triskcase triskcase = (Triskcase) this.triskcases.get(i);
				service.saveTriskcase(triskcase);
			}
			addMessage("triskcase.message.savedAll", null);
			return this.getSuccessAction();
		} catch (BeGenException e) {
			// TODO Auto-generated catch block
			this.addMessage(e.getCode(), e.getMsg(), e);
		}
		return null;
	}

	public void deleteChecked() {
		for (Triskcase triskcase : this.triskcases) {
			if (triskcase.is_checked_flag()) {
				service.delete(triskcase.getId());
			}
		}
	}

	public void deleteAll() {
		service.deleteAll(this.triskcases);
	}

	private List getOrganizeIdList() {
		UserBean userBean = getUserBean();
		TuserInfo userInfo = userBean.getTuserInfo();
		String organizeId = userInfo.getOrganizeId();
		if (!"".equals(organizeId)) {
			return getOrganizedIdOfParent(organizeId);
		} else {
			return null;
		}
	}

	private List getOrganizedIdOfParent(String organized) {
		List<String> itemList = new ArrayList<String>();
		TorganizeInfoDAO torganizeInfoDAO = (TorganizeInfoDAO) getBean("torganizeInfoDAO");
		TorganizeInfo torganizeInfo = torganizeInfoDAO
				.getTorganizeInfo(organized);
		if (torganizeInfo.getParentId() == null
				|| "".equals(torganizeInfo.getParentId())) {
			return null;
		} else {
			itemList.add(organized);
			TorganizeInfo torganizeInfo2 = new TorganizeInfo();
			torganizeInfo2.setParentId(organized);
			if (torganizeInfo2 != null) {
				List childList = torganizeInfoDAO
						.getTorganizeInfoList(torganizeInfo2);
				for (int i = 0; i < childList.size(); i++) {
					torganizeInfo2 = (TorganizeInfo) childList.get(i);
					if (torganizeInfo2.getDwFlag() != null
							&& torganizeInfo2.getDwFlag()) {
						String childOrganized = torganizeInfo2.getId();
						itemList.add(childOrganized);
					}
				}
			}
		}
		return itemList;
	}

	private TorganizeInfo getTorganizeInfo(String id) {
		TorganizeInfoDAO torganizeInfoDAO = (TorganizeInfoDAO) getBean("torganizeInfoDAO");
		TorganizeInfo torganizeInfo = torganizeInfoDAO.getTorganizeInfo(id);
		return torganizeInfo;
	}

	private boolean isThirdDw(String organizeId) {
		TorganizeInfo torganizeInfo = getTorganizeInfo(organizeId);
		if (torganizeInfo.getOrganizeLevel() == 3) {
			return true;
		}
		return false;
	}

	// 总公司派发到分支机构
	public String send() {
		try {
			TriskcaseService service = (TriskcaseService) getBean("triskcaseService");
			List list = (List) this.dataModel.getWrappedData();
			for (int i = 0; i < list.size(); i++) {
				Triskcase triskcase = (Triskcase) list.get(i);
				if (triskcase.isChecked()) {
					triskcase.setStatus("1");
					service.saveTriskcase(triskcase);
				}
			}
			this.addMessageString("案例派发成功!");
			return this.getSuccessAction();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			this.addMessageString("案例派发失败!");
			return getSuccessAction();
		}
	}

	// 催办
	public String urgent() {
		try {
			TriskcaseService service = (TriskcaseService) getBean("triskcaseService");
			List list = (List) this.dataModel.getWrappedData();
			for (int i = 0; i < list.size(); i++) {
				Triskcase triskcase = (Triskcase) list.get(i);
				if (triskcase.isChecked()) {
					Integer urgentCnt = triskcase.getUrgentCnt();
					int j = 0;
					if (urgentCnt != null) {
						j = urgentCnt.intValue();
					}
					j++;
					triskcase.setUrgentCnt(Integer.valueOf(j));
					triskcase.setBeenUrgent(Boolean.TRUE);
					service.saveTriskcase(triskcase);
				}
			}
			this.addMessageString("案例督办成功!");
			return this.getSuccessAction();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			this.addMessageString("案例督办失败!");
			return null;
		}
	}

	// 分支机构派发到地市级机构
	public String sendToInst() {
		try {
			TriskcaseService service = (TriskcaseService) getBean("triskcaseService");
			List list = (List) this.dataModel.getWrappedData();
			for (int i = 0; i < list.size(); i++) {
				Triskcase triskcase = (Triskcase) list.get(i);
				if (triskcase.isChecked()) {
					triskcase.setStatus("2");
					service.saveTriskcase(triskcase);
				}
			}
			this.addMessageString("案例派发成功!");
			return getSuccessAction();
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			this.addMessageString("案例派发失败!");
			return getSuccessAction();
		}
	}

	private List getOrganizeIdOfInstList() {
		List list = new ArrayList();
		UserBean userBean = getUserBean();
		TuserInfo userInfo = userBean.getTuserInfo();
		String organizeId = userInfo.getOrganizeId();
		TorganizeInfoDAO torganizeInfoDAO = (TorganizeInfoDAO) getBean("torganizeInfoDAO");
		TorganizeInfo torganizeInfo = torganizeInfoDAO
				.getTorganizeInfo(organizeId);
		String level = String.valueOf(torganizeInfo.getOrganizeLevel());
		if ("2".equals(level)) {
			list.add(torganizeInfo.getId());
			TorganizeInfo torganizeInfoChild = new TorganizeInfo();
			torganizeInfoChild.setParentId(torganizeInfo.getId());
			List childList = torganizeInfoDAO
					.getTorganizeInfoList(torganizeInfoChild);
			for (int i = 0; i < childList.size(); i++) {
				torganizeInfoChild = (TorganizeInfo) childList.get(i);
				list.add(torganizeInfoChild.getId());
			}
		} else if ("3".equals(level)) {
			list.add(torganizeInfo.getId());
		} else {
			List organizeList = torganizeInfoDAO
					.getTorganizeInfoList(new TorganizeInfo());
			for (int i = 0; i < organizeList.size(); i++) {
				TorganizeInfo torganizeInfoParent = (TorganizeInfo) organizeList
						.get(i);
				if (torganizeInfoParent.getDwFlag() != null
						&& torganizeInfoParent.getDwFlag()) {
					list.add(torganizeInfoParent.getId());
				}
			}
		}
		return list;
	}

	private String getLevel() {
		UserBean userBean = getUserBean();
		TuserInfo userInfo = userBean.getTuserInfo();
		String organizeId = userInfo.getOrganizeId();
		TorganizeInfoDAO torganizeInfoDAO = (TorganizeInfoDAO) getBean("torganizeInfoDAO");
		TorganizeInfo torganizeInfo = torganizeInfoDAO
				.getTorganizeInfo(organizeId);
		return String.valueOf(torganizeInfo.getOrganizeLevel());
	}

	private String getSysHsql() {
		String hsql = "";
		String belongToInst = (String) this.queryFields.get("belongToInst");
		String ruleGroupId = (String) this.queryFields.get("ruleGroup");
		String warnLevel = (String) this.queryFields.get("warnLevel");
		String triggerRuleNum = (String) this.queryFields.get("triggerRuleNum");
		String urgentCnt = (String) this.queryFields.get("urgentCnt");
		String backCnt = (String) this.queryFields.get("backCnt");
		String processLimit_min = (String) this.queryFields
				.get("processLimit_min");
		String processLimit_max = (String) this.queryFields
				.get("processLimit_max");
		String createdate_min = (String) this.queryFields.get("createdate_min");
		String createdate_max = (String) this.queryFields.get("createdate_max");
		String mchntCd = (String) this.queryFields.get("mchntCd");
		String casefrom = (String) this.queryFields.get("casefrom");
		String caseno = (String) this.queryFields.get("caseno");
		String mchntName = (String) this.queryFields.get("mchntName");
		String transMcc = (String) this.queryFields.get("transMcc");
		String submit2Inst = (String) this.queryFields.get("submit2Inst");
		String beginDate = (String) this.queryFields.get("beginDate");
		String endDate = (String) this.queryFields.get("endDate");		
		if (!"".equals(belongToInst) && belongToInst != null) {
			hsql = hsql + " and belong_to_inst='" + belongToInst + "'";
		}
		if (!"".equals(ruleGroupId) && ruleGroupId != null) {
			hsql = hsql + " and rule_group_id='" + ruleGroupId + "'";
		}
		if (!"".equals(warnLevel) && warnLevel != null) {
			hsql = hsql + " and warn_level='" + warnLevel + "'";
		}
		if (!"".equals(backCnt) && backCnt != null) {
			hsql = hsql + " and back_cnt>='" + backCnt + "'";
		}
		if (!"".equals(urgentCnt) && !"0".equals(urgentCnt)
				&& urgentCnt != null) {
			hsql = hsql + " and urgent_cnt>='" + urgentCnt + "'";
		}
		if (!"".equals(triggerRuleNum) && triggerRuleNum != null) {
			hsql = hsql + " and trigger_rule_num>='" + triggerRuleNum + "'";
		}
		if (!"".equals(mchntCd) && mchntCd != null) {
			hsql = hsql + " and mchnt_cd='" + mchntCd + "'";
		}
		if (!"".equals(casefrom) && casefrom != null) {
			hsql = hsql + " and casefrom='" + casefrom + "'";
		}
		if ((!"".equals(processLimit_min) && processLimit_min != null)
				&& (!"".equals(processLimit_max) && processLimit_max != null)) {
			hsql = hsql + " and (process_limit between to_date('"
					+ processLimit_min + "','yyyy-MM-dd') and to_date('"
					+ processLimit_max + "','yyyy-MM-dd'))";
		} else if ((!"".equals(processLimit_min) && processLimit_min != null)) {
			hsql = hsql + " and (process_limit=to_date('" + processLimit_min
					+ "','yyyy-MM-dd'))";
		} else if (!"".equals(processLimit_max) && processLimit_max != null) {
			hsql = hsql + " and (process_limit=to_date('" + processLimit_max
					+ "','yyyy-MM-dd'))";
		}
		if ((!"".equals(createdate_min) && createdate_min != null)
				&& (!"".equals(createdate_max) && createdate_max != null)) {
			hsql = hsql + " and (createdate between to_date('" + createdate_min
					+ "','yyyy-MM-dd') and to_date('" + createdate_max
					+ "','yyyy-MM-dd'))";
		} else if ((!"".equals(createdate_min) && createdate_min != null)) {
			hsql = hsql + " and (createdate=to_date('" + createdate_min
					+ "','yyyy-MM-dd'))";
		} else if (!"".equals(createdate_max) && createdate_max != null) {
			hsql = hsql + " and (createdate=to_date('" + createdate_max
					+ "','yyyy-MM-dd'))";
		}
		if (!"".equals(caseno) && caseno != null) {
			hsql = hsql + " and caseno='" + caseno + "'";
		}
		if (!"".equals(transMcc) && transMcc != null) {
			hsql = hsql + " and trans_mcc='" + transMcc + "'";
		}
		if (!"".equals(submit2Inst) && submit2Inst != null) {
			hsql = hsql + " and submit_2_Inst='" + submit2Inst + "'";
		}
		if (!"".equals(mchntName) && mchntName != null) {
			hsql = hsql + " and mchnt_name like '%" + mchntName + "%'";
		}
		if (!"".equals(beginDate) && beginDate != null) {
			hsql = hsql + " and begin_date=to_date('" + beginDate + "','yyyy-MM-dd')";
		}
		if (!"".equals(endDate) && endDate != null) {
			hsql = hsql + " and end_date=to_date('" + endDate + "','yyyy-MM-dd')";
		}		
		return hsql;
	}

	private int getOrganizeValue(String uploadInst, String currentOrganizeId) {
		Integer currentLevel = getOrganizeLevel(currentOrganizeId);
		Integer uploadLevel = getOrganizeLevel(uploadInst);
		if (currentLevel.compareTo(uploadLevel) == -1) {
			return 1;
		} else if (currentLevel.compareTo(uploadLevel) == 0) {
			return 0;
		} else {
			return -1;
		}
	}

	private Integer getOrganizeLevel(String organizeId) {
		TorganizeInfoDAO torganizeInfoDAO = (TorganizeInfoDAO) getBean("torganizeInfoDAO");
		TorganizeInfo torganizeInfo = torganizeInfoDAO
				.getTorganizeInfo(organizeId);
		return torganizeInfo.getOrganizeLevel();
	}

	private Date getProcessLimitDate() {
		Calendar rightnow = Calendar.getInstance();
		rightnow.add(Calendar.DATE, 5);
		rightnow.setTime(rightnow.getTime());
		int x = rightnow.get(Calendar.DAY_OF_WEEK);
		if (x == 1) {
			rightnow.add(Calendar.DATE, 2);
		} else if (x == 7) {
			rightnow.add(Calendar.DATE, 2);
		}
		return rightnow.getTime();
	}

	private String listToStringOfIn(List list) {
		if (list != null && list.size() > 0) {
			String str = "";
			for (int i = 0; i < list.size(); i++) {
				String id = (String) list.get(i);
				str = str + "'" + id + "',";
			}
			if (!"".equals(str)) {
				str = str.substring(0, str.length() - 1);
			}
			return str;
		}
		return null;
	}

	private List getCaseRuleGroupList(String ruleGroup) {
		TriskcaseRulegroupDAO triskcaseRulegroupDAO = (TriskcaseRulegroupDAO) getBean("triskcaseRulegroupDAO");
		TriskcaseRulegroup triskcaseRulegroup = new TriskcaseRulegroup();
		triskcaseRulegroup.setRuleGroupId(ruleGroup);
		return triskcaseRulegroupDAO
				.getTriskcaseRulegroupList(triskcaseRulegroup);
	}

	// 分支机构退回到处理部门，状态置为处理中
	public String backToInst() {
		try {
			TriskcaseService service = (TriskcaseService) getBean("triskcaseService");
			List list = (List) this.dataModel.getWrappedData();
			for (int i = 0; i < list.size(); i++) {
				Triskcase triskcase = (Triskcase) list.get(i);
				if (triskcase.isChecked()) {
					triskcase.setStatus("2");
					triskcase.setComments6(this.backComment);
					service.saveTriskcase(triskcase);
				}
			}
			this.addMessageString("案例退回成功!");
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			this.addMessageString("案例退回失败!");
			return null;
		}
	}

	// 总公司退回到分支机构，状态置为待处理，并且增加一次退回次数
	public String backToBelong() {
		try {
			TriskcaseService service = (TriskcaseService) getBean("triskcaseService");
			List list = (List) this.dataModel.getWrappedData();
			for (int i = 0; i < list.size(); i++) {
				Triskcase triskcase = (Triskcase) list.get(i);
				if (triskcase.isChecked()) {
					triskcase.setStatus("1");
					triskcase.setComments6(this.backComment);
					Integer backCntStr = triskcase.getBackCnt();
					int backCnt = 0;
					if (backCntStr != null) {
						backCnt = backCntStr.intValue();
					}
					backCnt++;
					triskcase.setBackCnt(Integer.valueOf(backCnt));
					service.saveTriskcase(triskcase);
				}
			}
			this.addMessageString("案例退回成功!");
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			this.addMessageString("案例退回失败!");
			return null;
		}
	}

	// 分支机构主管退回到风险管理部,将状态置为已处理
	public String backToDep() {
		try {
			TriskcaseService service = (TriskcaseService) getBean("triskcaseService");
			List list = (List) this.dataModel.getWrappedData();
			for (int i = 0; i < list.size(); i++) {
				Triskcase triskcase = (Triskcase) list.get(i);
				if (triskcase.isChecked()) {
					triskcase.setStatus("3");
					triskcase.setComments6(this.backComment);
					service.saveTriskcase(triskcase);
				}
			}
			this.addMessageString("案例退回成功!");
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			this.addMessageString("案例退回失败!");
			return null;
		}
	}

	public String getBackComment() {
		return backComment;
	}

	public void setBackComment(String backComment) {
		this.backComment = backComment;
	}

	public List getBelongToInstList() {
		List<SelectItem> itemList = new ArrayList<SelectItem>();
		TorganizeInfoDAO torganizeInfoDAO = (TorganizeInfoDAO) Tools
				.getBean("torganizeInfoDAO");
		List list = torganizeInfoDAO.getTorganizeInfoList(new TorganizeInfo());
		for (int i = 0; i < list.size(); i++) {
			TorganizeInfo torganizeInfo = (TorganizeInfo) list.get(i);
			if (torganizeInfo.getOrganizeLevel().intValue() == 2
					&& torganizeInfo.getDwFlag()) {
				itemList.add(new SelectItem(torganizeInfo.getId(),
						torganizeInfo.getName()));
			}
		}
		getRuleGroup();
		return itemList;
	}

	public List getRuleGroup() {
		List<SelectItem> itemList = new ArrayList<SelectItem>();
		String belongToInst = "";
		if(this.queryFields != null && !this.queryFields.isEmpty()) {
			belongToInst = (String) this.queryFields.get("belongToInst");
		}
		if (belongToInst != null && !"".equals(belongToInst)) {
			TruleGroupDAO truleGroupDAO = (TruleGroupDAO) getBean("truleGroupDAO");
			TruleGroup truleGroup = new TruleGroup();
			truleGroup.setBelongToInst(belongToInst);
			List list = truleGroupDAO.getTruleGroupList(truleGroup);
			for (int i = 0; i < list.size(); i++) {
				truleGroup = (TruleGroup) list.get(i);
				if (truleGroup.getEnable()) {
					itemList.add(new SelectItem(truleGroup.getId(), truleGroup
							.getDescription()));
				}
			}
		}
		this.truleGroupItems = itemList;
		return null;
	}
	
	public List getBigMccNameList() {
		List<SelectItem> itemList = new ArrayList<SelectItem>();
		itemList.add(new SelectItem("1","一类"));
		itemList.add(new SelectItem("2","二类"));
		itemList.add(new SelectItem("3","三类"));
		itemList.add(new SelectItem("4","四类"));
		itemList.add(new SelectItem("5","五类"));
		getTransMcc();
		return itemList;
	}

	public List getTransMcc() {
		List<SelectItem> itemList = new ArrayList<SelectItem>();
		String bigMcc = "";
		if(this.queryFields != null && !this.queryFields.isEmpty()) {
			bigMcc = (String)this.queryFields.get("bigMccName");
		}
		if(bigMcc != null && !"".equals(bigMcc)) {
			TmccDAO tmccDAO = (TmccDAO)getBean("tmccDAO");
			Tmcc tmcc = new Tmcc();
			tmcc.setBigmccCode(bigMcc);
			List list = tmccDAO.getTmccList(tmcc);
			for(int i = 0; i < list.size(); i++) {
				tmcc = (Tmcc)list.get(i);
				itemList.add(new SelectItem(tmcc.getId(), tmcc.getId() + "(" + tmcc.getMccName() + ")"));
			}
		}
		this.tmccItems = itemList;
		return null;
	}
	
	public List<SelectItem> getTruleGroupItems() {
		return truleGroupItems;
	}

	public void setTruleGroupItems(List<SelectItem> truleGroupItems) {
		this.truleGroupItems = truleGroupItems;
	}

	private String getNewSubmit2Inst(String mchntCd) {
		DataManageController dataManageController = (DataManageController) Tools
				.getBean("dataManageController");
		List list = dataManageController
				.queryForList("select belong_to_org from t_mchnt where merchantno='"
						+ mchntCd + "'");
		if (list != null && list.size() > 0) {
			Map map = (Map) list.get(0);
			BigDecimal big = (BigDecimal) map.get("belong_to_org");
			String submit2InstNew = String.valueOf(big.intValue());
			return submit2InstNew;
		}
		return null;
	}

	public Map getSaveQueryFiellds() {
		return saveQueryFiellds;
	}

	public void setSaveQueryFiellds(Map saveQueryFiellds) {
		this.saveQueryFiellds = saveQueryFiellds;
	}

	public String downLoadExcel() throws IOException {
		HttpServletResponse response = getResponse();
		TriskcaseDAO triskcaseDAO = (TriskcaseDAO) getBean("triskcaseDAO");
		Map map = new HashMap();
		if (!this.saveQueryFiellds.isEmpty()) {
			String hsql = (String) this.saveQueryFiellds.get("_hsql");
			map.put("_hsql", hsql);
		} else {
			String hsql = (String) this.queryFields.get("_hsql");
			map.put("_hsql", hsql);
		}
		List list = triskcaseDAO.getTriskcaseListOfQueryNoSize(map);
		UserBean userBean = getUserBean();
		TuserInfo tuserInfo = userBean.getTuserInfo();
		String id = tuserInfo.getId();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String fileName = id + sdf.format(new Date());
		response.reset();// 清空输出流
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-disposition", "attachment;filename="
				+ Tools.toUtf8String(fileName + ".xls"));
		ExcelOfRiskcaseUtil excelOfRiskcaseUtil = new ExcelOfRiskcaseUtil();
		OutputStream os = response.getOutputStream();
		String flag = excelOfRiskcaseUtil.createExcel(list, os);
		if ("failure".equals(flag)) {
			this.addMessageString("文件导出失败,请联系系统管理与!");
		}
		this.getFacesContext().responseComplete();
		return null;
	}
	
	private String getMchntType(String transMcc) {
		DataManageController dataManageController = (DataManageController)getBean("dataManageController");
		String sql = "select bigmcc_name from t_mcc where id='" + transMcc + "'";
		List list = dataManageController.queryForList(sql);
		Map map = (Map)list.get(0);
		String mchntType = (String)map.get("bigmcc_name");
		return mchntType;
	}

	public List<SelectItem> getTmccItems() {
		return tmccItems;
	}

	public void setTmccItems(List<SelectItem> tmccItems) {
		this.tmccItems = tmccItems;
	}

}
