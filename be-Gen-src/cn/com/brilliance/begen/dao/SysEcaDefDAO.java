package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysEcaDef;

/**
 * SysEcaDefDAO接口.
 * @author Administrator.
 */

public interface SysEcaDefDAO {

    /**
     *  根据主键获得SysEcaDef对象.
     *  @param sysEcaDefPrimaryKey SysEcaDef主键
     *  @return SysEcaDef.
     */
    SysEcaDef getSysEcaDef(java.lang.String sysEcaDefPrimaryKey);

    /**
     *  获取SysEcaDef对象列表.
     *  @param  sysEcaDef SysEcaDef对象
     *  @return List.
     */
    List getSysEcaDefList(SysEcaDef sysEcaDef);

    /**
     *  存储SysEcaDef对象.
     *  @param  sysEcaDef SysEcaDef对象
     *  @return SysEcaDef.
     */
    SysEcaDef saveSysEcaDef(SysEcaDef sysEcaDef);

    /**
     *  删除SysEcaDef对象.
     *  @param sysEcaDefPrimaryKey SysEcaDef主键.
     */
    void removeSysEcaDef(java.lang.String sysEcaDefPrimaryKey);

    /**
     *  根据查询条件获取SysEcaDef对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysEcaDefListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysEcaDef对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysEcaDefListOfNoAuthorityQuery(Map queryMap);
}
