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

import cn.com.brilliance.begen.dao.TruleDAO;
import cn.com.brilliance.begen.model.Trule;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * TruleDAO接口具体实现类.
 * @author Administrator.
 */

public class TruleDAOHibernate extends BeGenHibernateDaoSupport implements TruleDAO {    

    /**
     *  根据主键获得Trule对象.
     *  @param pkey Trule主键
     *  @return Trule.
     */
    public Trule getTrule(java.lang.String pkey) {
        Trule trule = (Trule) getHibernateTemplate().get(Trule.class, pkey);
        if (trule == null) {
            return trule;
        }
        return trule;

    }

    /**
     *  存储Trule对象.
     *  @param  trule Trule对象
     *  @return Trule.
     */
    public Trule saveTrule(Trule trule) {
        return (Trule) getHibernateTemplate().merge(trule);
    }

    /**
     *  删除Trule对象.
     *  @param pkey Trule主键.
     */
    public void removeTrule(java.lang.String pkey) {
        Trule trule = getTrule(pkey);
        getHibernateTemplate().delete(trule);
    }

    /**
     *  获取Trule对象列表.
     *  @param  trule Trule对象
     *  @return List.
     */
    public List getTruleList(Trule trule) {
        Criteria criteria = getSession().createCriteria(Trule.class).add(
                Example.create(trule));
        if (trule.getId() != null) {
            criteria.add(Expression.eq("id", trule.getId()));
        }
        return criteria.list();
    }

    /**
     *  根据查询条件获取Trule对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getTruleListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.Trule where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(Trule.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取Trule对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getTruleListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.Trule where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(Trule.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤Trule对象
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

        if (queryMap.get("description") != null) {
            criteria = criteria.add(Expression.eq("description", queryMap.get("description")));
        }
        if (queryMap.get("description_like") != null) {
            criteria = criteria.add(Expression.like("description", "%" + queryMap.get("description_like") + "%"));
        }

        if (queryMap.get("supportTrace") != null) {
            criteria = criteria.add(Expression.eq("supportTrace", new Boolean((String) queryMap.get("supportTrace"))));
        }
        if (queryMap.get("transInfo") != null) {
            criteria = criteria.add(Expression.eq("transInfo", new Boolean((String) queryMap.get("transInfo"))));
        }
        if (queryMap.get("type") != null) {
            criteria = criteria.add(Expression.eq("type", queryMap.get("type")));
        }
        if (queryMap.get("type_like") != null) {
            criteria = criteria.add(Expression.like("type", "%" + queryMap.get("type_like") + "%"));
        }

        if (queryMap.get("cycle") != null) {
            criteria = criteria.add(Expression.eq("cycle", queryMap.get("cycle")));
        }
        if (queryMap.get("cycle_like") != null) {
            criteria = criteria.add(Expression.like("cycle", "%" + queryMap.get("cycle_like") + "%"));
        }


        //根据查询queryMap的键值，提供排序功能,_order="域名1 asc|desc,域名2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
