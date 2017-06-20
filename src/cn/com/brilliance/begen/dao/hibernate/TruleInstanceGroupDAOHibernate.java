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

import cn.com.brilliance.begen.dao.TruleInstanceGroupDAO;
import cn.com.brilliance.begen.model.TruleInstanceGroup;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * TruleInstanceGroupDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class TruleInstanceGroupDAOHibernate extends BeGenHibernateDaoSupport implements TruleInstanceGroupDAO {    

    /**
     *  �����������TruleInstanceGroup����.
     *  @param pkey TruleInstanceGroup����
     *  @return TruleInstanceGroup.
     */
    public TruleInstanceGroup getTruleInstanceGroup(java.lang.String pkey) {
        TruleInstanceGroup truleInstanceGroup = (TruleInstanceGroup) getHibernateTemplate().get(TruleInstanceGroup.class, pkey);
        if (truleInstanceGroup == null) {
            return truleInstanceGroup;
        }
        return truleInstanceGroup;

    }

    /**
     *  �洢TruleInstanceGroup����.
     *  @param  truleInstanceGroup TruleInstanceGroup����
     *  @return TruleInstanceGroup.
     */
    public TruleInstanceGroup saveTruleInstanceGroup(TruleInstanceGroup truleInstanceGroup) {
        return (TruleInstanceGroup) getHibernateTemplate().merge(truleInstanceGroup);
    }

    /**
     *  ɾ��TruleInstanceGroup����.
     *  @param pkey TruleInstanceGroup����.
     */
    public void removeTruleInstanceGroup(java.lang.String pkey) {
        TruleInstanceGroup truleInstanceGroup = getTruleInstanceGroup(pkey);
        getHibernateTemplate().delete(truleInstanceGroup);
    }

    /**
     *  ��ȡTruleInstanceGroup�����б�.
     *  @param  truleInstanceGroup TruleInstanceGroup����
     *  @return List.
     */
    public List getTruleInstanceGroupList(TruleInstanceGroup truleInstanceGroup) {
        Criteria criteria = getSession().createCriteria(TruleInstanceGroup.class).add(
                Example.create(truleInstanceGroup));
        if (truleInstanceGroup.getId() != null) {
            criteria.add(Expression.eq("id", truleInstanceGroup.getId()));
        }
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡTruleInstanceGroup�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getTruleInstanceGroupListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TruleInstanceGroup where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(TruleInstanceGroup.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡTruleInstanceGroup�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getTruleInstanceGroupListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TruleInstanceGroup where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(TruleInstanceGroup.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������TruleInstanceGroup����
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

        if (queryMap.get("ruleGroupId") != null) {
            criteria = criteria.add(Expression.eq("ruleGroupId", queryMap.get("ruleGroupId")));
        }
        if (queryMap.get("ruleGroupId_like") != null) {
            criteria = criteria.add(Expression.like("ruleGroupId", "%" + queryMap.get("ruleGroupId_like") + "%"));
        }

        if (queryMap.get("ruleInstanceId") != null) {
            criteria = criteria.add(Expression.eq("ruleInstanceId", queryMap.get("ruleInstanceId")));
        }
        if (queryMap.get("ruleInstanceId_like") != null) {
            criteria = criteria.add(Expression.like("ruleInstanceId", "%" + queryMap.get("ruleInstanceId_like") + "%"));
        }


        //���ݲ�ѯqueryMap�ļ�ֵ���ṩ������,_order="����1 asc|desc,����2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
