package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysListLayout;

/**
 * SysListLayoutDAO接口.
 * @author Administrator.
 */

public interface SysListLayoutDAO {

    /**
     *  根据主键获得SysListLayout对象.
     *  @param sysListLayoutPrimaryKey SysListLayout主键
     *  @return SysListLayout.
     */
    SysListLayout getSysListLayout(java.lang.String sysListLayoutPrimaryKey);

    /**
     *  获取SysListLayout对象列表.
     *  @param  sysListLayout SysListLayout对象
     *  @return List.
     */
    List getSysListLayoutList(SysListLayout sysListLayout);

    /**
     *  存储SysListLayout对象.
     *  @param  sysListLayout SysListLayout对象
     *  @return SysListLayout.
     */
    SysListLayout saveSysListLayout(SysListLayout sysListLayout);

    /**
     *  删除SysListLayout对象.
     *  @param sysListLayoutPrimaryKey SysListLayout主键.
     */
    void removeSysListLayout(java.lang.String sysListLayoutPrimaryKey);

    /**
     *  根据查询条件获取SysListLayout对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysListLayoutListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysListLayout对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysListLayoutListOfNoAuthorityQuery(Map queryMap);
}
