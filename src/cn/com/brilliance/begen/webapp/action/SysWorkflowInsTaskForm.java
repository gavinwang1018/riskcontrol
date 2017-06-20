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
 * SysWorkflowInsTask对象Form.
 * @author Administrator.
 *
 */
public class SysWorkflowInsTaskForm extends BasePage implements FormPage {

	private SysWorkflowInsTaskService service = (SysWorkflowInsTaskService)getBean("sysWorkflowInsTaskService");

    private String lookupKey;        
	
    /**
     * sysWorkflowInsTask对象.
     */
    private SysWorkflowInsTask sysWorkflowInsTask;

    /**
     * SysWorkflowInsTask对象主键.
     */
    private java.lang.String sysWorkflowInsTaskPrimaryKey;
	
	
	public String getLookupKey() {
		return lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}	

    /**
     * Returns the SysWorkflowInsTask.
     * @return SysWorkflowInsTask.
     */
    public SysWorkflowInsTask getSysWorkflowInsTask() {
        if(sysWorkflowInsTask == null) {
            sysWorkflowInsTask = new SysWorkflowInsTask();
        }
        return sysWorkflowInsTask;
    }

    /**
     * Sets the SysWorkflowInsTask.
     * @param sysWorkflowInsTask The sysWorkflowInsTask to set.
     */
    public void setSysWorkflowInsTask(SysWorkflowInsTask sysWorkflowInsTask) {
        this.sysWorkflowInsTask = sysWorkflowInsTask;
    }

    /**
     * Returns the sysWorkflowInsTaskPrimaryKey.
     * @return SysWorkflowInsTaskPrimaryKey.
     */
    public java.lang.String getSysWorkflowInsTaskPrimaryKey() {
        return sysWorkflowInsTaskPrimaryKey;
    }

    /**
     * Sets the sysWorkflowInsTaskPrimaryKey.
     * @param sysWorkflowInsTaskPrimaryKey The SysWorkflowInsTaskPrimaryKey to set.
     */
    public void setSysWorkflowInsTaskPrimaryKey(java.lang.String sysWorkflowInsTaskPrimaryKey) {
		this.sysWorkflowInsTaskPrimaryKey = sysWorkflowInsTaskPrimaryKey;
		initSysWorkflowInsTask();
    }
	
	public void initSysWorkflowInsTask(){
        try {
            if (sysWorkflowInsTaskPrimaryKey == null || sysWorkflowInsTaskPrimaryKey.equals("")) {
                return;
            }
            this.setSysWorkflowInsTask(service.getSysWorkflowInsTask(sysWorkflowInsTaskPrimaryKey));    
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}	


    /**
     * 存储SysWorkflowInsTask对象.
     * @return String.
     */
    public String save() {
        try {
            if(this.sysWorkflowInsTask.getId() == null){
                this.sysWorkflowInsTask.setId(getAutoNumberValue("sys_workflow_ins_task","id","{0}",0));
            }
            if (sysWorkflowInsTaskPrimaryKey == null  && this.sysWorkflowInsTask.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getSysWorkflowInsTask(this.sysWorkflowInsTask.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.sysWorkflowInsTask.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (sysWorkflowInsTaskPrimaryKey == null || sysWorkflowInsTaskPrimaryKey.equals(this.sysWorkflowInsTask.getId())) {
            	this.sysWorkflowInsTask = service.saveSysWorkflowInsTask(this.sysWorkflowInsTask);
                String key = sysWorkflowInsTask.getId();
				this.sysWorkflowInsTaskPrimaryKey = key;
                if (sysWorkflowInsTaskPrimaryKey == null) {
                    addMessage("sysWorkflowInsTask.message.added", this.sysWorkflowInsTask.getId());				
                }
                else {
                    addMessage("sysWorkflowInsTask.message.saved", this.sysWorkflowInsTask.getId());					
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
            SysWorkflowInsTask sysWorkflowInsTask = new SysWorkflowInsTask();
            sysWorkflowInsTask.setProcessInsId(this.sysWorkflowInsTask.getProcessInsId());
            this.sysWorkflowInsTask = sysWorkflowInsTask;
            sysWorkflowInsTaskPrimaryKey = null;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return null;
    }
    /**
     * 删除SysWorkflowInsTask对象.
     * @return String.
     */
    public String delete() {
        try {
            service.delete(this.sysWorkflowInsTask.getId());
			CmsUtil.deleteFile("sys_workflow_ins_task/"+this.sysWorkflowInsTask.getId());
            addMessage("sysWorkflowInsTask.message.deleted", this.sysWorkflowInsTask.getId());
		
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return getSuccessAction();
    }




    /**
     * 删除SysWorkflowInsTask对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            SysWorkflowInsTask sysWorkflowInsTask = service.getSysWorkflowInsTask(this.sysWorkflowInsTask.getId());
            service.delete(this.sysWorkflowInsTask.getId());
            addMessage("sysWorkflowInsTask.message.deleted", this.sysWorkflowInsTask.getId());	
		
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
    	if(this.sysWorkflowInsTaskPrimaryKey == null)
    		return "_key=" + this.sysWorkflowInsTask.getId();
    	return "_key=" + this.sysWorkflowInsTaskPrimaryKey;
    }
	
	    
    public String popSave(){
    	this.getRequest().getSession().setAttribute("__pop_object", this.sysWorkflowInsTask);
		this.getRequest().getSession().setAttribute("__pop_data_object", "SysWorkflowInsTask");
		return "popSuccess";
    }
	
    public String saveAll(){
       try {
            if(this.sysWorkflowInsTask.getId() == null){
                this.sysWorkflowInsTask.setId(getAutoNumberValue("sys_workflow_ins_task","id","{0}",0));
            }
            if (sysWorkflowInsTaskPrimaryKey == null  && this.sysWorkflowInsTask.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getSysWorkflowInsTask(this.sysWorkflowInsTask.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.sysWorkflowInsTask.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (sysWorkflowInsTaskPrimaryKey == null || sysWorkflowInsTaskPrimaryKey.equals(this.sysWorkflowInsTask.getId())) {
  
                this.sysWorkflowInsTask = service.saveAll(this.sysWorkflowInsTask);
                String key = sysWorkflowInsTask.getId();
				this.sysWorkflowInsTaskPrimaryKey = key;
                if (sysWorkflowInsTaskPrimaryKey == null) {
                    addMessage("sysWorkflowInsTask.message.added", this.sysWorkflowInsTask.getId());				
                }
                else {
                    addMessage("sysWorkflowInsTask.message.saved", this.sysWorkflowInsTask.getId());					
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
            if(this.sysWorkflowInsTask.getId() == null){
                this.sysWorkflowInsTask.setId(getAutoNumberValue("sys_workflow_ins_task","id","{0}",0));
            }
            if (sysWorkflowInsTaskPrimaryKey == null  && this.sysWorkflowInsTask.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getSysWorkflowInsTask(this.sysWorkflowInsTask.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.sysWorkflowInsTask.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (sysWorkflowInsTaskPrimaryKey == null || sysWorkflowInsTaskPrimaryKey.equals(this.sysWorkflowInsTask.getId())) {
                this.sysWorkflowInsTask = service.saveAll(this.sysWorkflowInsTask);

                String key = sysWorkflowInsTask.getId();
				this.sysWorkflowInsTaskPrimaryKey = key;
                if (sysWorkflowInsTaskPrimaryKey == null) {
                    addMessage("sysWorkflowInsTask.message.added", this.sysWorkflowInsTask.getId());				
                }
                else {
                    addMessage("sysWorkflowInsTask.message.saved", this.sysWorkflowInsTask.getId());					
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
	

	public void loadSysWorkflowInsTask(){	
		SysWorkflowInsTask sysWorkflowInsTask = (SysWorkflowInsTask)this.getRequest().getSession().getAttribute("__pop_object");
		this.sysWorkflowInsTask = sysWorkflowInsTask;
		this.getRequest().getSession().removeAttribute("__pop_object");
	}
	
}
