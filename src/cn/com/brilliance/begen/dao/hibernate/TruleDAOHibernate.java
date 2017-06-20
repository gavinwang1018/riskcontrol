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

import cn.com.brilliance.begen.dao.TruleDAO;
import cn.com.brilliance.begen.model.Trule;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * TruleDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class TruleDAOHibernate extends BeGenHibernateDaoSupport implements TruleDAO {    

    /**
     *  �����������Trule����.
     *  @param pkey Trule����
     *  @return Trule.
     */
    public Trule getTrule(java.lang.String pkey) {
        Trule trule = (Trule) getHibernateTemplate().get(Trule.class, pkey);
        if (trule == null) {
            return trule;
        }
        return trule;

    }

    /**
     *  �洢Trule����.
     *  @param  trule Trule����
     *  @return Trule.
     */
    public Trule saveTrule(Trule trule) {
        return (Trule) getHibernateTemplate().merge(trule);
    }

    /**
     *  ɾ��Trule����.
     *  @param pkey Trule����.
     */
    public void removeTrule(java.lang.String pkey) {
        Trule trule = getTrule(pkey);
        getHibernateTemplate().delete(trule);
    }

    /**
     *  ��ȡTrule�����б�.
     *  @param  trule Trule����
     *  @return List.
     */
    public List getTruleList(Trule trule) {
        Criteria criteria = getSession().createCriteria(Trule.class).add(
                Example.create(trule));
        if (trule.getId() != null) {
            criteria.add(Expression.eq("id", trule.getId()));
        }
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡTrule�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getTruleListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.Trule where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(Trule.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡTrule�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getTruleListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.Trule where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(Trule.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������Trule����
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

        if (queryMap.get("description") != null) {
            criteria = criteria.add(Expression.eq("description", queryMap.get("description")));
        }
        if (queryMap.get("description_like") != null) {
            criteria = criteria.add(Expression.like("description", "%" + queryMap.get("description_like") + "%"));
        }

        if (queryMap.get("supportTrace") != null) {
            criteria = criteria.add(Expression.eq("supportTrace", new Boolean((String) queryMap.get("supportTrace"))));
        }
        if (queryMap.get("transInfo") != null) {
            criteria = criteria.add(Expression.eq("transInfo", new Boolean((String) queryMap.get("transInfo"))));
        }
        if (queryMap.get("type") != null) {
            criteria = criteria.add(Expression.eq("type", queryMap.get("type")));
        }
        if (queryMap.get("type_like") != null) {
            criteria = criteria.add(Expression.like("type", "%" + queryMap.get("type_like") + "%"));
        }

        if (queryMap.get("cycle") != null) {
            criteria = criteria.add(Expression.eq("cycle", queryMap.get("cycle")));
        }
        if (queryMap.get("cycle_like") != null) {
            criteria = criteria.add(Expression.like("cycle", "%" + queryMap.get("cycle_like") + "%"));
        }


        //���ݲ�ѯqueryMap�ļ�ֵ���ṩ������,_order="����1 asc|desc,����2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
