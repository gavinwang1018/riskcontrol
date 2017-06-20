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
import cn.com.brilliance.begen.service.TmchntAppService;
import cn.com.brilliance.begen.webapp.action.BasePage;
import cn.com.brilliance.begen.common.webapp.action.ListPage;

/**
 * TmchntApp对象List.
 * @author Administrator.
 *
 */
public class TmchntAppList extends BasePage implements ListPage {

	private TmchntAppService service = (TmchntAppService)getBean("tmchntAppService");
    /**
     * tmchntApps.
     */
    private List<TmchntApp> tmchntApps;

    /**
     * dataTable.
     */
    private HtmlDataTable dataTable;

    /**
     * tmchntApp.
     */
    private TmchntApp tmchntApp = null;

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
    public TmchntAppList() {
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
     * Returns the TmchntApp.
     * @return TmchntApp.
     */
    public void setTmchntApp(TmchntApp tmchntApp) {
        this.tmchntApp = tmchntApp;
    }

    /**
     * Sets the TmchntApp.
     * @param tmchntApp The tmchntApp to set.
     */
    public TmchntApp getTmchntApp() {
        return this.tmchntApp;
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
     * 获得TmchntApp对象列表.
     * @return List.
     */
    public List<TmchntApp> getTmchntApps() {
        return this.tmchntApps;
    }
	
	public void initTmchntApps(){
	    try {
            if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));

            this.tmchntApps = service.init(this.tmchntApp,this.queryFields);
			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}

    /**
     * Sets the TmchntApps.
     * @param tmchntApps The TmchntApps to set.
     */
    public void setTmchntApps(List tmchntApps) {
        this.tmchntApps = tmchntApps;
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
     * 删除TmchntApp对象.
     * @return String.
     */
    public void delete() {
        try {
            TmchntApp tmchntApp = tmchntApps.get(rowIndex);
            service.delete(tmchntApp.getId());		
            addMessage("tmchntApp.message.deleted", tmchntApp.getId());		
            this.tmchntApps.remove(rowIndex.intValue());
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
    }
    /**
     * 删除TmchntApp对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            TmchntApp tmchntApp = tmchntApps.get(rowIndex);

            service.delete(this.tmchntApp.getId());
            addMessage("tmchntApp.message.deleted", this.tmchntApp.getId());				
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return null;
        }
        return null;
    }
    /**
     *    查询TmchntApp对象.
     *  @return String.
     */
    public String query() {
        try {
            this.tmchntApps = service.getTmchntAppListOfQuery(this.queryFields);
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
		TmchntApp tmchntApp = new TmchntApp();
		tmchntApp.set_record_index(-1);		
    	tmchntApp.set_edit_flag(TmchntApp.EDIT_FLAG_ADD);
        this.tmchntApps.add(tmchntApp);
    }
	
	public void popupAdd(){
		TmchntApp tmchntApp = new TmchntApp();
		tmchntApp.set_record_index(-1);		
    	tmchntApp.set_edit_flag(TmchntApp.EDIT_FLAG_ADD);
    	this.getRequest().getSession().setAttribute("__pop_object", tmchntApp); 	
    }
	
	public void popupEdit(){
		TmchntApp tmchntApp = tmchntApps.get(rowIndex);
    	tmchntApp.set_record_index(rowIndex);
    	if (TmchntApp.EDIT_FLAG_ADD != tmchntApp.get_edit_flag()){
    		tmchntApp.set_edit_flag(TmchntApp.EDIT_FLAG_EDIT);
    	}    	
    	this.getRequest().getSession().setAttribute("__pop_object", tmchntApp); 	
	}	
	
	public void popupView(){
		TmchntApp tmchntApp = tmchntApps.get(rowIndex.intValue());
    	this.getRequest().getSession().setAttribute("__pop_object", tmchntApp); 	
	}	
    
    public void popupRefresh(){
    	TmchntApp tmchntApp = (TmchntApp)this.getRequest().getSession().getAttribute("__pop_object");
    	if (tmchntApp.get_record_index() != -1){
    		this.tmchntApps.remove(tmchntApp.get_record_index());
    		this.tmchntApps.add(tmchntApp.get_record_index(), tmchntApp);
    	}
    	else{
    		this.tmchntApps.add(tmchntApp);
    	}
		this.getRequest().getSession().removeAttribute("__pop_object");
    }
    
    public String edit(){
        TmchntApp tmchntApp = tmchntApps.get(rowIndex.intValue());
    	tmchntApp.set_record_index(rowIndex);
    	if (TmchntApp.EDIT_FLAG_ADD != tmchntApp.get_edit_flag()){
    		tmchntApp.set_edit_flag(TmchntApp.EDIT_FLAG_EDIT);
			this.setValueBinding("#{tmchntAppForm.tmchntAppPrimaryKey}", tmchntApp.getId());
    	}
    	return this.getSuccessAction();
    }
    
    public String view(){
        TmchntApp tmchntApp = tmchntApps.get(rowIndex.intValue());
		this.setValueBinding("#{tmchntAppForm.tmchntAppPrimaryKey}", tmchntApp.getId());
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
    	TmchntApp tmchntApp  = tmchntApps.get(rowIndex.intValue());
    	if (TmchntApp.EDIT_FLAG_ADD != tmchntApp.get_edit_flag()){
			deleteList.add(tmchntApp.getId());    	
		}
		tmchntApps.remove(rowIndex.intValue());
    }	
	
    public void moveUpBuffer(){
    	int i = rowIndex;
    	int j = getMovedTmchntAppIndex(i,-1);
    	if (j == -1)
    		return ;
    	TmchntApp tmchntApp = tmchntApps.get(i);
    	tmchntApps.add(j, tmchntApp);
    	tmchntApps.remove(i + 1);
    }	
	
    private int getMovedTmchntAppIndex(int index,int step){
    	if (index + step >= 0 && index + step < tmchntApps.size()){
    		TmchntApp tmchntApp = tmchntApps.get(index + step);
    		if (TmchntApp.EDIT_FLAG_DELETE == tmchntApp.get_edit_flag())
    			return index + step + getMovedTmchntAppIndex(index + step,step);
    		else
    			return index + step;
    	}else{
    		return -1;
    	}    	
    }	
	
    public void moveDownBuffer(){
    	int i = rowIndex;
    	int j = getMovedTmchntAppIndex(i,1);
    	if (j == -1)
    		return ;
    	TmchntApp tmchntApp = tmchntApps.get(j);
    	tmchntApps.add(i, tmchntApp);
    	tmchntApps.remove(j + 1);
    }	
    public void saveAllOfTorganizeInfo(String torganizeInfoid){
    	for(String id : deleteList){
    		service.delete(id);
    	}		
    	int i = 0;
		if(this.tmchntApps != null){
			for(TmchntApp tmchntApp : this.tmchntApps){    		
        		if (tmchntApp.get_edit_flag() == TmchntApp.EDIT_FLAG_ADD || tmchntApp.get_edit_flag() == TmchntApp.EDIT_FLAG_EDIT){
           			tmchntApp.setBelongToInst(torganizeInfoid);
        			i++;
        			service.saveTmchntApp(tmchntApp);
        		}
        	}
		}
    }
    public void saveAllOfTmchnt(String tmchntid){
    	for(String id : deleteList){
    		service.delete(id);
    	}		
    	int i = 0;
		if(this.tmchntApps != null){
			for(TmchntApp tmchntApp : this.tmchntApps){    		
        		if (tmchntApp.get_edit_flag() == TmchntApp.EDIT_FLAG_ADD || tmchntApp.get_edit_flag() == TmchntApp.EDIT_FLAG_EDIT){
           			tmchntApp.setMchntId(tmchntid);
        			i++;
        			service.saveTmchntApp(tmchntApp);
        		}
        	}
		}
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
            for (int i=0; i < tmchntApps.size(); i++) {
                TmchntApp tmchntApp = (TmchntApp)this.tmchntApps.get(i);
                service.saveTmchntApp(tmchntApp);
            }
	        addMessage("tmchntApp.message.savedAll",null);
			return this.getSuccessAction();
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
		return null;
	}	
	
	public void deleteChecked(){
		for(TmchntApp tmchntApp : this.tmchntApps){
			if(tmchntApp.is_checked_flag()){
				service.delete(tmchntApp.getId());
			}
		}
	}
	
	public void deleteAll(){
		service.deleteAll(this.tmchntApps);
	}
}
