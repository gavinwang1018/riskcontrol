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

import cn.com.brilliance.begen.dao.TroleUserDAO;
import cn.com.brilliance.begen.model.TroleUser;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * TroleUserDAO接口具体实现类.
 * @author Administrator.
 */

public class TroleUserDAOHibernate extends BeGenHibernateDaoSupport implements TroleUserDAO {    

    /**
     *  根据主键获得TroleUser对象.
     *  @param pkey TroleUser主键
     *  @return TroleUser.
     */
    public TroleUser getTroleUser(java.lang.String pkey) {
        TroleUser troleUser = (TroleUser) getHibernateTemplate().get(TroleUser.class, pkey);
        if (troleUser == null) {
            return troleUser;
        }
        return troleUser;

    }

    /**
     *  存储TroleUser对象.
     *  @param  troleUser TroleUser对象
     *  @return TroleUser.
     */
    public TroleUser saveTroleUser(TroleUser troleUser) {
        return (TroleUser) getHibernateTemplate().merge(troleUser);
    }

    /**
     *  删除TroleUser对象.
     *  @param pkey TroleUser主键.
     */
    public void removeTroleUser(java.lang.String pkey) {
        TroleUser troleUser = getTroleUser(pkey);
        getHibernateTemplate().delete(troleUser);
    }

    /**
     *  获取TroleUser对象列表.
     *  @param  troleUser TroleUser对象
     *  @return List.
     */
    public List getTroleUserList(TroleUser troleUser) {
        Criteria criteria = getSession().createCriteria(TroleUser.class).add(
                Example.create(troleUser));
        if (troleUser.getId() != null) {
            criteria.add(Expression.eq("id", troleUser.getId()));
        }
        return criteria.list();
    }

    /**
     *  根据查询条件获取TroleUser对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getTroleUserListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TroleUser where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(TroleUser.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取TroleUser对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getTroleUserListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TroleUser where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(TroleUser.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤TroleUser对象
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

        if (queryMap.get("roleId") != null) {
            criteria = criteria.add(Expression.eq("roleId", queryMap.get("roleId")));
        }
        if (queryMap.get("roleId_like") != null) {
            criteria = criteria.add(Expression.like("roleId", "%" + queryMap.get("roleId_like") + "%"));
        }

        if (queryMap.get("userId") != null) {
            criteria = criteria.add(Expression.eq("userId", queryMap.get("userId")));
        }
        if (queryMap.get("userId_like") != null) {
            criteria = criteria.add(Expression.like("userId", "%" + queryMap.get("userId_like") + "%"));
        }


        //根据查询queryMap的键值，提供排序功能,_order="域名1 asc|desc,域名2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
