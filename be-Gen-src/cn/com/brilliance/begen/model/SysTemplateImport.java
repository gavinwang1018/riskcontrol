package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
    /**
     *  定义类SysTemplateImport.
     */
public class SysTemplateImport implements Serializable {
    /**
     *  字段域id.
     */
    private java.lang.String id;

    /**
     *  字段域partyId.
     */
    private java.lang.String partyId;

    /**
     *  字段域importDate.
     */
    private java.util.Date importDate;

    /**
     *  字段域templateId.
     */
    private java.lang.String templateId;

    /**
     *  集合域sysTemplateLogGroup.
     */
    private Set sysTemplateLogGroup;


    /**
     *  域partyIdOfSysParty.
     */
    private SysParty partyIdOfSysParty;
    /**
     *  域templateIdOfSysTemplate.
     */
    private SysTemplate templateIdOfSysTemplate;


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
     *  获取 importDate.
     *  @return java.util.Date.
     */
    public java.util.Date getImportDate() {
        return this.importDate;
    }

    /**
     *  设置 importDate.
     *  @param importDate importDate域.
     */
    public void setImportDate(java.util.Date importDate) {
        this.importDate = importDate;
    }
    /**
     *  获取 templateId.
     *  @return java.lang.String.
     */
    public java.lang.String getTemplateId() {
        return this.templateId;
    }

    /**
     *  设置 templateId.
     *  @param templateId templateId域.
     */
    public void setTemplateId(java.lang.String templateId) {
        this.templateId = templateId;
    }

    /**
     *  获取 sysTemplateLogGroup.
     *  @return Set.
     */
    public Set getSysTemplateLogGroup() {
        return this.sysTemplateLogGroup;
    }

    /**
     *  设置 sysTemplateLogGroup.
     *  @param sysTemplateLogGroup sysTemplateLogGroup域.
     */
    public void setSysTemplateLogGroup(Set sysTemplateLogGroup) {
        this.sysTemplateLogGroup = sysTemplateLogGroup;
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
     *  获取 templateIdOfSysTemplate.
     *  @return SysTemplate.
     */
    public SysTemplate getTemplateIdOfSysTemplate() {
        return this.templateIdOfSysTemplate;
    }

    /**
     *  设置 templateIdOfSysTemplate.
     *  @param templateIdOfSysTemplate templateIdOfSysTemplate域.
     */
    public void setTemplateIdOfSysTemplate(SysTemplate templateIdOfSysTemplate) {
        this.templateIdOfSysTemplate = templateIdOfSysTemplate;
    }



    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SysTemplateImport.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysTemplateImport"));
        org.apache.axis.description.ElementDesc elemField = null;        


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
        elemField.setFieldName("importDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "importDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "datetime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("templateId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "templateId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);

        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sysTemplateLogGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sysTemplateLogGroup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);

        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partyIdOfSysParty");
        elemField.setXmlName(new javax.xml.namespace.QName("", "partyIdOfSysParty"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysParty"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("templateIdOfSysTemplate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "templateIdOfSysTemplate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysTemplate"));
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
