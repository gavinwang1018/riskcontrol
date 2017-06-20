package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.TruleInstanceGroup;

/**
 * TruleInstanceGroupDAO接口.
 * @author Administrator.
 */

public interface TruleInstanceGroupDAO {

    /**
     *  根据主键获得TruleInstanceGroup对象.
     *  @param truleInstanceGroupPrimaryKey TruleInstanceGroup主键
     *  @return TruleInstanceGroup.
     */
    TruleInstanceGroup getTruleInstanceGroup(java.lang.String truleInstanceGroupPrimaryKey);

    /**
     *  获取TruleInstanceGroup对象列表.
     *  @param  truleInstanceGroup TruleInstanceGroup对象
     *  @return List.
     */
    List getTruleInstanceGroupList(TruleInstanceGroup truleInstanceGroup);

    /**
     *  存储TruleInstanceGroup对象.
     *  @param  truleInstanceGroup TruleInstanceGroup对象
     *  @return TruleInstanceGroup.
     */
    TruleInstanceGroup saveTruleInstanceGroup(TruleInstanceGroup truleInstanceGroup);

    /**
     *  删除TruleInstanceGroup对象.
     *  @param truleInstanceGroupPrimaryKey TruleInstanceGroup主键.
     */
    void removeTruleInstanceGroup(java.lang.String truleInstanceGroupPrimaryKey);

    /**
     *  根据查询条件获取TruleInstanceGroup对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTruleInstanceGroupListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取TruleInstanceGroup对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTruleInstanceGroupListOfNoAuthorityQuery(Map queryMap);
}
