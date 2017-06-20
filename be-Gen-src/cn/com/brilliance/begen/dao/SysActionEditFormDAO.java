package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysActionEditForm;

/**
 * SysActionEditFormDAO接口.
 * @author Administrator.
 */

public interface SysActionEditFormDAO {

    /**
     *  根据主键获得SysActionEditForm对象.
     *  @param sysActionEditFormPrimaryKey SysActionEditForm主键
     *  @return SysActionEditForm.
     */
    SysActionEditForm getSysActionEditForm(java.lang.String sysActionEditFormPrimaryKey);

    /**
     *  获取SysActionEditForm对象列表.
     *  @param  sysActionEditForm SysActionEditForm对象
     *  @return List.
     */
    List getSysActionEditFormList(SysActionEditForm sysActionEditForm);

    /**
     *  存储SysActionEditForm对象.
     *  @param  sysActionEditForm SysActionEditForm对象
     *  @return SysActionEditForm.
     */
    SysActionEditForm saveSysActionEditForm(SysActionEditForm sysActionEditForm);

    /**
     *  删除SysActionEditForm对象.
     *  @param sysActionEditFormPrimaryKey SysActionEditForm主键.
     */
    void removeSysActionEditForm(java.lang.String sysActionEditFormPrimaryKey);

    /**
     *  根据查询条件获取SysActionEditForm对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysActionEditFormListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysActionEditForm对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysActionEditFormListOfNoAuthorityQuery(Map queryMap);
}
