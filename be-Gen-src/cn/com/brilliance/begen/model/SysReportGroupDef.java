package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
    /**
     *  定义类SysReportGroupDef.
     */
public class SysReportGroupDef implements Serializable {
    /**
     *  定义sysRecordOrder.
     */
    private java.lang.Integer sysRecordOrder;
    /**
     *  字段域id.
     */
    private java.lang.String id;

/*
1,升序
2,降序
*/
    /**
     *  字段域sort.
     */
    private java.lang.String sort;

    /**
     *  字段域label.
     */
    private java.lang.String label;

    /**
     *  字段域partyId.
     */
    private java.lang.String partyId;

    /**
     *  字段域sysReportDef.
     */
    private java.lang.String sysReportDef;

/*
@extSelectItems.sysFieldOfReportGroup
*/
    /**
     *  字段域reportField.
     */
    private java.lang.String reportField;


    /**
     *  域partyIdOfSysParty.
     */
    private SysParty partyIdOfSysParty;
    /**
     *  域sysReportDefOfSysReportDef.
     */
    private SysReportDef sysReportDefOfSysReportDef;

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
     *  获取 sort.
     *  @return java.lang.String.
     */
    public java.lang.String getSort() {
        return this.sort;
    }

    /**
     *  设置 sort.
     *  @param sort sort域.
     */
    public void setSort(java.lang.String sort) {
        this.sort = sort;
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
     *  获取 sysReportDef.
     *  @return java.lang.String.
     */
    public java.lang.String getSysReportDef() {
        return this.sysReportDef;
    }

    /**
     *  设置 sysReportDef.
     *  @param sysReportDef sysReportDef域.
     */
    public void setSysReportDef(java.lang.String sysReportDef) {
        this.sysReportDef = sysReportDef;
    }
    /**
     *  获取 reportField.
     *  @return java.lang.String.
     */
    public java.lang.String getReportField() {
        return this.reportField;
    }

    /**
     *  设置 reportField.
     *  @param reportField reportField域.
     */
    public void setReportField(java.lang.String reportField) {
        this.reportField = reportField;
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
     *  获取 sysReportDefOfSysReportDef.
     *  @return SysReportDef.
     */
    public SysReportDef getSysReportDefOfSysReportDef() {
        return this.sysReportDefOfSysReportDef;
    }

    /**
     *  设置 sysReportDefOfSysReportDef.
     *  @param sysReportDefOfSysReportDef sysReportDefOfSysReportDef域.
     */
    public void setSysReportDefOfSysReportDef(SysReportDef sysReportDefOfSysReportDef) {
        this.sysReportDefOfSysReportDef = sysReportDefOfSysReportDef;
    }



    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SysReportGroupDef.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysReportGroupDef"));
        org.apache.axis.description.ElementDesc elemField = null;        

        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sysRecordOrder");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sysRecordOrder"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);

        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sort");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sort"));
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
        elemField.setFieldName("partyId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "partyId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sysReportDef");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sysReportDef"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reportField");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reportField"));
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
        elemField.setFieldName("sysReportDefOfSysReportDef");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sysReportDefOfSysReportDef"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysReportDef"));
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
