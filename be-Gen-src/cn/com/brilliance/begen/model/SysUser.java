package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;

    /**
     *  ������SysUser.
     */

public class SysUser implements Serializable {
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���userId.
     */
    private java.lang.String userId;

    /**
     *  �ֶ���userName.
     */
    private java.lang.String userName;

    /**
     *  �ֶ���password.
     */
    private java.lang.String password;

    /**
     *  �ֶ���orgId.
     */
    private java.lang.String orgId;

    /**
     *  �ֶ���partyId.
     */
    private java.lang.String partyId;

/*
0,����
1,Ůʿ
2,С��
*/
    /**
     *  �ֶ���personSex.
     */
    private java.lang.String personSex;

    /**
     *  �ֶ���email.
     */
    private java.lang.String email;

    /**
     *  �ֶ���phone.
     */
    private java.lang.String phone;

    /**
     *  �ֶ���adminFlag.
     */
    private java.lang.Boolean adminFlag;

    /**
     *  �ֶ���remark.
     */
    private java.lang.String remark;

    /**
     *  �ֶ���deskey.
     */
    private java.lang.String deskey;

    /**
     *  �ֶ���sendCa.
     */
    private java.lang.Boolean sendCa;

    /**
     *  �ֶ���enableCa.
     */
    private java.lang.Boolean enableCa;

    /**
     *  �ֶ���googleId.
     */
    private java.lang.String googleId;

    /**
     *  �ֶ���googlePassword.
     */
    private java.lang.String googlePassword;

    /**
     *  ������sysUserRoleGroup.
     */
    private Set sysUserRoleGroup;


    /**
     *  ��orgIdOfSysOrg.
     */
    private SysOrg orgIdOfSysOrg;
    /**
     *  ��partyIdOfSysParty.
     */
    private SysParty partyIdOfSysParty;


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
     *  ��ȡ userId.
     *  @return java.lang.String.
     */
    public java.lang.String getUserId() {
        return this.userId;
    }

    /**
     *  ���� userId.
     *  @param userId userId��.
     */
    public void setUserId(java.lang.String userId) {
        this.userId = userId;
    }
    /**
     *  ��ȡ userName.
     *  @return java.lang.String.
     */
    public java.lang.String getUserName() {
        return this.userName;
    }

    /**
     *  ���� userName.
     *  @param userName userName��.
     */
    public void setUserName(java.lang.String userName) {
        this.userName = userName;
    }
    /**
     *  ��ȡ password.
     *  @return java.lang.String.
     */
    public java.lang.String getPassword() {
        return this.password;
    }

    /**
     *  ���� password.
     *  @param password password��.
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }
    /**
     *  ��ȡ orgId.
     *  @return java.lang.String.
     */
    public java.lang.String getOrgId() {
        return this.orgId;
    }

    /**
     *  ���� orgId.
     *  @param orgId orgId��.
     */
    public void setOrgId(java.lang.String orgId) {
        this.orgId = orgId;
    }
    /**
     *  ��ȡ partyId.
     *  @return java.lang.String.
     */
    public java.lang.String getPartyId() {
        return this.partyId;
    }

    /**
     *  ���� partyId.
     *  @param partyId partyId��.
     */
    public void setPartyId(java.lang.String partyId) {
        this.partyId = partyId;
    }
    /**
     *  ��ȡ personSex.
     *  @return java.lang.String.
     */
    public java.lang.String getPersonSex() {
        return this.personSex;
    }

    /**
     *  ���� personSex.
     *  @param personSex personSex��.
     */
    public void setPersonSex(java.lang.String personSex) {
        this.personSex = personSex;
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
     *  ��ȡ phone.
     *  @return java.lang.String.
     */
    public java.lang.String getPhone() {
        return this.phone;
    }

    /**
     *  ���� phone.
     *  @param phone phone��.
     */
    public void setPhone(java.lang.String phone) {
        this.phone = phone;
    }
    /**
     *  ��ȡ adminFlag.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getAdminFlag() {
        return this.adminFlag;
    }

    /**
     *  ���� adminFlag.
     *  @param adminFlag adminFlag��.
     */
    public void setAdminFlag(java.lang.Boolean adminFlag) {
        this.adminFlag = adminFlag;
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
     *  ��ȡ deskey.
     *  @return java.lang.String.
     */
    public java.lang.String getDeskey() {
        return this.deskey;
    }

    /**
     *  ���� deskey.
     *  @param deskey deskey��.
     */
    public void setDeskey(java.lang.String deskey) {
        this.deskey = deskey;
    }
    /**
     *  ��ȡ sendCa.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getSendCa() {
        return this.sendCa;
    }

    /**
     *  ���� sendCa.
     *  @param sendCa sendCa��.
     */
    public void setSendCa(java.lang.Boolean sendCa) {
        this.sendCa = sendCa;
    }
    /**
     *  ��ȡ enableCa.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getEnableCa() {
        return this.enableCa;
    }

    /**
     *  ���� enableCa.
     *  @param enableCa enableCa��.
     */
    public void setEnableCa(java.lang.Boolean enableCa) {
        this.enableCa = enableCa;
    }
    /**
     *  ��ȡ googleId.
     *  @return java.lang.String.
     */
    public java.lang.String getGoogleId() {
        return this.googleId;
    }

    /**
     *  ���� googleId.
     *  @param googleId googleId��.
     */
    public void setGoogleId(java.lang.String googleId) {
        this.googleId = googleId;
    }
    /**
     *  ��ȡ googlePassword.
     *  @return java.lang.String.
     */
    public java.lang.String getGooglePassword() {
        return this.googlePassword;
    }

    /**
     *  ���� googlePassword.
     *  @param googlePassword googlePassword��.
     */
    public void setGooglePassword(java.lang.String googlePassword) {
        this.googlePassword = googlePassword;
    }

    /**
     *  ��ȡ sysUserRoleGroup.
     *  @return Set.
     */
    public Set getSysUserRoleGroup() {
        return this.sysUserRoleGroup;
    }

    /**
     *  ���� sysUserRoleGroup.
     *  @param sysUserRoleGroup sysUserRoleGroup��.
     */
    public void setSysUserRoleGroup(Set sysUserRoleGroup) {
        this.sysUserRoleGroup = sysUserRoleGroup;
    }

    /**
     *  ��ȡ orgIdOfSysOrg.
     *  @return SysOrg.
     */
    public SysOrg getOrgIdOfSysOrg() {
        return this.orgIdOfSysOrg;
    }

    /**
     *  ���� orgIdOfSysOrg.
     *  @param orgIdOfSysOrg orgIdOfSysOrg��.
     */
    public void setOrgIdOfSysOrg(SysOrg orgIdOfSysOrg) {
        this.orgIdOfSysOrg = orgIdOfSysOrg;
    }

    /**
     *  ��ȡ partyIdOfSysParty.
     *  @return SysParty.
     */
    public SysParty getPartyIdOfSysParty() {
        return this.partyIdOfSysParty;
    }

    /**
     *  ���� partyIdOfSysParty.
     *  @param partyIdOfSysParty partyIdOfSysParty��.
     */
    public void setPartyIdOfSysParty(SysParty partyIdOfSysParty) {
        this.partyIdOfSysParty = partyIdOfSysParty;
    }



    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SysUser.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysUser"));
        org.apache.axis.description.ElementDesc elemField = null;        


        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("password");
        elemField.setXmlName(new javax.xml.namespace.QName("", "password"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orgId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "orgId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partyId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "partyId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("personSex");
        elemField.setXmlName(new javax.xml.namespace.QName("", "personSex"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("", "email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("phone");
        elemField.setXmlName(new javax.xml.namespace.QName("", "phone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adminFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "adminFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("remark");
        elemField.setXmlName(new javax.xml.namespace.QName("", "remark"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deskey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deskey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sendCa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sendCa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("enableCa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "enableCa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("googleId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "googleId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("googlePassword");
        elemField.setXmlName(new javax.xml.namespace.QName("", "googlePassword"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);

        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sysUserRoleGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sysUserRoleGroup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);

        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orgIdOfSysOrg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "orgIdOfSysOrg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysOrg"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partyIdOfSysParty");
        elemField.setXmlName(new javax.xml.namespace.QName("", "partyIdOfSysParty"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysParty"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);

    }

    /**
     * Return type metadata object.
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * @param mechType mechType
     * @param _javaType _javaType
     * @param _xmlType _xmlType
     * Get Custom Serializer.
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType,
           java.lang.Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * @param mechType mechType
     * @param _javaType _javaType
     * @param _xmlType _xmlType
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType,
           java.lang.Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }
}