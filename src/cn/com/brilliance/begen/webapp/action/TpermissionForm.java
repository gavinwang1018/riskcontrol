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
 * Tpermission对象Form.
 * @author Administrator.
 *
 */
public class TpermissionForm extends BasePage implements FormPage {

	private TpermissionService service = (TpermissionService)getBean("tpermissionService");

    private String lookupKey;        
	
    /**
     * tpermission对象.
     */
    private Tpermission tpermission;

    /**
     * Tpermission对象主键.
     */
    private java.lang.String tpermissionPrimaryKey;
	
	
	public String getLookupKey() {
		return lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}	

    /**
     * Returns the Tpermission.
     * @return Tpermission.
     */
    public Tpermission getTpermission() {
        if(tpermission == null) {
            tpermission = new Tpermission();
        }
        return tpermission;
    }

    /**
     * Sets the Tpermission.
     * @param tpermission The tpermission to set.
     */
    public void setTpermission(Tpermission tpermission) {
        this.tpermission = tpermission;
    }

    /**
     * Returns the tpermissionPrimaryKey.
     * @return TpermissionPrimaryKey.
     */
    public java.lang.String getTpermissionPrimaryKey() {
        return tpermissionPrimaryKey;
    }

    /**
     * Sets the tpermissionPrimaryKey.
     * @param tpermissionPrimaryKey The TpermissionPrimaryKey to set.
     */
    public void setTpermissionPrimaryKey(java.lang.String tpermissionPrimaryKey) {
		this.tpermissionPrimaryKey = tpermissionPrimaryKey;
		initTpermission();
    }
	
	public void initTpermission(){
        try {
            if (tpermissionPrimaryKey == null || tpermissionPrimaryKey.equals("")) {
                return;
            }
            this.setTpermission(service.getTpermission(tpermissionPrimaryKey));    
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}	


    /**
     * 存储Tpermission对象.
     * @return String.
     */
    public String save() {
        try {
            if (tpermissionPrimaryKey == null  && this.tpermission.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTpermission(this.tpermission.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.tpermission.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (tpermissionPrimaryKey == null || tpermissionPrimaryKey.equals(this.tpermission.getId())) {
            	this.tpermission = service.saveTpermission(this.tpermission);
                String key = tpermission.getId();
				this.tpermissionPrimaryKey = key;
                if (tpermissionPrimaryKey == null) {
                    addMessage("tpermission.message.added", this.tpermission.getId());				
                }
                else {
                    addMessage("tpermission.message.saved", this.tpermission.getId());					
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
            Tpermission tpermission = new Tpermission();
            this.tpermission = tpermission;
            tpermissionPrimaryKey = null;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return null;
    }
    /**
     * 删除Tpermission对象.
     * @return String.
     */
    public String delete() {
        try {
            service.delete(this.tpermission.getId());
			CmsUtil.deleteFile("t_permission/"+this.tpermission.getId());
            addMessage("tpermission.message.deleted", this.tpermission.getId());
		
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return getSuccessAction();
    }




    /**
     * 删除Tpermission对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            Tpermission tpermission = service.getTpermission(this.tpermission.getId());
            service.delete(this.tpermission.getId());
            addMessage("tpermission.message.deleted", this.tpermission.getId());	
		
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
    	if(this.tpermissionPrimaryKey == null)
    		return "_key=" + this.tpermission.getId();
    	return "_key=" + this.tpermissionPrimaryKey;
    }
	
	    
    public String popSave(){
    	this.getRequest().getSession().setAttribute("__pop_object", this.tpermission);
		this.getRequest().getSession().setAttribute("__pop_data_object", "Tpermission");
		return "popSuccess";
    }
	
    public String saveAll(){
       try {
            if (tpermissionPrimaryKey == null  && this.tpermission.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTpermission(this.tpermission.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.tpermission.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (tpermissionPrimaryKey == null || tpermissionPrimaryKey.equals(this.tpermission.getId())) {
  
                this.tpermission = service.saveAll(this.tpermission);
                String key = tpermission.getId();
				this.tpermissionPrimaryKey = key;
                if (tpermissionPrimaryKey == null) {
                    addMessage("tpermission.message.added", this.tpermission.getId());				
                }
                else {
                    addMessage("tpermission.message.saved", this.tpermission.getId());					
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
            if (tpermissionPrimaryKey == null  && this.tpermission.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTpermission(this.tpermission.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.tpermission.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (tpermissionPrimaryKey == null || tpermissionPrimaryKey.equals(this.tpermission.getId())) {
                this.tpermission = service.saveAll(this.tpermission);

                String key = tpermission.getId();
				this.tpermissionPrimaryKey = key;
                if (tpermissionPrimaryKey == null) {
                    addMessage("tpermission.message.added", this.tpermission.getId());				
                }
                else {
                    addMessage("tpermission.message.saved", this.tpermission.getId());					
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
	

	public void loadTpermission(){	
		Tpermission tpermission = (Tpermission)this.getRequest().getSession().getAttribute("__pop_object");
		this.tpermission = tpermission;
		this.getRequest().getSession().removeAttribute("__pop_object");
	}
	
}
