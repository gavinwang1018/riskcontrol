package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
    /**
     *  ������SysRelativeAction.
     */
public class SysRelativeAction implements Serializable {
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���rule.
     */
    private java.lang.String rule;

/*
@extSelectItems.inputFieldsByFormLayout[sysRelativeActionForm.sysRelativeAction.formLayout]
*/
    /**
     *  �ֶ���inputField.
     */
    private java.lang.String inputField;

    /**
     *  �ֶ���formLayout.
     */
    private java.lang.String formLayout;

    /**
     *  �ֶ���partyId.
     */
    private java.lang.String partyId;


    /**
     *  ��formLayoutOfSysFormLayout.
     */
    private SysFormLayout formLayoutOfSysFormLayout;
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
     *  ��ȡ rule.
     *  @return java.lang.String.
     */
    public java.lang.String getRule() {
        return this.rule;
    }

    /**
     *  ���� rule.
     *  @param rule rule��.
     */
    public void setRule(java.lang.String rule) {
        this.rule = rule;
    }
    /**
     *  ��ȡ inputField.
     *  @return java.lang.String.
     */
    public java.lang.String getInputField() {
        return this.inputField;
    }

    /**
     *  ���� inputField.
     *  @param inputField inputField��.
     */
    public void setInputField(java.lang.String inputField) {
        this.inputField = inputField;
    }
    /**
     *  ��ȡ formLayout.
     *  @return java.lang.String.
     */
    public java.lang.String getFormLayout() {
        return this.formLayout;
    }

    /**
     *  ���� formLayout.
     *  @param formLayout formLayout��.
     */
    public void setFormLayout(java.lang.String formLayout) {
        this.formLayout = formLayout;
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
     *  ��ȡ formLayoutOfSysFormLayout.
     *  @return SysFormLayout.
     */
    public SysFormLayout getFormLayoutOfSysFormLayout() {
        return this.formLayoutOfSysFormLayout;
    }

    /**
     *  ���� formLayoutOfSysFormLayout.
     *  @param formLayoutOfSysFormLayout formLayoutOfSysFormLayout��.
     */
    public void setFormLayoutOfSysFormLayout(SysFormLayout formLayoutOfSysFormLayout) {
        this.formLayoutOfSysFormLayout = formLayoutOfSysFormLayout;
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
        new org.apache.axis.description.TypeDesc(SysRelativeAction.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysRelativeAction"));
        org.apache.axis.description.ElementDesc elemField = null;        


        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rule");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rule"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inputField");
        elemField.setXmlName(new javax.xml.namespace.QName("", "inputField"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("formLayout");
        elemField.setXmlName(new javax.xml.namespace.QName("", "formLayout"));
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
        elemField.setFieldName("formLayoutOfSysFormLayout");
        elemField.setXmlName(new javax.xml.namespace.QName("", "formLayoutOfSysFormLayout"));
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
