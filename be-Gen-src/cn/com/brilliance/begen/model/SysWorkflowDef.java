package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
    /**
     *  定义类SysWorkflowDef.
     */
public class SysWorkflowDef implements Serializable {
    /**
     *  字段域id.
     */
    private java.lang.String id;

    /**
     *  字段域workflowName.
     */
    private java.lang.String workflowName;

    /**
     *  字段域workflowLabel.
     */
    private java.lang.String workflowLabel;

    /**
     *  字段域dataObject.
     */
    private java.lang.String dataObject;

/*
0,结束
1,退回申请人
2,退回上级审批人
*/
    /**
     *  字段域rollBack.
     */
    private java.lang.String rollBack;

    /**
     *  字段域historyLayout.
     */
    private java.lang.String historyLayout;

    /**
     *  字段域partyId.
     */
    private java.lang.String partyId;

    /**
     *  集合域sysWorkflowStateGroup.
     */
    private Set sysWorkflowStateGroup;


    /**
     *  域dataObjectOfSysDataObject.
     */
    private SysDataObject dataObjectOfSysDataObject;
    /**
     *  域historyLayoutOfSysFormLayout.
     */
    private SysFormLayout historyLayoutOfSysFormLayout;
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
     *  获取 workflowName.
     *  @return java.lang.String.
     */
    public java.lang.String getWorkflowName() {
        return this.workflowName;
    }

    /**
     *  设置 workflowName.
     *  @param workflowName workflowName域.
     */
    public void setWorkflowName(java.lang.String workflowName) {
        this.workflowName = workflowName;
    }
    /**
     *  获取 workflowLabel.
     *  @return java.lang.String.
     */
    public java.lang.String getWorkflowLabel() {
        return this.workflowLabel;
    }

    /**
     *  设置 workflowLabel.
     *  @param workflowLabel workflowLabel域.
     */
    public void setWorkflowLabel(java.lang.String workflowLabel) {
        this.workflowLabel = workflowLabel;
    }
    /**
     *  获取 dataObject.
     *  @return java.lang.String.
     */
    public java.lang.String getDataObject() {
        return this.dataObject;
    }

    /**
     *  设置 dataObject.
     *  @param dataObject dataObject域.
     */
    public void setDataObject(java.lang.String dataObject) {
        this.dataObject = dataObject;
    }
    /**
     *  获取 rollBack.
     *  @return java.lang.String.
     */
    public java.lang.String getRollBack() {
        return this.rollBack;
    }

    /**
     *  设置 rollBack.
     *  @param rollBack rollBack域.
     */
    public void setRollBack(java.lang.String rollBack) {
        this.rollBack = rollBack;
    }
    /**
     *  获取 historyLayout.
     *  @return java.lang.String.
     */
    public java.lang.String getHistoryLayout() {
        return this.historyLayout;
    }

    /**
     *  设置 historyLayout.
     *  @param historyLayout historyLayout域.
     */
    public void setHistoryLayout(java.lang.String historyLayout) {
        this.historyLayout = historyLayout;
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
     *  获取 sysWorkflowStateGroup.
     *  @return Set.
     */
    public Set getSysWorkflowStateGroup() {
        return this.sysWorkflowStateGroup;
    }

    /**
     *  设置 sysWorkflowStateGroup.
     *  @param sysWorkflowStateGroup sysWorkflowStateGroup域.
     */
    public void setSysWorkflowStateGroup(Set sysWorkflowStateGroup) {
        this.sysWorkflowStateGroup = sysWorkflowStateGroup;
    }

    /**
     *  获取 dataObjectOfSysDataObject.
     *  @return SysDataObject.
     */
    public SysDataObject getDataObjectOfSysDataObject() {
        return this.dataObjectOfSysDataObject;
    }

    /**
     *  设置 dataObjectOfSysDataObject.
     *  @param dataObjectOfSysDataObject dataObjectOfSysDataObject域.
     */
    public void setDataObjectOfSysDataObject(SysDataObject dataObjectOfSysDataObject) {
        this.dataObjectOfSysDataObject = dataObjectOfSysDataObject;
    }

    /**
     *  获取 historyLayoutOfSysFormLayout.
     *  @return SysFormLayout.
     */
    public SysFormLayout getHistoryLayoutOfSysFormLayout() {
        return this.historyLayoutOfSysFormLayout;
    }

    /**
     *  设置 historyLayoutOfSysFormLayout.
     *  @param historyLayoutOfSysFormLayout historyLayoutOfSysFormLayout域.
     */
    public void setHistoryLayoutOfSysFormLayout(SysFormLayout historyLayoutOfSysFormLayout) {
        this.historyLayoutOfSysFormLayout = historyLayoutOfSysFormLayout;
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
