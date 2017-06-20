package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  ������Tmchnt.
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
     *  �ֶ���merchantcategory.
     */
    private java.lang.String merchantcategory;

    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���foreigncard.
     */
    private java.lang.String foreigncard;

    /**
     *  �ֶ���merchantnature.
     */
    private java.lang.String merchantnature;

    /**
     *  �ֶ���name.
     */
    private java.lang.String name;

    /**
     *  �ֶ���briefname.
     */
    private java.lang.String briefname;

    /**
     *  �ֶ���engname.
     */
    private java.lang.String engname;

    /**
     *  �ֶ���engbriefname.
     */
    private java.lang.String engbriefname;

    /**
     *  �ֶ���contractant.
     */
    private java.lang.String contractant;

    /**
     *  �ֶ���licenseno.
     */
    private java.lang.String licenseno;

    /**
     *  �ֶ���registeredcapital.
     */
    private java.lang.String registeredcapital;

    /**
     *  �ֶ���taxno.
     */
    private java.lang.String taxno;

    /**
     *  �ֶ���merchantno.
     */
    private java.lang.String merchantno;

    /**
     *  �ֶ���installdate.
     */
    private java.util.Date installdate;

    /**
     *  �ֶ���withdrawinputdate.
     */
    private java.util.Date withdrawinputdate;

/*
@extSelectItems.belongToInstList
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
     *  �ֶ���developingmethod.
     */
    private java.lang.String developingmethod;

    /**
     *  �ֶ���multiacquirer.
     */
    private java.lang.Boolean multiacquirer;

    /**
     *  �ֶ���businessacceptmethod.
     */
    private java.lang.String businessacceptmethod;

    /**
     *  �ֶ���state.
     */
    private java.lang.String state;

    /**
     *  �ֶ���servicerate.
     */
    private java.lang.String servicerate;

    /**
     *  �ֶ���legalman.
     */
    private java.lang.String legalman;

    /**
     *  �ֶ���idcardtype.
     */
    private java.lang.String idcardtype;

    /**
     *  �ֶ���idcardno.
     */
    private java.lang.String idcardno;

    /**
     *  �ֶ���licensedeadline.
     */
    private java.util.Date licensedeadline;

    /**
     *  �ֶ���registerAddress.
     */
    private java.lang.String registerAddress;

    /**
     *  �ֶ���registerZipcode.
     */
    private java.lang.String registerZipcode;

    /**
     *  �ֶ���officeAddress.
     */
    private java.lang.String officeAddress;

    /**
     *  �ֶ���officeZipcode.
     */
    private java.lang.String officeZipcode;

    /**
     *  �ֶ���contactperson.
     */
    private java.lang.String contactperson;

    /**
     *  �ֶ���dept.
     */
    private java.lang.String dept;

    /**
     *  �ֶ���tel.
     */
    private java.lang.String tel;

    /**
     *  �ֶ���mobtel.
     */
    private java.lang.String mobtel;

    /**
     *  �ֶ���fax.
     */
    private java.lang.String fax;

    /**
     *  �ֶ���email.
     */
    private java.lang.String email;

    /**
     *  �ֶ���financeperson.
     */
    private java.lang.String financeperson;

    /**
     *  �ֶ���financetel.
     */
    private java.lang.String financetel;

    /**
     *  �ֶ���financemotel.
     */
    private java.lang.String financemotel;

    /**
     *  �ֶ���financefax.
     */
    private java.lang.String financefax;

    /**
     *  �ֶ���financeemail.
     */
    private java.lang.String financeemail;

    /**
     *  �ֶ���mailperson.
     */
    private java.lang.String mailperson;

    /**
     *  �ֶ���mailtel.
     */
    private java.lang.String mailtel;

    /**
     *  �ֶ���mailmobtel.
     */
    private java.lang.String mailmobtel;

    /**
     *  �ֶ���chargereduingtime.
     */
    private java.lang.Integer chargereduingtime;

    /**
     *  �ֶ���guaranteemethod.
     */
    private java.lang.String guaranteemethod;

    /**
     *  �ֶ���guaranteemethoddesc.
     */
    private java.lang.String guaranteemethoddesc;

    /**
     *  �ֶ���approvedesc.
     */
    private java.lang.String approvedesc;

    /**
     *  �ֶ���approveddate.
     */
    private java.util.Date approveddate;

    /**
     *  �ֶ���addingcategory.
     */
    private java.lang.String addingcategory;

    /**
     *  �ֶ���logoutinputdate.
     */
    private java.util.Date logoutinputdate;

    /**
     *  �ֶ���withdrawcategory.
     */
    private java.lang.String withdrawcategory;

    /**
     *  �ֶ���withdrawoperator.
     */
    private java.lang.String withdrawoperator;

    /**
     *  �ֶ���laststatechangedate.
     */
    private java.util.Date laststatechangedate;

    /**
     *  �ֶ���laststatechangeoperator.
     */
    private java.lang.String laststatechangeoperator;

    /**
     *  �ֶ���province.
     */
    private java.lang.String province;

    /**
     *  �ֶ���city.
     */
    private java.lang.String city;

    /**
     *  �ֶ���county.
     */
    private java.lang.String county;

    /**
     *  �ֶ���refusereason.
     */
    private java.lang.String refusereason;

    /**
     *  �ֶ���remark.
     */
    private java.lang.String remark;

    /**
     *  �ֶ���networktransferinst.
     */
    private java.lang.String networktransferinst;
    
    
    /**
     *  ������tmchntAppGroup.
     */
    private Set tmchntAppGroup;
	
	private List tmchntApps;


    /**
     *  ��merchantcategoryOfTmcc.
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
     *  ��ȡ foreigncard.
     *  @return java.lang.String.
     */
    public java.lang.String getForeigncard() {
        return this.foreigncard;
    }

    /**
     *  ���� foreigncard.
     *  @param foreigncard foreigncard��.
     */
    public void setForeigncard(java.lang.String foreigncard) {
        this.foreigncard = foreigncard;
    }
    /**
     *  ��ȡ merchantnature.
     *  @return java.lang.String.
     */
    public java.lang.String getMerchantnature() {
        return this.merchantnature;
    }

    /**
     *  ���� merchantnature.
     *  @param merchantnature merchantnature��.
     */
    public void setMerchantnature(java.lang.String merchantnature) {
        this.merchantnature = merchantnature;
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
     *  ��ȡ briefname.
     *  @return java.lang.String.
     */
    public java.lang.String getBriefname() {
        return this.briefname;
    }

    /**
     *  ���� briefname.
     *  @param briefname briefname��.
     */
    public void setBriefname(java.lang.String briefname) {
        this.briefname = briefname;
    }
    /**
     *  ��ȡ engname.
     *  @return java.lang.String.
     */
    public java.lang.String getEngname() {
        return this.engname;
    }

    /**
     *  ���� engname.
     *  @param engname engname��.
     */
    public void setEngname(java.lang.String engname) {
        this.engname = engname;
    }
    /**
     *  ��ȡ engbriefname.
     *  @return java.lang.String.
     */
    public java.lang.String getEngbriefname() {
        return this.engbriefname;
    }

    /**
     *  ���� engbriefname.
     *  @param engbriefname engbriefname��.
     */
    public void setEngbriefname(java.lang.String engbriefname) {
        this.engbriefname = engbriefname;
    }
    /**
     *  ��ȡ contractant.
     *  @return java.lang.String.
     */
    public java.lang.String getContractant() {
        return this.contractant;
    }

    /**
     *  ���� contractant.
     *  @param contractant contractant��.
     */
    public void setContractant(java.lang.String contractant) {
        this.contractant = contractant;
    }
    /**
     *  ��ȡ licenseno.
     *  @return java.lang.String.
     */
    public java.lang.String getLicenseno() {
        return this.licenseno;
    }

    /**
     *  ���� licenseno.
     *  @param licenseno licenseno��.
     */
    public void setLicenseno(java.lang.String licenseno) {
        this.licenseno = licenseno;
    }
    /**
     *  ��ȡ registeredcapital.
     *  @return java.lang.String.
     */
    public java.lang.String getRegisteredcapital() {
        return this.registeredcapital;
    }

    /**
     *  ���� registeredcapital.
     *  @param registeredcapital registeredcapital��.
     */
    public void setRegisteredcapital(java.lang.String registeredcapital) {
        this.registeredcapital = registeredcapital;
    }
    /**
     *  ��ȡ taxno.
     *  @return java.lang.String.
     */
    public java.lang.String getTaxno() {
        return this.taxno;
    }

    /**
     *  ���� taxno.
     *  @param taxno taxno��.
     */
    public void setTaxno(java.lang.String taxno) {
        this.taxno = taxno;
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
     *  ��ȡ installdate.
     *  @return java.util.Date.
     */
    public java.util.Date getInstalldate() {
        return this.installdate;
    }

    /**
     *  ���� installdate.
     *  @param installdate installdate��.
     */
    public void setInstalldate(java.util.Date installdate) {
        this.installdate = installdate;
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
     *  ��ȡ developingmethod.
     *  @return java.lang.String.
     */
    public java.lang.String getDevelopingmethod() {
        return this.developingmethod;
    }

    /**
     *  ���� developingmethod.
     *  @param developingmethod developingmethod��.
     */
    public void setDevelopingmethod(java.lang.String developingmethod) {
        this.developingmethod = developingmethod;
    }
    /**
     *  ��ȡ multiacquirer.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getMultiacquirer() {
        return this.multiacquirer;
    }
    /**
     *  ���� multiacquirer.
     *  @param multiacquirer multiacquirer��.
     */
    public void setMultiacquirer(java.lang.Boolean multiacquirer) {
        this.multiacquirer = Boolean.TRUE;
    }
    /**
     *  ��ȡ businessacceptmethod.
     *  @return java.lang.String.
     */
    public java.lang.String getBusinessacceptmethod() {
        return this.businessacceptmethod;
    }

    /**
     *  ���� businessacceptmethod.
     *  @param businessacceptmethod businessacceptmethod��.
     */
    public void setBusinessacceptmethod(java.lang.String businessacceptmethod) {
        this.businessacceptmethod = businessacceptmethod;
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
     *  ��ȡ servicerate.
     *  @return java.lang.String.
     */
    public java.lang.String getServicerate() {
        return this.servicerate;
    }

    /**
     *  ���� servicerate.
     *  @param servicerate servicerate��.
     */
    public void setServicerate(java.lang.String servicerate) {
        this.servicerate = servicerate;
    }
    /**
     *  ��ȡ legalman.
     *  @return java.lang.String.
     */
    public java.lang.String getLegalman() {
        return this.legalman;
    }

    /**
     *  ���� legalman.
     *  @param legalman legalman��.
     */
    public void setLegalman(java.lang.String legalman) {
        this.legalman = legalman;
    }
    /**
     *  ��ȡ idcardtype.
     *  @return java.lang.String.
     */
    public java.lang.String getIdcardtype() {
        return this.idcardtype;
    }

    /**
     *  ���� idcardtype.
     *  @param idcardtype idcardtype��.
     */
    public void setIdcardtype(java.lang.String idcardtype) {
        this.idcardtype = idcardtype;
    }
    /**
     *  ��ȡ idcardno.
     *  @return java.lang.String.
     */
    public java.lang.String getIdcardno() {
        return this.idcardno;
    }

    /**
     *  ���� idcardno.
     *  @param idcardno idcardno��.
     */
    public void setIdcardno(java.lang.String idcardno) {
        this.idcardno = idcardno;
    }
    /**
     *  ��ȡ licensedeadline.
     *  @return java.util.Date.
     */
    public java.util.Date getLicensedeadline() {
        return this.licensedeadline;
    }

    /**
     *  ���� licensedeadline.
     *  @param licensedeadline licensedeadline��.
     */
    public void setLicensedeadline(java.util.Date licensedeadline) {
        this.licensedeadline = licensedeadline;
    }
    /**
     *  ��ȡ registerAddress.
     *  @return java.lang.String.
     */
    public java.lang.String getRegisterAddress() {
        return this.registerAddress;
    }

    /**
     *  ���� registerAddress.
     *  @param registerAddress registerAddress��.
     */
    public void setRegisterAddress(java.lang.String registerAddress) {
        this.registerAddress = registerAddress;
    }
    /**
     *  ��ȡ registerZipcode.
     *  @return java.lang.String.
     */
    public java.lang.String getRegisterZipcode() {
        return this.registerZipcode;
    }

    /**
     *  ���� registerZipcode.
     *  @param registerZipcode registerZipcode��.
     */
    public void setRegisterZipcode(java.lang.String registerZipcode) {
        this.registerZipcode = registerZipcode;
    }
    /**
     *  ��ȡ officeAddress.
     *  @return java.lang.String.
     */
    public java.lang.String getOfficeAddress() {
        return this.officeAddress;
    }

    /**
     *  ���� officeAddress.
     *  @param officeAddress officeAddress��.
     */
    public void setOfficeAddress(java.lang.String officeAddress) {
        this.officeAddress = officeAddress;
    }
    /**
     *  ��ȡ officeZipcode.
     *  @return java.lang.String.
     */
    public java.lang.String getOfficeZipcode() {
        return this.officeZipcode;
    }

    /**
     *  ���� officeZipcode.
     *  @param officeZipcode officeZipcode��.
     */
    public void setOfficeZipcode(java.lang.String officeZipcode) {
        this.officeZipcode = officeZipcode;
    }
    /**
     *  ��ȡ contactperson.
     *  @return java.lang.String.
     */
    public java.lang.String getContactperson() {
        return this.contactperson;
    }

    /**
     *  ���� contactperson.
     *  @param contactperson contactperson��.
     */
    public void setContactperson(java.lang.String contactperson) {
        this.contactperson = contactperson;
    }
    /**
     *  ��ȡ dept.
     *  @return java.lang.String.
     */
    public java.lang.String getDept() {
        return this.dept;
    }

    /**
     *  ���� dept.
     *  @param dept dept��.
     */
    public void setDept(java.lang.String dept) {
        this.dept = dept;
    }
    /**
     *  ��ȡ tel.
     *  @return java.lang.String.
     */
    public java.lang.String getTel() {
        return this.tel;
    }

    /**
     *  ���� tel.
     *  @param tel tel��.
     */
    public void setTel(java.lang.String tel) {
        this.tel = tel;
    }
    /**
     *  ��ȡ mobtel.
     *  @return java.lang.String.
     */
    public java.lang.String getMobtel() {
        return this.mobtel;
    }

    /**
     *  ���� mobtel.
     *  @param mobtel mobtel��.
     */
    public void setMobtel(java.lang.String mobtel) {
        this.mobtel = mobtel;
    }
    /**
     *  ��ȡ fax.
     *  @return java.lang.String.
     */
    public java.lang.String getFax() {
        return this.fax;
    }

    /**
     *  ���� fax.
     *  @param fax fax��.
     */
    public void setFax(java.lang.String fax) {
        this.fax = fax;
    }
    /**
     *  ��ȡ email.
     *  @return java.lang.String.
     */
    public java.lang.String getEmail() {
        return this.email;
    }

    /**
     *  ���� email.
     *  @param email email��.
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }
    /**
     *  ��ȡ financeperson.
     *  @return java.lang.String.
     */
    public java.lang.String getFinanceperson() {
        return this.financeperson;
    }

    /**
     *  ���� financeperson.
     *  @param financeperson financeperson��.
     */
    public void setFinanceperson(java.lang.String financeperson) {
        this.financeperson = financeperson;
    }
    /**
     *  ��ȡ financetel.
     *  @return java.lang.String.
     */
    public java.lang.String getFinancetel() {
        return this.financetel;
    }

    /**
     *  ���� financetel.
     *  @param financetel financetel��.
     */
    public void setFinancetel(java.lang.String financetel) {
        this.financetel = financetel;
    }
    /**
     *  ��ȡ financemotel.
     *  @return java.lang.String.
     */
    public java.lang.String getFinancemotel() {
        return this.financemotel;
    }

    /**
     *  ���� financemotel.
     *  @param financemotel financemotel��.
     */
    public void setFinancemotel(java.lang.String financemotel) {
        this.financemotel = financemotel;
    }
    /**
     *  ��ȡ financefax.
     *  @return java.lang.String.
     */
    public java.lang.String getFinancefax() {
        return this.financefax;
    }

    /**
     *  ���� financefax.
     *  @param financefax financefax��.
     */
    public void setFinancefax(java.lang.String financefax) {
        this.financefax = financefax;
    }
    /**
     *  ��ȡ financeemail.
     *  @return java.lang.String.
     */
    public java.lang.String getFinanceemail() {
        return this.financeemail;
    }

    /**
     *  ���� financeemail.
     *  @param financeemail financeemail��.
     */
    public void setFinanceemail(java.lang.String financeemail) {
        this.financeemail = financeemail;
    }
    /**
     *  ��ȡ mailperson.
     *  @return java.lang.String.
     */
    public java.lang.String getMailperson() {
        return this.mailperson;
    }

    /**
     *  ���� mailperson.
     *  @param mailperson mailperson��.
     */
    public void setMailperson(java.lang.String mailperson) {
        this.mailperson = mailperson;
    }
    /**
     *  ��ȡ mailtel.
     *  @return java.lang.String.
     */
    public java.lang.String getMailtel() {
        return this.mailtel;
    }

    /**
     *  ���� mailtel.
     *  @param mailtel mailtel��.
     */
    public void setMailtel(java.lang.String mailtel) {
        this.mailtel = mailtel;
    }
    /**
     *  ��ȡ mailmobtel.
     *  @return java.lang.String.
     */
    public java.lang.String getMailmobtel() {
        return this.mailmobtel;
    }

    /**
     *  ���� mailmobtel.
     *  @param mailmobtel mailmobtel��.
     */
    public void setMailmobtel(java.lang.String mailmobtel) {
        this.mailmobtel = mailmobtel;
    }
    /**
     *  ��ȡ chargereduingtime.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getChargereduingtime() {
        return this.chargereduingtime;
    }

    /**
     *  ���� chargereduingtime.
     *  @param chargereduingtime chargereduingtime��.
     */
    public void setChargereduingtime(java.lang.Integer chargereduingtime) {
        this.chargereduingtime = chargereduingtime;
    }
    /**
     *  ��ȡ guaranteemethod.
     *  @return java.lang.String.
     */
    public java.lang.String getGuaranteemethod() {
        return this.guaranteemethod;
    }

    /**
     *  ���� guaranteemethod.
     *  @param guaranteemethod guaranteemethod��.
     */
    public void setGuaranteemethod(java.lang.String guaranteemethod) {
        this.guaranteemethod = guaranteemethod;
    }
    /**
     *  ��ȡ guaranteemethoddesc.
     *  @return java.lang.String.
     */
    public java.lang.String getGuaranteemethoddesc() {
        return this.guaranteemethoddesc;
    }

    /**
     *  ���� guaranteemethoddesc.
     *  @param guaranteemethoddesc guaranteemethoddesc��.
     */
    public void setGuaranteemethoddesc(java.lang.String guaranteemethoddesc) {
        this.guaranteemethoddesc = guaranteemethoddesc;
    }
    /**
     *  ��ȡ approvedesc.
     *  @return java.lang.String.
     */
    public java.lang.String getApprovedesc() {
        return this.approvedesc;
    }

    /**
     *  ���� approvedesc.
     *  @param approvedesc approvedesc��.
     */
    public void setApprovedesc(java.lang.String approvedesc) {
        this.approvedesc = approvedesc;
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
     *  ��ȡ addingcategory.
     *  @return java.lang.String.
     */
    public java.lang.String getAddingcategory() {
        return this.addingcategory;
    }

    /**
     *  ���� addingcategory.
     *  @param addingcategory addingcategory��.
     */
    public void setAddingcategory(java.lang.String addingcategory) {
        this.addingcategory = addingcategory;
    }
    /**
     *  ��ȡ logoutinputdate.
     *  @return java.util.Date.
     */
    public java.util.Date getLogoutinputdate() {
        return this.logoutinputdate;
    }

    /**
     *  ���� logoutinputdate.
     *  @param logoutinputdate logoutinputdate��.
     */
    public void setLogoutinputdate(java.util.Date logoutinputdate) {
        this.logoutinputdate = logoutinputdate;
    }
    /**
     *  ��ȡ withdrawcategory.
     *  @return java.lang.String.
     */
    public java.lang.String getWithdrawcategory() {
        return this.withdrawcategory;
    }

    /**
     *  ���� withdrawcategory.
     *  @param withdrawcategory withdrawcategory��.
     */
    public void setWithdrawcategory(java.lang.String withdrawcategory) {
        this.withdrawcategory = withdrawcategory;
    }
    /**
     *  ��ȡ withdrawoperator.
     *  @return java.lang.String.
     */
    public java.lang.String getWithdrawoperator() {
        return this.withdrawoperator;
    }

    /**
     *  ���� withdrawoperator.
     *  @param withdrawoperator withdrawoperator��.
     */
    public void setWithdrawoperator(java.lang.String withdrawoperator) {
        this.withdrawoperator = withdrawoperator;
    }
    /**
     *  ��ȡ laststatechangedate.
     *  @return java.util.Date.
     */
    public java.util.Date getLaststatechangedate() {
        return this.laststatechangedate;
    }

    /**
     *  ���� laststatechangedate.
     *  @param laststatechangedate laststatechangedate��.
     */
    public void setLaststatechangedate(java.util.Date laststatechangedate) {
        this.laststatechangedate = laststatechangedate;
    }
    /**
     *  ��ȡ laststatechangeoperator.
     *  @return java.lang.String.
     */
    public java.lang.String getLaststatechangeoperator() {
        return this.laststatechangeoperator;
    }

    /**
     *  ���� laststatechangeoperator.
     *  @param laststatechangeoperator laststatechangeoperator��.
     */
    public void setLaststatechangeoperator(java.lang.String laststatechangeoperator) {
        this.laststatechangeoperator = laststatechangeoperator;
    }
    /**
     *  ��ȡ province.
     *  @return java.lang.String.
     */
    public java.lang.String getProvince() {
        return this.province;
    }

    /**
     *  ���� province.
     *  @param province province��.
     */
    public void setProvince(java.lang.String province) {
        this.province = province;
    }
    /**
     *  ��ȡ city.
     *  @return java.lang.String.
     */
    public java.lang.String getCity() {
        return this.city;
    }

    /**
     *  ���� city.
     *  @param city city��.
     */
    public void setCity(java.lang.String city) {
        this.city = city;
    }
    /**
     *  ��ȡ county.
     *  @return java.lang.String.
     */
    public java.lang.String getCounty() {
        return this.county;
    }

    /**
     *  ���� county.
     *  @param county county��.
     */
    public void setCounty(java.lang.String county) {
        this.county = county;
    }
    /**
     *  ��ȡ refusereason.
     *  @return java.lang.String.
     */
    public java.lang.String getRefusereason() {
        return this.refusereason;
    }

    /**
     *  ���� refusereason.
     *  @param refusereason refusereason��.
     */
    public void setRefusereason(java.lang.String refusereason) {
        this.refusereason = refusereason;
    }
    /**
     *  ��ȡ remark.
     *  @return java.lang.String.
     */
    public java.lang.String getRemark() {
        return this.remark;
    }

    /**
     *  ���� remark.
     *  @param remark remark��.
     */
    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }

    /**
     *  ��ȡ tmchntAppGroup.
     *  @return Set.
     */
    public Set getTmchntAppGroup() {
        return this.tmchntAppGroup;
    }

    /**
     *  ���� tmchntAppGroup.
     *  @param tmchntAppGroup tmchntAppGroup��.
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
     *  ��ȡ networktransferinst.
     *  @return java.lang.String.
     */
	public java.lang.String getNetworktransferinst() {
		return networktransferinst;
	}

	/**
     *  ���� networktransferinst.
     *  @param networktransferinst networktransferinst��.
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
