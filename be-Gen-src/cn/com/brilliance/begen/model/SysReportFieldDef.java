package cn.com.brilliance.begen.model;

import java.io.Serializable;


    /**
     *  ������SysReportFieldDef.
     */
public class SysReportFieldDef implements Serializable {
    /**
     *  ����sysRecordOrder.
     */
    private java.lang.Integer sysRecordOrder;
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

/*
0,��
1,���
2,ƽ����
3,ͳ��
*/
    /**
     *  �ֶ���statisticExpression.
     */
    private java.lang.String statisticExpression;

    /**
     *  �ֶ���partyId.
     */
    private java.lang.String partyId;

    /**
     *  �ֶ���sysReportDef.
     */
    private java.lang.String sysReportDef;

/*
@extSelectItems.sysFieldOfReportField
*/
    /**
     *  �ֶ���reportField.
     */
    private java.lang.String reportField;

    /**
     *  �ֶ���relationField.
     */
    private java.lang.String relationField;


    /**
     *  ��partyIdOfSysParty.
     */
    private SysParty partyIdOfSysParty;
    /**
     *  ��sysReportDefOfSysReportDef.
     */
    private SysReportDef sysReportDefOfSysReportDef;
    /**
     *  ��relationFieldOfSysField.
     */
    private SysField relationFieldOfSysField;

    /**
     *  ��ȡ sysRecordOrder.
     *  @return Integer.
     */
    public java.lang.Integer getSysRecordOrder() {
        return this.sysRecordOrder;
    }

    /**
     *  ���� sysRecordOrder.
     *  @param sysRecordOrder sysRecordOrder.
     */
    public void setSysRecordOrder(java.lang.Integer sysRecordOrder) {
        this.sysRecordOrder = sysRecordOrder;
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
     *  ��ȡ statisticExpression.
     *  @return java.lang.String.
     */
    public java.lang.String getStatisticExpression() {
        return this.statisticExpression;
    }

    /**
     *  ���� statisticExpression.
     *  @param statisticExpression statisticExpression��.
     */
    public void setStatisticExpression(java.lang.String statisticExpression) {
        this.statisticExpression = statisticExpression;
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
     *  ��ȡ sysReportDef.
     *  @return java.lang.String.
     */
    public java.lang.String getSysReportDef() {
        return this.sysReportDef;
    }

    /**
     *  ���� sysReportDef.
     *  @param sysReportDef sysReportDef��.
     */
    public void setSysReportDef(java.lang.String sysReportDef) {
        this.sysReportDef = sysReportDef;
    }
    /**
     *  ��ȡ reportField.
     *  @return java.lang.String.
     */
    public java.lang.String getReportField() {
        return this.reportField;
    }

    /**
     *  ���� reportField.
     *  @param reportField reportField��.
     */
    public void setReportField(java.lang.String reportField) {
        this.reportField = reportField;
    }
    /**
     *  ��ȡ relationField.
     *  @return java.lang.String.
     */
    public java.lang.String getRelationField() {
        return this.relationField;
    }

    /**
     *  ���� relationField.
     *  @param relationField relationField��.
     */
    public void setRelationField(java.lang.String relationField) {
        this.relationField = relationField;
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

    /**
     *  ��ȡ sysReportDefOfSysReportDef.
     *  @return SysReportDef.
     */
    public SysReportDef getSysReportDefOfSysReportDef() {
        return this.sysReportDefOfSysReportDef;
    }

    /**
     *  ���� sysReportDefOfSysReportDef.
     *  @param sysReportDefOfSysReportDef sysReportDefOfSysReportDef��.
     */
    public void setSysReportDefOfSysReportDef(SysReportDef sysReportDefOfSysReportDef) {
        this.sysReportDefOfSysReportDef = sysReportDefOfSysReportDef;
    }

    /**
     *  ��ȡ relationFieldOfSysField.
     *  @return SysField.
     */
    public SysField getRelationFieldOfSysField() {
        return this.relationFieldOfSysField;
    }

    /**
     *  ���� relationFieldOfSysField.
     *  @param relationFieldOfSysField relationFieldOfSysField��.
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
