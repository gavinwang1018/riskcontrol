package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysParty;

/**
 * SysPartyDAO�ӿ�.
 * @author Administrator.
 */

public interface SysPartyDAO {

    /**
     *  �����������SysParty����.
     *  @param sysPartyPrimaryKey SysParty����
     *  @return SysParty.
     */
    SysParty getSysParty(java.lang.String sysPartyPrimaryKey);

    /**
     *  ��ȡSysParty�����б�.
     *  @param  sysParty SysParty����
     *  @return List.
     */
    List getSysPartyList(SysParty sysParty);

    /**
     *  �洢SysParty����.
     *  @param  sysParty SysParty����
     *  @return SysParty.
     */
    SysParty saveSysParty(SysParty sysParty);

    /**
     *  ɾ��SysParty����.
     *  @param sysPartyPrimaryKey SysParty����.
     */
    void removeSysParty(java.lang.String sysPartyPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysParty�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysPartyListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysParty�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysPartyListOfNoAuthorityQuery(Map queryMap);
}
