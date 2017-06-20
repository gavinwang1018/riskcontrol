package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysRoleAuthority;

/**
 * SysRoleAuthorityDAO�ӿ�.
 * @author Administrator.
 */

public interface SysRoleAuthorityDAO {

    /**
     *  �����������SysRoleAuthority����.
     *  @param sysRoleAuthorityPrimaryKey SysRoleAuthority����
     *  @return SysRoleAuthority.
     */
    SysRoleAuthority getSysRoleAuthority(java.lang.String sysRoleAuthorityPrimaryKey);

    /**
     *  ��ȡSysRoleAuthority�����б�.
     *  @param  sysRoleAuthority SysRoleAuthority����
     *  @return List.
     */
    List getSysRoleAuthorityList(SysRoleAuthority sysRoleAuthority);

    /**
     *  �洢SysRoleAuthority����.
     *  @param  sysRoleAuthority SysRoleAuthority����
     *  @return SysRoleAuthority.
     */
    SysRoleAuthority saveSysRoleAuthority(SysRoleAuthority sysRoleAuthority);

    /**
     *  ɾ��SysRoleAuthority����.
     *  @param sysRoleAuthorityPrimaryKey SysRoleAuthority����.
     */
    void removeSysRoleAuthority(java.lang.String sysRoleAuthorityPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysRoleAuthority�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysRoleAuthorityListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysRoleAuthority�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysRoleAuthorityListOfNoAuthorityQuery(Map queryMap);
}
