/**
 * 
 */
package cn.com.brilliance.begen.ext.webapp.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.SysAppDAO;
import cn.com.brilliance.begen.dao.SysMenuDAO;
import cn.com.brilliance.begen.dao.SysRoleAuthorityDAO;
import cn.com.brilliance.begen.dao.SysUserAuthorityDAO;
import cn.com.brilliance.begen.model.SysApp;
import cn.com.brilliance.begen.model.SysMenu;
import cn.com.brilliance.begen.model.SysRoleAuthority;
import cn.com.brilliance.begen.model.SysUserAuthority;

/**
 * @author user
 * 
 */
public class RightControlServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8287771893148246448L;

	final private static String USER_MENU_RIGHT = "_user_menu";

	final private static String USER_ACTION_RIGHT = "_user_action";

	final private static String ROLE_MENU_RIGHT = "_role_menu";

	final private static String ROLE_ACTION_RIGHT = "_role_action";

	final private static String ACTION_TYPE_APP = "4";

	final private static String ACTION_TYPE_MENU = "5";

	public RightControlServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String selectedValues = (String) request.getParameter("hid");
			String rightType = (String) request.getParameter("_type");
			if (USER_MENU_RIGHT.equals(rightType)) {
				String userId = (String) request.getParameter("_user_id");
				handleUserMenuRight(selectedValues, userId);
				response
						.sendRedirect("ext_right/ext_user_menu_right.faces?_userId="
								+ userId);
			} else if (USER_ACTION_RIGHT.equals(rightType)) {
				String userId = (String) request.getParameter("_user_id");
				handleUserActionRight(selectedValues, userId);
				response
						.sendRedirect("ext_right/ext_user_action_right.faces?_userId="
								+ userId);
			} else if (ROLE_MENU_RIGHT.equals(rightType)) {
				String roleId = (String) request.getParameter("_role_id");
				handleRoleMenuRight(selectedValues, roleId);
				response
						.sendRedirect("ext_right/ext_role_menu_right.faces?_roleId="
								+ roleId);
			} else if (ROLE_ACTION_RIGHT.equals(rightType)) {
				String roleId = (String) request.getParameter("_role_id");
				handleRoleActionRight(selectedValues, roleId);
				response
						.sendRedirect("ext_right/ext_role_action_right.faces?_roleId="
								+ roleId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void handleUserMenuRight(String selectedValues, String userId) {
		SysAppDAO sysAppDAO = (SysAppDAO) Tools.getBean("sysAppDAO");
		SysMenuDAO sysMenuDAO = (SysMenuDAO) Tools.getBean("sysMenuDAO");
		SysUserAuthorityDAO sysUserAuthorityDAO = (SysUserAuthorityDAO) Tools
				.getBean("sysUserAuthorityDAO");
		String actionId = "";
		if (selectedValues == null || "".equals(selectedValues)) {
			removeAllUserAuthority(userId);
		} else {
			List selectList = string2List(selectedValues.trim(), ",");
			List actionMapList = string2MapList(selectedValues.trim(), ",");
			List sysUserAuthorityList = getSysUserAuthorityList(userId);
			for (int i = 0; i < sysUserAuthorityList.size(); i++) {
				SysUserAuthority sua = (SysUserAuthority) sysUserAuthorityList
						.get(i);
				String userAuthorityId = sua.getId();
				if (!selectList.contains(userAuthorityId)) {
					sysUserAuthorityDAO.removeSysUserAuthority(userAuthorityId);
				}
			}
			for (int i = 0; i < selectList.size(); i++) {
				String value = (String) selectList.get(i);
				Map actionMap = (Map) actionMapList.get(i);
				String actionType = (String) actionMap.get(value);
				if (ACTION_TYPE_MENU.equals(actionType)) {
					SysMenu sysMenu = sysMenuDAO.getSysMenu(value);
					actionId = sysMenu.getId();
				} else if (ACTION_TYPE_APP.equals(actionType)) {
					SysApp sysApp = sysAppDAO.getSysApp(value);
					actionId = sysApp.getId();
				}
				SysUserAuthority userAuthority = new SysUserAuthority();
				userAuthority.setActionId(actionId);
				userAuthority.setAuthorityType(actionType);
//				userAuthority.setPartyId(BeAppDaoHelper.getPartyId());
				userAuthority.setUserId(userId);
				List userAuthorityList = sysUserAuthorityDAO
						.getSysUserAuthorityList(userAuthority);

				if (userAuthorityList == null || userAuthorityList.size() == 0) {
					SysUserAuthority ua = new SysUserAuthority();
					ua.setActionId(actionId);
					ua.setAuthorityType(actionType);
//					ua.setPartyId(BeAppDaoHelper.getPartyId());
					ua.setUserId(userId);
					sysUserAuthorityDAO.saveSysUserAuthority(ua);
				}
			}
		}

	}

	private void handleUserActionRight(String selectedValues, String userId) {
		SysUserAuthorityDAO sysUserAuthorityDAO = (SysUserAuthorityDAO) Tools
				.getBean("sysUserAuthorityDAO");

		if (selectedValues == null || "".equals(selectedValues)) {
			removeAllUserActionAuthority(userId);
		} else {
			List selectList = string2List(selectedValues.trim(), ",");
			List actionMapList = string2MapList(selectedValues.trim(), ",");
			List sysUserAuthorityList = getSysUserActionAuthorityList(userId);
			for (int i = 0; i < sysUserAuthorityList.size(); i++) {
				SysUserAuthority sua = (SysUserAuthority) sysUserAuthorityList
						.get(i);
				String userAuthorityId = sua.getId();
				if (!selectList.contains(userAuthorityId)) {
					sysUserAuthorityDAO.removeSysUserAuthority(userAuthorityId);
				}
			}
			for (int i = 0; i < selectList.size(); i++) {
				String value = (String) selectList.get(i);
				Map actionMap = (Map) actionMapList.get(i);
				String actionType = (String) actionMap.get(value);
				SysUserAuthority userAuthority = new SysUserAuthority();
				userAuthority.setActionId(value);
				userAuthority.setAuthorityType(actionType);
//				userAuthority.setPartyId(BeAppDaoHelper.getPartyId());
				userAuthority.setUserId(userId);
				List userAuthorityList = sysUserAuthorityDAO
						.getSysUserAuthorityList(userAuthority);

				if (userAuthorityList == null || userAuthorityList.size() == 0) {
					SysUserAuthority ua = new SysUserAuthority();
					ua.setActionId(value);
					ua.setAuthorityType(actionType);
//					ua.setPartyId(BeAppDaoHelper.getPartyId());
					ua.setUserId(userId);
					sysUserAuthorityDAO.saveSysUserAuthority(ua);
				}
			}
		}
	}

	private void handleRoleMenuRight(String selectedValues, String roleId) {
		SysAppDAO sysAppDAO = (SysAppDAO) Tools.getBean("sysAppDAO");
		SysMenuDAO sysMenuDAO = (SysMenuDAO) Tools.getBean("sysMenuDAO");
		SysRoleAuthorityDAO sysRoleAuthorityDAO = (SysRoleAuthorityDAO) Tools
				.getBean("sysRoleAuthorityDAO");
		String actionId = "";
		if (selectedValues == null || "".equals(selectedValues)) {
			removeAllRoleAuthority(roleId);
		} else {
			List selectList = string2List(selectedValues.trim(), ",");
			List actionMapList = string2MapList(selectedValues.trim(), ",");
			List sysRoleAuthorityList = getSysRoleAuthorityList(roleId);
			for (int i = 0; i < sysRoleAuthorityList.size(); i++) {
				SysRoleAuthority sua = (SysRoleAuthority) sysRoleAuthorityList
						.get(i);
				String roleAuthorityId = sua.getId();
				if (!selectList.contains(roleAuthorityId)) {
					sysRoleAuthorityDAO.removeSysRoleAuthority(roleAuthorityId);
				}
			}
			for (int i = 0; i < selectList.size(); i++) {
				String value = (String) selectList.get(i);
				Map actionMap = (Map) actionMapList.get(i);
				String actionType = (String) actionMap.get(value);
				if (ACTION_TYPE_MENU.equals(actionType)) {
					SysMenu sysMenu = sysMenuDAO.getSysMenu(value);
					actionId = sysMenu.getId();
				} else if (ACTION_TYPE_APP.equals(actionType)) {
					SysApp sysApp = sysAppDAO.getSysApp(value);
					actionId = sysApp.getId();
				}

				SysRoleAuthority sysRoleAuthority = new SysRoleAuthority();
				sysRoleAuthority.setActionId(actionId);
				sysRoleAuthority.setAuthorityType(actionType);
//				sysRoleAuthority.setPartyId(BeAppDaoHelper.getPartyId());
				sysRoleAuthority.setRoleId(roleId);
				List roleAuthorityList = sysRoleAuthorityDAO
						.getSysRoleAuthorityList(sysRoleAuthority);

				if (roleAuthorityList == null || roleAuthorityList.size() == 0) {
					SysRoleAuthority ra = new SysRoleAuthority();
					ra.setActionId(actionId);
					ra.setAuthorityType(actionType);
//					ra.setPartyId(BeAppDaoHelper.getPartyId());
					ra.setRoleId(roleId);
					sysRoleAuthorityDAO.saveSysRoleAuthority(ra);
				}
			}
		}
	}

	private void handleRoleActionRight(String selectedValues, String roleId) {
		SysRoleAuthorityDAO sysRoleAuthorityDAO = (SysRoleAuthorityDAO) Tools
				.getBean("sysRoleAuthorityDAO");
		if (selectedValues == null || "".equals(selectedValues)) {
			removeAllRoleActionAuthority(roleId);
		} else {
			List selectList = string2List(selectedValues.trim(), ",");
			List actionMapList = string2MapList(selectedValues.trim(), ",");
			List sysRoleAuthorityList = getSysUserActionAuthorityList(roleId);
			for (int i = 0; i < sysRoleAuthorityList.size(); i++) {
				SysRoleAuthority sra = (SysRoleAuthority) sysRoleAuthorityList
						.get(i);
				String roleAuthorityId = sra.getId();
				if (!selectList.contains(roleAuthorityId)) {
					sysRoleAuthorityDAO.removeSysRoleAuthority(roleAuthorityId);
				}
			}
			for (int i = 0; i < selectList.size(); i++) {
				String value = (String) selectList.get(i);
				Map actionMap = (Map) actionMapList.get(i);
				String actionType = (String) actionMap.get(value);
				SysRoleAuthority roleAuthority = new SysRoleAuthority();
				roleAuthority.setActionId(value);
				roleAuthority.setAuthorityType(actionType);
//				roleAuthority.setPartyId(BeAppDaoHelper.getPartyId());
				roleAuthority.setRoleId(roleId);
				List roleAuthorityList = sysRoleAuthorityDAO
						.getSysRoleAuthorityList(roleAuthority);

				if (roleAuthorityList == null || roleAuthorityList.size() == 0) {
					SysRoleAuthority ra = new SysRoleAuthority();
					ra.setActionId(value);
					ra.setAuthorityType(actionType);
//					ra.setPartyId(BeAppDaoHelper.getPartyId());
					ra.setRoleId(roleId);
					sysRoleAuthorityDAO.saveSysRoleAuthority(ra);
				}
			}
		}
	}

	private void removeAllUserAuthority(String id) {
		SysUserAuthorityDAO sysUserAuthorityDAO = (SysUserAuthorityDAO) Tools
				.getBean("sysUserAuthorityDAO");
		List sysUserAuthorityAppList = getSysUserAuthorityList(id);
		for (int i = 0; i < sysUserAuthorityAppList.size(); i++) {
			SysUserAuthority userAuthority = (SysUserAuthority) sysUserAuthorityAppList
					.get(i);
			sysUserAuthorityDAO.removeSysUserAuthority(userAuthority.getId());
		}
	}

	private void removeAllRoleAuthority(String id) {
		SysRoleAuthorityDAO sysRoleAuthorityDAO = (SysRoleAuthorityDAO) Tools
				.getBean("sysRoleAuthorityDAO");
		List sysRoleAuthorityList = getSysRoleAuthorityList(id);
		for (int i = 0; i < sysRoleAuthorityList.size(); i++) {
			SysRoleAuthority userAuthority = (SysRoleAuthority) sysRoleAuthorityList
					.get(i);
			sysRoleAuthorityDAO.removeSysRoleAuthority(userAuthority.getId());
		}
	}

	private void removeAllUserActionAuthority(String id) {
		SysUserAuthorityDAO sysUserAuthorityDAO = (SysUserAuthorityDAO) Tools
				.getBean("sysUserAuthorityDAO");
		List sysUerAuthorityList = getSysUserActionAuthorityList(id);
		for (int i = 0; i < sysUerAuthorityList.size(); i++) {
			SysUserAuthority userAuthority = (SysUserAuthority) sysUerAuthorityList
					.get(i);
			sysUserAuthorityDAO.removeSysUserAuthority(userAuthority.getId());
		}
	}

	private void removeAllRoleActionAuthority(String id) {
		SysRoleAuthorityDAO sysRoleAuthorityDAO = (SysRoleAuthorityDAO) Tools
				.getBean("sysRoleAuthorityDAO");
		List sysRoleAuthorityList = getSysRoleActionAuthorityList(id);
		for (int i = 0; i < sysRoleAuthorityList.size(); i++) {
			SysRoleAuthority roleAuthority = (SysRoleAuthority) sysRoleAuthorityList
					.get(i);
			sysRoleAuthorityDAO.removeSysRoleAuthority(roleAuthority.getId());
		}
	}

	/**
	 * 取用户权限表List.
	 * 
	 * @return list
	 */
	private List getSysUserAuthorityList(String userId) {
		SysUserAuthorityDAO sysUserAuthorityDAO = (SysUserAuthorityDAO) Tools
				.getBean("sysUserAuthorityDAO");
		SysUserAuthority sysUserAuthority = new SysUserAuthority();
		sysUserAuthority.setUserId(userId);
//		sysUserAuthority.setPartyId(BeAppDaoHelper.getPartyId());
		List list = sysUserAuthorityDAO
				.getSysUserAuthorityList(sysUserAuthority);
		return list;
	}

	// private List getSysUserAuthorityListByType(String userId, List list,
	// String actionType) {
	// List<SysUserAuthority> appList = new ArrayList<SysUserAuthority>();
	// for (int i = 0; i < list.size(); i++) {
	// SysUserAuthority sysUserAuthority = (SysUserAuthority) list.get(i);
	// String uid = sysUserAuthority.getUserId();
	// if (userId.equals(uid)
	// && actionType.equals(sysUserAuthority.getAuthorityType())) {
	// appList.add(sysUserAuthority);
	// }
	// }
	// return appList;
	// }

	private List getSysRoleAuthorityList(String roleId) {
		SysRoleAuthorityDAO sysRoleAuthorityDAO = (SysRoleAuthorityDAO) Tools
				.getBean("sysRoleAuthorityDAO");
		SysRoleAuthority sysRoleAuthority = new SysRoleAuthority();
		sysRoleAuthority.setRoleId(roleId);
//		sysRoleAuthority.setPartyId(BeAppDaoHelper.getPartyId());
		List list = sysRoleAuthorityDAO
				.getSysRoleAuthorityList(sysRoleAuthority);
		return list;
	}

	private List getSysUserActionAuthorityList(String userId) {
		SysUserAuthorityDAO sysUserAuthorityDAO = (SysUserAuthorityDAO) Tools
				.getBean("sysUserAuthorityDAO");
		SysUserAuthority sysUserAuthority = new SysUserAuthority();
		sysUserAuthority.setUserId(userId);
//		sysUserAuthority.setPartyId(BeAppDaoHelper.getPartyId());
		List list = sysUserAuthorityDAO
				.getSysUserAuthorityList(sysUserAuthority);
		List<SysUserAuthority> sysUserAuthorityList = new ArrayList<SysUserAuthority>();
		for (int i = 0; i < list.size(); i++) {
			SysUserAuthority sua = (SysUserAuthority) list.get(i);
			if (!ACTION_TYPE_APP.equals(sua.getAuthorityType())
					&& !ACTION_TYPE_MENU.equals(sua.getAuthorityType())) {
				sysUserAuthorityList.add(sua);
			}
		}
		return sysUserAuthorityList;
	}

	private List getSysRoleActionAuthorityList(String roleId) {
		SysRoleAuthorityDAO sysRoleAuthorityDAO = (SysRoleAuthorityDAO) Tools
				.getBean("sysRoleAuthorityDAO");
		SysRoleAuthority sysRoleAuthority = new SysRoleAuthority();
		sysRoleAuthority.setRoleId(roleId);
//		sysRoleAuthority.setPartyId(BeAppDaoHelper.getPartyId());
		List list = sysRoleAuthorityDAO
				.getSysRoleAuthorityList(sysRoleAuthority);
		List<SysRoleAuthority> sysRoleAuthorityList = new ArrayList<SysRoleAuthority>();
		for (int i = 0; i < list.size(); i++) {
			SysRoleAuthority sra = (SysRoleAuthority) list.get(i);
			if (!ACTION_TYPE_APP.equals(sra.getAuthorityType())
					&& !ACTION_TYPE_MENU.equals(sra.getAuthorityType())) {
				sysRoleAuthorityList.add(sra);
			}
		}
		return sysRoleAuthorityList;
	}

	// private static List string2List(String str, String division) {
	// List<String> list = new ArrayList<String>();
	// String[] strs = StringUtils.split(str, division);
	// for (int i = 0; i < strs.length; i++) {
	// list.add(strs[i]);
	// }
	// return list;
	// }

	private static List string2List(String str, String division) {
		List<String> list = new ArrayList<String>();
		String[] strs = StringUtils.split(str, division);
		for (int i = 0; i < strs.length; i++) {
			list.add(getActionId(strs[i]));
		}
		return list;
	}

	private static List string2MapList(String str, String division) {
		List<Map> list = new ArrayList<Map>();
		String[] strs = StringUtils.split(str, division);
		for (int i = 0; i < strs.length; i++) {
			Map<String, String> map = new HashMap<String, String>();
			map.put(getActionId(strs[i]), getAuthorityType(strs[i]));
			list.add(map);
		}
		return list;
	}

	private static String getActionId(String values) {
		String actionId = "";
		int index = values.indexOf("||");
		actionId = values.substring(0, index);
		return actionId;
	}

	private static String getAuthorityType(String values) {
		String actionType = "";
		int index = values.indexOf("||");
		actionType = values.substring(index + 2);
		return actionType;
	}
}
