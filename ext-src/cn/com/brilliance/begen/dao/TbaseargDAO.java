package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.Tbasearg;

/**
 * TbaseargDAO�ӿ�.
 * @author Administrator.
 */

public interface TbaseargDAO {

    /**
     *  �����������Tbasearg����.
     *  @param tbaseargPrimaryKey Tbasearg����
     *  @return Tbasearg.
     */
    Tbasearg getTbasearg(java.lang.String tbaseargPrimaryKey);

    /**
     *  ��ȡTbasearg�����б�.
     *  @param  tbasearg Tbasearg����
     *  @return List.
     */
    List getTbaseargList(Tbasearg tbasearg);

    /**
     *  �洢Tbasearg����.
     *  @param  tbasearg Tbasearg����
     *  @return Tbasearg.
     */
    Tbasearg saveTbasearg(Tbasearg tbasearg);

    /**
     *  ɾ��Tbasearg����.
     *  @param tbaseargPrimaryKey Tbasearg����.
     */
    void removeTbasearg(java.lang.String tbaseargPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡTbasearg�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTbaseargListOfQuery(Map queryMap);

    /**
     * ��������ȡTbasearg�����б�
     * @param queryMap
     * @param simbol
     * @return
     */

    List getTbaseargByType(Map queryMap, String simbol);
    
    /**
     *  ���ݲ�ѯ������ȡTbasearg�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTbaseargListOfNoAuthorityQuery(Map queryMap);
}
