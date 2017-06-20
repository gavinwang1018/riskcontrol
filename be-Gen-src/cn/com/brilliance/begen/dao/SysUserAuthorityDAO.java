package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysUserAuthority;

/**
 * SysUserAuthorityDAO接口.
 * @author Administrator.
 */

public interface SysUserAuthorityDAO {

    /**
     *  根据主键获得SysUserAuthority对象.
     *  @param sysUserAuthorityPrimaryKey SysUserAuthority主键
     *  @return SysUserAuthority.
     */
    SysUserAuthority getSysUserAuthority(java.lang.String sysUserAuthorityPrimaryKey);

    /**
     *  获取SysUserAuthority对象列表.
     *  @param  sysUserAuthority SysUserAuthority对象
     *  @return List.
     */
    List getSysUserAuthorityList(SysUserAuthority sysUserAuthority);

    /**
     *  存储SysUserAuthority对象.
     *  @param  sysUserAuthority SysUserAuthority对象
     *  @return SysUserAuthority.
     */
    SysUserAuthority saveSysUserAuthority(SysUserAuthority sysUserAuthority);

    /**
     *  删除SysUserAuthority对象.
     *  @param sysUserAuthorityPrimaryKey SysUserAuthority主键.
     */
    void removeSysUserAuthority(java.lang.String sysUserAuthorityPrimaryKey);

    /**
     *  根据查询条件获取SysUserAuthority对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysUserAuthorityListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysUserAuthority对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysUserAuthorityListOfNoAuthorityQuery(Map queryMap);
}
