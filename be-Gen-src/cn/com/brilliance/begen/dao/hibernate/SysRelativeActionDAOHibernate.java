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

import cn.com.brilliance.begen.dao.SysRelativeActionDAO;
import cn.com.brilliance.begen.model.SysRelativeAction;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysRelativeActionDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class SysRelativeActionDAOHibernate extends BeGenHibernateDaoSupport implements SysRelativeActionDAO {    

    /**
     *  �����������SysRelativeAction����.
     *  @param pkey SysRelativeAction����
     *  @return SysRelativeAction.
     */
    public SysRelativeAction getSysRelativeAction(java.lang.String pkey) {
        SysRelativeAction sysRelativeAction = (SysRelativeAction) getHibernateTemplate().get(SysRelativeAction.class, pkey);
        if (sysRelativeAction == null) {
            return sysRelativeAction;
        }
        return sysRelativeAction;

    }

    /**
     *  �洢SysRelativeAction����.
     *  @param  sysRelativeAction SysRelativeAction����
     *  @return SysRelativeAction.
     */
    public SysRelativeAction saveSysRelativeAction(SysRelativeAction sysRelativeAction) {
        return (SysRelativeAction) getHibernateTemplate().merge(sysRelativeAction);
    }

    /**
     *  ɾ��SysRelativeAction����.
     *  @param pkey SysRelativeAction����.
     */
    public void removeSysRelativeAction(java.lang.String pkey) {
        SysRelativeAction sysRelativeAction = getSysRelativeAction(pkey);
        getHibernateTemplate().delete(sysRelativeAction);
    }

    /**
     *  ��ȡSysRelativeAction�����б�.
     *  @param  sysRelativeAction SysRelativeAction����
     *  @return List.
     */
    public List getSysRelativeActionList(SysRelativeAction sysRelativeAction) {
        Criteria criteria = getSession().createCriteria(SysRelativeAction.class).add(
                Example.create(sysRelativeAction));
        if (sysRelativeAction.getId() != null) {
            criteria.add(Expression.eq("id", sysRelativeAction.getId()));
        }
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡSysRelativeAction�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysRelativeActionListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysRelativeAction where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysRelativeAction.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡSysRelativeAction�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysRelativeActionListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysRelativeAction where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysRelativeAction.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������SysRelativeAction����
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

        if (queryMap.get("rule") != null) {
            criteria = criteria.add(Expression.eq("rule", queryMap.get("rule")));
        }
        if (queryMap.get("rule_like") != null) {
            criteria = criteria.add(Expression.like("rule", "%" + queryMap.get("rule_like") + "%"));
        }

        if (queryMap.get("inputField_like") != null) {
            criteria = criteria.add(Expression.like("inputField", "%" + queryMap.get("inputField_like") + "%"));
        }
        if (queryMap.get("formLayout") != null) {
            criteria = criteria.add(Expression.eq("formLayout", queryMap.get("formLayout")));
        }
        if (queryMap.get("formLayout_like") != null) {
            criteria = criteria.add(Expression.like("formLayout", "%" + queryMap.get("formLayout_like") + "%"));
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
