package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.EpcInsProc;

/**
 * EpcInsProcDAO接口.
 * @author Administrator.
 */

public interface EpcInsProcDAO {

    /**
     *  根据主键获得EpcInsProc对象.
     *  @param epcInsProcPrimaryKey EpcInsProc主键
     *  @return EpcInsProc.
     */
    EpcInsProc getEpcInsProc(java.lang.String epcInsProcPrimaryKey);

    /**
     *  获取EpcInsProc对象列表.
     *  @param  epcInsProc EpcInsProc对象
     *  @return List.
     */
    List getEpcInsProcList(EpcInsProc epcInsProc);

    /**
     *  存储EpcInsProc对象.
     *  @param  epcInsProc EpcInsProc对象
     *  @return EpcInsProc.
     */
    EpcInsProc saveEpcInsProc(EpcInsProc epcInsProc);

    /**
     *  删除EpcInsProc对象.
     *  @param epcInsProcPrimaryKey EpcInsProc主键.
     */
    void removeEpcInsProc(java.lang.String epcInsProcPrimaryKey);

    /**
     *  根据查询条件获取EpcInsProc对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getEpcInsProcListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取EpcInsProc对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getEpcInsProcListOfNoAuthorityQuery(Map queryMap);
}
