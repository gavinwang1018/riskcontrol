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
 * TriskprocessTimelimit对象Form.
 * @author Administrator.
 *
 */
public class TriskprocessTimelimitForm extends BasePage implements FormPage {

	private TriskprocessTimelimitService service = (TriskprocessTimelimitService)getBean("triskprocessTimelimitService");

    private String lookupKey;        
	
    /**
     * triskprocessTimelimit对象.
     */
    private TriskprocessTimelimit triskprocessTimelimit;

    /**
     * TriskprocessTimelimit对象主键.
     */
    private java.lang.String triskprocessTimelimitPrimaryKey;
	
    private TorganizeInfo subinst ;
    
	public TorganizeInfo getSubinst() {
		return subinst;
	}

	public void setSubinst(TorganizeInfo subinst) {
		this.subinst = this.getUserBean().getTuserInfo().getOrganizeIdOfTorganizeInfo();
	}

	public String getLookupKey() {
		return lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}	

    /**
     * Returns the TriskprocessTimelimit.
     * @return TriskprocessTimelimit.
     */
    public TriskprocessTimelimit getTriskprocessTimelimit() {
        if(triskprocessTimelimit == null) {
            triskprocessTimelimit = new TriskprocessTimelimit();
        }
        return triskprocessTimelimit;
    }

    /**
     * Sets the TriskprocessTimelimit.
     * @param triskprocessTimelimit The triskprocessTimelimit to set.
     */
    public void setTriskprocessTimelimit(TriskprocessTimelimit triskprocessTimelimit) {
        this.triskprocessTimelimit = triskprocessTimelimit;
    }

    /**
     * Returns the triskprocessTimelimitPrimaryKey.
     * @return TriskprocessTimelimitPrimaryKey.
     */
    public java.lang.String getTriskprocessTimelimitPrimaryKey() {
        return triskprocessTimelimitPrimaryKey;
    }

    /**
     * Sets the triskprocessTimelimitPrimaryKey.
     * @param triskprocessTimelimitPrimaryKey The TriskprocessTimelimitPrimaryKey to set.
     */
    public void setTriskprocessTimelimitPrimaryKey(java.lang.String triskprocessTimelimitPrimaryKey) {
		this.triskprocessTimelimitPrimaryKey = triskprocessTimelimitPrimaryKey;
		initTriskprocessTimelimit();
    }
	
	public void initTriskprocessTimelimit(){
        try {
            if (triskprocessTimelimitPrimaryKey == null || triskprocessTimelimitPrimaryKey.equals("")) {
                return;
            }
            this.setTriskprocessTimelimit(service.getTriskprocessTimelimit(triskprocessTimelimitPrimaryKey));    
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}	


    /**
     * 存储TriskprocessTimelimit对象.
     * @return String.
     */
    public String save() {
        try {
            if (triskprocessTimelimitPrimaryKey == null  && this.triskprocessTimelimit.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTriskprocessTimelimit(this.triskprocessTimelimit.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.triskprocessTimelimit.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (triskprocessTimelimitPrimaryKey == null || triskprocessTimelimitPrimaryKey.equals(this.triskprocessTimelimit.getId())) {
            	this.triskprocessTimelimit = service.saveTriskprocessTimelimit(this.triskprocessTimelimit);
                String key = triskprocessTimelimit.getId();
				this.triskprocessTimelimitPrimaryKey = key;
                if (triskprocessTimelimitPrimaryKey == null) {
                    addMessage("triskprocessTimelimit.message.added", this.triskprocessTimelimit.getId());				
                }
                else {
                    addMessage("triskprocessTimelimit.message.saved", this.triskprocessTimelimit.getId());					
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
            TriskprocessTimelimit triskprocessTimelimit = new TriskprocessTimelimit();
            triskprocessTimelimit.setBelongToInst(this.triskprocessTimelimit.getBelongToInst());
            this.triskprocessTimelimit = triskprocessTimelimit;
            triskprocessTimelimitPrimaryKey = null;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return null;
    }
    /**
     * 删除TriskprocessTimelimit对象.
     * @return String.
     */
    public String delete() {
        try {
            service.delete(this.triskprocessTimelimit.getId());
			CmsUtil.deleteFile("t_riskprocess_timelimit/"+this.triskprocessTimelimit.getId());
            addMessage("triskprocessTimelimit.message.deleted", this.triskprocessTimelimit.getId());
		
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return getSuccessAction();
    }




    /**
     * 删除TriskprocessTimelimit对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            TriskprocessTimelimit triskprocessTimelimit = service.getTriskprocessTimelimit(this.triskprocessTimelimit.getId());
            service.delete(this.triskprocessTimelimit.getId());
            addMessage("triskprocessTimelimit.message.deleted", this.triskprocessTimelimit.getId());	
		
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
    	if(this.triskprocessTimelimitPrimaryKey == null)
    		return "_key=" + this.triskprocessTimelimit.getId();
    	return "_key=" + this.triskprocessTimelimitPrimaryKey;
    }
	
	    
    public String popSave(){
    	this.getRequest().getSession().setAttribute("__pop_object", this.triskprocessTimelimit);
		this.getRequest().getSession().setAttribute("__pop_data_object", "TriskprocessTimelimit");
		return "popSuccess";
    }
	
    public String saveAll(){
       try {
            if (triskprocessTimelimitPrimaryKey == null  && this.triskprocessTimelimit.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTriskprocessTimelimit(this.triskprocessTimelimit.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.triskprocessTimelimit.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (triskprocessTimelimitPrimaryKey == null || triskprocessTimelimitPrimaryKey.equals(this.triskprocessTimelimit.getId())) {
  
                this.triskprocessTimelimit = service.saveAll(this.triskprocessTimelimit);
                String key = triskprocessTimelimit.getId();
				this.triskprocessTimelimitPrimaryKey = key;
                if (triskprocessTimelimitPrimaryKey == null) {
                    addMessage("triskprocessTimelimit.message.added", this.triskprocessTimelimit.getId());				
                }
                else {
                    addMessage("triskprocessTimelimit.message.saved", this.triskprocessTimelimit.getId());					
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
            if (triskprocessTimelimitPrimaryKey == null  && this.triskprocessTimelimit.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTriskprocessTimelimit(this.triskprocessTimelimit.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.triskprocessTimelimit.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (triskprocessTimelimitPrimaryKey == null || triskprocessTimelimitPrimaryKey.equals(this.triskprocessTimelimit.getId())) {
                this.triskprocessTimelimit = service.saveAll(this.triskprocessTimelimit);

                String key = triskprocessTimelimit.getId();
				this.triskprocessTimelimitPrimaryKey = key;
                if (triskprocessTimelimitPrimaryKey == null) {
                    addMessage("triskprocessTimelimit.message.added", this.triskprocessTimelimit.getId());				
                }
                else {
                    addMessage("triskprocessTimelimit.message.saved", this.triskprocessTimelimit.getId());					
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
	

	public void loadTriskprocessTimelimit(){	
		TriskprocessTimelimit triskprocessTimelimit = (TriskprocessTimelimit)this.getRequest().getSession().getAttribute("__pop_object");
		this.triskprocessTimelimit = triskprocessTimelimit;
		this.getRequest().getSession().removeAttribute("__pop_object");
	}
	
}
