package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.TtransInfo;

/**
 * TtransInfoDAO接口.
 * @author Administrator.
 */

public interface TtransInfoDAO {

    /**
     *  根据主键获得TtransInfo对象.
     *  @param ttransInfoPrimaryKey TtransInfo主键
     *  @return TtransInfo.
     */
    TtransInfo getTtransInfo(java.lang.String ttransInfoPrimaryKey);

    /**
     *  获取TtransInfo对象列表.
     *  @param  ttransInfo TtransInfo对象
     *  @return List.
     */
    List getTtransInfoList(TtransInfo ttransInfo);

    /**
     *  存储TtransInfo对象.
     *  @param  ttransInfo TtransInfo对象
     *  @return TtransInfo.
     */
    TtransInfo saveTtransInfo(TtransInfo ttransInfo);

    /**
     *  删除TtransInfo对象.
     *  @param ttransInfoPrimaryKey TtransInfo主键.
     */
    void removeTtransInfo(java.lang.String ttransInfoPrimaryKey);

    /**
     *  根据查询条件获取TtransInfo对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTtransInfoListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取TtransInfo对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTtransInfoListOfNoAuthorityQuery(Map queryMap);

	int getTmchntListOfQueryCount(Map queryFields);
}
