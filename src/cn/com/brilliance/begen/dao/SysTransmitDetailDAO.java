package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysTransmitDetail;

/**
 * SysTransmitDetailDAO�ӿ�.
 * @author Administrator.
 */

public interface SysTransmitDetailDAO {

    /**
     *  �����������SysTransmitDetail����.
     *  @param sysTransmitDetailPrimaryKey SysTransmitDetail����
     *  @return SysTransmitDetail.
     */
    SysTransmitDetail getSysTransmitDetail(java.lang.String sysTransmitDetailPrimaryKey);

    /**
     *  ��ȡSysTransmitDetail�����б�.
     *  @param  sysTransmitDetail SysTransmitDetail����
     *  @return List.
     */
    List getSysTransmitDetailList(SysTransmitDetail sysTransmitDetail);

    /**
     *  �洢SysTransmitDetail����.
     *  @param  sysTransmitDetail SysTransmitDetail����
     *  @return SysTransmitDetail.
     */
    SysTransmitDetail saveSysTransmitDetail(SysTransmitDetail sysTransmitDetail);

    /**
     *  ɾ��SysTransmitDetail����.
     *  @param sysTransmitDetailPrimaryKey SysTransmitDetail����.
     */
    void removeSysTransmitDetail(java.lang.String sysTransmitDetailPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysTransmitDetail�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysTransmitDetailListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysTransmitDetail�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysTransmitDetailListOfNoAuthorityQuery(Map queryMap);
}
