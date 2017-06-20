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

import cn.com.brilliance.begen.dao.SysDataObjectDAO;
import cn.com.brilliance.begen.model.SysDataObject;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysDataObjectDAO接口具体实现类.
 * @author Administrator.
 */

public class SysDataObjectDAOHibernate extends BeGenHibernateDaoSupport implements SysDataObjectDAO {    

    /**
     *  根据主键获得SysDataObject对象.
     *  @param pkey SysDataObject主键
     *  @return SysDataObject.
     */
    public SysDataObject getSysDataObject(java.lang.String pkey) {
        SysDataObject sysDataObject = (SysDataObject) getHibernateTemplate().get(SysDataObject.class, pkey);
        if (sysDataObject == null) {
            return sysDataObject;
        }
        return sysDataObject;

    }

    /**
     *  存储SysDataObject对象.
     *  @param  sysDataObject SysDataObject对象
     *  @return SysDataObject.
     */
    public SysDataObject saveSysDataObject(SysDataObject sysDataObject) {
        return (SysDataObject) getHibernateTemplate().merge(sysDataObject);
    }

    /**
     *  删除SysDataObject对象.
     *  @param pkey SysDataObject主键.
     */
    public void removeSysDataObject(java.lang.String pkey) {
        SysDataObject sysDataObject = getSysDataObject(pkey);
        getHibernateTemplate().delete(sysDataObject);
    }

    /**
     *  获取SysDataObject对象列表.
     *  @param  sysDataObject SysDataObject对象
     *  @return List.
     */
    public List getSysDataObjectList(SysDataObject sysDataObject) {
        Criteria criteria = getSession().createCriteria(SysDataObject.class).add(
                Example.create(sysDataObject));
        if (sysDataObject.getId() != null) {
            criteria.add(Expression.eq("id", sysDataObject.getId()));
        }
        return criteria.list();
    }

    /**
     *  根据查询条件获取SysDataObject对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysDataObjectListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysDataObject where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysDataObject.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取SysDataObject对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysDataObjectListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysDataObject where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysDataObject.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤SysDataObject对象
        Object[] keyArray = queryMap.keySet().toArray();  //转换查询字段名keySet为数组
        //遍历该数组，去除对应查询字段值为空的键值
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

        if (queryMap.get("label") != null) {
            criteria = criteria.add(Expression.eq("label", queryMap.get("label")));
        }
        if (queryMap.get("label_like") != null) {
            criteria = criteria.add(Expression.like("label", "%" + queryMap.get("label_like") + "%"));
        }

        if (queryMap.get("description") != null) {
            criteria = criteria.add(Expression.eq("description", queryMap.get("description")));
        }
        if (queryMap.get("description_like") != null) {
            criteria = criteria.add(Expression.like("description", "%" + queryMap.get("description_like") + "%"));
        }

        if (queryMap.get("shareFlag") != null) {
            criteria = criteria.add(Expression.eq("shareFlag", queryMap.get("shareFlag")));
        }
        if (queryMap.get("shareFlag_like") != null) {
            criteria = criteria.add(Expression.like("shareFlag", "%" + queryMap.get("shareFlag_like") + "%"));
        }

        if (queryMap.get("shareRole") != null) {
            criteria = criteria.add(Expression.eq("shareRole", queryMap.get("shareRole")));
        }
        if (queryMap.get("shareRole_like") != null) {
            criteria = criteria.add(Expression.like("shareRole", "%" + queryMap.get("shareRole_like") + "%"));
        }

        if (queryMap.get("shareOrg") != null) {
            criteria = criteria.add(Expression.eq("shareOrg", queryMap.get("shareOrg")));
        }
        if (queryMap.get("shareOrg_like") != null) {
            criteria = criteria.add(Expression.like("shareOrg", "%" + queryMap.get("shareOrg_like") + "%"));
        }

        if (queryMap.get("validatorRule") != null) {
            criteria = criteria.add(Expression.eq("validatorRule", queryMap.get("validatorRule")));
        }
        if (queryMap.get("validatorRule_like") != null) {
            criteria = criteria.add(Expression.like("validatorRule", "%" + queryMap.get("validatorRule_like") + "%"));
        }

        if (queryMap.get("standard") != null) {
            criteria = criteria.add(Expression.eq("standard", new Boolean((String) queryMap.get("standard"))));
        }
        if (queryMap.get("partyId") != null) {
            criteria = criteria.add(Expression.eq("partyId", queryMap.get("partyId")));
        }
        if (queryMap.get("partyId_like") != null) {
            criteria = criteria.add(Expression.like("partyId", "%" + queryMap.get("partyId_like") + "%"));
        }

        if (queryMap.get("orderFlag") != null) {
            criteria = criteria.add(Expression.eq("orderFlag", new Boolean((String) queryMap.get("orderFlag"))));
        }
        if (queryMap.get("lookupLayout") != null) {
            criteria = criteria.add(Expression.eq("lookupLayout", queryMap.get("lookupLayout")));
        }
        if (queryMap.get("lookupLayout_like") != null) {
            criteria = criteria.add(Expression.like("lookupLayout", "%" + queryMap.get("lookupLayout_like") + "%"));
        }

        if (queryMap.get("labelField") != null) {
            criteria = criteria.add(Expression.eq("labelField", queryMap.get("labelField")));
        }
        if (queryMap.get("labelField_like") != null) {
            criteria = criteria.add(Expression.like("labelField", "%" + queryMap.get("labelField_like") + "%"));
        }


        //根据查询queryMap的键值，提供排序功能,_order="域名1 asc|desc,域名2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
