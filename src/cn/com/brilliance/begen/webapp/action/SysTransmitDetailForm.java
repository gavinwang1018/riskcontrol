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
 * SysTransmitDetail对象Form.
 * @author Administrator.
 *
 */
public class SysTransmitDetailForm extends BasePage implements FormPage {

	private SysTransmitDetailService service = (SysTransmitDetailService)getBean("sysTransmitDetailService");

    private String lookupKey;        
	
    /**
     * sysTransmitDetail对象.
     */
    private SysTransmitDetail sysTransmitDetail;

    /**
     * SysTransmitDetail对象主键.
     */
    private java.lang.String sysTransmitDetailPrimaryKey;
	
	
	public String getLookupKey() {
		return lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}	

    /**
     * Returns the SysTransmitDetail.
     * @return SysTransmitDetail.
     */
    public SysTransmitDetail getSysTransmitDetail() {
        if(sysTransmitDetail == null) {
            sysTransmitDetail = new SysTransmitDetail();
        }
        return sysTransmitDetail;
    }

    /**
     * Sets the SysTransmitDetail.
     * @param sysTransmitDetail The sysTransmitDetail to set.
     */
    public void setSysTransmitDetail(SysTransmitDetail sysTransmitDetail) {
        this.sysTransmitDetail = sysTransmitDetail;
    }

    /**
     * Returns the sysTransmitDetailPrimaryKey.
     * @return SysTransmitDetailPrimaryKey.
     */
    public java.lang.String getSysTransmitDetailPrimaryKey() {
        return sysTransmitDetailPrimaryKey;
    }

    /**
     * Sets the sysTransmitDetailPrimaryKey.
     * @param sysTransmitDetailPrimaryKey The SysTransmitDetailPrimaryKey to set.
     */
    public void setSysTransmitDetailPrimaryKey(java.lang.String sysTransmitDetailPrimaryKey) {
		this.sysTransmitDetailPrimaryKey = sysTransmitDetailPrimaryKey;
		initSysTransmitDetail();
    }
	
	public void initSysTransmitDetail(){
        try {
            if (sysTransmitDetailPrimaryKey == null || sysTransmitDetailPrimaryKey.equals("")) {
                return;
            }
            this.setSysTransmitDetail(service.getSysTransmitDetail(sysTransmitDetailPrimaryKey));    
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}	


    /**
     * 存储SysTransmitDetail对象.
     * @return String.
     */
    public String save() {
        try {
            if(this.sysTransmitDetail.getId() == null){
                this.sysTransmitDetail.setId(getAutoNumberValue("sys_transmit_detail","id","{0}",0));
            }
            if (sysTransmitDetailPrimaryKey == null  && this.sysTransmitDetail.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getSysTransmitDetail(this.sysTransmitDetail.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.sysTransmitDetail.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (sysTransmitDetailPrimaryKey == null || sysTransmitDetailPrimaryKey.equals(this.sysTransmitDetail.getId())) {
            	this.sysTransmitDetail = service.saveSysTransmitDetail(this.sysTransmitDetail);
                String key = sysTransmitDetail.getId();
				this.sysTransmitDetailPrimaryKey = key;
                if (sysTransmitDetailPrimaryKey == null) {
                    addMessage("sysTransmitDetail.message.added", this.sysTransmitDetail.getId());				
                }
                else {
                    addMessage("sysTransmitDetail.message.saved", this.sysTransmitDetail.getId());					
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
            SysTransmitDetail sysTransmitDetail = new SysTransmitDetail();
            sysTransmitDetail.setTransmitId(this.sysTransmitDetail.getTransmitId());
            this.sysTransmitDetail = sysTransmitDetail;
            sysTransmitDetailPrimaryKey = null;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return null;
    }
    /**
     * 删除SysTransmitDetail对象.
     * @return String.
     */
    public String delete() {
        try {
            service.delete(this.sysTransmitDetail.getId());
			CmsUtil.deleteFile("sys_transmit_detail/"+this.sysTransmitDetail.getId());
            addMessage("sysTransmitDetail.message.deleted", this.sysTransmitDetail.getId());
		
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return getSuccessAction();
    }




    /**
     * 删除SysTransmitDetail对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            SysTransmitDetail sysTransmitDetail = service.getSysTransmitDetail(this.sysTransmitDetail.getId());
            service.delete(this.sysTransmitDetail.getId());
            addMessage("sysTransmitDetail.message.deleted", this.sysTransmitDetail.getId());	
		
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
    	if(this.sysTransmitDetailPrimaryKey == null)
    		return "_key=" + this.sysTransmitDetail.getId();
    	return "_key=" + this.sysTransmitDetailPrimaryKey;
    }
	
	    
    public String popSave(){
    	this.getRequest().getSession().setAttribute("__pop_object", this.sysTransmitDetail);
		this.getRequest().getSession().setAttribute("__pop_data_object", "SysTransmitDetail");
		return "popSuccess";
    }
	
    public String saveAll(){
       try {
            if(this.sysTransmitDetail.getId() == null){
                this.sysTransmitDetail.setId(getAutoNumberValue("sys_transmit_detail","id","{0}",0));
            }
            if (sysTransmitDetailPrimaryKey == null  && this.sysTransmitDetail.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getSysTransmitDetail(this.sysTransmitDetail.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.sysTransmitDetail.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (sysTransmitDetailPrimaryKey == null || sysTransmitDetailPrimaryKey.equals(this.sysTransmitDetail.getId())) {
  
                this.sysTransmitDetail = service.saveAll(this.sysTransmitDetail);
                String key = sysTransmitDetail.getId();
				this.sysTransmitDetailPrimaryKey = key;
                if (sysTransmitDetailPrimaryKey == null) {
                    addMessage("sysTransmitDetail.message.added", this.sysTransmitDetail.getId());				
                }
                else {
                    addMessage("sysTransmitDetail.message.saved", this.sysTransmitDetail.getId());					
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
            if(this.sysTransmitDetail.getId() == null){
                this.sysTransmitDetail.setId(getAutoNumberValue("sys_transmit_detail","id","{0}",0));
            }
            if (sysTransmitDetailPrimaryKey == null  && this.sysTransmitDetail.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getSysTransmitDetail(this.sysTransmitDetail.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.sysTransmitDetail.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (sysTransmitDetailPrimaryKey == null || sysTransmitDetailPrimaryKey.equals(this.sysTransmitDetail.getId())) {
                this.sysTransmitDetail = service.saveAll(this.sysTransmitDetail);

                String key = sysTransmitDetail.getId();
				this.sysTransmitDetailPrimaryKey = key;
                if (sysTransmitDetailPrimaryKey == null) {
                    addMessage("sysTransmitDetail.message.added", this.sysTransmitDetail.getId());				
                }
                else {
                    addMessage("sysTransmitDetail.message.saved", this.sysTransmitDetail.getId());					
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
	

	public void loadSysTransmitDetail(){	
		SysTransmitDetail sysTransmitDetail = (SysTransmitDetail)this.getRequest().getSession().getAttribute("__pop_object");
		this.sysTransmitDetail = sysTransmitDetail;
		this.getRequest().getSession().removeAttribute("__pop_object");
	}
	
}
