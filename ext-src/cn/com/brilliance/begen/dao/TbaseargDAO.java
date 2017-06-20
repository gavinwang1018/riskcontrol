package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.Tbasearg;

/**
 * TbaseargDAO接口.
 * @author Administrator.
 */

public interface TbaseargDAO {

    /**
     *  根据主键获得Tbasearg对象.
     *  @param tbaseargPrimaryKey Tbasearg主键
     *  @return Tbasearg.
     */
    Tbasearg getTbasearg(java.lang.String tbaseargPrimaryKey);

    /**
     *  获取Tbasearg对象列表.
     *  @param  tbasearg Tbasearg对象
     *  @return List.
     */
    List getTbaseargList(Tbasearg tbasearg);

    /**
     *  存储Tbasearg对象.
     *  @param  tbasearg Tbasearg对象
     *  @return Tbasearg.
     */
    Tbasearg saveTbasearg(Tbasearg tbasearg);

    /**
     *  删除Tbasearg对象.
     *  @param tbaseargPrimaryKey Tbasearg主键.
     */
    void removeTbasearg(java.lang.String tbaseargPrimaryKey);

    /**
     *  根据查询条件获取Tbasearg对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTbaseargListOfQuery(Map queryMap);

    /**
     * 根据类型取Tbasearg对象列表
     * @param queryMap
     * @param simbol
     * @return
     */

    List getTbaseargByType(Map queryMap, String simbol);
    
    /**
     *  根据查询条件获取Tbasearg对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTbaseargListOfNoAuthorityQuery(Map queryMap);
}
