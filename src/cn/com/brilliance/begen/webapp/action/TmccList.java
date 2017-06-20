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
import cn.com.brilliance.begen.service.TmccService;
import cn.com.brilliance.begen.webapp.action.BasePage;
import cn.com.brilliance.begen.common.webapp.action.ListPage;

/**
 * Tmcc对象List.
 * @author Administrator.
 *
 */
public class TmccList extends BasePage implements ListPage {

	private TmccService service = (TmccService)getBean("tmccService");
    /**
     * tmccs.
     */
    private List<Tmcc> tmccs;

    /**
     * dataTable.
     */
    private HtmlDataTable dataTable;

    /**
     * tmcc.
     */
    private Tmcc tmcc = null;

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
    public TmccList() {
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
     * Returns the Tmcc.
     * @return Tmcc.
     */
    public void setTmcc(Tmcc tmcc) {
        this.tmcc = tmcc;
    }

    /**
     * Sets the Tmcc.
     * @param tmcc The tmcc to set.
     */
    public Tmcc getTmcc() {
        return this.tmcc;
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
     * 获得Tmcc对象列表.
     * @return List.
     */
    public List<Tmcc> getTmccs() {
        return this.tmccs;
    }
	
	public void initTmccs(){
	    try {
            if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));

            this.tmccs = service.init(this.tmcc,this.queryFields);
			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}

    /**
     * Sets the Tmccs.
     * @param tmccs The Tmccs to set.
     */
    public void setTmccs(List tmccs) {
        this.tmccs = tmccs;
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
     * 删除Tmcc对象.
     * @return String.
     */
    public void delete() {
        try {
            Tmcc tmcc = tmccs.get(rowIndex);
            service.delete(tmcc.getId());		
            addMessage("tmcc.message.deleted", tmcc.getId());		
            this.tmccs.remove(rowIndex.intValue());
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
    }
    /**
     * 删除Tmcc对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            Tmcc tmcc = tmccs.get(rowIndex);

            service.delete(this.tmcc.getId());
            addMessage("tmcc.message.deleted", this.tmcc.getId());				
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return null;
        }
        return null;
    }
    /**
     *    查询Tmcc对象.
     *  @return String.
     */
    public String query() {
        try {
            this.tmccs = service.getTmccListOfQuery(this.queryFields);
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
		Tmcc tmcc = new Tmcc();
		tmcc.set_record_index(-1);		
    	tmcc.set_edit_flag(Tmcc.EDIT_FLAG_ADD);
        this.tmccs.add(tmcc);
    }
	
	public void popupAdd(){
		Tmcc tmcc = new Tmcc();
		tmcc.set_record_index(-1);		
    	tmcc.set_edit_flag(Tmcc.EDIT_FLAG_ADD);
    	this.getRequest().getSession().setAttribute("__pop_object", tmcc); 	
    }
	
	public void popupEdit(){
		Tmcc tmcc = tmccs.get(rowIndex);
    	tmcc.set_record_index(rowIndex);
    	if (Tmcc.EDIT_FLAG_ADD != tmcc.get_edit_flag()){
    		tmcc.set_edit_flag(Tmcc.EDIT_FLAG_EDIT);
    	}    	
    	this.getRequest().getSession().setAttribute("__pop_object", tmcc); 	
	}	
	
	public void popupView(){
		Tmcc tmcc = tmccs.get(rowIndex.intValue());
    	this.getRequest().getSession().setAttribute("__pop_object", tmcc); 	
	}	
    
    public void popupRefresh(){
    	Tmcc tmcc = (Tmcc)this.getRequest().getSession().getAttribute("__pop_object");
    	if (tmcc.get_record_index() != -1){
    		this.tmccs.remove(tmcc.get_record_index());
    		this.tmccs.add(tmcc.get_record_index(), tmcc);
    	}
    	else{
    		this.tmccs.add(tmcc);
    	}
		this.getRequest().getSession().removeAttribute("__pop_object");
    }
    
    public String edit(){
        Tmcc tmcc = tmccs.get(rowIndex.intValue());
    	tmcc.set_record_index(rowIndex);
    	if (Tmcc.EDIT_FLAG_ADD != tmcc.get_edit_flag()){
    		tmcc.set_edit_flag(Tmcc.EDIT_FLAG_EDIT);
			this.setValueBinding("#{tmccForm.tmccPrimaryKey}", tmcc.getId());
    	}
    	return this.getSuccessAction();
    }
    
    public String view(){
        Tmcc tmcc = tmccs.get(rowIndex.intValue());
		this.setValueBinding("#{tmccForm.tmccPrimaryKey}", tmcc.getId());
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
    	Tmcc tmcc  = tmccs.get(rowIndex.intValue());
    	if (Tmcc.EDIT_FLAG_ADD != tmcc.get_edit_flag()){
			deleteList.add(tmcc.getId());    	
		}
		tmccs.remove(rowIndex.intValue());
    }	
	
    public void moveUpBuffer(){
    	int i = rowIndex;
    	int j = getMovedTmccIndex(i,-1);
    	if (j == -1)
    		return ;
    	Tmcc tmcc = tmccs.get(i);
    	tmccs.add(j, tmcc);
    	tmccs.remove(i + 1);
    }	
	
    private int getMovedTmccIndex(int index,int step){
    	if (index + step >= 0 && index + step < tmccs.size()){
    		Tmcc tmcc = tmccs.get(index + step);
    		if (Tmcc.EDIT_FLAG_DELETE == tmcc.get_edit_flag())
    			return index + step + getMovedTmccIndex(index + step,step);
    		else
    			return index + step;
    	}else{
    		return -1;
    	}    	
    }	
	
    public void moveDownBuffer(){
    	int i = rowIndex;
    	int j = getMovedTmccIndex(i,1);
    	if (j == -1)
    		return ;
    	Tmcc tmcc = tmccs.get(j);
    	tmccs.add(i, tmcc);
    	tmccs.remove(j + 1);
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
            for (int i=0; i < tmccs.size(); i++) {
                Tmcc tmcc = (Tmcc)this.tmccs.get(i);
                service.saveTmcc(tmcc);
            }
	        addMessage("tmcc.message.savedAll",null);
			return this.getSuccessAction();
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
		return null;
	}	
	
	public void deleteChecked(){
		for(Tmcc tmcc : this.tmccs){
			if(tmcc.is_checked_flag()){
				service.delete(tmcc.getId());
			}
		}
	}
	
	public void deleteAll(){
		service.deleteAll(this.tmccs);
	}
}
