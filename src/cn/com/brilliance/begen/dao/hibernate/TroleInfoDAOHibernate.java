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

import cn.com.brilliance.begen.dao.TroleInfoDAO;
import cn.com.brilliance.begen.model.TroleInfo;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * TroleInfoDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class TroleInfoDAOHibernate extends BeGenHibernateDaoSupport implements TroleInfoDAO {    

    /**
     *  �����������TroleInfo����.
     *  @param pkey TroleInfo����
     *  @return TroleInfo.
     */
    public TroleInfo getTroleInfo(java.lang.String pkey) {
        TroleInfo troleInfo = (TroleInfo) getHibernateTemplate().get(TroleInfo.class, pkey);
        if (troleInfo == null) {
            return troleInfo;
        }
        return troleInfo;

    }

    /**
     *  �洢TroleInfo����.
     *  @param  troleInfo TroleInfo����
     *  @return TroleInfo.
     */
    public TroleInfo saveTroleInfo(TroleInfo troleInfo) {
        return (TroleInfo) getHibernateTemplate().merge(troleInfo);
    }

    /**
     *  ɾ��TroleInfo����.
     *  @param pkey TroleInfo����.
     */
    public void removeTroleInfo(java.lang.String pkey) {
        TroleInfo troleInfo = getTroleInfo(pkey);
        getHibernateTemplate().delete(troleInfo);
    }

    /**
     *  ��ȡTroleInfo�����б�.
     *  @param  troleInfo TroleInfo����
     *  @return List.
     */
    public List getTroleInfoList(TroleInfo troleInfo) {
        Criteria criteria = getSession().createCriteria(TroleInfo.class).add(
                Example.create(troleInfo));
        if (troleInfo.getId() != null) {
            criteria.add(Expression.eq("id", troleInfo.getId()));
        }
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡTroleInfo�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getTroleInfoListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TroleInfo where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(TroleInfo.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡTroleInfo�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getTroleInfoListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TroleInfo where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(TroleInfo.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������TroleInfo����
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

        if (queryMap.get("name") != null) {
            criteria = criteria.add(Expression.eq("name", queryMap.get("name")));
        }
        if (queryMap.get("name_like") != null) {
            criteria = criteria.add(Expression.like("name", "%" + queryMap.get("name_like") + "%"));
        }

        if (queryMap.get("code") != null) {
            criteria = criteria.add(Expression.eq("code", queryMap.get("code")));
        }
        if (queryMap.get("code_like") != null) {
            criteria = criteria.add(Expression.like("code", "%" + queryMap.get("code_like") + "%"));
        }


        //���ݲ�ѯqueryMap�ļ�ֵ���ṩ������,_order="����1 asc|desc,����2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
