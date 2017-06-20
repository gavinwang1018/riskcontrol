package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysReportGroupDef;

/**
 * SysReportGroupDefDAO接口.
 * @author Administrator.
 */

public interface SysReportGroupDefDAO {

    /**
     *  根据主键获得SysReportGroupDef对象.
     *  @param sysReportGroupDefPrimaryKey SysReportGroupDef主键
     *  @return SysReportGroupDef.
     */
    SysReportGroupDef getSysReportGroupDef(java.lang.String sysReportGroupDefPrimaryKey);

    /**
     *  获取SysReportGroupDef对象列表.
     *  @param  sysReportGroupDef SysReportGroupDef对象
     *  @return List.
     */
    List getSysReportGroupDefList(SysReportGroupDef sysReportGroupDef);

    /**
     *  存储SysReportGroupDef对象.
     *  @param  sysReportGroupDef SysReportGroupDef对象
     *  @return SysReportGroupDef.
     */
    SysReportGroupDef saveSysReportGroupDef(SysReportGroupDef sysReportGroupDef);

    /**
     *  删除SysReportGroupDef对象.
     *  @param sysReportGroupDefPrimaryKey SysReportGroupDef主键.
     */
    void removeSysReportGroupDef(java.lang.String sysReportGroupDefPrimaryKey);

    /**
     *  根据查询条件获取SysReportGroupDef对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysReportGroupDefListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysReportGroupDef对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysReportGroupDefListOfNoAuthorityQuery(Map queryMap);
}
