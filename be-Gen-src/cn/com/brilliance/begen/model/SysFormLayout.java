package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
    /**
     *  ������SysFormLayout.
     */
public class SysFormLayout implements Serializable {
    /**
     *  ����sysRecordOrder.
     */
    private java.lang.Integer sysRecordOrder;
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���dataObject.
     */
    private java.lang.String dataObject;

    /**
     *  �ֶ���name.
     */
    private java.lang.String name;

    /**
     *  �ֶ���label.
     */
    private java.lang.String label;

    /**
     *  �ֶ���description.
     */
    private java.lang.String description;

    /**
     *  �ֶ���url.
     */
    private java.lang.String url;

/*
0,������ʽ
1,Tab��ʽ1
2,Tab��ʽ2
3,eps��ʽ
*/
    /**
     *  �ֶ���style.
     */
    private java.lang.String style;

    /**
     *  �ֶ���partyId.
     */
    private java.lang.String partyId;

    /**
     *  ������sysSectionGroup.
     */
    private Set sysSectionGroup;

    /**
     *  ������sysRelativeGroup.
     */
    private Set sysRelativeGroup;

    /**
     *  ������sysActionViewFormGroup.
     */
    private Set sysActionViewFormGroup;

    /**
     *  ������sysActionEditFormGroup.
     */
    private Set sysActionEditFormGroup;

    /**
     *  ������sysRelativeActionGroup.
     */
    private Set sysRelativeActionGroup;


    /**
     *  ��dataObjectOfSysDataObject.
     */
    private SysDataObject dataObjectOfSysDataObject;
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
     *  ��ȡ description.
     *  @return java.lang.String.
     */
    public java.lang.String getDescription() {
        return this.description;
    }

    /**
     *  ���� description.
     *  @param description description��.
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }
    /**
     *  ��ȡ url.
     *  @return java.lang.String.
     */
    public java.lang.String getUrl() {
        return this.url;
    }

    /**
     *  ���� url.
     *  @param url url��.
     */
    public void setUrl(java.lang.String url) {
        this.url = url;
    }
    /**
     *  ��ȡ style.
     *  @return java.lang.String.
     */
    public java.lang.String getStyle() {
        return this.style;
    }

    /**
     *  ���� style.
     *  @param style style��.
     */
    public void setStyle(java.lang.String style) {
        this.style = style;
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
     *  ��ȡ sysSectionGroup.
     *  @return Set.
     */
    public Set getSysSectionGroup() {
        return this.sysSectionGroup;
    }

    /**
     *  ���� sysSectionGroup.
     *  @param sysSectionGroup sysSectionGroup��.
     */
    public void setSysSectionGroup(Set sysSectionGroup) {
        this.sysSectionGroup = sysSectionGroup;
    }
    /**
     *  ��ȡ sysRelativeGroup.
     *  @return Set.
     */
    public Set getSysRelativeGroup() {
        return this.sysRelativeGroup;
    }

    /**
     *  ���� sysRelativeGroup.
     *  @param sysRelativeGroup sysRelativeGroup��.
     */
    public void setSysRelativeGroup(Set sysRelativeGroup) {
        this.sysRelativeGroup = sysRelativeGroup;
    }
    /**
     *  ��ȡ sysActionViewFormGroup.
     *  @return Set.
     */
    public Set getSysActionViewFormGroup() {
        return this.sysActionViewFormGroup;
    }

    /**
     *  ���� sysActionViewFormGroup.
     *  @param sysActionViewFormGroup sysActionViewFormGroup��.
     */
    public void setSysActionViewFormGroup(Set sysActionViewFormGroup) {
        this.sysActionViewFormGroup = sysActionViewFormGroup;
    }
    /**
     *  ��ȡ sysActionEditFormGroup.
     *  @return Set.
     */
    public Set getSysActionEditFormGroup() {
        return this.sysActionEditFormGroup;
    }

    /**
     *  ���� sysActionEditFormGroup.
     *  @param sysActionEditFormGroup sysActionEditFormGroup��.
     */
    public void setSysActionEditFormGroup(Set sysActionEditFormGroup) {
        this.sysActionEditFormGroup = sysActionEditFormGroup;
    }
    /**
     *  ��ȡ sysRelativeActionGroup.
     *  @return Set.
     */
    public Set getSysRelativeActionGroup() {
        return this.sysRelativeActionGroup;
    }

    /**
     *  ���� sysRelativeActionGroup.
     *  @param sysRelativeActionGroup sysRelativeActionGroup��.
     */
    public void setSysRelativeActionGroup(Set sysRelativeActionGroup) {
        this.sysRelativeActionGroup = sysRelativeActionGroup;
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
        new org.apache.axis.description.TypeDesc(SysFormLayout.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysFormLayout"));
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
        elemField.setFieldName("dataObject");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataObject"));
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
        elemField.setFieldName("label");
        elemField.setXmlName(new javax.xml.namespace.QName("", "label"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("url");
        elemField.setXmlName(new javax.xml.namespace.QName("", "url"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("style");
        elemField.setXmlName(new javax.xml.namespace.QName("", "style"));
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
        elemField.setFieldName("sysSectionGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sysSectionGroup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sysRelativeGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sysRelativeGroup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sysActionViewFormGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sysActionViewFormGroup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sysActionEditFormGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sysActionEditFormGroup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sysRelativeActionGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sysRelativeActionGroup"));
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
