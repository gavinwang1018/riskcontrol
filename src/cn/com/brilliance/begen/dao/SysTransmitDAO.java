package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysTransmit;

/**
 * SysTransmitDAO�ӿ�.
 * @author Administrator.
 */

public interface SysTransmitDAO {

    /**
     *  �����������SysTransmit����.
     *  @param sysTransmitPrimaryKey SysTransmit����
     *  @return SysTransmit.
     */
    SysTransmit getSysTransmit(java.lang.String sysTransmitPrimaryKey);

    /**
     *  ��ȡSysTransmit�����б�.
     *  @param  sysTransmit SysTransmit����
     *  @return List.
     */
    List getSysTransmitList(SysTransmit sysTransmit);

    /**
     *  �洢SysTransmit����.
     *  @param  sysTransmit SysTransmit����
     *  @return SysTransmit.
     */
    SysTransmit saveSysTransmit(SysTransmit sysTransmit);

    /**
     *  ɾ��SysTransmit����.
     *  @param sysTransmitPrimaryKey SysTransmit����.
     */
    void removeSysTransmit(java.lang.String sysTransmitPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysTransmit�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysTransmitListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysTransmit�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysTransmitListOfNoAuthorityQuery(Map queryMap);
}
