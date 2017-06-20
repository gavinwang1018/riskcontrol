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

import cn.com.brilliance.begen.dao.TpermissionDAO;
import cn.com.brilliance.begen.model.Tpermission;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * TpermissionDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class TpermissionDAOHibernate extends BeGenHibernateDaoSupport implements TpermissionDAO {    

    /**
     *  �����������Tpermission����.
     *  @param pkey Tpermission����
     *  @return Tpermission.
     */
    public Tpermission getTpermission(java.lang.String pkey) {
        Tpermission tpermission = (Tpermission) getHibernateTemplate().get(Tpermission.class, pkey);
        if (tpermission == null) {
            return tpermission;
        }
        return tpermission;

    }

    /**
     *  �洢Tpermission����.
     *  @param  tpermission Tpermission����
     *  @return Tpermission.
     */
    public Tpermission saveTpermission(Tpermission tpermission) {
        return (Tpermission) getHibernateTemplate().merge(tpermission);
    }

    /**
     *  ɾ��Tpermission����.
     *  @param pkey Tpermission����.
     */
    public void removeTpermission(java.lang.String pkey) {
        Tpermission tpermission = getTpermission(pkey);
        getHibernateTemplate().delete(tpermission);
    }

    /**
     *  ��ȡTpermission�����б�.
     *  @param  tpermission Tpermission����
     *  @return List.
     */
    public List getTpermissionList(Tpermission tpermission) {
        Criteria criteria = getSession().createCriteria(Tpermission.class).add(
                Example.create(tpermission));
        if (tpermission.getId() != null) {
            criteria.add(Expression.eq("id", tpermission.getId()));
        }
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡTpermission�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getTpermissionListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.Tpermission where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(Tpermission.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡTpermission�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getTpermissionListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.Tpermission where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(Tpermission.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������Tpermission����
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

        if (queryMap.get("priviledeId") != null) {
            criteria = criteria.add(Expression.eq("priviledeId", queryMap.get("priviledeId")));
        }
        if (queryMap.get("priviledeId_like") != null) {
            criteria = criteria.add(Expression.like("priviledeId", "%" + queryMap.get("priviledeId_like") + "%"));
        }

        if (queryMap.get("priviledeType") != null) {
            criteria = criteria.add(Expression.eq("priviledeType", queryMap.get("priviledeType")));
        }
        if (queryMap.get("priviledeType_like") != null) {
            criteria = criteria.add(Expression.like("priviledeType", "%" + queryMap.get("priviledeType_like") + "%"));
        }

        if (queryMap.get("roleId") != null) {
            criteria = criteria.add(Expression.eq("roleId", queryMap.get("roleId")));
        }
        if (queryMap.get("roleId_like") != null) {
            criteria = criteria.add(Expression.like("roleId", "%" + queryMap.get("roleId_like") + "%"));
        }


        //���ݲ�ѯqueryMap�ļ�ֵ���ṩ������,_order="����1 asc|desc,����2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
