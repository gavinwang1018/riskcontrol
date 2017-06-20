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

import cn.com.brilliance.begen.dao.SysRelativeDAO;
import cn.com.brilliance.begen.model.SysRelative;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysRelativeDAO接口具体实现类.
 * @author Administrator.
 */

public class SysRelativeDAOHibernate extends BeGenHibernateDaoSupport implements SysRelativeDAO {    

    /**
     *  根据主键获得SysRelative对象.
     *  @param pkey SysRelative主键
     *  @return SysRelative.
     */
    public SysRelative getSysRelative(java.lang.String pkey) {
        SysRelative sysRelative = (SysRelative) getHibernateTemplate().get(SysRelative.class, pkey);
        if (sysRelative == null) {
            return sysRelative;
        }
        return sysRelative;

    }

    /**
     *  存储SysRelative对象.
     *  @param  sysRelative SysRelative对象
     *  @return SysRelative.
     */
    public SysRelative saveSysRelative(SysRelative sysRelative) {
        return (SysRelative) getHibernateTemplate().merge(sysRelative);
    }

    /**
     *  删除SysRelative对象.
     *  @param pkey SysRelative主键.
     */
    public void removeSysRelative(java.lang.String pkey) {
        SysRelative sysRelative = getSysRelative(pkey);
        getHibernateTemplate().delete(sysRelative);
    }

    /**
     *  获取SysRelative对象列表.
     *  @param  sysRelative SysRelative对象
     *  @return List.
     */
    public List getSysRelativeList(SysRelative sysRelative) {
        Criteria criteria = getSession().createCriteria(SysRelative.class).add(
                Example.create(sysRelative));
        if (sysRelative.getId() != null) {
            criteria.add(Expression.eq("id", sysRelative.getId()));
        }
        criteria.addOrder(Order.asc("sysRecordOrder"));
        return criteria.list();
    }

    /**
     *  根据查询条件获取SysRelative对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysRelativeListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysRelative where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysRelative.class);

        criteria.addOrder(Order.asc("sysRecordOrder"));
        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取SysRelative对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysRelativeListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysRelative where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysRelative.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤SysRelative对象
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

        if (queryMap.get("partyId") != null) {
            criteria = criteria.add(Expression.eq("partyId", queryMap.get("partyId")));
        }
        if (queryMap.get("partyId_like") != null) {
            criteria = criteria.add(Expression.like("partyId", "%" + queryMap.get("partyId_like") + "%"));
        }

        if (queryMap.get("dataObject") != null) {
            criteria = criteria.add(Expression.eq("dataObject", queryMap.get("dataObject")));
        }
        if (queryMap.get("dataObject_like") != null) {
            criteria = criteria.add(Expression.like("dataObject", "%" + queryMap.get("dataObject_like") + "%"));
        }

        if (queryMap.get("formLayout") != null) {
            criteria = criteria.add(Expression.eq("formLayout", queryMap.get("formLayout")));
        }
        if (queryMap.get("formLayout_like") != null) {
            criteria = criteria.add(Expression.like("formLayout", "%" + queryMap.get("formLayout_like") + "%"));
        }

        if (queryMap.get("listLayout") != null) {
            criteria = criteria.add(Expression.eq("listLayout", queryMap.get("listLayout")));
        }
        if (queryMap.get("listLayout_like") != null) {
            criteria = criteria.add(Expression.like("listLayout", "%" + queryMap.get("listLayout_like") + "%"));
        }


        //根据查询queryMap的键值，提供排序功能,_order="域名1 asc|desc,域名2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
