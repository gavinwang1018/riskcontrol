package cn.com.brilliance.begen.webapp.action;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;

import cn.com.brilliance.begen.exception.BeGenException;
import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.TruleGroupService;
import cn.com.brilliance.begen.service.TruleInstanceGroupService;
import cn.com.brilliance.begen.service.TruleInstanceService;
import cn.com.brilliance.begen.service.TruleService;
import cn.com.brilliance.begen.webapp.action.BasePage;
import cn.com.brilliance.begen.common.webapp.action.ListPage;
import cn.com.brilliance.risk.ext.common.NumberComparator;

/**
 * TruleInstance对象List.
 * @author Administrator.
 *
 */
public class TruleInstanceList extends BasePage implements ListPage {

	private TruleInstanceService service = (TruleInstanceService)getBean("truleInstanceService");
	
	private TruleService truleService = (TruleService)getBean("truleService");
	
    /**
     * truleInstances.
     */
    private List<TruleInstance> truleInstances;

    /**
     * dataTable.
     */
    private HtmlDataTable dataTable;

    /**
     * truleInstance.
     */
    private TruleInstance truleInstance = null;

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
    public TruleInstanceList() {
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
     * Returns the TruleInstance.
     * @return TruleInstance.
     */
    public void setTruleInstance(TruleInstance truleInstance) {
        this.truleInstance = truleInstance;
    }

    /**
     * Sets the TruleInstance.
     * @param truleInstance The truleInstance to set.
     */
    public TruleInstance getTruleInstance() {
        return this.truleInstance;
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
     * 获得TruleInstance对象列表.
     * @return List.
     */
    public List<TruleInstance> getTruleInstances() {
    	if(isAscending()==true){
    		initTruleInstances();
    		sort(getSortColumn(),isAscending()); 
    		return this.truleInstances;
    	}else if(isAscending()==false){
    		initTruleInstances();
    		sort(getSortColumn(),isAscending()); 
    		return this.truleInstances;
    	}else
        return this.truleInstances;
    }

	public void initTruleInstances(){
    	String code = (String) this.queryFields.get("code");
    	String enable = (String) this.queryFields.get("enable");
    	String belongToInst = (String) this.queryFields.get("belongToInst");
    	
    	if(code == null || "".equals(code)){
    		
    	}
    	if(enable == null || ("*").equals(enable)){
    		queryFields.remove("enable");
    		queryFields.put("enable","");
    	}
    	if(belongToInst == null || ("*").equals(belongToInst)){
    		queryFields.remove("belongToInst");
    		queryFields.put("belongToInst","");
    	}
	    try {
	    	this.truleInstances = service.getTruleInstanceListOfQuery(queryFields);
            if (this.sortColumn != null){
	            queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));
            }

            sort(sortColumn, ascending);
			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}
	
	protected void sort(final String column, final boolean ascending){   
        Comparator comparator = new Comparator(){   
            public int compare(Object o1, Object o2)   
            {   
                TruleInstance t1 = (TruleInstance)o1;   
                TruleInstance t2 = (TruleInstance)o2;   
   
                if (column == null){   
                    return 0;   
                }   
                if (column.equals("code")){   
                    return ascending ? t1.getCode().compareTo(t2. 
                    		getCode()) : t2.getCode().compareTo(t1.getCode());   
                } else if(column.equals("description")){   
                    return ascending ? t1.getDescription().compareTo(t2. 
                    		getDescription()) : t2.getDescription().compareTo(t1.getDescription()); 
                } else if(column.equals("versionBm")){   
                	return ascending ? t1.getVersionBm().compareTo(t2. 
                			getVersionBm()) : t2.getVersionBm().compareTo(t1.getVersionBm());  
                } else if(column.equals("belongToInst")){   
                	return ascending ? t1.getBelongToInst().compareTo(t2. 
                			getBelongToInst()) : t2.getBelongToInst().compareTo(t1.getBelongToInst());  
                } else if(column.equals("enable")){ 
                	return ascending ? t1.getEnable().toString().trim().compareTo(t2. 
                			getEnable().toString().trim()) : t2.getEnable().toString().trim().compareTo(t1.getEnable().toString().trim());  
                } else if(column.equals("cycle")){   
                	return ascending ? t1.getCycle().compareTo(t2. 
                			getCycle()) : t2.getCycle().compareTo(t1.getCycle());  
                } else if(column.equals("timeParam")){   
                	return ascending ? t1.getTimeParam().compareTo(t2. 
                			getTimeParam()) : t2.getTimeParam().compareTo(t1.getTimeParam());  
                } else if(column.equals("supportTrace")){
                	return ascending ? t1.getSupportTrace().toString().trim().compareTo(t2. 
                			getSupportTrace().toString().trim()) : t2.getSupportTrace().toString().trim().compareTo(t1.getSupportTrace().toString().trim());  
                }      
                else return 0;   
            }   
        };   
        Collections.sort(this.truleInstances, comparator);   
    }  

    /**
     * Sets the TruleInstances.
     * @param truleInstances The TruleInstances to set.
     */
    public void setTruleInstances(List truleInstances) {
        this.truleInstances = truleInstances;
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
     * 删除TruleInstance对象.
     * @return String.
     */
    public void delete() {
        try {
            TruleInstance truleInstance = truleInstances.get(rowIndex);
            service.delete(truleInstance.getId());		
            addMessage("truleInstance.message.deleted", truleInstance.getId());		
            this.truleInstances.remove(rowIndex.intValue());
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
    }
    /**
     * 删除TruleInstance对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            TruleInstance truleInstance = truleInstances.get(rowIndex);

            service.delete(this.truleInstance.getId());
            addMessage("truleInstance.message.deleted", this.truleInstance.getId());				
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return null;
        }
        return null;
    }
    /**
     *    查询TruleInstance对象.
     *  @return String.
     */
    public String query() {
        try {
        	Map queryFields = new HashMap();
        	String code = (String) this.queryFields.get("code");
        	String enable = (String) this.queryFields.get("enable");
        	String belongToInst = (String) this.queryFields.get("belongToInst");
        	queryFields.put("code", code);
        	if(!enable.equals("*")){
        		queryFields.put("enable", enable);
        	}
        	if(!belongToInst.equals("*")){
        		queryFields.put("belongToInst", belongToInst);
        	}
        	this.truleInstances = service.getTruleInstanceListOfQuery(queryFields);
        	refreshAfterSearch();
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
        return null;
    }


    private void refreshAfterSearch() {
    	this.dataTable.setFirst(0);
    }

    public String add() {
		String code = (String) this.queryFields.get("code");
		if(code.equals("")){
			addMessage("truleInstanceCode.ifNull.canNotAdd", "["+"全部"+"}");
			return "t_rule_instance/t_rule_instance_list_List";
		}
		String id = getRuleId(code);
		String cycle = truleService.getTrule(id).getCycle();
		String url = "../ext_rule_instance/ext_t_rule_instance_EditForm_"
				+ code + ".faces?enable=true&time_param=1&description=" + id
				+ "'s Description&code=" + code+"&cycle="+cycle;
		try {
			getResponse().sendRedirect(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getFacesContext().responseComplete();
		return null;
	}
	
    private String getRuleId(String code) {
		Trule trule = truleService.getTrule(code);
		return trule.getId();//getDescription();
	}
    
	public void multiAdd(){
		TruleInstance truleInstance = new TruleInstance();
		truleInstance.set_record_index(-1);		
    	truleInstance.set_edit_flag(TruleInstance.EDIT_FLAG_ADD);
        this.truleInstances.add(truleInstance);
    }
	
	public void popupAdd(){
		TruleInstance truleInstance = new TruleInstance();
		truleInstance.set_record_index(-1);		
    	truleInstance.set_edit_flag(TruleInstance.EDIT_FLAG_ADD);
    	this.getRequest().getSession().setAttribute("__pop_object", truleInstance); 	
    }
	
	public void popupEdit(){
		TruleInstance truleInstance = truleInstances.get(rowIndex);
    	truleInstance.set_record_index(rowIndex);
    	if (TruleInstance.EDIT_FLAG_ADD != truleInstance.get_edit_flag()){
    		truleInstance.set_edit_flag(TruleInstance.EDIT_FLAG_EDIT);
    	}    	
    	this.getRequest().getSession().setAttribute("__pop_object", truleInstance); 	
	}	
	
	public void popupView(){
		TruleInstance truleInstance = truleInstances.get(rowIndex.intValue());
    	this.getRequest().getSession().setAttribute("__pop_object", truleInstance); 	
	}	
    
    public void popupRefresh(){
    	TruleInstance truleInstance = (TruleInstance)this.getRequest().getSession().getAttribute("__pop_object");
    	if (truleInstance.get_record_index() != -1){
    		this.truleInstances.remove(truleInstance.get_record_index());
    		this.truleInstances.add(truleInstance.get_record_index(), truleInstance);
    	}
    	else{
    		this.truleInstances.add(truleInstance);
    	}
		this.getRequest().getSession().removeAttribute("__pop_object");
    }
    
    public String edit(){
        TruleInstance truleInstance = truleInstances.get(rowIndex.intValue());
        String code = truleInstance.getCode();
    	truleInstance.set_record_index(rowIndex);
    	if(truleInstance.getEnable().equals(new Boolean(true))){
	    	if (TruleInstance.EDIT_FLAG_ADD != truleInstance.get_edit_flag()){
	    		truleInstance.set_edit_flag(TruleInstance.EDIT_FLAG_EDIT);
				this.setValueBinding("#{truleInstanceForm.truleInstancePrimaryKey}", truleInstance.getId());
	    	}
	    	return "ext_rule_instance/ext_t_rule_instance_EditForm_" + code;
    	}else{
    		addMessage("truleInstance.notEnable.notEditable","["+truleInstance.getCode()+"]");
    		return null;
    	}
    } 
    
    public String view(){
        TruleInstance truleInstance = truleInstances.get(rowIndex.intValue());
		this.setValueBinding("#{truleInstanceForm.truleInstancePrimaryKey}", truleInstance.getId());
    	return "ext_rule_instance/ext_t_rule_instance_ViewForm_" + truleInstance.getCode();
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
    	TruleInstance truleInstance  = truleInstances.get(rowIndex.intValue());
    	if (TruleInstance.EDIT_FLAG_ADD != truleInstance.get_edit_flag()){
			deleteList.add(truleInstance.getId());    	
		}
		truleInstances.remove(rowIndex.intValue());
    }	
	
    public void moveUpBuffer(){
    	int i = rowIndex;
    	int j = getMovedTruleInstanceIndex(i,-1);
    	if (j == -1)
    		return ;
    	TruleInstance truleInstance = truleInstances.get(i);
    	truleInstances.add(j, truleInstance);
    	truleInstances.remove(i + 1);
    }	
	
    private int getMovedTruleInstanceIndex(int index,int step){
    	if (index + step >= 0 && index + step < truleInstances.size()){
    		TruleInstance truleInstance = truleInstances.get(index + step);
    		if (TruleInstance.EDIT_FLAG_DELETE == truleInstance.get_edit_flag())
    			return index + step + getMovedTruleInstanceIndex(index + step,step);
    		else
    			return index + step;
    	}else{
    		return -1;
    	}    	
    }	
	
    public void moveDownBuffer(){
    	int i = rowIndex;
    	int j = getMovedTruleInstanceIndex(i,1);
    	if (j == -1)
    		return ;
    	TruleInstance truleInstance = truleInstances.get(j);
    	truleInstances.add(i, truleInstance);
    	truleInstances.remove(j + 1);
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
            for (int i=0; i < truleInstances.size(); i++) {
                TruleInstance truleInstance = (TruleInstance)this.truleInstances.get(i);
                service.saveTruleInstance(truleInstance);
            }
	        addMessage("truleInstance.message.savedAll",null);
			return this.getSuccessAction();
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
		return null;
	}	
	
	public void deleteChecked(){
		for(TruleInstance truleInstance : this.truleInstances){
			if(truleInstance.is_checked_flag()){
				service.delete(truleInstance.getId());
			}
		}
	}
	
	public void deleteAll(){
		service.deleteAll(this.truleInstances);
	}
	
	/**
	 * 用于关闭
	 */
	
    public void close() {
        try {
            TruleInstance truleInstance = truleInstances.get(rowIndex);
//            addMessage("truleInstance.message.deleted", truleInstance.getId());		
            this.truleInstances.get(rowIndex).setEnable(new Boolean(false));
            truleInstance.setEnable(new Boolean(false));
            
            TruleInstanceGroupService truleInstanceGroupService = (TruleInstanceGroupService) getBean("truleInstanceGroupService");
            TruleGroupService truleGroupService = (TruleGroupService) getBean("truleGroupService");
            Map query = new HashMap();
            query.put("ruleInstanceId", truleInstance.getId());
            List<TruleInstanceGroup> list = truleInstanceGroupService.getTruleInstanceGroupListOfQuery(query);
            System.out.println("list : "+list);
            //规则组在激活时不能注销
            if(list==null || list.isEmpty()==true){
            	service.saveTruleInstance(truleInstance);
            }else{
            	String groupId = list.get(0).getId();
            	if(truleGroupService.getTruleGroup(groupId)==null || "".equals(truleGroupService.getTruleGroup(groupId))){
            		
            	}else{
	            	if(truleGroupService.getTruleGroup(groupId).getEnable()==null || "".equals(truleGroupService.getTruleGroup(groupId).getEnable())){
		            	service.saveTruleInstance(truleInstance);
	            	}else{
	            		if(truleGroupService.getTruleGroup(groupId).getEnable()==true){
	            			
	            		}else{
	            			service.saveTruleInstance(truleInstance);
	            		}
	            	}
            	}
            }
            


        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
    }
    
    @Override
    public String toString() {
    	String code = (String) this.queryFields.get("code");
    	String enable = (String) this.queryFields.get("enable");
    	String belongToInst = (String) this.queryFields.get("belongToInst");
    	
    	return "code=="+code+"\n"+"enable=="+enable+"\n"+"belongToInst=="+belongToInst+"\n";
    }
    
    public void activate(){
        try {
            TruleInstance truleInstance = truleInstances.get(rowIndex);
            Map queryFields = new HashMap();
            queryFields.put("code", truleInstance.getCode());
            queryFields.put("cycle", truleInstance.getCycle());
            List<TruleInstance> list = service.getTruleInstanceListOfQuery(queryFields);
            for (TruleInstance instance : list) {
            	if(instance.getId().equals(truleInstance.getId())){
            		instance.setEnable(new Boolean(true));
            		service.saveTruleInstance(instance);
            	}else{
            		instance.setEnable(new Boolean(false));
            		service.saveTruleInstance(instance);
            	}
			}
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
    }
    
}
