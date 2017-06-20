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

import cn.com.brilliance.begen.dao.SysReportQueryDefDAO;
import cn.com.brilliance.begen.model.SysReportQueryDef;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysReportQueryDefDAO接口具体实现类.
 * @author Administrator.
 */

public class SysReportQueryDefDAOHibernate extends BeGenHibernateDaoSupport implements SysReportQueryDefDAO {    

    /**
     *  根据主键获得SysReportQueryDef对象.
     *  @param pkey SysReportQueryDef主键
     *  @return SysReportQueryDef.
     */
    public SysReportQueryDef getSysReportQueryDef(java.lang.String pkey) {
        SysReportQueryDef sysReportQueryDef = (SysReportQueryDef) getHibernateTemplate().get(SysReportQueryDef.class, pkey);
        if (sysReportQueryDef == null) {
            return sysReportQueryDef;
        }
        return sysReportQueryDef;

    }

    /**
     *  存储SysReportQueryDef对象.
     *  @param  sysReportQueryDef SysReportQueryDef对象
     *  @return SysReportQueryDef.
     */
    public SysReportQueryDef saveSysReportQueryDef(SysReportQueryDef sysReportQueryDef) {
        return (SysReportQueryDef) getHibernateTemplate().merge(sysReportQueryDef);
    }

    /**
     *  删除SysReportQueryDef对象.
     *  @param pkey SysReportQueryDef主键.
     */
    public void removeSysReportQueryDef(java.lang.String pkey) {
        SysReportQueryDef sysReportQueryDef = getSysReportQueryDef(pkey);
        getHibernateTemplate().delete(sysReportQueryDef);
    }

    /**
     *  获取SysReportQueryDef对象列表.
     *  @param  sysReportQueryDef SysReportQueryDef对象
     *  @return List.
     */
    public List getSysReportQueryDefList(SysReportQueryDef sysReportQueryDef) {
        Criteria criteria = getSession().createCriteria(SysReportQueryDef.class).add(
                Example.create(sysReportQueryDef));
        if (sysReportQueryDef.getId() != null) {
            criteria.add(Expression.eq("id", sysReportQueryDef.getId()));
        }
        criteria.addOrder(Order.asc("sysRecordOrder"));
        return criteria.list();
    }

    /**
     *  根据查询条件获取SysReportQueryDef对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysReportQueryDefListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysReportQueryDef where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysReportQueryDef.class);

        criteria.addOrder(Order.asc("sysRecordOrder"));
        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取SysReportQueryDef对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysReportQueryDefListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysReportQueryDef where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysReportQueryDef.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤SysReportQueryDef对象
        Object[] keyArray = queryMap.keySet().toArray();  //转换查询字段名keySet为数组
        //遍历该数组，去除对应查询字段值为空的键值
        for (int i = 0; i < keyArray.length; i++) {
            String value = (String) queryMap.get(keyArray[i]);
            if (value == null || value.trim().length() == 0) {
                queryMap.remove(keyArray[i]);
            }
        }

        if (queryMap.get("queryMode") != null) {
            criteria = criteria.add(Expression.eq("queryMode", queryMap.get("queryMode")));
        }
        if (queryMap.get("queryMode_like") != null) {
            criteria = criteria.add(Expression.like("queryMode", "%" + queryMap.get("queryMode_like") + "%"));
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

        if (queryMap.get("sysReportDef") != null) {
            criteria = criteria.add(Expression.eq("sysReportDef", queryMap.get("sysReportDef")));
        }
        if (queryMap.get("sysReportDef_like") != null) {
            criteria = criteria.add(Expression.like("sysReportDef", "%" + queryMap.get("sysReportDef_like") + "%"));
        }

        if (queryMap.get("reportField") != null) {
            criteria = criteria.add(Expression.eq("reportField", queryMap.get("reportField")));
        }
        if (queryMap.get("reportField_like") != null) {
            criteria = criteria.add(Expression.like("reportField", "%" + queryMap.get("reportField_like") + "%"));
        }


        //根据查询queryMap的键值，提供排序功能,_order="域名1 asc|desc,域名2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
