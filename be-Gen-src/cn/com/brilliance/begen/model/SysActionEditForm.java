package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
    /**
     *  定义类SysActionEditForm.
     */
public class SysActionEditForm implements Serializable {
    /**
     *  定义sysRecordOrder.
     */
    private java.lang.Integer sysRecordOrder;
    /**
     *  字段域id.
     */
    private java.lang.String id;

    /**
     *  字段域sysFormLayout.
     */
    private java.lang.String sysFormLayout;

    /**
     *  字段域name.
     */
    private java.lang.String name;

    /**
     *  字段域label.
     */
    private java.lang.String label;

    /**
     *  字段域authority.
     */
    private java.lang.Boolean authority;

    /**
     *  字段域url.
     */
    private java.lang.String url;

/*
_self,当前页面
_blank,弹出
*/
    /**
     *  字段域target.
     */
    private java.lang.String target;

    /**
     *  字段域pageCheck.
     */
    private java.lang.Boolean pageCheck;

    /**
     *  字段域partyId.
     */
    private java.lang.String partyId;

    /**
     *  字段域urlDescription.
     */
    private java.lang.String urlDescription;

    /**
     *  字段域disableExpress.
     */
    private java.lang.String disableExpress;

    /**
     *  字段域confirmOperate.
     */
    private java.lang.Boolean confirmOperate;

    /**
     *  字段域confirmMessage.
     */
    private java.lang.String confirmMessage;


    /**
     *  域sysFormLayoutOfSysFormLayout.
     */
    private SysFormLayout sysFormLayoutOfSysFormLayout;
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
     *  获取 sysFormLayout.
     *  @return java.lang.String.
     */
    public java.lang.String getSysFormLayout() {
        return this.sysFormLayout;
    }

    /**
     *  设置 sysFormLayout.
     *  @param sysFormLayout sysFormLayout域.
     */
    public void setSysFormLayout(java.lang.String sysFormLayout) {
        this.sysFormLayout = sysFormLayout;
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
     *  获取 authority.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getAuthority() {
        return this.authority;
    }

    /**
     *  设置 authority.
     *  @param authority authority域.
     */
    public void setAuthority(java.lang.Boolean authority) {
        this.authority = authority;
    }
    /**
     *  获取 url.
     *  @return java.lang.String.
     */
    public java.lang.String getUrl() {
        return this.url;
    }

    /**
     *  设置 url.
     *  @param url url域.
     */
    public void setUrl(java.lang.String url) {
        this.url = url;
    }
    /**
     *  获取 target.
     *  @return java.lang.String.
     */
    public java.lang.String getTarget() {
        return this.target;
    }

    /**
     *  设置 target.
     *  @param target target域.
     */
    public void setTarget(java.lang.String target) {
        this.target = target;
    }
    /**
     *  获取 pageCheck.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getPageCheck() {
        return this.pageCheck;
    }

    /**
     *  设置 pageCheck.
     *  @param pageCheck pageCheck域.
     */
    public void setPageCheck(java.lang.Boolean pageCheck) {
        this.pageCheck = pageCheck;
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
     *  获取 urlDescription.
     *  @return java.lang.String.
     */
    public java.lang.String getUrlDescription() {
        return this.urlDescription;
    }

    /**
     *  设置 urlDescription.
     *  @param urlDescription urlDescription域.
     */
    public void setUrlDescription(java.lang.String urlDescription) {
        this.urlDescription = urlDescription;
    }
    /**
     *  获取 disableExpress.
     *  @return java.lang.String.
     */
    public java.lang.String getDisableExpress() {
        return this.disableExpress;
    }

    /**
     *  设置 disableExpress.
     *  @param disableExpress disableExpress域.
     */
    public void setDisableExpress(java.lang.String disableExpress) {
        this.disableExpress = disableExpress;
    }
    /**
     *  获取 confirmOperate.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getConfirmOperate() {
        return this.confirmOperate;
    }

    /**
     *  设置 confirmOperate.
     *  @param confirmOperate confirmOperate域.
     */
    public void setConfirmOperate(java.lang.Boolean confirmOperate) {
        this.confirmOperate = confirmOperate;
    }
    /**
     *  获取 confirmMessage.
     *  @return java.lang.String.
     */
    public java.lang.String getConfirmMessage() {
        return this.confirmMessage;
    }

    /**
     *  设置 confirmMessage.
     *  @param confirmMessage confirmMessage域.
     */
    public void setConfirmMessage(java.lang.String confirmMessage) {
        this.confirmMessage = confirmMessage;
    }


    /**
     *  获取 sysFormLayoutOfSysFormLayout.
     *  @return SysFormLayout.
     */
    public SysFormLayout getSysFormLayoutOfSysFormLayout() {
        return this.sysFormLayoutOfSysFormLayout;
    }

    /**
     *  设置 sysFormLayoutOfSysFormLayout.
     *  @param sysFormLayoutOfSysFormLayout sysFormLayoutOfSysFormLayout域.
     */
    public void setSysFormLayoutOfSysFormLayout(SysFormLayout sysFormLayoutOfSysFormLayout) {
        this.sysFormLayoutOfSysFormLayout = sysFormLayoutOfSysFormLayout;
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
        new org.apache.axis.description.TypeDesc(SysActionEditForm.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysActionEditForm"));
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
        elemField.setFieldName("sysFormLayout");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sysFormLayout"));
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
        elemField.setFieldName("authority");
        elemField.setXmlName(new javax.xml.namespace.QName("", "authority"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("url");
        elemField.setXmlName(new javax.xml.namespace.QName("", "url"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("target");
        elemField.setXmlName(new javax.xml.namespace.QName("", "target"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pageCheck");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pageCheck"));
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
        elemField.setFieldName("urlDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("", "urlDescription"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("disableExpress");
        elemField.setXmlName(new javax.xml.namespace.QName("", "disableExpress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("confirmOperate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "confirmOperate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("confirmMessage");
        elemField.setXmlName(new javax.xml.namespace.QName("", "confirmMessage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);


        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sysFormLayoutOfSysFormLayout");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sysFormLayoutOfSysFormLayout"));
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
