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
 * SysDailyIns对象Form.
 * @author Administrator.
 *
 */
public class SysDailyInsForm extends BasePage implements FormPage {

	private SysDailyInsService service = (SysDailyInsService)getBean("sysDailyInsService");

    private String lookupKey;        
	
    /**
     * sysDailyIns对象.
     */
    private SysDailyIns sysDailyIns;

    /**
     * SysDailyIns对象主键.
     */
    private java.lang.String sysDailyInsPrimaryKey;
	
	
	public String getLookupKey() {
		return lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}	

    /**
     * Returns the SysDailyIns.
     * @return SysDailyIns.
     */
    public SysDailyIns getSysDailyIns() {
        if(sysDailyIns == null) {
            sysDailyIns = new SysDailyIns();
        }
        return sysDailyIns;
    }

    /**
     * Sets the SysDailyIns.
     * @param sysDailyIns The sysDailyIns to set.
     */
    public void setSysDailyIns(SysDailyIns sysDailyIns) {
        this.sysDailyIns = sysDailyIns;
    }

    /**
     * Returns the sysDailyInsPrimaryKey.
     * @return SysDailyInsPrimaryKey.
     */
    public java.lang.String getSysDailyInsPrimaryKey() {
        return sysDailyInsPrimaryKey;
    }

    /**
     * Sets the sysDailyInsPrimaryKey.
     * @param sysDailyInsPrimaryKey The SysDailyInsPrimaryKey to set.
     */
    public void setSysDailyInsPrimaryKey(java.lang.String sysDailyInsPrimaryKey) {
		this.sysDailyInsPrimaryKey = sysDailyInsPrimaryKey;
		initSysDailyIns();
    }
	
	public void initSysDailyIns(){
        try {
            if (sysDailyInsPrimaryKey == null || sysDailyInsPrimaryKey.equals("")) {
                return;
            }
            this.setSysDailyIns(service.getSysDailyIns(sysDailyInsPrimaryKey));    
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}	


    /**
     * 存储SysDailyIns对象.
     * @return String.
     */
    public String save() {
        try {
            if(this.sysDailyIns.getId() == null){
                this.sysDailyIns.setId(getAutoNumberValue("sys_daily_ins","id","{0}",0));
            }
            if (sysDailyInsPrimaryKey == null  && this.sysDailyIns.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getSysDailyIns(this.sysDailyIns.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.sysDailyIns.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (sysDailyInsPrimaryKey == null || sysDailyInsPrimaryKey.equals(this.sysDailyIns.getId())) {
            	this.sysDailyIns = service.saveSysDailyIns(this.sysDailyIns);
                String key = sysDailyIns.getId();
				this.sysDailyInsPrimaryKey = key;
                if (sysDailyInsPrimaryKey == null) {
                    addMessage("sysDailyIns.message.added", this.sysDailyIns.getId());				
                }
                else {
                    addMessage("sysDailyIns.message.saved", this.sysDailyIns.getId());					
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
            SysDailyIns sysDailyIns = new SysDailyIns();
            this.sysDailyIns = sysDailyIns;
            sysDailyInsPrimaryKey = null;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return null;
    }
    /**
     * 删除SysDailyIns对象.
     * @return String.
     */
    public String delete() {
        try {
            service.delete(this.sysDailyIns.getId());
			CmsUtil.deleteFile("sys_daily_ins/"+this.sysDailyIns.getId());
            addMessage("sysDailyIns.message.deleted", this.sysDailyIns.getId());
		
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return getSuccessAction();
    }




    /**
     * 删除SysDailyIns对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            SysDailyIns sysDailyIns = service.getSysDailyIns(this.sysDailyIns.getId());
            service.delete(this.sysDailyIns.getId());
            addMessage("sysDailyIns.message.deleted", this.sysDailyIns.getId());	
		
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
    	if(this.sysDailyInsPrimaryKey == null)
    		return "_key=" + this.sysDailyIns.getId();
    	return "_key=" + this.sysDailyInsPrimaryKey;
    }
	
	    
    public String popSave(){
    	this.getRequest().getSession().setAttribute("__pop_object", this.sysDailyIns);
		this.getRequest().getSession().setAttribute("__pop_data_object", "SysDailyIns");
		return "popSuccess";
    }
	
    public String saveAll(){
       try {
            if(this.sysDailyIns.getId() == null){
                this.sysDailyIns.setId(getAutoNumberValue("sys_daily_ins","id","{0}",0));
            }
            if (sysDailyInsPrimaryKey == null  && this.sysDailyIns.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getSysDailyIns(this.sysDailyIns.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.sysDailyIns.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (sysDailyInsPrimaryKey == null || sysDailyInsPrimaryKey.equals(this.sysDailyIns.getId())) {
  
                this.sysDailyIns = service.saveAll(this.sysDailyIns);
                String key = sysDailyIns.getId();
				this.sysDailyInsPrimaryKey = key;
                if (sysDailyInsPrimaryKey == null) {
                    addMessage("sysDailyIns.message.added", this.sysDailyIns.getId());				
                }
                else {
                    addMessage("sysDailyIns.message.saved", this.sysDailyIns.getId());					
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
            if(this.sysDailyIns.getId() == null){
                this.sysDailyIns.setId(getAutoNumberValue("sys_daily_ins","id","{0}",0));
            }
            if (sysDailyInsPrimaryKey == null  && this.sysDailyIns.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getSysDailyIns(this.sysDailyIns.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.sysDailyIns.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (sysDailyInsPrimaryKey == null || sysDailyInsPrimaryKey.equals(this.sysDailyIns.getId())) {
                this.sysDailyIns = service.saveAll(this.sysDailyIns);

                String key = sysDailyIns.getId();
				this.sysDailyInsPrimaryKey = key;
                if (sysDailyInsPrimaryKey == null) {
                    addMessage("sysDailyIns.message.added", this.sysDailyIns.getId());				
                }
                else {
                    addMessage("sysDailyIns.message.saved", this.sysDailyIns.getId());					
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
	

	public void loadSysDailyIns(){	
		SysDailyIns sysDailyIns = (SysDailyIns)this.getRequest().getSession().getAttribute("__pop_object");
		this.sysDailyIns = sysDailyIns;
		this.getRequest().getSession().removeAttribute("__pop_object");
	}
	
}
