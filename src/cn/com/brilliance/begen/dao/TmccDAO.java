package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.Tmcc;

/**
 * TmccDAO接口.
 * @author Administrator.
 */

public interface TmccDAO {

    /**
     *  根据主键获得Tmcc对象.
     *  @param tmccPrimaryKey Tmcc主键
     *  @return Tmcc.
     */
    Tmcc getTmcc(java.lang.String tmccPrimaryKey);

    /**
     *  获取Tmcc对象列表.
     *  @param  tmcc Tmcc对象
     *  @return List.
     */
    List getTmccList(Tmcc tmcc);

    /**
     *  存储Tmcc对象.
     *  @param  tmcc Tmcc对象
     *  @return Tmcc.
     */
    Tmcc saveTmcc(Tmcc tmcc);

    /**
     *  删除Tmcc对象.
     *  @param tmccPrimaryKey Tmcc主键.
     */
    void removeTmcc(java.lang.String tmccPrimaryKey);

    /**
     *  根据查询条件获取Tmcc对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTmccListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取Tmcc对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTmccListOfNoAuthorityQuery(Map queryMap);
    
    
    List getTmccNames(Map queryMap);
    
    List getTmccByBigMcc(String bigmcc);
}
