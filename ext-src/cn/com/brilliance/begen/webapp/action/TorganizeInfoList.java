package cn.com.brilliance.begen.webapp.action;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import javax.faces.component.html.HtmlDataTable;

import cn.com.brilliance.begen.exception.BeGenException;
import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.TorganizeInfoService;
import cn.com.brilliance.begen.webapp.action.BasePage;
import cn.com.brilliance.begen.common.webapp.action.ListPage;
import cn.com.brilliance.risk.ext.common.Function;

/**
 * TorganizeInfo对象List.
 * @author Administrator.
 *
 */
public class TorganizeInfoList extends BasePage implements ListPage {

	private TorganizeInfoService service = (TorganizeInfoService)getBean("torganizeInfoService");
    /**
     * torganizeInfos.
     */
    private List<TorganizeInfo> torganizeInfos;

    /**
     * dataTable.
     */
    private HtmlDataTable dataTable;

    /**
     * torganizeInfo.
     */
    private TorganizeInfo torganizeInfo = null;

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
    public TorganizeInfoList() {
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
     * Returns the TorganizeInfo.
     * @return TorganizeInfo.
     */
    public void setTorganizeInfo(TorganizeInfo torganizeInfo) {
        this.torganizeInfo = torganizeInfo;
    }

    /**
     * Sets the TorganizeInfo.
     * @param torganizeInfo The torganizeInfo to set.
     */
    public TorganizeInfo getTorganizeInfo() {
        return this.torganizeInfo;
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
     * 获得TorganizeInfo对象列表.
     * @return List.
     */
    public List<TorganizeInfo> getTorganizeInfos() {
		if (this.sortColumn != null)
			sort(getSortColumn(), isAscending());
		return this.torganizeInfos;
	}
	
	private void sort(final String column, final boolean ascending) {
		Comparator comparator = new Comparator() {
			public int compare(Object o1, Object o2) {
				TorganizeInfo t1 = (TorganizeInfo) o1;
				TorganizeInfo t2 = (TorganizeInfo) o2;

				if (column == null) {
					return 0;
				}

				String name1 = Tools.null2String(t1.getName());
				String name2 = Tools.null2String(t2.getName());
				String dwFlag1 = Tools.null2String(t1.getDwFlag().toString());
				String dwFlag2 = Tools.null2String(t2.getDwFlag().toString());

				if (column.equals("name")) {
					return ascending ? name1.compareTo(name2) : name2
							.compareTo(name1);
				} else if (column.equals("dwFlag")) {
					return ascending ? dwFlag1.compareTo(dwFlag2) : dwFlag2
							.compareTo(dwFlag1);
				} else
					return 0;
			}
		};
		Collections.sort(this.torganizeInfos, comparator);
	} 
	
	public void initTorganizeInfos(){
	    try {
            if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));

            this.torganizeInfos = service.init(this.torganizeInfo,this.queryFields);
			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}

    /**
     * Sets the TorganizeInfos.
     * @param torganizeInfos The TorganizeInfos to set.
     */
    public void setTorganizeInfos(List torganizeInfos) {
        this.torganizeInfos = torganizeInfos;
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
     * 删除TorganizeInfo对象.
     * @return String.
     */
    public void delete() {
        try {
            TorganizeInfo torganizeInfo = torganizeInfos.get(rowIndex);
            service.delete(torganizeInfo.getId());		
            addMessage("torganizeInfo.message.deleted", torganizeInfo.getName());		
            this.torganizeInfos.remove(rowIndex.intValue());
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
    }
    /**
     * 删除TorganizeInfo对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            TorganizeInfo torganizeInfo = torganizeInfos.get(rowIndex);
            if (torganizeInfo.getTmchntAppGroup().size() > 0) {
                this.addMessageString("exception.delete.cascade");
                return null;
            }
            if (torganizeInfo.getTriskprocessTimelimitGroup().size() > 0) {
                this.addMessageString("exception.delete.cascade");
                return null;
            }

            service.delete(this.torganizeInfo.getId());
            addMessage("torganizeInfo.message.deleted", this.torganizeInfo.getName());				
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return null;
        }
        return null;
    }
    /**
     *    查询TorganizeInfo对象.
     *  @return String.
     */
    public String query() {
		try {
			String orgId = this.getUserBean().getTuserInfo().getOrganizeId();
			String globalSort = this.getUserBean().getTuserInfo()
					.getOrganizeIdOfTorganizeInfo().getGlobalSort();

			if (!Function.isParentCompany(orgId)) {
				this.queryFields.put("globalSort_like", globalSort);
			}
			this.torganizeInfos = service
					.getTorganizeInfoListOfQuery(this.queryFields);
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
		TorganizeInfo torganizeInfo = new TorganizeInfo();
		torganizeInfo.set_record_index(-1);		
    	torganizeInfo.set_edit_flag(TorganizeInfo.EDIT_FLAG_ADD);
        this.torganizeInfos.add(torganizeInfo);
    }
	
	public void popupAdd(){
		TorganizeInfo torganizeInfo = new TorganizeInfo();
		torganizeInfo.set_record_index(-1);		
    	torganizeInfo.set_edit_flag(TorganizeInfo.EDIT_FLAG_ADD);
    	this.getRequest().getSession().setAttribute("__pop_object", torganizeInfo); 	
    }
	
	public void popupEdit(){
		TorganizeInfo torganizeInfo = torganizeInfos.get(rowIndex);
    	torganizeInfo.set_record_index(rowIndex);
    	if (TorganizeInfo.EDIT_FLAG_ADD != torganizeInfo.get_edit_flag()){
    		torganizeInfo.set_edit_flag(TorganizeInfo.EDIT_FLAG_EDIT);
    	}    	
    	this.getRequest().getSession().setAttribute("__pop_object", torganizeInfo); 	
	}	
	
	public void popupView(){
		TorganizeInfo torganizeInfo = torganizeInfos.get(rowIndex.intValue());
    	this.getRequest().getSession().setAttribute("__pop_object", torganizeInfo); 	
	}	
    
    public void popupRefresh(){
    	TorganizeInfo torganizeInfo = (TorganizeInfo)this.getRequest().getSession().getAttribute("__pop_object");
    	if (torganizeInfo.get_record_index() != -1){
    		this.torganizeInfos.remove(torganizeInfo.get_record_index());
    		this.torganizeInfos.add(torganizeInfo.get_record_index(), torganizeInfo);
    	}
    	else{
    		this.torganizeInfos.add(torganizeInfo);
    	}
		this.getRequest().getSession().removeAttribute("__pop_object");
    }
    
    public String edit(){
        TorganizeInfo torganizeInfo = torganizeInfos.get(rowIndex.intValue());
    	torganizeInfo.set_record_index(rowIndex);
    	if (TorganizeInfo.EDIT_FLAG_ADD != torganizeInfo.get_edit_flag()){
    		torganizeInfo.set_edit_flag(TorganizeInfo.EDIT_FLAG_EDIT);
			this.setValueBinding("#{torganizeInfoForm.torganizeInfoPrimaryKey}", torganizeInfo.getId());
    	}
    	return this.getSuccessAction();
    }
    
    public String view(){
        TorganizeInfo torganizeInfo = torganizeInfos.get(rowIndex.intValue());
		this.setValueBinding("#{torganizeInfoForm.torganizeInfoPrimaryKey}", torganizeInfo.getId());
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
    	TorganizeInfo torganizeInfo  = torganizeInfos.get(rowIndex.intValue());
    	if (TorganizeInfo.EDIT_FLAG_ADD != torganizeInfo.get_edit_flag()){
			deleteList.add(torganizeInfo.getId());    	
		}
		torganizeInfos.remove(rowIndex.intValue());
    }	
	
    public void moveUpBuffer(){
    	int i = rowIndex;
    	int j = getMovedTorganizeInfoIndex(i,-1);
    	if (j == -1)
    		return ;
    	TorganizeInfo torganizeInfo = torganizeInfos.get(i);
    	torganizeInfos.add(j, torganizeInfo);
    	torganizeInfos.remove(i + 1);
    }	
	
    private int getMovedTorganizeInfoIndex(int index,int step){
    	if (index + step >= 0 && index + step < torganizeInfos.size()){
    		TorganizeInfo torganizeInfo = torganizeInfos.get(index + step);
    		if (TorganizeInfo.EDIT_FLAG_DELETE == torganizeInfo.get_edit_flag())
    			return index + step + getMovedTorganizeInfoIndex(index + step,step);
    		else
    			return index + step;
    	}else{
    		return -1;
    	}    	
    }	
	
    public void moveDownBuffer(){
    	int i = rowIndex;
    	int j = getMovedTorganizeInfoIndex(i,1);
    	if (j == -1)
    		return ;
    	TorganizeInfo torganizeInfo = torganizeInfos.get(j);
    	torganizeInfos.add(i, torganizeInfo);
    	torganizeInfos.remove(j + 1);
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
            for (int i=0; i < torganizeInfos.size(); i++) {
                TorganizeInfo torganizeInfo = (TorganizeInfo)this.torganizeInfos.get(i);
                service.saveTorganizeInfo(torganizeInfo);
            }
	        addMessage("torganizeInfo.message.savedAll",null);
			return this.getSuccessAction();
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
		return null;
	}	
	
	public void deleteChecked(){
		for(TorganizeInfo torganizeInfo : this.torganizeInfos){
			if(torganizeInfo.is_checked_flag()){
				service.delete(torganizeInfo.getId());
			}
		}
	}
	
	public void deleteAll(){
		service.deleteAll(this.torganizeInfos);
	}
}
