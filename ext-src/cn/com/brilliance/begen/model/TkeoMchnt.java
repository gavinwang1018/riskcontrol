package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  定义类TkeoMchnt.
     */
public class TkeoMchnt extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  字段域id.
     */
    private java.lang.String id;

    /**
     *  字段域mchntCd.
     */
    private java.lang.String mchntCd;

    /**
     *  字段域reason.
     */
    private java.lang.String reason;

    /**
     *  字段域mchntName.
     */
    private java.lang.String mchntName;

/*
1,个人结算商户
2,豁免商户
3,重点监控商户
4,关注监控商户
5,新发展商户
6,已撤销商户
7,外卡商户
8,套现广告商户
*/
    /**
     *  字段域type.
     */
    private java.lang.String type;

/*
@selectItems.torganizeInfoItems
*/
    /**
     *  字段域belongToInst.
     */
    private java.lang.String belongToInst;

    
    private TorganizeInfo subInst;
    
    
    /**
     *  字段域settlementAccntNo.
     */
    private java.lang.String settlementAccntNo;

    /**
     *  字段域state.
     */
    private java.lang.String state;

    /**
     *  字段域approvedDate.
     */
    private java.util.Date approvedDate;

    /**
     *  字段域withdrawInputdate.
     */
    private java.util.Date withdrawInputdate;

    /**
     *  字段域mchntId.
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
     *  获取 reason.
     *  @return java.lang.String.
     */
    public java.lang.String getReason() {
        return this.reason;
    }

    /**
     *  设置 reason.
     *  @param reason reason域.
     */
    public void setReason(java.lang.String reason) {
        this.reason = reason;
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
     *  获取 type.
     *  @return java.lang.String.
     */
    public java.lang.String getType() {
        return this.type;
    }

    /**
     *  设置 type.
     *  @param type type域.
     */
    public void setType(java.lang.String type) {
        this.type = type;
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
     *  获取 settlementAccntNo.
     *  @return java.lang.String.
     */
    public java.lang.String getSettlementAccntNo() {
        return this.settlementAccntNo;
    }

    /**
     *  设置 settlementAccntNo.
     *  @param settlementAccntNo settlementAccntNo域.
     */
    public void setSettlementAccntNo(java.lang.String settlementAccntNo) {
        this.settlementAccntNo = settlementAccntNo;
    }
    /**
     *  获取 state.
     *  @return java.lang.String.
     */
    public java.lang.String getState() {
        return this.state;
    }

    /**
     *  设置 state.
     *  @param state state域.
     */
    public void setState(java.lang.String state) {
        this.state = state;
    }
    /**
     *  获取 approvedDate.
     *  @return java.util.Date.
     */
    public java.util.Date getApprovedDate() {
        return this.approvedDate;
    }

    /**
     *  设置 approvedDate.
     *  @param approvedDate approvedDate域.
     */
    public void setApprovedDate(java.util.Date approvedDate) {
        this.approvedDate = approvedDate;
    }
    /**
     *  获取 withdrawInputdate.
     *  @return java.util.Date.
     */
    public java.util.Date getWithdrawInputdate() {
        return this.withdrawInputdate;
    }

    /**
     *  设置 withdrawInputdate.
     *  @param withdrawInputdate withdrawInputdate域.
     */
    public void setWithdrawInputdate(java.util.Date withdrawInputdate) {
        this.withdrawInputdate = withdrawInputdate;
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
     *  获取 subInst.
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
     *  设置 subInst.
     *  @param subInst subInst域.
     */
	public void setSubInst(TorganizeInfo subInst) {
		this.subInst = subInst;
	}


}
