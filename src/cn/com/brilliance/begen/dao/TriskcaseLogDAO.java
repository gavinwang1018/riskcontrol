package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.TriskcaseLog;

/**
 * TriskcaseLogDAO接口.
 * @author Administrator.
 */

public interface TriskcaseLogDAO {

    /**
     *  根据主键获得TriskcaseLog对象.
     *  @param triskcaseLogPrimaryKey TriskcaseLog主键
     *  @return TriskcaseLog.
     */
    TriskcaseLog getTriskcaseLog(java.lang.String triskcaseLogPrimaryKey);

    /**
     *  获取TriskcaseLog对象列表.
     *  @param  triskcaseLog TriskcaseLog对象
     *  @return List.
     */
    List getTriskcaseLogList(TriskcaseLog triskcaseLog);

    /**
     *  存储TriskcaseLog对象.
     *  @param  triskcaseLog TriskcaseLog对象
     *  @return TriskcaseLog.
     */
    TriskcaseLog saveTriskcaseLog(TriskcaseLog triskcaseLog);

    /**
     *  删除TriskcaseLog对象.
     *  @param triskcaseLogPrimaryKey TriskcaseLog主键.
     */
    void removeTriskcaseLog(java.lang.String triskcaseLogPrimaryKey);

    /**
     *  根据查询条件获取TriskcaseLog对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTriskcaseLogListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取TriskcaseLog对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTriskcaseLogListOfNoAuthorityQuery(Map queryMap);
}
