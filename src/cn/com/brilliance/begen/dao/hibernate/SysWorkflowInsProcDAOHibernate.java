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

import cn.com.brilliance.begen.dao.SysWorkflowInsProcDAO;
import cn.com.brilliance.begen.model.SysWorkflowInsProc;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysWorkflowInsProcDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class SysWorkflowInsProcDAOHibernate extends BeGenHibernateDaoSupport implements SysWorkflowInsProcDAO {    

    /**
     *  �����������SysWorkflowInsProc����.
     *  @param pkey SysWorkflowInsProc����
     *  @return SysWorkflowInsProc.
     */
    public SysWorkflowInsProc getSysWorkflowInsProc(java.lang.String pkey) {
        SysWorkflowInsProc sysWorkflowInsProc = (SysWorkflowInsProc) getHibernateTemplate().get(SysWorkflowInsProc.class, pkey);
        if (sysWorkflowInsProc == null) {
            return sysWorkflowInsProc;
        }
        return sysWorkflowInsProc;

    }

    /**
     *  �洢SysWorkflowInsProc����.
     *  @param  sysWorkflowInsProc SysWorkflowInsProc����
     *  @return SysWorkflowInsProc.
     */
    public SysWorkflowInsProc saveSysWorkflowInsProc(SysWorkflowInsProc sysWorkflowInsProc) {
        return (SysWorkflowInsProc) getHibernateTemplate().merge(sysWorkflowInsProc);
    }

    /**
     *  ɾ��SysWorkflowInsProc����.
     *  @param pkey SysWorkflowInsProc����.
     */
    public void removeSysWorkflowInsProc(java.lang.String pkey) {
        SysWorkflowInsProc sysWorkflowInsProc = getSysWorkflowInsProc(pkey);
        getHibernateTemplate().delete(sysWorkflowInsProc);
    }

    /**
     *  ��ȡSysWorkflowInsProc�����б�.
     *  @param  sysWorkflowInsProc SysWorkflowInsProc����
     *  @return List.
     */
    public List getSysWorkflowInsProcList(SysWorkflowInsProc sysWorkflowInsProc) {
        Criteria criteria = getSession().createCriteria(SysWorkflowInsProc.class).add(
                Example.create(sysWorkflowInsProc));
        if (sysWorkflowInsProc.getId() != null) {
            criteria.add(Expression.eq("id", sysWorkflowInsProc.getId()));
        }
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡSysWorkflowInsProc�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysWorkflowInsProcListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysWorkflowInsProc where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysWorkflowInsProc.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡSysWorkflowInsProc�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysWorkflowInsProcListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysWorkflowInsProc where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysWorkflowInsProc.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������SysWorkflowInsProc����
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

        if (queryMap.get("processDefId") != null) {
            criteria = criteria.add(Expression.eq("processDefId", queryMap.get("processDefId")));
        }
        if (queryMap.get("processDefId_like") != null) {
            criteria = criteria.add(Expression.like("processDefId", "%" + queryMap.get("processDefId_like") + "%"));
        }

        if (queryMap.get("processState") != null) {
            criteria = criteria.add(Expression.eq("processState", queryMap.get("processState")));
        }
        if (queryMap.get("processState_like") != null) {
            criteria = criteria.add(Expression.like("processState", "%" + queryMap.get("processState_like") + "%"));
        }

        if (queryMap.get("processStart") != null) {
            criteria = criteria.add(Expression.eq("processStart", java.sql.Date.valueOf((String) queryMap.get("processStart"))));
        }
        if (queryMap.get("processStart_min") != null) {
            criteria = criteria.add(Expression.ge("processStart", java.sql.Date.valueOf((String) queryMap.get("processStart_min"))));
        }
        if (queryMap.get("processStart_max") != null) {
            criteria = criteria.add(Expression.le("processStart", java.sql.Date.valueOf((String) queryMap.get("processStart_max"))));
        }
        if (queryMap.get("processEnd") != null) {
            criteria = criteria.add(Expression.eq("processEnd", java.sql.Date.valueOf((String) queryMap.get("processEnd"))));
        }
        if (queryMap.get("processEnd_min") != null) {
            criteria = criteria.add(Expression.ge("processEnd", java.sql.Date.valueOf((String) queryMap.get("processEnd_min"))));
        }
        if (queryMap.get("processEnd_max") != null) {
            criteria = criteria.add(Expression.le("processEnd", java.sql.Date.valueOf((String) queryMap.get("processEnd_max"))));
        }
        if (queryMap.get("dataObjectKey") != null) {
            criteria = criteria.add(Expression.eq("dataObjectKey", queryMap.get("dataObjectKey")));
        }
        if (queryMap.get("dataObjectKey_like") != null) {
            criteria = criteria.add(Expression.like("dataObjectKey", "%" + queryMap.get("dataObjectKey_like") + "%"));
        }


        //���ݲ�ѯqueryMap�ļ�ֵ���ṩ������,_order="����1 asc|desc,����2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
