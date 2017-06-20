package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.EpcInsProc;

/**
 * EpcInsProcDAO�ӿ�.
 * @author Administrator.
 */

public interface EpcInsProcDAO {

    /**
     *  �����������EpcInsProc����.
     *  @param epcInsProcPrimaryKey EpcInsProc����
     *  @return EpcInsProc.
     */
    EpcInsProc getEpcInsProc(java.lang.String epcInsProcPrimaryKey);

    /**
     *  ��ȡEpcInsProc�����б�.
     *  @param  epcInsProc EpcInsProc����
     *  @return List.
     */
    List getEpcInsProcList(EpcInsProc epcInsProc);

    /**
     *  �洢EpcInsProc����.
     *  @param  epcInsProc EpcInsProc����
     *  @return EpcInsProc.
     */
    EpcInsProc saveEpcInsProc(EpcInsProc epcInsProc);

    /**
     *  ɾ��EpcInsProc����.
     *  @param epcInsProcPrimaryKey EpcInsProc����.
     */
    void removeEpcInsProc(java.lang.String epcInsProcPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡEpcInsProc�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getEpcInsProcListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡEpcInsProc�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getEpcInsProcListOfNoAuthorityQuery(Map queryMap);
}
