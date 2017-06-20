package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysRole;

/**
 * SysRoleDAO�ӿ�.
 * @author Administrator.
 */

public interface SysRoleDAO {

    /**
     *  �����������SysRole����.
     *  @param sysRolePrimaryKey SysRole����
     *  @return SysRole.
     */
    SysRole getSysRole(java.lang.String sysRolePrimaryKey);

    /**
     *  ��ȡSysRole�����б�.
     *  @param  sysRole SysRole����
     *  @return List.
     */
    List getSysRoleList(SysRole sysRole);

    /**
     *  �洢SysRole����.
     *  @param  sysRole SysRole����
     *  @return SysRole.
     */
    SysRole saveSysRole(SysRole sysRole);

    /**
     *  ɾ��SysRole����.
     *  @param sysRolePrimaryKey SysRole����.
     */
    void removeSysRole(java.lang.String sysRolePrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysRole�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysRoleListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysRole�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysRoleListOfNoAuthorityQuery(Map queryMap);
}
