package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  定义类Tmcc.
     */
public class Tmcc extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  字段域id.
     */
    private java.lang.String id;

    /**
     *  字段域mccName.
     */
    private java.lang.String mccName;

    /**
     *  字段域mccCode.
     */
    private java.lang.String mccCode;

    /**
     *  字段域bigmccName.
     */
    private java.lang.String bigmccName;

    /**
     *  字段域bigmccCode.
     */
    private java.lang.String bigmccCode;

    /**
     *  字段域midmccName.
     */
    private java.lang.String midmccName;

    /**
     *  字段域midmccCode.
     */
    private java.lang.String midmccCode;



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
     *  获取 mccName.
     *  @return java.lang.String.
     */
    public java.lang.String getMccName() {
        return this.mccName;
    }

    /**
     *  设置 mccName.
     *  @param mccName mccName域.
     */
    public void setMccName(java.lang.String mccName) {
        this.mccName = mccName;
    }
    /**
     *  获取 mccCode.
     *  @return java.lang.String.
     */
    public java.lang.String getMccCode() {
        return this.mccCode;
    }

    /**
     *  设置 mccCode.
     *  @param mccCode mccCode域.
     */
    public void setMccCode(java.lang.String mccCode) {
        this.mccCode = mccCode;
    }
    /**
     *  获取 bigmccName.
     *  @return java.lang.String.
     */
    public java.lang.String getBigmccName() {
        return this.bigmccName;
    }

    /**
     *  设置 bigmccName.
     *  @param bigmccName bigmccName域.
     */
    public void setBigmccName(java.lang.String bigmccName) {
        this.bigmccName = bigmccName;
    }
    /**
     *  获取 bigmccCode.
     *  @return java.lang.String.
     */
    public java.lang.String getBigmccCode() {
        return this.bigmccCode;
    }

    /**
     *  设置 bigmccCode.
     *  @param bigmccCode bigmccCode域.
     */
    public void setBigmccCode(java.lang.String bigmccCode) {
        this.bigmccCode = bigmccCode;
    }
    /**
     *  获取 midmccName.
     *  @return java.lang.String.
     */
    public java.lang.String getMidmccName() {
        return this.midmccName;
    }

    /**
     *  设置 midmccName.
     *  @param midmccName midmccName域.
     */
    public void setMidmccName(java.lang.String midmccName) {
        this.midmccName = midmccName;
    }
    /**
     *  获取 midmccCode.
     *  @return java.lang.String.
     */
    public java.lang.String getMidmccCode() {
        return this.midmccCode;
    }

    /**
     *  设置 midmccCode.
     *  @param midmccCode midmccCode域.
     */
    public void setMidmccCode(java.lang.String midmccCode) {
        this.midmccCode = midmccCode;
    }


}
