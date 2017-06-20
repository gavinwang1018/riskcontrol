package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysField;

/**
 * SysFieldDAO�ӿ�.
 * @author Administrator.
 */

public interface SysFieldDAO {

    /**
     *  �����������SysField����.
     *  @param sysFieldPrimaryKey SysField����
     *  @return SysField.
     */
    SysField getSysField(java.lang.String sysFieldPrimaryKey);

    /**
     *  ��ȡSysField�����б�.
     *  @param  sysField SysField����
     *  @return List.
     */
    List getSysFieldList(SysField sysField);

    /**
     *  �洢SysField����.
     *  @param  sysField SysField����
     *  @return SysField.
     */
    SysField saveSysField(SysField sysField);

    /**
     *  ɾ��SysField����.
     *  @param sysFieldPrimaryKey SysField����.
     */
    void removeSysField(java.lang.String sysFieldPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysField�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysFieldListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysField�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysFieldListOfNoAuthorityQuery(Map queryMap);
}
