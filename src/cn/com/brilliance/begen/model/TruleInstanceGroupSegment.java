package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  定义类TruleInstanceGroupSegment.
     */
public class TruleInstanceGroupSegment extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  字段域id.
     */
    private java.lang.String id;

    /**
     *  字段域propertion.
     */
    private java.lang.Float propertion;

    /**
     *  字段域ruleInstanceGroupId.
     */
    private java.lang.String ruleInstanceGroupId;

    /**
     *  字段域begin.
     */
    private java.lang.Float begin;

    /**
     *  字段域end.
     */
    private java.lang.Float end;

    /**
     *  字段域ruleInstanceId.
     */
    private java.lang.String ruleInstanceId;

    /**
     *  字段域value.
     */
    private java.lang.Float value;


    /**
     *  域ruleInstanceGroupIdOfTruleInstanceGroup.
     */
    private TruleInstanceGroup ruleInstanceGroupIdOfTruleInstanceGroup;
    /**
     *  域ruleInstanceIdOfTruleInstance.
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
     *  获取 propertion.
     *  @return java.lang.Float.
     */
    public java.lang.Float getPropertion() {
        return this.propertion;
    }

    /**
     *  设置 propertion.
     *  @param propertion propertion域.
     */
    public void setPropertion(java.lang.Float propertion) {
        this.propertion = propertion;
    }
    /**
     *  获取 ruleInstanceGroupId.
     *  @return java.lang.String.
     */
    public java.lang.String getRuleInstanceGroupId() {
        return this.ruleInstanceGroupId;
    }

    /**
     *  设置 ruleInstanceGroupId.
     *  @param ruleInstanceGroupId ruleInstanceGroupId域.
     */
    public void setRuleInstanceGroupId(java.lang.String ruleInstanceGroupId) {
        this.ruleInstanceGroupId = ruleInstanceGroupId;
    }
    /**
     *  获取 begin.
     *  @return java.lang.Float.
     */
    public java.lang.Float getBegin() {
        return this.begin;
    }

    /**
     *  设置 begin.
     *  @param begin begin域.
     */
    public void setBegin(java.lang.Float begin) {
        this.begin = begin;
    }
    /**
     *  获取 end.
     *  @return java.lang.Float.
     */
    public java.lang.Float getEnd() {
        return this.end;
    }

    /**
     *  设置 end.
     *  @param end end域.
     */
    public void setEnd(java.lang.Float end) {
        this.end = end;
    }
    /**
     *  获取 ruleInstanceId.
     *  @return java.lang.String.
     */
    public java.lang.String getRuleInstanceId() {
        return this.ruleInstanceId;
    }

    /**
     *  设置 ruleInstanceId.
     *  @param ruleInstanceId ruleInstanceId域.
     */
    public void setRuleInstanceId(java.lang.String ruleInstanceId) {
        this.ruleInstanceId = ruleInstanceId;
    }
    /**
     *  获取 value.
     *  @return java.lang.Float.
     */
    public java.lang.Float getValue() {
        return this.value;
    }

    /**
     *  设置 value.
     *  @param value value域.
     */
    public void setValue(java.lang.Float value) {
        this.value = value;
    }




    /**
     *  获取 ruleInstanceGroupIdOfTruleInstanceGroup.
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
     *  设置 ruleInstanceGroupIdOfTruleInstanceGroup.
     *  @param ruleInstanceGroupIdOfTruleInstanceGroup ruleInstanceGroupIdOfTruleInstanceGroup域.
     */
    public void setRuleInstanceGroupIdOfTruleInstanceGroup(TruleInstanceGroup ruleInstanceGroupIdOfTruleInstanceGroup) {
        this.ruleInstanceGroupIdOfTruleInstanceGroup = ruleInstanceGroupIdOfTruleInstanceGroup;
    }



    /**
     *  获取 ruleInstanceIdOfTruleInstance.
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
     *  设置 ruleInstanceIdOfTruleInstance.
     *  @param ruleInstanceIdOfTruleInstance ruleInstanceIdOfTruleInstance域.
     */
    public void setRuleInstanceIdOfTruleInstance(TruleInstance ruleInstanceIdOfTruleInstance) {
        this.ruleInstanceIdOfTruleInstance = ruleInstanceIdOfTruleInstance;
    }

}
