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
 * TkeoMchnt对象Form.
 * @author Administrator.
 *
 */
public class TkeoMchntForm extends BasePage implements FormPage {

	private TkeoMchntService service = (TkeoMchntService)getBean("tkeoMchntService");

    private String lookupKey;        
	
    /**
     * tkeoMchnt对象.
     */
    private TkeoMchnt tkeoMchnt;

    /**
     * TkeoMchnt对象主键.
     */
    private java.lang.String tkeoMchntPrimaryKey;
	
	
	public String getLookupKey() {
		return lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}	

    /**
     * Returns the TkeoMchnt.
     * @return TkeoMchnt.
     */
    public TkeoMchnt getTkeoMchnt() {
        if(tkeoMchnt == null) {
            tkeoMchnt = new TkeoMchnt();
        }
        return tkeoMchnt;
    }

    /**
     * Sets the TkeoMchnt.
     * @param tkeoMchnt The tkeoMchnt to set.
     */
    public void setTkeoMchnt(TkeoMchnt tkeoMchnt) {
        this.tkeoMchnt = tkeoMchnt;
    }

    /**
     * Returns the tkeoMchntPrimaryKey.
     * @return TkeoMchntPrimaryKey.
     */
    public java.lang.String getTkeoMchntPrimaryKey() {
        return tkeoMchntPrimaryKey;
    }

    /**
     * Sets the tkeoMchntPrimaryKey.
     * @param tkeoMchntPrimaryKey The TkeoMchntPrimaryKey to set.
     */
    public void setTkeoMchntPrimaryKey(java.lang.String tkeoMchntPrimaryKey) {
		this.tkeoMchntPrimaryKey = tkeoMchntPrimaryKey;
		initTkeoMchnt();
    }
	
	public void initTkeoMchnt(){
        try {
            if (tkeoMchntPrimaryKey == null || tkeoMchntPrimaryKey.equals("")) {
                return;
            }
            this.setTkeoMchnt(service.getTkeoMchnt(tkeoMchntPrimaryKey));    
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}	


    /**
     * 存储TkeoMchnt对象.
     * @return String.
     */
    public String save() {
        try {
            if(this.tkeoMchnt.getId() == null){
                this.tkeoMchnt.setId(getAutoNumberValue("t_keo_mchnt","id","{0000000000000}",1));
            }
            if (tkeoMchntPrimaryKey == null  && this.tkeoMchnt.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTkeoMchnt(this.tkeoMchnt.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.tkeoMchnt.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (tkeoMchntPrimaryKey == null || tkeoMchntPrimaryKey.equals(this.tkeoMchnt.getId())) {
            	this.tkeoMchnt = service.saveTkeoMchnt(this.tkeoMchnt);
                String key = tkeoMchnt.getId();
				this.tkeoMchntPrimaryKey = key;
                if (tkeoMchntPrimaryKey == null) {
                    addMessage("tkeoMchnt.message.added", this.tkeoMchnt.getId());				
                }
                else {
                    addMessage("tkeoMchnt.message.saved", this.tkeoMchnt.getId());					
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
            TkeoMchnt tkeoMchnt = new TkeoMchnt();
            this.tkeoMchnt = tkeoMchnt;
            tkeoMchntPrimaryKey = null;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return null;
    }
    /**
     * 删除TkeoMchnt对象.
     * @return String.
     */
    public String delete() {
        try {
            service.delete(this.tkeoMchnt.getId());
			CmsUtil.deleteFile("t_keo_mchnt/"+this.tkeoMchnt.getId());
            addMessage("tkeoMchnt.message.deleted", this.tkeoMchnt.getId());
		
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return getSuccessAction();
    }




    /**
     * 删除TkeoMchnt对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            TkeoMchnt tkeoMchnt = service.getTkeoMchnt(this.tkeoMchnt.getId());
            service.delete(this.tkeoMchnt.getId());
            addMessage("tkeoMchnt.message.deleted", this.tkeoMchnt.getId());	
		
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
    	if(this.tkeoMchntPrimaryKey == null)
    		return "_key=" + this.tkeoMchnt.getId();
    	return "_key=" + this.tkeoMchntPrimaryKey;
    }
	
	    
    public String popSave(){
    	this.getRequest().getSession().setAttribute("__pop_object", this.tkeoMchnt);
		this.getRequest().getSession().setAttribute("__pop_data_object", "TkeoMchnt");
		return "popSuccess";
    }
	
    public String saveAll(){
       try {
            if(this.tkeoMchnt.getId() == null){
                this.tkeoMchnt.setId(getAutoNumberValue("t_keo_mchnt","id","{0000000000000}",1));
            }
            if (tkeoMchntPrimaryKey == null  && this.tkeoMchnt.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTkeoMchnt(this.tkeoMchnt.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.tkeoMchnt.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (tkeoMchntPrimaryKey == null || tkeoMchntPrimaryKey.equals(this.tkeoMchnt.getId())) {
  
                this.tkeoMchnt = service.saveAll(this.tkeoMchnt);
                String key = tkeoMchnt.getId();
				this.tkeoMchntPrimaryKey = key;
                if (tkeoMchntPrimaryKey == null) {
                    addMessage("tkeoMchnt.message.added", this.tkeoMchnt.getId());				
                }
                else {
                    addMessage("tkeoMchnt.message.saved", this.tkeoMchnt.getId());					
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
            if(this.tkeoMchnt.getId() == null){
                this.tkeoMchnt.setId(getAutoNumberValue("t_keo_mchnt","id","{0000000000000}",1));
            }
            if (tkeoMchntPrimaryKey == null  && this.tkeoMchnt.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTkeoMchnt(this.tkeoMchnt.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.tkeoMchnt.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (tkeoMchntPrimaryKey == null || tkeoMchntPrimaryKey.equals(this.tkeoMchnt.getId())) {
                this.tkeoMchnt = service.saveAll(this.tkeoMchnt);

                String key = tkeoMchnt.getId();
				this.tkeoMchntPrimaryKey = key;
                if (tkeoMchntPrimaryKey == null) {
                    addMessage("tkeoMchnt.message.added", this.tkeoMchnt.getId());				
                }
                else {
                    addMessage("tkeoMchnt.message.saved", this.tkeoMchnt.getId());					
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
	

	public void loadTkeoMchnt(){	
		TkeoMchnt tkeoMchnt = (TkeoMchnt)this.getRequest().getSession().getAttribute("__pop_object");
		this.tkeoMchnt = tkeoMchnt;
		this.getRequest().getSession().removeAttribute("__pop_object");
	}
	
}
