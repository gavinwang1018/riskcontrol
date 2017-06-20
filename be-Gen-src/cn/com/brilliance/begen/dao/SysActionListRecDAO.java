package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysActionListRec;

/**
 * SysActionListRecDAO接口.
 * @author Administrator.
 */

public interface SysActionListRecDAO {

    /**
     *  根据主键获得SysActionListRec对象.
     *  @param sysActionListRecPrimaryKey SysActionListRec主键
     *  @return SysActionListRec.
     */
    SysActionListRec getSysActionListRec(java.lang.String sysActionListRecPrimaryKey);

    /**
     *  获取SysActionListRec对象列表.
     *  @param  sysActionListRec SysActionListRec对象
     *  @return List.
     */
    List getSysActionListRecList(SysActionListRec sysActionListRec);

    /**
     *  存储SysActionListRec对象.
     *  @param  sysActionListRec SysActionListRec对象
     *  @return SysActionListRec.
     */
    SysActionListRec saveSysActionListRec(SysActionListRec sysActionListRec);

    /**
     *  删除SysActionListRec对象.
     *  @param sysActionListRecPrimaryKey SysActionListRec主键.
     */
    void removeSysActionListRec(java.lang.String sysActionListRecPrimaryKey);

    /**
     *  根据查询条件获取SysActionListRec对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysActionListRecListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysActionListRec对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysActionListRecListOfNoAuthorityQuery(Map queryMap);
}
