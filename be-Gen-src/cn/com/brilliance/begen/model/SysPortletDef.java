package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
    /**
     *  定义类SysPortletDef.
     */
public class SysPortletDef implements Serializable {
    /**
     *  定义sysRecordOrder.
     */
    private java.lang.Integer sysRecordOrder;
    /**
     *  字段域label.
     */
    private java.lang.String label;

    /**
     *  字段域url.
     */
    private java.lang.String url;

    /**
     *  字段域partyId.
     */
    private java.lang.String partyId;

    /**
     *  字段域id.
     */
    private java.lang.String id;

    /**
     *  字段域urlDescription.
     */
    private java.lang.String urlDescription;

    /**
     *  字段域portalId.
     */
    private java.lang.String portalId;

/*
1,第一列
2,第二列
3,第三列
*/
    /**
     *  字段域cols.
     */
    private java.lang.String cols;


    /**
     *  域partyIdOfSysParty.
     */
    private SysParty partyIdOfSysParty;
    /**
     *  域portalIdOfSysPortalDef.
     */
    private SysPortalDef portalIdOfSysPortalDef;

    /**
     *  获取 sysRecordOrder.
     *  @return Integer.
     */
    public java.lang.Integer getSysRecordOrder() {
        return this.sysRecordOrder;
    }

    /**
     *  设置 sysRecordOrder.
     *  @param sysRecordOrder sysRecordOrder.
     */
    public void setSysRecordOrder(java.lang.Integer sysRecordOrder) {
        this.sysRecordOrder = sysRecordOrder;
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
     *  获取 url.
     *  @return java.lang.String.
     */
    public java.lang.String getUrl() {
        return this.url;
    }

    /**
     *  设置 url.
     *  @param url url域.
     */
    public void setUrl(java.lang.String url) {
        this.url = url;
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
     *  获取 urlDescription.
     *  @return java.lang.String.
     */
    public java.lang.String getUrlDescription() {
        return this.urlDescription;
    }

    /**
     *  设置 urlDescription.
     *  @param urlDescription urlDescription域.
     */
    public void setUrlDescription(java.lang.String urlDescription) {
        this.urlDescription = urlDescription;
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

    /**
     *  获取 portalIdOfSysPortalDef.
     *  @return SysPortalDef.
     */
    public SysPortalDef getPortalIdOfSysPortalDef() {
        return this.portalIdOfSysPortalDef;
    }

    /**
     *  设置 portalIdOfSysPortalDef.
     *  @param portalIdOfSysPortalDef portalIdOfSysPortalDef域.
     */
    public void setPortalIdOfSysPortalDef(SysPortalDef portalIdOfSysPortalDef) {
        this.portalIdOfSysPortalDef = portalIdOfSysPortalDef;
    }



    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SysPortletDef.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysPortletDef"));
        org.apache.axis.description.ElementDesc elemField = null;        

        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sysRecordOrder");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sysRecordOrder"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);

        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("label");
        elemField.setXmlName(new javax.xml.namespace.QName("", "label"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("url");
        elemField.setXmlName(new javax.xml.namespace.QName("", "url"));
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
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("urlDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("", "urlDescription"));
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
        elemField.setFieldName("cols");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cols"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);


        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partyIdOfSysParty");
        elemField.setXmlName(new javax.xml.namespace.QName("", "partyIdOfSysParty"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysParty"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("portalIdOfSysPortalDef");
        elemField.setXmlName(new javax.xml.namespace.QName("", "portalIdOfSysPortalDef"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysPortalDef"));
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
