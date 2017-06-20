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

import cn.com.brilliance.begen.dao.SysAutonumberDAO;
import cn.com.brilliance.begen.model.SysAutonumber;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysAutonumberDAO接口具体实现类.
 * @author Administrator.
 */

public class SysAutonumberDAOHibernate extends BeGenHibernateDaoSupport implements SysAutonumberDAO {    

    /**
     *  根据主键获得SysAutonumber对象.
     *  @param pkey SysAutonumber主键
     *  @return SysAutonumber.
     */
    public SysAutonumber getSysAutonumber(java.lang.String pkey) {
        SysAutonumber sysAutonumber = (SysAutonumber) getHibernateTemplate().get(SysAutonumber.class, pkey);
        if (sysAutonumber == null) {
            return sysAutonumber;
        }
        return sysAutonumber;

    }

    /**
     *  存储SysAutonumber对象.
     *  @param  sysAutonumber SysAutonumber对象
     *  @return SysAutonumber.
     */
    public SysAutonumber saveSysAutonumber(SysAutonumber sysAutonumber) {
        return (SysAutonumber) getHibernateTemplate().merge(sysAutonumber);
    }

    /**
     *  删除SysAutonumber对象.
     *  @param pkey SysAutonumber主键.
     */
    public void removeSysAutonumber(java.lang.String pkey) {
        SysAutonumber sysAutonumber = getSysAutonumber(pkey);
        getHibernateTemplate().delete(sysAutonumber);
    }

    /**
     *  获取SysAutonumber对象列表.
     *  @param  sysAutonumber SysAutonumber对象
     *  @return List.
     */
    public List getSysAutonumberList(SysAutonumber sysAutonumber) {
        Criteria criteria = getSession().createCriteria(SysAutonumber.class).add(
                Example.create(sysAutonumber));
        if (sysAutonumber.getId() != null) {
            criteria.add(Expression.eq("id", sysAutonumber.getId()));
        }
        return criteria.list();
    }

    /**
     *  根据查询条件获取SysAutonumber对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysAutonumberListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysAutonumber where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysAutonumber.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取SysAutonumber对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysAutonumberListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysAutonumber where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysAutonumber.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤SysAutonumber对象
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

        if (queryMap.get("numvalue") != null) {
            criteria = criteria.add(Expression.eq("numvalue", new Integer((String) queryMap.get("numvalue"))));
        }
        if (queryMap.get("numvalue_min") != null) {
            criteria = criteria.add(Expression.ge("numvalue", new Integer((String) queryMap.get("numvalue_min"))));
        }
        if (queryMap.get("numvalue_max") != null) {
            criteria = criteria.add(Expression.le("numvalue", new Integer((String) queryMap.get("numvalue_max"))));
        }
        if (queryMap.get("partyId") != null) {
            criteria = criteria.add(Expression.eq("partyId", queryMap.get("partyId")));
        }
        if (queryMap.get("partyId_like") != null) {
            criteria = criteria.add(Expression.like("partyId", "%" + queryMap.get("partyId_like") + "%"));
        }

        if (queryMap.get("sysField") != null) {
            criteria = criteria.add(Expression.eq("sysField", queryMap.get("sysField")));
        }
        if (queryMap.get("sysField_like") != null) {
            criteria = criteria.add(Expression.like("sysField", "%" + queryMap.get("sysField_like") + "%"));
        }


        //根据查询queryMap的键值，提供排序功能,_order="域名1 asc|desc,域名2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
