package cn.com.brilliance.begen.dao.hibernate;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Expression;

import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;
import cn.com.brilliance.begen.dao.SysWorkflowDefDAO;
import cn.com.brilliance.begen.model.SysWorkflowDef;

/**
 * SysWorkflowDefDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class SysWorkflowDefDAOHibernate extends BeGenHibernateDaoSupport implements SysWorkflowDefDAO {    

    /**
     *  �����������SysWorkflowDef����.
     *  @param pkey SysWorkflowDef����
     *  @return SysWorkflowDef.
     */
    public SysWorkflowDef getSysWorkflowDef(java.lang.String pkey) {
        SysWorkflowDef sysWorkflowDef = (SysWorkflowDef) getHibernateTemplate().get(SysWorkflowDef.class, pkey);
        if (sysWorkflowDef == null) {
            return sysWorkflowDef;
        }
        return sysWorkflowDef;

    }

    /**
     *  �洢SysWorkflowDef����.
     *  @param  sysWorkflowDef SysWorkflowDef����
     *  @return SysWorkflowDef.
     */
    public SysWorkflowDef saveSysWorkflowDef(SysWorkflowDef sysWorkflowDef) {
        return (SysWorkflowDef) getHibernateTemplate().merge(sysWorkflowDef);
    }

    /**
     *  ɾ��SysWorkflowDef����.
     *  @param pkey SysWorkflowDef����.
     */
    public void removeSysWorkflowDef(java.lang.String pkey) {
        SysWorkflowDef sysWorkflowDef = getSysWorkflowDef(pkey);
        getHibernateTemplate().delete(sysWorkflowDef);
    }

    /**
     *  ��ȡSysWorkflowDef�����б�.
     *  @param  sysWorkflowDef SysWorkflowDef����
     *  @return List.
     */
    public List getSysWorkflowDefList(SysWorkflowDef sysWorkflowDef) {
        Criteria criteria = getSession().createCriteria(SysWorkflowDef.class).add(
                Example.create(sysWorkflowDef));
        if (sysWorkflowDef.getId() != null) {
            criteria.add(Expression.eq("id", sysWorkflowDef.getId()));
        }
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡSysWorkflowDef�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysWorkflowDefListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.beapp.config.model.SysWorkflowDef where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysWorkflowDef.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡSysWorkflowDef�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysWorkflowDefListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.beapp.config.model.SysWorkflowDef where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysWorkflowDef.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������SysWorkflowDef����
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

        if (queryMap.get("workflowName") != null) {
            criteria = criteria.add(Expression.eq("workflowName", queryMap.get("workflowName")));
        }
        if (queryMap.get("workflowName_like") != null) {
            criteria = criteria.add(Expression.like("workflowName", "%" + queryMap.get("workflowName_like") + "%"));
        }

        if (queryMap.get("workflowLabel") != null) {
            criteria = criteria.add(Expression.eq("workflowLabel", queryMap.get("workflowLabel")));
        }
        if (queryMap.get("workflowLabel_like") != null) {
            criteria = criteria.add(Expression.like("workflowLabel", "%" + queryMap.get("workflowLabel_like") + "%"));
        }

        if (queryMap.get("dataObject") != null) {
            criteria = criteria.add(Expression.eq("dataObject", queryMap.get("dataObject")));
        }
        if (queryMap.get("dataObject_like") != null) {
            criteria = criteria.add(Expression.like("dataObject", "%" + queryMap.get("dataObject_like") + "%"));
        }

        if (queryMap.get("rollBack") != null) {
            criteria = criteria.add(Expression.eq("rollBack", queryMap.get("rollBack")));
        }
        if (queryMap.get("rollBack_like") != null) {
            criteria = criteria.add(Expression.like("rollBack", "%" + queryMap.get("rollBack_like") + "%"));
        }

        if (queryMap.get("historyLayout") != null) {
            criteria = criteria.add(Expression.eq("historyLayout", queryMap.get("historyLayout")));
        }
        if (queryMap.get("historyLayout_like") != null) {
            criteria = criteria.add(Expression.like("historyLayout", "%" + queryMap.get("historyLayout_like") + "%"));
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
