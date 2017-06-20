package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.TroleInfo;

/**
 * TroleInfoDAO接口.
 * @author Administrator.
 */

public interface TroleInfoDAO {

    /**
     *  根据主键获得TroleInfo对象.
     *  @param troleInfoPrimaryKey TroleInfo主键
     *  @return TroleInfo.
     */
    TroleInfo getTroleInfo(java.lang.String troleInfoPrimaryKey);

    /**
     *  获取TroleInfo对象列表.
     *  @param  troleInfo TroleInfo对象
     *  @return List.
     */
    List getTroleInfoList(TroleInfo troleInfo);

    /**
     *  存储TroleInfo对象.
     *  @param  troleInfo TroleInfo对象
     *  @return TroleInfo.
     */
    TroleInfo saveTroleInfo(TroleInfo troleInfo);

    /**
     *  删除TroleInfo对象.
     *  @param troleInfoPrimaryKey TroleInfo主键.
     */
    void removeTroleInfo(java.lang.String troleInfoPrimaryKey);

    /**
     *  根据查询条件获取TroleInfo对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTroleInfoListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取TroleInfo对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTroleInfoListOfNoAuthorityQuery(Map queryMap);
}
