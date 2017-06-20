package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysItem;

/**
 * SysItemDAO接口.
 * @author Administrator.
 */

public interface SysItemDAO {

    /**
     *  根据主键获得SysItem对象.
     *  @param sysItemPrimaryKey SysItem主键
     *  @return SysItem.
     */
    SysItem getSysItem(java.lang.String sysItemPrimaryKey);

    /**
     *  获取SysItem对象列表.
     *  @param  sysItem SysItem对象
     *  @return List.
     */
    List getSysItemList(SysItem sysItem);

    /**
     *  存储SysItem对象.
     *  @param  sysItem SysItem对象
     *  @return SysItem.
     */
    SysItem saveSysItem(SysItem sysItem);

    /**
     *  删除SysItem对象.
     *  @param sysItemPrimaryKey SysItem主键.
     */
    void removeSysItem(java.lang.String sysItemPrimaryKey);

    /**
     *  根据查询条件获取SysItem对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysItemListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysItem对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysItemListOfNoAuthorityQuery(Map queryMap);
}
