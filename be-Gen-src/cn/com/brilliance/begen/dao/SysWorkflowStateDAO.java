package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.model.SysWorkflowState;

/**
 * SysWorkflowStateDAO�ӿ�.
 * @author Administrator.
 */

public interface SysWorkflowStateDAO {

    /**
     *  �����������SysWorkflowState����.
     *  @param sysWorkflowStatePrimaryKey SysWorkflowState����
     *  @return SysWorkflowState.
     */
    SysWorkflowState getSysWorkflowState(java.lang.String sysWorkflowStatePrimaryKey);

    /**
     *  ��ȡSysWorkflowState�����б�.
     *  @param  sysWorkflowState SysWorkflowState����
     *  @return List.
     */
    List getSysWorkflowStateList(SysWorkflowState sysWorkflowState);

    /**
     *  �洢SysWorkflowState����.
     *  @param  sysWorkflowState SysWorkflowState����
     *  @return SysWorkflowState.
     */
    SysWorkflowState saveSysWorkflowState(SysWorkflowState sysWorkflowState);

    /**
     *  ɾ��SysWorkflowState����.
     *  @param sysWorkflowStatePrimaryKey SysWorkflowState����.
     */
    void removeSysWorkflowState(java.lang.String sysWorkflowStatePrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysWorkflowState�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysWorkflowStateListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysWorkflowState�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysWorkflowStateListOfNoAuthorityQuery(Map queryMap);
}
