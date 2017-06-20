package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.TriskprocessTimelimit;

/**
 * TriskprocessTimelimitDAO接口.
 * @author Administrator.
 */

public interface TriskprocessTimelimitDAO {

    /**
     *  根据主键获得TriskprocessTimelimit对象.
     *  @param triskprocessTimelimitPrimaryKey TriskprocessTimelimit主键
     *  @return TriskprocessTimelimit.
     */
    TriskprocessTimelimit getTriskprocessTimelimit(java.lang.String triskprocessTimelimitPrimaryKey);

    /**
     *  获取TriskprocessTimelimit对象列表.
     *  @param  triskprocessTimelimit TriskprocessTimelimit对象
     *  @return List.
     */
    List getTriskprocessTimelimitList(TriskprocessTimelimit triskprocessTimelimit);

    /**
     *  存储TriskprocessTimelimit对象.
     *  @param  triskprocessTimelimit TriskprocessTimelimit对象
     *  @return TriskprocessTimelimit.
     */
    TriskprocessTimelimit saveTriskprocessTimelimit(TriskprocessTimelimit triskprocessTimelimit);

    /**
     *  删除TriskprocessTimelimit对象.
     *  @param triskprocessTimelimitPrimaryKey TriskprocessTimelimit主键.
     */
    void removeTriskprocessTimelimit(java.lang.String triskprocessTimelimitPrimaryKey);

    /**
     *  根据查询条件获取TriskprocessTimelimit对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTriskprocessTimelimitListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取TriskprocessTimelimit对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTriskprocessTimelimitListOfNoAuthorityQuery(Map queryMap);
}
