package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysParty;

/**
 * SysPartyDAO接口.
 * @author Administrator.
 */

public interface SysPartyDAO {

    /**
     *  根据主键获得SysParty对象.
     *  @param sysPartyPrimaryKey SysParty主键
     *  @return SysParty.
     */
    SysParty getSysParty(java.lang.String sysPartyPrimaryKey);

    /**
     *  获取SysParty对象列表.
     *  @param  sysParty SysParty对象
     *  @return List.
     */
    List getSysPartyList(SysParty sysParty);

    /**
     *  存储SysParty对象.
     *  @param  sysParty SysParty对象
     *  @return SysParty.
     */
    SysParty saveSysParty(SysParty sysParty);

    /**
     *  删除SysParty对象.
     *  @param sysPartyPrimaryKey SysParty主键.
     */
    void removeSysParty(java.lang.String sysPartyPrimaryKey);

    /**
     *  根据查询条件获取SysParty对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysPartyListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysParty对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysPartyListOfNoAuthorityQuery(Map queryMap);
}
