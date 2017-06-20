package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysSection;

/**
 * SysSectionDAO�ӿ�.
 * @author Administrator.
 */

public interface SysSectionDAO {

    /**
     *  �����������SysSection����.
     *  @param sysSectionPrimaryKey SysSection����
     *  @return SysSection.
     */
    SysSection getSysSection(java.lang.String sysSectionPrimaryKey);

    /**
     *  ��ȡSysSection�����б�.
     *  @param  sysSection SysSection����
     *  @return List.
     */
    List getSysSectionList(SysSection sysSection);

    /**
     *  �洢SysSection����.
     *  @param  sysSection SysSection����
     *  @return SysSection.
     */
    SysSection saveSysSection(SysSection sysSection);

    /**
     *  ɾ��SysSection����.
     *  @param sysSectionPrimaryKey SysSection����.
     */
    void removeSysSection(java.lang.String sysSectionPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysSection�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysSectionListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysSection�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysSectionListOfNoAuthorityQuery(Map queryMap);
}
