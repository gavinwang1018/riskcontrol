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

import cn.com.brilliance.begen.dao.SysOrgDAO;
import cn.com.brilliance.begen.model.SysOrg;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysOrgDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class SysOrgDAOHibernate extends BeGenHibernateDaoSupport implements SysOrgDAO {    

    /**
     *  �����������SysOrg����.
     *  @param pkey SysOrg����
     *  @return SysOrg.
     */
    public SysOrg getSysOrg(java.lang.String pkey) {
        SysOrg sysOrg = (SysOrg) getHibernateTemplate().get(SysOrg.class, pkey);
        if (sysOrg == null) {
            return sysOrg;
        }
        return sysOrg;

    }

    /**
     *  �洢SysOrg����.
     *  @param  sysOrg SysOrg����
     *  @return SysOrg.
     */
    public SysOrg saveSysOrg(SysOrg sysOrg) {
        return (SysOrg) getHibernateTemplate().merge(sysOrg);
    }

    /**
     *  ɾ��SysOrg����.
     *  @param pkey SysOrg����.
     */
    public void removeSysOrg(java.lang.String pkey) {
        SysOrg sysOrg = getSysOrg(pkey);
        getHibernateTemplate().delete(sysOrg);
    }

    /**
     *  ��ȡSysOrg�����б�.
     *  @param  sysOrg SysOrg����
     *  @return List.
     */
    public List getSysOrgList(SysOrg sysOrg) {
        Criteria criteria = getSession().createCriteria(SysOrg.class).add(
                Example.create(sysOrg));
        if (sysOrg.getId() != null) {
            criteria.add(Expression.eq("id", sysOrg.getId()));
        }
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡSysOrg�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysOrgListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysOrg where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysOrg.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡSysOrg�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysOrgListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysOrg where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysOrg.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������SysOrg����
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

        if (queryMap.get("orgId") != null) {
            criteria = criteria.add(Expression.eq("orgId", queryMap.get("orgId")));
        }
        if (queryMap.get("orgId_like") != null) {
            criteria = criteria.add(Expression.like("orgId", "%" + queryMap.get("orgId_like") + "%"));
        }

        if (queryMap.get("orgName") != null) {
            criteria = criteria.add(Expression.eq("orgName", queryMap.get("orgName")));
        }
        if (queryMap.get("orgName_like") != null) {
            criteria = criteria.add(Expression.like("orgName", "%" + queryMap.get("orgName_like") + "%"));
        }

        if (queryMap.get("parentOrg") != null) {
            criteria = criteria.add(Expression.eq("parentOrg", queryMap.get("parentOrg")));
        }
        if (queryMap.get("parentOrg_like") != null) {
            criteria = criteria.add(Expression.like("parentOrg", "%" + queryMap.get("parentOrg_like") + "%"));
        }

        if (queryMap.get("masterOrg") != null) {
            criteria = criteria.add(Expression.eq("masterOrg", queryMap.get("masterOrg")));
        }
        if (queryMap.get("masterOrg_like") != null) {
            criteria = criteria.add(Expression.like("masterOrg", "%" + queryMap.get("masterOrg_like") + "%"));
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
