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

import cn.com.brilliance.begen.dao.TriskcaseLogDAO;
import cn.com.brilliance.begen.model.TriskcaseLog;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * TriskcaseLogDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class TriskcaseLogDAOHibernate extends BeGenHibernateDaoSupport implements TriskcaseLogDAO {    

    /**
     *  �����������TriskcaseLog����.
     *  @param pkey TriskcaseLog����
     *  @return TriskcaseLog.
     */
    public TriskcaseLog getTriskcaseLog(java.lang.String pkey) {
        TriskcaseLog triskcaseLog = (TriskcaseLog) getHibernateTemplate().get(TriskcaseLog.class, pkey);
        if (triskcaseLog == null) {
            return triskcaseLog;
        }
        return triskcaseLog;

    }

    /**
     *  �洢TriskcaseLog����.
     *  @param  triskcaseLog TriskcaseLog����
     *  @return TriskcaseLog.
     */
    public TriskcaseLog saveTriskcaseLog(TriskcaseLog triskcaseLog) {
        return (TriskcaseLog) getHibernateTemplate().merge(triskcaseLog);
    }

    /**
     *  ɾ��TriskcaseLog����.
     *  @param pkey TriskcaseLog����.
     */
    public void removeTriskcaseLog(java.lang.String pkey) {
        TriskcaseLog triskcaseLog = getTriskcaseLog(pkey);
        getHibernateTemplate().delete(triskcaseLog);
    }

    /**
     *  ��ȡTriskcaseLog�����б�.
     *  @param  triskcaseLog TriskcaseLog����
     *  @return List.
     */
    public List getTriskcaseLogList(TriskcaseLog triskcaseLog) {
        Criteria criteria = getSession().createCriteria(TriskcaseLog.class).add(
                Example.create(triskcaseLog));
        if (triskcaseLog.getId() != null) {
            criteria.add(Expression.eq("id", triskcaseLog.getId()));
        }
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡTriskcaseLog�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getTriskcaseLogListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TriskcaseLog where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(TriskcaseLog.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡTriskcaseLog�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getTriskcaseLogListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TriskcaseLog where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(TriskcaseLog.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������TriskcaseLog����
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

        if (queryMap.get("userMame") != null) {
            criteria = criteria.add(Expression.eq("userMame", queryMap.get("userMame")));
        }
        if (queryMap.get("userMame_like") != null) {
            criteria = criteria.add(Expression.like("userMame", "%" + queryMap.get("userMame_like") + "%"));
        }

        if (queryMap.get("operatorDatetime") != null) {
            criteria = criteria.add(Expression.eq("operatorDatetime", java.sql.Date.valueOf((String) queryMap.get("operatorDatetime"))));
        }
        if (queryMap.get("operatorDatetime_min") != null) {
            criteria = criteria.add(Expression.ge("operatorDatetime", java.sql.Date.valueOf((String) queryMap.get("operatorDatetime_min"))));
        }
        if (queryMap.get("operatorDatetime_max") != null) {
            criteria = criteria.add(Expression.le("operatorDatetime", java.sql.Date.valueOf((String) queryMap.get("operatorDatetime_max"))));
        }
        if (queryMap.get("ip") != null) {
            criteria = criteria.add(Expression.eq("ip", queryMap.get("ip")));
        }
        if (queryMap.get("ip_like") != null) {
            criteria = criteria.add(Expression.like("ip", "%" + queryMap.get("ip_like") + "%"));
        }

        if (queryMap.get("content") != null) {
            criteria = criteria.add(Expression.eq("content", queryMap.get("content")));
        }
        if (queryMap.get("content_like") != null) {
            criteria = criteria.add(Expression.like("content", "%" + queryMap.get("content_like") + "%"));
        }

        if (queryMap.get("loginName") != null) {
            criteria = criteria.add(Expression.eq("loginName", queryMap.get("loginName")));
        }
        if (queryMap.get("loginName_like") != null) {
            criteria = criteria.add(Expression.like("loginName", "%" + queryMap.get("loginName_like") + "%"));
        }


        //���ݲ�ѯqueryMap�ļ�ֵ���ṩ������,_order="����1 asc|desc,����2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
