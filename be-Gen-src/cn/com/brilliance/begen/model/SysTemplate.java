package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
    /**
     *  ������SysTemplate.
     */
public class SysTemplate implements Serializable {
    /**
     *  �ֶ���templateId.
     */
    private java.lang.String templateId;

    /**
     *  �ֶ���templateName.
     */
    private java.lang.String templateName;

    /**
     *  �ֶ���templateDesc.
     */
    private java.lang.String templateDesc;

    /**
     *  �ֶ���templateDbName.
     */
    private java.lang.String templateDbName;




    /**
     *  ��ȡ templateId.
     *  @return java.lang.String.
     */
    public java.lang.String getTemplateId() {
        return this.templateId;
    }

    /**
     *  ���� templateId.
     *  @param templateId templateId��.
     */
    public void setTemplateId(java.lang.String templateId) {
        this.templateId = templateId;
    }
    /**
     *  ��ȡ templateName.
     *  @return java.lang.String.
     */
    public java.lang.String getTemplateName() {
        return this.templateName;
    }

    /**
     *  ���� templateName.
     *  @param templateName templateName��.
     */
    public void setTemplateName(java.lang.String templateName) {
        this.templateName = templateName;
    }
    /**
     *  ��ȡ templateDesc.
     *  @return java.lang.String.
     */
    public java.lang.String getTemplateDesc() {
        return this.templateDesc;
    }

    /**
     *  ���� templateDesc.
     *  @param templateDesc templateDesc��.
     */
    public void setTemplateDesc(java.lang.String templateDesc) {
        this.templateDesc = templateDesc;
    }
    /**
     *  ��ȡ templateDbName.
     *  @return java.lang.String.
     */
    public java.lang.String getTemplateDbName() {
        return this.templateDbName;
    }

    /**
     *  ���� templateDbName.
     *  @param templateDbName templateDbName��.
     */
    public void setTemplateDbName(java.lang.String templateDbName) {
        this.templateDbName = templateDbName;
    }




    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SysTemplate.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysTemplate"));
        org.apache.axis.description.ElementDesc elemField = null;        


        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("templateId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "templateId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("templateName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "templateName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("templateDesc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "templateDesc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("templateDbName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "templateDbName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
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
