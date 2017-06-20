package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysReportQueryDef;

/**
 * SysReportQueryDefDAO�ӿ�.
 * @author Administrator.
 */

public interface SysReportQueryDefDAO {

    /**
     *  �����������SysReportQueryDef����.
     *  @param sysReportQueryDefPrimaryKey SysReportQueryDef����
     *  @return SysReportQueryDef.
     */
    SysReportQueryDef getSysReportQueryDef(java.lang.String sysReportQueryDefPrimaryKey);

    /**
     *  ��ȡSysReportQueryDef�����б�.
     *  @param  sysReportQueryDef SysReportQueryDef����
     *  @return List.
     */
    List getSysReportQueryDefList(SysReportQueryDef sysReportQueryDef);

    /**
     *  �洢SysReportQueryDef����.
     *  @param  sysReportQueryDef SysReportQueryDef����
     *  @return SysReportQueryDef.
     */
    SysReportQueryDef saveSysReportQueryDef(SysReportQueryDef sysReportQueryDef);

    /**
     *  ɾ��SysReportQueryDef����.
     *  @param sysReportQueryDefPrimaryKey SysReportQueryDef����.
     */
    void removeSysReportQueryDef(java.lang.String sysReportQueryDefPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysReportQueryDef�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysReportQueryDefListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysReportQueryDef�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysReportQueryDefListOfNoAuthorityQuery(Map queryMap);
}
