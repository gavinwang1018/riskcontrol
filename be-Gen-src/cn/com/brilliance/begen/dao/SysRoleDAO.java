package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysRole;

/**
 * SysRoleDAO接口.
 * @author Administrator.
 */

public interface SysRoleDAO {

    /**
     *  根据主键获得SysRole对象.
     *  @param sysRolePrimaryKey SysRole主键
     *  @return SysRole.
     */
    SysRole getSysRole(java.lang.String sysRolePrimaryKey);

    /**
     *  获取SysRole对象列表.
     *  @param  sysRole SysRole对象
     *  @return List.
     */
    List getSysRoleList(SysRole sysRole);

    /**
     *  存储SysRole对象.
     *  @param  sysRole SysRole对象
     *  @return SysRole.
     */
    SysRole saveSysRole(SysRole sysRole);

    /**
     *  删除SysRole对象.
     *  @param sysRolePrimaryKey SysRole主键.
     */
    void removeSysRole(java.lang.String sysRolePrimaryKey);

    /**
     *  根据查询条件获取SysRole对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysRoleListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysRole对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysRoleListOfNoAuthorityQuery(Map queryMap);
}
