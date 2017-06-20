package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysUserAuthority;

/**
 * SysUserAuthorityDAO�ӿ�.
 * @author Administrator.
 */

public interface SysUserAuthorityDAO {

    /**
     *  �����������SysUserAuthority����.
     *  @param sysUserAuthorityPrimaryKey SysUserAuthority����
     *  @return SysUserAuthority.
     */
    SysUserAuthority getSysUserAuthority(java.lang.String sysUserAuthorityPrimaryKey);

    /**
     *  ��ȡSysUserAuthority�����б�.
     *  @param  sysUserAuthority SysUserAuthority����
     *  @return List.
     */
    List getSysUserAuthorityList(SysUserAuthority sysUserAuthority);

    /**
     *  �洢SysUserAuthority����.
     *  @param  sysUserAuthority SysUserAuthority����
     *  @return SysUserAuthority.
     */
    SysUserAuthority saveSysUserAuthority(SysUserAuthority sysUserAuthority);

    /**
     *  ɾ��SysUserAuthority����.
     *  @param sysUserAuthorityPrimaryKey SysUserAuthority����.
     */
    void removeSysUserAuthority(java.lang.String sysUserAuthorityPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysUserAuthority�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysUserAuthorityListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysUserAuthority�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysUserAuthorityListOfNoAuthorityQuery(Map queryMap);
}
