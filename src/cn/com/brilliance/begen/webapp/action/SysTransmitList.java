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
import cn.com.brilliance.begen.service.SysTransmitService;
import cn.com.brilliance.begen.webapp.action.BasePage;
import cn.com.brilliance.begen.common.webapp.action.ListPage;

/**
 * SysTransmit对象List.
 * @author Administrator.
 *
 */
public class SysTransmitList extends BasePage implements ListPage {

	private SysTransmitService service = (SysTransmitService)getBean("sysTransmitService");
    /**
     * sysTransmits.
     */
    private List<SysTransmit> sysTransmits;

    /**
     * dataTable.
     */
    private HtmlDataTable dataTable;

    /**
     * sysTransmit.
     */
    private SysTransmit sysTransmit = null;

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
    public SysTransmitList() {
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
     * Returns the SysTransmit.
     * @return SysTransmit.
     */
    public void setSysTransmit(SysTransmit sysTransmit) {
        this.sysTransmit = sysTransmit;
    }

    /**
     * Sets the SysTransmit.
     * @param sysTransmit The sysTransmit to set.
     */
    public SysTransmit getSysTransmit() {
        return this.sysTransmit;
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
     * 获得SysTransmit对象列表.
     * @return List.
     */
    public List<SysTransmit> getSysTransmits() {
        return this.sysTransmits;
    }
	
	public void initSysTransmits(){
	    try {
            if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));

            this.sysTransmits = service.init(this.sysTransmit,this.queryFields);
			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}

    /**
     * Sets the SysTransmits.
     * @param sysTransmits The SysTransmits to set.
     */
    public void setSysTransmits(List sysTransmits) {
        this.sysTransmits = sysTransmits;
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
     * 删除SysTransmit对象.
     * @return String.
     */
    public void delete() {
        try {
            SysTransmit sysTransmit = sysTransmits.get(rowIndex);
            service.delete(sysTransmit.getId());		
            addMessage("sysTransmit.message.deleted", sysTransmit.getId());		
            this.sysTransmits.remove(rowIndex.intValue());
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
    }
    /**
     * 删除SysTransmit对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            SysTransmit sysTransmit = sysTransmits.get(rowIndex);
            if (sysTransmit.getSysTransmitDetailGroup().size() > 0) {
                this.addMessageString("exception.delete.cascade");
                return null;
            }

            service.delete(this.sysTransmit.getId());
            addMessage("sysTransmit.message.deleted", this.sysTransmit.getId());				
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return null;
        }
        return null;
    }
    /**
     *    查询SysTransmit对象.
     *  @return String.
     */
    public String query() {
        try {
            this.sysTransmits = service.getSysTransmitListOfQuery(this.queryFields);
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
		SysTransmit sysTransmit = new SysTransmit();
		sysTransmit.set_record_index(-1);		
    	sysTransmit.set_edit_flag(SysTransmit.EDIT_FLAG_ADD);
        this.sysTransmits.add(sysTransmit);
    }
	
	public void popupAdd(){
		SysTransmit sysTransmit = new SysTransmit();
		sysTransmit.set_record_index(-1);		
    	sysTransmit.set_edit_flag(SysTransmit.EDIT_FLAG_ADD);
    	this.getRequest().getSession().setAttribute("__pop_object", sysTransmit); 	
    }
	
	public void popupEdit(){
		SysTransmit sysTransmit = sysTransmits.get(rowIndex);
    	sysTransmit.set_record_index(rowIndex);
    	if (SysTransmit.EDIT_FLAG_ADD != sysTransmit.get_edit_flag()){
    		sysTransmit.set_edit_flag(SysTransmit.EDIT_FLAG_EDIT);
    	}    	
    	this.getRequest().getSession().setAttribute("__pop_object", sysTransmit); 	
	}	
	
	public void popupView(){
		SysTransmit sysTransmit = sysTransmits.get(rowIndex.intValue());
    	this.getRequest().getSession().setAttribute("__pop_object", sysTransmit); 	
	}	
    
    public void popupRefresh(){
    	SysTransmit sysTransmit = (SysTransmit)this.getRequest().getSession().getAttribute("__pop_object");
    	if (sysTransmit.get_record_index() != -1){
    		this.sysTransmits.remove(sysTransmit.get_record_index());
    		this.sysTransmits.add(sysTransmit.get_record_index(), sysTransmit);
    	}
    	else{
    		this.sysTransmits.add(sysTransmit);
    	}
		this.getRequest().getSession().removeAttribute("__pop_object");
    }
    
    public String edit(){
        SysTransmit sysTransmit = sysTransmits.get(rowIndex.intValue());
    	sysTransmit.set_record_index(rowIndex);
    	if (SysTransmit.EDIT_FLAG_ADD != sysTransmit.get_edit_flag()){
    		sysTransmit.set_edit_flag(SysTransmit.EDIT_FLAG_EDIT);
			this.setValueBinding("#{sysTransmitForm.sysTransmitPrimaryKey}", sysTransmit.getId());
    	}
    	return this.getSuccessAction();
    }
    
    public String view(){
        SysTransmit sysTransmit = sysTransmits.get(rowIndex.intValue());
		this.setValueBinding("#{sysTransmitForm.sysTransmitPrimaryKey}", sysTransmit.getId());
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
    	SysTransmit sysTransmit  = sysTransmits.get(rowIndex.intValue());
    	if (SysTransmit.EDIT_FLAG_ADD != sysTransmit.get_edit_flag()){
			deleteList.add(sysTransmit.getId());    	
		}
		sysTransmits.remove(rowIndex.intValue());
    }	
	
    public void moveUpBuffer(){
    	int i = rowIndex;
    	int j = getMovedSysTransmitIndex(i,-1);
    	if (j == -1)
    		return ;
    	SysTransmit sysTransmit = sysTransmits.get(i);
    	sysTransmits.add(j, sysTransmit);
    	sysTransmits.remove(i + 1);
    }	
	
    private int getMovedSysTransmitIndex(int index,int step){
    	if (index + step >= 0 && index + step < sysTransmits.size()){
    		SysTransmit sysTransmit = sysTransmits.get(index + step);
    		if (SysTransmit.EDIT_FLAG_DELETE == sysTransmit.get_edit_flag())
    			return index + step + getMovedSysTransmitIndex(index + step,step);
    		else
    			return index + step;
    	}else{
    		return -1;
    	}    	
    }	
	
    public void moveDownBuffer(){
    	int i = rowIndex;
    	int j = getMovedSysTransmitIndex(i,1);
    	if (j == -1)
    		return ;
    	SysTransmit sysTransmit = sysTransmits.get(j);
    	sysTransmits.add(i, sysTransmit);
    	sysTransmits.remove(j + 1);
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
            for (int i=0; i < sysTransmits.size(); i++) {
                SysTransmit sysTransmit = (SysTransmit)this.sysTransmits.get(i);
                service.saveSysTransmit(sysTransmit);
            }
	        addMessage("sysTransmit.message.savedAll",null);
			return this.getSuccessAction();
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
		return null;
	}	
	
	public void deleteChecked(){
		for(SysTransmit sysTransmit : this.sysTransmits){
			if(sysTransmit.is_checked_flag()){
				service.delete(sysTransmit.getId());
			}
		}
	}
	
	public void deleteAll(){
		service.deleteAll(this.sysTransmits);
	}
}
