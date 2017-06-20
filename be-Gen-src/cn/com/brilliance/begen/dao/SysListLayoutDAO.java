package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysListLayout;

/**
 * SysListLayoutDAO�ӿ�.
 * @author Administrator.
 */

public interface SysListLayoutDAO {

    /**
     *  �����������SysListLayout����.
     *  @param sysListLayoutPrimaryKey SysListLayout����
     *  @return SysListLayout.
     */
    SysListLayout getSysListLayout(java.lang.String sysListLayoutPrimaryKey);

    /**
     *  ��ȡSysListLayout�����б�.
     *  @param  sysListLayout SysListLayout����
     *  @return List.
     */
    List getSysListLayoutList(SysListLayout sysListLayout);

    /**
     *  �洢SysListLayout����.
     *  @param  sysListLayout SysListLayout����
     *  @return SysListLayout.
     */
    SysListLayout saveSysListLayout(SysListLayout sysListLayout);

    /**
     *  ɾ��SysListLayout����.
     *  @param sysListLayoutPrimaryKey SysListLayout����.
     */
    void removeSysListLayout(java.lang.String sysListLayoutPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysListLayout�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysListLayoutListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysListLayout�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysListLayoutListOfNoAuthorityQuery(Map queryMap);
}
