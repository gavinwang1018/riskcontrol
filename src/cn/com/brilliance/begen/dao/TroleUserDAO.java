package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.TroleUser;

/**
 * TroleUserDAO�ӿ�.
 * @author Administrator.
 */

public interface TroleUserDAO {

    /**
     *  �����������TroleUser����.
     *  @param troleUserPrimaryKey TroleUser����
     *  @return TroleUser.
     */
    TroleUser getTroleUser(java.lang.String troleUserPrimaryKey);

    /**
     *  ��ȡTroleUser�����б�.
     *  @param  troleUser TroleUser����
     *  @return List.
     */
    List getTroleUserList(TroleUser troleUser);

    /**
     *  �洢TroleUser����.
     *  @param  troleUser TroleUser����
     *  @return TroleUser.
     */
    TroleUser saveTroleUser(TroleUser troleUser);

    /**
     *  ɾ��TroleUser����.
     *  @param troleUserPrimaryKey TroleUser����.
     */
    void removeTroleUser(java.lang.String troleUserPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡTroleUser�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTroleUserListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡTroleUser�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTroleUserListOfNoAuthorityQuery(Map queryMap);
}
