package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysRelative;

/**
 * SysRelativeDAO接口.
 * @author Administrator.
 */

public interface SysRelativeDAO {

    /**
     *  根据主键获得SysRelative对象.
     *  @param sysRelativePrimaryKey SysRelative主键
     *  @return SysRelative.
     */
    SysRelative getSysRelative(java.lang.String sysRelativePrimaryKey);

    /**
     *  获取SysRelative对象列表.
     *  @param  sysRelative SysRelative对象
     *  @return List.
     */
    List getSysRelativeList(SysRelative sysRelative);

    /**
     *  存储SysRelative对象.
     *  @param  sysRelative SysRelative对象
     *  @return SysRelative.
     */
    SysRelative saveSysRelative(SysRelative sysRelative);

    /**
     *  删除SysRelative对象.
     *  @param sysRelativePrimaryKey SysRelative主键.
     */
    void removeSysRelative(java.lang.String sysRelativePrimaryKey);

    /**
     *  根据查询条件获取SysRelative对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysRelativeListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysRelative对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysRelativeListOfNoAuthorityQuery(Map queryMap);
}
