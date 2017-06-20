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

import cn.com.brilliance.begen.dao.TorganizeUserDAO;
import cn.com.brilliance.begen.model.TorganizeUser;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * TorganizeUserDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class TorganizeUserDAOHibernate extends BeGenHibernateDaoSupport implements TorganizeUserDAO {    

    /**
     *  �����������TorganizeUser����.
     *  @param pkey TorganizeUser����
     *  @return TorganizeUser.
     */
    public TorganizeUser getTorganizeUser(java.lang.String pkey) {
        TorganizeUser torganizeUser = (TorganizeUser) getHibernateTemplate().get(TorganizeUser.class, pkey);
        if (torganizeUser == null) {
            return torganizeUser;
        }
        return torganizeUser;

    }

    /**
     *  �洢TorganizeUser����.
     *  @param  torganizeUser TorganizeUser����
     *  @return TorganizeUser.
     */
    public TorganizeUser saveTorganizeUser(TorganizeUser torganizeUser) {
        return (TorganizeUser) getHibernateTemplate().merge(torganizeUser);
    }

    /**
     *  ɾ��TorganizeUser����.
     *  @param pkey TorganizeUser����.
     */
    public void removeTorganizeUser(java.lang.String pkey) {
        TorganizeUser torganizeUser = getTorganizeUser(pkey);
        getHibernateTemplate().delete(torganizeUser);
    }

    /**
     *  ��ȡTorganizeUser�����б�.
     *  @param  torganizeUser TorganizeUser����
     *  @return List.
     */
    public List getTorganizeUserList(TorganizeUser torganizeUser) {
        Criteria criteria = getSession().createCriteria(TorganizeUser.class).add(
                Example.create(torganizeUser));
        if (torganizeUser.getId() != null) {
            criteria.add(Expression.eq("id", torganizeUser.getId()));
        }
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡTorganizeUser�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getTorganizeUserListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TorganizeUser where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(TorganizeUser.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡTorganizeUser�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getTorganizeUserListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TorganizeUser where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(TorganizeUser.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������TorganizeUser����
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

        if (queryMap.get("organizeId") != null) {
            criteria = criteria.add(Expression.eq("organizeId", queryMap.get("organizeId")));
        }
        if (queryMap.get("organizeId_like") != null) {
            criteria = criteria.add(Expression.like("organizeId", "%" + queryMap.get("organizeId_like") + "%"));
        }

        if (queryMap.get("userId") != null) {
            criteria = criteria.add(Expression.eq("userId", queryMap.get("userId")));
        }
        if (queryMap.get("userId_like") != null) {
            criteria = criteria.add(Expression.like("userId", "%" + queryMap.get("userId_like") + "%"));
        }

        if (queryMap.get("type") != null) {
            criteria = criteria.add(Expression.eq("type", new Boolean((String) queryMap.get("type"))));
        }

        //���ݲ�ѯqueryMap�ļ�ֵ���ṩ������,_order="����1 asc|desc,����2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
