package cn.com.brilliance.begen.webapp.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlDataTable;

import cn.com.brilliance.begen.common.webapp.action.ListPage;
import cn.com.brilliance.begen.dao.SysUserDAO;
import cn.com.brilliance.begen.exception.BeGenException;
import cn.com.brilliance.begen.model.SysUser;

/**
 * SysUser对象List.
 * @author Administrator.
 *
 */
public class SysUserList extends BasePage implements ListPage {
    /**
     * sysUserList.
     */
    private List sysUserList;

    /**
     * dataTable.
     */
    private HtmlDataTable dataTable;

    /**
     * sysUser.
     */
    private SysUser sysUser = null;

    /**
     * queryMap.
     */
    private Map queryMap = new HashMap();   //查询条件Map

    /**
     * sortColumn.
     */
    private String sortColumn;

    /**
     * ascending.
     */
    private boolean ascending;

    /**
     * emptyList.
     */
    private boolean emptyList = false;

    /**
     * 默认构造函数.
     */
    public SysUserList() {
        super();
    }

    public void setEmptyList(String emptyListString) {
        if ("true".equalsIgnoreCase(emptyListString) || "yes".equalsIgnoreCase(emptyListString)) {
            this.emptyList = true;
        }
        else {
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
     * Returns the SysUser.
     * @return SysUser.
     */
    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    /**
     * Sets the SysUser.
     * @param sysUser The sysUser to set.
     */
    public SysUser getSysUser() {
        return this.sysUser;
    }

    /**
     * Returns the Map.
     * @return Map.
     */
    public Map getQueryMap() {
        return queryMap;
    }

    /**
     * Sets the Map.
     * @param queryMap The Map to set.
     */
    public void setQueryMap(Map queryMap) {
        this.queryMap = queryMap;
    }

    /**
     * 获得SysUser对象列表.
     * @return List.
     */
    public List getSysUserList() {
        if (this.emptyList) {
            return null;
        }
        try {
            if (this.sortColumn != null)
                queryMap.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));
            SysUserDAO sysUserDAO = (SysUserDAO)getBean("sysUserDAO");
            if (this.sysUser != null) {
                this.sysUserList = sysUserDAO.getSysUserList(this.sysUser);
            }
            else {
                this.sysUserList = sysUserDAO.getSysUserListOfQuery(this.queryMap);
            }
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
        return this.sysUserList;
    }

    /**
     * Sets the SysUserList.
     * @param sysUserList The SysUserList to set.
     */
    public void setSysUserList(List sysUserList) {
        this.sysUserList = sysUserList;
    }

    /**
     * Returns the dataTable.
     * @return dataTable.
     */
    public HtmlDataTable getDataTable() {
        return dataTable;
    }

    /**
     * Sets the dataTable.
     * @param dataTable The HtmlDataTable to set.
     */
    public void setDataTable(HtmlDataTable dataTable) {
        this.dataTable = dataTable;
    }

    /**
     * 删除SysUser对象.
     * @return String.
     */
    public void delete() {
        try {
            SysUser sysUser = (SysUser)this.dataTable.getRowData();
            SysUserDAO sysUserDAO = (SysUserDAO)getBean("sysUserDAO");
            sysUserDAO.removeSysUser(sysUser.getId());
            addMessage("sysUser.message.deleted", sysUser.getUserId());
            this.sysUserList = null;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
    }
    /**
     * 删除SysUser对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            SysUser sysUser = (SysUser)this.dataTable.getRowData();
            if (sysUser.getSysUserRoleGroup().size() > 0) {
                this.addMessageString("子表还有数据，无法删除!");
                return null;
            }
            SysUserDAO sysUserDAO = (SysUserDAO)getBean("sysUserDAO");
            sysUserDAO.removeSysUser(this.sysUser.getId());
            addMessage("sysUser.message.deleted", this.sysUser.getUserId());	
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return null;
        }
        return null;
    }
    /**
     *    查询SysUser对象.
     *  @return String.
     */
    public String query() {
        try {
            SysUserDAO sysUserDAO = (SysUserDAO)getBean("sysUserDAO");
            this.sysUserList = sysUserDAO.getSysUserListOfQuery(this.queryMap);
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
        return null;
    }


    public String getHistoryUrlParameter(){
    	Iterator iter = this.getQueryMap().keySet().iterator();
    	String url = "";
    	if (this.emptyList)
    		url += "_emptyList=true&";
    	while(iter.hasNext()){
    		String key = (String)iter.next();
			String value = (String)this.getQueryMap().get(key);
			if(value != null && !"".equals(value))
				url += key + "=" + value + "&";
    	}
    	return url;
    }
}
