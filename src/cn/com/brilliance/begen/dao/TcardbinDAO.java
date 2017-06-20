package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.Tcardbin;

/**
 * TcardbinDAO�ӿ�.
 * @author Administrator.
 */

public interface TcardbinDAO {

    /**
     *  �����������Tcardbin����.
     *  @param tcardbinPrimaryKey Tcardbin����
     *  @return Tcardbin.
     */
    Tcardbin getTcardbin(java.lang.String tcardbinPrimaryKey);

    /**
     *  ��ȡTcardbin�����б�.
     *  @param  tcardbin Tcardbin����
     *  @return List.
     */
    List getTcardbinList(Tcardbin tcardbin);

    /**
     *  �洢Tcardbin����.
     *  @param  tcardbin Tcardbin����
     *  @return Tcardbin.
     */
    Tcardbin saveTcardbin(Tcardbin tcardbin);

    /**
     *  ɾ��Tcardbin����.
     *  @param tcardbinPrimaryKey Tcardbin����.
     */
    void removeTcardbin(java.lang.String tcardbinPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡTcardbin�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTcardbinListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡTcardbin�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTcardbinListOfNoAuthorityQuery(Map queryMap);
}
