package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysAutonumber;

/**
 * SysAutonumberDAO�ӿ�.
 * @author Administrator.
 */

public interface SysAutonumberDAO {

    /**
     *  �����������SysAutonumber����.
     *  @param sysAutonumberPrimaryKey SysAutonumber����
     *  @return SysAutonumber.
     */
    SysAutonumber getSysAutonumber(java.lang.String sysAutonumberPrimaryKey);

    /**
     *  ��ȡSysAutonumber�����б�.
     *  @param  sysAutonumber SysAutonumber����
     *  @return List.
     */
    List getSysAutonumberList(SysAutonumber sysAutonumber);

    /**
     *  �洢SysAutonumber����.
     *  @param  sysAutonumber SysAutonumber����
     *  @return SysAutonumber.
     */
    SysAutonumber saveSysAutonumber(SysAutonumber sysAutonumber);

    /**
     *  ɾ��SysAutonumber����.
     *  @param sysAutonumberPrimaryKey SysAutonumber����.
     */
    void removeSysAutonumber(java.lang.String sysAutonumberPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysAutonumber�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysAutonumberListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysAutonumber�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysAutonumberListOfNoAuthorityQuery(Map queryMap);
}
