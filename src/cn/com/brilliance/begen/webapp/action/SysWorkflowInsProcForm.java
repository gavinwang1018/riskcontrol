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
 * SysWorkflowInsProc对象Form.
 * @author Administrator.
 *
 */
public class SysWorkflowInsProcForm extends BasePage implements FormPage {

	private SysWorkflowInsProcService service = (SysWorkflowInsProcService)getBean("sysWorkflowInsProcService");

    private String lookupKey;        
	
    /**
     * sysWorkflowInsProc对象.
     */
    private SysWorkflowInsProc sysWorkflowInsProc;

    /**
     * SysWorkflowInsProc对象主键.
     */
    private java.lang.String sysWorkflowInsProcPrimaryKey;
	
	
	public String getLookupKey() {
		return lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}	

    /**
     * Returns the SysWorkflowInsProc.
     * @return SysWorkflowInsProc.
     */
    public SysWorkflowInsProc getSysWorkflowInsProc() {
        if(sysWorkflowInsProc == null) {
            sysWorkflowInsProc = new SysWorkflowInsProc();
        }
        return sysWorkflowInsProc;
    }

    /**
     * Sets the SysWorkflowInsProc.
     * @param sysWorkflowInsProc The sysWorkflowInsProc to set.
     */
    public void setSysWorkflowInsProc(SysWorkflowInsProc sysWorkflowInsProc) {
        this.sysWorkflowInsProc = sysWorkflowInsProc;
    }

    /**
     * Returns the sysWorkflowInsProcPrimaryKey.
     * @return SysWorkflowInsProcPrimaryKey.
     */
    public java.lang.String getSysWorkflowInsProcPrimaryKey() {
        return sysWorkflowInsProcPrimaryKey;
    }

    /**
     * Sets the sysWorkflowInsProcPrimaryKey.
     * @param sysWorkflowInsProcPrimaryKey The SysWorkflowInsProcPrimaryKey to set.
     */
    public void setSysWorkflowInsProcPrimaryKey(java.lang.String sysWorkflowInsProcPrimaryKey) {
		this.sysWorkflowInsProcPrimaryKey = sysWorkflowInsProcPrimaryKey;
		initSysWorkflowInsProc();
    }
	
	public void initSysWorkflowInsProc(){
        try {
            if (sysWorkflowInsProcPrimaryKey == null || sysWorkflowInsProcPrimaryKey.equals("")) {
                return;
            }
            this.setSysWorkflowInsProc(service.getSysWorkflowInsProc(sysWorkflowInsProcPrimaryKey));    
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}	

    public String loadChildOfSysWorkflowInsTask() {
        try {
            SysWorkflowInsTaskList sysWorkflowInsTaskList = new SysWorkflowInsTaskList();            
			if(sysWorkflowInsProc.getId() != null && !"".equals(sysWorkflowInsProc.getId()) ){
			   SysWorkflowInsTask sysWorkflowInsTask = new SysWorkflowInsTask();
	           sysWorkflowInsTask.setProcessInsId(this.sysWorkflowInsProc.getId());
	           sysWorkflowInsTaskList.setSysWorkflowInsTask(sysWorkflowInsTask);
			   sysWorkflowInsTaskList.initSysWorkflowInsTasks();
            }
			else{
			   SysWorkflowInsTask sysWorkflowInsTask = new SysWorkflowInsTask();
	           sysWorkflowInsTaskList.setSysWorkflowInsTask(sysWorkflowInsTask);
               sysWorkflowInsTaskList.setSysWorkflowInsTasks(new ArrayList<SysWorkflowInsTask>());				
			}
            this.setValueBinding("#{sysWorkflowInsTaskList}",sysWorkflowInsTaskList);
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
        return null;
    }

    /**
     * 存储SysWorkflowInsProc对象.
     * @return String.
     */
    public String save() {
        try {
            if(this.sysWorkflowInsProc.getId() == null){
                this.sysWorkflowInsProc.setId(getAutoNumberValue("sys_workflow_ins_proc","id","{0}",0));
            }
            if (sysWorkflowInsProcPrimaryKey == null  && this.sysWorkflowInsProc.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getSysWorkflowInsProc(this.sysWorkflowInsProc.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.sysWorkflowInsProc.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (sysWorkflowInsProcPrimaryKey == null || sysWorkflowInsProcPrimaryKey.equals(this.sysWorkflowInsProc.getId())) {
            	this.sysWorkflowInsProc = service.saveSysWorkflowInsProc(this.sysWorkflowInsProc);
                String key = sysWorkflowInsProc.getId();
				this.sysWorkflowInsProcPrimaryKey = key;
                if (sysWorkflowInsProcPrimaryKey == null) {
                    addMessage("sysWorkflowInsProc.message.added", this.sysWorkflowInsProc.getId());				
                }
                else {
                    addMessage("sysWorkflowInsProc.message.saved", this.sysWorkflowInsProc.getId());					
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
            SysWorkflowInsProc sysWorkflowInsProc = new SysWorkflowInsProc();
            this.sysWorkflowInsProc = sysWorkflowInsProc;
            sysWorkflowInsProcPrimaryKey = null;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return null;
    }
    /**
     * 删除SysWorkflowInsProc对象.
     * @return String.
     */
    public String delete() {
        try {
            service.delete(this.sysWorkflowInsProc.getId());
			CmsUtil.deleteFile("sys_workflow_ins_proc/"+this.sysWorkflowInsProc.getId());
            addMessage("sysWorkflowInsProc.message.deleted", this.sysWorkflowInsProc.getId());
		
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return getSuccessAction();
    }




    /**
     * 删除SysWorkflowInsProc对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            SysWorkflowInsProc sysWorkflowInsProc = service.getSysWorkflowInsProc(this.sysWorkflowInsProc.getId());
            if (sysWorkflowInsProc.getSysWorkflowInsTaskGroup().size() > 0) {
                this.addMessageString("exception.delete.cascade");
                return getFailureAction();
            }
            service.delete(this.sysWorkflowInsProc.getId());
            addMessage("sysWorkflowInsProc.message.deleted", this.sysWorkflowInsProc.getId());	
		
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
    	if(this.sysWorkflowInsProcPrimaryKey == null)
    		return "_key=" + this.sysWorkflowInsProc.getId();
    	return "_key=" + this.sysWorkflowInsProcPrimaryKey;
    }
	
	    
    public String popSave(){
    	this.getRequest().getSession().setAttribute("__pop_object", this.sysWorkflowInsProc);
		this.getRequest().getSession().setAttribute("__pop_data_object", "SysWorkflowInsProc");
		return "popSuccess";
    }
	
    public String saveAll(){
       try {
            if(this.sysWorkflowInsProc.getId() == null){
                this.sysWorkflowInsProc.setId(getAutoNumberValue("sys_workflow_ins_proc","id","{0}",0));
            }
            if (sysWorkflowInsProcPrimaryKey == null  && this.sysWorkflowInsProc.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getSysWorkflowInsProc(this.sysWorkflowInsProc.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.sysWorkflowInsProc.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (sysWorkflowInsProcPrimaryKey == null || sysWorkflowInsProcPrimaryKey.equals(this.sysWorkflowInsProc.getId())) {
  
    	SysWorkflowInsTaskList sysWorkflowInsTaskList = (SysWorkflowInsTaskList)this.getValueBinding("#{sysWorkflowInsTaskList}");	
                this.sysWorkflowInsProc = service.saveAll(this.sysWorkflowInsProc,sysWorkflowInsTaskList.getDeleteList(),sysWorkflowInsTaskList.getSysWorkflowInsTasks());
                String key = sysWorkflowInsProc.getId();
				this.sysWorkflowInsProcPrimaryKey = key;
                if (sysWorkflowInsProcPrimaryKey == null) {
                    addMessage("sysWorkflowInsProc.message.added", this.sysWorkflowInsProc.getId());				
                }
                else {
                    addMessage("sysWorkflowInsProc.message.saved", this.sysWorkflowInsProc.getId());					
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
            if(this.sysWorkflowInsProc.getId() == null){
                this.sysWorkflowInsProc.setId(getAutoNumberValue("sys_workflow_ins_proc","id","{0}",0));
            }
            if (sysWorkflowInsProcPrimaryKey == null  && this.sysWorkflowInsProc.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getSysWorkflowInsProc(this.sysWorkflowInsProc.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.sysWorkflowInsProc.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (sysWorkflowInsProcPrimaryKey == null || sysWorkflowInsProcPrimaryKey.equals(this.sysWorkflowInsProc.getId())) {
        SysWorkflowInsTaskList sysWorkflowInsTaskList = (SysWorkflowInsTaskList)this.getValueBinding("#{sysWorkflowInsTaskList}");
        List<SysWorkflowInsTask> sysWorkflowInsTasks = sysWorkflowInsTaskList.getSysWorkflowInsTasks();			
    	List<SysWorkflowInsTask> sysWorkflowInsTaskLists = new ArrayList<SysWorkflowInsTask>();
    	for(SysWorkflowInsTask sysWorkflowInsTask : sysWorkflowInsTasks){
    		if(sysWorkflowInsTask.get_edit_flag() != SysWorkflowInsTask.EDIT_FLAG_EDIT){
    			sysWorkflowInsTask.set_edit_flag(SysWorkflowInsTask.EDIT_FLAG_EDIT);    			
    		}
    		sysWorkflowInsTaskLists.add(sysWorkflowInsTask);
    	}

                this.sysWorkflowInsProc = service.saveAll(this.sysWorkflowInsProc,sysWorkflowInsTaskList.getDeleteList(),sysWorkflowInsTaskLists);

                String key = sysWorkflowInsProc.getId();
				this.sysWorkflowInsProcPrimaryKey = key;
                if (sysWorkflowInsProcPrimaryKey == null) {
                    addMessage("sysWorkflowInsProc.message.added", this.sysWorkflowInsProc.getId());				
                }
                else {
                    addMessage("sysWorkflowInsProc.message.saved", this.sysWorkflowInsProc.getId());					
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
	
	private void saveSysWorkflowInsTask(){
    	SysWorkflowInsTaskList sysWorkflowInsTaskList = (SysWorkflowInsTaskList)this.getValueBinding("#{sysWorkflowInsTaskList}");
    	sysWorkflowInsTaskList.saveAllOfSysWorkflowInsProc(sysWorkflowInsProc.getId());
    }	

	public void loadSysWorkflowInsProc(){	
		SysWorkflowInsProc sysWorkflowInsProc = (SysWorkflowInsProc)this.getRequest().getSession().getAttribute("__pop_object");
		this.sysWorkflowInsProc = sysWorkflowInsProc;
		this.getRequest().getSession().removeAttribute("__pop_object");
	}
	
}
