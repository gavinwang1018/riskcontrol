package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  定义类SysMessage.
     */
public class SysMessage extends BaseModel implements Serializable {

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
     *  字段域content.
     */
    private java.lang.String content;

    /**
     *  字段域sendTime.
     */
    private java.util.Date sendTime;

    /**
     *  字段域sender.
     */
    private java.lang.String sender;

    /**
     *  字段域receiver.
     */
    private java.lang.String receiver;

    /**
     *  字段域readFlag.
     */
    private java.lang.Boolean readFlag;

/*
1,收件箱
2,发件箱
3,收件回收站
4,发件回收站
*/
    /**
     *  字段域type.
     */
    private java.lang.String type;


    /**
     *  域senderOfSysUser.
     */
    private SysUser senderOfSysUser;
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
     *  获取 content.
     *  @return java.lang.String.
     */
    public java.lang.String getContent() {
        return this.content;
    }

    /**
     *  设置 content.
     *  @param content content域.
     */
    public void setContent(java.lang.String content) {
        this.content = content;
    }
    /**
     *  获取 sendTime.
     *  @return java.util.Date.
     */
    public java.util.Date getSendTime() {
        return this.sendTime;
    }

    /**
     *  设置 sendTime.
     *  @param sendTime sendTime域.
     */
    public void setSendTime(java.util.Date sendTime) {
        this.sendTime = sendTime;
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
     *  获取 type.
     *  @return java.lang.String.
     */
    public java.lang.String getType() {
        return this.type;
    }

    /**
     *  设置 type.
     *  @param type type域.
     */
    public void setType(java.lang.String type) {
        this.type = type;
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
