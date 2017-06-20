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

import cn.com.brilliance.begen.dao.TcardbinDAO;
import cn.com.brilliance.begen.model.Tcardbin;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * TcardbinDAO接口具体实现类.
 * @author Administrator.
 */

public class TcardbinDAOHibernate extends BeGenHibernateDaoSupport implements TcardbinDAO {    

    /**
     *  根据主键获得Tcardbin对象.
     *  @param pkey Tcardbin主键
     *  @return Tcardbin.
     */
    public Tcardbin getTcardbin(java.lang.String pkey) {
        Tcardbin tcardbin = (Tcardbin) getHibernateTemplate().get(Tcardbin.class, pkey);
        if (tcardbin == null) {
            return tcardbin;
        }
        return tcardbin;

    }

    /**
     *  存储Tcardbin对象.
     *  @param  tcardbin Tcardbin对象
     *  @return Tcardbin.
     */
    public Tcardbin saveTcardbin(Tcardbin tcardbin) {
        return (Tcardbin) getHibernateTemplate().merge(tcardbin);
    }

    /**
     *  删除Tcardbin对象.
     *  @param pkey Tcardbin主键.
     */
    public void removeTcardbin(java.lang.String pkey) {
        Tcardbin tcardbin = getTcardbin(pkey);
        getHibernateTemplate().delete(tcardbin);
    }

    /**
     *  获取Tcardbin对象列表.
     *  @param  tcardbin Tcardbin对象
     *  @return List.
     */
    public List getTcardbinList(Tcardbin tcardbin) {
        Criteria criteria = getSession().createCriteria(Tcardbin.class).add(
                Example.create(tcardbin));
        if (tcardbin.getId() != null) {
            criteria.add(Expression.eq("id", tcardbin.getId()));
        }
        return criteria.list();
    }

    /**
     *  根据查询条件获取Tcardbin对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getTcardbinListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.Tcardbin where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(Tcardbin.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取Tcardbin对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getTcardbinListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.Tcardbin where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(Tcardbin.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤Tcardbin对象
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

        if (queryMap.get("length") != null) {
            criteria = criteria.add(Expression.eq("length", new Integer((String) queryMap.get("length"))));
        }
        if (queryMap.get("length_min") != null) {
            criteria = criteria.add(Expression.ge("length", new Integer((String) queryMap.get("length_min"))));
        }
        if (queryMap.get("length_max") != null) {
            criteria = criteria.add(Expression.le("length", new Integer((String) queryMap.get("length_max"))));
        }
        if (queryMap.get("bin") != null) {
            criteria = criteria.add(Expression.eq("bin", queryMap.get("bin")));
        }
        if (queryMap.get("bin_like") != null) {
            criteria = criteria.add(Expression.like("bin", "%" + queryMap.get("bin_like") + "%"));
        }

        if (queryMap.get("cupscard") != null) {
            criteria = criteria.add(Expression.eq("cupscard", new Boolean((String) queryMap.get("cupscard"))));
        }
        if (queryMap.get("bank") != null) {
            criteria = criteria.add(Expression.eq("bank", queryMap.get("bank")));
        }
        if (queryMap.get("bank_like") != null) {
            criteria = criteria.add(Expression.like("bank", "%" + queryMap.get("bank_like") + "%"));
        }


        //根据查询queryMap的键值，提供排序功能,_order="域名1 asc|desc,域名2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
