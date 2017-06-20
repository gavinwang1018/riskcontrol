package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysDataObject;

/**
 * SysDataObjectDAO�ӿ�.
 * @author Administrator.
 */

public interface SysDataObjectDAO {

    /**
     *  �����������SysDataObject����.
     *  @param sysDataObjectPrimaryKey SysDataObject����
     *  @return SysDataObject.
     */
    SysDataObject getSysDataObject(java.lang.String sysDataObjectPrimaryKey);

    /**
     *  ��ȡSysDataObject�����б�.
     *  @param  sysDataObject SysDataObject����
     *  @return List.
     */
    List getSysDataObjectList(SysDataObject sysDataObject);

    /**
     *  �洢SysDataObject����.
     *  @param  sysDataObject SysDataObject����
     *  @return SysDataObject.
     */
    SysDataObject saveSysDataObject(SysDataObject sysDataObject);

    /**
     *  ɾ��SysDataObject����.
     *  @param sysDataObjectPrimaryKey SysDataObject����.
     */
    void removeSysDataObject(java.lang.String sysDataObjectPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysDataObject�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysDataObjectListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysDataObject�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysDataObjectListOfNoAuthorityQuery(Map queryMap);
}
