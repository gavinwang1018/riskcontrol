package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.model.SysWorkflowDef;

/**
 * SysWorkflowDefDAO�ӿ�.
 * @author Administrator.
 */

public interface SysWorkflowDefDAO {

    /**
     *  �����������SysWorkflowDef����.
     *  @param sysWorkflowDefPrimaryKey SysWorkflowDef����
     *  @return SysWorkflowDef.
     */
    SysWorkflowDef getSysWorkflowDef(java.lang.String sysWorkflowDefPrimaryKey);

    /**
     *  ��ȡSysWorkflowDef�����б�.
     *  @param  sysWorkflowDef SysWorkflowDef����
     *  @return List.
     */
    List getSysWorkflowDefList(SysWorkflowDef sysWorkflowDef);

    /**
     *  �洢SysWorkflowDef����.
     *  @param  sysWorkflowDef SysWorkflowDef����
     *  @return SysWorkflowDef.
     */
    SysWorkflowDef saveSysWorkflowDef(SysWorkflowDef sysWorkflowDef);

    /**
     *  ɾ��SysWorkflowDef����.
     *  @param sysWorkflowDefPrimaryKey SysWorkflowDef����.
     */
    void removeSysWorkflowDef(java.lang.String sysWorkflowDefPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysWorkflowDef�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysWorkflowDefListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysWorkflowDef�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysWorkflowDefListOfNoAuthorityQuery(Map queryMap);
}
