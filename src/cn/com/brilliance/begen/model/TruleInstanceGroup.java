package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  定义类TruleInstanceGroup.
     */
public class TruleInstanceGroup extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  字段域id.
     */
    private java.lang.String id;

    /**
     *  字段域ruleGroupId.
     */
    private java.lang.String ruleGroupId;

    /**
     *  字段域ruleInstanceId.
     */
    private java.lang.String ruleInstanceId;


    /**
     *  域ruleGroupIdOfTruleGroup.
     */
    private TruleGroup ruleGroupIdOfTruleGroup;
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
     *  获取 ruleGroupId.
     *  @return java.lang.String.
     */
    public java.lang.String getRuleGroupId() {
        return this.ruleGroupId;
    }

    /**
     *  设置 ruleGroupId.
     *  @param ruleGroupId ruleGroupId域.
     */
    public void setRuleGroupId(java.lang.String ruleGroupId) {
        this.ruleGroupId = ruleGroupId;
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
     *  获取 ruleGroupIdOfTruleGroup.
     *  @return TruleGroup.
     */
    public TruleGroup getRuleGroupIdOfTruleGroup() {
    	if (this.ruleGroupIdOfTruleGroup == null && this.ruleGroupId != null  && !"".equals(this.ruleGroupId)){
    		TruleGroupDAO truleGroupDAO = (TruleGroupDAO)Tools.getBean("truleGroupDAO");
    		this.ruleGroupIdOfTruleGroup= truleGroupDAO.getTruleGroup(this.ruleGroupId);
    	}
        return this.ruleGroupIdOfTruleGroup;
    }

    /**
     *  设置 ruleGroupIdOfTruleGroup.
     *  @param ruleGroupIdOfTruleGroup ruleGroupIdOfTruleGroup域.
     */
    public void setRuleGroupIdOfTruleGroup(TruleGroup ruleGroupIdOfTruleGroup) {
        this.ruleGroupIdOfTruleGroup = ruleGroupIdOfTruleGroup;
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
