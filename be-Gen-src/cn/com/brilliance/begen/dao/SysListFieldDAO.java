package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysListField;

/**
 * SysListFieldDAO接口.
 * @author Administrator.
 */

public interface SysListFieldDAO {

    /**
     *  根据主键获得SysListField对象.
     *  @param sysListFieldPrimaryKey SysListField主键
     *  @return SysListField.
     */
    SysListField getSysListField(java.lang.String sysListFieldPrimaryKey);

    /**
     *  获取SysListField对象列表.
     *  @param  sysListField SysListField对象
     *  @return List.
     */
    List getSysListFieldList(SysListField sysListField);

    /**
     *  存储SysListField对象.
     *  @param  sysListField SysListField对象
     *  @return SysListField.
     */
    SysListField saveSysListField(SysListField sysListField);

    /**
     *  删除SysListField对象.
     *  @param sysListFieldPrimaryKey SysListField主键.
     */
    void removeSysListField(java.lang.String sysListFieldPrimaryKey);

    /**
     *  根据查询条件获取SysListField对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysListFieldListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysListField对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysListFieldListOfNoAuthorityQuery(Map queryMap);
}
