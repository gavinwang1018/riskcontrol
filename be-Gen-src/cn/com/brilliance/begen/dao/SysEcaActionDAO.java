package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysEcaAction;

/**
 * SysEcaActionDAO接口.
 * @author Administrator.
 */

public interface SysEcaActionDAO {

    /**
     *  根据主键获得SysEcaAction对象.
     *  @param sysEcaActionPrimaryKey SysEcaAction主键
     *  @return SysEcaAction.
     */
    SysEcaAction getSysEcaAction(java.lang.String sysEcaActionPrimaryKey);

    /**
     *  获取SysEcaAction对象列表.
     *  @param  sysEcaAction SysEcaAction对象
     *  @return List.
     */
    List getSysEcaActionList(SysEcaAction sysEcaAction);

    /**
     *  存储SysEcaAction对象.
     *  @param  sysEcaAction SysEcaAction对象
     *  @return SysEcaAction.
     */
    SysEcaAction saveSysEcaAction(SysEcaAction sysEcaAction);

    /**
     *  删除SysEcaAction对象.
     *  @param sysEcaActionPrimaryKey SysEcaAction主键.
     */
    void removeSysEcaAction(java.lang.String sysEcaActionPrimaryKey);

    /**
     *  根据查询条件获取SysEcaAction对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysEcaActionListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysEcaAction对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysEcaActionListOfNoAuthorityQuery(Map queryMap);
}
