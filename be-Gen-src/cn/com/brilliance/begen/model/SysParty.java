package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;

    /**
     *  ������SysParty.
     */
public class SysParty implements Serializable {
    /**
     *  �ֶ���partyId.
     */
    private java.lang.String partyId;

    /**
     *  �ֶ���partyName.
     */
    private java.lang.String partyName;

    /**
     *  �ֶ���databaseName.
     */
    private java.lang.String databaseName;

    /**
     *  �ֶ���lastDeployTime.
     */
    private java.util.Date lastDeployTime;

    /**
     *  �ֶ���contractPerson.
     */
    private java.lang.String contractPerson;

    /**
     *  �ֶ���email.
     */
    private java.lang.String email;

    /**
     *  �ֶ���phone.
     */
    private java.lang.String phone;

/*
5,С�� 8 ��
15,8 - 20 ��
60,21 - 100 ��
150,101 - 200 ��
300,201 - 400 ��
450,401 - 500 ��
625,501 - 750 ��
875,751 - 1,000 ��
1500,1,000 - 2,000 ��
5000,���� 2,000 ��
*/
    /**
     *  �ֶ���userNumber.
     */
    private java.lang.String userNumber;

    /**
     *  �ֶ���openFlag.
     */
    private java.lang.Boolean openFlag;

    /**
     *  �ֶ���remark.
     */
    private java.lang.String remark;

    /**
     *  �ֶ���logo.
     */
    private java.lang.String logo;

    /**
     *  �ֶ���developMode.
     */
    private java.lang.Boolean developMode;

    /**
     *  �ֶ���enableCa.
     */
    private java.lang.Boolean enableCa;

    /**
     *  �ֶ���sendCa.
     */
    private java.lang.Boolean sendCa;

    /**
     *  �ֶ���version.
     */
    private java.lang.String version;

    /**
     *  �ֶ���deskey.
     */
    private java.lang.String deskey;

    /**
     *  �ֶ���dbSpace.
     */
    private java.lang.Integer dbSpace;

    /**
     *  �ֶ���indexSpace.
     */
    private java.lang.Integer indexSpace;

    /**
     *  �ֶ���uploadSpace.
     */
    private java.lang.Integer uploadSpace;

    /**
     *  �ֶ���totalSpace.
     */
    private java.lang.Integer totalSpace;

/*
01,������Ӫ
02,��������
03,��桢���ؼ������ҵ
04,���С����պͽ��ڷ���
05,��װ�ͷ�֯
06,IT
07,�����Ӳ��
08,ϵͳ������
09,��������
10,������
11,���ز���������װ�
12,����ҵ
13,�����͹�����ҵ
14,��ѯ
15,��������ѵ
16,����(�������е)
17,���֡��˶�������
18,ũҵ, ��ҵ����ҵ
19,������ҵ
20,���䡢�����Ϳ��
21,���κͷ���
22,����Ʒ
23,ʳƷ�����Ϻ��̲�
24,ҽ�Ʊ���
25,�ع�ҵ
26,�ҵ�
27,������
28,��ҵ�Զ���
29,���ɷ���
31,�������㲥������͵���
32,��ҩ�����������﹤��
33,��Դ
33,���ۡ������������ó��
34,����
35,�����豸����Ӱ����
36,������ʯ��
37,����
38,ͨѶ����
39,���պͺ���
40,ϵͳ����
41,��������
42,����
*/
    /**
     *  �ֶ���industry.
     */
    private java.lang.String industry;

/*
001,����
002,�Ϻ�
003,���
004,����
005,���
006,����
007,�ӱ�
008,ɽ��
009,ɽ��
010,����
011,����
012,�㽭
013,����
014,����
015,����
016,����
017,����
018,�Ĵ�
019,����
020,����
021,����
022,�㶫
023,����
024,����
025,����
026,����
027,����
028,̨��
029,�ຣ
030,����
031,����
032,�½�
033,����
034,����
*/
    /**
     *  �ֶ���area.
     */
    private java.lang.String area;




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
     *  ��ȡ partyName.
     *  @return java.lang.String.
     */
    public java.lang.String getPartyName() {
        return this.partyName;
    }

    /**
     *  ���� partyName.
     *  @param partyName partyName��.
     */
    public void setPartyName(java.lang.String partyName) {
        this.partyName = partyName;
    }
    /**
     *  ��ȡ databaseName.
     *  @return java.lang.String.
     */
    public java.lang.String getDatabaseName() {
        return this.databaseName;
    }

    /**
     *  ���� databaseName.
     *  @param databaseName databaseName��.
     */
    public void setDatabaseName(java.lang.String databaseName) {
        this.databaseName = databaseName;
    }
    /**
     *  ��ȡ lastDeployTime.
     *  @return java.util.Date.
     */
    public java.util.Date getLastDeployTime() {
        return this.lastDeployTime;
    }

    /**
     *  ���� lastDeployTime.
     *  @param lastDeployTime lastDeployTime��.
     */
    public void setLastDeployTime(java.util.Date lastDeployTime) {
        this.lastDeployTime = lastDeployTime;
    }
    /**
     *  ��ȡ contractPerson.
     *  @return java.lang.String.
     */
    public java.lang.String getContractPerson() {
        return this.contractPerson;
    }

    /**
     *  ���� contractPerson.
     *  @param contractPerson contractPerson��.
     */
    public void setContractPerson(java.lang.String contractPerson) {
        this.contractPerson = contractPerson;
    }
    /**
     *  ��ȡ email.
     *  @return java.lang.String.
     */
    public java.lang.String getEmail() {
        return this.email;
    }

    /**
     *  ���� email.
     *  @param email email��.
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }
    /**
     *  ��ȡ phone.
     *  @return java.lang.String.
     */
    public java.lang.String getPhone() {
        return this.phone;
    }

    /**
     *  ���� phone.
     *  @param phone phone��.
     */
    public void setPhone(java.lang.String phone) {
        this.phone = phone;
    }
    /**
     *  ��ȡ userNumber.
     *  @return java.lang.String.
     */
    public java.lang.String getUserNumber() {
        return this.userNumber;
    }

    /**
     *  ���� userNumber.
     *  @param userNumber userNumber��.
     */
    public void setUserNumber(java.lang.String userNumber) {
        this.userNumber = userNumber;
    }
    /**
     *  ��ȡ openFlag.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getOpenFlag() {
        return this.openFlag;
    }

    /**
     *  ���� openFlag.
     *  @param openFlag openFlag��.
     */
    public void setOpenFlag(java.lang.Boolean openFlag) {
        this.openFlag = openFlag;
    }
    /**
     *  ��ȡ remark.
     *  @return java.lang.String.
     */
    public java.lang.String getRemark() {
        return this.remark;
    }

    /**
     *  ���� remark.
     *  @param remark remark��.
     */
    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }
    /**
     *  ��ȡ logo.
     *  @return java.lang.String.
     */
    public java.lang.String getLogo() {
        return this.logo;
    }

    /**
     *  ���� logo.
     *  @param logo logo��.
     */
    public void setLogo(java.lang.String logo) {
        this.logo = logo;
    }
    /**
     *  ��ȡ developMode.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getDevelopMode() {
        return this.developMode;
    }

    /**
     *  ���� developMode.
     *  @param developMode developMode��.
     */
    public void setDevelopMode(java.lang.Boolean developMode) {
        this.developMode = developMode;
    }
    /**
     *  ��ȡ enableCa.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getEnableCa() {
        return this.enableCa;
    }

    /**
     *  ���� enableCa.
     *  @param enableCa enableCa��.
     */
    public void setEnableCa(java.lang.Boolean enableCa) {
        this.enableCa = enableCa;
    }
    /**
     *  ��ȡ sendCa.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getSendCa() {
        return this.sendCa;
    }

    /**
     *  ���� sendCa.
     *  @param sendCa sendCa��.
     */
    public void setSendCa(java.lang.Boolean sendCa) {
        this.sendCa = sendCa;
    }
    /**
     *  ��ȡ version.
     *  @return java.lang.String.
     */
    public java.lang.String getVersion() {
        return this.version;
    }

    /**
     *  ���� version.
     *  @param version version��.
     */
    public void setVersion(java.lang.String version) {
        this.version = version;
    }
    /**
     *  ��ȡ deskey.
     *  @return java.lang.String.
     */
    public java.lang.String getDeskey() {
        return this.deskey;
    }

    /**
     *  ���� deskey.
     *  @param deskey deskey��.
     */
    public void setDeskey(java.lang.String deskey) {
        this.deskey = deskey;
    }
    /**
     *  ��ȡ dbSpace.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getDbSpace() {
        return this.dbSpace;
    }

    /**
     *  ���� dbSpace.
     *  @param dbSpace dbSpace��.
     */
    public void setDbSpace(java.lang.Integer dbSpace) {
        this.dbSpace = dbSpace;
    }
    /**
     *  ��ȡ indexSpace.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getIndexSpace() {
        return this.indexSpace;
    }

    /**
     *  ���� indexSpace.
     *  @param indexSpace indexSpace��.
     */
    public void setIndexSpace(java.lang.Integer indexSpace) {
        this.indexSpace = indexSpace;
    }
    /**
     *  ��ȡ uploadSpace.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getUploadSpace() {
        return this.uploadSpace;
    }

    /**
     *  ���� uploadSpace.
     *  @param uploadSpace uploadSpace��.
     */
    public void setUploadSpace(java.lang.Integer uploadSpace) {
        this.uploadSpace = uploadSpace;
    }
    /**
     *  ��ȡ totalSpace.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getTotalSpace() {
        return this.totalSpace;
    }

    /**
     *  ���� totalSpace.
     *  @param totalSpace totalSpace��.
     */
    public void setTotalSpace(java.lang.Integer totalSpace) {
        this.totalSpace = totalSpace;
    }
    /**
     *  ��ȡ industry.
     *  @return java.lang.String.
     */
    public java.lang.String getIndustry() {
        return this.industry;
    }

    /**
     *  ���� industry.
     *  @param industry industry��.
     */
    public void setIndustry(java.lang.String industry) {
        this.industry = industry;
    }
    /**
     *  ��ȡ area.
     *  @return java.lang.String.
     */
    public java.lang.String getArea() {
        return this.area;
    }

    /**
     *  ���� area.
     *  @param area area��.
     */
    public void setArea(java.lang.String area) {
        this.area = area;
    }




    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SysParty.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysParty"));
        org.apache.axis.description.ElementDesc elemField = null;        


        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partyId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "partyId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partyName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "partyName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("databaseName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "databaseName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastDeployTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lastDeployTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "datetime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contractPerson");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contractPerson"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("", "email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("phone");
        elemField.setXmlName(new javax.xml.namespace.QName("", "phone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("openFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "openFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("remark");
        elemField.setXmlName(new javax.xml.namespace.QName("", "remark"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("logo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "logo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("developMode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "developMode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("enableCa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "enableCa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sendCa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sendCa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("version");
        elemField.setXmlName(new javax.xml.namespace.QName("", "version"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deskey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deskey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dbSpace");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dbSpace"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indexSpace");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indexSpace"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("uploadSpace");
        elemField.setXmlName(new javax.xml.namespace.QName("", "uploadSpace"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalSpace");
        elemField.setXmlName(new javax.xml.namespace.QName("", "totalSpace"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("industry");
        elemField.setXmlName(new javax.xml.namespace.QName("", "industry"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("area");
        elemField.setXmlName(new javax.xml.namespace.QName("", "area"));
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
