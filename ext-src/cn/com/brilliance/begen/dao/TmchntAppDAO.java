package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.TmchntApp;

/**
 * TmchntAppDAO接口.
 * @author Administrator.
 */

public interface TmchntAppDAO {

    /**
     *  根据主键获得TmchntApp对象.
     *  @param tmchntAppPrimaryKey TmchntApp主键
     *  @return TmchntApp.
     */
    TmchntApp getTmchntApp(java.lang.String tmchntAppPrimaryKey);

    /**
     *  获取TmchntApp对象列表.
     *  @param  tmchntApp TmchntApp对象
     *  @return List.
     */
    List getTmchntAppList(TmchntApp tmchntApp);

    /**
     *  存储TmchntApp对象.
     *  @param  tmchntApp TmchntApp对象
     *  @return TmchntApp.
     */
    TmchntApp saveTmchntApp(TmchntApp tmchntApp);

    /**
     *  删除TmchntApp对象.
     *  @param tmchntAppPrimaryKey TmchntApp主键.
     */
    void removeTmchntApp(java.lang.String tmchntAppPrimaryKey);

    /**
     *  根据查询条件获取TmchntApp对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTmchntAppListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取TmchntApp对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTmchntAppListOfNoAuthorityQuery(Map queryMap);
    
    
    String getTmchntAppMain(String id);
    
}
