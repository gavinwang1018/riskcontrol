package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysDailyEvent;

/**
 * SysDailyEventDAO�ӿ�.
 * @author Administrator.
 */

public interface SysDailyEventDAO {

    /**
     *  �����������SysDailyEvent����.
     *  @param sysDailyEventPrimaryKey SysDailyEvent����
     *  @return SysDailyEvent.
     */
    SysDailyEvent getSysDailyEvent(java.lang.String sysDailyEventPrimaryKey);

    /**
     *  ��ȡSysDailyEvent�����б�.
     *  @param  sysDailyEvent SysDailyEvent����
     *  @return List.
     */
    List getSysDailyEventList(SysDailyEvent sysDailyEvent);

    /**
     *  �洢SysDailyEvent����.
     *  @param  sysDailyEvent SysDailyEvent����
     *  @return SysDailyEvent.
     */
    SysDailyEvent saveSysDailyEvent(SysDailyEvent sysDailyEvent);

    /**
     *  ɾ��SysDailyEvent����.
     *  @param sysDailyEventPrimaryKey SysDailyEvent����.
     */
    void removeSysDailyEvent(java.lang.String sysDailyEventPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysDailyEvent�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysDailyEventListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysDailyEvent�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysDailyEventListOfNoAuthorityQuery(Map queryMap);
}
