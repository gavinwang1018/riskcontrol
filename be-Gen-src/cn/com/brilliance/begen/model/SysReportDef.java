package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;

    /**
     *  ������SysReportDef.
     */
public class SysReportDef implements Serializable {
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���reportName.
     */
    private java.lang.String reportName;

    /**
     *  �ֶ���dataObject.
     */
    private java.lang.String dataObject;

    /**
     *  �ֶ���reportTitle.
     */
    private java.lang.String reportTitle;

/*
1,�б���ͼ
2,�б���ͼ
3,�ޱ���ͼ
*/
    /**
     *  �ֶ���reportType.
     */
    private java.lang.String reportType;

    /**
     *  �ֶ���chartTitle.
     */
    private java.lang.String chartTitle;

/*
@extSelectItems.reportGroupItems
*/
    /**
     *  �ֶ���chartSeries.
     */
    private java.lang.String chartSeries;

/*
@extSelectItems.reportGroupItems
*/
    /**
     *  �ֶ���category.
     */
    private java.lang.String category;

    /**
     *  �ֶ���partyId.
     */
    private java.lang.String partyId;

/*
1,HTML
2,PDF
3,EXCEL
*/
    /**
     *  �ֶ���exportFormat.
     */
    private java.lang.String exportFormat;

/*
1,��
2,��ͼ
3,��״ͼ
4,����ͼ
*/
    /**
     *  �ֶ���chartType.
     */
    private java.lang.String chartType;

/*
@extSelectItems.reportFieldItems
*/
    /**
     *  �ֶ���dataValue.
     */
    private java.lang.String dataValue;

    /**
     *  ������sysReportQueryDefGroup.
     */
    private Set sysReportQueryDefGroup;

    /**
     *  ������sysReportGroupDefGroup.
     */
    private Set sysReportGroupDefGroup;

    /**
     *  ������sysReportFieldDefGroup.
     */
    private Set sysReportFieldDefGroup;


    /**
     *  ��dataObjectOfSysDataObject.
     */
    private SysDataObject dataObjectOfSysDataObject;
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
     *  ��ȡ reportName.
     *  @return java.lang.String.
     */
    public java.lang.String getReportName() {
        return this.reportName;
    }

    /**
     *  ���� reportName.
     *  @param reportName reportName��.
     */
    public void setReportName(java.lang.String reportName) {
        this.reportName = reportName;
    }
    /**
     *  ��ȡ dataObject.
     *  @return java.lang.String.
     */
    public java.lang.String getDataObject() {
        return this.dataObject;
    }

    /**
     *  ���� dataObject.
     *  @param dataObject dataObject��.
     */
    public void setDataObject(java.lang.String dataObject) {
        this.dataObject = dataObject;
    }
    /**
     *  ��ȡ reportTitle.
     *  @return java.lang.String.
     */
    public java.lang.String getReportTitle() {
        return this.reportTitle;
    }

    /**
     *  ���� reportTitle.
     *  @param reportTitle reportTitle��.
     */
    public void setReportTitle(java.lang.String reportTitle) {
        this.reportTitle = reportTitle;
    }
    /**
     *  ��ȡ reportType.
     *  @return java.lang.String.
     */
    public java.lang.String getReportType() {
        return this.reportType;
    }

    /**
     *  ���� reportType.
     *  @param reportType reportType��.
     */
    public void setReportType(java.lang.String reportType) {
        this.reportType = reportType;
    }
    /**
     *  ��ȡ chartTitle.
     *  @return java.lang.String.
     */
    public java.lang.String getChartTitle() {
        return this.chartTitle;
    }

    /**
     *  ���� chartTitle.
     *  @param chartTitle chartTitle��.
     */
    public void setChartTitle(java.lang.String chartTitle) {
        this.chartTitle = chartTitle;
    }
    /**
     *  ��ȡ chartSeries.
     *  @return java.lang.String.
     */
    public java.lang.String getChartSeries() {
        return this.chartSeries;
    }

    /**
     *  ���� chartSeries.
     *  @param chartSeries chartSeries��.
     */
    public void setChartSeries(java.lang.String chartSeries) {
        this.chartSeries = chartSeries;
    }
    /**
     *  ��ȡ category.
     *  @return java.lang.String.
     */
    public java.lang.String getCategory() {
        return this.category;
    }

    /**
     *  ���� category.
     *  @param category category��.
     */
    public void setCategory(java.lang.String category) {
        this.category = category;
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
     *  ��ȡ exportFormat.
     *  @return java.lang.String.
     */
    public java.lang.String getExportFormat() {
        return this.exportFormat;
    }

    /**
     *  ���� exportFormat.
     *  @param exportFormat exportFormat��.
     */
    public void setExportFormat(java.lang.String exportFormat) {
        this.exportFormat = exportFormat;
    }
    /**
     *  ��ȡ chartType.
     *  @return java.lang.String.
     */
    public java.lang.String getChartType() {
        return this.chartType;
    }

    /**
     *  ���� chartType.
     *  @param chartType chartType��.
     */
    public void setChartType(java.lang.String chartType) {
        this.chartType = chartType;
    }
    /**
     *  ��ȡ dataValue.
     *  @return java.lang.String.
     */
    public java.lang.String getDataValue() {
        return this.dataValue;
    }

    /**
     *  ���� dataValue.
     *  @param dataValue dataValue��.
     */
    public void setDataValue(java.lang.String dataValue) {
        this.dataValue = dataValue;
    }

    /**
     *  ��ȡ sysReportQueryDefGroup.
     *  @return Set.
     */
    public Set getSysReportQueryDefGroup() {
        return this.sysReportQueryDefGroup;
    }

    /**
     *  ���� sysReportQueryDefGroup.
     *  @param sysReportQueryDefGroup sysReportQueryDefGroup��.
     */
    public void setSysReportQueryDefGroup(Set sysReportQueryDefGroup) {
        this.sysReportQueryDefGroup = sysReportQueryDefGroup;
    }
    /**
     *  ��ȡ sysReportGroupDefGroup.
     *  @return Set.
     */
    public Set getSysReportGroupDefGroup() {
        return this.sysReportGroupDefGroup;
    }

    /**
     *  ���� sysReportGroupDefGroup.
     *  @param sysReportGroupDefGroup sysReportGroupDefGroup��.
     */
    public void setSysReportGroupDefGroup(Set sysReportGroupDefGroup) {
        this.sysReportGroupDefGroup = sysReportGroupDefGroup;
    }
    /**
     *  ��ȡ sysReportFieldDefGroup.
     *  @return Set.
     */
    public Set getSysReportFieldDefGroup() {
        return this.sysReportFieldDefGroup;
    }

    /**
     *  ���� sysReportFieldDefGroup.
     *  @param sysReportFieldDefGroup sysReportFieldDefGroup��.
     */
    public void setSysReportFieldDefGroup(Set sysReportFieldDefGroup) {
        this.sysReportFieldDefGroup = sysReportFieldDefGroup;
    }

    /**
     *  ��ȡ dataObjectOfSysDataObject.
     *  @return SysDataObject.
     */
    public SysDataObject getDataObjectOfSysDataObject() {
        return this.dataObjectOfSysDataObject;
    }

    /**
     *  ���� dataObjectOfSysDataObject.
     *  @param dataObjectOfSysDataObject dataObjectOfSysDataObject��.
     */
    public void setDataObjectOfSysDataObject(SysDataObject dataObjectOfSysDataObject) {
        this.dataObjectOfSysDataObject = dataObjectOfSysDataObject;
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
        new org.apache.axis.description.TypeDesc(SysReportDef.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysReportDef"));
        org.apache.axis.description.ElementDesc elemField = null;        


        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reportName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reportName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataObject");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataObject"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reportTitle");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reportTitle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reportType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reportType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("chartTitle");
        elemField.setXmlName(new javax.xml.namespace.QName("", "chartTitle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("chartSeries");
        elemField.setXmlName(new javax.xml.namespace.QName("", "chartSeries"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("category");
        elemField.setXmlName(new javax.xml.namespace.QName("", "category"));
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
        elemField.setFieldName("exportFormat");
        elemField.setXmlName(new javax.xml.namespace.QName("", "exportFormat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("chartType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "chartType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataValue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);

        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sysReportQueryDefGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sysReportQueryDefGroup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sysReportGroupDefGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sysReportGroupDefGroup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sysReportFieldDefGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sysReportFieldDefGroup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);

        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataObjectOfSysDataObject");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataObjectOfSysDataObject"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysDataObject"));
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
