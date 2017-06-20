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
 * TorganizeInfo对象Form.
 * @author Administrator.
 *
 */
public class TorganizeInfoForm extends BasePage implements FormPage {

	private TorganizeInfoService service = (TorganizeInfoService)getBean("torganizeInfoService");

    private String lookupKey;        
	
    /**
     * torganizeInfo对象.
     */
    private TorganizeInfo torganizeInfo;

    /**
     * TorganizeInfo对象主键.
     */
    private java.lang.String torganizeInfoPrimaryKey;
	
	
	public String getLookupKey() {
		return lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}	

    /**
     * Returns the TorganizeInfo.
     * @return TorganizeInfo.
     */
    public TorganizeInfo getTorganizeInfo() {
        if(torganizeInfo == null) {
            torganizeInfo = new TorganizeInfo();
        }
        return torganizeInfo;
    }

    /**
     * Sets the TorganizeInfo.
     * @param torganizeInfo The torganizeInfo to set.
     */
    public void setTorganizeInfo(TorganizeInfo torganizeInfo) {
        this.torganizeInfo = torganizeInfo;
    }

    /**
     * Returns the torganizeInfoPrimaryKey.
     * @return TorganizeInfoPrimaryKey.
     */
    public java.lang.String getTorganizeInfoPrimaryKey() {
        return torganizeInfoPrimaryKey;
    }

    /**
     * Sets the torganizeInfoPrimaryKey.
     * @param torganizeInfoPrimaryKey The TorganizeInfoPrimaryKey to set.
     */
    public void setTorganizeInfoPrimaryKey(java.lang.String torganizeInfoPrimaryKey) {
		this.torganizeInfoPrimaryKey = torganizeInfoPrimaryKey;
		initTorganizeInfo();
    }
	
	public void initTorganizeInfo(){
        try {
            if (torganizeInfoPrimaryKey == null || torganizeInfoPrimaryKey.equals("")) {
                return;
            }
            this.setTorganizeInfo(service.getTorganizeInfo(torganizeInfoPrimaryKey));    
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}	

    public String loadChildOfTmchntApp() {
        try {
            TmchntAppList tmchntAppList = new TmchntAppList();            
			if(torganizeInfo.getId() != null && !"".equals(torganizeInfo.getId()) ){
			   TmchntApp tmchntApp = new TmchntApp();
	           tmchntApp.setBelongToInst(this.torganizeInfo.getId());
	           tmchntAppList.setTmchntApp(tmchntApp);
			   tmchntAppList.initTmchntApps();
            }
			else{
			   TmchntApp tmchntApp = new TmchntApp();
	           tmchntAppList.setTmchntApp(tmchntApp);
               tmchntAppList.setTmchntApps(new ArrayList<TmchntApp>());				
			}
            this.setValueBinding("#{tmchntAppList}",tmchntAppList);
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
        return null;
    }
    public String loadChildOfTriskprocessTimelimit() {
        try {
            TriskprocessTimelimitList triskprocessTimelimitList = new TriskprocessTimelimitList();            
			if(torganizeInfo.getId() != null && !"".equals(torganizeInfo.getId()) ){
			   TriskprocessTimelimit triskprocessTimelimit = new TriskprocessTimelimit();
	           triskprocessTimelimit.setBelongToInst(this.torganizeInfo.getId());
	           triskprocessTimelimitList.setTriskprocessTimelimit(triskprocessTimelimit);
			   triskprocessTimelimitList.initTriskprocessTimelimits();
            }
			else{
			   TriskprocessTimelimit triskprocessTimelimit = new TriskprocessTimelimit();
	           triskprocessTimelimitList.setTriskprocessTimelimit(triskprocessTimelimit);
               triskprocessTimelimitList.setTriskprocessTimelimits(new ArrayList<TriskprocessTimelimit>());				
			}
            this.setValueBinding("#{triskprocessTimelimitList}",triskprocessTimelimitList);
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
        return null;
    }

    /**
     * 存储TorganizeInfo对象.
     * @return String.
     */
    public String save() {
        try {
            if(this.torganizeInfo.getId() == null){
                this.torganizeInfo.setId(getAutoNumberValue("t_organize_info","id","{000000000000}",1));
            }
            if (torganizeInfoPrimaryKey == null  && this.torganizeInfo.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTorganizeInfo(this.torganizeInfo.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.torganizeInfo.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (torganizeInfoPrimaryKey == null || torganizeInfoPrimaryKey.equals(this.torganizeInfo.getId())) {
            	this.torganizeInfo = service.saveTorganizeInfo(this.torganizeInfo);
                String key = torganizeInfo.getId();
				this.torganizeInfoPrimaryKey = key;
                if (torganizeInfoPrimaryKey == null) {
                    addMessage("torganizeInfo.message.added", this.torganizeInfo.getName());				
                }
                else {
                    addMessage("torganizeInfo.message.saved", this.torganizeInfo.getName());					
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
            TorganizeInfo torganizeInfo = new TorganizeInfo();
            this.torganizeInfo = torganizeInfo;
            torganizeInfoPrimaryKey = null;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return null;
    }
    /**
     * 删除TorganizeInfo对象.
     * @return String.
     */
    public String delete() {
        try {
            service.delete(this.torganizeInfo.getId());
			CmsUtil.deleteFile("t_organize_info/"+this.torganizeInfo.getId());
            addMessage("torganizeInfo.message.deleted", this.torganizeInfo.getName());
		
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return getSuccessAction();
    }




    /**
     * 删除TorganizeInfo对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            TorganizeInfo torganizeInfo = service.getTorganizeInfo(this.torganizeInfo.getId());
            if (torganizeInfo.getTmchntAppGroup().size() > 0) {
                this.addMessageString("exception.delete.cascade");
                return getFailureAction();
            }
            if (torganizeInfo.getTriskprocessTimelimitGroup().size() > 0) {
                this.addMessageString("exception.delete.cascade");
                return getFailureAction();
            }
            service.delete(this.torganizeInfo.getId());
            addMessage("torganizeInfo.message.deleted", this.torganizeInfo.getName());	
		
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
    	if(this.torganizeInfoPrimaryKey == null)
    		return "_key=" + this.torganizeInfo.getId();
    	return "_key=" + this.torganizeInfoPrimaryKey;
    }
	
	    
    public String popSave(){
    	this.getRequest().getSession().setAttribute("__pop_object", this.torganizeInfo);
		this.getRequest().getSession().setAttribute("__pop_data_object", "TorganizeInfo");
		return "popSuccess";
    }
	
    public String saveAll(){
       try {
            if(this.torganizeInfo.getId() == null){
                this.torganizeInfo.setId(getAutoNumberValue("t_organize_info","id","{000000000000}",1));
            }
            if (torganizeInfoPrimaryKey == null  && this.torganizeInfo.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTorganizeInfo(this.torganizeInfo.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.torganizeInfo.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (torganizeInfoPrimaryKey == null || torganizeInfoPrimaryKey.equals(this.torganizeInfo.getId())) {
  
    	TmchntAppList tmchntAppList = (TmchntAppList)this.getValueBinding("#{tmchntAppList}");	
    	TriskprocessTimelimitList triskprocessTimelimitList = (TriskprocessTimelimitList)this.getValueBinding("#{triskprocessTimelimitList}");	
                this.torganizeInfo = service.saveAll(this.torganizeInfo,tmchntAppList.getDeleteList(),tmchntAppList.getTmchntApps(),triskprocessTimelimitList.getDeleteList(),triskprocessTimelimitList.getTriskprocessTimelimits());
                String key = torganizeInfo.getId();
				this.torganizeInfoPrimaryKey = key;
                if (torganizeInfoPrimaryKey == null) {
                    addMessage("torganizeInfo.message.added", this.torganizeInfo.getName());				
                }
                else {
                    addMessage("torganizeInfo.message.saved", this.torganizeInfo.getName());					
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
            if(this.torganizeInfo.getId() == null){
                this.torganizeInfo.setId(getAutoNumberValue("t_organize_info","id","{000000000000}",1));
            }
            if (torganizeInfoPrimaryKey == null  && this.torganizeInfo.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTorganizeInfo(this.torganizeInfo.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.torganizeInfo.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (torganizeInfoPrimaryKey == null || torganizeInfoPrimaryKey.equals(this.torganizeInfo.getId())) {
        TmchntAppList tmchntAppList = (TmchntAppList)this.getValueBinding("#{tmchntAppList}");
        List<TmchntApp> tmchntApps = tmchntAppList.getTmchntApps();			
    	List<TmchntApp> tmchntAppLists = new ArrayList<TmchntApp>();
    	for(TmchntApp tmchntApp : tmchntApps){
    		if(tmchntApp.get_edit_flag() != TmchntApp.EDIT_FLAG_EDIT){
    			tmchntApp.set_edit_flag(TmchntApp.EDIT_FLAG_EDIT);    			
    		}
    		tmchntAppLists.add(tmchntApp);
    	}

        TriskprocessTimelimitList triskprocessTimelimitList = (TriskprocessTimelimitList)this.getValueBinding("#{triskprocessTimelimitList}");
        List<TriskprocessTimelimit> triskprocessTimelimits = triskprocessTimelimitList.getTriskprocessTimelimits();			
    	List<TriskprocessTimelimit> triskprocessTimelimitLists = new ArrayList<TriskprocessTimelimit>();
    	for(TriskprocessTimelimit triskprocessTimelimit : triskprocessTimelimits){
    		if(triskprocessTimelimit.get_edit_flag() != TriskprocessTimelimit.EDIT_FLAG_EDIT){
    			triskprocessTimelimit.set_edit_flag(TriskprocessTimelimit.EDIT_FLAG_EDIT);    			
    		}
    		triskprocessTimelimitLists.add(triskprocessTimelimit);
    	}

                this.torganizeInfo = service.saveAll(this.torganizeInfo,tmchntAppList.getDeleteList(),tmchntAppLists,triskprocessTimelimitList.getDeleteList(),triskprocessTimelimitLists);

                String key = torganizeInfo.getId();
				this.torganizeInfoPrimaryKey = key;
                if (torganizeInfoPrimaryKey == null) {
                    addMessage("torganizeInfo.message.added", this.torganizeInfo.getName());				
                }
                else {
                    addMessage("torganizeInfo.message.saved", this.torganizeInfo.getName());					
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
	
	private void saveTmchntApp(){
    	TmchntAppList tmchntAppList = (TmchntAppList)this.getValueBinding("#{tmchntAppList}");
    	tmchntAppList.saveAllOfTorganizeInfo(torganizeInfo.getId());
    }	
	private void saveTriskprocessTimelimit(){
    	TriskprocessTimelimitList triskprocessTimelimitList = (TriskprocessTimelimitList)this.getValueBinding("#{triskprocessTimelimitList}");
    	triskprocessTimelimitList.saveAllOfTorganizeInfo(torganizeInfo.getId());
    }	

	public void loadTorganizeInfo(){	
		TorganizeInfo torganizeInfo = (TorganizeInfo)this.getRequest().getSession().getAttribute("__pop_object");
		this.torganizeInfo = torganizeInfo;
		this.getRequest().getSession().removeAttribute("__pop_object");
	}
	
}
