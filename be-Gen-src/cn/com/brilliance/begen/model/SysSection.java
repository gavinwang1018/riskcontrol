package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
    /**
     *  ������SysSection.
     */
public class SysSection implements Serializable {
    /**
     *  ����sysRecordOrder.
     */
    private java.lang.Integer sysRecordOrder;
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���formLayout.
     */
    private java.lang.String formLayout;

    /**
     *  �ֶ���name.
     */
    private java.lang.String name;

    /**
     *  �ֶ���partyId.
     */
    private java.lang.String partyId;

    /**
     *  �ֶ���sectionText.
     */
    private java.lang.String sectionText;

    /**
     *  �ֶ���detailHeading.
     */
    private java.lang.String detailHeading;

    /**
     *  �ֶ���sectionType.
     */
    private java.lang.String sectionType;

    /**
     *  �ֶ���editHeading.
     */
    private java.lang.String editHeading;

    /**
     *  �ֶ���numColumns.
     */
    private java.lang.Integer numColumns;

    /**
     *  �ֶ���maxRow.
     */
    private java.lang.Integer maxRow;

    /**
     *  ������sysItemGroup.
     */
    private Set sysItemGroup;


    /**
     *  ��formLayoutOfSysFormLayout.
     */
    private SysFormLayout formLayoutOfSysFormLayout;
    /**
     *  ��partyIdOfSysParty.
     */
    private SysParty partyIdOfSysParty;

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
     *  ��ȡ formLayout.
     *  @return java.lang.String.
     */
    public java.lang.String getFormLayout() {
        return this.formLayout;
    }

    /**
     *  ���� formLayout.
     *  @param formLayout formLayout��.
     */
    public void setFormLayout(java.lang.String formLayout) {
        this.formLayout = formLayout;
    }
    /**
     *  ��ȡ name.
     *  @return java.lang.String.
     */
    public java.lang.String getName() {
        return this.name;
    }

    /**
     *  ���� name.
     *  @param name name��.
     */
    public void setName(java.lang.String name) {
        this.name = name;
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
     *  ��ȡ sectionText.
     *  @return java.lang.String.
     */
    public java.lang.String getSectionText() {
        return this.sectionText;
    }

    /**
     *  ���� sectionText.
     *  @param sectionText sectionText��.
     */
    public void setSectionText(java.lang.String sectionText) {
        this.sectionText = sectionText;
    }
    /**
     *  ��ȡ detailHeading.
     *  @return java.lang.String.
     */
    public java.lang.String getDetailHeading() {
        return this.detailHeading;
    }

    /**
     *  ���� detailHeading.
     *  @param detailHeading detailHeading��.
     */
    public void setDetailHeading(java.lang.String detailHeading) {
        this.detailHeading = detailHeading;
    }
    /**
     *  ��ȡ sectionType.
     *  @return java.lang.String.
     */
    public java.lang.String getSectionType() {
        return this.sectionType;
    }

    /**
     *  ���� sectionType.
     *  @param sectionType sectionType��.
     */
    public void setSectionType(java.lang.String sectionType) {
        this.sectionType = sectionType;
    }
    /**
     *  ��ȡ editHeading.
     *  @return java.lang.String.
     */
    public java.lang.String getEditHeading() {
        return this.editHeading;
    }

    /**
     *  ���� editHeading.
     *  @param editHeading editHeading��.
     */
    public void setEditHeading(java.lang.String editHeading) {
        this.editHeading = editHeading;
    }
    /**
     *  ��ȡ numColumns.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getNumColumns() {
        return this.numColumns;
    }

    /**
     *  ���� numColumns.
     *  @param numColumns numColumns��.
     */
    public void setNumColumns(java.lang.Integer numColumns) {
        this.numColumns = numColumns;
    }
    /**
     *  ��ȡ maxRow.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getMaxRow() {
        return this.maxRow;
    }

    /**
     *  ���� maxRow.
     *  @param maxRow maxRow��.
     */
    public void setMaxRow(java.lang.Integer maxRow) {
        this.maxRow = maxRow;
    }

    /**
     *  ��ȡ sysItemGroup.
     *  @return Set.
     */
    public Set getSysItemGroup() {
        return this.sysItemGroup;
    }

    /**
     *  ���� sysItemGroup.
     *  @param sysItemGroup sysItemGroup��.
     */
    public void setSysItemGroup(Set sysItemGroup) {
        this.sysItemGroup = sysItemGroup;
    }

    /**
     *  ��ȡ formLayoutOfSysFormLayout.
     *  @return SysFormLayout.
     */
    public SysFormLayout getFormLayoutOfSysFormLayout() {
        return this.formLayoutOfSysFormLayout;
    }

    /**
     *  ���� formLayoutOfSysFormLayout.
     *  @param formLayoutOfSysFormLayout formLayoutOfSysFormLayout��.
     */
    public void setFormLayoutOfSysFormLayout(SysFormLayout formLayoutOfSysFormLayout) {
        this.formLayoutOfSysFormLayout = formLayoutOfSysFormLayout;
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
