package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  定义类TriskprocessTimelimit.
     */
public class TriskprocessTimelimit extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  字段域belongToInst.
     */
    private java.lang.String belongToInst;

/*
ddd
*/
    /**
     *  字段域warnLevel.
     */
    private java.lang.String warnLevel;

    /**
     *  字段域timeLimit.
     */
    private java.lang.String timeLimit;

    /**
     *  字段域id.
     */
    private java.lang.String id;


    /**
     *  域belongToInstOfTorganizeInfo.
     */
    private TorganizeInfo belongToInstOfTorganizeInfo;
    
    
    private Tbasearg wevel; 
    

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
     *  获取 warnLevel.
     *  @return java.lang.String.
     */
    public java.lang.String getWarnLevel() {
        return this.warnLevel;
    }

    /**
     *  设置 warnLevel.
     *  @param warnLevel warnLevel域.
     */
    public void setWarnLevel(java.lang.String warnLevel) {
        this.warnLevel = warnLevel;
    }
    /**
     *  获取 timeLimit.
     *  @return java.lang.String.
     */
    public java.lang.String getTimeLimit() {
        return this.timeLimit;
    }

    /**
     *  设置 timeLimit.
     *  @param timeLimit timeLimit域.
     */
    public void setTimeLimit(java.lang.String timeLimit) {
        this.timeLimit = timeLimit;
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

	public Tbasearg getWevel() {
		if (this.wevel == null && this.warnLevel != null  && !"".equals(this.warnLevel)){
			TbaseargDAO tbaseargDAO = (TbaseargDAO)Tools.getBean("tbaseargDAO");
    		this.wevel= tbaseargDAO.getTbasearg(this.warnLevel);
    	}
		return this.wevel;
	}

	public void setWevel(Tbasearg wevel) {
		this.wevel = wevel;
	}

}
