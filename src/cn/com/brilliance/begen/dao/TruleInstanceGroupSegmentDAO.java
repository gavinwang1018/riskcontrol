package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.TruleInstanceGroupSegment;

/**
 * TruleInstanceGroupSegmentDAO接口.
 * @author Administrator.
 */

public interface TruleInstanceGroupSegmentDAO {

    /**
     *  根据主键获得TruleInstanceGroupSegment对象.
     *  @param truleInstanceGroupSegmentPrimaryKey TruleInstanceGroupSegment主键
     *  @return TruleInstanceGroupSegment.
     */
    TruleInstanceGroupSegment getTruleInstanceGroupSegment(java.lang.String truleInstanceGroupSegmentPrimaryKey);

    /**
     *  获取TruleInstanceGroupSegment对象列表.
     *  @param  truleInstanceGroupSegment TruleInstanceGroupSegment对象
     *  @return List.
     */
    List getTruleInstanceGroupSegmentList(TruleInstanceGroupSegment truleInstanceGroupSegment);

    /**
     *  存储TruleInstanceGroupSegment对象.
     *  @param  truleInstanceGroupSegment TruleInstanceGroupSegment对象
     *  @return TruleInstanceGroupSegment.
     */
    TruleInstanceGroupSegment saveTruleInstanceGroupSegment(TruleInstanceGroupSegment truleInstanceGroupSegment);

    /**
     *  删除TruleInstanceGroupSegment对象.
     *  @param truleInstanceGroupSegmentPrimaryKey TruleInstanceGroupSegment主键.
     */
    void removeTruleInstanceGroupSegment(java.lang.String truleInstanceGroupSegmentPrimaryKey);

    /**
     *  根据查询条件获取TruleInstanceGroupSegment对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTruleInstanceGroupSegmentListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取TruleInstanceGroupSegment对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTruleInstanceGroupSegmentListOfNoAuthorityQuery(Map queryMap);
}
