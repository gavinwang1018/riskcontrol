package cn.com.brilliance.begen.webapp.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.SysRoleAuthorityDAO;
import cn.com.brilliance.begen.dao.SysUserAuthorityDAO;
import cn.com.brilliance.begen.dao.TpermissionDAO;
import cn.com.brilliance.begen.dao.TroleUserDAO;
import cn.com.brilliance.begen.dao.TuserInfoDAO;
import cn.com.brilliance.begen.model.SysRoleAuthority;
import cn.com.brilliance.begen.model.SysUserAuthority;
import cn.com.brilliance.begen.model.Tpermission;
import cn.com.brilliance.begen.model.TroleUser;
import cn.com.brilliance.begen.model.TuserInfo;

public class AuthorityUtil {

	private static final String SUPERMAN = "001";

	public Map getActionRight(String userId, Set permissionSet) {
		UserMap actionMap = new UserMap();
		TuserInfoDAO tuserInfoDAO = (TuserInfoDAO) Tools
				.getBean("tuserInfoDAO");
		TuserInfo tuserInfo = tuserInfoDAO.getTuserInfo(userId);
		if (SUPERMAN.equals(tuserInfo.getLoginName())) {
			actionMap.setAdmin(true);
		} else {
			TpermissionDAO tpermissionDAO = (TpermissionDAO) Tools
					.getBean("tpermissionDAO");

			if (permissionSet == null)
				return actionMap;

			Map queryMap = new HashMap();
			String hsql = "";
			Iterator it = permissionSet.iterator();
			while (it.hasNext()) {
				String code = (String) it.next();
				hsql = hsql + "" + code + ",";
			}
			if (hsql != null && !"".equals(hsql) && hsql.length() > 0) {
				queryMap.put("_hsql", " role_id in ("
						+ hsql.substring(0, hsql.length() - 1) + ")");
			} else {
				return actionMap;
			}
			List permissionList = tpermissionDAO
					.getTpermissionListOfNoAuthorityQuery(queryMap);
			for (int i = 0; i < permissionList.size(); i++) {
				Tpermission action = (Tpermission) permissionList.get(i);
				actionMap.put("action." + action.getPriviledeId(), "true");
			}
		}
		return actionMap;
	}

	private List getRolesOfUser(String userId) {
		TroleUserDAO troleUserDAO = (TroleUserDAO) Tools
				.getBean("troleUserDAO");
		TroleUser troleUser = new TroleUser();
		troleUser.setUserId(userId);
		return troleUserDAO.getTroleUserList(troleUser);
	}

	public Map getRight(String userId, Set roleSet) {
		UserMap authMap = new UserMap();
		TuserInfoDAO tuserInfoDAO = (TuserInfoDAO) Tools
				.getBean("tuserInfoDAO");
		TuserInfo tuserInfo = tuserInfoDAO.getTuserInfo(userId);
		if (SUPERMAN.equals(tuserInfo.getLoginName())) {
			authMap.setAdmin(true);
		} else {
			// 遍历当前用户
			SysUserAuthorityDAO sysUserAuthorityDAO = (SysUserAuthorityDAO) Tools
					.getBean("sysUserAuthorityDAO");
			SysUserAuthority sysUserAuthority = new SysUserAuthority();
			sysUserAuthority.setUserId(userId);
			List list = sysUserAuthorityDAO
					.getSysUserAuthorityList(sysUserAuthority);
			authMap.putAll(getUserAuthMap(list));

			// 遍历当前用户角色
			SysRoleAuthorityDAO sysRoleAuthorityDAO = (SysRoleAuthorityDAO) Tools
					.getBean("sysRoleAuthorityDAO");
			Iterator it = roleSet.iterator();
			while (it.hasNext()) {
				SysRoleAuthority sysRoleAuthority = new SysRoleAuthority();
				String roleId = (String) it.next();
				sysRoleAuthority.setRoleId(roleId);
				List authList = sysRoleAuthorityDAO
						.getSysRoleAuthorityList(sysRoleAuthority);
				authMap.putAll(getRoleAuthMap(authList));
			}
		}
		return authMap;
	}

	private Map getUserAuthMap(List authList) {
		Map authMap = new HashMap();
		for (int i = 0; i < authList.size(); i++) {
			SysUserAuthority sysUserAuthority = (SysUserAuthority) authList
					.get(i);
			if ("0".equals(sysUserAuthority.getAuthorityType())) {
				authMap.put("actionEdit." + sysUserAuthority.getActionId(),
						"true");
			}
			if ("1".equals(sysUserAuthority.getAuthorityType())) {
				authMap.put("actionList." + sysUserAuthority.getActionId(),
						"true");
			}
			if ("2".equals(sysUserAuthority.getAuthorityType())) {
				authMap.put("actionRec." + sysUserAuthority.getActionId(),
						"true");
			}
			if ("3".equals(sysUserAuthority.getAuthorityType())) {
				authMap.put("actionView." + sysUserAuthority.getActionId(),
						"true");
			}
			if ("4".equals(sysUserAuthority.getAuthorityType())) {
				authMap.put("app." + sysUserAuthority.getActionId(), "true");
			}
			if ("5".equals(sysUserAuthority.getAuthorityType())) {
				authMap.put("menu." + sysUserAuthority.getActionId(), "true");
			}
		}
		return authMap;
	}

	private Map getRoleAuthMap(List authList) {
		Map authMap = new HashMap();
		for (int i = 0; i < authList.size(); i++) {
			SysRoleAuthority sysRoleAuthority = (SysRoleAuthority) authList
					.get(i);
			if ("0".equals(sysRoleAuthority.getAuthorityType())) {
				authMap.put("actionEdit." + sysRoleAuthority.getActionId(),
						"true");
			}
			if ("1".equals(sysRoleAuthority.getAuthorityType())) {
				authMap.put("actionList." + sysRoleAuthority.getActionId(),
						"true");
			}
			if ("2".equals(sysRoleAuthority.getAuthorityType())) {
				authMap.put("actionRec." + sysRoleAuthority.getActionId(),
						"true");
			}
			if ("3".equals(sysRoleAuthority.getAuthorityType())) {
				authMap.put("actionView." + sysRoleAuthority.getActionId(),
						"true");
			}
			if ("4".equals(sysRoleAuthority.getAuthorityType())) {
				authMap.put("app." + sysRoleAuthority.getActionId(), "true");
			}
			if ("5".equals(sysRoleAuthority.getAuthorityType())) {
				authMap.put("menu." + sysRoleAuthority.getActionId(), "true");
			}
		}
		return authMap;
	}

	class UserMap extends HashMap {
		private boolean isAdmin = false;

		public void setAdmin(boolean admin) {
			this.isAdmin = admin;
		}

		public Object get(Object key) {
			if (isAdmin)
				return "true";
			return super.get(key);
		}
	}

}
