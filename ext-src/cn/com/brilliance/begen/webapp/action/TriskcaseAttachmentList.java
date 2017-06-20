package cn.com.brilliance.begen.webapp.action;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import javax.faces.component.html.HtmlDataTable;

import cn.com.brilliance.begen.dao.TorganizeInfoDAO;
import cn.com.brilliance.begen.dao.TuserInfoDAO;
import cn.com.brilliance.begen.exception.BeGenException;
import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.TriskcaseAttachmentService;
import cn.com.brilliance.begen.webapp.action.BasePage;
import cn.com.brilliance.begen.webapp.servlet.UserBean;
import cn.com.brilliance.begen.common.webapp.action.ListPage;

/**
 * TriskcaseAttachment对象List.
 * @author Administrator.
 *
 */
public class TriskcaseAttachmentList extends BasePage implements ListPage {

	private TriskcaseAttachmentService service = (TriskcaseAttachmentService)getBean("triskcaseAttachmentService");
    /**
     * triskcaseAttachments.
     */
    private List<TriskcaseAttachment> triskcaseAttachments;
    
    private String caseno;
    
    private String riskcaseId;

    /**
     * dataTable.
     */
    private HtmlDataTable dataTable;
    
    private Map riskcaseQueryFields;

    /**
     * triskcaseAttachment.
     */
    private TriskcaseAttachment triskcaseAttachment = null;

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
    public TriskcaseAttachmentList() {
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
     * Returns the TriskcaseAttachment.
     * @return TriskcaseAttachment.
     */
    public void setTriskcaseAttachment(TriskcaseAttachment triskcaseAttachment) {
        this.triskcaseAttachment = triskcaseAttachment;
    }

    /**
     * Sets the TriskcaseAttachment.
     * @param triskcaseAttachment The triskcaseAttachment to set.
     */
    public TriskcaseAttachment getTriskcaseAttachment() {
        return this.triskcaseAttachment;
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
     * 获得TriskcaseAttachment对象列表.
     * @return List.
     */
    public List<TriskcaseAttachment> getTriskcaseAttachments() {
        return this.triskcaseAttachments;
    }
	
	public void initTriskcaseAttachments(){
	    try {
            if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));

            this.triskcaseAttachments = service.init(this.triskcaseAttachment,this.queryFields);
			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}

    /**
     * Sets the TriskcaseAttachments.
     * @param triskcaseAttachments The TriskcaseAttachments to set.
     */
    public void setTriskcaseAttachments(List triskcaseAttachments) {
        this.triskcaseAttachments = triskcaseAttachments;
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
     * 删除TriskcaseAttachment对象.
     * @return String.
     */
    public void delete() {
        try {
            TriskcaseAttachment triskcaseAttachment = triskcaseAttachments.get(rowIndex.intValue());
            String uploadUserId = triskcaseAttachment.getUserId();
            UserBean userBean = getUserBean();
            TuserInfo tuserInfo = userBean.getTuserInfo();
            String currentUserId = tuserInfo.getId();
            if(uploadUserId != null) {
            	if(!currentUserId.equals(uploadUserId)) {
            		this.addMessageString("您无权删除该附件!");
            		return;
            	} else {
            		if(triskcaseAttachment.getSubmit()) {
            			this.addMessageString("您不能删除已提交的附件!");
            			return;
            		}
            	}
            }
            service.delete(triskcaseAttachment.getId());		
            addMessage("triskcaseAttachment.message.deleted", triskcaseAttachment.getId());		
            this.triskcaseAttachments.remove(rowIndex.intValue());
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessageString("删除附件失败!");
        }
    }
    /**
     * 删除TriskcaseAttachment对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            TriskcaseAttachment triskcaseAttachment = triskcaseAttachments.get(rowIndex);

            service.delete(this.triskcaseAttachment.getId());
            addMessage("triskcaseAttachment.message.deleted", this.triskcaseAttachment.getId());				
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return null;
        }
        return null;
    }
    /**
     *    查询TriskcaseAttachment对象.
     *  @return String.
     */
    public String query() {
        try {
            this.triskcaseAttachments = service.getTriskcaseAttachmentListOfQuery(this.queryFields);
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
        return null;
    }

    public String add(){
    	Triskcase triskcase = this.triskcaseAttachment.getRiskcaseIdOfTriskcase();
    	if("6".equals(triskcase.getStatus())) {
    		this.addMessageString("该案例已结案,无法添加附件!");
    		return null;
    	}
    	this.setValueBinding("#{triskcaseAttachmentForm.triskcaseAttachment.caseno}", this.caseno);
    	this.setValueBinding("#{triskcaseAttachmentForm.triskcaseAttachment.riskcaseId}", this.riskcaseId);
    	this.setValueBinding("#{triskcaseAttachmentForm.queryFields}", this.riskcaseQueryFields);
    	return this.getSuccessAction();
    }
	
	public void multiAdd(){
		TriskcaseAttachment triskcaseAttachment = new TriskcaseAttachment();
		triskcaseAttachment.set_record_index(-1);		
    	triskcaseAttachment.set_edit_flag(TriskcaseAttachment.EDIT_FLAG_ADD);
        this.triskcaseAttachments.add(triskcaseAttachment);
    }
	
	public void popupAdd(){
		TriskcaseAttachment triskcaseAttachment = new TriskcaseAttachment();
		triskcaseAttachment.set_record_index(-1);		
    	triskcaseAttachment.set_edit_flag(TriskcaseAttachment.EDIT_FLAG_ADD);
    	this.getRequest().getSession().setAttribute("__pop_object", triskcaseAttachment); 	
    }
	
	public void popupEdit(){
		TriskcaseAttachment triskcaseAttachment = triskcaseAttachments.get(rowIndex);
    	triskcaseAttachment.set_record_index(rowIndex);
    	if (TriskcaseAttachment.EDIT_FLAG_ADD != triskcaseAttachment.get_edit_flag()){
    		triskcaseAttachment.set_edit_flag(TriskcaseAttachment.EDIT_FLAG_EDIT);
    	}    	
    	this.getRequest().getSession().setAttribute("__pop_object", triskcaseAttachment); 	
	}	
	
	public void popupView(){
		TriskcaseAttachment triskcaseAttachment = triskcaseAttachments.get(rowIndex.intValue());
    	this.getRequest().getSession().setAttribute("__pop_object", triskcaseAttachment); 	
	}	
    
    public void popupRefresh(){
    	TriskcaseAttachment triskcaseAttachment = (TriskcaseAttachment)this.getRequest().getSession().getAttribute("__pop_object");
    	if (triskcaseAttachment.get_record_index() != -1){
    		this.triskcaseAttachments.remove(triskcaseAttachment.get_record_index());
    		this.triskcaseAttachments.add(triskcaseAttachment.get_record_index(), triskcaseAttachment);
    	}
    	else{
    		this.triskcaseAttachments.add(triskcaseAttachment);
    	}
		this.getRequest().getSession().removeAttribute("__pop_object");
    }
    
    public String edit(){
        TriskcaseAttachment triskcaseAttachment = triskcaseAttachments.get(rowIndex.intValue());
        String uploadUserId = triskcaseAttachment.getUserId();
        UserBean userBean = getUserBean();
        TuserInfo tuserInfo = userBean.getTuserInfo();
        String currentUserId = tuserInfo.getId();
        if(uploadUserId != null) {
        	if(!currentUserId.equals(uploadUserId)) {
        		this.addMessageString("您无权修改该附件!");
        		return null;
        	} else {
        		if(triskcaseAttachment.getSubmit()) {
        			this.addMessageString("您不能修改已提交的附件!");
        			return null;
        		}
        	}
        }
    	triskcaseAttachment.set_record_index(rowIndex);
    	if (TriskcaseAttachment.EDIT_FLAG_ADD != triskcaseAttachment.get_edit_flag()){
    		triskcaseAttachment.set_edit_flag(TriskcaseAttachment.EDIT_FLAG_EDIT);
			this.setValueBinding("#{triskcaseAttachmentForm.triskcaseAttachmentPrimaryKey}", triskcaseAttachment.getId());
			this.setValueBinding("#{triskcaseAttachmentForm.queryFields}", this.riskcaseQueryFields);
    	}
    	return this.getSuccessAction();
    }
    
    public String view(){
        TriskcaseAttachment triskcaseAttachment = triskcaseAttachments.get(rowIndex.intValue());
		this.setValueBinding("#{triskcaseAttachmentForm.triskcaseAttachmentPrimaryKey}", triskcaseAttachment.getId());
		System.out.println("view attach list queryfields is: " + this.riskcaseQueryFields);
		this.setValueBinding("#{triskcaseAttachmentForm.queryFields}", this.riskcaseQueryFields);
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
    	TriskcaseAttachment triskcaseAttachment  = triskcaseAttachments.get(rowIndex.intValue());
    	if (TriskcaseAttachment.EDIT_FLAG_ADD != triskcaseAttachment.get_edit_flag()){
			deleteList.add(triskcaseAttachment.getId());    	
		}
		triskcaseAttachments.remove(rowIndex.intValue());
    }	
	
    public void moveUpBuffer(){
    	int i = rowIndex;
    	int j = getMovedTriskcaseAttachmentIndex(i,-1);
    	if (j == -1)
    		return ;
    	TriskcaseAttachment triskcaseAttachment = triskcaseAttachments.get(i);
    	triskcaseAttachments.add(j, triskcaseAttachment);
    	triskcaseAttachments.remove(i + 1);
    }	
	
    private int getMovedTriskcaseAttachmentIndex(int index,int step){
    	if (index + step >= 0 && index + step < triskcaseAttachments.size()){
    		TriskcaseAttachment triskcaseAttachment = triskcaseAttachments.get(index + step);
    		if (TriskcaseAttachment.EDIT_FLAG_DELETE == triskcaseAttachment.get_edit_flag())
    			return index + step + getMovedTriskcaseAttachmentIndex(index + step,step);
    		else
    			return index + step;
    	}else{
    		return -1;
    	}    	
    }	
	
    public void moveDownBuffer(){
    	int i = rowIndex;
    	int j = getMovedTriskcaseAttachmentIndex(i,1);
    	if (j == -1)
    		return ;
    	TriskcaseAttachment triskcaseAttachment = triskcaseAttachments.get(j);
    	triskcaseAttachments.add(i, triskcaseAttachment);
    	triskcaseAttachments.remove(j + 1);
    }	
    public void saveAllOfTriskcase(String triskcaseid){
    	for(String id : deleteList){
    		service.delete(id);
    	}		
    	int i = 0;
		if(this.triskcaseAttachments != null){
			for(TriskcaseAttachment triskcaseAttachment : this.triskcaseAttachments){    		
        		if (triskcaseAttachment.get_edit_flag() == TriskcaseAttachment.EDIT_FLAG_ADD || triskcaseAttachment.get_edit_flag() == TriskcaseAttachment.EDIT_FLAG_EDIT){
           			triskcaseAttachment.setRiskcaseId(triskcaseid);
        			i++;
        			service.saveTriskcaseAttachment(triskcaseAttachment);
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
            for (int i=0; i < triskcaseAttachments.size(); i++) {
                TriskcaseAttachment triskcaseAttachment = (TriskcaseAttachment)this.triskcaseAttachments.get(i);
                service.saveTriskcaseAttachment(triskcaseAttachment);
            }
	        addMessage("triskcaseAttachment.message.savedAll",null);
			return this.getSuccessAction();
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
		return null;
	}	
	
	public void deleteChecked(){
		for(TriskcaseAttachment triskcaseAttachment : this.triskcaseAttachments){
			if(triskcaseAttachment.is_checked_flag()){
				service.delete(triskcaseAttachment.getId());
			}
		}
	}
	
	public void deleteAll(){
		service.deleteAll(this.triskcaseAttachments);
	}

	public Map getRiskcaseQueryFields() {
		return riskcaseQueryFields;
	}

	public void setRiskcaseQueryFields(Map riskcaseQueryFields) {
		this.riskcaseQueryFields = riskcaseQueryFields;
	}

	public String getCaseno() {
		return caseno;
	}

	public void setCaseno(String caseno) {
		this.caseno = caseno;
	}

	public String getRiskcaseId() {
		return riskcaseId;
	}

	public void setRiskcaseId(String riskcaseId) {
		this.riskcaseId = riskcaseId;
	}


}
