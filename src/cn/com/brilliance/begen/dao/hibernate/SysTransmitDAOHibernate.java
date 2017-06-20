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

import cn.com.brilliance.begen.dao.SysTransmitDAO;
import cn.com.brilliance.begen.model.SysTransmit;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysTransmitDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class SysTransmitDAOHibernate extends BeGenHibernateDaoSupport implements SysTransmitDAO {    

    /**
     *  �����������SysTransmit����.
     *  @param pkey SysTransmit����
     *  @return SysTransmit.
     */
    public SysTransmit getSysTransmit(java.lang.String pkey) {
        SysTransmit sysTransmit = (SysTransmit) getHibernateTemplate().get(SysTransmit.class, pkey);
        if (sysTransmit == null) {
            return sysTransmit;
        }
        return sysTransmit;

    }

    /**
     *  �洢SysTransmit����.
     *  @param  sysTransmit SysTransmit����
     *  @return SysTransmit.
     */
    public SysTransmit saveSysTransmit(SysTransmit sysTransmit) {
        return (SysTransmit) getHibernateTemplate().merge(sysTransmit);
    }

    /**
     *  ɾ��SysTransmit����.
     *  @param pkey SysTransmit����.
     */
    public void removeSysTransmit(java.lang.String pkey) {
        SysTransmit sysTransmit = getSysTransmit(pkey);
        getHibernateTemplate().delete(sysTransmit);
    }

    /**
     *  ��ȡSysTransmit�����б�.
     *  @param  sysTransmit SysTransmit����
     *  @return List.
     */
    public List getSysTransmitList(SysTransmit sysTransmit) {
        Criteria criteria = getSession().createCriteria(SysTransmit.class).add(
                Example.create(sysTransmit));
        if (sysTransmit.getId() != null) {
            criteria.add(Expression.eq("id", sysTransmit.getId()));
        }
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡSysTransmit�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysTransmitListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysTransmit where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysTransmit.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡSysTransmit�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysTransmitListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysTransmit where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysTransmit.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������SysTransmit����
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

        if (queryMap.get("title") != null) {
            criteria = criteria.add(Expression.eq("title", queryMap.get("title")));
        }
        if (queryMap.get("title_like") != null) {
            criteria = criteria.add(Expression.like("title", "%" + queryMap.get("title_like") + "%"));
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

        if (queryMap.get("formLayout") != null) {
            criteria = criteria.add(Expression.eq("formLayout", queryMap.get("formLayout")));
        }
        if (queryMap.get("formLayout_like") != null) {
            criteria = criteria.add(Expression.like("formLayout", "%" + queryMap.get("formLayout_like") + "%"));
        }

        if (queryMap.get("startTime") != null) {
            criteria = criteria.add(Expression.eq("startTime", java.sql.Date.valueOf((String) queryMap.get("startTime"))));
        }
        if (queryMap.get("startTime_min") != null) {
            criteria = criteria.add(Expression.ge("startTime", java.sql.Date.valueOf((String) queryMap.get("startTime_min"))));
        }
        if (queryMap.get("startTime_max") != null) {
            criteria = criteria.add(Expression.le("startTime", java.sql.Date.valueOf((String) queryMap.get("startTime_max"))));
        }
        if (queryMap.get("sender") != null) {
            criteria = criteria.add(Expression.eq("sender", queryMap.get("sender")));
        }
        if (queryMap.get("sender_like") != null) {
            criteria = criteria.add(Expression.like("sender", "%" + queryMap.get("sender_like") + "%"));
        }

        if (queryMap.get("endTime") != null) {
            criteria = criteria.add(Expression.eq("endTime", java.sql.Date.valueOf((String) queryMap.get("endTime"))));
        }
        if (queryMap.get("endTime_min") != null) {
            criteria = criteria.add(Expression.ge("endTime", java.sql.Date.valueOf((String) queryMap.get("endTime_min"))));
        }
        if (queryMap.get("endTime_max") != null) {
            criteria = criteria.add(Expression.le("endTime", java.sql.Date.valueOf((String) queryMap.get("endTime_max"))));
        }
        if (queryMap.get("endFlag") != null) {
            criteria = criteria.add(Expression.eq("endFlag", new Boolean((String) queryMap.get("endFlag"))));
        }

        //���ݲ�ѯqueryMap�ļ�ֵ���ṩ������,_order="����1 asc|desc,����2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
