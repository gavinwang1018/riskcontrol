package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.TriskcaseRecord;

/**
 * TriskcaseRecordDAO接口.
 * @author Administrator.
 */

public interface TriskcaseRecordDAO {

    /**
     *  根据主键获得TriskcaseRecord对象.
     *  @param triskcaseRecordPrimaryKey TriskcaseRecord主键
     *  @return TriskcaseRecord.
     */
    TriskcaseRecord getTriskcaseRecord(java.lang.String triskcaseRecordPrimaryKey);

    /**
     *  获取TriskcaseRecord对象列表.
     *  @param  triskcaseRecord TriskcaseRecord对象
     *  @return List.
     */
    List getTriskcaseRecordList(TriskcaseRecord triskcaseRecord);

    /**
     *  存储TriskcaseRecord对象.
     *  @param  triskcaseRecord TriskcaseRecord对象
     *  @return TriskcaseRecord.
     */
    TriskcaseRecord saveTriskcaseRecord(TriskcaseRecord triskcaseRecord);

    /**
     *  删除TriskcaseRecord对象.
     *  @param triskcaseRecordPrimaryKey TriskcaseRecord主键.
     */
    void removeTriskcaseRecord(java.lang.String triskcaseRecordPrimaryKey);

    /**
     *  根据查询条件获取TriskcaseRecord对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTriskcaseRecordListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取TriskcaseRecord对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTriskcaseRecordListOfNoAuthorityQuery(Map queryMap);
}
