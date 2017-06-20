package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysReportDef;

/**
 * SysReportDefDAO�ӿ�.
 * @author Administrator.
 */

public interface SysReportDefDAO {

    /**
     *  �����������SysReportDef����.
     *  @param sysReportDefPrimaryKey SysReportDef����
     *  @return SysReportDef.
     */
    SysReportDef getSysReportDef(java.lang.String sysReportDefPrimaryKey);

    /**
     *  ��ȡSysReportDef�����б�.
     *  @param  sysReportDef SysReportDef����
     *  @return List.
     */
    List getSysReportDefList(SysReportDef sysReportDef);

    /**
     *  �洢SysReportDef����.
     *  @param  sysReportDef SysReportDef����
     *  @return SysReportDef.
     */
    SysReportDef saveSysReportDef(SysReportDef sysReportDef);

    /**
     *  ɾ��SysReportDef����.
     *  @param sysReportDefPrimaryKey SysReportDef����.
     */
    void removeSysReportDef(java.lang.String sysReportDefPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysReportDef�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysReportDefListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysReportDef�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysReportDefListOfNoAuthorityQuery(Map queryMap);
}
