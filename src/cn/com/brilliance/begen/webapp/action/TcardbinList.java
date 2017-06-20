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
import cn.com.brilliance.begen.service.TcardbinService;
import cn.com.brilliance.begen.webapp.action.BasePage;
import cn.com.brilliance.begen.common.webapp.action.ListPage;

/**
 * Tcardbin对象List.
 * @author Administrator.
 *
 */
public class TcardbinList extends BasePage implements ListPage {

	private TcardbinService service = (TcardbinService)getBean("tcardbinService");
    /**
     * tcardbins.
     */
    private List<Tcardbin> tcardbins;

    /**
     * dataTable.
     */
    private HtmlDataTable dataTable;

    /**
     * tcardbin.
     */
    private Tcardbin tcardbin = null;

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
    public TcardbinList() {
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
     * Returns the Tcardbin.
     * @return Tcardbin.
     */
    public void setTcardbin(Tcardbin tcardbin) {
        this.tcardbin = tcardbin;
    }

    /**
     * Sets the Tcardbin.
     * @param tcardbin The tcardbin to set.
     */
    public Tcardbin getTcardbin() {
        return this.tcardbin;
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
     * 获得Tcardbin对象列表.
     * @return List.
     */
    public List<Tcardbin> getTcardbins() {
        return this.tcardbins;
    }
	
	public void initTcardbins(){
	    try {
            if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));

            this.tcardbins = service.init(this.tcardbin,this.queryFields);
			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}

    /**
     * Sets the Tcardbins.
     * @param tcardbins The Tcardbins to set.
     */
    public void setTcardbins(List tcardbins) {
        this.tcardbins = tcardbins;
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
     * 删除Tcardbin对象.
     * @return String.
     */
    public void delete() {
        try {
            Tcardbin tcardbin = tcardbins.get(rowIndex);
            service.delete(tcardbin.getId());		
            addMessage("tcardbin.message.deleted", tcardbin.getId());		
            this.tcardbins.remove(rowIndex.intValue());
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
    }
    /**
     * 删除Tcardbin对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            Tcardbin tcardbin = tcardbins.get(rowIndex);

            service.delete(this.tcardbin.getId());
            addMessage("tcardbin.message.deleted", this.tcardbin.getId());				
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return null;
        }
        return null;
    }
    /**
     *    查询Tcardbin对象.
     *  @return String.
     */
    public String query() {
        try {
            this.tcardbins = service.getTcardbinListOfQuery(this.queryFields);
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
		Tcardbin tcardbin = new Tcardbin();
		tcardbin.set_record_index(-1);		
    	tcardbin.set_edit_flag(Tcardbin.EDIT_FLAG_ADD);
        this.tcardbins.add(tcardbin);
    }
	
	public void popupAdd(){
		Tcardbin tcardbin = new Tcardbin();
		tcardbin.set_record_index(-1);		
    	tcardbin.set_edit_flag(Tcardbin.EDIT_FLAG_ADD);
    	this.getRequest().getSession().setAttribute("__pop_object", tcardbin); 	
    }
	
	public void popupEdit(){
		Tcardbin tcardbin = tcardbins.get(rowIndex);
    	tcardbin.set_record_index(rowIndex);
    	if (Tcardbin.EDIT_FLAG_ADD != tcardbin.get_edit_flag()){
    		tcardbin.set_edit_flag(Tcardbin.EDIT_FLAG_EDIT);
    	}    	
    	this.getRequest().getSession().setAttribute("__pop_object", tcardbin); 	
	}	
	
	public void popupView(){
		Tcardbin tcardbin = tcardbins.get(rowIndex.intValue());
    	this.getRequest().getSession().setAttribute("__pop_object", tcardbin); 	
	}	
    
    public void popupRefresh(){
    	Tcardbin tcardbin = (Tcardbin)this.getRequest().getSession().getAttribute("__pop_object");
    	if (tcardbin.get_record_index() != -1){
    		this.tcardbins.remove(tcardbin.get_record_index());
    		this.tcardbins.add(tcardbin.get_record_index(), tcardbin);
    	}
    	else{
    		this.tcardbins.add(tcardbin);
    	}
		this.getRequest().getSession().removeAttribute("__pop_object");
    }
    
    public String edit(){
        Tcardbin tcardbin = tcardbins.get(rowIndex.intValue());
    	tcardbin.set_record_index(rowIndex);
    	if (Tcardbin.EDIT_FLAG_ADD != tcardbin.get_edit_flag()){
    		tcardbin.set_edit_flag(Tcardbin.EDIT_FLAG_EDIT);
			this.setValueBinding("#{tcardbinForm.tcardbinPrimaryKey}", tcardbin.getId());
    	}
    	return this.getSuccessAction();
    }
    
    public String view(){
        Tcardbin tcardbin = tcardbins.get(rowIndex.intValue());
		this.setValueBinding("#{tcardbinForm.tcardbinPrimaryKey}", tcardbin.getId());
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
    	Tcardbin tcardbin  = tcardbins.get(rowIndex.intValue());
    	if (Tcardbin.EDIT_FLAG_ADD != tcardbin.get_edit_flag()){
			deleteList.add(tcardbin.getId());    	
		}
		tcardbins.remove(rowIndex.intValue());
    }	
	
    public void moveUpBuffer(){
    	int i = rowIndex;
    	int j = getMovedTcardbinIndex(i,-1);
    	if (j == -1)
    		return ;
    	Tcardbin tcardbin = tcardbins.get(i);
    	tcardbins.add(j, tcardbin);
    	tcardbins.remove(i + 1);
    }	
	
    private int getMovedTcardbinIndex(int index,int step){
    	if (index + step >= 0 && index + step < tcardbins.size()){
    		Tcardbin tcardbin = tcardbins.get(index + step);
    		if (Tcardbin.EDIT_FLAG_DELETE == tcardbin.get_edit_flag())
    			return index + step + getMovedTcardbinIndex(index + step,step);
    		else
    			return index + step;
    	}else{
    		return -1;
    	}    	
    }	
	
    public void moveDownBuffer(){
    	int i = rowIndex;
    	int j = getMovedTcardbinIndex(i,1);
    	if (j == -1)
    		return ;
    	Tcardbin tcardbin = tcardbins.get(j);
    	tcardbins.add(i, tcardbin);
    	tcardbins.remove(j + 1);
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
            for (int i=0; i < tcardbins.size(); i++) {
                Tcardbin tcardbin = (Tcardbin)this.tcardbins.get(i);
                service.saveTcardbin(tcardbin);
            }
	        addMessage("tcardbin.message.savedAll",null);
			return this.getSuccessAction();
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
		return null;
	}	
	
	public void deleteChecked(){
		for(Tcardbin tcardbin : this.tcardbins){
			if(tcardbin.is_checked_flag()){
				service.delete(tcardbin.getId());
			}
		}
	}
	
	public void deleteAll(){
		service.deleteAll(this.tcardbins);
	}
}
