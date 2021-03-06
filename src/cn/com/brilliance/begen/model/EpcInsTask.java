package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  ������EpcInsTask.
     */
public class EpcInsTask extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���processInsId.
     */
    private java.lang.String processInsId;

    /**
     *  �ֶ���stateDefId.
     */
    private java.lang.String stateDefId;

    /**
     *  �ֶ���taskTitle.
     */
    private java.lang.String taskTitle;

    /**
     *  �ֶ���operator.
     */
    private java.lang.String operator;

    /**
     *  �ֶ���taskOperator.
     */
    private java.lang.String taskOperator;

    /**
     *  �ֶ���instanceStart.
     */
    private java.util.Date instanceStart;

    /**
     *  �ֶ���instanceEnd.
     */
    private java.util.Date instanceEnd;

    /**
     *  �ֶ���url.
     */
    private java.lang.String url;

/*
1,�
2,����
3,����
*/
    /**
     *  �ֶ���instanceState.
     */
    private java.lang.String instanceState;

    /**
     *  �ֶ���receiptOrg.
     */
    private java.lang.String receiptOrg;

    /**
     *  �ֶ���receiptRole.
     */
    private java.lang.String receiptRole;

    /**
     *  �ֶ���receiptUser.
     */
    private java.lang.String receiptUser;


    /**
     *  ��processInsIdOfEpcInsProc.
     */
    private EpcInsProc processInsIdOfEpcInsProc;

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
     *  ��ȡ processInsId.
     *  @return java.lang.String.
     */
    public java.lang.String getProcessInsId() {
        return this.processInsId;
    }

    /**
     *  ���� processInsId.
     *  @param processInsId processInsId��.
     */
    public void setProcessInsId(java.lang.String processInsId) {
        this.processInsId = processInsId;
    }
    /**
     *  ��ȡ stateDefId.
     *  @return java.lang.String.
     */
    public java.lang.String getStateDefId() {
        return this.stateDefId;
    }

    /**
     *  ���� stateDefId.
     *  @param stateDefId stateDefId��.
     */
    public void setStateDefId(java.lang.String stateDefId) {
        this.stateDefId = stateDefId;
    }
    /**
     *  ��ȡ taskTitle.
     *  @return java.lang.String.
     */
    public java.lang.String getTaskTitle() {
        return this.taskTitle;
    }

    /**
     *  ���� taskTitle.
     *  @param taskTitle taskTitle��.
     */
    public void setTaskTitle(java.lang.String taskTitle) {
        this.taskTitle = taskTitle;
    }
    /**
     *  ��ȡ operator.
     *  @return java.lang.String.
     */
    public java.lang.String getOperator() {
        return this.operator;
    }

    /**
     *  ���� operator.
     *  @param operator operator��.
     */
    public void setOperator(java.lang.String operator) {
        this.operator = operator;
    }
    /**
     *  ��ȡ taskOperator.
     *  @return java.lang.String.
     */
    public java.lang.String getTaskOperator() {
        return this.taskOperator;
    }

    /**
     *  ���� taskOperator.
     *  @param taskOperator taskOperator��.
     */
    public void setTaskOperator(java.lang.String taskOperator) {
        this.taskOperator = taskOperator;
    }
    /**
     *  ��ȡ instanceStart.
     *  @return java.util.Date.
     */
    public java.util.Date getInstanceStart() {
        return this.instanceStart;
    }

    /**
     *  ���� instanceStart.
     *  @param instanceStart instanceStart��.
     */
    public void setInstanceStart(java.util.Date instanceStart) {
        this.instanceStart = instanceStart;
    }
    /**
     *  ��ȡ instanceEnd.
     *  @return java.util.Date.
     */
    public java.util.Date getInstanceEnd() {
        return this.instanceEnd;
    }

    /**
     *  ���� instanceEnd.
     *  @param instanceEnd instanceEnd��.
     */
    public void setInstanceEnd(java.util.Date instanceEnd) {
        this.instanceEnd = instanceEnd;
    }
    /**
     *  ��ȡ url.
     *  @return java.lang.String.
     */
    public java.lang.String getUrl() {
        return this.url;
    }

    /**
     *  ���� url.
     *  @param url url��.
     */
    public void setUrl(java.lang.String url) {
        this.url = url;
    }
    /**
     *  ��ȡ instanceState.
     *  @return java.lang.String.
     */
    public java.lang.String getInstanceState() {
        return this.instanceState;
    }

    /**
     *  ���� instanceState.
     *  @param instanceState instanceState��.
     */
    public void setInstanceState(java.lang.String instanceState) {
        this.instanceState = instanceState;
    }
    /**
     *  ��ȡ receiptOrg.
     *  @return java.lang.String.
     */
    public java.lang.String getReceiptOrg() {
        return this.receiptOrg;
    }

    /**
     *  ���� receiptOrg.
     *  @param receiptOrg receiptOrg��.
     */
    public void setReceiptOrg(java.lang.String receiptOrg) {
        this.receiptOrg = receiptOrg;
    }
    /**
     *  ��ȡ receiptRole.
     *  @return java.lang.String.
     */
    public java.lang.String getReceiptRole() {
        return this.receiptRole;
    }

    /**
     *  ���� receiptRole.
     *  @param receiptRole receiptRole��.
     */
    public void setReceiptRole(java.lang.String receiptRole) {
        this.receiptRole = receiptRole;
    }
    /**
     *  ��ȡ receiptUser.
     *  @return java.lang.String.
     */
    public java.lang.String getReceiptUser() {
        return this.receiptUser;
    }

    /**
     *  ���� receiptUser.
     *  @param receiptUser receiptUser��.
     */
    public void setReceiptUser(java.lang.String receiptUser) {
        this.receiptUser = receiptUser;
    }




    /**
     *  ��ȡ processInsIdOfEpcInsProc.
     *  @return EpcInsProc.
     */
    public EpcInsProc getProcessInsIdOfEpcInsProc() {
    	if (this.processInsIdOfEpcInsProc == null && this.processInsId != null  && !"".equals(this.processInsId)){
    		EpcInsProcDAO epcInsProcDAO = (EpcInsProcDAO)Tools.getBean("epcInsProcDAO");
    		this.processInsIdOfEpcInsProc= epcInsProcDAO.getEpcInsProc(this.processInsId);
    	}
        return this.processInsIdOfEpcInsProc;
    }

    /**
     *  ���� processInsIdOfEpcInsProc.
     *  @param processInsIdOfEpcInsProc processInsIdOfEpcInsProc��.
     */
    public void setProcessInsIdOfEpcInsProc(EpcInsProc processInsIdOfEpcInsProc) {
        this.processInsIdOfEpcInsProc = processInsIdOfEpcInsProc;
    }

}
