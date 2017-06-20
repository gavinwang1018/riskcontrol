package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysMenu;

/**
 * SysMenuDAO接口.
 * @author Administrator.
 */

public interface SysMenuDAO {

    /**
     *  根据主键获得SysMenu对象.
     *  @param sysMenuPrimaryKey SysMenu主键
     *  @return SysMenu.
     */
    SysMenu getSysMenu(java.lang.String sysMenuPrimaryKey);

    /**
     *  获取SysMenu对象列表.
     *  @param  sysMenu SysMenu对象
     *  @return List.
     */
    List getSysMenuList(SysMenu sysMenu);

    /**
     *  存储SysMenu对象.
     *  @param  sysMenu SysMenu对象
     *  @return SysMenu.
     */
    SysMenu saveSysMenu(SysMenu sysMenu);

    /**
     *  删除SysMenu对象.
     *  @param sysMenuPrimaryKey SysMenu主键.
     */
    void removeSysMenu(java.lang.String sysMenuPrimaryKey);

    /**
     *  根据查询条件获取SysMenu对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysMenuListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysMenu对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysMenuListOfNoAuthorityQuery(Map queryMap);
}
