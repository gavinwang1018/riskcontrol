package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  定义类SysLoginfo.
     */
public class SysLoginfo extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  字段域id.
     */
    private java.lang.String id;

    /**
     *  字段域operator.
     */
    private java.lang.String operator;

/*
1,登陆/退出
2,菜单操作
3,表单动作
4,数据增加
5,数据修改
6,数据删除
7,数据查询
*/
    /**
     *  字段域operationType.
     */
    private java.lang.String operationType;

    /**
     *  字段域operationTitle.
     */
    private java.lang.String operationTitle;

    /**
     *  字段域operationTime.
     */
    private java.util.Date operationTime;

    /**
     *  字段域clientIp.
     */
    private java.lang.String clientIp;

    /**
     *  字段域terminalType.
     */
    private java.lang.String terminalType;


    /**
     *  域operatorOfSysUser.
     */
    private SysUser operatorOfSysUser;

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
     *  获取 operator.
     *  @return java.lang.String.
     */
    public java.lang.String getOperator() {
        return this.operator;
    }

    /**
     *  设置 operator.
     *  @param operator operator域.
     */
    public void setOperator(java.lang.String operator) {
        this.operator = operator;
    }
    /**
     *  获取 operationType.
     *  @return java.lang.String.
     */
    public java.lang.String getOperationType() {
        return this.operationType;
    }

    /**
     *  设置 operationType.
     *  @param operationType operationType域.
     */
    public void setOperationType(java.lang.String operationType) {
        this.operationType = operationType;
    }
    /**
     *  获取 operationTitle.
     *  @return java.lang.String.
     */
    public java.lang.String getOperationTitle() {
        return this.operationTitle;
    }

    /**
     *  设置 operationTitle.
     *  @param operationTitle operationTitle域.
     */
    public void setOperationTitle(java.lang.String operationTitle) {
        this.operationTitle = operationTitle;
    }
    /**
     *  获取 operationTime.
     *  @return java.util.Date.
     */
    public java.util.Date getOperationTime() {
        return this.operationTime;
    }

    /**
     *  设置 operationTime.
     *  @param operationTime operationTime域.
     */
    public void setOperationTime(java.util.Date operationTime) {
        this.operationTime = operationTime;
    }
    /**
     *  获取 clientIp.
     *  @return java.lang.String.
     */
    public java.lang.String getClientIp() {
        return this.clientIp;
    }

    /**
     *  设置 clientIp.
     *  @param clientIp clientIp域.
     */
    public void setClientIp(java.lang.String clientIp) {
        this.clientIp = clientIp;
    }
    /**
     *  获取 terminalType.
     *  @return java.lang.String.
     */
    public java.lang.String getTerminalType() {
        return this.terminalType;
    }

    /**
     *  设置 terminalType.
     *  @param terminalType terminalType域.
     */
    public void setTerminalType(java.lang.String terminalType) {
        this.terminalType = terminalType;
    }




    /**
     *  获取 operatorOfSysUser.
     *  @return SysUser.
     */
    public SysUser getOperatorOfSysUser() {
    	if (this.operatorOfSysUser == null && this.operator != null  && !"".equals(this.operator)){
    		SysUserDAO sysUserDAO = (SysUserDAO)Tools.getBean("sysUserDAO");
    		this.operatorOfSysUser= sysUserDAO.getSysUser(this.operator);
    	}
        return this.operatorOfSysUser;
    }

    /**
     *  设置 operatorOfSysUser.
     *  @param operatorOfSysUser operatorOfSysUser域.
     */
    public void setOperatorOfSysUser(SysUser operatorOfSysUser) {
        this.operatorOfSysUser = operatorOfSysUser;
    }

}
