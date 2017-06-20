package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  ������TtransInfo.
     */
public class TtransInfo extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���settleDt.
     */
    private java.util.Date settleDt;

    /**
     *  �ֶ���sysTraNo.
     */
    private java.lang.String sysTraNo;

    /**
     *  �ֶ���respCd4.
     */
    private java.lang.String respCd4;

    /**
     *  �ֶ���transId.
     */
    private java.lang.String transId;

    /**
     *  �ֶ���settleIn.
     */
    private java.lang.String settleIn;

    /**
     *  �ֶ���transAt.
     */
    private java.lang.Integer transAt;

    /**
     *  �ֶ���msgTp.
     */
    private java.lang.String msgTp;

    /**
     *  �ֶ���locTransDtTm.
     */
    private java.lang.String locTransDtTm;

    /**
     *  �ֶ���mchntTp.
     */
    private java.lang.String mchntTp;

    /**
     *  �ֶ���retriRefNo.
     */
    private java.lang.String retriRefNo;

    /**
     *  �ֶ���priAcctNo.
     */
    private java.lang.String priAcctNo;

    /**
     *  �ֶ���bin.
     */
    private java.lang.String bin;

    /**
     *  �ֶ���cardAttr.
     */
    private java.lang.String cardAttr;

    /**
     *  �ֶ���cardMedia.
     */
    private java.lang.String cardMedia;

    /**
     *  �ֶ���termId.
     */
    private java.lang.String termId;

    /**
     *  �ֶ���mchntCd.
     */
    private java.lang.String mchntCd;

    /**
     *  �ֶ���cardAccptrNmLoc.
     */
    private java.lang.String cardAccptrNmLoc;

    /**
     *  �ֶ���acqInsIdCd.
     */
    private java.lang.String acqInsIdCd;

    /**
     *  �ֶ���fwdInsIdCd.
     */
    private java.lang.String fwdInsIdCd;

    /**
     *  �ֶ���rcvInsIdCd.
     */
    private java.lang.String rcvInsIdCd;

    /**
     *  �ֶ���issInsIdCd.
     */
    private java.lang.String issInsIdCd;

    /**
     *  �ֶ���origSysTraNo.
     */
    private java.lang.String origSysTraNo;

    /**
     *  �ֶ���origTransmsnDtTm.
     */
    private java.lang.String origTransmsnDtTm;

    /**
     *  �ֶ���rsnCd.
     */
    private java.lang.String rsnCd;

    /**
     *  �ֶ���authDt.
     */
    private String authDt;

    /**
     *  �ֶ���authIdRespCd.
     */
    private java.lang.String authIdRespCd;

    /**
     *  �ֶ���posEntryMdCd.
     */
    private java.lang.String posEntryMdCd;

    /**
     *  �ֶ���posCondCd.
     */
    private java.lang.String posCondCd;

    /**
     *  �ֶ���procCd.
     */
    private java.lang.String procCd;

    /**
     *  �ֶ���settleYm.
     */
    private java.lang.String settleYm;

    /**
     *  �ֶ���fwdInsIdOriginal.
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
     *  ��ȡ settleDt.
     *  @return java.util.Date.
     */
    public java.util.Date getSettleDt() {
        return this.settleDt;
    }

    /**
     *  ���� settleDt.
     *  @param settleDt settleDt��.
     */
    public void setSettleDt(java.util.Date settleDt) {
        this.settleDt = settleDt;
    }
    /**
     *  ��ȡ sysTraNo.
     *  @return java.lang.String.
     */
    public java.lang.String getSysTraNo() {
        return this.sysTraNo;
    }

    /**
     *  ���� sysTraNo.
     *  @param sysTraNo sysTraNo��.
     */
    public void setSysTraNo(java.lang.String sysTraNo) {
        this.sysTraNo = sysTraNo;
    }
    /**
     *  ��ȡ respCd4.
     *  @return java.lang.String.
     */
    public java.lang.String getRespCd4() {
        return this.respCd4;
    }

    /**
     *  ���� respCd4.
     *  @param respCd4 respCd4��.
     */
    public void setRespCd4(java.lang.String respCd4) {
        this.respCd4 = respCd4;
    }
    /**
     *  ��ȡ transId.
     *  @return java.lang.String.
     */
    public java.lang.String getTransId() {
        return this.transId;
    }

    /**
     *  ���� transId.
     *  @param transId transId��.
     */
    public void setTransId(java.lang.String transId) {
        this.transId = transId;
    }
    /**
     *  ��ȡ settleIn.
     *  @return java.lang.String.
     */
    public java.lang.String getSettleIn() {
        return this.settleIn;
    }

    /**
     *  ���� settleIn.
     *  @param settleIn settleIn��.
     */
    public void setSettleIn(java.lang.String settleIn) {
        this.settleIn = settleIn;
    }
    /**
     *  ��ȡ transAt.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getTransAt() {
        return this.transAt;
    }

    /**
     *  ���� transAt.
     *  @param transAt transAt��.
     */
    public void setTransAt(java.lang.Integer transAt) {
        this.transAt = transAt;
    }
    /**
     *  ��ȡ msgTp.
     *  @return java.lang.String.
     */
    public java.lang.String getMsgTp() {
        return this.msgTp;
    }

    /**
     *  ���� msgTp.
     *  @param msgTp msgTp��.
     */
    public void setMsgTp(java.lang.String msgTp) {
        this.msgTp = msgTp;
    }
    /**
     *  ��ȡ locTransDtTm.
     *  @return java.lang.String.
     */
    public java.lang.String getLocTransDtTm() {
        return this.locTransDtTm;
    }

    /**
     *  ���� locTransDtTm.
     *  @param locTransDtTm locTransDtTm��.
     */
    public void setLocTransDtTm(java.lang.String locTransDtTm) {
        this.locTransDtTm = locTransDtTm;
    }
    /**
     *  ��ȡ mchntTp.
     *  @return java.lang.String.
     */
    public java.lang.String getMchntTp() {
        return this.mchntTp;
    }

    /**
     *  ���� mchntTp.
     *  @param mchntTp mchntTp��.
     */
    public void setMchntTp(java.lang.String mchntTp) {
        this.mchntTp = mchntTp;
    }
    /**
     *  ��ȡ retriRefNo.
     *  @return java.lang.String.
     */
    public java.lang.String getRetriRefNo() {
        return this.retriRefNo;
    }

    /**
     *  ���� retriRefNo.
     *  @param retriRefNo retriRefNo��.
     */
    public void setRetriRefNo(java.lang.String retriRefNo) {
        this.retriRefNo = retriRefNo;
    }
    /**
     *  ��ȡ priAcctNo.
     *  @return java.lang.String.
     */
    public java.lang.String getPriAcctNo() {
        return this.priAcctNo;
    }

    /**
     *  ���� priAcctNo.
     *  @param priAcctNo priAcctNo��.
     */
    public void setPriAcctNo(java.lang.String priAcctNo) {
        this.priAcctNo = priAcctNo;
    }
    /**
     *  ��ȡ bin.
     *  @return java.lang.String.
     */
    public java.lang.String getBin() {
        return this.bin;
    }

    /**
     *  ���� bin.
     *  @param bin bin��.
     */
    public void setBin(java.lang.String bin) {
        this.bin = bin;
    }
    /**
     *  ��ȡ cardAttr.
     *  @return java.lang.String.
     */
    public java.lang.String getCardAttr() {
        return this.cardAttr;
    }

    /**
     *  ���� cardAttr.
     *  @param cardAttr cardAttr��.
     */
    public void setCardAttr(java.lang.String cardAttr) {
        this.cardAttr = cardAttr;
    }
    /**
     *  ��ȡ cardMedia.
     *  @return java.lang.String.
     */
    public java.lang.String getCardMedia() {
        return this.cardMedia;
    }

    /**
     *  ���� cardMedia.
     *  @param cardMedia cardMedia��.
     */
    public void setCardMedia(java.lang.String cardMedia) {
        this.cardMedia = cardMedia;
    }
    /**
     *  ��ȡ termId.
     *  @return java.lang.String.
     */
    public java.lang.String getTermId() {
        return this.termId;
    }

    /**
     *  ���� termId.
     *  @param termId termId��.
     */
    public void setTermId(java.lang.String termId) {
        this.termId = termId;
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
     *  ��ȡ cardAccptrNmLoc.
     *  @return java.lang.String.
     */
    public java.lang.String getCardAccptrNmLoc() {
        return this.cardAccptrNmLoc;
    }

    /**
     *  ���� cardAccptrNmLoc.
     *  @param cardAccptrNmLoc cardAccptrNmLoc��.
     */
    public void setCardAccptrNmLoc(java.lang.String cardAccptrNmLoc) {
        this.cardAccptrNmLoc = cardAccptrNmLoc;
    }
    /**
     *  ��ȡ acqInsIdCd.
     *  @return java.lang.String.
     */
    public java.lang.String getAcqInsIdCd() {
        return this.acqInsIdCd;
    }

    /**
     *  ���� acqInsIdCd.
     *  @param acqInsIdCd acqInsIdCd��.
     */
    public void setAcqInsIdCd(java.lang.String acqInsIdCd) {
        this.acqInsIdCd = acqInsIdCd;
    }
    /**
     *  ��ȡ fwdInsIdCd.
     *  @return java.lang.String.
     */
    public java.lang.String getFwdInsIdCd() {
        return this.fwdInsIdCd;
    }

    /**
     *  ���� fwdInsIdCd.
     *  @param fwdInsIdCd fwdInsIdCd��.
     */
    public void setFwdInsIdCd(java.lang.String fwdInsIdCd) {
        this.fwdInsIdCd = fwdInsIdCd;
    }
    /**
     *  ��ȡ rcvInsIdCd.
     *  @return java.lang.String.
     */
    public java.lang.String getRcvInsIdCd() {
        return this.rcvInsIdCd;
    }

    /**
     *  ���� rcvInsIdCd.
     *  @param rcvInsIdCd rcvInsIdCd��.
     */
    public void setRcvInsIdCd(java.lang.String rcvInsIdCd) {
        this.rcvInsIdCd = rcvInsIdCd;
    }
    /**
     *  ��ȡ issInsIdCd.
     *  @return java.lang.String.
     */
    public java.lang.String getIssInsIdCd() {
        return this.issInsIdCd;
    }

    /**
     *  ���� issInsIdCd.
     *  @param issInsIdCd issInsIdCd��.
     */
    public void setIssInsIdCd(java.lang.String issInsIdCd) {
        this.issInsIdCd = issInsIdCd;
    }
    /**
     *  ��ȡ origSysTraNo.
     *  @return java.lang.String.
     */
    public java.lang.String getOrigSysTraNo() {
        return this.origSysTraNo;
    }

    /**
     *  ���� origSysTraNo.
     *  @param origSysTraNo origSysTraNo��.
     */
    public void setOrigSysTraNo(java.lang.String origSysTraNo) {
        this.origSysTraNo = origSysTraNo;
    }
    /**
     *  ��ȡ origTransmsnDtTm.
     *  @return java.lang.String.
     */
    public java.lang.String getOrigTransmsnDtTm() {
        return this.origTransmsnDtTm;
    }

    /**
     *  ���� origTransmsnDtTm.
     *  @param origTransmsnDtTm origTransmsnDtTm��.
     */
    public void setOrigTransmsnDtTm(java.lang.String origTransmsnDtTm) {
        this.origTransmsnDtTm = origTransmsnDtTm;
    }
    /**
     *  ��ȡ rsnCd.
     *  @return java.lang.String.
     */
    public java.lang.String getRsnCd() {
        return this.rsnCd;
    }

    /**
     *  ���� rsnCd.
     *  @param rsnCd rsnCd��.
     */
    public void setRsnCd(java.lang.String rsnCd) {
        this.rsnCd = rsnCd;
    }
    public void setAuthDt(String authDt) {
		this.authDt = authDt;
	}

	/**
     *  ��ȡ authDt.
     *  @return java.util.Date.
     */
    public String getAuthDt() {
        return this.authDt;
    }

    /**
     *  ��ȡ authIdRespCd.
     *  @return java.lang.String.
     */
    public java.lang.String getAuthIdRespCd() {
        return this.authIdRespCd;
    }

    /**
     *  ���� authIdRespCd.
     *  @param authIdRespCd authIdRespCd��.
     */
    public void setAuthIdRespCd(java.lang.String authIdRespCd) {
        this.authIdRespCd = authIdRespCd;
    }
    /**
     *  ��ȡ posEntryMdCd.
     *  @return java.lang.String.
     */
    public java.lang.String getPosEntryMdCd() {
        return this.posEntryMdCd;
    }

    /**
     *  ���� posEntryMdCd.
     *  @param posEntryMdCd posEntryMdCd��.
     */
    public void setPosEntryMdCd(java.lang.String posEntryMdCd) {
        this.posEntryMdCd = posEntryMdCd;
    }
    /**
     *  ��ȡ posCondCd.
     *  @return java.lang.String.
     */
    public java.lang.String getPosCondCd() {
        return this.posCondCd;
    }

    /**
     *  ���� posCondCd.
     *  @param posCondCd posCondCd��.
     */
    public void setPosCondCd(java.lang.String posCondCd) {
        this.posCondCd = posCondCd;
    }
    /**
     *  ��ȡ procCd.
     *  @return java.lang.String.
     */
    public java.lang.String getProcCd() {
        return this.procCd;
    }

    /**
     *  ���� procCd.
     *  @param procCd procCd��.
     */
    public void setProcCd(java.lang.String procCd) {
        this.procCd = procCd;
    }
    /**
     *  ��ȡ settleYm.
     *  @return java.lang.String.
     */
    public java.lang.String getSettleYm() {
        return this.settleYm;
    }

    /**
     *  ���� settleYm.
     *  @param settleYm settleYm��.
     */
    public void setSettleYm(java.lang.String settleYm) {
        this.settleYm = settleYm;
    }
    /**
     *  ��ȡ fwdInsIdOriginal.
     *  @return java.lang.String.
     */
    public java.lang.String getFwdInsIdOriginal() {
        return this.fwdInsIdOriginal;
    }

    /**
     *  ���� fwdInsIdOriginal.
     *  @param fwdInsIdOriginal fwdInsIdOriginal��.
     */
    public void setFwdInsIdOriginal(java.lang.String fwdInsIdOriginal) {
        this.fwdInsIdOriginal = fwdInsIdOriginal;
    }


}
