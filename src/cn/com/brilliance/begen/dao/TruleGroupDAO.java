package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.TruleGroup;

/**
 * TruleGroupDAO�ӿ�.
 * @author Administrator.
 */

public interface TruleGroupDAO {

    /**
     *  �����������TruleGroup����.
     *  @param truleGroupPrimaryKey TruleGroup����
     *  @return TruleGroup.
     */
    TruleGroup getTruleGroup(java.lang.String truleGroupPrimaryKey);

    /**
     *  ��ȡTruleGroup�����б�.
     *  @param  truleGroup TruleGroup����
     *  @return List.
     */
    List getTruleGroupList(TruleGroup truleGroup);

    /**
     *  �洢TruleGroup����.
     *  @param  truleGroup TruleGroup����
     *  @return TruleGroup.
     */
    TruleGroup saveTruleGroup(TruleGroup truleGroup);

    /**
     *  ɾ��TruleGroup����.
     *  @param truleGroupPrimaryKey TruleGroup����.
     */
    void removeTruleGroup(java.lang.String truleGroupPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡTruleGroup�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTruleGroupListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡTruleGroup�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTruleGroupListOfNoAuthorityQuery(Map queryMap);
}
