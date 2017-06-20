package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.Tpermission;

/**
 * TpermissionDAO接口.
 * @author Administrator.
 */

public interface TpermissionDAO {

    /**
     *  根据主键获得Tpermission对象.
     *  @param tpermissionPrimaryKey Tpermission主键
     *  @return Tpermission.
     */
    Tpermission getTpermission(java.lang.String tpermissionPrimaryKey);

    /**
     *  获取Tpermission对象列表.
     *  @param  tpermission Tpermission对象
     *  @return List.
     */
    List getTpermissionList(Tpermission tpermission);

    /**
     *  存储Tpermission对象.
     *  @param  tpermission Tpermission对象
     *  @return Tpermission.
     */
    Tpermission saveTpermission(Tpermission tpermission);

    /**
     *  删除Tpermission对象.
     *  @param tpermissionPrimaryKey Tpermission主键.
     */
    void removeTpermission(java.lang.String tpermissionPrimaryKey);

    /**
     *  根据查询条件获取Tpermission对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTpermissionListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取Tpermission对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTpermissionListOfNoAuthorityQuery(Map queryMap);
}
