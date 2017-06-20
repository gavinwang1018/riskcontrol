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
 * EpcInsTask对象Form.
 * @author Administrator.
 *
 */
public class EpcInsTaskForm extends BasePage implements FormPage {

	private EpcInsTaskService service = (EpcInsTaskService)getBean("epcInsTaskService");

    private String lookupKey;        
	
    /**
     * epcInsTask对象.
     */
    private EpcInsTask epcInsTask;

    /**
     * EpcInsTask对象主键.
     */
    private java.lang.String epcInsTaskPrimaryKey;
	
	
	public String getLookupKey() {
		return lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}	

    /**
     * Returns the EpcInsTask.
     * @return EpcInsTask.
     */
    public EpcInsTask getEpcInsTask() {
        if(epcInsTask == null) {
            epcInsTask = new EpcInsTask();
        }
        return epcInsTask;
    }

    /**
     * Sets the EpcInsTask.
     * @param epcInsTask The epcInsTask to set.
     */
    public void setEpcInsTask(EpcInsTask epcInsTask) {
        this.epcInsTask = epcInsTask;
    }

    /**
     * Returns the epcInsTaskPrimaryKey.
     * @return EpcInsTaskPrimaryKey.
     */
    public java.lang.String getEpcInsTaskPrimaryKey() {
        return epcInsTaskPrimaryKey;
    }

    /**
     * Sets the epcInsTaskPrimaryKey.
     * @param epcInsTaskPrimaryKey The EpcInsTaskPrimaryKey to set.
     */
    public void setEpcInsTaskPrimaryKey(java.lang.String epcInsTaskPrimaryKey) {
		this.epcInsTaskPrimaryKey = epcInsTaskPrimaryKey;
		initEpcInsTask();
    }
	
	public void initEpcInsTask(){
        try {
            if (epcInsTaskPrimaryKey == null || epcInsTaskPrimaryKey.equals("")) {
                return;
            }
            this.setEpcInsTask(service.getEpcInsTask(epcInsTaskPrimaryKey));    
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}	


    /**
     * 存储EpcInsTask对象.
     * @return String.
     */
    public String save() {
        try {
            if(this.epcInsTask.getId() == null){
                this.epcInsTask.setId(getAutoNumberValue("epc_ins_task","id","{0}",0));
            }
            if (epcInsTaskPrimaryKey == null  && this.epcInsTask.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getEpcInsTask(this.epcInsTask.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.epcInsTask.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (epcInsTaskPrimaryKey == null || epcInsTaskPrimaryKey.equals(this.epcInsTask.getId())) {
            	this.epcInsTask = service.saveEpcInsTask(this.epcInsTask);
                String key = epcInsTask.getId();
				this.epcInsTaskPrimaryKey = key;
                if (epcInsTaskPrimaryKey == null) {
                    addMessage("epcInsTask.message.added", this.epcInsTask.getProcessInsId());				
                }
                else {
                    addMessage("epcInsTask.message.saved", this.epcInsTask.getProcessInsId());					
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
            EpcInsTask epcInsTask = new EpcInsTask();
            epcInsTask.setProcessInsId(this.epcInsTask.getProcessInsId());
            this.epcInsTask = epcInsTask;
            epcInsTaskPrimaryKey = null;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return null;
    }
    /**
     * 删除EpcInsTask对象.
     * @return String.
     */
    public String delete() {
        try {
            service.delete(this.epcInsTask.getId());
			CmsUtil.deleteFile("epc_ins_task/"+this.epcInsTask.getId());
            addMessage("epcInsTask.message.deleted", this.epcInsTask.getProcessInsId());
		
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return getSuccessAction();
    }




    /**
     * 删除EpcInsTask对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            EpcInsTask epcInsTask = service.getEpcInsTask(this.epcInsTask.getId());
            service.delete(this.epcInsTask.getId());
            addMessage("epcInsTask.message.deleted", this.epcInsTask.getProcessInsId());	
		
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
    	if(this.epcInsTaskPrimaryKey == null)
    		return "_key=" + this.epcInsTask.getId();
    	return "_key=" + this.epcInsTaskPrimaryKey;
    }
	
	    
    public String popSave(){
    	this.getRequest().getSession().setAttribute("__pop_object", this.epcInsTask);
		this.getRequest().getSession().setAttribute("__pop_data_object", "EpcInsTask");
		return "popSuccess";
    }
	
    public String saveAll(){
       try {
            if(this.epcInsTask.getId() == null){
                this.epcInsTask.setId(getAutoNumberValue("epc_ins_task","id","{0}",0));
            }
            if (epcInsTaskPrimaryKey == null  && this.epcInsTask.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getEpcInsTask(this.epcInsTask.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.epcInsTask.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (epcInsTaskPrimaryKey == null || epcInsTaskPrimaryKey.equals(this.epcInsTask.getId())) {
  
                this.epcInsTask = service.saveAll(this.epcInsTask);
                String key = epcInsTask.getId();
				this.epcInsTaskPrimaryKey = key;
                if (epcInsTaskPrimaryKey == null) {
                    addMessage("epcInsTask.message.added", this.epcInsTask.getProcessInsId());				
                }
                else {
                    addMessage("epcInsTask.message.saved", this.epcInsTask.getProcessInsId());					
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
            if(this.epcInsTask.getId() == null){
                this.epcInsTask.setId(getAutoNumberValue("epc_ins_task","id","{0}",0));
            }
            if (epcInsTaskPrimaryKey == null  && this.epcInsTask.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getEpcInsTask(this.epcInsTask.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.epcInsTask.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (epcInsTaskPrimaryKey == null || epcInsTaskPrimaryKey.equals(this.epcInsTask.getId())) {
                this.epcInsTask = service.saveAll(this.epcInsTask);

                String key = epcInsTask.getId();
				this.epcInsTaskPrimaryKey = key;
                if (epcInsTaskPrimaryKey == null) {
                    addMessage("epcInsTask.message.added", this.epcInsTask.getProcessInsId());				
                }
                else {
                    addMessage("epcInsTask.message.saved", this.epcInsTask.getProcessInsId());					
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
	

	public void loadEpcInsTask(){	
		EpcInsTask epcInsTask = (EpcInsTask)this.getRequest().getSession().getAttribute("__pop_object");
		this.epcInsTask = epcInsTask;
		this.getRequest().getSession().removeAttribute("__pop_object");
	}
	
}
