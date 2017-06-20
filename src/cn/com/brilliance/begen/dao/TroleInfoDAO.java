package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.TroleInfo;

/**
 * TroleInfoDAO�ӿ�.
 * @author Administrator.
 */

public interface TroleInfoDAO {

    /**
     *  �����������TroleInfo����.
     *  @param troleInfoPrimaryKey TroleInfo����
     *  @return TroleInfo.
     */
    TroleInfo getTroleInfo(java.lang.String troleInfoPrimaryKey);

    /**
     *  ��ȡTroleInfo�����б�.
     *  @param  troleInfo TroleInfo����
     *  @return List.
     */
    List getTroleInfoList(TroleInfo troleInfo);

    /**
     *  �洢TroleInfo����.
     *  @param  troleInfo TroleInfo����
     *  @return TroleInfo.
     */
    TroleInfo saveTroleInfo(TroleInfo troleInfo);

    /**
     *  ɾ��TroleInfo����.
     *  @param troleInfoPrimaryKey TroleInfo����.
     */
    void removeTroleInfo(java.lang.String troleInfoPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡTroleInfo�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTroleInfoListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡTroleInfo�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTroleInfoListOfNoAuthorityQuery(Map queryMap);
}
