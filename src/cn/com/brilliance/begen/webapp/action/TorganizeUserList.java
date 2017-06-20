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
import cn.com.brilliance.begen.service.TorganizeUserService;
import cn.com.brilliance.begen.webapp.action.BasePage;
import cn.com.brilliance.begen.common.webapp.action.ListPage;

/**
 * TorganizeUser对象List.
 * @author Administrator.
 *
 */
public class TorganizeUserList extends BasePage implements ListPage {

	private TorganizeUserService service = (TorganizeUserService)getBean("torganizeUserService");
    /**
     * torganizeUsers.
     */
    private List<TorganizeUser> torganizeUsers;

    /**
     * dataTable.
     */
    private HtmlDataTable dataTable;

    /**
     * torganizeUser.
     */
    private TorganizeUser torganizeUser = null;

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
    public TorganizeUserList() {
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
     * Returns the TorganizeUser.
     * @return TorganizeUser.
     */
    public void setTorganizeUser(TorganizeUser torganizeUser) {
        this.torganizeUser = torganizeUser;
    }

    /**
     * Sets the TorganizeUser.
     * @param torganizeUser The torganizeUser to set.
     */
    public TorganizeUser getTorganizeUser() {
        return this.torganizeUser;
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
     * 获得TorganizeUser对象列表.
     * @return List.
     */
    public List<TorganizeUser> getTorganizeUsers() {
        return this.torganizeUsers;
    }
	
	public void initTorganizeUsers(){
	    try {
            if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));

            this.torganizeUsers = service.init(this.torganizeUser,this.queryFields);
			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}

    /**
     * Sets the TorganizeUsers.
     * @param torganizeUsers The TorganizeUsers to set.
     */
    public void setTorganizeUsers(List torganizeUsers) {
        this.torganizeUsers = torganizeUsers;
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
     * 删除TorganizeUser对象.
     * @return String.
     */
    public void delete() {
        try {
            TorganizeUser torganizeUser = torganizeUsers.get(rowIndex);
            service.delete(torganizeUser.getId());		
            addMessage("torganizeUser.message.deleted", torganizeUser.getId());		
            this.torganizeUsers.remove(rowIndex.intValue());
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
    }
    /**
     * 删除TorganizeUser对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            TorganizeUser torganizeUser = torganizeUsers.get(rowIndex);

            service.delete(this.torganizeUser.getId());
            addMessage("torganizeUser.message.deleted", this.torganizeUser.getId());				
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return null;
        }
        return null;
    }
    /**
     *    查询TorganizeUser对象.
     *  @return String.
     */
    public String query() {
        try {
            this.torganizeUsers = service.getTorganizeUserListOfQuery(this.queryFields);
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
		TorganizeUser torganizeUser = new TorganizeUser();
		torganizeUser.set_record_index(-1);		
    	torganizeUser.set_edit_flag(TorganizeUser.EDIT_FLAG_ADD);
        this.torganizeUsers.add(torganizeUser);
    }
	
	public void popupAdd(){
		TorganizeUser torganizeUser = new TorganizeUser();
		torganizeUser.set_record_index(-1);		
    	torganizeUser.set_edit_flag(TorganizeUser.EDIT_FLAG_ADD);
    	this.getRequest().getSession().setAttribute("__pop_object", torganizeUser); 	
    }
	
	public void popupEdit(){
		TorganizeUser torganizeUser = torganizeUsers.get(rowIndex);
    	torganizeUser.set_record_index(rowIndex);
    	if (TorganizeUser.EDIT_FLAG_ADD != torganizeUser.get_edit_flag()){
    		torganizeUser.set_edit_flag(TorganizeUser.EDIT_FLAG_EDIT);
    	}    	
    	this.getRequest().getSession().setAttribute("__pop_object", torganizeUser); 	
	}	
	
	public void popupView(){
		TorganizeUser torganizeUser = torganizeUsers.get(rowIndex.intValue());
    	this.getRequest().getSession().setAttribute("__pop_object", torganizeUser); 	
	}	
    
    public void popupRefresh(){
    	TorganizeUser torganizeUser = (TorganizeUser)this.getRequest().getSession().getAttribute("__pop_object");
    	if (torganizeUser.get_record_index() != -1){
    		this.torganizeUsers.remove(torganizeUser.get_record_index());
    		this.torganizeUsers.add(torganizeUser.get_record_index(), torganizeUser);
    	}
    	else{
    		this.torganizeUsers.add(torganizeUser);
    	}
		this.getRequest().getSession().removeAttribute("__pop_object");
    }
    
    public String edit(){
        TorganizeUser torganizeUser = torganizeUsers.get(rowIndex.intValue());
    	torganizeUser.set_record_index(rowIndex);
    	if (TorganizeUser.EDIT_FLAG_ADD != torganizeUser.get_edit_flag()){
    		torganizeUser.set_edit_flag(TorganizeUser.EDIT_FLAG_EDIT);
			this.setValueBinding("#{torganizeUserForm.torganizeUserPrimaryKey}", torganizeUser.getId());
    	}
    	return this.getSuccessAction();
    }
    
    public String view(){
        TorganizeUser torganizeUser = torganizeUsers.get(rowIndex.intValue());
		this.setValueBinding("#{torganizeUserForm.torganizeUserPrimaryKey}", torganizeUser.getId());
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
    	TorganizeUser torganizeUser  = torganizeUsers.get(rowIndex.intValue());
    	if (TorganizeUser.EDIT_FLAG_ADD != torganizeUser.get_edit_flag()){
			deleteList.add(torganizeUser.getId());    	
		}
		torganizeUsers.remove(rowIndex.intValue());
    }	
	
    public void moveUpBuffer(){
    	int i = rowIndex;
    	int j = getMovedTorganizeUserIndex(i,-1);
    	if (j == -1)
    		return ;
    	TorganizeUser torganizeUser = torganizeUsers.get(i);
    	torganizeUsers.add(j, torganizeUser);
    	torganizeUsers.remove(i + 1);
    }	
	
    private int getMovedTorganizeUserIndex(int index,int step){
    	if (index + step >= 0 && index + step < torganizeUsers.size()){
    		TorganizeUser torganizeUser = torganizeUsers.get(index + step);
    		if (TorganizeUser.EDIT_FLAG_DELETE == torganizeUser.get_edit_flag())
    			return index + step + getMovedTorganizeUserIndex(index + step,step);
    		else
    			return index + step;
    	}else{
    		return -1;
    	}    	
    }	
	
    public void moveDownBuffer(){
    	int i = rowIndex;
    	int j = getMovedTorganizeUserIndex(i,1);
    	if (j == -1)
    		return ;
    	TorganizeUser torganizeUser = torganizeUsers.get(j);
    	torganizeUsers.add(i, torganizeUser);
    	torganizeUsers.remove(j + 1);
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
            for (int i=0; i < torganizeUsers.size(); i++) {
                TorganizeUser torganizeUser = (TorganizeUser)this.torganizeUsers.get(i);
                service.saveTorganizeUser(torganizeUser);
            }
	        addMessage("torganizeUser.message.savedAll",null);
			return this.getSuccessAction();
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
		return null;
	}	
	
	public void deleteChecked(){
		for(TorganizeUser torganizeUser : this.torganizeUsers){
			if(torganizeUser.is_checked_flag()){
				service.delete(torganizeUser.getId());
			}
		}
	}
	
	public void deleteAll(){
		service.deleteAll(this.torganizeUsers);
	}
}
