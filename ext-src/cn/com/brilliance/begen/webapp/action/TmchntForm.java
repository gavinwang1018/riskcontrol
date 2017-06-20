package cn.com.brilliance.begen.webapp.action;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Date;

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
 * Tmchnt对象Form.
 * @author Administrator.
 *
 */
public class TmchntForm extends BasePage implements FormPage {

	private TmchntService service = (TmchntService)getBean("tmchntService");

    private String lookupKey;        
	
    /**
     * tmchnt对象.
     */
    private Tmchnt tmchnt;

    /**
     * Tmchnt对象主键.
     */
    private java.lang.String tmchntPrimaryKey;
	
    /**
     * dataTable.
     */
    private HtmlDataTable dataTable;
    
    
	public String getLookupKey() {
		return lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}	

    /**
     * Returns the Tmchnt.
     * @return Tmchnt.
     */
    public Tmchnt getTmchnt() {
        if(tmchnt == null) {
            tmchnt = new Tmchnt();
        }
        return tmchnt;
    }

    /**
     * Sets the Tmchnt.
     * @param tmchnt The tmchnt to set.
     */
    public void setTmchnt(Tmchnt tmchnt) {
        this.tmchnt = tmchnt;
    }

    /**
     * Returns the tmchntPrimaryKey.
     * @return TmchntPrimaryKey.
     */
    public java.lang.String getTmchntPrimaryKey() {
        return tmchntPrimaryKey;
    }

    /**
     * Sets the tmchntPrimaryKey.
     * @param tmchntPrimaryKey The TmchntPrimaryKey to set.
     */
    public void setTmchntPrimaryKey(java.lang.String tmchntPrimaryKey) {
		this.tmchntPrimaryKey = tmchntPrimaryKey;
		initTmchnt();
    }
	
	public void initTmchnt(){
        try {
            if (tmchntPrimaryKey == null || tmchntPrimaryKey.equals("")) {
                return;
            }
            this.setTmchnt(service.getTmchnt(tmchntPrimaryKey));    
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}	

    public String loadChildOfTmchntApp() {
        try {
            TmchntAppList tmchntAppList = new TmchntAppList();            
			if(tmchnt.getId() != null && !"".equals(tmchnt.getId()) ){
			   TmchntApp tmchntApp = new TmchntApp();
	           tmchntApp.setMchntId(this.tmchnt.getId());
	           tmchntAppList.setTmchntApp(tmchntApp);
			   tmchntAppList.initTmchntApps();
            }
			else{
			   TmchntApp tmchntApp = new TmchntApp();
	           tmchntAppList.setTmchntApp(tmchntApp);
               tmchntAppList.setTmchntApps(new ArrayList<TmchntApp>());				
			}
            this.setValueBinding("#{tmchntAppList}",tmchntAppList);
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
        return null;
    }

    /**
     * 存储Tmchnt对象.
     * @return String.
     */
    public String save() {
        try {
            if (tmchntPrimaryKey == null  && this.tmchnt.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTmchnt(this.tmchnt.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.tmchnt.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (tmchntPrimaryKey == null || tmchntPrimaryKey.equals(this.tmchnt.getId())) {
            	this.tmchnt = service.saveTmchnt(this.tmchnt);
                String key = tmchnt.getId();
				this.tmchntPrimaryKey = key;
                if (tmchntPrimaryKey == null) {
                    addMessage("tmchnt.message.added", this.tmchnt.getId());				
                }
                else {
                    addMessage("tmchnt.message.saved", this.tmchnt.getId());					
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
            Tmchnt tmchnt = new Tmchnt();
            tmchnt.setMerchantcategory(this.tmchnt.getMerchantcategory());
            this.tmchnt = tmchnt;
            tmchntPrimaryKey = null;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return null;
    }
    /**
     * 删除Tmchnt对象.
     * @return String.
     */
    public String delete() {
        try {
            service.delete(this.tmchnt.getId());
			CmsUtil.deleteFile("t_mchnt/"+this.tmchnt.getId());
            addMessage("tmchnt.message.deleted", this.tmchnt.getId());
		
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return getSuccessAction();
    }




    /**
     * 删除Tmchnt对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            Tmchnt tmchnt = service.getTmchnt(this.tmchnt.getId());
            if (tmchnt.getTmchntAppGroup().size() > 0) {
                this.addMessageString("exception.delete.cascade");
                return getFailureAction();
            }
            service.delete(this.tmchnt.getId());
            addMessage("tmchnt.message.deleted", this.tmchnt.getId());	
		
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
    	if(this.tmchntPrimaryKey == null)
    		return "_key=" + this.tmchnt.getId();
    	return "_key=" + this.tmchntPrimaryKey;
    }
	
	    
    public String popSave(){
    	this.getRequest().getSession().setAttribute("__pop_object", this.tmchnt);
		this.getRequest().getSession().setAttribute("__pop_data_object", "Tmchnt");
		return "popSuccess";
    }
	
    public String saveAll(){
       try {
            if (tmchntPrimaryKey == null  && this.tmchnt.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTmchnt(this.tmchnt.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.tmchnt.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (tmchntPrimaryKey == null || tmchntPrimaryKey.equals(this.tmchnt.getId())) {
  
    	TmchntAppList tmchntAppList = (TmchntAppList)this.getValueBinding("#{tmchntAppList}");	
                this.tmchnt = service.saveAll(this.tmchnt,tmchntAppList.getDeleteList(),tmchntAppList.getTmchntApps());
                String key = tmchnt.getId();
				this.tmchntPrimaryKey = key;
                if (tmchntPrimaryKey == null) {
                    addMessage("tmchnt.message.added", this.tmchnt.getId());				
                }
                else {
                    addMessage("tmchnt.message.saved", this.tmchnt.getId());					
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
            if (tmchntPrimaryKey == null  && this.tmchnt.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTmchnt(this.tmchnt.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.tmchnt.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (tmchntPrimaryKey == null || tmchntPrimaryKey.equals(this.tmchnt.getId())) {
        TmchntAppList tmchntAppList = (TmchntAppList)this.getValueBinding("#{tmchntAppList}");
        List<TmchntApp> tmchntApps = tmchntAppList.getTmchntApps();			
    	List<TmchntApp> tmchntAppLists = new ArrayList<TmchntApp>();
    	for(TmchntApp tmchntApp : tmchntApps){
    		if(tmchntApp.get_edit_flag() != TmchntApp.EDIT_FLAG_EDIT){
    			tmchntApp.set_edit_flag(TmchntApp.EDIT_FLAG_EDIT);    			
    		}
    		tmchntAppLists.add(tmchntApp);
    	}

                this.tmchnt = service.saveAll(this.tmchnt,tmchntAppList.getDeleteList(),tmchntAppLists);

                String key = tmchnt.getId();
				this.tmchntPrimaryKey = key;
                if (tmchntPrimaryKey == null) {
                    addMessage("tmchnt.message.added", this.tmchnt.getId());				
                }
                else {
                    addMessage("tmchnt.message.saved", this.tmchnt.getId());					
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
	
	private void saveTmchntApp(){
    	TmchntAppList tmchntAppList = (TmchntAppList)this.getValueBinding("#{tmchntAppList}");
    	tmchntAppList.saveAllOfTmchnt(tmchnt.getId());
    }	

	public void loadTmchnt(){	
		Tmchnt tmchnt = (Tmchnt)this.getRequest().getSession().getAttribute("__pop_object");
		this.tmchnt = tmchnt;
		this.getRequest().getSession().removeAttribute("__pop_object");
	}

	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}
	
}
