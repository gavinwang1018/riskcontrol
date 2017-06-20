package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysRelativeAction;

/**
 * SysRelativeActionDAO�ӿ�.
 * @author Administrator.
 */

public interface SysRelativeActionDAO {

    /**
     *  �����������SysRelativeAction����.
     *  @param sysRelativeActionPrimaryKey SysRelativeAction����
     *  @return SysRelativeAction.
     */
    SysRelativeAction getSysRelativeAction(java.lang.String sysRelativeActionPrimaryKey);

    /**
     *  ��ȡSysRelativeAction�����б�.
     *  @param  sysRelativeAction SysRelativeAction����
     *  @return List.
     */
    List getSysRelativeActionList(SysRelativeAction sysRelativeAction);

    /**
     *  �洢SysRelativeAction����.
     *  @param  sysRelativeAction SysRelativeAction����
     *  @return SysRelativeAction.
     */
    SysRelativeAction saveSysRelativeAction(SysRelativeAction sysRelativeAction);

    /**
     *  ɾ��SysRelativeAction����.
     *  @param sysRelativeActionPrimaryKey SysRelativeAction����.
     */
    void removeSysRelativeAction(java.lang.String sysRelativeActionPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysRelativeAction�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysRelativeActionListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysRelativeAction�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysRelativeActionListOfNoAuthorityQuery(Map queryMap);
}
