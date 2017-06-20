package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;

    /**
     *  定义类SysParty.
     */
public class SysParty implements Serializable {
    /**
     *  字段域partyId.
     */
    private java.lang.String partyId;

    /**
     *  字段域partyName.
     */
    private java.lang.String partyName;

    /**
     *  字段域databaseName.
     */
    private java.lang.String databaseName;

    /**
     *  字段域lastDeployTime.
     */
    private java.util.Date lastDeployTime;

    /**
     *  字段域contractPerson.
     */
    private java.lang.String contractPerson;

    /**
     *  字段域email.
     */
    private java.lang.String email;

    /**
     *  字段域phone.
     */
    private java.lang.String phone;

/*
5,小于 8 人
15,8 - 20 人
60,21 - 100 人
150,101 - 200 人
300,201 - 400 人
450,401 - 500 人
625,501 - 750 人
875,751 - 1,000 人
1500,1,000 - 2,000 人
5000,大于 2,000 人
*/
    /**
     *  字段域userNumber.
     */
    private java.lang.String userNumber;

    /**
     *  字段域openFlag.
     */
    private java.lang.Boolean openFlag;

    /**
     *  字段域remark.
     */
    private java.lang.String remark;

    /**
     *  字段域logo.
     */
    private java.lang.String logo;

    /**
     *  字段域developMode.
     */
    private java.lang.Boolean developMode;

    /**
     *  字段域enableCa.
     */
    private java.lang.Boolean enableCa;

    /**
     *  字段域sendCa.
     */
    private java.lang.Boolean sendCa;

    /**
     *  字段域version.
     */
    private java.lang.String version;

    /**
     *  字段域deskey.
     */
    private java.lang.String deskey;

    /**
     *  字段域dbSpace.
     */
    private java.lang.Integer dbSpace;

    /**
     *  字段域indexSpace.
     */
    private java.lang.Integer indexSpace;

    /**
     *  字段域uploadSpace.
     */
    private java.lang.Integer uploadSpace;

    /**
     *  字段域totalSpace.
     */
    private java.lang.Integer totalSpace;

/*
01,多领域经营
02,财务和审计
03,广告、公关及相关行业
04,银行、保险和金融服务
05,服装和纺织
06,IT
07,计算机硬件
08,系统和网络
09,计算机软件
10,互联网
11,房地产、建筑和装璜
12,制造业
13,政府和公共事业
14,咨询
15,教育和培训
16,工程(电气与机械)
17,娱乐、运动和休闲
18,农业, 林业和渔业
19,环保产业
20,运输、物流和快递
21,旅游和饭店
22,消费品
23,食品，饮料和烟草
24,医疗保健
25,重工业
26,家电
27,进出口
28,工业自动化
29,法律服务
31,报刊、广播、出版和电视
32,制药、保健和生物工程
33,能源
33,零售、批发、代理和贸易
34,科研
35,电子设备和摄影器材
36,化工和石化
37,汽车
38,通讯技术
39,航空和航天
40,系统集成
41,分销代理
42,其它
*/
    /**
     *  字段域industry.
     */
    private java.lang.String industry;

/*
001,北京
002,上海
003,天津
004,重庆
005,香港
006,澳门
007,河北
008,山西
009,山东
010,辽宁
011,江苏
012,浙江
013,河南
014,陕西
015,安徽
016,湖北
017,湖南
018,四川
019,江西
020,黑龙
021,吉林
022,广东
023,广西
024,福建
025,甘肃
026,云南
027,海南
028,台湾
029,青海
030,贵州
031,内蒙
032,新疆
033,宁夏
034,西藏
*/
    /**
     *  字段域area.
     */
    private java.lang.String area;




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
     *  获取 partyName.
     *  @return java.lang.String.
     */
    public java.lang.String getPartyName() {
        return this.partyName;
    }

    /**
     *  设置 partyName.
     *  @param partyName partyName域.
     */
    public void setPartyName(java.lang.String partyName) {
        this.partyName = partyName;
    }
    /**
     *  获取 databaseName.
     *  @return java.lang.String.
     */
    public java.lang.String getDatabaseName() {
        return this.databaseName;
    }

    /**
     *  设置 databaseName.
     *  @param databaseName databaseName域.
     */
    public void setDatabaseName(java.lang.String databaseName) {
        this.databaseName = databaseName;
    }
    /**
     *  获取 lastDeployTime.
     *  @return java.util.Date.
     */
    public java.util.Date getLastDeployTime() {
        return this.lastDeployTime;
    }

    /**
     *  设置 lastDeployTime.
     *  @param lastDeployTime lastDeployTime域.
     */
    public void setLastDeployTime(java.util.Date lastDeployTime) {
        this.lastDeployTime = lastDeployTime;
    }
    /**
     *  获取 contractPerson.
     *  @return java.lang.String.
     */
    public java.lang.String getContractPerson() {
        return this.contractPerson;
    }

    /**
     *  设置 contractPerson.
     *  @param contractPerson contractPerson域.
     */
    public void setContractPerson(java.lang.String contractPerson) {
        this.contractPerson = contractPerson;
    }
    /**
     *  获取 email.
     *  @return java.lang.String.
     */
    public java.lang.String getEmail() {
        return this.email;
    }

    /**
     *  设置 email.
     *  @param email email域.
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }
    /**
     *  获取 phone.
     *  @return java.lang.String.
     */
    public java.lang.String getPhone() {
        return this.phone;
    }

    /**
     *  设置 phone.
     *  @param phone phone域.
     */
    public void setPhone(java.lang.String phone) {
        this.phone = phone;
    }
    /**
     *  获取 userNumber.
     *  @return java.lang.String.
     */
    public java.lang.String getUserNumber() {
        return this.userNumber;
    }

    /**
     *  设置 userNumber.
     *  @param userNumber userNumber域.
     */
    public void setUserNumber(java.lang.String userNumber) {
        this.userNumber = userNumber;
    }
    /**
     *  获取 openFlag.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getOpenFlag() {
        return this.openFlag;
    }

    /**
     *  设置 openFlag.
     *  @param openFlag openFlag域.
     */
    public void setOpenFlag(java.lang.Boolean openFlag) {
        this.openFlag = openFlag;
    }
    /**
     *  获取 remark.
     *  @return java.lang.String.
     */
    public java.lang.String getRemark() {
        return this.remark;
    }

    /**
     *  设置 remark.
     *  @param remark remark域.
     */
    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }
    /**
     *  获取 logo.
     *  @return java.lang.String.
     */
    public java.lang.String getLogo() {
        return this.logo;
    }

    /**
     *  设置 logo.
     *  @param logo logo域.
     */
    public void setLogo(java.lang.String logo) {
        this.logo = logo;
    }
    /**
     *  获取 developMode.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getDevelopMode() {
        return this.developMode;
    }

    /**
     *  设置 developMode.
     *  @param developMode developMode域.
     */
    public void setDevelopMode(java.lang.Boolean developMode) {
        this.developMode = developMode;
    }
    /**
     *  获取 enableCa.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getEnableCa() {
        return this.enableCa;
    }

    /**
     *  设置 enableCa.
     *  @param enableCa enableCa域.
     */
    public void setEnableCa(java.lang.Boolean enableCa) {
        this.enableCa = enableCa;
    }
    /**
     *  获取 sendCa.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getSendCa() {
        return this.sendCa;
    }

    /**
     *  设置 sendCa.
     *  @param sendCa sendCa域.
     */
    public void setSendCa(java.lang.Boolean sendCa) {
        this.sendCa = sendCa;
    }
    /**
     *  获取 version.
     *  @return java.lang.String.
     */
    public java.lang.String getVersion() {
        return this.version;
    }

    /**
     *  设置 version.
     *  @param version version域.
     */
    public void setVersion(java.lang.String version) {
        this.version = version;
    }
    /**
     *  获取 deskey.
     *  @return java.lang.String.
     */
    public java.lang.String getDeskey() {
        return this.deskey;
    }

    /**
     *  设置 deskey.
     *  @param deskey deskey域.
     */
    public void setDeskey(java.lang.String deskey) {
        this.deskey = deskey;
    }
    /**
     *  获取 dbSpace.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getDbSpace() {
        return this.dbSpace;
    }

    /**
     *  设置 dbSpace.
     *  @param dbSpace dbSpace域.
     */
    public void setDbSpace(java.lang.Integer dbSpace) {
        this.dbSpace = dbSpace;
    }
    /**
     *  获取 indexSpace.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getIndexSpace() {
        return this.indexSpace;
    }

    /**
     *  设置 indexSpace.
     *  @param indexSpace indexSpace域.
     */
    public void setIndexSpace(java.lang.Integer indexSpace) {
        this.indexSpace = indexSpace;
    }
    /**
     *  获取 uploadSpace.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getUploadSpace() {
        return this.uploadSpace;
    }

    /**
     *  设置 uploadSpace.
     *  @param uploadSpace uploadSpace域.
     */
    public void setUploadSpace(java.lang.Integer uploadSpace) {
        this.uploadSpace = uploadSpace;
    }
    /**
     *  获取 totalSpace.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getTotalSpace() {
        return this.totalSpace;
    }

    /**
     *  设置 totalSpace.
     *  @param totalSpace totalSpace域.
     */
    public void setTotalSpace(java.lang.Integer totalSpace) {
        this.totalSpace = totalSpace;
    }
    /**
     *  获取 industry.
     *  @return java.lang.String.
     */
    public java.lang.String getIndustry() {
        return this.industry;
    }

    /**
     *  设置 industry.
     *  @param industry industry域.
     */
    public void setIndustry(java.lang.String industry) {
        this.industry = industry;
    }
    /**
     *  获取 area.
     *  @return java.lang.String.
     */
    public java.lang.String getArea() {
        return this.area;
    }

    /**
     *  设置 area.
     *  @param area area域.
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
