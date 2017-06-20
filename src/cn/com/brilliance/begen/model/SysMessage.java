package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  ������SysMessage.
     */
public class SysMessage extends BaseModel implements Serializable {

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
     *  �ֶ���content.
     */
    private java.lang.String content;

    /**
     *  �ֶ���sendTime.
     */
    private java.util.Date sendTime;

    /**
     *  �ֶ���sender.
     */
    private java.lang.String sender;

    /**
     *  �ֶ���receiver.
     */
    private java.lang.String receiver;

    /**
     *  �ֶ���readFlag.
     */
    private java.lang.Boolean readFlag;

/*
1,�ռ���
2,������
3,�ռ�����վ
4,��������վ
*/
    /**
     *  �ֶ���type.
     */
    private java.lang.String type;


    /**
     *  ��senderOfSysUser.
     */
    private SysUser senderOfSysUser;
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
     *  ��ȡ content.
     *  @return java.lang.String.
     */
    public java.lang.String getContent() {
        return this.content;
    }

    /**
     *  ���� content.
     *  @param content content��.
     */
    public void setContent(java.lang.String content) {
        this.content = content;
    }
    /**
     *  ��ȡ sendTime.
     *  @return java.util.Date.
     */
    public java.util.Date getSendTime() {
        return this.sendTime;
    }

    /**
     *  ���� sendTime.
     *  @param sendTime sendTime��.
     */
    public void setSendTime(java.util.Date sendTime) {
        this.sendTime = sendTime;
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
     *  ��ȡ type.
     *  @return java.lang.String.
     */
    public java.lang.String getType() {
        return this.type;
    }

    /**
     *  ���� type.
     *  @param type type��.
     */
    public void setType(java.lang.String type) {
        this.type = type;
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
