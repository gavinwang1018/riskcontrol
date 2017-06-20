package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  ������Tmcc.
     */
public class Tmcc extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���mccName.
     */
    private java.lang.String mccName;

    /**
     *  �ֶ���mccCode.
     */
    private java.lang.String mccCode;

    /**
     *  �ֶ���bigmccName.
     */
    private java.lang.String bigmccName;

    /**
     *  �ֶ���bigmccCode.
     */
    private java.lang.String bigmccCode;

    /**
     *  �ֶ���midmccName.
     */
    private java.lang.String midmccName;

    /**
     *  �ֶ���midmccCode.
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
     *  ��ȡ mccName.
     *  @return java.lang.String.
     */
    public java.lang.String getMccName() {
        return this.mccName;
    }

    /**
     *  ���� mccName.
     *  @param mccName mccName��.
     */
    public void setMccName(java.lang.String mccName) {
        this.mccName = mccName;
    }
    /**
     *  ��ȡ mccCode.
     *  @return java.lang.String.
     */
    public java.lang.String getMccCode() {
        return this.mccCode;
    }

    /**
     *  ���� mccCode.
     *  @param mccCode mccCode��.
     */
    public void setMccCode(java.lang.String mccCode) {
        this.mccCode = mccCode;
    }
    /**
     *  ��ȡ bigmccName.
     *  @return java.lang.String.
     */
    public java.lang.String getBigmccName() {
        return this.bigmccName;
    }

    /**
     *  ���� bigmccName.
     *  @param bigmccName bigmccName��.
     */
    public void setBigmccName(java.lang.String bigmccName) {
        this.bigmccName = bigmccName;
    }
    /**
     *  ��ȡ bigmccCode.
     *  @return java.lang.String.
     */
    public java.lang.String getBigmccCode() {
        return this.bigmccCode;
    }

    /**
     *  ���� bigmccCode.
     *  @param bigmccCode bigmccCode��.
     */
    public void setBigmccCode(java.lang.String bigmccCode) {
        this.bigmccCode = bigmccCode;
    }
    /**
     *  ��ȡ midmccName.
     *  @return java.lang.String.
     */
    public java.lang.String getMidmccName() {
        return this.midmccName;
    }

    /**
     *  ���� midmccName.
     *  @param midmccName midmccName��.
     */
    public void setMidmccName(java.lang.String midmccName) {
        this.midmccName = midmccName;
    }
    /**
     *  ��ȡ midmccCode.
     *  @return java.lang.String.
     */
    public java.lang.String getMidmccCode() {
        return this.midmccCode;
    }

    /**
     *  ���� midmccCode.
     *  @param midmccCode midmccCode��.
     */
    public void setMidmccCode(java.lang.String midmccCode) {
        this.midmccCode = midmccCode;
    }


}
