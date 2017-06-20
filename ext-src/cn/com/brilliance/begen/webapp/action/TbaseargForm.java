package cn.com.brilliance.begen.webapp.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Date;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.faces.component.html.HtmlDataTable;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import cn.com.brilliance.begen.exception.BeGenException;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;
import cn.com.brilliance.begen.webapp.action.BasePage;
import cn.com.brilliance.begen.webapp.servlet.UserBean;
import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.webapp.action.FormPage;

/**
 * Tbasearg对象Form.
 * @author Administrator.
 *
 */
public class TbaseargForm extends BasePage implements FormPage {

	private TbaseargService service = (TbaseargService)getBean("tbaseargService");

    private String lookupKey;        
	
    /**
     * tbasearg对象.
     */
    private Tbasearg tbasearg;

    /**
     * Tbasearg对象主键.
     */
    private java.lang.String tbaseargPrimaryKey;
	
    /**
     * tbaseargs.
     */
    private List<Tbasearg> tbaseargs;
    
    /**
     * dataTable.
     */
    private HtmlDataTable dataTable;

    private Integer rowIndex;
    
    /**
     * sortColumn.
     */
    private String sortColumn;

    /**
     * ascending.
     */
    private boolean ascending;
    
    
    /**
     * queryFields.
     */
    private Map queryFields = new HashMap();   //查询条件Map

	public String getLookupKey() {
		return lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}	

    /**
     * Returns the Tbasearg.
     * @return Tbasearg.
     */
    public Tbasearg getTbasearg() {
        if(tbasearg == null) {
            tbasearg = new Tbasearg();
        }
        return tbasearg;
    }

    /**
     * Sets the Tbasearg.
     * @param tbasearg The tbasearg to set.
     */
    public void setTbasearg(Tbasearg tbasearg) {
        this.tbasearg = tbasearg;
    }

    /**
     * Returns the tbaseargPrimaryKey.
     * @return TbaseargPrimaryKey.
     */
    public java.lang.String getTbaseargPrimaryKey() {
        return tbaseargPrimaryKey;
    }

    /**
     * Sets the tbaseargPrimaryKey.
     * @param tbaseargPrimaryKey The TbaseargPrimaryKey to set.
     */
    public void setTbaseargPrimaryKey(java.lang.String tbaseargPrimaryKey) {
		this.tbaseargPrimaryKey = tbaseargPrimaryKey;
		initTbasearg();
    }
	
	public void initTbasearg(){
        try {
            if (tbaseargPrimaryKey == null || tbaseargPrimaryKey.equals("")) {
                return;
            }
            this.setTbasearg(service.getTbasearg(tbaseargPrimaryKey));    
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}	


    /**
     * 存储Tbasearg对象.
     * @return String.
     */
    public String save() {
        try {
            if (tbaseargPrimaryKey == null  && this.tbasearg.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTbasearg(this.tbasearg.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.tbasearg.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (tbaseargPrimaryKey == null || tbaseargPrimaryKey.equals(this.tbasearg.getId())) {
            	this.tbasearg = service.saveTbasearg(this.tbasearg);
                String key = tbasearg.getId();
				this.tbaseargPrimaryKey = key;
                if (tbaseargPrimaryKey == null) {
                    addMessage("tbasearg.message.added", this.tbasearg.getId());				
                }
                else {
                    addMessage("tbasearg.message.saved", this.tbasearg.getId());					
                }				
            }
            else {
                addMessageString("exception.save.primarykey");
                return null;
            }
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return getSuccessAction();
    }

    public String saveAndNew() {
        try {
            String action = save();
            if (action == null) {
                return null;
            }
            Tbasearg tbasearg = new Tbasearg();
            this.tbasearg = tbasearg;
            tbaseargPrimaryKey = null;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return null;
    }
    /**
     * 删除Tbasearg对象.
     * @return String.
     */
    public String delete() {
        try {
            service.delete(this.tbasearg.getId());
			CmsUtil.deleteFile("t_basearg/"+this.tbasearg.getId());
            addMessage("tbasearg.message.deleted", this.tbasearg.getId());
		
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return getSuccessAction();
    }




    /**
     * 删除Tbasearg对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            Tbasearg tbasearg = service.getTbasearg(this.tbasearg.getId());
            service.delete(this.tbasearg.getId());
            addMessage("tbasearg.message.deleted", this.tbasearg.getId());	
		
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return getSuccessAction();
    }
	
    public String edit(){
    	
    	return getSuccessAction();
    }	

    public String getHistoryUrlParameter(){
    	if(this.tbaseargPrimaryKey == null)
    		return "_key=" + this.tbasearg.getId();
    	return "_key=" + this.tbaseargPrimaryKey;
    }
	
	    
    public String popSave(){
    	this.getRequest().getSession().setAttribute("__pop_object", this.tbasearg);
		this.getRequest().getSession().setAttribute("__pop_data_object", "Tbasearg");
		return "popSuccess";
    }
	
    public String saveAll(){
       try {
            if (tbaseargPrimaryKey == null  && this.tbasearg.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTbasearg(this.tbasearg.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.tbasearg.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (tbaseargPrimaryKey == null || tbaseargPrimaryKey.equals(this.tbasearg.getId())) {
  
                this.tbasearg = service.saveAll(this.tbasearg);
                String key = tbasearg.getId();
				this.tbaseargPrimaryKey = key;
                if (tbaseargPrimaryKey == null) {
                    addMessage("tbasearg.message.added", this.tbasearg.getId());				
                }
                else {
                    addMessage("tbasearg.message.saved", this.tbasearg.getId());					
                }				
            }
            else {
                addMessageString("exception.save.primarykey");
                return null;
            }
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
    	return this.getSuccessAction();
    }	

    public String saveMultiAll(){
       try {
            if (tbaseargPrimaryKey == null  && this.tbasearg.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTbasearg(this.tbasearg.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.tbasearg.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (tbaseargPrimaryKey == null || tbaseargPrimaryKey.equals(this.tbasearg.getId())) {
                this.tbasearg = service.saveAll(this.tbasearg);

                String key = tbasearg.getId();
				this.tbaseargPrimaryKey = key;
                if (tbaseargPrimaryKey == null) {
                    addMessage("tbasearg.message.added", this.tbasearg.getId());				
                }
                else {
                    addMessage("tbasearg.message.saved", this.tbasearg.getId());					
                }				
            }
            else {
                addMessageString("exception.save.primarykey");
                return null;
            }
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }

    	return this.getSuccessAction();
    }	
	

	public void loadTbasearg(){	
		Tbasearg tbasearg = (Tbasearg)this.getRequest().getSession().getAttribute("__pop_object");
		this.tbasearg = tbasearg;
		this.getRequest().getSession().removeAttribute("__pop_object");
	}

	public void initWarnLevel(){
		try {
            if (this.sortColumn != null)
                queryFields.put("_order",this.sortColumn + " " + (this.ascending? "asc" : "desc"));
            	queryFields.put("type","WarnLevel");
            this.setTbaseargs(service.getTbaseargListOfQuery(this.queryFields));
			
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}
	
	
	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public Integer getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(Integer rowIndex) {
		this.rowIndex = rowIndex;
	}

	public TbaseargService getService() {
		return service;
	}

	public void setService(TbaseargService service) {
		this.service = service;
	}

	public List<Tbasearg> getTbaseargs() {
		return tbaseargs;
	}

	public void setTbaseargs(List<Tbasearg> tbaseargs) {
		this.tbaseargs = tbaseargs;
	}

	public boolean isAscending() {
		return ascending;
	}

	public void setAscending(boolean ascending) {
		this.ascending = ascending;
	}

	public Map getQueryFields() {
		return queryFields;
	}

	public void setQueryFields(Map queryFields) {
		this.queryFields = queryFields;
	}

	public String getSortColumn() {
		return sortColumn;
	}

	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}
	
	
	/**
	 * 保存所有的配置参数
	 * @return
	 */
	public String saveAlls() {
		TreeMap sortlist = new TreeMap();
		for (Iterator ti = this.tbaseargs.iterator();ti.hasNext();){
			Tbasearg basearg = (Tbasearg) ti.next();
			sortlist.put(basearg.getCode(),basearg);
		}
	
		String err = "";
		for (int t = 0;t < sortlist.size();t++){
			Tbasearg basearg = (Tbasearg) sortlist.get(sortlist.firstKey());
			
			if (basearg.getParam1().compareTo(basearg.getParam2())>0){
				err = err + "参数" +basearg.getCode() + "的上限必须大于下限;\n";
			
			}
			
			sortlist.remove(sortlist.firstKey());
			Tbasearg basearg1 = (Tbasearg) sortlist.get(sortlist.firstKey());
			
			if (basearg1.getParam1().compareTo(basearg1.getParam2())>0){
				err = err + "参数" +basearg.getCode() + "的上限必须大于下限;\n";
			
			}
			
			if (!basearg.getParam2().equals(basearg1.getParam1())){
				err = err + "参数" + basearg.getCode()+ " 的上限必须等于参数  "+basearg1.getCode()+" 的下限;\n";
				
			}
		}
		
		if (!"".equals(err)){
			addMessage("tbasearg.err", err);
			return null;
		}
		
		
		try {
			for (Iterator i = this.tbaseargs.iterator();i.hasNext();){
				Tbasearg arg = (Tbasearg) i.next();
				
				Tbasearg base = service.getTbasearg(arg.getId());
				
				base.setParam1(arg.getParam1());
				base.setParam2(arg.getParam2());
				
				service.saveTbasearg(base);
			}
		} catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
		
		
		return this.getSuccessAction();
		
		//return null;
		
	}
	
	public String saveSimilarCardTime(){
		try {
				Tbasearg base = service.getTbasearg(this.tbasearg.getId());
				
				base.setParam1(this.tbasearg.getParam1());
				
				service.saveTbasearg(base);
			  addMessageString("保存成功");
		} catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
		
		return this.getSuccessAction();
		
	}
	
	public String saveCaseMer(){
		try {
				Tbasearg base = service.getTbasearg(this.tbasearg.getId());
				base.setParam1(this.tbasearg.getParam1());
				base.setParam2(this.tbasearg.getParam2());
				base.setParam3(this.tbasearg.getParam3());
				service.saveTbasearg(base);
			  addMessageString("保存成功");
		} catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
		return this.getSuccessAction();
	}	
	
	
	
}
