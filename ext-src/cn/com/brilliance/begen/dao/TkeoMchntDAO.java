package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.TkeoMchnt;

/**
 * TkeoMchntDAO�ӿ�.
 * @author Administrator.
 */

public interface TkeoMchntDAO {

    /**
     *  �����������TkeoMchnt����.
     *  @param tkeoMchntPrimaryKey TkeoMchnt����
     *  @return TkeoMchnt.
     */
    TkeoMchnt getTkeoMchnt(java.lang.String tkeoMchntPrimaryKey);

    /**
     *  ��ȡTkeoMchnt�����б�.
     *  @param  tkeoMchnt TkeoMchnt����
     *  @return List.
     */
    List getTkeoMchntList(TkeoMchnt tkeoMchnt);

    /**
     *  �洢TkeoMchnt����.
     *  @param  tkeoMchnt TkeoMchnt����
     *  @return TkeoMchnt.
     */
    TkeoMchnt saveTkeoMchnt(TkeoMchnt tkeoMchnt);

    /**
     *  ɾ��TkeoMchnt����.
     *  @param tkeoMchntPrimaryKey TkeoMchnt����.
     */
    void removeTkeoMchnt(java.lang.String tkeoMchntPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡTkeoMchnt�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTkeoMchntListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡTkeoMchnt�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTkeoMchntListOfNoAuthorityQuery(Map queryMap);
    
    TkeoMchnt getKeoMchntByMerId(String merId,String type);
    
    int getTkeoMchntListOfQueryCount(Map queryFields);
}
