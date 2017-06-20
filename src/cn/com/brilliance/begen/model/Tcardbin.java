package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  ������Tcardbin.
     */
public class Tcardbin extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���name.
     */
    private java.lang.String name;

    /**
     *  �ֶ���length.
     */
    private java.lang.Integer length;

    /**
     *  �ֶ���bin.
     */
    private java.lang.String bin;

    /**
     *  �ֶ���cupscard.
     */
    private java.lang.Boolean cupscard;

    /**
     *  �ֶ���bank.
     */
    private java.lang.String bank;



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
     *  ��ȡ name.
     *  @return java.lang.String.
     */
    public java.lang.String getName() {
        return this.name;
    }

    /**
     *  ���� name.
     *  @param name name��.
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }
    /**
     *  ��ȡ length.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getLength() {
        return this.length;
    }

    /**
     *  ���� length.
     *  @param length length��.
     */
    public void setLength(java.lang.Integer length) {
        this.length = length;
    }
    /**
     *  ��ȡ bin.
     *  @return java.lang.String.
     */
    public java.lang.String getBin() {
        return this.bin;
    }

    /**
     *  ���� bin.
     *  @param bin bin��.
     */
    public void setBin(java.lang.String bin) {
        this.bin = bin;
    }
    /**
     *  ��ȡ cupscard.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getCupscard() {
        return this.cupscard;
    }

    /**
     *  ���� cupscard.
     *  @param cupscard cupscard��.
     */
    public void setCupscard(java.lang.Boolean cupscard) {
        this.cupscard = cupscard;
    }
    /**
     *  ��ȡ bank.
     *  @return java.lang.String.
     */
    public java.lang.String getBank() {
        return this.bank;
    }

    /**
     *  ���� bank.
     *  @param bank bank��.
     */
    public void setBank(java.lang.String bank) {
        this.bank = bank;
    }


}
