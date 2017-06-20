package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
    /**
     *  ������SysUserAuthority.
     */
public class SysUserAuthority implements Serializable {
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���actionId.
     */
    private java.lang.String actionId;

    /**
     *  �ֶ���userId.
     */
    private java.lang.String userId;

/*
0,�༭�����ֶ���
1,�б��ֱ�����
2,�б�����ϸ��¼����
3,���ı����ֶ���
4,Ӧ����
5,�˵�
*/
    /**
     *  �ֶ���authorityType.
     */
    private java.lang.String authorityType;

    /**
     *  �ֶ���partyId.
     */
    private java.lang.String partyId;

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
     *  ��ȡ actionId.
     *  @return java.lang.String.
     */
    public java.lang.String getActionId() {
        return this.actionId;
    }

    /**
     *  ���� actionId.
     *  @param actionId actionId��.
     */
    public void setActionId(java.lang.String actionId) {
        this.actionId = actionId;
    }
    /**
     *  ��ȡ userId.
     *  @return java.lang.String.
     */
    public java.lang.String getUserId() {
        return this.userId;
    }

    /**
     *  ���� userId.
     *  @param userId userId��.
     */
    public void setUserId(java.lang.String userId) {
        this.userId = userId;
    }
    /**
     *  ��ȡ authorityType.
     *  @return java.lang.String.
     */
    public java.lang.String getAuthorityType() {
        return this.authorityType;
    }

    /**
     *  ���� authorityType.
     *  @param authorityType authorityType��.
     */
    public void setAuthorityType(java.lang.String authorityType) {
        this.authorityType = authorityType;
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

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SysUserAuthority.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysUserAuthority"));
        org.apache.axis.description.ElementDesc elemField = null;        


        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("actionId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "actionId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authorityType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "authorityType"));
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
        elemField.setFieldName("userIdOfSysUser");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userIdOfSysUser"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysUser"));
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
