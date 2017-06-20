package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysEcaDef;

/**
 * SysEcaDefDAO�ӿ�.
 * @author Administrator.
 */

public interface SysEcaDefDAO {

    /**
     *  �����������SysEcaDef����.
     *  @param sysEcaDefPrimaryKey SysEcaDef����
     *  @return SysEcaDef.
     */
    SysEcaDef getSysEcaDef(java.lang.String sysEcaDefPrimaryKey);

    /**
     *  ��ȡSysEcaDef�����б�.
     *  @param  sysEcaDef SysEcaDef����
     *  @return List.
     */
    List getSysEcaDefList(SysEcaDef sysEcaDef);

    /**
     *  �洢SysEcaDef����.
     *  @param  sysEcaDef SysEcaDef����
     *  @return SysEcaDef.
     */
    SysEcaDef saveSysEcaDef(SysEcaDef sysEcaDef);

    /**
     *  ɾ��SysEcaDef����.
     *  @param sysEcaDefPrimaryKey SysEcaDef����.
     */
    void removeSysEcaDef(java.lang.String sysEcaDefPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysEcaDef�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysEcaDefListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysEcaDef�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysEcaDefListOfNoAuthorityQuery(Map queryMap);
}
