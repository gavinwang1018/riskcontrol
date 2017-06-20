package cn.com.brilliance.begen.webapp.action;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.SelectItem;

import cn.com.brilliance.begen.dao.TruleGroupDAO;
import cn.com.brilliance.begen.exception.BeGenException;
import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.TruleGroupService;
import cn.com.brilliance.begen.webapp.action.BasePage;
import cn.com.brilliance.begen.webapp.servlet.UserBean;
import cn.com.brilliance.begen.common.webapp.action.ListPage;
import cn.com.brilliance.risk.ext.common.Function;

/**
 * TruleGroup对象List.
 * @author Administrator.
 *
 */
public class TruleGroupList extends BasePage implements ListPage {

	private TruleGroupService service = (TruleGroupService)getBean("truleGroupService");
    /**
     * truleGroups.
     */
    private List<TruleGroup> truleGroups;

    /**
     * dataTable.
     */
    private HtmlDataTable dataTable;

    /**
     * truleGroup.
     */
    private TruleGroup truleGroup = null;

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
    public TruleGroupList() {
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
     * Returns the TruleGroup.
     * @return TruleGroup.
     */
    public void setTruleGroup(TruleGroup truleGroup) {
        this.truleGroup = truleGroup;
    }

    /**
     * Sets the TruleGroup.
     * @param truleGroup The truleGroup to set.
     */
    public TruleGroup getTruleGroup() {
        return this.truleGroup;
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
     * 获得TruleGroup对象列表.
     * @return List.
     */
    public List<TruleGroup> getTruleGroups() {
		if (this.sortColumn != null)
			sort(getSortColumn(), isAscending());
		return this.truleGroups;
	}
	
	private void sort(final String column, final boolean ascending) {
		Comparator comparator = new Comparator() {
			public int compare(Object o1, Object o2) {
				TruleGroup t1 = (TruleGroup) o1;
				TruleGroup t2 = (TruleGroup) o2;

				if (column == null) {
					return 0;
				}

				String enable1 = Tools.null2String(t1.getEnable().toString());
				String enable2 = Tools.null2String(t2.getEnable().toString());
				String desc1 = Tools.null2String(t1.getDescription());
				String desc2 = Tools.null2String(t2.getDescription());
				String organizeId1 = Tools.null2String(t1.getBelongToInst());
				String organizeId2 = Tools.null2String(t2.getBelongToInst());

				if (column.equals("description")) {
					return ascending ? desc1.compareTo(desc2) : desc2
							.compareTo(desc1);
				} else if (column.equals("enable")) {
					return ascending ? enable1.compareTo(enable2) : enable2
							.compareTo(enable1);
				} else if (column.equals("belongToInst")) {
					return ascending ? organizeId1.compareTo(organizeId2)
							: organizeId2.compareTo(organizeId1);
				} else
					return 0;
			}
		};
		Collections.sort(this.truleGroups, comparator);
	}  
	
	public void initTruleGroups(){
	    try {
            if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));

            this.truleGroups = service.init(this.truleGroup,this.queryFields);
			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}

    /**
     * Sets the TruleGroups.
     * @param truleGroups The TruleGroups to set.
     */
    public void setTruleGroups(List truleGroups) {
        this.truleGroups = truleGroups;
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
     * 删除TruleGroup对象.
     * @return String.
     */
    public void delete() {
        try {
            TruleGroup truleGroup = truleGroups.get(rowIndex);
            service.delete(truleGroup.getId());		
            addMessage("truleGroup.message.deleted", truleGroup.getId());		
            this.truleGroups.remove(rowIndex.intValue());
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
    }
    /**
     * 删除TruleGroup对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            TruleGroup truleGroup = truleGroups.get(rowIndex);

            service.delete(this.truleGroup.getId());
            addMessage("truleGroup.message.deleted", this.truleGroup.getId());				
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return null;
        }
        return null;
    }
    /**
     *    查询TruleGroup对象.
     *  @return String.
     */
    public String query() {
        try {
            this.truleGroups = service.getTruleGroupListOfQuery(this.queryFields);
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
		TruleGroup truleGroup = new TruleGroup();
		truleGroup.set_record_index(-1);		
    	truleGroup.set_edit_flag(TruleGroup.EDIT_FLAG_ADD);
        this.truleGroups.add(truleGroup);
    }
	
	public void popupAdd(){
		TruleGroup truleGroup = new TruleGroup();
		truleGroup.set_record_index(-1);		
    	truleGroup.set_edit_flag(TruleGroup.EDIT_FLAG_ADD);
    	this.getRequest().getSession().setAttribute("__pop_object", truleGroup); 	
    }
	
	public void popupEdit(){
		TruleGroup truleGroup = truleGroups.get(rowIndex);
    	truleGroup.set_record_index(rowIndex);
    	if (TruleGroup.EDIT_FLAG_ADD != truleGroup.get_edit_flag()){
    		truleGroup.set_edit_flag(TruleGroup.EDIT_FLAG_EDIT);
    	}    	
    	this.getRequest().getSession().setAttribute("__pop_object", truleGroup); 	
	}	
	
	public void popupView(){
		TruleGroup truleGroup = truleGroups.get(rowIndex.intValue());
    	this.getRequest().getSession().setAttribute("__pop_object", truleGroup); 	
	}	
    
    public void popupRefresh(){
    	TruleGroup truleGroup = (TruleGroup)this.getRequest().getSession().getAttribute("__pop_object");
    	if (truleGroup.get_record_index() != -1){
    		this.truleGroups.remove(truleGroup.get_record_index());
    		this.truleGroups.add(truleGroup.get_record_index(), truleGroup);
    	}
    	else{
    		this.truleGroups.add(truleGroup);
    	}
		this.getRequest().getSession().removeAttribute("__pop_object");
    }
    
    public String edit(){
        TruleGroup truleGroup = truleGroups.get(rowIndex.intValue());
    	truleGroup.set_record_index(rowIndex);
    	if (TruleGroup.EDIT_FLAG_ADD != truleGroup.get_edit_flag()){
    		truleGroup.set_edit_flag(TruleGroup.EDIT_FLAG_EDIT);
			this.setValueBinding("#{truleGroupForm.truleGroupPrimaryKey}", truleGroup.getId());
    	}
    	return this.getSuccessAction();
    }
    
    public String view(){
        TruleGroup truleGroup = truleGroups.get(rowIndex.intValue());
		this.setValueBinding("#{truleGroupForm.truleGroupPrimaryKey}", truleGroup.getId());
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
    	TruleGroup truleGroup  = truleGroups.get(rowIndex.intValue());
    	if (TruleGroup.EDIT_FLAG_ADD != truleGroup.get_edit_flag()){
			deleteList.add(truleGroup.getId());    	
		}
		truleGroups.remove(rowIndex.intValue());
    }	
	
    public void moveUpBuffer(){
    	int i = rowIndex;
    	int j = getMovedTruleGroupIndex(i,-1);
    	if (j == -1)
    		return ;
    	TruleGroup truleGroup = truleGroups.get(i);
    	truleGroups.add(j, truleGroup);
    	truleGroups.remove(i + 1);
    }	
	
    private int getMovedTruleGroupIndex(int index,int step){
    	if (index + step >= 0 && index + step < truleGroups.size()){
    		TruleGroup truleGroup = truleGroups.get(index + step);
    		if (TruleGroup.EDIT_FLAG_DELETE == truleGroup.get_edit_flag())
    			return index + step + getMovedTruleGroupIndex(index + step,step);
    		else
    			return index + step;
    	}else{
    		return -1;
    	}    	
    }	
	
    public void moveDownBuffer(){
    	int i = rowIndex;
    	int j = getMovedTruleGroupIndex(i,1);
    	if (j == -1)
    		return ;
    	TruleGroup truleGroup = truleGroups.get(j);
    	truleGroups.add(i, truleGroup);
    	truleGroups.remove(j + 1);
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
            for (int i=0; i < truleGroups.size(); i++) {
                TruleGroup truleGroup = (TruleGroup)this.truleGroups.get(i);
                service.saveTruleGroup(truleGroup);
            }
	        addMessage("truleGroup.message.savedAll",null);
			return this.getSuccessAction();
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
		return null;
	}	
	
	public void deleteChecked(){
		for(TruleGroup truleGroup : this.truleGroups){
			if(truleGroup.is_checked_flag()){
				service.delete(truleGroup.getId());
			}
		}
	}
	
	public void deleteAll(){
		service.deleteAll(this.truleGroups);
	}
	
	
	public void closeRuleGroup() {
        try {
            TruleGroup truleGroup = truleGroups.get(rowIndex);
            truleGroup.setEnable(new Boolean(false));
            service.saveTruleGroup(truleGroup);		
            addMessage("truleGroup.message.deleted", truleGroup.getDescription());		
//            this.truleGroups.remove(rowIndex.intValue());
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}	
	

	private List ruleGroups = new ArrayList();

	/**
	 * @return the ruleGroups
	 */
	public List getRuleGroups() {
		return ruleGroups;
	}

	/**
	 * @param ruleGroups the ruleGroups to set
	 */
	public void setRuleGroups(List ruleGroups) {
		this.ruleGroups = ruleGroups;
	}

	public List getBelongToInstForRuleItems() {
		List itemlist = new ArrayList();
		UserBean userBean = getUserBean();
		List list = Function.getParentCompanyList(userBean);
		for (int i = 0; i < list.size(); i++) {
			TorganizeInfo torganizeInfo = (TorganizeInfo) list.get(i);
			String label = torganizeInfo.getName();
			itemlist.add(new SelectItem(String.valueOf(torganizeInfo.getId()),
					label));
		}
		if (userBean != null
				&& Function.isParentCompany(userBean.getTuserInfo()
						.getOrganizeId())) {
			itemlist.add(new SelectItem("*", "全部"));
		}
		filterTruleGroups();
		return itemlist;
	}	

	public void filterTruleGroups() {
		ruleGroups = new ArrayList();
		TruleGroup truleGroup = new TruleGroup();
		String orgId = (String) this.queryFields.get("belongToInst");
		if(orgId == null){
			orgId = getUserBean().getTuserInfo().getOrganizeId();
		}
		if (!"*".equals(orgId)) {
			truleGroup.setBelongToInst(orgId);
		}
		TruleGroupDAO truleGroupDAO = (TruleGroupDAO) getBean("truleGroupDAO");
		List list = truleGroupDAO.getTruleGroupList(truleGroup);
		ruleGroups.add(new SelectItem("", "全部"));
		for (int i = 0; i < list.size(); i++) {
			TruleGroup tg = (TruleGroup) list.get(i);
			ruleGroups.add(new SelectItem(String.valueOf(tg.getId()), String
					.valueOf(tg.getDescription())));
		}
	}
	
	public void multiClose() {
		try {
			for (int i = 0; i < this.truleGroups.size(); i++) {
				TruleGroup tg = this.truleGroups.get(i);
				if (tg.is_checked_flag()) {
					tg.setEnable(new Boolean(false));
					service.saveTruleGroup(tg);
				}
			}
			addMessageString("注销成功!");
		} catch (BeGenException e) {
			// TODO Auto-generated catch block
			this.addMessage(e.getCode(), e.getMsg(), e);
		}
	}
}
