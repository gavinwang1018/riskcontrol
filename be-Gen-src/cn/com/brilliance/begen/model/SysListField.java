package cn.com.brilliance.begen.model;

import java.io.Serializable;

    /**
     *  定义类SysListField.
     */
public class SysListField implements Serializable {
    /**
     *  定义sysRecordOrder.
     */
    private java.lang.Integer sysRecordOrder;
    /**
     *  字段域id.
     */
    private java.lang.String id;

    /**
     *  字段域listLayout.
     */
    private java.lang.String listLayout;

    /**
     *  字段域view.
     */
    private java.lang.Boolean view;

    /**
     *  字段域partyId.
     */
    private java.lang.String partyId;

/*
,------
1,升序
2,降序
*/
    /**
     *  字段域sortFlag.
     */
    private java.lang.String sortFlag;

/*
0,不查询
1,精确查询
2,模糊查询
3,范围查询
*/
    /**
     *  字段域queryMode.
     */
    private java.lang.String queryMode;

/*
@extSelectItems.sysListFieldItems
*/
    /**
     *  字段域sysField.
     */
    private java.lang.String sysField;

    /**
     *  字段域relationField.
     */
    private java.lang.String relationField;


    /**
     *  域listLayoutOfSysListLayout.
     */
    private SysListLayout listLayoutOfSysListLayout;
    /**
     *  域partyIdOfSysParty.
     */
    private SysParty partyIdOfSysParty;
    /**
     *  域relationFieldOfSysField.
     */
    private SysField relationFieldOfSysField;

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
     *  获取 listLayout.
     *  @return java.lang.String.
     */
    public java.lang.String getListLayout() {
        return this.listLayout;
    }

    /**
     *  设置 listLayout.
     *  @param listLayout listLayout域.
     */
    public void setListLayout(java.lang.String listLayout) {
        this.listLayout = listLayout;
    }
    /**
     *  获取 view.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getView() {
        return this.view;
    }

    /**
     *  设置 view.
     *  @param view view域.
     */
    public void setView(java.lang.Boolean view) {
        this.view = view;
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
     *  获取 sortFlag.
     *  @return java.lang.String.
     */
    public java.lang.String getSortFlag() {
        return this.sortFlag;
    }

    /**
     *  设置 sortFlag.
     *  @param sortFlag sortFlag域.
     */
    public void setSortFlag(java.lang.String sortFlag) {
        this.sortFlag = sortFlag;
    }
    /**
     *  获取 queryMode.
     *  @return java.lang.String.
     */
    public java.lang.String getQueryMode() {
        return this.queryMode;
    }

    /**
     *  设置 queryMode.
     *  @param queryMode queryMode域.
     */
    public void setQueryMode(java.lang.String queryMode) {
        this.queryMode = queryMode;
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
     *  获取 listLayoutOfSysListLayout.
     *  @return SysListLayout.
     */
    public SysListLayout getListLayoutOfSysListLayout() {
        return this.listLayoutOfSysListLayout;
    }

    /**
     *  设置 listLayoutOfSysListLayout.
     *  @param listLayoutOfSysListLayout listLayoutOfSysListLayout域.
     */
    public void setListLayoutOfSysListLayout(SysListLayout listLayoutOfSysListLayout) {
        this.listLayoutOfSysListLayout = listLayoutOfSysListLayout;
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
