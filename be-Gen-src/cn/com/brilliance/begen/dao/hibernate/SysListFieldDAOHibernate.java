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

import cn.com.brilliance.begen.dao.SysListFieldDAO;
import cn.com.brilliance.begen.model.SysListField;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysListFieldDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class SysListFieldDAOHibernate extends BeGenHibernateDaoSupport implements SysListFieldDAO {    

    /**
     *  �����������SysListField����.
     *  @param pkey SysListField����
     *  @return SysListField.
     */
    public SysListField getSysListField(java.lang.String pkey) {
        SysListField sysListField = (SysListField) getHibernateTemplate().get(SysListField.class, pkey);
        if (sysListField == null) {
            return sysListField;
        }
        return sysListField;

    }

    /**
     *  �洢SysListField����.
     *  @param  sysListField SysListField����
     *  @return SysListField.
     */
    public SysListField saveSysListField(SysListField sysListField) {
        return (SysListField) getHibernateTemplate().merge(sysListField);
    }

    /**
     *  ɾ��SysListField����.
     *  @param pkey SysListField����.
     */
    public void removeSysListField(java.lang.String pkey) {
        SysListField sysListField = getSysListField(pkey);
        getHibernateTemplate().delete(sysListField);
    }

    /**
     *  ��ȡSysListField�����б�.
     *  @param  sysListField SysListField����
     *  @return List.
     */
    public List getSysListFieldList(SysListField sysListField) {
        Criteria criteria = getSession().createCriteria(SysListField.class).add(
                Example.create(sysListField));
        if (sysListField.getId() != null) {
            criteria.add(Expression.eq("id", sysListField.getId()));
        }
        criteria.addOrder(Order.asc("sysRecordOrder"));
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡSysListField�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysListFieldListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysListField where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysListField.class);

        criteria.addOrder(Order.asc("sysRecordOrder"));
        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡSysListField�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysListFieldListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysListField where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysListField.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������SysListField����
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

        if (queryMap.get("listLayout") != null) {
            criteria = criteria.add(Expression.eq("listLayout", queryMap.get("listLayout")));
        }
        if (queryMap.get("listLayout_like") != null) {
            criteria = criteria.add(Expression.like("listLayout", "%" + queryMap.get("listLayout_like") + "%"));
        }

        if (queryMap.get("view") != null) {
            criteria = criteria.add(Expression.eq("view", new Boolean((String) queryMap.get("view"))));
        }
        if (queryMap.get("partyId") != null) {
            criteria = criteria.add(Expression.eq("partyId", queryMap.get("partyId")));
        }
        if (queryMap.get("partyId_like") != null) {
            criteria = criteria.add(Expression.like("partyId", "%" + queryMap.get("partyId_like") + "%"));
        }

        if (queryMap.get("sortFlag") != null) {
            criteria = criteria.add(Expression.eq("sortFlag", queryMap.get("sortFlag")));
        }
        if (queryMap.get("sortFlag_like") != null) {
            criteria = criteria.add(Expression.like("sortFlag", "%" + queryMap.get("sortFlag_like") + "%"));
        }

        if (queryMap.get("queryMode") != null) {
            criteria = criteria.add(Expression.eq("queryMode", queryMap.get("queryMode")));
        }
        if (queryMap.get("queryMode_like") != null) {
            criteria = criteria.add(Expression.like("queryMode", "%" + queryMap.get("queryMode_like") + "%"));
        }

        if (queryMap.get("sysField") != null) {
            criteria = criteria.add(Expression.eq("sysField", queryMap.get("sysField")));
        }
        if (queryMap.get("sysField_like") != null) {
            criteria = criteria.add(Expression.like("sysField", "%" + queryMap.get("sysField_like") + "%"));
        }

        if (queryMap.get("relationField") != null) {
            criteria = criteria.add(Expression.eq("relationField", queryMap.get("relationField")));
        }
        if (queryMap.get("relationField_like") != null) {
            criteria = criteria.add(Expression.like("relationField", "%" + queryMap.get("relationField_like") + "%"));
        }


        //���ݲ�ѯqueryMap�ļ�ֵ���ṩ������,_order="����1 asc|desc,����2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
