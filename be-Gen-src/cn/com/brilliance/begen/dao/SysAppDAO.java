package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysApp;

/**
 * SysAppDAO�ӿ�.
 * @author Administrator.
 */

public interface SysAppDAO {

    /**
     *  �����������SysApp����.
     *  @param sysAppPrimaryKey SysApp����
     *  @return SysApp.
     */
    SysApp getSysApp(java.lang.String sysAppPrimaryKey);

    /**
     *  ��ȡSysApp�����б�.
     *  @param  sysApp SysApp����
     *  @return List.
     */
    List getSysAppList(SysApp sysApp);

    /**
     *  �洢SysApp����.
     *  @param  sysApp SysApp����
     *  @return SysApp.
     */
    SysApp saveSysApp(SysApp sysApp);

    /**
     *  ɾ��SysApp����.
     *  @param sysAppPrimaryKey SysApp����.
     */
    void removeSysApp(java.lang.String sysAppPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysApp�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysAppListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysApp�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysAppListOfNoAuthorityQuery(Map queryMap);
}
