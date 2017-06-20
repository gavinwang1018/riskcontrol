package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  定义类TuserInfo.
     */
public class TuserInfo extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  字段域id.
     */
    private java.lang.String id;

    /**
     *  字段域loginName.
     */
    private java.lang.String loginName;

    /**
     *  字段域name.
     */
    private java.lang.String name;

    /**
     *  字段域password.
     */
    private java.lang.String password;

    /**
     *  字段域email.
     */
    private java.lang.String email;

    /**
     *  字段域enable.
     */
    private java.lang.Boolean enable;

    /**
     *  字段域organizeId.
     */
    private java.lang.String organizeId;


    /**
     *  域organizeIdOfTorganizeInfo.
     */
    private TorganizeInfo organizeIdOfTorganizeInfo;

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
     *  获取 loginName.
     *  @return java.lang.String.
     */
    public java.lang.String getLoginName() {
        return this.loginName;
    }

    /**
     *  设置 loginName.
     *  @param loginName loginName域.
     */
    public void setLoginName(java.lang.String loginName) {
        this.loginName = loginName;
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
     *  获取 password.
     *  @return java.lang.String.
     */
    public java.lang.String getPassword() {
        return this.password;
    }

    /**
     *  设置 password.
     *  @param password password域.
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }
    /**
     *  获取 email.
     *  @return java.lang.String.
     */
    public java.lang.String getEmail() {
        return this.email;
    }

    /**
     *  设置 email.
     *  @param email email域.
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }
    /**
     *  获取 enable.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getEnable() {
        return this.enable;
    }
    /**
     *  设置 enable.
     *  @param enable enable域.
     */
    public void setEnable(java.lang.Boolean enable) {
        this.enable = enable;
    }
    /**
     *  获取 organizeId.
     *  @return java.lang.String.
     */
    public java.lang.String getOrganizeId() {
        return this.organizeId;
    }

    /**
     *  设置 organizeId.
     *  @param organizeId organizeId域.
     */
    public void setOrganizeId(java.lang.String organizeId) {
        this.organizeId = organizeId;
    }




    /**
     *  获取 organizeIdOfTorganizeInfo.
     *  @return TorganizeInfo.
     */
    public TorganizeInfo getOrganizeIdOfTorganizeInfo() {
    	if (this.organizeIdOfTorganizeInfo == null && this.organizeId != null  && !"".equals(this.organizeId)){
    		TorganizeInfoDAO torganizeInfoDAO = (TorganizeInfoDAO)Tools.getBean("torganizeInfoDAO");
    		this.organizeIdOfTorganizeInfo= torganizeInfoDAO.getTorganizeInfo(this.organizeId);
    	}
        return this.organizeIdOfTorganizeInfo;
    }

    /**
     *  设置 organizeIdOfTorganizeInfo.
     *  @param organizeIdOfTorganizeInfo organizeIdOfTorganizeInfo域.
     */
    public void setOrganizeIdOfTorganizeInfo(TorganizeInfo organizeIdOfTorganizeInfo) {
        this.organizeIdOfTorganizeInfo = organizeIdOfTorganizeInfo;
    }

}
