package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
    /**
     *  定义类SysWorkflowState.
     */
public class SysWorkflowState implements Serializable {
    /**
     *  字段域id.
     */
    private java.lang.String id;

    /**
     *  字段域receiptUser.
     */
    private java.lang.String receiptUser;

    /**
     *  字段域receiptRole.
     */
    private java.lang.String receiptRole;

    /**
     *  字段域receiptOrg.
     */
    private java.lang.String receiptOrg;

/*
1,编辑
2,浏览
*/
    /**
     *  字段域layoutType.
     */
    private java.lang.String layoutType;

    /**
     *  字段域formLayout.
     */
    private java.lang.String formLayout;

/*
0,发起
1,一级审批
2,二级审批
*/
    /**
     *  字段域authLevel.
     */
    private java.lang.String authLevel;

    /**
     *  字段域workflowId.
     */
    private java.lang.String workflowId;

    /**
     *  字段域partyId.
     */
    private java.lang.String partyId;

    /**
     *  字段域title.
     */
    private java.lang.String title;


    /**
     *  域formLayoutOfSysFormLayout.
     */
    private SysFormLayout formLayoutOfSysFormLayout;
    /**
     *  域workflowIdOfSysWorkflowDef.
     */
    private SysWorkflowDef workflowIdOfSysWorkflowDef;
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
     *  获取 receiptUser.
     *  @return java.lang.String.
     */
    public java.lang.String getReceiptUser() {
        return this.receiptUser;
    }

    /**
     *  设置 receiptUser.
     *  @param receiptUser receiptUser域.
     */
    public void setReceiptUser(java.lang.String receiptUser) {
        this.receiptUser = receiptUser;
    }
    /**
     *  获取 receiptRole.
     *  @return java.lang.String.
     */
    public java.lang.String getReceiptRole() {
        return this.receiptRole;
    }

    /**
     *  设置 receiptRole.
     *  @param receiptRole receiptRole域.
     */
    public void setReceiptRole(java.lang.String receiptRole) {
        this.receiptRole = receiptRole;
    }
    /**
     *  获取 receiptOrg.
     *  @return java.lang.String.
     */
    public java.lang.String getReceiptOrg() {
        return this.receiptOrg;
    }

    /**
     *  设置 receiptOrg.
     *  @param receiptOrg receiptOrg域.
     */
    public void setReceiptOrg(java.lang.String receiptOrg) {
        this.receiptOrg = receiptOrg;
    }
    /**
     *  获取 layoutType.
     *  @return java.lang.String.
     */
    public java.lang.String getLayoutType() {
        return this.layoutType;
    }

    /**
     *  设置 layoutType.
     *  @param layoutType layoutType域.
     */
    public void setLayoutType(java.lang.String layoutType) {
        this.layoutType = layoutType;
    }
    /**
     *  获取 formLayout.
     *  @return java.lang.String.
     */
    public java.lang.String getFormLayout() {
        return this.formLayout;
    }

    /**
     *  设置 formLayout.
     *  @param formLayout formLayout域.
     */
    public void setFormLayout(java.lang.String formLayout) {
        this.formLayout = formLayout;
    }
    /**
     *  获取 authLevel.
     *  @return java.lang.String.
     */
    public java.lang.String getAuthLevel() {
        return this.authLevel;
    }

    /**
     *  设置 authLevel.
     *  @param authLevel authLevel域.
     */
    public void setAuthLevel(java.lang.String authLevel) {
        this.authLevel = authLevel;
    }
    /**
     *  获取 workflowId.
     *  @return java.lang.String.
     */
    public java.lang.String getWorkflowId() {
        return this.workflowId;
    }

    /**
     *  设置 workflowId.
     *  @param workflowId workflowId域.
     */
    public void setWorkflowId(java.lang.String workflowId) {
        this.workflowId = workflowId;
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
     *  获取 title.
     *  @return java.lang.String.
     */
    public java.lang.String getTitle() {
        return this.title;
    }

    /**
     *  设置 title.
     *  @param title title域.
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }


    /**
     *  获取 formLayoutOfSysFormLayout.
     *  @return SysFormLayout.
     */
    public SysFormLayout getFormLayoutOfSysFormLayout() {
        return this.formLayoutOfSysFormLayout;
    }

    /**
     *  设置 formLayoutOfSysFormLayout.
     *  @param formLayoutOfSysFormLayout formLayoutOfSysFormLayout域.
     */
    public void setFormLayoutOfSysFormLayout(SysFormLayout formLayoutOfSysFormLayout) {
        this.formLayoutOfSysFormLayout = formLayoutOfSysFormLayout;
    }

    /**
     *  获取 workflowIdOfSysWorkflowDef.
     *  @return SysWorkflowDef.
     */
    public SysWorkflowDef getWorkflowIdOfSysWorkflowDef() {
        return this.workflowIdOfSysWorkflowDef;
    }

    /**
     *  设置 workflowIdOfSysWorkflowDef.
     *  @param workflowIdOfSysWorkflowDef workflowIdOfSysWorkflowDef域.
     */
    public void setWorkflowIdOfSysWorkflowDef(SysWorkflowDef workflowIdOfSysWorkflowDef) {
        this.workflowIdOfSysWorkflowDef = workflowIdOfSysWorkflowDef;
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
        new org.apache.axis.description.TypeDesc(SysWorkflowState.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysWorkflowState"));
        org.apache.axis.description.ElementDesc elemField = null;        


        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receiptUser");
        elemField.setXmlName(new javax.xml.namespace.QName("", "receiptUser"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receiptRole");
        elemField.setXmlName(new javax.xml.namespace.QName("", "receiptRole"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receiptOrg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "receiptOrg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("layoutType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "layoutType"));
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
        elemField.setFieldName("authLevel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "authLevel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("workflowId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "workflowId"));
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
        elemField.setFieldName("title");
        elemField.setXmlName(new javax.xml.namespace.QName("", "title"));
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
        elemField.setFieldName("workflowIdOfSysWorkflowDef");
        elemField.setXmlName(new javax.xml.namespace.QName("", "workflowIdOfSysWorkflowDef"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysWorkflowDef"));
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
