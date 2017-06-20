package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  ������TuserInfo.
     */
public class TuserInfo extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���loginName.
     */
    private java.lang.String loginName;

    /**
     *  �ֶ���name.
     */
    private java.lang.String name;

    /**
     *  �ֶ���password.
     */
    private java.lang.String password;

    /**
     *  �ֶ���email.
     */
    private java.lang.String email;

    /**
     *  �ֶ���enable.
     */
    private java.lang.Boolean enable;

    /**
     *  �ֶ���organizeId.
     */
    private java.lang.String organizeId;


    /**
     *  ��organizeIdOfTorganizeInfo.
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
     *  ��ȡ loginName.
     *  @return java.lang.String.
     */
    public java.lang.String getLoginName() {
        return this.loginName;
    }

    /**
     *  ���� loginName.
     *  @param loginName loginName��.
     */
    public void setLoginName(java.lang.String loginName) {
        this.loginName = loginName;
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
     *  ��ȡ password.
     *  @return java.lang.String.
     */
    public java.lang.String getPassword() {
        return this.password;
    }

    /**
     *  ���� password.
     *  @param password password��.
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }
    /**
     *  ��ȡ email.
     *  @return java.lang.String.
     */
    public java.lang.String getEmail() {
        return this.email;
    }

    /**
     *  ���� email.
     *  @param email email��.
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }
    /**
     *  ��ȡ enable.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getEnable() {
        return this.enable;
    }
    /**
     *  ���� enable.
     *  @param enable enable��.
     */
    public void setEnable(java.lang.Boolean enable) {
        this.enable = enable;
    }
    /**
     *  ��ȡ organizeId.
     *  @return java.lang.String.
     */
    public java.lang.String getOrganizeId() {
        return this.organizeId;
    }

    /**
     *  ���� organizeId.
     *  @param organizeId organizeId��.
     */
    public void setOrganizeId(java.lang.String organizeId) {
        this.organizeId = organizeId;
    }




    /**
     *  ��ȡ organizeIdOfTorganizeInfo.
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
     *  ���� organizeIdOfTorganizeInfo.
     *  @param organizeIdOfTorganizeInfo organizeIdOfTorganizeInfo��.
     */
    public void setOrganizeIdOfTorganizeInfo(TorganizeInfo organizeIdOfTorganizeInfo) {
        this.organizeIdOfTorganizeInfo = organizeIdOfTorganizeInfo;
    }

}
