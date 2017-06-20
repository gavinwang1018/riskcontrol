package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  ������TriskcaseLog.
     */
public class TriskcaseLog extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���userMame.
     */
    private java.lang.String userMame;

    /**
     *  �ֶ���operatorDatetime.
     */
    private java.util.Date operatorDatetime;

    /**
     *  �ֶ���ip.
     */
    private java.lang.String ip;

    /**
     *  �ֶ���content.
     */
    private java.lang.String content;

    /**
     *  �ֶ���loginName.
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
     *  ��ȡ userMame.
     *  @return java.lang.String.
     */
    public java.lang.String getUserMame() {
        return this.userMame;
    }

    /**
     *  ���� userMame.
     *  @param userMame userMame��.
     */
    public void setUserMame(java.lang.String userMame) {
        this.userMame = userMame;
    }
    /**
     *  ��ȡ operatorDatetime.
     *  @return java.util.Date.
     */
    public java.util.Date getOperatorDatetime() {
        return this.operatorDatetime;
    }

    /**
     *  ���� operatorDatetime.
     *  @param operatorDatetime operatorDatetime��.
     */
    public void setOperatorDatetime(java.util.Date operatorDatetime) {
        this.operatorDatetime = operatorDatetime;
    }
    /**
     *  ��ȡ ip.
     *  @return java.lang.String.
     */
    public java.lang.String getIp() {
        return this.ip;
    }

    /**
     *  ���� ip.
     *  @param ip ip��.
     */
    public void setIp(java.lang.String ip) {
        this.ip = ip;
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
     *  ��ȡ loginName.
     *  @return java.lang.String.
     */
    public java.lang.String getLoginName() {
        return this.loginName;
    }

    /**
     *  ���� loginName.
     *  @param loginName loginName��.
     */
    public void setLoginName(java.lang.String loginName) {
        this.loginName = loginName;
    }


}
