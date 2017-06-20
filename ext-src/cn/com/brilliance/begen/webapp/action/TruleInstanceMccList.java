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
import cn.com.brilliance.begen.service.TruleInstanceMccService;
import cn.com.brilliance.begen.webapp.action.BasePage;
import cn.com.brilliance.begen.common.webapp.action.ListPage;

/**
 * TruleInstanceMcc对象List.
 * @author Administrator.
 *
 */
public class TruleInstanceMccList extends BasePage implements ListPage {

	private TruleInstanceMccService service = (TruleInstanceMccService)getBean("truleInstanceMccService");
    /**
     * truleInstanceMccs.
     */
    private List<TruleInstanceMcc> truleInstanceMccs;

    private List<TruleInstanceMcc> mccList;
    
    private List<TruleInstanceMcc> bigMccList
    ;
    /**
     * dataTable.
     */
    private HtmlDataTable dataTable;

    /**
     * truleInstanceMcc.
     */
    private TruleInstanceMcc truleInstanceMcc = null;

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
    public TruleInstanceMccList() {
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
     * Returns the TruleInstanceMcc.
     * @return TruleInstanceMcc.
     */
    public void setTruleInstanceMcc(TruleInstanceMcc truleInstanceMcc) {
        this.truleInstanceMcc = truleInstanceMcc;
    }

    /**
     * Sets the TruleInstanceMcc.
     * @param truleInstanceMcc The truleInstanceMcc to set.
     */
    public TruleInstanceMcc getTruleInstanceMcc() {
        return this.truleInstanceMcc;
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
     * 获得TruleInstanceMcc对象列表.
     * @return List.
     */
    public List<TruleInstanceMcc> getTruleInstanceMccs() {
        return this.truleInstanceMccs;
    }
	
	public void initTruleInstanceMccs(){
	    try {
	    	if(null == (String) this.getValueBinding("#{truleInstanceForm.truleInstancePrimaryKey}")){
	            if (this.sortColumn != null)
	                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));
	            this.mccList =  new ArrayList<TruleInstanceMcc>();
	    	}else{
	    		this.initTruleInstanceMccsView();
	    	}


			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}
	
	public void initTruleInstanceMccsView(){
		this.mccList =  new ArrayList();
		String instanceId = (String) this.getValueBinding("#{truleInstanceForm.truleInstancePrimaryKey}");
	    try {
            if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));

            TruleInstanceMcc truleInstanceMcc = new TruleInstanceMcc();
            truleInstanceMcc.setRuleInstanceId(instanceId);
            
            TruleInstanceMccService mccService = (TruleInstanceMccService) getBean("truleInstanceMccService");
            Map queryFields = new HashMap();
            queryFields.put("ruleInstanceId", instanceId);
            queryFields.put("bigmccCode_min", "1");
            queryFields.put("bigmccCode_max", "5");
            List<TruleInstanceMcc> list = mccService.getTruleInstanceMccListOfQuery(queryFields);
			for (TruleInstanceMcc mcc : list) {
				String code = mcc.getRuleInstanceIdOfTruleInstance().getCode();
				if(code.equals("R01")||code.equals("R08")||code.equals("R15")||code.equals("R20")||code.equals("R29")){
					mcc.setParam1(Integer.toString((Integer.parseInt(mcc.getParam1())/100)));
				}
				if(code.equals("R20")){
					if(mcc.getParam2()==null || "".equals(mcc.getParam2())){
						mcc.setParam2("99999999999999999999");//20个9,数据库最大值.
					}else
					mcc.setParam2(mcc.getParam2().substring(0, mcc.getParam2().length()-2));
				}
				if(!mcc.getMccCode().equals("*")){
					this.mccList.add(mcc);
				}
			}
			
			
			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}
	
	
	public void initTruleInstanceBigMccs(){
	    try {
            this.bigMccList =  new ArrayList<TruleInstanceMcc>();
            for(int i=1; i<6; i++){
            	TruleInstanceMcc extTruleInstanceMcc = new TruleInstanceMcc();
	            extTruleInstanceMcc.setBigmccCode("" + i);
	            this.bigMccList.add(extTruleInstanceMcc);
            }
			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}
	
    /**
     * Sets the TruleInstanceMccs.
     * @param truleInstanceMccs The TruleInstanceMccs to set.
     */
    public void setTruleInstanceMccs(List truleInstanceMccs) {
        this.truleInstanceMccs = truleInstanceMccs;
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
     * 删除TruleInstanceMcc对象.
     * @return String.
     */
    public void delete() {
        try {
            TruleInstanceMcc truleInstanceMcc = mccList.get(rowIndex);
            service.delete(truleInstanceMcc.getId());		
            addMessage("truleInstanceMcc.message.deleted", truleInstanceMcc.getId());		
            this.mccList.remove(rowIndex.intValue());
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
    }
    /**
     * 删除TruleInstanceMcc对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            TruleInstanceMcc truleInstanceMcc = mccList.get(rowIndex);

            service.delete(this.truleInstanceMcc.getId());
            addMessage("truleInstanceMcc.message.deleted", this.truleInstanceMcc.getId());				
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return null;
        }
        return null;
    }
    /**
     *    查询TruleInstanceMcc对象.
     *  @return String.
     */
    public String query() {
        try {
            this.mccList = service.getTruleInstanceMccListOfQuery(this.queryFields);
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
		TruleInstanceMcc truleInstanceMcc = new TruleInstanceMcc();
		truleInstanceMcc.set_record_index(-1);		
    	truleInstanceMcc.set_edit_flag(TruleInstanceMcc.EDIT_FLAG_ADD);
        this.mccList.add(truleInstanceMcc);
    }
	
	public void popupAdd(){
		TruleInstanceMcc truleInstanceMcc = new TruleInstanceMcc();
		truleInstanceMcc.set_record_index(-1);		
    	truleInstanceMcc.set_edit_flag(TruleInstanceMcc.EDIT_FLAG_ADD);
    	this.getRequest().getSession().setAttribute("__pop_object", truleInstanceMcc); 	
    }
	
	public void popupEdit(){
		TruleInstanceMcc truleInstanceMcc = truleInstanceMccs.get(rowIndex);
    	truleInstanceMcc.set_record_index(rowIndex);
    	if (TruleInstanceMcc.EDIT_FLAG_ADD != truleInstanceMcc.get_edit_flag()){
    		truleInstanceMcc.set_edit_flag(TruleInstanceMcc.EDIT_FLAG_EDIT);
    	}    	
    	this.getRequest().getSession().setAttribute("__pop_object", truleInstanceMcc); 	
	}	
	
	public void popupView(){
		TruleInstanceMcc truleInstanceMcc = truleInstanceMccs.get(rowIndex.intValue());
    	this.getRequest().getSession().setAttribute("__pop_object", truleInstanceMcc); 	
	}	
    
    public void popupRefresh(){
    	TruleInstanceMcc truleInstanceMcc = (TruleInstanceMcc)this.getRequest().getSession().getAttribute("__pop_object");
    	if (truleInstanceMcc.get_record_index() != -1){
    		this.truleInstanceMccs.remove(truleInstanceMcc.get_record_index());
    		this.truleInstanceMccs.add(truleInstanceMcc.get_record_index(), truleInstanceMcc);
    	}
    	else{
    		this.truleInstanceMccs.add(truleInstanceMcc);
    	}
		this.getRequest().getSession().removeAttribute("__pop_object");
    }
    
    public String edit(){
        TruleInstanceMcc truleInstanceMcc = truleInstanceMccs.get(rowIndex.intValue());
    	truleInstanceMcc.set_record_index(rowIndex);
    	if (TruleInstanceMcc.EDIT_FLAG_ADD != truleInstanceMcc.get_edit_flag()){
    		truleInstanceMcc.set_edit_flag(TruleInstanceMcc.EDIT_FLAG_EDIT);
			this.setValueBinding("#{truleInstanceMccForm.truleInstanceMccPrimaryKey}", truleInstanceMcc.getId());
    	}
    	return this.getSuccessAction();
    }
    
    public String view(){
        TruleInstanceMcc truleInstanceMcc = mccList.get(rowIndex.intValue());
		this.setValueBinding("#{truleInstanceMccForm.truleInstanceMccPrimaryKey}", truleInstanceMcc.getId());
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
    	TruleInstanceMcc truleInstanceMcc  = mccList.get(rowIndex.intValue());
    	if (TruleInstanceMcc.EDIT_FLAG_ADD != truleInstanceMcc.get_edit_flag()){
			deleteList.add(truleInstanceMcc.getId());    	
		}
    	mccList.remove(rowIndex.intValue());
    }	
	
    public void moveUpBuffer(){
    	int i = rowIndex;
    	int j = getMovedTruleInstanceMccIndex(i,-1);
    	if (j == -1)
    		return ;
    	TruleInstanceMcc truleInstanceMcc = truleInstanceMccs.get(i);
    	truleInstanceMccs.add(j, truleInstanceMcc);
    	truleInstanceMccs.remove(i + 1);
    }	
	
    private int getMovedTruleInstanceMccIndex(int index,int step){
    	if (index + step >= 0 && index + step < truleInstanceMccs.size()){
    		TruleInstanceMcc truleInstanceMcc = truleInstanceMccs.get(index + step);
    		if (TruleInstanceMcc.EDIT_FLAG_DELETE == truleInstanceMcc.get_edit_flag())
    			return index + step + getMovedTruleInstanceMccIndex(index + step,step);
    		else
    			return index + step;
    	}else{
    		return -1;
    	}    	
    }	
	
    public void moveDownBuffer(){
    	int i = rowIndex;
    	int j = getMovedTruleInstanceMccIndex(i,1);
    	if (j == -1)
    		return ;
    	TruleInstanceMcc truleInstanceMcc = truleInstanceMccs.get(j);
    	truleInstanceMccs.add(i, truleInstanceMcc);
    	truleInstanceMccs.remove(j + 1);
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
            for (int i=0; i < mccList.size(); i++) {
                TruleInstanceMcc truleInstanceMcc = (TruleInstanceMcc)this.mccList.get(i);
                service.saveTruleInstanceMcc(truleInstanceMcc);
            }
	        addMessage("truleInstanceMcc.message.savedAll",null);
			return this.getSuccessAction();
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
		return null;
	}	
	
	public void deleteChecked(){
		for(TruleInstanceMcc truleInstanceMcc : this.truleInstanceMccs){
			if(truleInstanceMcc.is_checked_flag()){
				service.delete(truleInstanceMcc.getId());
			}
		}
	}
	
	public void deleteAll(){
		service.deleteAll(this.truleInstanceMccs);
	}

	/**
	 * @return the bigMccList
	 */
	public List<TruleInstanceMcc> getBigMccList() {
		return bigMccList;
	}

	/**
	 * @param bigMccList the bigMccList to set
	 */
	public void setBigMccList(List<TruleInstanceMcc> bigMccList) {
		this.bigMccList = bigMccList;
	}

	/**
	 * @return the mccList
	 */
	public List<TruleInstanceMcc> getMccList() {
		return mccList;
	}

	/**
	 * @param mccList the mccList to set
	 */
	public void setMccList(List<TruleInstanceMcc> mccList) {
		this.mccList = mccList;
	}

}
