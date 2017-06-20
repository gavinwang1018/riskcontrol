package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysActionListRec;

/**
 * SysActionListRecDAO�ӿ�.
 * @author Administrator.
 */

public interface SysActionListRecDAO {

    /**
     *  �����������SysActionListRec����.
     *  @param sysActionListRecPrimaryKey SysActionListRec����
     *  @return SysActionListRec.
     */
    SysActionListRec getSysActionListRec(java.lang.String sysActionListRecPrimaryKey);

    /**
     *  ��ȡSysActionListRec�����б�.
     *  @param  sysActionListRec SysActionListRec����
     *  @return List.
     */
    List getSysActionListRecList(SysActionListRec sysActionListRec);

    /**
     *  �洢SysActionListRec����.
     *  @param  sysActionListRec SysActionListRec����
     *  @return SysActionListRec.
     */
    SysActionListRec saveSysActionListRec(SysActionListRec sysActionListRec);

    /**
     *  ɾ��SysActionListRec����.
     *  @param sysActionListRecPrimaryKey SysActionListRec����.
     */
    void removeSysActionListRec(java.lang.String sysActionListRecPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysActionListRec�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysActionListRecListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysActionListRec�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysActionListRecListOfNoAuthorityQuery(Map queryMap);
}
