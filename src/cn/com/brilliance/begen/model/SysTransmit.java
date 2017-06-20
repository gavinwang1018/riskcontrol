package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  ������SysTransmit.
     */
public class SysTransmit extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���title.
     */
    private java.lang.String title;

    /**
     *  �ֶ���dataObject.
     */
    private java.lang.String dataObject;

    /**
     *  �ֶ���dataObjectKey.
     */
    private java.lang.String dataObjectKey;

    /**
     *  �ֶ���formLayout.
     */
    private java.lang.String formLayout;

    /**
     *  �ֶ���startTime.
     */
    private java.util.Date startTime;

    /**
     *  �ֶ���sender.
     */
    private java.lang.String sender;

    /**
     *  �ֶ���endTime.
     */
    private java.util.Date endTime;

    /**
     *  �ֶ���endFlag.
     */
    private java.lang.Boolean endFlag;

    /**
     *  ������sysTransmitDetailGroup.
     */
    private Set sysTransmitDetailGroup;
	
	private List sysTransmitDetails;


    /**
     *  ��senderOfSysUser.
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
     *  ��ȡ dataObject.
     *  @return java.lang.String.
     */
    public java.lang.String getDataObject() {
        return this.dataObject;
    }

    /**
     *  ���� dataObject.
     *  @param dataObject dataObject��.
     */
    public void setDataObject(java.lang.String dataObject) {
        this.dataObject = dataObject;
    }
    /**
     *  ��ȡ dataObjectKey.
     *  @return java.lang.String.
     */
    public java.lang.String getDataObjectKey() {
        return this.dataObjectKey;
    }

    /**
     *  ���� dataObjectKey.
     *  @param dataObjectKey dataObjectKey��.
     */
    public void setDataObjectKey(java.lang.String dataObjectKey) {
        this.dataObjectKey = dataObjectKey;
    }
    /**
     *  ��ȡ formLayout.
     *  @return java.lang.String.
     */
    public java.lang.String getFormLayout() {
        return this.formLayout;
    }

    /**
     *  ���� formLayout.
     *  @param formLayout formLayout��.
     */
    public void setFormLayout(java.lang.String formLayout) {
        this.formLayout = formLayout;
    }
    /**
     *  ��ȡ startTime.
     *  @return java.util.Date.
     */
    public java.util.Date getStartTime() {
        return this.startTime;
    }

    /**
     *  ���� startTime.
     *  @param startTime startTime��.
     */
    public void setStartTime(java.util.Date startTime) {
        this.startTime = startTime;
    }
    /**
     *  ��ȡ sender.
     *  @return java.lang.String.
     */
    public java.lang.String getSender() {
        return this.sender;
    }

    /**
     *  ���� sender.
     *  @param sender sender��.
     */
    public void setSender(java.lang.String sender) {
        this.sender = sender;
    }
    /**
     *  ��ȡ endTime.
     *  @return java.util.Date.
     */
    public java.util.Date getEndTime() {
        return this.endTime;
    }

    /**
     *  ���� endTime.
     *  @param endTime endTime��.
     */
    public void setEndTime(java.util.Date endTime) {
        this.endTime = endTime;
    }
    /**
     *  ��ȡ endFlag.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getEndFlag() {
        return this.endFlag;
    }

    /**
     *  ���� endFlag.
     *  @param endFlag endFlag��.
     */
    public void setEndFlag(java.lang.Boolean endFlag) {
        this.endFlag = endFlag;
    }

    /**
     *  ��ȡ sysTransmitDetailGroup.
     *  @return Set.
     */
    public Set getSysTransmitDetailGroup() {
        return this.sysTransmitDetailGroup;
    }

    /**
     *  ���� sysTransmitDetailGroup.
     *  @param sysTransmitDetailGroup sysTransmitDetailGroup��.
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
     *  ��ȡ senderOfSysUser.
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
     *  ���� senderOfSysUser.
     *  @param senderOfSysUser senderOfSysUser��.
     */
    public void setSenderOfSysUser(SysUser senderOfSysUser) {
        this.senderOfSysUser = senderOfSysUser;
    }

}
