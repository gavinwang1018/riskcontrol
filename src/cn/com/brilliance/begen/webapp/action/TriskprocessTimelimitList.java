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
import cn.com.brilliance.begen.service.TriskprocessTimelimitService;
import cn.com.brilliance.begen.webapp.action.BasePage;
import cn.com.brilliance.begen.common.webapp.action.ListPage;

/**
 * TriskprocessTimelimit对象List.
 * @author Administrator.
 *
 */
public class TriskprocessTimelimitList extends BasePage implements ListPage {

	private TriskprocessTimelimitService service = (TriskprocessTimelimitService)getBean("triskprocessTimelimitService");
    /**
     * triskprocessTimelimits.
     */
    private List<TriskprocessTimelimit> triskprocessTimelimits;

    /**
     * dataTable.
     */
    private HtmlDataTable dataTable;

    /**
     * triskprocessTimelimit.
     */
    private TriskprocessTimelimit triskprocessTimelimit = null;

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
    public TriskprocessTimelimitList() {
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
     * Returns the TriskprocessTimelimit.
     * @return TriskprocessTimelimit.
     */
    public void setTriskprocessTimelimit(TriskprocessTimelimit triskprocessTimelimit) {
        this.triskprocessTimelimit = triskprocessTimelimit;
    }

    /**
     * Sets the TriskprocessTimelimit.
     * @param triskprocessTimelimit The triskprocessTimelimit to set.
     */
    public TriskprocessTimelimit getTriskprocessTimelimit() {
        return this.triskprocessTimelimit;
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
     * 获得TriskprocessTimelimit对象列表.
     * @return List.
     */
    public List<TriskprocessTimelimit> getTriskprocessTimelimits() {
        return this.triskprocessTimelimits;
    }
	
	public void initTriskprocessTimelimits(){
	    try {
            if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));

            this.triskprocessTimelimits = service.init(this.triskprocessTimelimit,this.queryFields);
			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}

    /**
     * Sets the TriskprocessTimelimits.
     * @param triskprocessTimelimits The TriskprocessTimelimits to set.
     */
    public void setTriskprocessTimelimits(List triskprocessTimelimits) {
        this.triskprocessTimelimits = triskprocessTimelimits;
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
     * 删除TriskprocessTimelimit对象.
     * @return String.
     */
    public void delete() {
        try {
            TriskprocessTimelimit triskprocessTimelimit = triskprocessTimelimits.get(rowIndex);
            service.delete(triskprocessTimelimit.getId());		
            addMessage("triskprocessTimelimit.message.deleted", triskprocessTimelimit.getId());		
            this.triskprocessTimelimits.remove(rowIndex.intValue());
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
    }
    /**
     * 删除TriskprocessTimelimit对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            TriskprocessTimelimit triskprocessTimelimit = triskprocessTimelimits.get(rowIndex);

            service.delete(this.triskprocessTimelimit.getId());
            addMessage("triskprocessTimelimit.message.deleted", this.triskprocessTimelimit.getId());				
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return null;
        }
        return null;
    }
    /**
     *    查询TriskprocessTimelimit对象.
     *  @return String.
     */
    public String query() {
        try {
            this.triskprocessTimelimits = service.getTriskprocessTimelimitListOfQuery(this.queryFields);
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
		TriskprocessTimelimit triskprocessTimelimit = new TriskprocessTimelimit();
		triskprocessTimelimit.set_record_index(-1);		
    	triskprocessTimelimit.set_edit_flag(TriskprocessTimelimit.EDIT_FLAG_ADD);
        this.triskprocessTimelimits.add(triskprocessTimelimit);
    }
	
	public void popupAdd(){
		TriskprocessTimelimit triskprocessTimelimit = new TriskprocessTimelimit();
		triskprocessTimelimit.set_record_index(-1);		
    	triskprocessTimelimit.set_edit_flag(TriskprocessTimelimit.EDIT_FLAG_ADD);
    	this.getRequest().getSession().setAttribute("__pop_object", triskprocessTimelimit); 	
    }
	
	public void popupEdit(){
		TriskprocessTimelimit triskprocessTimelimit = triskprocessTimelimits.get(rowIndex);
    	triskprocessTimelimit.set_record_index(rowIndex);
    	if (TriskprocessTimelimit.EDIT_FLAG_ADD != triskprocessTimelimit.get_edit_flag()){
    		triskprocessTimelimit.set_edit_flag(TriskprocessTimelimit.EDIT_FLAG_EDIT);
    	}    	
    	this.getRequest().getSession().setAttribute("__pop_object", triskprocessTimelimit); 	
	}	
	
	public void popupView(){
		TriskprocessTimelimit triskprocessTimelimit = triskprocessTimelimits.get(rowIndex.intValue());
    	this.getRequest().getSession().setAttribute("__pop_object", triskprocessTimelimit); 	
	}	
    
    public void popupRefresh(){
    	TriskprocessTimelimit triskprocessTimelimit = (TriskprocessTimelimit)this.getRequest().getSession().getAttribute("__pop_object");
    	if (triskprocessTimelimit.get_record_index() != -1){
    		this.triskprocessTimelimits.remove(triskprocessTimelimit.get_record_index());
    		this.triskprocessTimelimits.add(triskprocessTimelimit.get_record_index(), triskprocessTimelimit);
    	}
    	else{
    		this.triskprocessTimelimits.add(triskprocessTimelimit);
    	}
		this.getRequest().getSession().removeAttribute("__pop_object");
    }
    
    public String edit(){
        TriskprocessTimelimit triskprocessTimelimit = triskprocessTimelimits.get(rowIndex.intValue());
    	triskprocessTimelimit.set_record_index(rowIndex);
    	if (TriskprocessTimelimit.EDIT_FLAG_ADD != triskprocessTimelimit.get_edit_flag()){
    		triskprocessTimelimit.set_edit_flag(TriskprocessTimelimit.EDIT_FLAG_EDIT);
			this.setValueBinding("#{triskprocessTimelimitForm.triskprocessTimelimitPrimaryKey}", triskprocessTimelimit.getId());
    	}
    	return this.getSuccessAction();
    }
    
    public String view(){
        TriskprocessTimelimit triskprocessTimelimit = triskprocessTimelimits.get(rowIndex.intValue());
		this.setValueBinding("#{triskprocessTimelimitForm.triskprocessTimelimitPrimaryKey}", triskprocessTimelimit.getId());
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
    	TriskprocessTimelimit triskprocessTimelimit  = triskprocessTimelimits.get(rowIndex.intValue());
    	if (TriskprocessTimelimit.EDIT_FLAG_ADD != triskprocessTimelimit.get_edit_flag()){
			deleteList.add(triskprocessTimelimit.getId());    	
		}
		triskprocessTimelimits.remove(rowIndex.intValue());
    }	
	
    public void moveUpBuffer(){
    	int i = rowIndex;
    	int j = getMovedTriskprocessTimelimitIndex(i,-1);
    	if (j == -1)
    		return ;
    	TriskprocessTimelimit triskprocessTimelimit = triskprocessTimelimits.get(i);
    	triskprocessTimelimits.add(j, triskprocessTimelimit);
    	triskprocessTimelimits.remove(i + 1);
    }	
	
    private int getMovedTriskprocessTimelimitIndex(int index,int step){
    	if (index + step >= 0 && index + step < triskprocessTimelimits.size()){
    		TriskprocessTimelimit triskprocessTimelimit = triskprocessTimelimits.get(index + step);
    		if (TriskprocessTimelimit.EDIT_FLAG_DELETE == triskprocessTimelimit.get_edit_flag())
    			return index + step + getMovedTriskprocessTimelimitIndex(index + step,step);
    		else
    			return index + step;
    	}else{
    		return -1;
    	}    	
    }	
	
    public void moveDownBuffer(){
    	int i = rowIndex;
    	int j = getMovedTriskprocessTimelimitIndex(i,1);
    	if (j == -1)
    		return ;
    	TriskprocessTimelimit triskprocessTimelimit = triskprocessTimelimits.get(j);
    	triskprocessTimelimits.add(i, triskprocessTimelimit);
    	triskprocessTimelimits.remove(j + 1);
    }	
    public void saveAllOfTorganizeInfo(String torganizeInfoid){
    	for(String id : deleteList){
    		service.delete(id);
    	}		
    	int i = 0;
		if(this.triskprocessTimelimits != null){
			for(TriskprocessTimelimit triskprocessTimelimit : this.triskprocessTimelimits){    		
        		if (triskprocessTimelimit.get_edit_flag() == TriskprocessTimelimit.EDIT_FLAG_ADD || triskprocessTimelimit.get_edit_flag() == TriskprocessTimelimit.EDIT_FLAG_EDIT){
           			triskprocessTimelimit.setBelongToInst(torganizeInfoid);
        			i++;
        			service.saveTriskprocessTimelimit(triskprocessTimelimit);
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
            for (int i=0; i < triskprocessTimelimits.size(); i++) {
                TriskprocessTimelimit triskprocessTimelimit = (TriskprocessTimelimit)this.triskprocessTimelimits.get(i);
                service.saveTriskprocessTimelimit(triskprocessTimelimit);
            }
	        addMessage("triskprocessTimelimit.message.savedAll",null);
			return this.getSuccessAction();
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
		return null;
	}	
	
	public void deleteChecked(){
		for(TriskprocessTimelimit triskprocessTimelimit : this.triskprocessTimelimits){
			if(triskprocessTimelimit.is_checked_flag()){
				service.delete(triskprocessTimelimit.getId());
			}
		}
	}
	
	public void deleteAll(){
		service.deleteAll(this.triskprocessTimelimits);
	}
}
