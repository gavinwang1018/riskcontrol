package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  ������TriskcaseRecord.
     */
public class TriskcaseRecord extends BaseModel implements Serializable {
	
	private java.lang.Boolean isLocked;

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���riskcaseId.
     */
    private java.lang.String riskcaseId;

    /**
     *  �ֶ���investigationDate.
     */
    private java.util.Date investigationDate;

    /**
     *  �ֶ���createDate.
     */
    private java.util.Date createDate;

/*
0,ʵ�ص���
1,�绰����
2,�ź�����
3,������ʽ
*/
    /**
     *  �ֶ���investigationWay.
     */
    private java.lang.String investigationWay;

    /**
     *  �ֶ���isPickFlow.
     */
    private java.lang.Boolean isPickFlow;

    /**
     *  �ֶ���pickCnt.
     */
    private java.lang.Integer pickCnt;

    /**
     *  �ֶ���pickAmt.
     */
    private java.lang.Double pickAmt;

    /**
     *  �ֶ���pick180Cnt.
     */
    private java.lang.Integer pick180Cnt;

    /**
     *  �ֶ���pick180Amt.
     */
    private java.lang.Double pick180Amt;

/*
0,���ݺϹ���覴�
1,������覴�
2,�̻��޷��ṩ����
*/
    /**
     *  �ֶ���pickStatus.
     */
    private java.lang.String pickStatus;

    /**
     *  �ֶ���pickFlawCnt.
     */
    private java.lang.String pickFlawCnt;

    /**
     *  �ֶ���pickEmptyCnt.
     */
    private java.lang.String pickEmptyCnt;

/*
1,�з���
0,�޷���
*/
    /**
     *  �ֶ���investigationResult.
     */
    private java.lang.String investigationResult;

/*
0,Σ��
1,�ϸ�
2,һ��
3,�ϵ�
*/
    /**
     *  �ֶ���riskLevel.
     */
    private java.lang.String riskLevel;

/*
0,����
1,��¼
2,ϴ��
3,�������
4,����
*/
    /**
     *  �ֶ���riskType.
     */
    private java.lang.String riskType;

/*
00,��ͷ����
01,���澯��
10,��ͣ����
11,�ݻ��ʽ����
12,����
13,����
*/
    /**
     *  �ֶ���processType.
     */
    private java.lang.String processType;
    
    private java.lang.String process2Type;

    /**
     *  �ֶ���processFreezeAmt.
     */
    private java.lang.Double processFreezeAmt;

    /**
     *  �ֶ���processWithdrawCnt.
     */
    private java.lang.Integer processWithdrawCnt;

    /**
     *  �ֶ���description.
     */
    private java.lang.String description;

    /**
     *  �ֶ���caseno.
     */
    private java.lang.String caseno;

    /**
     *  �ֶ���userId.
     */
    private java.lang.String userId;

    /**
     *  �ֶ���submit.
     */
    private java.lang.Boolean submit;

    /**
     *  �ֶ���otherInvestigationWay.
     */
    private java.lang.String otherInvestigationWay;

    /**
     *  �ֶ���otherRiskType.
     */
    private java.lang.String otherRiskType;

    /**
     *  �ֶ���otherProcessType.
     */
    private java.lang.String otherProcessType;
    
    private java.lang.String reason;


    /**
     *  ��riskcaseIdOfTriskcase.
     */
    private Triskcase riskcaseIdOfTriskcase;
    /**
     *  ��casenoOfTriskcase.
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
     *  ��ȡ riskcaseId.
     *  @return java.lang.String.
     */
    public java.lang.String getRiskcaseId() {
        return this.riskcaseId;
    }

    /**
     *  ���� riskcaseId.
     *  @param riskcaseId riskcaseId��.
     */
    public void setRiskcaseId(java.lang.String riskcaseId) {
        this.riskcaseId = riskcaseId;
    }
    /**
     *  ��ȡ investigationDate.
     *  @return java.util.Date.
     */
    public java.util.Date getInvestigationDate() {
        return this.investigationDate;
    }

    /**
     *  ���� investigationDate.
     *  @param investigationDate investigationDate��.
     */
    public void setInvestigationDate(java.util.Date investigationDate) {
        this.investigationDate = investigationDate;
    }
    /**
     *  ��ȡ createDate.
     *  @return java.util.Date.
     */
    public java.util.Date getCreateDate() {
        return this.createDate;
    }

    /**
     *  ���� createDate.
     *  @param createDate createDate��.
     */
    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }
    /**
     *  ��ȡ investigationWay.
     *  @return java.lang.String.
     */
    public java.lang.String getInvestigationWay() {
        return this.investigationWay;
    }

    /**
     *  ���� investigationWay.
     *  @param investigationWay investigationWay��.
     */
    public void setInvestigationWay(java.lang.String investigationWay) {
        this.investigationWay = investigationWay;
    }
    /**
     *  ��ȡ isPickFlow.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getIsPickFlow() {
        return this.isPickFlow;
    }

    /**
     *  ���� isPickFlow.
     *  @param isPickFlow isPickFlow��.
     */
    public void setIsPickFlow(java.lang.Boolean isPickFlow) {
        this.isPickFlow = isPickFlow;
    }
    /**
     *  ��ȡ pickCnt.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getPickCnt() {
        return this.pickCnt;
    }

    /**
     *  ���� pickCnt.
     *  @param pickCnt pickCnt��.
     */
    public void setPickCnt(java.lang.Integer pickCnt) {
        this.pickCnt = pickCnt;
    }
    /**
     *  ��ȡ pickAmt.
     *  @return java.lang.Integer.
     */
    public java.lang.Double getPickAmt() {
        return this.pickAmt;
    }

    /**
     *  ���� pickAmt.
     *  @param pickAmt pickAmt��.
     */
    public void setPickAmt(java.lang.Double pickAmt) {
        this.pickAmt = pickAmt;
    }
    /**
     *  ��ȡ pick180Cnt.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getPick180Cnt() {
        return this.pick180Cnt;
    }

    /**
     *  ���� pick180Cnt.
     *  @param pick180Cnt pick180Cnt��.
     */
    public void setPick180Cnt(java.lang.Integer pick180Cnt) {
        this.pick180Cnt = pick180Cnt;
    }
    /**
     *  ��ȡ pick180Amt.
     *  @return java.lang.Integer.
     */
    public java.lang.Double getPick180Amt() {
        return this.pick180Amt;
    }

    /**
     *  ���� pick180Amt.
     *  @param pick180Amt pick180Amt��.
     */
    public void setPick180Amt(java.lang.Double pick180Amt) {
        this.pick180Amt = pick180Amt;
    }
    /**
     *  ��ȡ pickStatus.
     *  @return java.lang.String.
     */
    public java.lang.String getPickStatus() {
        return this.pickStatus;
    }

    /**
     *  ���� pickStatus.
     *  @param pickStatus pickStatus��.
     */
    public void setPickStatus(java.lang.String pickStatus) {
        this.pickStatus = pickStatus;
    }
    /**
     *  ��ȡ pickFlawCnt.
     *  @return java.lang.Integer.
     */
    public java.lang.String getPickFlawCnt() {
        return this.pickFlawCnt;
    }

    /**
     *  ���� pickFlawCnt.
     *  @param pickFlawCnt pickFlawCnt��.
     */
    public void setPickFlawCnt(java.lang.String pickFlawCnt) {
        this.pickFlawCnt = pickFlawCnt;
    }
    /**
     *  ��ȡ pickEmptyCnt.
     *  @return java.lang.Integer.
     */
    public java.lang.String getPickEmptyCnt() {
        return this.pickEmptyCnt;
    }

    /**
     *  ���� pickEmptyCnt.
     *  @param pickEmptyCnt pickEmptyCnt��.
     */
    public void setPickEmptyCnt(java.lang.String pickEmptyCnt) {
        this.pickEmptyCnt = pickEmptyCnt;
    }
    /**
     *  ��ȡ investigationResult.
     *  @return java.lang.String.
     */
    public java.lang.String getInvestigationResult() {
        return this.investigationResult;
    }

    /**
     *  ���� investigationResult.
     *  @param investigationResult investigationResult��.
     */
    public void setInvestigationResult(java.lang.String investigationResult) {
        this.investigationResult = investigationResult;
    }
    /**
     *  ��ȡ riskLevel.
     *  @return java.lang.String.
     */
    public java.lang.String getRiskLevel() {
        return this.riskLevel;
    }

    /**
     *  ���� riskLevel.
     *  @param riskLevel riskLevel��.
     */
    public void setRiskLevel(java.lang.String riskLevel) {
        this.riskLevel = riskLevel;
    }
    /**
     *  ��ȡ riskType.
     *  @return java.lang.String.
     */
    public java.lang.String getRiskType() {
        return this.riskType;
    }

    /**
     *  ���� riskType.
     *  @param riskType riskType��.
     */
    public void setRiskType(java.lang.String riskType) {
        this.riskType = riskType;
    }
    /**
     *  ��ȡ processType.
     *  @return java.lang.String.
     */
    public java.lang.String getProcessType() {
        return this.processType;
    }

    /**
     *  ���� processType.
     *  @param processType processType��.
     */
    public void setProcessType(java.lang.String processType) {
        this.processType = processType;
    }
    /**
     *  ��ȡ processFreezeAmt.
     *  @return java.lang.Integer.
     */
    public java.lang.Double getProcessFreezeAmt() {
        return this.processFreezeAmt;
    }

    /**
     *  ���� processFreezeAmt.
     *  @param processFreezeAmt processFreezeAmt��.
     */
    public void setProcessFreezeAmt(java.lang.Double processFreezeAmt) {
        this.processFreezeAmt = processFreezeAmt;
    }
    /**
     *  ��ȡ processWithdrawCnt.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getProcessWithdrawCnt() {
        return this.processWithdrawCnt;
    }

    /**
     *  ���� processWithdrawCnt.
     *  @param processWithdrawCnt processWithdrawCnt��.
     */
    public void setProcessWithdrawCnt(java.lang.Integer processWithdrawCnt) {
        this.processWithdrawCnt = processWithdrawCnt;
    }
    /**
     *  ��ȡ description.
     *  @return java.lang.String.
     */
    public java.lang.String getDescription() {
        return this.description;
    }

    /**
     *  ���� description.
     *  @param description description��.
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }
    /**
     *  ��ȡ caseno.
     *  @return java.lang.String.
     */
    public java.lang.String getCaseno() {
        return this.caseno;
    }

    /**
     *  ���� caseno.
     *  @param caseno caseno��.
     */
    public void setCaseno(java.lang.String caseno) {
        this.caseno = caseno;
    }
    /**
     *  ��ȡ userId.
     *  @return java.lang.String.
     */
    public java.lang.String getUserId() {
        return this.userId;
    }

    /**
     *  ���� userId.
     *  @param userId userId��.
     */
    public void setUserId(java.lang.String userId) {
        this.userId = userId;
    }
    /**
     *  ��ȡ submit.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getSubmit() {
        return this.submit;
    }

    /**
     *  ���� submit.
     *  @param submit submit��.
     */
    public void setSubmit(java.lang.Boolean submit) {
        this.submit = submit;
    }
    /**
     *  ��ȡ otherInvestigationWay.
     *  @return java.lang.String.
     */
    public java.lang.String getOtherInvestigationWay() {
        return this.otherInvestigationWay;
    }

    /**
     *  ���� otherInvestigationWay.
     *  @param otherInvestigationWay otherInvestigationWay��.
     */
    public void setOtherInvestigationWay(java.lang.String otherInvestigationWay) {
        this.otherInvestigationWay = otherInvestigationWay;
    }
    /**
     *  ��ȡ otherRiskType.
     *  @return java.lang.String.
     */
    public java.lang.String getOtherRiskType() {
        return this.otherRiskType;
    }

    /**
     *  ���� otherRiskType.
     *  @param otherRiskType otherRiskType��.
     */
    public void setOtherRiskType(java.lang.String otherRiskType) {
        this.otherRiskType = otherRiskType;
    }
    /**
     *  ��ȡ otherProcessType.
     *  @return java.lang.String.
     */
    public java.lang.String getOtherProcessType() {
        return this.otherProcessType;
    }

    /**
     *  ���� otherProcessType.
     *  @param otherProcessType otherProcessType��.
     */
    public void setOtherProcessType(java.lang.String otherProcessType) {
        this.otherProcessType = otherProcessType;
    }




    /**
     *  ��ȡ riskcaseIdOfTriskcase.
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
     *  ���� riskcaseIdOfTriskcase.
     *  @param riskcaseIdOfTriskcase riskcaseIdOfTriskcase��.
     */
    public void setRiskcaseIdOfTriskcase(Triskcase riskcaseIdOfTriskcase) {
        this.riskcaseIdOfTriskcase = riskcaseIdOfTriskcase;
    }



    /**
     *  ��ȡ casenoOfTriskcase.
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
     *  ���� casenoOfTriskcase.
     *  @param casenoOfTriskcase casenoOfTriskcase��.
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
