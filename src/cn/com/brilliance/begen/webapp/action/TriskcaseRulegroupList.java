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
import cn.com.brilliance.begen.service.TriskcaseRulegroupService;
import cn.com.brilliance.begen.webapp.action.BasePage;
import cn.com.brilliance.begen.common.webapp.action.ListPage;

/**
 * TriskcaseRulegroup对象List.
 * @author Administrator.
 *
 */
public class TriskcaseRulegroupList extends BasePage implements ListPage {

	private TriskcaseRulegroupService service = (TriskcaseRulegroupService)getBean("triskcaseRulegroupService");
    /**
     * triskcaseRulegroups.
     */
    private List<TriskcaseRulegroup> triskcaseRulegroups;

    /**
     * dataTable.
     */
    private HtmlDataTable dataTable;

    /**
     * triskcaseRulegroup.
     */
    private TriskcaseRulegroup triskcaseRulegroup = null;

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
    public TriskcaseRulegroupList() {
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
     * Returns the TriskcaseRulegroup.
     * @return TriskcaseRulegroup.
     */
    public void setTriskcaseRulegroup(TriskcaseRulegroup triskcaseRulegroup) {
        this.triskcaseRulegroup = triskcaseRulegroup;
    }

    /**
     * Sets the TriskcaseRulegroup.
     * @param triskcaseRulegroup The triskcaseRulegroup to set.
     */
    public TriskcaseRulegroup getTriskcaseRulegroup() {
        return this.triskcaseRulegroup;
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
     * 获得TriskcaseRulegroup对象列表.
     * @return List.
     */
    public List<TriskcaseRulegroup> getTriskcaseRulegroups() {
        return this.triskcaseRulegroups;
    }
	
	public void initTriskcaseRulegroups(){
	    try {
            if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));

            this.triskcaseRulegroups = service.init(this.triskcaseRulegroup,this.queryFields);
			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}

    /**
     * Sets the TriskcaseRulegroups.
     * @param triskcaseRulegroups The TriskcaseRulegroups to set.
     */
    public void setTriskcaseRulegroups(List triskcaseRulegroups) {
        this.triskcaseRulegroups = triskcaseRulegroups;
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
     * 删除TriskcaseRulegroup对象.
     * @return String.
     */
    public void delete() {
        try {
            TriskcaseRulegroup triskcaseRulegroup = triskcaseRulegroups.get(rowIndex);
            service.delete(triskcaseRulegroup.getId());		
            addMessage("triskcaseRulegroup.message.deleted", triskcaseRulegroup.getId());		
            this.triskcaseRulegroups.remove(rowIndex.intValue());
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
    }
    /**
     * 删除TriskcaseRulegroup对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            TriskcaseRulegroup triskcaseRulegroup = triskcaseRulegroups.get(rowIndex);

            service.delete(this.triskcaseRulegroup.getId());
            addMessage("triskcaseRulegroup.message.deleted", this.triskcaseRulegroup.getId());				
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return null;
        }
        return null;
    }
    /**
     *    查询TriskcaseRulegroup对象.
     *  @return String.
     */
    public String query() {
        try {
            this.triskcaseRulegroups = service.getTriskcaseRulegroupListOfQuery(this.queryFields);
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
		TriskcaseRulegroup triskcaseRulegroup = new TriskcaseRulegroup();
		triskcaseRulegroup.set_record_index(-1);		
    	triskcaseRulegroup.set_edit_flag(TriskcaseRulegroup.EDIT_FLAG_ADD);
        this.triskcaseRulegroups.add(triskcaseRulegroup);
    }
	
	public void popupAdd(){
		TriskcaseRulegroup triskcaseRulegroup = new TriskcaseRulegroup();
		triskcaseRulegroup.set_record_index(-1);		
    	triskcaseRulegroup.set_edit_flag(TriskcaseRulegroup.EDIT_FLAG_ADD);
    	this.getRequest().getSession().setAttribute("__pop_object", triskcaseRulegroup); 	
    }
	
	public void popupEdit(){
		TriskcaseRulegroup triskcaseRulegroup = triskcaseRulegroups.get(rowIndex);
    	triskcaseRulegroup.set_record_index(rowIndex);
    	if (TriskcaseRulegroup.EDIT_FLAG_ADD != triskcaseRulegroup.get_edit_flag()){
    		triskcaseRulegroup.set_edit_flag(TriskcaseRulegroup.EDIT_FLAG_EDIT);
    	}    	
    	this.getRequest().getSession().setAttribute("__pop_object", triskcaseRulegroup); 	
	}	
	
	public void popupView(){
		TriskcaseRulegroup triskcaseRulegroup = triskcaseRulegroups.get(rowIndex.intValue());
    	this.getRequest().getSession().setAttribute("__pop_object", triskcaseRulegroup); 	
	}	
    
    public void popupRefresh(){
    	TriskcaseRulegroup triskcaseRulegroup = (TriskcaseRulegroup)this.getRequest().getSession().getAttribute("__pop_object");
    	if (triskcaseRulegroup.get_record_index() != -1){
    		this.triskcaseRulegroups.remove(triskcaseRulegroup.get_record_index());
    		this.triskcaseRulegroups.add(triskcaseRulegroup.get_record_index(), triskcaseRulegroup);
    	}
    	else{
    		this.triskcaseRulegroups.add(triskcaseRulegroup);
    	}
		this.getRequest().getSession().removeAttribute("__pop_object");
    }
    
    public String edit(){
        TriskcaseRulegroup triskcaseRulegroup = triskcaseRulegroups.get(rowIndex.intValue());
    	triskcaseRulegroup.set_record_index(rowIndex);
    	if (TriskcaseRulegroup.EDIT_FLAG_ADD != triskcaseRulegroup.get_edit_flag()){
    		triskcaseRulegroup.set_edit_flag(TriskcaseRulegroup.EDIT_FLAG_EDIT);
			this.setValueBinding("#{triskcaseRulegroupForm.triskcaseRulegroupPrimaryKey}", triskcaseRulegroup.getId());
    	}
    	return this.getSuccessAction();
    }
    
    public String view(){
        TriskcaseRulegroup triskcaseRulegroup = triskcaseRulegroups.get(rowIndex.intValue());
		this.setValueBinding("#{triskcaseRulegroupForm.triskcaseRulegroupPrimaryKey}", triskcaseRulegroup.getId());
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
    	TriskcaseRulegroup triskcaseRulegroup  = triskcaseRulegroups.get(rowIndex.intValue());
    	if (TriskcaseRulegroup.EDIT_FLAG_ADD != triskcaseRulegroup.get_edit_flag()){
			deleteList.add(triskcaseRulegroup.getId());    	
		}
		triskcaseRulegroups.remove(rowIndex.intValue());
    }	
	
    public void moveUpBuffer(){
    	int i = rowIndex;
    	int j = getMovedTriskcaseRulegroupIndex(i,-1);
    	if (j == -1)
    		return ;
    	TriskcaseRulegroup triskcaseRulegroup = triskcaseRulegroups.get(i);
    	triskcaseRulegroups.add(j, triskcaseRulegroup);
    	triskcaseRulegroups.remove(i + 1);
    }	
	
    private int getMovedTriskcaseRulegroupIndex(int index,int step){
    	if (index + step >= 0 && index + step < triskcaseRulegroups.size()){
    		TriskcaseRulegroup triskcaseRulegroup = triskcaseRulegroups.get(index + step);
    		if (TriskcaseRulegroup.EDIT_FLAG_DELETE == triskcaseRulegroup.get_edit_flag())
    			return index + step + getMovedTriskcaseRulegroupIndex(index + step,step);
    		else
    			return index + step;
    	}else{
    		return -1;
    	}    	
    }	
	
    public void moveDownBuffer(){
    	int i = rowIndex;
    	int j = getMovedTriskcaseRulegroupIndex(i,1);
    	if (j == -1)
    		return ;
    	TriskcaseRulegroup triskcaseRulegroup = triskcaseRulegroups.get(j);
    	triskcaseRulegroups.add(i, triskcaseRulegroup);
    	triskcaseRulegroups.remove(j + 1);
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
            for (int i=0; i < triskcaseRulegroups.size(); i++) {
                TriskcaseRulegroup triskcaseRulegroup = (TriskcaseRulegroup)this.triskcaseRulegroups.get(i);
                service.saveTriskcaseRulegroup(triskcaseRulegroup);
            }
	        addMessage("triskcaseRulegroup.message.savedAll",null);
			return this.getSuccessAction();
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
		return null;
	}	
	
	public void deleteChecked(){
		for(TriskcaseRulegroup triskcaseRulegroup : this.triskcaseRulegroups){
			if(triskcaseRulegroup.is_checked_flag()){
				service.delete(triskcaseRulegroup.getId());
			}
		}
	}
	
	public void deleteAll(){
		service.deleteAll(this.triskcaseRulegroups);
	}
}
