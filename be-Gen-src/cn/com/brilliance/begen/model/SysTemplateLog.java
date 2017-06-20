package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
    /**
     *  定义类SysTemplateLog.
     */
public class SysTemplateLog implements Serializable {
    /**
     *  字段域id.
     */
    private java.lang.String id;

    /**
     *  字段域templateImportId.
     */
    private java.lang.String templateImportId;

    /**
     *  字段域tableName.
     */
    private java.lang.String tableName;

    /**
     *  字段域keyValue.
     */
    private java.lang.String keyValue;

    /**
     *  字段域partyId.
     */
    private java.lang.String partyId;


    /**
     *  域templateImportIdOfSysTemplateImport.
     */
    private SysTemplateImport templateImportIdOfSysTemplateImport;
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
     *  获取 templateImportId.
     *  @return java.lang.String.
     */
    public java.lang.String getTemplateImportId() {
        return this.templateImportId;
    }

    /**
     *  设置 templateImportId.
     *  @param templateImportId templateImportId域.
     */
    public void setTemplateImportId(java.lang.String templateImportId) {
        this.templateImportId = templateImportId;
    }
    /**
     *  获取 tableName.
     *  @return java.lang.String.
     */
    public java.lang.String getTableName() {
        return this.tableName;
    }

    /**
     *  设置 tableName.
     *  @param tableName tableName域.
     */
    public void setTableName(java.lang.String tableName) {
        this.tableName = tableName;
    }
    /**
     *  获取 keyValue.
     *  @return java.lang.String.
     */
    public java.lang.String getKeyValue() {
        return this.keyValue;
    }

    /**
     *  设置 keyValue.
     *  @param keyValue keyValue域.
     */
    public void setKeyValue(java.lang.String keyValue) {
        this.keyValue = keyValue;
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
     *  获取 templateImportIdOfSysTemplateImport.
     *  @return SysTemplateImport.
     */
    public SysTemplateImport getTemplateImportIdOfSysTemplateImport() {
        return this.templateImportIdOfSysTemplateImport;
    }

    /**
     *  设置 templateImportIdOfSysTemplateImport.
     *  @param templateImportIdOfSysTemplateImport templateImportIdOfSysTemplateImport域.
     */
    public void setTemplateImportIdOfSysTemplateImport(SysTemplateImport templateImportIdOfSysTemplateImport) {
        this.templateImportIdOfSysTemplateImport = templateImportIdOfSysTemplateImport;
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
        new org.apache.axis.description.TypeDesc(SysTemplateLog.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysTemplateLog"));
        org.apache.axis.description.ElementDesc elemField = null;        


        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("templateImportId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "templateImportId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tableName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tableName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("keyValue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "keyValue"));
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
        elemField.setFieldName("templateImportIdOfSysTemplateImport");
        elemField.setXmlName(new javax.xml.namespace.QName("", "templateImportIdOfSysTemplateImport"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysTemplateImport"));
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
