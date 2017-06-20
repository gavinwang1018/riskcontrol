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

import cn.com.brilliance.begen.dao.SysAutonumberDAO;
import cn.com.brilliance.begen.model.SysAutonumber;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysAutonumberDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class SysAutonumberDAOHibernate extends BeGenHibernateDaoSupport implements SysAutonumberDAO {    

    /**
     *  �����������SysAutonumber����.
     *  @param pkey SysAutonumber����
     *  @return SysAutonumber.
     */
    public SysAutonumber getSysAutonumber(java.lang.String pkey) {
        SysAutonumber sysAutonumber = (SysAutonumber) getHibernateTemplate().get(SysAutonumber.class, pkey);
        if (sysAutonumber == null) {
            return sysAutonumber;
        }
        return sysAutonumber;

    }

    /**
     *  �洢SysAutonumber����.
     *  @param  sysAutonumber SysAutonumber����
     *  @return SysAutonumber.
     */
    public SysAutonumber saveSysAutonumber(SysAutonumber sysAutonumber) {
        return (SysAutonumber) getHibernateTemplate().merge(sysAutonumber);
    }

    /**
     *  ɾ��SysAutonumber����.
     *  @param pkey SysAutonumber����.
     */
    public void removeSysAutonumber(java.lang.String pkey) {
        SysAutonumber sysAutonumber = getSysAutonumber(pkey);
        getHibernateTemplate().delete(sysAutonumber);
    }

    /**
     *  ��ȡSysAutonumber�����б�.
     *  @param  sysAutonumber SysAutonumber����
     *  @return List.
     */
    public List getSysAutonumberList(SysAutonumber sysAutonumber) {
        Criteria criteria = getSession().createCriteria(SysAutonumber.class).add(
                Example.create(sysAutonumber));
        if (sysAutonumber.getId() != null) {
            criteria.add(Expression.eq("id", sysAutonumber.getId()));
        }
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡSysAutonumber�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysAutonumberListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysAutonumber where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysAutonumber.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡSysAutonumber�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysAutonumberListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysAutonumber where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysAutonumber.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������SysAutonumber����
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

        if (queryMap.get("numvalue") != null) {
            criteria = criteria.add(Expression.eq("numvalue", new Integer((String) queryMap.get("numvalue"))));
        }
        if (queryMap.get("numvalue_min") != null) {
            criteria = criteria.add(Expression.ge("numvalue", new Integer((String) queryMap.get("numvalue_min"))));
        }
        if (queryMap.get("numvalue_max") != null) {
            criteria = criteria.add(Expression.le("numvalue", new Integer((String) queryMap.get("numvalue_max"))));
        }
        if (queryMap.get("partyId") != null) {
            criteria = criteria.add(Expression.eq("partyId", queryMap.get("partyId")));
        }
        if (queryMap.get("partyId_like") != null) {
            criteria = criteria.add(Expression.like("partyId", "%" + queryMap.get("partyId_like") + "%"));
        }

        if (queryMap.get("sysField") != null) {
            criteria = criteria.add(Expression.eq("sysField", queryMap.get("sysField")));
        }
        if (queryMap.get("sysField_like") != null) {
            criteria = criteria.add(Expression.like("sysField", "%" + queryMap.get("sysField_like") + "%"));
        }


        //���ݲ�ѯqueryMap�ļ�ֵ���ṩ������,_order="����1 asc|desc,����2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
