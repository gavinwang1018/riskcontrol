package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.ExtTruleInstanceMcc;

/**
 * TruleInstanceMccDAO接口.
 * @author Administrator.
 */

public interface ExtTruleInstanceMccDAO {

    /**
     *  根据主键获得TruleInstanceMcc对象.
     *  @param truleInstanceMccPrimaryKey TruleInstanceMcc主键
     *  @return TruleInstanceMcc.
     */
	ExtTruleInstanceMcc getExtTruleInstanceMcc(java.lang.String extTruleInstanceMccPrimaryKey);

    /**
     *  获取TruleInstanceMcc对象列表.
     *  @param  truleInstanceMcc TruleInstanceMcc对象
     *  @return List.
     */
    List getExtTruleInstanceMccList(ExtTruleInstanceMcc extTruleInstanceMcc);

    /**
     *  存储TruleInstanceMcc对象.
     *  @param  truleInstanceMcc TruleInstanceMcc对象
     *  @return TruleInstanceMcc.
     */
    ExtTruleInstanceMcc saveExtTruleInstanceMcc(ExtTruleInstanceMcc extTruleInstanceMcc);

    /**
     *  删除TruleInstanceMcc对象.
     *  @param truleInstanceMccPrimaryKey TruleInstanceMcc主键.
     */
    void removeExtTruleInstanceMcc(java.lang.String extTruleInstanceMccPrimaryKey);

    /**
     *  根据查询条件获取TruleInstanceMcc对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getExtTruleInstanceMccListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取TruleInstanceMcc对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getExtTruleInstanceMccListOfNoAuthorityQuery(Map queryMap);
}
