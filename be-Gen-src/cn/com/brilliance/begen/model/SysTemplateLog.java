package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
    /**
     *  ������SysTemplateLog.
     */
public class SysTemplateLog implements Serializable {
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���templateImportId.
     */
    private java.lang.String templateImportId;

    /**
     *  �ֶ���tableName.
     */
    private java.lang.String tableName;

    /**
     *  �ֶ���keyValue.
     */
    private java.lang.String keyValue;

    /**
     *  �ֶ���partyId.
     */
    private java.lang.String partyId;


    /**
     *  ��templateImportIdOfSysTemplateImport.
     */
    private SysTemplateImport templateImportIdOfSysTemplateImport;
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
     *  ��ȡ templateImportId.
     *  @return java.lang.String.
     */
    public java.lang.String getTemplateImportId() {
        return this.templateImportId;
    }

    /**
     *  ���� templateImportId.
     *  @param templateImportId templateImportId��.
     */
    public void setTemplateImportId(java.lang.String templateImportId) {
        this.templateImportId = templateImportId;
    }
    /**
     *  ��ȡ tableName.
     *  @return java.lang.String.
     */
    public java.lang.String getTableName() {
        return this.tableName;
    }

    /**
     *  ���� tableName.
     *  @param tableName tableName��.
     */
    public void setTableName(java.lang.String tableName) {
        this.tableName = tableName;
    }
    /**
     *  ��ȡ keyValue.
     *  @return java.lang.String.
     */
    public java.lang.String getKeyValue() {
        return this.keyValue;
    }

    /**
     *  ���� keyValue.
     *  @param keyValue keyValue��.
     */
    public void setKeyValue(java.lang.String keyValue) {
        this.keyValue = keyValue;
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
     *  ��ȡ templateImportIdOfSysTemplateImport.
     *  @return SysTemplateImport.
     */
    public SysTemplateImport getTemplateImportIdOfSysTemplateImport() {
        return this.templateImportIdOfSysTemplateImport;
    }

    /**
     *  ���� templateImportIdOfSysTemplateImport.
     *  @param templateImportIdOfSysTemplateImport templateImportIdOfSysTemplateImport��.
     */
    public void setTemplateImportIdOfSysTemplateImport(SysTemplateImport templateImportIdOfSysTemplateImport) {
        this.templateImportIdOfSysTemplateImport = templateImportIdOfSysTemplateImport;
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
