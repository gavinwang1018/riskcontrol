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

import cn.com.brilliance.begen.dao.SysUserRoleDAO;
import cn.com.brilliance.begen.model.SysUserRole;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysUserRoleDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class SysUserRoleDAOHibernate extends BeGenHibernateDaoSupport implements SysUserRoleDAO {    

    /**
     *  �����������SysUserRole����.
     *  @param pkey SysUserRole����
     *  @return SysUserRole.
     */
    public SysUserRole getSysUserRole(java.lang.String pkey) {
        SysUserRole sysUserRole = (SysUserRole) getHibernateTemplate().get(SysUserRole.class, pkey);
        if (sysUserRole == null) {
            return sysUserRole;
        }
        return sysUserRole;

    }

    /**
     *  �洢SysUserRole����.
     *  @param  sysUserRole SysUserRole����
     *  @return SysUserRole.
     */
    public SysUserRole saveSysUserRole(SysUserRole sysUserRole) {
        return (SysUserRole) getHibernateTemplate().merge(sysUserRole);
    }

    /**
     *  ɾ��SysUserRole����.
     *  @param pkey SysUserRole����.
     */
    public void removeSysUserRole(java.lang.String pkey) {
        SysUserRole sysUserRole = getSysUserRole(pkey);
        getHibernateTemplate().delete(sysUserRole);
    }

    /**
     *  ��ȡSysUserRole�����б�.
     *  @param  sysUserRole SysUserRole����
     *  @return List.
     */
    public List getSysUserRoleList(SysUserRole sysUserRole) {
        Criteria criteria = getSession().createCriteria(SysUserRole.class).add(
                Example.create(sysUserRole));
        if (sysUserRole.getId() != null) {
            criteria.add(Expression.eq("id", sysUserRole.getId()));
        }
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡSysUserRole�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysUserRoleListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysUserRole where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysUserRole.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡSysUserRole�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysUserRoleListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysUserRole where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysUserRole.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������SysUserRole����
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

        if (queryMap.get("userId") != null) {
            criteria = criteria.add(Expression.eq("userId", queryMap.get("userId")));
        }
        if (queryMap.get("userId_like") != null) {
            criteria = criteria.add(Expression.like("userId", "%" + queryMap.get("userId_like") + "%"));
        }

        if (queryMap.get("roleId") != null) {
            criteria = criteria.add(Expression.eq("roleId", queryMap.get("roleId")));
        }
        if (queryMap.get("roleId_like") != null) {
            criteria = criteria.add(Expression.like("roleId", "%" + queryMap.get("roleId_like") + "%"));
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
