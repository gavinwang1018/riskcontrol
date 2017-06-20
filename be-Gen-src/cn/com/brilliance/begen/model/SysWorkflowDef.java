package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
    /**
     *  ������SysWorkflowDef.
     */
public class SysWorkflowDef implements Serializable {
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���workflowName.
     */
    private java.lang.String workflowName;

    /**
     *  �ֶ���workflowLabel.
     */
    private java.lang.String workflowLabel;

    /**
     *  �ֶ���dataObject.
     */
    private java.lang.String dataObject;

/*
0,����
1,�˻�������
2,�˻��ϼ�������
*/
    /**
     *  �ֶ���rollBack.
     */
    private java.lang.String rollBack;

    /**
     *  �ֶ���historyLayout.
     */
    private java.lang.String historyLayout;

    /**
     *  �ֶ���partyId.
     */
    private java.lang.String partyId;

    /**
     *  ������sysWorkflowStateGroup.
     */
    private Set sysWorkflowStateGroup;


    /**
     *  ��dataObjectOfSysDataObject.
     */
    private SysDataObject dataObjectOfSysDataObject;
    /**
     *  ��historyLayoutOfSysFormLayout.
     */
    private SysFormLayout historyLayoutOfSysFormLayout;
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
     *  ��ȡ workflowName.
     *  @return java.lang.String.
     */
    public java.lang.String getWorkflowName() {
        return this.workflowName;
    }

    /**
     *  ���� workflowName.
     *  @param workflowName workflowName��.
     */
    public void setWorkflowName(java.lang.String workflowName) {
        this.workflowName = workflowName;
    }
    /**
     *  ��ȡ workflowLabel.
     *  @return java.lang.String.
     */
    public java.lang.String getWorkflowLabel() {
        return this.workflowLabel;
    }

    /**
     *  ���� workflowLabel.
     *  @param workflowLabel workflowLabel��.
     */
    public void setWorkflowLabel(java.lang.String workflowLabel) {
        this.workflowLabel = workflowLabel;
    }
    /**
     *  ��ȡ dataObject.
     *  @return java.lang.String.
     */
    public java.lang.String getDataObject() {
        return this.dataObject;
    }

    /**
     *  ���� dataObject.
     *  @param dataObject dataObject��.
     */
    public void setDataObject(java.lang.String dataObject) {
        this.dataObject = dataObject;
    }
    /**
     *  ��ȡ rollBack.
     *  @return java.lang.String.
     */
    public java.lang.String getRollBack() {
        return this.rollBack;
    }

    /**
     *  ���� rollBack.
     *  @param rollBack rollBack��.
     */
    public void setRollBack(java.lang.String rollBack) {
        this.rollBack = rollBack;
    }
    /**
     *  ��ȡ historyLayout.
     *  @return java.lang.String.
     */
    public java.lang.String getHistoryLayout() {
        return this.historyLayout;
    }

    /**
     *  ���� historyLayout.
     *  @param historyLayout historyLayout��.
     */
    public void setHistoryLayout(java.lang.String historyLayout) {
        this.historyLayout = historyLayout;
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
     *  ��ȡ sysWorkflowStateGroup.
     *  @return Set.
     */
    public Set getSysWorkflowStateGroup() {
        return this.sysWorkflowStateGroup;
    }

    /**
     *  ���� sysWorkflowStateGroup.
     *  @param sysWorkflowStateGroup sysWorkflowStateGroup��.
     */
    public void setSysWorkflowStateGroup(Set sysWorkflowStateGroup) {
        this.sysWorkflowStateGroup = sysWorkflowStateGroup;
    }

    /**
     *  ��ȡ dataObjectOfSysDataObject.
     *  @return SysDataObject.
     */
    public SysDataObject getDataObjectOfSysDataObject() {
        return this.dataObjectOfSysDataObject;
    }

    /**
     *  ���� dataObjectOfSysDataObject.
     *  @param dataObjectOfSysDataObject dataObjectOfSysDataObject��.
     */
    public void setDataObjectOfSysDataObject(SysDataObject dataObjectOfSysDataObject) {
        this.dataObjectOfSysDataObject = dataObjectOfSysDataObject;
    }

    /**
     *  ��ȡ historyLayoutOfSysFormLayout.
     *  @return SysFormLayout.
     */
    public SysFormLayout getHistoryLayoutOfSysFormLayout() {
        return this.historyLayoutOfSysFormLayout;
    }

    /**
     *  ���� historyLayoutOfSysFormLayout.
     *  @param historyLayoutOfSysFormLayout historyLayoutOfSysFormLayout��.
     */
    public void setHistoryLayoutOfSysFormLayout(SysFormLayout historyLayoutOfSysFormLayout) {
        this.historyLayoutOfSysFormLayout = historyLayoutOfSysFormLayout;
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
        new org.apache.axis.description.TypeDesc(SysWorkflowDef.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysWorkflowDef"));
        org.apache.axis.description.ElementDesc elemField = null;        


        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("workflowName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "workflowName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("workflowLabel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "workflowLabel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataObject");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataObject"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rollBack");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rollBack"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("historyLayout");
        elemField.setXmlName(new javax.xml.namespace.QName("", "historyLayout"));
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
        elemField.setFieldName("sysWorkflowStateGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sysWorkflowStateGroup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);

        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataObjectOfSysDataObject");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataObjectOfSysDataObject"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysDataObject"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("historyLayoutOfSysFormLayout");
        elemField.setXmlName(new javax.xml.namespace.QName("", "historyLayoutOfSysFormLayout"));
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
