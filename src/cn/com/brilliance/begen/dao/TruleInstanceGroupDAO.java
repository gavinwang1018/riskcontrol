package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.TruleInstanceGroup;

/**
 * TruleInstanceGroupDAO�ӿ�.
 * @author Administrator.
 */

public interface TruleInstanceGroupDAO {

    /**
     *  �����������TruleInstanceGroup����.
     *  @param truleInstanceGroupPrimaryKey TruleInstanceGroup����
     *  @return TruleInstanceGroup.
     */
    TruleInstanceGroup getTruleInstanceGroup(java.lang.String truleInstanceGroupPrimaryKey);

    /**
     *  ��ȡTruleInstanceGroup�����б�.
     *  @param  truleInstanceGroup TruleInstanceGroup����
     *  @return List.
     */
    List getTruleInstanceGroupList(TruleInstanceGroup truleInstanceGroup);

    /**
     *  �洢TruleInstanceGroup����.
     *  @param  truleInstanceGroup TruleInstanceGroup����
     *  @return TruleInstanceGroup.
     */
    TruleInstanceGroup saveTruleInstanceGroup(TruleInstanceGroup truleInstanceGroup);

    /**
     *  ɾ��TruleInstanceGroup����.
     *  @param truleInstanceGroupPrimaryKey TruleInstanceGroup����.
     */
    void removeTruleInstanceGroup(java.lang.String truleInstanceGroupPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡTruleInstanceGroup�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTruleInstanceGroupListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡTruleInstanceGroup�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTruleInstanceGroupListOfNoAuthorityQuery(Map queryMap);
}
