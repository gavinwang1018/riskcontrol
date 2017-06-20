package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  ������SysTransmitDetail.
     */
public class SysTransmitDetail extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���transmitId.
     */
    private java.lang.String transmitId;

    /**
     *  �ֶ���readFlag.
     */
    private java.lang.Boolean readFlag;

    /**
     *  �ֶ���advice.
     */
    private java.lang.String advice;

    /**
     *  �ֶ���transmitTime.
     */
    private java.util.Date transmitTime;

    /**
     *  �ֶ���receiver.
     */
    private java.lang.String receiver;


    /**
     *  ��transmitIdOfSysTransmit.
     */
    private SysTransmit transmitIdOfSysTransmit;
    /**
     *  ��receiverOfSysUser.
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
     *  ��ȡ transmitId.
     *  @return java.lang.String.
     */
    public java.lang.String getTransmitId() {
        return this.transmitId;
    }

    /**
     *  ���� transmitId.
     *  @param transmitId transmitId��.
     */
    public void setTransmitId(java.lang.String transmitId) {
        this.transmitId = transmitId;
    }
    /**
     *  ��ȡ readFlag.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getReadFlag() {
        return this.readFlag;
    }

    /**
     *  ���� readFlag.
     *  @param readFlag readFlag��.
     */
    public void setReadFlag(java.lang.Boolean readFlag) {
        this.readFlag = readFlag;
    }
    /**
     *  ��ȡ advice.
     *  @return java.lang.String.
     */
    public java.lang.String getAdvice() {
        return this.advice;
    }

    /**
     *  ���� advice.
     *  @param advice advice��.
     */
    public void setAdvice(java.lang.String advice) {
        this.advice = advice;
    }
    /**
     *  ��ȡ transmitTime.
     *  @return java.util.Date.
     */
    public java.util.Date getTransmitTime() {
        return this.transmitTime;
    }

    /**
     *  ���� transmitTime.
     *  @param transmitTime transmitTime��.
     */
    public void setTransmitTime(java.util.Date transmitTime) {
        this.transmitTime = transmitTime;
    }
    /**
     *  ��ȡ receiver.
     *  @return java.lang.String.
     */
    public java.lang.String getReceiver() {
        return this.receiver;
    }

    /**
     *  ���� receiver.
     *  @param receiver receiver��.
     */
    public void setReceiver(java.lang.String receiver) {
        this.receiver = receiver;
    }




    /**
     *  ��ȡ transmitIdOfSysTransmit.
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
     *  ���� transmitIdOfSysTransmit.
     *  @param transmitIdOfSysTransmit transmitIdOfSysTransmit��.
     */
    public void setTransmitIdOfSysTransmit(SysTransmit transmitIdOfSysTransmit) {
        this.transmitIdOfSysTransmit = transmitIdOfSysTransmit;
    }



    /**
     *  ��ȡ receiverOfSysUser.
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
     *  ���� receiverOfSysUser.
     *  @param receiverOfSysUser receiverOfSysUser��.
     */
    public void setReceiverOfSysUser(SysUser receiverOfSysUser) {
        this.receiverOfSysUser = receiverOfSysUser;
    }

}
