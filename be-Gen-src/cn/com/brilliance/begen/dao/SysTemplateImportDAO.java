package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysTemplateImport;

/**
 * SysTemplateImportDAO�ӿ�.
 * @author Administrator.
 */

public interface SysTemplateImportDAO {

    /**
     *  �����������SysTemplateImport����.
     *  @param sysTemplateImportPrimaryKey SysTemplateImport����
     *  @return SysTemplateImport.
     */
    SysTemplateImport getSysTemplateImport(java.lang.String sysTemplateImportPrimaryKey);

    /**
     *  ��ȡSysTemplateImport�����б�.
     *  @param  sysTemplateImport SysTemplateImport����
     *  @return List.
     */
    List getSysTemplateImportList(SysTemplateImport sysTemplateImport);

    /**
     *  �洢SysTemplateImport����.
     *  @param  sysTemplateImport SysTemplateImport����
     *  @return SysTemplateImport.
     */
    SysTemplateImport saveSysTemplateImport(SysTemplateImport sysTemplateImport);

    /**
     *  ɾ��SysTemplateImport����.
     *  @param sysTemplateImportPrimaryKey SysTemplateImport����.
     */
    void removeSysTemplateImport(java.lang.String sysTemplateImportPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysTemplateImport�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysTemplateImportListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysTemplateImport�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysTemplateImportListOfNoAuthorityQuery(Map queryMap);
}
