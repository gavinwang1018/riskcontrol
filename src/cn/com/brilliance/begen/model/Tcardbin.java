package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  定义类Tcardbin.
     */
public class Tcardbin extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  字段域id.
     */
    private java.lang.String id;

    /**
     *  字段域name.
     */
    private java.lang.String name;

    /**
     *  字段域length.
     */
    private java.lang.Integer length;

    /**
     *  字段域bin.
     */
    private java.lang.String bin;

    /**
     *  字段域cupscard.
     */
    private java.lang.Boolean cupscard;

    /**
     *  字段域bank.
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
     *  获取 name.
     *  @return java.lang.String.
     */
    public java.lang.String getName() {
        return this.name;
    }

    /**
     *  设置 name.
     *  @param name name域.
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }
    /**
     *  获取 length.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getLength() {
        return this.length;
    }

    /**
     *  设置 length.
     *  @param length length域.
     */
    public void setLength(java.lang.Integer length) {
        this.length = length;
    }
    /**
     *  获取 bin.
     *  @return java.lang.String.
     */
    public java.lang.String getBin() {
        return this.bin;
    }

    /**
     *  设置 bin.
     *  @param bin bin域.
     */
    public void setBin(java.lang.String bin) {
        this.bin = bin;
    }
    /**
     *  获取 cupscard.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getCupscard() {
        return this.cupscard;
    }

    /**
     *  设置 cupscard.
     *  @param cupscard cupscard域.
     */
    public void setCupscard(java.lang.Boolean cupscard) {
        this.cupscard = cupscard;
    }
    /**
     *  获取 bank.
     *  @return java.lang.String.
     */
    public java.lang.String getBank() {
        return this.bank;
    }

    /**
     *  设置 bank.
     *  @param bank bank域.
     */
    public void setBank(java.lang.String bank) {
        this.bank = bank;
    }


}
