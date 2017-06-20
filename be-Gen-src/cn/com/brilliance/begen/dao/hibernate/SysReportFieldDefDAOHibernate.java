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

import cn.com.brilliance.begen.dao.SysReportFieldDefDAO;
import cn.com.brilliance.begen.model.SysReportFieldDef;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysReportFieldDefDAO接口具体实现类.
 * @author Administrator.
 */

public class SysReportFieldDefDAOHibernate extends BeGenHibernateDaoSupport implements SysReportFieldDefDAO {    

    /**
     *  根据主键获得SysReportFieldDef对象.
     *  @param pkey SysReportFieldDef主键
     *  @return SysReportFieldDef.
     */
    public SysReportFieldDef getSysReportFieldDef(java.lang.String pkey) {
        SysReportFieldDef sysReportFieldDef = (SysReportFieldDef) getHibernateTemplate().get(SysReportFieldDef.class, pkey);
        if (sysReportFieldDef == null) {
            return sysReportFieldDef;
        }
        return sysReportFieldDef;

    }

    /**
     *  存储SysReportFieldDef对象.
     *  @param  sysReportFieldDef SysReportFieldDef对象
     *  @return SysReportFieldDef.
     */
    public SysReportFieldDef saveSysReportFieldDef(SysReportFieldDef sysReportFieldDef) {
        return (SysReportFieldDef) getHibernateTemplate().merge(sysReportFieldDef);
    }

    /**
     *  删除SysReportFieldDef对象.
     *  @param pkey SysReportFieldDef主键.
     */
    public void removeSysReportFieldDef(java.lang.String pkey) {
        SysReportFieldDef sysReportFieldDef = getSysReportFieldDef(pkey);
        getHibernateTemplate().delete(sysReportFieldDef);
    }

    /**
     *  获取SysReportFieldDef对象列表.
     *  @param  sysReportFieldDef SysReportFieldDef对象
     *  @return List.
     */
    public List getSysReportFieldDefList(SysReportFieldDef sysReportFieldDef) {
        Criteria criteria = getSession().createCriteria(SysReportFieldDef.class).add(
                Example.create(sysReportFieldDef));
        if (sysReportFieldDef.getId() != null) {
            criteria.add(Expression.eq("id", sysReportFieldDef.getId()));
        }
        criteria.addOrder(Order.asc("sysRecordOrder"));
        return criteria.list();
    }

    /**
     *  根据查询条件获取SysReportFieldDef对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysReportFieldDefListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysReportFieldDef where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysReportFieldDef.class);

        criteria.addOrder(Order.asc("sysRecordOrder"));
        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取SysReportFieldDef对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysReportFieldDefListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysReportFieldDef where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysReportFieldDef.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤SysReportFieldDef对象
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

        if (queryMap.get("statisticExpression") != null) {
            criteria = criteria.add(Expression.eq("statisticExpression", queryMap.get("statisticExpression")));
        }
        if (queryMap.get("statisticExpression_like") != null) {
            criteria = criteria.add(Expression.like("statisticExpression", "%" + queryMap.get("statisticExpression_like") + "%"));
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
