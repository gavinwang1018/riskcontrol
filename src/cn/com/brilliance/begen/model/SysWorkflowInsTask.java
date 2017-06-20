package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  定义类SysWorkflowInsTask.
     */
public class SysWorkflowInsTask extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  字段域id.
     */
    private java.lang.String id;

    /**
     *  字段域operator.
     */
    private java.lang.String operator;

    /**
     *  字段域taskOperator.
     */
    private java.lang.String taskOperator;

    /**
     *  字段域instanceStart.
     */
    private java.util.Date instanceStart;

    /**
     *  字段域instanceEnd.
     */
    private java.util.Date instanceEnd;

/*
0,活动
1,打回
2,结束
*/
    /**
     *  字段域instanceState.
     */
    private java.lang.String instanceState;

    /**
     *  字段域receiptOrg.
     */
    private java.lang.String receiptOrg;

    /**
     *  字段域receiptRole.
     */
    private java.lang.String receiptRole;

    /**
     *  字段域receiptUser.
     */
    private java.lang.String receiptUser;

    /**
     *  字段域processInsId.
     */
    private java.lang.String processInsId;

    /**
     *  字段域taskTitle.
     */
    private java.lang.String taskTitle;

    /**
     *  字段域stateDefId.
     */
    private java.lang.String stateDefId;


    /**
     *  域processInsIdOfSysWorkflowInsProc.
     */
    private SysWorkflowInsProc processInsIdOfSysWorkflowInsProc;

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
     *  获取 operator.
     *  @return java.lang.String.
     */
    public java.lang.String getOperator() {
        return this.operator;
    }

    /**
     *  设置 operator.
     *  @param operator operator域.
     */
    public void setOperator(java.lang.String operator) {
        this.operator = operator;
    }
    /**
     *  获取 taskOperator.
     *  @return java.lang.String.
     */
    public java.lang.String getTaskOperator() {
        return this.taskOperator;
    }

    /**
     *  设置 taskOperator.
     *  @param taskOperator taskOperator域.
     */
    public void setTaskOperator(java.lang.String taskOperator) {
        this.taskOperator = taskOperator;
    }
    /**
     *  获取 instanceStart.
     *  @return java.util.Date.
     */
    public java.util.Date getInstanceStart() {
        return this.instanceStart;
    }

    /**
     *  设置 instanceStart.
     *  @param instanceStart instanceStart域.
     */
    public void setInstanceStart(java.util.Date instanceStart) {
        this.instanceStart = instanceStart;
    }
    /**
     *  获取 instanceEnd.
     *  @return java.util.Date.
     */
    public java.util.Date getInstanceEnd() {
        return this.instanceEnd;
    }

    /**
     *  设置 instanceEnd.
     *  @param instanceEnd instanceEnd域.
     */
    public void setInstanceEnd(java.util.Date instanceEnd) {
        this.instanceEnd = instanceEnd;
    }
    /**
     *  获取 instanceState.
     *  @return java.lang.String.
     */
    public java.lang.String getInstanceState() {
        return this.instanceState;
    }

    /**
     *  设置 instanceState.
     *  @param instanceState instanceState域.
     */
    public void setInstanceState(java.lang.String instanceState) {
        this.instanceState = instanceState;
    }
    /**
     *  获取 receiptOrg.
     *  @return java.lang.String.
     */
    public java.lang.String getReceiptOrg() {
        return this.receiptOrg;
    }

    /**
     *  设置 receiptOrg.
     *  @param receiptOrg receiptOrg域.
     */
    public void setReceiptOrg(java.lang.String receiptOrg) {
        this.receiptOrg = receiptOrg;
    }
    /**
     *  获取 receiptRole.
     *  @return java.lang.String.
     */
    public java.lang.String getReceiptRole() {
        return this.receiptRole;
    }

    /**
     *  设置 receiptRole.
     *  @param receiptRole receiptRole域.
     */
    public void setReceiptRole(java.lang.String receiptRole) {
        this.receiptRole = receiptRole;
    }
    /**
     *  获取 receiptUser.
     *  @return java.lang.String.
     */
    public java.lang.String getReceiptUser() {
        return this.receiptUser;
    }

    /**
     *  设置 receiptUser.
     *  @param receiptUser receiptUser域.
     */
    public void setReceiptUser(java.lang.String receiptUser) {
        this.receiptUser = receiptUser;
    }
    /**
     *  获取 processInsId.
     *  @return java.lang.String.
     */
    public java.lang.String getProcessInsId() {
        return this.processInsId;
    }

    /**
     *  设置 processInsId.
     *  @param processInsId processInsId域.
     */
    public void setProcessInsId(java.lang.String processInsId) {
        this.processInsId = processInsId;
    }
    /**
     *  获取 taskTitle.
     *  @return java.lang.String.
     */
    public java.lang.String getTaskTitle() {
        return this.taskTitle;
    }

    /**
     *  设置 taskTitle.
     *  @param taskTitle taskTitle域.
     */
    public void setTaskTitle(java.lang.String taskTitle) {
        this.taskTitle = taskTitle;
    }
    /**
     *  获取 stateDefId.
     *  @return java.lang.String.
     */
    public java.lang.String getStateDefId() {
        return this.stateDefId;
    }

    /**
     *  设置 stateDefId.
     *  @param stateDefId stateDefId域.
     */
    public void setStateDefId(java.lang.String stateDefId) {
        this.stateDefId = stateDefId;
    }




    /**
     *  获取 processInsIdOfSysWorkflowInsProc.
     *  @return SysWorkflowInsProc.
     */
    public SysWorkflowInsProc getProcessInsIdOfSysWorkflowInsProc() {
    	if (this.processInsIdOfSysWorkflowInsProc == null && this.processInsId != null  && !"".equals(this.processInsId)){
    		SysWorkflowInsProcDAO sysWorkflowInsProcDAO = (SysWorkflowInsProcDAO)Tools.getBean("sysWorkflowInsProcDAO");
    		this.processInsIdOfSysWorkflowInsProc= sysWorkflowInsProcDAO.getSysWorkflowInsProc(this.processInsId);
    	}
        return this.processInsIdOfSysWorkflowInsProc;
    }

    /**
     *  设置 processInsIdOfSysWorkflowInsProc.
     *  @param processInsIdOfSysWorkflowInsProc processInsIdOfSysWorkflowInsProc域.
     */
    public void setProcessInsIdOfSysWorkflowInsProc(SysWorkflowInsProc processInsIdOfSysWorkflowInsProc) {
        this.processInsIdOfSysWorkflowInsProc = processInsIdOfSysWorkflowInsProc;
    }

}
