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

import cn.com.brilliance.begen.dao.SysRoleDAO;
import cn.com.brilliance.begen.model.SysRole;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysRoleDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class SysRoleDAOHibernate extends BeGenHibernateDaoSupport implements SysRoleDAO {    

    /**
     *  �����������SysRole����.
     *  @param pkey SysRole����
     *  @return SysRole.
     */
    public SysRole getSysRole(java.lang.String pkey) {
        SysRole sysRole = (SysRole) getHibernateTemplate().get(SysRole.class, pkey);
        if (sysRole == null) {
            return sysRole;
        }
        return sysRole;

    }

    /**
     *  �洢SysRole����.
     *  @param  sysRole SysRole����
     *  @return SysRole.
     */
    public SysRole saveSysRole(SysRole sysRole) {
        return (SysRole) getHibernateTemplate().merge(sysRole);
    }

    /**
     *  ɾ��SysRole����.
     *  @param pkey SysRole����.
     */
    public void removeSysRole(java.lang.String pkey) {
        SysRole sysRole = getSysRole(pkey);
        getHibernateTemplate().delete(sysRole);
    }

    /**
     *  ��ȡSysRole�����б�.
     *  @param  sysRole SysRole����
     *  @return List.
     */
    public List getSysRoleList(SysRole sysRole) {
        Criteria criteria = getSession().createCriteria(SysRole.class).add(
                Example.create(sysRole));
        if (sysRole.getId() != null) {
            criteria.add(Expression.eq("id", sysRole.getId()));
        }
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡSysRole�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysRoleListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysRole where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysRole.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡSysRole�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysRoleListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysRole where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysRole.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������SysRole����
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

        if (queryMap.get("roleId") != null) {
            criteria = criteria.add(Expression.eq("roleId", queryMap.get("roleId")));
        }
        if (queryMap.get("roleId_like") != null) {
            criteria = criteria.add(Expression.like("roleId", "%" + queryMap.get("roleId_like") + "%"));
        }

        if (queryMap.get("roleName") != null) {
            criteria = criteria.add(Expression.eq("roleName", queryMap.get("roleName")));
        }
        if (queryMap.get("roleName_like") != null) {
            criteria = criteria.add(Expression.like("roleName", "%" + queryMap.get("roleName_like") + "%"));
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
