package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysOrg;

/**
 * SysOrgDAO接口.
 * @author Administrator.
 */

public interface SysOrgDAO {

    /**
     *  根据主键获得SysOrg对象.
     *  @param sysOrgPrimaryKey SysOrg主键
     *  @return SysOrg.
     */
    SysOrg getSysOrg(java.lang.String sysOrgPrimaryKey);

    /**
     *  获取SysOrg对象列表.
     *  @param  sysOrg SysOrg对象
     *  @return List.
     */
    List getSysOrgList(SysOrg sysOrg);

    /**
     *  存储SysOrg对象.
     *  @param  sysOrg SysOrg对象
     *  @return SysOrg.
     */
    SysOrg saveSysOrg(SysOrg sysOrg);

    /**
     *  删除SysOrg对象.
     *  @param sysOrgPrimaryKey SysOrg主键.
     */
    void removeSysOrg(java.lang.String sysOrgPrimaryKey);

    /**
     *  根据查询条件获取SysOrg对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysOrgListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysOrg对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysOrgListOfNoAuthorityQuery(Map queryMap);
}
