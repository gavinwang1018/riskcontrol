package cn.com.brilliance.begen.model;

import java.io.Serializable;

import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.TmccDAO;
import cn.com.brilliance.begen.dao.TorganizeInfoDAO;

public class TmchntAndApp extends BaseModel implements Serializable {
	 /**
     *  字段域merchantcategory.
     */
    private java.lang.String merchantcategory;

    /**
     *  字段域id.
     */
    private java.lang.String id;

    /**
     *  字段域name.
     */
    private java.lang.String name;

    /**
     *  字段域merchantno.
     */
    private java.lang.String merchantno;
    
    /**
     *  字段域withdrawinputdate.
     */
    private java.util.Date withdrawinputdate;
    
    
    /*
    @selectItems.torganizeInfoItems
    */
    
    /**
     *  字段域subinst.
     */
    private java.lang.String subinst;

    /**
     * 域belongToSubinst
     */
    private TorganizeInfo belongToSubinst;
    
    
    /**
     *  字段域state.
     */
    private java.lang.String state;
    
    /**
     *  字段域approveddate.
     */
    private java.util.Date approveddate;
    
    /**
     *  域merchantcategoryOfTmcc.
     */
    private Tmcc merchantcategoryOfTmcc;
    
    
    /**
     *  字段域settlementaccntno.
     */
    private java.lang.String settlementaccntno;
    

    /**
     *  获取 merchantcategory.
     *  @return java.lang.String.
     */
    public java.lang.String getMerchantcategory() {
        return this.merchantcategory;
    }

    /**
     *  设置 merchantcategory.
     *  @param merchantcategory merchantcategory域.
     */
    public void setMerchantcategory(java.lang.String merchantcategory) {
        this.merchantcategory = merchantcategory;
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
     *  获取 name.
     *  @return java.lang.String.
     */
    public java.lang.String getName() {
        return this.name;
    }

    /**
     *  设置 name.
     *  @param name name域.
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }
    /**
     *  获取 merchantno.
     *  @return java.lang.String.
     */
    public java.lang.String getMerchantno() {
        return this.merchantno;
    }

    /**
     *  设置 merchantno.
     *  @param merchantno merchantno域.
     */
    public void setMerchantno(java.lang.String merchantno) {
        this.merchantno = merchantno;
    }
    /**
     *  获取 withdrawinputdate.
     *  @return java.util.Date.
     */
    public java.util.Date getWithdrawinputdate() {
        return this.withdrawinputdate;
    }

    /**
     *  设置 withdrawinputdate.
     *  @param withdrawinputdate withdrawinputdate域.
     */
    public void setWithdrawinputdate(java.util.Date withdrawinputdate) {
        this.withdrawinputdate = withdrawinputdate;
    }
    /**
     *  获取 subinst.
     *  @return java.lang.String.
     */
    public java.lang.String getSubinst() {
        return this.subinst;
    }

    /**
     *  设置 subinst.
     *  @param subinst subinst域.
     */
    public void setSubinst(java.lang.String subinst) {
        this.subinst = subinst;
    }
    /**
     *  获取 belongToInstOfTorganizeInfo.
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
     *  设置 belongToInstOfTorganizeInfo.
     *  @param belongToInstOfTorganizeInfo belongToInstOfTorganizeInfo域.
     */
	public void setBelongToSubinst(TorganizeInfo belongToSubinst) {
		this.belongToSubinst = belongToSubinst;
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
     *  获取 approveddate.
     *  @return java.util.Date.
     */
    public java.util.Date getApproveddate() {
        return this.approveddate;
    }

    /**
     *  设置 approveddate.
     *  @param approveddate approveddate域.
     */
    public void setApproveddate(java.util.Date approveddate) {
        this.approveddate = approveddate;
    }

    /**
     *  获取 merchantcategoryOfTmcc.
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
     *  设置 merchantcategoryOfTmcc.
     *  @param merchantcategoryOfTmcc merchantcategoryOfTmcc域.
     */
    public void setMerchantcategoryOfTmcc(Tmcc merchantcategoryOfTmcc) {
        this.merchantcategoryOfTmcc = merchantcategoryOfTmcc;
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
}
