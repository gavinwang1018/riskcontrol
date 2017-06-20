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
 * TriskcaseLog对象Form.
 * @author Administrator.
 *
 */
public class TriskcaseLogForm extends BasePage implements FormPage {

	private TriskcaseLogService service = (TriskcaseLogService)getBean("triskcaseLogService");

    private String lookupKey;        
	
    /**
     * triskcaseLog对象.
     */
    private TriskcaseLog triskcaseLog;

    /**
     * TriskcaseLog对象主键.
     */
    private java.lang.String triskcaseLogPrimaryKey;
	
	
	public String getLookupKey() {
		return lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}	

    /**
     * Returns the TriskcaseLog.
     * @return TriskcaseLog.
     */
    public TriskcaseLog getTriskcaseLog() {
        if(triskcaseLog == null) {
            triskcaseLog = new TriskcaseLog();
        }
        return triskcaseLog;
    }

    /**
     * Sets the TriskcaseLog.
     * @param triskcaseLog The triskcaseLog to set.
     */
    public void setTriskcaseLog(TriskcaseLog triskcaseLog) {
        this.triskcaseLog = triskcaseLog;
    }

    /**
     * Returns the triskcaseLogPrimaryKey.
     * @return TriskcaseLogPrimaryKey.
     */
    public java.lang.String getTriskcaseLogPrimaryKey() {
        return triskcaseLogPrimaryKey;
    }

    /**
     * Sets the triskcaseLogPrimaryKey.
     * @param triskcaseLogPrimaryKey The TriskcaseLogPrimaryKey to set.
     */
    public void setTriskcaseLogPrimaryKey(java.lang.String triskcaseLogPrimaryKey) {
		this.triskcaseLogPrimaryKey = triskcaseLogPrimaryKey;
		initTriskcaseLog();
    }
	
	public void initTriskcaseLog(){
        try {
            if (triskcaseLogPrimaryKey == null || triskcaseLogPrimaryKey.equals("")) {
                return;
            }
            this.setTriskcaseLog(service.getTriskcaseLog(triskcaseLogPrimaryKey));    
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}	


    /**
     * 存储TriskcaseLog对象.
     * @return String.
     */
    public String save() {
        try {
            if(this.triskcaseLog.getId() == null){
                this.triskcaseLog.setId(getAutoNumberValue("t_riskcase_log","id","{0000000000000}",1));
            }
            if (triskcaseLogPrimaryKey == null  && this.triskcaseLog.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTriskcaseLog(this.triskcaseLog.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.triskcaseLog.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (triskcaseLogPrimaryKey == null || triskcaseLogPrimaryKey.equals(this.triskcaseLog.getId())) {
            	this.triskcaseLog = service.saveTriskcaseLog(this.triskcaseLog);
                String key = triskcaseLog.getId();
				this.triskcaseLogPrimaryKey = key;
                if (triskcaseLogPrimaryKey == null) {
                    addMessage("triskcaseLog.message.added", this.triskcaseLog.getId());				
                }
                else {
                    addMessage("triskcaseLog.message.saved", this.triskcaseLog.getId());					
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
            TriskcaseLog triskcaseLog = new TriskcaseLog();
            this.triskcaseLog = triskcaseLog;
            triskcaseLogPrimaryKey = null;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return null;
    }
    /**
     * 删除TriskcaseLog对象.
     * @return String.
     */
    public String delete() {
        try {
            service.delete(this.triskcaseLog.getId());
			CmsUtil.deleteFile("t_riskcase_log/"+this.triskcaseLog.getId());
            addMessage("triskcaseLog.message.deleted", this.triskcaseLog.getId());
		
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return getSuccessAction();
    }




    /**
     * 删除TriskcaseLog对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            TriskcaseLog triskcaseLog = service.getTriskcaseLog(this.triskcaseLog.getId());
            service.delete(this.triskcaseLog.getId());
            addMessage("triskcaseLog.message.deleted", this.triskcaseLog.getId());	
		
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
    	if(this.triskcaseLogPrimaryKey == null)
    		return "_key=" + this.triskcaseLog.getId();
    	return "_key=" + this.triskcaseLogPrimaryKey;
    }
	
	    
    public String popSave(){
    	this.getRequest().getSession().setAttribute("__pop_object", this.triskcaseLog);
		this.getRequest().getSession().setAttribute("__pop_data_object", "TriskcaseLog");
		return "popSuccess";
    }
	
    public String saveAll(){
       try {
            if(this.triskcaseLog.getId() == null){
                this.triskcaseLog.setId(getAutoNumberValue("t_riskcase_log","id","{0000000000000}",1));
            }
            if (triskcaseLogPrimaryKey == null  && this.triskcaseLog.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTriskcaseLog(this.triskcaseLog.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.triskcaseLog.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (triskcaseLogPrimaryKey == null || triskcaseLogPrimaryKey.equals(this.triskcaseLog.getId())) {
  
                this.triskcaseLog = service.saveAll(this.triskcaseLog);
                String key = triskcaseLog.getId();
				this.triskcaseLogPrimaryKey = key;
                if (triskcaseLogPrimaryKey == null) {
                    addMessage("triskcaseLog.message.added", this.triskcaseLog.getId());				
                }
                else {
                    addMessage("triskcaseLog.message.saved", this.triskcaseLog.getId());					
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
            if(this.triskcaseLog.getId() == null){
                this.triskcaseLog.setId(getAutoNumberValue("t_riskcase_log","id","{0000000000000}",1));
            }
            if (triskcaseLogPrimaryKey == null  && this.triskcaseLog.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTriskcaseLog(this.triskcaseLog.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.triskcaseLog.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (triskcaseLogPrimaryKey == null || triskcaseLogPrimaryKey.equals(this.triskcaseLog.getId())) {
                this.triskcaseLog = service.saveAll(this.triskcaseLog);

                String key = triskcaseLog.getId();
				this.triskcaseLogPrimaryKey = key;
                if (triskcaseLogPrimaryKey == null) {
                    addMessage("triskcaseLog.message.added", this.triskcaseLog.getId());				
                }
                else {
                    addMessage("triskcaseLog.message.saved", this.triskcaseLog.getId());					
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
	

	public void loadTriskcaseLog(){	
		TriskcaseLog triskcaseLog = (TriskcaseLog)this.getRequest().getSession().getAttribute("__pop_object");
		this.triskcaseLog = triskcaseLog;
		this.getRequest().getSession().removeAttribute("__pop_object");
	}
	
}
