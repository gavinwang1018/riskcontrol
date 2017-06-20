package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysEcaAction;

/**
 * SysEcaActionDAO�ӿ�.
 * @author Administrator.
 */

public interface SysEcaActionDAO {

    /**
     *  �����������SysEcaAction����.
     *  @param sysEcaActionPrimaryKey SysEcaAction����
     *  @return SysEcaAction.
     */
    SysEcaAction getSysEcaAction(java.lang.String sysEcaActionPrimaryKey);

    /**
     *  ��ȡSysEcaAction�����б�.
     *  @param  sysEcaAction SysEcaAction����
     *  @return List.
     */
    List getSysEcaActionList(SysEcaAction sysEcaAction);

    /**
     *  �洢SysEcaAction����.
     *  @param  sysEcaAction SysEcaAction����
     *  @return SysEcaAction.
     */
    SysEcaAction saveSysEcaAction(SysEcaAction sysEcaAction);

    /**
     *  ɾ��SysEcaAction����.
     *  @param sysEcaActionPrimaryKey SysEcaAction����.
     */
    void removeSysEcaAction(java.lang.String sysEcaActionPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysEcaAction�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysEcaActionListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysEcaAction�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysEcaActionListOfNoAuthorityQuery(Map queryMap);
}
