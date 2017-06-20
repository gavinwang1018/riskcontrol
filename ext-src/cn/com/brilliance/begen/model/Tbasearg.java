package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  ������Tbasearg.
     */
public class Tbasearg extends BaseModel implements Serializable ,Comparable {

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
     *  �ֶ���type.
     */
    private java.lang.String type;

    /**
     *  �ֶ���code.
     */
    private java.lang.String code;

    /**
     *  �ֶ���param1.
     */
    private java.lang.String param1;

    /**
     *  �ֶ���param2.
     */
    private java.lang.String param2;

    /**
     *  �ֶ���param3.
     */
    private java.lang.String param3;

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
     *  ��ȡ code.
     *  @return java.lang.String.
     */
    public java.lang.String getCode() {
        return this.code;
    }

    /**
     *  ���� code.
     *  @param code code��.
     */
    public void setCode(java.lang.String code) {
        this.code = code;
    }
    /**
     *  ��ȡ param1.
     *  @return java.lang.String.
     */
    public java.lang.String getParam1() {
        return this.param1;
    }

    /**
     *  ���� param1.
     *  @param param1 param1��.
     */
    public void setParam1(java.lang.String param1) {
        this.param1 = param1;
    }
    /**
     *  ��ȡ param2.
     *  @return java.lang.String.
     */
    public java.lang.String getParam2() {
        return this.param2;
    }

    /**
     *  ���� param2.
     *  @param param2 param2��.
     */
    public void setParam2(java.lang.String param2) {
        this.param2 = param2;
    }

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @return the param3
	 */
	public java.lang.String getParam3() {
		return param3;
	}

	/**
	 * @param param3 the param3 to set
	 */
	public void setParam3(java.lang.String param3) {
		this.param3 = param3;
	}


}
