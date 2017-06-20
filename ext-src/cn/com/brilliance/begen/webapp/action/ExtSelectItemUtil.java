package cn.com.brilliance.begen.webapp.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.TbaseargDAO;
import cn.com.brilliance.begen.dao.TkeoMchntDAO;
import cn.com.brilliance.begen.dao.TmccDAO;
import cn.com.brilliance.begen.dao.TorganizeInfoDAO;
import cn.com.brilliance.begen.dao.TruleGroupDAO;
import cn.com.brilliance.begen.dao.TruleInstanceDAO;
import cn.com.brilliance.begen.model.Tbasearg;
import cn.com.brilliance.begen.model.TkeoMchnt;
import cn.com.brilliance.begen.model.Tmcc;
import cn.com.brilliance.begen.model.TorganizeInfo;
import cn.com.brilliance.begen.model.Trule;
import cn.com.brilliance.begen.model.TruleGroup;
import cn.com.brilliance.begen.model.TruleInstance;
import cn.com.brilliance.begen.model.TuserInfo;
import cn.com.brilliance.begen.service.TorganizeInfoService;
import cn.com.brilliance.begen.service.TruleInstanceService;
import cn.com.brilliance.begen.service.TruleService;
import cn.com.brilliance.begen.service.impl.TruleInstanceServiceImpl;
import cn.com.brilliance.begen.service.impl.TruleServiceImpl;
import cn.com.brilliance.begen.webapp.servlet.UserBean;
import cn.com.brilliance.risk.ext.common.Function;
import cn.com.brilliance.risk.ext.common.NumberComparator;
import cn.com.brilliance.risk.model.comm.TmccComparator;

public class ExtSelectItemUtil {
	private static ApplicationContext ctx = null;

	private Object getBean(String name) {
		if (ctx == null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			ctx = WebApplicationContextUtils
					.getRequiredWebApplicationContext((ServletContext) facesContext
							.getExternalContext().getContext());
		}
		return ctx.getBean(name);
	}

	private UserBean getUserBean() {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		HttpSession session = request.getSession();
		return (UserBean) session.getAttribute("_user_info");
	}

	private Map queryMap = new HashMap();

	public Map getQueryMap() {
		return queryMap;
	}

	public void setQueryMap(Map queryMap) {
		this.queryMap = queryMap;
	}

	public List getTbaseargTypeItems() {
		List itemlist = new ArrayList();
		TbaseargDAO tbaseargDAO = (TbaseargDAO) getBean("tbaseargDAO");
		List list = tbaseargDAO.getTbaseargListOfQuery(this.queryMap);
		for (int i = 0; i < list.size(); i++) {
			Tbasearg tbasearg = (Tbasearg) list.get(i);
			itemlist.add(new SelectItem(String.valueOf(tbasearg.getType()),
					String.valueOf(tbasearg.getType())));
		}
		return itemlist;
	}

	public List<String> getTmccIdsOfTmccs() {
		List list = new ArrayList<String>();
		TmccDAO tmccDAO = (TmccDAO) getBean("tmccDAO");
		List<Tmcc> tmccList = tmccDAO.getTmccListOfQuery(this.queryMap);
		Comparator c = new TmccComparator();
		Collections.sort(tmccList, c);
		for (Tmcc tmcc : tmccList) {
			list.add(new SelectItem(tmcc.getId(), tmcc.getBigmccCode()+"-"+tmcc.getMccCode()+tmcc.getMccName()));
		}
		return list;
	}

	public List<String> getTmccNamessOfTmccs() {
		List list = new ArrayList<String>();
		TmccDAO tmccDAO = (TmccDAO) getBean("tmccDAO");
		List<Tmcc> tmccList = tmccDAO.getTmccNames(this.queryMap);
		for (Tmcc tmcc : tmccList) {
			list.add(new SelectItem(tmcc.getId(), tmcc.getMccCode() + "("
					+ tmcc.getBigmccCode() + ")" + tmcc.getMccName()));

		}
		return list;
	}

	public List<String> getNameOfWarnLevel() {
		List list = new ArrayList<String>();
		TbaseargDAO dao = (TbaseargDAO) getBean("tbaseargDAO");
		List<Tbasearg> tbaseargList = dao.getTbaseargByType(this.queryMap,
				"WarnLevel");
		for (Tbasearg tbasearg : tbaseargList) {
			list.add(new SelectItem(tbasearg.getId(), tbasearg.getName()));
		}
		return list;
	}

	public List getKeoMerTypes() {
		List itemlist = new ArrayList();
		TkeoMchntDAO tkeoMchntDAO = (TkeoMchntDAO) getBean("tkeoMchntDAO");
		List list = tkeoMchntDAO.getTkeoMchntListOfQuery(this.queryMap);
		for (int i = 0; i < list.size(); i++) {
			TkeoMchnt tkeoMchnt = (TkeoMchnt) list.get(i);
			itemlist.add(new SelectItem(String.valueOf(tkeoMchnt.getId()),
					String.valueOf(tkeoMchnt.getType())));
		}
		return itemlist;
	}

	// 根据用户所在机构来显示所属机构
	public List getBelongToInstList() {
		List itemList = new ArrayList();
		UserBean userBean = getUserBean();
		TuserInfo tuserInfo = userBean.getTuserInfo();
		String organizeId = tuserInfo.getOrganizeId();
		TorganizeInfoDAO torganizeInfoDAO = (TorganizeInfoDAO) Tools
				.getBean("torganizeInfoDAO");
		TorganizeInfo torganizeInfo = new TorganizeInfo();
		torganizeInfo.setParentId(organizeId);
		List childIdList = torganizeInfoDAO.getTorganizeInfoList(torganizeInfo);
		if (childIdList.size() == 0) {
			List list = torganizeInfoDAO
					.getTorganizeInfoList(new TorganizeInfo());
			for (int i = 0; i < list.size(); i++) {
				torganizeInfo = (TorganizeInfo) list.get(i);
				if (torganizeInfo.getDwFlag() != null) {
					if (torganizeInfo.getDwFlag()) {
						itemList.add(new SelectItem(String
								.valueOf(torganizeInfo.getId()), String
								.valueOf(torganizeInfo.getName())));
					}
				}
			}
		} else {
			TorganizeInfo ownTorganiceInfo = torganizeInfoDAO
					.getTorganizeInfo(organizeId);
			itemList.add(new SelectItem(String
					.valueOf(ownTorganiceInfo.getId()), String
					.valueOf(ownTorganiceInfo.getName())));
			for (int i = 0; i < childIdList.size(); i++) {
				torganizeInfo = (TorganizeInfo) childIdList.get(i);
				if (torganizeInfo.getDwFlag() != null) {
					if (torganizeInfo.getDwFlag()) {
						itemList.add(new SelectItem(String
								.valueOf(torganizeInfo.getId()), String
								.valueOf(torganizeInfo.getName())));
					}
				}
			}
		}
		return itemList;
	}

	public List getBelongToInstList2() {
		List<SelectItem> itemList = new ArrayList<SelectItem>();
		UserBean userBean = getUserBean();
		TuserInfo tuserInfo = userBean.getTuserInfo();
		String organizeId = tuserInfo.getOrganizeId();
		TorganizeInfoDAO torganizeInfoDAO = (TorganizeInfoDAO) Tools
				.getBean("torganizeInfoDAO");
		TorganizeInfo torganizeInfo = torganizeInfoDAO
				.getTorganizeInfo(organizeId);
		if (torganizeInfo.getOrganizeLevel().intValue() == 1) {
			TorganizeInfo torganizeInfoSecond = new TorganizeInfo();
			torganizeInfoSecond.setParentId(organizeId);
			List secondList = torganizeInfoDAO
					.getTorganizeInfoList(torganizeInfoSecond);
			for (int i = 0; i < secondList.size(); i++) {
				torganizeInfoSecond = (TorganizeInfo) secondList.get(i);
				if (torganizeInfoSecond.getDwFlag()) {
					itemList.add(new SelectItem(String
							.valueOf(torganizeInfoSecond.getId()),
							torganizeInfoSecond.getName()));
				}
			}
		} else if (torganizeInfo.getOrganizeLevel().intValue() == 2) {
			itemList.add(new SelectItem(String.valueOf(torganizeInfo.getId()),
					torganizeInfo.getName()));
		} else if (torganizeInfo.getOrganizeLevel().intValue() == 3) {
			String parentId = torganizeInfo.getParentId();
			TorganizeInfo torganizeInfoParent = torganizeInfoDAO
					.getTorganizeInfo(parentId);
			itemList.add(new SelectItem(String.valueOf(torganizeInfoParent
					.getId()), torganizeInfoParent.getName()));
		}
		return itemList;
	}

	public List getSubmit2Inst2Items() {
		List<SelectItem> itemList = new ArrayList<SelectItem>();
		UserBean userBean = getUserBean();
		TuserInfo tuserInfo = userBean.getTuserInfo();
		String organizeId = tuserInfo.getOrganizeId();
		Map map = new HashMap();
		map.put("dwFlag", "true");
		map.put("parentId", organizeId);
		TorganizeInfoDAO torganizeInfoDAO = (TorganizeInfoDAO) Tools
				.getBean("torganizeInfoDAO");
		TorganizeInfo torganizeInfo = torganizeInfoDAO
				.getTorganizeInfo(organizeId);
		itemList.add(new SelectItem(torganizeInfo.getId(), torganizeInfo
				.getName()));
		List list = torganizeInfoDAO.getTorganizeInfoListOfQuery(map);
		for (int i = 0; i < list.size(); i++) {
			TorganizeInfo torganizeInfoChild = (TorganizeInfo) list.get(i);
			itemList.add(new SelectItem(torganizeInfoChild.getId(), "--"
					+ torganizeInfoChild.getName()));
		}
		// if (torganizeInfo.getOrganizeLevel().intValue() == 1) {
		// List childlist = torganizeInfoDAO
		// .getTorganizeInfoList(new TorganizeInfo());
		// for (int i = 0; i < childlist.size(); i++) {
		// TorganizeInfo torganizeInfoSecond = (TorganizeInfo) childlist.get(i);
		// if(torganizeInfoSecond.getOrganizeLevel().intValue() == 1) {
		// continue;
		// }
		// if (torganizeInfoSecond.getDwFlag() != null &&
		// torganizeInfoSecond.getDwFlag()) {
		// itemList.add(new SelectItem(String
		// .valueOf(torganizeInfoSecond.getId()),
		// torganizeInfoSecond.getName()));
		// }
		// }
		// } else if (torganizeInfo.getOrganizeLevel().intValue() == 2) {
		// itemList.add(new SelectItem(String.valueOf(torganizeInfo.getId()),
		// torganizeInfo.getName()));
		// } else if (torganizeInfo.getOrganizeLevel().intValue() == 3) {
		// String parentId = torganizeInfo.getParentId();
		// TorganizeInfo torganizeInfoParent = torganizeInfoDAO
		// .getTorganizeInfo(parentId);
		// itemList.add(new SelectItem(String.valueOf(torganizeInfoParent
		// .getId()), torganizeInfoParent.getName()));
		// }
		return itemList;
	}
	
	public List getTruleInstanceItems() {
		List itemlist = new ArrayList();

		UserBean userBean = getUserBean();
		String organizeId = userBean.getTuserInfo().getOrganizeId();
		boolean dwFlag = userBean.getTuserInfo().getOrganizeIdOfTorganizeInfo()
				.getDwFlag().booleanValue();
		int orgLevel = userBean.getTuserInfo().getOrganizeIdOfTorganizeInfo()
				.getOrganizeLevel().intValue();
		String parentId = userBean.getTuserInfo()
				.getOrganizeIdOfTorganizeInfo().getParentId();

		TruleInstanceDAO truleInstanceDAO = (TruleInstanceDAO) getBean("truleInstanceDAO");
		Map map = new HashMap();
		map.put("enable", "true");
		if (!Function.isParentCompany(organizeId)) {
			if (dwFlag) {
				if (orgLevel == 2) {
					map.put("belongToInst", organizeId);
				} else if (orgLevel == 3) {
					map.put("belongToInst", parentId);
				}
			}
		}
		map.put("_order", "code asc");
		List list = truleInstanceDAO.getTruleInstanceListOfQuery(map);
		for (int i = 0; i < list.size(); i++) {
			TruleInstance truleInstance = (TruleInstance) list.get(i);
			itemlist.add(new SelectItem(String.valueOf(truleInstance.getId()),
					String.valueOf(truleInstance.getCode() + "-"
							+ truleInstance.getDescription())));
		}
		return itemlist;
	}

	public List getBigmccCodeNames() {
		List nameList = new ArrayList<String>();
		nameList.add("一类");
		nameList.add("二类");
		nameList.add("三类");
		nameList.add("四类");
		nameList.add("五类");
		List list = new ArrayList();
		Integer i = 0;
		for (Iterator iter = nameList.iterator(); iter.hasNext();) {
			i++;
			String s = (String) iter.next();
			list.add(new SelectItem(String.valueOf(i), s));
		}
		return list;
	}

	public List getAdjustAccounts() {
		List adjustList = new ArrayList<String>();
		adjustList.add("贷记调整");
		adjustList.add("退单");
		adjustList.add("请款");
		adjustList.add("二次退单");
		adjustList.add("再请款");
		adjustList.add("其他");
		List list = new ArrayList();
		Integer i = 0;
		for (Iterator iter = adjustList.iterator(); iter.hasNext();) {
			i++;
			String s = (String) iter.next();
			list.add(new SelectItem(String.valueOf(i), s));
		}
		return list;
	}

	public List getUrgentTimes() {
		List itemList = new ArrayList();
		itemList.add(new SelectItem(String.valueOf(0), "督办完成/无督办"));
		for (int i = 1; i < 9999; i++) {
			itemList.add(new SelectItem(String.valueOf(i), String.valueOf(i)
					+ "次督办"));
		}
		return itemList;
	}

	/**
	 * 子规则，规则组设置
	 * 
	 * @return
	 */
	public List getBelongToInstForRuleItems() {
		List itemlist = new ArrayList();
		UserBean userBean = getUserBean();
		/**
		 * String orgnizeId = userBean.getTuserInfo().getOrganizeId();
		 * 
		 * String globalSort = userBean.getTuserInfo()
		 * .getOrganizeIdOfTorganizeInfo().getGlobalSort(); TorganizeInfoDAO
		 * torganizeInfoDAO = (TorganizeInfoDAO) getBean("torganizeInfoDAO");
		 * Map querys = new HashMap(); if (!Function.isParentCompany(orgnizeId)) {
		 * querys.put("dwFlag", "true"); querys.put("globalSort_like",
		 * globalSort); } else { querys.put("dwFlag", "true"); }
		 * querys.put("organizeLevel_min", "1"); querys.put("organizeLevel_max",
		 * "2"); querys.put("_order", "organizeBm asc");
		 * 
		 * List list = torganizeInfoDAO.getTorganizeInfoListOfQuery(querys);
		 */

		List list = Function.getParentCompanyList(userBean);
		for (int i = 0; i < list.size(); i++) {
			TorganizeInfo torganizeInfo = (TorganizeInfo) list.get(i);
			String label = torganizeInfo.getName();
			itemlist.add(new SelectItem(String.valueOf(torganizeInfo.getId()),
					label));
		}
		if (userBean != null
				&& Function.isParentCompany(userBean.getTuserInfo()
						.getOrganizeId())) {
			itemlist.add(new SelectItem("*", "全部"));
		}
		return itemlist;
	}

	/**
	 * 用户信息管理
	 * 
	 * @return
	 */
	public List getBelongToInstItems() {
		List itemlist = new ArrayList();
		UserBean userBean = getUserBean();
		if (userBean == null) {
			return new ArrayList();
		}
		String orgnizeId = userBean.getTuserInfo().getOrganizeId();

		String globalSort = userBean.getTuserInfo()
				.getOrganizeIdOfTorganizeInfo().getGlobalSort();
		TorganizeInfoDAO torganizeInfoDAO = (TorganizeInfoDAO) getBean("torganizeInfoDAO");
		Map querys = new HashMap();
		if (!Function.isParentCompany(orgnizeId)) {
			querys.put("dwFlag", "true");
			querys.put("globalSort_like", globalSort);
		} else {
			querys.put("dwFlag", "true");
		}
		querys.put("_order", "organizeBm asc");

		List list = torganizeInfoDAO.getTorganizeInfoListOfQuery(querys);
		for (int i = 0; i < list.size(); i++) {
			TorganizeInfo torganizeInfo = (TorganizeInfo) list.get(i);
			String label = torganizeInfo.getName();
			int level = torganizeInfo.getOrganizeLevel().intValue();
			if (level == 2) {
				label = "-----" + label;
			} else if (level == 3) {
				label = "----------" + label;
			} else if (level == 4) {
				label = "---------------" + label;
			}
			itemlist.add(new SelectItem(String.valueOf(torganizeInfo.getId()),
					label));
		}
		return itemlist;
	}

	public List getBelongToInstForOrgItems() {
		List itemlist = new ArrayList();
		UserBean userBean = getUserBean();
		List list = Function.getParentCompanyList(userBean);
		for (int i = 0; i < list.size(); i++) {
			TorganizeInfo torganizeInfo = (TorganizeInfo) list.get(i);
			itemlist
					.add(new SelectItem(String.valueOf(torganizeInfo
							.getGlobalSort()), String.valueOf(torganizeInfo
							.getName())));
		}
		return itemlist;
	}

	public List getBelongToDeptItems() {
		List itemlist = new ArrayList();
		UserBean userBean = getUserBean();
		String orgnizeId = userBean.getTuserInfo().getOrganizeId();
		int orgLevel = userBean.getTuserInfo().getOrganizeIdOfTorganizeInfo()
				.getOrganizeLevel().intValue();
		boolean isDw = userBean.getTuserInfo().getOrganizeIdOfTorganizeInfo()
				.getDwFlag().booleanValue();
		String parentId = userBean.getTuserInfo()
				.getOrganizeIdOfTorganizeInfo().getParentId();

		TorganizeInfoDAO torganizeInfoDAO = (TorganizeInfoDAO) getBean("torganizeInfoDAO");
		Map querys = new HashMap();

		if (Function.isParentCompany(orgnizeId)) {
			querys.put("organizeLevel_min", "2");
			querys.put("organizeLevel_max", "4");
		} else {
			querys.put("organizeLevel_min", "" + orgLevel);
			querys.put("organizeLevel_max", "4");
			if (isDw) {
				if (orgLevel == 2) {
					querys.put("parentId", orgnizeId);
				} else if (orgLevel == 3) {
					querys.put("parentId", parentId);
				}
			} else {
				querys.put("parentId", parentId);
			}
		}

		querys.put("_order", "organizeBm asc");
		List list = torganizeInfoDAO.getTorganizeInfoListOfQuery(querys);
		for (int i = 0; i < list.size(); i++) {
			TorganizeInfo torganizeInfo = (TorganizeInfo) list.get(i);
			itemlist.add(new SelectItem(String.valueOf(torganizeInfo.getId()),
					String.valueOf(torganizeInfo.getName())));
		}
		return itemlist;
	}

	public List getTruleItems() {
		List<String> list = new ArrayList();
		List<String> list2 = new ArrayList();
		for (int i = 1; i < 38; i++) {
			String str = (Integer.toString(i).length() > 1) ? String.valueOf(i)
					: "0" + String.valueOf(i);
			String trule = "子规则" + str;
			String trule2 = "R" + str;
			list.add(trule);
			list2.add(trule2);
		}
		List truleItems = new ArrayList();
		for (int i = 1; i < 38; i++) {
			if (i != 12 && i != 21 && i != 22 && i != 23 && i != 24 && i != 25
					&& i != 26 && i != 27 && i != 30 && i != 32 && i != 33
					&& i != 34) {
				truleItems
						.add(new SelectItem(list2.get(i - 1), list.get(i - 1)));
			}
		}
		return truleItems;
		// List itemlist = new ArrayList();itemlist.t
		// String[] disableList =
		// java.util.Arrays.to{"R12","R12","R12","R12","R12","R12","R12","R12","R12","R12"};
		// TruleDAO truleDAO = (TruleDAO)getBean("truleDAO");
		// List list = truleDAO.getTruleListOfQuery(this.queryMap);
		// for(int i=0;i<list.size();i++) {
		// Trule trule = (Trule)list.get(i);
		// itemlist.add(new
		// SelectItem(String.valueOf(trule.getId()),String.valueOf(trule.getDescription())));
		// }
		// return itemlist;
	}

	public List getOrganizations() {
		TorganizeInfoService service = (TorganizeInfoService) getBean("torganizeInfoService");
		TorganizeInfo info2 = service.getTorganizeInfo("72125");
		TorganizeInfo info = service.getTorganizeInfo("0");
		Map queryFields = new HashMap<String, String>();
		queryFields.put("dwFlag", "true");
		queryFields.put("organizeLevel", "2");
		List<TorganizeInfo> list = service
				.getTorganizeInfoListOfQuery(queryFields);

		list.remove(info2);

		List<TorganizeInfo> newArrayList = new ArrayList();
		newArrayList.add(info);
		for (TorganizeInfo tInfo : list) {
			newArrayList.add(tInfo);
		}
		List orgList = new ArrayList();
		for (TorganizeInfo infoAll : newArrayList) {
			orgList.add(new SelectItem(infoAll.getId(), infoAll.getName()));
		}
		return orgList;
	}

	public List getBackCntItems() {
		List itemList = new ArrayList();
		for (int i = 0; i < 9999; i++) {
			itemList.add(new SelectItem(String.valueOf(i), String.valueOf(i)
					+ "次退回"));
		}
		return itemList;
	}

	public List getStatusByOrganizeLevel() {
		List<SelectItem> itemList = new ArrayList<SelectItem>();
		UserBean userBean = getUserBean();
		TuserInfo tuserInfo = userBean.getTuserInfo();
		String organizeId = tuserInfo.getOrganizeId();
		TorganizeInfoDAO torganizeInfoDAO = (TorganizeInfoDAO) Tools
				.getBean("torganizeInfoDAO");
		TorganizeInfo torganizeInfo = torganizeInfoDAO
				.getTorganizeInfo(organizeId);
		if (torganizeInfo.getOrganizeLevel().intValue() == 2) {
			itemList.add(new SelectItem("1", "待处理"));
			itemList.add(new SelectItem("2", "处理中"));
			itemList.add(new SelectItem("3", "已处理,待复核"));
			itemList.add(new SelectItem("4", "部门已复核"));
			itemList.add(new SelectItem("5", "已审核"));
			itemList.add(new SelectItem("6", "结案"));
		} else if (torganizeInfo.getOrganizeLevel().intValue() == 3) {
			itemList.add(new SelectItem("2", "处理中"));
			itemList.add(new SelectItem("3", "已处理,待复核"));
			itemList.add(new SelectItem("4", "部门已复核"));
			itemList.add(new SelectItem("5", "已审核"));
			itemList.add(new SelectItem("6", "结案"));
		}
		return itemList;
	}

	public List getTruleGroupItems() {
		UserBean userBean = getUserBean();
		TuserInfo tuserInfo = userBean.getTuserInfo();
		String organizeId = tuserInfo.getOrganizeId();
		List itemlist = new ArrayList();
		TruleGroupDAO truleGroupDAO = (TruleGroupDAO) getBean("truleGroupDAO");
		TruleGroup truleGroup = new TruleGroup();
		truleGroup.setBelongToInst(organizeId);
		List list = new ArrayList();
		if ("0".equals(organizeId)) {
			list = truleGroupDAO.getTruleGroupList(new TruleGroup());
		} else {
			list = truleGroupDAO.getTruleGroupList(truleGroup);
		}
		for (int i = 0; i < list.size(); i++) {
			truleGroup = (TruleGroup) list.get(i);
			if (truleGroup.getEnable()) {
				itemlist.add(new SelectItem(String.valueOf(truleGroup.getId()),
						truleGroup.getDescription()));
			}
		}
		return itemlist;
	}

	public List getStatusItemsByCheckIn() {
		List<SelectItem> itemList = new ArrayList<SelectItem>();
		UserBean userBean = getUserBean();
		TuserInfo tuserInfo = userBean.getTuserInfo();
		String organizeId = tuserInfo.getOrganizeId();
		TorganizeInfoDAO torganizeInfoDAO = (TorganizeInfoDAO) Tools
				.getBean("torganizeInfoDAO");
		TorganizeInfo torganizeInfo = torganizeInfoDAO
				.getTorganizeInfo(organizeId);
		if (torganizeInfo.getOrganizeLevel().intValue() == 1) {
			itemList.add(new SelectItem("0", "不处理"));
			itemList.add(new SelectItem("1", "待处理"));
		} else if (torganizeInfo.getOrganizeLevel().intValue() == 2) {
			itemList.add(new SelectItem("1", "待处理"));
		} else if (torganizeInfo.getOrganizeLevel().intValue() == 3) {
			itemList.add(new SelectItem("2", "处理中"));
		}
		return itemList;
	}
	
	public List getEnableQueriesItems(){
		List<String> tempList = new ArrayList();
		tempList.add("true");
		tempList.add("false");
		tempList.add("*");
		List<String> tempList2 = new ArrayList();
		tempList2.add("激活");tempList2.add("注销");tempList2.add("全部");
		List list = new ArrayList();
		for (int i = 0; i < tempList.size(); i++) {
			list.add(new SelectItem(tempList.get(i),tempList2.get(i)));
		}
		return list;
	}
	
	public List getTruleGroupsForOrgItems() {
		List itemlist = new ArrayList();
		UserBean userBean = getUserBean();
		String orgId = userBean.getTuserInfo().getOrganizeId();
		TruleGroup truleGroup = new TruleGroup();
		truleGroup.setBelongToInst(orgId);
		TruleGroupDAO truleGroupDAO = (TruleGroupDAO) getBean("truleGroupDAO");
		List list = truleGroupDAO.getTruleGroupList(truleGroup);
		itemlist.add(new SelectItem("", "全部"));
		for (int i = 0; i < list.size(); i++) {
			TruleGroup tg = (TruleGroup) list.get(i);
			itemlist.add(new SelectItem(String.valueOf(tg.getId()), String
					.valueOf(tg.getDescription())));
		}
		return itemlist;
	}
	
	public List getNewRecordList() {
		List<SelectItem> itemList = new ArrayList<SelectItem>();
		itemList.add(new SelectItem("true","是"));
		itemList.add(new SelectItem("false","否"));
		return itemList;
	}
	
	public List getSecondLevelCorpList(){
		List list = new ArrayList();
		TorganizeInfoService torganizeInfoService = (TorganizeInfoService) getBean("torganizeInfoService");
		Map queryFields = new HashMap();
		queryFields.put("dwFlag", "true");
		queryFields.put("organizeLevel_min", "1");
		queryFields.put("organizeLevel_max", "2");
		List<TorganizeInfo> corpList = torganizeInfoService.getTorganizeInfoListOfQuery(queryFields);

		//删除没有的分区
			corpList.remove(corpList.size()-1);
			corpList.remove(corpList.size()-1);
			corpList.remove(0);
			corpList.remove(0);

		for (TorganizeInfo info : corpList) {
			list.add(new SelectItem(String.valueOf(info.getFwdInsIdCd()), String
					.valueOf(info.getName())));
		}
		return list;
	}
	
	public List getTmccListItems() {
		List itemlist = new ArrayList();
		TmccDAO tmccDAO = (TmccDAO)getBean("tmccDAO");
		List list = tmccDAO.getTmccListOfQuery(this.queryMap);
		for(int i=0;i<list.size();i++) {
			Tmcc tmcc = (Tmcc)list.get(i);
			String tmccName = "";
			if(tmcc.getMccName() != null) {
				if(tmcc.getMccName().length() >=6) {
					tmccName = tmcc.getId() + "(" + tmcc.getMccName().substring(0, 5) + ")";
				} else {
					tmccName = tmcc.getId() + "(" + tmcc.getMccName() + ")";
				}
			}
			itemlist.add(new SelectItem(String.valueOf(tmcc.getId()),tmccName));
		}
		return itemlist;
	}		
	
	public List getTmccListOfAscItems() {
		List itemList = new ArrayList();
		TmccDAO tmccDAO = (TmccDAO)getBean("tmccDAO");
		Map map = new HashMap();
		map.put("_order", "id asc");
		List list = tmccDAO.getTmccListOfQuery(map);
		for(int i = 0; i < list.size(); i++) {
			Tmcc tmcc = (Tmcc)list.get(i);
			itemList.add(new SelectItem(String.valueOf(tmcc.getId()),tmcc.getBigmccName() + "-" + tmcc.getId() + "(" + tmcc.getMccName() + ")"));
		}
		return itemList;
	}

}