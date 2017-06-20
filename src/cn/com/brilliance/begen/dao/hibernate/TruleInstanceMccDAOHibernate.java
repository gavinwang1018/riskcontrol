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

import cn.com.brilliance.begen.dao.TruleInstanceMccDAO;
import cn.com.brilliance.begen.model.TruleInstanceMcc;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * TruleInstanceMccDAO接口具体实现类.
 * @author Administrator.
 */

public class TruleInstanceMccDAOHibernate extends BeGenHibernateDaoSupport implements TruleInstanceMccDAO {    

    /**
     *  根据主键获得TruleInstanceMcc对象.
     *  @param pkey TruleInstanceMcc主键
     *  @return TruleInstanceMcc.
     */
    public TruleInstanceMcc getTruleInstanceMcc(java.lang.String pkey) {
        TruleInstanceMcc truleInstanceMcc = (TruleInstanceMcc) getHibernateTemplate().get(TruleInstanceMcc.class, pkey);
        if (truleInstanceMcc == null) {
            return truleInstanceMcc;
        }
        return truleInstanceMcc;

    }

    /**
     *  存储TruleInstanceMcc对象.
     *  @param  truleInstanceMcc TruleInstanceMcc对象
     *  @return TruleInstanceMcc.
     */
    public TruleInstanceMcc saveTruleInstanceMcc(TruleInstanceMcc truleInstanceMcc) {
        return (TruleInstanceMcc) getHibernateTemplate().merge(truleInstanceMcc);
    }

    /**
     *  删除TruleInstanceMcc对象.
     *  @param pkey TruleInstanceMcc主键.
     */
    public void removeTruleInstanceMcc(java.lang.String pkey) {
        TruleInstanceMcc truleInstanceMcc = getTruleInstanceMcc(pkey);
        getHibernateTemplate().delete(truleInstanceMcc);
    }

    /**
     *  获取TruleInstanceMcc对象列表.
     *  @param  truleInstanceMcc TruleInstanceMcc对象
     *  @return List.
     */
    public List getTruleInstanceMccList(TruleInstanceMcc truleInstanceMcc) {
        Criteria criteria = getSession().createCriteria(TruleInstanceMcc.class).add(
                Example.create(truleInstanceMcc));
        if (truleInstanceMcc.getId() != null) {
            criteria.add(Expression.eq("id", truleInstanceMcc.getId()));
        }
        return criteria.list();
    }

    /**
     *  根据查询条件获取TruleInstanceMcc对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getTruleInstanceMccListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TruleInstanceMcc where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(TruleInstanceMcc.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取TruleInstanceMcc对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getTruleInstanceMccListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TruleInstanceMcc where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(TruleInstanceMcc.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤TruleInstanceMcc对象
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

        if (queryMap.get("ruleInstanceId") != null) {
            criteria = criteria.add(Expression.eq("ruleInstanceId", queryMap.get("ruleInstanceId")));
        }
        if (queryMap.get("ruleInstanceId_like") != null) {
            criteria = criteria.add(Expression.like("ruleInstanceId", "%" + queryMap.get("ruleInstanceId_like") + "%"));
        }

        if (queryMap.get("param1") != null) {
            criteria = criteria.add(Expression.eq("param1", queryMap.get("param1")));
        }
        if (queryMap.get("param1_like") != null) {
            criteria = criteria.add(Expression.like("param1", "%" + queryMap.get("param1_like") + "%"));
        }

        if (queryMap.get("param2") != null) {
            criteria = criteria.add(Expression.eq("param2", queryMap.get("param2")));
        }
        if (queryMap.get("param2_like") != null) {
            criteria = criteria.add(Expression.like("param2", "%" + queryMap.get("param2_like") + "%"));
        }

        if (queryMap.get("param3") != null) {
            criteria = criteria.add(Expression.eq("param3", queryMap.get("param3")));
        }
        if (queryMap.get("param3_like") != null) {
            criteria = criteria.add(Expression.like("param3", "%" + queryMap.get("param3_like") + "%"));
        }

        if (queryMap.get("param4") != null) {
            criteria = criteria.add(Expression.eq("param4", queryMap.get("param4")));
        }
        if (queryMap.get("param4_like") != null) {
            criteria = criteria.add(Expression.like("param4", "%" + queryMap.get("param4_like") + "%"));
        }

        if (queryMap.get("mccCode") != null) {
            criteria = criteria.add(Expression.eq("mccCode", queryMap.get("mccCode")));
        }
        if (queryMap.get("mccCode_like") != null) {
            criteria = criteria.add(Expression.like("mccCode", "%" + queryMap.get("mccCode_like") + "%"));
        }

        if (queryMap.get("riskThreshold") != null) {
            criteria = criteria.add(Expression.eq("riskThreshold", queryMap.get("riskThreshold")));
        }
        if (queryMap.get("riskThreshold_like") != null) {
            criteria = criteria.add(Expression.like("riskThreshold", "%" + queryMap.get("riskThreshold_like") + "%"));
        }

        if (queryMap.get("bigmccCode") != null) {
            criteria = criteria.add(Expression.eq("bigmccCode", queryMap.get("bigmccCode")));
        }
        if (queryMap.get("bigmccCode_like") != null) {
            criteria = criteria.add(Expression.like("bigmccCode", "%" + queryMap.get("bigmccCode_like") + "%"));
        }
        if (queryMap.get("bigmccCode_min") != null) {
            criteria = criteria.add(Expression.ge("bigmccCode", (String) queryMap.get("bigmccCode_min")));
        }
        if (queryMap.get("bigmccCode_max") != null) {
            criteria = criteria.add(Expression.le("bigmccCode", (String) queryMap.get("bigmccCode_max")));
        }
        if (queryMap.get("mccId") != null) {
            criteria = criteria.add(Expression.eq("mccId", queryMap.get("mccId")));
        }
        if (queryMap.get("mccId_like") != null) {
            criteria = criteria.add(Expression.like("mccId", "%" + queryMap.get("mccId_like") + "%"));
        }


        //根据查询queryMap的键值，提供排序功能,_order="域名1 asc|desc,域名2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
    public void rollback(){
    	getHibernateTemplate().getSessionFactory().getCurrentSession().getTransaction().rollback();
    }
}
