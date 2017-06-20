package cn.com.brilliance.begen.webapp.action;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Date;
import org.apache.myfaces.custom.fileupload.UploadedFile;

import cn.com.brilliance.begen.exception.BeGenException;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;
import cn.com.brilliance.begen.webapp.action.BasePage;
import cn.com.brilliance.begen.webapp.servlet.UserBean;
import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.webapp.action.FormPage;

/**
 * TmchntApp对象Form.
 * @author Administrator.
 *
 */
public class TmchntAppForm extends BasePage implements FormPage {

	private TmchntAppService service = (TmchntAppService)getBean("tmchntAppService");

    private String lookupKey;        
	
    /**
     * tmchntApp对象.
     */
    private TmchntApp tmchntApp;

    /**
     * TmchntApp对象主键.
     */
    private java.lang.String tmchntAppPrimaryKey;
	
	
	public String getLookupKey() {
		return lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}	

    /**
     * Returns the TmchntApp.
     * @return TmchntApp.
     */
    public TmchntApp getTmchntApp() {
        if(tmchntApp == null) {
            tmchntApp = new TmchntApp();
        }
        return tmchntApp;
    }

    /**
     * Sets the TmchntApp.
     * @param tmchntApp The tmchntApp to set.
     */
    public void setTmchntApp(TmchntApp tmchntApp) {
        this.tmchntApp = tmchntApp;
    }

    /**
     * Returns the tmchntAppPrimaryKey.
     * @return TmchntAppPrimaryKey.
     */
    public java.lang.String getTmchntAppPrimaryKey() {
        return tmchntAppPrimaryKey;
    }

    /**
     * Sets the tmchntAppPrimaryKey.
     * @param tmchntAppPrimaryKey The TmchntAppPrimaryKey to set.
     */
    public void setTmchntAppPrimaryKey(java.lang.String tmchntAppPrimaryKey) {
		this.tmchntAppPrimaryKey = tmchntAppPrimaryKey;
		initTmchntApp();
    }
	
	public void initTmchntApp(){
        try {
            if (tmchntAppPrimaryKey == null || tmchntAppPrimaryKey.equals("")) {
                return;
            }
            this.setTmchntApp(service.getTmchntApp(tmchntAppPrimaryKey));    
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}	


    /**
     * 存储TmchntApp对象.
     * @return String.
     */
    public String save() {
        try {
            if (tmchntAppPrimaryKey == null  && this.tmchntApp.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTmchntApp(this.tmchntApp.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.tmchntApp.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (tmchntAppPrimaryKey == null || tmchntAppPrimaryKey.equals(this.tmchntApp.getId())) {
            	this.tmchntApp = service.saveTmchntApp(this.tmchntApp);
                String key = tmchntApp.getId();
				this.tmchntAppPrimaryKey = key;
                if (tmchntAppPrimaryKey == null) {
                    addMessage("tmchntApp.message.added", this.tmchntApp.getId());				
                }
                else {
                    addMessage("tmchntApp.message.saved", this.tmchntApp.getId());					
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
            TmchntApp tmchntApp = new TmchntApp();
            tmchntApp.setMchntId(this.tmchntApp.getMchntId());
            tmchntApp.setBelongToInst(this.tmchntApp.getBelongToInst());
            this.tmchntApp = tmchntApp;
            tmchntAppPrimaryKey = null;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return null;
    }
    /**
     * 删除TmchntApp对象.
     * @return String.
     */
    public String delete() {
        try {
            service.delete(this.tmchntApp.getId());
			CmsUtil.deleteFile("t_mchnt_app/"+this.tmchntApp.getId());
            addMessage("tmchntApp.message.deleted", this.tmchntApp.getId());
		
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return getSuccessAction();
    }




    /**
     * 删除TmchntApp对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            TmchntApp tmchntApp = service.getTmchntApp(this.tmchntApp.getId());
            service.delete(this.tmchntApp.getId());
            addMessage("tmchntApp.message.deleted", this.tmchntApp.getId());	
		
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
    	if(this.tmchntAppPrimaryKey == null)
    		return "_key=" + this.tmchntApp.getId();
    	return "_key=" + this.tmchntAppPrimaryKey;
    }
	
	    
    public String popSave(){
    	this.getRequest().getSession().setAttribute("__pop_object", this.tmchntApp);
		this.getRequest().getSession().setAttribute("__pop_data_object", "TmchntApp");
		return "popSuccess";
    }
	
    public String saveAll(){
       try {
            if (tmchntAppPrimaryKey == null  && this.tmchntApp.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTmchntApp(this.tmchntApp.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.tmchntApp.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (tmchntAppPrimaryKey == null || tmchntAppPrimaryKey.equals(this.tmchntApp.getId())) {
  
                this.tmchntApp = service.saveAll(this.tmchntApp);
                String key = tmchntApp.getId();
				this.tmchntAppPrimaryKey = key;
                if (tmchntAppPrimaryKey == null) {
                    addMessage("tmchntApp.message.added", this.tmchntApp.getId());				
                }
                else {
                    addMessage("tmchntApp.message.saved", this.tmchntApp.getId());					
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
            if (tmchntAppPrimaryKey == null  && this.tmchntApp.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTmchntApp(this.tmchntApp.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.tmchntApp.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (tmchntAppPrimaryKey == null || tmchntAppPrimaryKey.equals(this.tmchntApp.getId())) {
                this.tmchntApp = service.saveAll(this.tmchntApp);

                String key = tmchntApp.getId();
				this.tmchntAppPrimaryKey = key;
                if (tmchntAppPrimaryKey == null) {
                    addMessage("tmchntApp.message.added", this.tmchntApp.getId());				
                }
                else {
                    addMessage("tmchntApp.message.saved", this.tmchntApp.getId());					
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
	

	public void loadTmchntApp(){	
		TmchntApp tmchntApp = (TmchntApp)this.getRequest().getSession().getAttribute("__pop_object");
		this.tmchntApp = tmchntApp;
		this.getRequest().getSession().removeAttribute("__pop_object");
	}
	
}
