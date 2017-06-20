package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysPortletDef;

/**
 * SysPortletDefDAO�ӿ�.
 * @author Administrator.
 */

public interface SysPortletDefDAO {

    /**
     *  �����������SysPortletDef����.
     *  @param sysPortletDefPrimaryKey SysPortletDef����
     *  @return SysPortletDef.
     */
    SysPortletDef getSysPortletDef(java.lang.String sysPortletDefPrimaryKey);

    /**
     *  ��ȡSysPortletDef�����б�.
     *  @param  sysPortletDef SysPortletDef����
     *  @return List.
     */
    List getSysPortletDefList(SysPortletDef sysPortletDef);

    /**
     *  �洢SysPortletDef����.
     *  @param  sysPortletDef SysPortletDef����
     *  @return SysPortletDef.
     */
    SysPortletDef saveSysPortletDef(SysPortletDef sysPortletDef);

    /**
     *  ɾ��SysPortletDef����.
     *  @param sysPortletDefPrimaryKey SysPortletDef����.
     */
    void removeSysPortletDef(java.lang.String sysPortletDefPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysPortletDef�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysPortletDefListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysPortletDef�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysPortletDefListOfNoAuthorityQuery(Map queryMap);
}
