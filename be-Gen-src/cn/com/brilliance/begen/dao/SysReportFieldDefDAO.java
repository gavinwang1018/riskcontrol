package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysReportFieldDef;

/**
 * SysReportFieldDefDAO接口.
 * @author Administrator.
 */

public interface SysReportFieldDefDAO {

    /**
     *  根据主键获得SysReportFieldDef对象.
     *  @param sysReportFieldDefPrimaryKey SysReportFieldDef主键
     *  @return SysReportFieldDef.
     */
    SysReportFieldDef getSysReportFieldDef(java.lang.String sysReportFieldDefPrimaryKey);

    /**
     *  获取SysReportFieldDef对象列表.
     *  @param  sysReportFieldDef SysReportFieldDef对象
     *  @return List.
     */
    List getSysReportFieldDefList(SysReportFieldDef sysReportFieldDef);

    /**
     *  存储SysReportFieldDef对象.
     *  @param  sysReportFieldDef SysReportFieldDef对象
     *  @return SysReportFieldDef.
     */
    SysReportFieldDef saveSysReportFieldDef(SysReportFieldDef sysReportFieldDef);

    /**
     *  删除SysReportFieldDef对象.
     *  @param sysReportFieldDefPrimaryKey SysReportFieldDef主键.
     */
    void removeSysReportFieldDef(java.lang.String sysReportFieldDefPrimaryKey);

    /**
     *  根据查询条件获取SysReportFieldDef对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysReportFieldDefListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysReportFieldDef对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysReportFieldDefListOfNoAuthorityQuery(Map queryMap);
}
