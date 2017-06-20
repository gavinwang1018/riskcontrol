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
 * EpcInsProc对象Form.
 * @author Administrator.
 *
 */
public class EpcInsProcForm extends BasePage implements FormPage {

	private EpcInsProcService service = (EpcInsProcService)getBean("epcInsProcService");

    private String lookupKey;        
	
    /**
     * epcInsProc对象.
     */
    private EpcInsProc epcInsProc;

    /**
     * EpcInsProc对象主键.
     */
    private java.lang.String epcInsProcPrimaryKey;
	
	
	public String getLookupKey() {
		return lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}	

    /**
     * Returns the EpcInsProc.
     * @return EpcInsProc.
     */
    public EpcInsProc getEpcInsProc() {
        if(epcInsProc == null) {
            epcInsProc = new EpcInsProc();
        }
        return epcInsProc;
    }

    /**
     * Sets the EpcInsProc.
     * @param epcInsProc The epcInsProc to set.
     */
    public void setEpcInsProc(EpcInsProc epcInsProc) {
        this.epcInsProc = epcInsProc;
    }

    /**
     * Returns the epcInsProcPrimaryKey.
     * @return EpcInsProcPrimaryKey.
     */
    public java.lang.String getEpcInsProcPrimaryKey() {
        return epcInsProcPrimaryKey;
    }

    /**
     * Sets the epcInsProcPrimaryKey.
     * @param epcInsProcPrimaryKey The EpcInsProcPrimaryKey to set.
     */
    public void setEpcInsProcPrimaryKey(java.lang.String epcInsProcPrimaryKey) {
		this.epcInsProcPrimaryKey = epcInsProcPrimaryKey;
		initEpcInsProc();
    }
	
	public void initEpcInsProc(){
        try {
            if (epcInsProcPrimaryKey == null || epcInsProcPrimaryKey.equals("")) {
                return;
            }
            this.setEpcInsProc(service.getEpcInsProc(epcInsProcPrimaryKey));    
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}	

    public String loadChildOfEpcInsTask() {
        try {
            EpcInsTaskList epcInsTaskList = new EpcInsTaskList();            
			if(epcInsProc.getId() != null && !"".equals(epcInsProc.getId()) ){
			   EpcInsTask epcInsTask = new EpcInsTask();
	           epcInsTask.setProcessInsId(this.epcInsProc.getId());
	           epcInsTaskList.setEpcInsTask(epcInsTask);
			   epcInsTaskList.initEpcInsTasks();
            }
			else{
			   EpcInsTask epcInsTask = new EpcInsTask();
	           epcInsTaskList.setEpcInsTask(epcInsTask);
               epcInsTaskList.setEpcInsTasks(new ArrayList<EpcInsTask>());				
			}
            this.setValueBinding("#{epcInsTaskList}",epcInsTaskList);
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
        return null;
    }

    /**
     * 存储EpcInsProc对象.
     * @return String.
     */
    public String save() {
        try {
            if(this.epcInsProc.getId() == null){
                this.epcInsProc.setId(getAutoNumberValue("epc_ins_proc","id","{0}",0));
            }
            if (epcInsProcPrimaryKey == null  && this.epcInsProc.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getEpcInsProc(this.epcInsProc.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.epcInsProc.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (epcInsProcPrimaryKey == null || epcInsProcPrimaryKey.equals(this.epcInsProc.getId())) {
            	this.epcInsProc = service.saveEpcInsProc(this.epcInsProc);
                String key = epcInsProc.getId();
				this.epcInsProcPrimaryKey = key;
                if (epcInsProcPrimaryKey == null) {
                    addMessage("epcInsProc.message.added", this.epcInsProc.getProcessDefId());				
                }
                else {
                    addMessage("epcInsProc.message.saved", this.epcInsProc.getProcessDefId());					
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
            EpcInsProc epcInsProc = new EpcInsProc();
            this.epcInsProc = epcInsProc;
            epcInsProcPrimaryKey = null;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return null;
    }
    /**
     * 删除EpcInsProc对象.
     * @return String.
     */
    public String delete() {
        try {
            service.delete(this.epcInsProc.getId());
			CmsUtil.deleteFile("epc_ins_proc/"+this.epcInsProc.getId());
            addMessage("epcInsProc.message.deleted", this.epcInsProc.getProcessDefId());
		
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return getSuccessAction();
    }




    /**
     * 删除EpcInsProc对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            EpcInsProc epcInsProc = service.getEpcInsProc(this.epcInsProc.getId());
            if (epcInsProc.getEpcInsTaskGroup().size() > 0) {
                this.addMessageString("exception.delete.cascade");
                return getFailureAction();
            }
            service.delete(this.epcInsProc.getId());
            addMessage("epcInsProc.message.deleted", this.epcInsProc.getProcessDefId());	
		
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
    	if(this.epcInsProcPrimaryKey == null)
    		return "_key=" + this.epcInsProc.getId();
    	return "_key=" + this.epcInsProcPrimaryKey;
    }
	
	    
    public String popSave(){
    	this.getRequest().getSession().setAttribute("__pop_object", this.epcInsProc);
		this.getRequest().getSession().setAttribute("__pop_data_object", "EpcInsProc");
		return "popSuccess";
    }
	
    public String saveAll(){
       try {
            if(this.epcInsProc.getId() == null){
                this.epcInsProc.setId(getAutoNumberValue("epc_ins_proc","id","{0}",0));
            }
            if (epcInsProcPrimaryKey == null  && this.epcInsProc.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getEpcInsProc(this.epcInsProc.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.epcInsProc.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (epcInsProcPrimaryKey == null || epcInsProcPrimaryKey.equals(this.epcInsProc.getId())) {
  
    	EpcInsTaskList epcInsTaskList = (EpcInsTaskList)this.getValueBinding("#{epcInsTaskList}");	
                this.epcInsProc = service.saveAll(this.epcInsProc,epcInsTaskList.getDeleteList(),epcInsTaskList.getEpcInsTasks());
                String key = epcInsProc.getId();
				this.epcInsProcPrimaryKey = key;
                if (epcInsProcPrimaryKey == null) {
                    addMessage("epcInsProc.message.added", this.epcInsProc.getProcessDefId());				
                }
                else {
                    addMessage("epcInsProc.message.saved", this.epcInsProc.getProcessDefId());					
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
            if(this.epcInsProc.getId() == null){
                this.epcInsProc.setId(getAutoNumberValue("epc_ins_proc","id","{0}",0));
            }
            if (epcInsProcPrimaryKey == null  && this.epcInsProc.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getEpcInsProc(this.epcInsProc.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.epcInsProc.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (epcInsProcPrimaryKey == null || epcInsProcPrimaryKey.equals(this.epcInsProc.getId())) {
        EpcInsTaskList epcInsTaskList = (EpcInsTaskList)this.getValueBinding("#{epcInsTaskList}");
        List<EpcInsTask> epcInsTasks = epcInsTaskList.getEpcInsTasks();			
    	List<EpcInsTask> epcInsTaskLists = new ArrayList<EpcInsTask>();
    	for(EpcInsTask epcInsTask : epcInsTasks){
    		if(epcInsTask.get_edit_flag() != EpcInsTask.EDIT_FLAG_EDIT){
    			epcInsTask.set_edit_flag(EpcInsTask.EDIT_FLAG_EDIT);    			
    		}
    		epcInsTaskLists.add(epcInsTask);
    	}

                this.epcInsProc = service.saveAll(this.epcInsProc,epcInsTaskList.getDeleteList(),epcInsTaskLists);

                String key = epcInsProc.getId();
				this.epcInsProcPrimaryKey = key;
                if (epcInsProcPrimaryKey == null) {
                    addMessage("epcInsProc.message.added", this.epcInsProc.getProcessDefId());				
                }
                else {
                    addMessage("epcInsProc.message.saved", this.epcInsProc.getProcessDefId());					
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
	
	private void saveEpcInsTask(){
    	EpcInsTaskList epcInsTaskList = (EpcInsTaskList)this.getValueBinding("#{epcInsTaskList}");
    	epcInsTaskList.saveAllOfEpcInsProc(epcInsProc.getId());
    }	

	public void loadEpcInsProc(){	
		EpcInsProc epcInsProc = (EpcInsProc)this.getRequest().getSession().getAttribute("__pop_object");
		this.epcInsProc = epcInsProc;
		this.getRequest().getSession().removeAttribute("__pop_object");
	}
	
}
