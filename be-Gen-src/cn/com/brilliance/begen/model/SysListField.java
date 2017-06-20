package cn.com.brilliance.begen.model;

import java.io.Serializable;

    /**
     *  ������SysListField.
     */
public class SysListField implements Serializable {
    /**
     *  ����sysRecordOrder.
     */
    private java.lang.Integer sysRecordOrder;
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���listLayout.
     */
    private java.lang.String listLayout;

    /**
     *  �ֶ���view.
     */
    private java.lang.Boolean view;

    /**
     *  �ֶ���partyId.
     */
    private java.lang.String partyId;

/*
,------
1,����
2,����
*/
    /**
     *  �ֶ���sortFlag.
     */
    private java.lang.String sortFlag;

/*
0,����ѯ
1,��ȷ��ѯ
2,ģ����ѯ
3,��Χ��ѯ
*/
    /**
     *  �ֶ���queryMode.
     */
    private java.lang.String queryMode;

/*
@extSelectItems.sysListFieldItems
*/
    /**
     *  �ֶ���sysField.
     */
    private java.lang.String sysField;

    /**
     *  �ֶ���relationField.
     */
    private java.lang.String relationField;


    /**
     *  ��listLayoutOfSysListLayout.
     */
    private SysListLayout listLayoutOfSysListLayout;
    /**
     *  ��partyIdOfSysParty.
     */
    private SysParty partyIdOfSysParty;
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
     *  ��ȡ listLayout.
     *  @return java.lang.String.
     */
    public java.lang.String getListLayout() {
        return this.listLayout;
    }

    /**
     *  ���� listLayout.
     *  @param listLayout listLayout��.
     */
    public void setListLayout(java.lang.String listLayout) {
        this.listLayout = listLayout;
    }
    /**
     *  ��ȡ view.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getView() {
        return this.view;
    }

    /**
     *  ���� view.
     *  @param view view��.
     */
    public void setView(java.lang.Boolean view) {
        this.view = view;
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
     *  ��ȡ sortFlag.
     *  @return java.lang.String.
     */
    public java.lang.String getSortFlag() {
        return this.sortFlag;
    }

    /**
     *  ���� sortFlag.
     *  @param sortFlag sortFlag��.
     */
    public void setSortFlag(java.lang.String sortFlag) {
        this.sortFlag = sortFlag;
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
     *  ��ȡ listLayoutOfSysListLayout.
     *  @return SysListLayout.
     */
    public SysListLayout getListLayoutOfSysListLayout() {
        return this.listLayoutOfSysListLayout;
    }

    /**
     *  ���� listLayoutOfSysListLayout.
     *  @param listLayoutOfSysListLayout listLayoutOfSysListLayout��.
     */
    public void setListLayoutOfSysListLayout(SysListLayout listLayoutOfSysListLayout) {
        this.listLayoutOfSysListLayout = listLayoutOfSysListLayout;
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
        new org.apache.axis.description.TypeDesc(SysListField.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysListField"));
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
        elemField.setFieldName("listLayout");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listLayout"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("view");
        elemField.setXmlName(new javax.xml.namespace.QName("", "view"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partyId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "partyId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sortFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sortFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("queryMode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "queryMode"));
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
        elemField.setFieldName("listLayoutOfSysListLayout");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listLayoutOfSysListLayout"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysListLayout"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partyIdOfSysParty");
        elemField.setXmlName(new javax.xml.namespace.QName("", "partyIdOfSysParty"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysParty"));
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
