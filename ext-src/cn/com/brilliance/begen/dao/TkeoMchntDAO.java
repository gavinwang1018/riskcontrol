package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.TkeoMchnt;

/**
 * TkeoMchntDAO接口.
 * @author Administrator.
 */

public interface TkeoMchntDAO {

    /**
     *  根据主键获得TkeoMchnt对象.
     *  @param tkeoMchntPrimaryKey TkeoMchnt主键
     *  @return TkeoMchnt.
     */
    TkeoMchnt getTkeoMchnt(java.lang.String tkeoMchntPrimaryKey);

    /**
     *  获取TkeoMchnt对象列表.
     *  @param  tkeoMchnt TkeoMchnt对象
     *  @return List.
     */
    List getTkeoMchntList(TkeoMchnt tkeoMchnt);

    /**
     *  存储TkeoMchnt对象.
     *  @param  tkeoMchnt TkeoMchnt对象
     *  @return TkeoMchnt.
     */
    TkeoMchnt saveTkeoMchnt(TkeoMchnt tkeoMchnt);

    /**
     *  删除TkeoMchnt对象.
     *  @param tkeoMchntPrimaryKey TkeoMchnt主键.
     */
    void removeTkeoMchnt(java.lang.String tkeoMchntPrimaryKey);

    /**
     *  根据查询条件获取TkeoMchnt对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTkeoMchntListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取TkeoMchnt对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTkeoMchntListOfNoAuthorityQuery(Map queryMap);
    
    TkeoMchnt getKeoMchntByMerId(String merId,String type);
    
    int getTkeoMchntListOfQueryCount(Map queryFields);
}
