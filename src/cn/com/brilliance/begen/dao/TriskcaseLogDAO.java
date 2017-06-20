package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.TriskcaseLog;

/**
 * TriskcaseLogDAO�ӿ�.
 * @author Administrator.
 */

public interface TriskcaseLogDAO {

    /**
     *  �����������TriskcaseLog����.
     *  @param triskcaseLogPrimaryKey TriskcaseLog����
     *  @return TriskcaseLog.
     */
    TriskcaseLog getTriskcaseLog(java.lang.String triskcaseLogPrimaryKey);

    /**
     *  ��ȡTriskcaseLog�����б�.
     *  @param  triskcaseLog TriskcaseLog����
     *  @return List.
     */
    List getTriskcaseLogList(TriskcaseLog triskcaseLog);

    /**
     *  �洢TriskcaseLog����.
     *  @param  triskcaseLog TriskcaseLog����
     *  @return TriskcaseLog.
     */
    TriskcaseLog saveTriskcaseLog(TriskcaseLog triskcaseLog);

    /**
     *  ɾ��TriskcaseLog����.
     *  @param triskcaseLogPrimaryKey TriskcaseLog����.
     */
    void removeTriskcaseLog(java.lang.String triskcaseLogPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡTriskcaseLog�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTriskcaseLogListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡTriskcaseLog�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTriskcaseLogListOfNoAuthorityQuery(Map queryMap);
}
