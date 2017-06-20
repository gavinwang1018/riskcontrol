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
import cn.com.brilliance.begen.service.TruleService;
import cn.com.brilliance.begen.webapp.action.BasePage;
import cn.com.brilliance.begen.common.webapp.action.ListPage;

/**
 * Trule对象List.
 * @author Administrator.
 *
 */
public class TruleList extends BasePage implements ListPage {

	private TruleService service = (TruleService)getBean("truleService");
    /**
     * trules.
     */
    private List<Trule> trules;

    /**
     * dataTable.
     */
    private HtmlDataTable dataTable;

    /**
     * trule.
     */
    private Trule trule = null;

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
    public TruleList() {
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
     * Returns the Trule.
     * @return Trule.
     */
    public void setTrule(Trule trule) {
        this.trule = trule;
    }

    /**
     * Sets the Trule.
     * @param trule The trule to set.
     */
    public Trule getTrule() {
        return this.trule;
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
     * 获得Trule对象列表.
     * @return List.
     */
    public List<Trule> getTrules() {
        return this.trules;
    }
	
	public void initTrules(){
	    try {
            if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));

            this.trules = service.init(this.trule,this.queryFields);
			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}

    /**
     * Sets the Trules.
     * @param trules The Trules to set.
     */
    public void setTrules(List trules) {
        this.trules = trules;
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
     * 删除Trule对象.
     * @return String.
     */
    public void delete() {
        try {
            Trule trule = trules.get(rowIndex);
            service.delete(trule.getId());		
            addMessage("trule.message.deleted", trule.getId());		
            this.trules.remove(rowIndex.intValue());
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
    }
    /**
     * 删除Trule对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            Trule trule = trules.get(rowIndex);

            service.delete(this.trule.getId());
            addMessage("trule.message.deleted", this.trule.getId());				
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return null;
        }
        return null;
    }
    /**
     *    查询Trule对象.
     *  @return String.
     */
    public String query() {
        try {
            this.trules = service.getTruleListOfQuery(this.queryFields);
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
		Trule trule = new Trule();
		trule.set_record_index(-1);		
    	trule.set_edit_flag(Trule.EDIT_FLAG_ADD);
        this.trules.add(trule);
    }
	
	public void popupAdd(){
		Trule trule = new Trule();
		trule.set_record_index(-1);		
    	trule.set_edit_flag(Trule.EDIT_FLAG_ADD);
    	this.getRequest().getSession().setAttribute("__pop_object", trule); 	
    }
	
	public void popupEdit(){
		Trule trule = trules.get(rowIndex);
    	trule.set_record_index(rowIndex);
    	if (Trule.EDIT_FLAG_ADD != trule.get_edit_flag()){
    		trule.set_edit_flag(Trule.EDIT_FLAG_EDIT);
    	}    	
    	this.getRequest().getSession().setAttribute("__pop_object", trule); 	
	}	
	
	public void popupView(){
		Trule trule = trules.get(rowIndex.intValue());
    	this.getRequest().getSession().setAttribute("__pop_object", trule); 	
	}	
    
    public void popupRefresh(){
    	Trule trule = (Trule)this.getRequest().getSession().getAttribute("__pop_object");
    	if (trule.get_record_index() != -1){
    		this.trules.remove(trule.get_record_index());
    		this.trules.add(trule.get_record_index(), trule);
    	}
    	else{
    		this.trules.add(trule);
    	}
		this.getRequest().getSession().removeAttribute("__pop_object");
    }
    
    public String edit(){
        Trule trule = trules.get(rowIndex.intValue());
    	trule.set_record_index(rowIndex);
    	if (Trule.EDIT_FLAG_ADD != trule.get_edit_flag()){
    		trule.set_edit_flag(Trule.EDIT_FLAG_EDIT);
			this.setValueBinding("#{truleForm.trulePrimaryKey}", trule.getId());
    	}
    	return this.getSuccessAction();
    }
    
    public String view(){
        Trule trule = trules.get(rowIndex.intValue());
		this.setValueBinding("#{truleForm.trulePrimaryKey}", trule.getId());
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
    	Trule trule  = trules.get(rowIndex.intValue());
    	if (Trule.EDIT_FLAG_ADD != trule.get_edit_flag()){
			deleteList.add(trule.getId());    	
		}
		trules.remove(rowIndex.intValue());
    }	
	
    public void moveUpBuffer(){
    	int i = rowIndex;
    	int j = getMovedTruleIndex(i,-1);
    	if (j == -1)
    		return ;
    	Trule trule = trules.get(i);
    	trules.add(j, trule);
    	trules.remove(i + 1);
    }	
	
    private int getMovedTruleIndex(int index,int step){
    	if (index + step >= 0 && index + step < trules.size()){
    		Trule trule = trules.get(index + step);
    		if (Trule.EDIT_FLAG_DELETE == trule.get_edit_flag())
    			return index + step + getMovedTruleIndex(index + step,step);
    		else
    			return index + step;
    	}else{
    		return -1;
    	}    	
    }	
	
    public void moveDownBuffer(){
    	int i = rowIndex;
    	int j = getMovedTruleIndex(i,1);
    	if (j == -1)
    		return ;
    	Trule trule = trules.get(j);
    	trules.add(i, trule);
    	trules.remove(j + 1);
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
            for (int i=0; i < trules.size(); i++) {
                Trule trule = (Trule)this.trules.get(i);
                service.saveTrule(trule);
            }
	        addMessage("trule.message.savedAll",null);
			return this.getSuccessAction();
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
		return null;
	}	
	
	public void deleteChecked(){
		for(Trule trule : this.trules){
			if(trule.is_checked_flag()){
				service.delete(trule.getId());
			}
		}
	}
	
	public void deleteAll(){
		service.deleteAll(this.trules);
	}
}
