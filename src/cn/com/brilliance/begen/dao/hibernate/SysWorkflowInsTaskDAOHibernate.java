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

import cn.com.brilliance.begen.dao.SysWorkflowInsTaskDAO;
import cn.com.brilliance.begen.model.SysWorkflowInsTask;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysWorkflowInsTaskDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class SysWorkflowInsTaskDAOHibernate extends BeGenHibernateDaoSupport implements SysWorkflowInsTaskDAO {    

    /**
     *  �����������SysWorkflowInsTask����.
     *  @param pkey SysWorkflowInsTask����
     *  @return SysWorkflowInsTask.
     */
    public SysWorkflowInsTask getSysWorkflowInsTask(java.lang.String pkey) {
        SysWorkflowInsTask sysWorkflowInsTask = (SysWorkflowInsTask) getHibernateTemplate().get(SysWorkflowInsTask.class, pkey);
        if (sysWorkflowInsTask == null) {
            return sysWorkflowInsTask;
        }
        return sysWorkflowInsTask;

    }

    /**
     *  �洢SysWorkflowInsTask����.
     *  @param  sysWorkflowInsTask SysWorkflowInsTask����
     *  @return SysWorkflowInsTask.
     */
    public SysWorkflowInsTask saveSysWorkflowInsTask(SysWorkflowInsTask sysWorkflowInsTask) {
        return (SysWorkflowInsTask) getHibernateTemplate().merge(sysWorkflowInsTask);
    }

    /**
     *  ɾ��SysWorkflowInsTask����.
     *  @param pkey SysWorkflowInsTask����.
     */
    public void removeSysWorkflowInsTask(java.lang.String pkey) {
        SysWorkflowInsTask sysWorkflowInsTask = getSysWorkflowInsTask(pkey);
        getHibernateTemplate().delete(sysWorkflowInsTask);
    }

    /**
     *  ��ȡSysWorkflowInsTask�����б�.
     *  @param  sysWorkflowInsTask SysWorkflowInsTask����
     *  @return List.
     */
    public List getSysWorkflowInsTaskList(SysWorkflowInsTask sysWorkflowInsTask) {
        Criteria criteria = getSession().createCriteria(SysWorkflowInsTask.class).add(
                Example.create(sysWorkflowInsTask));
        if (sysWorkflowInsTask.getId() != null) {
            criteria.add(Expression.eq("id", sysWorkflowInsTask.getId()));
        }
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡSysWorkflowInsTask�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysWorkflowInsTaskListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysWorkflowInsTask where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysWorkflowInsTask.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡSysWorkflowInsTask�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysWorkflowInsTaskListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysWorkflowInsTask where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysWorkflowInsTask.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������SysWorkflowInsTask����
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

        if (queryMap.get("taskOperator") != null) {
            criteria = criteria.add(Expression.eq("taskOperator", queryMap.get("taskOperator")));
        }
        if (queryMap.get("taskOperator_like") != null) {
            criteria = criteria.add(Expression.like("taskOperator", "%" + queryMap.get("taskOperator_like") + "%"));
        }

        if (queryMap.get("instanceStart") != null) {
            criteria = criteria.add(Expression.eq("instanceStart", java.sql.Date.valueOf((String) queryMap.get("instanceStart"))));
        }
        if (queryMap.get("instanceStart_min") != null) {
            criteria = criteria.add(Expression.ge("instanceStart", java.sql.Date.valueOf((String) queryMap.get("instanceStart_min"))));
        }
        if (queryMap.get("instanceStart_max") != null) {
            criteria = criteria.add(Expression.le("instanceStart", java.sql.Date.valueOf((String) queryMap.get("instanceStart_max"))));
        }
        if (queryMap.get("instanceEnd") != null) {
            criteria = criteria.add(Expression.eq("instanceEnd", java.sql.Date.valueOf((String) queryMap.get("instanceEnd"))));
        }
        if (queryMap.get("instanceEnd_min") != null) {
            criteria = criteria.add(Expression.ge("instanceEnd", java.sql.Date.valueOf((String) queryMap.get("instanceEnd_min"))));
        }
        if (queryMap.get("instanceEnd_max") != null) {
            criteria = criteria.add(Expression.le("instanceEnd", java.sql.Date.valueOf((String) queryMap.get("instanceEnd_max"))));
        }
        if (queryMap.get("instanceState") != null) {
            criteria = criteria.add(Expression.eq("instanceState", queryMap.get("instanceState")));
        }
        if (queryMap.get("instanceState_like") != null) {
            criteria = criteria.add(Expression.like("instanceState", "%" + queryMap.get("instanceState_like") + "%"));
        }

        if (queryMap.get("receiptOrg") != null) {
            criteria = criteria.add(Expression.eq("receiptOrg", queryMap.get("receiptOrg")));
        }
        if (queryMap.get("receiptOrg_like") != null) {
            criteria = criteria.add(Expression.like("receiptOrg", "%" + queryMap.get("receiptOrg_like") + "%"));
        }

        if (queryMap.get("receiptRole") != null) {
            criteria = criteria.add(Expression.eq("receiptRole", queryMap.get("receiptRole")));
        }
        if (queryMap.get("receiptRole_like") != null) {
            criteria = criteria.add(Expression.like("receiptRole", "%" + queryMap.get("receiptRole_like") + "%"));
        }

        if (queryMap.get("receiptUser") != null) {
            criteria = criteria.add(Expression.eq("receiptUser", queryMap.get("receiptUser")));
        }
        if (queryMap.get("receiptUser_like") != null) {
            criteria = criteria.add(Expression.like("receiptUser", "%" + queryMap.get("receiptUser_like") + "%"));
        }

        if (queryMap.get("processInsId") != null) {
            criteria = criteria.add(Expression.eq("processInsId", queryMap.get("processInsId")));
        }
        if (queryMap.get("processInsId_like") != null) {
            criteria = criteria.add(Expression.like("processInsId", "%" + queryMap.get("processInsId_like") + "%"));
        }

        if (queryMap.get("taskTitle") != null) {
            criteria = criteria.add(Expression.eq("taskTitle", queryMap.get("taskTitle")));
        }
        if (queryMap.get("taskTitle_like") != null) {
            criteria = criteria.add(Expression.like("taskTitle", "%" + queryMap.get("taskTitle_like") + "%"));
        }

        if (queryMap.get("stateDefId") != null) {
            criteria = criteria.add(Expression.eq("stateDefId", queryMap.get("stateDefId")));
        }
        if (queryMap.get("stateDefId_like") != null) {
            criteria = criteria.add(Expression.like("stateDefId", "%" + queryMap.get("stateDefId_like") + "%"));
        }


        //���ݲ�ѯqueryMap�ļ�ֵ���ṩ������,_order="����1 asc|desc,����2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}