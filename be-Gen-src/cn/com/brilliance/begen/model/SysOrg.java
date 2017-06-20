package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
    /**
     *  ������SysOrg.
     */
public class SysOrg implements Serializable {
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���orgId.
     */
    private java.lang.String orgId;

    /**
     *  �ֶ���orgName.
     */
    private java.lang.String orgName;

/*
@extSelectItems.sysOrgList
*/
    /**
     *  �ֶ���parentOrg.
     */
    private java.lang.String parentOrg;

/*
@extSelectItems.sysOrgList
*/
    /**
     *  �ֶ���masterOrg.
     */
    private java.lang.String masterOrg;

    /**
     *  �ֶ���partyId.
     */
    private java.lang.String partyId;

    /**
     *  ������sysUserGroup.
     */
    private Set sysUserGroup;


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
     *  ��ȡ orgName.
     *  @return java.lang.String.
     */
    public java.lang.String getOrgName() {
        return this.orgName;
    }

    /**
     *  ���� orgName.
     *  @param orgName orgName��.
     */
    public void setOrgName(java.lang.String orgName) {
        this.orgName = orgName;
    }
    /**
     *  ��ȡ parentOrg.
     *  @return java.lang.String.
     */
    public java.lang.String getParentOrg() {
        return this.parentOrg;
    }

    /**
     *  ���� parentOrg.
     *  @param parentOrg parentOrg��.
     */
    public void setParentOrg(java.lang.String parentOrg) {
        this.parentOrg = parentOrg;
    }
    /**
     *  ��ȡ masterOrg.
     *  @return java.lang.String.
     */
    public java.lang.String getMasterOrg() {
        return this.masterOrg;
    }

    /**
     *  ���� masterOrg.
     *  @param masterOrg masterOrg��.
     */
    public void setMasterOrg(java.lang.String masterOrg) {
        this.masterOrg = masterOrg;
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
     *  ��ȡ sysUserGroup.
     *  @return Set.
     */
    public Set getSysUserGroup() {
        return this.sysUserGroup;
    }

    /**
     *  ���� sysUserGroup.
     *  @param sysUserGroup sysUserGroup��.
     */
    public void setSysUserGroup(Set sysUserGroup) {
        this.sysUserGroup = sysUserGroup;
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
        new org.apache.axis.description.TypeDesc(SysOrg.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysOrg"));
        org.apache.axis.description.ElementDesc elemField = null;        


        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
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
        elemField.setFieldName("orgName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "orgName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parentOrg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "parentOrg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("masterOrg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "masterOrg"));
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
        elemField.setFieldName("sysUserGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sysUserGroup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
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
