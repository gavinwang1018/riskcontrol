package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  定义类TorganizeUser.
     */
public class TorganizeUser extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  字段域id.
     */
    private java.lang.String id;

    /**
     *  字段域organizeId.
     */
    private java.lang.String organizeId;

    /**
     *  字段域userId.
     */
    private java.lang.String userId;

    /**
     *  字段域type.
     */
    private java.lang.Boolean type;


    /**
     *  域organizeIdOfTorganizeInfo.
     */
    private TorganizeInfo organizeIdOfTorganizeInfo;
    /**
     *  域userIdOfTuserInfo.
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
     *  获取 type.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getType() {
        return this.type;
    }

    /**
     *  设置 type.
     *  @param type type域.
     */
    public void setType(java.lang.Boolean type) {
        this.type = type;
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



    /**
     *  获取 userIdOfTuserInfo.
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
     *  设置 userIdOfTuserInfo.
     *  @param userIdOfTuserInfo userIdOfTuserInfo域.
     */
    public void setUserIdOfTuserInfo(TuserInfo userIdOfTuserInfo) {
        this.userIdOfTuserInfo = userIdOfTuserInfo;
    }

}
