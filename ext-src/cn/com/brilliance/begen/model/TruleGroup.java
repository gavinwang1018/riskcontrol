package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  ������TruleGroup.
     */
public class TruleGroup extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���belongToInst.
     */
    private java.lang.String belongToInst;

    /**
     *  �ֶ���description.
     */
    private java.lang.String description;

    /**
     *  �ֶ���enable.
     */
    private java.lang.Boolean enable;

/*
0,������
1,������
2,������
3,�Ѵ����ȷ��
4,������
5,�᰸

*/
    /**
     *  �ֶ���status.
     */
    private java.lang.String status;


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
     *  ��ȡ status.
     *  @return java.lang.String.
     */
    public java.lang.String getStatus() {
        return this.status;
    }

    /**
     *  ���� status.
     *  @param status status��.
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
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
