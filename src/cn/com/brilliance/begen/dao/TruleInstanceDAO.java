package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.TruleInstance;

/**
 * TruleInstanceDAO接口.
 * @author Administrator.
 */

public interface TruleInstanceDAO {

    /**
     *  根据主键获得TruleInstance对象.
     *  @param truleInstancePrimaryKey TruleInstance主键
     *  @return TruleInstance.
     */
    TruleInstance getTruleInstance(java.lang.String truleInstancePrimaryKey);

    /**
     *  获取TruleInstance对象列表.
     *  @param  truleInstance TruleInstance对象
     *  @return List.
     */
    List getTruleInstanceList(TruleInstance truleInstance);

    /**
     *  存储TruleInstance对象.
     *  @param  truleInstance TruleInstance对象
     *  @return TruleInstance.
     */
    TruleInstance saveTruleInstance(TruleInstance truleInstance);

    /**
     *  删除TruleInstance对象.
     *  @param truleInstancePrimaryKey TruleInstance主键.
     */
    void removeTruleInstance(java.lang.String truleInstancePrimaryKey);

    /**
     *  根据查询条件获取TruleInstance对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTruleInstanceListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取TruleInstance对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTruleInstanceListOfNoAuthorityQuery(Map queryMap);

	void rollback();
}
