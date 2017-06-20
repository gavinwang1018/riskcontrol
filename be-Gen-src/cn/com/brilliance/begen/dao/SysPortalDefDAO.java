package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysPortalDef;

/**
 * SysPortalDefDAO接口.
 * @author Administrator.
 */

public interface SysPortalDefDAO {

    /**
     *  根据主键获得SysPortalDef对象.
     *  @param sysPortalDefPrimaryKey SysPortalDef主键
     *  @return SysPortalDef.
     */
    SysPortalDef getSysPortalDef(java.lang.String sysPortalDefPrimaryKey);

    /**
     *  获取SysPortalDef对象列表.
     *  @param  sysPortalDef SysPortalDef对象
     *  @return List.
     */
    List getSysPortalDefList(SysPortalDef sysPortalDef);

    /**
     *  存储SysPortalDef对象.
     *  @param  sysPortalDef SysPortalDef对象
     *  @return SysPortalDef.
     */
    SysPortalDef saveSysPortalDef(SysPortalDef sysPortalDef);

    /**
     *  删除SysPortalDef对象.
     *  @param sysPortalDefPrimaryKey SysPortalDef主键.
     */
    void removeSysPortalDef(java.lang.String sysPortalDefPrimaryKey);

    /**
     *  根据查询条件获取SysPortalDef对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysPortalDefListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysPortalDef对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysPortalDefListOfNoAuthorityQuery(Map queryMap);
}
