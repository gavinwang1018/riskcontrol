package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;

    /**
     *  定义类SysDataObject.
     */
public class SysDataObject implements Serializable {
    /**
     *  字段域id.
     */
    private java.lang.String id;

    /**
     *  字段域name.
     */
    private java.lang.String name;

    /**
     *  字段域label.
     */
    private java.lang.String label;

    /**
     *  字段域description.
     */
    private java.lang.String description;

/*
0,公共
1,本人
2,指定机构共享
3,指定角色共享
4,指定机构和角色共享
*/
    /**
     *  字段域shareFlag.
     */
    private java.lang.String shareFlag;

    /**
     *  字段域shareRole.
     */
    private java.lang.String shareRole;

/*
0,本机构
1,上级机构
2,下级机构
*/
    /**
     *  字段域shareOrg.
     */
    private java.lang.String shareOrg;

    /**
     *  字段域validatorRule.
     */
    private java.lang.String validatorRule;

    /**
     *  字段域standard.
     */
    private java.lang.Boolean standard;

    /**
     *  字段域partyId.
     */
    private java.lang.String partyId;

    /**
     *  字段域orderFlag.
     */
    private java.lang.Boolean orderFlag;

/*
@extSelectItems.lookupLayoutItems
*/
    /**
     *  字段域lookupLayout.
     */
    private java.lang.String lookupLayout;

/*
@extSelectItems.fieldsItems
*/
    /**
     *  字段域labelField.
     */
    private java.lang.String labelField;

    /**
     *  集合域sysListLayoutGroup.
     */
    private Set sysListLayoutGroup;

    /**
     *  集合域sysFormLayoutGroup.
     */
    private Set sysFormLayoutGroup;

    /**
     *  集合域sysFieldGroup.
     */
    private Set sysFieldGroup;


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
     *  获取 name.
     *  @return java.lang.String.
     */
    public java.lang.String getName() {
        return this.name;
    }

    /**
     *  设置 name.
     *  @param name name域.
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }
    /**
     *  获取 label.
     *  @return java.lang.String.
     */
    public java.lang.String getLabel() {
        return this.label;
    }

    /**
     *  设置 label.
     *  @param label label域.
     */
    public void setLabel(java.lang.String label) {
        this.label = label;
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
     *  获取 shareFlag.
     *  @return java.lang.String.
     */
    public java.lang.String getShareFlag() {
        return this.shareFlag;
    }

    /**
     *  设置 shareFlag.
     *  @param shareFlag shareFlag域.
     */
    public void setShareFlag(java.lang.String shareFlag) {
        this.shareFlag = shareFlag;
    }
    /**
     *  获取 shareRole.
     *  @return java.lang.String.
     */
    public java.lang.String getShareRole() {
        return this.shareRole;
    }

    /**
     *  设置 shareRole.
     *  @param shareRole shareRole域.
     */
    public void setShareRole(java.lang.String shareRole) {
        this.shareRole = shareRole;
    }
    /**
     *  获取 shareOrg.
     *  @return java.lang.String.
     */
    public java.lang.String getShareOrg() {
        return this.shareOrg;
    }

    /**
     *  设置 shareOrg.
     *  @param shareOrg shareOrg域.
     */
    public void setShareOrg(java.lang.String shareOrg) {
        this.shareOrg = shareOrg;
    }
    /**
     *  获取 validatorRule.
     *  @return java.lang.String.
     */
    public java.lang.String getValidatorRule() {
        return this.validatorRule;
    }

    /**
     *  设置 validatorRule.
     *  @param validatorRule validatorRule域.
     */
    public void setValidatorRule(java.lang.String validatorRule) {
        this.validatorRule = validatorRule;
    }
    /**
     *  获取 standard.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getStandard() {
        return this.standard;
    }

    /**
     *  设置 standard.
     *  @param standard standard域.
     */
    public void setStandard(java.lang.Boolean standard) {
        this.standard = standard;
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
     *  获取 orderFlag.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getOrderFlag() {
        return this.orderFlag;
    }

    /**
     *  设置 orderFlag.
     *  @param orderFlag orderFlag域.
     */
    public void setOrderFlag(java.lang.Boolean orderFlag) {
        this.orderFlag = orderFlag;
    }
    /**
     *  获取 lookupLayout.
     *  @return java.lang.String.
     */
    public java.lang.String getLookupLayout() {
        return this.lookupLayout;
    }

    /**
     *  设置 lookupLayout.
     *  @param lookupLayout lookupLayout域.
     */
    public void setLookupLayout(java.lang.String lookupLayout) {
        this.lookupLayout = lookupLayout;
    }
    /**
     *  获取 labelField.
     *  @return java.lang.String.
     */
    public java.lang.String getLabelField() {
        return this.labelField;
    }

    /**
     *  设置 labelField.
     *  @param labelField labelField域.
     */
    public void setLabelField(java.lang.String labelField) {
        this.labelField = labelField;
    }

    /**
     *  获取 sysListLayoutGroup.
     *  @return Set.
     */
    public Set getSysListLayoutGroup() {
        return this.sysListLayoutGroup;
    }

    /**
     *  设置 sysListLayoutGroup.
     *  @param sysListLayoutGroup sysListLayoutGroup域.
     */
    public void setSysListLayoutGroup(Set sysListLayoutGroup) {
        this.sysListLayoutGroup = sysListLayoutGroup;
    }
    /**
     *  获取 sysFormLayoutGroup.
     *  @return Set.
     */
    public Set getSysFormLayoutGroup() {
        return this.sysFormLayoutGroup;
    }

    /**
     *  设置 sysFormLayoutGroup.
     *  @param sysFormLayoutGroup sysFormLayoutGroup域.
     */
    public void setSysFormLayoutGroup(Set sysFormLayoutGroup) {
        this.sysFormLayoutGroup = sysFormLayoutGroup;
    }
    /**
     *  获取 sysFieldGroup.
     *  @return Set.
     */
    public Set getSysFieldGroup() {
        return this.sysFieldGroup;
    }

    /**
     *  设置 sysFieldGroup.
     *  @param sysFieldGroup sysFieldGroup域.
     */
    public void setSysFieldGroup(Set sysFieldGroup) {
        this.sysFieldGroup = sysFieldGroup;
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
