package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.Tmchnt;

/**
 * TmchntDAO�ӿ�.
 * @author Administrator.
 */

public interface TmchntDAO {

    /**
     *  �����������Tmchnt����.
     *  @param tmchntPrimaryKey Tmchnt����
     *  @return Tmchnt.
     */
    Tmchnt getTmchnt(java.lang.String tmchntPrimaryKey);

    /**
     *  ��ȡTmchnt�����б�.
     *  @param  tmchnt Tmchnt����
     *  @return List.
     */
    List getTmchntList(Tmchnt tmchnt);

    /**
     *  �洢Tmchnt����.
     *  @param  tmchnt Tmchnt����
     *  @return Tmchnt.
     */
    Tmchnt saveTmchnt(Tmchnt tmchnt);

    /**
     *  ɾ��Tmchnt����.
     *  @param tmchntPrimaryKey Tmchnt����.
     */
    void removeTmchnt(java.lang.String tmchntPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡTmchnt�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTmchntListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡTmchnt�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTmchntListOfNoAuthorityQuery(Map queryMap);
    
   /**
    * �����̻�Id��ѯ�̻���Ӧ�ý����ʺ�
    * @param id
    * @return
    */
    String getTmchntAccountNo(String id);
    
    /**
     * �����̻�����,�̻������������̻�������������ȡ�̻�
     * @param merNo
     * @param subinst
     * @param netWorkTransfer
     * @return
     */
    Tmchnt getTmchntByName(String merNo,String subinst,String netWorkTransfer);
    
    
    List getMerListOfQuery(int firstpage, int pagesize,Map queryFields);
    
    int getMerListOfQueryNumber(Map queryFields);
    
    int getTmchntListOfQueryCount(Map queryFields);
    
}
