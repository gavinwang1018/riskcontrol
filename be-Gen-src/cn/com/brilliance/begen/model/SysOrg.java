package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
    /**
     *  定义类SysOrg.
     */
public class SysOrg implements Serializable {
    /**
     *  字段域id.
     */
    private java.lang.String id;

    /**
     *  字段域orgId.
     */
    private java.lang.String orgId;

    /**
     *  字段域orgName.
     */
    private java.lang.String orgName;

/*
@extSelectItems.sysOrgList
*/
    /**
     *  字段域parentOrg.
     */
    private java.lang.String parentOrg;

/*
@extSelectItems.sysOrgList
*/
    /**
     *  字段域masterOrg.
     */
    private java.lang.String masterOrg;

    /**
     *  字段域partyId.
     */
    private java.lang.String partyId;

    /**
     *  集合域sysUserGroup.
     */
    private Set sysUserGroup;


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
     *  获取 orgName.
     *  @return java.lang.String.
     */
    public java.lang.String getOrgName() {
        return this.orgName;
    }

    /**
     *  设置 orgName.
     *  @param orgName orgName域.
     */
    public void setOrgName(java.lang.String orgName) {
        this.orgName = orgName;
    }
    /**
     *  获取 parentOrg.
     *  @return java.lang.String.
     */
    public java.lang.String getParentOrg() {
        return this.parentOrg;
    }

    /**
     *  设置 parentOrg.
     *  @param parentOrg parentOrg域.
     */
    public void setParentOrg(java.lang.String parentOrg) {
        this.parentOrg = parentOrg;
    }
    /**
     *  获取 masterOrg.
     *  @return java.lang.String.
     */
    public java.lang.String getMasterOrg() {
        return this.masterOrg;
    }

    /**
     *  设置 masterOrg.
     *  @param masterOrg masterOrg域.
     */
    public void setMasterOrg(java.lang.String masterOrg) {
        this.masterOrg = masterOrg;
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
     *  获取 sysUserGroup.
     *  @return Set.
     */
    public Set getSysUserGroup() {
        return this.sysUserGroup;
    }

    /**
     *  设置 sysUserGroup.
     *  @param sysUserGroup sysUserGroup域.
     */
    public void setSysUserGroup(Set sysUserGroup) {
        this.sysUserGroup = sysUserGroup;
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
