package cn.com.brilliance.begen.model;

import java.io.Serializable;


    /**
     *  ������SysField.
     */
public class SysField implements Serializable {
    /**
     *  ����sysRecordOrder.
     */
    private java.lang.Integer sysRecordOrder;
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���name.
     */
    private java.lang.String name;

    /**
     *  �ֶ���label.
     */
    private java.lang.String label;

    /**
     *  �ֶ���standard.
     */
    private java.lang.Boolean standard;

/*
1,��ʽ
2,�Զ����
3,��-��ϸ��Ϣ��ϵ
4,���ҹ�ϵ
5,��������
6,�ٷֱ�
7,���
9,�绰
A,�����ʼ�
B,��ѡ��
C,����
D,����/ʱ��
E,����
F,�ı�
G,�ı���
H,��ѡ�б�������
I,��ѡ�б��б��
J,�ļ�
K,��ѡ�б�(��ѡ��ť)
L,��ѡ�б���ѡ��
M,��ȷɨ��
N,����ɨ��
O,����
P,���ܿ�
*/
    /**
     *  �ֶ���type.
     */
    private java.lang.String type;

    /**
     *  �ֶ���formula.
     */
    private java.lang.String formula;

    /**
     *  �ֶ���checked.
     */
    private java.lang.Boolean checked;

    /**
     *  �ֶ���length.
     */
    private java.lang.Integer length;

    /**
     *  �ֶ���numDecimal.
     */
    private java.lang.Integer numDecimal;

    /**
     *  �ֶ���dataObject.
     */
    private java.lang.String dataObject;

    /**
     *  �ֶ���lookupParameter.
     */
    private java.lang.String lookupParameter;

    /**
     *  �ֶ���mask.
     */
    private java.lang.String mask;

    /**
     *  �ֶ���viewSize.
     */
    private java.lang.Integer viewSize;

/*
1,�ı�
2,�ı���
3,������
*/
    /**
     *  �ֶ���lookupFieldType.
     */
    private java.lang.String lookupFieldType;

    /**
     *  �ֶ���defaultValue.
     */
    private java.lang.String defaultValue;

    /**
     *  �ֶ���editFlag.
     */
    private java.lang.Boolean editFlag;

    /**
     *  �ֶ���partyId.
     */
    private java.lang.String partyId;

    /**
     *  �ֶ���selectItem.
     */
    private java.lang.String selectItem;

    /**
     *  �ֶ���visibleCols.
     */
    private java.lang.Integer visibleCols;

    /**
     *  �ֶ���relationObject.
     */
    private java.lang.String relationObject;

    /**
     *  �ֶ���autoNumberStart.
     */
    private java.lang.Integer autoNumberStart;

    /**
     *  �ֶ���autoNumberFormat.
     */
    private java.lang.String autoNumberFormat;

/*
1,����
2,����
3,����/ʱ��
4,����
5,�ٷֱ�
6,�ı�
*/
    /**
     *  �ֶ���formulaReturnType.
     */
    private java.lang.String formulaReturnType;

    /**
     *  �ֶ���primateKey.
     */
    private java.lang.Boolean primateKey;

    /**
     *  �ֶ���visibleLines.
     */
    private java.lang.Integer visibleLines;

    /**
     *  �ֶ���indexFlag.
     */
    private java.lang.Boolean indexFlag;

    /**
     *  �ֶ���encryptFlag.
     */
    private java.lang.Boolean encryptFlag;

/*
1,UT-201
*/
    /**
     *  �ֶ���smartcardType.
     */
    private java.lang.String smartcardType;


    /**
     *  ��dataObjectOfSysDataObject.
     */
    private SysDataObject dataObjectOfSysDataObject;
    /**
     *  ��partyIdOfSysParty.
     */
    private SysParty partyIdOfSysParty;
    /**
     *  ��relationObjectOfSysDataObject.
     */
    private SysDataObject relationObjectOfSysDataObject;

    /**
     *  ��ȡ sysRecordOrder.
     *  @return Integer.
     */
    public java.lang.Integer getSysRecordOrder() {
        return this.sysRecordOrder;
    }

    /**
     *  ���� sysRecordOrder.
     *  @param sysRecordOrder sysRecordOrder.
     */
    public void setSysRecordOrder(java.lang.Integer sysRecordOrder) {
        this.sysRecordOrder = sysRecordOrder;
    }


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
     *  ��ȡ name.
     *  @return java.lang.String.
     */
    public java.lang.String getName() {
        return this.name;
    }

    /**
     *  ���� name.
     *  @param name name��.
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }
    /**
     *  ��ȡ label.
     *  @return java.lang.String.
     */
    public java.lang.String getLabel() {
        return this.label;
    }

    /**
     *  ���� label.
     *  @param label label��.
     */
    public void setLabel(java.lang.String label) {
        this.label = label;
    }
    /**
     *  ��ȡ standard.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getStandard() {
        return this.standard;
    }

    /**
     *  ���� standard.
     *  @param standard standard��.
     */
    public void setStandard(java.lang.Boolean standard) {
        this.standard = standard;
    }
    /**
     *  ��ȡ type.
     *  @return java.lang.String.
     */
    public java.lang.String getType() {
        return this.type;
    }

    /**
     *  ���� type.
     *  @param type type��.
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }
    /**
     *  ��ȡ formula.
     *  @return java.lang.String.
     */
    public java.lang.String getFormula() {
        return this.formula;
    }

    /**
     *  ���� formula.
     *  @param formula formula��.
     */
    public void setFormula(java.lang.String formula) {
        this.formula = formula;
    }
    /**
     *  ��ȡ checked.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getChecked() {
        return this.checked;
    }

    /**
     *  ���� checked.
     *  @param checked checked��.
     */
    public void setChecked(java.lang.Boolean checked) {
        this.checked = checked;
    }
    /**
     *  ��ȡ length.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getLength() {
        return this.length;
    }

    /**
     *  ���� length.
     *  @param length length��.
     */
    public void setLength(java.lang.Integer length) {
        this.length = length;
    }
    /**
     *  ��ȡ numDecimal.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getNumDecimal() {
        return this.numDecimal;
    }

    /**
     *  ���� numDecimal.
     *  @param numDecimal numDecimal��.
     */
    public void setNumDecimal(java.lang.Integer numDecimal) {
        this.numDecimal = numDecimal;
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
     *  ��ȡ lookupParameter.
     *  @return java.lang.String.
     */
    public java.lang.String getLookupParameter() {
        return this.lookupParameter;
    }

    /**
     *  ���� lookupParameter.
     *  @param lookupParameter lookupParameter��.
     */
    public void setLookupParameter(java.lang.String lookupParameter) {
        this.lookupParameter = lookupParameter;
    }
    /**
     *  ��ȡ mask.
     *  @return java.lang.String.
     */
    public java.lang.String getMask() {
        return this.mask;
    }

    /**
     *  ���� mask.
     *  @param mask mask��.
     */
    public void setMask(java.lang.String mask) {
        this.mask = mask;
    }
    /**
     *  ��ȡ viewSize.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getViewSize() {
        return this.viewSize;
    }

    /**
     *  ���� viewSize.
     *  @param viewSize viewSize��.
     */
    public void setViewSize(java.lang.Integer viewSize) {
        this.viewSize = viewSize;
    }
    /**
     *  ��ȡ lookupFieldType.
     *  @return java.lang.String.
     */
    public java.lang.String getLookupFieldType() {
        return this.lookupFieldType;
    }

    /**
     *  ���� lookupFieldType.
     *  @param lookupFieldType lookupFieldType��.
     */
    public void setLookupFieldType(java.lang.String lookupFieldType) {
        this.lookupFieldType = lookupFieldType;
    }
    /**
     *  ��ȡ defaultValue.
     *  @return java.lang.String.
     */
    public java.lang.String getDefaultValue() {
        return this.defaultValue;
    }

    /**
     *  ���� defaultValue.
     *  @param defaultValue defaultValue��.
     */
    public void setDefaultValue(java.lang.String defaultValue) {
        this.defaultValue = defaultValue;
    }
    /**
     *  ��ȡ editFlag.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getEditFlag() {
        return this.editFlag;
    }

    /**
     *  ���� editFlag.
     *  @param editFlag editFlag��.
     */
    public void setEditFlag(java.lang.Boolean editFlag) {
        this.editFlag = editFlag;
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
     *  ��ȡ selectItem.
     *  @return java.lang.String.
     */
    public java.lang.String getSelectItem() {
        return this.selectItem;
    }

    /**
     *  ���� selectItem.
     *  @param selectItem selectItem��.
     */
    public void setSelectItem(java.lang.String selectItem) {
        this.selectItem = selectItem;
    }
    /**
     *  ��ȡ visibleCols.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getVisibleCols() {
        return this.visibleCols;
    }

    /**
     *  ���� visibleCols.
     *  @param visibleCols visibleCols��.
     */
    public void setVisibleCols(java.lang.Integer visibleCols) {
        this.visibleCols = visibleCols;
    }
    /**
     *  ��ȡ relationObject.
     *  @return java.lang.String.
     */
    public java.lang.String getRelationObject() {
        return this.relationObject;
    }

    /**
     *  ���� relationObject.
     *  @param relationObject relationObject��.
     */
    public void setRelationObject(java.lang.String relationObject) {
        this.relationObject = relationObject;
    }
    /**
     *  ��ȡ autoNumberStart.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getAutoNumberStart() {
        return this.autoNumberStart;
    }

    /**
     *  ���� autoNumberStart.
     *  @param autoNumberStart autoNumberStart��.
     */
    public void setAutoNumberStart(java.lang.Integer autoNumberStart) {
        this.autoNumberStart = autoNumberStart;
    }
    /**
     *  ��ȡ autoNumberFormat.
     *  @return java.lang.String.
     */
    public java.lang.String getAutoNumberFormat() {
        return this.autoNumberFormat;
    }

    /**
     *  ���� autoNumberFormat.
     *  @param autoNumberFormat autoNumberFormat��.
     */
    public void setAutoNumberFormat(java.lang.String autoNumberFormat) {
        this.autoNumberFormat = autoNumberFormat;
    }
    /**
     *  ��ȡ formulaReturnType.
     *  @return java.lang.String.
     */
    public java.lang.String getFormulaReturnType() {
        return this.formulaReturnType;
    }

    /**
     *  ���� formulaReturnType.
     *  @param formulaReturnType formulaReturnType��.
     */
    public void setFormulaReturnType(java.lang.String formulaReturnType) {
        this.formulaReturnType = formulaReturnType;
    }
    /**
     *  ��ȡ primateKey.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getPrimateKey() {
        return this.primateKey;
    }

    /**
     *  ���� primateKey.
     *  @param primateKey primateKey��.
     */
    public void setPrimateKey(java.lang.Boolean primateKey) {
        this.primateKey = primateKey;
    }
    /**
     *  ��ȡ visibleLines.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getVisibleLines() {
        return this.visibleLines;
    }

    /**
     *  ���� visibleLines.
     *  @param visibleLines visibleLines��.
     */
    public void setVisibleLines(java.lang.Integer visibleLines) {
        this.visibleLines = visibleLines;
    }
    /**
     *  ��ȡ indexFlag.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getIndexFlag() {
        return this.indexFlag;
    }

    /**
     *  ���� indexFlag.
     *  @param indexFlag indexFlag��.
     */
    public void setIndexFlag(java.lang.Boolean indexFlag) {
        this.indexFlag = indexFlag;
    }
    /**
     *  ��ȡ encryptFlag.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getEncryptFlag() {
        return this.encryptFlag;
    }

    /**
     *  ���� encryptFlag.
     *  @param encryptFlag encryptFlag��.
     */
    public void setEncryptFlag(java.lang.Boolean encryptFlag) {
        this.encryptFlag = encryptFlag;
    }
    /**
     *  ��ȡ smartcardType.
     *  @return java.lang.String.
     */
    public java.lang.String getSmartcardType() {
        return this.smartcardType;
    }

    /**
     *  ���� smartcardType.
     *  @param smartcardType smartcardType��.
     */
    public void setSmartcardType(java.lang.String smartcardType) {
        this.smartcardType = smartcardType;
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

    /**
     *  ��ȡ relationObjectOfSysDataObject.
     *  @return SysDataObject.
     */
    public SysDataObject getRelationObjectOfSysDataObject() {
        return this.relationObjectOfSysDataObject;
    }

    /**
     *  ���� relationObjectOfSysDataObject.
     *  @param relationObjectOfSysDataObject relationObjectOfSysDataObject��.
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
