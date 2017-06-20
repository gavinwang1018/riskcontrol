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

import cn.com.brilliance.begen.dao.SysDailyDefDAO;
import cn.com.brilliance.begen.model.SysDailyDef;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysDailyDefDAO接口具体实现类.
 * @author Administrator.
 */

public class SysDailyDefDAOHibernate extends BeGenHibernateDaoSupport implements SysDailyDefDAO {    

    /**
     *  根据主键获得SysDailyDef对象.
     *  @param pkey SysDailyDef主键
     *  @return SysDailyDef.
     */
    public SysDailyDef getSysDailyDef(java.lang.String pkey) {
        SysDailyDef sysDailyDef = (SysDailyDef) getHibernateTemplate().get(SysDailyDef.class, pkey);
        if (sysDailyDef == null) {
            return sysDailyDef;
        }
        return sysDailyDef;

    }

    /**
     *  存储SysDailyDef对象.
     *  @param  sysDailyDef SysDailyDef对象
     *  @return SysDailyDef.
     */
    public SysDailyDef saveSysDailyDef(SysDailyDef sysDailyDef) {
        return (SysDailyDef) getHibernateTemplate().merge(sysDailyDef);
    }

    /**
     *  删除SysDailyDef对象.
     *  @param pkey SysDailyDef主键.
     */
    public void removeSysDailyDef(java.lang.String pkey) {
        SysDailyDef sysDailyDef = getSysDailyDef(pkey);
        getHibernateTemplate().delete(sysDailyDef);
    }

    /**
     *  获取SysDailyDef对象列表.
     *  @param  sysDailyDef SysDailyDef对象
     *  @return List.
     */
    public List getSysDailyDefList(SysDailyDef sysDailyDef) {
        Criteria criteria = getSession().createCriteria(SysDailyDef.class).add(
                Example.create(sysDailyDef));
        if (sysDailyDef.getId() != null) {
            criteria.add(Expression.eq("id", sysDailyDef.getId()));
        }
        return criteria.list();
    }

    /**
     *  根据查询条件获取SysDailyDef对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysDailyDefListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysDailyDef where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysDailyDef.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取SysDailyDef对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysDailyDefListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysDailyDef where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysDailyDef.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤SysDailyDef对象
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

        if (queryMap.get("eventType") != null) {
            criteria = criteria.add(Expression.eq("eventType", queryMap.get("eventType")));
        }
        if (queryMap.get("eventType_like") != null) {
            criteria = criteria.add(Expression.like("eventType", "%" + queryMap.get("eventType_like") + "%"));
        }

        if (queryMap.get("title") != null) {
            criteria = criteria.add(Expression.eq("title", queryMap.get("title")));
        }
        if (queryMap.get("title_like") != null) {
            criteria = criteria.add(Expression.like("title", "%" + queryMap.get("title_like") + "%"));
        }

        if (queryMap.get("url") != null) {
            criteria = criteria.add(Expression.eq("url", queryMap.get("url")));
        }
        if (queryMap.get("url_like") != null) {
            criteria = criteria.add(Expression.like("url", "%" + queryMap.get("url_like") + "%"));
        }

        if (queryMap.get("content") != null) {
            criteria = criteria.add(Expression.eq("content", queryMap.get("content")));
        }
        if (queryMap.get("content_like") != null) {
            criteria = criteria.add(Expression.like("content", "%" + queryMap.get("content_like") + "%"));
        }

        if (queryMap.get("dataObject") != null) {
            criteria = criteria.add(Expression.eq("dataObject", queryMap.get("dataObject")));
        }
        if (queryMap.get("dataObject_like") != null) {
            criteria = criteria.add(Expression.like("dataObject", "%" + queryMap.get("dataObject_like") + "%"));
        }

        if (queryMap.get("dateField") != null) {
            criteria = criteria.add(Expression.eq("dateField", queryMap.get("dateField")));
        }
        if (queryMap.get("dateField_like") != null) {
            criteria = criteria.add(Expression.like("dateField", "%" + queryMap.get("dateField_like") + "%"));
        }

        if (queryMap.get("filterExpress") != null) {
            criteria = criteria.add(Expression.eq("filterExpress", queryMap.get("filterExpress")));
        }
        if (queryMap.get("filterExpress_like") != null) {
            criteria = criteria.add(Expression.like("filterExpress", "%" + queryMap.get("filterExpress_like") + "%"));
        }

        if (queryMap.get("partyId") != null) {
            criteria = criteria.add(Expression.eq("partyId", queryMap.get("partyId")));
        }
        if (queryMap.get("partyId_like") != null) {
            criteria = criteria.add(Expression.like("partyId", "%" + queryMap.get("partyId_like") + "%"));
        }

        if (queryMap.get("urlDescription") != null) {
            criteria = criteria.add(Expression.eq("urlDescription", queryMap.get("urlDescription")));
        }
        if (queryMap.get("urlDescription_like") != null) {
            criteria = criteria.add(Expression.like("urlDescription", "%" + queryMap.get("urlDescription_like") + "%"));
        }


        //根据查询queryMap的键值，提供排序功能,_order="域名1 asc|desc,域名2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
