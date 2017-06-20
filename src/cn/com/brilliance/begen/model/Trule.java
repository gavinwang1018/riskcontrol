package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  定义类Trule.
     */
public class Trule extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  字段域id.
     */
    private java.lang.String id;

    /**
     *  字段域description.
     */
    private java.lang.String description;

    /**
     *  字段域supportTrace.
     */
    private java.lang.Boolean supportTrace;

    /**
     *  字段域transInfo.
     */
    private java.lang.Boolean transInfo;

/*
1,静态
2,动态
*/
    /**
     *  字段域type.
     */
    private java.lang.String type;

    /**
     *  字段域cycle.
     */
    private java.lang.String cycle;



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
     *  获取 description.
     *  @return java.lang.String.
     */
    public java.lang.String getDescription() {
        return this.description;
    }

    /**
     *  设置 description.
     *  @param description description域.
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }
    /**
     *  获取 supportTrace.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getSupportTrace() {
        return this.supportTrace;
    }

    /**
     *  设置 supportTrace.
     *  @param supportTrace supportTrace域.
     */
    public void setSupportTrace(java.lang.Boolean supportTrace) {
        this.supportTrace = supportTrace;
    }
    /**
     *  获取 transInfo.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getTransInfo() {
        return this.transInfo;
    }

    /**
     *  设置 transInfo.
     *  @param transInfo transInfo域.
     */
    public void setTransInfo(java.lang.Boolean transInfo) {
        this.transInfo = transInfo;
    }
    /**
     *  获取 type.
     *  @return java.lang.String.
     */
    public java.lang.String getType() {
        return this.type;
    }

    /**
     *  设置 type.
     *  @param type type域.
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }
    /**
     *  获取 cycle.
     *  @return java.lang.String.
     */
    public java.lang.String getCycle() {
        return this.cycle;
    }

    /**
     *  设置 cycle.
     *  @param cycle cycle域.
     */
    public void setCycle(java.lang.String cycle) {
        this.cycle = cycle;
    }


}
