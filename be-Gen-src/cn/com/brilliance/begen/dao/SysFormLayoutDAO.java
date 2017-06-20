package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysFormLayout;

/**
 * SysFormLayoutDAO�ӿ�.
 * @author Administrator.
 */

public interface SysFormLayoutDAO {

    /**
     *  �����������SysFormLayout����.
     *  @param sysFormLayoutPrimaryKey SysFormLayout����
     *  @return SysFormLayout.
     */
    SysFormLayout getSysFormLayout(java.lang.String sysFormLayoutPrimaryKey);

    /**
     *  ��ȡSysFormLayout�����б�.
     *  @param  sysFormLayout SysFormLayout����
     *  @return List.
     */
    List getSysFormLayoutList(SysFormLayout sysFormLayout);

    /**
     *  �洢SysFormLayout����.
     *  @param  sysFormLayout SysFormLayout����
     *  @return SysFormLayout.
     */
    SysFormLayout saveSysFormLayout(SysFormLayout sysFormLayout);

    /**
     *  ɾ��SysFormLayout����.
     *  @param sysFormLayoutPrimaryKey SysFormLayout����.
     */
    void removeSysFormLayout(java.lang.String sysFormLayoutPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysFormLayout�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysFormLayoutListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysFormLayout�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysFormLayoutListOfNoAuthorityQuery(Map queryMap);
}
