package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  定义类TruleInstanceMcc.
     */
public class TruleInstanceMcc extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  字段域id.
     */
    private java.lang.String id;

    /**
     *  字段域ruleInstanceId.
     */
    private java.lang.String ruleInstanceId;

    /**
     *  字段域param1.
     */
    private java.lang.String param1;

    /**
     *  字段域param2.
     */
    private java.lang.String param2;

    /**
     *  字段域param3.
     */
    private java.lang.String param3;

    /**
     *  字段域param4.
     */
    private java.lang.String param4;

    /**
     *  字段域mccCode.
     */
    private java.lang.String mccCode;

    /**
     *  字段域riskThreshold.
     */
    private java.lang.String riskThreshold;

    /**
     *  字段域bigmccCode.
     */
    private java.lang.String bigmccCode;

    /**
     *  字段域mccId.
     */
    private java.lang.String mccId;


    /**
     *  域ruleInstanceIdOfTruleInstance.
     */
    private TruleInstance ruleInstanceIdOfTruleInstance;
    /**
     *  域mccIdOfTmcc.
     */
    private Tmcc mccIdOfTmcc;

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
     *  获取 param1.
     *  @return java.lang.String.
     */
    public java.lang.String getParam1() {
        return this.param1;
    }

    /**
     *  设置 param1.
     *  @param param1 param1域.
     */
    public void setParam1(java.lang.String param1) {
        this.param1 = param1;
    }
    /**
     *  获取 param2.
     *  @return java.lang.String.
     */
    public java.lang.String getParam2() {
        return this.param2;
    }

    /**
     *  设置 param2.
     *  @param param2 param2域.
     */
    public void setParam2(java.lang.String param2) {
        this.param2 = param2;
    }
    /**
     *  获取 param3.
     *  @return java.lang.String.
     */
    public java.lang.String getParam3() {
        return this.param3;
    }

    /**
     *  设置 param3.
     *  @param param3 param3域.
     */
    public void setParam3(java.lang.String param3) {
        this.param3 = param3;
    }
    /**
     *  获取 param4.
     *  @return java.lang.String.
     */
    public java.lang.String getParam4() {
        return this.param4;
    }

    /**
     *  设置 param4.
     *  @param param4 param4域.
     */
    public void setParam4(java.lang.String param4) {
        this.param4 = param4;
    }
    /**
     *  获取 mccCode.
     *  @return java.lang.String.
     */
    public java.lang.String getMccCode() {
        return this.mccCode;
    }

    /**
     *  设置 mccCode.
     *  @param mccCode mccCode域.
     */
    public void setMccCode(java.lang.String mccCode) {
        this.mccCode = mccCode;
    }
    /**
     *  获取 riskThreshold.
     *  @return java.lang.String.
     */
    public java.lang.String getRiskThreshold() {
        return this.riskThreshold;
    }

    /**
     *  设置 riskThreshold.
     *  @param riskThreshold riskThreshold域.
     */
    public void setRiskThreshold(java.lang.String riskThreshold) {
        this.riskThreshold = riskThreshold;
    }
    /**
     *  获取 bigmccCode.
     *  @return java.lang.String.
     */
    public java.lang.String getBigmccCode() {
        return this.bigmccCode;
    }

    /**
     *  设置 bigmccCode.
     *  @param bigmccCode bigmccCode域.
     */
    public void setBigmccCode(java.lang.String bigmccCode) {
        this.bigmccCode = bigmccCode;
    }
    /**
     *  获取 mccId.
     *  @return java.lang.String.
     */
    public java.lang.String getMccId() {
        return this.mccId;
    }

    /**
     *  设置 mccId.
     *  @param mccId mccId域.
     */
    public void setMccId(java.lang.String mccId) {
        this.mccId = mccId;
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



    /**
     *  获取 mccIdOfTmcc.
     *  @return Tmcc.
     */
    public Tmcc getMccIdOfTmcc() {
    	if (this.mccIdOfTmcc == null && this.mccId != null  && !"".equals(this.mccId)){
    		TmccDAO tmccDAO = (TmccDAO)Tools.getBean("tmccDAO");
    		this.mccIdOfTmcc= tmccDAO.getTmcc(this.mccId);
    	}
        return this.mccIdOfTmcc;
    }

    /**
     *  设置 mccIdOfTmcc.
     *  @param mccIdOfTmcc mccIdOfTmcc域.
     */
    public void setMccIdOfTmcc(Tmcc mccIdOfTmcc) {
        this.mccIdOfTmcc = mccIdOfTmcc;
    }

}
