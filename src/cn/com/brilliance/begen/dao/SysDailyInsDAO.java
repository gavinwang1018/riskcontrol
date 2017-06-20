package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysDailyIns;

/**
 * SysDailyInsDAO接口.
 * @author Administrator.
 */

public interface SysDailyInsDAO {

    /**
     *  根据主键获得SysDailyIns对象.
     *  @param sysDailyInsPrimaryKey SysDailyIns主键
     *  @return SysDailyIns.
     */
    SysDailyIns getSysDailyIns(java.lang.String sysDailyInsPrimaryKey);

    /**
     *  获取SysDailyIns对象列表.
     *  @param  sysDailyIns SysDailyIns对象
     *  @return List.
     */
    List getSysDailyInsList(SysDailyIns sysDailyIns);

    /**
     *  存储SysDailyIns对象.
     *  @param  sysDailyIns SysDailyIns对象
     *  @return SysDailyIns.
     */
    SysDailyIns saveSysDailyIns(SysDailyIns sysDailyIns);

    /**
     *  删除SysDailyIns对象.
     *  @param sysDailyInsPrimaryKey SysDailyIns主键.
     */
    void removeSysDailyIns(java.lang.String sysDailyInsPrimaryKey);

    /**
     *  根据查询条件获取SysDailyIns对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysDailyInsListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysDailyIns对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysDailyInsListOfNoAuthorityQuery(Map queryMap);
}
