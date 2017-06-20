package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysMessage;

/**
 * SysMessageDAO接口.
 * @author Administrator.
 */

public interface SysMessageDAO {

    /**
     *  根据主键获得SysMessage对象.
     *  @param sysMessagePrimaryKey SysMessage主键
     *  @return SysMessage.
     */
    SysMessage getSysMessage(java.lang.String sysMessagePrimaryKey);

    /**
     *  获取SysMessage对象列表.
     *  @param  sysMessage SysMessage对象
     *  @return List.
     */
    List getSysMessageList(SysMessage sysMessage);

    /**
     *  存储SysMessage对象.
     *  @param  sysMessage SysMessage对象
     *  @return SysMessage.
     */
    SysMessage saveSysMessage(SysMessage sysMessage);

    /**
     *  删除SysMessage对象.
     *  @param sysMessagePrimaryKey SysMessage主键.
     */
    void removeSysMessage(java.lang.String sysMessagePrimaryKey);

    /**
     *  根据查询条件获取SysMessage对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysMessageListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysMessage对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysMessageListOfNoAuthorityQuery(Map queryMap);
}
