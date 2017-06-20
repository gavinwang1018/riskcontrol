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

import cn.com.brilliance.begen.dao.TroleUserDAO;
import cn.com.brilliance.begen.model.TroleUser;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * TroleUserDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class TroleUserDAOHibernate extends BeGenHibernateDaoSupport implements TroleUserDAO {    

    /**
     *  �����������TroleUser����.
     *  @param pkey TroleUser����
     *  @return TroleUser.
     */
    public TroleUser getTroleUser(java.lang.String pkey) {
        TroleUser troleUser = (TroleUser) getHibernateTemplate().get(TroleUser.class, pkey);
        if (troleUser == null) {
            return troleUser;
        }
        return troleUser;

    }

    /**
     *  �洢TroleUser����.
     *  @param  troleUser TroleUser����
     *  @return TroleUser.
     */
    public TroleUser saveTroleUser(TroleUser troleUser) {
        return (TroleUser) getHibernateTemplate().merge(troleUser);
    }

    /**
     *  ɾ��TroleUser����.
     *  @param pkey TroleUser����.
     */
    public void removeTroleUser(java.lang.String pkey) {
        TroleUser troleUser = getTroleUser(pkey);
        getHibernateTemplate().delete(troleUser);
    }

    /**
     *  ��ȡTroleUser�����б�.
     *  @param  troleUser TroleUser����
     *  @return List.
     */
    public List getTroleUserList(TroleUser troleUser) {
        Criteria criteria = getSession().createCriteria(TroleUser.class).add(
                Example.create(troleUser));
        if (troleUser.getId() != null) {
            criteria.add(Expression.eq("id", troleUser.getId()));
        }
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡTroleUser�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getTroleUserListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TroleUser where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(TroleUser.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡTroleUser�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getTroleUserListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TroleUser where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(TroleUser.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������TroleUser����
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

        if (queryMap.get("roleId") != null) {
            criteria = criteria.add(Expression.eq("roleId", queryMap.get("roleId")));
        }
        if (queryMap.get("roleId_like") != null) {
            criteria = criteria.add(Expression.like("roleId", "%" + queryMap.get("roleId_like") + "%"));
        }

        if (queryMap.get("userId") != null) {
            criteria = criteria.add(Expression.eq("userId", queryMap.get("userId")));
        }
        if (queryMap.get("userId_like") != null) {
            criteria = criteria.add(Expression.like("userId", "%" + queryMap.get("userId_like") + "%"));
        }


        //���ݲ�ѯqueryMap�ļ�ֵ���ṩ������,_order="����1 asc|desc,����2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
