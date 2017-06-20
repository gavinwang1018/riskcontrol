package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
    /**
     *  定义类SysSection.
     */
public class SysSection implements Serializable {
    /**
     *  定义sysRecordOrder.
     */
    private java.lang.Integer sysRecordOrder;
    /**
     *  字段域id.
     */
    private java.lang.String id;

    /**
     *  字段域formLayout.
     */
    private java.lang.String formLayout;

    /**
     *  字段域name.
     */
    private java.lang.String name;

    /**
     *  字段域partyId.
     */
    private java.lang.String partyId;

    /**
     *  字段域sectionText.
     */
    private java.lang.String sectionText;

    /**
     *  字段域detailHeading.
     */
    private java.lang.String detailHeading;

    /**
     *  字段域sectionType.
     */
    private java.lang.String sectionType;

    /**
     *  字段域editHeading.
     */
    private java.lang.String editHeading;

    /**
     *  字段域numColumns.
     */
    private java.lang.Integer numColumns;

    /**
     *  字段域maxRow.
     */
    private java.lang.Integer maxRow;

    /**
     *  集合域sysItemGroup.
     */
    private Set sysItemGroup;


    /**
     *  域formLayoutOfSysFormLayout.
     */
    private SysFormLayout formLayoutOfSysFormLayout;
    /**
     *  域partyIdOfSysParty.
     */
    private SysParty partyIdOfSysParty;

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
     *  获取 formLayout.
     *  @return java.lang.String.
     */
    public java.lang.String getFormLayout() {
        return this.formLayout;
    }

    /**
     *  设置 formLayout.
     *  @param formLayout formLayout域.
     */
    public void setFormLayout(java.lang.String formLayout) {
        this.formLayout = formLayout;
    }
    /**
     *  获取 name.
     *  @return java.lang.String.
     */
    public java.lang.String getName() {
        return this.name;
    }

    /**
     *  设置 name.
     *  @param name name域.
     */
    public void setName(java.lang.String name) {
        this.name = name;
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
     *  获取 sectionText.
     *  @return java.lang.String.
     */
    public java.lang.String getSectionText() {
        return this.sectionText;
    }

    /**
     *  设置 sectionText.
     *  @param sectionText sectionText域.
     */
    public void setSectionText(java.lang.String sectionText) {
        this.sectionText = sectionText;
    }
    /**
     *  获取 detailHeading.
     *  @return java.lang.String.
     */
    public java.lang.String getDetailHeading() {
        return this.detailHeading;
    }

    /**
     *  设置 detailHeading.
     *  @param detailHeading detailHeading域.
     */
    public void setDetailHeading(java.lang.String detailHeading) {
        this.detailHeading = detailHeading;
    }
    /**
     *  获取 sectionType.
     *  @return java.lang.String.
     */
    public java.lang.String getSectionType() {
        return this.sectionType;
    }

    /**
     *  设置 sectionType.
     *  @param sectionType sectionType域.
     */
    public void setSectionType(java.lang.String sectionType) {
        this.sectionType = sectionType;
    }
    /**
     *  获取 editHeading.
     *  @return java.lang.String.
     */
    public java.lang.String getEditHeading() {
        return this.editHeading;
    }

    /**
     *  设置 editHeading.
     *  @param editHeading editHeading域.
     */
    public void setEditHeading(java.lang.String editHeading) {
        this.editHeading = editHeading;
    }
    /**
     *  获取 numColumns.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getNumColumns() {
        return this.numColumns;
    }

    /**
     *  设置 numColumns.
     *  @param numColumns numColumns域.
     */
    public void setNumColumns(java.lang.Integer numColumns) {
        this.numColumns = numColumns;
    }
    /**
     *  获取 maxRow.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getMaxRow() {
        return this.maxRow;
    }

    /**
     *  设置 maxRow.
     *  @param maxRow maxRow域.
     */
    public void setMaxRow(java.lang.Integer maxRow) {
        this.maxRow = maxRow;
    }

    /**
     *  获取 sysItemGroup.
     *  @return Set.
     */
    public Set getSysItemGroup() {
        return this.sysItemGroup;
    }

    /**
     *  设置 sysItemGroup.
     *  @param sysItemGroup sysItemGroup域.
     */
    public void setSysItemGroup(Set sysItemGroup) {
        this.sysItemGroup = sysItemGroup;
    }

    /**
     *  获取 formLayoutOfSysFormLayout.
     *  @return SysFormLayout.
     */
    public SysFormLayout getFormLayoutOfSysFormLayout() {
        return this.formLayoutOfSysFormLayout;
    }

    /**
     *  设置 formLayoutOfSysFormLayout.
     *  @param formLayoutOfSysFormLayout formLayoutOfSysFormLayout域.
     */
    public void setFormLayoutOfSysFormLayout(SysFormLayout formLayoutOfSysFormLayout) {
        this.formLayoutOfSysFormLayout = formLayoutOfSysFormLayout;
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
        new org.apache.axis.description.TypeDesc(SysSection.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysSection"));
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
        elemField.setFieldName("formLayout");
        elemField.setXmlName(new javax.xml.namespace.QName("", "formLayout"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
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
        elemField.setFieldName("sectionText");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sectionText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("detailHeading");
        elemField.setXmlName(new javax.xml.namespace.QName("", "detailHeading"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sectionType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sectionType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("editHeading");
        elemField.setXmlName(new javax.xml.namespace.QName("", "editHeading"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numColumns");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numColumns"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxRow");
        elemField.setXmlName(new javax.xml.namespace.QName("", "maxRow"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);

        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sysItemGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sysItemGroup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);

        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("formLayoutOfSysFormLayout");
        elemField.setXmlName(new javax.xml.namespace.QName("", "formLayoutOfSysFormLayout"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysFormLayout"));
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
