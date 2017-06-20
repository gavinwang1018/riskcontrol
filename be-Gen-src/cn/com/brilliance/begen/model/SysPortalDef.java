package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
    /**
     *  定义类SysPortalDef.
     */
public class SysPortalDef implements Serializable {
    /**
     *  字段域description.
     */
    private java.lang.String description;

/*
1,单列
2,两列
3,三列
*/
    /**
     *  字段域cols.
     */
    private java.lang.String cols;

    /**
     *  字段域label.
     */
    private java.lang.String label;

/*
1,窄
2,中
3,宽
*/
    /**
     *  字段域widthFst.
     */
    private java.lang.String widthFst;

/*
1,窄
2,中
3,宽
*/
    /**
     *  字段域widthSec.
     */
    private java.lang.String widthSec;

/*
1,窄
2,中
3,宽
*/
    /**
     *  字段域widthThd.
     */
    private java.lang.String widthThd;

    /**
     *  字段域id.
     */
    private java.lang.String id;

    /**
     *  字段域partyId.
     */
    private java.lang.String partyId;

    /**
     *  字段域portalId.
     */
    private java.lang.String portalId;

    /**
     *  集合域sysPortletDefGroup.
     */
    private Set sysPortletDefGroup;


    /**
     *  域partyIdOfSysParty.
     */
    private SysParty partyIdOfSysParty;


    /**
     *  获取 description.
     *  @return java.lang.String.
     */
    public java.lang.String getDescription() {
        return this.description;
    }

    /**
     *  设置 description.
     *  @param description description域.
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }
    /**
     *  获取 cols.
     *  @return java.lang.String.
     */
    public java.lang.String getCols() {
        return this.cols;
    }

    /**
     *  设置 cols.
     *  @param cols cols域.
     */
    public void setCols(java.lang.String cols) {
        this.cols = cols;
    }
    /**
     *  获取 label.
     *  @return java.lang.String.
     */
    public java.lang.String getLabel() {
        return this.label;
    }

    /**
     *  设置 label.
     *  @param label label域.
     */
    public void setLabel(java.lang.String label) {
        this.label = label;
    }
    /**
     *  获取 widthFst.
     *  @return java.lang.String.
     */
    public java.lang.String getWidthFst() {
        return this.widthFst;
    }

    /**
     *  设置 widthFst.
     *  @param widthFst widthFst域.
     */
    public void setWidthFst(java.lang.String widthFst) {
        this.widthFst = widthFst;
    }
    /**
     *  获取 widthSec.
     *  @return java.lang.String.
     */
    public java.lang.String getWidthSec() {
        return this.widthSec;
    }

    /**
     *  设置 widthSec.
     *  @param widthSec widthSec域.
     */
    public void setWidthSec(java.lang.String widthSec) {
        this.widthSec = widthSec;
    }
    /**
     *  获取 widthThd.
     *  @return java.lang.String.
     */
    public java.lang.String getWidthThd() {
        return this.widthThd;
    }

    /**
     *  设置 widthThd.
     *  @param widthThd widthThd域.
     */
    public void setWidthThd(java.lang.String widthThd) {
        this.widthThd = widthThd;
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
     *  获取 portalId.
     *  @return java.lang.String.
     */
    public java.lang.String getPortalId() {
        return this.portalId;
    }

    /**
     *  设置 portalId.
     *  @param portalId portalId域.
     */
    public void setPortalId(java.lang.String portalId) {
        this.portalId = portalId;
    }

    /**
     *  获取 sysPortletDefGroup.
     *  @return Set.
     */
    public Set getSysPortletDefGroup() {
        return this.sysPortletDefGroup;
    }

    /**
     *  设置 sysPortletDefGroup.
     *  @param sysPortletDefGroup sysPortletDefGroup域.
     */
    public void setSysPortletDefGroup(Set sysPortletDefGroup) {
        this.sysPortletDefGroup = sysPortletDefGroup;
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
        new org.apache.axis.description.TypeDesc(SysPortalDef.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysPortalDef"));
        org.apache.axis.description.ElementDesc elemField = null;        


        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cols");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cols"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("label");
        elemField.setXmlName(new javax.xml.namespace.QName("", "label"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("widthFst");
        elemField.setXmlName(new javax.xml.namespace.QName("", "widthFst"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("widthSec");
        elemField.setXmlName(new javax.xml.namespace.QName("", "widthSec"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("widthThd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "widthThd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
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
        elemField.setFieldName("portalId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "portalId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);

        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sysPortletDefGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sysPortletDefGroup"));
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
