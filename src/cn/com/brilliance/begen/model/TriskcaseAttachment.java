package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  定义类TriskcaseAttachment.
     */
public class TriskcaseAttachment extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  字段域id.
     */
    private java.lang.String id;

    /**
     *  字段域riskcaseId.
     */
    private java.lang.String riskcaseId;

    /**
     *  字段域filename.
     */
    private java.lang.String filename;

    /**
     *  字段域content.
     */
    private java.lang.String content;

    /**
     *  字段域sortcode.
     */
    private java.lang.Integer sortcode;

    /**
     *  字段域caseno.
     */
    private java.lang.String caseno;
    
    private java.lang.String userId;

    private java.lang.Boolean submit;

    /**
     *  域riskcaseIdOfTriskcase.
     */
    private Triskcase riskcaseIdOfTriskcase;
    /**
     *  域casenoOfTriskcase.
     */
    private Triskcase casenoOfTriskcase;

	public int get_edit_flag() {
		return _edit_flag;
	}

	public void set_edit_flag(int _edit_flag) {
		this._edit_flag = _edit_flag;
	}

	public int get_record_index() {
		return _record_index;
	}

	public void set_record_index(int index) {
		this._record_index = index;
	}
	
	public boolean is_checked_flag() {
		return _checked_flag;
	}

	public void set_checked_flag(boolean _checked_flag) {
		this._checked_flag = _checked_flag;
	}


    /**
     *  获取 id.
     *  @return java.lang.String.
     */
    public java.lang.String getId() {
        return this.id;
    }

    /**
     *  设置 id.
     *  @param id id域.
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }
    /**
     *  获取 riskcaseId.
     *  @return java.lang.String.
     */
    public java.lang.String getRiskcaseId() {
        return this.riskcaseId;
    }

    /**
     *  设置 riskcaseId.
     *  @param riskcaseId riskcaseId域.
     */
    public void setRiskcaseId(java.lang.String riskcaseId) {
        this.riskcaseId = riskcaseId;
    }
    /**
     *  获取 filename.
     *  @return java.lang.String.
     */
    public java.lang.String getFilename() {
        return this.filename;
    }

    /**
     *  设置 filename.
     *  @param filename filename域.
     */
    public void setFilename(java.lang.String filename) {
        this.filename = filename;
    }
    /**
     *  获取 content.
     *  @return java.lang.String.
     */
    public java.lang.String getContent() {
        return this.content;
    }

    /**
     *  设置 content.
     *  @param content content域.
     */
    public void setContent(java.lang.String content) {
        this.content = content;
    }
    /**
     *  获取 sortcode.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getSortcode() {
        return this.sortcode;
    }

    /**
     *  设置 sortcode.
     *  @param sortcode sortcode域.
     */
    public void setSortcode(java.lang.Integer sortcode) {
        this.sortcode = sortcode;
    }
    /**
     *  获取 caseno.
     *  @return java.lang.String.
     */
    public java.lang.String getCaseno() {
        return this.caseno;
    }

    /**
     *  设置 caseno.
     *  @param caseno caseno域.
     */
    public void setCaseno(java.lang.String caseno) {
        this.caseno = caseno;
    }




    /**
     *  获取 riskcaseIdOfTriskcase.
     *  @return Triskcase.
     */
    public Triskcase getRiskcaseIdOfTriskcase() {
    	if (this.riskcaseIdOfTriskcase == null && this.riskcaseId != null  && !"".equals(this.riskcaseId)){
    		TriskcaseDAO triskcaseDAO = (TriskcaseDAO)Tools.getBean("triskcaseDAO");
    		this.riskcaseIdOfTriskcase= triskcaseDAO.getTriskcase(this.riskcaseId);
    	}
        return this.riskcaseIdOfTriskcase;
    }

    /**
     *  设置 riskcaseIdOfTriskcase.
     *  @param riskcaseIdOfTriskcase riskcaseIdOfTriskcase域.
     */
    public void setRiskcaseIdOfTriskcase(Triskcase riskcaseIdOfTriskcase) {
        this.riskcaseIdOfTriskcase = riskcaseIdOfTriskcase;
    }



    /**
     *  获取 casenoOfTriskcase.
     *  @return Triskcase.
     */
    public Triskcase getCasenoOfTriskcase() {
    	if (this.casenoOfTriskcase == null && this.caseno != null  && !"".equals(this.caseno)){
    		TriskcaseDAO triskcaseDAO = (TriskcaseDAO)Tools.getBean("triskcaseDAO");
    		this.casenoOfTriskcase= triskcaseDAO.getTriskcase(this.caseno);
    	}
        return this.casenoOfTriskcase;
    }

    /**
     *  设置 casenoOfTriskcase.
     *  @param casenoOfTriskcase casenoOfTriskcase域.
     */
    public void setCasenoOfTriskcase(Triskcase casenoOfTriskcase) {
        this.casenoOfTriskcase = casenoOfTriskcase;
    }

	public java.lang.String getUserId() {
		return userId;
	}

	public void setUserId(java.lang.String userId) {
		this.userId = userId;
	}

	public java.lang.Boolean getSubmit() {
		return submit;
	}

	public void setSubmit(java.lang.Boolean submit) {
		this.submit = submit;
	}

}
