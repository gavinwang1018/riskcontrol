package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  ������TruleInstanceMcc.
     */
public class TruleInstanceMcc extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���ruleInstanceId.
     */
    private java.lang.String ruleInstanceId;

    /**
     *  �ֶ���param1.
     */
    private java.lang.String param1;

    /**
     *  �ֶ���param2.
     */
    private java.lang.String param2;

    /**
     *  �ֶ���param3.
     */
    private java.lang.String param3;

    /**
     *  �ֶ���param4.
     */
    private java.lang.String param4;

    /**
     *  �ֶ���mccCode.
     */
    private java.lang.String mccCode;

    /**
     *  �ֶ���riskThreshold.
     */
    private java.lang.String riskThreshold;

    /**
     *  �ֶ���bigmccCode.
     */
    private java.lang.String bigmccCode;

    /**
     *  �ֶ���mccId.
     */
    private java.lang.String mccId;


    /**
     *  ��ruleInstanceIdOfTruleInstance.
     */
    private TruleInstance ruleInstanceIdOfTruleInstance;
    /**
     *  ��mccIdOfTmcc.
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
     *  ��ȡ param1.
     *  @return java.lang.String.
     */
    public java.lang.String getParam1() {
        return this.param1;
    }

    /**
     *  ���� param1.
     *  @param param1 param1��.
     */
    public void setParam1(java.lang.String param1) {
        this.param1 = param1;
    }
    /**
     *  ��ȡ param2.
     *  @return java.lang.String.
     */
    public java.lang.String getParam2() {
        return this.param2;
    }

    /**
     *  ���� param2.
     *  @param param2 param2��.
     */
    public void setParam2(java.lang.String param2) {
        this.param2 = param2;
    }
    /**
     *  ��ȡ param3.
     *  @return java.lang.String.
     */
    public java.lang.String getParam3() {
        return this.param3;
    }

    /**
     *  ���� param3.
     *  @param param3 param3��.
     */
    public void setParam3(java.lang.String param3) {
        this.param3 = param3;
    }
    /**
     *  ��ȡ param4.
     *  @return java.lang.String.
     */
    public java.lang.String getParam4() {
        return this.param4;
    }

    /**
     *  ���� param4.
     *  @param param4 param4��.
     */
    public void setParam4(java.lang.String param4) {
        this.param4 = param4;
    }
    /**
     *  ��ȡ mccCode.
     *  @return java.lang.String.
     */
    public java.lang.String getMccCode() {
        return this.mccCode;
    }

    /**
     *  ���� mccCode.
     *  @param mccCode mccCode��.
     */
    public void setMccCode(java.lang.String mccCode) {
        this.mccCode = mccCode;
    }
    /**
     *  ��ȡ riskThreshold.
     *  @return java.lang.String.
     */
    public java.lang.String getRiskThreshold() {
        return this.riskThreshold;
    }

    /**
     *  ���� riskThreshold.
     *  @param riskThreshold riskThreshold��.
     */
    public void setRiskThreshold(java.lang.String riskThreshold) {
        this.riskThreshold = riskThreshold;
    }
    /**
     *  ��ȡ bigmccCode.
     *  @return java.lang.String.
     */
    public java.lang.String getBigmccCode() {
        return this.bigmccCode;
    }

    /**
     *  ���� bigmccCode.
     *  @param bigmccCode bigmccCode��.
     */
    public void setBigmccCode(java.lang.String bigmccCode) {
        this.bigmccCode = bigmccCode;
    }
    /**
     *  ��ȡ mccId.
     *  @return java.lang.String.
     */
    public java.lang.String getMccId() {
        return this.mccId;
    }

    /**
     *  ���� mccId.
     *  @param mccId mccId��.
     */
    public void setMccId(java.lang.String mccId) {
        this.mccId = mccId;
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



    /**
     *  ��ȡ mccIdOfTmcc.
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
     *  ���� mccIdOfTmcc.
     *  @param mccIdOfTmcc mccIdOfTmcc��.
     */
    public void setMccIdOfTmcc(Tmcc mccIdOfTmcc) {
        this.mccIdOfTmcc = mccIdOfTmcc;
    }

}
