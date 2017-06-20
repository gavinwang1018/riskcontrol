package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  ������TroleUser.
     */
public class TroleUser extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���roleId.
     */
    private java.lang.String roleId;

/*
@selectItems.tuserInfoItems
*/
    /**
     *  �ֶ���userId.
     */
    private java.lang.String userId;


    /**
     *  ��roleIdOfTroleInfo.
     */
    private TroleInfo roleIdOfTroleInfo;

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
     *  ��ȡ roleId.
     *  @return java.lang.String.
     */
    public java.lang.String getRoleId() {
        return this.roleId;
    }

    /**
     *  ���� roleId.
     *  @param roleId roleId��.
     */
    public void setRoleId(java.lang.String roleId) {
        this.roleId = roleId;
    }
    /**
     *  ��ȡ userId.
     *  @return java.lang.String.
     */
    public java.lang.String getUserId() {
        return this.userId;
    }

    /**
     *  ���� userId.
     *  @param userId userId��.
     */
    public void setUserId(java.lang.String userId) {
        this.userId = userId;
    }




    /**
     *  ��ȡ roleIdOfTroleInfo.
     *  @return TroleInfo.
     */
    public TroleInfo getRoleIdOfTroleInfo() {
    	if (this.roleIdOfTroleInfo == null && this.roleId != null  && !"".equals(this.roleId)){
    		TroleInfoDAO troleInfoDAO = (TroleInfoDAO)Tools.getBean("troleInfoDAO");
    		this.roleIdOfTroleInfo= troleInfoDAO.getTroleInfo(this.roleId);
    	}
        return this.roleIdOfTroleInfo;
    }

    /**
     *  ���� roleIdOfTroleInfo.
     *  @param roleIdOfTroleInfo roleIdOfTroleInfo��.
     */
    public void setRoleIdOfTroleInfo(TroleInfo roleIdOfTroleInfo) {
        this.roleIdOfTroleInfo = roleIdOfTroleInfo;
    }

}
