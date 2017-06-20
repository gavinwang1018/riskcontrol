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
 * SysLoginfo对象Form.
 * @author Administrator.
 *
 */
public class SysLoginfoForm extends BasePage implements FormPage {

	private SysLoginfoService service = (SysLoginfoService)getBean("sysLoginfoService");

    private String lookupKey;        
	
    /**
     * sysLoginfo对象.
     */
    private SysLoginfo sysLoginfo;

    /**
     * SysLoginfo对象主键.
     */
    private java.lang.String sysLoginfoPrimaryKey;
	
	
	public String getLookupKey() {
		return lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}	

    /**
     * Returns the SysLoginfo.
     * @return SysLoginfo.
     */
    public SysLoginfo getSysLoginfo() {
        if(sysLoginfo == null) {
            sysLoginfo = new SysLoginfo();
        }
        return sysLoginfo;
    }

    /**
     * Sets the SysLoginfo.
     * @param sysLoginfo The sysLoginfo to set.
     */
    public void setSysLoginfo(SysLoginfo sysLoginfo) {
        this.sysLoginfo = sysLoginfo;
    }

    /**
     * Returns the sysLoginfoPrimaryKey.
     * @return SysLoginfoPrimaryKey.
     */
    public java.lang.String getSysLoginfoPrimaryKey() {
        return sysLoginfoPrimaryKey;
    }

    /**
     * Sets the sysLoginfoPrimaryKey.
     * @param sysLoginfoPrimaryKey The SysLoginfoPrimaryKey to set.
     */
    public void setSysLoginfoPrimaryKey(java.lang.String sysLoginfoPrimaryKey) {
		this.sysLoginfoPrimaryKey = sysLoginfoPrimaryKey;
		initSysLoginfo();
    }
	
	public void initSysLoginfo(){
        try {
            if (sysLoginfoPrimaryKey == null || sysLoginfoPrimaryKey.equals("")) {
                return;
            }
            this.setSysLoginfo(service.getSysLoginfo(sysLoginfoPrimaryKey));    
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}	


    /**
     * 存储SysLoginfo对象.
     * @return String.
     */
    public String save() {
        try {
            if (sysLoginfoPrimaryKey == null  && this.sysLoginfo.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getSysLoginfo(this.sysLoginfo.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.sysLoginfo.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (sysLoginfoPrimaryKey == null || sysLoginfoPrimaryKey.equals(this.sysLoginfo.getId())) {
            	this.sysLoginfo = service.saveSysLoginfo(this.sysLoginfo);
                String key = sysLoginfo.getId();
				this.sysLoginfoPrimaryKey = key;
                if (sysLoginfoPrimaryKey == null) {
                    addMessage("sysLoginfo.message.added", this.sysLoginfo.getId());				
                }
                else {
                    addMessage("sysLoginfo.message.saved", this.sysLoginfo.getId());					
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
            SysLoginfo sysLoginfo = new SysLoginfo();
            this.sysLoginfo = sysLoginfo;
            sysLoginfoPrimaryKey = null;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return null;
    }
    /**
     * 删除SysLoginfo对象.
     * @return String.
     */
    public String delete() {
        try {
            service.delete(this.sysLoginfo.getId());
			CmsUtil.deleteFile("sys_loginfo/"+this.sysLoginfo.getId());
            addMessage("sysLoginfo.message.deleted", this.sysLoginfo.getId());
		
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return getSuccessAction();
    }




    /**
     * 删除SysLoginfo对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            SysLoginfo sysLoginfo = service.getSysLoginfo(this.sysLoginfo.getId());
            service.delete(this.sysLoginfo.getId());
            addMessage("sysLoginfo.message.deleted", this.sysLoginfo.getId());	
		
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
    	if(this.sysLoginfoPrimaryKey == null)
    		return "_key=" + this.sysLoginfo.getId();
    	return "_key=" + this.sysLoginfoPrimaryKey;
    }
	
	    
    public String popSave(){
    	this.getRequest().getSession().setAttribute("__pop_object", this.sysLoginfo);
		this.getRequest().getSession().setAttribute("__pop_data_object", "SysLoginfo");
		return "popSuccess";
    }
	
    public String saveAll(){
       try {
            if (sysLoginfoPrimaryKey == null  && this.sysLoginfo.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getSysLoginfo(this.sysLoginfo.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.sysLoginfo.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (sysLoginfoPrimaryKey == null || sysLoginfoPrimaryKey.equals(this.sysLoginfo.getId())) {
  
                this.sysLoginfo = service.saveAll(this.sysLoginfo);
                String key = sysLoginfo.getId();
				this.sysLoginfoPrimaryKey = key;
                if (sysLoginfoPrimaryKey == null) {
                    addMessage("sysLoginfo.message.added", this.sysLoginfo.getId());				
                }
                else {
                    addMessage("sysLoginfo.message.saved", this.sysLoginfo.getId());					
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
            if (sysLoginfoPrimaryKey == null  && this.sysLoginfo.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getSysLoginfo(this.sysLoginfo.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.sysLoginfo.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (sysLoginfoPrimaryKey == null || sysLoginfoPrimaryKey.equals(this.sysLoginfo.getId())) {
                this.sysLoginfo = service.saveAll(this.sysLoginfo);

                String key = sysLoginfo.getId();
				this.sysLoginfoPrimaryKey = key;
                if (sysLoginfoPrimaryKey == null) {
                    addMessage("sysLoginfo.message.added", this.sysLoginfo.getId());				
                }
                else {
                    addMessage("sysLoginfo.message.saved", this.sysLoginfo.getId());					
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
	

	public void loadSysLoginfo(){	
		SysLoginfo sysLoginfo = (SysLoginfo)this.getRequest().getSession().getAttribute("__pop_object");
		this.sysLoginfo = sysLoginfo;
		this.getRequest().getSession().removeAttribute("__pop_object");
	}
	
}
