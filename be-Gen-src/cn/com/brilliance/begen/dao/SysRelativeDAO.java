package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysRelative;

/**
 * SysRelativeDAO�ӿ�.
 * @author Administrator.
 */

public interface SysRelativeDAO {

    /**
     *  �����������SysRelative����.
     *  @param sysRelativePrimaryKey SysRelative����
     *  @return SysRelative.
     */
    SysRelative getSysRelative(java.lang.String sysRelativePrimaryKey);

    /**
     *  ��ȡSysRelative�����б�.
     *  @param  sysRelative SysRelative����
     *  @return List.
     */
    List getSysRelativeList(SysRelative sysRelative);

    /**
     *  �洢SysRelative����.
     *  @param  sysRelative SysRelative����
     *  @return SysRelative.
     */
    SysRelative saveSysRelative(SysRelative sysRelative);

    /**
     *  ɾ��SysRelative����.
     *  @param sysRelativePrimaryKey SysRelative����.
     */
    void removeSysRelative(java.lang.String sysRelativePrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysRelative�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysRelativeListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysRelative�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysRelativeListOfNoAuthorityQuery(Map queryMap);
}
