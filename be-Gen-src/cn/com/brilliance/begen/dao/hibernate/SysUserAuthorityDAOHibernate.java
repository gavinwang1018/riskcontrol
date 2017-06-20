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

import cn.com.brilliance.begen.dao.SysUserAuthorityDAO;
import cn.com.brilliance.begen.model.SysUserAuthority;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysUserAuthorityDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class SysUserAuthorityDAOHibernate extends BeGenHibernateDaoSupport implements SysUserAuthorityDAO {    

    /**
     *  �����������SysUserAuthority����.
     *  @param pkey SysUserAuthority����
     *  @return SysUserAuthority.
     */
    public SysUserAuthority getSysUserAuthority(java.lang.String pkey) {
        SysUserAuthority sysUserAuthority = (SysUserAuthority) getHibernateTemplate().get(SysUserAuthority.class, pkey);
        if (sysUserAuthority == null) {
            return sysUserAuthority;
        }
        return sysUserAuthority;

    }

    /**
     *  �洢SysUserAuthority����.
     *  @param  sysUserAuthority SysUserAuthority����
     *  @return SysUserAuthority.
     */
    public SysUserAuthority saveSysUserAuthority(SysUserAuthority sysUserAuthority) {
        return (SysUserAuthority) getHibernateTemplate().merge(sysUserAuthority);
    }

    /**
     *  ɾ��SysUserAuthority����.
     *  @param pkey SysUserAuthority����.
     */
    public void removeSysUserAuthority(java.lang.String pkey) {
        SysUserAuthority sysUserAuthority = getSysUserAuthority(pkey);
        getHibernateTemplate().delete(sysUserAuthority);
    }

    /**
     *  ��ȡSysUserAuthority�����б�.
     *  @param  sysUserAuthority SysUserAuthority����
     *  @return List.
     */
    public List getSysUserAuthorityList(SysUserAuthority sysUserAuthority) {
        Criteria criteria = getSession().createCriteria(SysUserAuthority.class).add(
                Example.create(sysUserAuthority));
        if (sysUserAuthority.getId() != null) {
            criteria.add(Expression.eq("id", sysUserAuthority.getId()));
        }
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡSysUserAuthority�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysUserAuthorityListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysUserAuthority where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysUserAuthority.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡSysUserAuthority�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysUserAuthorityListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysUserAuthority where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysUserAuthority.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������SysUserAuthority����
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

        if (queryMap.get("actionId") != null) {
            criteria = criteria.add(Expression.eq("actionId", queryMap.get("actionId")));
        }
        if (queryMap.get("actionId_like") != null) {
            criteria = criteria.add(Expression.like("actionId", "%" + queryMap.get("actionId_like") + "%"));
        }

        if (queryMap.get("userId") != null) {
            criteria = criteria.add(Expression.eq("userId", queryMap.get("userId")));
        }
        if (queryMap.get("userId_like") != null) {
            criteria = criteria.add(Expression.like("userId", "%" + queryMap.get("userId_like") + "%"));
        }

        if (queryMap.get("authorityType") != null) {
            criteria = criteria.add(Expression.eq("authorityType", queryMap.get("authorityType")));
        }
        if (queryMap.get("authorityType_like") != null) {
            criteria = criteria.add(Expression.like("authorityType", "%" + queryMap.get("authorityType_like") + "%"));
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
