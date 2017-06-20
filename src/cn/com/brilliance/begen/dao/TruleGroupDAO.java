package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.TruleGroup;

/**
 * TruleGroupDAO接口.
 * @author Administrator.
 */

public interface TruleGroupDAO {

    /**
     *  根据主键获得TruleGroup对象.
     *  @param truleGroupPrimaryKey TruleGroup主键
     *  @return TruleGroup.
     */
    TruleGroup getTruleGroup(java.lang.String truleGroupPrimaryKey);

    /**
     *  获取TruleGroup对象列表.
     *  @param  truleGroup TruleGroup对象
     *  @return List.
     */
    List getTruleGroupList(TruleGroup truleGroup);

    /**
     *  存储TruleGroup对象.
     *  @param  truleGroup TruleGroup对象
     *  @return TruleGroup.
     */
    TruleGroup saveTruleGroup(TruleGroup truleGroup);

    /**
     *  删除TruleGroup对象.
     *  @param truleGroupPrimaryKey TruleGroup主键.
     */
    void removeTruleGroup(java.lang.String truleGroupPrimaryKey);

    /**
     *  根据查询条件获取TruleGroup对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTruleGroupListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取TruleGroup对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTruleGroupListOfNoAuthorityQuery(Map queryMap);
}
