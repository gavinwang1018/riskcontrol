package cn.com.brilliance.begen.webapp.servlet;

import java.util.Map;
import java.util.Set;

import cn.com.brilliance.begen.model.TuserInfo;
import cn.com.brilliance.begen.webapp.action.AuthorityUtil;

public class UserBean {
	private TuserInfo tuserInfo;

	private Set roleSet;

	private Set permissionSet;
	
	private Map rightMap;

	private Map actionMap;

	public Set getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(Set roleSet) {
		this.roleSet = roleSet;
	}

	public Map getRightMap() {
		if (this.rightMap == null) {
			AuthorityUtil auth = new AuthorityUtil();
			this.rightMap = auth.getRight(String.valueOf(this.getTuserInfo()
					.getId()), this.roleSet);
		}
		return rightMap;
	}

	public Map getActionMap() {
		if (this.actionMap == null) {
			AuthorityUtil auth = new AuthorityUtil();
			this.actionMap = auth.getActionRight(String.valueOf(this
					.getTuserInfo().getId()), this.permissionSet);
		}
		return actionMap;
	}

	/**
	 * @return the tuserInfo
	 */
	public TuserInfo getTuserInfo() {
		return tuserInfo;
	}

	/**
	 * @param tuserInfo
	 *            the tuserInfo to set
	 */
	public void setTuserInfo(TuserInfo tuserInfo) {
		this.tuserInfo = tuserInfo;
	}

	/**
	 * @return the permissionSet
	 */
	public Set getPermissionSet() {
		return permissionSet;
	}

	/**
	 * @param permissionSet the permissionSet to set
	 */
	public void setPermissionSet(Set permissionSet) {
		this.permissionSet = permissionSet;
	}
}
