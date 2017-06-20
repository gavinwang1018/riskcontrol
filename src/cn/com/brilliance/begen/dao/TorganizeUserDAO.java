package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.TorganizeUser;

/**
 * TorganizeUserDAO�ӿ�.
 * @author Administrator.
 */

public interface TorganizeUserDAO {

    /**
     *  �����������TorganizeUser����.
     *  @param torganizeUserPrimaryKey TorganizeUser����
     *  @return TorganizeUser.
     */
    TorganizeUser getTorganizeUser(java.lang.String torganizeUserPrimaryKey);

    /**
     *  ��ȡTorganizeUser�����б�.
     *  @param  torganizeUser TorganizeUser����
     *  @return List.
     */
    List getTorganizeUserList(TorganizeUser torganizeUser);

    /**
     *  �洢TorganizeUser����.
     *  @param  torganizeUser TorganizeUser����
     *  @return TorganizeUser.
     */
    TorganizeUser saveTorganizeUser(TorganizeUser torganizeUser);

    /**
     *  ɾ��TorganizeUser����.
     *  @param torganizeUserPrimaryKey TorganizeUser����.
     */
    void removeTorganizeUser(java.lang.String torganizeUserPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡTorganizeUser�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTorganizeUserListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡTorganizeUser�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTorganizeUserListOfNoAuthorityQuery(Map queryMap);
}
