package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysUser;

/**
 * SysUserDAO接口.
 * @author Administrator.
 */

public interface SysUserDAO {

    /**
     *  根据主键获得SysUser对象.
     *  @param sysUserPrimaryKey SysUser主键
     *  @return SysUser.
     */
    SysUser getSysUser(java.lang.String sysUserPrimaryKey);

    /**
     *  获取SysUser对象列表.
     *  @param  sysUser SysUser对象
     *  @return List.
     */
    List getSysUserList(SysUser sysUser);

    /**
     *  存储SysUser对象.
     *  @param  sysUser SysUser对象
     *  @return SysUser.
     */
    SysUser saveSysUser(SysUser sysUser);

    /**
     *  删除SysUser对象.
     *  @param sysUserPrimaryKey SysUser主键.
     */
    void removeSysUser(java.lang.String sysUserPrimaryKey);

    /**
     *  根据查询条件获取SysUser对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysUserListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysUser对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysUserListOfNoAuthorityQuery(Map queryMap);
}
