package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysTemplate;

/**
 * SysTemplateDAO接口.
 * @author Administrator.
 */

public interface SysTemplateDAO {

    /**
     *  根据主键获得SysTemplate对象.
     *  @param sysTemplatePrimaryKey SysTemplate主键
     *  @return SysTemplate.
     */
    SysTemplate getSysTemplate(java.lang.String sysTemplatePrimaryKey);

    /**
     *  获取SysTemplate对象列表.
     *  @param  sysTemplate SysTemplate对象
     *  @return List.
     */
    List getSysTemplateList(SysTemplate sysTemplate);

    /**
     *  存储SysTemplate对象.
     *  @param  sysTemplate SysTemplate对象
     *  @return SysTemplate.
     */
    SysTemplate saveSysTemplate(SysTemplate sysTemplate);

    /**
     *  删除SysTemplate对象.
     *  @param sysTemplatePrimaryKey SysTemplate主键.
     */
    void removeSysTemplate(java.lang.String sysTemplatePrimaryKey);

    /**
     *  根据查询条件获取SysTemplate对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysTemplateListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysTemplate对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysTemplateListOfNoAuthorityQuery(Map queryMap);
}
