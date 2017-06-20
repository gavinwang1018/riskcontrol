package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.Tmchnt;

/**
 * TmchntDAO接口.
 * @author Administrator.
 */

public interface TmchntDAO {

    /**
     *  根据主键获得Tmchnt对象.
     *  @param tmchntPrimaryKey Tmchnt主键
     *  @return Tmchnt.
     */
    Tmchnt getTmchnt(java.lang.String tmchntPrimaryKey);

    /**
     *  获取Tmchnt对象列表.
     *  @param  tmchnt Tmchnt对象
     *  @return List.
     */
    List getTmchntList(Tmchnt tmchnt);

    /**
     *  存储Tmchnt对象.
     *  @param  tmchnt Tmchnt对象
     *  @return Tmchnt.
     */
    Tmchnt saveTmchnt(Tmchnt tmchnt);

    /**
     *  删除Tmchnt对象.
     *  @param tmchntPrimaryKey Tmchnt主键.
     */
    void removeTmchnt(java.lang.String tmchntPrimaryKey);

    /**
     *  根据查询条件获取Tmchnt对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTmchntListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取Tmchnt对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTmchntListOfNoAuthorityQuery(Map queryMap);
    
   /**
    * 根据商户Id查询商户主应用结算帐号
    * @param id
    * @return
    */
    String getTmchntAccountNo(String id);
    
    /**
     * 根据商户名称,商户所属机构和商户入网机构代码取商户
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
