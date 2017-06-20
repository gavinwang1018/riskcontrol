package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.TruleInstanceMcc;

/**
 * TruleInstanceMccDAO接口.
 * @author Administrator.
 */

public interface TruleInstanceMccDAO {

    /**
     *  根据主键获得TruleInstanceMcc对象.
     *  @param truleInstanceMccPrimaryKey TruleInstanceMcc主键
     *  @return TruleInstanceMcc.
     */
    TruleInstanceMcc getTruleInstanceMcc(java.lang.String truleInstanceMccPrimaryKey);

    /**
     *  获取TruleInstanceMcc对象列表.
     *  @param  truleInstanceMcc TruleInstanceMcc对象
     *  @return List.
     */
    List getTruleInstanceMccList(TruleInstanceMcc truleInstanceMcc);

    /**
     *  存储TruleInstanceMcc对象.
     *  @param  truleInstanceMcc TruleInstanceMcc对象
     *  @return TruleInstanceMcc.
     */
    TruleInstanceMcc saveTruleInstanceMcc(TruleInstanceMcc truleInstanceMcc);

    /**
     *  删除TruleInstanceMcc对象.
     *  @param truleInstanceMccPrimaryKey TruleInstanceMcc主键.
     */
    void removeTruleInstanceMcc(java.lang.String truleInstanceMccPrimaryKey);

    /**
     *  根据查询条件获取TruleInstanceMcc对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTruleInstanceMccListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取TruleInstanceMcc对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTruleInstanceMccListOfNoAuthorityQuery(Map queryMap);
    /**
     * 事务回滚
     *
     */
    void rollback();
}
