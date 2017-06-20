package cn.com.brilliance.begen.webapp.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.DataModel;
import javax.faces.model.SelectItem;

import cn.com.brilliance.begen.common.webapp.action.DataPage;
import cn.com.brilliance.begen.common.webapp.action.ListPage;
import cn.com.brilliance.begen.dao.TmccDAO;
import cn.com.brilliance.begen.exception.BeGenException;
import cn.com.brilliance.begen.model.TkeoMchnt;
import cn.com.brilliance.begen.model.Tmcc;
import cn.com.brilliance.begen.model.Tmchnt;
import cn.com.brilliance.begen.model.TmchntAndApp;
import cn.com.brilliance.begen.service.TkeoMchntService;
import cn.com.brilliance.begen.service.TmchntAppService;
import cn.com.brilliance.begen.service.TmchntService;

public class TmchntAndAppList extends BasePage implements ListPage {
	private TmchntService service = (TmchntService)getBean("tmchntService");
	
	/**
     * tmchnts.
     */
    private List<Tmchnt> tmchnts;

    //private List<TmchntAndApp> tmchntApps = new List<TmchntAndApp>;
    
    private List tmchntApps = new ArrayList();
    /**
     * dataTable.
     */
    private HtmlDataTable dataTable;

    /**
     * tmchnt.
     */
    private Tmchnt tmchnt = null;

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

    private java.lang.String reason;
    
    private TkeoMchnt tkeoMchnt = new TkeoMchnt();
    
    private java.lang.String type;
    
    private int totalPages;
    
    private int fromPage;
    
    private String big_mcc;
    
    /**
     * emptyList.
     */
    private boolean emptyList = false;
    
    /*List list = new ArrayList<String>();
    */
    
    /**
     * 默认构造函数.
     */
    public TmchntAndAppList() {
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
     * Returns the Tmchnt.
     * @return Tmchnt.
     */
    public void setTmchnt(Tmchnt tmchnt) {
        this.tmchnt = tmchnt;
    }

    /**
     * Sets the Tmchnt.
     * @param tmchnt The tmchnt to set.
     */
    public Tmchnt getTmchnt() {
        return this.tmchnt;
    }

    /**
     * Returns the Map.
     * @return Map.
     */
    public Map getQueryFields() {
        return this.queryFields;
    }

    /**
     * Sets the Map.
     * @param queryFields The Map to set.
     */
    public void setQueryFields(Map queryFields) {
        this.queryFields = queryFields;
    }

    /**
     * 获得Tmchnt对象列表.
     * @return List.
     */
    public List<Tmchnt> getTmchnts() {
        return this.tmchnts;
    }
	
	public void initTmchnts(){
	    try {
            if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));

            this.tmchnts = service.init(this.tmchnt,this.queryFields);
			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}

    /**
     * Sets the Tmchnts.
     * @param tmchnts The Tmchnts to set.
     */
    public void setTmchnts(List tmchnts) {
        this.tmchnts = tmchnts;
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
     * 删除Tmchnt对象.
     * @return String.
     */
    public void delete() {
        try {
            Tmchnt tmchnt = tmchnts.get(rowIndex);
            service.delete(tmchnt.getId());		
            addMessage("tmchnt.message.deleted", tmchnt.getId());		
            this.tmchnts.remove(rowIndex.intValue());
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
    }
    /**
     * 删除Tmchnt对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            Tmchnt tmchnt = tmchnts.get(rowIndex);
            if (tmchnt.getTmchntAppGroup().size() > 0) {
                this.addMessageString("exception.delete.cascade");
                return null;
            }

            service.delete(this.tmchnt.getId());
            addMessage("tmchnt.message.deleted", this.tmchnt.getId());				
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return null;
        }
        return null;
    }
    /**
     *    查询Tmchnt对象.
     *  @return String.
     */
    public String query() {
        try {
            this.tmchnts = service.getTmchntListOfQuery(this.queryFields);
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
		Tmchnt tmchnt = new Tmchnt();
		tmchnt.set_record_index(-1);		
    	tmchnt.set_edit_flag(Tmchnt.EDIT_FLAG_ADD);
        this.tmchnts.add(tmchnt);
    }
	
	
	public void popupAdd(){
		Tmchnt tmchnt = new Tmchnt();
		tmchnt.set_record_index(-1);		
    	tmchnt.set_edit_flag(Tmchnt.EDIT_FLAG_ADD);
    	this.getRequest().getSession().setAttribute("__pop_object", tmchnt); 	
    }
	
	public void popupEdit(){
		Tmchnt tmchnt = tmchnts.get(rowIndex);
    	tmchnt.set_record_index(rowIndex);
    	if (Tmchnt.EDIT_FLAG_ADD != tmchnt.get_edit_flag()){
    		tmchnt.set_edit_flag(Tmchnt.EDIT_FLAG_EDIT);
    	}    	
    	this.getRequest().getSession().setAttribute("__pop_object", tmchnt); 	
	}	
	
	public void popupView(){
		Tmchnt tmchnt = tmchnts.get(rowIndex.intValue());
    	this.getRequest().getSession().setAttribute("__pop_object", tmchnt); 	
	}	
    
    public void popupRefresh(){
    	Tmchnt tmchnt = (Tmchnt)this.getRequest().getSession().getAttribute("__pop_object");
    	if (tmchnt.get_record_index() != -1){
    		this.tmchnts.remove(tmchnt.get_record_index());
    		this.tmchnts.add(tmchnt.get_record_index(), tmchnt);
    	}
    	else{
    		this.tmchnts.add(tmchnt);
    	}
		this.getRequest().getSession().removeAttribute("__pop_object");
    }
    
    public String edit(){
        Tmchnt tmchnt = tmchnts.get(rowIndex.intValue());
    	tmchnt.set_record_index(rowIndex);
    	if (Tmchnt.EDIT_FLAG_ADD != tmchnt.get_edit_flag()){
    		tmchnt.set_edit_flag(Tmchnt.EDIT_FLAG_EDIT);
			this.setValueBinding("#{tmchntForm.tmchntPrimaryKey}", tmchnt.getId());
    	}
    	return this.getSuccessAction();
    }
    
    public String view(){	
    	TmchntAndApp tmchnt = (TmchntAndApp)((List) dataModel.getWrappedData()).get(rowIndex.intValue());
		this.setValueBinding("#{tmchntForm.tmchntPrimaryKey}", tmchnt.getId());
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
    	Tmchnt tmchnt  = tmchnts.get(rowIndex.intValue());
    	if (Tmchnt.EDIT_FLAG_ADD != tmchnt.get_edit_flag()){
			deleteList.add(tmchnt.getId());    	
		}
		tmchnts.remove(rowIndex.intValue());
    }	
	
    public void moveUpBuffer(){
    	int i = rowIndex;
    	int j = getMovedTmchntIndex(i,-1);
    	if (j == -1)
    		return ;
    	Tmchnt tmchnt = tmchnts.get(i);
    	tmchnts.add(j, tmchnt);
    	tmchnts.remove(i + 1);
    }	
	
    private int getMovedTmchntIndex(int index,int step){
    	if (index + step >= 0 && index + step < tmchnts.size()){
    		Tmchnt tmchnt = tmchnts.get(index + step);
    		if (Tmchnt.EDIT_FLAG_DELETE == tmchnt.get_edit_flag())
    			return index + step + getMovedTmchntIndex(index + step,step);
    		else
    			return index + step;
    	}else{
    		return -1;
    	}    	
    }	
	
    public void moveDownBuffer(){
    	int i = rowIndex;
    	int j = getMovedTmchntIndex(i,1);
    	if (j == -1)
    		return ;
    	Tmchnt tmchnt = tmchnts.get(j);
    	tmchnts.add(i, tmchnt);
    	tmchnts.remove(j + 1);
    }	
    public void saveAllOfTmcc(String tmccid){
    	for(String id : deleteList){
    		service.delete(id);
    	}		
    	int i = 0;
		if(this.tmchnts != null){
			for(Tmchnt tmchnt : this.tmchnts){    		
        		if (tmchnt.get_edit_flag() == Tmchnt.EDIT_FLAG_ADD || tmchnt.get_edit_flag() == Tmchnt.EDIT_FLAG_EDIT){
           			tmchnt.setMerchantcategory(tmccid);
        			i++;
        			service.saveTmchnt(tmchnt);
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
            for (int i=0; i < tmchnts.size(); i++) {
                Tmchnt tmchnt = (Tmchnt)this.tmchnts.get(i);
                service.saveTmchnt(tmchnt);
            }
	        addMessage("tmchnt.message.savedAll",null);
			return this.getSuccessAction();
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
		return null;
	}	
	
	public void deleteChecked(){
		for(Tmchnt tmchnt : this.tmchnts){
			if(tmchnt.is_checked_flag()){
				service.delete(tmchnt.getId());
			}
		}
	}
	
	public void deleteAll(){
		service.deleteAll(this.tmchnts);
	}

	public java.lang.String getReason() {
		return reason;
	}

	public void setReason(java.lang.String reason) {
		this.reason = reason;
	}

	public TkeoMchnt getTkeoMchnt() {
		return tkeoMchnt;
	}

	public void setTkeoMchnt(TkeoMchnt tkeoMchnt) {
		this.tkeoMchnt = tkeoMchnt;
	}

	public java.lang.String getType() {
		return type;
	}

	public void setType(java.lang.String type) {
		this.type = type;
	}

	public DataModel getTmchntApps() {
		System.out.println("load dataModel...");
		if(this.emptyList){
			return null;
		}
		if (dataModel == null) {
			dataModel = new LocalDataModel(COMMON_PAGE_SIZE);
		}
		return dataModel;
	}


	public void setTmchntApps(ArrayList tmchntApps) {
		this.tmchntApps = tmchntApps;
	}

	public int getFromPage() {
		return fromPage;
	}

	public void setFromPage(int fromPage) {
		this.fromPage = fromPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
	private List<SelectItem> tmccNamesOfTmccs = new ArrayList<SelectItem>();

	public List getCertainMcc(){
		List<SelectItem> itemList = new ArrayList<SelectItem>();
		
		if (this.getQueryFields().containsKey("big_mcc")){
			System.out.println(this.getQueryFields().get("big_mcc"));
		}
		String bigmcc = (String)this.getQueryFields().get("big_mcc");
		if (bigmcc !=null && !"".equals(bigmcc)){
			TmccDAO tmccDAO = (TmccDAO) getBean("tmccDAO");
			List<Tmcc> tmccList = tmccDAO.getTmccByBigMcc(bigmcc);
			for (Tmcc tmcc : tmccList) {
				itemList.add(new SelectItem(tmcc.getId(),tmcc.getMccCode()+"("+tmcc.getBigmccCode()+")"+tmcc.getMccName()));
			}
		}
		
		this.tmccNamesOfTmccs = itemList;
		return null;
		
		
	}

	
	public String getBig_mcc() {
		return big_mcc;
	}

	public void setBig_mcc(String big_mcc) {
		this.big_mcc = big_mcc;
	}
	
	
	

    /**
     * 查询商户及多应用信息
     * @return
     */
	public DataPage getDataPage(int startRow, int pageSize) {
		int total = 0;
			
		List<Tmchnt> mers = new ArrayList();
		
		mers = service.getMerListOfQuery(startRow,pageSize,this.queryFields);
		total = service.getMerListOfQueryNumber(this.queryFields);
        TmchntAppService serv = (TmchntAppService)getBean("tmchntAppService");
        for (Iterator ti = mers.iterator();ti.hasNext();){
        	Tmchnt tmchnt = (Tmchnt)ti.next();
        	
        	TmchntAndApp merApp = new TmchntAndApp();
        	merApp.setId(tmchnt.getId());
        	merApp.setApproveddate(tmchnt.getApproveddate());
        	merApp.setBelongToSubinst(tmchnt.getBelongToSubinst());
        	merApp.setMerchantcategory(tmchnt.getMerchantcategoryOfTmcc().getId());
        	merApp.setMerchantcategoryOfTmcc(tmchnt.getMerchantcategoryOfTmcc());
        	merApp.setMerchantno(tmchnt.getMerchantno());
        	merApp.setName(tmchnt.getName());
        	merApp.setState(tmchnt.getState());
        	merApp.setSubinst(tmchnt.getSubinst());
        	
        	merApp.setSettlementaccntno(serv.getTmchntAppMain(tmchnt.getId()));
        	this.tmchntApps.add(merApp);
		
        }
		
		System.out.println("total is:" + total);
		DataPage dataPage = new DataPage(total , startRow, this.tmchntApps);
		return dataPage;
	}

    /**
     * 查询商户及多应用信息
     * @return
     */
	public String queryMer() {
		try {
			if (dataModel == null) {
				dataModel = new LocalDataModel(COMMON_PAGE_SIZE);
				System.out.println(dataModel);
			}
			
		} catch (BeGenException e) {
			// TODO Auto-generated catch block
			this.addMessage(e.getCode(), e.getMsg(), e);
		}
		return null;
	}
	
	public void setEmptyList(String emptyListString) {
        if ("true".equalsIgnoreCase(emptyListString) || "yes".equalsIgnoreCase(emptyListString)) {
            this.emptyList = true;
        }
        else {
            this.emptyList = false;
        }
    }

	
	public List getBigmccCodeNames() {
		List nameList = new ArrayList<String>();
		nameList.add("一类");
		nameList.add("二类");
		nameList.add("三类");
		nameList.add("四类");
		nameList.add("五类");
		List list = new ArrayList();
		Integer i = 0;
		for (Iterator iter = nameList.iterator(); iter.hasNext();) {
			i++;
			String s = (String) iter.next();
			list.add(new SelectItem(String.valueOf(i), s));
		}
		getCertainMcc();
		return list;
	}

	public List<SelectItem> getTmccNamesOfTmccs() {
		return tmccNamesOfTmccs;
	}

	public void setTmccNamesOfTmccs(List<SelectItem> tmccNamesOfTmccs) {
		this.tmccNamesOfTmccs = tmccNamesOfTmccs;
	}
	
	public List getTmccNamessOfTmccs() {
		List list = new ArrayList();
		TmccDAO tmccDAO = (TmccDAO) getBean("tmccDAO");
		Map queryMap = new  HashMap();
		List<Tmcc> tmccList = tmccDAO.getTmccNames(queryMap);
		for (Tmcc tmcc : tmccList) {
			list.add(new SelectItem(tmcc.getId(), tmcc.getMccCode() + "("
					+ tmcc.getBigmccCode() + ")" + tmcc.getMccName()));

		}
		return list;
	}
	

}
