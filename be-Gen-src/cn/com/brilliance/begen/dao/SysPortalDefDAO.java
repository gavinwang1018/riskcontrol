package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysPortalDef;

/**
 * SysPortalDefDAO�ӿ�.
 * @author Administrator.
 */

public interface SysPortalDefDAO {

    /**
     *  �����������SysPortalDef����.
     *  @param sysPortalDefPrimaryKey SysPortalDef����
     *  @return SysPortalDef.
     */
    SysPortalDef getSysPortalDef(java.lang.String sysPortalDefPrimaryKey);

    /**
     *  ��ȡSysPortalDef�����б�.
     *  @param  sysPortalDef SysPortalDef����
     *  @return List.
     */
    List getSysPortalDefList(SysPortalDef sysPortalDef);

    /**
     *  �洢SysPortalDef����.
     *  @param  sysPortalDef SysPortalDef����
     *  @return SysPortalDef.
     */
    SysPortalDef saveSysPortalDef(SysPortalDef sysPortalDef);

    /**
     *  ɾ��SysPortalDef����.
     *  @param sysPortalDefPrimaryKey SysPortalDef����.
     */
    void removeSysPortalDef(java.lang.String sysPortalDefPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysPortalDef�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysPortalDefListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysPortalDef�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysPortalDefListOfNoAuthorityQuery(Map queryMap);
}
