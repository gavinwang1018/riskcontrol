package cn.com.brilliance.begen.dao.hibernate;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.dao.DataRetrievalFailureException;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Expression;

import cn.com.brilliance.begen.dao.TroleInfoDAO;
import cn.com.brilliance.begen.model.TroleInfo;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * TroleInfoDAO接口具体实现类.
 * @author Administrator.
 */

public class TroleInfoDAOHibernate extends BeGenHibernateDaoSupport implements TroleInfoDAO {    

    /**
     *  根据主键获得TroleInfo对象.
     *  @param pkey TroleInfo主键
     *  @return TroleInfo.
     */
    public TroleInfo getTroleInfo(java.lang.String pkey) {
        TroleInfo troleInfo = (TroleInfo) getHibernateTemplate().get(TroleInfo.class, pkey);
        if (troleInfo == null) {
            return troleInfo;
        }
        return troleInfo;

    }

    /**
     *  存储TroleInfo对象.
     *  @param  troleInfo TroleInfo对象
     *  @return TroleInfo.
     */
    public TroleInfo saveTroleInfo(TroleInfo troleInfo) {
        return (TroleInfo) getHibernateTemplate().merge(troleInfo);
    }

    /**
     *  删除TroleInfo对象.
     *  @param pkey TroleInfo主键.
     */
    public void removeTroleInfo(java.lang.String pkey) {
        TroleInfo troleInfo = getTroleInfo(pkey);
        getHibernateTemplate().delete(troleInfo);
    }

    /**
     *  获取TroleInfo对象列表.
     *  @param  troleInfo TroleInfo对象
     *  @return List.
     */
    public List getTroleInfoList(TroleInfo troleInfo) {
        Criteria criteria = getSession().createCriteria(TroleInfo.class).add(
                Example.create(troleInfo));
        if (troleInfo.getId() != null) {
            criteria.add(Expression.eq("id", troleInfo.getId()));
        }
        return criteria.list();
    }

    /**
     *  根据查询条件获取TroleInfo对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getTroleInfoListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TroleInfo where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(TroleInfo.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取TroleInfo对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getTroleInfoListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TroleInfo where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(TroleInfo.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤TroleInfo对象
        Object[] keyArray = queryMap.keySet().toArray();  //转换查询字段名keySet为数组
        //遍历该数组，去除对应查询字段值为空的键值
        for (int i = 0; i < keyArray.length; i++) {
            String value = (String) queryMap.get(keyArray[i]);
            if (value == null || value.trim().length() == 0) {
                queryMap.remove(keyArray[i]);
            }
        }

        if (queryMap.get("id") != null) {
            criteria = criteria.add(Expression.eq("id", queryMap.get("id")));
        }
        if (queryMap.get("id_like") != null) {
            criteria = criteria.add(Expression.like("id", "%" + queryMap.get("id_like") + "%"));
        }

        if (queryMap.get("name") != null) {
            criteria = criteria.add(Expression.eq("name", queryMap.get("name")));
        }
        if (queryMap.get("name_like") != null) {
            criteria = criteria.add(Expression.like("name", "%" + queryMap.get("name_like") + "%"));
        }

        if (queryMap.get("code") != null) {
            criteria = criteria.add(Expression.eq("code", queryMap.get("code")));
        }
        if (queryMap.get("code_like") != null) {
            criteria = criteria.add(Expression.like("code", "%" + queryMap.get("code_like") + "%"));
        }


        //根据查询queryMap的键值，提供排序功能,_order="域名1 asc|desc,域名2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
