package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  定义类TriskcaseLog.
     */
public class TriskcaseLog extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  字段域id.
     */
    private java.lang.String id;

    /**
     *  字段域userMame.
     */
    private java.lang.String userMame;

    /**
     *  字段域operatorDatetime.
     */
    private java.util.Date operatorDatetime;

    /**
     *  字段域ip.
     */
    private java.lang.String ip;

    /**
     *  字段域content.
     */
    private java.lang.String content;

    /**
     *  字段域loginName.
     */
    private java.lang.String loginName;



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
     *  获取 userMame.
     *  @return java.lang.String.
     */
    public java.lang.String getUserMame() {
        return this.userMame;
    }

    /**
     *  设置 userMame.
     *  @param userMame userMame域.
     */
    public void setUserMame(java.lang.String userMame) {
        this.userMame = userMame;
    }
    /**
     *  获取 operatorDatetime.
     *  @return java.util.Date.
     */
    public java.util.Date getOperatorDatetime() {
        return this.operatorDatetime;
    }

    /**
     *  设置 operatorDatetime.
     *  @param operatorDatetime operatorDatetime域.
     */
    public void setOperatorDatetime(java.util.Date operatorDatetime) {
        this.operatorDatetime = operatorDatetime;
    }
    /**
     *  获取 ip.
     *  @return java.lang.String.
     */
    public java.lang.String getIp() {
        return this.ip;
    }

    /**
     *  设置 ip.
     *  @param ip ip域.
     */
    public void setIp(java.lang.String ip) {
        this.ip = ip;
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
     *  获取 loginName.
     *  @return java.lang.String.
     */
    public java.lang.String getLoginName() {
        return this.loginName;
    }

    /**
     *  设置 loginName.
     *  @param loginName loginName域.
     */
    public void setLoginName(java.lang.String loginName) {
        this.loginName = loginName;
    }


}
