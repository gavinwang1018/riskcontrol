package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.TorganizeUser;

/**
 * TorganizeUserDAO接口.
 * @author Administrator.
 */

public interface TorganizeUserDAO {

    /**
     *  根据主键获得TorganizeUser对象.
     *  @param torganizeUserPrimaryKey TorganizeUser主键
     *  @return TorganizeUser.
     */
    TorganizeUser getTorganizeUser(java.lang.String torganizeUserPrimaryKey);

    /**
     *  获取TorganizeUser对象列表.
     *  @param  torganizeUser TorganizeUser对象
     *  @return List.
     */
    List getTorganizeUserList(TorganizeUser torganizeUser);

    /**
     *  存储TorganizeUser对象.
     *  @param  torganizeUser TorganizeUser对象
     *  @return TorganizeUser.
     */
    TorganizeUser saveTorganizeUser(TorganizeUser torganizeUser);

    /**
     *  删除TorganizeUser对象.
     *  @param torganizeUserPrimaryKey TorganizeUser主键.
     */
    void removeTorganizeUser(java.lang.String torganizeUserPrimaryKey);

    /**
     *  根据查询条件获取TorganizeUser对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTorganizeUserListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取TorganizeUser对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTorganizeUserListOfNoAuthorityQuery(Map queryMap);
}
