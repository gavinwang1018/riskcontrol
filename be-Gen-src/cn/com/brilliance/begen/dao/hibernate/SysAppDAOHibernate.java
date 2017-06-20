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

import cn.com.brilliance.begen.dao.SysAppDAO;
import cn.com.brilliance.begen.model.SysApp;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysAppDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class SysAppDAOHibernate extends BeGenHibernateDaoSupport implements SysAppDAO {    

    /**
     *  �����������SysApp����.
     *  @param pkey SysApp����
     *  @return SysApp.
     */
    public SysApp getSysApp(java.lang.String pkey) {
        SysApp sysApp = (SysApp) getHibernateTemplate().get(SysApp.class, pkey);
        if (sysApp == null) {
            return sysApp;
        }
        return sysApp;

    }

    /**
     *  �洢SysApp����.
     *  @param  sysApp SysApp����
     *  @return SysApp.
     */
    public SysApp saveSysApp(SysApp sysApp) {
        return (SysApp) getHibernateTemplate().merge(sysApp);
    }

    /**
     *  ɾ��SysApp����.
     *  @param pkey SysApp����.
     */
    public void removeSysApp(java.lang.String pkey) {
        SysApp sysApp = getSysApp(pkey);
        getHibernateTemplate().delete(sysApp);
    }

    /**
     *  ��ȡSysApp�����б�.
     *  @param  sysApp SysApp����
     *  @return List.
     */
    public List getSysAppList(SysApp sysApp) {
        Criteria criteria = getSession().createCriteria(SysApp.class).add(
                Example.create(sysApp));
        if (sysApp.getId() != null) {
            criteria.add(Expression.eq("id", sysApp.getId()));
        }
        criteria.addOrder(Order.asc("sysRecordOrder"));
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡSysApp�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysAppListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysApp where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysApp.class);

        criteria.addOrder(Order.asc("sysRecordOrder"));
        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡSysApp�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysAppListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysApp where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysApp.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������SysApp����
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

        if (queryMap.get("label") != null) {
            criteria = criteria.add(Expression.eq("label", queryMap.get("label")));
        }
        if (queryMap.get("label_like") != null) {
            criteria = criteria.add(Expression.like("label", "%" + queryMap.get("label_like") + "%"));
        }

        if (queryMap.get("name") != null) {
            criteria = criteria.add(Expression.eq("name", queryMap.get("name")));
        }
        if (queryMap.get("name_like") != null) {
            criteria = criteria.add(Expression.like("name", "%" + queryMap.get("name_like") + "%"));
        }

        if (queryMap.get("url") != null) {
            criteria = criteria.add(Expression.eq("url", queryMap.get("url")));
        }
        if (queryMap.get("url_like") != null) {
            criteria = criteria.add(Expression.like("url", "%" + queryMap.get("url_like") + "%"));
        }

        if (queryMap.get("authority") != null) {
            criteria = criteria.add(Expression.eq("authority", new Boolean((String) queryMap.get("authority"))));
        }
        if (queryMap.get("partyId") != null) {
            criteria = criteria.add(Expression.eq("partyId", queryMap.get("partyId")));
        }
        if (queryMap.get("partyId_like") != null) {
            criteria = criteria.add(Expression.like("partyId", "%" + queryMap.get("partyId_like") + "%"));
        }

        if (queryMap.get("urlDescription") != null) {
            criteria = criteria.add(Expression.eq("urlDescription", queryMap.get("urlDescription")));
        }
        if (queryMap.get("urlDescription_like") != null) {
            criteria = criteria.add(Expression.like("urlDescription", "%" + queryMap.get("urlDescription_like") + "%"));
        }


        //���ݲ�ѯqueryMap�ļ�ֵ���ṩ������,_order="����1 asc|desc,����2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
