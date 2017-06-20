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
import cn.com.brilliance.begen.model.TorganizeInfo;
import cn.com.brilliance.begen.model.TuserInfo;
import cn.com.brilliance.begen.service.TorganizeInfoService;
import cn.com.brilliance.begen.service.TuserInfoService;
import cn.com.brilliance.risk.ext.common.Function;

/**
 * TuserInfo对象List.
 * @author Administrator.
 *
 */
public class TuserInfoList extends BasePage implements ListPage {

	private TuserInfoService service = (TuserInfoService)getBean("tuserInfoService");
	
	private TorganizeInfoService torganizeInfoService = (TorganizeInfoService)getBean("torganizeInfoService");
	
    /**
     * tuserInfos.
     */
    private List<TuserInfo> tuserInfos;

    /**
     * dataTable.
     */
    private HtmlDataTable dataTable;

    /**
     * tuserInfo.
     */
    private TuserInfo tuserInfo = null;

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
    public TuserInfoList() {
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
     * Returns the TuserInfo.
     * @return TuserInfo.
     */
    public void setTuserInfo(TuserInfo tuserInfo) {
        this.tuserInfo = tuserInfo;
    }

    /**
     * Sets the TuserInfo.
     * @param tuserInfo The tuserInfo to set.
     */
    public TuserInfo getTuserInfo() {
        return this.tuserInfo;
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
     * 获得TuserInfo对象列表.
     * @return List.
     */
    public List<TuserInfo> getTuserInfos() {
		if (this.sortColumn != null)
			sort(getSortColumn(), isAscending());
		return this.tuserInfos;
	}
	
	public void initTuserInfos(){
	    try {
            if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));

            this.tuserInfos = service.init(this.tuserInfo,this.queryFields);
			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}

	private void sort(final String column, final boolean ascending) {
		Comparator comparator = new Comparator() {
			public int compare(Object o1, Object o2) {
				TuserInfo t1 = (TuserInfo) o1;
				TuserInfo t2 = (TuserInfo) o2;

				if (column == null) {
					return 0;
				}
				
				String loginName1 = Tools.null2String(t1.getLoginName());
				String loginName2 = Tools.null2String(t2.getLoginName());
				String name1 = Tools.null2String(t1.getName());
				String name2 = Tools.null2String(t2.getName());
				String email1 = Tools.null2String(t1.getEmail());
				String email2 = Tools.null2String(t2.getEmail());
				String organizeId1 = Tools.null2String(t1.getOrganizeId());
				String organizeId2 = Tools.null2String(t2.getOrganizeId());
				
				if (column.equals("loginName")) {
					return ascending ? loginName1.compareTo(loginName2)
							: loginName2.compareTo(loginName1);
				} else if (column.equals("name")) {
					return ascending ? name1.compareTo(name2) : name2
							.compareTo(name1);
				} else if (column.equals("enable")) {
					return ascending ? t1.getEnable().toString().compareTo(
							t2.getEnable().toString()) : t2.getEnable()
							.toString().compareTo(t1.getEnable().toString());
				} else if (column.equals("email")) {
					return ascending ? email1.compareTo(email2) : email2
							.compareTo(email1);
				} else if (column.equals("organizeId")) {
					return ascending ? organizeId1.compareTo(organizeId2)
							: organizeId2.compareTo(organizeId1);
				} else
					return 0;
			}
		};
		Collections.sort(this.tuserInfos, comparator);   
    }  
	
    /**
	 * Sets the TuserInfos.
	 * 
	 * @param tuserInfos
	 *            The TuserInfos to set.
	 */
    public void setTuserInfos(List tuserInfos) {
        this.tuserInfos = tuserInfos;
    }

    /**
	 * Returns the dataTable.
	 * 
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
     * 删除TuserInfo对象.
     * @return String.
     */
    public void delete() {
        try {
            TuserInfo tuserInfo = tuserInfos.get(rowIndex);
            service.delete(tuserInfo.getId());		
            addMessage("tuserInfo.message.deleted", tuserInfo.getId());		
            this.tuserInfos.remove(rowIndex.intValue());
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
    }
    /**
     * 删除TuserInfo对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            TuserInfo tuserInfo = tuserInfos.get(rowIndex);

            service.delete(this.tuserInfo.getId());
            addMessage("tuserInfo.message.deleted", this.tuserInfo.getId());				
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return null;
        }
        return null;
    }
    
    /**
	 * 查询TuserInfo对象.
	 * 
	 * @return String.
	 */
	public String query() {
		try {
			String sql = "select myClass.id from cn.com.brilliance.begen.model.TorganizeInfo as myClass where 1=1 ";
			String orgId = (String) this.queryFields.get("organizeId");
			String loginName = (String) this.queryFields.get("loginName_like");
			String name = (String) this.queryFields.get("name_like");
			TorganizeInfo orgInfo = torganizeInfoService
					.getTorganizeInfo(orgId);
			String globalSort = orgInfo.getGlobalSort();
			if (Function.isParentCompany(orgId)) {
				sql = sql + " and (dw_flag = '1' and organize_level >= 1) ";
			} else {
				sql = sql + " and (dw_flag = '1' and global_sort like '"
						+ globalSort + "%') ";
			}
			String _hsql = " organize_id = ANY(" + sql + ")";
			if (!"".equals(loginName)) {
				_hsql = _hsql + " and login_name like '%" + loginName + "%'";
			}
			if (!"".equals(name)) {
				_hsql = _hsql + " and name like '%" + name + "%'";
			}
			this.queryFields.put("_hsql", _hsql);
			this.tuserInfos = service.getTuserInfoListOfQuery(this.queryFields);
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
		TuserInfo tuserInfo = new TuserInfo();
		tuserInfo.set_record_index(-1);		
    	tuserInfo.set_edit_flag(TuserInfo.EDIT_FLAG_ADD);
        this.tuserInfos.add(tuserInfo);
    }
	
	public void popupAdd(){
		TuserInfo tuserInfo = new TuserInfo();
		tuserInfo.set_record_index(-1);		
    	tuserInfo.set_edit_flag(TuserInfo.EDIT_FLAG_ADD);
    	this.getRequest().getSession().setAttribute("__pop_object", tuserInfo); 	
    }
	
	public void popupEdit(){
		TuserInfo tuserInfo = tuserInfos.get(rowIndex);
    	tuserInfo.set_record_index(rowIndex);
    	if (TuserInfo.EDIT_FLAG_ADD != tuserInfo.get_edit_flag()){
    		tuserInfo.set_edit_flag(TuserInfo.EDIT_FLAG_EDIT);
    	}    	
    	this.getRequest().getSession().setAttribute("__pop_object", tuserInfo); 	
	}	
	
	public void popupView(){
		TuserInfo tuserInfo = tuserInfos.get(rowIndex.intValue());
    	this.getRequest().getSession().setAttribute("__pop_object", tuserInfo); 	
	}	
    
    public void popupRefresh(){
    	TuserInfo tuserInfo = (TuserInfo)this.getRequest().getSession().getAttribute("__pop_object");
    	if (tuserInfo.get_record_index() != -1){
    		this.tuserInfos.remove(tuserInfo.get_record_index());
    		this.tuserInfos.add(tuserInfo.get_record_index(), tuserInfo);
    	}
    	else{
    		this.tuserInfos.add(tuserInfo);
    	}
		this.getRequest().getSession().removeAttribute("__pop_object");
    }
    
    public String edit(){
        TuserInfo tuserInfo = tuserInfos.get(rowIndex.intValue());
    	tuserInfo.set_record_index(rowIndex);
    	if (TuserInfo.EDIT_FLAG_ADD != tuserInfo.get_edit_flag()){
    		tuserInfo.set_edit_flag(TuserInfo.EDIT_FLAG_EDIT);
			this.setValueBinding("#{tuserInfoForm.tuserInfoPrimaryKey}", tuserInfo.getId());
    	}
    	return this.getSuccessAction();
    }
    
    public String view(){
        TuserInfo tuserInfo = tuserInfos.get(rowIndex.intValue());
		this.setValueBinding("#{tuserInfoForm.tuserInfoPrimaryKey}", tuserInfo.getId());
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
    	TuserInfo tuserInfo  = tuserInfos.get(rowIndex.intValue());
    	if (TuserInfo.EDIT_FLAG_ADD != tuserInfo.get_edit_flag()){
			deleteList.add(tuserInfo.getId());    	
		}
		tuserInfos.remove(rowIndex.intValue());
    }	
	
    public void moveUpBuffer(){
    	int i = rowIndex;
    	int j = getMovedTuserInfoIndex(i,-1);
    	if (j == -1)
    		return ;
    	TuserInfo tuserInfo = tuserInfos.get(i);
    	tuserInfos.add(j, tuserInfo);
    	tuserInfos.remove(i + 1);
    }	
	
    private int getMovedTuserInfoIndex(int index,int step){
    	if (index + step >= 0 && index + step < tuserInfos.size()){
    		TuserInfo tuserInfo = tuserInfos.get(index + step);
    		if (TuserInfo.EDIT_FLAG_DELETE == tuserInfo.get_edit_flag())
    			return index + step + getMovedTuserInfoIndex(index + step,step);
    		else
    			return index + step;
    	}else{
    		return -1;
    	}    	
    }	
	
    public void moveDownBuffer(){
    	int i = rowIndex;
    	int j = getMovedTuserInfoIndex(i,1);
    	if (j == -1)
    		return ;
    	TuserInfo tuserInfo = tuserInfos.get(j);
    	tuserInfos.add(i, tuserInfo);
    	tuserInfos.remove(j + 1);
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
            for (int i=0; i < tuserInfos.size(); i++) {
                TuserInfo tuserInfo = (TuserInfo)this.tuserInfos.get(i);
                service.saveTuserInfo(tuserInfo);
            }
	        addMessage("tuserInfo.message.savedAll",null);
			return this.getSuccessAction();
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
		return null;
	}	
	
	public void deleteChecked(){
		for(TuserInfo tuserInfo : this.tuserInfos){
			if(tuserInfo.is_checked_flag()){
				service.delete(tuserInfo.getId());
			}
		}
	}
	
	public void deleteAll(){
		service.deleteAll(this.tuserInfos);
	}
	
	public void closeUser() {
        try {
        	TuserInfo tuserInfo = tuserInfos.get(rowIndex);
        	tuserInfo.setEnable(new Boolean(false));
            service.saveTuserInfo(tuserInfo);		
            addMessage("tuserInfo.message.deleted", tuserInfo.getLoginName());		
//            this.truleGroups.remove(rowIndex.intValue());
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}	
}
