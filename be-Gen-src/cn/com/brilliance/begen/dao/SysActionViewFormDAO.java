package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysActionViewForm;

/**
 * SysActionViewFormDAO接口.
 * @author Administrator.
 */

public interface SysActionViewFormDAO {

    /**
     *  根据主键获得SysActionViewForm对象.
     *  @param sysActionViewFormPrimaryKey SysActionViewForm主键
     *  @return SysActionViewForm.
     */
    SysActionViewForm getSysActionViewForm(java.lang.String sysActionViewFormPrimaryKey);

    /**
     *  获取SysActionViewForm对象列表.
     *  @param  sysActionViewForm SysActionViewForm对象
     *  @return List.
     */
    List getSysActionViewFormList(SysActionViewForm sysActionViewForm);

    /**
     *  存储SysActionViewForm对象.
     *  @param  sysActionViewForm SysActionViewForm对象
     *  @return SysActionViewForm.
     */
    SysActionViewForm saveSysActionViewForm(SysActionViewForm sysActionViewForm);

    /**
     *  删除SysActionViewForm对象.
     *  @param sysActionViewFormPrimaryKey SysActionViewForm主键.
     */
    void removeSysActionViewForm(java.lang.String sysActionViewFormPrimaryKey);

    /**
     *  根据查询条件获取SysActionViewForm对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysActionViewFormListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysActionViewForm对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysActionViewFormListOfNoAuthorityQuery(Map queryMap);
}
