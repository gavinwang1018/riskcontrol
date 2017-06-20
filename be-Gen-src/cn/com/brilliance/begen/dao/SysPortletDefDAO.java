package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysPortletDef;

/**
 * SysPortletDefDAO接口.
 * @author Administrator.
 */

public interface SysPortletDefDAO {

    /**
     *  根据主键获得SysPortletDef对象.
     *  @param sysPortletDefPrimaryKey SysPortletDef主键
     *  @return SysPortletDef.
     */
    SysPortletDef getSysPortletDef(java.lang.String sysPortletDefPrimaryKey);

    /**
     *  获取SysPortletDef对象列表.
     *  @param  sysPortletDef SysPortletDef对象
     *  @return List.
     */
    List getSysPortletDefList(SysPortletDef sysPortletDef);

    /**
     *  存储SysPortletDef对象.
     *  @param  sysPortletDef SysPortletDef对象
     *  @return SysPortletDef.
     */
    SysPortletDef saveSysPortletDef(SysPortletDef sysPortletDef);

    /**
     *  删除SysPortletDef对象.
     *  @param sysPortletDefPrimaryKey SysPortletDef主键.
     */
    void removeSysPortletDef(java.lang.String sysPortletDefPrimaryKey);

    /**
     *  根据查询条件获取SysPortletDef对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysPortletDefListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysPortletDef对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysPortletDefListOfNoAuthorityQuery(Map queryMap);
}
