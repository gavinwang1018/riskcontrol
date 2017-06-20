package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysReportDef;

/**
 * SysReportDefDAO接口.
 * @author Administrator.
 */

public interface SysReportDefDAO {

    /**
     *  根据主键获得SysReportDef对象.
     *  @param sysReportDefPrimaryKey SysReportDef主键
     *  @return SysReportDef.
     */
    SysReportDef getSysReportDef(java.lang.String sysReportDefPrimaryKey);

    /**
     *  获取SysReportDef对象列表.
     *  @param  sysReportDef SysReportDef对象
     *  @return List.
     */
    List getSysReportDefList(SysReportDef sysReportDef);

    /**
     *  存储SysReportDef对象.
     *  @param  sysReportDef SysReportDef对象
     *  @return SysReportDef.
     */
    SysReportDef saveSysReportDef(SysReportDef sysReportDef);

    /**
     *  删除SysReportDef对象.
     *  @param sysReportDefPrimaryKey SysReportDef主键.
     */
    void removeSysReportDef(java.lang.String sysReportDefPrimaryKey);

    /**
     *  根据查询条件获取SysReportDef对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysReportDefListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysReportDef对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysReportDefListOfNoAuthorityQuery(Map queryMap);
}
