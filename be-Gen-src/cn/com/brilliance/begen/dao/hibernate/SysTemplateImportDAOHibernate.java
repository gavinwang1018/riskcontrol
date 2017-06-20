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

import cn.com.brilliance.begen.dao.SysTemplateImportDAO;
import cn.com.brilliance.begen.model.SysTemplateImport;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysTemplateImportDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class SysTemplateImportDAOHibernate extends BeGenHibernateDaoSupport implements SysTemplateImportDAO {    

    /**
     *  �����������SysTemplateImport����.
     *  @param pkey SysTemplateImport����
     *  @return SysTemplateImport.
     */
    public SysTemplateImport getSysTemplateImport(java.lang.String pkey) {
        SysTemplateImport sysTemplateImport = (SysTemplateImport) getHibernateTemplate().get(SysTemplateImport.class, pkey);
        if (sysTemplateImport == null) {
            return sysTemplateImport;
        }
        return sysTemplateImport;

    }

    /**
     *  �洢SysTemplateImport����.
     *  @param  sysTemplateImport SysTemplateImport����
     *  @return SysTemplateImport.
     */
    public SysTemplateImport saveSysTemplateImport(SysTemplateImport sysTemplateImport) {
        return (SysTemplateImport) getHibernateTemplate().merge(sysTemplateImport);
    }

    /**
     *  ɾ��SysTemplateImport����.
     *  @param pkey SysTemplateImport����.
     */
    public void removeSysTemplateImport(java.lang.String pkey) {
        SysTemplateImport sysTemplateImport = getSysTemplateImport(pkey);
        getHibernateTemplate().delete(sysTemplateImport);
    }

    /**
     *  ��ȡSysTemplateImport�����б�.
     *  @param  sysTemplateImport SysTemplateImport����
     *  @return List.
     */
    public List getSysTemplateImportList(SysTemplateImport sysTemplateImport) {
        Criteria criteria = getSession().createCriteria(SysTemplateImport.class).add(
                Example.create(sysTemplateImport));
        if (sysTemplateImport.getId() != null) {
            criteria.add(Expression.eq("id", sysTemplateImport.getId()));
        }
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡSysTemplateImport�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysTemplateImportListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysTemplateImport where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysTemplateImport.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡSysTemplateImport�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysTemplateImportListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysTemplateImport where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysTemplateImport.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������SysTemplateImport����
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

        if (queryMap.get("partyId") != null) {
            criteria = criteria.add(Expression.eq("partyId", queryMap.get("partyId")));
        }
        if (queryMap.get("partyId_like") != null) {
            criteria = criteria.add(Expression.like("partyId", "%" + queryMap.get("partyId_like") + "%"));
        }

        if (queryMap.get("importDate") != null) {
            criteria = criteria.add(Expression.eq("importDate", java.sql.Date.valueOf((String) queryMap.get("importDate"))));
        }
        if (queryMap.get("importDate_min") != null) {
            criteria = criteria.add(Expression.ge("importDate", java.sql.Date.valueOf((String) queryMap.get("importDate_min"))));
        }
        if (queryMap.get("importDate_max") != null) {
            criteria = criteria.add(Expression.le("importDate", java.sql.Date.valueOf((String) queryMap.get("importDate_max"))));
        }
        if (queryMap.get("templateId") != null) {
            criteria = criteria.add(Expression.eq("templateId", queryMap.get("templateId")));
        }
        if (queryMap.get("templateId_like") != null) {
            criteria = criteria.add(Expression.like("templateId", "%" + queryMap.get("templateId_like") + "%"));
        }


        //���ݲ�ѯqueryMap�ļ�ֵ���ṩ������,_order="����1 asc|desc,����2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
