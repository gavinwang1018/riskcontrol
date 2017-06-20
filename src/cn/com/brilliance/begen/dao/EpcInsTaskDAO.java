package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.EpcInsTask;

/**
 * EpcInsTaskDAO接口.
 * @author Administrator.
 */

public interface EpcInsTaskDAO {

    /**
     *  根据主键获得EpcInsTask对象.
     *  @param epcInsTaskPrimaryKey EpcInsTask主键
     *  @return EpcInsTask.
     */
    EpcInsTask getEpcInsTask(java.lang.String epcInsTaskPrimaryKey);

    /**
     *  获取EpcInsTask对象列表.
     *  @param  epcInsTask EpcInsTask对象
     *  @return List.
     */
    List getEpcInsTaskList(EpcInsTask epcInsTask);

    /**
     *  存储EpcInsTask对象.
     *  @param  epcInsTask EpcInsTask对象
     *  @return EpcInsTask.
     */
    EpcInsTask saveEpcInsTask(EpcInsTask epcInsTask);

    /**
     *  删除EpcInsTask对象.
     *  @param epcInsTaskPrimaryKey EpcInsTask主键.
     */
    void removeEpcInsTask(java.lang.String epcInsTaskPrimaryKey);

    /**
     *  根据查询条件获取EpcInsTask对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getEpcInsTaskListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取EpcInsTask对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getEpcInsTaskListOfNoAuthorityQuery(Map queryMap);
}
