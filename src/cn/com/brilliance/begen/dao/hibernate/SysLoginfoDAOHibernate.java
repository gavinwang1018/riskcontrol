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

import cn.com.brilliance.begen.dao.SysLoginfoDAO;
import cn.com.brilliance.begen.model.SysLoginfo;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysLoginfoDAO接口具体实现类.
 * @author Administrator.
 */

public class SysLoginfoDAOHibernate extends BeGenHibernateDaoSupport implements SysLoginfoDAO {    

    /**
     *  根据主键获得SysLoginfo对象.
     *  @param pkey SysLoginfo主键
     *  @return SysLoginfo.
     */
    public SysLoginfo getSysLoginfo(java.lang.String pkey) {
        SysLoginfo sysLoginfo = (SysLoginfo) getHibernateTemplate().get(SysLoginfo.class, pkey);
        if (sysLoginfo == null) {
            return sysLoginfo;
        }
        return sysLoginfo;

    }

    /**
     *  存储SysLoginfo对象.
     *  @param  sysLoginfo SysLoginfo对象
     *  @return SysLoginfo.
     */
    public SysLoginfo saveSysLoginfo(SysLoginfo sysLoginfo) {
        return (SysLoginfo) getHibernateTemplate().merge(sysLoginfo);
    }

    /**
     *  删除SysLoginfo对象.
     *  @param pkey SysLoginfo主键.
     */
    public void removeSysLoginfo(java.lang.String pkey) {
        SysLoginfo sysLoginfo = getSysLoginfo(pkey);
        getHibernateTemplate().delete(sysLoginfo);
    }

    /**
     *  获取SysLoginfo对象列表.
     *  @param  sysLoginfo SysLoginfo对象
     *  @return List.
     */
    public List getSysLoginfoList(SysLoginfo sysLoginfo) {
        Criteria criteria = getSession().createCriteria(SysLoginfo.class).add(
                Example.create(sysLoginfo));
        if (sysLoginfo.getId() != null) {
            criteria.add(Expression.eq("id", sysLoginfo.getId()));
        }
        return criteria.list();
    }

    /**
     *  根据查询条件获取SysLoginfo对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysLoginfoListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysLoginfo where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysLoginfo.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取SysLoginfo对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysLoginfoListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysLoginfo where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysLoginfo.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤SysLoginfo对象
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

        if (queryMap.get("operator") != null) {
            criteria = criteria.add(Expression.eq("operator", queryMap.get("operator")));
        }
        if (queryMap.get("operator_like") != null) {
            criteria = criteria.add(Expression.like("operator", "%" + queryMap.get("operator_like") + "%"));
        }

        if (queryMap.get("operationType") != null) {
            criteria = criteria.add(Expression.eq("operationType", queryMap.get("operationType")));
        }
        if (queryMap.get("operationType_like") != null) {
            criteria = criteria.add(Expression.like("operationType", "%" + queryMap.get("operationType_like") + "%"));
        }

        if (queryMap.get("operationTitle") != null) {
            criteria = criteria.add(Expression.eq("operationTitle", queryMap.get("operationTitle")));
        }
        if (queryMap.get("operationTitle_like") != null) {
            criteria = criteria.add(Expression.like("operationTitle", "%" + queryMap.get("operationTitle_like") + "%"));
        }

        if (queryMap.get("operationTime") != null) {
            criteria = criteria.add(Expression.eq("operationTime", java.sql.Date.valueOf((String) queryMap.get("operationTime"))));
        }
        if (queryMap.get("operationTime_min") != null) {
            criteria = criteria.add(Expression.ge("operationTime", java.sql.Date.valueOf((String) queryMap.get("operationTime_min"))));
        }
        if (queryMap.get("operationTime_max") != null) {
            criteria = criteria.add(Expression.le("operationTime", java.sql.Date.valueOf((String) queryMap.get("operationTime_max"))));
        }
        if (queryMap.get("clientIp") != null) {
            criteria = criteria.add(Expression.eq("clientIp", queryMap.get("clientIp")));
        }
        if (queryMap.get("clientIp_like") != null) {
            criteria = criteria.add(Expression.like("clientIp", "%" + queryMap.get("clientIp_like") + "%"));
        }

        if (queryMap.get("terminalType") != null) {
            criteria = criteria.add(Expression.eq("terminalType", queryMap.get("terminalType")));
        }
        if (queryMap.get("terminalType_like") != null) {
            criteria = criteria.add(Expression.like("terminalType", "%" + queryMap.get("terminalType_like") + "%"));
        }


        //根据查询queryMap的键值，提供排序功能,_order="域名1 asc|desc,域名2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
