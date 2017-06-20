package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  定义类SysTransmitDetail.
     */
public class SysTransmitDetail extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  字段域id.
     */
    private java.lang.String id;

    /**
     *  字段域transmitId.
     */
    private java.lang.String transmitId;

    /**
     *  字段域readFlag.
     */
    private java.lang.Boolean readFlag;

    /**
     *  字段域advice.
     */
    private java.lang.String advice;

    /**
     *  字段域transmitTime.
     */
    private java.util.Date transmitTime;

    /**
     *  字段域receiver.
     */
    private java.lang.String receiver;


    /**
     *  域transmitIdOfSysTransmit.
     */
    private SysTransmit transmitIdOfSysTransmit;
    /**
     *  域receiverOfSysUser.
     */
    private SysUser receiverOfSysUser;

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
     *  获取 transmitId.
     *  @return java.lang.String.
     */
    public java.lang.String getTransmitId() {
        return this.transmitId;
    }

    /**
     *  设置 transmitId.
     *  @param transmitId transmitId域.
     */
    public void setTransmitId(java.lang.String transmitId) {
        this.transmitId = transmitId;
    }
    /**
     *  获取 readFlag.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getReadFlag() {
        return this.readFlag;
    }

    /**
     *  设置 readFlag.
     *  @param readFlag readFlag域.
     */
    public void setReadFlag(java.lang.Boolean readFlag) {
        this.readFlag = readFlag;
    }
    /**
     *  获取 advice.
     *  @return java.lang.String.
     */
    public java.lang.String getAdvice() {
        return this.advice;
    }

    /**
     *  设置 advice.
     *  @param advice advice域.
     */
    public void setAdvice(java.lang.String advice) {
        this.advice = advice;
    }
    /**
     *  获取 transmitTime.
     *  @return java.util.Date.
     */
    public java.util.Date getTransmitTime() {
        return this.transmitTime;
    }

    /**
     *  设置 transmitTime.
     *  @param transmitTime transmitTime域.
     */
    public void setTransmitTime(java.util.Date transmitTime) {
        this.transmitTime = transmitTime;
    }
    /**
     *  获取 receiver.
     *  @return java.lang.String.
     */
    public java.lang.String getReceiver() {
        return this.receiver;
    }

    /**
     *  设置 receiver.
     *  @param receiver receiver域.
     */
    public void setReceiver(java.lang.String receiver) {
        this.receiver = receiver;
    }




    /**
     *  获取 transmitIdOfSysTransmit.
     *  @return SysTransmit.
     */
    public SysTransmit getTransmitIdOfSysTransmit() {
    	if (this.transmitIdOfSysTransmit == null && this.transmitId != null  && !"".equals(this.transmitId)){
    		SysTransmitDAO sysTransmitDAO = (SysTransmitDAO)Tools.getBean("sysTransmitDAO");
    		this.transmitIdOfSysTransmit= sysTransmitDAO.getSysTransmit(this.transmitId);
    	}
        return this.transmitIdOfSysTransmit;
    }

    /**
     *  设置 transmitIdOfSysTransmit.
     *  @param transmitIdOfSysTransmit transmitIdOfSysTransmit域.
     */
    public void setTransmitIdOfSysTransmit(SysTransmit transmitIdOfSysTransmit) {
        this.transmitIdOfSysTransmit = transmitIdOfSysTransmit;
    }



    /**
     *  获取 receiverOfSysUser.
     *  @return SysUser.
     */
    public SysUser getReceiverOfSysUser() {
    	if (this.receiverOfSysUser == null && this.receiver != null  && !"".equals(this.receiver)){
    		SysUserDAO sysUserDAO = (SysUserDAO)Tools.getBean("sysUserDAO");
    		this.receiverOfSysUser= sysUserDAO.getSysUser(this.receiver);
    	}
        return this.receiverOfSysUser;
    }

    /**
     *  设置 receiverOfSysUser.
     *  @param receiverOfSysUser receiverOfSysUser域.
     */
    public void setReceiverOfSysUser(SysUser receiverOfSysUser) {
        this.receiverOfSysUser = receiverOfSysUser;
    }

}
