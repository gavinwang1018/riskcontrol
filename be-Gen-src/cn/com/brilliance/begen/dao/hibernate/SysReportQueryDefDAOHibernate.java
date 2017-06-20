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

import cn.com.brilliance.begen.dao.SysReportQueryDefDAO;
import cn.com.brilliance.begen.model.SysReportQueryDef;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysReportQueryDefDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class SysReportQueryDefDAOHibernate extends BeGenHibernateDaoSupport implements SysReportQueryDefDAO {    

    /**
     *  �����������SysReportQueryDef����.
     *  @param pkey SysReportQueryDef����
     *  @return SysReportQueryDef.
     */
    public SysReportQueryDef getSysReportQueryDef(java.lang.String pkey) {
        SysReportQueryDef sysReportQueryDef = (SysReportQueryDef) getHibernateTemplate().get(SysReportQueryDef.class, pkey);
        if (sysReportQueryDef == null) {
            return sysReportQueryDef;
        }
        return sysReportQueryDef;

    }

    /**
     *  �洢SysReportQueryDef����.
     *  @param  sysReportQueryDef SysReportQueryDef����
     *  @return SysReportQueryDef.
     */
    public SysReportQueryDef saveSysReportQueryDef(SysReportQueryDef sysReportQueryDef) {
        return (SysReportQueryDef) getHibernateTemplate().merge(sysReportQueryDef);
    }

    /**
     *  ɾ��SysReportQueryDef����.
     *  @param pkey SysReportQueryDef����.
     */
    public void removeSysReportQueryDef(java.lang.String pkey) {
        SysReportQueryDef sysReportQueryDef = getSysReportQueryDef(pkey);
        getHibernateTemplate().delete(sysReportQueryDef);
    }

    /**
     *  ��ȡSysReportQueryDef�����б�.
     *  @param  sysReportQueryDef SysReportQueryDef����
     *  @return List.
     */
    public List getSysReportQueryDefList(SysReportQueryDef sysReportQueryDef) {
        Criteria criteria = getSession().createCriteria(SysReportQueryDef.class).add(
                Example.create(sysReportQueryDef));
        if (sysReportQueryDef.getId() != null) {
            criteria.add(Expression.eq("id", sysReportQueryDef.getId()));
        }
        criteria.addOrder(Order.asc("sysRecordOrder"));
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡSysReportQueryDef�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysReportQueryDefListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysReportQueryDef where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysReportQueryDef.class);

        criteria.addOrder(Order.asc("sysRecordOrder"));
        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡSysReportQueryDef�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysReportQueryDefListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysReportQueryDef where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysReportQueryDef.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������SysReportQueryDef����
        Object[] keyArray = queryMap.keySet().toArray();  //ת����ѯ�ֶ���keySetΪ����
        //���������飬ȥ����Ӧ��ѯ�ֶ�ֵΪ�յļ�ֵ
        for (int i = 0; i < keyArray.length; i++) {
            String value = (String) queryMap.get(keyArray[i]);
            if (value == null || value.trim().length() == 0) {
                queryMap.remove(keyArray[i]);
            }
        }

        if (queryMap.get("queryMode") != null) {
            criteria = criteria.add(Expression.eq("queryMode", queryMap.get("queryMode")));
        }
        if (queryMap.get("queryMode_like") != null) {
            criteria = criteria.add(Expression.like("queryMode", "%" + queryMap.get("queryMode_like") + "%"));
        }

        if (queryMap.get("id") != null) {
            criteria = criteria.add(Expression.eq("id", queryMap.get("id")));
        }
        if (queryMap.get("id_like") != null) {
            criteria = criteria.add(Expression.like("id", "%" + queryMap.get("id_like") + "%"));
        }

        if (queryMap.get("partyId") != null) {
            criteria = criteria.add(Expression.eq("partyId", queryMap.get("partyId")));
        }
        if (queryMap.get("partyId_like") != null) {
            criteria = criteria.add(Expression.like("partyId", "%" + queryMap.get("partyId_like") + "%"));
        }

        if (queryMap.get("sysReportDef") != null) {
            criteria = criteria.add(Expression.eq("sysReportDef", queryMap.get("sysReportDef")));
        }
        if (queryMap.get("sysReportDef_like") != null) {
            criteria = criteria.add(Expression.like("sysReportDef", "%" + queryMap.get("sysReportDef_like") + "%"));
        }

        if (queryMap.get("reportField") != null) {
            criteria = criteria.add(Expression.eq("reportField", queryMap.get("reportField")));
        }
        if (queryMap.get("reportField_like") != null) {
            criteria = criteria.add(Expression.like("reportField", "%" + queryMap.get("reportField_like") + "%"));
        }


        //���ݲ�ѯqueryMap�ļ�ֵ���ṩ������,_order="����1 asc|desc,����2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
