package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.TuserInfo;

/**
 * TuserInfoDAO接口.
 * @author Administrator.
 */

public interface TuserInfoDAO {

    /**
     *  根据主键获得TuserInfo对象.
     *  @param tuserInfoPrimaryKey TuserInfo主键
     *  @return TuserInfo.
     */
    TuserInfo getTuserInfo(java.lang.String tuserInfoPrimaryKey);

    /**
     *  获取TuserInfo对象列表.
     *  @param  tuserInfo TuserInfo对象
     *  @return List.
     */
    List getTuserInfoList(TuserInfo tuserInfo);

    /**
     *  存储TuserInfo对象.
     *  @param  tuserInfo TuserInfo对象
     *  @return TuserInfo.
     */
    TuserInfo saveTuserInfo(TuserInfo tuserInfo);

    /**
     *  删除TuserInfo对象.
     *  @param tuserInfoPrimaryKey TuserInfo主键.
     */
    void removeTuserInfo(java.lang.String tuserInfoPrimaryKey);

    /**
     *  根据查询条件获取TuserInfo对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTuserInfoListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取TuserInfo对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTuserInfoListOfNoAuthorityQuery(Map queryMap);
}
