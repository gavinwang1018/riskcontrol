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
import cn.com.brilliance.begen.service.TriskcaseLogService;
import cn.com.brilliance.begen.webapp.action.BasePage;
import cn.com.brilliance.begen.common.webapp.action.ListPage;

/**
 * TriskcaseLog对象List.
 * @author Administrator.
 *
 */
public class TriskcaseLogList extends BasePage implements ListPage {

	private TriskcaseLogService service = (TriskcaseLogService)getBean("triskcaseLogService");
    /**
     * triskcaseLogs.
     */
    private List<TriskcaseLog> triskcaseLogs;

    /**
     * dataTable.
     */
    private HtmlDataTable dataTable;

    /**
     * triskcaseLog.
     */
    private TriskcaseLog triskcaseLog = null;

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
    public TriskcaseLogList() {
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
     * Returns the TriskcaseLog.
     * @return TriskcaseLog.
     */
    public void setTriskcaseLog(TriskcaseLog triskcaseLog) {
        this.triskcaseLog = triskcaseLog;
    }

    /**
     * Sets the TriskcaseLog.
     * @param triskcaseLog The triskcaseLog to set.
     */
    public TriskcaseLog getTriskcaseLog() {
        return this.triskcaseLog;
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
     * 获得TriskcaseLog对象列表.
     * @return List.
     */
    public List<TriskcaseLog> getTriskcaseLogs() {
        return this.triskcaseLogs;
    }
	
	public void initTriskcaseLogs(){
	    try {
            if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));

            this.triskcaseLogs = service.init(this.triskcaseLog,this.queryFields);
			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}

    /**
     * Sets the TriskcaseLogs.
     * @param triskcaseLogs The TriskcaseLogs to set.
     */
    public void setTriskcaseLogs(List triskcaseLogs) {
        this.triskcaseLogs = triskcaseLogs;
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
     * 删除TriskcaseLog对象.
     * @return String.
     */
    public void delete() {
        try {
            TriskcaseLog triskcaseLog = triskcaseLogs.get(rowIndex);
            service.delete(triskcaseLog.getId());		
            addMessage("triskcaseLog.message.deleted", triskcaseLog.getId());		
            this.triskcaseLogs.remove(rowIndex.intValue());
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
    }
    /**
     * 删除TriskcaseLog对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            TriskcaseLog triskcaseLog = triskcaseLogs.get(rowIndex);

            service.delete(this.triskcaseLog.getId());
            addMessage("triskcaseLog.message.deleted", this.triskcaseLog.getId());				
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return null;
        }
        return null;
    }
    /**
     *    查询TriskcaseLog对象.
     *  @return String.
     */
    public String query() {
        try {
            this.triskcaseLogs = service.getTriskcaseLogListOfQuery(this.queryFields);
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
		TriskcaseLog triskcaseLog = new TriskcaseLog();
		triskcaseLog.set_record_index(-1);		
    	triskcaseLog.set_edit_flag(TriskcaseLog.EDIT_FLAG_ADD);
        this.triskcaseLogs.add(triskcaseLog);
    }
	
	public void popupAdd(){
		TriskcaseLog triskcaseLog = new TriskcaseLog();
		triskcaseLog.set_record_index(-1);		
    	triskcaseLog.set_edit_flag(TriskcaseLog.EDIT_FLAG_ADD);
    	this.getRequest().getSession().setAttribute("__pop_object", triskcaseLog); 	
    }
	
	public void popupEdit(){
		TriskcaseLog triskcaseLog = triskcaseLogs.get(rowIndex);
    	triskcaseLog.set_record_index(rowIndex);
    	if (TriskcaseLog.EDIT_FLAG_ADD != triskcaseLog.get_edit_flag()){
    		triskcaseLog.set_edit_flag(TriskcaseLog.EDIT_FLAG_EDIT);
    	}    	
    	this.getRequest().getSession().setAttribute("__pop_object", triskcaseLog); 	
	}	
	
	public void popupView(){
		TriskcaseLog triskcaseLog = triskcaseLogs.get(rowIndex.intValue());
    	this.getRequest().getSession().setAttribute("__pop_object", triskcaseLog); 	
	}	
    
    public void popupRefresh(){
    	TriskcaseLog triskcaseLog = (TriskcaseLog)this.getRequest().getSession().getAttribute("__pop_object");
    	if (triskcaseLog.get_record_index() != -1){
    		this.triskcaseLogs.remove(triskcaseLog.get_record_index());
    		this.triskcaseLogs.add(triskcaseLog.get_record_index(), triskcaseLog);
    	}
    	else{
    		this.triskcaseLogs.add(triskcaseLog);
    	}
		this.getRequest().getSession().removeAttribute("__pop_object");
    }
    
    public String edit(){
        TriskcaseLog triskcaseLog = triskcaseLogs.get(rowIndex.intValue());
    	triskcaseLog.set_record_index(rowIndex);
    	if (TriskcaseLog.EDIT_FLAG_ADD != triskcaseLog.get_edit_flag()){
    		triskcaseLog.set_edit_flag(TriskcaseLog.EDIT_FLAG_EDIT);
			this.setValueBinding("#{triskcaseLogForm.triskcaseLogPrimaryKey}", triskcaseLog.getId());
    	}
    	return this.getSuccessAction();
    }
    
    public String view(){
        TriskcaseLog triskcaseLog = triskcaseLogs.get(rowIndex.intValue());
		this.setValueBinding("#{triskcaseLogForm.triskcaseLogPrimaryKey}", triskcaseLog.getId());
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
    	TriskcaseLog triskcaseLog  = triskcaseLogs.get(rowIndex.intValue());
    	if (TriskcaseLog.EDIT_FLAG_ADD != triskcaseLog.get_edit_flag()){
			deleteList.add(triskcaseLog.getId());    	
		}
		triskcaseLogs.remove(rowIndex.intValue());
    }	
	
    public void moveUpBuffer(){
    	int i = rowIndex;
    	int j = getMovedTriskcaseLogIndex(i,-1);
    	if (j == -1)
    		return ;
    	TriskcaseLog triskcaseLog = triskcaseLogs.get(i);
    	triskcaseLogs.add(j, triskcaseLog);
    	triskcaseLogs.remove(i + 1);
    }	
	
    private int getMovedTriskcaseLogIndex(int index,int step){
    	if (index + step >= 0 && index + step < triskcaseLogs.size()){
    		TriskcaseLog triskcaseLog = triskcaseLogs.get(index + step);
    		if (TriskcaseLog.EDIT_FLAG_DELETE == triskcaseLog.get_edit_flag())
    			return index + step + getMovedTriskcaseLogIndex(index + step,step);
    		else
    			return index + step;
    	}else{
    		return -1;
    	}    	
    }	
	
    public void moveDownBuffer(){
    	int i = rowIndex;
    	int j = getMovedTriskcaseLogIndex(i,1);
    	if (j == -1)
    		return ;
    	TriskcaseLog triskcaseLog = triskcaseLogs.get(j);
    	triskcaseLogs.add(i, triskcaseLog);
    	triskcaseLogs.remove(j + 1);
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
            for (int i=0; i < triskcaseLogs.size(); i++) {
                TriskcaseLog triskcaseLog = (TriskcaseLog)this.triskcaseLogs.get(i);
                service.saveTriskcaseLog(triskcaseLog);
            }
	        addMessage("triskcaseLog.message.savedAll",null);
			return this.getSuccessAction();
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
		return null;
	}	
	
	public void deleteChecked(){
		for(TriskcaseLog triskcaseLog : this.triskcaseLogs){
			if(triskcaseLog.is_checked_flag()){
				service.delete(triskcaseLog.getId());
			}
		}
	}
	
	public void deleteAll(){
		service.deleteAll(this.triskcaseLogs);
	}
}
