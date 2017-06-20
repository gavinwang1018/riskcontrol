package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.EpcInsTask;

/**
 * EpcInsTaskDAO�ӿ�.
 * @author Administrator.
 */

public interface EpcInsTaskDAO {

    /**
     *  �����������EpcInsTask����.
     *  @param epcInsTaskPrimaryKey EpcInsTask����
     *  @return EpcInsTask.
     */
    EpcInsTask getEpcInsTask(java.lang.String epcInsTaskPrimaryKey);

    /**
     *  ��ȡEpcInsTask�����б�.
     *  @param  epcInsTask EpcInsTask����
     *  @return List.
     */
    List getEpcInsTaskList(EpcInsTask epcInsTask);

    /**
     *  �洢EpcInsTask����.
     *  @param  epcInsTask EpcInsTask����
     *  @return EpcInsTask.
     */
    EpcInsTask saveEpcInsTask(EpcInsTask epcInsTask);

    /**
     *  ɾ��EpcInsTask����.
     *  @param epcInsTaskPrimaryKey EpcInsTask����.
     */
    void removeEpcInsTask(java.lang.String epcInsTaskPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡEpcInsTask�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getEpcInsTaskListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡEpcInsTask�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getEpcInsTaskListOfNoAuthorityQuery(Map queryMap);
}
