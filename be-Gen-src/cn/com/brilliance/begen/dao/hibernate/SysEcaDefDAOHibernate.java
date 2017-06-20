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

import cn.com.brilliance.begen.dao.SysEcaDefDAO;
import cn.com.brilliance.begen.model.SysEcaDef;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysEcaDefDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class SysEcaDefDAOHibernate extends BeGenHibernateDaoSupport implements SysEcaDefDAO {    

    /**
     *  �����������SysEcaDef����.
     *  @param pkey SysEcaDef����
     *  @return SysEcaDef.
     */
    public SysEcaDef getSysEcaDef(java.lang.String pkey) {
        SysEcaDef sysEcaDef = (SysEcaDef) getHibernateTemplate().get(SysEcaDef.class, pkey);
        if (sysEcaDef == null) {
            return sysEcaDef;
        }
        return sysEcaDef;

    }

    /**
     *  �洢SysEcaDef����.
     *  @param  sysEcaDef SysEcaDef����
     *  @return SysEcaDef.
     */
    public SysEcaDef saveSysEcaDef(SysEcaDef sysEcaDef) {
        return (SysEcaDef) getHibernateTemplate().merge(sysEcaDef);
    }

    /**
     *  ɾ��SysEcaDef����.
     *  @param pkey SysEcaDef����.
     */
    public void removeSysEcaDef(java.lang.String pkey) {
        SysEcaDef sysEcaDef = getSysEcaDef(pkey);
        getHibernateTemplate().delete(sysEcaDef);
    }

    /**
     *  ��ȡSysEcaDef�����б�.
     *  @param  sysEcaDef SysEcaDef����
     *  @return List.
     */
    public List getSysEcaDefList(SysEcaDef sysEcaDef) {
        Criteria criteria = getSession().createCriteria(SysEcaDef.class).add(
                Example.create(sysEcaDef));
        if (sysEcaDef.getId() != null) {
            criteria.add(Expression.eq("id", sysEcaDef.getId()));
        }
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡSysEcaDef�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysEcaDefListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysEcaDef where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysEcaDef.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡSysEcaDef�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysEcaDefListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysEcaDef where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysEcaDef.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������SysEcaDef����
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

        if (queryMap.get("dataObject") != null) {
            criteria = criteria.add(Expression.eq("dataObject", queryMap.get("dataObject")));
        }
        if (queryMap.get("dataObject_like") != null) {
            criteria = criteria.add(Expression.like("dataObject", "%" + queryMap.get("dataObject_like") + "%"));
        }

        if (queryMap.get("actionType") != null) {
            criteria = criteria.add(Expression.eq("actionType", queryMap.get("actionType")));
        }
        if (queryMap.get("actionType_like") != null) {
            criteria = criteria.add(Expression.like("actionType", "%" + queryMap.get("actionType_like") + "%"));
        }

        if (queryMap.get("eventExpress") != null) {
            criteria = criteria.add(Expression.eq("eventExpress", queryMap.get("eventExpress")));
        }
        if (queryMap.get("eventExpress_like") != null) {
            criteria = criteria.add(Expression.like("eventExpress", "%" + queryMap.get("eventExpress_like") + "%"));
        }

        if (queryMap.get("description") != null) {
            criteria = criteria.add(Expression.eq("description", queryMap.get("description")));
        }
        if (queryMap.get("description_like") != null) {
            criteria = criteria.add(Expression.like("description", "%" + queryMap.get("description_like") + "%"));
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
