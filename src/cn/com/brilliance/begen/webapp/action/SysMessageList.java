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
import cn.com.brilliance.begen.service.SysMessageService;
import cn.com.brilliance.begen.webapp.action.BasePage;
import cn.com.brilliance.begen.common.webapp.action.ListPage;

/**
 * SysMessage对象List.
 * @author Administrator.
 *
 */
public class SysMessageList extends BasePage implements ListPage {

	private SysMessageService service = (SysMessageService)getBean("sysMessageService");
    /**
     * sysMessages.
     */
    private List<SysMessage> sysMessages;

    /**
     * dataTable.
     */
    private HtmlDataTable dataTable;

    /**
     * sysMessage.
     */
    private SysMessage sysMessage = null;

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
    public SysMessageList() {
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
     * Returns the SysMessage.
     * @return SysMessage.
     */
    public void setSysMessage(SysMessage sysMessage) {
        this.sysMessage = sysMessage;
    }

    /**
     * Sets the SysMessage.
     * @param sysMessage The sysMessage to set.
     */
    public SysMessage getSysMessage() {
        return this.sysMessage;
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
     * 获得SysMessage对象列表.
     * @return List.
     */
    public List<SysMessage> getSysMessages() {
        return this.sysMessages;
    }
	
	public void initSysMessages(){
	    try {
            if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));

            this.sysMessages = service.init(this.sysMessage,this.queryFields);
			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}

    /**
     * Sets the SysMessages.
     * @param sysMessages The SysMessages to set.
     */
    public void setSysMessages(List sysMessages) {
        this.sysMessages = sysMessages;
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
     * 删除SysMessage对象.
     * @return String.
     */
    public void delete() {
        try {
            SysMessage sysMessage = sysMessages.get(rowIndex);
            service.delete(sysMessage.getId());		
            addMessage("sysMessage.message.deleted", sysMessage.getId());		
            this.sysMessages.remove(rowIndex.intValue());
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
    }
    /**
     * 删除SysMessage对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            SysMessage sysMessage = sysMessages.get(rowIndex);

            service.delete(this.sysMessage.getId());
            addMessage("sysMessage.message.deleted", this.sysMessage.getId());				
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return null;
        }
        return null;
    }
    /**
     *    查询SysMessage对象.
     *  @return String.
     */
    public String query() {
        try {
            this.sysMessages = service.getSysMessageListOfQuery(this.queryFields);
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
		SysMessage sysMessage = new SysMessage();
		sysMessage.set_record_index(-1);		
    	sysMessage.set_edit_flag(SysMessage.EDIT_FLAG_ADD);
        this.sysMessages.add(sysMessage);
    }
	
	public void popupAdd(){
		SysMessage sysMessage = new SysMessage();
		sysMessage.set_record_index(-1);		
    	sysMessage.set_edit_flag(SysMessage.EDIT_FLAG_ADD);
    	this.getRequest().getSession().setAttribute("__pop_object", sysMessage); 	
    }
	
	public void popupEdit(){
		SysMessage sysMessage = sysMessages.get(rowIndex);
    	sysMessage.set_record_index(rowIndex);
    	if (SysMessage.EDIT_FLAG_ADD != sysMessage.get_edit_flag()){
    		sysMessage.set_edit_flag(SysMessage.EDIT_FLAG_EDIT);
    	}    	
    	this.getRequest().getSession().setAttribute("__pop_object", sysMessage); 	
	}	
	
	public void popupView(){
		SysMessage sysMessage = sysMessages.get(rowIndex.intValue());
    	this.getRequest().getSession().setAttribute("__pop_object", sysMessage); 	
	}	
    
    public void popupRefresh(){
    	SysMessage sysMessage = (SysMessage)this.getRequest().getSession().getAttribute("__pop_object");
    	if (sysMessage.get_record_index() != -1){
    		this.sysMessages.remove(sysMessage.get_record_index());
    		this.sysMessages.add(sysMessage.get_record_index(), sysMessage);
    	}
    	else{
    		this.sysMessages.add(sysMessage);
    	}
		this.getRequest().getSession().removeAttribute("__pop_object");
    }
    
    public String edit(){
        SysMessage sysMessage = sysMessages.get(rowIndex.intValue());
    	sysMessage.set_record_index(rowIndex);
    	if (SysMessage.EDIT_FLAG_ADD != sysMessage.get_edit_flag()){
    		sysMessage.set_edit_flag(SysMessage.EDIT_FLAG_EDIT);
			this.setValueBinding("#{sysMessageForm.sysMessagePrimaryKey}", sysMessage.getId());
    	}
    	return this.getSuccessAction();
    }
    
    public String view(){
        SysMessage sysMessage = sysMessages.get(rowIndex.intValue());
		this.setValueBinding("#{sysMessageForm.sysMessagePrimaryKey}", sysMessage.getId());
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
    	SysMessage sysMessage  = sysMessages.get(rowIndex.intValue());
    	if (SysMessage.EDIT_FLAG_ADD != sysMessage.get_edit_flag()){
			deleteList.add(sysMessage.getId());    	
		}
		sysMessages.remove(rowIndex.intValue());
    }	
	
    public void moveUpBuffer(){
    	int i = rowIndex;
    	int j = getMovedSysMessageIndex(i,-1);
    	if (j == -1)
    		return ;
    	SysMessage sysMessage = sysMessages.get(i);
    	sysMessages.add(j, sysMessage);
    	sysMessages.remove(i + 1);
    }	
	
    private int getMovedSysMessageIndex(int index,int step){
    	if (index + step >= 0 && index + step < sysMessages.size()){
    		SysMessage sysMessage = sysMessages.get(index + step);
    		if (SysMessage.EDIT_FLAG_DELETE == sysMessage.get_edit_flag())
    			return index + step + getMovedSysMessageIndex(index + step,step);
    		else
    			return index + step;
    	}else{
    		return -1;
    	}    	
    }	
	
    public void moveDownBuffer(){
    	int i = rowIndex;
    	int j = getMovedSysMessageIndex(i,1);
    	if (j == -1)
    		return ;
    	SysMessage sysMessage = sysMessages.get(j);
    	sysMessages.add(i, sysMessage);
    	sysMessages.remove(j + 1);
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
            for (int i=0; i < sysMessages.size(); i++) {
                SysMessage sysMessage = (SysMessage)this.sysMessages.get(i);
                service.saveSysMessage(sysMessage);
            }
	        addMessage("sysMessage.message.savedAll",null);
			return this.getSuccessAction();
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
		return null;
	}	
	
	public void deleteChecked(){
		for(SysMessage sysMessage : this.sysMessages){
			if(sysMessage.is_checked_flag()){
				service.delete(sysMessage.getId());
			}
		}
	}
	
	public void deleteAll(){
		service.deleteAll(this.sysMessages);
	}
}
