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
 * Trule对象Form.
 * @author Administrator.
 *
 */
public class TruleForm extends BasePage implements FormPage {

	private TruleService service = (TruleService)getBean("truleService");

    private String lookupKey;        
	
    /**
     * trule对象.
     */
    private Trule trule;

    /**
     * Trule对象主键.
     */
    private java.lang.String trulePrimaryKey;
	
	
	public String getLookupKey() {
		return lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}	

    /**
     * Returns the Trule.
     * @return Trule.
     */
    public Trule getTrule() {
        if(trule == null) {
            trule = new Trule();
        }
        return trule;
    }

    /**
     * Sets the Trule.
     * @param trule The trule to set.
     */
    public void setTrule(Trule trule) {
        this.trule = trule;
    }

    /**
     * Returns the trulePrimaryKey.
     * @return TrulePrimaryKey.
     */
    public java.lang.String getTrulePrimaryKey() {
        return trulePrimaryKey;
    }

    /**
     * Sets the trulePrimaryKey.
     * @param trulePrimaryKey The TrulePrimaryKey to set.
     */
    public void setTrulePrimaryKey(java.lang.String trulePrimaryKey) {
		this.trulePrimaryKey = trulePrimaryKey;
		initTrule();
    }
	
	public void initTrule(){
        try {
            if (trulePrimaryKey == null || trulePrimaryKey.equals("")) {
                return;
            }
            this.setTrule(service.getTrule(trulePrimaryKey));    
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}	


    /**
     * 存储Trule对象.
     * @return String.
     */
    public String save() {
        try {
            if (trulePrimaryKey == null  && this.trule.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTrule(this.trule.getId()) != null) {
                    addMessage("error.database.duplicatekey", "id[" + this.trule.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (trulePrimaryKey == null || trulePrimaryKey.equals(this.trule.getId())) {
            	this.trule = service.saveTrule(this.trule);
                String key = trule.getId();
				this.trulePrimaryKey = key;
                if (trulePrimaryKey == null) {
                    addMessage("trule.message.added", this.trule.getId());				
                }
                else {
                    addMessage("trule.message.saved", this.trule.getId());					
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
            Trule trule = new Trule();
            this.trule = trule;
            trulePrimaryKey = null;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return null;
    }
    /**
     * 删除Trule对象.
     * @return String.
     */
    public String delete() {
        try {
            service.delete(this.trule.getId());
			CmsUtil.deleteFile("t_rule/"+this.trule.getId());
            addMessage("trule.message.deleted", this.trule.getId());
		
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return getSuccessAction();
    }




    /**
     * 删除Trule对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            Trule trule = service.getTrule(this.trule.getId());
            service.delete(this.trule.getId());
            addMessage("trule.message.deleted", this.trule.getId());	
		
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
    	if(this.trulePrimaryKey == null)
    		return "_key=" + this.trule.getId();
    	return "_key=" + this.trulePrimaryKey;
    }
	
	    
    public String popSave(){
    	this.getRequest().getSession().setAttribute("__pop_object", this.trule);
		this.getRequest().getSession().setAttribute("__pop_data_object", "Trule");
		return "popSuccess";
    }
	
    public String saveAll(){
       try {
            if (trulePrimaryKey == null  && this.trule.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTrule(this.trule.getId()) != null) {
                    addMessage("error.database.duplicatekey", "id[" + this.trule.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (trulePrimaryKey == null || trulePrimaryKey.equals(this.trule.getId())) {
  
                this.trule = service.saveAll(this.trule);
                String key = trule.getId();
				this.trulePrimaryKey = key;
                if (trulePrimaryKey == null) {
                    addMessage("trule.message.added", this.trule.getId());				
                }
                else {
                    addMessage("trule.message.saved", this.trule.getId());					
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
            if (trulePrimaryKey == null  && this.trule.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTrule(this.trule.getId()) != null) {
                    addMessage("error.database.duplicatekey", "id[" + this.trule.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (trulePrimaryKey == null || trulePrimaryKey.equals(this.trule.getId())) {
                this.trule = service.saveAll(this.trule);

                String key = trule.getId();
				this.trulePrimaryKey = key;
                if (trulePrimaryKey == null) {
                    addMessage("trule.message.added", this.trule.getId());				
                }
                else {
                    addMessage("trule.message.saved", this.trule.getId());					
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
	

	public void loadTrule(){	
		Trule trule = (Trule)this.getRequest().getSession().getAttribute("__pop_object");
		this.trule = trule;
		this.getRequest().getSession().removeAttribute("__pop_object");
	}
	
}
