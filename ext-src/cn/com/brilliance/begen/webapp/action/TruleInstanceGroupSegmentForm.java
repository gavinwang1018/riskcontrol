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
 * TruleInstanceGroupSegment对象Form.
 * @author Administrator.
 *
 */
public class TruleInstanceGroupSegmentForm extends BasePage implements FormPage {

	private TruleInstanceGroupSegmentService service = (TruleInstanceGroupSegmentService)getBean("truleInstanceGroupSegmentService");

    private String lookupKey;        
	
    /**
     * truleInstanceGroupSegment对象.
     */
    private TruleInstanceGroupSegment truleInstanceGroupSegment;

    /**
     * TruleInstanceGroupSegment对象主键.
     */
    private java.lang.String truleInstanceGroupSegmentPrimaryKey;
	
	
	public String getLookupKey() {
		return lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}	

    /**
     * Returns the TruleInstanceGroupSegment.
     * @return TruleInstanceGroupSegment.
     */
    public TruleInstanceGroupSegment getTruleInstanceGroupSegment() {
        if(truleInstanceGroupSegment == null) {
            truleInstanceGroupSegment = new TruleInstanceGroupSegment();
        }
        return truleInstanceGroupSegment;
    }

    /**
     * Sets the TruleInstanceGroupSegment.
     * @param truleInstanceGroupSegment The truleInstanceGroupSegment to set.
     */
    public void setTruleInstanceGroupSegment(TruleInstanceGroupSegment truleInstanceGroupSegment) {
        this.truleInstanceGroupSegment = truleInstanceGroupSegment;
    }

    /**
     * Returns the truleInstanceGroupSegmentPrimaryKey.
     * @return TruleInstanceGroupSegmentPrimaryKey.
     */
    public java.lang.String getTruleInstanceGroupSegmentPrimaryKey() {
        return truleInstanceGroupSegmentPrimaryKey;
    }

    /**
     * Sets the truleInstanceGroupSegmentPrimaryKey.
     * @param truleInstanceGroupSegmentPrimaryKey The TruleInstanceGroupSegmentPrimaryKey to set.
     */
    public void setTruleInstanceGroupSegmentPrimaryKey(java.lang.String truleInstanceGroupSegmentPrimaryKey) {
		this.truleInstanceGroupSegmentPrimaryKey = truleInstanceGroupSegmentPrimaryKey;
		initTruleInstanceGroupSegment();
    }
	
	public void initTruleInstanceGroupSegment(){
        try {
            if (truleInstanceGroupSegmentPrimaryKey == null || truleInstanceGroupSegmentPrimaryKey.equals("")) {
                return;
            }
            this.setTruleInstanceGroupSegment(service.getTruleInstanceGroupSegment(truleInstanceGroupSegmentPrimaryKey));    
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}	


    /**
     * 存储TruleInstanceGroupSegment对象.
     * @return String.
     */
    public String save() {
        try {
            if (truleInstanceGroupSegmentPrimaryKey == null  && this.truleInstanceGroupSegment.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTruleInstanceGroupSegment(this.truleInstanceGroupSegment.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.truleInstanceGroupSegment.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (truleInstanceGroupSegmentPrimaryKey == null || truleInstanceGroupSegmentPrimaryKey.equals(this.truleInstanceGroupSegment.getId())) {
            	this.truleInstanceGroupSegment = service.saveTruleInstanceGroupSegment(this.truleInstanceGroupSegment);
                String key = truleInstanceGroupSegment.getId();
				this.truleInstanceGroupSegmentPrimaryKey = key;
                if (truleInstanceGroupSegmentPrimaryKey == null) {
                    addMessage("truleInstanceGroupSegment.message.added", this.truleInstanceGroupSegment.getId());				
                }
                else {
                    addMessage("truleInstanceGroupSegment.message.saved", this.truleInstanceGroupSegment.getId());					
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
            TruleInstanceGroupSegment truleInstanceGroupSegment = new TruleInstanceGroupSegment();
            this.truleInstanceGroupSegment = truleInstanceGroupSegment;
            truleInstanceGroupSegmentPrimaryKey = null;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return null;
    }
    /**
     * 删除TruleInstanceGroupSegment对象.
     * @return String.
     */
    public String delete() {
        try {
            service.delete(this.truleInstanceGroupSegment.getId());
			CmsUtil.deleteFile("t_rule_instance_group_segment/"+this.truleInstanceGroupSegment.getId());
            addMessage("truleInstanceGroupSegment.message.deleted", this.truleInstanceGroupSegment.getId());
		
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return getSuccessAction();
    }




    /**
     * 删除TruleInstanceGroupSegment对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            TruleInstanceGroupSegment truleInstanceGroupSegment = service.getTruleInstanceGroupSegment(this.truleInstanceGroupSegment.getId());
            service.delete(this.truleInstanceGroupSegment.getId());
            addMessage("truleInstanceGroupSegment.message.deleted", this.truleInstanceGroupSegment.getId());	
		
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
    	if(this.truleInstanceGroupSegmentPrimaryKey == null)
    		return "_key=" + this.truleInstanceGroupSegment.getId();
    	return "_key=" + this.truleInstanceGroupSegmentPrimaryKey;
    }
	
	    
    public String popSave(){
    	this.getRequest().getSession().setAttribute("__pop_object", this.truleInstanceGroupSegment);
		this.getRequest().getSession().setAttribute("__pop_data_object", "TruleInstanceGroupSegment");
		return "popSuccess";
    }
	
    public String saveAll(){
       try {
            if (truleInstanceGroupSegmentPrimaryKey == null  && this.truleInstanceGroupSegment.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTruleInstanceGroupSegment(this.truleInstanceGroupSegment.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.truleInstanceGroupSegment.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (truleInstanceGroupSegmentPrimaryKey == null || truleInstanceGroupSegmentPrimaryKey.equals(this.truleInstanceGroupSegment.getId())) {
  
                this.truleInstanceGroupSegment = service.saveAll(this.truleInstanceGroupSegment);
                String key = truleInstanceGroupSegment.getId();
				this.truleInstanceGroupSegmentPrimaryKey = key;
                if (truleInstanceGroupSegmentPrimaryKey == null) {
                    addMessage("truleInstanceGroupSegment.message.added", this.truleInstanceGroupSegment.getId());				
                }
                else {
                    addMessage("truleInstanceGroupSegment.message.saved", this.truleInstanceGroupSegment.getId());					
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
            if (truleInstanceGroupSegmentPrimaryKey == null  && this.truleInstanceGroupSegment.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTruleInstanceGroupSegment(this.truleInstanceGroupSegment.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.truleInstanceGroupSegment.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (truleInstanceGroupSegmentPrimaryKey == null || truleInstanceGroupSegmentPrimaryKey.equals(this.truleInstanceGroupSegment.getId())) {
                this.truleInstanceGroupSegment = service.saveAll(this.truleInstanceGroupSegment);

                String key = truleInstanceGroupSegment.getId();
				this.truleInstanceGroupSegmentPrimaryKey = key;
                if (truleInstanceGroupSegmentPrimaryKey == null) {
                    addMessage("truleInstanceGroupSegment.message.added", this.truleInstanceGroupSegment.getId());				
                }
                else {
                    addMessage("truleInstanceGroupSegment.message.saved", this.truleInstanceGroupSegment.getId());					
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
	

	public void loadTruleInstanceGroupSegment(){	
		TruleInstanceGroupSegment truleInstanceGroupSegment = (TruleInstanceGroupSegment)this.getRequest().getSession().getAttribute("__pop_object");
		this.truleInstanceGroupSegment = truleInstanceGroupSegment;
		this.getRequest().getSession().removeAttribute("__pop_object");
	}
	
}
