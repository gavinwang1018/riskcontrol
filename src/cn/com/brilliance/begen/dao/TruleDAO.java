package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.Trule;

/**
 * TruleDAO接口.
 * @author Administrator.
 */

public interface TruleDAO {

    /**
     *  根据主键获得Trule对象.
     *  @param trulePrimaryKey Trule主键
     *  @return Trule.
     */
    Trule getTrule(java.lang.String trulePrimaryKey);

    /**
     *  获取Trule对象列表.
     *  @param  trule Trule对象
     *  @return List.
     */
    List getTruleList(Trule trule);

    /**
     *  存储Trule对象.
     *  @param  trule Trule对象
     *  @return Trule.
     */
    Trule saveTrule(Trule trule);

    /**
     *  删除Trule对象.
     *  @param trulePrimaryKey Trule主键.
     */
    void removeTrule(java.lang.String trulePrimaryKey);

    /**
     *  根据查询条件获取Trule对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTruleListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取Trule对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTruleListOfNoAuthorityQuery(Map queryMap);
}
