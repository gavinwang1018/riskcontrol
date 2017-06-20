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
import cn.com.brilliance.begen.service.TbaseargService;
import cn.com.brilliance.begen.webapp.action.BasePage;
import cn.com.brilliance.begen.common.webapp.action.ListPage;

/**
 * Tbasearg对象List.
 * @author Administrator.
 *
 */
public class TbaseargList extends BasePage implements ListPage {

	private TbaseargService service = (TbaseargService)getBean("tbaseargService");
    /**
     * tbaseargs.
     */
    private List<Tbasearg> tbaseargs;

    /**
     * dataTable.
     */
    private HtmlDataTable dataTable;

    /**
     * tbasearg.
     */
    private Tbasearg tbasearg = null;

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
     * 调帐类型
     */
    private boolean adjust;
	
	private boolean turnback;
	
	private boolean askfund;
	
	private boolean returnback;
	
	private boolean reaskfund;
	
	private boolean others;
	
	private boolean certain1;
	
	private boolean certain2;
    
	public boolean isAdjust() {
		return adjust;
	}

	public void setAdjust(boolean adjust) {
		this.adjust = adjust;
	}

	public boolean isAskfund() {
		return askfund;
	}

	public void setAskfund(boolean askfund) {
		this.askfund = askfund;
	}

	public boolean isCertain1() {
		return certain1;
	}

	public void setCertain1(boolean certain1) {
		this.certain1 = certain1;
	}

	public boolean isCertain2() {
		return certain2;
	}

	public void setCertain2(boolean certain2) {
		this.certain2 = certain2;
	}

	public boolean isOthers() {
		return others;
	}

	public void setOthers(boolean others) {
		this.others = others;
	}

	public boolean isReaskfund() {
		return reaskfund;
	}

	public void setReaskfund(boolean reaskfund) {
		this.reaskfund = reaskfund;
	}

	public boolean isReturnback() {
		return returnback;
	}

	public void setReturnback(boolean returnback) {
		this.returnback = returnback;
	}

	public boolean isTurnback() {
		return turnback;
	}

	public void setTurnback(boolean turnback) {
		this.turnback = turnback;
	}
    
    
    
    
    
    
    
    /**
     * 默认构造函数.
     */
    public TbaseargList() {
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
     * Returns the Tbasearg.
     * @return Tbasearg.
     */
    public void setTbasearg(Tbasearg tbasearg) {
        this.tbasearg = tbasearg;
    }

    /**
     * Sets the Tbasearg.
     * @param tbasearg The tbasearg to set.
     */
    public Tbasearg getTbasearg() {
        return this.tbasearg;
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
     * 获得Tbasearg对象列表.
     * @return List.
     */
    public List<Tbasearg> getTbaseargs() {
        return this.tbaseargs;
    }
	
	public void initTbaseargs(){
	    try {
            if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));

            this.tbaseargs = service.init(this.tbasearg,this.queryFields);
			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}

	public void initWarnLevel(){
		try {
            if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));
            	queryFields.put("type","WarnLevel");
            this.tbaseargs = service.init(this.tbasearg,this.queryFields);
			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}
	
	public void initNewMerTime(){
		try {
            if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));
            	queryFields.put("type","MchntType");
            	queryFields.put("name","新发展商户");
            this.tbaseargs = service.init(this.tbasearg,this.queryFields);
			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}
	
	public void initSimilarCardTime(){
		try {
            if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));
            	queryFields.put("type","SimilarCard");
            this.tbaseargs = service.init(this.tbasearg,this.queryFields);
			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}
	
	public void initCanceledCardTime(){
		try {
            if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));
            	queryFields.put("type","MchntType");
            	queryFields.put("name","已撤销商户");
            this.tbaseargs = service.init(this.tbasearg,this.queryFields);
			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}
	
	public void initCaseMer(){
		try {
            if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));
            	queryFields.put("type","MchntType");
            	queryFields.put("name","触发案例商户");
            this.tbaseargs = service.init(this.tbasearg,this.queryFields);
			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}
	
	public void initAdjustmentType(){
		try {
            if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));
            	queryFields.put("type","Adjustment");
            this.tbaseargs = service.init(this.tbasearg,this.queryFields);
            Tbasearg  basearg = (Tbasearg) tbaseargs.get(0);
            String adjust = basearg.getParam1();
            
            if (adjust.charAt(0)=='0'){
            	this.adjust = false;
            }else{
            	this.adjust = true;
            }
            
            if (adjust.charAt(1)=='0'){
            	this.turnback = false;
            }else{
            	this.turnback = true;
            }
            if (adjust.charAt(2)=='0'){
            	this.askfund = false;
            }else{
            	this.askfund = true;
            }
            if (adjust.charAt(3)=='0'){
            	this.returnback = false;
            }else{
            	this.returnback = true;
            }
            if (adjust.charAt(4)=='0'){
            	this.reaskfund = false;
            }else{
            	this.reaskfund = true;
            }
            if (adjust.charAt(5)=='0'){
            	this.others = false;
            }else{
            	this.others = true;
            }
            if (adjust.charAt(6)=='0'){
            	this.certain1 = false;
            }else{
            	this.certain1 = true;
            }
            if (adjust.charAt(7)=='0'){
            	this.certain2 = false;
            }else{
            	this.certain2 = true;
            }
            
			unload = true;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}
	
	public String saveAdjustment(){
        try {
        	String str = "";
        	
        	if (this.adjust){
        		str = str + "1";
        	}else{
        		str = str + "0";
        	}
        	if (this.turnback){
        		str = str + "1";
        	}else{
        		str = str + "0";
        	}
        	if (this.askfund){
        		str = str + "1";
        	}else{
        		str = str + "0";
        	}
        	if (this.returnback){
        		str = str + "1";
        	}else{
        		str = str + "0";
        	}
        	if (this.reaskfund){
        		str = str + "1";
        	}else{
        		str = str + "0";
        	}
        	if (this.others){
        		str = str + "1";
        	}else{
        		str = str + "0";
        	}
        	if (this.certain1){
        		str = str + "1";
        	}else{
        		str = str + "0";
        	}
        	if (this.certain2){
        		str = str + "1";
        	}else{
        		str = str + "0";
        	}
        	
        	if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));
            	queryFields.put("type","Adjustment");
            this.tbaseargs = service.init(this.tbasearg,this.queryFields);
            Tbasearg  basearg = (Tbasearg) tbaseargs.get(0);
        	
            basearg.setParam1(str);
            
            service.saveTbasearg(basearg);
            
	        addMessage("tbasearg.message.savedAll",null);
			return this.getSuccessAction();
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
		return null;
	}	
	
    /**
     * Sets the Tbaseargs.
     * @param tbaseargs The Tbaseargs to set.
     */
    public void setTbaseargs(List tbaseargs) {
        this.tbaseargs = tbaseargs;
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
     * 删除Tbasearg对象.
     * @return String.
     */
    public void delete() {
        try {
            Tbasearg tbasearg = tbaseargs.get(rowIndex);
            service.delete(tbasearg.getId());		
            addMessage("tbasearg.message.deleted", tbasearg.getId());		
            this.tbaseargs.remove(rowIndex.intValue());
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
    }
    /**
     * 删除Tbasearg对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            Tbasearg tbasearg = tbaseargs.get(rowIndex);

            service.delete(this.tbasearg.getId());
            addMessage("tbasearg.message.deleted", this.tbasearg.getId());				
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return null;
        }
        return null;
    }
    /**
     *    查询Tbasearg对象.
     *  @return String.
     */
    public String query() {
        try {
            this.tbaseargs = service.getTbaseargListOfQuery(this.queryFields);
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
        return null;
    }

    /**
     *    查询交易码
     * @return
     */
    public String queryTradeCode(){
    	try {
    		String simbol = "ProcCode";
    		
            this.tbaseargs = service.getTbaseargByType(this.queryFields,simbol);
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
    	return null;
    }

    /**
     *   查询响应码
     * @return
     */
    public String queryResponseCode(){
    	try {
    		String simbol = "RespCode";
            this.tbaseargs = service.getTbaseargByType(this.queryFields,simbol);
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
		Tbasearg tbasearg = new Tbasearg();
		tbasearg.set_record_index(-1);		
    	tbasearg.set_edit_flag(Tbasearg.EDIT_FLAG_ADD);
        this.tbaseargs.add(tbasearg);
    }
	
	public void popupAdd(){
		Tbasearg tbasearg = new Tbasearg();
		tbasearg.set_record_index(-1);		
    	tbasearg.set_edit_flag(Tbasearg.EDIT_FLAG_ADD);
    	this.getRequest().getSession().setAttribute("__pop_object", tbasearg); 	
    }
	
	public void popupEdit(){
		Tbasearg tbasearg = tbaseargs.get(rowIndex);
    	tbasearg.set_record_index(rowIndex);
    	if (Tbasearg.EDIT_FLAG_ADD != tbasearg.get_edit_flag()){
    		tbasearg.set_edit_flag(Tbasearg.EDIT_FLAG_EDIT);
    	}    	
    	this.getRequest().getSession().setAttribute("__pop_object", tbasearg); 	
	}	
	
	public void popupView(){
		Tbasearg tbasearg = tbaseargs.get(rowIndex.intValue());
    	this.getRequest().getSession().setAttribute("__pop_object", tbasearg); 	
	}	
    
    public void popupRefresh(){
    	Tbasearg tbasearg = (Tbasearg)this.getRequest().getSession().getAttribute("__pop_object");
    	if (tbasearg.get_record_index() != -1){
    		this.tbaseargs.remove(tbasearg.get_record_index());
    		this.tbaseargs.add(tbasearg.get_record_index(), tbasearg);
    	}
    	else{
    		this.tbaseargs.add(tbasearg);
    	}
		this.getRequest().getSession().removeAttribute("__pop_object");
    }
    
    public String edit(){
        Tbasearg tbasearg = tbaseargs.get(rowIndex.intValue());
    	tbasearg.set_record_index(rowIndex);
    	if (Tbasearg.EDIT_FLAG_ADD != tbasearg.get_edit_flag()){
    		tbasearg.set_edit_flag(Tbasearg.EDIT_FLAG_EDIT);
			this.setValueBinding("#{tbaseargForm.tbaseargPrimaryKey}", tbasearg.getId());
    	}
    	return this.getSuccessAction();
    }
    
    public String view(){
        Tbasearg tbasearg = tbaseargs.get(rowIndex.intValue());
		this.setValueBinding("#{tbaseargForm.tbaseargPrimaryKey}", tbasearg.getId());
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
    	Tbasearg tbasearg  = tbaseargs.get(rowIndex.intValue());
    	if (Tbasearg.EDIT_FLAG_ADD != tbasearg.get_edit_flag()){
			deleteList.add(tbasearg.getId());    	
		}
		tbaseargs.remove(rowIndex.intValue());
    }	
	
    public void moveUpBuffer(){
    	int i = rowIndex;
    	int j = getMovedTbaseargIndex(i,-1);
    	if (j == -1)
    		return ;
    	Tbasearg tbasearg = tbaseargs.get(i);
    	tbaseargs.add(j, tbasearg);
    	tbaseargs.remove(i + 1);
    }	
	
    private int getMovedTbaseargIndex(int index,int step){
    	if (index + step >= 0 && index + step < tbaseargs.size()){
    		Tbasearg tbasearg = tbaseargs.get(index + step);
    		if (Tbasearg.EDIT_FLAG_DELETE == tbasearg.get_edit_flag())
    			return index + step + getMovedTbaseargIndex(index + step,step);
    		else
    			return index + step;
    	}else{
    		return -1;
    	}    	
    }	
	
    public void moveDownBuffer(){
    	int i = rowIndex;
    	int j = getMovedTbaseargIndex(i,1);
    	if (j == -1)
    		return ;
    	Tbasearg tbasearg = tbaseargs.get(j);
    	tbaseargs.add(i, tbasearg);
    	tbaseargs.remove(j + 1);
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
            for (int i=0; i < tbaseargs.size(); i++) {
                Tbasearg tbasearg = (Tbasearg)this.tbaseargs.get(i);
                service.saveTbasearg(tbasearg);
            }
	        addMessage("tbasearg.message.savedAll",null);
			return this.getSuccessAction();
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
		return null;
	}	
	
	public void deleteChecked(){
		for(Tbasearg tbasearg : this.tbaseargs){
			if(tbasearg.is_checked_flag()){
				service.delete(tbasearg.getId());
			}
		}
	}
	
	public void deleteAll(){
		service.deleteAll(this.tbaseargs);
	}
}
