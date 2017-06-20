package cn.com.brilliance.begen.webapp.action;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Date;
import org.apache.myfaces.custom.fileupload.UploadedFile;

import cn.com.brilliance.begen.dao.TorganizeInfoDAO;
import cn.com.brilliance.begen.dao.TuserInfoDAO;
import cn.com.brilliance.begen.exception.BeGenException;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;
import cn.com.brilliance.begen.webapp.action.BasePage;
import cn.com.brilliance.begen.webapp.servlet.UserBean;
import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.webapp.action.FormPage;

/**
 * TriskcaseAttachment对象Form.
 * @author Administrator.
 *
 */
public class TriskcaseAttachmentForm extends BasePage implements FormPage {

	private TriskcaseAttachmentService service = (TriskcaseAttachmentService)getBean("triskcaseAttachmentService");

    private String lookupKey;        
	
    /**
     * triskcaseAttachment对象.
     */
    private TriskcaseAttachment triskcaseAttachment;
    
    private Map queryFields;

    /**
     * TriskcaseAttachment对象主键.
     */
    private java.lang.String triskcaseAttachmentPrimaryKey;
	
	
	public String getLookupKey() {
		return lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}	

    /**
     * Returns the TriskcaseAttachment.
     * @return TriskcaseAttachment.
     */
    public TriskcaseAttachment getTriskcaseAttachment() {
        if(triskcaseAttachment == null) {
            triskcaseAttachment = new TriskcaseAttachment();
        }
        return triskcaseAttachment;
    }

    /**
     * Sets the TriskcaseAttachment.
     * @param triskcaseAttachment The triskcaseAttachment to set.
     */
    public void setTriskcaseAttachment(TriskcaseAttachment triskcaseAttachment) {
        this.triskcaseAttachment = triskcaseAttachment;
    }

    /**
     * Returns the triskcaseAttachmentPrimaryKey.
     * @return TriskcaseAttachmentPrimaryKey.
     */
    public java.lang.String getTriskcaseAttachmentPrimaryKey() {
        return triskcaseAttachmentPrimaryKey;
    }

    /**
     * Sets the triskcaseAttachmentPrimaryKey.
     * @param triskcaseAttachmentPrimaryKey The TriskcaseAttachmentPrimaryKey to set.
     */
    public void setTriskcaseAttachmentPrimaryKey(java.lang.String triskcaseAttachmentPrimaryKey) {
		this.triskcaseAttachmentPrimaryKey = triskcaseAttachmentPrimaryKey;
		initTriskcaseAttachment();
    }
	
	public void initTriskcaseAttachment(){
        try {
            if (triskcaseAttachmentPrimaryKey == null || triskcaseAttachmentPrimaryKey.equals("")) {
                return;
            }
            this.setTriskcaseAttachment(service.getTriskcaseAttachment(triskcaseAttachmentPrimaryKey));    
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}	


    private UploadedFile filename_File;

    public UploadedFile getFilename_File() {
        return filename_File;
    }

    public void setFilename_File(UploadedFile filename_File) {
        this.filename_File = filename_File;
    }
    /**
     * 存储TriskcaseAttachment对象.
     * @return String.
     */
    public String save() {
        try {
            if(this.triskcaseAttachment.getId() == null){
                this.triskcaseAttachment.setId(getAutoNumberValue("t_riskcase_attachment","id","{0000000000}",1));
            }
            if (triskcaseAttachmentPrimaryKey == null  && this.triskcaseAttachment.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTriskcaseAttachment(this.triskcaseAttachment.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.triskcaseAttachment.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (triskcaseAttachmentPrimaryKey == null || triskcaseAttachmentPrimaryKey.equals(this.triskcaseAttachment.getId())) {
            	this.triskcaseAttachment = service.saveTriskcaseAttachment(this.triskcaseAttachment);
                String key = triskcaseAttachment.getId();
				this.triskcaseAttachmentPrimaryKey = key;
                if (this.filename_File != null) {
                    CmsUtil.saveUploadedFile("t_riskcase_attachment/"+this.triskcaseAttachment.getId()+"/filename",this.filename_File);
                    this.triskcaseAttachment.setFilename(CmsUtil.getUploadedFileName(this.filename_File));
                    TuserInfo tuserInfo = userBean.getTuserInfo();
                    this.triskcaseAttachment.setUserId(tuserInfo.getId());
                    this.triskcaseAttachment = service.saveTriskcaseAttachment(this.triskcaseAttachment);
                }
                if (triskcaseAttachmentPrimaryKey == null) {
                    addMessage("triskcaseAttachment.message.added", this.triskcaseAttachment.getId());				
                }
                else {
                    addMessage("triskcaseAttachment.message.saved", this.triskcaseAttachment.getId());					
                }
                this.setValueBinding("#{triskcaseForm.triskcasePrimaryKey}", this.triskcaseAttachment.getRiskcaseId());
                this.setValueBinding("#{triskcaseForm.queryFields}", this.queryFields);
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
            TriskcaseAttachment triskcaseAttachment = new TriskcaseAttachment();
            triskcaseAttachment.setRiskcaseId(this.triskcaseAttachment.getRiskcaseId());
            this.triskcaseAttachment = triskcaseAttachment;
            triskcaseAttachmentPrimaryKey = null;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return null;
    }
    /**
     * 删除TriskcaseAttachment对象.
     * @return String.
     */
    public String delete() {
        try {
            String uploadUserId = triskcaseAttachment.getUserId();
            UserBean userBean = getUserBean();
            TuserInfo tuserInfo = userBean.getTuserInfo();
            String currentOrganizeId = tuserInfo.getOrganizeId();
            if(triskcaseAttachment.getSubmit() != null) {
                if (getOrganizeValue(uploadUserId, currentOrganizeId) == 0
    					&& triskcaseAttachment.getSubmit()) {
    				this.addMessageString("您不能删除已提交的附件!");
    				return null;
    			} else if(getOrganizeValue(uploadUserId, currentOrganizeId) == -1) {
    				this.addMessageString("您无权删除上级机构上传的附件!");
    				return null;
    			}
            }
            service.delete(this.triskcaseAttachment.getId());
			CmsUtil.deleteFile("t_riskcase_attachment/"+this.triskcaseAttachment.getId());
            addMessage("triskcaseAttachment.message.deleted", this.triskcaseAttachment.getId());
		
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return getSuccessAction();
    }

    public String deleteFilenameFile() {

        TriskcaseAttachmentForm triskcaseAttachmentForm = (TriskcaseAttachmentForm)this.getValueBinding("#{triskcaseAttachmentForm}");
        TriskcaseAttachment triskcaseAttachment=service.getTriskcaseAttachment(triskcaseAttachmentForm.getTriskcaseAttachment().getId());
        CmsUtil.deleteFile("t_riskcase_attachment/"+this.triskcaseAttachment.getId()+"/filename");
        triskcaseAttachment.setFilename(null);
        triskcaseAttachmentForm.getTriskcaseAttachment().setFilename(null);
        service.saveTriskcaseAttachment(triskcaseAttachment);
        return null;
    }



    /**
     * 删除TriskcaseAttachment对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            TriskcaseAttachment triskcaseAttachment = service.getTriskcaseAttachment(this.triskcaseAttachment.getId());
            service.delete(this.triskcaseAttachment.getId());
            addMessage("triskcaseAttachment.message.deleted", this.triskcaseAttachment.getId());	
		
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return getSuccessAction();
    }
	
    public String edit(){
        String uploadUserId = triskcaseAttachment.getUserId();
        UserBean userBean = getUserBean();
        TuserInfo tuserInfo = userBean.getTuserInfo();
        String currentOrganizeId = tuserInfo.getOrganizeId();
        Integer currentLevel = this.getOrganizeLevel(currentOrganizeId);
        if(triskcaseAttachment.getSubmit() != null) {
            if (getOrganizeValue(uploadUserId, currentOrganizeId) == 0
					&& triskcaseAttachment.getSubmit() && currentLevel.intValue() != 1) {
				this.addMessageString("您不能编辑已提交的附件!");
				return null;
			} else if(getOrganizeValue(uploadUserId, currentOrganizeId) == -1) {
				this.addMessageString("您无权编辑上级机构上传的附件!");
				return null;
			}
        }
    	return getSuccessAction();
    }	

    public String getHistoryUrlParameter(){
    	if(this.triskcaseAttachmentPrimaryKey == null)
    		return "_key=" + this.triskcaseAttachment.getId();
    	return "_key=" + this.triskcaseAttachmentPrimaryKey;
    }
	
	    
    public String popSave(){
    	this.getRequest().getSession().setAttribute("__pop_object", this.triskcaseAttachment);
		this.getRequest().getSession().setAttribute("__pop_data_object", "TriskcaseAttachment");
		return "popSuccess";
    }
	
    public String saveAll(){
       try {
            if(this.triskcaseAttachment.getId() == null){
                this.triskcaseAttachment.setId(getAutoNumberValue("t_riskcase_attachment","id","{0000000000}",1));
            }
            if (triskcaseAttachmentPrimaryKey == null  && this.triskcaseAttachment.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTriskcaseAttachment(this.triskcaseAttachment.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.triskcaseAttachment.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (triskcaseAttachmentPrimaryKey == null || triskcaseAttachmentPrimaryKey.equals(this.triskcaseAttachment.getId())) {
  
                this.triskcaseAttachment = service.saveAll(this.triskcaseAttachment);
                String key = triskcaseAttachment.getId();
				this.triskcaseAttachmentPrimaryKey = key;
                if (this.filename_File != null) {
                    CmsUtil.saveUploadedFile("t_riskcase_attachment/"+this.triskcaseAttachment.getId()+"/filename",this.filename_File);
                    this.triskcaseAttachment.setFilename(CmsUtil.getUploadedFileName(this.filename_File));
                    this.triskcaseAttachment = service.saveTriskcaseAttachment(this.triskcaseAttachment);
                }
                if (triskcaseAttachmentPrimaryKey == null) {
                    addMessage("triskcaseAttachment.message.added", this.triskcaseAttachment.getId());				
                }
                else {
                    addMessage("triskcaseAttachment.message.saved", this.triskcaseAttachment.getId());					
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
            if(this.triskcaseAttachment.getId() == null){
                this.triskcaseAttachment.setId(getAutoNumberValue("t_riskcase_attachment","id","{0000000000}",1));
            }
            if (triskcaseAttachmentPrimaryKey == null  && this.triskcaseAttachment.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTriskcaseAttachment(this.triskcaseAttachment.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.triskcaseAttachment.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (triskcaseAttachmentPrimaryKey == null || triskcaseAttachmentPrimaryKey.equals(this.triskcaseAttachment.getId())) {
                this.triskcaseAttachment = service.saveAll(this.triskcaseAttachment);

                String key = triskcaseAttachment.getId();
				this.triskcaseAttachmentPrimaryKey = key;
                if (this.filename_File != null) {
                    CmsUtil.saveUploadedFile("t_riskcase_attachment/"+this.triskcaseAttachment.getId()+"/filename",this.filename_File);
                    this.triskcaseAttachment.setFilename(CmsUtil.getUploadedFileName(this.filename_File));
                    this.triskcaseAttachment = service.saveTriskcaseAttachment(this.triskcaseAttachment);
                }
                if (triskcaseAttachmentPrimaryKey == null) {
                    addMessage("triskcaseAttachment.message.added", this.triskcaseAttachment.getId());				
                }
                else {
                    addMessage("triskcaseAttachment.message.saved", this.triskcaseAttachment.getId());					
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
	

	public void loadTriskcaseAttachment(){	
		TriskcaseAttachment triskcaseAttachment = (TriskcaseAttachment)this.getRequest().getSession().getAttribute("__pop_object");
		this.triskcaseAttachment = triskcaseAttachment;
		this.getRequest().getSession().removeAttribute("__pop_object");
	}

	private int getOrganizeValue(String userId,String currentOrganizeId) {
		TuserInfoDAO tuserInfoDAO = (TuserInfoDAO)getBean("tuserInfoDAO");
		TuserInfo tuserInfo = tuserInfoDAO.getTuserInfo(userId);
		String uploadOrganizeId = tuserInfo.getOrganizeId();
		Integer currentLevel = getOrganizeLevel(currentOrganizeId);
		Integer uploadLevel = getOrganizeLevel(uploadOrganizeId);
		if(currentLevel.compareTo(uploadLevel) == -1) {
			return 1;
		} else if(currentLevel.compareTo(uploadLevel) == 0) {
			return 0;
		} else {
			return -1;
		}
	}
	
	private Integer getOrganizeLevel(String organizeId) {
		TorganizeInfoDAO torganizeInfoDAO = (TorganizeInfoDAO)getBean("torganizeInfoDAO");
		TorganizeInfo torganizeInfo = torganizeInfoDAO.getTorganizeInfo(organizeId);
		return torganizeInfo.getOrganizeLevel();
	}
	
	public String back() {
		this.setValueBinding("#{triskcaseForm.queryFields}", this.queryFields);
		this.setValueBinding("#{triskcaseForm.triskcasePrimaryKey}", this.triskcaseAttachment.getRiskcaseId());
		return this.getSuccessAction();
	}

	public Map getQueryFields() {
		return queryFields;
	}

	public void setQueryFields(Map queryFields) {
		this.queryFields = queryFields;
	}
}
