package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  定义类SysDailyIns.
     */
public class SysDailyIns extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  字段域id.
     */
    private java.lang.String id;

    /**
     *  字段域eventType.
     */
    private java.lang.String eventType;

    /**
     *  字段域title.
     */
    private java.lang.String title;

    /**
     *  字段域url.
     */
    private java.lang.String url;

    /**
     *  字段域description.
     */
    private java.lang.String description;

    /**
     *  字段域defineDate.
     */
    private java.util.Date defineDate;

    /**
     *  字段域userId.
     */
    private java.lang.String userId;

/*
0,本人
1,所有人
2,指定用户
2,指定角色
3,指定机构
*/
    /**
     *  字段域shareFlag.
     */
    private java.lang.String shareFlag;

    /**
     *  字段域shareData.
     */
    private java.lang.String shareData;


    /**
     *  域userIdOfSysUser.
     */
    private SysUser userIdOfSysUser;

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
     *  获取 eventType.
     *  @return java.lang.String.
     */
    public java.lang.String getEventType() {
        return this.eventType;
    }

    /**
     *  设置 eventType.
     *  @param eventType eventType域.
     */
    public void setEventType(java.lang.String eventType) {
        this.eventType = eventType;
    }
    /**
     *  获取 title.
     *  @return java.lang.String.
     */
    public java.lang.String getTitle() {
        return this.title;
    }

    /**
     *  设置 title.
     *  @param title title域.
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }
    /**
     *  获取 url.
     *  @return java.lang.String.
     */
    public java.lang.String getUrl() {
        return this.url;
    }

    /**
     *  设置 url.
     *  @param url url域.
     */
    public void setUrl(java.lang.String url) {
        this.url = url;
    }
    /**
     *  获取 description.
     *  @return java.lang.String.
     */
    public java.lang.String getDescription() {
        return this.description;
    }

    /**
     *  设置 description.
     *  @param description description域.
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }
    /**
     *  获取 defineDate.
     *  @return java.util.Date.
     */
    public java.util.Date getDefineDate() {
        return this.defineDate;
    }

    /**
     *  设置 defineDate.
     *  @param defineDate defineDate域.
     */
    public void setDefineDate(java.util.Date defineDate) {
        this.defineDate = defineDate;
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
     *  获取 shareFlag.
     *  @return java.lang.String.
     */
    public java.lang.String getShareFlag() {
        return this.shareFlag;
    }

    /**
     *  设置 shareFlag.
     *  @param shareFlag shareFlag域.
     */
    public void setShareFlag(java.lang.String shareFlag) {
        this.shareFlag = shareFlag;
    }
    /**
     *  获取 shareData.
     *  @return java.lang.String.
     */
    public java.lang.String getShareData() {
        return this.shareData;
    }

    /**
     *  设置 shareData.
     *  @param shareData shareData域.
     */
    public void setShareData(java.lang.String shareData) {
        this.shareData = shareData;
    }




    /**
     *  获取 userIdOfSysUser.
     *  @return SysUser.
     */
    public SysUser getUserIdOfSysUser() {
    	if (this.userIdOfSysUser == null && this.userId != null  && !"".equals(this.userId)){
    		SysUserDAO sysUserDAO = (SysUserDAO)Tools.getBean("sysUserDAO");
    		this.userIdOfSysUser= sysUserDAO.getSysUser(this.userId);
    	}
        return this.userIdOfSysUser;
    }

    /**
     *  设置 userIdOfSysUser.
     *  @param userIdOfSysUser userIdOfSysUser域.
     */
    public void setUserIdOfSysUser(SysUser userIdOfSysUser) {
        this.userIdOfSysUser = userIdOfSysUser;
    }

}
