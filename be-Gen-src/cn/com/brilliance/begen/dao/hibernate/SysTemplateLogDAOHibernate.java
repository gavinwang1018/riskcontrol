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

import cn.com.brilliance.begen.dao.SysTemplateLogDAO;
import cn.com.brilliance.begen.model.SysTemplateLog;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysTemplateLogDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class SysTemplateLogDAOHibernate extends BeGenHibernateDaoSupport implements SysTemplateLogDAO {    

    /**
     *  �����������SysTemplateLog����.
     *  @param pkey SysTemplateLog����
     *  @return SysTemplateLog.
     */
    public SysTemplateLog getSysTemplateLog(java.lang.String pkey) {
        SysTemplateLog sysTemplateLog = (SysTemplateLog) getHibernateTemplate().get(SysTemplateLog.class, pkey);
        if (sysTemplateLog == null) {
            return sysTemplateLog;
        }
        return sysTemplateLog;

    }

    /**
     *  �洢SysTemplateLog����.
     *  @param  sysTemplateLog SysTemplateLog����
     *  @return SysTemplateLog.
     */
    public SysTemplateLog saveSysTemplateLog(SysTemplateLog sysTemplateLog) {
        return (SysTemplateLog) getHibernateTemplate().merge(sysTemplateLog);
    }

    /**
     *  ɾ��SysTemplateLog����.
     *  @param pkey SysTemplateLog����.
     */
    public void removeSysTemplateLog(java.lang.String pkey) {
        SysTemplateLog sysTemplateLog = getSysTemplateLog(pkey);
        getHibernateTemplate().delete(sysTemplateLog);
    }

    /**
     *  ��ȡSysTemplateLog�����б�.
     *  @param  sysTemplateLog SysTemplateLog����
     *  @return List.
     */
    public List getSysTemplateLogList(SysTemplateLog sysTemplateLog) {
        Criteria criteria = getSession().createCriteria(SysTemplateLog.class).add(
                Example.create(sysTemplateLog));
        if (sysTemplateLog.getId() != null) {
            criteria.add(Expression.eq("id", sysTemplateLog.getId()));
        }
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡSysTemplateLog�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysTemplateLogListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysTemplateLog where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysTemplateLog.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡSysTemplateLog�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysTemplateLogListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysTemplateLog where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysTemplateLog.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������SysTemplateLog����
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

        if (queryMap.get("templateImportId") != null) {
            criteria = criteria.add(Expression.eq("templateImportId", queryMap.get("templateImportId")));
        }
        if (queryMap.get("templateImportId_like") != null) {
            criteria = criteria.add(Expression.like("templateImportId", "%" + queryMap.get("templateImportId_like") + "%"));
        }

        if (queryMap.get("tableName") != null) {
            criteria = criteria.add(Expression.eq("tableName", queryMap.get("tableName")));
        }
        if (queryMap.get("tableName_like") != null) {
            criteria = criteria.add(Expression.like("tableName", "%" + queryMap.get("tableName_like") + "%"));
        }

        if (queryMap.get("keyValue") != null) {
            criteria = criteria.add(Expression.eq("keyValue", queryMap.get("keyValue")));
        }
        if (queryMap.get("keyValue_like") != null) {
            criteria = criteria.add(Expression.like("keyValue", "%" + queryMap.get("keyValue_like") + "%"));
        }

        if (queryMap.get("partyId") != null) {
            criteria = criteria.add(Expression.eq("partyId", queryMap.get("partyId")));
        }
        if (queryMap.get("partyId_like") != null) {
            criteria = criteria.add(Expression.like("partyId", "%" + queryMap.get("partyId_like") + "%"));
        }


        //���ݲ�ѯqueryMap�ļ�ֵ���ṩ������,_order="����1 asc|desc,����2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
