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

import cn.com.brilliance.begen.dao.TriskprocessTimelimitDAO;
import cn.com.brilliance.begen.model.TriskprocessTimelimit;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * TriskprocessTimelimitDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class TriskprocessTimelimitDAOHibernate extends BeGenHibernateDaoSupport implements TriskprocessTimelimitDAO {    

    /**
     *  �����������TriskprocessTimelimit����.
     *  @param pkey TriskprocessTimelimit����
     *  @return TriskprocessTimelimit.
     */
    public TriskprocessTimelimit getTriskprocessTimelimit(java.lang.String pkey) {
        TriskprocessTimelimit triskprocessTimelimit = (TriskprocessTimelimit) getHibernateTemplate().get(TriskprocessTimelimit.class, pkey);
        if (triskprocessTimelimit == null) {
            return triskprocessTimelimit;
        }
        return triskprocessTimelimit;

    }

    /**
     *  �洢TriskprocessTimelimit����.
     *  @param  triskprocessTimelimit TriskprocessTimelimit����
     *  @return TriskprocessTimelimit.
     */
    public TriskprocessTimelimit saveTriskprocessTimelimit(TriskprocessTimelimit triskprocessTimelimit) {
        return (TriskprocessTimelimit) getHibernateTemplate().merge(triskprocessTimelimit);
    }

    /**
     *  ɾ��TriskprocessTimelimit����.
     *  @param pkey TriskprocessTimelimit����.
     */
    public void removeTriskprocessTimelimit(java.lang.String pkey) {
        TriskprocessTimelimit triskprocessTimelimit = getTriskprocessTimelimit(pkey);
        getHibernateTemplate().delete(triskprocessTimelimit);
    }

    /**
     *  ��ȡTriskprocessTimelimit�����б�.
     *  @param  triskprocessTimelimit TriskprocessTimelimit����
     *  @return List.
     */
    public List getTriskprocessTimelimitList(TriskprocessTimelimit triskprocessTimelimit) {
        Criteria criteria = getSession().createCriteria(TriskprocessTimelimit.class).add(
                Example.create(triskprocessTimelimit));
        if (triskprocessTimelimit.getId() != null) {
            criteria.add(Expression.eq("id", triskprocessTimelimit.getId()));
        }
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡTriskprocessTimelimit�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getTriskprocessTimelimitListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TriskprocessTimelimit where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(TriskprocessTimelimit.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡTriskprocessTimelimit�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getTriskprocessTimelimitListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TriskprocessTimelimit where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(TriskprocessTimelimit.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������TriskprocessTimelimit����
        Object[] keyArray = queryMap.keySet().toArray();  //ת����ѯ�ֶ���keySetΪ����
        //���������飬ȥ����Ӧ��ѯ�ֶ�ֵΪ�յļ�ֵ
        for (int i = 0; i < keyArray.length; i++) {
            String value = (String) queryMap.get(keyArray[i]);
            if (value == null || value.trim().length() == 0) {
                queryMap.remove(keyArray[i]);
            }
        }

        if (queryMap.get("belongToInst") != null) {
            criteria = criteria.add(Expression.eq("belongToInst", queryMap.get("belongToInst")));
        }
        if (queryMap.get("belongToInst_like") != null) {
            criteria = criteria.add(Expression.like("belongToInst", "%" + queryMap.get("belongToInst_like") + "%"));
        }

        if (queryMap.get("warnLevel") != null) {
            criteria = criteria.add(Expression.eq("warnLevel", queryMap.get("warnLevel")));
        }
        if (queryMap.get("warnLevel_like") != null) {
            criteria = criteria.add(Expression.like("warnLevel", "%" + queryMap.get("warnLevel_like") + "%"));
        }

        if (queryMap.get("timeLimit") != null) {
            criteria = criteria.add(Expression.eq("timeLimit", queryMap.get("timeLimit")));
        }
        if (queryMap.get("timeLimit_like") != null) {
            criteria = criteria.add(Expression.like("timeLimit", "%" + queryMap.get("timeLimit_like") + "%"));
        }

        if (queryMap.get("id") != null) {
            criteria = criteria.add(Expression.eq("id", queryMap.get("id")));
        }
        if (queryMap.get("id_like") != null) {
            criteria = criteria.add(Expression.like("id", "%" + queryMap.get("id_like") + "%"));
        }


        //���ݲ�ѯqueryMap�ļ�ֵ���ṩ������,_order="����1 asc|desc,����2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
