package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysMessage;

/**
 * SysMessageDAO�ӿ�.
 * @author Administrator.
 */

public interface SysMessageDAO {

    /**
     *  �����������SysMessage����.
     *  @param sysMessagePrimaryKey SysMessage����
     *  @return SysMessage.
     */
    SysMessage getSysMessage(java.lang.String sysMessagePrimaryKey);

    /**
     *  ��ȡSysMessage�����б�.
     *  @param  sysMessage SysMessage����
     *  @return List.
     */
    List getSysMessageList(SysMessage sysMessage);

    /**
     *  �洢SysMessage����.
     *  @param  sysMessage SysMessage����
     *  @return SysMessage.
     */
    SysMessage saveSysMessage(SysMessage sysMessage);

    /**
     *  ɾ��SysMessage����.
     *  @param sysMessagePrimaryKey SysMessage����.
     */
    void removeSysMessage(java.lang.String sysMessagePrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysMessage�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysMessageListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysMessage�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysMessageListOfNoAuthorityQuery(Map queryMap);
}
