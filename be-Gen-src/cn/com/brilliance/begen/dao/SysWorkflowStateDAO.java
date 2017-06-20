package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.model.SysWorkflowState;

/**
 * SysWorkflowStateDAO接口.
 * @author Administrator.
 */

public interface SysWorkflowStateDAO {

    /**
     *  根据主键获得SysWorkflowState对象.
     *  @param sysWorkflowStatePrimaryKey SysWorkflowState主键
     *  @return SysWorkflowState.
     */
    SysWorkflowState getSysWorkflowState(java.lang.String sysWorkflowStatePrimaryKey);

    /**
     *  获取SysWorkflowState对象列表.
     *  @param  sysWorkflowState SysWorkflowState对象
     *  @return List.
     */
    List getSysWorkflowStateList(SysWorkflowState sysWorkflowState);

    /**
     *  存储SysWorkflowState对象.
     *  @param  sysWorkflowState SysWorkflowState对象
     *  @return SysWorkflowState.
     */
    SysWorkflowState saveSysWorkflowState(SysWorkflowState sysWorkflowState);

    /**
     *  删除SysWorkflowState对象.
     *  @param sysWorkflowStatePrimaryKey SysWorkflowState主键.
     */
    void removeSysWorkflowState(java.lang.String sysWorkflowStatePrimaryKey);

    /**
     *  根据查询条件获取SysWorkflowState对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysWorkflowStateListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysWorkflowState对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysWorkflowStateListOfNoAuthorityQuery(Map queryMap);
}
