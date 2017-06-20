package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.Tmcc;

/**
 * TmccDAO�ӿ�.
 * @author Administrator.
 */

public interface TmccDAO {

    /**
     *  �����������Tmcc����.
     *  @param tmccPrimaryKey Tmcc����
     *  @return Tmcc.
     */
    Tmcc getTmcc(java.lang.String tmccPrimaryKey);

    /**
     *  ��ȡTmcc�����б�.
     *  @param  tmcc Tmcc����
     *  @return List.
     */
    List getTmccList(Tmcc tmcc);

    /**
     *  �洢Tmcc����.
     *  @param  tmcc Tmcc����
     *  @return Tmcc.
     */
    Tmcc saveTmcc(Tmcc tmcc);

    /**
     *  ɾ��Tmcc����.
     *  @param tmccPrimaryKey Tmcc����.
     */
    void removeTmcc(java.lang.String tmccPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡTmcc�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTmccListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡTmcc�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTmccListOfNoAuthorityQuery(Map queryMap);
    
    
    List getTmccNames(Map queryMap);
    
    List getTmccByBigMcc(String bigmcc);
}
