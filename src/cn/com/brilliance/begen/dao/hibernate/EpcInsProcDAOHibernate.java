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

import cn.com.brilliance.begen.dao.EpcInsProcDAO;
import cn.com.brilliance.begen.model.EpcInsProc;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * EpcInsProcDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class EpcInsProcDAOHibernate extends BeGenHibernateDaoSupport implements EpcInsProcDAO {    

    /**
     *  �����������EpcInsProc����.
     *  @param pkey EpcInsProc����
     *  @return EpcInsProc.
     */
    public EpcInsProc getEpcInsProc(java.lang.String pkey) {
        EpcInsProc epcInsProc = (EpcInsProc) getHibernateTemplate().get(EpcInsProc.class, pkey);
        if (epcInsProc == null) {
            return epcInsProc;
        }
        return epcInsProc;

    }

    /**
     *  �洢EpcInsProc����.
     *  @param  epcInsProc EpcInsProc����
     *  @return EpcInsProc.
     */
    public EpcInsProc saveEpcInsProc(EpcInsProc epcInsProc) {
        return (EpcInsProc) getHibernateTemplate().merge(epcInsProc);
    }

    /**
     *  ɾ��EpcInsProc����.
     *  @param pkey EpcInsProc����.
     */
    public void removeEpcInsProc(java.lang.String pkey) {
        EpcInsProc epcInsProc = getEpcInsProc(pkey);
        getHibernateTemplate().delete(epcInsProc);
    }

    /**
     *  ��ȡEpcInsProc�����б�.
     *  @param  epcInsProc EpcInsProc����
     *  @return List.
     */
    public List getEpcInsProcList(EpcInsProc epcInsProc) {
        Criteria criteria = getSession().createCriteria(EpcInsProc.class).add(
                Example.create(epcInsProc));
        if (epcInsProc.getId() != null) {
            criteria.add(Expression.eq("id", epcInsProc.getId()));
        }
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡEpcInsProc�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getEpcInsProcListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.EpcInsProc where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(EpcInsProc.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡEpcInsProc�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getEpcInsProcListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.EpcInsProc where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(EpcInsProc.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������EpcInsProc����
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
        if (queryMap.get("dataObject") != null) {
            criteria = criteria.add(Expression.eq("dataObject", queryMap.get("dataObject")));
        }
        if (queryMap.get("dataObject_like") != null) {
            criteria = criteria.add(Expression.like("dataObject", "%" + queryMap.get("dataObject_like") + "%"));
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
