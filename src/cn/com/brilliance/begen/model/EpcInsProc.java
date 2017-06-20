package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  定义类EpcInsProc.
     */
public class EpcInsProc extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  字段域id.
     */
    private java.lang.String id;

    /**
     *  字段域processDefId.
     */
    private java.lang.String processDefId;

/*
1,活动
2,挂起
3,结束
*/
    /**
     *  字段域processState.
     */
    private java.lang.String processState;

    /**
     *  字段域processStart.
     */
    private java.util.Date processStart;

    /**
     *  字段域processEnd.
     */
    private java.util.Date processEnd;

    /**
     *  字段域dataObject.
     */
    private java.lang.String dataObject;

    /**
     *  字段域dataObjectKey.
     */
    private java.lang.String dataObjectKey;

    /**
     *  集合域epcInsTaskGroup.
     */
    private Set epcInsTaskGroup;
	
	private List epcInsTasks;



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
     *  获取 processDefId.
     *  @return java.lang.String.
     */
    public java.lang.String getProcessDefId() {
        return this.processDefId;
    }

    /**
     *  设置 processDefId.
     *  @param processDefId processDefId域.
     */
    public void setProcessDefId(java.lang.String processDefId) {
        this.processDefId = processDefId;
    }
    /**
     *  获取 processState.
     *  @return java.lang.String.
     */
    public java.lang.String getProcessState() {
        return this.processState;
    }

    /**
     *  设置 processState.
     *  @param processState processState域.
     */
    public void setProcessState(java.lang.String processState) {
        this.processState = processState;
    }
    /**
     *  获取 processStart.
     *  @return java.util.Date.
     */
    public java.util.Date getProcessStart() {
        return this.processStart;
    }

    /**
     *  设置 processStart.
     *  @param processStart processStart域.
     */
    public void setProcessStart(java.util.Date processStart) {
        this.processStart = processStart;
    }
    /**
     *  获取 processEnd.
     *  @return java.util.Date.
     */
    public java.util.Date getProcessEnd() {
        return this.processEnd;
    }

    /**
     *  设置 processEnd.
     *  @param processEnd processEnd域.
     */
    public void setProcessEnd(java.util.Date processEnd) {
        this.processEnd = processEnd;
    }
    /**
     *  获取 dataObject.
     *  @return java.lang.String.
     */
    public java.lang.String getDataObject() {
        return this.dataObject;
    }

    /**
     *  设置 dataObject.
     *  @param dataObject dataObject域.
     */
    public void setDataObject(java.lang.String dataObject) {
        this.dataObject = dataObject;
    }
    /**
     *  获取 dataObjectKey.
     *  @return java.lang.String.
     */
    public java.lang.String getDataObjectKey() {
        return this.dataObjectKey;
    }

    /**
     *  设置 dataObjectKey.
     *  @param dataObjectKey dataObjectKey域.
     */
    public void setDataObjectKey(java.lang.String dataObjectKey) {
        this.dataObjectKey = dataObjectKey;
    }

    /**
     *  获取 epcInsTaskGroup.
     *  @return Set.
     */
    public Set getEpcInsTaskGroup() {
        return this.epcInsTaskGroup;
    }

    /**
     *  设置 epcInsTaskGroup.
     *  @param epcInsTaskGroup epcInsTaskGroup域.
     */
    public void setEpcInsTaskGroup(Set epcInsTaskGroup) {
        this.epcInsTaskGroup = epcInsTaskGroup;
    }
	
	public List getEpcInsTasks() {
        return this.epcInsTasks;
    }

    public void setEpcInsTasks(List epcInsTasks) {
        this.epcInsTasks = epcInsTasks;
    }

}
