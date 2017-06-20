package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysUserRole;

/**
 * SysUserRoleDAO�ӿ�.
 * @author Administrator.
 */

public interface SysUserRoleDAO {

    /**
     *  �����������SysUserRole����.
     *  @param sysUserRolePrimaryKey SysUserRole����
     *  @return SysUserRole.
     */
    SysUserRole getSysUserRole(java.lang.String sysUserRolePrimaryKey);

    /**
     *  ��ȡSysUserRole�����б�.
     *  @param  sysUserRole SysUserRole����
     *  @return List.
     */
    List getSysUserRoleList(SysUserRole sysUserRole);

    /**
     *  �洢SysUserRole����.
     *  @param  sysUserRole SysUserRole����
     *  @return SysUserRole.
     */
    SysUserRole saveSysUserRole(SysUserRole sysUserRole);

    /**
     *  ɾ��SysUserRole����.
     *  @param sysUserRolePrimaryKey SysUserRole����.
     */
    void removeSysUserRole(java.lang.String sysUserRolePrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysUserRole�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysUserRoleListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysUserRole�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysUserRoleListOfNoAuthorityQuery(Map queryMap);
}
