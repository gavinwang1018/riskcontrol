package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
    /**
     *  ������SysUserRole.
     */
public class SysUserRole implements Serializable {
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���userId.
     */
    private java.lang.String userId;

    /**
     *  �ֶ���roleId.
     */
    private java.lang.String roleId;

    /**
     *  �ֶ���partyId.
     */
    private java.lang.String partyId;


    /**
     *  ��userIdOfSysUser.
     */
    private SysUser userIdOfSysUser;
    /**
     *  ��roleIdOfSysRole.
     */
    private SysRole roleIdOfSysRole;
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
     *  ��ȡ roleId.
     *  @return java.lang.String.
     */
    public java.lang.String getRoleId() {
        return this.roleId;
    }

    /**
     *  ���� roleId.
     *  @param roleId roleId��.
     */
    public void setRoleId(java.lang.String roleId) {
        this.roleId = roleId;
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
     *  ��ȡ userIdOfSysUser.
     *  @return SysUser.
     */
    public SysUser getUserIdOfSysUser() {
        return this.userIdOfSysUser;
    }

    /**
     *  ���� userIdOfSysUser.
     *  @param userIdOfSysUser userIdOfSysUser��.
     */
    public void setUserIdOfSysUser(SysUser userIdOfSysUser) {
        this.userIdOfSysUser = userIdOfSysUser;
    }

    /**
     *  ��ȡ roleIdOfSysRole.
     *  @return SysRole.
     */
    public SysRole getRoleIdOfSysRole() {
        return this.roleIdOfSysRole;
    }

    /**
     *  ���� roleIdOfSysRole.
     *  @param roleIdOfSysRole roleIdOfSysRole��.
     */
    public void setRoleIdOfSysRole(SysRole roleIdOfSysRole) {
        this.roleIdOfSysRole = roleIdOfSysRole;
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
        new org.apache.axis.description.TypeDesc(SysUserRole.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysUserRole"));
        org.apache.axis.description.ElementDesc elemField = null;        


        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
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
        elemField.setFieldName("roleId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "roleId"));
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
        elemField.setFieldName("roleIdOfSysRole");
        elemField.setXmlName(new javax.xml.namespace.QName("", "roleIdOfSysRole"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysRole"));
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
