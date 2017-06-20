package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.TroleUser;

/**
 * TroleUserDAO接口.
 * @author Administrator.
 */

public interface TroleUserDAO {

    /**
     *  根据主键获得TroleUser对象.
     *  @param troleUserPrimaryKey TroleUser主键
     *  @return TroleUser.
     */
    TroleUser getTroleUser(java.lang.String troleUserPrimaryKey);

    /**
     *  获取TroleUser对象列表.
     *  @param  troleUser TroleUser对象
     *  @return List.
     */
    List getTroleUserList(TroleUser troleUser);

    /**
     *  存储TroleUser对象.
     *  @param  troleUser TroleUser对象
     *  @return TroleUser.
     */
    TroleUser saveTroleUser(TroleUser troleUser);

    /**
     *  删除TroleUser对象.
     *  @param troleUserPrimaryKey TroleUser主键.
     */
    void removeTroleUser(java.lang.String troleUserPrimaryKey);

    /**
     *  根据查询条件获取TroleUser对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTroleUserListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取TroleUser对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTroleUserListOfNoAuthorityQuery(Map queryMap);
}
