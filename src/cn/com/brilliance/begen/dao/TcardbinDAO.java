package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.Tcardbin;

/**
 * TcardbinDAO接口.
 * @author Administrator.
 */

public interface TcardbinDAO {

    /**
     *  根据主键获得Tcardbin对象.
     *  @param tcardbinPrimaryKey Tcardbin主键
     *  @return Tcardbin.
     */
    Tcardbin getTcardbin(java.lang.String tcardbinPrimaryKey);

    /**
     *  获取Tcardbin对象列表.
     *  @param  tcardbin Tcardbin对象
     *  @return List.
     */
    List getTcardbinList(Tcardbin tcardbin);

    /**
     *  存储Tcardbin对象.
     *  @param  tcardbin Tcardbin对象
     *  @return Tcardbin.
     */
    Tcardbin saveTcardbin(Tcardbin tcardbin);

    /**
     *  删除Tcardbin对象.
     *  @param tcardbinPrimaryKey Tcardbin主键.
     */
    void removeTcardbin(java.lang.String tcardbinPrimaryKey);

    /**
     *  根据查询条件获取Tcardbin对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTcardbinListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取Tcardbin对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTcardbinListOfNoAuthorityQuery(Map queryMap);
}
