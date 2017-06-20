package cn.com.brilliance.begen.webapp.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.DataModel;

import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.common.webapp.action.DataPage;
import cn.com.brilliance.begen.common.webapp.action.ListPage;
import cn.com.brilliance.begen.dao.TtransInfoDAO;
import cn.com.brilliance.begen.exception.BeGenException;
import cn.com.brilliance.begen.model.TtransInfo;
import cn.com.brilliance.begen.service.TtransInfoService;

/**
 * TtransInfo对象List.
 * @author Administrator.
 *
 */
public class TtransInfoList extends BasePage implements ListPage {

	private TtransInfoService service = (TtransInfoService)getBean("ttransInfoService");
    /**
     * ttransInfos.
     */
    private List<TtransInfo> ttransInfos;

    /**
     * dataTable.
     */
    private HtmlDataTable dataTable;

    /**
     * ttransInfo.
     */
    private TtransInfo ttransInfo = null;

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
    public TtransInfoList() {
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
     * Returns the TtransInfo.
     * @return TtransInfo.
     */
    public void setTtransInfo(TtransInfo ttransInfo) {
        this.ttransInfo = ttransInfo;
    }

    /**
     * Sets the TtransInfo.
     * @param ttransInfo The ttransInfo to set.
     */
    public TtransInfo getTtransInfo() {
        return this.ttransInfo;
    }

    /**
     * Returns the Map.
     * @return Map.
     */
    public Map getQueryFields() {
        return queryFields;
    }
    
    private boolean emptyList = false;

    public void setEmptyList(String emptyListString) {
        if ("true".equalsIgnoreCase(emptyListString) || "yes".equalsIgnoreCase(emptyListString)) {
            this.emptyList = true;
        }
        else {
            this.emptyList = false;
        }
    }

	/**
     * Sets the Map.
     * @param queryFields The Map to set.
     */
    public void setQueryFields(Map queryFields) {
        this.queryFields = queryFields;
    }

    /**
     * 获得TtransInfo对象列表.
     * @return List.
     */
//    public List<TtransInfo> getTtransInfos() {
//        return this.ttransInfos;
//    }
	
//	public void initTtransInfos(){
//		try {
//			if (dataModel == null) {
//				dataModel = new LocalDataModel(20);
//			}
//			unload = true;
//		} catch (BeGenException e) {
//            // TODO Auto-generated catch block
//            this.addMessage(e.getCode(), e.getMsg(), e);
//		}
//	}
	
    public DataModel getTtransInfos() {
	    if(this.emptyList){
			return null;
		}
		if (dataModel == null) {
			dataModel = new LocalDataModel(20);
		}
		return dataModel;
       
    }

    /**
     * Sets the TtransInfos.
     * @param ttransInfos The TtransInfos to set.
     */
    public void setTtransInfos(List ttransInfos) {
        this.ttransInfos = ttransInfos;
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
     * 删除TtransInfo对象.
     * @return String.
     */
    public void delete() {
        try {
            TtransInfo ttransInfo = ttransInfos.get(rowIndex);
            service.delete(ttransInfo.getId());		
            addMessage("ttransInfo.message.deleted", ttransInfo.getId());		
            this.ttransInfos.remove(rowIndex.intValue());
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
    }
    
	public DataPage getDataPage(int startRow, int pageSize) {
		// access database here, or call EJB to do so
		this.queryFields.put("startRow", String.valueOf(startRow));
		this.queryFields.put("pageSize", String.valueOf(pageSize));
		int total = 0;
		
		List ttransInfoList= service.getTtransInfoListOfQuery(this.queryFields);
		total = service.getTtransInfoListOfQueryCount(this.queryFields);
		DataPage dataPage = new DataPage(total , startRow, ttransInfoList);
		return dataPage;
	}
    
    
    /**
     * 删除TtransInfo对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            TtransInfo ttransInfo = ttransInfos.get(rowIndex);

            service.delete(this.ttransInfo.getId());
            addMessage("ttransInfo.message.deleted", this.ttransInfo.getId());				
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return null;
        }
        return null;
    }
    /**
     *    查询TtransInfo对象.
     *  @return String.
     */
    public String query() {
    	Date settleDt_min = (Date) this.queryFields.get("settleDt_min");
    	Date settleDt_max = (Date) this.queryFields.get("settleDt_max");
    	String priAcctNo = (String) this.queryFields.get("priAcctNo");
    	String fwdInsIdCd = (String) this.queryFields.get("fwdInsIdCd");
    	String mchntCd = (String) this.queryFields.get("mchntCd");
    	
    	
    	
    	String date = new String();
    	String date2 = new String();
    	if(settleDt_min!=null && !("").equals(settleDt_min)){
    		date = Tools.getFormatDate(settleDt_min, "yyyy-MM-dd");
		}
    	if(settleDt_max!=null && !("").equals(settleDt_max)){
    		date2 = Tools.getFormatDate(settleDt_max, "yyyy-MM-dd");
		}
    	
    	if(Tools.isEmpty(date)==null || Tools.isEmpty(date2)==null){
	    		addMessage("ttransInfo.message.queryError", null);
	    		return "t_trans_info/t_trans_info_view_list_List";
    	}
    	if(Tools.isEmpty(mchntCd)==null && Tools.isEmpty(priAcctNo)==null){
    		addMessage("ttransInfo.message.queryError", null);
    		return "t_trans_info/t_trans_info_view_list_List";    	
    	}

    	
    	
        try {
        	String hsql = " t_trans_info Partition(" + fwdInsIdCd + ") tt where";
        	
        	if(!"".equals(date)){
        		hsql = hsql + " tt.settle_dt>=to_date('" + date + "','yyyy-MM-dd') and ";
        	}
        	if(!"".equals(date2)){
        		hsql = hsql + " tt.settle_dt<=to_date('" + date2 + "','yyyy-MM-dd') and ";
        	}
        	if(!"".equals(priAcctNo)){
        		hsql = hsql + " trim(tt.pri_acct_no)='" + priAcctNo + "' and ";
        	}
        	if(!"".equals(mchntCd)){
        		hsql = hsql + " trim(tt.mchnt_cd)='" + mchntCd + "' and ";
        	}
        	if (!"".equals(hsql)) {
        		this.queryFields.put("_hsql", hsql.substring(0, hsql.length() - 5));
			}
    		if (dataModel == null) {
    			dataModel = new LocalDataModel(20);
    		}
//        	this.ttransInfos = service.getTtransInfoListOfQuery(hashMap);

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
		TtransInfo ttransInfo = new TtransInfo();
		ttransInfo.set_record_index(-1);		
    	ttransInfo.set_edit_flag(TtransInfo.EDIT_FLAG_ADD);
        this.ttransInfos.add(ttransInfo);
    }
	
	public void popupAdd(){
		TtransInfo ttransInfo = new TtransInfo();
		ttransInfo.set_record_index(-1);		
    	ttransInfo.set_edit_flag(TtransInfo.EDIT_FLAG_ADD);
    	this.getRequest().getSession().setAttribute("__pop_object", ttransInfo); 	
    }
	
	public void popupEdit(){
		TtransInfo ttransInfo = ttransInfos.get(rowIndex);
    	ttransInfo.set_record_index(rowIndex);
    	if (TtransInfo.EDIT_FLAG_ADD != ttransInfo.get_edit_flag()){
    		ttransInfo.set_edit_flag(TtransInfo.EDIT_FLAG_EDIT);
    	}    	
    	this.getRequest().getSession().setAttribute("__pop_object", ttransInfo); 	
	}	
	
	public void popupView(){
		TtransInfo ttransInfo = ttransInfos.get(rowIndex.intValue());
    	this.getRequest().getSession().setAttribute("__pop_object", ttransInfo); 	
	}	
    
    public void popupRefresh(){
    	TtransInfo ttransInfo = (TtransInfo)this.getRequest().getSession().getAttribute("__pop_object");
    	if (ttransInfo.get_record_index() != -1){
    		this.ttransInfos.remove(ttransInfo.get_record_index());
    		this.ttransInfos.add(ttransInfo.get_record_index(), ttransInfo);
    	}
    	else{
    		this.ttransInfos.add(ttransInfo);
    	}
		this.getRequest().getSession().removeAttribute("__pop_object");
    }
    
    public String edit(){
        TtransInfo ttransInfo = ttransInfos.get(rowIndex.intValue());
    	ttransInfo.set_record_index(rowIndex);
    	if (TtransInfo.EDIT_FLAG_ADD != ttransInfo.get_edit_flag()){
    		ttransInfo.set_edit_flag(TtransInfo.EDIT_FLAG_EDIT);
			this.setValueBinding("#{ttransInfoForm.ttransInfoPrimaryKey}", ttransInfo.getId());
    	}
    	return this.getSuccessAction();
    }
    
//    public String view(){
//        TtransInfo ttransInfo = ttransInfos.get(rowIndex.intValue());
//		this.setValueBinding("#{ttransInfoForm.ttransInfoPrimaryKey}", ttransInfo.getId());
//    	return this.getSuccessAction();
//    }
    
	public String view(){
		TtransInfo ttransInfo = (TtransInfo)((List)this.dataModel.getWrappedData()).get(rowIndex.intValue());
		this.setValueBinding("#{ttransInfoForm.ttransInfoPrimaryKey}", ttransInfo.getId());
		return this.getSuccessAction();
	}

    public String getHistoryUrlParameter(){
    	Iterator iter = this.getQueryFields().keySet().iterator();
    	String url = "";
    	while(iter.hasNext()){
    		String key = (String)iter.next();
    		String value = new String();
    		if(this.getQueryFields().get(key) != null && key.equals("settleDt_min")){
    			value = Tools.getFormatDate((Date) this.getQueryFields().get(key), "yyyy-MM-dd");
    		}else if(this.getQueryFields().get(key) != null && key.equals("settleDt_max")){
    			value = Tools.getFormatDate((Date) this.getQueryFields().get(key), "yyyy-MM-dd");
    		}else{
    			value = (String)this.getQueryFields().get(key);
    		}
			if(value != null && !"".equals(value))
				url += key + "=" + value + "&";
    	}
    	return url;
    }
	
    public void deleteBuffer(){
    	TtransInfo ttransInfo  = ttransInfos.get(rowIndex.intValue());
    	if (TtransInfo.EDIT_FLAG_ADD != ttransInfo.get_edit_flag()){
			deleteList.add(ttransInfo.getId());    	
		}
		ttransInfos.remove(rowIndex.intValue());
    }	
	
    public void moveUpBuffer(){
    	int i = rowIndex;
    	int j = getMovedTtransInfoIndex(i,-1);
    	if (j == -1)
    		return ;
    	TtransInfo ttransInfo = ttransInfos.get(i);
    	ttransInfos.add(j, ttransInfo);
    	ttransInfos.remove(i + 1);
    }	
	
    private int getMovedTtransInfoIndex(int index,int step){
    	if (index + step >= 0 && index + step < ttransInfos.size()){
    		TtransInfo ttransInfo = ttransInfos.get(index + step);
    		if (TtransInfo.EDIT_FLAG_DELETE == ttransInfo.get_edit_flag())
    			return index + step + getMovedTtransInfoIndex(index + step,step);
    		else
    			return index + step;
    	}else{
    		return -1;
    	}    	
    }	
	
    public void moveDownBuffer(){
    	int i = rowIndex;
    	int j = getMovedTtransInfoIndex(i,1);
    	if (j == -1)
    		return ;
    	TtransInfo ttransInfo = ttransInfos.get(j);
    	ttransInfos.add(i, ttransInfo);
    	ttransInfos.remove(j + 1);
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
            for (int i=0; i < ttransInfos.size(); i++) {
                TtransInfo ttransInfo = (TtransInfo)this.ttransInfos.get(i);
                service.saveTtransInfo(ttransInfo);
            }
	        addMessage("ttransInfo.message.savedAll",null);
			return this.getSuccessAction();
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
		return null;
	}	
	
	public void deleteChecked(){
		for(TtransInfo ttransInfo : this.ttransInfos){
			if(ttransInfo.is_checked_flag()){
				service.delete(ttransInfo.getId());
			}
		}
	}
	
	public void deleteAll(){
		service.deleteAll(this.ttransInfos);
	}
}
