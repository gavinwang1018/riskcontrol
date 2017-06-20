package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysWorkflowInsProc;

/**
 * SysWorkflowInsProcDAO�ӿ�.
 * @author Administrator.
 */

public interface SysWorkflowInsProcDAO {

    /**
     *  �����������SysWorkflowInsProc����.
     *  @param sysWorkflowInsProcPrimaryKey SysWorkflowInsProc����
     *  @return SysWorkflowInsProc.
     */
    SysWorkflowInsProc getSysWorkflowInsProc(java.lang.String sysWorkflowInsProcPrimaryKey);

    /**
     *  ��ȡSysWorkflowInsProc�����б�.
     *  @param  sysWorkflowInsProc SysWorkflowInsProc����
     *  @return List.
     */
    List getSysWorkflowInsProcList(SysWorkflowInsProc sysWorkflowInsProc);

    /**
     *  �洢SysWorkflowInsProc����.
     *  @param  sysWorkflowInsProc SysWorkflowInsProc����
     *  @return SysWorkflowInsProc.
     */
    SysWorkflowInsProc saveSysWorkflowInsProc(SysWorkflowInsProc sysWorkflowInsProc);

    /**
     *  ɾ��SysWorkflowInsProc����.
     *  @param sysWorkflowInsProcPrimaryKey SysWorkflowInsProc����.
     */
    void removeSysWorkflowInsProc(java.lang.String sysWorkflowInsProcPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysWorkflowInsProc�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysWorkflowInsProcListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysWorkflowInsProc�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysWorkflowInsProcListOfNoAuthorityQuery(Map queryMap);
}
