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
import cn.com.brilliance.begen.service.EpcInsProcService;
import cn.com.brilliance.begen.webapp.action.BasePage;
import cn.com.brilliance.begen.common.webapp.action.ListPage;

/**
 * EpcInsProc对象List.
 * @author Administrator.
 *
 */
public class EpcInsProcList extends BasePage implements ListPage {

	private EpcInsProcService service = (EpcInsProcService)getBean("epcInsProcService");
    /**
     * epcInsProcs.
     */
    private List<EpcInsProc> epcInsProcs;

    /**
     * dataTable.
     */
    private HtmlDataTable dataTable;

    /**
     * epcInsProc.
     */
    private EpcInsProc epcInsProc = null;

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
    public EpcInsProcList() {
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
     * Returns the EpcInsProc.
     * @return EpcInsProc.
     */
    public void setEpcInsProc(EpcInsProc epcInsProc) {
        this.epcInsProc = epcInsProc;
    }

    /**
     * Sets the EpcInsProc.
     * @param epcInsProc The epcInsProc to set.
     */
    public EpcInsProc getEpcInsProc() {
        return this.epcInsProc;
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
     * 获得EpcInsProc对象列表.
     * @return List.
     */
    public List<EpcInsProc> getEpcInsProcs() {
        return this.epcInsProcs;
    }
	
	public void initEpcInsProcs(){
	    try {
            if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));

            this.epcInsProcs = service.init(this.epcInsProc,this.queryFields);
			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}

    /**
     * Sets the EpcInsProcs.
     * @param epcInsProcs The EpcInsProcs to set.
     */
    public void setEpcInsProcs(List epcInsProcs) {
        this.epcInsProcs = epcInsProcs;
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
     * 删除EpcInsProc对象.
     * @return String.
     */
    public void delete() {
        try {
            EpcInsProc epcInsProc = epcInsProcs.get(rowIndex);
            service.delete(epcInsProc.getId());		
            addMessage("epcInsProc.message.deleted", epcInsProc.getProcessDefId());		
            this.epcInsProcs.remove(rowIndex.intValue());
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
    }
    /**
     * 删除EpcInsProc对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            EpcInsProc epcInsProc = epcInsProcs.get(rowIndex);
            if (epcInsProc.getEpcInsTaskGroup().size() > 0) {
                this.addMessageString("exception.delete.cascade");
                return null;
            }

            service.delete(this.epcInsProc.getId());
            addMessage("epcInsProc.message.deleted", this.epcInsProc.getProcessDefId());				
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return null;
        }
        return null;
    }
    /**
     *    查询EpcInsProc对象.
     *  @return String.
     */
    public String query() {
        try {
            this.epcInsProcs = service.getEpcInsProcListOfQuery(this.queryFields);
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
		EpcInsProc epcInsProc = new EpcInsProc();
		epcInsProc.set_record_index(-1);		
    	epcInsProc.set_edit_flag(EpcInsProc.EDIT_FLAG_ADD);
        this.epcInsProcs.add(epcInsProc);
    }
	
	public void popupAdd(){
		EpcInsProc epcInsProc = new EpcInsProc();
		epcInsProc.set_record_index(-1);		
    	epcInsProc.set_edit_flag(EpcInsProc.EDIT_FLAG_ADD);
    	this.getRequest().getSession().setAttribute("__pop_object", epcInsProc); 	
    }
	
	public void popupEdit(){
		EpcInsProc epcInsProc = epcInsProcs.get(rowIndex);
    	epcInsProc.set_record_index(rowIndex);
    	if (EpcInsProc.EDIT_FLAG_ADD != epcInsProc.get_edit_flag()){
    		epcInsProc.set_edit_flag(EpcInsProc.EDIT_FLAG_EDIT);
    	}    	
    	this.getRequest().getSession().setAttribute("__pop_object", epcInsProc); 	
	}	
	
	public void popupView(){
		EpcInsProc epcInsProc = epcInsProcs.get(rowIndex.intValue());
    	this.getRequest().getSession().setAttribute("__pop_object", epcInsProc); 	
	}	
    
    public void popupRefresh(){
    	EpcInsProc epcInsProc = (EpcInsProc)this.getRequest().getSession().getAttribute("__pop_object");
    	if (epcInsProc.get_record_index() != -1){
    		this.epcInsProcs.remove(epcInsProc.get_record_index());
    		this.epcInsProcs.add(epcInsProc.get_record_index(), epcInsProc);
    	}
    	else{
    		this.epcInsProcs.add(epcInsProc);
    	}
		this.getRequest().getSession().removeAttribute("__pop_object");
    }
    
    public String edit(){
        EpcInsProc epcInsProc = epcInsProcs.get(rowIndex.intValue());
    	epcInsProc.set_record_index(rowIndex);
    	if (EpcInsProc.EDIT_FLAG_ADD != epcInsProc.get_edit_flag()){
    		epcInsProc.set_edit_flag(EpcInsProc.EDIT_FLAG_EDIT);
			this.setValueBinding("#{epcInsProcForm.epcInsProcPrimaryKey}", epcInsProc.getId());
    	}
    	return this.getSuccessAction();
    }
    
    public String view(){
        EpcInsProc epcInsProc = epcInsProcs.get(rowIndex.intValue());
		this.setValueBinding("#{epcInsProcForm.epcInsProcPrimaryKey}", epcInsProc.getId());
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
    	EpcInsProc epcInsProc  = epcInsProcs.get(rowIndex.intValue());
    	if (EpcInsProc.EDIT_FLAG_ADD != epcInsProc.get_edit_flag()){
			deleteList.add(epcInsProc.getId());    	
		}
		epcInsProcs.remove(rowIndex.intValue());
    }	
	
    public void moveUpBuffer(){
    	int i = rowIndex;
    	int j = getMovedEpcInsProcIndex(i,-1);
    	if (j == -1)
    		return ;
    	EpcInsProc epcInsProc = epcInsProcs.get(i);
    	epcInsProcs.add(j, epcInsProc);
    	epcInsProcs.remove(i + 1);
    }	
	
    private int getMovedEpcInsProcIndex(int index,int step){
    	if (index + step >= 0 && index + step < epcInsProcs.size()){
    		EpcInsProc epcInsProc = epcInsProcs.get(index + step);
    		if (EpcInsProc.EDIT_FLAG_DELETE == epcInsProc.get_edit_flag())
    			return index + step + getMovedEpcInsProcIndex(index + step,step);
    		else
    			return index + step;
    	}else{
    		return -1;
    	}    	
    }	
	
    public void moveDownBuffer(){
    	int i = rowIndex;
    	int j = getMovedEpcInsProcIndex(i,1);
    	if (j == -1)
    		return ;
    	EpcInsProc epcInsProc = epcInsProcs.get(j);
    	epcInsProcs.add(i, epcInsProc);
    	epcInsProcs.remove(j + 1);
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
            for (int i=0; i < epcInsProcs.size(); i++) {
                EpcInsProc epcInsProc = (EpcInsProc)this.epcInsProcs.get(i);
                service.saveEpcInsProc(epcInsProc);
            }
	        addMessage("epcInsProc.message.savedAll",null);
			return this.getSuccessAction();
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
		return null;
	}	
	
	public void deleteChecked(){
		for(EpcInsProc epcInsProc : this.epcInsProcs){
			if(epcInsProc.is_checked_flag()){
				service.delete(epcInsProc.getId());
			}
		}
	}
	
	public void deleteAll(){
		service.deleteAll(this.epcInsProcs);
	}
}
