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
import cn.com.brilliance.begen.service.SysWorkflowInsTaskService;
import cn.com.brilliance.begen.webapp.action.BasePage;
import cn.com.brilliance.begen.common.webapp.action.ListPage;

/**
 * SysWorkflowInsTask对象List.
 * @author Administrator.
 *
 */
public class SysWorkflowInsTaskList extends BasePage implements ListPage {

	private SysWorkflowInsTaskService service = (SysWorkflowInsTaskService)getBean("sysWorkflowInsTaskService");
    /**
     * sysWorkflowInsTasks.
     */
    private List<SysWorkflowInsTask> sysWorkflowInsTasks;

    /**
     * dataTable.
     */
    private HtmlDataTable dataTable;

    /**
     * sysWorkflowInsTask.
     */
    private SysWorkflowInsTask sysWorkflowInsTask = null;

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
    public SysWorkflowInsTaskList() {
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
     * Returns the SysWorkflowInsTask.
     * @return SysWorkflowInsTask.
     */
    public void setSysWorkflowInsTask(SysWorkflowInsTask sysWorkflowInsTask) {
        this.sysWorkflowInsTask = sysWorkflowInsTask;
    }

    /**
     * Sets the SysWorkflowInsTask.
     * @param sysWorkflowInsTask The sysWorkflowInsTask to set.
     */
    public SysWorkflowInsTask getSysWorkflowInsTask() {
        return this.sysWorkflowInsTask;
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
     * 获得SysWorkflowInsTask对象列表.
     * @return List.
     */
    public List<SysWorkflowInsTask> getSysWorkflowInsTasks() {
        return this.sysWorkflowInsTasks;
    }
	
	public void initSysWorkflowInsTasks(){
	    try {
            if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));

            this.sysWorkflowInsTasks = service.init(this.sysWorkflowInsTask,this.queryFields);
			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}

    /**
     * Sets the SysWorkflowInsTasks.
     * @param sysWorkflowInsTasks The SysWorkflowInsTasks to set.
     */
    public void setSysWorkflowInsTasks(List sysWorkflowInsTasks) {
        this.sysWorkflowInsTasks = sysWorkflowInsTasks;
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
     * 删除SysWorkflowInsTask对象.
     * @return String.
     */
    public void delete() {
        try {
            SysWorkflowInsTask sysWorkflowInsTask = sysWorkflowInsTasks.get(rowIndex);
            service.delete(sysWorkflowInsTask.getId());		
            addMessage("sysWorkflowInsTask.message.deleted", sysWorkflowInsTask.getId());		
            this.sysWorkflowInsTasks.remove(rowIndex.intValue());
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
    }
    /**
     * 删除SysWorkflowInsTask对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            SysWorkflowInsTask sysWorkflowInsTask = sysWorkflowInsTasks.get(rowIndex);

            service.delete(this.sysWorkflowInsTask.getId());
            addMessage("sysWorkflowInsTask.message.deleted", this.sysWorkflowInsTask.getId());				
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return null;
        }
        return null;
    }
    /**
     *    查询SysWorkflowInsTask对象.
     *  @return String.
     */
    public String query() {
        try {
            this.sysWorkflowInsTasks = service.getSysWorkflowInsTaskListOfQuery(this.queryFields);
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
		SysWorkflowInsTask sysWorkflowInsTask = new SysWorkflowInsTask();
		sysWorkflowInsTask.set_record_index(-1);		
    	sysWorkflowInsTask.set_edit_flag(SysWorkflowInsTask.EDIT_FLAG_ADD);
        this.sysWorkflowInsTasks.add(sysWorkflowInsTask);
    }
	
	public void popupAdd(){
		SysWorkflowInsTask sysWorkflowInsTask = new SysWorkflowInsTask();
		sysWorkflowInsTask.set_record_index(-1);		
    	sysWorkflowInsTask.set_edit_flag(SysWorkflowInsTask.EDIT_FLAG_ADD);
    	this.getRequest().getSession().setAttribute("__pop_object", sysWorkflowInsTask); 	
    }
	
	public void popupEdit(){
		SysWorkflowInsTask sysWorkflowInsTask = sysWorkflowInsTasks.get(rowIndex);
    	sysWorkflowInsTask.set_record_index(rowIndex);
    	if (SysWorkflowInsTask.EDIT_FLAG_ADD != sysWorkflowInsTask.get_edit_flag()){
    		sysWorkflowInsTask.set_edit_flag(SysWorkflowInsTask.EDIT_FLAG_EDIT);
    	}    	
    	this.getRequest().getSession().setAttribute("__pop_object", sysWorkflowInsTask); 	
	}	
	
	public void popupView(){
		SysWorkflowInsTask sysWorkflowInsTask = sysWorkflowInsTasks.get(rowIndex.intValue());
    	this.getRequest().getSession().setAttribute("__pop_object", sysWorkflowInsTask); 	
	}	
    
    public void popupRefresh(){
    	SysWorkflowInsTask sysWorkflowInsTask = (SysWorkflowInsTask)this.getRequest().getSession().getAttribute("__pop_object");
    	if (sysWorkflowInsTask.get_record_index() != -1){
    		this.sysWorkflowInsTasks.remove(sysWorkflowInsTask.get_record_index());
    		this.sysWorkflowInsTasks.add(sysWorkflowInsTask.get_record_index(), sysWorkflowInsTask);
    	}
    	else{
    		this.sysWorkflowInsTasks.add(sysWorkflowInsTask);
    	}
		this.getRequest().getSession().removeAttribute("__pop_object");
    }
    
    public String edit(){
        SysWorkflowInsTask sysWorkflowInsTask = sysWorkflowInsTasks.get(rowIndex.intValue());
    	sysWorkflowInsTask.set_record_index(rowIndex);
    	if (SysWorkflowInsTask.EDIT_FLAG_ADD != sysWorkflowInsTask.get_edit_flag()){
    		sysWorkflowInsTask.set_edit_flag(SysWorkflowInsTask.EDIT_FLAG_EDIT);
			this.setValueBinding("#{sysWorkflowInsTaskForm.sysWorkflowInsTaskPrimaryKey}", sysWorkflowInsTask.getId());
    	}
    	return this.getSuccessAction();
    }
    
    public String view(){
        SysWorkflowInsTask sysWorkflowInsTask = sysWorkflowInsTasks.get(rowIndex.intValue());
		this.setValueBinding("#{sysWorkflowInsTaskForm.sysWorkflowInsTaskPrimaryKey}", sysWorkflowInsTask.getId());
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
    	SysWorkflowInsTask sysWorkflowInsTask  = sysWorkflowInsTasks.get(rowIndex.intValue());
    	if (SysWorkflowInsTask.EDIT_FLAG_ADD != sysWorkflowInsTask.get_edit_flag()){
			deleteList.add(sysWorkflowInsTask.getId());    	
		}
		sysWorkflowInsTasks.remove(rowIndex.intValue());
    }	
	
    public void moveUpBuffer(){
    	int i = rowIndex;
    	int j = getMovedSysWorkflowInsTaskIndex(i,-1);
    	if (j == -1)
    		return ;
    	SysWorkflowInsTask sysWorkflowInsTask = sysWorkflowInsTasks.get(i);
    	sysWorkflowInsTasks.add(j, sysWorkflowInsTask);
    	sysWorkflowInsTasks.remove(i + 1);
    }	
	
    private int getMovedSysWorkflowInsTaskIndex(int index,int step){
    	if (index + step >= 0 && index + step < sysWorkflowInsTasks.size()){
    		SysWorkflowInsTask sysWorkflowInsTask = sysWorkflowInsTasks.get(index + step);
    		if (SysWorkflowInsTask.EDIT_FLAG_DELETE == sysWorkflowInsTask.get_edit_flag())
    			return index + step + getMovedSysWorkflowInsTaskIndex(index + step,step);
    		else
    			return index + step;
    	}else{
    		return -1;
    	}    	
    }	
	
    public void moveDownBuffer(){
    	int i = rowIndex;
    	int j = getMovedSysWorkflowInsTaskIndex(i,1);
    	if (j == -1)
    		return ;
    	SysWorkflowInsTask sysWorkflowInsTask = sysWorkflowInsTasks.get(j);
    	sysWorkflowInsTasks.add(i, sysWorkflowInsTask);
    	sysWorkflowInsTasks.remove(j + 1);
    }	
    public void saveAllOfSysWorkflowInsProc(String sysWorkflowInsProcid){
    	for(String id : deleteList){
    		service.delete(id);
    	}		
    	int i = 0;
		if(this.sysWorkflowInsTasks != null){
			for(SysWorkflowInsTask sysWorkflowInsTask : this.sysWorkflowInsTasks){    		
        		if (sysWorkflowInsTask.get_edit_flag() == SysWorkflowInsTask.EDIT_FLAG_ADD || sysWorkflowInsTask.get_edit_flag() == SysWorkflowInsTask.EDIT_FLAG_EDIT){
           			sysWorkflowInsTask.setProcessInsId(sysWorkflowInsProcid);
        			i++;
        			service.saveSysWorkflowInsTask(sysWorkflowInsTask);
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
            for (int i=0; i < sysWorkflowInsTasks.size(); i++) {
                SysWorkflowInsTask sysWorkflowInsTask = (SysWorkflowInsTask)this.sysWorkflowInsTasks.get(i);
                service.saveSysWorkflowInsTask(sysWorkflowInsTask);
            }
	        addMessage("sysWorkflowInsTask.message.savedAll",null);
			return this.getSuccessAction();
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
		return null;
	}	
	
	public void deleteChecked(){
		for(SysWorkflowInsTask sysWorkflowInsTask : this.sysWorkflowInsTasks){
			if(sysWorkflowInsTask.is_checked_flag()){
				service.delete(sysWorkflowInsTask.getId());
			}
		}
	}
	
	public void deleteAll(){
		service.deleteAll(this.sysWorkflowInsTasks);
	}
}
