package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  定义类TmchntApp.
     */
public class TmchntApp extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  字段域mchntId.
     */
    private java.lang.String mchntId;

    /**
     *  字段域apptype.
     */
    private java.lang.String apptype;

    /**
     *  字段域main.
     */
    private java.lang.Boolean main;

    /**
     *  字段域acquirer.
     */
    private java.lang.String acquirer;

    /**
     *  字段域networktransferinst.
     */
    private java.lang.String networktransferinst;

    /**
     *  字段域memberinstmerno.
     */
    private java.lang.String memberinstmerno;

    /**
     *  字段域depositbank.
     */
    private java.lang.String depositbank;

    /**
     *  字段域settlementaccntname.
     */
    private java.lang.String settlementaccntname;

    /**
     *  字段域settlementaccntno.
     */
    private java.lang.String settlementaccntno;

    /**
     *  字段域belongToInst.
     */
    private java.lang.String belongToInst;

    /**
     *  字段域id.
     */
    private java.lang.String id;


    /**
     *  域mchntIdOfTmchnt.
     */
    private Tmchnt mchntIdOfTmchnt;
    /**
     *  域belongToInstOfTorganizeInfo.
     */
    private TorganizeInfo belongToInstOfTorganizeInfo;

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
     *  获取 apptype.
     *  @return java.lang.String.
     */
    public java.lang.String getApptype() {
        return this.apptype;
    }

    /**
     *  设置 apptype.
     *  @param apptype apptype域.
     */
    public void setApptype(java.lang.String apptype) {
        this.apptype = apptype;
    }
    /**
     *  获取 main.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getMain() {
        return this.main;
    }

    /**
     *  设置 main.
     *  @param main main域.
     */
    public void setMain(java.lang.Boolean main) {
        this.main = main;
    }
    /**
     *  获取 acquirer.
     *  @return java.lang.String.
     */
    public java.lang.String getAcquirer() {
        return this.acquirer;
    }

    /**
     *  设置 acquirer.
     *  @param acquirer acquirer域.
     */
    public void setAcquirer(java.lang.String acquirer) {
        this.acquirer = acquirer;
    }
    /**
     *  获取 networktransferinst.
     *  @return java.lang.String.
     */
    public java.lang.String getNetworktransferinst() {
        return this.networktransferinst;
    }

    /**
     *  设置 networktransferinst.
     *  @param networktransferinst networktransferinst域.
     */
    public void setNetworktransferinst(java.lang.String networktransferinst) {
        this.networktransferinst = networktransferinst;
    }
    /**
     *  获取 memberinstmerno.
     *  @return java.lang.String.
     */
    public java.lang.String getMemberinstmerno() {
        return this.memberinstmerno;
    }

    /**
     *  设置 memberinstmerno.
     *  @param memberinstmerno memberinstmerno域.
     */
    public void setMemberinstmerno(java.lang.String memberinstmerno) {
        this.memberinstmerno = memberinstmerno;
    }
    /**
     *  获取 depositbank.
     *  @return java.lang.String.
     */
    public java.lang.String getDepositbank() {
        return this.depositbank;
    }

    /**
     *  设置 depositbank.
     *  @param depositbank depositbank域.
     */
    public void setDepositbank(java.lang.String depositbank) {
        this.depositbank = depositbank;
    }
    /**
     *  获取 settlementaccntname.
     *  @return java.lang.String.
     */
    public java.lang.String getSettlementaccntname() {
        return this.settlementaccntname;
    }

    /**
     *  设置 settlementaccntname.
     *  @param settlementaccntname settlementaccntname域.
     */
    public void setSettlementaccntname(java.lang.String settlementaccntname) {
        this.settlementaccntname = settlementaccntname;
    }
    /**
     *  获取 settlementaccntno.
     *  @return java.lang.String.
     */
    public java.lang.String getSettlementaccntno() {
        return this.settlementaccntno;
    }

    /**
     *  设置 settlementaccntno.
     *  @param settlementaccntno settlementaccntno域.
     */
    public void setSettlementaccntno(java.lang.String settlementaccntno) {
        this.settlementaccntno = settlementaccntno;
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
     *  获取 mchntIdOfTmchnt.
     *  @return Tmchnt.
     */
    public Tmchnt getMchntIdOfTmchnt() {
    	if (this.mchntIdOfTmchnt == null && this.mchntId != null  && !"".equals(this.mchntId)){
    		TmchntDAO tmchntDAO = (TmchntDAO)Tools.getBean("tmchntDAO");
    		this.mchntIdOfTmchnt= tmchntDAO.getTmchnt(this.mchntId);
    	}
        return this.mchntIdOfTmchnt;
    }

    /**
     *  设置 mchntIdOfTmchnt.
     *  @param mchntIdOfTmchnt mchntIdOfTmchnt域.
     */
    public void setMchntIdOfTmchnt(Tmchnt mchntIdOfTmchnt) {
        this.mchntIdOfTmchnt = mchntIdOfTmchnt;
    }



    /**
     *  获取 belongToInstOfTorganizeInfo.
     *  @return TorganizeInfo.
     */
    public TorganizeInfo getBelongToInstOfTorganizeInfo() {
    	if (this.belongToInstOfTorganizeInfo == null && this.belongToInst != null  && !"".equals(this.belongToInst)){
    		TorganizeInfoDAO torganizeInfoDAO = (TorganizeInfoDAO)Tools.getBean("torganizeInfoDAO");
    		this.belongToInstOfTorganizeInfo= torganizeInfoDAO.getTorganizeInfo(this.belongToInst);
    	}
        return this.belongToInstOfTorganizeInfo;
    }

    /**
     *  设置 belongToInstOfTorganizeInfo.
     *  @param belongToInstOfTorganizeInfo belongToInstOfTorganizeInfo域.
     */
    public void setBelongToInstOfTorganizeInfo(TorganizeInfo belongToInstOfTorganizeInfo) {
        this.belongToInstOfTorganizeInfo = belongToInstOfTorganizeInfo;
    }

}
