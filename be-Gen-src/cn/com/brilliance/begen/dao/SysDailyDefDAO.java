package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysDailyDef;

/**
 * SysDailyDefDAO�ӿ�.
 * @author Administrator.
 */

public interface SysDailyDefDAO {

    /**
     *  �����������SysDailyDef����.
     *  @param sysDailyDefPrimaryKey SysDailyDef����
     *  @return SysDailyDef.
     */
    SysDailyDef getSysDailyDef(java.lang.String sysDailyDefPrimaryKey);

    /**
     *  ��ȡSysDailyDef�����б�.
     *  @param  sysDailyDef SysDailyDef����
     *  @return List.
     */
    List getSysDailyDefList(SysDailyDef sysDailyDef);

    /**
     *  �洢SysDailyDef����.
     *  @param  sysDailyDef SysDailyDef����
     *  @return SysDailyDef.
     */
    SysDailyDef saveSysDailyDef(SysDailyDef sysDailyDef);

    /**
     *  ɾ��SysDailyDef����.
     *  @param sysDailyDefPrimaryKey SysDailyDef����.
     */
    void removeSysDailyDef(java.lang.String sysDailyDefPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysDailyDef�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysDailyDefListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysDailyDef�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysDailyDefListOfNoAuthorityQuery(Map queryMap);
}
