package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysOrg;

/**
 * SysOrgDAO�ӿ�.
 * @author Administrator.
 */

public interface SysOrgDAO {

    /**
     *  �����������SysOrg����.
     *  @param sysOrgPrimaryKey SysOrg����
     *  @return SysOrg.
     */
    SysOrg getSysOrg(java.lang.String sysOrgPrimaryKey);

    /**
     *  ��ȡSysOrg�����б�.
     *  @param  sysOrg SysOrg����
     *  @return List.
     */
    List getSysOrgList(SysOrg sysOrg);

    /**
     *  �洢SysOrg����.
     *  @param  sysOrg SysOrg����
     *  @return SysOrg.
     */
    SysOrg saveSysOrg(SysOrg sysOrg);

    /**
     *  ɾ��SysOrg����.
     *  @param sysOrgPrimaryKey SysOrg����.
     */
    void removeSysOrg(java.lang.String sysOrgPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysOrg�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysOrgListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysOrg�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysOrgListOfNoAuthorityQuery(Map queryMap);
}
