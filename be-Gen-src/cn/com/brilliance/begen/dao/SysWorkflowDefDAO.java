package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.model.SysWorkflowDef;

/**
 * SysWorkflowDefDAO接口.
 * @author Administrator.
 */

public interface SysWorkflowDefDAO {

    /**
     *  根据主键获得SysWorkflowDef对象.
     *  @param sysWorkflowDefPrimaryKey SysWorkflowDef主键
     *  @return SysWorkflowDef.
     */
    SysWorkflowDef getSysWorkflowDef(java.lang.String sysWorkflowDefPrimaryKey);

    /**
     *  获取SysWorkflowDef对象列表.
     *  @param  sysWorkflowDef SysWorkflowDef对象
     *  @return List.
     */
    List getSysWorkflowDefList(SysWorkflowDef sysWorkflowDef);

    /**
     *  存储SysWorkflowDef对象.
     *  @param  sysWorkflowDef SysWorkflowDef对象
     *  @return SysWorkflowDef.
     */
    SysWorkflowDef saveSysWorkflowDef(SysWorkflowDef sysWorkflowDef);

    /**
     *  删除SysWorkflowDef对象.
     *  @param sysWorkflowDefPrimaryKey SysWorkflowDef主键.
     */
    void removeSysWorkflowDef(java.lang.String sysWorkflowDefPrimaryKey);

    /**
     *  根据查询条件获取SysWorkflowDef对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysWorkflowDefListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysWorkflowDef对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysWorkflowDefListOfNoAuthorityQuery(Map queryMap);
}
