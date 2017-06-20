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
import cn.com.brilliance.risk.ext.common.Function;

/**
 * TroleInfo对象Form.
 * @author Administrator.
 *
 */
public class TroleInfoForm extends BasePage implements FormPage {

	private TroleInfoService service = (TroleInfoService)getBean("troleInfoService");

    private String lookupKey;        
	
    /**
     * troleInfo对象.
     */
    private TroleInfo troleInfo;

    /**
     * TroleInfo对象主键.
     */
    private java.lang.String troleInfoPrimaryKey;
	
	
	public String getLookupKey() {
		return lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}	

    /**
     * Returns the TroleInfo.
     * @return TroleInfo.
     */
    public TroleInfo getTroleInfo() {
        if(troleInfo == null) {
            troleInfo = new TroleInfo();
        }
        return troleInfo;
    }

    /**
     * Sets the TroleInfo.
     * @param troleInfo The troleInfo to set.
     */
    public void setTroleInfo(TroleInfo troleInfo) {
        this.troleInfo = troleInfo;
    }

    /**
     * Returns the troleInfoPrimaryKey.
     * @return TroleInfoPrimaryKey.
     */
    public java.lang.String getTroleInfoPrimaryKey() {
        return troleInfoPrimaryKey;
    }

    /**
     * Sets the troleInfoPrimaryKey.
     * @param troleInfoPrimaryKey The TroleInfoPrimaryKey to set.
     */
    public void setTroleInfoPrimaryKey(java.lang.String troleInfoPrimaryKey) {
		this.troleInfoPrimaryKey = troleInfoPrimaryKey;
		initTroleInfo();
    }
	
	public void initTroleInfo(){
        try {
            if (troleInfoPrimaryKey == null || troleInfoPrimaryKey.equals("")) {
                return;
            }
            this.setTroleInfo(service.getTroleInfo(troleInfoPrimaryKey));    
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}	


    /**
     * 存储TroleInfo对象.
     * @return String.
     */
    public String save() {
        try {
            if(this.troleInfo.getId() == null){
                this.troleInfo.setId(getAutoNumberValue("t_role_info","id","{0000000000000}",1));
            }
            if (troleInfoPrimaryKey == null  && this.troleInfo.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTroleInfo(this.troleInfo.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.troleInfo.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (troleInfoPrimaryKey == null || troleInfoPrimaryKey.equals(this.troleInfo.getId())) {
            	this.troleInfo = service.saveTroleInfo(this.troleInfo);
                String key = troleInfo.getId();
				this.troleInfoPrimaryKey = key;
                if (troleInfoPrimaryKey == null) {
                    addMessage("troleInfo.message.added", this.troleInfo.getId());				
                }
                else {
                    addMessage("troleInfo.message.saved", this.troleInfo.getId());					
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
            TroleInfo troleInfo = new TroleInfo();
            this.troleInfo = troleInfo;
            troleInfoPrimaryKey = null;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return null;
    }
    /**
     * 删除TroleInfo对象.
     * @return String.
     */
    public String delete() {
		try {
			if (!Function.hasChild(this.troleInfo.getId())) {
				service.delete(this.troleInfo.getId());
				CmsUtil.deleteFile("t_role_info/" + this.troleInfo.getId());
				addMessage("troleInfo.message.deleted", this.troleInfo.getId());
			} else {
				addMessage("troleInfo.message.hasChild", this.troleInfo.getId());
				return null;
			}

		} catch (BeGenException e) {
			// TODO Auto-generated catch block
			this.addMessage(e.getCode(), e.getMsg(), e);
			return getFailureAction();
		}
		return getSuccessAction();
	}




    /**
	 * 删除TroleInfo对象 (子表有数据不允许删除）.
	 * 
	 * @return String.
	 */
    public String deleteOfNoChild() {
        try {
            TroleInfo troleInfo = service.getTroleInfo(this.troleInfo.getId());
            service.delete(this.troleInfo.getId());
            addMessage("troleInfo.message.deleted", this.troleInfo.getId());	
		
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
    	if(this.troleInfoPrimaryKey == null)
    		return "_key=" + this.troleInfo.getId();
    	return "_key=" + this.troleInfoPrimaryKey;
    }
	
	    
    public String popSave(){
    	this.getRequest().getSession().setAttribute("__pop_object", this.troleInfo);
		this.getRequest().getSession().setAttribute("__pop_data_object", "TroleInfo");
		return "popSuccess";
    }
	
    public String saveAll(){
       try {
            if(this.troleInfo.getId() == null){
                this.troleInfo.setId(getAutoNumberValue("t_role_info","id","{0000000000000}",1));
            }
            if (troleInfoPrimaryKey == null  && this.troleInfo.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTroleInfo(this.troleInfo.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.troleInfo.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (troleInfoPrimaryKey == null || troleInfoPrimaryKey.equals(this.troleInfo.getId())) {
  
                this.troleInfo = service.saveAll(this.troleInfo);
                String key = troleInfo.getId();
				this.troleInfoPrimaryKey = key;
                if (troleInfoPrimaryKey == null) {
                    addMessage("troleInfo.message.added", this.troleInfo.getId());				
                }
                else {
                    addMessage("troleInfo.message.saved", this.troleInfo.getId());					
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
            if(this.troleInfo.getId() == null){
                this.troleInfo.setId(getAutoNumberValue("t_role_info","id","{0000000000000}",1));
            }
            if (troleInfoPrimaryKey == null  && this.troleInfo.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTroleInfo(this.troleInfo.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.troleInfo.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (troleInfoPrimaryKey == null || troleInfoPrimaryKey.equals(this.troleInfo.getId())) {
                this.troleInfo = service.saveAll(this.troleInfo);

                String key = troleInfo.getId();
				this.troleInfoPrimaryKey = key;
                if (troleInfoPrimaryKey == null) {
                    addMessage("troleInfo.message.added", this.troleInfo.getId());				
                }
                else {
                    addMessage("troleInfo.message.saved", this.troleInfo.getId());					
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
	

	public void loadTroleInfo(){	
		TroleInfo troleInfo = (TroleInfo)this.getRequest().getSession().getAttribute("__pop_object");
		this.troleInfo = troleInfo;
		this.getRequest().getSession().removeAttribute("__pop_object");
	}
	
	public String authControl(){
		return this.getSuccessAction();
	}
	
}
