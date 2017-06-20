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

import cn.com.brilliance.begen.dao.TruleInstanceDAO;
import cn.com.brilliance.begen.model.TruleInstance;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * TruleInstanceDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class TruleInstanceDAOHibernate extends BeGenHibernateDaoSupport implements TruleInstanceDAO {    

    /**
     *  �����������TruleInstance����.
     *  @param pkey TruleInstance����
     *  @return TruleInstance.
     */
    public TruleInstance getTruleInstance(java.lang.String pkey) {
        TruleInstance truleInstance = (TruleInstance) getHibernateTemplate().get(TruleInstance.class, pkey);
        if (truleInstance == null) {
            return truleInstance;
        }
        return truleInstance;

    }

    /**
     *  �洢TruleInstance����.
     *  @param  truleInstance TruleInstance����
     *  @return TruleInstance.
     */
    public TruleInstance saveTruleInstance(TruleInstance truleInstance) {
        return (TruleInstance) getHibernateTemplate().merge(truleInstance);
    }

    /**
     *  ɾ��TruleInstance����.
     *  @param pkey TruleInstance����.
     */
    public void removeTruleInstance(java.lang.String pkey) {
        TruleInstance truleInstance = getTruleInstance(pkey);
        getHibernateTemplate().delete(truleInstance);
    }

    /**
     *  ��ȡTruleInstance�����б�.
     *  @param  truleInstance TruleInstance����
     *  @return List.
     */
    public List getTruleInstanceList(TruleInstance truleInstance) {
        Criteria criteria = getSession().createCriteria(TruleInstance.class).add(
                Example.create(truleInstance));
        if (truleInstance.getId() != null) {
            criteria.add(Expression.eq("id", truleInstance.getId()));
        }
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡTruleInstance�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getTruleInstanceListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TruleInstance where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(TruleInstance.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡTruleInstance�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getTruleInstanceListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TruleInstance where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(TruleInstance.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������TruleInstance����
        Object[] keyArray = queryMap.keySet().toArray();  //ת����ѯ�ֶ���keySetΪ����
        //���������飬ȥ����Ӧ��ѯ�ֶ�ֵΪ�յļ�ֵ
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

        if (queryMap.get("enable") != null) {
            criteria = criteria.add(Expression.eq("enable", new Boolean((String) queryMap.get("enable"))));
        }
        if (queryMap.get("description") != null) {
            criteria = criteria.add(Expression.eq("description", queryMap.get("description")));
        }
        if (queryMap.get("description_like") != null) {
            criteria = criteria.add(Expression.like("description", "%" + queryMap.get("description_like") + "%"));
        }

        if (queryMap.get("cycle") != null) {
            criteria = criteria.add(Expression.eq("cycle", queryMap.get("cycle")));
        }
        if (queryMap.get("cycle_like") != null) {
            criteria = criteria.add(Expression.like("cycle", "%" + queryMap.get("cycle_like") + "%"));
        }

        if (queryMap.get("timeParam") != null) {
            criteria = criteria.add(Expression.eq("timeParam", queryMap.get("timeParam")));
        }
        if (queryMap.get("timeParam_like") != null) {
            criteria = criteria.add(Expression.like("timeParam", "%" + queryMap.get("timeParam_like") + "%"));
        }

        if (queryMap.get("needTransInfo") != null) {
            criteria = criteria.add(Expression.eq("needTransInfo", new Boolean((String) queryMap.get("needTransInfo"))));
        }
        if (queryMap.get("supportTrace") != null) {
            criteria = criteria.add(Expression.eq("supportTrace", new Boolean((String) queryMap.get("supportTrace"))));
        }
        if (queryMap.get("type") != null) {
            criteria = criteria.add(Expression.eq("type", queryMap.get("type")));
        }
        if (queryMap.get("type_like") != null) {
            criteria = criteria.add(Expression.like("type", "%" + queryMap.get("type_like") + "%"));
        }

        if (queryMap.get("versionBm") != null) {
            criteria = criteria.add(Expression.eq("versionBm", queryMap.get("versionBm")));
        }
        if (queryMap.get("versionBm_like") != null) {
            criteria = criteria.add(Expression.like("versionBm", "%" + queryMap.get("versionBm_like") + "%"));
        }

        if (queryMap.get("transInfo") != null) {
            criteria = criteria.add(Expression.eq("transInfo", new Boolean((String) queryMap.get("transInfo"))));
        }
        if (queryMap.get("code") != null) {
            criteria = criteria.add(Expression.eq("code", queryMap.get("code")));
        }
        if (queryMap.get("code_like") != null) {
            criteria = criteria.add(Expression.like("code", "%" + queryMap.get("code_like") + "%"));
        }

        if (queryMap.get("beginTraceDate") != null) {
            criteria = criteria.add(Expression.eq("beginTraceDate", java.sql.Date.valueOf((String) queryMap.get("beginTraceDate"))));
        }
        if (queryMap.get("beginTraceDate_min") != null) {
            criteria = criteria.add(Expression.ge("beginTraceDate", java.sql.Date.valueOf((String) queryMap.get("beginTraceDate_min"))));
        }
        if (queryMap.get("beginTraceDate_max") != null) {
            criteria = criteria.add(Expression.le("beginTraceDate", java.sql.Date.valueOf((String) queryMap.get("beginTraceDate_max"))));
        }
        if (queryMap.get("belongToInst") != null) {
            criteria = criteria.add(Expression.eq("belongToInst", queryMap.get("belongToInst")));
        }
        if (queryMap.get("belongToInst_like") != null) {
            criteria = criteria.add(Expression.like("belongToInst", "%" + queryMap.get("belongToInst_like") + "%"));
        }

        if (queryMap.get("endTraceDate") != null) {
            criteria = criteria.add(Expression.eq("endTraceDate", java.sql.Date.valueOf((String) queryMap.get("endTraceDate"))));
        }
        if (queryMap.get("endTraceDate_min") != null) {
            criteria = criteria.add(Expression.ge("endTraceDate", java.sql.Date.valueOf((String) queryMap.get("endTraceDate_min"))));
        }
        if (queryMap.get("endTraceDate_max") != null) {
            criteria = criteria.add(Expression.le("endTraceDate", java.sql.Date.valueOf((String) queryMap.get("endTraceDate_max"))));
        }

        //���ݲ�ѯqueryMap�ļ�ֵ���ṩ������,_order="����1 asc|desc,����2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
    
    /**
     * ����ع�
     */
    public void rollback(){
    	getHibernateTemplate().getSessionFactory().getCurrentSession().getTransaction().rollback();
    }
}
