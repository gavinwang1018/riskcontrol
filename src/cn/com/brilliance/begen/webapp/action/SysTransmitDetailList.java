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
import cn.com.brilliance.begen.service.SysTransmitDetailService;
import cn.com.brilliance.begen.webapp.action.BasePage;
import cn.com.brilliance.begen.common.webapp.action.ListPage;

/**
 * SysTransmitDetail对象List.
 * @author Administrator.
 *
 */
public class SysTransmitDetailList extends BasePage implements ListPage {

	private SysTransmitDetailService service = (SysTransmitDetailService)getBean("sysTransmitDetailService");
    /**
     * sysTransmitDetails.
     */
    private List<SysTransmitDetail> sysTransmitDetails;

    /**
     * dataTable.
     */
    private HtmlDataTable dataTable;

    /**
     * sysTransmitDetail.
     */
    private SysTransmitDetail sysTransmitDetail = null;

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
    public SysTransmitDetailList() {
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
     * Returns the SysTransmitDetail.
     * @return SysTransmitDetail.
     */
    public void setSysTransmitDetail(SysTransmitDetail sysTransmitDetail) {
        this.sysTransmitDetail = sysTransmitDetail;
    }

    /**
     * Sets the SysTransmitDetail.
     * @param sysTransmitDetail The sysTransmitDetail to set.
     */
    public SysTransmitDetail getSysTransmitDetail() {
        return this.sysTransmitDetail;
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
     * 获得SysTransmitDetail对象列表.
     * @return List.
     */
    public List<SysTransmitDetail> getSysTransmitDetails() {
        return this.sysTransmitDetails;
    }
	
	public void initSysTransmitDetails(){
	    try {
            if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));

            this.sysTransmitDetails = service.init(this.sysTransmitDetail,this.queryFields);
			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}

    /**
     * Sets the SysTransmitDetails.
     * @param sysTransmitDetails The SysTransmitDetails to set.
     */
    public void setSysTransmitDetails(List sysTransmitDetails) {
        this.sysTransmitDetails = sysTransmitDetails;
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
     * 删除SysTransmitDetail对象.
     * @return String.
     */
    public void delete() {
        try {
            SysTransmitDetail sysTransmitDetail = sysTransmitDetails.get(rowIndex);
            service.delete(sysTransmitDetail.getId());		
            addMessage("sysTransmitDetail.message.deleted", sysTransmitDetail.getId());		
            this.sysTransmitDetails.remove(rowIndex.intValue());
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
    }
    /**
     * 删除SysTransmitDetail对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            SysTransmitDetail sysTransmitDetail = sysTransmitDetails.get(rowIndex);

            service.delete(this.sysTransmitDetail.getId());
            addMessage("sysTransmitDetail.message.deleted", this.sysTransmitDetail.getId());				
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return null;
        }
        return null;
    }
    /**
     *    查询SysTransmitDetail对象.
     *  @return String.
     */
    public String query() {
        try {
            this.sysTransmitDetails = service.getSysTransmitDetailListOfQuery(this.queryFields);
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
		SysTransmitDetail sysTransmitDetail = new SysTransmitDetail();
		sysTransmitDetail.set_record_index(-1);		
    	sysTransmitDetail.set_edit_flag(SysTransmitDetail.EDIT_FLAG_ADD);
        this.sysTransmitDetails.add(sysTransmitDetail);
    }
	
	public void popupAdd(){
		SysTransmitDetail sysTransmitDetail = new SysTransmitDetail();
		sysTransmitDetail.set_record_index(-1);		
    	sysTransmitDetail.set_edit_flag(SysTransmitDetail.EDIT_FLAG_ADD);
    	this.getRequest().getSession().setAttribute("__pop_object", sysTransmitDetail); 	
    }
	
	public void popupEdit(){
		SysTransmitDetail sysTransmitDetail = sysTransmitDetails.get(rowIndex);
    	sysTransmitDetail.set_record_index(rowIndex);
    	if (SysTransmitDetail.EDIT_FLAG_ADD != sysTransmitDetail.get_edit_flag()){
    		sysTransmitDetail.set_edit_flag(SysTransmitDetail.EDIT_FLAG_EDIT);
    	}    	
    	this.getRequest().getSession().setAttribute("__pop_object", sysTransmitDetail); 	
	}	
	
	public void popupView(){
		SysTransmitDetail sysTransmitDetail = sysTransmitDetails.get(rowIndex.intValue());
    	this.getRequest().getSession().setAttribute("__pop_object", sysTransmitDetail); 	
	}	
    
    public void popupRefresh(){
    	SysTransmitDetail sysTransmitDetail = (SysTransmitDetail)this.getRequest().getSession().getAttribute("__pop_object");
    	if (sysTransmitDetail.get_record_index() != -1){
    		this.sysTransmitDetails.remove(sysTransmitDetail.get_record_index());
    		this.sysTransmitDetails.add(sysTransmitDetail.get_record_index(), sysTransmitDetail);
    	}
    	else{
    		this.sysTransmitDetails.add(sysTransmitDetail);
    	}
		this.getRequest().getSession().removeAttribute("__pop_object");
    }
    
    public String edit(){
        SysTransmitDetail sysTransmitDetail = sysTransmitDetails.get(rowIndex.intValue());
    	sysTransmitDetail.set_record_index(rowIndex);
    	if (SysTransmitDetail.EDIT_FLAG_ADD != sysTransmitDetail.get_edit_flag()){
    		sysTransmitDetail.set_edit_flag(SysTransmitDetail.EDIT_FLAG_EDIT);
			this.setValueBinding("#{sysTransmitDetailForm.sysTransmitDetailPrimaryKey}", sysTransmitDetail.getId());
    	}
    	return this.getSuccessAction();
    }
    
    public String view(){
        SysTransmitDetail sysTransmitDetail = sysTransmitDetails.get(rowIndex.intValue());
		this.setValueBinding("#{sysTransmitDetailForm.sysTransmitDetailPrimaryKey}", sysTransmitDetail.getId());
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
    	SysTransmitDetail sysTransmitDetail  = sysTransmitDetails.get(rowIndex.intValue());
    	if (SysTransmitDetail.EDIT_FLAG_ADD != sysTransmitDetail.get_edit_flag()){
			deleteList.add(sysTransmitDetail.getId());    	
		}
		sysTransmitDetails.remove(rowIndex.intValue());
    }	
	
    public void moveUpBuffer(){
    	int i = rowIndex;
    	int j = getMovedSysTransmitDetailIndex(i,-1);
    	if (j == -1)
    		return ;
    	SysTransmitDetail sysTransmitDetail = sysTransmitDetails.get(i);
    	sysTransmitDetails.add(j, sysTransmitDetail);
    	sysTransmitDetails.remove(i + 1);
    }	
	
    private int getMovedSysTransmitDetailIndex(int index,int step){
    	if (index + step >= 0 && index + step < sysTransmitDetails.size()){
    		SysTransmitDetail sysTransmitDetail = sysTransmitDetails.get(index + step);
    		if (SysTransmitDetail.EDIT_FLAG_DELETE == sysTransmitDetail.get_edit_flag())
    			return index + step + getMovedSysTransmitDetailIndex(index + step,step);
    		else
    			return index + step;
    	}else{
    		return -1;
    	}    	
    }	
	
    public void moveDownBuffer(){
    	int i = rowIndex;
    	int j = getMovedSysTransmitDetailIndex(i,1);
    	if (j == -1)
    		return ;
    	SysTransmitDetail sysTransmitDetail = sysTransmitDetails.get(j);
    	sysTransmitDetails.add(i, sysTransmitDetail);
    	sysTransmitDetails.remove(j + 1);
    }	
    public void saveAllOfSysTransmit(String sysTransmitid){
    	for(String id : deleteList){
    		service.delete(id);
    	}		
    	int i = 0;
		if(this.sysTransmitDetails != null){
			for(SysTransmitDetail sysTransmitDetail : this.sysTransmitDetails){    		
        		if (sysTransmitDetail.get_edit_flag() == SysTransmitDetail.EDIT_FLAG_ADD || sysTransmitDetail.get_edit_flag() == SysTransmitDetail.EDIT_FLAG_EDIT){
           			sysTransmitDetail.setTransmitId(sysTransmitid);
        			i++;
        			service.saveSysTransmitDetail(sysTransmitDetail);
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
            for (int i=0; i < sysTransmitDetails.size(); i++) {
                SysTransmitDetail sysTransmitDetail = (SysTransmitDetail)this.sysTransmitDetails.get(i);
                service.saveSysTransmitDetail(sysTransmitDetail);
            }
	        addMessage("sysTransmitDetail.message.savedAll",null);
			return this.getSuccessAction();
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
		return null;
	}	
	
	public void deleteChecked(){
		for(SysTransmitDetail sysTransmitDetail : this.sysTransmitDetails){
			if(sysTransmitDetail.is_checked_flag()){
				service.delete(sysTransmitDetail.getId());
			}
		}
	}
	
	public void deleteAll(){
		service.deleteAll(this.sysTransmitDetails);
	}
}
