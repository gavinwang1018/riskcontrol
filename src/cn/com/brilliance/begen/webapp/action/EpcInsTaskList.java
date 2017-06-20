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
import cn.com.brilliance.begen.service.EpcInsTaskService;
import cn.com.brilliance.begen.webapp.action.BasePage;
import cn.com.brilliance.begen.common.webapp.action.ListPage;

/**
 * EpcInsTask对象List.
 * @author Administrator.
 *
 */
public class EpcInsTaskList extends BasePage implements ListPage {

	private EpcInsTaskService service = (EpcInsTaskService)getBean("epcInsTaskService");
    /**
     * epcInsTasks.
     */
    private List<EpcInsTask> epcInsTasks;

    /**
     * dataTable.
     */
    private HtmlDataTable dataTable;

    /**
     * epcInsTask.
     */
    private EpcInsTask epcInsTask = null;

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
    public EpcInsTaskList() {
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
     * Returns the EpcInsTask.
     * @return EpcInsTask.
     */
    public void setEpcInsTask(EpcInsTask epcInsTask) {
        this.epcInsTask = epcInsTask;
    }

    /**
     * Sets the EpcInsTask.
     * @param epcInsTask The epcInsTask to set.
     */
    public EpcInsTask getEpcInsTask() {
        return this.epcInsTask;
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
     * 获得EpcInsTask对象列表.
     * @return List.
     */
    public List<EpcInsTask> getEpcInsTasks() {
        return this.epcInsTasks;
    }
	
	public void initEpcInsTasks(){
	    try {
            if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));

            this.epcInsTasks = service.init(this.epcInsTask,this.queryFields);
			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}

    /**
     * Sets the EpcInsTasks.
     * @param epcInsTasks The EpcInsTasks to set.
     */
    public void setEpcInsTasks(List epcInsTasks) {
        this.epcInsTasks = epcInsTasks;
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
     * 删除EpcInsTask对象.
     * @return String.
     */
    public void delete() {
        try {
            EpcInsTask epcInsTask = epcInsTasks.get(rowIndex);
            service.delete(epcInsTask.getId());		
            addMessage("epcInsTask.message.deleted", epcInsTask.getProcessInsId());		
            this.epcInsTasks.remove(rowIndex.intValue());
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
    }
    /**
     * 删除EpcInsTask对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            EpcInsTask epcInsTask = epcInsTasks.get(rowIndex);

            service.delete(this.epcInsTask.getId());
            addMessage("epcInsTask.message.deleted", this.epcInsTask.getProcessInsId());				
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return null;
        }
        return null;
    }
    /**
     *    查询EpcInsTask对象.
     *  @return String.
     */
    public String query() {
        try {
            this.epcInsTasks = service.getEpcInsTaskListOfQuery(this.queryFields);
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
		EpcInsTask epcInsTask = new EpcInsTask();
		epcInsTask.set_record_index(-1);		
    	epcInsTask.set_edit_flag(EpcInsTask.EDIT_FLAG_ADD);
        this.epcInsTasks.add(epcInsTask);
    }
	
	public void popupAdd(){
		EpcInsTask epcInsTask = new EpcInsTask();
		epcInsTask.set_record_index(-1);		
    	epcInsTask.set_edit_flag(EpcInsTask.EDIT_FLAG_ADD);
    	this.getRequest().getSession().setAttribute("__pop_object", epcInsTask); 	
    }
	
	public void popupEdit(){
		EpcInsTask epcInsTask = epcInsTasks.get(rowIndex);
    	epcInsTask.set_record_index(rowIndex);
    	if (EpcInsTask.EDIT_FLAG_ADD != epcInsTask.get_edit_flag()){
    		epcInsTask.set_edit_flag(EpcInsTask.EDIT_FLAG_EDIT);
    	}    	
    	this.getRequest().getSession().setAttribute("__pop_object", epcInsTask); 	
	}	
	
	public void popupView(){
		EpcInsTask epcInsTask = epcInsTasks.get(rowIndex.intValue());
    	this.getRequest().getSession().setAttribute("__pop_object", epcInsTask); 	
	}	
    
    public void popupRefresh(){
    	EpcInsTask epcInsTask = (EpcInsTask)this.getRequest().getSession().getAttribute("__pop_object");
    	if (epcInsTask.get_record_index() != -1){
    		this.epcInsTasks.remove(epcInsTask.get_record_index());
    		this.epcInsTasks.add(epcInsTask.get_record_index(), epcInsTask);
    	}
    	else{
    		this.epcInsTasks.add(epcInsTask);
    	}
		this.getRequest().getSession().removeAttribute("__pop_object");
    }
    
    public String edit(){
        EpcInsTask epcInsTask = epcInsTasks.get(rowIndex.intValue());
    	epcInsTask.set_record_index(rowIndex);
    	if (EpcInsTask.EDIT_FLAG_ADD != epcInsTask.get_edit_flag()){
    		epcInsTask.set_edit_flag(EpcInsTask.EDIT_FLAG_EDIT);
			this.setValueBinding("#{epcInsTaskForm.epcInsTaskPrimaryKey}", epcInsTask.getId());
    	}
    	return this.getSuccessAction();
    }
    
    public String view(){
        EpcInsTask epcInsTask = epcInsTasks.get(rowIndex.intValue());
		this.setValueBinding("#{epcInsTaskForm.epcInsTaskPrimaryKey}", epcInsTask.getId());
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
    	EpcInsTask epcInsTask  = epcInsTasks.get(rowIndex.intValue());
    	if (EpcInsTask.EDIT_FLAG_ADD != epcInsTask.get_edit_flag()){
			deleteList.add(epcInsTask.getId());    	
		}
		epcInsTasks.remove(rowIndex.intValue());
    }	
	
    public void moveUpBuffer(){
    	int i = rowIndex;
    	int j = getMovedEpcInsTaskIndex(i,-1);
    	if (j == -1)
    		return ;
    	EpcInsTask epcInsTask = epcInsTasks.get(i);
    	epcInsTasks.add(j, epcInsTask);
    	epcInsTasks.remove(i + 1);
    }	
	
    private int getMovedEpcInsTaskIndex(int index,int step){
    	if (index + step >= 0 && index + step < epcInsTasks.size()){
    		EpcInsTask epcInsTask = epcInsTasks.get(index + step);
    		if (EpcInsTask.EDIT_FLAG_DELETE == epcInsTask.get_edit_flag())
    			return index + step + getMovedEpcInsTaskIndex(index + step,step);
    		else
    			return index + step;
    	}else{
    		return -1;
    	}    	
    }	
	
    public void moveDownBuffer(){
    	int i = rowIndex;
    	int j = getMovedEpcInsTaskIndex(i,1);
    	if (j == -1)
    		return ;
    	EpcInsTask epcInsTask = epcInsTasks.get(j);
    	epcInsTasks.add(i, epcInsTask);
    	epcInsTasks.remove(j + 1);
    }	
    public void saveAllOfEpcInsProc(String epcInsProcid){
    	for(String id : deleteList){
    		service.delete(id);
    	}		
    	int i = 0;
		if(this.epcInsTasks != null){
			for(EpcInsTask epcInsTask : this.epcInsTasks){    		
        		if (epcInsTask.get_edit_flag() == EpcInsTask.EDIT_FLAG_ADD || epcInsTask.get_edit_flag() == EpcInsTask.EDIT_FLAG_EDIT){
           			epcInsTask.setProcessInsId(epcInsProcid);
        			i++;
        			service.saveEpcInsTask(epcInsTask);
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
            for (int i=0; i < epcInsTasks.size(); i++) {
                EpcInsTask epcInsTask = (EpcInsTask)this.epcInsTasks.get(i);
                service.saveEpcInsTask(epcInsTask);
            }
	        addMessage("epcInsTask.message.savedAll",null);
			return this.getSuccessAction();
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
		return null;
	}	
	
	public void deleteChecked(){
		for(EpcInsTask epcInsTask : this.epcInsTasks){
			if(epcInsTask.is_checked_flag()){
				service.delete(epcInsTask.getId());
			}
		}
	}
	
	public void deleteAll(){
		service.deleteAll(this.epcInsTasks);
	}
}
