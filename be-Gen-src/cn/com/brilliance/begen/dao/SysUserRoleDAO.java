package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysUserRole;

/**
 * SysUserRoleDAO接口.
 * @author Administrator.
 */

public interface SysUserRoleDAO {

    /**
     *  根据主键获得SysUserRole对象.
     *  @param sysUserRolePrimaryKey SysUserRole主键
     *  @return SysUserRole.
     */
    SysUserRole getSysUserRole(java.lang.String sysUserRolePrimaryKey);

    /**
     *  获取SysUserRole对象列表.
     *  @param  sysUserRole SysUserRole对象
     *  @return List.
     */
    List getSysUserRoleList(SysUserRole sysUserRole);

    /**
     *  存储SysUserRole对象.
     *  @param  sysUserRole SysUserRole对象
     *  @return SysUserRole.
     */
    SysUserRole saveSysUserRole(SysUserRole sysUserRole);

    /**
     *  删除SysUserRole对象.
     *  @param sysUserRolePrimaryKey SysUserRole主键.
     */
    void removeSysUserRole(java.lang.String sysUserRolePrimaryKey);

    /**
     *  根据查询条件获取SysUserRole对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysUserRoleListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysUserRole对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysUserRoleListOfNoAuthorityQuery(Map queryMap);
}
