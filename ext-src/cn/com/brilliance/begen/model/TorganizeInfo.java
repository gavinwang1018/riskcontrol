package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  ������TorganizeInfo.
     */
public class TorganizeInfo extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  �ֶ���id.
     */
    private java.lang.String id;

    /**
     *  �ֶ���name.
     */
    private java.lang.String name;

    /**
     *  �ֶ���dwFlag.
     */
    private java.lang.Boolean dwFlag;

    /**
     *  �ֶ���originalSort.
     */
    private java.lang.String originalSort;

    /**
     *  �ֶ���globalSort.
     */
    private java.lang.String globalSort;

    /**
     *  �ֶ���fwdInsIdCd.
     */
    private java.lang.String fwdInsIdCd;

    /**
     *  �ֶ���parentId.
     */
    private java.lang.String parentId;

    /**
     *  �ֶ���organizeBm.
     */
    private java.lang.String organizeBm;

    /**
     *  �ֶ���organizeLevel.
     */
    private java.lang.Integer organizeLevel;

/*
0,����Ҫ
1,��Ҫ
*/
    /**
     *  �ֶ���isCheck.
     */
    private java.lang.String isCheck;

    /**
     *  ������tmchntAppGroup.
     */
    private Set tmchntAppGroup;
	
	private List tmchntApps;

    /**
     *  ������triskprocessTimelimitGroup.
     */
    private Set triskprocessTimelimitGroup;
	
	private List triskprocessTimelimits;


    /**
     *  ��parentIdOfTorganizeInfo.
     */
    private TorganizeInfo parentIdOfTorganizeInfo;

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
     *  ��ȡ dwFlag.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getDwFlag() {
        return this.dwFlag;
    }

    /**
     *  ���� dwFlag.
     *  @param dwFlag dwFlag��.
     */
    public void setDwFlag(java.lang.Boolean dwFlag) {
        this.dwFlag = dwFlag;
    }
    /**
     *  ��ȡ originalSort.
     *  @return java.lang.String.
     */
    public java.lang.String getOriginalSort() {
        return this.originalSort;
    }

    /**
     *  ���� originalSort.
     *  @param originalSort originalSort��.
     */
    public void setOriginalSort(java.lang.String originalSort) {
        this.originalSort = originalSort;
    }
    /**
     *  ��ȡ globalSort.
     *  @return java.lang.String.
     */
    public java.lang.String getGlobalSort() {
        return this.globalSort;
    }

    /**
     *  ���� globalSort.
     *  @param globalSort globalSort��.
     */
    public void setGlobalSort(java.lang.String globalSort) {
        this.globalSort = globalSort;
    }
    /**
     *  ��ȡ fwdInsIdCd.
     *  @return java.lang.String.
     */
    public java.lang.String getFwdInsIdCd() {
        return this.fwdInsIdCd;
    }

    /**
     *  ���� fwdInsIdCd.
     *  @param fwdInsIdCd fwdInsIdCd��.
     */
    public void setFwdInsIdCd(java.lang.String fwdInsIdCd) {
        this.fwdInsIdCd = fwdInsIdCd;
    }
    /**
     *  ��ȡ parentId.
     *  @return java.lang.String.
     */
    public java.lang.String getParentId() {
        return this.parentId;
    }

    /**
     *  ���� parentId.
     *  @param parentId parentId��.
     */
    public void setParentId(java.lang.String parentId) {
        this.parentId = parentId;
    }
    /**
     *  ��ȡ organizeBm.
     *  @return java.lang.String.
     */
    public java.lang.String getOrganizeBm() {
        return this.organizeBm;
    }

    /**
     *  ���� organizeBm.
     *  @param organizeBm organizeBm��.
     */
    public void setOrganizeBm(java.lang.String organizeBm) {
        this.organizeBm = organizeBm;
    }
    /**
     *  ��ȡ organizeLevel.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getOrganizeLevel() {
        return this.organizeLevel;
    }

    /**
     *  ���� organizeLevel.
     *  @param organizeLevel organizeLevel��.
     */
    public void setOrganizeLevel(java.lang.Integer organizeLevel) {
        this.organizeLevel = organizeLevel;
    }
    /**
     *  ��ȡ isCheck.
     *  @return java.lang.String.
     */
    public java.lang.String getIsCheck() {
        return this.isCheck;
    }

    /**
     *  ���� isCheck.
     *  @param isCheck isCheck��.
     */
    public void setIsCheck(java.lang.String isCheck) {
        this.isCheck = isCheck;
    }

    /**
     *  ��ȡ tmchntAppGroup.
     *  @return Set.
     */
    public Set getTmchntAppGroup() {
        return this.tmchntAppGroup;
    }

    /**
     *  ���� tmchntAppGroup.
     *  @param tmchntAppGroup tmchntAppGroup��.
     */
    public void setTmchntAppGroup(Set tmchntAppGroup) {
        this.tmchntAppGroup = tmchntAppGroup;
    }
	
	public List getTmchntApps() {
        return this.tmchntApps;
    }

    public void setTmchntApps(List tmchntApps) {
        this.tmchntApps = tmchntApps;
    }
    /**
     *  ��ȡ triskprocessTimelimitGroup.
     *  @return Set.
     */
    public Set getTriskprocessTimelimitGroup() {
        return this.triskprocessTimelimitGroup;
    }

    /**
     *  ���� triskprocessTimelimitGroup.
     *  @param triskprocessTimelimitGroup triskprocessTimelimitGroup��.
     */
    public void setTriskprocessTimelimitGroup(Set triskprocessTimelimitGroup) {
        this.triskprocessTimelimitGroup = triskprocessTimelimitGroup;
    }
	
	public List getTriskprocessTimelimits() {
        return this.triskprocessTimelimits;
    }

    public void setTriskprocessTimelimits(List triskprocessTimelimits) {
        this.triskprocessTimelimits = triskprocessTimelimits;
    }



    /**
     *  ��ȡ parentIdOfTorganizeInfo.
     *  @return TorganizeInfo.
     */
    public TorganizeInfo getParentIdOfTorganizeInfo() {
    	if (this.parentIdOfTorganizeInfo == null && this.parentId != null  && !"".equals(this.parentId)){
    		TorganizeInfoDAO torganizeInfoDAO = (TorganizeInfoDAO)Tools.getBean("torganizeInfoDAO");
    		this.parentIdOfTorganizeInfo= torganizeInfoDAO.getTorganizeInfo(this.parentId);
    	}
        return this.parentIdOfTorganizeInfo;
    }

    /**
     *  ���� parentIdOfTorganizeInfo.
     *  @param parentIdOfTorganizeInfo parentIdOfTorganizeInfo��.
     */
    public void setParentIdOfTorganizeInfo(TorganizeInfo parentIdOfTorganizeInfo) {
        this.parentIdOfTorganizeInfo = parentIdOfTorganizeInfo;
    }

}
