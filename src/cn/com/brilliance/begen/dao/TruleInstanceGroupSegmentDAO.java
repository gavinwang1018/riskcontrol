package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.TruleInstanceGroupSegment;

/**
 * TruleInstanceGroupSegmentDAO�ӿ�.
 * @author Administrator.
 */

public interface TruleInstanceGroupSegmentDAO {

    /**
     *  �����������TruleInstanceGroupSegment����.
     *  @param truleInstanceGroupSegmentPrimaryKey TruleInstanceGroupSegment����
     *  @return TruleInstanceGroupSegment.
     */
    TruleInstanceGroupSegment getTruleInstanceGroupSegment(java.lang.String truleInstanceGroupSegmentPrimaryKey);

    /**
     *  ��ȡTruleInstanceGroupSegment�����б�.
     *  @param  truleInstanceGroupSegment TruleInstanceGroupSegment����
     *  @return List.
     */
    List getTruleInstanceGroupSegmentList(TruleInstanceGroupSegment truleInstanceGroupSegment);

    /**
     *  �洢TruleInstanceGroupSegment����.
     *  @param  truleInstanceGroupSegment TruleInstanceGroupSegment����
     *  @return TruleInstanceGroupSegment.
     */
    TruleInstanceGroupSegment saveTruleInstanceGroupSegment(TruleInstanceGroupSegment truleInstanceGroupSegment);

    /**
     *  ɾ��TruleInstanceGroupSegment����.
     *  @param truleInstanceGroupSegmentPrimaryKey TruleInstanceGroupSegment����.
     */
    void removeTruleInstanceGroupSegment(java.lang.String truleInstanceGroupSegmentPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡTruleInstanceGroupSegment�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTruleInstanceGroupSegmentListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡTruleInstanceGroupSegment�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTruleInstanceGroupSegmentListOfNoAuthorityQuery(Map queryMap);
}
