package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.ExtTruleInstanceMcc;

/**
 * TruleInstanceMccDAO�ӿ�.
 * @author Administrator.
 */

public interface ExtTruleInstanceMccDAO {

    /**
     *  �����������TruleInstanceMcc����.
     *  @param truleInstanceMccPrimaryKey TruleInstanceMcc����
     *  @return TruleInstanceMcc.
     */
	ExtTruleInstanceMcc getExtTruleInstanceMcc(java.lang.String extTruleInstanceMccPrimaryKey);

    /**
     *  ��ȡTruleInstanceMcc�����б�.
     *  @param  truleInstanceMcc TruleInstanceMcc����
     *  @return List.
     */
    List getExtTruleInstanceMccList(ExtTruleInstanceMcc extTruleInstanceMcc);

    /**
     *  �洢TruleInstanceMcc����.
     *  @param  truleInstanceMcc TruleInstanceMcc����
     *  @return TruleInstanceMcc.
     */
    ExtTruleInstanceMcc saveExtTruleInstanceMcc(ExtTruleInstanceMcc extTruleInstanceMcc);

    /**
     *  ɾ��TruleInstanceMcc����.
     *  @param truleInstanceMccPrimaryKey TruleInstanceMcc����.
     */
    void removeExtTruleInstanceMcc(java.lang.String extTruleInstanceMccPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡTruleInstanceMcc�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getExtTruleInstanceMccListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡTruleInstanceMcc�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getExtTruleInstanceMccListOfNoAuthorityQuery(Map queryMap);
}
