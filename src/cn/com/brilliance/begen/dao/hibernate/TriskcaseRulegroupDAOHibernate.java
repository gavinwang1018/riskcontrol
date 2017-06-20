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
 * TriskcaseRulegroupDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class TriskcaseRulegroupDAOHibernate extends BeGenHibernateDaoSupport implements TriskcaseRulegroupDAO {    

    /**
     *  �����������TriskcaseRulegroup����.
     *  @param pkey TriskcaseRulegroup����
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
     *  �洢TriskcaseRulegroup����.
     *  @param  triskcaseRulegroup TriskcaseRulegroup����
     *  @return TriskcaseRulegroup.
     */
    public TriskcaseRulegroup saveTriskcaseRulegroup(TriskcaseRulegroup triskcaseRulegroup) {
        return (TriskcaseRulegroup) getHibernateTemplate().merge(triskcaseRulegroup);
    }

    /**
     *  ɾ��TriskcaseRulegroup����.
     *  @param pkey TriskcaseRulegroup����.
     */
    public void removeTriskcaseRulegroup(java.lang.String pkey) {
        TriskcaseRulegroup triskcaseRulegroup = getTriskcaseRulegroup(pkey);
        getHibernateTemplate().delete(triskcaseRulegroup);
    }

    /**
     *  ��ȡTriskcaseRulegroup�����б�.
     *  @param  triskcaseRulegroup TriskcaseRulegroup����
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
     *  ���ݲ�ѯ������ȡTriskcaseRulegroup�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
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
     *  ���ݲ�ѯ������ȡTriskcaseRulegroup�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
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
        //���ݲ�ѯqueryMap�ļ�ֵ������TriskcaseRulegroup����
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


        //���ݲ�ѯqueryMap�ļ�ֵ���ṩ������,_order="����1 asc|desc,����2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
