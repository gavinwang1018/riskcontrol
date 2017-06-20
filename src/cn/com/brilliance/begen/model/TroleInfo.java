package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  ������TroleInfo.
     */
public class TroleInfo extends BaseModel implements Serializable {

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
     *  �ֶ���code.
     */
    private java.lang.String code;



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


}
