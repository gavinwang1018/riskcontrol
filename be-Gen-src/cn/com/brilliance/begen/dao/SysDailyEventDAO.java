package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysDailyEvent;

/**
 * SysDailyEventDAO接口.
 * @author Administrator.
 */

public interface SysDailyEventDAO {

    /**
     *  根据主键获得SysDailyEvent对象.
     *  @param sysDailyEventPrimaryKey SysDailyEvent主键
     *  @return SysDailyEvent.
     */
    SysDailyEvent getSysDailyEvent(java.lang.String sysDailyEventPrimaryKey);

    /**
     *  获取SysDailyEvent对象列表.
     *  @param  sysDailyEvent SysDailyEvent对象
     *  @return List.
     */
    List getSysDailyEventList(SysDailyEvent sysDailyEvent);

    /**
     *  存储SysDailyEvent对象.
     *  @param  sysDailyEvent SysDailyEvent对象
     *  @return SysDailyEvent.
     */
    SysDailyEvent saveSysDailyEvent(SysDailyEvent sysDailyEvent);

    /**
     *  删除SysDailyEvent对象.
     *  @param sysDailyEventPrimaryKey SysDailyEvent主键.
     */
    void removeSysDailyEvent(java.lang.String sysDailyEventPrimaryKey);

    /**
     *  根据查询条件获取SysDailyEvent对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysDailyEventListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysDailyEvent对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysDailyEventListOfNoAuthorityQuery(Map queryMap);
}
