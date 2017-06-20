package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysReportFieldDef;

/**
 * SysReportFieldDefDAO�ӿ�.
 * @author Administrator.
 */

public interface SysReportFieldDefDAO {

    /**
     *  �����������SysReportFieldDef����.
     *  @param sysReportFieldDefPrimaryKey SysReportFieldDef����
     *  @return SysReportFieldDef.
     */
    SysReportFieldDef getSysReportFieldDef(java.lang.String sysReportFieldDefPrimaryKey);

    /**
     *  ��ȡSysReportFieldDef�����б�.
     *  @param  sysReportFieldDef SysReportFieldDef����
     *  @return List.
     */
    List getSysReportFieldDefList(SysReportFieldDef sysReportFieldDef);

    /**
     *  �洢SysReportFieldDef����.
     *  @param  sysReportFieldDef SysReportFieldDef����
     *  @return SysReportFieldDef.
     */
    SysReportFieldDef saveSysReportFieldDef(SysReportFieldDef sysReportFieldDef);

    /**
     *  ɾ��SysReportFieldDef����.
     *  @param sysReportFieldDefPrimaryKey SysReportFieldDef����.
     */
    void removeSysReportFieldDef(java.lang.String sysReportFieldDefPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysReportFieldDef�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysReportFieldDefListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysReportFieldDef�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysReportFieldDefListOfNoAuthorityQuery(Map queryMap);
}
