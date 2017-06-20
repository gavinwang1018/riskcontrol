package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysRoleAuthority;

/**
 * SysRoleAuthorityDAO接口.
 * @author Administrator.
 */

public interface SysRoleAuthorityDAO {

    /**
     *  根据主键获得SysRoleAuthority对象.
     *  @param sysRoleAuthorityPrimaryKey SysRoleAuthority主键
     *  @return SysRoleAuthority.
     */
    SysRoleAuthority getSysRoleAuthority(java.lang.String sysRoleAuthorityPrimaryKey);

    /**
     *  获取SysRoleAuthority对象列表.
     *  @param  sysRoleAuthority SysRoleAuthority对象
     *  @return List.
     */
    List getSysRoleAuthorityList(SysRoleAuthority sysRoleAuthority);

    /**
     *  存储SysRoleAuthority对象.
     *  @param  sysRoleAuthority SysRoleAuthority对象
     *  @return SysRoleAuthority.
     */
    SysRoleAuthority saveSysRoleAuthority(SysRoleAuthority sysRoleAuthority);

    /**
     *  删除SysRoleAuthority对象.
     *  @param sysRoleAuthorityPrimaryKey SysRoleAuthority主键.
     */
    void removeSysRoleAuthority(java.lang.String sysRoleAuthorityPrimaryKey);

    /**
     *  根据查询条件获取SysRoleAuthority对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysRoleAuthorityListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysRoleAuthority对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysRoleAuthorityListOfNoAuthorityQuery(Map queryMap);
}
