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

import cn.com.brilliance.begen.dao.SysReportGroupDefDAO;
import cn.com.brilliance.begen.model.SysReportGroupDef;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysReportGroupDefDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class SysReportGroupDefDAOHibernate extends BeGenHibernateDaoSupport implements SysReportGroupDefDAO {    

    /**
     *  �����������SysReportGroupDef����.
     *  @param pkey SysReportGroupDef����
     *  @return SysReportGroupDef.
     */
    public SysReportGroupDef getSysReportGroupDef(java.lang.String pkey) {
        SysReportGroupDef sysReportGroupDef = (SysReportGroupDef) getHibernateTemplate().get(SysReportGroupDef.class, pkey);
        if (sysReportGroupDef == null) {
            return sysReportGroupDef;
        }
        return sysReportGroupDef;

    }

    /**
     *  �洢SysReportGroupDef����.
     *  @param  sysReportGroupDef SysReportGroupDef����
     *  @return SysReportGroupDef.
     */
    public SysReportGroupDef saveSysReportGroupDef(SysReportGroupDef sysReportGroupDef) {
        return (SysReportGroupDef) getHibernateTemplate().merge(sysReportGroupDef);
    }

    /**
     *  ɾ��SysReportGroupDef����.
     *  @param pkey SysReportGroupDef����.
     */
    public void removeSysReportGroupDef(java.lang.String pkey) {
        SysReportGroupDef sysReportGroupDef = getSysReportGroupDef(pkey);
        getHibernateTemplate().delete(sysReportGroupDef);
    }

    /**
     *  ��ȡSysReportGroupDef�����б�.
     *  @param  sysReportGroupDef SysReportGroupDef����
     *  @return List.
     */
    public List getSysReportGroupDefList(SysReportGroupDef sysReportGroupDef) {
        Criteria criteria = getSession().createCriteria(SysReportGroupDef.class).add(
                Example.create(sysReportGroupDef));
        if (sysReportGroupDef.getId() != null) {
            criteria.add(Expression.eq("id", sysReportGroupDef.getId()));
        }
        criteria.addOrder(Order.asc("sysRecordOrder"));
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡSysReportGroupDef�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysReportGroupDefListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysReportGroupDef where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysReportGroupDef.class);

        criteria.addOrder(Order.asc("sysRecordOrder"));
        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡSysReportGroupDef�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysReportGroupDefListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysReportGroupDef where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysReportGroupDef.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������SysReportGroupDef����
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

        if (queryMap.get("sort") != null) {
            criteria = criteria.add(Expression.eq("sort", queryMap.get("sort")));
        }
        if (queryMap.get("sort_like") != null) {
            criteria = criteria.add(Expression.like("sort", "%" + queryMap.get("sort_like") + "%"));
        }

        if (queryMap.get("label") != null) {
            criteria = criteria.add(Expression.eq("label", queryMap.get("label")));
        }
        if (queryMap.get("label_like") != null) {
            criteria = criteria.add(Expression.like("label", "%" + queryMap.get("label_like") + "%"));
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
