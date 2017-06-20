package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysActionListForm;

/**
 * SysActionListFormDAO接口.
 * @author Administrator.
 */

public interface SysActionListFormDAO {

    /**
     *  根据主键获得SysActionListForm对象.
     *  @param sysActionListFormPrimaryKey SysActionListForm主键
     *  @return SysActionListForm.
     */
    SysActionListForm getSysActionListForm(java.lang.String sysActionListFormPrimaryKey);

    /**
     *  获取SysActionListForm对象列表.
     *  @param  sysActionListForm SysActionListForm对象
     *  @return List.
     */
    List getSysActionListFormList(SysActionListForm sysActionListForm);

    /**
     *  存储SysActionListForm对象.
     *  @param  sysActionListForm SysActionListForm对象
     *  @return SysActionListForm.
     */
    SysActionListForm saveSysActionListForm(SysActionListForm sysActionListForm);

    /**
     *  删除SysActionListForm对象.
     *  @param sysActionListFormPrimaryKey SysActionListForm主键.
     */
    void removeSysActionListForm(java.lang.String sysActionListFormPrimaryKey);

    /**
     *  根据查询条件获取SysActionListForm对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysActionListFormListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取SysActionListForm对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getSysActionListFormListOfNoAuthorityQuery(Map queryMap);
}
