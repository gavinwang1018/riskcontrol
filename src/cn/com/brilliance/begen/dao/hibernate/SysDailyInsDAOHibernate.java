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

import cn.com.brilliance.begen.dao.SysDailyInsDAO;
import cn.com.brilliance.begen.model.SysDailyIns;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysDailyInsDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class SysDailyInsDAOHibernate extends BeGenHibernateDaoSupport implements SysDailyInsDAO {    

    /**
     *  �����������SysDailyIns����.
     *  @param pkey SysDailyIns����
     *  @return SysDailyIns.
     */
    public SysDailyIns getSysDailyIns(java.lang.String pkey) {
        SysDailyIns sysDailyIns = (SysDailyIns) getHibernateTemplate().get(SysDailyIns.class, pkey);
        if (sysDailyIns == null) {
            return sysDailyIns;
        }
        return sysDailyIns;

    }

    /**
     *  �洢SysDailyIns����.
     *  @param  sysDailyIns SysDailyIns����
     *  @return SysDailyIns.
     */
    public SysDailyIns saveSysDailyIns(SysDailyIns sysDailyIns) {
        return (SysDailyIns) getHibernateTemplate().merge(sysDailyIns);
    }

    /**
     *  ɾ��SysDailyIns����.
     *  @param pkey SysDailyIns����.
     */
    public void removeSysDailyIns(java.lang.String pkey) {
        SysDailyIns sysDailyIns = getSysDailyIns(pkey);
        getHibernateTemplate().delete(sysDailyIns);
    }

    /**
     *  ��ȡSysDailyIns�����б�.
     *  @param  sysDailyIns SysDailyIns����
     *  @return List.
     */
    public List getSysDailyInsList(SysDailyIns sysDailyIns) {
        Criteria criteria = getSession().createCriteria(SysDailyIns.class).add(
                Example.create(sysDailyIns));
        if (sysDailyIns.getId() != null) {
            criteria.add(Expression.eq("id", sysDailyIns.getId()));
        }
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡSysDailyIns�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysDailyInsListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysDailyIns where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysDailyIns.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡSysDailyIns�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysDailyInsListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysDailyIns where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysDailyIns.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������SysDailyIns����
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

        if (queryMap.get("eventType") != null) {
            criteria = criteria.add(Expression.eq("eventType", queryMap.get("eventType")));
        }
        if (queryMap.get("eventType_like") != null) {
            criteria = criteria.add(Expression.like("eventType", "%" + queryMap.get("eventType_like") + "%"));
        }

        if (queryMap.get("title") != null) {
            criteria = criteria.add(Expression.eq("title", queryMap.get("title")));
        }
        if (queryMap.get("title_like") != null) {
            criteria = criteria.add(Expression.like("title", "%" + queryMap.get("title_like") + "%"));
        }

        if (queryMap.get("url") != null) {
            criteria = criteria.add(Expression.eq("url", queryMap.get("url")));
        }
        if (queryMap.get("url_like") != null) {
            criteria = criteria.add(Expression.like("url", "%" + queryMap.get("url_like") + "%"));
        }

        if (queryMap.get("description") != null) {
            criteria = criteria.add(Expression.eq("description", queryMap.get("description")));
        }
        if (queryMap.get("description_like") != null) {
            criteria = criteria.add(Expression.like("description", "%" + queryMap.get("description_like") + "%"));
        }

        if (queryMap.get("defineDate") != null) {
            criteria = criteria.add(Expression.eq("defineDate", java.sql.Date.valueOf((String) queryMap.get("defineDate"))));
        }
        if (queryMap.get("defineDate_min") != null) {
            criteria = criteria.add(Expression.ge("defineDate", java.sql.Date.valueOf((String) queryMap.get("defineDate_min"))));
        }
        if (queryMap.get("defineDate_max") != null) {
            criteria = criteria.add(Expression.le("defineDate", java.sql.Date.valueOf((String) queryMap.get("defineDate_max"))));
        }
        if (queryMap.get("userId") != null) {
            criteria = criteria.add(Expression.eq("userId", queryMap.get("userId")));
        }
        if (queryMap.get("userId_like") != null) {
            criteria = criteria.add(Expression.like("userId", "%" + queryMap.get("userId_like") + "%"));
        }

        if (queryMap.get("shareFlag") != null) {
            criteria = criteria.add(Expression.eq("shareFlag", queryMap.get("shareFlag")));
        }
        if (queryMap.get("shareFlag_like") != null) {
            criteria = criteria.add(Expression.like("shareFlag", "%" + queryMap.get("shareFlag_like") + "%"));
        }

        if (queryMap.get("shareData") != null) {
            criteria = criteria.add(Expression.eq("shareData", queryMap.get("shareData")));
        }
        if (queryMap.get("shareData_like") != null) {
            criteria = criteria.add(Expression.like("shareData", "%" + queryMap.get("shareData_like") + "%"));
        }


        //���ݲ�ѯqueryMap�ļ�ֵ���ṩ������,_order="����1 asc|desc,����2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
