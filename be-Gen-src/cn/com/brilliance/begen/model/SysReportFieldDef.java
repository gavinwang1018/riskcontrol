package cn.com.brilliance.begen.model;

import java.io.Serializable;


    /**
     *  定义类SysReportFieldDef.
     */
public class SysReportFieldDef implements Serializable {
    /**
     *  定义sysRecordOrder.
     */
    private java.lang.Integer sysRecordOrder;
    /**
     *  字段域id.
     */
    private java.lang.String id;

/*
0,无
1,求和
2,平均数
3,统计
*/
    /**
     *  字段域statisticExpression.
     */
    private java.lang.String statisticExpression;

    /**
     *  字段域partyId.
     */
    private java.lang.String partyId;

    /**
     *  字段域sysReportDef.
     */
    private java.lang.String sysReportDef;

/*
@extSelectItems.sysFieldOfReportField
*/
    /**
     *  字段域reportField.
     */
    private java.lang.String reportField;

    /**
     *  字段域relationField.
     */
    private java.lang.String relationField;


    /**
     *  域partyIdOfSysParty.
     */
    private SysParty partyIdOfSysParty;
    /**
     *  域sysReportDefOfSysReportDef.
     */
    private SysReportDef sysReportDefOfSysReportDef;
    /**
     *  域relationFieldOfSysField.
     */
    private SysField relationFieldOfSysField;

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
     *  获取 statisticExpression.
     *  @return java.lang.String.
     */
    public java.lang.String getStatisticExpression() {
        return this.statisticExpression;
    }

    /**
     *  设置 statisticExpression.
     *  @param statisticExpression statisticExpression域.
     */
    public void setStatisticExpression(java.lang.String statisticExpression) {
        this.statisticExpression = statisticExpression;
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
     *  获取 relationField.
     *  @return java.lang.String.
     */
    public java.lang.String getRelationField() {
        return this.relationField;
    }

    /**
     *  设置 relationField.
     *  @param relationField relationField域.
     */
    public void setRelationField(java.lang.String relationField) {
        this.relationField = relationField;
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

    /**
     *  获取 relationFieldOfSysField.
     *  @return SysField.
     */
    public SysField getRelationFieldOfSysField() {
        return this.relationFieldOfSysField;
    }

    /**
     *  设置 relationFieldOfSysField.
     *  @param relationFieldOfSysField relationFieldOfSysField域.
     */
    public void setRelationFieldOfSysField(SysField relationFieldOfSysField) {
        this.relationFieldOfSysField = relationFieldOfSysField;
    }



    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SysReportFieldDef.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysReportFieldDef"));
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
        elemField.setFieldName("statisticExpression");
        elemField.setXmlName(new javax.xml.namespace.QName("", "statisticExpression"));
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
        elemField.setFieldName("relationField");
        elemField.setXmlName(new javax.xml.namespace.QName("", "relationField"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("relationFieldOfSysField");
        elemField.setXmlName(new javax.xml.namespace.QName("", "relationFieldOfSysField"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysField"));
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
