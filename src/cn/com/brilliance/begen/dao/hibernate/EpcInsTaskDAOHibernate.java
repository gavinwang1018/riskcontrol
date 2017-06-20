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

import cn.com.brilliance.begen.dao.EpcInsTaskDAO;
import cn.com.brilliance.begen.model.EpcInsTask;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * EpcInsTaskDAO接口具体实现类.
 * @author Administrator.
 */

public class EpcInsTaskDAOHibernate extends BeGenHibernateDaoSupport implements EpcInsTaskDAO {    

    /**
     *  根据主键获得EpcInsTask对象.
     *  @param pkey EpcInsTask主键
     *  @return EpcInsTask.
     */
    public EpcInsTask getEpcInsTask(java.lang.String pkey) {
        EpcInsTask epcInsTask = (EpcInsTask) getHibernateTemplate().get(EpcInsTask.class, pkey);
        if (epcInsTask == null) {
            return epcInsTask;
        }
        return epcInsTask;

    }

    /**
     *  存储EpcInsTask对象.
     *  @param  epcInsTask EpcInsTask对象
     *  @return EpcInsTask.
     */
    public EpcInsTask saveEpcInsTask(EpcInsTask epcInsTask) {
        return (EpcInsTask) getHibernateTemplate().merge(epcInsTask);
    }

    /**
     *  删除EpcInsTask对象.
     *  @param pkey EpcInsTask主键.
     */
    public void removeEpcInsTask(java.lang.String pkey) {
        EpcInsTask epcInsTask = getEpcInsTask(pkey);
        getHibernateTemplate().delete(epcInsTask);
    }

    /**
     *  获取EpcInsTask对象列表.
     *  @param  epcInsTask EpcInsTask对象
     *  @return List.
     */
    public List getEpcInsTaskList(EpcInsTask epcInsTask) {
        Criteria criteria = getSession().createCriteria(EpcInsTask.class).add(
                Example.create(epcInsTask));
        if (epcInsTask.getId() != null) {
            criteria.add(Expression.eq("id", epcInsTask.getId()));
        }
        return criteria.list();
    }

    /**
     *  根据查询条件获取EpcInsTask对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getEpcInsTaskListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.EpcInsTask where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(EpcInsTask.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取EpcInsTask对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getEpcInsTaskListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.EpcInsTask where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(EpcInsTask.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤EpcInsTask对象
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

        if (queryMap.get("processInsId") != null) {
            criteria = criteria.add(Expression.eq("processInsId", queryMap.get("processInsId")));
        }
        if (queryMap.get("processInsId_like") != null) {
            criteria = criteria.add(Expression.like("processInsId", "%" + queryMap.get("processInsId_like") + "%"));
        }

        if (queryMap.get("stateDefId") != null) {
            criteria = criteria.add(Expression.eq("stateDefId", queryMap.get("stateDefId")));
        }
        if (queryMap.get("stateDefId_like") != null) {
            criteria = criteria.add(Expression.like("stateDefId", "%" + queryMap.get("stateDefId_like") + "%"));
        }

        if (queryMap.get("taskTitle") != null) {
            criteria = criteria.add(Expression.eq("taskTitle", queryMap.get("taskTitle")));
        }
        if (queryMap.get("taskTitle_like") != null) {
            criteria = criteria.add(Expression.like("taskTitle", "%" + queryMap.get("taskTitle_like") + "%"));
        }

        if (queryMap.get("operator") != null) {
            criteria = criteria.add(Expression.eq("operator", queryMap.get("operator")));
        }
        if (queryMap.get("operator_like") != null) {
            criteria = criteria.add(Expression.like("operator", "%" + queryMap.get("operator_like") + "%"));
        }

        if (queryMap.get("taskOperator") != null) {
            criteria = criteria.add(Expression.eq("taskOperator", queryMap.get("taskOperator")));
        }
        if (queryMap.get("taskOperator_like") != null) {
            criteria = criteria.add(Expression.like("taskOperator", "%" + queryMap.get("taskOperator_like") + "%"));
        }

        if (queryMap.get("instanceStart") != null) {
            criteria = criteria.add(Expression.eq("instanceStart", java.sql.Date.valueOf((String) queryMap.get("instanceStart"))));
        }
        if (queryMap.get("instanceStart_min") != null) {
            criteria = criteria.add(Expression.ge("instanceStart", java.sql.Date.valueOf((String) queryMap.get("instanceStart_min"))));
        }
        if (queryMap.get("instanceStart_max") != null) {
            criteria = criteria.add(Expression.le("instanceStart", java.sql.Date.valueOf((String) queryMap.get("instanceStart_max"))));
        }
        if (queryMap.get("instanceEnd") != null) {
            criteria = criteria.add(Expression.eq("instanceEnd", java.sql.Date.valueOf((String) queryMap.get("instanceEnd"))));
        }
        if (queryMap.get("instanceEnd_min") != null) {
            criteria = criteria.add(Expression.ge("instanceEnd", java.sql.Date.valueOf((String) queryMap.get("instanceEnd_min"))));
        }
        if (queryMap.get("instanceEnd_max") != null) {
            criteria = criteria.add(Expression.le("instanceEnd", java.sql.Date.valueOf((String) queryMap.get("instanceEnd_max"))));
        }
        if (queryMap.get("url") != null) {
            criteria = criteria.add(Expression.eq("url", queryMap.get("url")));
        }
        if (queryMap.get("url_like") != null) {
            criteria = criteria.add(Expression.like("url", "%" + queryMap.get("url_like") + "%"));
        }

        if (queryMap.get("instanceState") != null) {
            criteria = criteria.add(Expression.eq("instanceState", queryMap.get("instanceState")));
        }
        if (queryMap.get("instanceState_like") != null) {
            criteria = criteria.add(Expression.like("instanceState", "%" + queryMap.get("instanceState_like") + "%"));
        }

        if (queryMap.get("receiptOrg") != null) {
            criteria = criteria.add(Expression.eq("receiptOrg", queryMap.get("receiptOrg")));
        }
        if (queryMap.get("receiptOrg_like") != null) {
            criteria = criteria.add(Expression.like("receiptOrg", "%" + queryMap.get("receiptOrg_like") + "%"));
        }

        if (queryMap.get("receiptRole") != null) {
            criteria = criteria.add(Expression.eq("receiptRole", queryMap.get("receiptRole")));
        }
        if (queryMap.get("receiptRole_like") != null) {
            criteria = criteria.add(Expression.like("receiptRole", "%" + queryMap.get("receiptRole_like") + "%"));
        }

        if (queryMap.get("receiptUser") != null) {
            criteria = criteria.add(Expression.eq("receiptUser", queryMap.get("receiptUser")));
        }
        if (queryMap.get("receiptUser_like") != null) {
            criteria = criteria.add(Expression.like("receiptUser", "%" + queryMap.get("receiptUser_like") + "%"));
        }


        //根据查询queryMap的键值，提供排序功能,_order="域名1 asc|desc,域名2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
