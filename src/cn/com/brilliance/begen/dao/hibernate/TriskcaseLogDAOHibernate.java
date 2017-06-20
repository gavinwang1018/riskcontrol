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

import cn.com.brilliance.begen.dao.TriskcaseLogDAO;
import cn.com.brilliance.begen.model.TriskcaseLog;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * TriskcaseLogDAO接口具体实现类.
 * @author Administrator.
 */

public class TriskcaseLogDAOHibernate extends BeGenHibernateDaoSupport implements TriskcaseLogDAO {    

    /**
     *  根据主键获得TriskcaseLog对象.
     *  @param pkey TriskcaseLog主键
     *  @return TriskcaseLog.
     */
    public TriskcaseLog getTriskcaseLog(java.lang.String pkey) {
        TriskcaseLog triskcaseLog = (TriskcaseLog) getHibernateTemplate().get(TriskcaseLog.class, pkey);
        if (triskcaseLog == null) {
            return triskcaseLog;
        }
        return triskcaseLog;

    }

    /**
     *  存储TriskcaseLog对象.
     *  @param  triskcaseLog TriskcaseLog对象
     *  @return TriskcaseLog.
     */
    public TriskcaseLog saveTriskcaseLog(TriskcaseLog triskcaseLog) {
        return (TriskcaseLog) getHibernateTemplate().merge(triskcaseLog);
    }

    /**
     *  删除TriskcaseLog对象.
     *  @param pkey TriskcaseLog主键.
     */
    public void removeTriskcaseLog(java.lang.String pkey) {
        TriskcaseLog triskcaseLog = getTriskcaseLog(pkey);
        getHibernateTemplate().delete(triskcaseLog);
    }

    /**
     *  获取TriskcaseLog对象列表.
     *  @param  triskcaseLog TriskcaseLog对象
     *  @return List.
     */
    public List getTriskcaseLogList(TriskcaseLog triskcaseLog) {
        Criteria criteria = getSession().createCriteria(TriskcaseLog.class).add(
                Example.create(triskcaseLog));
        if (triskcaseLog.getId() != null) {
            criteria.add(Expression.eq("id", triskcaseLog.getId()));
        }
        return criteria.list();
    }

    /**
     *  根据查询条件获取TriskcaseLog对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getTriskcaseLogListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TriskcaseLog where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(TriskcaseLog.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取TriskcaseLog对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getTriskcaseLogListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TriskcaseLog where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(TriskcaseLog.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤TriskcaseLog对象
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

        if (queryMap.get("userMame") != null) {
            criteria = criteria.add(Expression.eq("userMame", queryMap.get("userMame")));
        }
        if (queryMap.get("userMame_like") != null) {
            criteria = criteria.add(Expression.like("userMame", "%" + queryMap.get("userMame_like") + "%"));
        }

        if (queryMap.get("operatorDatetime") != null) {
            criteria = criteria.add(Expression.eq("operatorDatetime", java.sql.Date.valueOf((String) queryMap.get("operatorDatetime"))));
        }
        if (queryMap.get("operatorDatetime_min") != null) {
            criteria = criteria.add(Expression.ge("operatorDatetime", java.sql.Date.valueOf((String) queryMap.get("operatorDatetime_min"))));
        }
        if (queryMap.get("operatorDatetime_max") != null) {
            criteria = criteria.add(Expression.le("operatorDatetime", java.sql.Date.valueOf((String) queryMap.get("operatorDatetime_max"))));
        }
        if (queryMap.get("ip") != null) {
            criteria = criteria.add(Expression.eq("ip", queryMap.get("ip")));
        }
        if (queryMap.get("ip_like") != null) {
            criteria = criteria.add(Expression.like("ip", "%" + queryMap.get("ip_like") + "%"));
        }

        if (queryMap.get("content") != null) {
            criteria = criteria.add(Expression.eq("content", queryMap.get("content")));
        }
        if (queryMap.get("content_like") != null) {
            criteria = criteria.add(Expression.like("content", "%" + queryMap.get("content_like") + "%"));
        }

        if (queryMap.get("loginName") != null) {
            criteria = criteria.add(Expression.eq("loginName", queryMap.get("loginName")));
        }
        if (queryMap.get("loginName_like") != null) {
            criteria = criteria.add(Expression.like("loginName", "%" + queryMap.get("loginName_like") + "%"));
        }


        //根据查询queryMap的键值，提供排序功能,_order="域名1 asc|desc,域名2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
