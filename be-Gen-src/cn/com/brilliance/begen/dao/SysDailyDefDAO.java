package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysDailyDef;

/**
 * SysDailyDefDAO接口.
 * @author Administrator.
 */

public interface SysDailyDefDAO {

    /**
     *  根据主键获得SysDailyDef对象.
     *  @param sysDailyDefPrimaryKey SysDailyDef主键
     *  @return SysDailyDef.
     */
    SysDailyDef getSysDailyDef(java.lang.String sysDailyDefPrimaryKey);

    /**
     *  获取SysDailyDef对象列表.
     *  @param  sysDailyDef SysDailyDef对象
     *  @return List.
     */
    List getSysDailyDefList(SysDailyDef sysDailyDef);

    /**
     *  存储SysDailyDef对象.
     *  @param  sysDailyDef SysDailyDef对象
     *  @return SysDailyDef.
     */
    SysDailyDef saveSysDailyDef(SysDailyDef sysDailyDef);

    /**
     *  删除SysDailyDef对象.
     *  @param sysDailyDefPrimaryKey SysDailyDef主键.
     */
    void removeSysDailyDef(java.lang.String sysDailyDefPrimaryKey);

    /**
     *  根据查询条件获取SysDailyDef对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysDailyDefListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysDailyDef对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysDailyDefListOfNoAuthorityQuery(Map queryMap);
}
