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

import cn.com.brilliance.begen.dao.TcardbinDAO;
import cn.com.brilliance.begen.model.Tcardbin;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * TcardbinDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class TcardbinDAOHibernate extends BeGenHibernateDaoSupport implements TcardbinDAO {    

    /**
     *  �����������Tcardbin����.
     *  @param pkey Tcardbin����
     *  @return Tcardbin.
     */
    public Tcardbin getTcardbin(java.lang.String pkey) {
        Tcardbin tcardbin = (Tcardbin) getHibernateTemplate().get(Tcardbin.class, pkey);
        if (tcardbin == null) {
            return tcardbin;
        }
        return tcardbin;

    }

    /**
     *  �洢Tcardbin����.
     *  @param  tcardbin Tcardbin����
     *  @return Tcardbin.
     */
    public Tcardbin saveTcardbin(Tcardbin tcardbin) {
        return (Tcardbin) getHibernateTemplate().merge(tcardbin);
    }

    /**
     *  ɾ��Tcardbin����.
     *  @param pkey Tcardbin����.
     */
    public void removeTcardbin(java.lang.String pkey) {
        Tcardbin tcardbin = getTcardbin(pkey);
        getHibernateTemplate().delete(tcardbin);
    }

    /**
     *  ��ȡTcardbin�����б�.
     *  @param  tcardbin Tcardbin����
     *  @return List.
     */
    public List getTcardbinList(Tcardbin tcardbin) {
        Criteria criteria = getSession().createCriteria(Tcardbin.class).add(
                Example.create(tcardbin));
        if (tcardbin.getId() != null) {
            criteria.add(Expression.eq("id", tcardbin.getId()));
        }
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡTcardbin�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getTcardbinListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.Tcardbin where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(Tcardbin.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡTcardbin�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getTcardbinListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.Tcardbin where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(Tcardbin.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������Tcardbin����
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

        if (queryMap.get("length") != null) {
            criteria = criteria.add(Expression.eq("length", new Integer((String) queryMap.get("length"))));
        }
        if (queryMap.get("length_min") != null) {
            criteria = criteria.add(Expression.ge("length", new Integer((String) queryMap.get("length_min"))));
        }
        if (queryMap.get("length_max") != null) {
            criteria = criteria.add(Expression.le("length", new Integer((String) queryMap.get("length_max"))));
        }
        if (queryMap.get("bin") != null) {
            criteria = criteria.add(Expression.eq("bin", queryMap.get("bin")));
        }
        if (queryMap.get("bin_like") != null) {
            criteria = criteria.add(Expression.like("bin", "%" + queryMap.get("bin_like") + "%"));
        }

        if (queryMap.get("cupscard") != null) {
            criteria = criteria.add(Expression.eq("cupscard", new Boolean((String) queryMap.get("cupscard"))));
        }
        if (queryMap.get("bank") != null) {
            criteria = criteria.add(Expression.eq("bank", queryMap.get("bank")));
        }
        if (queryMap.get("bank_like") != null) {
            criteria = criteria.add(Expression.like("bank", "%" + queryMap.get("bank_like") + "%"));
        }


        //���ݲ�ѯqueryMap�ļ�ֵ���ṩ������,_order="����1 asc|desc,����2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
