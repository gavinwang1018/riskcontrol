package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysReportQueryDef;

/**
 * SysReportQueryDefDAO接口.
 * @author Administrator.
 */

public interface SysReportQueryDefDAO {

    /**
     *  根据主键获得SysReportQueryDef对象.
     *  @param sysReportQueryDefPrimaryKey SysReportQueryDef主键
     *  @return SysReportQueryDef.
     */
    SysReportQueryDef getSysReportQueryDef(java.lang.String sysReportQueryDefPrimaryKey);

    /**
     *  获取SysReportQueryDef对象列表.
     *  @param  sysReportQueryDef SysReportQueryDef对象
     *  @return List.
     */
    List getSysReportQueryDefList(SysReportQueryDef sysReportQueryDef);

    /**
     *  存储SysReportQueryDef对象.
     *  @param  sysReportQueryDef SysReportQueryDef对象
     *  @return SysReportQueryDef.
     */
    SysReportQueryDef saveSysReportQueryDef(SysReportQueryDef sysReportQueryDef);

    /**
     *  删除SysReportQueryDef对象.
     *  @param sysReportQueryDefPrimaryKey SysReportQueryDef主键.
     */
    void removeSysReportQueryDef(java.lang.String sysReportQueryDefPrimaryKey);

    /**
     *  根据查询条件获取SysReportQueryDef对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysReportQueryDefListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysReportQueryDef对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysReportQueryDefListOfNoAuthorityQuery(Map queryMap);
}
