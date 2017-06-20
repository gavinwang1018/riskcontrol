package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.Triskcase;

/**
 * TriskcaseDAO�ӿ�.
 * @author Administrator.
 */

public interface TriskcaseDAO {

    /**
     *  �����������Triskcase����.
     *  @param triskcasePrimaryKey Triskcase����
     *  @return Triskcase.
     */
    Triskcase getTriskcase(java.lang.String triskcasePrimaryKey);

    /**
     *  ��ȡTriskcase�����б�.
     *  @param  triskcase Triskcase����
     *  @return List.
     */
    List getTriskcaseList(Triskcase triskcase);

    /**
     *  �洢Triskcase����.
     *  @param  triskcase Triskcase����
     *  @return Triskcase.
     */
    Triskcase saveTriskcase(Triskcase triskcase);

    /**
     *  ɾ��Triskcase����.
     *  @param triskcasePrimaryKey Triskcase����.
     */
    void removeTriskcase(java.lang.String triskcasePrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡTriskcase�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTriskcaseListOfQuery(Map queryMap);
    
    List getTriskcaseListOfQueryNoSize(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡTriskcase�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTriskcaseListOfNoAuthorityQuery(Map queryMap);
    
    int getTriskcaseListOfCount(Map queryMap);
}
