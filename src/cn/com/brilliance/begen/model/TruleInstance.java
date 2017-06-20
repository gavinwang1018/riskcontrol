package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  ������TruleInstance.
     */
public class TruleInstance extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���enable.
     */
    private java.lang.Boolean enable;

    /**
     *  �ֶ���description.
     */
    private java.lang.String description;

    /**
     *  �ֶ���cycle.
     */
    private java.lang.String cycle;

    /**
     *  �ֶ���timeParam.
     */
    private java.lang.String timeParam;

    /**
     *  �ֶ���needTransInfo.
     */
    private java.lang.Boolean needTransInfo;

    /**
     *  �ֶ���supportTrace.
     */
    private java.lang.Boolean supportTrace;

/*
0,��̬
1,��̬
*/
    /**
     *  �ֶ���type.
     */
    private java.lang.String type;

    /**
     *  �ֶ���versionBm.
     */
    private java.lang.String versionBm;

    /**
     *  �ֶ���transInfo.
     */
    private java.lang.Boolean transInfo;

    /**
     *  �ֶ���code.
     */
    private java.lang.String code;

    /**
     *  �ֶ���beginTraceDate.
     */
    private java.util.Date beginTraceDate;

    /**
     *  �ֶ���belongToInst.
     */
    private java.lang.String belongToInst;

    /**
     *  �ֶ���endTraceDate.
     */
    private java.util.Date endTraceDate;


    /**
     *  ��belongToInstOfTorganizeInfo.
     */
    private TorganizeInfo belongToInstOfTorganizeInfo;

	public int get_edit_flag() {
		return _edit_flag;
	}

	public void set_edit_flag(int _edit_flag) {
		this._edit_flag = _edit_flag;
	}

	public int get_record_index() {
		return _record_index;
	}

	public void set_record_index(int index) {
		this._record_index = index;
	}
	
	public boolean is_checked_flag() {
		return _checked_flag;
	}

	public void set_checked_flag(boolean _checked_flag) {
		this._checked_flag = _checked_flag;
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
     *  ��ȡ enable.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getEnable() {
        return this.enable;
    }
    /**
     *  ���� enable.
     *  @param enable enable��.
     */
    public void setEnable(java.lang.Boolean enable) {
        this.enable = enable;
    }
    /**
     *  ��ȡ description.
     *  @return java.lang.String.
     */
    public java.lang.String getDescription() {
        return this.description;
    }

    /**
     *  ���� description.
     *  @param description description��.
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }
    /**
     *  ��ȡ cycle.
     *  @return java.lang.String.
     */
    public java.lang.String getCycle() {
        return this.cycle;
    }

    /**
     *  ���� cycle.
     *  @param cycle cycle��.
     */
    public void setCycle(java.lang.String cycle) {
        this.cycle = cycle;
    }
    /**
     *  ��ȡ timeParam.
     *  @return java.lang.String.
     */
    public java.lang.String getTimeParam() {
        return this.timeParam;
    }

    /**
     *  ���� timeParam.
     *  @param timeParam timeParam��.
     */
    public void setTimeParam(java.lang.String timeParam) {
        this.timeParam = timeParam;
    }
    /**
     *  ��ȡ needTransInfo.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getNeedTransInfo() {
        return this.needTransInfo;
    }
    /**
     *  ���� needTransInfo.
     *  @param needTransInfo needTransInfo��.
     */
    public void setNeedTransInfo(java.lang.Boolean needTransInfo) {
        this.needTransInfo = needTransInfo;
    }
    /**
     *  ��ȡ supportTrace.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getSupportTrace() {
        return this.supportTrace;
    }
    /**
     *  ���� supportTrace.
     *  @param supportTrace supportTrace��.
     */
    public void setSupportTrace(java.lang.Boolean supportTrace) {
        this.supportTrace = supportTrace;
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
     *  ��ȡ versionBm.
     *  @return java.lang.String.
     */
    public java.lang.String getVersionBm() {
        return this.versionBm;
    }

    /**
     *  ���� versionBm.
     *  @param versionBm versionBm��.
     */
    public void setVersionBm(java.lang.String versionBm) {
        this.versionBm = versionBm;
    }
    /**
     *  ��ȡ transInfo.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getTransInfo() {
        return this.transInfo;
    }

    /**
     *  ���� transInfo.
     *  @param transInfo transInfo��.
     */
    public void setTransInfo(java.lang.Boolean transInfo) {
        this.transInfo = transInfo;
    }
    /**
     *  ��ȡ code.
     *  @return java.lang.String.
     */
    public java.lang.String getCode() {
        return this.code;
    }

    /**
     *  ���� code.
     *  @param code code��.
     */
    public void setCode(java.lang.String code) {
        this.code = code;
    }
    /**
     *  ��ȡ beginTraceDate.
     *  @return java.util.Date.
     */
    public java.util.Date getBeginTraceDate() {
        return this.beginTraceDate;
    }

    /**
     *  ���� beginTraceDate.
     *  @param beginTraceDate beginTraceDate��.
     */
    public void setBeginTraceDate(java.util.Date beginTraceDate) {
        this.beginTraceDate = beginTraceDate;
    }
    /**
     *  ��ȡ belongToInst.
     *  @return java.lang.String.
     */
    public java.lang.String getBelongToInst() {
        return this.belongToInst;
    }

    /**
     *  ���� belongToInst.
     *  @param belongToInst belongToInst��.
     */
    public void setBelongToInst(java.lang.String belongToInst) {
        this.belongToInst = belongToInst;
    }
    /**
     *  ��ȡ endTraceDate.
     *  @return java.util.Date.
     */
    public java.util.Date getEndTraceDate() {
        return this.endTraceDate;
    }

    /**
     *  ���� endTraceDate.
     *  @param endTraceDate endTraceDate��.
     */
    public void setEndTraceDate(java.util.Date endTraceDate) {
        this.endTraceDate = endTraceDate;
    }




    /**
     *  ��ȡ belongToInstOfTorganizeInfo.
     *  @return TorganizeInfo.
     */
    public TorganizeInfo getBelongToInstOfTorganizeInfo() {
    	if (this.belongToInstOfTorganizeInfo == null && this.belongToInst != null  && !"".equals(this.belongToInst)){
    		TorganizeInfoDAO torganizeInfoDAO = (TorganizeInfoDAO)Tools.getBean("torganizeInfoDAO");
    		this.belongToInstOfTorganizeInfo= torganizeInfoDAO.getTorganizeInfo(this.belongToInst);
    	}
        return this.belongToInstOfTorganizeInfo;
    }

    /**
     *  ���� belongToInstOfTorganizeInfo.
     *  @param belongToInstOfTorganizeInfo belongToInstOfTorganizeInfo��.
     */
    public void setBelongToInstOfTorganizeInfo(TorganizeInfo belongToInstOfTorganizeInfo) {
        this.belongToInstOfTorganizeInfo = belongToInstOfTorganizeInfo;
    }

}
