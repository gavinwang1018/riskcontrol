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
import cn.com.brilliance.begen.service.SysWorkflowInsProcService;
import cn.com.brilliance.begen.webapp.action.BasePage;
import cn.com.brilliance.begen.common.webapp.action.ListPage;

/**
 * SysWorkflowInsProc对象List.
 * @author Administrator.
 *
 */
public class SysWorkflowInsProcList extends BasePage implements ListPage {

	private SysWorkflowInsProcService service = (SysWorkflowInsProcService)getBean("sysWorkflowInsProcService");
    /**
     * sysWorkflowInsProcs.
     */
    private List<SysWorkflowInsProc> sysWorkflowInsProcs;

    /**
     * dataTable.
     */
    private HtmlDataTable dataTable;

    /**
     * sysWorkflowInsProc.
     */
    private SysWorkflowInsProc sysWorkflowInsProc = null;

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
    public SysWorkflowInsProcList() {
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
     * Returns the SysWorkflowInsProc.
     * @return SysWorkflowInsProc.
     */
    public void setSysWorkflowInsProc(SysWorkflowInsProc sysWorkflowInsProc) {
        this.sysWorkflowInsProc = sysWorkflowInsProc;
    }

    /**
     * Sets the SysWorkflowInsProc.
     * @param sysWorkflowInsProc The sysWorkflowInsProc to set.
     */
    public SysWorkflowInsProc getSysWorkflowInsProc() {
        return this.sysWorkflowInsProc;
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
     * 获得SysWorkflowInsProc对象列表.
     * @return List.
     */
    public List<SysWorkflowInsProc> getSysWorkflowInsProcs() {
        return this.sysWorkflowInsProcs;
    }
	
	public void initSysWorkflowInsProcs(){
	    try {
            if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));

            this.sysWorkflowInsProcs = service.init(this.sysWorkflowInsProc,this.queryFields);
			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}

    /**
     * Sets the SysWorkflowInsProcs.
     * @param sysWorkflowInsProcs The SysWorkflowInsProcs to set.
     */
    public void setSysWorkflowInsProcs(List sysWorkflowInsProcs) {
        this.sysWorkflowInsProcs = sysWorkflowInsProcs;
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
     * 删除SysWorkflowInsProc对象.
     * @return String.
     */
    public void delete() {
        try {
            SysWorkflowInsProc sysWorkflowInsProc = sysWorkflowInsProcs.get(rowIndex);
            service.delete(sysWorkflowInsProc.getId());		
            addMessage("sysWorkflowInsProc.message.deleted", sysWorkflowInsProc.getId());		
            this.sysWorkflowInsProcs.remove(rowIndex.intValue());
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
    }
    /**
     * 删除SysWorkflowInsProc对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            SysWorkflowInsProc sysWorkflowInsProc = sysWorkflowInsProcs.get(rowIndex);
            if (sysWorkflowInsProc.getSysWorkflowInsTaskGroup().size() > 0) {
                this.addMessageString("exception.delete.cascade");
                return null;
            }

            service.delete(this.sysWorkflowInsProc.getId());
            addMessage("sysWorkflowInsProc.message.deleted", this.sysWorkflowInsProc.getId());				
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return null;
        }
        return null;
    }
    /**
     *    查询SysWorkflowInsProc对象.
     *  @return String.
     */
    public String query() {
        try {
            this.sysWorkflowInsProcs = service.getSysWorkflowInsProcListOfQuery(this.queryFields);
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
		SysWorkflowInsProc sysWorkflowInsProc = new SysWorkflowInsProc();
		sysWorkflowInsProc.set_record_index(-1);		
    	sysWorkflowInsProc.set_edit_flag(SysWorkflowInsProc.EDIT_FLAG_ADD);
        this.sysWorkflowInsProcs.add(sysWorkflowInsProc);
    }
	
	public void popupAdd(){
		SysWorkflowInsProc sysWorkflowInsProc = new SysWorkflowInsProc();
		sysWorkflowInsProc.set_record_index(-1);		
    	sysWorkflowInsProc.set_edit_flag(SysWorkflowInsProc.EDIT_FLAG_ADD);
    	this.getRequest().getSession().setAttribute("__pop_object", sysWorkflowInsProc); 	
    }
	
	public void popupEdit(){
		SysWorkflowInsProc sysWorkflowInsProc = sysWorkflowInsProcs.get(rowIndex);
    	sysWorkflowInsProc.set_record_index(rowIndex);
    	if (SysWorkflowInsProc.EDIT_FLAG_ADD != sysWorkflowInsProc.get_edit_flag()){
    		sysWorkflowInsProc.set_edit_flag(SysWorkflowInsProc.EDIT_FLAG_EDIT);
    	}    	
    	this.getRequest().getSession().setAttribute("__pop_object", sysWorkflowInsProc); 	
	}	
	
	public void popupView(){
		SysWorkflowInsProc sysWorkflowInsProc = sysWorkflowInsProcs.get(rowIndex.intValue());
    	this.getRequest().getSession().setAttribute("__pop_object", sysWorkflowInsProc); 	
	}	
    
    public void popupRefresh(){
    	SysWorkflowInsProc sysWorkflowInsProc = (SysWorkflowInsProc)this.getRequest().getSession().getAttribute("__pop_object");
    	if (sysWorkflowInsProc.get_record_index() != -1){
    		this.sysWorkflowInsProcs.remove(sysWorkflowInsProc.get_record_index());
    		this.sysWorkflowInsProcs.add(sysWorkflowInsProc.get_record_index(), sysWorkflowInsProc);
    	}
    	else{
    		this.sysWorkflowInsProcs.add(sysWorkflowInsProc);
    	}
		this.getRequest().getSession().removeAttribute("__pop_object");
    }
    
    public String edit(){
        SysWorkflowInsProc sysWorkflowInsProc = sysWorkflowInsProcs.get(rowIndex.intValue());
    	sysWorkflowInsProc.set_record_index(rowIndex);
    	if (SysWorkflowInsProc.EDIT_FLAG_ADD != sysWorkflowInsProc.get_edit_flag()){
    		sysWorkflowInsProc.set_edit_flag(SysWorkflowInsProc.EDIT_FLAG_EDIT);
			this.setValueBinding("#{sysWorkflowInsProcForm.sysWorkflowInsProcPrimaryKey}", sysWorkflowInsProc.getId());
    	}
    	return this.getSuccessAction();
    }
    
    public String view(){
        SysWorkflowInsProc sysWorkflowInsProc = sysWorkflowInsProcs.get(rowIndex.intValue());
		this.setValueBinding("#{sysWorkflowInsProcForm.sysWorkflowInsProcPrimaryKey}", sysWorkflowInsProc.getId());
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
    	SysWorkflowInsProc sysWorkflowInsProc  = sysWorkflowInsProcs.get(rowIndex.intValue());
    	if (SysWorkflowInsProc.EDIT_FLAG_ADD != sysWorkflowInsProc.get_edit_flag()){
			deleteList.add(sysWorkflowInsProc.getId());    	
		}
		sysWorkflowInsProcs.remove(rowIndex.intValue());
    }	
	
    public void moveUpBuffer(){
    	int i = rowIndex;
    	int j = getMovedSysWorkflowInsProcIndex(i,-1);
    	if (j == -1)
    		return ;
    	SysWorkflowInsProc sysWorkflowInsProc = sysWorkflowInsProcs.get(i);
    	sysWorkflowInsProcs.add(j, sysWorkflowInsProc);
    	sysWorkflowInsProcs.remove(i + 1);
    }	
	
    private int getMovedSysWorkflowInsProcIndex(int index,int step){
    	if (index + step >= 0 && index + step < sysWorkflowInsProcs.size()){
    		SysWorkflowInsProc sysWorkflowInsProc = sysWorkflowInsProcs.get(index + step);
    		if (SysWorkflowInsProc.EDIT_FLAG_DELETE == sysWorkflowInsProc.get_edit_flag())
    			return index + step + getMovedSysWorkflowInsProcIndex(index + step,step);
    		else
    			return index + step;
    	}else{
    		return -1;
    	}    	
    }	
	
    public void moveDownBuffer(){
    	int i = rowIndex;
    	int j = getMovedSysWorkflowInsProcIndex(i,1);
    	if (j == -1)
    		return ;
    	SysWorkflowInsProc sysWorkflowInsProc = sysWorkflowInsProcs.get(j);
    	sysWorkflowInsProcs.add(i, sysWorkflowInsProc);
    	sysWorkflowInsProcs.remove(j + 1);
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
            for (int i=0; i < sysWorkflowInsProcs.size(); i++) {
                SysWorkflowInsProc sysWorkflowInsProc = (SysWorkflowInsProc)this.sysWorkflowInsProcs.get(i);
                service.saveSysWorkflowInsProc(sysWorkflowInsProc);
            }
	        addMessage("sysWorkflowInsProc.message.savedAll",null);
			return this.getSuccessAction();
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
		return null;
	}	
	
	public void deleteChecked(){
		for(SysWorkflowInsProc sysWorkflowInsProc : this.sysWorkflowInsProcs){
			if(sysWorkflowInsProc.is_checked_flag()){
				service.delete(sysWorkflowInsProc.getId());
			}
		}
	}
	
	public void deleteAll(){
		service.deleteAll(this.sysWorkflowInsProcs);
	}
}
