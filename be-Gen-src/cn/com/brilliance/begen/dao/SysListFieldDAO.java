package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysListField;

/**
 * SysListFieldDAO�ӿ�.
 * @author Administrator.
 */

public interface SysListFieldDAO {

    /**
     *  �����������SysListField����.
     *  @param sysListFieldPrimaryKey SysListField����
     *  @return SysListField.
     */
    SysListField getSysListField(java.lang.String sysListFieldPrimaryKey);

    /**
     *  ��ȡSysListField�����б�.
     *  @param  sysListField SysListField����
     *  @return List.
     */
    List getSysListFieldList(SysListField sysListField);

    /**
     *  �洢SysListField����.
     *  @param  sysListField SysListField����
     *  @return SysListField.
     */
    SysListField saveSysListField(SysListField sysListField);

    /**
     *  ɾ��SysListField����.
     *  @param sysListFieldPrimaryKey SysListField����.
     */
    void removeSysListField(java.lang.String sysListFieldPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysListField�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysListFieldListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysListField�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysListFieldListOfNoAuthorityQuery(Map queryMap);
}
