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

import cn.com.brilliance.begen.dao.SysTransmitDetailDAO;
import cn.com.brilliance.begen.model.SysTransmitDetail;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysTransmitDetailDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class SysTransmitDetailDAOHibernate extends BeGenHibernateDaoSupport implements SysTransmitDetailDAO {    

    /**
     *  �����������SysTransmitDetail����.
     *  @param pkey SysTransmitDetail����
     *  @return SysTransmitDetail.
     */
    public SysTransmitDetail getSysTransmitDetail(java.lang.String pkey) {
        SysTransmitDetail sysTransmitDetail = (SysTransmitDetail) getHibernateTemplate().get(SysTransmitDetail.class, pkey);
        if (sysTransmitDetail == null) {
            return sysTransmitDetail;
        }
        return sysTransmitDetail;

    }

    /**
     *  �洢SysTransmitDetail����.
     *  @param  sysTransmitDetail SysTransmitDetail����
     *  @return SysTransmitDetail.
     */
    public SysTransmitDetail saveSysTransmitDetail(SysTransmitDetail sysTransmitDetail) {
        return (SysTransmitDetail) getHibernateTemplate().merge(sysTransmitDetail);
    }

    /**
     *  ɾ��SysTransmitDetail����.
     *  @param pkey SysTransmitDetail����.
     */
    public void removeSysTransmitDetail(java.lang.String pkey) {
        SysTransmitDetail sysTransmitDetail = getSysTransmitDetail(pkey);
        getHibernateTemplate().delete(sysTransmitDetail);
    }

    /**
     *  ��ȡSysTransmitDetail�����б�.
     *  @param  sysTransmitDetail SysTransmitDetail����
     *  @return List.
     */
    public List getSysTransmitDetailList(SysTransmitDetail sysTransmitDetail) {
        Criteria criteria = getSession().createCriteria(SysTransmitDetail.class).add(
                Example.create(sysTransmitDetail));
        if (sysTransmitDetail.getId() != null) {
            criteria.add(Expression.eq("id", sysTransmitDetail.getId()));
        }
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡSysTransmitDetail�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysTransmitDetailListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysTransmitDetail where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysTransmitDetail.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡSysTransmitDetail�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysTransmitDetailListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysTransmitDetail where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysTransmitDetail.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������SysTransmitDetail����
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

        if (queryMap.get("transmitId") != null) {
            criteria = criteria.add(Expression.eq("transmitId", queryMap.get("transmitId")));
        }
        if (queryMap.get("transmitId_like") != null) {
            criteria = criteria.add(Expression.like("transmitId", "%" + queryMap.get("transmitId_like") + "%"));
        }

        if (queryMap.get("readFlag") != null) {
            criteria = criteria.add(Expression.eq("readFlag", new Boolean((String) queryMap.get("readFlag"))));
        }
        if (queryMap.get("advice") != null) {
            criteria = criteria.add(Expression.eq("advice", queryMap.get("advice")));
        }
        if (queryMap.get("advice_like") != null) {
            criteria = criteria.add(Expression.like("advice", "%" + queryMap.get("advice_like") + "%"));
        }

        if (queryMap.get("transmitTime") != null) {
            criteria = criteria.add(Expression.eq("transmitTime", java.sql.Date.valueOf((String) queryMap.get("transmitTime"))));
        }
        if (queryMap.get("transmitTime_min") != null) {
            criteria = criteria.add(Expression.ge("transmitTime", java.sql.Date.valueOf((String) queryMap.get("transmitTime_min"))));
        }
        if (queryMap.get("transmitTime_max") != null) {
            criteria = criteria.add(Expression.le("transmitTime", java.sql.Date.valueOf((String) queryMap.get("transmitTime_max"))));
        }
        if (queryMap.get("receiver") != null) {
            criteria = criteria.add(Expression.eq("receiver", queryMap.get("receiver")));
        }
        if (queryMap.get("receiver_like") != null) {
            criteria = criteria.add(Expression.like("receiver", "%" + queryMap.get("receiver_like") + "%"));
        }


        //���ݲ�ѯqueryMap�ļ�ֵ���ṩ������,_order="����1 asc|desc,����2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
