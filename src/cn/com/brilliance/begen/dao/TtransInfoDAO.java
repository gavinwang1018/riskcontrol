package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.TtransInfo;

/**
 * TtransInfoDAO�ӿ�.
 * @author Administrator.
 */

public interface TtransInfoDAO {

    /**
     *  �����������TtransInfo����.
     *  @param ttransInfoPrimaryKey TtransInfo����
     *  @return TtransInfo.
     */
    TtransInfo getTtransInfo(java.lang.String ttransInfoPrimaryKey);

    /**
     *  ��ȡTtransInfo�����б�.
     *  @param  ttransInfo TtransInfo����
     *  @return List.
     */
    List getTtransInfoList(TtransInfo ttransInfo);

    /**
     *  �洢TtransInfo����.
     *  @param  ttransInfo TtransInfo����
     *  @return TtransInfo.
     */
    TtransInfo saveTtransInfo(TtransInfo ttransInfo);

    /**
     *  ɾ��TtransInfo����.
     *  @param ttransInfoPrimaryKey TtransInfo����.
     */
    void removeTtransInfo(java.lang.String ttransInfoPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡTtransInfo�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTtransInfoListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡTtransInfo�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTtransInfoListOfNoAuthorityQuery(Map queryMap);

	int getTmchntListOfQueryCount(Map queryFields);
}
