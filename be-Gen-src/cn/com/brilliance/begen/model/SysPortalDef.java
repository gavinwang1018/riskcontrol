package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
    /**
     *  ������SysPortalDef.
     */
public class SysPortalDef implements Serializable {
    /**
     *  �ֶ���description.
     */
    private java.lang.String description;

/*
1,����
2,����
3,����
*/
    /**
     *  �ֶ���cols.
     */
    private java.lang.String cols;

    /**
     *  �ֶ���label.
     */
    private java.lang.String label;

/*
1,խ
2,��
3,��
*/
    /**
     *  �ֶ���widthFst.
     */
    private java.lang.String widthFst;

/*
1,խ
2,��
3,��
*/
    /**
     *  �ֶ���widthSec.
     */
    private java.lang.String widthSec;

/*
1,խ
2,��
3,��
*/
    /**
     *  �ֶ���widthThd.
     */
    private java.lang.String widthThd;

    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���partyId.
     */
    private java.lang.String partyId;

    /**
     *  �ֶ���portalId.
     */
    private java.lang.String portalId;

    /**
     *  ������sysPortletDefGroup.
     */
    private Set sysPortletDefGroup;


    /**
     *  ��partyIdOfSysParty.
     */
    private SysParty partyIdOfSysParty;


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
     *  ��ȡ widthFst.
     *  @return java.lang.String.
     */
    public java.lang.String getWidthFst() {
        return this.widthFst;
    }

    /**
     *  ���� widthFst.
     *  @param widthFst widthFst��.
     */
    public void setWidthFst(java.lang.String widthFst) {
        this.widthFst = widthFst;
    }
    /**
     *  ��ȡ widthSec.
     *  @return java.lang.String.
     */
    public java.lang.String getWidthSec() {
        return this.widthSec;
    }

    /**
     *  ���� widthSec.
     *  @param widthSec widthSec��.
     */
    public void setWidthSec(java.lang.String widthSec) {
        this.widthSec = widthSec;
    }
    /**
     *  ��ȡ widthThd.
     *  @return java.lang.String.
     */
    public java.lang.String getWidthThd() {
        return this.widthThd;
    }

    /**
     *  ���� widthThd.
     *  @param widthThd widthThd��.
     */
    public void setWidthThd(java.lang.String widthThd) {
        this.widthThd = widthThd;
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
     *  ��ȡ sysPortletDefGroup.
     *  @return Set.
     */
    public Set getSysPortletDefGroup() {
        return this.sysPortletDefGroup;
    }

    /**
     *  ���� sysPortletDefGroup.
     *  @param sysPortletDefGroup sysPortletDefGroup��.
     */
    public void setSysPortletDefGroup(Set sysPortletDefGroup) {
        this.sysPortletDefGroup = sysPortletDefGroup;
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
        new org.apache.axis.description.TypeDesc(SysPortalDef.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysPortalDef"));
        org.apache.axis.description.ElementDesc elemField = null;        


        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("", "description"));
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
        elemField.setFieldName("label");
        elemField.setXmlName(new javax.xml.namespace.QName("", "label"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("widthFst");
        elemField.setXmlName(new javax.xml.namespace.QName("", "widthFst"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("widthSec");
        elemField.setXmlName(new javax.xml.namespace.QName("", "widthSec"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("widthThd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "widthThd"));
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
        elemField.setFieldName("partyId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "partyId"));
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
        elemField.setFieldName("sysPortletDefGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sysPortletDefGroup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
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
