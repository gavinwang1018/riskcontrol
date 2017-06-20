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
import cn.com.brilliance.begen.service.TpermissionService;
import cn.com.brilliance.begen.webapp.action.BasePage;
import cn.com.brilliance.begen.common.webapp.action.ListPage;

/**
 * Tpermission对象List.
 * @author Administrator.
 *
 */
public class TpermissionList extends BasePage implements ListPage {

	private TpermissionService service = (TpermissionService)getBean("tpermissionService");
    /**
     * tpermissions.
     */
    private List<Tpermission> tpermissions;

    /**
     * dataTable.
     */
    private HtmlDataTable dataTable;

    /**
     * tpermission.
     */
    private Tpermission tpermission = null;

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
    public TpermissionList() {
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
     * Returns the Tpermission.
     * @return Tpermission.
     */
    public void setTpermission(Tpermission tpermission) {
        this.tpermission = tpermission;
    }

    /**
     * Sets the Tpermission.
     * @param tpermission The tpermission to set.
     */
    public Tpermission getTpermission() {
        return this.tpermission;
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
     * 获得Tpermission对象列表.
     * @return List.
     */
    public List<Tpermission> getTpermissions() {
        return this.tpermissions;
    }
	
	public void initTpermissions(){
	    try {
            if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));

            this.tpermissions = service.init(this.tpermission,this.queryFields);
			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}

    /**
     * Sets the Tpermissions.
     * @param tpermissions The Tpermissions to set.
     */
    public void setTpermissions(List tpermissions) {
        this.tpermissions = tpermissions;
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
     * 删除Tpermission对象.
     * @return String.
     */
    public void delete() {
        try {
            Tpermission tpermission = tpermissions.get(rowIndex);
            service.delete(tpermission.getId());		
            addMessage("tpermission.message.deleted", tpermission.getId());		
            this.tpermissions.remove(rowIndex.intValue());
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
    }
    /**
     * 删除Tpermission对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            Tpermission tpermission = tpermissions.get(rowIndex);

            service.delete(this.tpermission.getId());
            addMessage("tpermission.message.deleted", this.tpermission.getId());				
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return null;
        }
        return null;
    }
    /**
     *    查询Tpermission对象.
     *  @return String.
     */
    public String query() {
        try {
            this.tpermissions = service.getTpermissionListOfQuery(this.queryFields);
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
		Tpermission tpermission = new Tpermission();
		tpermission.set_record_index(-1);		
    	tpermission.set_edit_flag(Tpermission.EDIT_FLAG_ADD);
        this.tpermissions.add(tpermission);
    }
	
	public void popupAdd(){
		Tpermission tpermission = new Tpermission();
		tpermission.set_record_index(-1);		
    	tpermission.set_edit_flag(Tpermission.EDIT_FLAG_ADD);
    	this.getRequest().getSession().setAttribute("__pop_object", tpermission); 	
    }
	
	public void popupEdit(){
		Tpermission tpermission = tpermissions.get(rowIndex);
    	tpermission.set_record_index(rowIndex);
    	if (Tpermission.EDIT_FLAG_ADD != tpermission.get_edit_flag()){
    		tpermission.set_edit_flag(Tpermission.EDIT_FLAG_EDIT);
    	}    	
    	this.getRequest().getSession().setAttribute("__pop_object", tpermission); 	
	}	
	
	public void popupView(){
		Tpermission tpermission = tpermissions.get(rowIndex.intValue());
    	this.getRequest().getSession().setAttribute("__pop_object", tpermission); 	
	}	
    
    public void popupRefresh(){
    	Tpermission tpermission = (Tpermission)this.getRequest().getSession().getAttribute("__pop_object");
    	if (tpermission.get_record_index() != -1){
    		this.tpermissions.remove(tpermission.get_record_index());
    		this.tpermissions.add(tpermission.get_record_index(), tpermission);
    	}
    	else{
    		this.tpermissions.add(tpermission);
    	}
		this.getRequest().getSession().removeAttribute("__pop_object");
    }
    
    public String edit(){
        Tpermission tpermission = tpermissions.get(rowIndex.intValue());
    	tpermission.set_record_index(rowIndex);
    	if (Tpermission.EDIT_FLAG_ADD != tpermission.get_edit_flag()){
    		tpermission.set_edit_flag(Tpermission.EDIT_FLAG_EDIT);
			this.setValueBinding("#{tpermissionForm.tpermissionPrimaryKey}", tpermission.getId());
    	}
    	return this.getSuccessAction();
    }
    
    public String view(){
        Tpermission tpermission = tpermissions.get(rowIndex.intValue());
		this.setValueBinding("#{tpermissionForm.tpermissionPrimaryKey}", tpermission.getId());
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
    	Tpermission tpermission  = tpermissions.get(rowIndex.intValue());
    	if (Tpermission.EDIT_FLAG_ADD != tpermission.get_edit_flag()){
			deleteList.add(tpermission.getId());    	
		}
		tpermissions.remove(rowIndex.intValue());
    }	
	
    public void moveUpBuffer(){
    	int i = rowIndex;
    	int j = getMovedTpermissionIndex(i,-1);
    	if (j == -1)
    		return ;
    	Tpermission tpermission = tpermissions.get(i);
    	tpermissions.add(j, tpermission);
    	tpermissions.remove(i + 1);
    }	
	
    private int getMovedTpermissionIndex(int index,int step){
    	if (index + step >= 0 && index + step < tpermissions.size()){
    		Tpermission tpermission = tpermissions.get(index + step);
    		if (Tpermission.EDIT_FLAG_DELETE == tpermission.get_edit_flag())
    			return index + step + getMovedTpermissionIndex(index + step,step);
    		else
    			return index + step;
    	}else{
    		return -1;
    	}    	
    }	
	
    public void moveDownBuffer(){
    	int i = rowIndex;
    	int j = getMovedTpermissionIndex(i,1);
    	if (j == -1)
    		return ;
    	Tpermission tpermission = tpermissions.get(j);
    	tpermissions.add(i, tpermission);
    	tpermissions.remove(j + 1);
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
            for (int i=0; i < tpermissions.size(); i++) {
                Tpermission tpermission = (Tpermission)this.tpermissions.get(i);
                service.saveTpermission(tpermission);
            }
	        addMessage("tpermission.message.savedAll",null);
			return this.getSuccessAction();
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
		return null;
	}	
	
	public void deleteChecked(){
		for(Tpermission tpermission : this.tpermissions){
			if(tpermission.is_checked_flag()){
				service.delete(tpermission.getId());
			}
		}
	}
	
	public void deleteAll(){
		service.deleteAll(this.tpermissions);
	}
}
