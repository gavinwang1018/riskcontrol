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
 * SysMessage对象Form.
 * @author Administrator.
 *
 */
public class SysMessageForm extends BasePage implements FormPage {

	private SysMessageService service = (SysMessageService)getBean("sysMessageService");

    private String lookupKey;        
	
    /**
     * sysMessage对象.
     */
    private SysMessage sysMessage;

    /**
     * SysMessage对象主键.
     */
    private java.lang.String sysMessagePrimaryKey;
	
	
	public String getLookupKey() {
		return lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}	

    /**
     * Returns the SysMessage.
     * @return SysMessage.
     */
    public SysMessage getSysMessage() {
        if(sysMessage == null) {
            sysMessage = new SysMessage();
        }
        return sysMessage;
    }

    /**
     * Sets the SysMessage.
     * @param sysMessage The sysMessage to set.
     */
    public void setSysMessage(SysMessage sysMessage) {
        this.sysMessage = sysMessage;
    }

    /**
     * Returns the sysMessagePrimaryKey.
     * @return SysMessagePrimaryKey.
     */
    public java.lang.String getSysMessagePrimaryKey() {
        return sysMessagePrimaryKey;
    }

    /**
     * Sets the sysMessagePrimaryKey.
     * @param sysMessagePrimaryKey The SysMessagePrimaryKey to set.
     */
    public void setSysMessagePrimaryKey(java.lang.String sysMessagePrimaryKey) {
		this.sysMessagePrimaryKey = sysMessagePrimaryKey;
		initSysMessage();
    }
	
	public void initSysMessage(){
        try {
            if (sysMessagePrimaryKey == null || sysMessagePrimaryKey.equals("")) {
                return;
            }
            this.setSysMessage(service.getSysMessage(sysMessagePrimaryKey));    
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}	


    /**
     * 存储SysMessage对象.
     * @return String.
     */
    public String save() {
        try {
            if(this.sysMessage.getId() == null){
                this.sysMessage.setId(getAutoNumberValue("sys_message","id","{0}",0));
            }
            if (sysMessagePrimaryKey == null  && this.sysMessage.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getSysMessage(this.sysMessage.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.sysMessage.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (sysMessagePrimaryKey == null || sysMessagePrimaryKey.equals(this.sysMessage.getId())) {
            	this.sysMessage = service.saveSysMessage(this.sysMessage);
                String key = sysMessage.getId();
				this.sysMessagePrimaryKey = key;
                if (sysMessagePrimaryKey == null) {
                    addMessage("sysMessage.message.added", this.sysMessage.getId());				
                }
                else {
                    addMessage("sysMessage.message.saved", this.sysMessage.getId());					
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
            SysMessage sysMessage = new SysMessage();
            this.sysMessage = sysMessage;
            sysMessagePrimaryKey = null;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return null;
    }
    /**
     * 删除SysMessage对象.
     * @return String.
     */
    public String delete() {
        try {
            service.delete(this.sysMessage.getId());
			CmsUtil.deleteFile("sys_message/"+this.sysMessage.getId());
            addMessage("sysMessage.message.deleted", this.sysMessage.getId());
		
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return getSuccessAction();
    }




    /**
     * 删除SysMessage对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            SysMessage sysMessage = service.getSysMessage(this.sysMessage.getId());
            service.delete(this.sysMessage.getId());
            addMessage("sysMessage.message.deleted", this.sysMessage.getId());	
		
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
    	if(this.sysMessagePrimaryKey == null)
    		return "_key=" + this.sysMessage.getId();
    	return "_key=" + this.sysMessagePrimaryKey;
    }
	
	    
    public String popSave(){
    	this.getRequest().getSession().setAttribute("__pop_object", this.sysMessage);
		this.getRequest().getSession().setAttribute("__pop_data_object", "SysMessage");
		return "popSuccess";
    }
	
    public String saveAll(){
       try {
            if(this.sysMessage.getId() == null){
                this.sysMessage.setId(getAutoNumberValue("sys_message","id","{0}",0));
            }
            if (sysMessagePrimaryKey == null  && this.sysMessage.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getSysMessage(this.sysMessage.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.sysMessage.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (sysMessagePrimaryKey == null || sysMessagePrimaryKey.equals(this.sysMessage.getId())) {
  
                this.sysMessage = service.saveAll(this.sysMessage);
                String key = sysMessage.getId();
				this.sysMessagePrimaryKey = key;
                if (sysMessagePrimaryKey == null) {
                    addMessage("sysMessage.message.added", this.sysMessage.getId());				
                }
                else {
                    addMessage("sysMessage.message.saved", this.sysMessage.getId());					
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
            if(this.sysMessage.getId() == null){
                this.sysMessage.setId(getAutoNumberValue("sys_message","id","{0}",0));
            }
            if (sysMessagePrimaryKey == null  && this.sysMessage.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getSysMessage(this.sysMessage.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.sysMessage.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (sysMessagePrimaryKey == null || sysMessagePrimaryKey.equals(this.sysMessage.getId())) {
                this.sysMessage = service.saveAll(this.sysMessage);

                String key = sysMessage.getId();
				this.sysMessagePrimaryKey = key;
                if (sysMessagePrimaryKey == null) {
                    addMessage("sysMessage.message.added", this.sysMessage.getId());				
                }
                else {
                    addMessage("sysMessage.message.saved", this.sysMessage.getId());					
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
	

	public void loadSysMessage(){	
		SysMessage sysMessage = (SysMessage)this.getRequest().getSession().getAttribute("__pop_object");
		this.sysMessage = sysMessage;
		this.getRequest().getSession().removeAttribute("__pop_object");
	}
	
}
