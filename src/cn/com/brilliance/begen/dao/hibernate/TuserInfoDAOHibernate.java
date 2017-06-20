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

import cn.com.brilliance.begen.dao.TuserInfoDAO;
import cn.com.brilliance.begen.model.TuserInfo;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * TuserInfoDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class TuserInfoDAOHibernate extends BeGenHibernateDaoSupport implements TuserInfoDAO {    

    /**
     *  �����������TuserInfo����.
     *  @param pkey TuserInfo����
     *  @return TuserInfo.
     */
    public TuserInfo getTuserInfo(java.lang.String pkey) {
        TuserInfo tuserInfo = (TuserInfo) getHibernateTemplate().get(TuserInfo.class, pkey);
        if (tuserInfo == null) {
            return tuserInfo;
        }
        return tuserInfo;

    }

    /**
     *  �洢TuserInfo����.
     *  @param  tuserInfo TuserInfo����
     *  @return TuserInfo.
     */
    public TuserInfo saveTuserInfo(TuserInfo tuserInfo) {
        return (TuserInfo) getHibernateTemplate().merge(tuserInfo);
    }

    /**
     *  ɾ��TuserInfo����.
     *  @param pkey TuserInfo����.
     */
    public void removeTuserInfo(java.lang.String pkey) {
        TuserInfo tuserInfo = getTuserInfo(pkey);
        getHibernateTemplate().delete(tuserInfo);
    }

    /**
     *  ��ȡTuserInfo�����б�.
     *  @param  tuserInfo TuserInfo����
     *  @return List.
     */
    public List getTuserInfoList(TuserInfo tuserInfo) {
        Criteria criteria = getSession().createCriteria(TuserInfo.class).add(
                Example.create(tuserInfo));
        if (tuserInfo.getId() != null) {
            criteria.add(Expression.eq("id", tuserInfo.getId()));
        }
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡTuserInfo�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getTuserInfoListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TuserInfo where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(TuserInfo.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡTuserInfo�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getTuserInfoListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TuserInfo where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(TuserInfo.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������TuserInfo����
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

        if (queryMap.get("loginName") != null) {
            criteria = criteria.add(Expression.eq("loginName", queryMap.get("loginName")));
        }
        if (queryMap.get("loginName_like") != null) {
            criteria = criteria.add(Expression.like("loginName", "%" + queryMap.get("loginName_like") + "%"));
        }

        if (queryMap.get("name") != null) {
            criteria = criteria.add(Expression.eq("name", queryMap.get("name")));
        }
        if (queryMap.get("name_like") != null) {
            criteria = criteria.add(Expression.like("name", "%" + queryMap.get("name_like") + "%"));
        }

        if (queryMap.get("password") != null) {
            criteria = criteria.add(Expression.eq("password", queryMap.get("password")));
        }
        if (queryMap.get("password_like") != null) {
            criteria = criteria.add(Expression.like("password", "%" + queryMap.get("password_like") + "%"));
        }

        if (queryMap.get("email") != null) {
            criteria = criteria.add(Expression.eq("email", queryMap.get("email")));
        }
        if (queryMap.get("email_like") != null) {
            criteria = criteria.add(Expression.like("email", "%" + queryMap.get("email_like") + "%"));
        }

        if (queryMap.get("enable") != null) {
            criteria = criteria.add(Expression.eq("enable", new Boolean((String) queryMap.get("enable"))));
        }

        if (queryMap.get("organizeId") != null) {
            criteria = criteria.add(Expression.eq("organizeId", queryMap.get("organizeId")));
        }
        if (queryMap.get("organizeId_like") != null) {//������ƥ���������� --- û��߷
//        	criteria = criteria.add(Expression.eq("organizeId", queryMap.get("organizeId_like")));        	
            criteria = criteria.add(Expression.like("organizeId", "%" + queryMap.get("organizeId_like") + "%"));
        }

        queryMap.put("_order", "organizeId asc");
        //���ݲ�ѯqueryMap�ļ�ֵ���ṩ������,_order="����1 asc|desc,����2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
