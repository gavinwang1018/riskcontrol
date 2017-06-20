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
 * TtransInfo对象Form.
 * @author Administrator.
 *
 */
public class TtransInfoForm extends BasePage implements FormPage {

	private TtransInfoService service = (TtransInfoService)getBean("ttransInfoService");

    private String lookupKey;        
	
    /**
     * ttransInfo对象.
     */
    private TtransInfo ttransInfo;

    /**
     * TtransInfo对象主键.
     */
    private java.lang.String ttransInfoPrimaryKey;
	
	
	public String getLookupKey() {
		return lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}	

    /**
     * Returns the TtransInfo.
     * @return TtransInfo.
     */
    public TtransInfo getTtransInfo() {
        if(ttransInfo == null) {
            ttransInfo = new TtransInfo();
        }
        return ttransInfo;
    }

    /**
     * Sets the TtransInfo.
     * @param ttransInfo The ttransInfo to set.
     */
    public void setTtransInfo(TtransInfo ttransInfo) {
        this.ttransInfo = ttransInfo;
    }

    /**
     * Returns the ttransInfoPrimaryKey.
     * @return TtransInfoPrimaryKey.
     */
    public java.lang.String getTtransInfoPrimaryKey() {
        return ttransInfoPrimaryKey;
    }

    /**
     * Sets the ttransInfoPrimaryKey.
     * @param ttransInfoPrimaryKey The TtransInfoPrimaryKey to set.
     */
    public void setTtransInfoPrimaryKey(java.lang.String ttransInfoPrimaryKey) {
		this.ttransInfoPrimaryKey = ttransInfoPrimaryKey;
		initTtransInfo();
    }
	
	public void initTtransInfo(){
        try {
            if (ttransInfoPrimaryKey == null || ttransInfoPrimaryKey.equals("")) {
                return;
            }
            this.setTtransInfo(service.getTtransInfo(ttransInfoPrimaryKey));    
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}	


    /**
     * 存储TtransInfo对象.
     * @return String.
     */
    public String save() {
        try {
            if (ttransInfoPrimaryKey == null  && this.ttransInfo.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTtransInfo(this.ttransInfo.getId()) != null) {
                    addMessage("error.database.duplicatekey", "id[" + this.ttransInfo.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (ttransInfoPrimaryKey == null || ttransInfoPrimaryKey.equals(this.ttransInfo.getId())) {
            	this.ttransInfo = service.saveTtransInfo(this.ttransInfo);
                String key = ttransInfo.getId();
				this.ttransInfoPrimaryKey = key;
                if (ttransInfoPrimaryKey == null) {
                    addMessage("ttransInfo.message.added", this.ttransInfo.getId());				
                }
                else {
                    addMessage("ttransInfo.message.saved", this.ttransInfo.getId());					
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
            TtransInfo ttransInfo = new TtransInfo();
            this.ttransInfo = ttransInfo;
            ttransInfoPrimaryKey = null;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return null;
    }
    /**
     * 删除TtransInfo对象.
     * @return String.
     */
    public String delete() {
        try {
            service.delete(this.ttransInfo.getId());
			CmsUtil.deleteFile("t_trans_info/"+this.ttransInfo.getId());
            addMessage("ttransInfo.message.deleted", this.ttransInfo.getId());
		
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return getSuccessAction();
    }




    /**
     * 删除TtransInfo对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            TtransInfo ttransInfo = service.getTtransInfo(this.ttransInfo.getId());
            service.delete(this.ttransInfo.getId());
            addMessage("ttransInfo.message.deleted", this.ttransInfo.getId());	
		
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
    	if(this.ttransInfoPrimaryKey == null)
    		return "_key=" + this.ttransInfo.getId();
    	return "_key=" + this.ttransInfoPrimaryKey;
    }
	
	    
    public String popSave(){
    	this.getRequest().getSession().setAttribute("__pop_object", this.ttransInfo);
		this.getRequest().getSession().setAttribute("__pop_data_object", "TtransInfo");
		return "popSuccess";
    }
	
    public String saveAll(){
       try {
            if (ttransInfoPrimaryKey == null  && this.ttransInfo.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTtransInfo(this.ttransInfo.getId()) != null) {
                    addMessage("error.database.duplicatekey", "id[" + this.ttransInfo.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (ttransInfoPrimaryKey == null || ttransInfoPrimaryKey.equals(this.ttransInfo.getId())) {
  
                this.ttransInfo = service.saveAll(this.ttransInfo);
                String key = ttransInfo.getId();
				this.ttransInfoPrimaryKey = key;
                if (ttransInfoPrimaryKey == null) {
                    addMessage("ttransInfo.message.added", this.ttransInfo.getId());				
                }
                else {
                    addMessage("ttransInfo.message.saved", this.ttransInfo.getId());					
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
            if (ttransInfoPrimaryKey == null  && this.ttransInfo.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTtransInfo(this.ttransInfo.getId()) != null) {
                    addMessage("error.database.duplicatekey", "id[" + this.ttransInfo.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (ttransInfoPrimaryKey == null || ttransInfoPrimaryKey.equals(this.ttransInfo.getId())) {
                this.ttransInfo = service.saveAll(this.ttransInfo);

                String key = ttransInfo.getId();
				this.ttransInfoPrimaryKey = key;
                if (ttransInfoPrimaryKey == null) {
                    addMessage("ttransInfo.message.added", this.ttransInfo.getId());				
                }
                else {
                    addMessage("ttransInfo.message.saved", this.ttransInfo.getId());					
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
	

	public void loadTtransInfo(){	
		TtransInfo ttransInfo = (TtransInfo)this.getRequest().getSession().getAttribute("__pop_object");
		this.ttransInfo = ttransInfo;
		this.getRequest().getSession().removeAttribute("__pop_object");
	}
	
}
