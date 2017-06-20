package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysWorkflowInsProc;

/**
 * SysWorkflowInsProcDAO接口.
 * @author Administrator.
 */

public interface SysWorkflowInsProcDAO {

    /**
     *  根据主键获得SysWorkflowInsProc对象.
     *  @param sysWorkflowInsProcPrimaryKey SysWorkflowInsProc主键
     *  @return SysWorkflowInsProc.
     */
    SysWorkflowInsProc getSysWorkflowInsProc(java.lang.String sysWorkflowInsProcPrimaryKey);

    /**
     *  获取SysWorkflowInsProc对象列表.
     *  @param  sysWorkflowInsProc SysWorkflowInsProc对象
     *  @return List.
     */
    List getSysWorkflowInsProcList(SysWorkflowInsProc sysWorkflowInsProc);

    /**
     *  存储SysWorkflowInsProc对象.
     *  @param  sysWorkflowInsProc SysWorkflowInsProc对象
     *  @return SysWorkflowInsProc.
     */
    SysWorkflowInsProc saveSysWorkflowInsProc(SysWorkflowInsProc sysWorkflowInsProc);

    /**
     *  删除SysWorkflowInsProc对象.
     *  @param sysWorkflowInsProcPrimaryKey SysWorkflowInsProc主键.
     */
    void removeSysWorkflowInsProc(java.lang.String sysWorkflowInsProcPrimaryKey);

    /**
     *  根据查询条件获取SysWorkflowInsProc对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysWorkflowInsProcListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysWorkflowInsProc对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysWorkflowInsProcListOfNoAuthorityQuery(Map queryMap);
}
