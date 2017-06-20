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
 * TriskcaseRulegroup对象Form.
 * @author Administrator.
 *
 */
public class TriskcaseRulegroupForm extends BasePage implements FormPage {

	private TriskcaseRulegroupService service = (TriskcaseRulegroupService)getBean("triskcaseRulegroupService");

    private String lookupKey;        
	
    /**
     * triskcaseRulegroup对象.
     */
    private TriskcaseRulegroup triskcaseRulegroup;

    /**
     * TriskcaseRulegroup对象主键.
     */
    private java.lang.String triskcaseRulegroupPrimaryKey;
	
	
	public String getLookupKey() {
		return lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}	

    /**
     * Returns the TriskcaseRulegroup.
     * @return TriskcaseRulegroup.
     */
    public TriskcaseRulegroup getTriskcaseRulegroup() {
        if(triskcaseRulegroup == null) {
            triskcaseRulegroup = new TriskcaseRulegroup();
        }
        return triskcaseRulegroup;
    }

    /**
     * Sets the TriskcaseRulegroup.
     * @param triskcaseRulegroup The triskcaseRulegroup to set.
     */
    public void setTriskcaseRulegroup(TriskcaseRulegroup triskcaseRulegroup) {
        this.triskcaseRulegroup = triskcaseRulegroup;
    }

    /**
     * Returns the triskcaseRulegroupPrimaryKey.
     * @return TriskcaseRulegroupPrimaryKey.
     */
    public java.lang.String getTriskcaseRulegroupPrimaryKey() {
        return triskcaseRulegroupPrimaryKey;
    }

    /**
     * Sets the triskcaseRulegroupPrimaryKey.
     * @param triskcaseRulegroupPrimaryKey The TriskcaseRulegroupPrimaryKey to set.
     */
    public void setTriskcaseRulegroupPrimaryKey(java.lang.String triskcaseRulegroupPrimaryKey) {
		this.triskcaseRulegroupPrimaryKey = triskcaseRulegroupPrimaryKey;
		initTriskcaseRulegroup();
    }
	
	public void initTriskcaseRulegroup(){
        try {
            if (triskcaseRulegroupPrimaryKey == null || triskcaseRulegroupPrimaryKey.equals("")) {
                return;
            }
            this.setTriskcaseRulegroup(service.getTriskcaseRulegroup(triskcaseRulegroupPrimaryKey));    
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}	


    /**
     * 存储TriskcaseRulegroup对象.
     * @return String.
     */
    public String save() {
        try {
            if(this.triskcaseRulegroup.getId() == null){
                this.triskcaseRulegroup.setId(getAutoNumberValue("t_riskcase_rulegroup","id","{00000000000}",1));
            }
            if (triskcaseRulegroupPrimaryKey == null  && this.triskcaseRulegroup.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTriskcaseRulegroup(this.triskcaseRulegroup.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.triskcaseRulegroup.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (triskcaseRulegroupPrimaryKey == null || triskcaseRulegroupPrimaryKey.equals(this.triskcaseRulegroup.getId())) {
            	this.triskcaseRulegroup = service.saveTriskcaseRulegroup(this.triskcaseRulegroup);
                String key = triskcaseRulegroup.getId();
				this.triskcaseRulegroupPrimaryKey = key;
                if (triskcaseRulegroupPrimaryKey == null) {
                    addMessage("triskcaseRulegroup.message.added", this.triskcaseRulegroup.getId());				
                }
                else {
                    addMessage("triskcaseRulegroup.message.saved", this.triskcaseRulegroup.getId());					
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
            TriskcaseRulegroup triskcaseRulegroup = new TriskcaseRulegroup();
            this.triskcaseRulegroup = triskcaseRulegroup;
            triskcaseRulegroupPrimaryKey = null;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return null;
    }
    /**
     * 删除TriskcaseRulegroup对象.
     * @return String.
     */
    public String delete() {
        try {
            service.delete(this.triskcaseRulegroup.getId());
			CmsUtil.deleteFile("t_riskcase_rulegroup/"+this.triskcaseRulegroup.getId());
            addMessage("triskcaseRulegroup.message.deleted", this.triskcaseRulegroup.getId());
		
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return getSuccessAction();
    }




    /**
     * 删除TriskcaseRulegroup对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            TriskcaseRulegroup triskcaseRulegroup = service.getTriskcaseRulegroup(this.triskcaseRulegroup.getId());
            service.delete(this.triskcaseRulegroup.getId());
            addMessage("triskcaseRulegroup.message.deleted", this.triskcaseRulegroup.getId());	
		
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
    	if(this.triskcaseRulegroupPrimaryKey == null)
    		return "_key=" + this.triskcaseRulegroup.getId();
    	return "_key=" + this.triskcaseRulegroupPrimaryKey;
    }
	
	    
    public String popSave(){
    	this.getRequest().getSession().setAttribute("__pop_object", this.triskcaseRulegroup);
		this.getRequest().getSession().setAttribute("__pop_data_object", "TriskcaseRulegroup");
		return "popSuccess";
    }
	
    public String saveAll(){
       try {
            if(this.triskcaseRulegroup.getId() == null){
                this.triskcaseRulegroup.setId(getAutoNumberValue("t_riskcase_rulegroup","id","{00000000000}",1));
            }
            if (triskcaseRulegroupPrimaryKey == null  && this.triskcaseRulegroup.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTriskcaseRulegroup(this.triskcaseRulegroup.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.triskcaseRulegroup.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (triskcaseRulegroupPrimaryKey == null || triskcaseRulegroupPrimaryKey.equals(this.triskcaseRulegroup.getId())) {
  
                this.triskcaseRulegroup = service.saveAll(this.triskcaseRulegroup);
                String key = triskcaseRulegroup.getId();
				this.triskcaseRulegroupPrimaryKey = key;
                if (triskcaseRulegroupPrimaryKey == null) {
                    addMessage("triskcaseRulegroup.message.added", this.triskcaseRulegroup.getId());				
                }
                else {
                    addMessage("triskcaseRulegroup.message.saved", this.triskcaseRulegroup.getId());					
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
            if(this.triskcaseRulegroup.getId() == null){
                this.triskcaseRulegroup.setId(getAutoNumberValue("t_riskcase_rulegroup","id","{00000000000}",1));
            }
            if (triskcaseRulegroupPrimaryKey == null  && this.triskcaseRulegroup.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTriskcaseRulegroup(this.triskcaseRulegroup.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.triskcaseRulegroup.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (triskcaseRulegroupPrimaryKey == null || triskcaseRulegroupPrimaryKey.equals(this.triskcaseRulegroup.getId())) {
                this.triskcaseRulegroup = service.saveAll(this.triskcaseRulegroup);

                String key = triskcaseRulegroup.getId();
				this.triskcaseRulegroupPrimaryKey = key;
                if (triskcaseRulegroupPrimaryKey == null) {
                    addMessage("triskcaseRulegroup.message.added", this.triskcaseRulegroup.getId());				
                }
                else {
                    addMessage("triskcaseRulegroup.message.saved", this.triskcaseRulegroup.getId());					
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
	

	public void loadTriskcaseRulegroup(){	
		TriskcaseRulegroup triskcaseRulegroup = (TriskcaseRulegroup)this.getRequest().getSession().getAttribute("__pop_object");
		this.triskcaseRulegroup = triskcaseRulegroup;
		this.getRequest().getSession().removeAttribute("__pop_object");
	}
	
}
