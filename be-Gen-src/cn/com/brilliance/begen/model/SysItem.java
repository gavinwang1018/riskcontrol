package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;

    /**
     *  定义类SysItem.
     */
public class SysItem implements Serializable {
    /**
     *  字段域id.
     */
    private java.lang.String id;

    /**
     *  字段域section.
     */
    private java.lang.String section;

    /**
     *  字段域label.
     */
    private java.lang.String label;

    /**
     *  字段域readonly.
     */
    private java.lang.Boolean readonly;

    /**
     *  字段域required.
     */
    private java.lang.Boolean required;

    /**
     *  字段域seq.
     */
    private java.lang.Integer seq;

    /**
     *  字段域col.
     */
    private java.lang.Integer col;

    /**
     *  字段域colspan.
     */
    private java.lang.Integer colspan;

    /**
     *  字段域partyId.
     */
    private java.lang.String partyId;

    /**
     *  字段域sysField.
     */
    private java.lang.String sysField;

    /**
     *  字段域relationField.
     */
    private java.lang.String relationField;

    /**
     *  字段域filterField.
     */
    private java.lang.String filterField;

/*
0,=
1,>
2,<
3,like
*/
    /**
     *  字段域filterMethod.
     */
    private java.lang.String filterMethod;

    /**
     *  字段域fieldRelationField.
     */
    private java.lang.String fieldRelationField;


    /**
     *  域sectionOfSysSection.
     */
    private SysSection sectionOfSysSection;
    /**
     *  域partyIdOfSysParty.
     */
    private SysParty partyIdOfSysParty;
    /**
     *  域sysFieldOfSysField.
     */
    private SysField sysFieldOfSysField;
    /**
     *  域relationFieldOfSysField.
     */
    private SysField relationFieldOfSysField;
    /**
     *  域filterFieldOfSysField.
     */
    private SysField filterFieldOfSysField;
    /**
     *  域fieldRelationFieldOfSysField.
     */
    private SysField fieldRelationFieldOfSysField;


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
     *  获取 section.
     *  @return java.lang.String.
     */
    public java.lang.String getSection() {
        return this.section;
    }

    /**
     *  设置 section.
     *  @param section section域.
     */
    public void setSection(java.lang.String section) {
        this.section = section;
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
     *  获取 readonly.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getReadonly() {
        return this.readonly;
    }

    /**
     *  设置 readonly.
     *  @param readonly readonly域.
     */
    public void setReadonly(java.lang.Boolean readonly) {
        this.readonly = readonly;
    }
    /**
     *  获取 required.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getRequired() {
        return this.required;
    }

    /**
     *  设置 required.
     *  @param required required域.
     */
    public void setRequired(java.lang.Boolean required) {
        this.required = required;
    }
    /**
     *  获取 seq.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getSeq() {
        return this.seq;
    }

    /**
     *  设置 seq.
     *  @param seq seq域.
     */
    public void setSeq(java.lang.Integer seq) {
        this.seq = seq;
    }
    /**
     *  获取 col.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getCol() {
        return this.col;
    }

    /**
     *  设置 col.
     *  @param col col域.
     */
    public void setCol(java.lang.Integer col) {
        this.col = col;
    }
    /**
     *  获取 colspan.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getColspan() {
        return this.colspan;
    }

    /**
     *  设置 colspan.
     *  @param colspan colspan域.
     */
    public void setColspan(java.lang.Integer colspan) {
        this.colspan = colspan;
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
     *  获取 sysField.
     *  @return java.lang.String.
     */
    public java.lang.String getSysField() {
        return this.sysField;
    }

    /**
     *  设置 sysField.
     *  @param sysField sysField域.
     */
    public void setSysField(java.lang.String sysField) {
        this.sysField = sysField;
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
     *  获取 filterField.
     *  @return java.lang.String.
     */
    public java.lang.String getFilterField() {
        return this.filterField;
    }

    /**
     *  设置 filterField.
     *  @param filterField filterField域.
     */
    public void setFilterField(java.lang.String filterField) {
        this.filterField = filterField;
    }
    /**
     *  获取 filterMethod.
     *  @return java.lang.String.
     */
    public java.lang.String getFilterMethod() {
        return this.filterMethod;
    }

    /**
     *  设置 filterMethod.
     *  @param filterMethod filterMethod域.
     */
    public void setFilterMethod(java.lang.String filterMethod) {
        this.filterMethod = filterMethod;
    }
    /**
     *  获取 fieldRelationField.
     *  @return java.lang.String.
     */
    public java.lang.String getFieldRelationField() {
        return this.fieldRelationField;
    }

    /**
     *  设置 fieldRelationField.
     *  @param fieldRelationField fieldRelationField域.
     */
    public void setFieldRelationField(java.lang.String fieldRelationField) {
        this.fieldRelationField = fieldRelationField;
    }


    /**
     *  获取 sectionOfSysSection.
     *  @return SysSection.
     */
    public SysSection getSectionOfSysSection() {
        return this.sectionOfSysSection;
    }

    /**
     *  设置 sectionOfSysSection.
     *  @param sectionOfSysSection sectionOfSysSection域.
     */
    public void setSectionOfSysSection(SysSection sectionOfSysSection) {
        this.sectionOfSysSection = sectionOfSysSection;
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
     *  获取 sysFieldOfSysField.
     *  @return SysField.
     */
    public SysField getSysFieldOfSysField() {
        return this.sysFieldOfSysField;
    }

    /**
     *  设置 sysFieldOfSysField.
     *  @param sysFieldOfSysField sysFieldOfSysField域.
     */
    public void setSysFieldOfSysField(SysField sysFieldOfSysField) {
        this.sysFieldOfSysField = sysFieldOfSysField;
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

    /**
     *  获取 filterFieldOfSysField.
     *  @return SysField.
     */
    public SysField getFilterFieldOfSysField() {
        return this.filterFieldOfSysField;
    }

    /**
     *  设置 filterFieldOfSysField.
     *  @param filterFieldOfSysField filterFieldOfSysField域.
     */
    public void setFilterFieldOfSysField(SysField filterFieldOfSysField) {
        this.filterFieldOfSysField = filterFieldOfSysField;
    }

    /**
     *  获取 fieldRelationFieldOfSysField.
     *  @return SysField.
     */
    public SysField getFieldRelationFieldOfSysField() {
        return this.fieldRelationFieldOfSysField;
    }

    /**
     *  设置 fieldRelationFieldOfSysField.
     *  @param fieldRelationFieldOfSysField fieldRelationFieldOfSysField域.
     */
    public void setFieldRelationFieldOfSysField(SysField fieldRelationFieldOfSysField) {
        this.fieldRelationFieldOfSysField = fieldRelationFieldOfSysField;
    }



    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SysItem.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysItem"));
        org.apache.axis.description.ElementDesc elemField = null;        


        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("section");
        elemField.setXmlName(new javax.xml.namespace.QName("", "section"));
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
        elemField.setFieldName("readonly");
        elemField.setXmlName(new javax.xml.namespace.QName("", "readonly"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("required");
        elemField.setXmlName(new javax.xml.namespace.QName("", "required"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("seq");
        elemField.setXmlName(new javax.xml.namespace.QName("", "seq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("col");
        elemField.setXmlName(new javax.xml.namespace.QName("", "col"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("colspan");
        elemField.setXmlName(new javax.xml.namespace.QName("", "colspan"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partyId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "partyId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sysField");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sysField"));
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
        elemField.setFieldName("filterField");
        elemField.setXmlName(new javax.xml.namespace.QName("", "filterField"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filterMethod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "filterMethod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fieldRelationField");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fieldRelationField"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);


        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sectionOfSysSection");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sectionOfSysSection"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysSection"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partyIdOfSysParty");
        elemField.setXmlName(new javax.xml.namespace.QName("", "partyIdOfSysParty"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysParty"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sysFieldOfSysField");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sysFieldOfSysField"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysField"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("relationFieldOfSysField");
        elemField.setXmlName(new javax.xml.namespace.QName("", "relationFieldOfSysField"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysField"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filterFieldOfSysField");
        elemField.setXmlName(new javax.xml.namespace.QName("", "filterFieldOfSysField"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysField"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fieldRelationFieldOfSysField");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fieldRelationFieldOfSysField"));
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
