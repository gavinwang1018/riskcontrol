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
import cn.com.brilliance.begen.service.SysDailyInsService;
import cn.com.brilliance.begen.webapp.action.BasePage;
import cn.com.brilliance.begen.common.webapp.action.ListPage;

/**
 * SysDailyIns对象List.
 * @author Administrator.
 *
 */
public class SysDailyInsList extends BasePage implements ListPage {

	private SysDailyInsService service = (SysDailyInsService)getBean("sysDailyInsService");
    /**
     * sysDailyInss.
     */
    private List<SysDailyIns> sysDailyInss;

    /**
     * dataTable.
     */
    private HtmlDataTable dataTable;

    /**
     * sysDailyIns.
     */
    private SysDailyIns sysDailyIns = null;

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
    public SysDailyInsList() {
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
     * Returns the SysDailyIns.
     * @return SysDailyIns.
     */
    public void setSysDailyIns(SysDailyIns sysDailyIns) {
        this.sysDailyIns = sysDailyIns;
    }

    /**
     * Sets the SysDailyIns.
     * @param sysDailyIns The sysDailyIns to set.
     */
    public SysDailyIns getSysDailyIns() {
        return this.sysDailyIns;
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
     * 获得SysDailyIns对象列表.
     * @return List.
     */
    public List<SysDailyIns> getSysDailyInss() {
        return this.sysDailyInss;
    }
	
	public void initSysDailyInss(){
	    try {
            if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));

            this.sysDailyInss = service.init(this.sysDailyIns,this.queryFields);
			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}

    /**
     * Sets the SysDailyInss.
     * @param sysDailyInss The SysDailyInss to set.
     */
    public void setSysDailyInss(List sysDailyInss) {
        this.sysDailyInss = sysDailyInss;
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
     * 删除SysDailyIns对象.
     * @return String.
     */
    public void delete() {
        try {
            SysDailyIns sysDailyIns = sysDailyInss.get(rowIndex);
            service.delete(sysDailyIns.getId());		
            addMessage("sysDailyIns.message.deleted", sysDailyIns.getId());		
            this.sysDailyInss.remove(rowIndex.intValue());
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
    }
    /**
     * 删除SysDailyIns对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            SysDailyIns sysDailyIns = sysDailyInss.get(rowIndex);

            service.delete(this.sysDailyIns.getId());
            addMessage("sysDailyIns.message.deleted", this.sysDailyIns.getId());				
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return null;
        }
        return null;
    }
    /**
     *    查询SysDailyIns对象.
     *  @return String.
     */
    public String query() {
        try {
            this.sysDailyInss = service.getSysDailyInsListOfQuery(this.queryFields);
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
		SysDailyIns sysDailyIns = new SysDailyIns();
		sysDailyIns.set_record_index(-1);		
    	sysDailyIns.set_edit_flag(SysDailyIns.EDIT_FLAG_ADD);
        this.sysDailyInss.add(sysDailyIns);
    }
	
	public void popupAdd(){
		SysDailyIns sysDailyIns = new SysDailyIns();
		sysDailyIns.set_record_index(-1);		
    	sysDailyIns.set_edit_flag(SysDailyIns.EDIT_FLAG_ADD);
    	this.getRequest().getSession().setAttribute("__pop_object", sysDailyIns); 	
    }
	
	public void popupEdit(){
		SysDailyIns sysDailyIns = sysDailyInss.get(rowIndex);
    	sysDailyIns.set_record_index(rowIndex);
    	if (SysDailyIns.EDIT_FLAG_ADD != sysDailyIns.get_edit_flag()){
    		sysDailyIns.set_edit_flag(SysDailyIns.EDIT_FLAG_EDIT);
    	}    	
    	this.getRequest().getSession().setAttribute("__pop_object", sysDailyIns); 	
	}	
	
	public void popupView(){
		SysDailyIns sysDailyIns = sysDailyInss.get(rowIndex.intValue());
    	this.getRequest().getSession().setAttribute("__pop_object", sysDailyIns); 	
	}	
    
    public void popupRefresh(){
    	SysDailyIns sysDailyIns = (SysDailyIns)this.getRequest().getSession().getAttribute("__pop_object");
    	if (sysDailyIns.get_record_index() != -1){
    		this.sysDailyInss.remove(sysDailyIns.get_record_index());
    		this.sysDailyInss.add(sysDailyIns.get_record_index(), sysDailyIns);
    	}
    	else{
    		this.sysDailyInss.add(sysDailyIns);
    	}
		this.getRequest().getSession().removeAttribute("__pop_object");
    }
    
    public String edit(){
        SysDailyIns sysDailyIns = sysDailyInss.get(rowIndex.intValue());
    	sysDailyIns.set_record_index(rowIndex);
    	if (SysDailyIns.EDIT_FLAG_ADD != sysDailyIns.get_edit_flag()){
    		sysDailyIns.set_edit_flag(SysDailyIns.EDIT_FLAG_EDIT);
			this.setValueBinding("#{sysDailyInsForm.sysDailyInsPrimaryKey}", sysDailyIns.getId());
    	}
    	return this.getSuccessAction();
    }
    
    public String view(){
        SysDailyIns sysDailyIns = sysDailyInss.get(rowIndex.intValue());
		this.setValueBinding("#{sysDailyInsForm.sysDailyInsPrimaryKey}", sysDailyIns.getId());
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
    	SysDailyIns sysDailyIns  = sysDailyInss.get(rowIndex.intValue());
    	if (SysDailyIns.EDIT_FLAG_ADD != sysDailyIns.get_edit_flag()){
			deleteList.add(sysDailyIns.getId());    	
		}
		sysDailyInss.remove(rowIndex.intValue());
    }	
	
    public void moveUpBuffer(){
    	int i = rowIndex;
    	int j = getMovedSysDailyInsIndex(i,-1);
    	if (j == -1)
    		return ;
    	SysDailyIns sysDailyIns = sysDailyInss.get(i);
    	sysDailyInss.add(j, sysDailyIns);
    	sysDailyInss.remove(i + 1);
    }	
	
    private int getMovedSysDailyInsIndex(int index,int step){
    	if (index + step >= 0 && index + step < sysDailyInss.size()){
    		SysDailyIns sysDailyIns = sysDailyInss.get(index + step);
    		if (SysDailyIns.EDIT_FLAG_DELETE == sysDailyIns.get_edit_flag())
    			return index + step + getMovedSysDailyInsIndex(index + step,step);
    		else
    			return index + step;
    	}else{
    		return -1;
    	}    	
    }	
	
    public void moveDownBuffer(){
    	int i = rowIndex;
    	int j = getMovedSysDailyInsIndex(i,1);
    	if (j == -1)
    		return ;
    	SysDailyIns sysDailyIns = sysDailyInss.get(j);
    	sysDailyInss.add(i, sysDailyIns);
    	sysDailyInss.remove(j + 1);
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
            for (int i=0; i < sysDailyInss.size(); i++) {
                SysDailyIns sysDailyIns = (SysDailyIns)this.sysDailyInss.get(i);
                service.saveSysDailyIns(sysDailyIns);
            }
	        addMessage("sysDailyIns.message.savedAll",null);
			return this.getSuccessAction();
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
		return null;
	}	
	
	public void deleteChecked(){
		for(SysDailyIns sysDailyIns : this.sysDailyInss){
			if(sysDailyIns.is_checked_flag()){
				service.delete(sysDailyIns.getId());
			}
		}
	}
	
	public void deleteAll(){
		service.deleteAll(this.sysDailyInss);
	}
}
