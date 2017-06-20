package cn.com.brilliance.begen.webapp.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlDataTable;

import cn.com.brilliance.begen.common.webapp.action.ListPage;
import cn.com.brilliance.begen.dao.SysOrgDAO;
import cn.com.brilliance.begen.exception.BeGenException;
import cn.com.brilliance.begen.model.SysOrg;

/**
 * SysOrg对象List.
 * @author Administrator.
 *
 */
public class SysOrgList extends BasePage implements ListPage {
    /**
     * sysOrgList.
     */
    private List sysOrgList;

    /**
     * dataTable.
     */
    private HtmlDataTable dataTable;

    /**
     * sysOrg.
     */
    private SysOrg sysOrg = null;

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
    public SysOrgList() {
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
     * Returns the SysOrg.
     * @return SysOrg.
     */
    public void setSysOrg(SysOrg sysOrg) {
        this.sysOrg = sysOrg;
    }

    /**
     * Sets the SysOrg.
     * @param sysOrg The sysOrg to set.
     */
    public SysOrg getSysOrg() {
        return this.sysOrg;
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
     * 获得SysOrg对象列表.
     * @return List.
     */
    public List getSysOrgList() {
        if (this.emptyList) {
            return null;
        }
        try {
            if (this.sortColumn != null)
                queryMap.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));
            SysOrgDAO sysOrgDAO = (SysOrgDAO)getBean("sysOrgDAO");
            if (this.sysOrg != null) {
                this.sysOrgList = sysOrgDAO.getSysOrgList(this.sysOrg);
            }
            else {
                this.sysOrgList = sysOrgDAO.getSysOrgListOfQuery(this.queryMap);
            }
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
        return this.sysOrgList;
    }

    /**
     * Sets the SysOrgList.
     * @param sysOrgList The SysOrgList to set.
     */
    public void setSysOrgList(List sysOrgList) {
        this.sysOrgList = sysOrgList;
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
     * 删除SysOrg对象.
     * @return String.
     */
    public void delete() {
        try {
            SysOrg sysOrg = (SysOrg)this.dataTable.getRowData();
            SysOrgDAO sysOrgDAO = (SysOrgDAO)getBean("sysOrgDAO");
            sysOrgDAO.removeSysOrg(sysOrg.getId());
            addMessage("sysOrg.message.deleted", sysOrg.getOrgId());
            this.sysOrgList = null;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
    }
    /**
     * 删除SysOrg对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            SysOrg sysOrg = (SysOrg)this.dataTable.getRowData();
            if (sysOrg.getSysUserGroup().size() > 0) {
                this.addMessageString("子表还有数据，无法删除!");
                return null;
            }
            SysOrgDAO sysOrgDAO = (SysOrgDAO)getBean("sysOrgDAO");
            sysOrgDAO.removeSysOrg(this.sysOrg.getId());
            addMessage("sysOrg.message.deleted", this.sysOrg.getOrgId());	
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return null;
        }
        return null;
    }
    /**
     *    查询SysOrg对象.
     *  @return String.
     */
    public String query() {
        try {
            SysOrgDAO sysOrgDAO = (SysOrgDAO)getBean("sysOrgDAO");
            this.sysOrgList = sysOrgDAO.getSysOrgListOfQuery(this.queryMap);
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
