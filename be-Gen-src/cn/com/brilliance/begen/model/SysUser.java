package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;

    /**
     *  定义类SysUser.
     */

public class SysUser implements Serializable {
    /**
     *  字段域id.
     */
    private java.lang.String id;

    /**
     *  字段域userId.
     */
    private java.lang.String userId;

    /**
     *  字段域userName.
     */
    private java.lang.String userName;

    /**
     *  字段域password.
     */
    private java.lang.String password;

    /**
     *  字段域orgId.
     */
    private java.lang.String orgId;

    /**
     *  字段域partyId.
     */
    private java.lang.String partyId;

/*
0,先生
1,女士
2,小姐
*/
    /**
     *  字段域personSex.
     */
    private java.lang.String personSex;

    /**
     *  字段域email.
     */
    private java.lang.String email;

    /**
     *  字段域phone.
     */
    private java.lang.String phone;

    /**
     *  字段域adminFlag.
     */
    private java.lang.Boolean adminFlag;

    /**
     *  字段域remark.
     */
    private java.lang.String remark;

    /**
     *  字段域deskey.
     */
    private java.lang.String deskey;

    /**
     *  字段域sendCa.
     */
    private java.lang.Boolean sendCa;

    /**
     *  字段域enableCa.
     */
    private java.lang.Boolean enableCa;

    /**
     *  字段域googleId.
     */
    private java.lang.String googleId;

    /**
     *  字段域googlePassword.
     */
    private java.lang.String googlePassword;

    /**
     *  集合域sysUserRoleGroup.
     */
    private Set sysUserRoleGroup;


    /**
     *  域orgIdOfSysOrg.
     */
    private SysOrg orgIdOfSysOrg;
    /**
     *  域partyIdOfSysParty.
     */
    private SysParty partyIdOfSysParty;


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
     *  获取 userId.
     *  @return java.lang.String.
     */
    public java.lang.String getUserId() {
        return this.userId;
    }

    /**
     *  设置 userId.
     *  @param userId userId域.
     */
    public void setUserId(java.lang.String userId) {
        this.userId = userId;
    }
    /**
     *  获取 userName.
     *  @return java.lang.String.
     */
    public java.lang.String getUserName() {
        return this.userName;
    }

    /**
     *  设置 userName.
     *  @param userName userName域.
     */
    public void setUserName(java.lang.String userName) {
        this.userName = userName;
    }
    /**
     *  获取 password.
     *  @return java.lang.String.
     */
    public java.lang.String getPassword() {
        return this.password;
    }

    /**
     *  设置 password.
     *  @param password password域.
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }
    /**
     *  获取 orgId.
     *  @return java.lang.String.
     */
    public java.lang.String getOrgId() {
        return this.orgId;
    }

    /**
     *  设置 orgId.
     *  @param orgId orgId域.
     */
    public void setOrgId(java.lang.String orgId) {
        this.orgId = orgId;
    }
    /**
     *  获取 partyId.
     *  @return java.lang.String.
     */
    public java.lang.String getPartyId() {
        return this.partyId;
    }

    /**
     *  设置 partyId.
     *  @param partyId partyId域.
     */
    public void setPartyId(java.lang.String partyId) {
        this.partyId = partyId;
    }
    /**
     *  获取 personSex.
     *  @return java.lang.String.
     */
    public java.lang.String getPersonSex() {
        return this.personSex;
    }

    /**
     *  设置 personSex.
     *  @param personSex personSex域.
     */
    public void setPersonSex(java.lang.String personSex) {
        this.personSex = personSex;
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
     *  获取 phone.
     *  @return java.lang.String.
     */
    public java.lang.String getPhone() {
        return this.phone;
    }

    /**
     *  设置 phone.
     *  @param phone phone域.
     */
    public void setPhone(java.lang.String phone) {
        this.phone = phone;
    }
    /**
     *  获取 adminFlag.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getAdminFlag() {
        return this.adminFlag;
    }

    /**
     *  设置 adminFlag.
     *  @param adminFlag adminFlag域.
     */
    public void setAdminFlag(java.lang.Boolean adminFlag) {
        this.adminFlag = adminFlag;
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
     *  获取 deskey.
     *  @return java.lang.String.
     */
    public java.lang.String getDeskey() {
        return this.deskey;
    }

    /**
     *  设置 deskey.
     *  @param deskey deskey域.
     */
    public void setDeskey(java.lang.String deskey) {
        this.deskey = deskey;
    }
    /**
     *  获取 sendCa.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getSendCa() {
        return this.sendCa;
    }

    /**
     *  设置 sendCa.
     *  @param sendCa sendCa域.
     */
    public void setSendCa(java.lang.Boolean sendCa) {
        this.sendCa = sendCa;
    }
    /**
     *  获取 enableCa.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getEnableCa() {
        return this.enableCa;
    }

    /**
     *  设置 enableCa.
     *  @param enableCa enableCa域.
     */
    public void setEnableCa(java.lang.Boolean enableCa) {
        this.enableCa = enableCa;
    }
    /**
     *  获取 googleId.
     *  @return java.lang.String.
     */
    public java.lang.String getGoogleId() {
        return this.googleId;
    }

    /**
     *  设置 googleId.
     *  @param googleId googleId域.
     */
    public void setGoogleId(java.lang.String googleId) {
        this.googleId = googleId;
    }
    /**
     *  获取 googlePassword.
     *  @return java.lang.String.
     */
    public java.lang.String getGooglePassword() {
        return this.googlePassword;
    }

    /**
     *  设置 googlePassword.
     *  @param googlePassword googlePassword域.
     */
    public void setGooglePassword(java.lang.String googlePassword) {
        this.googlePassword = googlePassword;
    }

    /**
     *  获取 sysUserRoleGroup.
     *  @return Set.
     */
    public Set getSysUserRoleGroup() {
        return this.sysUserRoleGroup;
    }

    /**
     *  设置 sysUserRoleGroup.
     *  @param sysUserRoleGroup sysUserRoleGroup域.
     */
    public void setSysUserRoleGroup(Set sysUserRoleGroup) {
        this.sysUserRoleGroup = sysUserRoleGroup;
    }

    /**
     *  获取 orgIdOfSysOrg.
     *  @return SysOrg.
     */
    public SysOrg getOrgIdOfSysOrg() {
        return this.orgIdOfSysOrg;
    }

    /**
     *  设置 orgIdOfSysOrg.
     *  @param orgIdOfSysOrg orgIdOfSysOrg域.
     */
    public void setOrgIdOfSysOrg(SysOrg orgIdOfSysOrg) {
        this.orgIdOfSysOrg = orgIdOfSysOrg;
    }

    /**
     *  获取 partyIdOfSysParty.
     *  @return SysParty.
     */
    public SysParty getPartyIdOfSysParty() {
        return this.partyIdOfSysParty;
    }

    /**
     *  设置 partyIdOfSysParty.
     *  @param partyIdOfSysParty partyIdOfSysParty域.
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