package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.TruleInstanceMcc;

/**
 * TruleInstanceMccDAO�ӿ�.
 * @author Administrator.
 */

public interface TruleInstanceMccDAO {

    /**
     *  �����������TruleInstanceMcc����.
     *  @param truleInstanceMccPrimaryKey TruleInstanceMcc����
     *  @return TruleInstanceMcc.
     */
    TruleInstanceMcc getTruleInstanceMcc(java.lang.String truleInstanceMccPrimaryKey);

    /**
     *  ��ȡTruleInstanceMcc�����б�.
     *  @param  truleInstanceMcc TruleInstanceMcc����
     *  @return List.
     */
    List getTruleInstanceMccList(TruleInstanceMcc truleInstanceMcc);

    /**
     *  �洢TruleInstanceMcc����.
     *  @param  truleInstanceMcc TruleInstanceMcc����
     *  @return TruleInstanceMcc.
     */
    TruleInstanceMcc saveTruleInstanceMcc(TruleInstanceMcc truleInstanceMcc);

    /**
     *  ɾ��TruleInstanceMcc����.
     *  @param truleInstanceMccPrimaryKey TruleInstanceMcc����.
     */
    void removeTruleInstanceMcc(java.lang.String truleInstanceMccPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡTruleInstanceMcc�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTruleInstanceMccListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡTruleInstanceMcc�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTruleInstanceMccListOfNoAuthorityQuery(Map queryMap);
    /**
     * ����ع�
     *
     */
    void rollback();
}
