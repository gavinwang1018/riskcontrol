package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.TruleInstance;

/**
 * TruleInstanceDAO�ӿ�.
 * @author Administrator.
 */

public interface TruleInstanceDAO {

    /**
     *  �����������TruleInstance����.
     *  @param truleInstancePrimaryKey TruleInstance����
     *  @return TruleInstance.
     */
    TruleInstance getTruleInstance(java.lang.String truleInstancePrimaryKey);

    /**
     *  ��ȡTruleInstance�����б�.
     *  @param  truleInstance TruleInstance����
     *  @return List.
     */
    List getTruleInstanceList(TruleInstance truleInstance);

    /**
     *  �洢TruleInstance����.
     *  @param  truleInstance TruleInstance����
     *  @return TruleInstance.
     */
    TruleInstance saveTruleInstance(TruleInstance truleInstance);

    /**
     *  ɾ��TruleInstance����.
     *  @param truleInstancePrimaryKey TruleInstance����.
     */
    void removeTruleInstance(java.lang.String truleInstancePrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡTruleInstance�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTruleInstanceListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡTruleInstance�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTruleInstanceListOfNoAuthorityQuery(Map queryMap);

	void rollback();
}
