package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysWorkflowInsTask;

/**
 * SysWorkflowInsTaskDAO接口.
 * @author Administrator.
 */

public interface SysWorkflowInsTaskDAO {

    /**
     *  根据主键获得SysWorkflowInsTask对象.
     *  @param sysWorkflowInsTaskPrimaryKey SysWorkflowInsTask主键
     *  @return SysWorkflowInsTask.
     */
    SysWorkflowInsTask getSysWorkflowInsTask(java.lang.String sysWorkflowInsTaskPrimaryKey);

    /**
     *  获取SysWorkflowInsTask对象列表.
     *  @param  sysWorkflowInsTask SysWorkflowInsTask对象
     *  @return List.
     */
    List getSysWorkflowInsTaskList(SysWorkflowInsTask sysWorkflowInsTask);

    /**
     *  存储SysWorkflowInsTask对象.
     *  @param  sysWorkflowInsTask SysWorkflowInsTask对象
     *  @return SysWorkflowInsTask.
     */
    SysWorkflowInsTask saveSysWorkflowInsTask(SysWorkflowInsTask sysWorkflowInsTask);

    /**
     *  删除SysWorkflowInsTask对象.
     *  @param sysWorkflowInsTaskPrimaryKey SysWorkflowInsTask主键.
     */
    void removeSysWorkflowInsTask(java.lang.String sysWorkflowInsTaskPrimaryKey);

    /**
     *  根据查询条件获取SysWorkflowInsTask对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysWorkflowInsTaskListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysWorkflowInsTask对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysWorkflowInsTaskListOfNoAuthorityQuery(Map queryMap);
}
