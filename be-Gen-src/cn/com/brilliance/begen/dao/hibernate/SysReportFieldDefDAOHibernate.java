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

import cn.com.brilliance.begen.dao.SysReportFieldDefDAO;
import cn.com.brilliance.begen.model.SysReportFieldDef;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysReportFieldDefDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class SysReportFieldDefDAOHibernate extends BeGenHibernateDaoSupport implements SysReportFieldDefDAO {    

    /**
     *  �����������SysReportFieldDef����.
     *  @param pkey SysReportFieldDef����
     *  @return SysReportFieldDef.
     */
    public SysReportFieldDef getSysReportFieldDef(java.lang.String pkey) {
        SysReportFieldDef sysReportFieldDef = (SysReportFieldDef) getHibernateTemplate().get(SysReportFieldDef.class, pkey);
        if (sysReportFieldDef == null) {
            return sysReportFieldDef;
        }
        return sysReportFieldDef;

    }

    /**
     *  �洢SysReportFieldDef����.
     *  @param  sysReportFieldDef SysReportFieldDef����
     *  @return SysReportFieldDef.
     */
    public SysReportFieldDef saveSysReportFieldDef(SysReportFieldDef sysReportFieldDef) {
        return (SysReportFieldDef) getHibernateTemplate().merge(sysReportFieldDef);
    }

    /**
     *  ɾ��SysReportFieldDef����.
     *  @param pkey SysReportFieldDef����.
     */
    public void removeSysReportFieldDef(java.lang.String pkey) {
        SysReportFieldDef sysReportFieldDef = getSysReportFieldDef(pkey);
        getHibernateTemplate().delete(sysReportFieldDef);
    }

    /**
     *  ��ȡSysReportFieldDef�����б�.
     *  @param  sysReportFieldDef SysReportFieldDef����
     *  @return List.
     */
    public List getSysReportFieldDefList(SysReportFieldDef sysReportFieldDef) {
        Criteria criteria = getSession().createCriteria(SysReportFieldDef.class).add(
                Example.create(sysReportFieldDef));
        if (sysReportFieldDef.getId() != null) {
            criteria.add(Expression.eq("id", sysReportFieldDef.getId()));
        }
        criteria.addOrder(Order.asc("sysRecordOrder"));
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡSysReportFieldDef�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysReportFieldDefListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysReportFieldDef where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysReportFieldDef.class);

        criteria.addOrder(Order.asc("sysRecordOrder"));
        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡSysReportFieldDef�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysReportFieldDefListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysReportFieldDef where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysReportFieldDef.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������SysReportFieldDef����
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

        if (queryMap.get("statisticExpression") != null) {
            criteria = criteria.add(Expression.eq("statisticExpression", queryMap.get("statisticExpression")));
        }
        if (queryMap.get("statisticExpression_like") != null) {
            criteria = criteria.add(Expression.like("statisticExpression", "%" + queryMap.get("statisticExpression_like") + "%"));
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
