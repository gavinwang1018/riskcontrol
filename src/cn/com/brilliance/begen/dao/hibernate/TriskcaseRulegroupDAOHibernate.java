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

import cn.com.brilliance.begen.dao.TriskcaseRulegroupDAO;
import cn.com.brilliance.begen.model.TriskcaseRulegroup;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * TriskcaseRulegroupDAO接口具体实现类.
 * @author Administrator.
 */

public class TriskcaseRulegroupDAOHibernate extends BeGenHibernateDaoSupport implements TriskcaseRulegroupDAO {    

    /**
     *  根据主键获得TriskcaseRulegroup对象.
     *  @param pkey TriskcaseRulegroup主键
     *  @return TriskcaseRulegroup.
     */
    public TriskcaseRulegroup getTriskcaseRulegroup(java.lang.String pkey) {
        TriskcaseRulegroup triskcaseRulegroup = (TriskcaseRulegroup) getHibernateTemplate().get(TriskcaseRulegroup.class, pkey);
        if (triskcaseRulegroup == null) {
            return triskcaseRulegroup;
        }
        return triskcaseRulegroup;

    }

    /**
     *  存储TriskcaseRulegroup对象.
     *  @param  triskcaseRulegroup TriskcaseRulegroup对象
     *  @return TriskcaseRulegroup.
     */
    public TriskcaseRulegroup saveTriskcaseRulegroup(TriskcaseRulegroup triskcaseRulegroup) {
        return (TriskcaseRulegroup) getHibernateTemplate().merge(triskcaseRulegroup);
    }

    /**
     *  删除TriskcaseRulegroup对象.
     *  @param pkey TriskcaseRulegroup主键.
     */
    public void removeTriskcaseRulegroup(java.lang.String pkey) {
        TriskcaseRulegroup triskcaseRulegroup = getTriskcaseRulegroup(pkey);
        getHibernateTemplate().delete(triskcaseRulegroup);
    }

    /**
     *  获取TriskcaseRulegroup对象列表.
     *  @param  triskcaseRulegroup TriskcaseRulegroup对象
     *  @return List.
     */
    public List getTriskcaseRulegroupList(TriskcaseRulegroup triskcaseRulegroup) {
        Criteria criteria = getSession().createCriteria(TriskcaseRulegroup.class).add(
                Example.create(triskcaseRulegroup));
        if (triskcaseRulegroup.getId() != null) {
            criteria.add(Expression.eq("id", triskcaseRulegroup.getId()));
        }
        return criteria.list();
    }

    /**
     *  根据查询条件获取TriskcaseRulegroup对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getTriskcaseRulegroupListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TriskcaseRulegroup where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(TriskcaseRulegroup.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取TriskcaseRulegroup对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getTriskcaseRulegroupListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TriskcaseRulegroup where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(TriskcaseRulegroup.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤TriskcaseRulegroup对象
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

        if (queryMap.get("riskCaseId") != null) {
            criteria = criteria.add(Expression.eq("riskCaseId", queryMap.get("riskCaseId")));
        }
        if (queryMap.get("riskCaseId_like") != null) {
            criteria = criteria.add(Expression.like("riskCaseId", "%" + queryMap.get("riskCaseId_like") + "%"));
        }

        if (queryMap.get("ruleGroupId") != null) {
            criteria = criteria.add(Expression.eq("ruleGroupId", queryMap.get("ruleGroupId")));
        }
        if (queryMap.get("ruleGroupId_like") != null) {
            criteria = criteria.add(Expression.like("ruleGroupId", "%" + queryMap.get("ruleGroupId_like") + "%"));
        }


        //根据查询queryMap的键值，提供排序功能,_order="域名1 asc|desc,域名2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
