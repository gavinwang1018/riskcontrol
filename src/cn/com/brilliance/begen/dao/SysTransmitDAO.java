package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysTransmit;

/**
 * SysTransmitDAO接口.
 * @author Administrator.
 */

public interface SysTransmitDAO {

    /**
     *  根据主键获得SysTransmit对象.
     *  @param sysTransmitPrimaryKey SysTransmit主键
     *  @return SysTransmit.
     */
    SysTransmit getSysTransmit(java.lang.String sysTransmitPrimaryKey);

    /**
     *  获取SysTransmit对象列表.
     *  @param  sysTransmit SysTransmit对象
     *  @return List.
     */
    List getSysTransmitList(SysTransmit sysTransmit);

    /**
     *  存储SysTransmit对象.
     *  @param  sysTransmit SysTransmit对象
     *  @return SysTransmit.
     */
    SysTransmit saveSysTransmit(SysTransmit sysTransmit);

    /**
     *  删除SysTransmit对象.
     *  @param sysTransmitPrimaryKey SysTransmit主键.
     */
    void removeSysTransmit(java.lang.String sysTransmitPrimaryKey);

    /**
     *  根据查询条件获取SysTransmit对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysTransmitListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysTransmit对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysTransmitListOfNoAuthorityQuery(Map queryMap);
}
