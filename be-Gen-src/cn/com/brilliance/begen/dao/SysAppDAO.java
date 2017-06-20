package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysApp;

/**
 * SysAppDAO接口.
 * @author Administrator.
 */

public interface SysAppDAO {

    /**
     *  根据主键获得SysApp对象.
     *  @param sysAppPrimaryKey SysApp主键
     *  @return SysApp.
     */
    SysApp getSysApp(java.lang.String sysAppPrimaryKey);

    /**
     *  获取SysApp对象列表.
     *  @param  sysApp SysApp对象
     *  @return List.
     */
    List getSysAppList(SysApp sysApp);

    /**
     *  存储SysApp对象.
     *  @param  sysApp SysApp对象
     *  @return SysApp.
     */
    SysApp saveSysApp(SysApp sysApp);

    /**
     *  删除SysApp对象.
     *  @param sysAppPrimaryKey SysApp主键.
     */
    void removeSysApp(java.lang.String sysAppPrimaryKey);

    /**
     *  根据查询条件获取SysApp对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysAppListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysApp对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysAppListOfNoAuthorityQuery(Map queryMap);
}
