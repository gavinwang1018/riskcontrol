package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.Triskcase;

/**
 * TriskcaseDAO接口.
 * @author Administrator.
 */

public interface TriskcaseDAO {

    /**
     *  根据主键获得Triskcase对象.
     *  @param triskcasePrimaryKey Triskcase主键
     *  @return Triskcase.
     */
    Triskcase getTriskcase(java.lang.String triskcasePrimaryKey);

    /**
     *  获取Triskcase对象列表.
     *  @param  triskcase Triskcase对象
     *  @return List.
     */
    List getTriskcaseList(Triskcase triskcase);

    /**
     *  存储Triskcase对象.
     *  @param  triskcase Triskcase对象
     *  @return Triskcase.
     */
    Triskcase saveTriskcase(Triskcase triskcase);

    /**
     *  删除Triskcase对象.
     *  @param triskcasePrimaryKey Triskcase主键.
     */
    void removeTriskcase(java.lang.String triskcasePrimaryKey);

    /**
     *  根据查询条件获取Triskcase对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTriskcaseListOfQuery(Map queryMap);
    
    List getTriskcaseListOfQueryNoSize(Map queryMap);

    /**
     *  根据查询条件获取Triskcase对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTriskcaseListOfNoAuthorityQuery(Map queryMap);
    
    int getTriskcaseListOfCount(Map queryMap);
}
