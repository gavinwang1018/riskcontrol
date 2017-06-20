package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  定义类TruleInstance.
     */
public class TruleInstance extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  字段域id.
     */
    private java.lang.String id;

    /**
     *  字段域enable.
     */
    private java.lang.Boolean enable;

    /**
     *  字段域description.
     */
    private java.lang.String description;

    /**
     *  字段域cycle.
     */
    private java.lang.String cycle;

    /**
     *  字段域timeParam.
     */
    private java.lang.String timeParam;

    /**
     *  字段域needTransInfo.
     */
    private java.lang.Boolean needTransInfo;

    /**
     *  字段域supportTrace.
     */
    private java.lang.Boolean supportTrace;

/*
0,静态
1,动态
*/
    /**
     *  字段域type.
     */
    private java.lang.String type;

    /**
     *  字段域versionBm.
     */
    private java.lang.String versionBm;

    /**
     *  字段域transInfo.
     */
    private java.lang.Boolean transInfo;

    /**
     *  字段域code.
     */
    private java.lang.String code;

    /**
     *  字段域beginTraceDate.
     */
    private java.util.Date beginTraceDate;

    /**
     *  字段域belongToInst.
     */
    private java.lang.String belongToInst;

    /**
     *  字段域endTraceDate.
     */
    private java.util.Date endTraceDate;


    /**
     *  域belongToInstOfTorganizeInfo.
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
     *  获取 enable.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getEnable() {
        return this.enable;
    }
    /**
     *  设置 enable.
     *  @param enable enable域.
     */
    public void setEnable(java.lang.Boolean enable) {
        this.enable = enable;
    }
    /**
     *  获取 description.
     *  @return java.lang.String.
     */
    public java.lang.String getDescription() {
        return this.description;
    }

    /**
     *  设置 description.
     *  @param description description域.
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }
    /**
     *  获取 cycle.
     *  @return java.lang.String.
     */
    public java.lang.String getCycle() {
        return this.cycle;
    }

    /**
     *  设置 cycle.
     *  @param cycle cycle域.
     */
    public void setCycle(java.lang.String cycle) {
        this.cycle = cycle;
    }
    /**
     *  获取 timeParam.
     *  @return java.lang.String.
     */
    public java.lang.String getTimeParam() {
        return this.timeParam;
    }

    /**
     *  设置 timeParam.
     *  @param timeParam timeParam域.
     */
    public void setTimeParam(java.lang.String timeParam) {
        this.timeParam = timeParam;
    }
    /**
     *  获取 needTransInfo.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getNeedTransInfo() {
        return this.needTransInfo;
    }
    /**
     *  设置 needTransInfo.
     *  @param needTransInfo needTransInfo域.
     */
    public void setNeedTransInfo(java.lang.Boolean needTransInfo) {
        this.needTransInfo = needTransInfo;
    }
    /**
     *  获取 supportTrace.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getSupportTrace() {
        return this.supportTrace;
    }
    /**
     *  设置 supportTrace.
     *  @param supportTrace supportTrace域.
     */
    public void setSupportTrace(java.lang.Boolean supportTrace) {
        this.supportTrace = supportTrace;
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
     *  获取 versionBm.
     *  @return java.lang.String.
     */
    public java.lang.String getVersionBm() {
        return this.versionBm;
    }

    /**
     *  设置 versionBm.
     *  @param versionBm versionBm域.
     */
    public void setVersionBm(java.lang.String versionBm) {
        this.versionBm = versionBm;
    }
    /**
     *  获取 transInfo.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getTransInfo() {
        return this.transInfo;
    }

    /**
     *  设置 transInfo.
     *  @param transInfo transInfo域.
     */
    public void setTransInfo(java.lang.Boolean transInfo) {
        this.transInfo = transInfo;
    }
    /**
     *  获取 code.
     *  @return java.lang.String.
     */
    public java.lang.String getCode() {
        return this.code;
    }

    /**
     *  设置 code.
     *  @param code code域.
     */
    public void setCode(java.lang.String code) {
        this.code = code;
    }
    /**
     *  获取 beginTraceDate.
     *  @return java.util.Date.
     */
    public java.util.Date getBeginTraceDate() {
        return this.beginTraceDate;
    }

    /**
     *  设置 beginTraceDate.
     *  @param beginTraceDate beginTraceDate域.
     */
    public void setBeginTraceDate(java.util.Date beginTraceDate) {
        this.beginTraceDate = beginTraceDate;
    }
    /**
     *  获取 belongToInst.
     *  @return java.lang.String.
     */
    public java.lang.String getBelongToInst() {
        return this.belongToInst;
    }

    /**
     *  设置 belongToInst.
     *  @param belongToInst belongToInst域.
     */
    public void setBelongToInst(java.lang.String belongToInst) {
        this.belongToInst = belongToInst;
    }
    /**
     *  获取 endTraceDate.
     *  @return java.util.Date.
     */
    public java.util.Date getEndTraceDate() {
        return this.endTraceDate;
    }

    /**
     *  设置 endTraceDate.
     *  @param endTraceDate endTraceDate域.
     */
    public void setEndTraceDate(java.util.Date endTraceDate) {
        this.endTraceDate = endTraceDate;
    }




    /**
     *  获取 belongToInstOfTorganizeInfo.
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
     *  设置 belongToInstOfTorganizeInfo.
     *  @param belongToInstOfTorganizeInfo belongToInstOfTorganizeInfo域.
     */
    public void setBelongToInstOfTorganizeInfo(TorganizeInfo belongToInstOfTorganizeInfo) {
        this.belongToInstOfTorganizeInfo = belongToInstOfTorganizeInfo;
    }

}
