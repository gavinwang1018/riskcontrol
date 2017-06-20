package cn.com.brilliance.begen.webapp.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;

import cn.com.brilliance.begen.exception.BeGenException;
import cn.com.brilliance.begen.model.ExtTruleInstanceMcc;
import cn.com.brilliance.begen.model.Trule;
import cn.com.brilliance.begen.model.TruleInstance;
import cn.com.brilliance.begen.model.TruleInstanceMcc;
import cn.com.brilliance.begen.service.ExtTruleInstanceMccService;
import cn.com.brilliance.begen.service.TruleInstanceMccService;
import cn.com.brilliance.begen.service.TruleInstanceService;
import cn.com.brilliance.begen.service.TruleService;
import cn.com.brilliance.risk.ext.common.NumberComparator;

/**
 * TruleInstanceMcc对象List.
 * @author Administrator.
 *
 */
public class ExtTruleInstanceMccList extends BasePage {

	private ExtTruleInstanceMccService service = (ExtTruleInstanceMccService)getBean("extTruleInstanceMccService");
	
    /**
     * truleInstanceMccs.
     */  
    private List<TruleInstanceMcc> truleInstanceMccs;

    /**
     * dataTable.
     */
    private HtmlDataTable dataTable;

    /**
     * truleInstanceMcc.
     */
    private ExtTruleInstanceMcc extTruleInstanceMcc = null;

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
    public ExtTruleInstanceMccList() {
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
    public void setExtTruleInstanceMcc(ExtTruleInstanceMcc extTruleInstanceMcc) {
        this.extTruleInstanceMcc = extTruleInstanceMcc;
    }

    /**
     * Sets the TruleInstanceMcc.
     * @param truleInstanceMcc The truleInstanceMcc to set.
     */
    public ExtTruleInstanceMcc getExtTruleInstanceMcc() {
        return this.extTruleInstanceMcc;
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

	public void initTruleInstanceBigMccs(){
	    try {
	    	if(null==(String) this.getValueBinding("#{truleInstanceForm.truleInstancePrimaryKey}")){
	            if (this.sortColumn != null)
	                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));
	            this.truleInstanceMccs =  new ArrayList<TruleInstanceMcc>();
	            for(int i=1; i<6; i++){
		            TruleInstanceMcc extTruleInstanceMcc = new TruleInstanceMcc();
		            extTruleInstanceMcc.setBigmccCode("" + i);
		            this.truleInstanceMccs.add(extTruleInstanceMcc);
	            }
	    		
	    	}else{
	    		this.initTruleInstanceBigMccsView();
	    	}

			unload = true;
        } catch (BeGenException e) {
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}
	
//	编辑过程的初始
	public void initTruleInstanceBigMccsView(){
		this.truleInstanceMccs = new ArrayList();
		String instanceId = (String) this.getValueBinding("#{truleInstanceForm.truleInstancePrimaryKey}");
	    try {
            if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));
            
//            this.truleInstanceMccs =  new ArrayList<TruleInstanceMcc>();

            TruleInstanceMcc truleInstanceMcc = new TruleInstanceMcc();
            truleInstanceMcc.setRuleInstanceId(instanceId);
            
            TruleInstanceMccService mccService = (TruleInstanceMccService) getBean("truleInstanceMccService");
            queryFields.put("ruleInstanceId", instanceId);
            queryFields.put("mccCode", "*");
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
					this.truleInstanceMccs.add(mcc);
			}
			unload = true;


        } catch (BeGenException e) {
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}
	
	public void initParameterConfig(){
	    try {
	    	if(null == (String) this.getValueBinding("#{truleInstanceForm.truleInstancePrimaryKey}")){
	            if (this.sortColumn != null)
	                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));
	            
	            this.truleInstanceMccs =  new ArrayList<TruleInstanceMcc>();
	            for(int i=1; i<2; i++){
		            TruleInstanceMcc extTruleInstanceMcc = new TruleInstanceMcc();
		            extTruleInstanceMcc.setBigmccCode("" + i);
		            this.truleInstanceMccs.add(extTruleInstanceMcc);
	            }
	    	}else{
	    		this.initParameterConfigView();
	    	}

			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}
	
	public void initParameterConfigView(){
		this.truleInstanceMccs = new ArrayList();
		String instanceId = (String) this.getValueBinding("#{truleInstanceForm.truleInstancePrimaryKey}");
	    try {
            if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));
            
//            this.truleInstanceMccs =  new ArrayList<TruleInstanceMcc>();

            TruleInstanceMcc truleInstanceMcc = new TruleInstanceMcc();
            truleInstanceMcc.setRuleInstanceId(instanceId);
            
            TruleInstanceMccService mccService = (TruleInstanceMccService) getBean("truleInstanceMccService");
            queryFields.put("ruleInstanceId", instanceId);
            queryFields.put("mccCode", "*");
            queryFields.put("bigmccCode", "*");
            List<TruleInstanceMcc> list = mccService.getTruleInstanceMccListOfQuery(queryFields);
            
			for (TruleInstanceMcc mcc : list) {
				String code = mcc.getRuleInstanceIdOfTruleInstance().getCode();
				if(code.equals("R31")){
					String param1 = mcc.getParam1().substring(0,4)+"-"+mcc.getParam1().substring(4,6)+"-"+mcc.getParam1().substring(6,8);
					String param2 = mcc.getParam2().substring(0,4)+"-"+mcc.getParam2().substring(4,6)+"-"+mcc.getParam2().substring(6,8);
					mcc.setParam1(param1);
					mcc.setParam2(param2);
				}
				this.truleInstanceMccs.add(mcc);
			}
//            this.extTruleInstanceMccs = service.init(this.extTruleInstanceMcc,this.queryFields);
			unload = true;


        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
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

  
	
	public Integer getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(Integer rowIndex) {
		this.rowIndex = rowIndex;
	}

	/**
	 * @return the truleInstanceMccs
	 */
	public List<TruleInstanceMcc> getTruleInstanceMccs() {
		return truleInstanceMccs;
	}

	/**
	 * @param truleInstanceMccs the truleInstanceMccs to set
	 */
	public void setTruleInstanceMccs(List<TruleInstanceMcc> truleInstanceMccs) {
		this.truleInstanceMccs = truleInstanceMccs;
	}

}
