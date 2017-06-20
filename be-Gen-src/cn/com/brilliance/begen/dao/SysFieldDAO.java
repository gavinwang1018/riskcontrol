package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysField;

/**
 * SysFieldDAO接口.
 * @author Administrator.
 */

public interface SysFieldDAO {

    /**
     *  根据主键获得SysField对象.
     *  @param sysFieldPrimaryKey SysField主键
     *  @return SysField.
     */
    SysField getSysField(java.lang.String sysFieldPrimaryKey);

    /**
     *  获取SysField对象列表.
     *  @param  sysField SysField对象
     *  @return List.
     */
    List getSysFieldList(SysField sysField);

    /**
     *  存储SysField对象.
     *  @param  sysField SysField对象
     *  @return SysField.
     */
    SysField saveSysField(SysField sysField);

    /**
     *  删除SysField对象.
     *  @param sysFieldPrimaryKey SysField主键.
     */
    void removeSysField(java.lang.String sysFieldPrimaryKey);

    /**
     *  根据查询条件获取SysField对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysFieldListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysField对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysFieldListOfNoAuthorityQuery(Map queryMap);
}
