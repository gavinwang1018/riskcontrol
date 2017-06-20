package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysTemplateImport;

/**
 * SysTemplateImportDAO接口.
 * @author Administrator.
 */

public interface SysTemplateImportDAO {

    /**
     *  根据主键获得SysTemplateImport对象.
     *  @param sysTemplateImportPrimaryKey SysTemplateImport主键
     *  @return SysTemplateImport.
     */
    SysTemplateImport getSysTemplateImport(java.lang.String sysTemplateImportPrimaryKey);

    /**
     *  获取SysTemplateImport对象列表.
     *  @param  sysTemplateImport SysTemplateImport对象
     *  @return List.
     */
    List getSysTemplateImportList(SysTemplateImport sysTemplateImport);

    /**
     *  存储SysTemplateImport对象.
     *  @param  sysTemplateImport SysTemplateImport对象
     *  @return SysTemplateImport.
     */
    SysTemplateImport saveSysTemplateImport(SysTemplateImport sysTemplateImport);

    /**
     *  删除SysTemplateImport对象.
     *  @param sysTemplateImportPrimaryKey SysTemplateImport主键.
     */
    void removeSysTemplateImport(java.lang.String sysTemplateImportPrimaryKey);

    /**
     *  根据查询条件获取SysTemplateImport对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysTemplateImportListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysTemplateImport对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysTemplateImportListOfNoAuthorityQuery(Map queryMap);
}
