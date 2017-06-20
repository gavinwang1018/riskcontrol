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

import cn.com.brilliance.begen.dao.TpermissionDAO;
import cn.com.brilliance.begen.model.Tpermission;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * TpermissionDAO接口具体实现类.
 * @author Administrator.
 */

public class TpermissionDAOHibernate extends BeGenHibernateDaoSupport implements TpermissionDAO {    

    /**
     *  根据主键获得Tpermission对象.
     *  @param pkey Tpermission主键
     *  @return Tpermission.
     */
    public Tpermission getTpermission(java.lang.String pkey) {
        Tpermission tpermission = (Tpermission) getHibernateTemplate().get(Tpermission.class, pkey);
        if (tpermission == null) {
            return tpermission;
        }
        return tpermission;

    }

    /**
     *  存储Tpermission对象.
     *  @param  tpermission Tpermission对象
     *  @return Tpermission.
     */
    public Tpermission saveTpermission(Tpermission tpermission) {
        return (Tpermission) getHibernateTemplate().merge(tpermission);
    }

    /**
     *  删除Tpermission对象.
     *  @param pkey Tpermission主键.
     */
    public void removeTpermission(java.lang.String pkey) {
        Tpermission tpermission = getTpermission(pkey);
        getHibernateTemplate().delete(tpermission);
    }

    /**
     *  获取Tpermission对象列表.
     *  @param  tpermission Tpermission对象
     *  @return List.
     */
    public List getTpermissionList(Tpermission tpermission) {
        Criteria criteria = getSession().createCriteria(Tpermission.class).add(
                Example.create(tpermission));
        if (tpermission.getId() != null) {
            criteria.add(Expression.eq("id", tpermission.getId()));
        }
        return criteria.list();
    }

    /**
     *  根据查询条件获取Tpermission对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getTpermissionListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.Tpermission where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(Tpermission.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取Tpermission对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getTpermissionListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.Tpermission where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(Tpermission.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤Tpermission对象
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

        if (queryMap.get("priviledeId") != null) {
            criteria = criteria.add(Expression.eq("priviledeId", queryMap.get("priviledeId")));
        }
        if (queryMap.get("priviledeId_like") != null) {
            criteria = criteria.add(Expression.like("priviledeId", "%" + queryMap.get("priviledeId_like") + "%"));
        }

        if (queryMap.get("priviledeType") != null) {
            criteria = criteria.add(Expression.eq("priviledeType", queryMap.get("priviledeType")));
        }
        if (queryMap.get("priviledeType_like") != null) {
            criteria = criteria.add(Expression.like("priviledeType", "%" + queryMap.get("priviledeType_like") + "%"));
        }

        if (queryMap.get("roleId") != null) {
            criteria = criteria.add(Expression.eq("roleId", queryMap.get("roleId")));
        }
        if (queryMap.get("roleId_like") != null) {
            criteria = criteria.add(Expression.like("roleId", "%" + queryMap.get("roleId_like") + "%"));
        }


        //根据查询queryMap的键值，提供排序功能,_order="域名1 asc|desc,域名2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
