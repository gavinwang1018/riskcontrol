package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.Trule;

/**
 * TruleDAO�ӿ�.
 * @author Administrator.
 */

public interface TruleDAO {

    /**
     *  �����������Trule����.
     *  @param trulePrimaryKey Trule����
     *  @return Trule.
     */
    Trule getTrule(java.lang.String trulePrimaryKey);

    /**
     *  ��ȡTrule�����б�.
     *  @param  trule Trule����
     *  @return List.
     */
    List getTruleList(Trule trule);

    /**
     *  �洢Trule����.
     *  @param  trule Trule����
     *  @return Trule.
     */
    Trule saveTrule(Trule trule);

    /**
     *  ɾ��Trule����.
     *  @param trulePrimaryKey Trule����.
     */
    void removeTrule(java.lang.String trulePrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡTrule�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTruleListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡTrule�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTruleListOfNoAuthorityQuery(Map queryMap);
}
