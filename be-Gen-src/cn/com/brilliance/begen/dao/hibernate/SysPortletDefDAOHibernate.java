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

import cn.com.brilliance.begen.dao.SysPortletDefDAO;
import cn.com.brilliance.begen.model.SysPortletDef;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysPortletDefDAO接口具体实现类.
 * @author Administrator.
 */

public class SysPortletDefDAOHibernate extends BeGenHibernateDaoSupport implements SysPortletDefDAO {    

    /**
     *  根据主键获得SysPortletDef对象.
     *  @param pkey SysPortletDef主键
     *  @return SysPortletDef.
     */
    public SysPortletDef getSysPortletDef(java.lang.String pkey) {
        SysPortletDef sysPortletDef = (SysPortletDef) getHibernateTemplate().get(SysPortletDef.class, pkey);
        if (sysPortletDef == null) {
            return sysPortletDef;
        }
        return sysPortletDef;

    }

    /**
     *  存储SysPortletDef对象.
     *  @param  sysPortletDef SysPortletDef对象
     *  @return SysPortletDef.
     */
    public SysPortletDef saveSysPortletDef(SysPortletDef sysPortletDef) {
        return (SysPortletDef) getHibernateTemplate().merge(sysPortletDef);
    }

    /**
     *  删除SysPortletDef对象.
     *  @param pkey SysPortletDef主键.
     */
    public void removeSysPortletDef(java.lang.String pkey) {
        SysPortletDef sysPortletDef = getSysPortletDef(pkey);
        getHibernateTemplate().delete(sysPortletDef);
    }

    /**
     *  获取SysPortletDef对象列表.
     *  @param  sysPortletDef SysPortletDef对象
     *  @return List.
     */
    public List getSysPortletDefList(SysPortletDef sysPortletDef) {
        Criteria criteria = getSession().createCriteria(SysPortletDef.class).add(
                Example.create(sysPortletDef));
        if (sysPortletDef.getId() != null) {
            criteria.add(Expression.eq("id", sysPortletDef.getId()));
        }
        criteria.addOrder(Order.asc("sysRecordOrder"));
        return criteria.list();
    }

    /**
     *  根据查询条件获取SysPortletDef对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysPortletDefListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysPortletDef where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysPortletDef.class);

        criteria.addOrder(Order.asc("sysRecordOrder"));
        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取SysPortletDef对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysPortletDefListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysPortletDef where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysPortletDef.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤SysPortletDef对象
        Object[] keyArray = queryMap.keySet().toArray();  //转换查询字段名keySet为数组
        //遍历该数组，去除对应查询字段值为空的键值
        for (int i = 0; i < keyArray.length; i++) {
            String value = (String) queryMap.get(keyArray[i]);
            if (value == null || value.trim().length() == 0) {
                queryMap.remove(keyArray[i]);
            }
        }

        if (queryMap.get("label") != null) {
            criteria = criteria.add(Expression.eq("label", queryMap.get("label")));
        }
        if (queryMap.get("label_like") != null) {
            criteria = criteria.add(Expression.like("label", "%" + queryMap.get("label_like") + "%"));
        }

        if (queryMap.get("url") != null) {
            criteria = criteria.add(Expression.eq("url", queryMap.get("url")));
        }
        if (queryMap.get("url_like") != null) {
            criteria = criteria.add(Expression.like("url", "%" + queryMap.get("url_like") + "%"));
        }

        if (queryMap.get("partyId") != null) {
            criteria = criteria.add(Expression.eq("partyId", queryMap.get("partyId")));
        }
        if (queryMap.get("partyId_like") != null) {
            criteria = criteria.add(Expression.like("partyId", "%" + queryMap.get("partyId_like") + "%"));
        }

        if (queryMap.get("id") != null) {
            criteria = criteria.add(Expression.eq("id", queryMap.get("id")));
        }
        if (queryMap.get("id_like") != null) {
            criteria = criteria.add(Expression.like("id", "%" + queryMap.get("id_like") + "%"));
        }

        if (queryMap.get("urlDescription") != null) {
            criteria = criteria.add(Expression.eq("urlDescription", queryMap.get("urlDescription")));
        }
        if (queryMap.get("urlDescription_like") != null) {
            criteria = criteria.add(Expression.like("urlDescription", "%" + queryMap.get("urlDescription_like") + "%"));
        }

        if (queryMap.get("portalId") != null) {
            criteria = criteria.add(Expression.eq("portalId", queryMap.get("portalId")));
        }
        if (queryMap.get("portalId_like") != null) {
            criteria = criteria.add(Expression.like("portalId", "%" + queryMap.get("portalId_like") + "%"));
        }

        if (queryMap.get("cols") != null) {
            criteria = criteria.add(Expression.eq("cols", queryMap.get("cols")));
        }
        if (queryMap.get("cols_like") != null) {
            criteria = criteria.add(Expression.like("cols", "%" + queryMap.get("cols_like") + "%"));
        }


        //根据查询queryMap的键值，提供排序功能,_order="域名1 asc|desc,域名2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
