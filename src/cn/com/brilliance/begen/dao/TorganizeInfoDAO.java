package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.TorganizeInfo;

/**
 * TorganizeInfoDAO接口.
 * @author Administrator.
 */

public interface TorganizeInfoDAO {

    /**
     *  根据主键获得TorganizeInfo对象.
     *  @param torganizeInfoPrimaryKey TorganizeInfo主键
     *  @return TorganizeInfo.
     */
    TorganizeInfo getTorganizeInfo(java.lang.String torganizeInfoPrimaryKey);

    /**
     *  获取TorganizeInfo对象列表.
     *  @param  torganizeInfo TorganizeInfo对象
     *  @return List.
     */
    List getTorganizeInfoList(TorganizeInfo torganizeInfo);

    /**
     *  存储TorganizeInfo对象.
     *  @param  torganizeInfo TorganizeInfo对象
     *  @return TorganizeInfo.
     */
    TorganizeInfo saveTorganizeInfo(TorganizeInfo torganizeInfo);

    /**
     *  删除TorganizeInfo对象.
     *  @param torganizeInfoPrimaryKey TorganizeInfo主键.
     */
    void removeTorganizeInfo(java.lang.String torganizeInfoPrimaryKey);

    /**
     *  根据查询条件获取TorganizeInfo对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTorganizeInfoListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取TorganizeInfo对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTorganizeInfoListOfNoAuthorityQuery(Map queryMap);
}
