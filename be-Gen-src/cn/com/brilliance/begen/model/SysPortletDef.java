package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
    /**
     *  ������SysPortletDef.
     */
public class SysPortletDef implements Serializable {
    /**
     *  ����sysRecordOrder.
     */
    private java.lang.Integer sysRecordOrder;
    /**
     *  �ֶ���label.
     */
    private java.lang.String label;

    /**
     *  �ֶ���url.
     */
    private java.lang.String url;

    /**
     *  �ֶ���partyId.
     */
    private java.lang.String partyId;

    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���urlDescription.
     */
    private java.lang.String urlDescription;

    /**
     *  �ֶ���portalId.
     */
    private java.lang.String portalId;

/*
1,��һ��
2,�ڶ���
3,������
*/
    /**
     *  �ֶ���cols.
     */
    private java.lang.String cols;


    /**
     *  ��partyIdOfSysParty.
     */
    private SysParty partyIdOfSysParty;
    /**
     *  ��portalIdOfSysPortalDef.
     */
    private SysPortalDef portalIdOfSysPortalDef;

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
     *  ��ȡ portalId.
     *  @return java.lang.String.
     */
    public java.lang.String getPortalId() {
        return this.portalId;
    }

    /**
     *  ���� portalId.
     *  @param portalId portalId��.
     */
    public void setPortalId(java.lang.String portalId) {
        this.portalId = portalId;
    }
    /**
     *  ��ȡ cols.
     *  @return java.lang.String.
     */
    public java.lang.String getCols() {
        return this.cols;
    }

    /**
     *  ���� cols.
     *  @param cols cols��.
     */
    public void setCols(java.lang.String cols) {
        this.cols = cols;
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
     *  ��ȡ portalIdOfSysPortalDef.
     *  @return SysPortalDef.
     */
    public SysPortalDef getPortalIdOfSysPortalDef() {
        return this.portalIdOfSysPortalDef;
    }

    /**
     *  ���� portalIdOfSysPortalDef.
     *  @param portalIdOfSysPortalDef portalIdOfSysPortalDef��.
     */
    public void setPortalIdOfSysPortalDef(SysPortalDef portalIdOfSysPortalDef) {
        this.portalIdOfSysPortalDef = portalIdOfSysPortalDef;
    }



    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SysPortletDef.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysPortletDef"));
        org.apache.axis.description.ElementDesc elemField = null;        

        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sysRecordOrder");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sysRecordOrder"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);

        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("label");
        elemField.setXmlName(new javax.xml.namespace.QName("", "label"));
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
        elemField.setFieldName("partyId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "partyId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
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
        elemField.setFieldName("portalId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "portalId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cols");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cols"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);


        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partyIdOfSysParty");
        elemField.setXmlName(new javax.xml.namespace.QName("", "partyIdOfSysParty"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysParty"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("portalIdOfSysPortalDef");
        elemField.setXmlName(new javax.xml.namespace.QName("", "portalIdOfSysPortalDef"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysPortalDef"));
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
