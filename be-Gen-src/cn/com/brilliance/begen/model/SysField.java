package cn.com.brilliance.begen.model;

import java.io.Serializable;


    /**
     *  定义类SysField.
     */
public class SysField implements Serializable {
    /**
     *  定义sysRecordOrder.
     */
    private java.lang.Integer sysRecordOrder;
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
     *  字段域standard.
     */
    private java.lang.Boolean standard;

/*
1,公式
2,自动编号
3,主-详细信息关系
4,查找关系
5,超级链接
6,百分比
7,金额
9,电话
A,电子邮件
B,复选框
C,日期
D,日期/时间
E,数字
F,文本
G,文本区
H,单选列表（下拉框）
I,多选列表（列表框）
J,文件
K,单选列表(单选按钮)
L,多选列表（复选框）
M,精确扫描
N,简易扫描
O,密码
P,智能卡
*/
    /**
     *  字段域type.
     */
    private java.lang.String type;

    /**
     *  字段域formula.
     */
    private java.lang.String formula;

    /**
     *  字段域checked.
     */
    private java.lang.Boolean checked;

    /**
     *  字段域length.
     */
    private java.lang.Integer length;

    /**
     *  字段域numDecimal.
     */
    private java.lang.Integer numDecimal;

    /**
     *  字段域dataObject.
     */
    private java.lang.String dataObject;

    /**
     *  字段域lookupParameter.
     */
    private java.lang.String lookupParameter;

    /**
     *  字段域mask.
     */
    private java.lang.String mask;

    /**
     *  字段域viewSize.
     */
    private java.lang.Integer viewSize;

/*
1,文本
2,文本区
3,下拉框
*/
    /**
     *  字段域lookupFieldType.
     */
    private java.lang.String lookupFieldType;

    /**
     *  字段域defaultValue.
     */
    private java.lang.String defaultValue;

    /**
     *  字段域editFlag.
     */
    private java.lang.Boolean editFlag;

    /**
     *  字段域partyId.
     */
    private java.lang.String partyId;

    /**
     *  字段域selectItem.
     */
    private java.lang.String selectItem;

    /**
     *  字段域visibleCols.
     */
    private java.lang.Integer visibleCols;

    /**
     *  字段域relationObject.
     */
    private java.lang.String relationObject;

    /**
     *  字段域autoNumberStart.
     */
    private java.lang.Integer autoNumberStart;

    /**
     *  字段域autoNumberFormat.
     */
    private java.lang.String autoNumberFormat;

/*
1,币种
2,日期
3,日期/时间
4,数字
5,百分比
6,文本
*/
    /**
     *  字段域formulaReturnType.
     */
    private java.lang.String formulaReturnType;

    /**
     *  字段域primateKey.
     */
    private java.lang.Boolean primateKey;

    /**
     *  字段域visibleLines.
     */
    private java.lang.Integer visibleLines;

    /**
     *  字段域indexFlag.
     */
    private java.lang.Boolean indexFlag;

    /**
     *  字段域encryptFlag.
     */
    private java.lang.Boolean encryptFlag;

/*
1,UT-201
*/
    /**
     *  字段域smartcardType.
     */
    private java.lang.String smartcardType;


    /**
     *  域dataObjectOfSysDataObject.
     */
    private SysDataObject dataObjectOfSysDataObject;
    /**
     *  域partyIdOfSysParty.
     */
    private SysParty partyIdOfSysParty;
    /**
     *  域relationObjectOfSysDataObject.
     */
    private SysDataObject relationObjectOfSysDataObject;

    /**
     *  获取 sysRecordOrder.
     *  @return Integer.
     */
    public java.lang.Integer getSysRecordOrder() {
        return this.sysRecordOrder;
    }

    /**
     *  设置 sysRecordOrder.
     *  @param sysRecordOrder sysRecordOrder.
     */
    public void setSysRecordOrder(java.lang.Integer sysRecordOrder) {
        this.sysRecordOrder = sysRecordOrder;
    }


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
     *  获取 type.
     *  @return java.lang.String.
     */
    public java.lang.String getType() {
        return this.type;
    }

    /**
     *  设置 type.
     *  @param type type域.
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }
    /**
     *  获取 formula.
     *  @return java.lang.String.
     */
    public java.lang.String getFormula() {
        return this.formula;
    }

    /**
     *  设置 formula.
     *  @param formula formula域.
     */
    public void setFormula(java.lang.String formula) {
        this.formula = formula;
    }
    /**
     *  获取 checked.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getChecked() {
        return this.checked;
    }

    /**
     *  设置 checked.
     *  @param checked checked域.
     */
    public void setChecked(java.lang.Boolean checked) {
        this.checked = checked;
    }
    /**
     *  获取 length.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getLength() {
        return this.length;
    }

    /**
     *  设置 length.
     *  @param length length域.
     */
    public void setLength(java.lang.Integer length) {
        this.length = length;
    }
    /**
     *  获取 numDecimal.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getNumDecimal() {
        return this.numDecimal;
    }

    /**
     *  设置 numDecimal.
     *  @param numDecimal numDecimal域.
     */
    public void setNumDecimal(java.lang.Integer numDecimal) {
        this.numDecimal = numDecimal;
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
     *  获取 lookupParameter.
     *  @return java.lang.String.
     */
    public java.lang.String getLookupParameter() {
        return this.lookupParameter;
    }

    /**
     *  设置 lookupParameter.
     *  @param lookupParameter lookupParameter域.
     */
    public void setLookupParameter(java.lang.String lookupParameter) {
        this.lookupParameter = lookupParameter;
    }
    /**
     *  获取 mask.
     *  @return java.lang.String.
     */
    public java.lang.String getMask() {
        return this.mask;
    }

    /**
     *  设置 mask.
     *  @param mask mask域.
     */
    public void setMask(java.lang.String mask) {
        this.mask = mask;
    }
    /**
     *  获取 viewSize.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getViewSize() {
        return this.viewSize;
    }

    /**
     *  设置 viewSize.
     *  @param viewSize viewSize域.
     */
    public void setViewSize(java.lang.Integer viewSize) {
        this.viewSize = viewSize;
    }
    /**
     *  获取 lookupFieldType.
     *  @return java.lang.String.
     */
    public java.lang.String getLookupFieldType() {
        return this.lookupFieldType;
    }

    /**
     *  设置 lookupFieldType.
     *  @param lookupFieldType lookupFieldType域.
     */
    public void setLookupFieldType(java.lang.String lookupFieldType) {
        this.lookupFieldType = lookupFieldType;
    }
    /**
     *  获取 defaultValue.
     *  @return java.lang.String.
     */
    public java.lang.String getDefaultValue() {
        return this.defaultValue;
    }

    /**
     *  设置 defaultValue.
     *  @param defaultValue defaultValue域.
     */
    public void setDefaultValue(java.lang.String defaultValue) {
        this.defaultValue = defaultValue;
    }
    /**
     *  获取 editFlag.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getEditFlag() {
        return this.editFlag;
    }

    /**
     *  设置 editFlag.
     *  @param editFlag editFlag域.
     */
    public void setEditFlag(java.lang.Boolean editFlag) {
        this.editFlag = editFlag;
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
     *  获取 selectItem.
     *  @return java.lang.String.
     */
    public java.lang.String getSelectItem() {
        return this.selectItem;
    }

    /**
     *  设置 selectItem.
     *  @param selectItem selectItem域.
     */
    public void setSelectItem(java.lang.String selectItem) {
        this.selectItem = selectItem;
    }
    /**
     *  获取 visibleCols.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getVisibleCols() {
        return this.visibleCols;
    }

    /**
     *  设置 visibleCols.
     *  @param visibleCols visibleCols域.
     */
    public void setVisibleCols(java.lang.Integer visibleCols) {
        this.visibleCols = visibleCols;
    }
    /**
     *  获取 relationObject.
     *  @return java.lang.String.
     */
    public java.lang.String getRelationObject() {
        return this.relationObject;
    }

    /**
     *  设置 relationObject.
     *  @param relationObject relationObject域.
     */
    public void setRelationObject(java.lang.String relationObject) {
        this.relationObject = relationObject;
    }
    /**
     *  获取 autoNumberStart.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getAutoNumberStart() {
        return this.autoNumberStart;
    }

    /**
     *  设置 autoNumberStart.
     *  @param autoNumberStart autoNumberStart域.
     */
    public void setAutoNumberStart(java.lang.Integer autoNumberStart) {
        this.autoNumberStart = autoNumberStart;
    }
    /**
     *  获取 autoNumberFormat.
     *  @return java.lang.String.
     */
    public java.lang.String getAutoNumberFormat() {
        return this.autoNumberFormat;
    }

    /**
     *  设置 autoNumberFormat.
     *  @param autoNumberFormat autoNumberFormat域.
     */
    public void setAutoNumberFormat(java.lang.String autoNumberFormat) {
        this.autoNumberFormat = autoNumberFormat;
    }
    /**
     *  获取 formulaReturnType.
     *  @return java.lang.String.
     */
    public java.lang.String getFormulaReturnType() {
        return this.formulaReturnType;
    }

    /**
     *  设置 formulaReturnType.
     *  @param formulaReturnType formulaReturnType域.
     */
    public void setFormulaReturnType(java.lang.String formulaReturnType) {
        this.formulaReturnType = formulaReturnType;
    }
    /**
     *  获取 primateKey.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getPrimateKey() {
        return this.primateKey;
    }

    /**
     *  设置 primateKey.
     *  @param primateKey primateKey域.
     */
    public void setPrimateKey(java.lang.Boolean primateKey) {
        this.primateKey = primateKey;
    }
    /**
     *  获取 visibleLines.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getVisibleLines() {
        return this.visibleLines;
    }

    /**
     *  设置 visibleLines.
     *  @param visibleLines visibleLines域.
     */
    public void setVisibleLines(java.lang.Integer visibleLines) {
        this.visibleLines = visibleLines;
    }
    /**
     *  获取 indexFlag.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getIndexFlag() {
        return this.indexFlag;
    }

    /**
     *  设置 indexFlag.
     *  @param indexFlag indexFlag域.
     */
    public void setIndexFlag(java.lang.Boolean indexFlag) {
        this.indexFlag = indexFlag;
    }
    /**
     *  获取 encryptFlag.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getEncryptFlag() {
        return this.encryptFlag;
    }

    /**
     *  设置 encryptFlag.
     *  @param encryptFlag encryptFlag域.
     */
    public void setEncryptFlag(java.lang.Boolean encryptFlag) {
        this.encryptFlag = encryptFlag;
    }
    /**
     *  获取 smartcardType.
     *  @return java.lang.String.
     */
    public java.lang.String getSmartcardType() {
        return this.smartcardType;
    }

    /**
     *  设置 smartcardType.
     *  @param smartcardType smartcardType域.
     */
    public void setSmartcardType(java.lang.String smartcardType) {
        this.smartcardType = smartcardType;
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

    /**
     *  获取 relationObjectOfSysDataObject.
     *  @return SysDataObject.
     */
    public SysDataObject getRelationObjectOfSysDataObject() {
        return this.relationObjectOfSysDataObject;
    }

    /**
     *  设置 relationObjectOfSysDataObject.
     *  @param relationObjectOfSysDataObject relationObjectOfSysDataObject域.
     */
    public void setRelationObjectOfSysDataObject(SysDataObject relationObjectOfSysDataObject) {
        this.relationObjectOfSysDataObject = relationObjectOfSysDataObject;
    }



    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SysField.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysField"));
        org.apache.axis.description.ElementDesc elemField = null;        

        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sysRecordOrder");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sysRecordOrder"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);

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
        elemField.setFieldName("standard");
        elemField.setXmlName(new javax.xml.namespace.QName("", "standard"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("formula");
        elemField.setXmlName(new javax.xml.namespace.QName("", "formula"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("checked");
        elemField.setXmlName(new javax.xml.namespace.QName("", "checked"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("length");
        elemField.setXmlName(new javax.xml.namespace.QName("", "length"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numDecimal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numDecimal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataObject");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataObject"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lookupParameter");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lookupParameter"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mask");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mask"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("viewSize");
        elemField.setXmlName(new javax.xml.namespace.QName("", "viewSize"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lookupFieldType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lookupFieldType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("defaultValue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "defaultValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("editFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "editFlag"));
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
        elemField.setFieldName("selectItem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "selectItem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("visibleCols");
        elemField.setXmlName(new javax.xml.namespace.QName("", "visibleCols"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("relationObject");
        elemField.setXmlName(new javax.xml.namespace.QName("", "relationObject"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("autoNumberStart");
        elemField.setXmlName(new javax.xml.namespace.QName("", "autoNumberStart"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("autoNumberFormat");
        elemField.setXmlName(new javax.xml.namespace.QName("", "autoNumberFormat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("formulaReturnType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "formulaReturnType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("primateKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "primateKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("visibleLines");
        elemField.setXmlName(new javax.xml.namespace.QName("", "visibleLines"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indexFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indexFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("encryptFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "encryptFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("smartcardType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "smartcardType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);


        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataObjectOfSysDataObject");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataObjectOfSysDataObject"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysDataObject"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partyIdOfSysParty");
        elemField.setXmlName(new javax.xml.namespace.QName("", "partyIdOfSysParty"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysParty"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("relationObjectOfSysDataObject");
        elemField.setXmlName(new javax.xml.namespace.QName("", "relationObjectOfSysDataObject"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.begen.brilliance.com.cn", "SysDataObject"));
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
