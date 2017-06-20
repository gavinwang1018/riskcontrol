package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  ������TmchntApp.
     */
public class TmchntApp extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  �ֶ���mchntId.
     */
    private java.lang.String mchntId;

    /**
     *  �ֶ���apptype.
     */
    private java.lang.String apptype;

    /**
     *  �ֶ���main.
     */
    private java.lang.Boolean main;

    /**
     *  �ֶ���acquirer.
     */
    private java.lang.String acquirer;

    /**
     *  �ֶ���networktransferinst.
     */
    private java.lang.String networktransferinst;

    /**
     *  �ֶ���memberinstmerno.
     */
    private java.lang.String memberinstmerno;

    /**
     *  �ֶ���depositbank.
     */
    private java.lang.String depositbank;

    /**
     *  �ֶ���settlementaccntname.
     */
    private java.lang.String settlementaccntname;

    /**
     *  �ֶ���settlementaccntno.
     */
    private java.lang.String settlementaccntno;

    /**
     *  �ֶ���belongToInst.
     */
    private java.lang.String belongToInst;

    /**
     *  �ֶ���id.
     */
    private java.lang.String id;


    /**
     *  ��mchntIdOfTmchnt.
     */
    private Tmchnt mchntIdOfTmchnt;
    /**
     *  ��belongToInstOfTorganizeInfo.
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
     *  ��ȡ apptype.
     *  @return java.lang.String.
     */
    public java.lang.String getApptype() {
        return this.apptype;
    }

    /**
     *  ���� apptype.
     *  @param apptype apptype��.
     */
    public void setApptype(java.lang.String apptype) {
        this.apptype = apptype;
    }
    /**
     *  ��ȡ main.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getMain() {
        return this.main;
    }

    /**
     *  ���� main.
     *  @param main main��.
     */
    public void setMain(java.lang.Boolean main) {
        this.main = main;
    }
    /**
     *  ��ȡ acquirer.
     *  @return java.lang.String.
     */
    public java.lang.String getAcquirer() {
        return this.acquirer;
    }

    /**
     *  ���� acquirer.
     *  @param acquirer acquirer��.
     */
    public void setAcquirer(java.lang.String acquirer) {
        this.acquirer = acquirer;
    }
    /**
     *  ��ȡ networktransferinst.
     *  @return java.lang.String.
     */
    public java.lang.String getNetworktransferinst() {
        return this.networktransferinst;
    }

    /**
     *  ���� networktransferinst.
     *  @param networktransferinst networktransferinst��.
     */
    public void setNetworktransferinst(java.lang.String networktransferinst) {
        this.networktransferinst = networktransferinst;
    }
    /**
     *  ��ȡ memberinstmerno.
     *  @return java.lang.String.
     */
    public java.lang.String getMemberinstmerno() {
        return this.memberinstmerno;
    }

    /**
     *  ���� memberinstmerno.
     *  @param memberinstmerno memberinstmerno��.
     */
    public void setMemberinstmerno(java.lang.String memberinstmerno) {
        this.memberinstmerno = memberinstmerno;
    }
    /**
     *  ��ȡ depositbank.
     *  @return java.lang.String.
     */
    public java.lang.String getDepositbank() {
        return this.depositbank;
    }

    /**
     *  ���� depositbank.
     *  @param depositbank depositbank��.
     */
    public void setDepositbank(java.lang.String depositbank) {
        this.depositbank = depositbank;
    }
    /**
     *  ��ȡ settlementaccntname.
     *  @return java.lang.String.
     */
    public java.lang.String getSettlementaccntname() {
        return this.settlementaccntname;
    }

    /**
     *  ���� settlementaccntname.
     *  @param settlementaccntname settlementaccntname��.
     */
    public void setSettlementaccntname(java.lang.String settlementaccntname) {
        this.settlementaccntname = settlementaccntname;
    }
    /**
     *  ��ȡ settlementaccntno.
     *  @return java.lang.String.
     */
    public java.lang.String getSettlementaccntno() {
        return this.settlementaccntno;
    }

    /**
     *  ���� settlementaccntno.
     *  @param settlementaccntno settlementaccntno��.
     */
    public void setSettlementaccntno(java.lang.String settlementaccntno) {
        this.settlementaccntno = settlementaccntno;
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
     *  ��ȡ mchntIdOfTmchnt.
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
     *  ���� mchntIdOfTmchnt.
     *  @param mchntIdOfTmchnt mchntIdOfTmchnt��.
     */
    public void setMchntIdOfTmchnt(Tmchnt mchntIdOfTmchnt) {
        this.mchntIdOfTmchnt = mchntIdOfTmchnt;
    }



    /**
     *  ��ȡ belongToInstOfTorganizeInfo.
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
     *  ���� belongToInstOfTorganizeInfo.
     *  @param belongToInstOfTorganizeInfo belongToInstOfTorganizeInfo��.
     */
    public void setBelongToInstOfTorganizeInfo(TorganizeInfo belongToInstOfTorganizeInfo) {
        this.belongToInstOfTorganizeInfo = belongToInstOfTorganizeInfo;
    }

}
