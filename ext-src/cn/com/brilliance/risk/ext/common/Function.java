/**
 * 
 */
package cn.com.brilliance.risk.ext.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.TorganizeInfoDAO;
import cn.com.brilliance.begen.model.TorganizeInfo;
import cn.com.brilliance.begen.model.TruleInstance;
import cn.com.brilliance.begen.service.TroleUserService;
import cn.com.brilliance.begen.service.TruleInstanceService;
import cn.com.brilliance.begen.webapp.servlet.UserBean;

/**
 * @author IBM
 * 
 */
public class Function {

	public static boolean hasChild(String roleId) {
		TroleUserService troleUserService = (TroleUserService) Tools
				.getBean("troleUserService");
		Map roleMap = new HashMap();
		roleMap.put("roleId", roleId);
		List list = troleUserService.getTroleUserListOfQuery(roleMap);
		if (list != null && list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断是否为总公司人员
	 * 
	 * @return
	 */
	public static boolean isParentCompany(String orgId) {
		boolean isParentComp = false;
		if ("0".equals(orgId)) {
			return true;
		}
		TorganizeInfoDAO torganizeInfoDAO = (TorganizeInfoDAO) Tools
				.getBean("torganizeInfoDAO");
		TorganizeInfo torganizeInfo = torganizeInfoDAO.getTorganizeInfo(orgId);
		String parentId = torganizeInfo.getParentId();
		if ("0".equals(parentId) && !torganizeInfo.getDwFlag()) {
			return true;
		}
		return isParentComp;
	}

	public static List getParentCompanyList(UserBean userBean) {
		if (userBean == null) {
			return new ArrayList();
		}
		String orgnizeId = userBean.getTuserInfo().getOrganizeId();
		String globalSort = userBean.getTuserInfo()
				.getOrganizeIdOfTorganizeInfo().getGlobalSort();

		TorganizeInfoDAO torganizeInfoDAO = (TorganizeInfoDAO) Tools
				.getBean("torganizeInfoDAO");
		Map querys = new HashMap();
		if (!isParentCompany(orgnizeId)) {
			querys.put("dwFlag", "true");
			querys.put("globalSort_like", globalSort);
		} else {
			querys.put("dwFlag", "true");
		}
		querys.put("organizeLevel_min", "1");
		querys.put("organizeLevel_max", "2");
		querys.put("_order", "organizeBm asc");

		return torganizeInfoDAO.getTorganizeInfoListOfQuery(querys);
	}

	public static boolean checkNumber(Float number) {
		if (number == null)
			return false;
		String numberStr = String.valueOf(number);
		int index = numberStr.indexOf(".");
		if (index != -1) {
			String begin = numberStr.substring(0, index);
			String end = numberStr.substring(index + 1);
			if (begin.length() > 3) {
				return false;
			} else if (end.length() > 2) {
				return false;
			}
		} else if (numberStr.length() > 5) {
			return false;
		}
		return true;
	}

	public static boolean checkNumber(Float number, int length) {
		String numberStr = String.valueOf(number);
		if (numberStr.length() > length) {
			return false;
		}
		return true;
	}
	

	public static void initRuleInstance() {
		String[] rules = { "R21", "R23", "R25", "R26", "R27", "R31", "R33" };//去掉R24
		TruleInstanceService truleInstanceService = (TruleInstanceService) Tools
				.getBean("truleInstanceService");
		TorganizeInfoDAO torganizeInfoDAO = (TorganizeInfoDAO) Tools
				.getBean("torganizeInfoDAO");
		Map querys = new HashMap();
		querys.put("dwFlag", "true");
		querys.put("organizeLevel_min", "1");
		querys.put("organizeLevel_max", "2");
		querys.put("_order", "organizeBm asc");

		List list = torganizeInfoDAO.getTorganizeInfoListOfQuery(querys);
		for (int i = 0; i < list.size(); i++) {
			TorganizeInfo torganizeInfo = (TorganizeInfo) list.get(i);
			for (int a = 0; a < rules.length; a++) {
				TruleInstance tr = new TruleInstance();
				tr.setBelongToInst(torganizeInfo.getId());
				tr.setType("0");
				tr.setCode(rules[a]);
				tr.setDescription("静态子规则" + rules[a]);
				tr.setEnable(new Boolean(true));
				truleInstanceService.saveTruleInstance(tr);
				System.out.println("added:" + torganizeInfo.getId() + "-" + rules[a]);
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
