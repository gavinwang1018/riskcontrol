package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.TuserInfo;

/**
 * TuserInfoDAO�ӿ�.
 * @author Administrator.
 */

public interface TuserInfoDAO {

    /**
     *  �����������TuserInfo����.
     *  @param tuserInfoPrimaryKey TuserInfo����
     *  @return TuserInfo.
     */
    TuserInfo getTuserInfo(java.lang.String tuserInfoPrimaryKey);

    /**
     *  ��ȡTuserInfo�����б�.
     *  @param  tuserInfo TuserInfo����
     *  @return List.
     */
    List getTuserInfoList(TuserInfo tuserInfo);

    /**
     *  �洢TuserInfo����.
     *  @param  tuserInfo TuserInfo����
     *  @return TuserInfo.
     */
    TuserInfo saveTuserInfo(TuserInfo tuserInfo);

    /**
     *  ɾ��TuserInfo����.
     *  @param tuserInfoPrimaryKey TuserInfo����.
     */
    void removeTuserInfo(java.lang.String tuserInfoPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡTuserInfo�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTuserInfoListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡTuserInfo�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTuserInfoListOfNoAuthorityQuery(Map queryMap);
}
