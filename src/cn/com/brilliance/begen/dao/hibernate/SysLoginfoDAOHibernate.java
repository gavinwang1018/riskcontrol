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

import cn.com.brilliance.begen.dao.SysLoginfoDAO;
import cn.com.brilliance.begen.model.SysLoginfo;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysLoginfoDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class SysLoginfoDAOHibernate extends BeGenHibernateDaoSupport implements SysLoginfoDAO {    

    /**
     *  �����������SysLoginfo����.
     *  @param pkey SysLoginfo����
     *  @return SysLoginfo.
     */
    public SysLoginfo getSysLoginfo(java.lang.String pkey) {
        SysLoginfo sysLoginfo = (SysLoginfo) getHibernateTemplate().get(SysLoginfo.class, pkey);
        if (sysLoginfo == null) {
            return sysLoginfo;
        }
        return sysLoginfo;

    }

    /**
     *  �洢SysLoginfo����.
     *  @param  sysLoginfo SysLoginfo����
     *  @return SysLoginfo.
     */
    public SysLoginfo saveSysLoginfo(SysLoginfo sysLoginfo) {
        return (SysLoginfo) getHibernateTemplate().merge(sysLoginfo);
    }

    /**
     *  ɾ��SysLoginfo����.
     *  @param pkey SysLoginfo����.
     */
    public void removeSysLoginfo(java.lang.String pkey) {
        SysLoginfo sysLoginfo = getSysLoginfo(pkey);
        getHibernateTemplate().delete(sysLoginfo);
    }

    /**
     *  ��ȡSysLoginfo�����б�.
     *  @param  sysLoginfo SysLoginfo����
     *  @return List.
     */
    public List getSysLoginfoList(SysLoginfo sysLoginfo) {
        Criteria criteria = getSession().createCriteria(SysLoginfo.class).add(
                Example.create(sysLoginfo));
        if (sysLoginfo.getId() != null) {
            criteria.add(Expression.eq("id", sysLoginfo.getId()));
        }
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡSysLoginfo�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysLoginfoListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysLoginfo where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysLoginfo.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡSysLoginfo�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysLoginfoListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysLoginfo where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysLoginfo.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������SysLoginfo����
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

        if (queryMap.get("operator") != null) {
            criteria = criteria.add(Expression.eq("operator", queryMap.get("operator")));
        }
        if (queryMap.get("operator_like") != null) {
            criteria = criteria.add(Expression.like("operator", "%" + queryMap.get("operator_like") + "%"));
        }

        if (queryMap.get("operationType") != null) {
            criteria = criteria.add(Expression.eq("operationType", queryMap.get("operationType")));
        }
        if (queryMap.get("operationType_like") != null) {
            criteria = criteria.add(Expression.like("operationType", "%" + queryMap.get("operationType_like") + "%"));
        }

        if (queryMap.get("operationTitle") != null) {
            criteria = criteria.add(Expression.eq("operationTitle", queryMap.get("operationTitle")));
        }
        if (queryMap.get("operationTitle_like") != null) {
            criteria = criteria.add(Expression.like("operationTitle", "%" + queryMap.get("operationTitle_like") + "%"));
        }

        if (queryMap.get("operationTime") != null) {
            criteria = criteria.add(Expression.eq("operationTime", java.sql.Date.valueOf((String) queryMap.get("operationTime"))));
        }
        if (queryMap.get("operationTime_min") != null) {
            criteria = criteria.add(Expression.ge("operationTime", java.sql.Date.valueOf((String) queryMap.get("operationTime_min"))));
        }
        if (queryMap.get("operationTime_max") != null) {
            criteria = criteria.add(Expression.le("operationTime", java.sql.Date.valueOf((String) queryMap.get("operationTime_max"))));
        }
        if (queryMap.get("clientIp") != null) {
            criteria = criteria.add(Expression.eq("clientIp", queryMap.get("clientIp")));
        }
        if (queryMap.get("clientIp_like") != null) {
            criteria = criteria.add(Expression.like("clientIp", "%" + queryMap.get("clientIp_like") + "%"));
        }

        if (queryMap.get("terminalType") != null) {
            criteria = criteria.add(Expression.eq("terminalType", queryMap.get("terminalType")));
        }
        if (queryMap.get("terminalType_like") != null) {
            criteria = criteria.add(Expression.like("terminalType", "%" + queryMap.get("terminalType_like") + "%"));
        }


        //���ݲ�ѯqueryMap�ļ�ֵ���ṩ������,_order="����1 asc|desc,����2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
