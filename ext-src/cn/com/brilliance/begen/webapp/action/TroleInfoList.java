package cn.com.brilliance.begen.webapp.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlDataTable;

import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.common.webapp.action.ListPage;
import cn.com.brilliance.begen.exception.BeGenException;
import cn.com.brilliance.begen.model.TroleInfo;
import cn.com.brilliance.begen.model.TuserInfo;
import cn.com.brilliance.begen.service.TroleInfoService;
import cn.com.brilliance.risk.ext.common.Function;

/**
 * TroleInfo对象List.
 * @author Administrator.
 *
 */
public class TroleInfoList extends BasePage implements ListPage {

	private TroleInfoService service = (TroleInfoService)getBean("troleInfoService");
	
    /**
     * troleInfos.
     */
    private List<TroleInfo> troleInfos;

    /**
     * dataTable.
     */
    private HtmlDataTable dataTable;

    /**
     * troleInfo.
     */
    private TroleInfo troleInfo = null;

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
    public TroleInfoList() {
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
     * Returns the TroleInfo.
     * @return TroleInfo.
     */
    public void setTroleInfo(TroleInfo troleInfo) {
        this.troleInfo = troleInfo;
    }

    /**
     * Sets the TroleInfo.
     * @param troleInfo The troleInfo to set.
     */
    public TroleInfo getTroleInfo() {
        return this.troleInfo;
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
     * 获得TroleInfo对象列表.
     * @return List.
     */
    public List<TroleInfo> getTroleInfos() {
		if (this.sortColumn != null)
			sort(getSortColumn(), isAscending());
		return this.troleInfos;
	}

	private void sort(final String column, final boolean ascending) {
		Comparator comparator = new Comparator() {
			public int compare(Object o1, Object o2) {
				TroleInfo t1 = (TroleInfo) o1;
				TroleInfo t2 = (TroleInfo) o2;

				if (column == null) {
					return 0;
				}

				String name1 = Tools.null2String(t1.getName());
				String name2 = Tools.null2String(t2.getName());
				String code1 = Tools.null2String(t1.getCode());
				String code2 = Tools.null2String(t2.getCode());

				if (column.equals("name")) {
					return ascending ? name1.compareTo(name2) : name2
							.compareTo(name1);
				} else if (column.equals("code")) {
					return ascending ? code1.compareTo(code2) : code2
							.compareTo(code1);
				} else
					return 0;
			}
		};
		Collections.sort(this.troleInfos, comparator);
	}  
	
	public void initTroleInfos(){
	    try {
            if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));

            this.troleInfos = service.init(this.troleInfo,this.queryFields);
			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}

    /**
     * Sets the TroleInfos.
     * @param troleInfos The TroleInfos to set.
     */
    public void setTroleInfos(List troleInfos) {
        this.troleInfos = troleInfos;
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

	public void delete() {
		try {
			TroleInfo troleInfo = troleInfos.get(rowIndex);
			if (!Function.hasChild(troleInfo.getId())) {
				service.delete(troleInfo.getId());
				addMessage("troleInfo.message.deleted", troleInfo.getId());
				this.troleInfos.remove(rowIndex.intValue());
			} else {
				addMessage("troleInfo.message.hasChild", troleInfo.getId());
			}
		} catch (BeGenException e) {
			// TODO Auto-generated catch block
			this.addMessage(e.getCode(), e.getMsg(), e);
		}
	}    
    
    /**
	 * 删除TroleInfo对象 (子表有数据不允许删除）.
	 * 
	 * @return String.
	 */
    public String deleteOfNoChild() {
        try {
            TroleInfo troleInfo = troleInfos.get(rowIndex);

            service.delete(this.troleInfo.getId());
            addMessage("troleInfo.message.deleted", this.troleInfo.getId());				
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return null;
        }
        return null;
    }
    /**
     *    查询TroleInfo对象.
     *  @return String.
     */
    public String query() {
        try {
            this.troleInfos = service.getTroleInfoListOfQuery(this.queryFields);
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
		TroleInfo troleInfo = new TroleInfo();
		troleInfo.set_record_index(-1);		
    	troleInfo.set_edit_flag(TroleInfo.EDIT_FLAG_ADD);
        this.troleInfos.add(troleInfo);
    }
	
	public void popupAdd(){
		TroleInfo troleInfo = new TroleInfo();
		troleInfo.set_record_index(-1);		
    	troleInfo.set_edit_flag(TroleInfo.EDIT_FLAG_ADD);
    	this.getRequest().getSession().setAttribute("__pop_object", troleInfo); 	
    }
	
	public void popupEdit(){
		TroleInfo troleInfo = troleInfos.get(rowIndex);
    	troleInfo.set_record_index(rowIndex);
    	if (TroleInfo.EDIT_FLAG_ADD != troleInfo.get_edit_flag()){
    		troleInfo.set_edit_flag(TroleInfo.EDIT_FLAG_EDIT);
    	}    	
    	this.getRequest().getSession().setAttribute("__pop_object", troleInfo); 	
	}	
	
	public void popupView(){
		TroleInfo troleInfo = troleInfos.get(rowIndex.intValue());
    	this.getRequest().getSession().setAttribute("__pop_object", troleInfo); 	
	}	
    
    public void popupRefresh(){
    	TroleInfo troleInfo = (TroleInfo)this.getRequest().getSession().getAttribute("__pop_object");
    	if (troleInfo.get_record_index() != -1){
    		this.troleInfos.remove(troleInfo.get_record_index());
    		this.troleInfos.add(troleInfo.get_record_index(), troleInfo);
    	}
    	else{
    		this.troleInfos.add(troleInfo);
    	}
		this.getRequest().getSession().removeAttribute("__pop_object");
    }
    
    public String edit(){
        TroleInfo troleInfo = troleInfos.get(rowIndex.intValue());
    	troleInfo.set_record_index(rowIndex);
    	if (TroleInfo.EDIT_FLAG_ADD != troleInfo.get_edit_flag()){
    		troleInfo.set_edit_flag(TroleInfo.EDIT_FLAG_EDIT);
			this.setValueBinding("#{troleInfoForm.troleInfoPrimaryKey}", troleInfo.getId());
    	}
    	return this.getSuccessAction();
    }
    
    public String view(){
        TroleInfo troleInfo = troleInfos.get(rowIndex.intValue());
		this.setValueBinding("#{troleInfoForm.troleInfoPrimaryKey}", troleInfo.getId());
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
    	TroleInfo troleInfo  = troleInfos.get(rowIndex.intValue());
    	if (TroleInfo.EDIT_FLAG_ADD != troleInfo.get_edit_flag()){
			deleteList.add(troleInfo.getId());    	
		}
		troleInfos.remove(rowIndex.intValue());
    }	
	
    public void moveUpBuffer(){
    	int i = rowIndex;
    	int j = getMovedTroleInfoIndex(i,-1);
    	if (j == -1)
    		return ;
    	TroleInfo troleInfo = troleInfos.get(i);
    	troleInfos.add(j, troleInfo);
    	troleInfos.remove(i + 1);
    }	
	
    private int getMovedTroleInfoIndex(int index,int step){
    	if (index + step >= 0 && index + step < troleInfos.size()){
    		TroleInfo troleInfo = troleInfos.get(index + step);
    		if (TroleInfo.EDIT_FLAG_DELETE == troleInfo.get_edit_flag())
    			return index + step + getMovedTroleInfoIndex(index + step,step);
    		else
    			return index + step;
    	}else{
    		return -1;
    	}    	
    }	
	
    public void moveDownBuffer(){
    	int i = rowIndex;
    	int j = getMovedTroleInfoIndex(i,1);
    	if (j == -1)
    		return ;
    	TroleInfo troleInfo = troleInfos.get(j);
    	troleInfos.add(i, troleInfo);
    	troleInfos.remove(j + 1);
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
            for (int i=0; i < troleInfos.size(); i++) {
                TroleInfo troleInfo = (TroleInfo)this.troleInfos.get(i);
                service.saveTroleInfo(troleInfo);
            }
	        addMessage("troleInfo.message.savedAll",null);
			return this.getSuccessAction();
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
		return null;
	}	
	
	public void deleteChecked(){
		for(TroleInfo troleInfo : this.troleInfos){
			if(troleInfo.is_checked_flag()){
				service.delete(troleInfo.getId());
			}
		}
	}
	
	public void deleteAll(){
		service.deleteAll(this.troleInfos);
	}
}
