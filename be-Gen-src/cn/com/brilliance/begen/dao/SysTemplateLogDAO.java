package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysTemplateLog;

/**
 * SysTemplateLogDAO�ӿ�.
 * @author Administrator.
 */

public interface SysTemplateLogDAO {

    /**
     *  �����������SysTemplateLog����.
     *  @param sysTemplateLogPrimaryKey SysTemplateLog����
     *  @return SysTemplateLog.
     */
    SysTemplateLog getSysTemplateLog(java.lang.String sysTemplateLogPrimaryKey);

    /**
     *  ��ȡSysTemplateLog�����б�.
     *  @param  sysTemplateLog SysTemplateLog����
     *  @return List.
     */
    List getSysTemplateLogList(SysTemplateLog sysTemplateLog);

    /**
     *  �洢SysTemplateLog����.
     *  @param  sysTemplateLog SysTemplateLog����
     *  @return SysTemplateLog.
     */
    SysTemplateLog saveSysTemplateLog(SysTemplateLog sysTemplateLog);

    /**
     *  ɾ��SysTemplateLog����.
     *  @param sysTemplateLogPrimaryKey SysTemplateLog����.
     */
    void removeSysTemplateLog(java.lang.String sysTemplateLogPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysTemplateLog�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysTemplateLogListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysTemplateLog�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysTemplateLogListOfNoAuthorityQuery(Map queryMap);
}
