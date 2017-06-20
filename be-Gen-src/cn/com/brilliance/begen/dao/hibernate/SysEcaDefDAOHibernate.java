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

import cn.com.brilliance.begen.dao.SysEcaDefDAO;
import cn.com.brilliance.begen.model.SysEcaDef;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysEcaDefDAO接口具体实现类.
 * @author Administrator.
 */

public class SysEcaDefDAOHibernate extends BeGenHibernateDaoSupport implements SysEcaDefDAO {    

    /**
     *  根据主键获得SysEcaDef对象.
     *  @param pkey SysEcaDef主键
     *  @return SysEcaDef.
     */
    public SysEcaDef getSysEcaDef(java.lang.String pkey) {
        SysEcaDef sysEcaDef = (SysEcaDef) getHibernateTemplate().get(SysEcaDef.class, pkey);
        if (sysEcaDef == null) {
            return sysEcaDef;
        }
        return sysEcaDef;

    }

    /**
     *  存储SysEcaDef对象.
     *  @param  sysEcaDef SysEcaDef对象
     *  @return SysEcaDef.
     */
    public SysEcaDef saveSysEcaDef(SysEcaDef sysEcaDef) {
        return (SysEcaDef) getHibernateTemplate().merge(sysEcaDef);
    }

    /**
     *  删除SysEcaDef对象.
     *  @param pkey SysEcaDef主键.
     */
    public void removeSysEcaDef(java.lang.String pkey) {
        SysEcaDef sysEcaDef = getSysEcaDef(pkey);
        getHibernateTemplate().delete(sysEcaDef);
    }

    /**
     *  获取SysEcaDef对象列表.
     *  @param  sysEcaDef SysEcaDef对象
     *  @return List.
     */
    public List getSysEcaDefList(SysEcaDef sysEcaDef) {
        Criteria criteria = getSession().createCriteria(SysEcaDef.class).add(
                Example.create(sysEcaDef));
        if (sysEcaDef.getId() != null) {
            criteria.add(Expression.eq("id", sysEcaDef.getId()));
        }
        return criteria.list();
    }

    /**
     *  根据查询条件获取SysEcaDef对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysEcaDefListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysEcaDef where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysEcaDef.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取SysEcaDef对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysEcaDefListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysEcaDef where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysEcaDef.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤SysEcaDef对象
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

        if (queryMap.get("dataObject") != null) {
            criteria = criteria.add(Expression.eq("dataObject", queryMap.get("dataObject")));
        }
        if (queryMap.get("dataObject_like") != null) {
            criteria = criteria.add(Expression.like("dataObject", "%" + queryMap.get("dataObject_like") + "%"));
        }

        if (queryMap.get("actionType") != null) {
            criteria = criteria.add(Expression.eq("actionType", queryMap.get("actionType")));
        }
        if (queryMap.get("actionType_like") != null) {
            criteria = criteria.add(Expression.like("actionType", "%" + queryMap.get("actionType_like") + "%"));
        }

        if (queryMap.get("eventExpress") != null) {
            criteria = criteria.add(Expression.eq("eventExpress", queryMap.get("eventExpress")));
        }
        if (queryMap.get("eventExpress_like") != null) {
            criteria = criteria.add(Expression.like("eventExpress", "%" + queryMap.get("eventExpress_like") + "%"));
        }

        if (queryMap.get("description") != null) {
            criteria = criteria.add(Expression.eq("description", queryMap.get("description")));
        }
        if (queryMap.get("description_like") != null) {
            criteria = criteria.add(Expression.like("description", "%" + queryMap.get("description_like") + "%"));
        }

        if (queryMap.get("partyId") != null) {
            criteria = criteria.add(Expression.eq("partyId", queryMap.get("partyId")));
        }
        if (queryMap.get("partyId_like") != null) {
            criteria = criteria.add(Expression.like("partyId", "%" + queryMap.get("partyId_like") + "%"));
        }


        //根据查询queryMap的键值，提供排序功能,_order="域名1 asc|desc,域名2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
