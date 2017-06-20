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
 * Tmcc对象Form.
 * @author Administrator.
 *
 */
public class TmccForm extends BasePage implements FormPage {

	private TmccService service = (TmccService)getBean("tmccService");

    private String lookupKey;        
	
    /**
     * tmcc对象.
     */
    private Tmcc tmcc;

    /**
     * Tmcc对象主键.
     */
    private java.lang.String tmccPrimaryKey;
	
	
	public String getLookupKey() {
		return lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}	

    /**
     * Returns the Tmcc.
     * @return Tmcc.
     */
    public Tmcc getTmcc() {
        if(tmcc == null) {
            tmcc = new Tmcc();
        }
        return tmcc;
    }

    /**
     * Sets the Tmcc.
     * @param tmcc The tmcc to set.
     */
    public void setTmcc(Tmcc tmcc) {
        this.tmcc = tmcc;
    }

    /**
     * Returns the tmccPrimaryKey.
     * @return TmccPrimaryKey.
     */
    public java.lang.String getTmccPrimaryKey() {
        return tmccPrimaryKey;
    }

    /**
     * Sets the tmccPrimaryKey.
     * @param tmccPrimaryKey The TmccPrimaryKey to set.
     */
    public void setTmccPrimaryKey(java.lang.String tmccPrimaryKey) {
		this.tmccPrimaryKey = tmccPrimaryKey;
		initTmcc();
    }
	
	public void initTmcc(){
        try {
            if (tmccPrimaryKey == null || tmccPrimaryKey.equals("")) {
                return;
            }
            this.setTmcc(service.getTmcc(tmccPrimaryKey));    
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}	


    /**
     * 存储Tmcc对象.
     * @return String.
     */
    public String save() {
        try {
            if(this.tmcc.getId() == null){
                this.tmcc.setId(getAutoNumberValue("t_mcc","id","{00000000000}",1));
            }
            if (tmccPrimaryKey == null  && this.tmcc.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTmcc(this.tmcc.getId()) != null) {
                    addMessage("error.database.duplicatekey", "id[" + this.tmcc.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (tmccPrimaryKey == null || tmccPrimaryKey.equals(this.tmcc.getId())) {
            	this.tmcc = service.saveTmcc(this.tmcc);
                String key = tmcc.getId();
				this.tmccPrimaryKey = key;
                if (tmccPrimaryKey == null) {
                    addMessage("tmcc.message.added", this.tmcc.getId());				
                }
                else {
                    addMessage("tmcc.message.saved", this.tmcc.getId());					
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
            Tmcc tmcc = new Tmcc();
            this.tmcc = tmcc;
            tmccPrimaryKey = null;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return null;
    }
    /**
     * 删除Tmcc对象.
     * @return String.
     */
    public String delete() {
        try {
            service.delete(this.tmcc.getId());
			CmsUtil.deleteFile("t_mcc/"+this.tmcc.getId());
            addMessage("tmcc.message.deleted", this.tmcc.getId());
		
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return getSuccessAction();
    }




    /**
     * 删除Tmcc对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            Tmcc tmcc = service.getTmcc(this.tmcc.getId());
            service.delete(this.tmcc.getId());
            addMessage("tmcc.message.deleted", this.tmcc.getId());	
		
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
    	if(this.tmccPrimaryKey == null)
    		return "_key=" + this.tmcc.getId();
    	return "_key=" + this.tmccPrimaryKey;
    }
	
	    
    public String popSave(){
    	this.getRequest().getSession().setAttribute("__pop_object", this.tmcc);
		this.getRequest().getSession().setAttribute("__pop_data_object", "Tmcc");
		return "popSuccess";
    }
	
    public String saveAll(){
       try {
            if(this.tmcc.getId() == null){
                this.tmcc.setId(getAutoNumberValue("t_mcc","id","{00000000000}",1));
            }
            if (tmccPrimaryKey == null  && this.tmcc.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTmcc(this.tmcc.getId()) != null) {
                    addMessage("error.database.duplicatekey", "id[" + this.tmcc.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (tmccPrimaryKey == null || tmccPrimaryKey.equals(this.tmcc.getId())) {
  
                this.tmcc = service.saveAll(this.tmcc);
                String key = tmcc.getId();
				this.tmccPrimaryKey = key;
                if (tmccPrimaryKey == null) {
                    addMessage("tmcc.message.added", this.tmcc.getId());				
                }
                else {
                    addMessage("tmcc.message.saved", this.tmcc.getId());					
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
            if(this.tmcc.getId() == null){
                this.tmcc.setId(getAutoNumberValue("t_mcc","id","{00000000000}",1));
            }
            if (tmccPrimaryKey == null  && this.tmcc.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTmcc(this.tmcc.getId()) != null) {
                    addMessage("error.database.duplicatekey", "id[" + this.tmcc.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (tmccPrimaryKey == null || tmccPrimaryKey.equals(this.tmcc.getId())) {
                this.tmcc = service.saveAll(this.tmcc);

                String key = tmcc.getId();
				this.tmccPrimaryKey = key;
                if (tmccPrimaryKey == null) {
                    addMessage("tmcc.message.added", this.tmcc.getId());				
                }
                else {
                    addMessage("tmcc.message.saved", this.tmcc.getId());					
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
	

	public void loadTmcc(){	
		Tmcc tmcc = (Tmcc)this.getRequest().getSession().getAttribute("__pop_object");
		this.tmcc = tmcc;
		this.getRequest().getSession().removeAttribute("__pop_object");
	}
	
}
