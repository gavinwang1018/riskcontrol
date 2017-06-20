package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;

    /**
     *  ������SysItem.
     */
public class SysItem implements Serializable {
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���section.
     */
    private java.lang.String section;

    /**
     *  �ֶ���label.
     */
    private java.lang.String label;

    /**
     *  �ֶ���readonly.
     */
    private java.lang.Boolean readonly;

    /**
     *  �ֶ���required.
     */
    private java.lang.Boolean required;

    /**
     *  �ֶ���seq.
     */
    private java.lang.Integer seq;

    /**
     *  �ֶ���col.
     */
    private java.lang.Integer col;

    /**
     *  �ֶ���colspan.
     */
    private java.lang.Integer colspan;

    /**
     *  �ֶ���partyId.
     */
    private java.lang.String partyId;

    /**
     *  �ֶ���sysField.
     */
    private java.lang.String sysField;

    /**
     *  �ֶ���relationField.
     */
    private java.lang.String relationField;

    /**
     *  �ֶ���filterField.
     */
    private java.lang.String filterField;

/*
0,=
1,>
2,<
3,like
*/
    /**
     *  �ֶ���filterMethod.
     */
    private java.lang.String filterMethod;

    /**
     *  �ֶ���fieldRelationField.
     */
    private java.lang.String fieldRelationField;


    /**
     *  ��sectionOfSysSection.
     */
    private SysSection sectionOfSysSection;
    /**
     *  ��partyIdOfSysParty.
     */
    private SysParty partyIdOfSysParty;
    /**
     *  ��sysFieldOfSysField.
     */
    private SysField sysFieldOfSysField;
    /**
     *  ��relationFieldOfSysField.
     */
    private SysField relationFieldOfSysField;
    /**
     *  ��filterFieldOfSysField.
     */
    private SysField filterFieldOfSysField;
    /**
     *  ��fieldRelationFieldOfSysField.
     */
    private SysField fieldRelationFieldOfSysField;


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
     *  ��ȡ section.
     *  @return java.lang.String.
     */
    public java.lang.String getSection() {
        return this.section;
    }

    /**
     *  ���� section.
     *  @param section section��.
     */
    public void setSection(java.lang.String section) {
        this.section = section;
    }
    /**
     *  ��ȡ label.
     *  @return java.lang.String.
     */
    public java.lang.String getLabel() {
        return this.label;
    }

    /**
     *  ���� label.
     *  @param label label��.
     */
    public void setLabel(java.lang.String label) {
        this.label = label;
    }
    /**
     *  ��ȡ readonly.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getReadonly() {
        return this.readonly;
    }

    /**
     *  ���� readonly.
     *  @param readonly readonly��.
     */
    public void setReadonly(java.lang.Boolean readonly) {
        this.readonly = readonly;
    }
    /**
     *  ��ȡ required.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getRequired() {
        return this.required;
    }

    /**
     *  ���� required.
     *  @param required required��.
     */
    public void setRequired(java.lang.Boolean required) {
        this.required = required;
    }
    /**
     *  ��ȡ seq.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getSeq() {
        return this.seq;
    }

    /**
     *  ���� seq.
     *  @param seq seq��.
     */
    public void setSeq(java.lang.Integer seq) {
        this.seq = seq;
    }
    /**
     *  ��ȡ col.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getCol() {
        return this.col;
    }

    /**
     *  ���� col.
     *  @param col col��.
     */
    public void setCol(java.lang.Integer col) {
        this.col = col;
    }
    /**
     *  ��ȡ colspan.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getColspan() {
        return this.colspan;
    }

    /**
     *  ���� colspan.
     *  @param colspan colspan��.
     */
    public void setColspan(java.lang.Integer colspan) {
        this.colspan = colspan;
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
     *  ��ȡ sysField.
     *  @return java.lang.String.
     */
    public java.lang.String getSysField() {
        return this.sysField;
    }

    /**
     *  ���� sysField.
     *  @param sysField sysField��.
     */
    public void setSysField(java.lang.String sysField) {
        this.sysField = sysField;
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
     *  ��ȡ filterField.
     *  @return java.lang.String.
     */
    public java.lang.String getFilterField() {
        return this.filterField;
    }

    /**
     *  ���� filterField.
     *  @param filterField filterField��.
     */
    public void setFilterField(java.lang.String filterField) {
        this.filterField = filterField;
    }
    /**
     *  ��ȡ filterMethod.
     *  @return java.lang.String.
     */
    public java.lang.String getFilterMethod() {
        return this.filterMethod;
    }

    /**
     *  ���� filterMethod.
     *  @param filterMethod filterMethod��.
     */
    public void setFilterMethod(java.lang.String filterMethod) {
        this.filterMethod = filterMethod;
    }
    /**
     *  ��ȡ fieldRelationField.
     *  @return java.lang.String.
     */
    public java.lang.String getFieldRelationField() {
        return this.fieldRelationField;
    }

    /**
     *  ���� fieldRelationField.
     *  @param fieldRelationField fieldRelationField��.
     */
    public void setFieldRelationField(java.lang.String fieldRelationField) {
        this.fieldRelationField = fieldRelationField;
    }


    /**
     *  ��ȡ sectionOfSysSection.
     *  @return SysSection.
     */
    public SysSection getSectionOfSysSection() {
        return this.sectionOfSysSection;
    }

    /**
     *  ���� sectionOfSysSection.
     *  @param sectionOfSysSection sectionOfSysSection��.
     */
    public void setSectionOfSysSection(SysSection sectionOfSysSection) {
        this.sectionOfSysSection = sectionOfSysSection;
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
     *  ��ȡ sysFieldOfSysField.
     *  @return SysField.
     */
    public SysField getSysFieldOfSysField() {
        return this.sysFieldOfSysField;
    }

    /**
     *  ���� sysFieldOfSysField.
     *  @param sysFieldOfSysField sysFieldOfSysField��.
     */
    public void setSysFieldOfSysField(SysField sysFieldOfSysField) {
        this.sysFieldOfSysField = sysFieldOfSysField;
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

    /**
     *  ��ȡ filterFieldOfSysField.
     *  @return SysField.
     */
    public SysField getFilterFieldOfSysField() {
        return this.filterFieldOfSysField;
    }

    /**
     *  ���� filterFieldOfSysField.
     *  @param filterFieldOfSysField filterFieldOfSysField��.
     */
    public void setFilterFieldOfSysField(SysField filterFieldOfSysField) {
        this.filterFieldOfSysField = filterFieldOfSysField;
    }

    /**
     *  ��ȡ fieldRelationFieldOfSysField.
     *  @return SysField.
     */
    public SysField getFieldRelationFieldOfSysField() {
        return this.fieldRelationFieldOfSysField;
    }

    /**
     *  ���� fieldRelationFieldOfSysField.
     *  @param fieldRelationFieldOfSysField fieldRelationFieldOfSysField��.
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
