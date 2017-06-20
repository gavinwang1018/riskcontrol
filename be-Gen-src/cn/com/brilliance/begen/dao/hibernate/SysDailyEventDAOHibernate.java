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

import cn.com.brilliance.begen.dao.SysDailyEventDAO;
import cn.com.brilliance.begen.model.SysDailyEvent;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysDailyEventDAO接口具体实现类.
 * @author Administrator.
 */

public class SysDailyEventDAOHibernate extends BeGenHibernateDaoSupport implements SysDailyEventDAO {    

    /**
     *  根据主键获得SysDailyEvent对象.
     *  @param pkey SysDailyEvent主键
     *  @return SysDailyEvent.
     */
    public SysDailyEvent getSysDailyEvent(java.lang.String pkey) {
        SysDailyEvent sysDailyEvent = (SysDailyEvent) getHibernateTemplate().get(SysDailyEvent.class, pkey);
        if (sysDailyEvent == null) {
            return sysDailyEvent;
        }
        return sysDailyEvent;

    }

    /**
     *  存储SysDailyEvent对象.
     *  @param  sysDailyEvent SysDailyEvent对象
     *  @return SysDailyEvent.
     */
    public SysDailyEvent saveSysDailyEvent(SysDailyEvent sysDailyEvent) {
        return (SysDailyEvent) getHibernateTemplate().merge(sysDailyEvent);
    }

    /**
     *  删除SysDailyEvent对象.
     *  @param pkey SysDailyEvent主键.
     */
    public void removeSysDailyEvent(java.lang.String pkey) {
        SysDailyEvent sysDailyEvent = getSysDailyEvent(pkey);
        getHibernateTemplate().delete(sysDailyEvent);
    }

    /**
     *  获取SysDailyEvent对象列表.
     *  @param  sysDailyEvent SysDailyEvent对象
     *  @return List.
     */
    public List getSysDailyEventList(SysDailyEvent sysDailyEvent) {
        Criteria criteria = getSession().createCriteria(SysDailyEvent.class).add(
                Example.create(sysDailyEvent));
        if (sysDailyEvent.getId() != null) {
            criteria.add(Expression.eq("id", sysDailyEvent.getId()));
        }
        return criteria.list();
    }

    /**
     *  根据查询条件获取SysDailyEvent对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysDailyEventListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysDailyEvent where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysDailyEvent.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取SysDailyEvent对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysDailyEventListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysDailyEvent where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysDailyEvent.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤SysDailyEvent对象
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

        if (queryMap.get("typeId") != null) {
            criteria = criteria.add(Expression.eq("typeId", queryMap.get("typeId")));
        }
        if (queryMap.get("typeId_like") != null) {
            criteria = criteria.add(Expression.like("typeId", "%" + queryMap.get("typeId_like") + "%"));
        }

        if (queryMap.get("name") != null) {
            criteria = criteria.add(Expression.eq("name", queryMap.get("name")));
        }
        if (queryMap.get("name_like") != null) {
            criteria = criteria.add(Expression.like("name", "%" + queryMap.get("name_like") + "%"));
        }

        if (queryMap.get("imageUrl") != null) {
            criteria = criteria.add(Expression.eq("imageUrl", queryMap.get("imageUrl")));
        }
        if (queryMap.get("imageUrl_like") != null) {
            criteria = criteria.add(Expression.like("imageUrl", "%" + queryMap.get("imageUrl_like") + "%"));
        }

        if (queryMap.get("partyId") != null) {
            criteria = criteria.add(Expression.eq("partyId", queryMap.get("partyId")));
        }
        if (queryMap.get("partyId_like") != null) {
            criteria = criteria.add(Expression.like("partyId", "%" + queryMap.get("partyId_like") + "%"));
        }


        //根据查询queryMap的键值，提供排序功能,_order="域名1 asc|desc,域名2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
