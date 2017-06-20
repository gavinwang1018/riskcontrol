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

import cn.com.brilliance.begen.dao.SysBizServiceDefDAO;
import cn.com.brilliance.begen.model.SysBizServiceDef;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysBizServiceDefDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class SysBizServiceDefDAOHibernate extends BeGenHibernateDaoSupport implements SysBizServiceDefDAO {    

    /**
     *  �����������SysBizServiceDef����.
     *  @param pkey SysBizServiceDef����
     *  @return SysBizServiceDef.
     */
    public SysBizServiceDef getSysBizServiceDef(java.lang.String pkey) {
        SysBizServiceDef sysBizServiceDef = (SysBizServiceDef) getHibernateTemplate().get(SysBizServiceDef.class, pkey);
        if (sysBizServiceDef == null) {
            return sysBizServiceDef;
        }
        return sysBizServiceDef;

    }

    /**
     *  �洢SysBizServiceDef����.
     *  @param  sysBizServiceDef SysBizServiceDef����
     *  @return SysBizServiceDef.
     */
    public SysBizServiceDef saveSysBizServiceDef(SysBizServiceDef sysBizServiceDef) {
        return (SysBizServiceDef) getHibernateTemplate().merge(sysBizServiceDef);
    }

    /**
     *  ɾ��SysBizServiceDef����.
     *  @param pkey SysBizServiceDef����.
     */
    public void removeSysBizServiceDef(java.lang.String pkey) {
        SysBizServiceDef sysBizServiceDef = getSysBizServiceDef(pkey);
        getHibernateTemplate().delete(sysBizServiceDef);
    }

    /**
     *  ��ȡSysBizServiceDef�����б�.
     *  @param  sysBizServiceDef SysBizServiceDef����
     *  @return List.
     */
    public List getSysBizServiceDefList(SysBizServiceDef sysBizServiceDef) {
        Criteria criteria = getSession().createCriteria(SysBizServiceDef.class).add(
                Example.create(sysBizServiceDef));
        if (sysBizServiceDef.getId() != null) {
            criteria.add(Expression.eq("id", sysBizServiceDef.getId()));
        }
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡSysBizServiceDef�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysBizServiceDefListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysBizServiceDef where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysBizServiceDef.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡSysBizServiceDef�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysBizServiceDefListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysBizServiceDef where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysBizServiceDef.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������SysBizServiceDef����
        Object[] keyArray = queryMap.keySet().toArray();  //ת����ѯ�ֶ���keySetΪ����
        //���������飬ȥ����Ӧ��ѯ�ֶ�ֵΪ�յļ�ֵ
        for (int i = 0; i < keyArray.length; i++) {
            String value = (String) queryMap.get(keyArray[i]);
            if (value == null || value.trim().length() == 0) {
                queryMap.remove(keyArray[i]);
            }
        }

        if (queryMap.get("operationId") != null) {
            criteria = criteria.add(Expression.eq("operationId", queryMap.get("operationId")));
        }
        if (queryMap.get("operationId_like") != null) {
            criteria = criteria.add(Expression.like("operationId", "%" + queryMap.get("operationId_like") + "%"));
        }

        if (queryMap.get("operationDesc") != null) {
            criteria = criteria.add(Expression.eq("operationDesc", queryMap.get("operationDesc")));
        }
        if (queryMap.get("operationDesc_like") != null) {
            criteria = criteria.add(Expression.like("operationDesc", "%" + queryMap.get("operationDesc_like") + "%"));
        }

        if (queryMap.get("scriptContent") != null) {
            criteria = criteria.add(Expression.eq("scriptContent", queryMap.get("scriptContent")));
        }
        if (queryMap.get("scriptContent_like") != null) {
            criteria = criteria.add(Expression.like("scriptContent", "%" + queryMap.get("scriptContent_like") + "%"));
        }

        if (queryMap.get("id") != null) {
            criteria = criteria.add(Expression.eq("id", queryMap.get("id")));
        }
        if (queryMap.get("id_like") != null) {
            criteria = criteria.add(Expression.like("id", "%" + queryMap.get("id_like") + "%"));
        }

        if (queryMap.get("partyId") != null) {
            criteria = criteria.add(Expression.eq("partyId", queryMap.get("partyId")));
        }
        if (queryMap.get("partyId_like") != null) {
            criteria = criteria.add(Expression.like("partyId", "%" + queryMap.get("partyId_like") + "%"));
        }

        if (queryMap.get("dataObject") != null) {
            criteria = criteria.add(Expression.eq("dataObject", queryMap.get("dataObject")));
        }
        if (queryMap.get("dataObject_like") != null) {
            criteria = criteria.add(Expression.like("dataObject", "%" + queryMap.get("dataObject_like") + "%"));
        }


        //���ݲ�ѯqueryMap�ļ�ֵ���ṩ������,_order="����1 asc|desc,����2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
