package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  ������TriskcaseAttachment.
     */
public class TriskcaseAttachment extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���riskcaseId.
     */
    private java.lang.String riskcaseId;

    /**
     *  �ֶ���filename.
     */
    private java.lang.String filename;

    /**
     *  �ֶ���content.
     */
    private java.lang.String content;

    /**
     *  �ֶ���sortcode.
     */
    private java.lang.Integer sortcode;

    /**
     *  �ֶ���caseno.
     */
    private java.lang.String caseno;
    
    private java.lang.String userId;

    private java.lang.Boolean submit;

    /**
     *  ��riskcaseIdOfTriskcase.
     */
    private Triskcase riskcaseIdOfTriskcase;
    /**
     *  ��casenoOfTriskcase.
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
     *  ��ȡ id.
     *  @return java.lang.String.
     */
    public java.lang.String getId() {
        return this.id;
    }

    /**
     *  ���� id.
     *  @param id id��.
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }
    /**
     *  ��ȡ riskcaseId.
     *  @return java.lang.String.
     */
    public java.lang.String getRiskcaseId() {
        return this.riskcaseId;
    }

    /**
     *  ���� riskcaseId.
     *  @param riskcaseId riskcaseId��.
     */
    public void setRiskcaseId(java.lang.String riskcaseId) {
        this.riskcaseId = riskcaseId;
    }
    /**
     *  ��ȡ filename.
     *  @return java.lang.String.
     */
    public java.lang.String getFilename() {
        return this.filename;
    }

    /**
     *  ���� filename.
     *  @param filename filename��.
     */
    public void setFilename(java.lang.String filename) {
        this.filename = filename;
    }
    /**
     *  ��ȡ content.
     *  @return java.lang.String.
     */
    public java.lang.String getContent() {
        return this.content;
    }

    /**
     *  ���� content.
     *  @param content content��.
     */
    public void setContent(java.lang.String content) {
        this.content = content;
    }
    /**
     *  ��ȡ sortcode.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getSortcode() {
        return this.sortcode;
    }

    /**
     *  ���� sortcode.
     *  @param sortcode sortcode��.
     */
    public void setSortcode(java.lang.Integer sortcode) {
        this.sortcode = sortcode;
    }
    /**
     *  ��ȡ caseno.
     *  @return java.lang.String.
     */
    public java.lang.String getCaseno() {
        return this.caseno;
    }

    /**
     *  ���� caseno.
     *  @param caseno caseno��.
     */
    public void setCaseno(java.lang.String caseno) {
        this.caseno = caseno;
    }




    /**
     *  ��ȡ riskcaseIdOfTriskcase.
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
     *  ���� riskcaseIdOfTriskcase.
     *  @param riskcaseIdOfTriskcase riskcaseIdOfTriskcase��.
     */
    public void setRiskcaseIdOfTriskcase(Triskcase riskcaseIdOfTriskcase) {
        this.riskcaseIdOfTriskcase = riskcaseIdOfTriskcase;
    }



    /**
     *  ��ȡ casenoOfTriskcase.
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
     *  ���� casenoOfTriskcase.
     *  @param casenoOfTriskcase casenoOfTriskcase��.
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
