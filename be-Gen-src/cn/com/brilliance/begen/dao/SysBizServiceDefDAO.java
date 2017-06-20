package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysBizServiceDef;

/**
 * SysBizServiceDefDAO�ӿ�.
 * @author Administrator.
 */

public interface SysBizServiceDefDAO {

    /**
     *  �����������SysBizServiceDef����.
     *  @param sysBizServiceDefPrimaryKey SysBizServiceDef����
     *  @return SysBizServiceDef.
     */
    SysBizServiceDef getSysBizServiceDef(java.lang.String sysBizServiceDefPrimaryKey);

    /**
     *  ��ȡSysBizServiceDef�����б�.
     *  @param  sysBizServiceDef SysBizServiceDef����
     *  @return List.
     */
    List getSysBizServiceDefList(SysBizServiceDef sysBizServiceDef);

    /**
     *  �洢SysBizServiceDef����.
     *  @param  sysBizServiceDef SysBizServiceDef����
     *  @return SysBizServiceDef.
     */
    SysBizServiceDef saveSysBizServiceDef(SysBizServiceDef sysBizServiceDef);

    /**
     *  ɾ��SysBizServiceDef����.
     *  @param sysBizServiceDefPrimaryKey SysBizServiceDef����.
     */
    void removeSysBizServiceDef(java.lang.String sysBizServiceDefPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysBizServiceDef�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysBizServiceDefListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysBizServiceDef�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysBizServiceDefListOfNoAuthorityQuery(Map queryMap);
}
