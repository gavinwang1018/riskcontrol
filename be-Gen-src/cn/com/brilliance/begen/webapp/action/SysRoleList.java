package cn.com.brilliance.begen.webapp.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlDataTable;

import cn.com.brilliance.begen.common.webapp.action.ListPage;
import cn.com.brilliance.begen.dao.SysRoleDAO;
import cn.com.brilliance.begen.exception.BeGenException;
import cn.com.brilliance.begen.model.SysRole;

/**
 * SysRole对象List.
 * @author Administrator.
 *
 */
public class SysRoleList extends BasePage implements ListPage {
    /**
     * sysRoleList.
     */
    private List sysRoleList;

    /**
     * dataTable.
     */
    private HtmlDataTable dataTable;

    /**
     * sysRole.
     */
    private SysRole sysRole = null;

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
    public SysRoleList() {
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
     * Returns the SysRole.
     * @return SysRole.
     */
    public void setSysRole(SysRole sysRole) {
        this.sysRole = sysRole;
    }

    /**
     * Sets the SysRole.
     * @param sysRole The sysRole to set.
     */
    public SysRole getSysRole() {
        return this.sysRole;
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
     * 获得SysRole对象列表.
     * @return List.
     */
    public List getSysRoleList() {
        if (this.emptyList) {
            return null;
        }
        try {
            if (this.sortColumn != null)
                queryMap.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));
            SysRoleDAO sysRoleDAO = (SysRoleDAO)getBean("sysRoleDAO");
            if (this.sysRole != null) {
                this.sysRoleList = sysRoleDAO.getSysRoleList(this.sysRole);
            }
            else {
                this.sysRoleList = sysRoleDAO.getSysRoleListOfQuery(this.queryMap);
            }
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
        return this.sysRoleList;
    }

    /**
     * Sets the SysRoleList.
     * @param sysRoleList The SysRoleList to set.
     */
    public void setSysRoleList(List sysRoleList) {
        this.sysRoleList = sysRoleList;
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
     * 删除SysRole对象.
     * @return String.
     */
    public void delete() {
        try {
            SysRole sysRole = (SysRole)this.dataTable.getRowData();
            SysRoleDAO sysRoleDAO = (SysRoleDAO)getBean("sysRoleDAO");
            sysRoleDAO.removeSysRole(sysRole.getId());
            addMessage("sysRole.message.deleted", sysRole.getRoleId());
            this.sysRoleList = null;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
    }
    /**
     * 删除SysRole对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            SysRole sysRole = (SysRole)this.dataTable.getRowData();
            if (sysRole.getSysUserRoleGroup().size() > 0) {
                this.addMessageString("子表还有数据，无法删除!");
                return null;
            }
            SysRoleDAO sysRoleDAO = (SysRoleDAO)getBean("sysRoleDAO");
            sysRoleDAO.removeSysRole(this.sysRole.getId());
            addMessage("sysRole.message.deleted", this.sysRole.getRoleId());	
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return null;
        }
        return null;
    }
    /**
     *    查询SysRole对象.
     *  @return String.
     */
    public String query() {
        try {
            SysRoleDAO sysRoleDAO = (SysRoleDAO)getBean("sysRoleDAO");
            this.sysRoleList = sysRoleDAO.getSysRoleListOfQuery(this.queryMap);
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
