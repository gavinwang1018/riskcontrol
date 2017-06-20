package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  定义类Tmchnt.
     */
public class Tmchnt extends BaseModel implements Serializable {

	private boolean checked;
	
	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
/*
@extSelectItems.tmccIdsOfTmccs
*/
    /**
     *  字段域merchantcategory.
     */
    private java.lang.String merchantcategory;

    /**
     *  字段域id.
     */
    private java.lang.String id;

    /**
     *  字段域foreigncard.
     */
    private java.lang.String foreigncard;

    /**
     *  字段域merchantnature.
     */
    private java.lang.String merchantnature;

    /**
     *  字段域name.
     */
    private java.lang.String name;

    /**
     *  字段域briefname.
     */
    private java.lang.String briefname;

    /**
     *  字段域engname.
     */
    private java.lang.String engname;

    /**
     *  字段域engbriefname.
     */
    private java.lang.String engbriefname;

    /**
     *  字段域contractant.
     */
    private java.lang.String contractant;

    /**
     *  字段域licenseno.
     */
    private java.lang.String licenseno;

    /**
     *  字段域registeredcapital.
     */
    private java.lang.String registeredcapital;

    /**
     *  字段域taxno.
     */
    private java.lang.String taxno;

    /**
     *  字段域merchantno.
     */
    private java.lang.String merchantno;

    /**
     *  字段域installdate.
     */
    private java.util.Date installdate;

    /**
     *  字段域withdrawinputdate.
     */
    private java.util.Date withdrawinputdate;

/*
@extSelectItems.belongToInstList
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
     *  字段域developingmethod.
     */
    private java.lang.String developingmethod;

    /**
     *  字段域multiacquirer.
     */
    private java.lang.Boolean multiacquirer;

    /**
     *  字段域businessacceptmethod.
     */
    private java.lang.String businessacceptmethod;

    /**
     *  字段域state.
     */
    private java.lang.String state;

    /**
     *  字段域servicerate.
     */
    private java.lang.String servicerate;

    /**
     *  字段域legalman.
     */
    private java.lang.String legalman;

    /**
     *  字段域idcardtype.
     */
    private java.lang.String idcardtype;

    /**
     *  字段域idcardno.
     */
    private java.lang.String idcardno;

    /**
     *  字段域licensedeadline.
     */
    private java.util.Date licensedeadline;

    /**
     *  字段域registerAddress.
     */
    private java.lang.String registerAddress;

    /**
     *  字段域registerZipcode.
     */
    private java.lang.String registerZipcode;

    /**
     *  字段域officeAddress.
     */
    private java.lang.String officeAddress;

    /**
     *  字段域officeZipcode.
     */
    private java.lang.String officeZipcode;

    /**
     *  字段域contactperson.
     */
    private java.lang.String contactperson;

    /**
     *  字段域dept.
     */
    private java.lang.String dept;

    /**
     *  字段域tel.
     */
    private java.lang.String tel;

    /**
     *  字段域mobtel.
     */
    private java.lang.String mobtel;

    /**
     *  字段域fax.
     */
    private java.lang.String fax;

    /**
     *  字段域email.
     */
    private java.lang.String email;

    /**
     *  字段域financeperson.
     */
    private java.lang.String financeperson;

    /**
     *  字段域financetel.
     */
    private java.lang.String financetel;

    /**
     *  字段域financemotel.
     */
    private java.lang.String financemotel;

    /**
     *  字段域financefax.
     */
    private java.lang.String financefax;

    /**
     *  字段域financeemail.
     */
    private java.lang.String financeemail;

    /**
     *  字段域mailperson.
     */
    private java.lang.String mailperson;

    /**
     *  字段域mailtel.
     */
    private java.lang.String mailtel;

    /**
     *  字段域mailmobtel.
     */
    private java.lang.String mailmobtel;

    /**
     *  字段域chargereduingtime.
     */
    private java.lang.Integer chargereduingtime;

    /**
     *  字段域guaranteemethod.
     */
    private java.lang.String guaranteemethod;

    /**
     *  字段域guaranteemethoddesc.
     */
    private java.lang.String guaranteemethoddesc;

    /**
     *  字段域approvedesc.
     */
    private java.lang.String approvedesc;

    /**
     *  字段域approveddate.
     */
    private java.util.Date approveddate;

    /**
     *  字段域addingcategory.
     */
    private java.lang.String addingcategory;

    /**
     *  字段域logoutinputdate.
     */
    private java.util.Date logoutinputdate;

    /**
     *  字段域withdrawcategory.
     */
    private java.lang.String withdrawcategory;

    /**
     *  字段域withdrawoperator.
     */
    private java.lang.String withdrawoperator;

    /**
     *  字段域laststatechangedate.
     */
    private java.util.Date laststatechangedate;

    /**
     *  字段域laststatechangeoperator.
     */
    private java.lang.String laststatechangeoperator;

    /**
     *  字段域province.
     */
    private java.lang.String province;

    /**
     *  字段域city.
     */
    private java.lang.String city;

    /**
     *  字段域county.
     */
    private java.lang.String county;

    /**
     *  字段域refusereason.
     */
    private java.lang.String refusereason;

    /**
     *  字段域remark.
     */
    private java.lang.String remark;

    /**
     *  字段域networktransferinst.
     */
    private java.lang.String networktransferinst;
    
    
    /**
     *  集合域tmchntAppGroup.
     */
    private Set tmchntAppGroup;
	
	private List tmchntApps;


    /**
     *  域merchantcategoryOfTmcc.
     */
    private Tmcc merchantcategoryOfTmcc;

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
     *  获取 foreigncard.
     *  @return java.lang.String.
     */
    public java.lang.String getForeigncard() {
        return this.foreigncard;
    }

    /**
     *  设置 foreigncard.
     *  @param foreigncard foreigncard域.
     */
    public void setForeigncard(java.lang.String foreigncard) {
        this.foreigncard = foreigncard;
    }
    /**
     *  获取 merchantnature.
     *  @return java.lang.String.
     */
    public java.lang.String getMerchantnature() {
        return this.merchantnature;
    }

    /**
     *  设置 merchantnature.
     *  @param merchantnature merchantnature域.
     */
    public void setMerchantnature(java.lang.String merchantnature) {
        this.merchantnature = merchantnature;
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
     *  获取 briefname.
     *  @return java.lang.String.
     */
    public java.lang.String getBriefname() {
        return this.briefname;
    }

    /**
     *  设置 briefname.
     *  @param briefname briefname域.
     */
    public void setBriefname(java.lang.String briefname) {
        this.briefname = briefname;
    }
    /**
     *  获取 engname.
     *  @return java.lang.String.
     */
    public java.lang.String getEngname() {
        return this.engname;
    }

    /**
     *  设置 engname.
     *  @param engname engname域.
     */
    public void setEngname(java.lang.String engname) {
        this.engname = engname;
    }
    /**
     *  获取 engbriefname.
     *  @return java.lang.String.
     */
    public java.lang.String getEngbriefname() {
        return this.engbriefname;
    }

    /**
     *  设置 engbriefname.
     *  @param engbriefname engbriefname域.
     */
    public void setEngbriefname(java.lang.String engbriefname) {
        this.engbriefname = engbriefname;
    }
    /**
     *  获取 contractant.
     *  @return java.lang.String.
     */
    public java.lang.String getContractant() {
        return this.contractant;
    }

    /**
     *  设置 contractant.
     *  @param contractant contractant域.
     */
    public void setContractant(java.lang.String contractant) {
        this.contractant = contractant;
    }
    /**
     *  获取 licenseno.
     *  @return java.lang.String.
     */
    public java.lang.String getLicenseno() {
        return this.licenseno;
    }

    /**
     *  设置 licenseno.
     *  @param licenseno licenseno域.
     */
    public void setLicenseno(java.lang.String licenseno) {
        this.licenseno = licenseno;
    }
    /**
     *  获取 registeredcapital.
     *  @return java.lang.String.
     */
    public java.lang.String getRegisteredcapital() {
        return this.registeredcapital;
    }

    /**
     *  设置 registeredcapital.
     *  @param registeredcapital registeredcapital域.
     */
    public void setRegisteredcapital(java.lang.String registeredcapital) {
        this.registeredcapital = registeredcapital;
    }
    /**
     *  获取 taxno.
     *  @return java.lang.String.
     */
    public java.lang.String getTaxno() {
        return this.taxno;
    }

    /**
     *  设置 taxno.
     *  @param taxno taxno域.
     */
    public void setTaxno(java.lang.String taxno) {
        this.taxno = taxno;
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
     *  获取 installdate.
     *  @return java.util.Date.
     */
    public java.util.Date getInstalldate() {
        return this.installdate;
    }

    /**
     *  设置 installdate.
     *  @param installdate installdate域.
     */
    public void setInstalldate(java.util.Date installdate) {
        this.installdate = installdate;
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
     *  获取 developingmethod.
     *  @return java.lang.String.
     */
    public java.lang.String getDevelopingmethod() {
        return this.developingmethod;
    }

    /**
     *  设置 developingmethod.
     *  @param developingmethod developingmethod域.
     */
    public void setDevelopingmethod(java.lang.String developingmethod) {
        this.developingmethod = developingmethod;
    }
    /**
     *  获取 multiacquirer.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getMultiacquirer() {
        return this.multiacquirer;
    }
    /**
     *  设置 multiacquirer.
     *  @param multiacquirer multiacquirer域.
     */
    public void setMultiacquirer(java.lang.Boolean multiacquirer) {
        this.multiacquirer = Boolean.TRUE;
    }
    /**
     *  获取 businessacceptmethod.
     *  @return java.lang.String.
     */
    public java.lang.String getBusinessacceptmethod() {
        return this.businessacceptmethod;
    }

    /**
     *  设置 businessacceptmethod.
     *  @param businessacceptmethod businessacceptmethod域.
     */
    public void setBusinessacceptmethod(java.lang.String businessacceptmethod) {
        this.businessacceptmethod = businessacceptmethod;
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
     *  获取 servicerate.
     *  @return java.lang.String.
     */
    public java.lang.String getServicerate() {
        return this.servicerate;
    }

    /**
     *  设置 servicerate.
     *  @param servicerate servicerate域.
     */
    public void setServicerate(java.lang.String servicerate) {
        this.servicerate = servicerate;
    }
    /**
     *  获取 legalman.
     *  @return java.lang.String.
     */
    public java.lang.String getLegalman() {
        return this.legalman;
    }

    /**
     *  设置 legalman.
     *  @param legalman legalman域.
     */
    public void setLegalman(java.lang.String legalman) {
        this.legalman = legalman;
    }
    /**
     *  获取 idcardtype.
     *  @return java.lang.String.
     */
    public java.lang.String getIdcardtype() {
        return this.idcardtype;
    }

    /**
     *  设置 idcardtype.
     *  @param idcardtype idcardtype域.
     */
    public void setIdcardtype(java.lang.String idcardtype) {
        this.idcardtype = idcardtype;
    }
    /**
     *  获取 idcardno.
     *  @return java.lang.String.
     */
    public java.lang.String getIdcardno() {
        return this.idcardno;
    }

    /**
     *  设置 idcardno.
     *  @param idcardno idcardno域.
     */
    public void setIdcardno(java.lang.String idcardno) {
        this.idcardno = idcardno;
    }
    /**
     *  获取 licensedeadline.
     *  @return java.util.Date.
     */
    public java.util.Date getLicensedeadline() {
        return this.licensedeadline;
    }

    /**
     *  设置 licensedeadline.
     *  @param licensedeadline licensedeadline域.
     */
    public void setLicensedeadline(java.util.Date licensedeadline) {
        this.licensedeadline = licensedeadline;
    }
    /**
     *  获取 registerAddress.
     *  @return java.lang.String.
     */
    public java.lang.String getRegisterAddress() {
        return this.registerAddress;
    }

    /**
     *  设置 registerAddress.
     *  @param registerAddress registerAddress域.
     */
    public void setRegisterAddress(java.lang.String registerAddress) {
        this.registerAddress = registerAddress;
    }
    /**
     *  获取 registerZipcode.
     *  @return java.lang.String.
     */
    public java.lang.String getRegisterZipcode() {
        return this.registerZipcode;
    }

    /**
     *  设置 registerZipcode.
     *  @param registerZipcode registerZipcode域.
     */
    public void setRegisterZipcode(java.lang.String registerZipcode) {
        this.registerZipcode = registerZipcode;
    }
    /**
     *  获取 officeAddress.
     *  @return java.lang.String.
     */
    public java.lang.String getOfficeAddress() {
        return this.officeAddress;
    }

    /**
     *  设置 officeAddress.
     *  @param officeAddress officeAddress域.
     */
    public void setOfficeAddress(java.lang.String officeAddress) {
        this.officeAddress = officeAddress;
    }
    /**
     *  获取 officeZipcode.
     *  @return java.lang.String.
     */
    public java.lang.String getOfficeZipcode() {
        return this.officeZipcode;
    }

    /**
     *  设置 officeZipcode.
     *  @param officeZipcode officeZipcode域.
     */
    public void setOfficeZipcode(java.lang.String officeZipcode) {
        this.officeZipcode = officeZipcode;
    }
    /**
     *  获取 contactperson.
     *  @return java.lang.String.
     */
    public java.lang.String getContactperson() {
        return this.contactperson;
    }

    /**
     *  设置 contactperson.
     *  @param contactperson contactperson域.
     */
    public void setContactperson(java.lang.String contactperson) {
        this.contactperson = contactperson;
    }
    /**
     *  获取 dept.
     *  @return java.lang.String.
     */
    public java.lang.String getDept() {
        return this.dept;
    }

    /**
     *  设置 dept.
     *  @param dept dept域.
     */
    public void setDept(java.lang.String dept) {
        this.dept = dept;
    }
    /**
     *  获取 tel.
     *  @return java.lang.String.
     */
    public java.lang.String getTel() {
        return this.tel;
    }

    /**
     *  设置 tel.
     *  @param tel tel域.
     */
    public void setTel(java.lang.String tel) {
        this.tel = tel;
    }
    /**
     *  获取 mobtel.
     *  @return java.lang.String.
     */
    public java.lang.String getMobtel() {
        return this.mobtel;
    }

    /**
     *  设置 mobtel.
     *  @param mobtel mobtel域.
     */
    public void setMobtel(java.lang.String mobtel) {
        this.mobtel = mobtel;
    }
    /**
     *  获取 fax.
     *  @return java.lang.String.
     */
    public java.lang.String getFax() {
        return this.fax;
    }

    /**
     *  设置 fax.
     *  @param fax fax域.
     */
    public void setFax(java.lang.String fax) {
        this.fax = fax;
    }
    /**
     *  获取 email.
     *  @return java.lang.String.
     */
    public java.lang.String getEmail() {
        return this.email;
    }

    /**
     *  设置 email.
     *  @param email email域.
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }
    /**
     *  获取 financeperson.
     *  @return java.lang.String.
     */
    public java.lang.String getFinanceperson() {
        return this.financeperson;
    }

    /**
     *  设置 financeperson.
     *  @param financeperson financeperson域.
     */
    public void setFinanceperson(java.lang.String financeperson) {
        this.financeperson = financeperson;
    }
    /**
     *  获取 financetel.
     *  @return java.lang.String.
     */
    public java.lang.String getFinancetel() {
        return this.financetel;
    }

    /**
     *  设置 financetel.
     *  @param financetel financetel域.
     */
    public void setFinancetel(java.lang.String financetel) {
        this.financetel = financetel;
    }
    /**
     *  获取 financemotel.
     *  @return java.lang.String.
     */
    public java.lang.String getFinancemotel() {
        return this.financemotel;
    }

    /**
     *  设置 financemotel.
     *  @param financemotel financemotel域.
     */
    public void setFinancemotel(java.lang.String financemotel) {
        this.financemotel = financemotel;
    }
    /**
     *  获取 financefax.
     *  @return java.lang.String.
     */
    public java.lang.String getFinancefax() {
        return this.financefax;
    }

    /**
     *  设置 financefax.
     *  @param financefax financefax域.
     */
    public void setFinancefax(java.lang.String financefax) {
        this.financefax = financefax;
    }
    /**
     *  获取 financeemail.
     *  @return java.lang.String.
     */
    public java.lang.String getFinanceemail() {
        return this.financeemail;
    }

    /**
     *  设置 financeemail.
     *  @param financeemail financeemail域.
     */
    public void setFinanceemail(java.lang.String financeemail) {
        this.financeemail = financeemail;
    }
    /**
     *  获取 mailperson.
     *  @return java.lang.String.
     */
    public java.lang.String getMailperson() {
        return this.mailperson;
    }

    /**
     *  设置 mailperson.
     *  @param mailperson mailperson域.
     */
    public void setMailperson(java.lang.String mailperson) {
        this.mailperson = mailperson;
    }
    /**
     *  获取 mailtel.
     *  @return java.lang.String.
     */
    public java.lang.String getMailtel() {
        return this.mailtel;
    }

    /**
     *  设置 mailtel.
     *  @param mailtel mailtel域.
     */
    public void setMailtel(java.lang.String mailtel) {
        this.mailtel = mailtel;
    }
    /**
     *  获取 mailmobtel.
     *  @return java.lang.String.
     */
    public java.lang.String getMailmobtel() {
        return this.mailmobtel;
    }

    /**
     *  设置 mailmobtel.
     *  @param mailmobtel mailmobtel域.
     */
    public void setMailmobtel(java.lang.String mailmobtel) {
        this.mailmobtel = mailmobtel;
    }
    /**
     *  获取 chargereduingtime.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getChargereduingtime() {
        return this.chargereduingtime;
    }

    /**
     *  设置 chargereduingtime.
     *  @param chargereduingtime chargereduingtime域.
     */
    public void setChargereduingtime(java.lang.Integer chargereduingtime) {
        this.chargereduingtime = chargereduingtime;
    }
    /**
     *  获取 guaranteemethod.
     *  @return java.lang.String.
     */
    public java.lang.String getGuaranteemethod() {
        return this.guaranteemethod;
    }

    /**
     *  设置 guaranteemethod.
     *  @param guaranteemethod guaranteemethod域.
     */
    public void setGuaranteemethod(java.lang.String guaranteemethod) {
        this.guaranteemethod = guaranteemethod;
    }
    /**
     *  获取 guaranteemethoddesc.
     *  @return java.lang.String.
     */
    public java.lang.String getGuaranteemethoddesc() {
        return this.guaranteemethoddesc;
    }

    /**
     *  设置 guaranteemethoddesc.
     *  @param guaranteemethoddesc guaranteemethoddesc域.
     */
    public void setGuaranteemethoddesc(java.lang.String guaranteemethoddesc) {
        this.guaranteemethoddesc = guaranteemethoddesc;
    }
    /**
     *  获取 approvedesc.
     *  @return java.lang.String.
     */
    public java.lang.String getApprovedesc() {
        return this.approvedesc;
    }

    /**
     *  设置 approvedesc.
     *  @param approvedesc approvedesc域.
     */
    public void setApprovedesc(java.lang.String approvedesc) {
        this.approvedesc = approvedesc;
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
     *  获取 addingcategory.
     *  @return java.lang.String.
     */
    public java.lang.String getAddingcategory() {
        return this.addingcategory;
    }

    /**
     *  设置 addingcategory.
     *  @param addingcategory addingcategory域.
     */
    public void setAddingcategory(java.lang.String addingcategory) {
        this.addingcategory = addingcategory;
    }
    /**
     *  获取 logoutinputdate.
     *  @return java.util.Date.
     */
    public java.util.Date getLogoutinputdate() {
        return this.logoutinputdate;
    }

    /**
     *  设置 logoutinputdate.
     *  @param logoutinputdate logoutinputdate域.
     */
    public void setLogoutinputdate(java.util.Date logoutinputdate) {
        this.logoutinputdate = logoutinputdate;
    }
    /**
     *  获取 withdrawcategory.
     *  @return java.lang.String.
     */
    public java.lang.String getWithdrawcategory() {
        return this.withdrawcategory;
    }

    /**
     *  设置 withdrawcategory.
     *  @param withdrawcategory withdrawcategory域.
     */
    public void setWithdrawcategory(java.lang.String withdrawcategory) {
        this.withdrawcategory = withdrawcategory;
    }
    /**
     *  获取 withdrawoperator.
     *  @return java.lang.String.
     */
    public java.lang.String getWithdrawoperator() {
        return this.withdrawoperator;
    }

    /**
     *  设置 withdrawoperator.
     *  @param withdrawoperator withdrawoperator域.
     */
    public void setWithdrawoperator(java.lang.String withdrawoperator) {
        this.withdrawoperator = withdrawoperator;
    }
    /**
     *  获取 laststatechangedate.
     *  @return java.util.Date.
     */
    public java.util.Date getLaststatechangedate() {
        return this.laststatechangedate;
    }

    /**
     *  设置 laststatechangedate.
     *  @param laststatechangedate laststatechangedate域.
     */
    public void setLaststatechangedate(java.util.Date laststatechangedate) {
        this.laststatechangedate = laststatechangedate;
    }
    /**
     *  获取 laststatechangeoperator.
     *  @return java.lang.String.
     */
    public java.lang.String getLaststatechangeoperator() {
        return this.laststatechangeoperator;
    }

    /**
     *  设置 laststatechangeoperator.
     *  @param laststatechangeoperator laststatechangeoperator域.
     */
    public void setLaststatechangeoperator(java.lang.String laststatechangeoperator) {
        this.laststatechangeoperator = laststatechangeoperator;
    }
    /**
     *  获取 province.
     *  @return java.lang.String.
     */
    public java.lang.String getProvince() {
        return this.province;
    }

    /**
     *  设置 province.
     *  @param province province域.
     */
    public void setProvince(java.lang.String province) {
        this.province = province;
    }
    /**
     *  获取 city.
     *  @return java.lang.String.
     */
    public java.lang.String getCity() {
        return this.city;
    }

    /**
     *  设置 city.
     *  @param city city域.
     */
    public void setCity(java.lang.String city) {
        this.city = city;
    }
    /**
     *  获取 county.
     *  @return java.lang.String.
     */
    public java.lang.String getCounty() {
        return this.county;
    }

    /**
     *  设置 county.
     *  @param county county域.
     */
    public void setCounty(java.lang.String county) {
        this.county = county;
    }
    /**
     *  获取 refusereason.
     *  @return java.lang.String.
     */
    public java.lang.String getRefusereason() {
        return this.refusereason;
    }

    /**
     *  设置 refusereason.
     *  @param refusereason refusereason域.
     */
    public void setRefusereason(java.lang.String refusereason) {
        this.refusereason = refusereason;
    }
    /**
     *  获取 remark.
     *  @return java.lang.String.
     */
    public java.lang.String getRemark() {
        return this.remark;
    }

    /**
     *  设置 remark.
     *  @param remark remark域.
     */
    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }

    /**
     *  获取 tmchntAppGroup.
     *  @return Set.
     */
    public Set getTmchntAppGroup() {
        return this.tmchntAppGroup;
    }

    /**
     *  设置 tmchntAppGroup.
     *  @param tmchntAppGroup tmchntAppGroup域.
     */
    public void setTmchntAppGroup(Set tmchntAppGroup) {
        this.tmchntAppGroup = tmchntAppGroup;
    }
	
	public List getTmchntApps() {
        return this.tmchntApps;
    }

    public void setTmchntApps(List tmchntApps) {
        this.tmchntApps = tmchntApps;
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
     *  获取 networktransferinst.
     *  @return java.lang.String.
     */
	public java.lang.String getNetworktransferinst() {
		return networktransferinst;
	}

	/**
     *  设置 networktransferinst.
     *  @param networktransferinst networktransferinst域.
     */
	public void setNetworktransferinst(java.lang.String networktransferinst) {
		this.networktransferinst = networktransferinst;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
}
