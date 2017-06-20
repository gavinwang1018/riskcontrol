package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysTransmitDetail;

/**
 * SysTransmitDetailDAO接口.
 * @author Administrator.
 */

public interface SysTransmitDetailDAO {

    /**
     *  根据主键获得SysTransmitDetail对象.
     *  @param sysTransmitDetailPrimaryKey SysTransmitDetail主键
     *  @return SysTransmitDetail.
     */
    SysTransmitDetail getSysTransmitDetail(java.lang.String sysTransmitDetailPrimaryKey);

    /**
     *  获取SysTransmitDetail对象列表.
     *  @param  sysTransmitDetail SysTransmitDetail对象
     *  @return List.
     */
    List getSysTransmitDetailList(SysTransmitDetail sysTransmitDetail);

    /**
     *  存储SysTransmitDetail对象.
     *  @param  sysTransmitDetail SysTransmitDetail对象
     *  @return SysTransmitDetail.
     */
    SysTransmitDetail saveSysTransmitDetail(SysTransmitDetail sysTransmitDetail);

    /**
     *  删除SysTransmitDetail对象.
     *  @param sysTransmitDetailPrimaryKey SysTransmitDetail主键.
     */
    void removeSysTransmitDetail(java.lang.String sysTransmitDetailPrimaryKey);

    /**
     *  根据查询条件获取SysTransmitDetail对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysTransmitDetailListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysTransmitDetail对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysTransmitDetailListOfNoAuthorityQuery(Map queryMap);
}
