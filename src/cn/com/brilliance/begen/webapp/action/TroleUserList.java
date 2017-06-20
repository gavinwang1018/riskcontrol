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
import cn.com.brilliance.begen.service.TroleUserService;
import cn.com.brilliance.begen.webapp.action.BasePage;
import cn.com.brilliance.begen.common.webapp.action.ListPage;

/**
 * TroleUser对象List.
 * @author Administrator.
 *
 */
public class TroleUserList extends BasePage implements ListPage {

	private TroleUserService service = (TroleUserService)getBean("troleUserService");
    /**
     * troleUsers.
     */
    private List<TroleUser> troleUsers;

    /**
     * dataTable.
     */
    private HtmlDataTable dataTable;

    /**
     * troleUser.
     */
    private TroleUser troleUser = null;

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
    public TroleUserList() {
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
     * Returns the TroleUser.
     * @return TroleUser.
     */
    public void setTroleUser(TroleUser troleUser) {
        this.troleUser = troleUser;
    }

    /**
     * Sets the TroleUser.
     * @param troleUser The troleUser to set.
     */
    public TroleUser getTroleUser() {
        return this.troleUser;
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
     * 获得TroleUser对象列表.
     * @return List.
     */
    public List<TroleUser> getTroleUsers() {
        return this.troleUsers;
    }
	
	public void initTroleUsers(){
	    try {
            if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));

            this.troleUsers = service.init(this.troleUser,this.queryFields);
			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}

    /**
     * Sets the TroleUsers.
     * @param troleUsers The TroleUsers to set.
     */
    public void setTroleUsers(List troleUsers) {
        this.troleUsers = troleUsers;
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
     * 删除TroleUser对象.
     * @return String.
     */
    public void delete() {
        try {
            TroleUser troleUser = troleUsers.get(rowIndex);
            service.delete(troleUser.getId());		
            addMessage("troleUser.message.deleted", troleUser.getId());		
            this.troleUsers.remove(rowIndex.intValue());
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
    }
    /**
     * 删除TroleUser对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            TroleUser troleUser = troleUsers.get(rowIndex);

            service.delete(this.troleUser.getId());
            addMessage("troleUser.message.deleted", this.troleUser.getId());				
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return null;
        }
        return null;
    }
    /**
     *    查询TroleUser对象.
     *  @return String.
     */
    public String query() {
        try {
            this.troleUsers = service.getTroleUserListOfQuery(this.queryFields);
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
		TroleUser troleUser = new TroleUser();
		troleUser.set_record_index(-1);		
    	troleUser.set_edit_flag(TroleUser.EDIT_FLAG_ADD);
        this.troleUsers.add(troleUser);
    }
	
	public void popupAdd(){
		TroleUser troleUser = new TroleUser();
		troleUser.set_record_index(-1);		
    	troleUser.set_edit_flag(TroleUser.EDIT_FLAG_ADD);
    	this.getRequest().getSession().setAttribute("__pop_object", troleUser); 	
    }
	
	public void popupEdit(){
		TroleUser troleUser = troleUsers.get(rowIndex);
    	troleUser.set_record_index(rowIndex);
    	if (TroleUser.EDIT_FLAG_ADD != troleUser.get_edit_flag()){
    		troleUser.set_edit_flag(TroleUser.EDIT_FLAG_EDIT);
    	}    	
    	this.getRequest().getSession().setAttribute("__pop_object", troleUser); 	
	}	
	
	public void popupView(){
		TroleUser troleUser = troleUsers.get(rowIndex.intValue());
    	this.getRequest().getSession().setAttribute("__pop_object", troleUser); 	
	}	
    
    public void popupRefresh(){
    	TroleUser troleUser = (TroleUser)this.getRequest().getSession().getAttribute("__pop_object");
    	if (troleUser.get_record_index() != -1){
    		this.troleUsers.remove(troleUser.get_record_index());
    		this.troleUsers.add(troleUser.get_record_index(), troleUser);
    	}
    	else{
    		this.troleUsers.add(troleUser);
    	}
		this.getRequest().getSession().removeAttribute("__pop_object");
    }
    
    public String edit(){
        TroleUser troleUser = troleUsers.get(rowIndex.intValue());
    	troleUser.set_record_index(rowIndex);
    	if (TroleUser.EDIT_FLAG_ADD != troleUser.get_edit_flag()){
    		troleUser.set_edit_flag(TroleUser.EDIT_FLAG_EDIT);
			this.setValueBinding("#{troleUserForm.troleUserPrimaryKey}", troleUser.getId());
    	}
    	return this.getSuccessAction();
    }
    
    public String view(){
        TroleUser troleUser = troleUsers.get(rowIndex.intValue());
		this.setValueBinding("#{troleUserForm.troleUserPrimaryKey}", troleUser.getId());
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
    	TroleUser troleUser  = troleUsers.get(rowIndex.intValue());
    	if (TroleUser.EDIT_FLAG_ADD != troleUser.get_edit_flag()){
			deleteList.add(troleUser.getId());    	
		}
		troleUsers.remove(rowIndex.intValue());
    }	
	
    public void moveUpBuffer(){
    	int i = rowIndex;
    	int j = getMovedTroleUserIndex(i,-1);
    	if (j == -1)
    		return ;
    	TroleUser troleUser = troleUsers.get(i);
    	troleUsers.add(j, troleUser);
    	troleUsers.remove(i + 1);
    }	
	
    private int getMovedTroleUserIndex(int index,int step){
    	if (index + step >= 0 && index + step < troleUsers.size()){
    		TroleUser troleUser = troleUsers.get(index + step);
    		if (TroleUser.EDIT_FLAG_DELETE == troleUser.get_edit_flag())
    			return index + step + getMovedTroleUserIndex(index + step,step);
    		else
    			return index + step;
    	}else{
    		return -1;
    	}    	
    }	
	
    public void moveDownBuffer(){
    	int i = rowIndex;
    	int j = getMovedTroleUserIndex(i,1);
    	if (j == -1)
    		return ;
    	TroleUser troleUser = troleUsers.get(j);
    	troleUsers.add(i, troleUser);
    	troleUsers.remove(j + 1);
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
            for (int i=0; i < troleUsers.size(); i++) {
                TroleUser troleUser = (TroleUser)this.troleUsers.get(i);
                service.saveTroleUser(troleUser);
            }
	        addMessage("troleUser.message.savedAll",null);
			return this.getSuccessAction();
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
		return null;
	}	
	
	public void deleteChecked(){
		for(TroleUser troleUser : this.troleUsers){
			if(troleUser.is_checked_flag()){
				service.delete(troleUser.getId());
			}
		}
	}
	
	public void deleteAll(){
		service.deleteAll(this.troleUsers);
	}
}
