package cn.com.brilliance.begen.webapp.action;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.faces.component.html.HtmlDataTable;

import cn.com.brilliance.begen.dao.TorganizeInfoDAO;
import cn.com.brilliance.begen.dao.TriskcaseDAO;
import cn.com.brilliance.begen.dao.TuserInfoDAO;
import cn.com.brilliance.begen.exception.BeGenException;
import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.TriskcaseRecordService;
import cn.com.brilliance.begen.webapp.action.BasePage;
import cn.com.brilliance.begen.webapp.servlet.UserBean;
import cn.com.brilliance.begen.common.webapp.action.ListPage;

/**
 * TriskcaseRecord对象List.
 * @author Administrator.
 *
 */
public class TriskcaseRecordList extends BasePage implements ListPage {

	private TriskcaseRecordService service = (TriskcaseRecordService)getBean("triskcaseRecordService");
    /**
     * triskcaseRecords.
     */
    private List<TriskcaseRecord> triskcaseRecords;
    
    private String caseno;
    
    private String riskcaseId;

    /**
     * dataTable.
     */
    private HtmlDataTable dataTable;
    

    private Map riskcaseQueryFields;;
    /**
     * triskcaseRecord.
     */
    private TriskcaseRecord triskcaseRecord = null;

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
    public TriskcaseRecordList() {
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
     * Returns the TriskcaseRecord.
     * @return TriskcaseRecord.
     */
    public void setTriskcaseRecord(TriskcaseRecord triskcaseRecord) {
        this.triskcaseRecord = triskcaseRecord;
    }

    /**
     * Sets the TriskcaseRecord.
     * @param triskcaseRecord The triskcaseRecord to set.
     */
    public TriskcaseRecord getTriskcaseRecord() {
        return this.triskcaseRecord;
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
     * 获得TriskcaseRecord对象列表.
     * @return List.
     */
    public List<TriskcaseRecord> getTriskcaseRecords() {
        return this.triskcaseRecords;
    }
	
	public void initTriskcaseRecords(){
	    try {
            if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));

            this.triskcaseRecords = service.init(this.triskcaseRecord,this.queryFields);
			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}

    /**
     * Sets the TriskcaseRecords.
     * @param triskcaseRecords The TriskcaseRecords to set.
     */
    public void setTriskcaseRecords(List triskcaseRecords) {
        this.triskcaseRecords = triskcaseRecords;
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
     * 删除TriskcaseRecord对象.
     * @return String.
     */
    public void delete() {
        try {
            TriskcaseRecord triskcaseRecord = triskcaseRecords.get(rowIndex);
            if(triskcaseRecord.getSubmit()) {
            	this.addMessageString("该案例已被锁定,不能删除!");
            	return;
            }
//            String uploadUserId = triskcaseRecord.getUserId();
//            UserBean userBean = getUserBean();
//            TuserInfo tuserInfo = userBean.getTuserInfo();
//            String currentOrganizeId = tuserInfo.getOrganizeId();
//            Integer currentLevel = this.getOrganizeLevel(currentOrganizeId);
//            if(triskcaseRecord.getSubmit() != null) {
//	            if (getOrganizeValue(uploadUserId, currentOrganizeId) == 0
//						&& triskcaseRecord.getSubmit() && currentLevel.intValue() != 1) {
//					this.addMessageString("您不能删除已提交的登记要素!");
//					return;
//				} else if(getOrganizeValue(uploadUserId, currentOrganizeId) == -1) {
//					this.addMessageString("您无权删除上级机构提交的登记要素!");
//					return;
//				}
//            }
            service.delete(triskcaseRecord.getId());		
            addMessage("triskcaseRecord.message.deleted", triskcaseRecord.getId());		
            this.triskcaseRecords.remove(rowIndex.intValue());
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
    }
    /**
     * 删除TriskcaseRecord对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            TriskcaseRecord triskcaseRecord = triskcaseRecords.get(rowIndex);

            service.delete(this.triskcaseRecord.getId());
            addMessage("triskcaseRecord.message.deleted", this.triskcaseRecord.getId());				
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return null;
        }
        return null;
    }
    /**
     *    查询TriskcaseRecord对象.
     *  @return String.
     */
    public String query() {
        try {
            this.triskcaseRecords = service.getTriskcaseRecordListOfQuery(this.queryFields);
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
        return null;
    }




    public String add(){
    	Triskcase triskcase = this.triskcaseRecord.getRiskcaseIdOfTriskcase();
    	String riskcaseId = triskcase.getId();
//    	if(isCloseCase(riskcaseId)) {
//        	this.addMessageString("不能添加已结案案例的登记要素!");
//        	return null;
//        }
    	Set set = triskcase.getTriskcaseRecordGroup();
    	boolean flag = false;
    	for(Iterator it = set.iterator(); it.hasNext();) {
    		TriskcaseRecord triskcaseRecord = (TriskcaseRecord)it.next();
    		if(!triskcaseRecord.getSubmit()) {
    			flag = true;
    			break;
    		}
    	}
    	if(flag) {
    		this.addMessageString("您的处理结果还未提交到总公司,请在原记录上修改!");
    		return null;
    	}
    	this.setValueBinding("#{triskcaseRecordForm.queryFields}", this.riskcaseQueryFields);
    	this.setValueBinding("#{triskcaseRecordForm.triskcaseRecord.caseno}", this.caseno);
    	this.setValueBinding("#{triskcaseRecordForm.triskcaseRecord.riskcaseId}", this.riskcaseId);
    	return this.getSuccessAction();
    }
	
	public void multiAdd(){
		TriskcaseRecord triskcaseRecord = new TriskcaseRecord();
		triskcaseRecord.set_record_index(-1);		
    	triskcaseRecord.set_edit_flag(TriskcaseRecord.EDIT_FLAG_ADD);
        this.triskcaseRecords.add(triskcaseRecord);
    }
	
	public void popupAdd(){
		TriskcaseRecord triskcaseRecord = new TriskcaseRecord();
		triskcaseRecord.set_record_index(-1);		
    	triskcaseRecord.set_edit_flag(TriskcaseRecord.EDIT_FLAG_ADD);
    	this.getRequest().getSession().setAttribute("__pop_object", triskcaseRecord); 	
    }
	
	public void popupEdit(){
		TriskcaseRecord triskcaseRecord = triskcaseRecords.get(rowIndex);
    	triskcaseRecord.set_record_index(rowIndex);
    	if (TriskcaseRecord.EDIT_FLAG_ADD != triskcaseRecord.get_edit_flag()){
    		triskcaseRecord.set_edit_flag(TriskcaseRecord.EDIT_FLAG_EDIT);
    	}    	
    	this.getRequest().getSession().setAttribute("__pop_object", triskcaseRecord); 	
	}	
	
	public void popupView(){
		TriskcaseRecord triskcaseRecord = triskcaseRecords.get(rowIndex.intValue());
    	this.getRequest().getSession().setAttribute("__pop_object", triskcaseRecord); 	
	}	
    
    public void popupRefresh(){
    	TriskcaseRecord triskcaseRecord = (TriskcaseRecord)this.getRequest().getSession().getAttribute("__pop_object");
    	if (triskcaseRecord.get_record_index() != -1){
    		this.triskcaseRecords.remove(triskcaseRecord.get_record_index());
    		this.triskcaseRecords.add(triskcaseRecord.get_record_index(), triskcaseRecord);
    	}
    	else{
    		this.triskcaseRecords.add(triskcaseRecord);
    	}
		this.getRequest().getSession().removeAttribute("__pop_object");
    }
    
    public String edit(){
        TriskcaseRecord triskcaseRecord = triskcaseRecords.get(rowIndex.intValue());
        if(triskcaseRecord.getSubmit()) {
        	this.addMessageString("该处理结果已被锁定,请重新增加处理结果!");
        	return null;
        }
//        String uploadUserId = triskcaseRecord.getUserId();
//        UserBean userBean = getUserBean();
//        TuserInfo tuserInfo = userBean.getTuserInfo();
//        String currentOrganizeId = tuserInfo.getOrganizeId();
//        if(triskcaseRecord.getSubmit() != null) {
//            if (getOrganizeValue(uploadUserId, currentOrganizeId) == 0
//					&& triskcaseRecord.getSubmit()) {
//				this.addMessageString("您不能编辑已提交的登记要素!");
//				return null;
//			} else if(getOrganizeValue(uploadUserId, currentOrganizeId) == -1) {
//				this.addMessageString("您无权编辑上级机构提交的登记要素!");
//				return null;
//			}
//        }
    	triskcaseRecord.set_record_index(rowIndex);
    	if (TriskcaseRecord.EDIT_FLAG_ADD != triskcaseRecord.get_edit_flag()){
    		triskcaseRecord.set_edit_flag(TriskcaseRecord.EDIT_FLAG_EDIT);
			this.setValueBinding("#{triskcaseRecordForm.triskcaseRecordPrimaryKey}", triskcaseRecord.getId());
			this.setValueBinding("#{triskcaseRecordForm.triskcasePrimaryKey}", triskcaseRecord.getRiskcaseId());
			this.setValueBinding("#{triskcaseRecordForm.queryFields}", this.riskcaseQueryFields);			
			
    	}
    	return this.getSuccessAction();
    }
    
    public String view(){
        TriskcaseRecord triskcaseRecord = triskcaseRecords.get(rowIndex.intValue());
		this.setValueBinding("#{triskcaseRecordForm.triskcaseRecordPrimaryKey}", triskcaseRecord.getId());
		this.setValueBinding("#{triskcaseRecordForm.triskcasePrimaryKey}", triskcaseRecord.getRiskcaseId());
		this.setValueBinding("#{triskcaseRecordForm.queryFields}", this.riskcaseQueryFields);
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
    	TriskcaseRecord triskcaseRecord  = triskcaseRecords.get(rowIndex.intValue());
    	if (TriskcaseRecord.EDIT_FLAG_ADD != triskcaseRecord.get_edit_flag()){
			deleteList.add(triskcaseRecord.getId());    	
		}
		triskcaseRecords.remove(rowIndex.intValue());
    }	
	
    public void moveUpBuffer(){
    	int i = rowIndex;
    	int j = getMovedTriskcaseRecordIndex(i,-1);
    	if (j == -1)
    		return ;
    	TriskcaseRecord triskcaseRecord = triskcaseRecords.get(i);
    	triskcaseRecords.add(j, triskcaseRecord);
    	triskcaseRecords.remove(i + 1);
    }	
	
    private int getMovedTriskcaseRecordIndex(int index,int step){
    	if (index + step >= 0 && index + step < triskcaseRecords.size()){
    		TriskcaseRecord triskcaseRecord = triskcaseRecords.get(index + step);
    		if (TriskcaseRecord.EDIT_FLAG_DELETE == triskcaseRecord.get_edit_flag())
    			return index + step + getMovedTriskcaseRecordIndex(index + step,step);
    		else
    			return index + step;
    	}else{
    		return -1;
    	}    	
    }	
	
    public void moveDownBuffer(){
    	int i = rowIndex;
    	int j = getMovedTriskcaseRecordIndex(i,1);
    	if (j == -1)
    		return ;
    	TriskcaseRecord triskcaseRecord = triskcaseRecords.get(j);
    	triskcaseRecords.add(i, triskcaseRecord);
    	triskcaseRecords.remove(j + 1);
    }	
    public void saveAllOfTriskcase(String triskcaseid){
    	for(String id : deleteList){
    		service.delete(id);
    	}		
    	int i = 0;
		if(this.triskcaseRecords != null){
			for(TriskcaseRecord triskcaseRecord : this.triskcaseRecords){    		
        		if (triskcaseRecord.get_edit_flag() == TriskcaseRecord.EDIT_FLAG_ADD || triskcaseRecord.get_edit_flag() == TriskcaseRecord.EDIT_FLAG_EDIT){
           			triskcaseRecord.setRiskcaseId(triskcaseid);
        			i++;
        			service.saveTriskcaseRecord(triskcaseRecord);
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
            for (int i=0; i < triskcaseRecords.size(); i++) {
                TriskcaseRecord triskcaseRecord = (TriskcaseRecord)this.triskcaseRecords.get(i);
                service.saveTriskcaseRecord(triskcaseRecord);
            }
	        addMessage("triskcaseRecord.message.savedAll",null);
			return this.getSuccessAction();
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
		return null;
	}	
	
	public void deleteChecked(){
		for(TriskcaseRecord triskcaseRecord : this.triskcaseRecords){
			if(triskcaseRecord.is_checked_flag()){
				service.delete(triskcaseRecord.getId());
			}
		}
	}
	
	public void deleteAll(){
		service.deleteAll(this.triskcaseRecords);
	}
	
	private Integer getOrganizeLevel(String organizeId) {
		TorganizeInfoDAO torganizeInfoDAO = (TorganizeInfoDAO)getBean("torganizeInfoDAO");
		TorganizeInfo torganizeInfo = torganizeInfoDAO.getTorganizeInfo(organizeId);
		return torganizeInfo.getOrganizeLevel();
	}
	
	private boolean isCloseCase(String riskcaseId) {
		TriskcaseDAO triskcaseDAO = (TriskcaseDAO)getBean("triskcaseDAO");
		Triskcase triskcase = triskcaseDAO.getTriskcase(riskcaseId);
		if("6".equals(triskcase.getStatus())) {
			return true;
		}
		return false;
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
