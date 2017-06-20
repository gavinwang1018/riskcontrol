package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
    /**
     *  ������SysActionEditForm.
     */
public class SysActionEditForm implements Serializable {
    /**
     *  ����sysRecordOrder.
     */
    private java.lang.Integer sysRecordOrder;
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���sysFormLayout.
     */
    private java.lang.String sysFormLayout;

    /**
     *  �ֶ���name.
     */
    private java.lang.String name;

    /**
     *  �ֶ���label.
     */
    private java.lang.String label;

    /**
     *  �ֶ���authority.
     */
    private java.lang.Boolean authority;

    /**
     *  �ֶ���url.
     */
    private java.lang.String url;

/*
_self,��ǰҳ��
_blank,����
*/
    /**
     *  �ֶ���target.
     */
    private java.lang.String target;

    /**
     *  �ֶ���pageCheck.
     */
    private java.lang.Boolean pageCheck;

    /**
     *  �ֶ���partyId.
     */
    private java.lang.String partyId;

    /**
     *  �ֶ���urlDescription.
     */
    private java.lang.String urlDescription;

    /**
     *  �ֶ���disableExpress.
     */
    private java.lang.String disableExpress;

    /**
     *  �ֶ���confirmOperate.
     */
    private java.lang.Boolean confirmOperate;

    /**
     *  �ֶ���confirmMessage.
     */
    private java.lang.String confirmMessage;


    /**
     *  ��sysFormLayoutOfSysFormLayout.
     */
    private SysFormLayout sysFormLayoutOfSysFormLayout;
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
     *  ��ȡ sysFormLayout.
     *  @return java.lang.String.
     */
    public java.lang.String getSysFormLayout() {
        return this.sysFormLayout;
    }

    /**
     *  ���� sysFormLayout.
     *  @param sysFormLayout sysFormLayout��.
     */
    public void setSysFormLayout(java.lang.String sysFormLayout) {
        this.sysFormLayout = sysFormLayout;
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
     *  ��ȡ authority.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getAuthority() {
        return this.authority;
    }

    /**
     *  ���� authority.
     *  @param authority authority��.
     */
    public void setAuthority(java.lang.Boolean authority) {
        this.authority = authority;
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
     *  ��ȡ target.
     *  @return java.lang.String.
     */
    public java.lang.String getTarget() {
        return this.target;
    }

    /**
     *  ���� target.
     *  @param target target��.
     */
    public void setTarget(java.lang.String target) {
        this.target = target;
    }
    /**
     *  ��ȡ pageCheck.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getPageCheck() {
        return this.pageCheck;
    }

    /**
     *  ���� pageCheck.
     *  @param pageCheck pageCheck��.
     */
    public void setPageCheck(java.lang.Boolean pageCheck) {
        this.pageCheck = pageCheck;
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
     *  ��ȡ urlDescription.
     *  @return java.lang.String.
     */
    public java.lang.String getUrlDescription() {
        return this.urlDescription;
    }

    /**
     *  ���� urlDescription.
     *  @param urlDescription urlDescription��.
     */
    public void setUrlDescription(java.lang.String urlDescription) {
        this.urlDescription = urlDescription;
    }
    /**
     *  ��ȡ disableExpress.
     *  @return java.lang.String.
     */
    public java.lang.String getDisableExpress() {
        return this.disableExpress;
    }

    /**
     *  ���� disableExpress.
     *  @param disableExpress disableExpress��.
     */
    public void setDisableExpress(java.lang.String disableExpress) {
        this.disableExpress = disableExpress;
    }
    /**
     *  ��ȡ confirmOperate.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getConfirmOperate() {
        return this.confirmOperate;
    }

    /**
     *  ���� confirmOperate.
     *  @param confirmOperate confirmOperate��.
     */
    public void setConfirmOperate(java.lang.Boolean confirmOperate) {
        this.confirmOperate = confirmOperate;
    }
    /**
     *  ��ȡ confirmMessage.
     *  @return java.lang.String.
     */
    public java.lang.String getConfirmMessage() {
        return this.confirmMessage;
    }

    /**
     *  ���� confirmMessage.
     *  @param confirmMessage confirmMessage��.
     */
    public void setConfirmMessage(java.lang.String confirmMessage) {
        this.confirmMessage = confirmMessage;
    }


    /**
     *  ��ȡ sysFormLayoutOfSysFormLayout.
     *  @return SysFormLayout.
     */
    public SysFormLayout getSysFormLayoutOfSysFormLayout() {
        return this.sysFormLayoutOfSysFormLayout;
    }

    /**
     *  ���� sysFormLayoutOfSysFormLayout.
     *  @param sysFormLayoutOfSysFormLayout sysFormLayoutOfSysFormLayout��.
     */
    public void setSysFormLayoutOfSysFormLayout(SysFormLayout sysFormLayoutOfSysFormLayout) {
        this.sysFormLayoutOfSysFormLayout = sysFormLayoutOfSysFormLayout;
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
