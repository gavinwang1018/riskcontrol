package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  ������TkeoMchnt.
     */
public class TkeoMchnt extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���mchntCd.
     */
    private java.lang.String mchntCd;

    /**
     *  �ֶ���reason.
     */
    private java.lang.String reason;

    /**
     *  �ֶ���mchntName.
     */
    private java.lang.String mchntName;

/*
1,���˽����̻�
2,�����̻�
3,�ص����̻�
4,��ע����̻�
5,�·�չ�̻�
6,�ѳ����̻�
7,�⿨�̻�
8,���ֹ���̻�
*/
    /**
     *  �ֶ���type.
     */
    private java.lang.String type;

/*
@selectItems.torganizeInfoItems
*/
    /**
     *  �ֶ���belongToInst.
     */
    private java.lang.String belongToInst;

    
    private TorganizeInfo subInst;
    
    
    /**
     *  �ֶ���settlementAccntNo.
     */
    private java.lang.String settlementAccntNo;

    /**
     *  �ֶ���state.
     */
    private java.lang.String state;

    /**
     *  �ֶ���approvedDate.
     */
    private java.util.Date approvedDate;

    /**
     *  �ֶ���withdrawInputdate.
     */
    private java.util.Date withdrawInputdate;

    /**
     *  �ֶ���mchntId.
     */
    private java.lang.String mchntId;



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
     *  ��ȡ reason.
     *  @return java.lang.String.
     */
    public java.lang.String getReason() {
        return this.reason;
    }

    /**
     *  ���� reason.
     *  @param reason reason��.
     */
    public void setReason(java.lang.String reason) {
        this.reason = reason;
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
     *  ��ȡ type.
     *  @return java.lang.String.
     */
    public java.lang.String getType() {
        return this.type;
    }

    /**
     *  ���� type.
     *  @param type type��.
     */
    public void setType(java.lang.String type) {
        this.type = type;
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
     *  ��ȡ settlementAccntNo.
     *  @return java.lang.String.
     */
    public java.lang.String getSettlementAccntNo() {
        return this.settlementAccntNo;
    }

    /**
     *  ���� settlementAccntNo.
     *  @param settlementAccntNo settlementAccntNo��.
     */
    public void setSettlementAccntNo(java.lang.String settlementAccntNo) {
        this.settlementAccntNo = settlementAccntNo;
    }
    /**
     *  ��ȡ state.
     *  @return java.lang.String.
     */
    public java.lang.String getState() {
        return this.state;
    }

    /**
     *  ���� state.
     *  @param state state��.
     */
    public void setState(java.lang.String state) {
        this.state = state;
    }
    /**
     *  ��ȡ approvedDate.
     *  @return java.util.Date.
     */
    public java.util.Date getApprovedDate() {
        return this.approvedDate;
    }

    /**
     *  ���� approvedDate.
     *  @param approvedDate approvedDate��.
     */
    public void setApprovedDate(java.util.Date approvedDate) {
        this.approvedDate = approvedDate;
    }
    /**
     *  ��ȡ withdrawInputdate.
     *  @return java.util.Date.
     */
    public java.util.Date getWithdrawInputdate() {
        return this.withdrawInputdate;
    }

    /**
     *  ���� withdrawInputdate.
     *  @param withdrawInputdate withdrawInputdate��.
     */
    public void setWithdrawInputdate(java.util.Date withdrawInputdate) {
        this.withdrawInputdate = withdrawInputdate;
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
     *  ��ȡ subInst.
     *  @return TorganizeInfo.
     */
	public TorganizeInfo getSubInst() { 
		if (this.subInst == null && this.belongToInst != null  && !"".equals(this.belongToInst)){
    		TorganizeInfoDAO torganizeInfoDAO = (TorganizeInfoDAO)Tools.getBean("torganizeInfoDAO");
    		this.subInst= torganizeInfoDAO.getTorganizeInfo(this.belongToInst);
    	}
		return subInst;
	}

	/**
     *  ���� subInst.
     *  @param subInst subInst��.
     */
	public void setSubInst(TorganizeInfo subInst) {
		this.subInst = subInst;
	}


}
