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
 * SysTransmit对象Form.
 * @author Administrator.
 *
 */
public class SysTransmitForm extends BasePage implements FormPage {

	private SysTransmitService service = (SysTransmitService)getBean("sysTransmitService");

    private String lookupKey;        
	
    /**
     * sysTransmit对象.
     */
    private SysTransmit sysTransmit;

    /**
     * SysTransmit对象主键.
     */
    private java.lang.String sysTransmitPrimaryKey;
	
	
	public String getLookupKey() {
		return lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}	

    /**
     * Returns the SysTransmit.
     * @return SysTransmit.
     */
    public SysTransmit getSysTransmit() {
        if(sysTransmit == null) {
            sysTransmit = new SysTransmit();
        }
        return sysTransmit;
    }

    /**
     * Sets the SysTransmit.
     * @param sysTransmit The sysTransmit to set.
     */
    public void setSysTransmit(SysTransmit sysTransmit) {
        this.sysTransmit = sysTransmit;
    }

    /**
     * Returns the sysTransmitPrimaryKey.
     * @return SysTransmitPrimaryKey.
     */
    public java.lang.String getSysTransmitPrimaryKey() {
        return sysTransmitPrimaryKey;
    }

    /**
     * Sets the sysTransmitPrimaryKey.
     * @param sysTransmitPrimaryKey The SysTransmitPrimaryKey to set.
     */
    public void setSysTransmitPrimaryKey(java.lang.String sysTransmitPrimaryKey) {
		this.sysTransmitPrimaryKey = sysTransmitPrimaryKey;
		initSysTransmit();
    }
	
	public void initSysTransmit(){
        try {
            if (sysTransmitPrimaryKey == null || sysTransmitPrimaryKey.equals("")) {
                return;
            }
            this.setSysTransmit(service.getSysTransmit(sysTransmitPrimaryKey));    
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}	

    public String loadChildOfSysTransmitDetail() {
        try {
            SysTransmitDetailList sysTransmitDetailList = new SysTransmitDetailList();            
			if(sysTransmit.getId() != null && !"".equals(sysTransmit.getId()) ){
			   SysTransmitDetail sysTransmitDetail = new SysTransmitDetail();
	           sysTransmitDetail.setTransmitId(this.sysTransmit.getId());
	           sysTransmitDetailList.setSysTransmitDetail(sysTransmitDetail);
			   sysTransmitDetailList.initSysTransmitDetails();
            }
			else{
			   SysTransmitDetail sysTransmitDetail = new SysTransmitDetail();
	           sysTransmitDetailList.setSysTransmitDetail(sysTransmitDetail);
               sysTransmitDetailList.setSysTransmitDetails(new ArrayList<SysTransmitDetail>());				
			}
            this.setValueBinding("#{sysTransmitDetailList}",sysTransmitDetailList);
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
        return null;
    }

    /**
     * 存储SysTransmit对象.
     * @return String.
     */
    public String save() {
        try {
            if(this.sysTransmit.getId() == null){
                this.sysTransmit.setId(getAutoNumberValue("sys_transmit","id","{0}",0));
            }
            if (sysTransmitPrimaryKey == null  && this.sysTransmit.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getSysTransmit(this.sysTransmit.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.sysTransmit.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (sysTransmitPrimaryKey == null || sysTransmitPrimaryKey.equals(this.sysTransmit.getId())) {
            	this.sysTransmit = service.saveSysTransmit(this.sysTransmit);
                String key = sysTransmit.getId();
				this.sysTransmitPrimaryKey = key;
                if (sysTransmitPrimaryKey == null) {
                    addMessage("sysTransmit.message.added", this.sysTransmit.getId());				
                }
                else {
                    addMessage("sysTransmit.message.saved", this.sysTransmit.getId());					
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
            SysTransmit sysTransmit = new SysTransmit();
            this.sysTransmit = sysTransmit;
            sysTransmitPrimaryKey = null;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return null;
    }
    /**
     * 删除SysTransmit对象.
     * @return String.
     */
    public String delete() {
        try {
            service.delete(this.sysTransmit.getId());
			CmsUtil.deleteFile("sys_transmit/"+this.sysTransmit.getId());
            addMessage("sysTransmit.message.deleted", this.sysTransmit.getId());
		
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return getSuccessAction();
    }




    /**
     * 删除SysTransmit对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            SysTransmit sysTransmit = service.getSysTransmit(this.sysTransmit.getId());
            if (sysTransmit.getSysTransmitDetailGroup().size() > 0) {
                this.addMessageString("exception.delete.cascade");
                return getFailureAction();
            }
            service.delete(this.sysTransmit.getId());
            addMessage("sysTransmit.message.deleted", this.sysTransmit.getId());	
		
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
    	if(this.sysTransmitPrimaryKey == null)
    		return "_key=" + this.sysTransmit.getId();
    	return "_key=" + this.sysTransmitPrimaryKey;
    }
	
	    
    public String popSave(){
    	this.getRequest().getSession().setAttribute("__pop_object", this.sysTransmit);
		this.getRequest().getSession().setAttribute("__pop_data_object", "SysTransmit");
		return "popSuccess";
    }
	
    public String saveAll(){
       try {
            if(this.sysTransmit.getId() == null){
                this.sysTransmit.setId(getAutoNumberValue("sys_transmit","id","{0}",0));
            }
            if (sysTransmitPrimaryKey == null  && this.sysTransmit.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getSysTransmit(this.sysTransmit.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.sysTransmit.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (sysTransmitPrimaryKey == null || sysTransmitPrimaryKey.equals(this.sysTransmit.getId())) {
  
    	SysTransmitDetailList sysTransmitDetailList = (SysTransmitDetailList)this.getValueBinding("#{sysTransmitDetailList}");	
                this.sysTransmit = service.saveAll(this.sysTransmit,sysTransmitDetailList.getDeleteList(),sysTransmitDetailList.getSysTransmitDetails());
                String key = sysTransmit.getId();
				this.sysTransmitPrimaryKey = key;
                if (sysTransmitPrimaryKey == null) {
                    addMessage("sysTransmit.message.added", this.sysTransmit.getId());				
                }
                else {
                    addMessage("sysTransmit.message.saved", this.sysTransmit.getId());					
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
            if(this.sysTransmit.getId() == null){
                this.sysTransmit.setId(getAutoNumberValue("sys_transmit","id","{0}",0));
            }
            if (sysTransmitPrimaryKey == null  && this.sysTransmit.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getSysTransmit(this.sysTransmit.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.sysTransmit.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (sysTransmitPrimaryKey == null || sysTransmitPrimaryKey.equals(this.sysTransmit.getId())) {
        SysTransmitDetailList sysTransmitDetailList = (SysTransmitDetailList)this.getValueBinding("#{sysTransmitDetailList}");
        List<SysTransmitDetail> sysTransmitDetails = sysTransmitDetailList.getSysTransmitDetails();			
    	List<SysTransmitDetail> sysTransmitDetailLists = new ArrayList<SysTransmitDetail>();
    	for(SysTransmitDetail sysTransmitDetail : sysTransmitDetails){
    		if(sysTransmitDetail.get_edit_flag() != SysTransmitDetail.EDIT_FLAG_EDIT){
    			sysTransmitDetail.set_edit_flag(SysTransmitDetail.EDIT_FLAG_EDIT);    			
    		}
    		sysTransmitDetailLists.add(sysTransmitDetail);
    	}

                this.sysTransmit = service.saveAll(this.sysTransmit,sysTransmitDetailList.getDeleteList(),sysTransmitDetailLists);

                String key = sysTransmit.getId();
				this.sysTransmitPrimaryKey = key;
                if (sysTransmitPrimaryKey == null) {
                    addMessage("sysTransmit.message.added", this.sysTransmit.getId());				
                }
                else {
                    addMessage("sysTransmit.message.saved", this.sysTransmit.getId());					
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
	
	private void saveSysTransmitDetail(){
    	SysTransmitDetailList sysTransmitDetailList = (SysTransmitDetailList)this.getValueBinding("#{sysTransmitDetailList}");
    	sysTransmitDetailList.saveAllOfSysTransmit(sysTransmit.getId());
    }	

	public void loadSysTransmit(){	
		SysTransmit sysTransmit = (SysTransmit)this.getRequest().getSession().getAttribute("__pop_object");
		this.sysTransmit = sysTransmit;
		this.getRequest().getSession().removeAttribute("__pop_object");
	}
	
}
