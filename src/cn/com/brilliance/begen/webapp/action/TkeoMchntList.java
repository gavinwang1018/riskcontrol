package cn.com.brilliance.begen.webapp.action;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.DataModel;

import cn.com.brilliance.begen.exception.BeGenException;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.TkeoMchntService;
import cn.com.brilliance.begen.webapp.action.BasePage;
import cn.com.brilliance.begen.common.webapp.action.DataPage;
import cn.com.brilliance.begen.common.webapp.action.ListPage;

/**
 * TkeoMchnt对象List.
 * @author Administrator.
 *
 */
public class TkeoMchntList extends BasePage implements ListPage {

	private TkeoMchntService service = (TkeoMchntService)getBean("tkeoMchntService");
    /**
     * tkeoMchnts.
     */
    private List<TkeoMchnt> tkeoMchnts;

    /**
     * dataTable.
     */
    private HtmlDataTable dataTable;

    /**
     * tkeoMchnt.
     */
    private TkeoMchnt tkeoMchnt = null;

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
     * emptyList.
     */
    private boolean emptyList = false;

    /**
     * 默认构造函数.
     */
    public TkeoMchntList() {
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
     * Returns the TkeoMchnt.
     * @return TkeoMchnt.
     */
    public void setTkeoMchnt(TkeoMchnt tkeoMchnt) {
        this.tkeoMchnt = tkeoMchnt;
    }

    /**
     * Sets the TkeoMchnt.
     * @param tkeoMchnt The tkeoMchnt to set.
     */
    public TkeoMchnt getTkeoMchnt() {
        return this.tkeoMchnt;
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
     * 获得TkeoMchnt对象列表.
     * @return List.
     */
    public DataModel getTkeoMchnts() {
    	System.out.println("load dataModel...");
		if(this.emptyList){
			return null;
		}
		if (dataModel == null) {
			dataModel = new LocalDataModel(COMMON_PAGE_SIZE);
		}
		return dataModel;
    }
	
	/*public void initTkeoMchnts(){
	    try {
            if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));

            this.tkeoMchnts = service.init(this.tkeoMchnt,this.queryFields);
			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}*/

    /**
     * Sets the TkeoMchnts.
     * @param tkeoMchnts The TkeoMchnts to set.
     */
    public void setTkeoMchnts(List tkeoMchnts) {
        this.tkeoMchnts = tkeoMchnts;
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
     * 删除TkeoMchnt对象.
     * @return String.
     */
    public void delete() {
        try {
            TkeoMchnt tkeoMchnt = (TkeoMchnt)((List) dataModel.getWrappedData()).get(rowIndex.intValue());
            service.delete(tkeoMchnt.getId());		
            addMessage("tkeoMchnt.message.deleted", tkeoMchnt.getId());		
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
    }
    /**
     * 删除TkeoMchnt对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            TkeoMchnt tkeoMchnt = tkeoMchnts.get(rowIndex);

            service.delete(this.tkeoMchnt.getId());
            addMessage("tkeoMchnt.message.deleted", this.tkeoMchnt.getId());				
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return null;
        }
        return null;
    }
    /**
     *    查询TkeoMchnt对象.
     *  @return String.
     */
    public String query() {
        try {
        	if (dataModel == null) {
				dataModel = new LocalDataModel(COMMON_PAGE_SIZE);
			}
            
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
        return null;
    }


    public DataPage getDataPage(int startRow, int pageSize) {
		// access database here, or call EJB to do so
    	System.out.println("diroeiroeo");
		this.queryFields.put("startRow", String.valueOf(startRow));
		this.queryFields.put("pageSize", String.valueOf(pageSize));
		int total = 0;
			
		this.tkeoMchnts = service.getTkeoMchntListOfQuery(this.queryFields);
		total = service.getTkeoMchntListOfQueryCount(this.queryFields);
		
		System.out.println("total is:" + total);
		DataPage dataPage = new DataPage(total , startRow, this.tkeoMchnts);
		return dataPage;
	}

	public void setEmptyList(String emptyListString) {
        if ("true".equalsIgnoreCase(emptyListString) || "yes".equalsIgnoreCase(emptyListString)) {
            this.emptyList = true;
        }
        else {
            this.emptyList = false;
        }
    }
    

    public String add(){
    	return this.getSuccessAction();
    }
	
	public void multiAdd(){
		TkeoMchnt tkeoMchnt = new TkeoMchnt();
		tkeoMchnt.set_record_index(-1);		
    	tkeoMchnt.set_edit_flag(TkeoMchnt.EDIT_FLAG_ADD);
        this.tkeoMchnts.add(tkeoMchnt);
    }
	
	public void popupAdd(){
		TkeoMchnt tkeoMchnt = new TkeoMchnt();
		tkeoMchnt.set_record_index(-1);		
    	tkeoMchnt.set_edit_flag(TkeoMchnt.EDIT_FLAG_ADD);
    	this.getRequest().getSession().setAttribute("__pop_object", tkeoMchnt); 	
    }
	
	public void popupEdit(){
		TkeoMchnt tkeoMchnt = tkeoMchnts.get(rowIndex);
    	tkeoMchnt.set_record_index(rowIndex);
    	if (TkeoMchnt.EDIT_FLAG_ADD != tkeoMchnt.get_edit_flag()){
    		tkeoMchnt.set_edit_flag(TkeoMchnt.EDIT_FLAG_EDIT);
    	}    	
    	this.getRequest().getSession().setAttribute("__pop_object", tkeoMchnt); 	
	}	
	
	public void popupView(){
		TkeoMchnt tkeoMchnt = tkeoMchnts.get(rowIndex.intValue());
    	this.getRequest().getSession().setAttribute("__pop_object", tkeoMchnt); 	
	}	
    
    public void popupRefresh(){
    	TkeoMchnt tkeoMchnt = (TkeoMchnt)this.getRequest().getSession().getAttribute("__pop_object");
    	if (tkeoMchnt.get_record_index() != -1){
    		this.tkeoMchnts.remove(tkeoMchnt.get_record_index());
    		this.tkeoMchnts.add(tkeoMchnt.get_record_index(), tkeoMchnt);
    	}
    	else{
    		this.tkeoMchnts.add(tkeoMchnt);
    	}
		this.getRequest().getSession().removeAttribute("__pop_object");
    }
    
    public String edit(){
        //TkeoMchnt tkeoMchnt = tkeoMchnts.get(rowIndex.intValue());
        TkeoMchnt tkeoMchnt = (TkeoMchnt)((List) dataModel.getWrappedData()).get(rowIndex.intValue());
    	tkeoMchnt.set_record_index(rowIndex);
    	if (TkeoMchnt.EDIT_FLAG_ADD != tkeoMchnt.get_edit_flag()){
    		tkeoMchnt.set_edit_flag(TkeoMchnt.EDIT_FLAG_EDIT);
			this.setValueBinding("#{tkeoMchntForm.tkeoMchntPrimaryKey}", tkeoMchnt.getId());
    	}
    	return this.getSuccessAction();
    }
    
    public String view(){
        TkeoMchnt tkeoMchnt = tkeoMchnts.get(rowIndex.intValue());
		this.setValueBinding("#{tkeoMchntForm.tkeoMchntPrimaryKey}", tkeoMchnt.getId());
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
    	TkeoMchnt tkeoMchnt  = tkeoMchnts.get(rowIndex.intValue());
    	if (TkeoMchnt.EDIT_FLAG_ADD != tkeoMchnt.get_edit_flag()){
			deleteList.add(tkeoMchnt.getId());    	
		}
		tkeoMchnts.remove(rowIndex.intValue());
    }	
	
    public void moveUpBuffer(){
    	int i = rowIndex;
    	int j = getMovedTkeoMchntIndex(i,-1);
    	if (j == -1)
    		return ;
    	TkeoMchnt tkeoMchnt = tkeoMchnts.get(i);
    	tkeoMchnts.add(j, tkeoMchnt);
    	tkeoMchnts.remove(i + 1);
    }	
	
    private int getMovedTkeoMchntIndex(int index,int step){
    	if (index + step >= 0 && index + step < tkeoMchnts.size()){
    		TkeoMchnt tkeoMchnt = tkeoMchnts.get(index + step);
    		if (TkeoMchnt.EDIT_FLAG_DELETE == tkeoMchnt.get_edit_flag())
    			return index + step + getMovedTkeoMchntIndex(index + step,step);
    		else
    			return index + step;
    	}else{
    		return -1;
    	}    	
    }	
	
    public void moveDownBuffer(){
    	int i = rowIndex;
    	int j = getMovedTkeoMchntIndex(i,1);
    	if (j == -1)
    		return ;
    	TkeoMchnt tkeoMchnt = tkeoMchnts.get(j);
    	tkeoMchnts.add(i, tkeoMchnt);
    	tkeoMchnts.remove(j + 1);
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
            for (int i=0; i < tkeoMchnts.size(); i++) {
                TkeoMchnt tkeoMchnt = (TkeoMchnt)this.tkeoMchnts.get(i);
                service.saveTkeoMchnt(tkeoMchnt);
            }
	        addMessage("tkeoMchnt.message.savedAll",null);
			return this.getSuccessAction();
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
		return null;
	}	
	
	public void deleteChecked(){
		for(TkeoMchnt tkeoMchnt : this.tkeoMchnts){
			if(tkeoMchnt.is_checked_flag()){
				service.delete(tkeoMchnt.getId());
			}
		}
	}
	
	public void deleteAll(){
		service.deleteAll(this.tkeoMchnts);
	}
}
