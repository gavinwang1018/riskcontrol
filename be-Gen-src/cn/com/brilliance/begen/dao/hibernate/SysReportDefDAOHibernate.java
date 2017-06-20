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

import cn.com.brilliance.begen.dao.SysReportDefDAO;
import cn.com.brilliance.begen.model.SysReportDef;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysReportDefDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class SysReportDefDAOHibernate extends BeGenHibernateDaoSupport implements SysReportDefDAO {    

    /**
     *  �����������SysReportDef����.
     *  @param pkey SysReportDef����
     *  @return SysReportDef.
     */
    public SysReportDef getSysReportDef(java.lang.String pkey) {
        SysReportDef sysReportDef = (SysReportDef) getHibernateTemplate().get(SysReportDef.class, pkey);
        if (sysReportDef == null) {
            return sysReportDef;
        }
        return sysReportDef;

    }

    /**
     *  �洢SysReportDef����.
     *  @param  sysReportDef SysReportDef����
     *  @return SysReportDef.
     */
    public SysReportDef saveSysReportDef(SysReportDef sysReportDef) {
        return (SysReportDef) getHibernateTemplate().merge(sysReportDef);
    }

    /**
     *  ɾ��SysReportDef����.
     *  @param pkey SysReportDef����.
     */
    public void removeSysReportDef(java.lang.String pkey) {
        SysReportDef sysReportDef = getSysReportDef(pkey);
        getHibernateTemplate().delete(sysReportDef);
    }

    /**
     *  ��ȡSysReportDef�����б�.
     *  @param  sysReportDef SysReportDef����
     *  @return List.
     */
    public List getSysReportDefList(SysReportDef sysReportDef) {
        Criteria criteria = getSession().createCriteria(SysReportDef.class).add(
                Example.create(sysReportDef));
        if (sysReportDef.getId() != null) {
            criteria.add(Expression.eq("id", sysReportDef.getId()));
        }
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡSysReportDef�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysReportDefListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysReportDef where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysReportDef.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡSysReportDef�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysReportDefListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysReportDef where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysReportDef.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������SysReportDef����
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

        if (queryMap.get("reportName") != null) {
            criteria = criteria.add(Expression.eq("reportName", queryMap.get("reportName")));
        }
        if (queryMap.get("reportName_like") != null) {
            criteria = criteria.add(Expression.like("reportName", "%" + queryMap.get("reportName_like") + "%"));
        }

        if (queryMap.get("dataObject") != null) {
            criteria = criteria.add(Expression.eq("dataObject", queryMap.get("dataObject")));
        }
        if (queryMap.get("dataObject_like") != null) {
            criteria = criteria.add(Expression.like("dataObject", "%" + queryMap.get("dataObject_like") + "%"));
        }

        if (queryMap.get("reportTitle") != null) {
            criteria = criteria.add(Expression.eq("reportTitle", queryMap.get("reportTitle")));
        }
        if (queryMap.get("reportTitle_like") != null) {
            criteria = criteria.add(Expression.like("reportTitle", "%" + queryMap.get("reportTitle_like") + "%"));
        }

        if (queryMap.get("reportType") != null) {
            criteria = criteria.add(Expression.eq("reportType", queryMap.get("reportType")));
        }
        if (queryMap.get("reportType_like") != null) {
            criteria = criteria.add(Expression.like("reportType", "%" + queryMap.get("reportType_like") + "%"));
        }

        if (queryMap.get("chartTitle") != null) {
            criteria = criteria.add(Expression.eq("chartTitle", queryMap.get("chartTitle")));
        }
        if (queryMap.get("chartTitle_like") != null) {
            criteria = criteria.add(Expression.like("chartTitle", "%" + queryMap.get("chartTitle_like") + "%"));
        }

        if (queryMap.get("chartSeries") != null) {
            criteria = criteria.add(Expression.eq("chartSeries", queryMap.get("chartSeries")));
        }
        if (queryMap.get("chartSeries_like") != null) {
            criteria = criteria.add(Expression.like("chartSeries", "%" + queryMap.get("chartSeries_like") + "%"));
        }

        if (queryMap.get("category") != null) {
            criteria = criteria.add(Expression.eq("category", queryMap.get("category")));
        }
        if (queryMap.get("category_like") != null) {
            criteria = criteria.add(Expression.like("category", "%" + queryMap.get("category_like") + "%"));
        }

        if (queryMap.get("partyId") != null) {
            criteria = criteria.add(Expression.eq("partyId", queryMap.get("partyId")));
        }
        if (queryMap.get("partyId_like") != null) {
            criteria = criteria.add(Expression.like("partyId", "%" + queryMap.get("partyId_like") + "%"));
        }

        if (queryMap.get("exportFormat") != null) {
            criteria = criteria.add(Expression.eq("exportFormat", queryMap.get("exportFormat")));
        }
        if (queryMap.get("exportFormat_like") != null) {
            criteria = criteria.add(Expression.like("exportFormat", "%" + queryMap.get("exportFormat_like") + "%"));
        }

        if (queryMap.get("chartType") != null) {
            criteria = criteria.add(Expression.eq("chartType", queryMap.get("chartType")));
        }
        if (queryMap.get("chartType_like") != null) {
            criteria = criteria.add(Expression.like("chartType", "%" + queryMap.get("chartType_like") + "%"));
        }

        if (queryMap.get("dataValue") != null) {
            criteria = criteria.add(Expression.eq("dataValue", queryMap.get("dataValue")));
        }
        if (queryMap.get("dataValue_like") != null) {
            criteria = criteria.add(Expression.like("dataValue", "%" + queryMap.get("dataValue_like") + "%"));
        }


        //���ݲ�ѯqueryMap�ļ�ֵ���ṩ������,_order="����1 asc|desc,����2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
