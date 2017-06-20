package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysFormLayout;

/**
 * SysFormLayoutDAO接口.
 * @author Administrator.
 */

public interface SysFormLayoutDAO {

    /**
     *  根据主键获得SysFormLayout对象.
     *  @param sysFormLayoutPrimaryKey SysFormLayout主键
     *  @return SysFormLayout.
     */
    SysFormLayout getSysFormLayout(java.lang.String sysFormLayoutPrimaryKey);

    /**
     *  获取SysFormLayout对象列表.
     *  @param  sysFormLayout SysFormLayout对象
     *  @return List.
     */
    List getSysFormLayoutList(SysFormLayout sysFormLayout);

    /**
     *  存储SysFormLayout对象.
     *  @param  sysFormLayout SysFormLayout对象
     *  @return SysFormLayout.
     */
    SysFormLayout saveSysFormLayout(SysFormLayout sysFormLayout);

    /**
     *  删除SysFormLayout对象.
     *  @param sysFormLayoutPrimaryKey SysFormLayout主键.
     */
    void removeSysFormLayout(java.lang.String sysFormLayoutPrimaryKey);

    /**
     *  根据查询条件获取SysFormLayout对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysFormLayoutListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysFormLayout对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysFormLayoutListOfNoAuthorityQuery(Map queryMap);
}
