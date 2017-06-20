package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  定义类SysTransmit.
     */
public class SysTransmit extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  字段域id.
     */
    private java.lang.String id;

    /**
     *  字段域title.
     */
    private java.lang.String title;

    /**
     *  字段域dataObject.
     */
    private java.lang.String dataObject;

    /**
     *  字段域dataObjectKey.
     */
    private java.lang.String dataObjectKey;

    /**
     *  字段域formLayout.
     */
    private java.lang.String formLayout;

    /**
     *  字段域startTime.
     */
    private java.util.Date startTime;

    /**
     *  字段域sender.
     */
    private java.lang.String sender;

    /**
     *  字段域endTime.
     */
    private java.util.Date endTime;

    /**
     *  字段域endFlag.
     */
    private java.lang.Boolean endFlag;

    /**
     *  集合域sysTransmitDetailGroup.
     */
    private Set sysTransmitDetailGroup;
	
	private List sysTransmitDetails;


    /**
     *  域senderOfSysUser.
     */
    private SysUser senderOfSysUser;

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
     *  获取 dataObject.
     *  @return java.lang.String.
     */
    public java.lang.String getDataObject() {
        return this.dataObject;
    }

    /**
     *  设置 dataObject.
     *  @param dataObject dataObject域.
     */
    public void setDataObject(java.lang.String dataObject) {
        this.dataObject = dataObject;
    }
    /**
     *  获取 dataObjectKey.
     *  @return java.lang.String.
     */
    public java.lang.String getDataObjectKey() {
        return this.dataObjectKey;
    }

    /**
     *  设置 dataObjectKey.
     *  @param dataObjectKey dataObjectKey域.
     */
    public void setDataObjectKey(java.lang.String dataObjectKey) {
        this.dataObjectKey = dataObjectKey;
    }
    /**
     *  获取 formLayout.
     *  @return java.lang.String.
     */
    public java.lang.String getFormLayout() {
        return this.formLayout;
    }

    /**
     *  设置 formLayout.
     *  @param formLayout formLayout域.
     */
    public void setFormLayout(java.lang.String formLayout) {
        this.formLayout = formLayout;
    }
    /**
     *  获取 startTime.
     *  @return java.util.Date.
     */
    public java.util.Date getStartTime() {
        return this.startTime;
    }

    /**
     *  设置 startTime.
     *  @param startTime startTime域.
     */
    public void setStartTime(java.util.Date startTime) {
        this.startTime = startTime;
    }
    /**
     *  获取 sender.
     *  @return java.lang.String.
     */
    public java.lang.String getSender() {
        return this.sender;
    }

    /**
     *  设置 sender.
     *  @param sender sender域.
     */
    public void setSender(java.lang.String sender) {
        this.sender = sender;
    }
    /**
     *  获取 endTime.
     *  @return java.util.Date.
     */
    public java.util.Date getEndTime() {
        return this.endTime;
    }

    /**
     *  设置 endTime.
     *  @param endTime endTime域.
     */
    public void setEndTime(java.util.Date endTime) {
        this.endTime = endTime;
    }
    /**
     *  获取 endFlag.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getEndFlag() {
        return this.endFlag;
    }

    /**
     *  设置 endFlag.
     *  @param endFlag endFlag域.
     */
    public void setEndFlag(java.lang.Boolean endFlag) {
        this.endFlag = endFlag;
    }

    /**
     *  获取 sysTransmitDetailGroup.
     *  @return Set.
     */
    public Set getSysTransmitDetailGroup() {
        return this.sysTransmitDetailGroup;
    }

    /**
     *  设置 sysTransmitDetailGroup.
     *  @param sysTransmitDetailGroup sysTransmitDetailGroup域.
     */
    public void setSysTransmitDetailGroup(Set sysTransmitDetailGroup) {
        this.sysTransmitDetailGroup = sysTransmitDetailGroup;
    }
	
	public List getSysTransmitDetails() {
        return this.sysTransmitDetails;
    }

    public void setSysTransmitDetails(List sysTransmitDetails) {
        this.sysTransmitDetails = sysTransmitDetails;
    }



    /**
     *  获取 senderOfSysUser.
     *  @return SysUser.
     */
    public SysUser getSenderOfSysUser() {
    	if (this.senderOfSysUser == null && this.sender != null  && !"".equals(this.sender)){
    		SysUserDAO sysUserDAO = (SysUserDAO)Tools.getBean("sysUserDAO");
    		this.senderOfSysUser= sysUserDAO.getSysUser(this.sender);
    	}
        return this.senderOfSysUser;
    }

    /**
     *  设置 senderOfSysUser.
     *  @param senderOfSysUser senderOfSysUser域.
     */
    public void setSenderOfSysUser(SysUser senderOfSysUser) {
        this.senderOfSysUser = senderOfSysUser;
    }

}
