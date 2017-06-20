package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  ������TriskprocessTimelimit.
     */
public class TriskprocessTimelimit extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  �ֶ���belongToInst.
     */
    private java.lang.String belongToInst;

/*
ddd
*/
    /**
     *  �ֶ���warnLevel.
     */
    private java.lang.String warnLevel;

    /**
     *  �ֶ���timeLimit.
     */
    private java.lang.String timeLimit;

    /**
     *  �ֶ���id.
     */
    private java.lang.String id;


    /**
     *  ��belongToInstOfTorganizeInfo.
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
     *  ��ȡ warnLevel.
     *  @return java.lang.String.
     */
    public java.lang.String getWarnLevel() {
        return this.warnLevel;
    }

    /**
     *  ���� warnLevel.
     *  @param warnLevel warnLevel��.
     */
    public void setWarnLevel(java.lang.String warnLevel) {
        this.warnLevel = warnLevel;
    }
    /**
     *  ��ȡ timeLimit.
     *  @return java.lang.String.
     */
    public java.lang.String getTimeLimit() {
        return this.timeLimit;
    }

    /**
     *  ���� timeLimit.
     *  @param timeLimit timeLimit��.
     */
    public void setTimeLimit(java.lang.String timeLimit) {
        this.timeLimit = timeLimit;
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
