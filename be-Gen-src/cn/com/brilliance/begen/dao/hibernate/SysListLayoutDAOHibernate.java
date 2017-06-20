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

import cn.com.brilliance.begen.dao.SysListLayoutDAO;
import cn.com.brilliance.begen.model.SysListLayout;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysListLayoutDAO接口具体实现类.
 * @author Administrator.
 */

public class SysListLayoutDAOHibernate extends BeGenHibernateDaoSupport implements SysListLayoutDAO {    

    /**
     *  根据主键获得SysListLayout对象.
     *  @param pkey SysListLayout主键
     *  @return SysListLayout.
     */
    public SysListLayout getSysListLayout(java.lang.String pkey) {
        SysListLayout sysListLayout = (SysListLayout) getHibernateTemplate().get(SysListLayout.class, pkey);
        if (sysListLayout == null) {
            return sysListLayout;
        }
        return sysListLayout;

    }

    /**
     *  存储SysListLayout对象.
     *  @param  sysListLayout SysListLayout对象
     *  @return SysListLayout.
     */
    public SysListLayout saveSysListLayout(SysListLayout sysListLayout) {
        return (SysListLayout) getHibernateTemplate().merge(sysListLayout);
    }

    /**
     *  删除SysListLayout对象.
     *  @param pkey SysListLayout主键.
     */
    public void removeSysListLayout(java.lang.String pkey) {
        SysListLayout sysListLayout = getSysListLayout(pkey);
        getHibernateTemplate().delete(sysListLayout);
    }

    /**
     *  获取SysListLayout对象列表.
     *  @param  sysListLayout SysListLayout对象
     *  @return List.
     */
    public List getSysListLayoutList(SysListLayout sysListLayout) {
        Criteria criteria = getSession().createCriteria(SysListLayout.class).add(
                Example.create(sysListLayout));
        if (sysListLayout.getId() != null) {
            criteria.add(Expression.eq("id", sysListLayout.getId()));
        }
        criteria.addOrder(Order.asc("sysRecordOrder"));
        return criteria.list();
    }

    /**
     *  根据查询条件获取SysListLayout对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysListLayoutListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysListLayout where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysListLayout.class);

        criteria.addOrder(Order.asc("sysRecordOrder"));
        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取SysListLayout对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysListLayoutListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysListLayout where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysListLayout.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤SysListLayout对象
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

        if (queryMap.get("dataObject") != null) {
            criteria = criteria.add(Expression.eq("dataObject", queryMap.get("dataObject")));
        }
        if (queryMap.get("dataObject_like") != null) {
            criteria = criteria.add(Expression.like("dataObject", "%" + queryMap.get("dataObject_like") + "%"));
        }

        if (queryMap.get("name") != null) {
            criteria = criteria.add(Expression.eq("name", queryMap.get("name")));
        }
        if (queryMap.get("name_like") != null) {
            criteria = criteria.add(Expression.like("name", "%" + queryMap.get("name_like") + "%"));
        }

        if (queryMap.get("label") != null) {
            criteria = criteria.add(Expression.eq("label", queryMap.get("label")));
        }
        if (queryMap.get("label_like") != null) {
            criteria = criteria.add(Expression.like("label", "%" + queryMap.get("label_like") + "%"));
        }

        if (queryMap.get("description") != null) {
            criteria = criteria.add(Expression.eq("description", queryMap.get("description")));
        }
        if (queryMap.get("description_like") != null) {
            criteria = criteria.add(Expression.like("description", "%" + queryMap.get("description_like") + "%"));
        }

        if (queryMap.get("formLayout") != null) {
            criteria = criteria.add(Expression.eq("formLayout", queryMap.get("formLayout")));
        }
        if (queryMap.get("formLayout_like") != null) {
            criteria = criteria.add(Expression.like("formLayout", "%" + queryMap.get("formLayout_like") + "%"));
        }

        if (queryMap.get("scroller") != null) {
            criteria = criteria.add(Expression.eq("scroller", new Boolean((String) queryMap.get("scroller"))));
        }
        if (queryMap.get("scrollerSize") != null) {
            criteria = criteria.add(Expression.eq("scrollerSize", new Integer((String) queryMap.get("scrollerSize"))));
        }
        if (queryMap.get("scrollerSize_min") != null) {
            criteria = criteria.add(Expression.ge("scrollerSize", new Integer((String) queryMap.get("scrollerSize_min"))));
        }
        if (queryMap.get("scrollerSize_max") != null) {
            criteria = criteria.add(Expression.le("scrollerSize", new Integer((String) queryMap.get("scrollerSize_max"))));
        }
        if (queryMap.get("url") != null) {
            criteria = criteria.add(Expression.eq("url", queryMap.get("url")));
        }
        if (queryMap.get("url_like") != null) {
            criteria = criteria.add(Expression.like("url", "%" + queryMap.get("url_like") + "%"));
        }

        if (queryMap.get("style") != null) {
            criteria = criteria.add(Expression.eq("style", queryMap.get("style")));
        }
        if (queryMap.get("style_like") != null) {
            criteria = criteria.add(Expression.like("style", "%" + queryMap.get("style_like") + "%"));
        }

        if (queryMap.get("partyId") != null) {
            criteria = criteria.add(Expression.eq("partyId", queryMap.get("partyId")));
        }
        if (queryMap.get("partyId_like") != null) {
            criteria = criteria.add(Expression.like("partyId", "%" + queryMap.get("partyId_like") + "%"));
        }

        if (queryMap.get("multiSelect") != null) {
            criteria = criteria.add(Expression.eq("multiSelect", new Boolean((String) queryMap.get("multiSelect"))));
        }

        //根据查询queryMap的键值，提供排序功能,_order="域名1 asc|desc,域名2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
