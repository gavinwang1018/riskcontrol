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
 * TorganizeUser对象Form.
 * @author Administrator.
 *
 */
public class TorganizeUserForm extends BasePage implements FormPage {

	private TorganizeUserService service = (TorganizeUserService)getBean("torganizeUserService");

    private String lookupKey;        
	
    /**
     * torganizeUser对象.
     */
    private TorganizeUser torganizeUser;

    /**
     * TorganizeUser对象主键.
     */
    private java.lang.String torganizeUserPrimaryKey;
	
	
	public String getLookupKey() {
		return lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}	

    /**
     * Returns the TorganizeUser.
     * @return TorganizeUser.
     */
    public TorganizeUser getTorganizeUser() {
        if(torganizeUser == null) {
            torganizeUser = new TorganizeUser();
        }
        return torganizeUser;
    }

    /**
     * Sets the TorganizeUser.
     * @param torganizeUser The torganizeUser to set.
     */
    public void setTorganizeUser(TorganizeUser torganizeUser) {
        this.torganizeUser = torganizeUser;
    }

    /**
     * Returns the torganizeUserPrimaryKey.
     * @return TorganizeUserPrimaryKey.
     */
    public java.lang.String getTorganizeUserPrimaryKey() {
        return torganizeUserPrimaryKey;
    }

    /**
     * Sets the torganizeUserPrimaryKey.
     * @param torganizeUserPrimaryKey The TorganizeUserPrimaryKey to set.
     */
    public void setTorganizeUserPrimaryKey(java.lang.String torganizeUserPrimaryKey) {
		this.torganizeUserPrimaryKey = torganizeUserPrimaryKey;
		initTorganizeUser();
    }
	
	public void initTorganizeUser(){
        try {
            if (torganizeUserPrimaryKey == null || torganizeUserPrimaryKey.equals("")) {
                return;
            }
            this.setTorganizeUser(service.getTorganizeUser(torganizeUserPrimaryKey));    
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}	


    /**
     * 存储TorganizeUser对象.
     * @return String.
     */
    public String save() {
        try {
            if(this.torganizeUser.getId() == null){
                this.torganizeUser.setId(getAutoNumberValue("t_organize_user","id","{000000000}",1));
            }
            if (torganizeUserPrimaryKey == null  && this.torganizeUser.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTorganizeUser(this.torganizeUser.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.torganizeUser.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (torganizeUserPrimaryKey == null || torganizeUserPrimaryKey.equals(this.torganizeUser.getId())) {
            	this.torganizeUser = service.saveTorganizeUser(this.torganizeUser);
                String key = torganizeUser.getId();
				this.torganizeUserPrimaryKey = key;
                if (torganizeUserPrimaryKey == null) {
                    addMessage("torganizeUser.message.added", this.torganizeUser.getId());				
                }
                else {
                    addMessage("torganizeUser.message.saved", this.torganizeUser.getId());					
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
            TorganizeUser torganizeUser = new TorganizeUser();
            this.torganizeUser = torganizeUser;
            torganizeUserPrimaryKey = null;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return null;
    }
    /**
     * 删除TorganizeUser对象.
     * @return String.
     */
    public String delete() {
        try {
            service.delete(this.torganizeUser.getId());
			CmsUtil.deleteFile("t_organize_user/"+this.torganizeUser.getId());
            addMessage("torganizeUser.message.deleted", this.torganizeUser.getId());
		
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return getSuccessAction();
    }




    /**
     * 删除TorganizeUser对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            TorganizeUser torganizeUser = service.getTorganizeUser(this.torganizeUser.getId());
            service.delete(this.torganizeUser.getId());
            addMessage("torganizeUser.message.deleted", this.torganizeUser.getId());	
		
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
    	if(this.torganizeUserPrimaryKey == null)
    		return "_key=" + this.torganizeUser.getId();
    	return "_key=" + this.torganizeUserPrimaryKey;
    }
	
	    
    public String popSave(){
    	this.getRequest().getSession().setAttribute("__pop_object", this.torganizeUser);
		this.getRequest().getSession().setAttribute("__pop_data_object", "TorganizeUser");
		return "popSuccess";
    }
	
    public String saveAll(){
       try {
            if(this.torganizeUser.getId() == null){
                this.torganizeUser.setId(getAutoNumberValue("t_organize_user","id","{000000000}",1));
            }
            if (torganizeUserPrimaryKey == null  && this.torganizeUser.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTorganizeUser(this.torganizeUser.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.torganizeUser.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (torganizeUserPrimaryKey == null || torganizeUserPrimaryKey.equals(this.torganizeUser.getId())) {
  
                this.torganizeUser = service.saveAll(this.torganizeUser);
                String key = torganizeUser.getId();
				this.torganizeUserPrimaryKey = key;
                if (torganizeUserPrimaryKey == null) {
                    addMessage("torganizeUser.message.added", this.torganizeUser.getId());				
                }
                else {
                    addMessage("torganizeUser.message.saved", this.torganizeUser.getId());					
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
            if(this.torganizeUser.getId() == null){
                this.torganizeUser.setId(getAutoNumberValue("t_organize_user","id","{000000000}",1));
            }
            if (torganizeUserPrimaryKey == null  && this.torganizeUser.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTorganizeUser(this.torganizeUser.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.torganizeUser.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (torganizeUserPrimaryKey == null || torganizeUserPrimaryKey.equals(this.torganizeUser.getId())) {
                this.torganizeUser = service.saveAll(this.torganizeUser);

                String key = torganizeUser.getId();
				this.torganizeUserPrimaryKey = key;
                if (torganizeUserPrimaryKey == null) {
                    addMessage("torganizeUser.message.added", this.torganizeUser.getId());				
                }
                else {
                    addMessage("torganizeUser.message.saved", this.torganizeUser.getId());					
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
	

	public void loadTorganizeUser(){	
		TorganizeUser torganizeUser = (TorganizeUser)this.getRequest().getSession().getAttribute("__pop_object");
		this.torganizeUser = torganizeUser;
		this.getRequest().getSession().removeAttribute("__pop_object");
	}
	
}
