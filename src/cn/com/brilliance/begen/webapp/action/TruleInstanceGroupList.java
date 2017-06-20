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
import cn.com.brilliance.begen.service.TruleInstanceGroupService;
import cn.com.brilliance.begen.webapp.action.BasePage;
import cn.com.brilliance.begen.common.webapp.action.ListPage;

/**
 * TruleInstanceGroup对象List.
 * @author Administrator.
 *
 */
public class TruleInstanceGroupList extends BasePage implements ListPage {

	private TruleInstanceGroupService service = (TruleInstanceGroupService)getBean("truleInstanceGroupService");
    /**
     * truleInstanceGroups.
     */
    private List<TruleInstanceGroup> truleInstanceGroups;

    /**
     * dataTable.
     */
    private HtmlDataTable dataTable;

    /**
     * truleInstanceGroup.
     */
    private TruleInstanceGroup truleInstanceGroup = null;

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
    public TruleInstanceGroupList() {
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
     * Returns the TruleInstanceGroup.
     * @return TruleInstanceGroup.
     */
    public void setTruleInstanceGroup(TruleInstanceGroup truleInstanceGroup) {
        this.truleInstanceGroup = truleInstanceGroup;
    }

    /**
     * Sets the TruleInstanceGroup.
     * @param truleInstanceGroup The truleInstanceGroup to set.
     */
    public TruleInstanceGroup getTruleInstanceGroup() {
        return this.truleInstanceGroup;
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
     * 获得TruleInstanceGroup对象列表.
     * @return List.
     */
    public List<TruleInstanceGroup> getTruleInstanceGroups() {
        return this.truleInstanceGroups;
    }
	
	public void initTruleInstanceGroups(){
	    try {
            if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));

            this.truleInstanceGroups = service.init(this.truleInstanceGroup,this.queryFields);
			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}

    /**
     * Sets the TruleInstanceGroups.
     * @param truleInstanceGroups The TruleInstanceGroups to set.
     */
    public void setTruleInstanceGroups(List truleInstanceGroups) {
        this.truleInstanceGroups = truleInstanceGroups;
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
     * 删除TruleInstanceGroup对象.
     * @return String.
     */
    public void delete() {
        try {
            TruleInstanceGroup truleInstanceGroup = truleInstanceGroups.get(rowIndex);
            service.delete(truleInstanceGroup.getId());		
            addMessage("truleInstanceGroup.message.deleted", truleInstanceGroup.getId());		
            this.truleInstanceGroups.remove(rowIndex.intValue());
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
    }
    /**
     * 删除TruleInstanceGroup对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            TruleInstanceGroup truleInstanceGroup = truleInstanceGroups.get(rowIndex);

            service.delete(this.truleInstanceGroup.getId());
            addMessage("truleInstanceGroup.message.deleted", this.truleInstanceGroup.getId());				
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return null;
        }
        return null;
    }
    /**
     *    查询TruleInstanceGroup对象.
     *  @return String.
     */
    public String query() {
        try {
            this.truleInstanceGroups = service.getTruleInstanceGroupListOfQuery(this.queryFields);
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
		TruleInstanceGroup truleInstanceGroup = new TruleInstanceGroup();
		truleInstanceGroup.set_record_index(-1);		
    	truleInstanceGroup.set_edit_flag(TruleInstanceGroup.EDIT_FLAG_ADD);
        this.truleInstanceGroups.add(truleInstanceGroup);
    }
	
	public void popupAdd(){
		TruleInstanceGroup truleInstanceGroup = new TruleInstanceGroup();
		truleInstanceGroup.set_record_index(-1);		
    	truleInstanceGroup.set_edit_flag(TruleInstanceGroup.EDIT_FLAG_ADD);
    	this.getRequest().getSession().setAttribute("__pop_object", truleInstanceGroup); 	
    }
	
	public void popupEdit(){
		TruleInstanceGroup truleInstanceGroup = truleInstanceGroups.get(rowIndex);
    	truleInstanceGroup.set_record_index(rowIndex);
    	if (TruleInstanceGroup.EDIT_FLAG_ADD != truleInstanceGroup.get_edit_flag()){
    		truleInstanceGroup.set_edit_flag(TruleInstanceGroup.EDIT_FLAG_EDIT);
    	}    	
    	this.getRequest().getSession().setAttribute("__pop_object", truleInstanceGroup); 	
	}	
	
	public void popupView(){
		TruleInstanceGroup truleInstanceGroup = truleInstanceGroups.get(rowIndex.intValue());
    	this.getRequest().getSession().setAttribute("__pop_object", truleInstanceGroup); 	
	}	
    
    public void popupRefresh(){
    	TruleInstanceGroup truleInstanceGroup = (TruleInstanceGroup)this.getRequest().getSession().getAttribute("__pop_object");
    	if (truleInstanceGroup.get_record_index() != -1){
    		this.truleInstanceGroups.remove(truleInstanceGroup.get_record_index());
    		this.truleInstanceGroups.add(truleInstanceGroup.get_record_index(), truleInstanceGroup);
    	}
    	else{
    		this.truleInstanceGroups.add(truleInstanceGroup);
    	}
		this.getRequest().getSession().removeAttribute("__pop_object");
    }
    
    public String edit(){
        TruleInstanceGroup truleInstanceGroup = truleInstanceGroups.get(rowIndex.intValue());
    	truleInstanceGroup.set_record_index(rowIndex);
    	if (TruleInstanceGroup.EDIT_FLAG_ADD != truleInstanceGroup.get_edit_flag()){
    		truleInstanceGroup.set_edit_flag(TruleInstanceGroup.EDIT_FLAG_EDIT);
			this.setValueBinding("#{truleInstanceGroupForm.truleInstanceGroupPrimaryKey}", truleInstanceGroup.getId());
    	}
    	return this.getSuccessAction();
    }
    
    public String view(){
        TruleInstanceGroup truleInstanceGroup = truleInstanceGroups.get(rowIndex.intValue());
		this.setValueBinding("#{truleInstanceGroupForm.truleInstanceGroupPrimaryKey}", truleInstanceGroup.getId());
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
    	TruleInstanceGroup truleInstanceGroup  = truleInstanceGroups.get(rowIndex.intValue());
    	if (TruleInstanceGroup.EDIT_FLAG_ADD != truleInstanceGroup.get_edit_flag()){
			deleteList.add(truleInstanceGroup.getId());    	
		}
		truleInstanceGroups.remove(rowIndex.intValue());
    }	
	
    public void moveUpBuffer(){
    	int i = rowIndex;
    	int j = getMovedTruleInstanceGroupIndex(i,-1);
    	if (j == -1)
    		return ;
    	TruleInstanceGroup truleInstanceGroup = truleInstanceGroups.get(i);
    	truleInstanceGroups.add(j, truleInstanceGroup);
    	truleInstanceGroups.remove(i + 1);
    }	
	
    private int getMovedTruleInstanceGroupIndex(int index,int step){
    	if (index + step >= 0 && index + step < truleInstanceGroups.size()){
    		TruleInstanceGroup truleInstanceGroup = truleInstanceGroups.get(index + step);
    		if (TruleInstanceGroup.EDIT_FLAG_DELETE == truleInstanceGroup.get_edit_flag())
    			return index + step + getMovedTruleInstanceGroupIndex(index + step,step);
    		else
    			return index + step;
    	}else{
    		return -1;
    	}    	
    }	
	
    public void moveDownBuffer(){
    	int i = rowIndex;
    	int j = getMovedTruleInstanceGroupIndex(i,1);
    	if (j == -1)
    		return ;
    	TruleInstanceGroup truleInstanceGroup = truleInstanceGroups.get(j);
    	truleInstanceGroups.add(i, truleInstanceGroup);
    	truleInstanceGroups.remove(j + 1);
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
            for (int i=0; i < truleInstanceGroups.size(); i++) {
                TruleInstanceGroup truleInstanceGroup = (TruleInstanceGroup)this.truleInstanceGroups.get(i);
                service.saveTruleInstanceGroup(truleInstanceGroup);
            }
	        addMessage("truleInstanceGroup.message.savedAll",null);
			return this.getSuccessAction();
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
		return null;
	}	
	
	public void deleteChecked(){
		for(TruleInstanceGroup truleInstanceGroup : this.truleInstanceGroups){
			if(truleInstanceGroup.is_checked_flag()){
				service.delete(truleInstanceGroup.getId());
			}
		}
	}
	
	public void deleteAll(){
		service.deleteAll(this.truleInstanceGroups);
	}
}
