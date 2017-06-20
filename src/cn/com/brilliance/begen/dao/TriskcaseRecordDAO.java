package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.TriskcaseRecord;

/**
 * TriskcaseRecordDAO�ӿ�.
 * @author Administrator.
 */

public interface TriskcaseRecordDAO {

    /**
     *  �����������TriskcaseRecord����.
     *  @param triskcaseRecordPrimaryKey TriskcaseRecord����
     *  @return TriskcaseRecord.
     */
    TriskcaseRecord getTriskcaseRecord(java.lang.String triskcaseRecordPrimaryKey);

    /**
     *  ��ȡTriskcaseRecord�����б�.
     *  @param  triskcaseRecord TriskcaseRecord����
     *  @return List.
     */
    List getTriskcaseRecordList(TriskcaseRecord triskcaseRecord);

    /**
     *  �洢TriskcaseRecord����.
     *  @param  triskcaseRecord TriskcaseRecord����
     *  @return TriskcaseRecord.
     */
    TriskcaseRecord saveTriskcaseRecord(TriskcaseRecord triskcaseRecord);

    /**
     *  ɾ��TriskcaseRecord����.
     *  @param triskcaseRecordPrimaryKey TriskcaseRecord����.
     */
    void removeTriskcaseRecord(java.lang.String triskcaseRecordPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡTriskcaseRecord�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTriskcaseRecordListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡTriskcaseRecord�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTriskcaseRecordListOfNoAuthorityQuery(Map queryMap);
}
