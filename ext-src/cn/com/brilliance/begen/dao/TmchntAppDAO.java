package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.TmchntApp;

/**
 * TmchntAppDAO�ӿ�.
 * @author Administrator.
 */

public interface TmchntAppDAO {

    /**
     *  �����������TmchntApp����.
     *  @param tmchntAppPrimaryKey TmchntApp����
     *  @return TmchntApp.
     */
    TmchntApp getTmchntApp(java.lang.String tmchntAppPrimaryKey);

    /**
     *  ��ȡTmchntApp�����б�.
     *  @param  tmchntApp TmchntApp����
     *  @return List.
     */
    List getTmchntAppList(TmchntApp tmchntApp);

    /**
     *  �洢TmchntApp����.
     *  @param  tmchntApp TmchntApp����
     *  @return TmchntApp.
     */
    TmchntApp saveTmchntApp(TmchntApp tmchntApp);

    /**
     *  ɾ��TmchntApp����.
     *  @param tmchntAppPrimaryKey TmchntApp����.
     */
    void removeTmchntApp(java.lang.String tmchntAppPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡTmchntApp�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTmchntAppListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡTmchntApp�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTmchntAppListOfNoAuthorityQuery(Map queryMap);
    
    
    String getTmchntAppMain(String id);
    
}
