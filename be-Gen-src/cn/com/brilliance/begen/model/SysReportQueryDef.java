package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
    /**
     *  ������SysReportQueryDef.
     */
public class SysReportQueryDef implements Serializable {
    /**
     *  ����sysRecordOrder.
     */
    private java.lang.Integer sysRecordOrder;
/*
1,��ȷ��ѯ
2,ģ����ѯ
3,��Χ��ѯ
*/
    /**
     *  �ֶ���queryMode.
     */
    private java.lang.String queryMode;

    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���partyId.
     */
    private java.lang.String partyId;

    /**
     *  �ֶ���sysReportDef.
     */
    private java.lang.String sysReportDef;

/*
@extSelectItems.sysFieldOfReportQuery
*/
    /**
     *  �ֶ���reportField.
     */
    private java.lang.String reportField;


    /**
     *  ��partyIdOfSysParty.
     */
    private SysParty partyIdOfSysParty;
    /**
     *  ��sysReportDefOfSysReportDef.
     */
    private SysReportDef sysReportDefOfSysReportDef;

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
     *  ��ȡ queryMode.
     *  @return java.lang.String.
     */
    public java.lang.String getQueryMode() {
        return this.queryMode;
    }

    /**
     *  ���� queryMode.
     *  @param queryMode queryMode��.
     */
    public void setQueryMode(java.lang.String queryMode) {
        this.queryMode = queryMode;
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



    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SysReportQueryDef.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysReportQueryDef"));
        org.apache.axis.description.ElementDesc elemField = null;        

        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sysRecordOrder");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sysRecordOrder"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);

        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("queryMode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "queryMode"));
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
