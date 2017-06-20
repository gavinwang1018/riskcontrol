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

import cn.com.brilliance.begen.dao.SysFieldDAO;
import cn.com.brilliance.begen.model.SysField;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysFieldDAO接口具体实现类.
 * @author Administrator.
 */

public class SysFieldDAOHibernate extends BeGenHibernateDaoSupport implements SysFieldDAO {    

    /**
     *  根据主键获得SysField对象.
     *  @param pkey SysField主键
     *  @return SysField.
     */
    public SysField getSysField(java.lang.String pkey) {
        SysField sysField = (SysField) getHibernateTemplate().get(SysField.class, pkey);
        if (sysField == null) {
            return sysField;
        }
        return sysField;

    }

    /**
     *  存储SysField对象.
     *  @param  sysField SysField对象
     *  @return SysField.
     */
    public SysField saveSysField(SysField sysField) {
        return (SysField) getHibernateTemplate().merge(sysField);
    }

    /**
     *  删除SysField对象.
     *  @param pkey SysField主键.
     */
    public void removeSysField(java.lang.String pkey) {
        SysField sysField = getSysField(pkey);
        getHibernateTemplate().delete(sysField);
    }

    /**
     *  获取SysField对象列表.
     *  @param  sysField SysField对象
     *  @return List.
     */
    public List getSysFieldList(SysField sysField) {
        Criteria criteria = getSession().createCriteria(SysField.class).add(
                Example.create(sysField));
        if (sysField.getId() != null) {
            criteria.add(Expression.eq("id", sysField.getId()));
        }
        criteria.addOrder(Order.asc("sysRecordOrder"));
        return criteria.list();
    }

    /**
     *  根据查询条件获取SysField对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysFieldListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysField where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysField.class);

        criteria.addOrder(Order.asc("sysRecordOrder"));
        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取SysField对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysFieldListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysField where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysField.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤SysField对象
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

        if (queryMap.get("standard") != null) {
            criteria = criteria.add(Expression.eq("standard", new Boolean((String) queryMap.get("standard"))));
        }
        if (queryMap.get("type") != null) {
            criteria = criteria.add(Expression.eq("type", queryMap.get("type")));
        }
        if (queryMap.get("type_like") != null) {
            criteria = criteria.add(Expression.like("type", "%" + queryMap.get("type_like") + "%"));
        }

        if (queryMap.get("formula") != null) {
            criteria = criteria.add(Expression.eq("formula", queryMap.get("formula")));
        }
        if (queryMap.get("formula_like") != null) {
            criteria = criteria.add(Expression.like("formula", "%" + queryMap.get("formula_like") + "%"));
        }

        if (queryMap.get("checked") != null) {
            criteria = criteria.add(Expression.eq("checked", new Boolean((String) queryMap.get("checked"))));
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
        if (queryMap.get("numDecimal") != null) {
            criteria = criteria.add(Expression.eq("numDecimal", new Integer((String) queryMap.get("numDecimal"))));
        }
        if (queryMap.get("numDecimal_min") != null) {
            criteria = criteria.add(Expression.ge("numDecimal", new Integer((String) queryMap.get("numDecimal_min"))));
        }
        if (queryMap.get("numDecimal_max") != null) {
            criteria = criteria.add(Expression.le("numDecimal", new Integer((String) queryMap.get("numDecimal_max"))));
        }
        if (queryMap.get("dataObject") != null) {
            criteria = criteria.add(Expression.eq("dataObject", queryMap.get("dataObject")));
        }
        if (queryMap.get("dataObject_like") != null) {
            criteria = criteria.add(Expression.like("dataObject", "%" + queryMap.get("dataObject_like") + "%"));
        }

        if (queryMap.get("lookupParameter") != null) {
            criteria = criteria.add(Expression.eq("lookupParameter", queryMap.get("lookupParameter")));
        }
        if (queryMap.get("lookupParameter_like") != null) {
            criteria = criteria.add(Expression.like("lookupParameter", "%" + queryMap.get("lookupParameter_like") + "%"));
        }

        if (queryMap.get("mask") != null) {
            criteria = criteria.add(Expression.eq("mask", queryMap.get("mask")));
        }
        if (queryMap.get("mask_like") != null) {
            criteria = criteria.add(Expression.like("mask", "%" + queryMap.get("mask_like") + "%"));
        }

        if (queryMap.get("viewSize") != null) {
            criteria = criteria.add(Expression.eq("viewSize", new Integer((String) queryMap.get("viewSize"))));
        }
        if (queryMap.get("viewSize_min") != null) {
            criteria = criteria.add(Expression.ge("viewSize", new Integer((String) queryMap.get("viewSize_min"))));
        }
        if (queryMap.get("viewSize_max") != null) {
            criteria = criteria.add(Expression.le("viewSize", new Integer((String) queryMap.get("viewSize_max"))));
        }
        if (queryMap.get("lookupFieldType") != null) {
            criteria = criteria.add(Expression.eq("lookupFieldType", queryMap.get("lookupFieldType")));
        }
        if (queryMap.get("lookupFieldType_like") != null) {
            criteria = criteria.add(Expression.like("lookupFieldType", "%" + queryMap.get("lookupFieldType_like") + "%"));
        }

        if (queryMap.get("defaultValue") != null) {
            criteria = criteria.add(Expression.eq("defaultValue", queryMap.get("defaultValue")));
        }
        if (queryMap.get("defaultValue_like") != null) {
            criteria = criteria.add(Expression.like("defaultValue", "%" + queryMap.get("defaultValue_like") + "%"));
        }

        if (queryMap.get("editFlag") != null) {
            criteria = criteria.add(Expression.eq("editFlag", new Boolean((String) queryMap.get("editFlag"))));
        }
        if (queryMap.get("partyId") != null) {
            criteria = criteria.add(Expression.eq("partyId", queryMap.get("partyId")));
        }
        if (queryMap.get("partyId_like") != null) {
            criteria = criteria.add(Expression.like("partyId", "%" + queryMap.get("partyId_like") + "%"));
        }

        if (queryMap.get("selectItem") != null) {
            criteria = criteria.add(Expression.eq("selectItem", queryMap.get("selectItem")));
        }
        if (queryMap.get("selectItem_like") != null) {
            criteria = criteria.add(Expression.like("selectItem", "%" + queryMap.get("selectItem_like") + "%"));
        }

        if (queryMap.get("visibleCols") != null) {
            criteria = criteria.add(Expression.eq("visibleCols", new Integer((String) queryMap.get("visibleCols"))));
        }
        if (queryMap.get("visibleCols_min") != null) {
            criteria = criteria.add(Expression.ge("visibleCols", new Integer((String) queryMap.get("visibleCols_min"))));
        }
        if (queryMap.get("visibleCols_max") != null) {
            criteria = criteria.add(Expression.le("visibleCols", new Integer((String) queryMap.get("visibleCols_max"))));
        }
        if (queryMap.get("relationObject") != null) {
            criteria = criteria.add(Expression.eq("relationObject", queryMap.get("relationObject")));
        }
        if (queryMap.get("relationObject_like") != null) {
            criteria = criteria.add(Expression.like("relationObject", "%" + queryMap.get("relationObject_like") + "%"));
        }

        if (queryMap.get("autoNumberStart") != null) {
            criteria = criteria.add(Expression.eq("autoNumberStart", new Integer((String) queryMap.get("autoNumberStart"))));
        }
        if (queryMap.get("autoNumberStart_min") != null) {
            criteria = criteria.add(Expression.ge("autoNumberStart", new Integer((String) queryMap.get("autoNumberStart_min"))));
        }
        if (queryMap.get("autoNumberStart_max") != null) {
            criteria = criteria.add(Expression.le("autoNumberStart", new Integer((String) queryMap.get("autoNumberStart_max"))));
        }
        if (queryMap.get("autoNumberFormat") != null) {
            criteria = criteria.add(Expression.eq("autoNumberFormat", queryMap.get("autoNumberFormat")));
        }
        if (queryMap.get("autoNumberFormat_like") != null) {
            criteria = criteria.add(Expression.like("autoNumberFormat", "%" + queryMap.get("autoNumberFormat_like") + "%"));
        }

        if (queryMap.get("formulaReturnType") != null) {
            criteria = criteria.add(Expression.eq("formulaReturnType", queryMap.get("formulaReturnType")));
        }
        if (queryMap.get("formulaReturnType_like") != null) {
            criteria = criteria.add(Expression.like("formulaReturnType", "%" + queryMap.get("formulaReturnType_like") + "%"));
        }

        if (queryMap.get("primateKey") != null) {
            criteria = criteria.add(Expression.eq("primateKey", new Boolean((String) queryMap.get("primateKey"))));
        }
        if (queryMap.get("visibleLines") != null) {
            criteria = criteria.add(Expression.eq("visibleLines", new Integer((String) queryMap.get("visibleLines"))));
        }
        if (queryMap.get("visibleLines_min") != null) {
            criteria = criteria.add(Expression.ge("visibleLines", new Integer((String) queryMap.get("visibleLines_min"))));
        }
        if (queryMap.get("visibleLines_max") != null) {
            criteria = criteria.add(Expression.le("visibleLines", new Integer((String) queryMap.get("visibleLines_max"))));
        }
        if (queryMap.get("indexFlag") != null) {
            criteria = criteria.add(Expression.eq("indexFlag", new Boolean((String) queryMap.get("indexFlag"))));
        }

        //根据查询queryMap的键值，提供排序功能,_order="域名1 asc|desc,域名2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
