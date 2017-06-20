package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysLoginfo;

/**
 * SysLoginfoDAO�ӿ�.
 * @author Administrator.
 */

public interface SysLoginfoDAO {

    /**
     *  �����������SysLoginfo����.
     *  @param sysLoginfoPrimaryKey SysLoginfo����
     *  @return SysLoginfo.
     */
    SysLoginfo getSysLoginfo(java.lang.String sysLoginfoPrimaryKey);

    /**
     *  ��ȡSysLoginfo�����б�.
     *  @param  sysLoginfo SysLoginfo����
     *  @return List.
     */
    List getSysLoginfoList(SysLoginfo sysLoginfo);

    /**
     *  �洢SysLoginfo����.
     *  @param  sysLoginfo SysLoginfo����
     *  @return SysLoginfo.
     */
    SysLoginfo saveSysLoginfo(SysLoginfo sysLoginfo);

    /**
     *  ɾ��SysLoginfo����.
     *  @param sysLoginfoPrimaryKey SysLoginfo����.
     */
    void removeSysLoginfo(java.lang.String sysLoginfoPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysLoginfo�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysLoginfoListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysLoginfo�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysLoginfoListOfNoAuthorityQuery(Map queryMap);
}
