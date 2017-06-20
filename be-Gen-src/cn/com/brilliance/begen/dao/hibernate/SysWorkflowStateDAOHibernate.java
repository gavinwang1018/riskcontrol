package cn.com.brilliance.begen.dao.hibernate;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Expression;

import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;
import cn.com.brilliance.begen.dao.SysWorkflowStateDAO;
import cn.com.brilliance.begen.model.SysWorkflowState;

/**
 * SysWorkflowStateDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class SysWorkflowStateDAOHibernate extends BeGenHibernateDaoSupport implements SysWorkflowStateDAO {    

    /**
     *  �����������SysWorkflowState����.
     *  @param pkey SysWorkflowState����
     *  @return SysWorkflowState.
     */
    public SysWorkflowState getSysWorkflowState(java.lang.String pkey) {
        SysWorkflowState sysWorkflowState = (SysWorkflowState) getHibernateTemplate().get(SysWorkflowState.class, pkey);
        if (sysWorkflowState == null) {
            return sysWorkflowState;
        }
        return sysWorkflowState;

    }

    /**
     *  �洢SysWorkflowState����.
     *  @param  sysWorkflowState SysWorkflowState����
     *  @return SysWorkflowState.
     */
    public SysWorkflowState saveSysWorkflowState(SysWorkflowState sysWorkflowState) {
        return (SysWorkflowState) getHibernateTemplate().merge(sysWorkflowState);
    }

    /**
     *  ɾ��SysWorkflowState����.
     *  @param pkey SysWorkflowState����.
     */
    public void removeSysWorkflowState(java.lang.String pkey) {
        SysWorkflowState sysWorkflowState = getSysWorkflowState(pkey);
        getHibernateTemplate().delete(sysWorkflowState);
    }

    /**
     *  ��ȡSysWorkflowState�����б�.
     *  @param  sysWorkflowState SysWorkflowState����
     *  @return List.
     */
    public List getSysWorkflowStateList(SysWorkflowState sysWorkflowState) {
        Criteria criteria = getSession().createCriteria(SysWorkflowState.class).add(
                Example.create(sysWorkflowState));
        if (sysWorkflowState.getId() != null) {
            criteria.add(Expression.eq("id", sysWorkflowState.getId()));
        }
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡSysWorkflowState�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysWorkflowStateListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.beapp.config.model.SysWorkflowState where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysWorkflowState.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡSysWorkflowState�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysWorkflowStateListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.beapp.config.model.SysWorkflowState where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysWorkflowState.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������SysWorkflowState����
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

        if (queryMap.get("receiptUser") != null) {
            criteria = criteria.add(Expression.eq("receiptUser", queryMap.get("receiptUser")));
        }
        if (queryMap.get("receiptUser_like") != null) {
            criteria = criteria.add(Expression.like("receiptUser", "%" + queryMap.get("receiptUser_like") + "%"));
        }

        if (queryMap.get("receiptRole") != null) {
            criteria = criteria.add(Expression.eq("receiptRole", queryMap.get("receiptRole")));
        }
        if (queryMap.get("receiptRole_like") != null) {
            criteria = criteria.add(Expression.like("receiptRole", "%" + queryMap.get("receiptRole_like") + "%"));
        }

        if (queryMap.get("receiptOrg") != null) {
            criteria = criteria.add(Expression.eq("receiptOrg", queryMap.get("receiptOrg")));
        }
        if (queryMap.get("receiptOrg_like") != null) {
            criteria = criteria.add(Expression.like("receiptOrg", "%" + queryMap.get("receiptOrg_like") + "%"));
        }

        if (queryMap.get("layoutType") != null) {
            criteria = criteria.add(Expression.eq("layoutType", queryMap.get("layoutType")));
        }
        if (queryMap.get("layoutType_like") != null) {
            criteria = criteria.add(Expression.like("layoutType", "%" + queryMap.get("layoutType_like") + "%"));
        }

        if (queryMap.get("formLayout") != null) {
            criteria = criteria.add(Expression.eq("formLayout", queryMap.get("formLayout")));
        }
        if (queryMap.get("formLayout_like") != null) {
            criteria = criteria.add(Expression.like("formLayout", "%" + queryMap.get("formLayout_like") + "%"));
        }

        if (queryMap.get("authLevel") != null) {
            criteria = criteria.add(Expression.eq("authLevel", queryMap.get("authLevel")));
        }
        if (queryMap.get("authLevel_like") != null) {
            criteria = criteria.add(Expression.like("authLevel", "%" + queryMap.get("authLevel_like") + "%"));
        }

        if (queryMap.get("workflowId") != null) {
            criteria = criteria.add(Expression.eq("workflowId", queryMap.get("workflowId")));
        }
        if (queryMap.get("workflowId_like") != null) {
            criteria = criteria.add(Expression.like("workflowId", "%" + queryMap.get("workflowId_like") + "%"));
        }

        if (queryMap.get("partyId") != null) {
            criteria = criteria.add(Expression.eq("partyId", queryMap.get("partyId")));
        }
        if (queryMap.get("partyId_like") != null) {
            criteria = criteria.add(Expression.like("partyId", "%" + queryMap.get("partyId_like") + "%"));
        }

        if (queryMap.get("title") != null) {
            criteria = criteria.add(Expression.eq("title", queryMap.get("title")));
        }
        if (queryMap.get("title_like") != null) {
            criteria = criteria.add(Expression.like("title", "%" + queryMap.get("title_like") + "%"));
        }


        //���ݲ�ѯqueryMap�ļ�ֵ���ṩ������,_order="����1 asc|desc,����2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
