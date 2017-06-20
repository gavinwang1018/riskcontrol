package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  ������TruleInstanceGroupSegment.
     */
public class TruleInstanceGroupSegment extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���propertion.
     */
    private java.lang.Float propertion;

    /**
     *  �ֶ���ruleInstanceGroupId.
     */
    private java.lang.String ruleInstanceGroupId;

    /**
     *  �ֶ���begin.
     */
    private java.lang.Float begin;

    /**
     *  �ֶ���end.
     */
    private java.lang.Float end;

    /**
     *  �ֶ���ruleInstanceId.
     */
    private java.lang.String ruleInstanceId;

    /**
     *  �ֶ���value.
     */
    private java.lang.Float value;


    /**
     *  ��ruleInstanceGroupIdOfTruleInstanceGroup.
     */
    private TruleInstanceGroup ruleInstanceGroupIdOfTruleInstanceGroup;
    /**
     *  ��ruleInstanceIdOfTruleInstance.
     */
    private TruleInstance ruleInstanceIdOfTruleInstance;

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
     *  ��ȡ propertion.
     *  @return java.lang.Float.
     */
    public java.lang.Float getPropertion() {
        return this.propertion;
    }

    /**
     *  ���� propertion.
     *  @param propertion propertion��.
     */
    public void setPropertion(java.lang.Float propertion) {
        this.propertion = propertion;
    }
    /**
     *  ��ȡ ruleInstanceGroupId.
     *  @return java.lang.String.
     */
    public java.lang.String getRuleInstanceGroupId() {
        return this.ruleInstanceGroupId;
    }

    /**
     *  ���� ruleInstanceGroupId.
     *  @param ruleInstanceGroupId ruleInstanceGroupId��.
     */
    public void setRuleInstanceGroupId(java.lang.String ruleInstanceGroupId) {
        this.ruleInstanceGroupId = ruleInstanceGroupId;
    }
    /**
     *  ��ȡ begin.
     *  @return java.lang.Float.
     */
    public java.lang.Float getBegin() {
        return this.begin;
    }

    /**
     *  ���� begin.
     *  @param begin begin��.
     */
    public void setBegin(java.lang.Float begin) {
        this.begin = begin;
    }
    /**
     *  ��ȡ end.
     *  @return java.lang.Float.
     */
    public java.lang.Float getEnd() {
        return this.end;
    }

    /**
     *  ���� end.
     *  @param end end��.
     */
    public void setEnd(java.lang.Float end) {
        this.end = end;
    }
    /**
     *  ��ȡ ruleInstanceId.
     *  @return java.lang.String.
     */
    public java.lang.String getRuleInstanceId() {
        return this.ruleInstanceId;
    }

    /**
     *  ���� ruleInstanceId.
     *  @param ruleInstanceId ruleInstanceId��.
     */
    public void setRuleInstanceId(java.lang.String ruleInstanceId) {
        this.ruleInstanceId = ruleInstanceId;
    }
    /**
     *  ��ȡ value.
     *  @return java.lang.Float.
     */
    public java.lang.Float getValue() {
        return this.value;
    }

    /**
     *  ���� value.
     *  @param value value��.
     */
    public void setValue(java.lang.Float value) {
        this.value = value;
    }




    /**
     *  ��ȡ ruleInstanceGroupIdOfTruleInstanceGroup.
     *  @return TruleInstanceGroup.
     */
    public TruleInstanceGroup getRuleInstanceGroupIdOfTruleInstanceGroup() {
    	if (this.ruleInstanceGroupIdOfTruleInstanceGroup == null && this.ruleInstanceGroupId != null  && !"".equals(this.ruleInstanceGroupId)){
    		TruleInstanceGroupDAO truleInstanceGroupDAO = (TruleInstanceGroupDAO)Tools.getBean("truleInstanceGroupDAO");
    		this.ruleInstanceGroupIdOfTruleInstanceGroup= truleInstanceGroupDAO.getTruleInstanceGroup(this.ruleInstanceGroupId);
    	}
        return this.ruleInstanceGroupIdOfTruleInstanceGroup;
    }

    /**
     *  ���� ruleInstanceGroupIdOfTruleInstanceGroup.
     *  @param ruleInstanceGroupIdOfTruleInstanceGroup ruleInstanceGroupIdOfTruleInstanceGroup��.
     */
    public void setRuleInstanceGroupIdOfTruleInstanceGroup(TruleInstanceGroup ruleInstanceGroupIdOfTruleInstanceGroup) {
        this.ruleInstanceGroupIdOfTruleInstanceGroup = ruleInstanceGroupIdOfTruleInstanceGroup;
    }



    /**
     *  ��ȡ ruleInstanceIdOfTruleInstance.
     *  @return TruleInstance.
     */
    public TruleInstance getRuleInstanceIdOfTruleInstance() {
    	if (this.ruleInstanceIdOfTruleInstance == null && this.ruleInstanceId != null  && !"".equals(this.ruleInstanceId)){
    		TruleInstanceDAO truleInstanceDAO = (TruleInstanceDAO)Tools.getBean("truleInstanceDAO");
    		this.ruleInstanceIdOfTruleInstance= truleInstanceDAO.getTruleInstance(this.ruleInstanceId);
    	}
        return this.ruleInstanceIdOfTruleInstance;
    }

    /**
     *  ���� ruleInstanceIdOfTruleInstance.
     *  @param ruleInstanceIdOfTruleInstance ruleInstanceIdOfTruleInstance��.
     */
    public void setRuleInstanceIdOfTruleInstance(TruleInstance ruleInstanceIdOfTruleInstance) {
        this.ruleInstanceIdOfTruleInstance = ruleInstanceIdOfTruleInstance;
    }

}
