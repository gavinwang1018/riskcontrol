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

import cn.com.brilliance.begen.dao.SysItemDAO;
import cn.com.brilliance.begen.model.SysItem;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysItemDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class SysItemDAOHibernate extends BeGenHibernateDaoSupport implements SysItemDAO {    

    /**
     *  �����������SysItem����.
     *  @param pkey SysItem����
     *  @return SysItem.
     */
    public SysItem getSysItem(java.lang.String pkey) {
        SysItem sysItem = (SysItem) getHibernateTemplate().get(SysItem.class, pkey);
        if (sysItem == null) {
            return sysItem;
        }
        return sysItem;

    }

    /**
     *  �洢SysItem����.
     *  @param  sysItem SysItem����
     *  @return SysItem.
     */
    public SysItem saveSysItem(SysItem sysItem) {
        return (SysItem) getHibernateTemplate().merge(sysItem);
    }

    /**
     *  ɾ��SysItem����.
     *  @param pkey SysItem����.
     */
    public void removeSysItem(java.lang.String pkey) {
        SysItem sysItem = getSysItem(pkey);
        getHibernateTemplate().delete(sysItem);
    }

    /**
     *  ��ȡSysItem�����б�.
     *  @param  sysItem SysItem����
     *  @return List.
     */
    public List getSysItemList(SysItem sysItem) {
        Criteria criteria = getSession().createCriteria(SysItem.class).add(
                Example.create(sysItem));
        if (sysItem.getId() != null) {
            criteria.add(Expression.eq("id", sysItem.getId()));
        }
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡSysItem�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysItemListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysItem where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysItem.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡSysItem�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysItemListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysItem where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysItem.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������SysItem����
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

        if (queryMap.get("section") != null) {
            criteria = criteria.add(Expression.eq("section", queryMap.get("section")));
        }
        if (queryMap.get("section_like") != null) {
            criteria = criteria.add(Expression.like("section", "%" + queryMap.get("section_like") + "%"));
        }

        if (queryMap.get("label") != null) {
            criteria = criteria.add(Expression.eq("label", queryMap.get("label")));
        }
        if (queryMap.get("label_like") != null) {
            criteria = criteria.add(Expression.like("label", "%" + queryMap.get("label_like") + "%"));
        }

        if (queryMap.get("readonly") != null) {
            criteria = criteria.add(Expression.eq("readonly", new Boolean((String) queryMap.get("readonly"))));
        }
        if (queryMap.get("required") != null) {
            criteria = criteria.add(Expression.eq("required", new Boolean((String) queryMap.get("required"))));
        }
        if (queryMap.get("seq") != null) {
            criteria = criteria.add(Expression.eq("seq", new Integer((String) queryMap.get("seq"))));
        }
        if (queryMap.get("seq_min") != null) {
            criteria = criteria.add(Expression.ge("seq", new Integer((String) queryMap.get("seq_min"))));
        }
        if (queryMap.get("seq_max") != null) {
            criteria = criteria.add(Expression.le("seq", new Integer((String) queryMap.get("seq_max"))));
        }
        if (queryMap.get("col") != null) {
            criteria = criteria.add(Expression.eq("col", new Integer((String) queryMap.get("col"))));
        }
        if (queryMap.get("col_min") != null) {
            criteria = criteria.add(Expression.ge("col", new Integer((String) queryMap.get("col_min"))));
        }
        if (queryMap.get("col_max") != null) {
            criteria = criteria.add(Expression.le("col", new Integer((String) queryMap.get("col_max"))));
        }
        if (queryMap.get("colspan") != null) {
            criteria = criteria.add(Expression.eq("colspan", new Integer((String) queryMap.get("colspan"))));
        }
        if (queryMap.get("colspan_min") != null) {
            criteria = criteria.add(Expression.ge("colspan", new Integer((String) queryMap.get("colspan_min"))));
        }
        if (queryMap.get("colspan_max") != null) {
            criteria = criteria.add(Expression.le("colspan", new Integer((String) queryMap.get("colspan_max"))));
        }
        if (queryMap.get("partyId") != null) {
            criteria = criteria.add(Expression.eq("partyId", queryMap.get("partyId")));
        }
        if (queryMap.get("partyId_like") != null) {
            criteria = criteria.add(Expression.like("partyId", "%" + queryMap.get("partyId_like") + "%"));
        }

        if (queryMap.get("sysField") != null) {
            criteria = criteria.add(Expression.eq("sysField", queryMap.get("sysField")));
        }
        if (queryMap.get("sysField_like") != null) {
            criteria = criteria.add(Expression.like("sysField", "%" + queryMap.get("sysField_like") + "%"));
        }

        if (queryMap.get("relationField") != null) {
            criteria = criteria.add(Expression.eq("relationField", queryMap.get("relationField")));
        }
        if (queryMap.get("relationField_like") != null) {
            criteria = criteria.add(Expression.like("relationField", "%" + queryMap.get("relationField_like") + "%"));
        }


        //���ݲ�ѯqueryMap�ļ�ֵ���ṩ������,_order="����1 asc|desc,����2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
