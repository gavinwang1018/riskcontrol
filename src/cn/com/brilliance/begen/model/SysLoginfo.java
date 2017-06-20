package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  ������SysLoginfo.
     */
public class SysLoginfo extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���operator.
     */
    private java.lang.String operator;

/*
1,��½/�˳�
2,�˵�����
3,������
4,��������
5,�����޸�
6,����ɾ��
7,���ݲ�ѯ
*/
    /**
     *  �ֶ���operationType.
     */
    private java.lang.String operationType;

    /**
     *  �ֶ���operationTitle.
     */
    private java.lang.String operationTitle;

    /**
     *  �ֶ���operationTime.
     */
    private java.util.Date operationTime;

    /**
     *  �ֶ���clientIp.
     */
    private java.lang.String clientIp;

    /**
     *  �ֶ���terminalType.
     */
    private java.lang.String terminalType;


    /**
     *  ��operatorOfSysUser.
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
     *  ��ȡ operator.
     *  @return java.lang.String.
     */
    public java.lang.String getOperator() {
        return this.operator;
    }

    /**
     *  ���� operator.
     *  @param operator operator��.
     */
    public void setOperator(java.lang.String operator) {
        this.operator = operator;
    }
    /**
     *  ��ȡ operationType.
     *  @return java.lang.String.
     */
    public java.lang.String getOperationType() {
        return this.operationType;
    }

    /**
     *  ���� operationType.
     *  @param operationType operationType��.
     */
    public void setOperationType(java.lang.String operationType) {
        this.operationType = operationType;
    }
    /**
     *  ��ȡ operationTitle.
     *  @return java.lang.String.
     */
    public java.lang.String getOperationTitle() {
        return this.operationTitle;
    }

    /**
     *  ���� operationTitle.
     *  @param operationTitle operationTitle��.
     */
    public void setOperationTitle(java.lang.String operationTitle) {
        this.operationTitle = operationTitle;
    }
    /**
     *  ��ȡ operationTime.
     *  @return java.util.Date.
     */
    public java.util.Date getOperationTime() {
        return this.operationTime;
    }

    /**
     *  ���� operationTime.
     *  @param operationTime operationTime��.
     */
    public void setOperationTime(java.util.Date operationTime) {
        this.operationTime = operationTime;
    }
    /**
     *  ��ȡ clientIp.
     *  @return java.lang.String.
     */
    public java.lang.String getClientIp() {
        return this.clientIp;
    }

    /**
     *  ���� clientIp.
     *  @param clientIp clientIp��.
     */
    public void setClientIp(java.lang.String clientIp) {
        this.clientIp = clientIp;
    }
    /**
     *  ��ȡ terminalType.
     *  @return java.lang.String.
     */
    public java.lang.String getTerminalType() {
        return this.terminalType;
    }

    /**
     *  ���� terminalType.
     *  @param terminalType terminalType��.
     */
    public void setTerminalType(java.lang.String terminalType) {
        this.terminalType = terminalType;
    }




    /**
     *  ��ȡ operatorOfSysUser.
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
     *  ���� operatorOfSysUser.
     *  @param operatorOfSysUser operatorOfSysUser��.
     */
    public void setOperatorOfSysUser(SysUser operatorOfSysUser) {
        this.operatorOfSysUser = operatorOfSysUser;
    }

}
