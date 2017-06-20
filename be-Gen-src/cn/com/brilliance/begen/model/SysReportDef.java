package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;

    /**
     *  定义类SysReportDef.
     */
public class SysReportDef implements Serializable {
    /**
     *  字段域id.
     */
    private java.lang.String id;

    /**
     *  字段域reportName.
     */
    private java.lang.String reportName;

    /**
     *  字段域dataObject.
     */
    private java.lang.String dataObject;

    /**
     *  字段域reportTitle.
     */
    private java.lang.String reportTitle;

/*
1,有表无图
2,有表有图
3,无表有图
*/
    /**
     *  字段域reportType.
     */
    private java.lang.String reportType;

    /**
     *  字段域chartTitle.
     */
    private java.lang.String chartTitle;

/*
@extSelectItems.reportGroupItems
*/
    /**
     *  字段域chartSeries.
     */
    private java.lang.String chartSeries;

/*
@extSelectItems.reportGroupItems
*/
    /**
     *  字段域category.
     */
    private java.lang.String category;

    /**
     *  字段域partyId.
     */
    private java.lang.String partyId;

/*
1,HTML
2,PDF
3,EXCEL
*/
    /**
     *  字段域exportFormat.
     */
    private java.lang.String exportFormat;

/*
1,无
2,饼图
3,柱状图
4,线性图
*/
    /**
     *  字段域chartType.
     */
    private java.lang.String chartType;

/*
@extSelectItems.reportFieldItems
*/
    /**
     *  字段域dataValue.
     */
    private java.lang.String dataValue;

    /**
     *  集合域sysReportQueryDefGroup.
     */
    private Set sysReportQueryDefGroup;

    /**
     *  集合域sysReportGroupDefGroup.
     */
    private Set sysReportGroupDefGroup;

    /**
     *  集合域sysReportFieldDefGroup.
     */
    private Set sysReportFieldDefGroup;


    /**
     *  域dataObjectOfSysDataObject.
     */
    private SysDataObject dataObjectOfSysDataObject;
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
     *  获取 reportName.
     *  @return java.lang.String.
     */
    public java.lang.String getReportName() {
        return this.reportName;
    }

    /**
     *  设置 reportName.
     *  @param reportName reportName域.
     */
    public void setReportName(java.lang.String reportName) {
        this.reportName = reportName;
    }
    /**
     *  获取 dataObject.
     *  @return java.lang.String.
     */
    public java.lang.String getDataObject() {
        return this.dataObject;
    }

    /**
     *  设置 dataObject.
     *  @param dataObject dataObject域.
     */
    public void setDataObject(java.lang.String dataObject) {
        this.dataObject = dataObject;
    }
    /**
     *  获取 reportTitle.
     *  @return java.lang.String.
     */
    public java.lang.String getReportTitle() {
        return this.reportTitle;
    }

    /**
     *  设置 reportTitle.
     *  @param reportTitle reportTitle域.
     */
    public void setReportTitle(java.lang.String reportTitle) {
        this.reportTitle = reportTitle;
    }
    /**
     *  获取 reportType.
     *  @return java.lang.String.
     */
    public java.lang.String getReportType() {
        return this.reportType;
    }

    /**
     *  设置 reportType.
     *  @param reportType reportType域.
     */
    public void setReportType(java.lang.String reportType) {
        this.reportType = reportType;
    }
    /**
     *  获取 chartTitle.
     *  @return java.lang.String.
     */
    public java.lang.String getChartTitle() {
        return this.chartTitle;
    }

    /**
     *  设置 chartTitle.
     *  @param chartTitle chartTitle域.
     */
    public void setChartTitle(java.lang.String chartTitle) {
        this.chartTitle = chartTitle;
    }
    /**
     *  获取 chartSeries.
     *  @return java.lang.String.
     */
    public java.lang.String getChartSeries() {
        return this.chartSeries;
    }

    /**
     *  设置 chartSeries.
     *  @param chartSeries chartSeries域.
     */
    public void setChartSeries(java.lang.String chartSeries) {
        this.chartSeries = chartSeries;
    }
    /**
     *  获取 category.
     *  @return java.lang.String.
     */
    public java.lang.String getCategory() {
        return this.category;
    }

    /**
     *  设置 category.
     *  @param category category域.
     */
    public void setCategory(java.lang.String category) {
        this.category = category;
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
     *  获取 exportFormat.
     *  @return java.lang.String.
     */
    public java.lang.String getExportFormat() {
        return this.exportFormat;
    }

    /**
     *  设置 exportFormat.
     *  @param exportFormat exportFormat域.
     */
    public void setExportFormat(java.lang.String exportFormat) {
        this.exportFormat = exportFormat;
    }
    /**
     *  获取 chartType.
     *  @return java.lang.String.
     */
    public java.lang.String getChartType() {
        return this.chartType;
    }

    /**
     *  设置 chartType.
     *  @param chartType chartType域.
     */
    public void setChartType(java.lang.String chartType) {
        this.chartType = chartType;
    }
    /**
     *  获取 dataValue.
     *  @return java.lang.String.
     */
    public java.lang.String getDataValue() {
        return this.dataValue;
    }

    /**
     *  设置 dataValue.
     *  @param dataValue dataValue域.
     */
    public void setDataValue(java.lang.String dataValue) {
        this.dataValue = dataValue;
    }

    /**
     *  获取 sysReportQueryDefGroup.
     *  @return Set.
     */
    public Set getSysReportQueryDefGroup() {
        return this.sysReportQueryDefGroup;
    }

    /**
     *  设置 sysReportQueryDefGroup.
     *  @param sysReportQueryDefGroup sysReportQueryDefGroup域.
     */
    public void setSysReportQueryDefGroup(Set sysReportQueryDefGroup) {
        this.sysReportQueryDefGroup = sysReportQueryDefGroup;
    }
    /**
     *  获取 sysReportGroupDefGroup.
     *  @return Set.
     */
    public Set getSysReportGroupDefGroup() {
        return this.sysReportGroupDefGroup;
    }

    /**
     *  设置 sysReportGroupDefGroup.
     *  @param sysReportGroupDefGroup sysReportGroupDefGroup域.
     */
    public void setSysReportGroupDefGroup(Set sysReportGroupDefGroup) {
        this.sysReportGroupDefGroup = sysReportGroupDefGroup;
    }
    /**
     *  获取 sysReportFieldDefGroup.
     *  @return Set.
     */
    public Set getSysReportFieldDefGroup() {
        return this.sysReportFieldDefGroup;
    }

    /**
     *  设置 sysReportFieldDefGroup.
     *  @param sysReportFieldDefGroup sysReportFieldDefGroup域.
     */
    public void setSysReportFieldDefGroup(Set sysReportFieldDefGroup) {
        this.sysReportFieldDefGroup = sysReportFieldDefGroup;
    }

    /**
     *  获取 dataObjectOfSysDataObject.
     *  @return SysDataObject.
     */
    public SysDataObject getDataObjectOfSysDataObject() {
        return this.dataObjectOfSysDataObject;
    }

    /**
     *  设置 dataObjectOfSysDataObject.
     *  @param dataObjectOfSysDataObject dataObjectOfSysDataObject域.
     */
    public void setDataObjectOfSysDataObject(SysDataObject dataObjectOfSysDataObject) {
        this.dataObjectOfSysDataObject = dataObjectOfSysDataObject;
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
