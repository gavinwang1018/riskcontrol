package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysRelativeAction;

/**
 * SysRelativeActionDAO接口.
 * @author Administrator.
 */

public interface SysRelativeActionDAO {

    /**
     *  根据主键获得SysRelativeAction对象.
     *  @param sysRelativeActionPrimaryKey SysRelativeAction主键
     *  @return SysRelativeAction.
     */
    SysRelativeAction getSysRelativeAction(java.lang.String sysRelativeActionPrimaryKey);

    /**
     *  获取SysRelativeAction对象列表.
     *  @param  sysRelativeAction SysRelativeAction对象
     *  @return List.
     */
    List getSysRelativeActionList(SysRelativeAction sysRelativeAction);

    /**
     *  存储SysRelativeAction对象.
     *  @param  sysRelativeAction SysRelativeAction对象
     *  @return SysRelativeAction.
     */
    SysRelativeAction saveSysRelativeAction(SysRelativeAction sysRelativeAction);

    /**
     *  删除SysRelativeAction对象.
     *  @param sysRelativeActionPrimaryKey SysRelativeAction主键.
     */
    void removeSysRelativeAction(java.lang.String sysRelativeActionPrimaryKey);

    /**
     *  根据查询条件获取SysRelativeAction对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysRelativeActionListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysRelativeAction对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysRelativeActionListOfNoAuthorityQuery(Map queryMap);
}
