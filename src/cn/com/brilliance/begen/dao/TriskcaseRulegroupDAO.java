package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.TriskcaseRulegroup;

/**
 * TriskcaseRulegroupDAO接口.
 * @author Administrator.
 */

public interface TriskcaseRulegroupDAO {

    /**
     *  根据主键获得TriskcaseRulegroup对象.
     *  @param triskcaseRulegroupPrimaryKey TriskcaseRulegroup主键
     *  @return TriskcaseRulegroup.
     */
    TriskcaseRulegroup getTriskcaseRulegroup(java.lang.String triskcaseRulegroupPrimaryKey);

    /**
     *  获取TriskcaseRulegroup对象列表.
     *  @param  triskcaseRulegroup TriskcaseRulegroup对象
     *  @return List.
     */
    List getTriskcaseRulegroupList(TriskcaseRulegroup triskcaseRulegroup);

    /**
     *  存储TriskcaseRulegroup对象.
     *  @param  triskcaseRulegroup TriskcaseRulegroup对象
     *  @return TriskcaseRulegroup.
     */
    TriskcaseRulegroup saveTriskcaseRulegroup(TriskcaseRulegroup triskcaseRulegroup);

    /**
     *  删除TriskcaseRulegroup对象.
     *  @param triskcaseRulegroupPrimaryKey TriskcaseRulegroup主键.
     */
    void removeTriskcaseRulegroup(java.lang.String triskcaseRulegroupPrimaryKey);

    /**
     *  根据查询条件获取TriskcaseRulegroup对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTriskcaseRulegroupListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取TriskcaseRulegroup对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTriskcaseRulegroupListOfNoAuthorityQuery(Map queryMap);
}
