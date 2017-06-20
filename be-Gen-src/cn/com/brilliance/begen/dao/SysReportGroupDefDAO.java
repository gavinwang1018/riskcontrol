package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysReportGroupDef;

/**
 * SysReportGroupDefDAO�ӿ�.
 * @author Administrator.
 */

public interface SysReportGroupDefDAO {

    /**
     *  �����������SysReportGroupDef����.
     *  @param sysReportGroupDefPrimaryKey SysReportGroupDef����
     *  @return SysReportGroupDef.
     */
    SysReportGroupDef getSysReportGroupDef(java.lang.String sysReportGroupDefPrimaryKey);

    /**
     *  ��ȡSysReportGroupDef�����б�.
     *  @param  sysReportGroupDef SysReportGroupDef����
     *  @return List.
     */
    List getSysReportGroupDefList(SysReportGroupDef sysReportGroupDef);

    /**
     *  �洢SysReportGroupDef����.
     *  @param  sysReportGroupDef SysReportGroupDef����
     *  @return SysReportGroupDef.
     */
    SysReportGroupDef saveSysReportGroupDef(SysReportGroupDef sysReportGroupDef);

    /**
     *  ɾ��SysReportGroupDef����.
     *  @param sysReportGroupDefPrimaryKey SysReportGroupDef����.
     */
    void removeSysReportGroupDef(java.lang.String sysReportGroupDefPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysReportGroupDef�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysReportGroupDefListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysReportGroupDef�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysReportGroupDefListOfNoAuthorityQuery(Map queryMap);
}
