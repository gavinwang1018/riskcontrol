package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
    /**
     *  ������SysEcaDef.
     */
public class SysEcaDef implements Serializable {
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���dataObject.
     */
    private java.lang.String dataObject;

/*
0,����
1,�޸�
2,ɾ��
*/
    /**
     *  �ֶ���actionType.
     */
    private java.lang.String actionType;

    /**
     *  �ֶ���eventExpress.
     */
    private java.lang.String eventExpress;

    /**
     *  �ֶ���description.
     */
    private java.lang.String description;

    /**
     *  �ֶ���partyId.
     */
    private java.lang.String partyId;

    /**
     *  ������sysEcaActionGroup.
     */
    private Set sysEcaActionGroup;


    /**
     *  ��dataObjectOfSysDataObject.
     */
    private SysDataObject dataObjectOfSysDataObject;
    /**
     *  ��partyIdOfSysParty.
     */
    private SysParty partyIdOfSysParty;


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
     *  ��ȡ actionType.
     *  @return java.lang.String.
     */
    public java.lang.String getActionType() {
        return this.actionType;
    }

    /**
     *  ���� actionType.
     *  @param actionType actionType��.
     */
    public void setActionType(java.lang.String actionType) {
        this.actionType = actionType;
    }
    /**
     *  ��ȡ eventExpress.
     *  @return java.lang.String.
     */
    public java.lang.String getEventExpress() {
        return this.eventExpress;
    }

    /**
     *  ���� eventExpress.
     *  @param eventExpress eventExpress��.
     */
    public void setEventExpress(java.lang.String eventExpress) {
        this.eventExpress = eventExpress;
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
     *  ��ȡ sysEcaActionGroup.
     *  @return Set.
     */
    public Set getSysEcaActionGroup() {
        return this.sysEcaActionGroup;
    }

    /**
     *  ���� sysEcaActionGroup.
     *  @param sysEcaActionGroup sysEcaActionGroup��.
     */
    public void setSysEcaActionGroup(Set sysEcaActionGroup) {
        this.sysEcaActionGroup = sysEcaActionGroup;
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
        new org.apache.axis.description.TypeDesc(SysEcaDef.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysEcaDef"));
        org.apache.axis.description.ElementDesc elemField = null;        


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
        elemField.setFieldName("actionType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "actionType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eventExpress");
        elemField.setXmlName(new javax.xml.namespace.QName("", "eventExpress"));
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
        elemField.setFieldName("partyId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "partyId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);

        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sysEcaActionGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sysEcaActionGroup"));
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
