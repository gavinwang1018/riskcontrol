package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  ������SysWorkflowInsProc.
     */
public class SysWorkflowInsProc extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���processDefId.
     */
    private java.lang.String processDefId;

/*
0,�
1,����(�ܾ�)
2,����(ͨ��)
*/
    /**
     *  �ֶ���processState.
     */
    private java.lang.String processState;

    /**
     *  �ֶ���processStart.
     */
    private java.util.Date processStart;

    /**
     *  �ֶ���processEnd.
     */
    private java.util.Date processEnd;

    /**
     *  �ֶ���dataObjectKey.
     */
    private java.lang.String dataObjectKey;

    /**
     *  ������sysWorkflowInsTaskGroup.
     */
    private Set sysWorkflowInsTaskGroup;
	
	private List sysWorkflowInsTasks;



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
     *  ��ȡ processDefId.
     *  @return java.lang.String.
     */
    public java.lang.String getProcessDefId() {
        return this.processDefId;
    }

    /**
     *  ���� processDefId.
     *  @param processDefId processDefId��.
     */
    public void setProcessDefId(java.lang.String processDefId) {
        this.processDefId = processDefId;
    }
    /**
     *  ��ȡ processState.
     *  @return java.lang.String.
     */
    public java.lang.String getProcessState() {
        return this.processState;
    }

    /**
     *  ���� processState.
     *  @param processState processState��.
     */
    public void setProcessState(java.lang.String processState) {
        this.processState = processState;
    }
    /**
     *  ��ȡ processStart.
     *  @return java.util.Date.
     */
    public java.util.Date getProcessStart() {
        return this.processStart;
    }

    /**
     *  ���� processStart.
     *  @param processStart processStart��.
     */
    public void setProcessStart(java.util.Date processStart) {
        this.processStart = processStart;
    }
    /**
     *  ��ȡ processEnd.
     *  @return java.util.Date.
     */
    public java.util.Date getProcessEnd() {
        return this.processEnd;
    }

    /**
     *  ���� processEnd.
     *  @param processEnd processEnd��.
     */
    public void setProcessEnd(java.util.Date processEnd) {
        this.processEnd = processEnd;
    }
    /**
     *  ��ȡ dataObjectKey.
     *  @return java.lang.String.
     */
    public java.lang.String getDataObjectKey() {
        return this.dataObjectKey;
    }

    /**
     *  ���� dataObjectKey.
     *  @param dataObjectKey dataObjectKey��.
     */
    public void setDataObjectKey(java.lang.String dataObjectKey) {
        this.dataObjectKey = dataObjectKey;
    }

    /**
     *  ��ȡ sysWorkflowInsTaskGroup.
     *  @return Set.
     */
    public Set getSysWorkflowInsTaskGroup() {
        return this.sysWorkflowInsTaskGroup;
    }

    /**
     *  ���� sysWorkflowInsTaskGroup.
     *  @param sysWorkflowInsTaskGroup sysWorkflowInsTaskGroup��.
     */
    public void setSysWorkflowInsTaskGroup(Set sysWorkflowInsTaskGroup) {
        this.sysWorkflowInsTaskGroup = sysWorkflowInsTaskGroup;
    }
	
	public List getSysWorkflowInsTasks() {
        return this.sysWorkflowInsTasks;
    }

    public void setSysWorkflowInsTasks(List sysWorkflowInsTasks) {
        this.sysWorkflowInsTasks = sysWorkflowInsTasks;
    }

}
