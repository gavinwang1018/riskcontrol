package cn.com.brilliance.begen.common.dao;

import java.util.HashSet;
import java.util.Set;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.com.brilliance.begen.webapp.servlet.UserBean;


public abstract class AuthorityHibernateDaoSupport extends BeGenHibernateDaoSupport {
	
	protected UserBean getUserBean() {
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpSession session = request.getSession();
		return (UserBean)session.getAttribute("_user_info");
	}

	protected boolean isParentOrg(String org,String parentOrg) {
    	if (org.equals(parentOrg))
    		return false;
    	if (org.indexOf(parentOrg) == 0)
    		return true;
    	return false;
    }
	protected boolean isChildOrg(String org,String childOrg) {
    	if (org.equals(childOrg))
    		return false;
    	if (childOrg.indexOf(org) == 0)
    		return true;
    	return false;
    }
	protected boolean isRole(String[] roles,UserBean userBean) {
    	for(int i=0;i<roles.length;i++) {
    		if (userBean.getRoleSet().contains(roles[i]))
    			return true;
    	}
    	return false;
    }
	/**
	protected Set getParentOrgSet(UserBean userBean) {
    	Set set = new HashSet();
    	String[] orgs = userBean.getOrgPath().split("/");
    	if (orgs.length == 0)
    		return set;
    	String org = "";
    	for(int i=1;i<orgs.length - 1;i++) {    		
    		org = org + "/" + orgs[i];    	
    		set.add(org);
    	}
    	return set;
    }
*/
}
