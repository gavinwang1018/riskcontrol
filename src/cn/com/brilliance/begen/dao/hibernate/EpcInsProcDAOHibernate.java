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

import cn.com.brilliance.begen.dao.EpcInsProcDAO;
import cn.com.brilliance.begen.model.EpcInsProc;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * EpcInsProcDAO接口具体实现类.
 * @author Administrator.
 */

public class EpcInsProcDAOHibernate extends BeGenHibernateDaoSupport implements EpcInsProcDAO {    

    /**
     *  根据主键获得EpcInsProc对象.
     *  @param pkey EpcInsProc主键
     *  @return EpcInsProc.
     */
    public EpcInsProc getEpcInsProc(java.lang.String pkey) {
        EpcInsProc epcInsProc = (EpcInsProc) getHibernateTemplate().get(EpcInsProc.class, pkey);
        if (epcInsProc == null) {
            return epcInsProc;
        }
        return epcInsProc;

    }

    /**
     *  存储EpcInsProc对象.
     *  @param  epcInsProc EpcInsProc对象
     *  @return EpcInsProc.
     */
    public EpcInsProc saveEpcInsProc(EpcInsProc epcInsProc) {
        return (EpcInsProc) getHibernateTemplate().merge(epcInsProc);
    }

    /**
     *  删除EpcInsProc对象.
     *  @param pkey EpcInsProc主键.
     */
    public void removeEpcInsProc(java.lang.String pkey) {
        EpcInsProc epcInsProc = getEpcInsProc(pkey);
        getHibernateTemplate().delete(epcInsProc);
    }

    /**
     *  获取EpcInsProc对象列表.
     *  @param  epcInsProc EpcInsProc对象
     *  @return List.
     */
    public List getEpcInsProcList(EpcInsProc epcInsProc) {
        Criteria criteria = getSession().createCriteria(EpcInsProc.class).add(
                Example.create(epcInsProc));
        if (epcInsProc.getId() != null) {
            criteria.add(Expression.eq("id", epcInsProc.getId()));
        }
        return criteria.list();
    }

    /**
     *  根据查询条件获取EpcInsProc对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getEpcInsProcListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.EpcInsProc where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(EpcInsProc.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取EpcInsProc对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getEpcInsProcListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.EpcInsProc where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(EpcInsProc.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤EpcInsProc对象
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

        if (queryMap.get("processDefId") != null) {
            criteria = criteria.add(Expression.eq("processDefId", queryMap.get("processDefId")));
        }
        if (queryMap.get("processDefId_like") != null) {
            criteria = criteria.add(Expression.like("processDefId", "%" + queryMap.get("processDefId_like") + "%"));
        }

        if (queryMap.get("processState") != null) {
            criteria = criteria.add(Expression.eq("processState", queryMap.get("processState")));
        }
        if (queryMap.get("processState_like") != null) {
            criteria = criteria.add(Expression.like("processState", "%" + queryMap.get("processState_like") + "%"));
        }

        if (queryMap.get("processStart") != null) {
            criteria = criteria.add(Expression.eq("processStart", java.sql.Date.valueOf((String) queryMap.get("processStart"))));
        }
        if (queryMap.get("processStart_min") != null) {
            criteria = criteria.add(Expression.ge("processStart", java.sql.Date.valueOf((String) queryMap.get("processStart_min"))));
        }
        if (queryMap.get("processStart_max") != null) {
            criteria = criteria.add(Expression.le("processStart", java.sql.Date.valueOf((String) queryMap.get("processStart_max"))));
        }
        if (queryMap.get("processEnd") != null) {
            criteria = criteria.add(Expression.eq("processEnd", java.sql.Date.valueOf((String) queryMap.get("processEnd"))));
        }
        if (queryMap.get("processEnd_min") != null) {
            criteria = criteria.add(Expression.ge("processEnd", java.sql.Date.valueOf((String) queryMap.get("processEnd_min"))));
        }
        if (queryMap.get("processEnd_max") != null) {
            criteria = criteria.add(Expression.le("processEnd", java.sql.Date.valueOf((String) queryMap.get("processEnd_max"))));
        }
        if (queryMap.get("dataObject") != null) {
            criteria = criteria.add(Expression.eq("dataObject", queryMap.get("dataObject")));
        }
        if (queryMap.get("dataObject_like") != null) {
            criteria = criteria.add(Expression.like("dataObject", "%" + queryMap.get("dataObject_like") + "%"));
        }

        if (queryMap.get("dataObjectKey") != null) {
            criteria = criteria.add(Expression.eq("dataObjectKey", queryMap.get("dataObjectKey")));
        }
        if (queryMap.get("dataObjectKey_like") != null) {
            criteria = criteria.add(Expression.like("dataObjectKey", "%" + queryMap.get("dataObjectKey_like") + "%"));
        }


        //根据查询queryMap的键值，提供排序功能,_order="域名1 asc|desc,域名2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
