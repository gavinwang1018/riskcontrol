package cn.com.brilliance.begen.model;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.common.Tools;

    /**
     *  定义类TorganizeInfo.
     */
public class TorganizeInfo extends BaseModel implements Serializable {

	private int _edit_flag;
	
	private int _record_index;

	private boolean _checked_flag;
    /**
     *  字段域id.
     */
    private java.lang.String id;

    /**
     *  字段域name.
     */
    private java.lang.String name;

    /**
     *  字段域dwFlag.
     */
    private java.lang.Boolean dwFlag;

    /**
     *  字段域originalSort.
     */
    private java.lang.String originalSort;

    /**
     *  字段域globalSort.
     */
    private java.lang.String globalSort;

    /**
     *  字段域fwdInsIdCd.
     */
    private java.lang.String fwdInsIdCd;

    /**
     *  字段域parentId.
     */
    private java.lang.String parentId;

    /**
     *  字段域organizeBm.
     */
    private java.lang.String organizeBm;

    /**
     *  字段域organizeLevel.
     */
    private java.lang.Integer organizeLevel;

/*
0,不需要
1,需要
*/
    /**
     *  字段域isCheck.
     */
    private java.lang.String isCheck;

    /**
     *  集合域tmchntAppGroup.
     */
    private Set tmchntAppGroup;
	
	private List tmchntApps;

    /**
     *  集合域triskprocessTimelimitGroup.
     */
    private Set triskprocessTimelimitGroup;
	
	private List triskprocessTimelimits;


    /**
     *  域parentIdOfTorganizeInfo.
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
     *  获取 dwFlag.
     *  @return java.lang.Boolean.
     */
    public java.lang.Boolean getDwFlag() {
        return this.dwFlag;
    }

    /**
     *  设置 dwFlag.
     *  @param dwFlag dwFlag域.
     */
    public void setDwFlag(java.lang.Boolean dwFlag) {
        this.dwFlag = dwFlag;
    }
    /**
     *  获取 originalSort.
     *  @return java.lang.String.
     */
    public java.lang.String getOriginalSort() {
        return this.originalSort;
    }

    /**
     *  设置 originalSort.
     *  @param originalSort originalSort域.
     */
    public void setOriginalSort(java.lang.String originalSort) {
        this.originalSort = originalSort;
    }
    /**
     *  获取 globalSort.
     *  @return java.lang.String.
     */
    public java.lang.String getGlobalSort() {
        return this.globalSort;
    }

    /**
     *  设置 globalSort.
     *  @param globalSort globalSort域.
     */
    public void setGlobalSort(java.lang.String globalSort) {
        this.globalSort = globalSort;
    }
    /**
     *  获取 fwdInsIdCd.
     *  @return java.lang.String.
     */
    public java.lang.String getFwdInsIdCd() {
        return this.fwdInsIdCd;
    }

    /**
     *  设置 fwdInsIdCd.
     *  @param fwdInsIdCd fwdInsIdCd域.
     */
    public void setFwdInsIdCd(java.lang.String fwdInsIdCd) {
        this.fwdInsIdCd = fwdInsIdCd;
    }
    /**
     *  获取 parentId.
     *  @return java.lang.String.
     */
    public java.lang.String getParentId() {
        return this.parentId;
    }

    /**
     *  设置 parentId.
     *  @param parentId parentId域.
     */
    public void setParentId(java.lang.String parentId) {
        this.parentId = parentId;
    }
    /**
     *  获取 organizeBm.
     *  @return java.lang.String.
     */
    public java.lang.String getOrganizeBm() {
        return this.organizeBm;
    }

    /**
     *  设置 organizeBm.
     *  @param organizeBm organizeBm域.
     */
    public void setOrganizeBm(java.lang.String organizeBm) {
        this.organizeBm = organizeBm;
    }
    /**
     *  获取 organizeLevel.
     *  @return java.lang.Integer.
     */
    public java.lang.Integer getOrganizeLevel() {
        return this.organizeLevel;
    }

    /**
     *  设置 organizeLevel.
     *  @param organizeLevel organizeLevel域.
     */
    public void setOrganizeLevel(java.lang.Integer organizeLevel) {
        this.organizeLevel = organizeLevel;
    }
    /**
     *  获取 isCheck.
     *  @return java.lang.String.
     */
    public java.lang.String getIsCheck() {
        return this.isCheck;
    }

    /**
     *  设置 isCheck.
     *  @param isCheck isCheck域.
     */
    public void setIsCheck(java.lang.String isCheck) {
        this.isCheck = isCheck;
    }

    /**
     *  获取 tmchntAppGroup.
     *  @return Set.
     */
    public Set getTmchntAppGroup() {
        return this.tmchntAppGroup;
    }

    /**
     *  设置 tmchntAppGroup.
     *  @param tmchntAppGroup tmchntAppGroup域.
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
     *  获取 triskprocessTimelimitGroup.
     *  @return Set.
     */
    public Set getTriskprocessTimelimitGroup() {
        return this.triskprocessTimelimitGroup;
    }

    /**
     *  设置 triskprocessTimelimitGroup.
     *  @param triskprocessTimelimitGroup triskprocessTimelimitGroup域.
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
     *  获取 parentIdOfTorganizeInfo.
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
     *  设置 parentIdOfTorganizeInfo.
     *  @param parentIdOfTorganizeInfo parentIdOfTorganizeInfo域.
     */
    public void setParentIdOfTorganizeInfo(TorganizeInfo parentIdOfTorganizeInfo) {
        this.parentIdOfTorganizeInfo = parentIdOfTorganizeInfo;
    }

}
