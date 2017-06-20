package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.TriskprocessTimelimit;

/**
 * TriskprocessTimelimitDAO�ӿ�.
 * @author Administrator.
 */

public interface TriskprocessTimelimitDAO {

    /**
     *  �����������TriskprocessTimelimit����.
     *  @param triskprocessTimelimitPrimaryKey TriskprocessTimelimit����
     *  @return TriskprocessTimelimit.
     */
    TriskprocessTimelimit getTriskprocessTimelimit(java.lang.String triskprocessTimelimitPrimaryKey);

    /**
     *  ��ȡTriskprocessTimelimit�����б�.
     *  @param  triskprocessTimelimit TriskprocessTimelimit����
     *  @return List.
     */
    List getTriskprocessTimelimitList(TriskprocessTimelimit triskprocessTimelimit);

    /**
     *  �洢TriskprocessTimelimit����.
     *  @param  triskprocessTimelimit TriskprocessTimelimit����
     *  @return TriskprocessTimelimit.
     */
    TriskprocessTimelimit saveTriskprocessTimelimit(TriskprocessTimelimit triskprocessTimelimit);

    /**
     *  ɾ��TriskprocessTimelimit����.
     *  @param triskprocessTimelimitPrimaryKey TriskprocessTimelimit����.
     */
    void removeTriskprocessTimelimit(java.lang.String triskprocessTimelimitPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡTriskprocessTimelimit�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTriskprocessTimelimitListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡTriskprocessTimelimit�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTriskprocessTimelimitListOfNoAuthorityQuery(Map queryMap);
}
