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
 * TroleUser对象Form.
 * @author Administrator.
 *
 */
public class TroleUserForm extends BasePage implements FormPage {

	private TroleUserService service = (TroleUserService)getBean("troleUserService");

    private String lookupKey;        
	
    /**
     * troleUser对象.
     */
    private TroleUser troleUser;

    /**
     * TroleUser对象主键.
     */
    private java.lang.String troleUserPrimaryKey;
	
	
	public String getLookupKey() {
		return lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}	

    /**
     * Returns the TroleUser.
     * @return TroleUser.
     */
    public TroleUser getTroleUser() {
        if(troleUser == null) {
            troleUser = new TroleUser();
        }
        return troleUser;
    }

    /**
     * Sets the TroleUser.
     * @param troleUser The troleUser to set.
     */
    public void setTroleUser(TroleUser troleUser) {
        this.troleUser = troleUser;
    }

    /**
     * Returns the troleUserPrimaryKey.
     * @return TroleUserPrimaryKey.
     */
    public java.lang.String getTroleUserPrimaryKey() {
        return troleUserPrimaryKey;
    }

    /**
     * Sets the troleUserPrimaryKey.
     * @param troleUserPrimaryKey The TroleUserPrimaryKey to set.
     */
    public void setTroleUserPrimaryKey(java.lang.String troleUserPrimaryKey) {
		this.troleUserPrimaryKey = troleUserPrimaryKey;
		initTroleUser();
    }
	
	public void initTroleUser(){
        try {
            if (troleUserPrimaryKey == null || troleUserPrimaryKey.equals("")) {
                return;
            }
            this.setTroleUser(service.getTroleUser(troleUserPrimaryKey));    
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}	


    /**
     * 存储TroleUser对象.
     * @return String.
     */
    public String save() {
        try {
            if(this.troleUser.getId() == null){
                this.troleUser.setId(getAutoNumberValue("t_role_user","id","{000000000}",1));
            }
            if (troleUserPrimaryKey == null  && this.troleUser.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTroleUser(this.troleUser.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.troleUser.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (troleUserPrimaryKey == null || troleUserPrimaryKey.equals(this.troleUser.getId())) {
            	this.troleUser = service.saveTroleUser(this.troleUser);
                String key = troleUser.getId();
				this.troleUserPrimaryKey = key;
                if (troleUserPrimaryKey == null) {
                    addMessage("troleUser.message.added", this.troleUser.getId());				
                }
                else {
                    addMessage("troleUser.message.saved", this.troleUser.getId());					
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
            TroleUser troleUser = new TroleUser();
            this.troleUser = troleUser;
            troleUserPrimaryKey = null;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return null;
    }
    /**
     * 删除TroleUser对象.
     * @return String.
     */
    public String delete() {
        try {
            service.delete(this.troleUser.getId());
			CmsUtil.deleteFile("t_role_user/"+this.troleUser.getId());
            addMessage("troleUser.message.deleted", this.troleUser.getId());
		
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return getSuccessAction();
    }




    /**
     * 删除TroleUser对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            TroleUser troleUser = service.getTroleUser(this.troleUser.getId());
            service.delete(this.troleUser.getId());
            addMessage("troleUser.message.deleted", this.troleUser.getId());	
		
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
    	if(this.troleUserPrimaryKey == null)
    		return "_key=" + this.troleUser.getId();
    	return "_key=" + this.troleUserPrimaryKey;
    }
	
	    
    public String popSave(){
    	this.getRequest().getSession().setAttribute("__pop_object", this.troleUser);
		this.getRequest().getSession().setAttribute("__pop_data_object", "TroleUser");
		return "popSuccess";
    }
	
    public String saveAll(){
       try {
            if(this.troleUser.getId() == null){
                this.troleUser.setId(getAutoNumberValue("t_role_user","id","{000000000}",1));
            }
            if (troleUserPrimaryKey == null  && this.troleUser.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTroleUser(this.troleUser.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.troleUser.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (troleUserPrimaryKey == null || troleUserPrimaryKey.equals(this.troleUser.getId())) {
  
                this.troleUser = service.saveAll(this.troleUser);
                String key = troleUser.getId();
				this.troleUserPrimaryKey = key;
                if (troleUserPrimaryKey == null) {
                    addMessage("troleUser.message.added", this.troleUser.getId());				
                }
                else {
                    addMessage("troleUser.message.saved", this.troleUser.getId());					
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
            if(this.troleUser.getId() == null){
                this.troleUser.setId(getAutoNumberValue("t_role_user","id","{000000000}",1));
            }
            if (troleUserPrimaryKey == null  && this.troleUser.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTroleUser(this.troleUser.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.troleUser.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (troleUserPrimaryKey == null || troleUserPrimaryKey.equals(this.troleUser.getId())) {
                this.troleUser = service.saveAll(this.troleUser);

                String key = troleUser.getId();
				this.troleUserPrimaryKey = key;
                if (troleUserPrimaryKey == null) {
                    addMessage("troleUser.message.added", this.troleUser.getId());				
                }
                else {
                    addMessage("troleUser.message.saved", this.troleUser.getId());					
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
	

	public void loadTroleUser(){	
		TroleUser troleUser = (TroleUser)this.getRequest().getSession().getAttribute("__pop_object");
		this.troleUser = troleUser;
		this.getRequest().getSession().removeAttribute("__pop_object");
	}
	
}
