package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  定义类TtransInfo.
     */
public class TtransInfo extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  字段域id.
     */
    private java.lang.String id;

    /**
     *  字段域settleDt.
     */
    private java.util.Date settleDt;

    /**
     *  字段域sysTraNo.
     */
    private java.lang.String sysTraNo;

    /**
     *  字段域respCd4.
     */
    private java.lang.String respCd4;

    /**
     *  字段域transId.
     */
    private java.lang.String transId;

    /**
     *  字段域settleIn.
     */
    private java.lang.String settleIn;

    /**
     *  字段域transAt.
     */
    private java.lang.Integer transAt;

    /**
     *  字段域msgTp.
     */
    private java.lang.String msgTp;

    /**
     *  字段域locTransDtTm.
     */
    private java.lang.String locTransDtTm;

    /**
     *  字段域mchntTp.
     */
    private java.lang.String mchntTp;

    /**
     *  字段域retriRefNo.
     */
    private java.lang.String retriRefNo;

    /**
     *  字段域priAcctNo.
     */
    private java.lang.String priAcctNo;

    /**
     *  字段域bin.
     */
    private java.lang.String bin;

    /**
     *  字段域cardAttr.
     */
    private java.lang.String cardAttr;

    /**
     *  字段域cardMedia.
     */
    private java.lang.String cardMedia;

    /**
     *  字段域termId.
     */
    private java.lang.String termId;

    /**
     *  字段域mchntCd.
     */
    private java.lang.String mchntCd;

    /**
     *  字段域cardAccptrNmLoc.
     */
    private java.lang.String cardAccptrNmLoc;

    /**
     *  字段域acqInsIdCd.
     */
    private java.lang.String acqInsIdCd;

    /**
     *  字段域fwdInsIdCd.
     */
    private java.lang.String fwdInsIdCd;

    /**
     *  字段域rcvInsIdCd.
     */
    private java.lang.String rcvInsIdCd;

    /**
     *  字段域issInsIdCd.
     */
    private java.lang.String issInsIdCd;

    /**
     *  字段域origSysTraNo.
     */
    private java.lang.String origSysTraNo;

    /**
     *  字段域origTransmsnDtTm.
     */
    private java.lang.String origTransmsnDtTm;

    /**
     *  字段域rsnCd.
     */
    private java.lang.String rsnCd;

    /**
     *  字段域authDt.
     */
    private String authDt;

    /**
     *  字段域authIdRespCd.
     */
    private java.lang.String authIdRespCd;

    /**
     *  字段域posEntryMdCd.
     */
    private java.lang.String posEntryMdCd;

    /**
     *  字段域posCondCd.
     */
    private java.lang.String posCondCd;

    /**
     *  字段域procCd.
     */
    private java.lang.String procCd;

    /**
     *  字段域settleYm.
     */
    private java.lang.String settleYm;

    /**
     *  字段域fwdInsIdOriginal.
     */
    private java.lang.String fwdInsIdOriginal;



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
     *  获取 settleDt.
     *  @return java.util.Date.
     */
    public java.util.Date getSettleDt() {
        return this.settleDt;
    }

    /**
     *  设置 settleDt.
     *  @param settleDt settleDt域.
     */
    public void setSettleDt(java.util.Date settleDt) {
        this.settleDt = settleDt;
    }
    /**
     *  获取 sysTraNo.
     *  @return java.lang.String.
     */
    public java.lang.String getSysTraNo() {
        return this.sysTraNo;
    }

    /**
     *  设置 sysTraNo.
     *  @param sysTraNo sysTraNo域.
     */
    public void setSysTraNo(java.lang.String sysTraNo) {
        this.sysTraNo = sysTraNo;
    }
    /**
     *  获取 respCd4.
     *  @return java.lang.String.
     */
    public java.lang.String getRespCd4() {
        return this.respCd4;
    }

    /**
     *  设置 respCd4.
     *  @param respCd4 respCd4域.
     */
    public void setRespCd4(java.lang.String respCd4) {
        this.respCd4 = respCd4;
    }
    /**
     *  获取 transId.
     *  @return java.lang.String.
     */
    public java.lang.String getTransId() {
        return this.transId;
    }

    /**
     *  设置 transId.
     *  @param transId transId域.
     */
    public void setTransId(java.lang.String transId) {
        this.transId = transId;
    }
    /**
     *  获取 settleIn.
     *  @return java.lang.String.
     */
    public java.lang.String getSettleIn() {
        return this.settleIn;
    }

    /**
     *  设置 settleIn.
     *  @param settleIn settleIn域.
     */
    public void setSettleIn(java.lang.String settleIn) {
        this.settleIn = settleIn;
    }
    /**
     *  获取 transAt.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getTransAt() {
        return this.transAt;
    }

    /**
     *  设置 transAt.
     *  @param transAt transAt域.
     */
    public void setTransAt(java.lang.Integer transAt) {
        this.transAt = transAt;
    }
    /**
     *  获取 msgTp.
     *  @return java.lang.String.
     */
    public java.lang.String getMsgTp() {
        return this.msgTp;
    }

    /**
     *  设置 msgTp.
     *  @param msgTp msgTp域.
     */
    public void setMsgTp(java.lang.String msgTp) {
        this.msgTp = msgTp;
    }
    /**
     *  获取 locTransDtTm.
     *  @return java.lang.String.
     */
    public java.lang.String getLocTransDtTm() {
        return this.locTransDtTm;
    }

    /**
     *  设置 locTransDtTm.
     *  @param locTransDtTm locTransDtTm域.
     */
    public void setLocTransDtTm(java.lang.String locTransDtTm) {
        this.locTransDtTm = locTransDtTm;
    }
    /**
     *  获取 mchntTp.
     *  @return java.lang.String.
     */
    public java.lang.String getMchntTp() {
        return this.mchntTp;
    }

    /**
     *  设置 mchntTp.
     *  @param mchntTp mchntTp域.
     */
    public void setMchntTp(java.lang.String mchntTp) {
        this.mchntTp = mchntTp;
    }
    /**
     *  获取 retriRefNo.
     *  @return java.lang.String.
     */
    public java.lang.String getRetriRefNo() {
        return this.retriRefNo;
    }

    /**
     *  设置 retriRefNo.
     *  @param retriRefNo retriRefNo域.
     */
    public void setRetriRefNo(java.lang.String retriRefNo) {
        this.retriRefNo = retriRefNo;
    }
    /**
     *  获取 priAcctNo.
     *  @return java.lang.String.
     */
    public java.lang.String getPriAcctNo() {
        return this.priAcctNo;
    }

    /**
     *  设置 priAcctNo.
     *  @param priAcctNo priAcctNo域.
     */
    public void setPriAcctNo(java.lang.String priAcctNo) {
        this.priAcctNo = priAcctNo;
    }
    /**
     *  获取 bin.
     *  @return java.lang.String.
     */
    public java.lang.String getBin() {
        return this.bin;
    }

    /**
     *  设置 bin.
     *  @param bin bin域.
     */
    public void setBin(java.lang.String bin) {
        this.bin = bin;
    }
    /**
     *  获取 cardAttr.
     *  @return java.lang.String.
     */
    public java.lang.String getCardAttr() {
        return this.cardAttr;
    }

    /**
     *  设置 cardAttr.
     *  @param cardAttr cardAttr域.
     */
    public void setCardAttr(java.lang.String cardAttr) {
        this.cardAttr = cardAttr;
    }
    /**
     *  获取 cardMedia.
     *  @return java.lang.String.
     */
    public java.lang.String getCardMedia() {
        return this.cardMedia;
    }

    /**
     *  设置 cardMedia.
     *  @param cardMedia cardMedia域.
     */
    public void setCardMedia(java.lang.String cardMedia) {
        this.cardMedia = cardMedia;
    }
    /**
     *  获取 termId.
     *  @return java.lang.String.
     */
    public java.lang.String getTermId() {
        return this.termId;
    }

    /**
     *  设置 termId.
     *  @param termId termId域.
     */
    public void setTermId(java.lang.String termId) {
        this.termId = termId;
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
     *  获取 cardAccptrNmLoc.
     *  @return java.lang.String.
     */
    public java.lang.String getCardAccptrNmLoc() {
        return this.cardAccptrNmLoc;
    }

    /**
     *  设置 cardAccptrNmLoc.
     *  @param cardAccptrNmLoc cardAccptrNmLoc域.
     */
    public void setCardAccptrNmLoc(java.lang.String cardAccptrNmLoc) {
        this.cardAccptrNmLoc = cardAccptrNmLoc;
    }
    /**
     *  获取 acqInsIdCd.
     *  @return java.lang.String.
     */
    public java.lang.String getAcqInsIdCd() {
        return this.acqInsIdCd;
    }

    /**
     *  设置 acqInsIdCd.
     *  @param acqInsIdCd acqInsIdCd域.
     */
    public void setAcqInsIdCd(java.lang.String acqInsIdCd) {
        this.acqInsIdCd = acqInsIdCd;
    }
    /**
     *  获取 fwdInsIdCd.
     *  @return java.lang.String.
     */
    public java.lang.String getFwdInsIdCd() {
        return this.fwdInsIdCd;
    }

    /**
     *  设置 fwdInsIdCd.
     *  @param fwdInsIdCd fwdInsIdCd域.
     */
    public void setFwdInsIdCd(java.lang.String fwdInsIdCd) {
        this.fwdInsIdCd = fwdInsIdCd;
    }
    /**
     *  获取 rcvInsIdCd.
     *  @return java.lang.String.
     */
    public java.lang.String getRcvInsIdCd() {
        return this.rcvInsIdCd;
    }

    /**
     *  设置 rcvInsIdCd.
     *  @param rcvInsIdCd rcvInsIdCd域.
     */
    public void setRcvInsIdCd(java.lang.String rcvInsIdCd) {
        this.rcvInsIdCd = rcvInsIdCd;
    }
    /**
     *  获取 issInsIdCd.
     *  @return java.lang.String.
     */
    public java.lang.String getIssInsIdCd() {
        return this.issInsIdCd;
    }

    /**
     *  设置 issInsIdCd.
     *  @param issInsIdCd issInsIdCd域.
     */
    public void setIssInsIdCd(java.lang.String issInsIdCd) {
        this.issInsIdCd = issInsIdCd;
    }
    /**
     *  获取 origSysTraNo.
     *  @return java.lang.String.
     */
    public java.lang.String getOrigSysTraNo() {
        return this.origSysTraNo;
    }

    /**
     *  设置 origSysTraNo.
     *  @param origSysTraNo origSysTraNo域.
     */
    public void setOrigSysTraNo(java.lang.String origSysTraNo) {
        this.origSysTraNo = origSysTraNo;
    }
    /**
     *  获取 origTransmsnDtTm.
     *  @return java.lang.String.
     */
    public java.lang.String getOrigTransmsnDtTm() {
        return this.origTransmsnDtTm;
    }

    /**
     *  设置 origTransmsnDtTm.
     *  @param origTransmsnDtTm origTransmsnDtTm域.
     */
    public void setOrigTransmsnDtTm(java.lang.String origTransmsnDtTm) {
        this.origTransmsnDtTm = origTransmsnDtTm;
    }
    /**
     *  获取 rsnCd.
     *  @return java.lang.String.
     */
    public java.lang.String getRsnCd() {
        return this.rsnCd;
    }

    /**
     *  设置 rsnCd.
     *  @param rsnCd rsnCd域.
     */
    public void setRsnCd(java.lang.String rsnCd) {
        this.rsnCd = rsnCd;
    }
    public void setAuthDt(String authDt) {
		this.authDt = authDt;
	}

	/**
     *  获取 authDt.
     *  @return java.util.Date.
     */
    public String getAuthDt() {
        return this.authDt;
    }

    /**
     *  获取 authIdRespCd.
     *  @return java.lang.String.
     */
    public java.lang.String getAuthIdRespCd() {
        return this.authIdRespCd;
    }

    /**
     *  设置 authIdRespCd.
     *  @param authIdRespCd authIdRespCd域.
     */
    public void setAuthIdRespCd(java.lang.String authIdRespCd) {
        this.authIdRespCd = authIdRespCd;
    }
    /**
     *  获取 posEntryMdCd.
     *  @return java.lang.String.
     */
    public java.lang.String getPosEntryMdCd() {
        return this.posEntryMdCd;
    }

    /**
     *  设置 posEntryMdCd.
     *  @param posEntryMdCd posEntryMdCd域.
     */
    public void setPosEntryMdCd(java.lang.String posEntryMdCd) {
        this.posEntryMdCd = posEntryMdCd;
    }
    /**
     *  获取 posCondCd.
     *  @return java.lang.String.
     */
    public java.lang.String getPosCondCd() {
        return this.posCondCd;
    }

    /**
     *  设置 posCondCd.
     *  @param posCondCd posCondCd域.
     */
    public void setPosCondCd(java.lang.String posCondCd) {
        this.posCondCd = posCondCd;
    }
    /**
     *  获取 procCd.
     *  @return java.lang.String.
     */
    public java.lang.String getProcCd() {
        return this.procCd;
    }

    /**
     *  设置 procCd.
     *  @param procCd procCd域.
     */
    public void setProcCd(java.lang.String procCd) {
        this.procCd = procCd;
    }
    /**
     *  获取 settleYm.
     *  @return java.lang.String.
     */
    public java.lang.String getSettleYm() {
        return this.settleYm;
    }

    /**
     *  设置 settleYm.
     *  @param settleYm settleYm域.
     */
    public void setSettleYm(java.lang.String settleYm) {
        this.settleYm = settleYm;
    }
    /**
     *  获取 fwdInsIdOriginal.
     *  @return java.lang.String.
     */
    public java.lang.String getFwdInsIdOriginal() {
        return this.fwdInsIdOriginal;
    }

    /**
     *  设置 fwdInsIdOriginal.
     *  @param fwdInsIdOriginal fwdInsIdOriginal域.
     */
    public void setFwdInsIdOriginal(java.lang.String fwdInsIdOriginal) {
        this.fwdInsIdOriginal = fwdInsIdOriginal;
    }


}
