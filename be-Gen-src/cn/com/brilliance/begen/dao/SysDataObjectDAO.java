package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysDataObject;

/**
 * SysDataObjectDAO接口.
 * @author Administrator.
 */

public interface SysDataObjectDAO {

    /**
     *  根据主键获得SysDataObject对象.
     *  @param sysDataObjectPrimaryKey SysDataObject主键
     *  @return SysDataObject.
     */
    SysDataObject getSysDataObject(java.lang.String sysDataObjectPrimaryKey);

    /**
     *  获取SysDataObject对象列表.
     *  @param  sysDataObject SysDataObject对象
     *  @return List.
     */
    List getSysDataObjectList(SysDataObject sysDataObject);

    /**
     *  存储SysDataObject对象.
     *  @param  sysDataObject SysDataObject对象
     *  @return SysDataObject.
     */
    SysDataObject saveSysDataObject(SysDataObject sysDataObject);

    /**
     *  删除SysDataObject对象.
     *  @param sysDataObjectPrimaryKey SysDataObject主键.
     */
    void removeSysDataObject(java.lang.String sysDataObjectPrimaryKey);

    /**
     *  根据查询条件获取SysDataObject对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysDataObjectListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysDataObject对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysDataObjectListOfNoAuthorityQuery(Map queryMap);
}
