package cn.com.brilliance.begen.model;

import java.io.Serializable;

import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.TmccDAO;
import cn.com.brilliance.begen.dao.TorganizeInfoDAO;

public class TmchntAndApp extends BaseModel implements Serializable {
	 /**
     *  �ֶ���merchantcategory.
     */
    private java.lang.String merchantcategory;

    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���name.
     */
    private java.lang.String name;

    /**
     *  �ֶ���merchantno.
     */
    private java.lang.String merchantno;
    
    /**
     *  �ֶ���withdrawinputdate.
     */
    private java.util.Date withdrawinputdate;
    
    
    /*
    @selectItems.torganizeInfoItems
    */
    
    /**
     *  �ֶ���subinst.
     */
    private java.lang.String subinst;

    /**
     * ��belongToSubinst
     */
    private TorganizeInfo belongToSubinst;
    
    
    /**
     *  �ֶ���state.
     */
    private java.lang.String state;
    
    /**
     *  �ֶ���approveddate.
     */
    private java.util.Date approveddate;
    
    /**
     *  ��merchantcategoryOfTmcc.
     */
    private Tmcc merchantcategoryOfTmcc;
    
    
    /**
     *  �ֶ���settlementaccntno.
     */
    private java.lang.String settlementaccntno;
    

    /**
     *  ��ȡ merchantcategory.
     *  @return java.lang.String.
     */
    public java.lang.String getMerchantcategory() {
        return this.merchantcategory;
    }

    /**
     *  ���� merchantcategory.
     *  @param merchantcategory merchantcategory��.
     */
    public void setMerchantcategory(java.lang.String merchantcategory) {
        this.merchantcategory = merchantcategory;
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
     *  ��ȡ name.
     *  @return java.lang.String.
     */
    public java.lang.String getName() {
        return this.name;
    }

    /**
     *  ���� name.
     *  @param name name��.
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }
    /**
     *  ��ȡ merchantno.
     *  @return java.lang.String.
     */
    public java.lang.String getMerchantno() {
        return this.merchantno;
    }

    /**
     *  ���� merchantno.
     *  @param merchantno merchantno��.
     */
    public void setMerchantno(java.lang.String merchantno) {
        this.merchantno = merchantno;
    }
    /**
     *  ��ȡ withdrawinputdate.
     *  @return java.util.Date.
     */
    public java.util.Date getWithdrawinputdate() {
        return this.withdrawinputdate;
    }

    /**
     *  ���� withdrawinputdate.
     *  @param withdrawinputdate withdrawinputdate��.
     */
    public void setWithdrawinputdate(java.util.Date withdrawinputdate) {
        this.withdrawinputdate = withdrawinputdate;
    }
    /**
     *  ��ȡ subinst.
     *  @return java.lang.String.
     */
    public java.lang.String getSubinst() {
        return this.subinst;
    }

    /**
     *  ���� subinst.
     *  @param subinst subinst��.
     */
    public void setSubinst(java.lang.String subinst) {
        this.subinst = subinst;
    }
    /**
     *  ��ȡ belongToInstOfTorganizeInfo.
     *  @return TorganizeInfo.
     */
    public TorganizeInfo getBelongToSubinst() {
    	if (this.belongToSubinst == null && this.subinst != null  && !"".equals(this.subinst)){
    		TorganizeInfoDAO torganizeInfoDAO = (TorganizeInfoDAO)Tools.getBean("torganizeInfoDAO");
    		this.belongToSubinst= torganizeInfoDAO.getTorganizeInfo(this.subinst);
    	}
		return belongToSubinst;
	}

    /**
     *  ���� belongToInstOfTorganizeInfo.
     *  @param belongToInstOfTorganizeInfo belongToInstOfTorganizeInfo��.
     */
	public void setBelongToSubinst(TorganizeInfo belongToSubinst) {
		this.belongToSubinst = belongToSubinst;
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
     *  ��ȡ approveddate.
     *  @return java.util.Date.
     */
    public java.util.Date getApproveddate() {
        return this.approveddate;
    }

    /**
     *  ���� approveddate.
     *  @param approveddate approveddate��.
     */
    public void setApproveddate(java.util.Date approveddate) {
        this.approveddate = approveddate;
    }

    /**
     *  ��ȡ merchantcategoryOfTmcc.
     *  @return Tmcc.
     */
    public Tmcc getMerchantcategoryOfTmcc() {
    	if (this.merchantcategoryOfTmcc == null && this.merchantcategory != null  && !"".equals(this.merchantcategory)){
    		TmccDAO tmccDAO = (TmccDAO)Tools.getBean("tmccDAO");
    		this.merchantcategoryOfTmcc= tmccDAO.getTmcc(this.merchantcategory);
    	}
        return this.merchantcategoryOfTmcc;
    }

    /**
     *  ���� merchantcategoryOfTmcc.
     *  @param merchantcategoryOfTmcc merchantcategoryOfTmcc��.
     */
    public void setMerchantcategoryOfTmcc(Tmcc merchantcategoryOfTmcc) {
        this.merchantcategoryOfTmcc = merchantcategoryOfTmcc;
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
}
