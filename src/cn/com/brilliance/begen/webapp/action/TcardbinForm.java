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
 * Tcardbin对象Form.
 * @author Administrator.
 *
 */
public class TcardbinForm extends BasePage implements FormPage {

	private TcardbinService service = (TcardbinService)getBean("tcardbinService");

    private String lookupKey;        
	
    /**
     * tcardbin对象.
     */
    private Tcardbin tcardbin;

    /**
     * Tcardbin对象主键.
     */
    private java.lang.String tcardbinPrimaryKey;
	
	
	public String getLookupKey() {
		return lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}	

    /**
     * Returns the Tcardbin.
     * @return Tcardbin.
     */
    public Tcardbin getTcardbin() {
        if(tcardbin == null) {
            tcardbin = new Tcardbin();
        }
        return tcardbin;
    }

    /**
     * Sets the Tcardbin.
     * @param tcardbin The tcardbin to set.
     */
    public void setTcardbin(Tcardbin tcardbin) {
        this.tcardbin = tcardbin;
    }

    /**
     * Returns the tcardbinPrimaryKey.
     * @return TcardbinPrimaryKey.
     */
    public java.lang.String getTcardbinPrimaryKey() {
        return tcardbinPrimaryKey;
    }

    /**
     * Sets the tcardbinPrimaryKey.
     * @param tcardbinPrimaryKey The TcardbinPrimaryKey to set.
     */
    public void setTcardbinPrimaryKey(java.lang.String tcardbinPrimaryKey) {
		this.tcardbinPrimaryKey = tcardbinPrimaryKey;
		initTcardbin();
    }
	
	public void initTcardbin(){
        try {
            if (tcardbinPrimaryKey == null || tcardbinPrimaryKey.equals("")) {
                return;
            }
            this.setTcardbin(service.getTcardbin(tcardbinPrimaryKey));    
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}	


    /**
     * 存储Tcardbin对象.
     * @return String.
     */
    public String save() {
        try {
            if(this.tcardbin.getId() == null){
                this.tcardbin.setId(getAutoNumberValue("t_cardbin","id","{00000000000}",1));
            }
            if (tcardbinPrimaryKey == null  && this.tcardbin.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTcardbin(this.tcardbin.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.tcardbin.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (tcardbinPrimaryKey == null || tcardbinPrimaryKey.equals(this.tcardbin.getId())) {
            	this.tcardbin = service.saveTcardbin(this.tcardbin);
                String key = tcardbin.getId();
				this.tcardbinPrimaryKey = key;
                if (tcardbinPrimaryKey == null) {
                    addMessage("tcardbin.message.added", this.tcardbin.getId());				
                }
                else {
                    addMessage("tcardbin.message.saved", this.tcardbin.getId());					
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
            Tcardbin tcardbin = new Tcardbin();
            this.tcardbin = tcardbin;
            tcardbinPrimaryKey = null;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return null;
    }
    /**
     * 删除Tcardbin对象.
     * @return String.
     */
    public String delete() {
        try {
            service.delete(this.tcardbin.getId());
			CmsUtil.deleteFile("t_cardbin/"+this.tcardbin.getId());
            addMessage("tcardbin.message.deleted", this.tcardbin.getId());
		
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return getSuccessAction();
    }




    /**
     * 删除Tcardbin对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            Tcardbin tcardbin = service.getTcardbin(this.tcardbin.getId());
            service.delete(this.tcardbin.getId());
            addMessage("tcardbin.message.deleted", this.tcardbin.getId());	
		
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
    	if(this.tcardbinPrimaryKey == null)
    		return "_key=" + this.tcardbin.getId();
    	return "_key=" + this.tcardbinPrimaryKey;
    }
	
	    
    public String popSave(){
    	this.getRequest().getSession().setAttribute("__pop_object", this.tcardbin);
		this.getRequest().getSession().setAttribute("__pop_data_object", "Tcardbin");
		return "popSuccess";
    }
	
    public String saveAll(){
       try {
            if(this.tcardbin.getId() == null){
                this.tcardbin.setId(getAutoNumberValue("t_cardbin","id","{00000000000}",1));
            }
            if (tcardbinPrimaryKey == null  && this.tcardbin.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTcardbin(this.tcardbin.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.tcardbin.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (tcardbinPrimaryKey == null || tcardbinPrimaryKey.equals(this.tcardbin.getId())) {
  
                this.tcardbin = service.saveAll(this.tcardbin);
                String key = tcardbin.getId();
				this.tcardbinPrimaryKey = key;
                if (tcardbinPrimaryKey == null) {
                    addMessage("tcardbin.message.added", this.tcardbin.getId());				
                }
                else {
                    addMessage("tcardbin.message.saved", this.tcardbin.getId());					
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
            if(this.tcardbin.getId() == null){
                this.tcardbin.setId(getAutoNumberValue("t_cardbin","id","{00000000000}",1));
            }
            if (tcardbinPrimaryKey == null  && this.tcardbin.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTcardbin(this.tcardbin.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.tcardbin.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (tcardbinPrimaryKey == null || tcardbinPrimaryKey.equals(this.tcardbin.getId())) {
                this.tcardbin = service.saveAll(this.tcardbin);

                String key = tcardbin.getId();
				this.tcardbinPrimaryKey = key;
                if (tcardbinPrimaryKey == null) {
                    addMessage("tcardbin.message.added", this.tcardbin.getId());				
                }
                else {
                    addMessage("tcardbin.message.saved", this.tcardbin.getId());					
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
	

	public void loadTcardbin(){	
		Tcardbin tcardbin = (Tcardbin)this.getRequest().getSession().getAttribute("__pop_object");
		this.tcardbin = tcardbin;
		this.getRequest().getSession().removeAttribute("__pop_object");
	}
	
}
