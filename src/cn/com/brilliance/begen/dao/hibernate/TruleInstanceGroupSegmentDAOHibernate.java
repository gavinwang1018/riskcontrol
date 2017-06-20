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

import cn.com.brilliance.begen.dao.TruleInstanceGroupSegmentDAO;
import cn.com.brilliance.begen.model.TruleInstanceGroupSegment;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * TruleInstanceGroupSegmentDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class TruleInstanceGroupSegmentDAOHibernate extends BeGenHibernateDaoSupport implements TruleInstanceGroupSegmentDAO {    

    /**
     *  �����������TruleInstanceGroupSegment����.
     *  @param pkey TruleInstanceGroupSegment����
     *  @return TruleInstanceGroupSegment.
     */
    public TruleInstanceGroupSegment getTruleInstanceGroupSegment(java.lang.String pkey) {
        TruleInstanceGroupSegment truleInstanceGroupSegment = (TruleInstanceGroupSegment) getHibernateTemplate().get(TruleInstanceGroupSegment.class, pkey);
        if (truleInstanceGroupSegment == null) {
            return truleInstanceGroupSegment;
        }
        return truleInstanceGroupSegment;

    }

    /**
     *  �洢TruleInstanceGroupSegment����.
     *  @param  truleInstanceGroupSegment TruleInstanceGroupSegment����
     *  @return TruleInstanceGroupSegment.
     */
    public TruleInstanceGroupSegment saveTruleInstanceGroupSegment(TruleInstanceGroupSegment truleInstanceGroupSegment) {
        return (TruleInstanceGroupSegment) getHibernateTemplate().merge(truleInstanceGroupSegment);
    }

    /**
     *  ɾ��TruleInstanceGroupSegment����.
     *  @param pkey TruleInstanceGroupSegment����.
     */
    public void removeTruleInstanceGroupSegment(java.lang.String pkey) {
        TruleInstanceGroupSegment truleInstanceGroupSegment = getTruleInstanceGroupSegment(pkey);
        getHibernateTemplate().delete(truleInstanceGroupSegment);
    }

    /**
     *  ��ȡTruleInstanceGroupSegment�����б�.
     *  @param  truleInstanceGroupSegment TruleInstanceGroupSegment����
     *  @return List.
     */
    public List getTruleInstanceGroupSegmentList(TruleInstanceGroupSegment truleInstanceGroupSegment) {
        Criteria criteria = getSession().createCriteria(TruleInstanceGroupSegment.class).add(
                Example.create(truleInstanceGroupSegment));
        if (truleInstanceGroupSegment.getId() != null) {
            criteria.add(Expression.eq("id", truleInstanceGroupSegment.getId()));
        }
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡTruleInstanceGroupSegment�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getTruleInstanceGroupSegmentListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TruleInstanceGroupSegment where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(TruleInstanceGroupSegment.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡTruleInstanceGroupSegment�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getTruleInstanceGroupSegmentListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TruleInstanceGroupSegment where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(TruleInstanceGroupSegment.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������TruleInstanceGroupSegment����
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

        if (queryMap.get("propertion") != null) {
            criteria = criteria.add(Expression.eq("propertion", new Float((String) queryMap.get("propertion"))));
        }
        if (queryMap.get("propertion_min") != null) {
            criteria = criteria.add(Expression.ge("propertion", new Float((String) queryMap.get("propertion_min"))));
        }
        if (queryMap.get("propertion_max") != null) {
            criteria = criteria.add(Expression.le("propertion", new Float((String) queryMap.get("propertion_max"))));
        }
        if (queryMap.get("ruleInstanceGroupId") != null) {
            criteria = criteria.add(Expression.eq("ruleInstanceGroupId", queryMap.get("ruleInstanceGroupId")));
        }
        if (queryMap.get("ruleInstanceGroupId_like") != null) {
            criteria = criteria.add(Expression.like("ruleInstanceGroupId", "%" + queryMap.get("ruleInstanceGroupId_like") + "%"));
        }

        if (queryMap.get("begin") != null) {
            criteria = criteria.add(Expression.eq("begin", new Float((String) queryMap.get("begin"))));
        }
        if (queryMap.get("begin_min") != null) {
            criteria = criteria.add(Expression.ge("begin", new Float((String) queryMap.get("begin_min"))));
        }
        if (queryMap.get("begin_max") != null) {
            criteria = criteria.add(Expression.le("begin", new Float((String) queryMap.get("begin_max"))));
        }
        if (queryMap.get("end") != null) {
            criteria = criteria.add(Expression.eq("end", new Float((String) queryMap.get("end"))));
        }
        if (queryMap.get("end_min") != null) {
            criteria = criteria.add(Expression.ge("end", new Float((String) queryMap.get("end_min"))));
        }
        if (queryMap.get("end_max") != null) {
            criteria = criteria.add(Expression.le("end", new Float((String) queryMap.get("end_max"))));
        }
        if (queryMap.get("ruleInstanceId") != null) {
            criteria = criteria.add(Expression.eq("ruleInstanceId", queryMap.get("ruleInstanceId")));
        }
        if (queryMap.get("ruleInstanceId_like") != null) {
            criteria = criteria.add(Expression.like("ruleInstanceId", "%" + queryMap.get("ruleInstanceId_like") + "%"));
        }

        if (queryMap.get("value") != null) {
            criteria = criteria.add(Expression.eq("value", new Float((String) queryMap.get("value"))));
        }
        if (queryMap.get("value_min") != null) {
            criteria = criteria.add(Expression.ge("value", new Float((String) queryMap.get("value_min"))));
        }
        if (queryMap.get("value_max") != null) {
            criteria = criteria.add(Expression.le("value", new Float((String) queryMap.get("value_max"))));
        }

        //���ݲ�ѯqueryMap�ļ�ֵ���ṩ������,_order="����1 asc|desc,����2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
