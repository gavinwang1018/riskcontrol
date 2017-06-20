package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysLoginfo;

/**
 * SysLoginfoDAO接口.
 * @author Administrator.
 */

public interface SysLoginfoDAO {

    /**
     *  根据主键获得SysLoginfo对象.
     *  @param sysLoginfoPrimaryKey SysLoginfo主键
     *  @return SysLoginfo.
     */
    SysLoginfo getSysLoginfo(java.lang.String sysLoginfoPrimaryKey);

    /**
     *  获取SysLoginfo对象列表.
     *  @param  sysLoginfo SysLoginfo对象
     *  @return List.
     */
    List getSysLoginfoList(SysLoginfo sysLoginfo);

    /**
     *  存储SysLoginfo对象.
     *  @param  sysLoginfo SysLoginfo对象
     *  @return SysLoginfo.
     */
    SysLoginfo saveSysLoginfo(SysLoginfo sysLoginfo);

    /**
     *  删除SysLoginfo对象.
     *  @param sysLoginfoPrimaryKey SysLoginfo主键.
     */
    void removeSysLoginfo(java.lang.String sysLoginfoPrimaryKey);

    /**
     *  根据查询条件获取SysLoginfo对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysLoginfoListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysLoginfo对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysLoginfoListOfNoAuthorityQuery(Map queryMap);
}
