package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysBizServiceDef;

/**
 * SysBizServiceDefDAO接口.
 * @author Administrator.
 */

public interface SysBizServiceDefDAO {

    /**
     *  根据主键获得SysBizServiceDef对象.
     *  @param sysBizServiceDefPrimaryKey SysBizServiceDef主键
     *  @return SysBizServiceDef.
     */
    SysBizServiceDef getSysBizServiceDef(java.lang.String sysBizServiceDefPrimaryKey);

    /**
     *  获取SysBizServiceDef对象列表.
     *  @param  sysBizServiceDef SysBizServiceDef对象
     *  @return List.
     */
    List getSysBizServiceDefList(SysBizServiceDef sysBizServiceDef);

    /**
     *  存储SysBizServiceDef对象.
     *  @param  sysBizServiceDef SysBizServiceDef对象
     *  @return SysBizServiceDef.
     */
    SysBizServiceDef saveSysBizServiceDef(SysBizServiceDef sysBizServiceDef);

    /**
     *  删除SysBizServiceDef对象.
     *  @param sysBizServiceDefPrimaryKey SysBizServiceDef主键.
     */
    void removeSysBizServiceDef(java.lang.String sysBizServiceDefPrimaryKey);

    /**
     *  根据查询条件获取SysBizServiceDef对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysBizServiceDefListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysBizServiceDef对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysBizServiceDefListOfNoAuthorityQuery(Map queryMap);
}
