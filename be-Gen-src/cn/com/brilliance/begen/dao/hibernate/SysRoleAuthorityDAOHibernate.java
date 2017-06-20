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

import cn.com.brilliance.begen.dao.SysRoleAuthorityDAO;
import cn.com.brilliance.begen.model.SysRoleAuthority;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysRoleAuthorityDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class SysRoleAuthorityDAOHibernate extends BeGenHibernateDaoSupport implements SysRoleAuthorityDAO {    

    /**
     *  �����������SysRoleAuthority����.
     *  @param pkey SysRoleAuthority����
     *  @return SysRoleAuthority.
     */
    public SysRoleAuthority getSysRoleAuthority(java.lang.String pkey) {
        SysRoleAuthority sysRoleAuthority = (SysRoleAuthority) getHibernateTemplate().get(SysRoleAuthority.class, pkey);
        if (sysRoleAuthority == null) {
            return sysRoleAuthority;
        }
        return sysRoleAuthority;

    }

    /**
     *  �洢SysRoleAuthority����.
     *  @param  sysRoleAuthority SysRoleAuthority����
     *  @return SysRoleAuthority.
     */
    public SysRoleAuthority saveSysRoleAuthority(SysRoleAuthority sysRoleAuthority) {
        return (SysRoleAuthority) getHibernateTemplate().merge(sysRoleAuthority);
    }

    /**
     *  ɾ��SysRoleAuthority����.
     *  @param pkey SysRoleAuthority����.
     */
    public void removeSysRoleAuthority(java.lang.String pkey) {
        SysRoleAuthority sysRoleAuthority = getSysRoleAuthority(pkey);
        getHibernateTemplate().delete(sysRoleAuthority);
    }

    /**
     *  ��ȡSysRoleAuthority�����б�.
     *  @param  sysRoleAuthority SysRoleAuthority����
     *  @return List.
     */
    public List getSysRoleAuthorityList(SysRoleAuthority sysRoleAuthority) {
        Criteria criteria = getSession().createCriteria(SysRoleAuthority.class).add(
                Example.create(sysRoleAuthority));
        if (sysRoleAuthority.getId() != null) {
            criteria.add(Expression.eq("id", sysRoleAuthority.getId()));
        }
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡSysRoleAuthority�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysRoleAuthorityListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysRoleAuthority where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysRoleAuthority.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡSysRoleAuthority�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysRoleAuthorityListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysRoleAuthority where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysRoleAuthority.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������SysRoleAuthority����
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

        if (queryMap.get("roleId") != null) {
            criteria = criteria.add(Expression.eq("roleId", queryMap.get("roleId")));
        }
        if (queryMap.get("roleId_like") != null) {
            criteria = criteria.add(Expression.like("roleId", "%" + queryMap.get("roleId_like") + "%"));
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
