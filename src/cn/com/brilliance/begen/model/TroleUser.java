package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  定义类TroleUser.
     */
public class TroleUser extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  字段域id.
     */
    private java.lang.String id;

    /**
     *  字段域roleId.
     */
    private java.lang.String roleId;

/*
@selectItems.tuserInfoItems
*/
    /**
     *  字段域userId.
     */
    private java.lang.String userId;


    /**
     *  域roleIdOfTroleInfo.
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
     *  获取 roleId.
     *  @return java.lang.String.
     */
    public java.lang.String getRoleId() {
        return this.roleId;
    }

    /**
     *  设置 roleId.
     *  @param roleId roleId域.
     */
    public void setRoleId(java.lang.String roleId) {
        this.roleId = roleId;
    }
    /**
     *  获取 userId.
     *  @return java.lang.String.
     */
    public java.lang.String getUserId() {
        return this.userId;
    }

    /**
     *  设置 userId.
     *  @param userId userId域.
     */
    public void setUserId(java.lang.String userId) {
        this.userId = userId;
    }




    /**
     *  获取 roleIdOfTroleInfo.
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
     *  设置 roleIdOfTroleInfo.
     *  @param roleIdOfTroleInfo roleIdOfTroleInfo域.
     */
    public void setRoleIdOfTroleInfo(TroleInfo roleIdOfTroleInfo) {
        this.roleIdOfTroleInfo = roleIdOfTroleInfo;
    }

}
