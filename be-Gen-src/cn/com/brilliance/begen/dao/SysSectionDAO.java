package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysSection;

/**
 * SysSectionDAO接口.
 * @author Administrator.
 */

public interface SysSectionDAO {

    /**
     *  根据主键获得SysSection对象.
     *  @param sysSectionPrimaryKey SysSection主键
     *  @return SysSection.
     */
    SysSection getSysSection(java.lang.String sysSectionPrimaryKey);

    /**
     *  获取SysSection对象列表.
     *  @param  sysSection SysSection对象
     *  @return List.
     */
    List getSysSectionList(SysSection sysSection);

    /**
     *  存储SysSection对象.
     *  @param  sysSection SysSection对象
     *  @return SysSection.
     */
    SysSection saveSysSection(SysSection sysSection);

    /**
     *  删除SysSection对象.
     *  @param sysSectionPrimaryKey SysSection主键.
     */
    void removeSysSection(java.lang.String sysSectionPrimaryKey);

    /**
     *  根据查询条件获取SysSection对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysSectionListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysSection对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysSectionListOfNoAuthorityQuery(Map queryMap);
}
