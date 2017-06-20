package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;

    /**
     *  ������SysDataObject.
     */
public class SysDataObject implements Serializable {
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���name.
     */
    private java.lang.String name;

    /**
     *  �ֶ���label.
     */
    private java.lang.String label;

    /**
     *  �ֶ���description.
     */
    private java.lang.String description;

/*
0,����
1,����
2,ָ����������
3,ָ����ɫ����
4,ָ�������ͽ�ɫ����
*/
    /**
     *  �ֶ���shareFlag.
     */
    private java.lang.String shareFlag;

    /**
     *  �ֶ���shareRole.
     */
    private java.lang.String shareRole;

/*
0,������
1,�ϼ�����
2,�¼�����
*/
    /**
     *  �ֶ���shareOrg.
     */
    private java.lang.String shareOrg;

    /**
     *  �ֶ���validatorRule.
     */
    private java.lang.String validatorRule;

    /**
     *  �ֶ���standard.
     */
    private java.lang.Boolean standard;

    /**
     *  �ֶ���partyId.
     */
    private java.lang.String partyId;

    /**
     *  �ֶ���orderFlag.
     */
    private java.lang.Boolean orderFlag;

/*
@extSelectItems.lookupLayoutItems
*/
    /**
     *  �ֶ���lookupLayout.
     */
    private java.lang.String lookupLayout;

/*
@extSelectItems.fieldsItems
*/
    /**
     *  �ֶ���labelField.
     */
    private java.lang.String labelField;

    /**
     *  ������sysListLayoutGroup.
     */
    private Set sysListLayoutGroup;

    /**
     *  ������sysFormLayoutGroup.
     */
    private Set sysFormLayoutGroup;

    /**
     *  ������sysFieldGroup.
     */
    private Set sysFieldGroup;


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
     *  ��ȡ shareFlag.
     *  @return java.lang.String.
     */
    public java.lang.String getShareFlag() {
        return this.shareFlag;
    }

    /**
     *  ���� shareFlag.
     *  @param shareFlag shareFlag��.
     */
    public void setShareFlag(java.lang.String shareFlag) {
        this.shareFlag = shareFlag;
    }
    /**
     *  ��ȡ shareRole.
     *  @return java.lang.String.
     */
    public java.lang.String getShareRole() {
        return this.shareRole;
    }

    /**
     *  ���� shareRole.
     *  @param shareRole shareRole��.
     */
    public void setShareRole(java.lang.String shareRole) {
        this.shareRole = shareRole;
    }
    /**
     *  ��ȡ shareOrg.
     *  @return java.lang.String.
     */
    public java.lang.String getShareOrg() {
        return this.shareOrg;
    }

    /**
     *  ���� shareOrg.
     *  @param shareOrg shareOrg��.
     */
    public void setShareOrg(java.lang.String shareOrg) {
        this.shareOrg = shareOrg;
    }
    /**
     *  ��ȡ validatorRule.
     *  @return java.lang.String.
     */
    public java.lang.String getValidatorRule() {
        return this.validatorRule;
    }

    /**
     *  ���� validatorRule.
     *  @param validatorRule validatorRule��.
     */
    public void setValidatorRule(java.lang.String validatorRule) {
        this.validatorRule = validatorRule;
    }
    /**
     *  ��ȡ standard.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getStandard() {
        return this.standard;
    }

    /**
     *  ���� standard.
     *  @param standard standard��.
     */
    public void setStandard(java.lang.Boolean standard) {
        this.standard = standard;
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
     *  ��ȡ orderFlag.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getOrderFlag() {
        return this.orderFlag;
    }

    /**
     *  ���� orderFlag.
     *  @param orderFlag orderFlag��.
     */
    public void setOrderFlag(java.lang.Boolean orderFlag) {
        this.orderFlag = orderFlag;
    }
    /**
     *  ��ȡ lookupLayout.
     *  @return java.lang.String.
     */
    public java.lang.String getLookupLayout() {
        return this.lookupLayout;
    }

    /**
     *  ���� lookupLayout.
     *  @param lookupLayout lookupLayout��.
     */
    public void setLookupLayout(java.lang.String lookupLayout) {
        this.lookupLayout = lookupLayout;
    }
    /**
     *  ��ȡ labelField.
     *  @return java.lang.String.
     */
    public java.lang.String getLabelField() {
        return this.labelField;
    }

    /**
     *  ���� labelField.
     *  @param labelField labelField��.
     */
    public void setLabelField(java.lang.String labelField) {
        this.labelField = labelField;
    }

    /**
     *  ��ȡ sysListLayoutGroup.
     *  @return Set.
     */
    public Set getSysListLayoutGroup() {
        return this.sysListLayoutGroup;
    }

    /**
     *  ���� sysListLayoutGroup.
     *  @param sysListLayoutGroup sysListLayoutGroup��.
     */
    public void setSysListLayoutGroup(Set sysListLayoutGroup) {
        this.sysListLayoutGroup = sysListLayoutGroup;
    }
    /**
     *  ��ȡ sysFormLayoutGroup.
     *  @return Set.
     */
    public Set getSysFormLayoutGroup() {
        return this.sysFormLayoutGroup;
    }

    /**
     *  ���� sysFormLayoutGroup.
     *  @param sysFormLayoutGroup sysFormLayoutGroup��.
     */
    public void setSysFormLayoutGroup(Set sysFormLayoutGroup) {
        this.sysFormLayoutGroup = sysFormLayoutGroup;
    }
    /**
     *  ��ȡ sysFieldGroup.
     *  @return Set.
     */
    public Set getSysFieldGroup() {
        return this.sysFieldGroup;
    }

    /**
     *  ���� sysFieldGroup.
     *  @param sysFieldGroup sysFieldGroup��.
     */
    public void setSysFieldGroup(Set sysFieldGroup) {
        this.sysFieldGroup = sysFieldGroup;
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
        new org.apache.axis.description.TypeDesc(SysDataObject.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysDataObject"));
        org.apache.axis.description.ElementDesc elemField = null;        


        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
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
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("shareFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "shareFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("shareRole");
        elemField.setXmlName(new javax.xml.namespace.QName("", "shareRole"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("shareOrg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "shareOrg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("validatorRule");
        elemField.setXmlName(new javax.xml.namespace.QName("", "validatorRule"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("standard");
        elemField.setXmlName(new javax.xml.namespace.QName("", "standard"));
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
        elemField.setFieldName("orderFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "orderFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lookupLayout");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lookupLayout"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("labelField");
        elemField.setXmlName(new javax.xml.namespace.QName("", "labelField"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);

        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sysListLayoutGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sysListLayoutGroup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sysFormLayoutGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sysFormLayoutGroup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sysFieldGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sysFieldGroup"));
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
