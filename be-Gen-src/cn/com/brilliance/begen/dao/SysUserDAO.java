package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysUser;

/**
 * SysUserDAO�ӿ�.
 * @author Administrator.
 */

public interface SysUserDAO {

    /**
     *  �����������SysUser����.
     *  @param sysUserPrimaryKey SysUser����
     *  @return SysUser.
     */
    SysUser getSysUser(java.lang.String sysUserPrimaryKey);

    /**
     *  ��ȡSysUser�����б�.
     *  @param  sysUser SysUser����
     *  @return List.
     */
    List getSysUserList(SysUser sysUser);

    /**
     *  �洢SysUser����.
     *  @param  sysUser SysUser����
     *  @return SysUser.
     */
    SysUser saveSysUser(SysUser sysUser);

    /**
     *  ɾ��SysUser����.
     *  @param sysUserPrimaryKey SysUser����.
     */
    void removeSysUser(java.lang.String sysUserPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysUser�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysUserListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysUser�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysUserListOfNoAuthorityQuery(Map queryMap);
}
