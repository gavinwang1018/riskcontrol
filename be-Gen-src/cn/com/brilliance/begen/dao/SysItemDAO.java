package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysItem;

/**
 * SysItemDAO�ӿ�.
 * @author Administrator.
 */

public interface SysItemDAO {

    /**
     *  �����������SysItem����.
     *  @param sysItemPrimaryKey SysItem����
     *  @return SysItem.
     */
    SysItem getSysItem(java.lang.String sysItemPrimaryKey);

    /**
     *  ��ȡSysItem�����б�.
     *  @param  sysItem SysItem����
     *  @return List.
     */
    List getSysItemList(SysItem sysItem);

    /**
     *  �洢SysItem����.
     *  @param  sysItem SysItem����
     *  @return SysItem.
     */
    SysItem saveSysItem(SysItem sysItem);

    /**
     *  ɾ��SysItem����.
     *  @param sysItemPrimaryKey SysItem����.
     */
    void removeSysItem(java.lang.String sysItemPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysItem�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysItemListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysItem�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysItemListOfNoAuthorityQuery(Map queryMap);
}
