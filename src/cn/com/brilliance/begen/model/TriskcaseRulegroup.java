package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  ������TriskcaseRulegroup.
     */
public class TriskcaseRulegroup extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

/*
1,1
*/
    /**
     *  �ֶ���riskCaseId.
     */
    private java.lang.String riskCaseId;

/*
1,1
*/
    /**
     *  �ֶ���ruleGroupId.
     */
    private java.lang.String ruleGroupId;



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
     *  ��ȡ riskCaseId.
     *  @return java.lang.String.
     */
    public java.lang.String getRiskCaseId() {
        return this.riskCaseId;
    }

    /**
     *  ���� riskCaseId.
     *  @param riskCaseId riskCaseId��.
     */
    public void setRiskCaseId(java.lang.String riskCaseId) {
        this.riskCaseId = riskCaseId;
    }
    /**
     *  ��ȡ ruleGroupId.
     *  @return java.lang.String.
     */
    public java.lang.String getRuleGroupId() {
        return this.ruleGroupId;
    }

    /**
     *  ���� ruleGroupId.
     *  @param ruleGroupId ruleGroupId��.
     */
    public void setRuleGroupId(java.lang.String ruleGroupId) {
        this.ruleGroupId = ruleGroupId;
    }


}
