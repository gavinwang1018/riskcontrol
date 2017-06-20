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
 * TruleInstanceGroup对象Form.
 * @author Administrator.
 *
 */
public class TruleInstanceGroupForm extends BasePage implements FormPage {

	private TruleInstanceGroupService service = (TruleInstanceGroupService)getBean("truleInstanceGroupService");

    private String lookupKey;        
	
    /**
     * truleInstanceGroup对象.
     */
    private TruleInstanceGroup truleInstanceGroup;

    /**
     * TruleInstanceGroup对象主键.
     */
    private java.lang.String truleInstanceGroupPrimaryKey;
	
	
	public String getLookupKey() {
		return lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}	

    /**
     * Returns the TruleInstanceGroup.
     * @return TruleInstanceGroup.
     */
    public TruleInstanceGroup getTruleInstanceGroup() {
        if(truleInstanceGroup == null) {
            truleInstanceGroup = new TruleInstanceGroup();
        }
        return truleInstanceGroup;
    }

    /**
     * Sets the TruleInstanceGroup.
     * @param truleInstanceGroup The truleInstanceGroup to set.
     */
    public void setTruleInstanceGroup(TruleInstanceGroup truleInstanceGroup) {
        this.truleInstanceGroup = truleInstanceGroup;
    }

    /**
     * Returns the truleInstanceGroupPrimaryKey.
     * @return TruleInstanceGroupPrimaryKey.
     */
    public java.lang.String getTruleInstanceGroupPrimaryKey() {
        return truleInstanceGroupPrimaryKey;
    }

    /**
     * Sets the truleInstanceGroupPrimaryKey.
     * @param truleInstanceGroupPrimaryKey The TruleInstanceGroupPrimaryKey to set.
     */
    public void setTruleInstanceGroupPrimaryKey(java.lang.String truleInstanceGroupPrimaryKey) {
		this.truleInstanceGroupPrimaryKey = truleInstanceGroupPrimaryKey;
		initTruleInstanceGroup();
    }
	
	public void initTruleInstanceGroup(){
        try {
            if (truleInstanceGroupPrimaryKey == null || truleInstanceGroupPrimaryKey.equals("")) {
                return;
            }
            this.setTruleInstanceGroup(service.getTruleInstanceGroup(truleInstanceGroupPrimaryKey));    
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}	


    /**
     * 存储TruleInstanceGroup对象.
     * @return String.
     */
    public String save() {
        try {
            if (truleInstanceGroupPrimaryKey == null  && this.truleInstanceGroup.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTruleInstanceGroup(this.truleInstanceGroup.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.truleInstanceGroup.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (truleInstanceGroupPrimaryKey == null || truleInstanceGroupPrimaryKey.equals(this.truleInstanceGroup.getId())) {
            	this.truleInstanceGroup = service.saveTruleInstanceGroup(this.truleInstanceGroup);
                String key = truleInstanceGroup.getId();
				this.truleInstanceGroupPrimaryKey = key;
                if (truleInstanceGroupPrimaryKey == null) {
                    addMessage("truleInstanceGroup.message.added", this.truleInstanceGroup.getId());				
                }
                else {
                    addMessage("truleInstanceGroup.message.saved", this.truleInstanceGroup.getId());					
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
            TruleInstanceGroup truleInstanceGroup = new TruleInstanceGroup();
            this.truleInstanceGroup = truleInstanceGroup;
            truleInstanceGroupPrimaryKey = null;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return null;
    }
    /**
     * 删除TruleInstanceGroup对象.
     * @return String.
     */
    public String delete() {
        try {
            service.delete(this.truleInstanceGroup.getId());
			CmsUtil.deleteFile("t_rule_instance_group/"+this.truleInstanceGroup.getId());
            addMessage("truleInstanceGroup.message.deleted", this.truleInstanceGroup.getId());
		
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return getSuccessAction();
    }




    /**
     * 删除TruleInstanceGroup对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            TruleInstanceGroup truleInstanceGroup = service.getTruleInstanceGroup(this.truleInstanceGroup.getId());
            service.delete(this.truleInstanceGroup.getId());
            addMessage("truleInstanceGroup.message.deleted", this.truleInstanceGroup.getId());	
		
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
    	if(this.truleInstanceGroupPrimaryKey == null)
    		return "_key=" + this.truleInstanceGroup.getId();
    	return "_key=" + this.truleInstanceGroupPrimaryKey;
    }
	
	    
    public String popSave(){
    	this.getRequest().getSession().setAttribute("__pop_object", this.truleInstanceGroup);
		this.getRequest().getSession().setAttribute("__pop_data_object", "TruleInstanceGroup");
		return "popSuccess";
    }
	
    public String saveAll(){
       try {
            if (truleInstanceGroupPrimaryKey == null  && this.truleInstanceGroup.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTruleInstanceGroup(this.truleInstanceGroup.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.truleInstanceGroup.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (truleInstanceGroupPrimaryKey == null || truleInstanceGroupPrimaryKey.equals(this.truleInstanceGroup.getId())) {
  
                this.truleInstanceGroup = service.saveAll(this.truleInstanceGroup);
                String key = truleInstanceGroup.getId();
				this.truleInstanceGroupPrimaryKey = key;
                if (truleInstanceGroupPrimaryKey == null) {
                    addMessage("truleInstanceGroup.message.added", this.truleInstanceGroup.getId());				
                }
                else {
                    addMessage("truleInstanceGroup.message.saved", this.truleInstanceGroup.getId());					
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
            if (truleInstanceGroupPrimaryKey == null  && this.truleInstanceGroup.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTruleInstanceGroup(this.truleInstanceGroup.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.truleInstanceGroup.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (truleInstanceGroupPrimaryKey == null || truleInstanceGroupPrimaryKey.equals(this.truleInstanceGroup.getId())) {
                this.truleInstanceGroup = service.saveAll(this.truleInstanceGroup);

                String key = truleInstanceGroup.getId();
				this.truleInstanceGroupPrimaryKey = key;
                if (truleInstanceGroupPrimaryKey == null) {
                    addMessage("truleInstanceGroup.message.added", this.truleInstanceGroup.getId());				
                }
                else {
                    addMessage("truleInstanceGroup.message.saved", this.truleInstanceGroup.getId());					
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
	

	public void loadTruleInstanceGroup(){	
		TruleInstanceGroup truleInstanceGroup = (TruleInstanceGroup)this.getRequest().getSession().getAttribute("__pop_object");
		this.truleInstanceGroup = truleInstanceGroup;
		this.getRequest().getSession().removeAttribute("__pop_object");
	}
	
}
