package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysWorkflowInsTask;

/**
 * SysWorkflowInsTaskDAO�ӿ�.
 * @author Administrator.
 */

public interface SysWorkflowInsTaskDAO {

    /**
     *  �����������SysWorkflowInsTask����.
     *  @param sysWorkflowInsTaskPrimaryKey SysWorkflowInsTask����
     *  @return SysWorkflowInsTask.
     */
    SysWorkflowInsTask getSysWorkflowInsTask(java.lang.String sysWorkflowInsTaskPrimaryKey);

    /**
     *  ��ȡSysWorkflowInsTask�����б�.
     *  @param  sysWorkflowInsTask SysWorkflowInsTask����
     *  @return List.
     */
    List getSysWorkflowInsTaskList(SysWorkflowInsTask sysWorkflowInsTask);

    /**
     *  �洢SysWorkflowInsTask����.
     *  @param  sysWorkflowInsTask SysWorkflowInsTask����
     *  @return SysWorkflowInsTask.
     */
    SysWorkflowInsTask saveSysWorkflowInsTask(SysWorkflowInsTask sysWorkflowInsTask);

    /**
     *  ɾ��SysWorkflowInsTask����.
     *  @param sysWorkflowInsTaskPrimaryKey SysWorkflowInsTask����.
     */
    void removeSysWorkflowInsTask(java.lang.String sysWorkflowInsTaskPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysWorkflowInsTask�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysWorkflowInsTaskListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysWorkflowInsTask�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysWorkflowInsTaskListOfNoAuthorityQuery(Map queryMap);
}
