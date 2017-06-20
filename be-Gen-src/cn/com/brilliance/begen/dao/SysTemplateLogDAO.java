package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysTemplateLog;

/**
 * SysTemplateLogDAO接口.
 * @author Administrator.
 */

public interface SysTemplateLogDAO {

    /**
     *  根据主键获得SysTemplateLog对象.
     *  @param sysTemplateLogPrimaryKey SysTemplateLog主键
     *  @return SysTemplateLog.
     */
    SysTemplateLog getSysTemplateLog(java.lang.String sysTemplateLogPrimaryKey);

    /**
     *  获取SysTemplateLog对象列表.
     *  @param  sysTemplateLog SysTemplateLog对象
     *  @return List.
     */
    List getSysTemplateLogList(SysTemplateLog sysTemplateLog);

    /**
     *  存储SysTemplateLog对象.
     *  @param  sysTemplateLog SysTemplateLog对象
     *  @return SysTemplateLog.
     */
    SysTemplateLog saveSysTemplateLog(SysTemplateLog sysTemplateLog);

    /**
     *  删除SysTemplateLog对象.
     *  @param sysTemplateLogPrimaryKey SysTemplateLog主键.
     */
    void removeSysTemplateLog(java.lang.String sysTemplateLogPrimaryKey);

    /**
     *  根据查询条件获取SysTemplateLog对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysTemplateLogListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysTemplateLog对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysTemplateLogListOfNoAuthorityQuery(Map queryMap);
}
