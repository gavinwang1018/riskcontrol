package cn.com.brilliance.begen.webapp.action;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import javax.faces.component.html.HtmlDataTable;

import cn.com.brilliance.begen.exception.BeGenException;
import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.SysLoginfoService;
import cn.com.brilliance.begen.webapp.action.BasePage;
import cn.com.brilliance.begen.common.webapp.action.ListPage;

/**
 * SysLoginfo对象List.
 * @author Administrator.
 *
 */
public class SysLoginfoList extends BasePage implements ListPage {

	private SysLoginfoService service = (SysLoginfoService)getBean("sysLoginfoService");
    /**
     * sysLoginfos.
     */
    private List<SysLoginfo> sysLoginfos;

    /**
     * dataTable.
     */
    private HtmlDataTable dataTable;

    /**
     * sysLoginfo.
     */
    private SysLoginfo sysLoginfo = null;

    /**
     * queryFields.
     */
    private Map queryFields = new HashMap();   //查询条件Map
	
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
    public SysLoginfoList() {
        super();
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
     * Returns the SysLoginfo.
     * @return SysLoginfo.
     */
    public void setSysLoginfo(SysLoginfo sysLoginfo) {
        this.sysLoginfo = sysLoginfo;
    }

    /**
     * Sets the SysLoginfo.
     * @param sysLoginfo The sysLoginfo to set.
     */
    public SysLoginfo getSysLoginfo() {
        return this.sysLoginfo;
    }

    /**
     * Returns the Map.
     * @return Map.
     */
    public Map getQueryFields() {
        return queryFields;
    }

    /**
     * Sets the Map.
     * @param queryFields The Map to set.
     */
    public void setQueryFields(Map queryFields) {
        this.queryFields = queryFields;
    }

    /**
     * 获得SysLoginfo对象列表.
     * @return List.
     */
    public List<SysLoginfo> getSysLoginfos() {
        return this.sysLoginfos;
    }
	
	public void initSysLoginfos(){
	    try {
            if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));

            this.sysLoginfos = service.init(this.sysLoginfo,this.queryFields);
			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}

    /**
     * Sets the SysLoginfos.
     * @param sysLoginfos The SysLoginfos to set.
     */
    public void setSysLoginfos(List sysLoginfos) {
        this.sysLoginfos = sysLoginfos;
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
     * 删除SysLoginfo对象.
     * @return String.
     */
    public void delete() {
        try {
            SysLoginfo sysLoginfo = sysLoginfos.get(rowIndex);
            service.delete(sysLoginfo.getId());		
            addMessage("sysLoginfo.message.deleted", sysLoginfo.getId());		
            this.sysLoginfos.remove(rowIndex.intValue());
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
    }
    /**
     * 删除SysLoginfo对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            SysLoginfo sysLoginfo = sysLoginfos.get(rowIndex);

            service.delete(this.sysLoginfo.getId());
            addMessage("sysLoginfo.message.deleted", this.sysLoginfo.getId());				
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return null;
        }
        return null;
    }
    /**
     *    查询SysLoginfo对象.
     *  @return String.
     */
    public String query() {
        try {
            this.sysLoginfos = service.getSysLoginfoListOfQuery(this.queryFields);
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
        return null;
    }




    public String add(){
    	return this.getSuccessAction();
    }
	
	public void multiAdd(){
		SysLoginfo sysLoginfo = new SysLoginfo();
		sysLoginfo.set_record_index(-1);		
    	sysLoginfo.set_edit_flag(SysLoginfo.EDIT_FLAG_ADD);
        this.sysLoginfos.add(sysLoginfo);
    }
	
	public void popupAdd(){
		SysLoginfo sysLoginfo = new SysLoginfo();
		sysLoginfo.set_record_index(-1);		
    	sysLoginfo.set_edit_flag(SysLoginfo.EDIT_FLAG_ADD);
    	this.getRequest().getSession().setAttribute("__pop_object", sysLoginfo); 	
    }
	
	public void popupEdit(){
		SysLoginfo sysLoginfo = sysLoginfos.get(rowIndex);
    	sysLoginfo.set_record_index(rowIndex);
    	if (SysLoginfo.EDIT_FLAG_ADD != sysLoginfo.get_edit_flag()){
    		sysLoginfo.set_edit_flag(SysLoginfo.EDIT_FLAG_EDIT);
    	}    	
    	this.getRequest().getSession().setAttribute("__pop_object", sysLoginfo); 	
	}	
	
	public void popupView(){
		SysLoginfo sysLoginfo = sysLoginfos.get(rowIndex.intValue());
    	this.getRequest().getSession().setAttribute("__pop_object", sysLoginfo); 	
	}	
    
    public void popupRefresh(){
    	SysLoginfo sysLoginfo = (SysLoginfo)this.getRequest().getSession().getAttribute("__pop_object");
    	if (sysLoginfo.get_record_index() != -1){
    		this.sysLoginfos.remove(sysLoginfo.get_record_index());
    		this.sysLoginfos.add(sysLoginfo.get_record_index(), sysLoginfo);
    	}
    	else{
    		this.sysLoginfos.add(sysLoginfo);
    	}
		this.getRequest().getSession().removeAttribute("__pop_object");
    }
    
    public String edit(){
        SysLoginfo sysLoginfo = sysLoginfos.get(rowIndex.intValue());
    	sysLoginfo.set_record_index(rowIndex);
    	if (SysLoginfo.EDIT_FLAG_ADD != sysLoginfo.get_edit_flag()){
    		sysLoginfo.set_edit_flag(SysLoginfo.EDIT_FLAG_EDIT);
			this.setValueBinding("#{sysLoginfoForm.sysLoginfoPrimaryKey}", sysLoginfo.getId());
    	}
    	return this.getSuccessAction();
    }
    
    public String view(){
        SysLoginfo sysLoginfo = sysLoginfos.get(rowIndex.intValue());
		this.setValueBinding("#{sysLoginfoForm.sysLoginfoPrimaryKey}", sysLoginfo.getId());
    	return this.getSuccessAction();
    }

    public String getHistoryUrlParameter(){
    	Iterator iter = this.getQueryFields().keySet().iterator();
    	String url = "";
    	while(iter.hasNext()){
    		String key = (String)iter.next();
			String value = (String)this.getQueryFields().get(key);
			if(value != null && !"".equals(value))
				url += key + "=" + value + "&";
    	}
    	return url;
    }
	
    public void deleteBuffer(){
    	SysLoginfo sysLoginfo  = sysLoginfos.get(rowIndex.intValue());
    	if (SysLoginfo.EDIT_FLAG_ADD != sysLoginfo.get_edit_flag()){
			deleteList.add(sysLoginfo.getId());    	
		}
		sysLoginfos.remove(rowIndex.intValue());
    }	
	
    public void moveUpBuffer(){
    	int i = rowIndex;
    	int j = getMovedSysLoginfoIndex(i,-1);
    	if (j == -1)
    		return ;
    	SysLoginfo sysLoginfo = sysLoginfos.get(i);
    	sysLoginfos.add(j, sysLoginfo);
    	sysLoginfos.remove(i + 1);
    }	
	
    private int getMovedSysLoginfoIndex(int index,int step){
    	if (index + step >= 0 && index + step < sysLoginfos.size()){
    		SysLoginfo sysLoginfo = sysLoginfos.get(index + step);
    		if (SysLoginfo.EDIT_FLAG_DELETE == sysLoginfo.get_edit_flag())
    			return index + step + getMovedSysLoginfoIndex(index + step,step);
    		else
    			return index + step;
    	}else{
    		return -1;
    	}    	
    }	
	
    public void moveDownBuffer(){
    	int i = rowIndex;
    	int j = getMovedSysLoginfoIndex(i,1);
    	if (j == -1)
    		return ;
    	SysLoginfo sysLoginfo = sysLoginfos.get(j);
    	sysLoginfos.add(i, sysLoginfo);
    	sysLoginfos.remove(j + 1);
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
	
	public String save(){
        try {
            for (int i=0; i < sysLoginfos.size(); i++) {
                SysLoginfo sysLoginfo = (SysLoginfo)this.sysLoginfos.get(i);
                service.saveSysLoginfo(sysLoginfo);
            }
	        addMessage("sysLoginfo.message.savedAll",null);
			return this.getSuccessAction();
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
		return null;
	}	
	
	public void deleteChecked(){
		for(SysLoginfo sysLoginfo : this.sysLoginfos){
			if(sysLoginfo.is_checked_flag()){
				service.delete(sysLoginfo.getId());
			}
		}
	}
	
	public void deleteAll(){
		service.deleteAll(this.sysLoginfos);
	}
}
