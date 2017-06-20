package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  ������SysDailyIns.
     */
public class SysDailyIns extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���eventType.
     */
    private java.lang.String eventType;

    /**
     *  �ֶ���title.
     */
    private java.lang.String title;

    /**
     *  �ֶ���url.
     */
    private java.lang.String url;

    /**
     *  �ֶ���description.
     */
    private java.lang.String description;

    /**
     *  �ֶ���defineDate.
     */
    private java.util.Date defineDate;

    /**
     *  �ֶ���userId.
     */
    private java.lang.String userId;

/*
0,����
1,������
2,ָ���û�
2,ָ����ɫ
3,ָ������
*/
    /**
     *  �ֶ���shareFlag.
     */
    private java.lang.String shareFlag;

    /**
     *  �ֶ���shareData.
     */
    private java.lang.String shareData;


    /**
     *  ��userIdOfSysUser.
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
     *  ��ȡ eventType.
     *  @return java.lang.String.
     */
    public java.lang.String getEventType() {
        return this.eventType;
    }

    /**
     *  ���� eventType.
     *  @param eventType eventType��.
     */
    public void setEventType(java.lang.String eventType) {
        this.eventType = eventType;
    }
    /**
     *  ��ȡ title.
     *  @return java.lang.String.
     */
    public java.lang.String getTitle() {
        return this.title;
    }

    /**
     *  ���� title.
     *  @param title title��.
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }
    /**
     *  ��ȡ url.
     *  @return java.lang.String.
     */
    public java.lang.String getUrl() {
        return this.url;
    }

    /**
     *  ���� url.
     *  @param url url��.
     */
    public void setUrl(java.lang.String url) {
        this.url = url;
    }
    /**
     *  ��ȡ description.
     *  @return java.lang.String.
     */
    public java.lang.String getDescription() {
        return this.description;
    }

    /**
     *  ���� description.
     *  @param description description��.
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }
    /**
     *  ��ȡ defineDate.
     *  @return java.util.Date.
     */
    public java.util.Date getDefineDate() {
        return this.defineDate;
    }

    /**
     *  ���� defineDate.
     *  @param defineDate defineDate��.
     */
    public void setDefineDate(java.util.Date defineDate) {
        this.defineDate = defineDate;
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
     *  ��ȡ shareFlag.
     *  @return java.lang.String.
     */
    public java.lang.String getShareFlag() {
        return this.shareFlag;
    }

    /**
     *  ���� shareFlag.
     *  @param shareFlag shareFlag��.
     */
    public void setShareFlag(java.lang.String shareFlag) {
        this.shareFlag = shareFlag;
    }
    /**
     *  ��ȡ shareData.
     *  @return java.lang.String.
     */
    public java.lang.String getShareData() {
        return this.shareData;
    }

    /**
     *  ���� shareData.
     *  @param shareData shareData��.
     */
    public void setShareData(java.lang.String shareData) {
        this.shareData = shareData;
    }




    /**
     *  ��ȡ userIdOfSysUser.
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
     *  ���� userIdOfSysUser.
     *  @param userIdOfSysUser userIdOfSysUser��.
     */
    public void setUserIdOfSysUser(SysUser userIdOfSysUser) {
        this.userIdOfSysUser = userIdOfSysUser;
    }

}
