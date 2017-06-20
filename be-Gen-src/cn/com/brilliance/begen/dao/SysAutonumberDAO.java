package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysAutonumber;

/**
 * SysAutonumberDAO接口.
 * @author Administrator.
 */

public interface SysAutonumberDAO {

    /**
     *  根据主键获得SysAutonumber对象.
     *  @param sysAutonumberPrimaryKey SysAutonumber主键
     *  @return SysAutonumber.
     */
    SysAutonumber getSysAutonumber(java.lang.String sysAutonumberPrimaryKey);

    /**
     *  获取SysAutonumber对象列表.
     *  @param  sysAutonumber SysAutonumber对象
     *  @return List.
     */
    List getSysAutonumberList(SysAutonumber sysAutonumber);

    /**
     *  存储SysAutonumber对象.
     *  @param  sysAutonumber SysAutonumber对象
     *  @return SysAutonumber.
     */
    SysAutonumber saveSysAutonumber(SysAutonumber sysAutonumber);

    /**
     *  删除SysAutonumber对象.
     *  @param sysAutonumberPrimaryKey SysAutonumber主键.
     */
    void removeSysAutonumber(java.lang.String sysAutonumberPrimaryKey);

    /**
     *  根据查询条件获取SysAutonumber对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysAutonumberListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysAutonumber对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysAutonumberListOfNoAuthorityQuery(Map queryMap);
}
