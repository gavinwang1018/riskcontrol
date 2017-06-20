package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
    /**
     *  ������SysWorkflowState.
     */
public class SysWorkflowState implements Serializable {
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���receiptUser.
     */
    private java.lang.String receiptUser;

    /**
     *  �ֶ���receiptRole.
     */
    private java.lang.String receiptRole;

    /**
     *  �ֶ���receiptOrg.
     */
    private java.lang.String receiptOrg;

/*
1,�༭
2,���
*/
    /**
     *  �ֶ���layoutType.
     */
    private java.lang.String layoutType;

    /**
     *  �ֶ���formLayout.
     */
    private java.lang.String formLayout;

/*
0,����
1,һ������
2,��������
*/
    /**
     *  �ֶ���authLevel.
     */
    private java.lang.String authLevel;

    /**
     *  �ֶ���workflowId.
     */
    private java.lang.String workflowId;

    /**
     *  �ֶ���partyId.
     */
    private java.lang.String partyId;

    /**
     *  �ֶ���title.
     */
    private java.lang.String title;


    /**
     *  ��formLayoutOfSysFormLayout.
     */
    private SysFormLayout formLayoutOfSysFormLayout;
    /**
     *  ��workflowIdOfSysWorkflowDef.
     */
    private SysWorkflowDef workflowIdOfSysWorkflowDef;
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
     *  ��ȡ receiptUser.
     *  @return java.lang.String.
     */
    public java.lang.String getReceiptUser() {
        return this.receiptUser;
    }

    /**
     *  ���� receiptUser.
     *  @param receiptUser receiptUser��.
     */
    public void setReceiptUser(java.lang.String receiptUser) {
        this.receiptUser = receiptUser;
    }
    /**
     *  ��ȡ receiptRole.
     *  @return java.lang.String.
     */
    public java.lang.String getReceiptRole() {
        return this.receiptRole;
    }

    /**
     *  ���� receiptRole.
     *  @param receiptRole receiptRole��.
     */
    public void setReceiptRole(java.lang.String receiptRole) {
        this.receiptRole = receiptRole;
    }
    /**
     *  ��ȡ receiptOrg.
     *  @return java.lang.String.
     */
    public java.lang.String getReceiptOrg() {
        return this.receiptOrg;
    }

    /**
     *  ���� receiptOrg.
     *  @param receiptOrg receiptOrg��.
     */
    public void setReceiptOrg(java.lang.String receiptOrg) {
        this.receiptOrg = receiptOrg;
    }
    /**
     *  ��ȡ layoutType.
     *  @return java.lang.String.
     */
    public java.lang.String getLayoutType() {
        return this.layoutType;
    }

    /**
     *  ���� layoutType.
     *  @param layoutType layoutType��.
     */
    public void setLayoutType(java.lang.String layoutType) {
        this.layoutType = layoutType;
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
     *  ��ȡ authLevel.
     *  @return java.lang.String.
     */
    public java.lang.String getAuthLevel() {
        return this.authLevel;
    }

    /**
     *  ���� authLevel.
     *  @param authLevel authLevel��.
     */
    public void setAuthLevel(java.lang.String authLevel) {
        this.authLevel = authLevel;
    }
    /**
     *  ��ȡ workflowId.
     *  @return java.lang.String.
     */
    public java.lang.String getWorkflowId() {
        return this.workflowId;
    }

    /**
     *  ���� workflowId.
     *  @param workflowId workflowId��.
     */
    public void setWorkflowId(java.lang.String workflowId) {
        this.workflowId = workflowId;
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
     *  ��ȡ title.
     *  @return java.lang.String.
     */
    public java.lang.String getTitle() {
        return this.title;
    }

    /**
     *  ���� title.
     *  @param title title��.
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
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
     *  ��ȡ workflowIdOfSysWorkflowDef.
     *  @return SysWorkflowDef.
     */
    public SysWorkflowDef getWorkflowIdOfSysWorkflowDef() {
        return this.workflowIdOfSysWorkflowDef;
    }

    /**
     *  ���� workflowIdOfSysWorkflowDef.
     *  @param workflowIdOfSysWorkflowDef workflowIdOfSysWorkflowDef��.
     */
    public void setWorkflowIdOfSysWorkflowDef(SysWorkflowDef workflowIdOfSysWorkflowDef) {
        this.workflowIdOfSysWorkflowDef = workflowIdOfSysWorkflowDef;
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
