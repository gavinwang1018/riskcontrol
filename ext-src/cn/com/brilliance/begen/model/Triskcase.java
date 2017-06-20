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
     *  定义类Triskcase.
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
     *  字段域id.
     */
    private java.lang.String id;

    /**
     *  字段域caseno.
     */
    private java.lang.String caseno;

    /**
     *  字段域mchntCd.
     */
    private java.lang.String mchntCd;

    /**
     *  字段域beginDate.
     */
    private java.util.Date beginDate;

    /**
     *  字段域endDate.
     */
    private java.util.Date endDate;

/*
@extSelectItems.belongToInstList
*/
    /**
     *  字段域belongToInst.
     */
    private java.lang.String belongToInst;

    /**
     *  字段域relativeTransAmt.
     */
    private java.lang.Double relativeTransAmt;

    /**
     *  字段域allTransAmt.
     */
    private java.lang.Double allTransAmt;

    /**
     *  字段域allTransNum.
     */
    private java.lang.Long allTransNum;

    /**
     *  字段域createdate.
     */
    private java.util.Date createdate;

    /**
     *  字段域score.
     */
    private java.lang.Float score;

    /**
     *  字段域triggerRuleNum.
     */
    private java.lang.Integer triggerRuleNum;

    /**
     *  字段域mchntName.
     */
    private java.lang.String mchntName;

    /**
     *  字段域transMcc.
     */
    private java.lang.String transMcc;

    /**
     *  字段域processLimit.
     */
    private java.util.Date processLimit;

/*
0,提示
1,关注
2,预警
3,警告
*/
    /**
     *  字段域warnLevel.
     */
    private java.lang.String warnLevel;

    /**
     *  字段域otherno.
     */
    private java.lang.String otherno;

    /**
     *  字段域mchntMcc.
     */
    private java.lang.String mchntMcc;

    /**
     *  字段域triggerContent.
     */
    private java.lang.String triggerContent;

    /**
     *  字段域riskContent.
     */
    private java.lang.String riskContent;

/*
@extSelectItems.belongToInstList
*/
    /**
     *  字段域acquireInstName.
     */
    private java.lang.String acquireInstName;

/*
0,不处理
1,待处理
2,处理中
3,已处理，待确认
4,已审批
5,结案
*/
    /**
     *  字段域status.
     */
    private java.lang.String status;

    /**
     *  字段域comments1.
     */
    private java.lang.String comments1;

    /**
     *  字段域comments2.
     */
    private java.lang.String comments2;

    /**
     *  字段域comments3.
     */
    private java.lang.String comments3;

    /**
     *  字段域comments4.
     */
    private java.lang.String comments4;

    /**
     *  字段域comments5.
     */
    private java.lang.String comments5;

    /**
     *  字段域relativeTransNum.
     */
    private java.lang.Long relativeTransNum;

    /**
     *  字段域trace.
     */
    private java.lang.Boolean trace;

    /**
     *  字段域beenUrgent.
     */
    private java.lang.Boolean beenUrgent;

    /**
     *  字段域urgentCnt.
     */
    private java.lang.Integer urgentCnt;

/*
@extSelectItems.belongToInstList
*/
    /**
     *  字段域submit2Inst.
     */
    private java.lang.String submit2Inst;

/*
1,银商集团总公司
2,银商分支机构
3,银联集团
4,其它机构
5,报刊媒体
6,其它渠道
*/
    /**
     *  字段域casefrom.
     */
    private java.lang.String casefrom;

    /**
     *  字段域mchntId.
     */
    private java.lang.String mchntId;

    /**
     *  集合域triskcaseRecordGroup.
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
     *  获取 mchntCd.
     *  @return java.lang.String.
     */
    public java.lang.String getMchntCd() {
        return this.mchntCd;
    }

    /**
     *  设置 mchntCd.
     *  @param mchntCd mchntCd域.
     */
    public void setMchntCd(java.lang.String mchntCd) {
        this.mchntCd = mchntCd;
    }
    /**
     *  获取 beginDate.
     *  @return java.util.Date.
     */
    public java.util.Date getBeginDate() {
        return this.beginDate;
    }

    /**
     *  设置 beginDate.
     *  @param beginDate beginDate域.
     */
    public void setBeginDate(java.util.Date beginDate) {
        this.beginDate = beginDate;
    }
    /**
     *  获取 endDate.
     *  @return java.util.Date.
     */
    public java.util.Date getEndDate() {
        return this.endDate;
    }

    /**
     *  设置 endDate.
     *  @param endDate endDate域.
     */
    public void setEndDate(java.util.Date endDate) {
        this.endDate = endDate;
    }
    /**
     *  获取 belongToInst.
     *  @return java.lang.String.
     */
    public java.lang.String getBelongToInst() {
        return this.belongToInst;
    }

    /**
     *  设置 belongToInst.
     *  @param belongToInst belongToInst域.
     */
    public void setBelongToInst(java.lang.String belongToInst) {
        this.belongToInst = belongToInst;
    }
   
    /**
     *  获取 createdate.
     *  @return java.util.Date.
     */
    public java.util.Date getCreatedate() {
        return this.createdate;
    }

    /**
     *  设置 createdate.
     *  @param createdate createdate域.
     */
    public void setCreatedate(java.util.Date createdate) {
        this.createdate = createdate;
    }
    /**
     *  获取 score.
     *  @return java.lang.Float.
     */
    public java.lang.Float getScore() {
        return this.score;
    }

    /**
     *  设置 score.
     *  @param score score域.
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
     *  获取 mchntName.
     *  @return java.lang.String.
     */
    public java.lang.String getMchntName() {
        return this.mchntName;
    }

    /**
     *  设置 mchntName.
     *  @param mchntName mchntName域.
     */
    public void setMchntName(java.lang.String mchntName) {
        this.mchntName = mchntName;
    }
    /**
     *  获取 transMcc.
     *  @return java.lang.String.
     */
    public java.lang.String getTransMcc() {
        return this.transMcc;
    }

    /**
     *  设置 transMcc.
     *  @param transMcc transMcc域.
     */
    public void setTransMcc(java.lang.String transMcc) {
        this.transMcc = transMcc;
    }
    /**
     *  获取 processLimit.
     *  @return java.util.Date.
     */
    public java.util.Date getProcessLimit() {
    	return this.processLimit;
	}

    /**
	 * 设置 processLimit.
	 * 
	 * @param processLimit
	 *            processLimit域.
	 */
    public void setProcessLimit(java.util.Date processLimit) {
    	this.processLimit = processLimit;
	}
    /**
	 * 获取 warnLevel.
	 * 
	 * @return java.lang.String.
	 */
    public java.lang.String getWarnLevel() {
        return this.warnLevel;
    }

    /**
     *  设置 warnLevel.
     *  @param warnLevel warnLevel域.
     */
    public void setWarnLevel(java.lang.String warnLevel) {
        this.warnLevel = warnLevel;
    }
    /**
     *  获取 otherno.
     *  @return java.lang.String.
     */
    public java.lang.String getOtherno() {
        return this.otherno;
    }

    /**
     *  设置 otherno.
     *  @param otherno otherno域.
     */
    public void setOtherno(java.lang.String otherno) {
        this.otherno = otherno;
    }
    /**
     *  获取 mchntMcc.
     *  @return java.lang.String.
     */
    public java.lang.String getMchntMcc() {
        return this.mchntMcc;
    }

    /**
     *  设置 mchntMcc.
     *  @param mchntMcc mchntMcc域.
     */
    public void setMchntMcc(java.lang.String mchntMcc) {
        this.mchntMcc = mchntMcc;
    }
    /**
     *  获取 triggerContent.
     *  @return java.lang.String.
     */
    public java.lang.String getTriggerContent() {
        return this.triggerContent;
    }

    /**
     *  设置 triggerContent.
     *  @param triggerContent triggerContent域.
     */
    public void setTriggerContent(java.lang.String triggerContent) {
        this.triggerContent = triggerContent;
    }
    /**
     *  获取 riskContent.
     *  @return java.lang.String.
     */
    public java.lang.String getRiskContent() {
        return this.riskContent;
    }

    /**
     *  设置 riskContent.
     *  @param riskContent riskContent域.
     */
    public void setRiskContent(java.lang.String riskContent) {
        this.riskContent = riskContent;
    }
    /**
     *  获取 acquireInstName.
     *  @return java.lang.String.
     */
    public java.lang.String getAcquireInstName() {
        return this.acquireInstName;
    }

    /**
     *  设置 acquireInstName.
     *  @param acquireInstName acquireInstName域.
     */
    public void setAcquireInstName(java.lang.String acquireInstName) {
        this.acquireInstName = acquireInstName;
    }
    /**
     *  获取 status.
     *  @return java.lang.String.
     */
    public java.lang.String getStatus() {
        return this.status;
    }

    /**
     *  设置 status.
     *  @param status status域.
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }
    /**
     *  获取 comments1.
     *  @return java.lang.String.
     */
    public java.lang.String getComments1() {
        return this.comments1;
    }

    /**
     *  设置 comments1.
     *  @param comments1 comments1域.
     */
    public void setComments1(java.lang.String comments1) {
        this.comments1 = comments1;
    }
    /**
     *  获取 comments2.
     *  @return java.lang.String.
     */
    public java.lang.String getComments2() {
        return this.comments2;
    }

    /**
     *  设置 comments2.
     *  @param comments2 comments2域.
     */
    public void setComments2(java.lang.String comments2) {
        this.comments2 = comments2;
    }
    /**
     *  获取 comments3.
     *  @return java.lang.String.
     */
    public java.lang.String getComments3() {
        return this.comments3;
    }

    /**
     *  设置 comments3.
     *  @param comments3 comments3域.
     */
    public void setComments3(java.lang.String comments3) {
        this.comments3 = comments3;
    }
    /**
     *  获取 comments4.
     *  @return java.lang.String.
     */
    public java.lang.String getComments4() {
        return this.comments4;
    }

    /**
     *  设置 comments4.
     *  @param comments4 comments4域.
     */
    public void setComments4(java.lang.String comments4) {
        this.comments4 = comments4;
    }
    /**
     *  获取 comments5.
     *  @return java.lang.String.
     */
    public java.lang.String getComments5() {
        return this.comments5;
    }

    /**
     *  设置 comments5.
     *  @param comments5 comments5域.
     */
    public void setComments5(java.lang.String comments5) {
        this.comments5 = comments5;
    }
    /**
     *  获取 relativeTransNum.
     *  @return java.lang.Integer.
     */
    public java.lang.Long getRelativeTransNum() {
        return this.relativeTransNum;
    }

    /**
     *  设置 relativeTransNum.
     *  @param relativeTransNum relativeTransNum域.
     */
    public void setRelativeTransNum(java.lang.Long relativeTransNum) {
        this.relativeTransNum = relativeTransNum;
    }
    /**
     *  获取 trace.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getTrace() {
        return this.trace;
    }

    /**
     *  设置 trace.
     *  @param trace trace域.
     */
    public void setTrace(java.lang.Boolean trace) {
        this.trace = trace;
    }
    /**
     *  获取 beenUrgent.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getBeenUrgent() {
        return this.beenUrgent;
    }

    /**
     *  设置 beenUrgent.
     *  @param beenUrgent beenUrgent域.
     */
    public void setBeenUrgent(java.lang.Boolean beenUrgent) {
        this.beenUrgent = beenUrgent;
    }
    /**
     *  获取 urgentCnt.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getUrgentCnt() {
        return this.urgentCnt;
    }

    /**
     *  设置 urgentCnt.
     *  @param urgentCnt urgentCnt域.
     */
    public void setUrgentCnt(java.lang.Integer urgentCnt) {
        this.urgentCnt = urgentCnt;
    }
    /**
     *  获取 submit2Inst.
     *  @return java.lang.String.
     */
    public java.lang.String getSubmit2Inst() {
        return this.submit2Inst;
    }

    /**
     *  设置 submit2Inst.
     *  @param submit2Inst submit2Inst域.
     */
    public void setSubmit2Inst(java.lang.String submit2Inst) {
    	this.submit2Inst = submit2Inst;
    }
    /**
     *  获取 casefrom.
     *  @return java.lang.String.
     */
    public java.lang.String getCasefrom() {
        return this.casefrom;
    }

    /**
     *  设置 casefrom.
     *  @param casefrom casefrom域.
     */
    public void setCasefrom(java.lang.String casefrom) {
        this.casefrom = casefrom;
    }
    /**
     *  获取 mchntId.
     *  @return java.lang.String.
     */
    public java.lang.String getMchntId() {
        return this.mchntId;
    }

    /**
     *  设置 mchntId.
     *  @param mchntId mchntId域.
     */
    public void setMchntId(java.lang.String mchntId) {
        this.mchntId = mchntId;
    }

    /**
     *  获取 triskcaseRecordGroup.
     *  @return Set.
     */
    public Set getTriskcaseRecordGroup() {
        return this.triskcaseRecordGroup;
    }

    /**
     *  设置 triskcaseRecordGroup.
     *  @param triskcaseRecordGroup triskcaseRecordGroup域.
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
