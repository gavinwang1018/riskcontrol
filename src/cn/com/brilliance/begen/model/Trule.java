package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  ������Trule.
     */
public class Trule extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���description.
     */
    private java.lang.String description;

    /**
     *  �ֶ���supportTrace.
     */
    private java.lang.Boolean supportTrace;

    /**
     *  �ֶ���transInfo.
     */
    private java.lang.Boolean transInfo;

/*
1,��̬
2,��̬
*/
    /**
     *  �ֶ���type.
     */
    private java.lang.String type;

    /**
     *  �ֶ���cycle.
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
     *  ��ȡ description.
     *  @return java.lang.String.
     */
    public java.lang.String getDescription() {
        return this.description;
    }

    /**
     *  ���� description.
     *  @param description description��.
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }
    /**
     *  ��ȡ supportTrace.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getSupportTrace() {
        return this.supportTrace;
    }

    /**
     *  ���� supportTrace.
     *  @param supportTrace supportTrace��.
     */
    public void setSupportTrace(java.lang.Boolean supportTrace) {
        this.supportTrace = supportTrace;
    }
    /**
     *  ��ȡ transInfo.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getTransInfo() {
        return this.transInfo;
    }

    /**
     *  ���� transInfo.
     *  @param transInfo transInfo��.
     */
    public void setTransInfo(java.lang.Boolean transInfo) {
        this.transInfo = transInfo;
    }
    /**
     *  ��ȡ type.
     *  @return java.lang.String.
     */
    public java.lang.String getType() {
        return this.type;
    }

    /**
     *  ���� type.
     *  @param type type��.
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }
    /**
     *  ��ȡ cycle.
     *  @return java.lang.String.
     */
    public java.lang.String getCycle() {
        return this.cycle;
    }

    /**
     *  ���� cycle.
     *  @param cycle cycle��.
     */
    public void setCycle(java.lang.String cycle) {
        this.cycle = cycle;
    }


}
