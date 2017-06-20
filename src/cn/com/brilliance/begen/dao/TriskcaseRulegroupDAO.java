package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.TriskcaseRulegroup;

/**
 * TriskcaseRulegroupDAO�ӿ�.
 * @author Administrator.
 */

public interface TriskcaseRulegroupDAO {

    /**
     *  �����������TriskcaseRulegroup����.
     *  @param triskcaseRulegroupPrimaryKey TriskcaseRulegroup����
     *  @return TriskcaseRulegroup.
     */
    TriskcaseRulegroup getTriskcaseRulegroup(java.lang.String triskcaseRulegroupPrimaryKey);

    /**
     *  ��ȡTriskcaseRulegroup�����б�.
     *  @param  triskcaseRulegroup TriskcaseRulegroup����
     *  @return List.
     */
    List getTriskcaseRulegroupList(TriskcaseRulegroup triskcaseRulegroup);

    /**
     *  �洢TriskcaseRulegroup����.
     *  @param  triskcaseRulegroup TriskcaseRulegroup����
     *  @return TriskcaseRulegroup.
     */
    TriskcaseRulegroup saveTriskcaseRulegroup(TriskcaseRulegroup triskcaseRulegroup);

    /**
     *  ɾ��TriskcaseRulegroup����.
     *  @param triskcaseRulegroupPrimaryKey TriskcaseRulegroup����.
     */
    void removeTriskcaseRulegroup(java.lang.String triskcaseRulegroupPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡTriskcaseRulegroup�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTriskcaseRulegroupListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡTriskcaseRulegroup�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTriskcaseRulegroupListOfNoAuthorityQuery(Map queryMap);
}
