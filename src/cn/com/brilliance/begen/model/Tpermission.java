package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  ������Tpermission.
     */
public class Tpermission extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���priviledeId.
     */
    private java.lang.String priviledeId;

    /**
     *  �ֶ���priviledeType.
     */
    private java.lang.String priviledeType;

    /**
     *  �ֶ���roleId.
     */
    private java.lang.String roleId;


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
     *  ��ȡ priviledeId.
     *  @return java.lang.String.
     */
    public java.lang.String getPriviledeId() {
        return this.priviledeId;
    }

    /**
     *  ���� priviledeId.
     *  @param priviledeId priviledeId��.
     */
    public void setPriviledeId(java.lang.String priviledeId) {
        this.priviledeId = priviledeId;
    }
    /**
     *  ��ȡ priviledeType.
     *  @return java.lang.String.
     */
    public java.lang.String getPriviledeType() {
        return this.priviledeType;
    }

    /**
     *  ���� priviledeType.
     *  @param priviledeType priviledeType��.
     */
    public void setPriviledeType(java.lang.String priviledeType) {
        this.priviledeType = priviledeType;
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
