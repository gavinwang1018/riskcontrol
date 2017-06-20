package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  定义类TriskcaseRecord.
     */
public class TriskcaseRecord extends BaseModel implements Serializable {
	
	private java.lang.Boolean isLocked;

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  字段域id.
     */
    private java.lang.String id;

    /**
     *  字段域riskcaseId.
     */
    private java.lang.String riskcaseId;

    /**
     *  字段域investigationDate.
     */
    private java.util.Date investigationDate;

    /**
     *  字段域createDate.
     */
    private java.util.Date createDate;

/*
0,实地调查
1,电话调查
2,信函调查
3,其它方式
*/
    /**
     *  字段域investigationWay.
     */
    private java.lang.String investigationWay;

    /**
     *  字段域isPickFlow.
     */
    private java.lang.Boolean isPickFlow;

    /**
     *  字段域pickCnt.
     */
    private java.lang.Integer pickCnt;

    /**
     *  字段域pickAmt.
     */
    private java.lang.Double pickAmt;

    /**
     *  字段域pick180Cnt.
     */
    private java.lang.Integer pick180Cnt;

    /**
     *  字段域pick180Amt.
     */
    private java.lang.Double pick180Amt;

/*
0,单据合规无瑕疵
1,单据有瑕疵
2,商户无法提供单据
*/
    /**
     *  字段域pickStatus.
     */
    private java.lang.String pickStatus;

    /**
     *  字段域pickFlawCnt.
     */
    private java.lang.String pickFlawCnt;

    /**
     *  字段域pickEmptyCnt.
     */
    private java.lang.String pickEmptyCnt;

/*
1,有风险
0,无风险
*/
    /**
     *  字段域investigationResult.
     */
    private java.lang.String investigationResult;

/*
0,危险
1,较高
2,一般
3,较低
*/
    /**
     *  字段域riskLevel.
     */
    private java.lang.String riskLevel;

/*
0,套现
1,侧录
2,洗单
3,虚假申请
4,其它
*/
    /**
     *  字段域riskType.
     */
    private java.lang.String riskType;

/*
00,口头警告
01,书面警告
10,暂停交易
11,暂缓资金结算
12,撤机
13,其他
*/
    /**
     *  字段域processType.
     */
    private java.lang.String processType;
    
    private java.lang.String process2Type;

    /**
     *  字段域processFreezeAmt.
     */
    private java.lang.Double processFreezeAmt;

    /**
     *  字段域processWithdrawCnt.
     */
    private java.lang.Integer processWithdrawCnt;

    /**
     *  字段域description.
     */
    private java.lang.String description;

    /**
     *  字段域caseno.
     */
    private java.lang.String caseno;

    /**
     *  字段域userId.
     */
    private java.lang.String userId;

    /**
     *  字段域submit.
     */
    private java.lang.Boolean submit;

    /**
     *  字段域otherInvestigationWay.
     */
    private java.lang.String otherInvestigationWay;

    /**
     *  字段域otherRiskType.
     */
    private java.lang.String otherRiskType;

    /**
     *  字段域otherProcessType.
     */
    private java.lang.String otherProcessType;
    
    private java.lang.String reason;


    /**
     *  域riskcaseIdOfTriskcase.
     */
    private Triskcase riskcaseIdOfTriskcase;
    /**
     *  域casenoOfTriskcase.
     */
    private Triskcase casenoOfTriskcase;

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
     *  获取 riskcaseId.
     *  @return java.lang.String.
     */
    public java.lang.String getRiskcaseId() {
        return this.riskcaseId;
    }

    /**
     *  设置 riskcaseId.
     *  @param riskcaseId riskcaseId域.
     */
    public void setRiskcaseId(java.lang.String riskcaseId) {
        this.riskcaseId = riskcaseId;
    }
    /**
     *  获取 investigationDate.
     *  @return java.util.Date.
     */
    public java.util.Date getInvestigationDate() {
        return this.investigationDate;
    }

    /**
     *  设置 investigationDate.
     *  @param investigationDate investigationDate域.
     */
    public void setInvestigationDate(java.util.Date investigationDate) {
        this.investigationDate = investigationDate;
    }
    /**
     *  获取 createDate.
     *  @return java.util.Date.
     */
    public java.util.Date getCreateDate() {
        return this.createDate;
    }

    /**
     *  设置 createDate.
     *  @param createDate createDate域.
     */
    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }
    /**
     *  获取 investigationWay.
     *  @return java.lang.String.
     */
    public java.lang.String getInvestigationWay() {
        return this.investigationWay;
    }

    /**
     *  设置 investigationWay.
     *  @param investigationWay investigationWay域.
     */
    public void setInvestigationWay(java.lang.String investigationWay) {
        this.investigationWay = investigationWay;
    }
    /**
     *  获取 isPickFlow.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getIsPickFlow() {
        return this.isPickFlow;
    }

    /**
     *  设置 isPickFlow.
     *  @param isPickFlow isPickFlow域.
     */
    public void setIsPickFlow(java.lang.Boolean isPickFlow) {
        this.isPickFlow = isPickFlow;
    }
    /**
     *  获取 pickCnt.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getPickCnt() {
        return this.pickCnt;
    }

    /**
     *  设置 pickCnt.
     *  @param pickCnt pickCnt域.
     */
    public void setPickCnt(java.lang.Integer pickCnt) {
        this.pickCnt = pickCnt;
    }
    /**
     *  获取 pickAmt.
     *  @return java.lang.Integer.
     */
    public java.lang.Double getPickAmt() {
        return this.pickAmt;
    }

    /**
     *  设置 pickAmt.
     *  @param pickAmt pickAmt域.
     */
    public void setPickAmt(java.lang.Double pickAmt) {
        this.pickAmt = pickAmt;
    }
    /**
     *  获取 pick180Cnt.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getPick180Cnt() {
        return this.pick180Cnt;
    }

    /**
     *  设置 pick180Cnt.
     *  @param pick180Cnt pick180Cnt域.
     */
    public void setPick180Cnt(java.lang.Integer pick180Cnt) {
        this.pick180Cnt = pick180Cnt;
    }
    /**
     *  获取 pick180Amt.
     *  @return java.lang.Integer.
     */
    public java.lang.Double getPick180Amt() {
        return this.pick180Amt;
    }

    /**
     *  设置 pick180Amt.
     *  @param pick180Amt pick180Amt域.
     */
    public void setPick180Amt(java.lang.Double pick180Amt) {
        this.pick180Amt = pick180Amt;
    }
    /**
     *  获取 pickStatus.
     *  @return java.lang.String.
     */
    public java.lang.String getPickStatus() {
        return this.pickStatus;
    }

    /**
     *  设置 pickStatus.
     *  @param pickStatus pickStatus域.
     */
    public void setPickStatus(java.lang.String pickStatus) {
        this.pickStatus = pickStatus;
    }
    /**
     *  获取 pickFlawCnt.
     *  @return java.lang.Integer.
     */
    public java.lang.String getPickFlawCnt() {
        return this.pickFlawCnt;
    }

    /**
     *  设置 pickFlawCnt.
     *  @param pickFlawCnt pickFlawCnt域.
     */
    public void setPickFlawCnt(java.lang.String pickFlawCnt) {
        this.pickFlawCnt = pickFlawCnt;
    }
    /**
     *  获取 pickEmptyCnt.
     *  @return java.lang.Integer.
     */
    public java.lang.String getPickEmptyCnt() {
        return this.pickEmptyCnt;
    }

    /**
     *  设置 pickEmptyCnt.
     *  @param pickEmptyCnt pickEmptyCnt域.
     */
    public void setPickEmptyCnt(java.lang.String pickEmptyCnt) {
        this.pickEmptyCnt = pickEmptyCnt;
    }
    /**
     *  获取 investigationResult.
     *  @return java.lang.String.
     */
    public java.lang.String getInvestigationResult() {
        return this.investigationResult;
    }

    /**
     *  设置 investigationResult.
     *  @param investigationResult investigationResult域.
     */
    public void setInvestigationResult(java.lang.String investigationResult) {
        this.investigationResult = investigationResult;
    }
    /**
     *  获取 riskLevel.
     *  @return java.lang.String.
     */
    public java.lang.String getRiskLevel() {
        return this.riskLevel;
    }

    /**
     *  设置 riskLevel.
     *  @param riskLevel riskLevel域.
     */
    public void setRiskLevel(java.lang.String riskLevel) {
        this.riskLevel = riskLevel;
    }
    /**
     *  获取 riskType.
     *  @return java.lang.String.
     */
    public java.lang.String getRiskType() {
        return this.riskType;
    }

    /**
     *  设置 riskType.
     *  @param riskType riskType域.
     */
    public void setRiskType(java.lang.String riskType) {
        this.riskType = riskType;
    }
    /**
     *  获取 processType.
     *  @return java.lang.String.
     */
    public java.lang.String getProcessType() {
        return this.processType;
    }

    /**
     *  设置 processType.
     *  @param processType processType域.
     */
    public void setProcessType(java.lang.String processType) {
        this.processType = processType;
    }
    /**
     *  获取 processFreezeAmt.
     *  @return java.lang.Integer.
     */
    public java.lang.Double getProcessFreezeAmt() {
        return this.processFreezeAmt;
    }

    /**
     *  设置 processFreezeAmt.
     *  @param processFreezeAmt processFreezeAmt域.
     */
    public void setProcessFreezeAmt(java.lang.Double processFreezeAmt) {
        this.processFreezeAmt = processFreezeAmt;
    }
    /**
     *  获取 processWithdrawCnt.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getProcessWithdrawCnt() {
        return this.processWithdrawCnt;
    }

    /**
     *  设置 processWithdrawCnt.
     *  @param processWithdrawCnt processWithdrawCnt域.
     */
    public void setProcessWithdrawCnt(java.lang.Integer processWithdrawCnt) {
        this.processWithdrawCnt = processWithdrawCnt;
    }
    /**
     *  获取 description.
     *  @return java.lang.String.
     */
    public java.lang.String getDescription() {
        return this.description;
    }

    /**
     *  设置 description.
     *  @param description description域.
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }
    /**
     *  获取 caseno.
     *  @return java.lang.String.
     */
    public java.lang.String getCaseno() {
        return this.caseno;
    }

    /**
     *  设置 caseno.
     *  @param caseno caseno域.
     */
    public void setCaseno(java.lang.String caseno) {
        this.caseno = caseno;
    }
    /**
     *  获取 userId.
     *  @return java.lang.String.
     */
    public java.lang.String getUserId() {
        return this.userId;
    }

    /**
     *  设置 userId.
     *  @param userId userId域.
     */
    public void setUserId(java.lang.String userId) {
        this.userId = userId;
    }
    /**
     *  获取 submit.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getSubmit() {
        return this.submit;
    }

    /**
     *  设置 submit.
     *  @param submit submit域.
     */
    public void setSubmit(java.lang.Boolean submit) {
        this.submit = submit;
    }
    /**
     *  获取 otherInvestigationWay.
     *  @return java.lang.String.
     */
    public java.lang.String getOtherInvestigationWay() {
        return this.otherInvestigationWay;
    }

    /**
     *  设置 otherInvestigationWay.
     *  @param otherInvestigationWay otherInvestigationWay域.
     */
    public void setOtherInvestigationWay(java.lang.String otherInvestigationWay) {
        this.otherInvestigationWay = otherInvestigationWay;
    }
    /**
     *  获取 otherRiskType.
     *  @return java.lang.String.
     */
    public java.lang.String getOtherRiskType() {
        return this.otherRiskType;
    }

    /**
     *  设置 otherRiskType.
     *  @param otherRiskType otherRiskType域.
     */
    public void setOtherRiskType(java.lang.String otherRiskType) {
        this.otherRiskType = otherRiskType;
    }
    /**
     *  获取 otherProcessType.
     *  @return java.lang.String.
     */
    public java.lang.String getOtherProcessType() {
        return this.otherProcessType;
    }

    /**
     *  设置 otherProcessType.
     *  @param otherProcessType otherProcessType域.
     */
    public void setOtherProcessType(java.lang.String otherProcessType) {
        this.otherProcessType = otherProcessType;
    }




    /**
     *  获取 riskcaseIdOfTriskcase.
     *  @return Triskcase.
     */
    public Triskcase getRiskcaseIdOfTriskcase() {
    	if (this.riskcaseIdOfTriskcase == null && this.riskcaseId != null  && !"".equals(this.riskcaseId)){
    		TriskcaseDAO triskcaseDAO = (TriskcaseDAO)Tools.getBean("triskcaseDAO");
    		this.riskcaseIdOfTriskcase= triskcaseDAO.getTriskcase(this.riskcaseId);
    	}
        return this.riskcaseIdOfTriskcase;
    }

    /**
     *  设置 riskcaseIdOfTriskcase.
     *  @param riskcaseIdOfTriskcase riskcaseIdOfTriskcase域.
     */
    public void setRiskcaseIdOfTriskcase(Triskcase riskcaseIdOfTriskcase) {
        this.riskcaseIdOfTriskcase = riskcaseIdOfTriskcase;
    }



    /**
     *  获取 casenoOfTriskcase.
     *  @return Triskcase.
     */
    public Triskcase getCasenoOfTriskcase() {
    	if (this.casenoOfTriskcase == null && this.caseno != null  && !"".equals(this.caseno)){
    		TriskcaseDAO triskcaseDAO = (TriskcaseDAO)Tools.getBean("triskcaseDAO");
    		this.casenoOfTriskcase= triskcaseDAO.getTriskcase(this.caseno);
    	}
        return this.casenoOfTriskcase;
    }

    /**
     *  设置 casenoOfTriskcase.
     *  @param casenoOfTriskcase casenoOfTriskcase域.
     */
    public void setCasenoOfTriskcase(Triskcase casenoOfTriskcase) {
        this.casenoOfTriskcase = casenoOfTriskcase;
    }

	public java.lang.String getReason() {
		return reason;
	}

	public void setReason(java.lang.String reason) {
		this.reason = reason;
	}

	public java.lang.String getProcess2Type() {
		return process2Type;
	}

	public void setProcess2Type(java.lang.String process2Type) {
		this.process2Type = process2Type;
	}

	public java.lang.Boolean getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(java.lang.Boolean isLocked) {
		this.isLocked = isLocked;
	}

}
