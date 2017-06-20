package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
    /**
     *  定义类SysEcaAction.
     */
public class SysEcaAction implements Serializable {
    /**
     *  字段域id.
     */
    private java.lang.String id;

/*
0,邮件
*/
    /**
     *  字段域actionType.
     */
    private java.lang.String actionType;

    /**
     *  字段域content.
     */
    private java.lang.String content;

    /**
     *  字段域description.
     */
    private java.lang.String description;

    /**
     *  字段域ecaDefId.
     */
    private java.lang.String ecaDefId;

    /**
     *  字段域partyId.
     */
    private java.lang.String partyId;


    /**
     *  域ecaDefIdOfSysEcaDef.
     */
    private SysEcaDef ecaDefIdOfSysEcaDef;
    /**
     *  域partyIdOfSysParty.
     */
    private SysParty partyIdOfSysParty;


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
     *  获取 actionType.
     *  @return java.lang.String.
     */
    public java.lang.String getActionType() {
        return this.actionType;
    }

    /**
     *  设置 actionType.
     *  @param actionType actionType域.
     */
    public void setActionType(java.lang.String actionType) {
        this.actionType = actionType;
    }
    /**
     *  获取 content.
     *  @return java.lang.String.
     */
    public java.lang.String getContent() {
        return this.content;
    }

    /**
     *  设置 content.
     *  @param content content域.
     */
    public void setContent(java.lang.String content) {
        this.content = content;
    }
    /**
     *  获取 description.
     *  @return java.lang.String.
     */
    public java.lang.String getDescription() {
        return this.description;
    }

    /**
     *  设置 description.
     *  @param description description域.
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }
    /**
     *  获取 ecaDefId.
     *  @return java.lang.String.
     */
    public java.lang.String getEcaDefId() {
        return this.ecaDefId;
    }

    /**
     *  设置 ecaDefId.
     *  @param ecaDefId ecaDefId域.
     */
    public void setEcaDefId(java.lang.String ecaDefId) {
        this.ecaDefId = ecaDefId;
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
     *  获取 ecaDefIdOfSysEcaDef.
     *  @return SysEcaDef.
     */
    public SysEcaDef getEcaDefIdOfSysEcaDef() {
        return this.ecaDefIdOfSysEcaDef;
    }

    /**
     *  设置 ecaDefIdOfSysEcaDef.
     *  @param ecaDefIdOfSysEcaDef ecaDefIdOfSysEcaDef域.
     */
    public void setEcaDefIdOfSysEcaDef(SysEcaDef ecaDefIdOfSysEcaDef) {
        this.ecaDefIdOfSysEcaDef = ecaDefIdOfSysEcaDef;
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
        new org.apache.axis.description.TypeDesc(SysEcaAction.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysEcaAction"));
        org.apache.axis.description.ElementDesc elemField = null;        


        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
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
        elemField.setFieldName("content");
        elemField.setXmlName(new javax.xml.namespace.QName("", "content"));
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
        elemField.setFieldName("ecaDefId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ecaDefId"));
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
        elemField.setFieldName("ecaDefIdOfSysEcaDef");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ecaDefIdOfSysEcaDef"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysEcaDef"));
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
