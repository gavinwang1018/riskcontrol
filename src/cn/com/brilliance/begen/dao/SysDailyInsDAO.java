package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysDailyIns;

/**
 * SysDailyInsDAO�ӿ�.
 * @author Administrator.
 */

public interface SysDailyInsDAO {

    /**
     *  �����������SysDailyIns����.
     *  @param sysDailyInsPrimaryKey SysDailyIns����
     *  @return SysDailyIns.
     */
    SysDailyIns getSysDailyIns(java.lang.String sysDailyInsPrimaryKey);

    /**
     *  ��ȡSysDailyIns�����б�.
     *  @param  sysDailyIns SysDailyIns����
     *  @return List.
     */
    List getSysDailyInsList(SysDailyIns sysDailyIns);

    /**
     *  �洢SysDailyIns����.
     *  @param  sysDailyIns SysDailyIns����
     *  @return SysDailyIns.
     */
    SysDailyIns saveSysDailyIns(SysDailyIns sysDailyIns);

    /**
     *  ɾ��SysDailyIns����.
     *  @param sysDailyInsPrimaryKey SysDailyIns����.
     */
    void removeSysDailyIns(java.lang.String sysDailyInsPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysDailyIns�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysDailyInsListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysDailyIns�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysDailyInsListOfNoAuthorityQuery(Map queryMap);
}
