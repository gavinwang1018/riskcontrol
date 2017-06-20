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

import cn.com.brilliance.begen.dao.SysPortletDefDAO;
import cn.com.brilliance.begen.model.SysPortletDef;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysPortletDefDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class SysPortletDefDAOHibernate extends BeGenHibernateDaoSupport implements SysPortletDefDAO {    

    /**
     *  �����������SysPortletDef����.
     *  @param pkey SysPortletDef����
     *  @return SysPortletDef.
     */
    public SysPortletDef getSysPortletDef(java.lang.String pkey) {
        SysPortletDef sysPortletDef = (SysPortletDef) getHibernateTemplate().get(SysPortletDef.class, pkey);
        if (sysPortletDef == null) {
            return sysPortletDef;
        }
        return sysPortletDef;

    }

    /**
     *  �洢SysPortletDef����.
     *  @param  sysPortletDef SysPortletDef����
     *  @return SysPortletDef.
     */
    public SysPortletDef saveSysPortletDef(SysPortletDef sysPortletDef) {
        return (SysPortletDef) getHibernateTemplate().merge(sysPortletDef);
    }

    /**
     *  ɾ��SysPortletDef����.
     *  @param pkey SysPortletDef����.
     */
    public void removeSysPortletDef(java.lang.String pkey) {
        SysPortletDef sysPortletDef = getSysPortletDef(pkey);
        getHibernateTemplate().delete(sysPortletDef);
    }

    /**
     *  ��ȡSysPortletDef�����б�.
     *  @param  sysPortletDef SysPortletDef����
     *  @return List.
     */
    public List getSysPortletDefList(SysPortletDef sysPortletDef) {
        Criteria criteria = getSession().createCriteria(SysPortletDef.class).add(
                Example.create(sysPortletDef));
        if (sysPortletDef.getId() != null) {
            criteria.add(Expression.eq("id", sysPortletDef.getId()));
        }
        criteria.addOrder(Order.asc("sysRecordOrder"));
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡSysPortletDef�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysPortletDefListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysPortletDef where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysPortletDef.class);

        criteria.addOrder(Order.asc("sysRecordOrder"));
        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡSysPortletDef�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysPortletDefListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysPortletDef where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysPortletDef.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������SysPortletDef����
        Object[] keyArray = queryMap.keySet().toArray();  //ת����ѯ�ֶ���keySetΪ����
        //���������飬ȥ����Ӧ��ѯ�ֶ�ֵΪ�յļ�ֵ
        for (int i = 0; i < keyArray.length; i++) {
            String value = (String) queryMap.get(keyArray[i]);
            if (value == null || value.trim().length() == 0) {
                queryMap.remove(keyArray[i]);
            }
        }

        if (queryMap.get("label") != null) {
            criteria = criteria.add(Expression.eq("label", queryMap.get("label")));
        }
        if (queryMap.get("label_like") != null) {
            criteria = criteria.add(Expression.like("label", "%" + queryMap.get("label_like") + "%"));
        }

        if (queryMap.get("url") != null) {
            criteria = criteria.add(Expression.eq("url", queryMap.get("url")));
        }
        if (queryMap.get("url_like") != null) {
            criteria = criteria.add(Expression.like("url", "%" + queryMap.get("url_like") + "%"));
        }

        if (queryMap.get("partyId") != null) {
            criteria = criteria.add(Expression.eq("partyId", queryMap.get("partyId")));
        }
        if (queryMap.get("partyId_like") != null) {
            criteria = criteria.add(Expression.like("partyId", "%" + queryMap.get("partyId_like") + "%"));
        }

        if (queryMap.get("id") != null) {
            criteria = criteria.add(Expression.eq("id", queryMap.get("id")));
        }
        if (queryMap.get("id_like") != null) {
            criteria = criteria.add(Expression.like("id", "%" + queryMap.get("id_like") + "%"));
        }

        if (queryMap.get("urlDescription") != null) {
            criteria = criteria.add(Expression.eq("urlDescription", queryMap.get("urlDescription")));
        }
        if (queryMap.get("urlDescription_like") != null) {
            criteria = criteria.add(Expression.like("urlDescription", "%" + queryMap.get("urlDescription_like") + "%"));
        }

        if (queryMap.get("portalId") != null) {
            criteria = criteria.add(Expression.eq("portalId", queryMap.get("portalId")));
        }
        if (queryMap.get("portalId_like") != null) {
            criteria = criteria.add(Expression.like("portalId", "%" + queryMap.get("portalId_like") + "%"));
        }

        if (queryMap.get("cols") != null) {
            criteria = criteria.add(Expression.eq("cols", queryMap.get("cols")));
        }
        if (queryMap.get("cols_like") != null) {
            criteria = criteria.add(Expression.like("cols", "%" + queryMap.get("cols_like") + "%"));
        }


        //���ݲ�ѯqueryMap�ļ�ֵ���ṩ������,_order="����1 asc|desc,����2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
