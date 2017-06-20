package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  ������TorganizeUser.
     */
public class TorganizeUser extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���organizeId.
     */
    private java.lang.String organizeId;

    /**
     *  �ֶ���userId.
     */
    private java.lang.String userId;

    /**
     *  �ֶ���type.
     */
    private java.lang.Boolean type;


    /**
     *  ��organizeIdOfTorganizeInfo.
     */
    private TorganizeInfo organizeIdOfTorganizeInfo;
    /**
     *  ��userIdOfTuserInfo.
     */
    private TuserInfo userIdOfTuserInfo;

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
     *  ��ȡ type.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getType() {
        return this.type;
    }

    /**
     *  ���� type.
     *  @param type type��.
     */
    public void setType(java.lang.Boolean type) {
        this.type = type;
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



    /**
     *  ��ȡ userIdOfTuserInfo.
     *  @return TuserInfo.
     */
    public TuserInfo getUserIdOfTuserInfo() {
    	if (this.userIdOfTuserInfo == null && this.userId != null  && !"".equals(this.userId)){
    		TuserInfoDAO tuserInfoDAO = (TuserInfoDAO)Tools.getBean("tuserInfoDAO");
    		this.userIdOfTuserInfo= tuserInfoDAO.getTuserInfo(this.userId);
    	}
        return this.userIdOfTuserInfo;
    }

    /**
     *  ���� userIdOfTuserInfo.
     *  @param userIdOfTuserInfo userIdOfTuserInfo��.
     */
    public void setUserIdOfTuserInfo(TuserInfo userIdOfTuserInfo) {
        this.userIdOfTuserInfo = userIdOfTuserInfo;
    }

}
