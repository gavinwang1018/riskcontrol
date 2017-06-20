package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.TorganizeInfo;

/**
 * TorganizeInfoDAO�ӿ�.
 * @author Administrator.
 */

public interface TorganizeInfoDAO {

    /**
     *  �����������TorganizeInfo����.
     *  @param torganizeInfoPrimaryKey TorganizeInfo����
     *  @return TorganizeInfo.
     */
    TorganizeInfo getTorganizeInfo(java.lang.String torganizeInfoPrimaryKey);

    /**
     *  ��ȡTorganizeInfo�����б�.
     *  @param  torganizeInfo TorganizeInfo����
     *  @return List.
     */
    List getTorganizeInfoList(TorganizeInfo torganizeInfo);

    /**
     *  �洢TorganizeInfo����.
     *  @param  torganizeInfo TorganizeInfo����
     *  @return TorganizeInfo.
     */
    TorganizeInfo saveTorganizeInfo(TorganizeInfo torganizeInfo);

    /**
     *  ɾ��TorganizeInfo����.
     *  @param torganizeInfoPrimaryKey TorganizeInfo����.
     */
    void removeTorganizeInfo(java.lang.String torganizeInfoPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡTorganizeInfo�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTorganizeInfoListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡTorganizeInfo�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTorganizeInfoListOfNoAuthorityQuery(Map queryMap);
}
