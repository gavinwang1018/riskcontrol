package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.risk.ext.interfaces.DataManageController;

    /**
     *  ������Triskcase.
     */
public class Triskcase extends BaseModel implements Serializable {
	
	private String mchntType;

	private Double addRelativeAmt;
	
	private Double relativeAmt;
	
	private Double allAmt;
	
	private String action;
	
	private String way;
	
	private java.lang.Long createInst;
	
	private java.lang.Integer backCnt;
	
	private java.lang.String comments6;
	
	private java.lang.String comments7;
	
	private java.lang.String comments8;
	
	private java.lang.Integer ruleGroupId;
	
	private boolean checked;
	
	private Integer isNew;
	
	private String flag;

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���caseno.
     */
    private java.lang.String caseno;

    /**
     *  �ֶ���mchntCd.
     */
    private java.lang.String mchntCd;

    /**
     *  �ֶ���beginDate.
     */
    private java.util.Date beginDate;

    /**
     *  �ֶ���endDate.
     */
    private java.util.Date endDate;

/*
@extSelectItems.belongToInstList
*/
    /**
     *  �ֶ���belongToInst.
     */
    private java.lang.String belongToInst;

    /**
     *  �ֶ���relativeTransAmt.
     */
    private java.lang.Double relativeTransAmt;

    /**
     *  �ֶ���allTransAmt.
     */
    private java.lang.Double allTransAmt;

    /**
     *  �ֶ���allTransNum.
     */
    private java.lang.Long allTransNum;

    /**
     *  �ֶ���createdate.
     */
    private java.util.Date createdate;

    /**
     *  �ֶ���score.
     */
    private java.lang.Float score;

    /**
     *  �ֶ���triggerRuleNum.
     */
    private java.lang.Integer triggerRuleNum;

    /**
     *  �ֶ���mchntName.
     */
    private java.lang.String mchntName;

    /**
     *  �ֶ���transMcc.
     */
    private java.lang.String transMcc;

    /**
     *  �ֶ���processLimit.
     */
    private java.util.Date processLimit;

/*
0,��ʾ
1,��ע
2,Ԥ��
3,����
*/
    /**
     *  �ֶ���warnLevel.
     */
    private java.lang.String warnLevel;

    /**
     *  �ֶ���otherno.
     */
    private java.lang.String otherno;

    /**
     *  �ֶ���mchntMcc.
     */
    private java.lang.String mchntMcc;

    /**
     *  �ֶ���triggerContent.
     */
    private java.lang.String triggerContent;

    /**
     *  �ֶ���riskContent.
     */
    private java.lang.String riskContent;

/*
@extSelectItems.belongToInstList
*/
    /**
     *  �ֶ���acquireInstName.
     */
    private java.lang.String acquireInstName;

/*
0,������
1,������
2,������
3,�Ѵ�����ȷ��
4,������
5,�᰸
*/
    /**
     *  �ֶ���status.
     */
    private java.lang.String status;

    /**
     *  �ֶ���comments1.
     */
    private java.lang.String comments1;

    /**
     *  �ֶ���comments2.
     */
    private java.lang.String comments2;

    /**
     *  �ֶ���comments3.
     */
    private java.lang.String comments3;

    /**
     *  �ֶ���comments4.
     */
    private java.lang.String comments4;

    /**
     *  �ֶ���comments5.
     */
    private java.lang.String comments5;

    /**
     *  �ֶ���relativeTransNum.
     */
    private java.lang.Long relativeTransNum;

    /**
     *  �ֶ���trace.
     */
    private java.lang.Boolean trace;

    /**
     *  �ֶ���beenUrgent.
     */
    private java.lang.Boolean beenUrgent;

    /**
     *  �ֶ���urgentCnt.
     */
    private java.lang.Integer urgentCnt;

/*
@extSelectItems.belongToInstList
*/
    /**
     *  �ֶ���submit2Inst.
     */
    private java.lang.String submit2Inst;

/*
1,���̼����ܹ�˾
2,���̷�֧����
3,��������
4,��������
5,����ý��
6,��������
*/
    /**
     *  �ֶ���casefrom.
     */
    private java.lang.String casefrom;

    /**
     *  �ֶ���mchntId.
     */
    private java.lang.String mchntId;

    /**
     *  ������triskcaseRecordGroup.
     */
    private Set triskcaseRecordGroup;
    
    private Set triskcaseAttachmentGroup;
	
	private List triskcaseRecords;
	
	private List triskcaseAttachments;



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
     *  ��ȡ mchntCd.
     *  @return java.lang.String.
     */
    public java.lang.String getMchntCd() {
        return this.mchntCd;
    }

    /**
     *  ���� mchntCd.
     *  @param mchntCd mchntCd��.
     */
    public void setMchntCd(java.lang.String mchntCd) {
        this.mchntCd = mchntCd;
    }
    /**
     *  ��ȡ beginDate.
     *  @return java.util.Date.
     */
    public java.util.Date getBeginDate() {
        return this.beginDate;
    }

    /**
     *  ���� beginDate.
     *  @param beginDate beginDate��.
     */
    public void setBeginDate(java.util.Date beginDate) {
        this.beginDate = beginDate;
    }
    /**
     *  ��ȡ endDate.
     *  @return java.util.Date.
     */
    public java.util.Date getEndDate() {
        return this.endDate;
    }

    /**
     *  ���� endDate.
     *  @param endDate endDate��.
     */
    public void setEndDate(java.util.Date endDate) {
        this.endDate = endDate;
    }
    /**
     *  ��ȡ belongToInst.
     *  @return java.lang.String.
     */
    public java.lang.String getBelongToInst() {
        return this.belongToInst;
    }

    /**
     *  ���� belongToInst.
     *  @param belongToInst belongToInst��.
     */
    public void setBelongToInst(java.lang.String belongToInst) {
        this.belongToInst = belongToInst;
    }
   
    /**
     *  ��ȡ createdate.
     *  @return java.util.Date.
     */
    public java.util.Date getCreatedate() {
        return this.createdate;
    }

    /**
     *  ���� createdate.
     *  @param createdate createdate��.
     */
    public void setCreatedate(java.util.Date createdate) {
        this.createdate = createdate;
    }
    /**
     *  ��ȡ score.
     *  @return java.lang.Float.
     */
    public java.lang.Float getScore() {
        return this.score;
    }

    /**
     *  ���� score.
     *  @param score score��.
     */
    public void setScore(java.lang.Float score) {
        this.score = score;
    }
 
    public java.lang.Double getAllTransAmt() {
		return allTransAmt;
	}

	public void setAllTransAmt(java.lang.Double allTransAmt) {
		this.allTransAmt = allTransAmt;
	}

	public java.lang.Long getAllTransNum() {
		return allTransNum;
	}

	public void setAllTransNum(java.lang.Long allTransNum) {
		this.allTransNum = allTransNum;
	}

	public java.lang.Double getRelativeTransAmt() {
		return relativeTransAmt;
	}

	public void setRelativeTransAmt(java.lang.Double relativeTransAmt) {
		this.relativeTransAmt = relativeTransAmt;
	}

	public java.lang.Integer getTriggerRuleNum() {
		return triggerRuleNum;
	}

	public void setTriggerRuleNum(java.lang.Integer triggerRuleNum) {
		this.triggerRuleNum = triggerRuleNum;
	}

	public void setBackCnt(java.lang.Integer backCnt) {
		this.backCnt = backCnt;
	}

	public void setCreateInst(java.lang.Long createInst) {
		this.createInst = createInst;
	}

	/**
     *  ��ȡ mchntName.
     *  @return java.lang.String.
     */
    public java.lang.String getMchntName() {
        return this.mchntName;
    }

    /**
     *  ���� mchntName.
     *  @param mchntName mchntName��.
     */
    public void setMchntName(java.lang.String mchntName) {
        this.mchntName = mchntName;
    }
    /**
     *  ��ȡ transMcc.
     *  @return java.lang.String.
     */
    public java.lang.String getTransMcc() {
        return this.transMcc;
    }

    /**
     *  ���� transMcc.
     *  @param transMcc transMcc��.
     */
    public void setTransMcc(java.lang.String transMcc) {
        this.transMcc = transMcc;
    }
    /**
     *  ��ȡ processLimit.
     *  @return java.util.Date.
     */
    public java.util.Date getProcessLimit() {
    	return this.processLimit;
	}

    /**
	 * ���� processLimit.
	 * 
	 * @param processLimit
	 *            processLimit��.
	 */
    public void setProcessLimit(java.util.Date processLimit) {
    	this.processLimit = processLimit;
	}
    /**
	 * ��ȡ warnLevel.
	 * 
	 * @return java.lang.String.
	 */
    public java.lang.String getWarnLevel() {
        return this.warnLevel;
    }

    /**
     *  ���� warnLevel.
     *  @param warnLevel warnLevel��.
     */
    public void setWarnLevel(java.lang.String warnLevel) {
        this.warnLevel = warnLevel;
    }
    /**
     *  ��ȡ otherno.
     *  @return java.lang.String.
     */
    public java.lang.String getOtherno() {
        return this.otherno;
    }

    /**
     *  ���� otherno.
     *  @param otherno otherno��.
     */
    public void setOtherno(java.lang.String otherno) {
        this.otherno = otherno;
    }
    /**
     *  ��ȡ mchntMcc.
     *  @return java.lang.String.
     */
    public java.lang.String getMchntMcc() {
        return this.mchntMcc;
    }

    /**
     *  ���� mchntMcc.
     *  @param mchntMcc mchntMcc��.
     */
    public void setMchntMcc(java.lang.String mchntMcc) {
        this.mchntMcc = mchntMcc;
    }
    /**
     *  ��ȡ triggerContent.
     *  @return java.lang.String.
     */
    public java.lang.String getTriggerContent() {
        return this.triggerContent;
    }

    /**
     *  ���� triggerContent.
     *  @param triggerContent triggerContent��.
     */
    public void setTriggerContent(java.lang.String triggerContent) {
        this.triggerContent = triggerContent;
    }
    /**
     *  ��ȡ riskContent.
     *  @return java.lang.String.
     */
    public java.lang.String getRiskContent() {
        return this.riskContent;
    }

    /**
     *  ���� riskContent.
     *  @param riskContent riskContent��.
     */
    public void setRiskContent(java.lang.String riskContent) {
        this.riskContent = riskContent;
    }
    /**
     *  ��ȡ acquireInstName.
     *  @return java.lang.String.
     */
    public java.lang.String getAcquireInstName() {
        return this.acquireInstName;
    }

    /**
     *  ���� acquireInstName.
     *  @param acquireInstName acquireInstName��.
     */
    public void setAcquireInstName(java.lang.String acquireInstName) {
        this.acquireInstName = acquireInstName;
    }
    /**
     *  ��ȡ status.
     *  @return java.lang.String.
     */
    public java.lang.String getStatus() {
        return this.status;
    }

    /**
     *  ���� status.
     *  @param status status��.
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }
    /**
     *  ��ȡ comments1.
     *  @return java.lang.String.
     */
    public java.lang.String getComments1() {
        return this.comments1;
    }

    /**
     *  ���� comments1.
     *  @param comments1 comments1��.
     */
    public void setComments1(java.lang.String comments1) {
        this.comments1 = comments1;
    }
    /**
     *  ��ȡ comments2.
     *  @return java.lang.String.
     */
    public java.lang.String getComments2() {
        return this.comments2;
    }

    /**
     *  ���� comments2.
     *  @param comments2 comments2��.
     */
    public void setComments2(java.lang.String comments2) {
        this.comments2 = comments2;
    }
    /**
     *  ��ȡ comments3.
     *  @return java.lang.String.
     */
    public java.lang.String getComments3() {
        return this.comments3;
    }

    /**
     *  ���� comments3.
     *  @param comments3 comments3��.
     */
    public void setComments3(java.lang.String comments3) {
        this.comments3 = comments3;
    }
    /**
     *  ��ȡ comments4.
     *  @return java.lang.String.
     */
    public java.lang.String getComments4() {
        return this.comments4;
    }

    /**
     *  ���� comments4.
     *  @param comments4 comments4��.
     */
    public void setComments4(java.lang.String comments4) {
        this.comments4 = comments4;
    }
    /**
     *  ��ȡ comments5.
     *  @return java.lang.String.
     */
    public java.lang.String getComments5() {
        return this.comments5;
    }

    /**
     *  ���� comments5.
     *  @param comments5 comments5��.
     */
    public void setComments5(java.lang.String comments5) {
        this.comments5 = comments5;
    }
    /**
     *  ��ȡ relativeTransNum.
     *  @return java.lang.Integer.
     */
    public java.lang.Long getRelativeTransNum() {
        return this.relativeTransNum;
    }

    /**
     *  ���� relativeTransNum.
     *  @param relativeTransNum relativeTransNum��.
     */
    public void setRelativeTransNum(java.lang.Long relativeTransNum) {
        this.relativeTransNum = relativeTransNum;
    }
    /**
     *  ��ȡ trace.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getTrace() {
        return this.trace;
    }

    /**
     *  ���� trace.
     *  @param trace trace��.
     */
    public void setTrace(java.lang.Boolean trace) {
        this.trace = trace;
    }
    /**
     *  ��ȡ beenUrgent.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getBeenUrgent() {
        return this.beenUrgent;
    }

    /**
     *  ���� beenUrgent.
     *  @param beenUrgent beenUrgent��.
     */
    public void setBeenUrgent(java.lang.Boolean beenUrgent) {
        this.beenUrgent = beenUrgent;
    }
    /**
     *  ��ȡ urgentCnt.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getUrgentCnt() {
        return this.urgentCnt;
    }

    /**
     *  ���� urgentCnt.
     *  @param urgentCnt urgentCnt��.
     */
    public void setUrgentCnt(java.lang.Integer urgentCnt) {
        this.urgentCnt = urgentCnt;
    }
    /**
     *  ��ȡ submit2Inst.
     *  @return java.lang.String.
     */
    public java.lang.String getSubmit2Inst() {
        return this.submit2Inst;
    }

    /**
     *  ���� submit2Inst.
     *  @param submit2Inst submit2Inst��.
     */
    public void setSubmit2Inst(java.lang.String submit2Inst) {
    	this.submit2Inst = submit2Inst;
    }
    /**
     *  ��ȡ casefrom.
     *  @return java.lang.String.
     */
    public java.lang.String getCasefrom() {
        return this.casefrom;
    }

    /**
     *  ���� casefrom.
     *  @param casefrom casefrom��.
     */
    public void setCasefrom(java.lang.String casefrom) {
        this.casefrom = casefrom;
    }
    /**
     *  ��ȡ mchntId.
     *  @return java.lang.String.
     */
    public java.lang.String getMchntId() {
        return this.mchntId;
    }

    /**
     *  ���� mchntId.
     *  @param mchntId mchntId��.
     */
    public void setMchntId(java.lang.String mchntId) {
        this.mchntId = mchntId;
    }

    /**
     *  ��ȡ triskcaseRecordGroup.
     *  @return Set.
     */
    public Set getTriskcaseRecordGroup() {
        return this.triskcaseRecordGroup;
    }

    /**
     *  ���� triskcaseRecordGroup.
     *  @param triskcaseRecordGroup triskcaseRecordGroup��.
     */
    public void setTriskcaseRecordGroup(Set triskcaseRecordGroup) {
        this.triskcaseRecordGroup = triskcaseRecordGroup;
    }
	
	public List getTriskcaseRecords() {
        return this.triskcaseRecords;
    }

    public void setTriskcaseRecords(List triskcaseRecords) {
        this.triskcaseRecords = triskcaseRecords;
    }

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Set getTriskcaseAttachmentGroup() {
		return triskcaseAttachmentGroup;
	}

	public void setTriskcaseAttachmentGroup(Set triskcaseAttachmentGroup) {
		this.triskcaseAttachmentGroup = triskcaseAttachmentGroup;
	}

	public List getTriskcaseAttachments() {
		return triskcaseAttachments;
	}

	public void setTriskcaseAttachments(List triskcaseAttachments) {
		this.triskcaseAttachments = triskcaseAttachments;
	}


	public java.lang.String getComments6() {
		return comments6;
	}

	public void setComments6(java.lang.String comments6) {
		this.comments6 = comments6;
	}

	public java.lang.Integer getBackCnt() {
		return backCnt;
	}

	public java.lang.Long getCreateInst() {
		return createInst;
	}

	public java.lang.String getComments7() {
		return comments7;
	}

	public void setComments7(java.lang.String comments7) {
		this.comments7 = comments7;
	}

	public java.lang.String getComments8() {
		return comments8;
	}

	public void setComments8(java.lang.String comments8) {
		this.comments8 = comments8;
	}

	public Integer getIsNew() {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String nowDate = format.format(new Date());
		String createDate = "";
		if(this.createdate != null) {
			createDate = format.format(this.createdate);
		}
		if(nowDate.equals(createDate)) {
			return 1;
		} else {
			return 0;
		}
	}

	public void setIsNew(Integer isNew) {
		this.isNew = isNew;
	}

	public java.lang.Integer getRuleGroupId() {
		return ruleGroupId;
	}

	public void setRuleGroupId(java.lang.Integer ruleGroupId) {
		this.ruleGroupId = ruleGroupId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}

	public Double getAllAmt() {
		return allAmt;
	}

	public void setAllAmt(Double allAmt) {
		this.allAmt = allAmt;
	}

	public Double getRelativeAmt() {
		return relativeAmt;
	}

	public void setRelativeAmt(Double relativeAmt) {
		this.relativeAmt = relativeAmt;
	}

	public Double getAddRelativeAmt() {
		return addRelativeAmt;
	}

	public void setAddRelativeAmt(Double addRelativeAmt) {
		this.addRelativeAmt = addRelativeAmt;
	}

	public String getMchntType() {
		return mchntType;
	}

	public void setMchntType(String mchntType) {
		this.mchntType = mchntType;
	}
}
