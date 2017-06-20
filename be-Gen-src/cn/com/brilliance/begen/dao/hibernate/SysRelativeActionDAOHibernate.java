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

import cn.com.brilliance.begen.dao.SysRelativeActionDAO;
import cn.com.brilliance.begen.model.SysRelativeAction;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysRelativeActionDAO接口具体实现类.
 * @author Administrator.
 */

public class SysRelativeActionDAOHibernate extends BeGenHibernateDaoSupport implements SysRelativeActionDAO {    

    /**
     *  根据主键获得SysRelativeAction对象.
     *  @param pkey SysRelativeAction主键
     *  @return SysRelativeAction.
     */
    public SysRelativeAction getSysRelativeAction(java.lang.String pkey) {
        SysRelativeAction sysRelativeAction = (SysRelativeAction) getHibernateTemplate().get(SysRelativeAction.class, pkey);
        if (sysRelativeAction == null) {
            return sysRelativeAction;
        }
        return sysRelativeAction;

    }

    /**
     *  存储SysRelativeAction对象.
     *  @param  sysRelativeAction SysRelativeAction对象
     *  @return SysRelativeAction.
     */
    public SysRelativeAction saveSysRelativeAction(SysRelativeAction sysRelativeAction) {
        return (SysRelativeAction) getHibernateTemplate().merge(sysRelativeAction);
    }

    /**
     *  删除SysRelativeAction对象.
     *  @param pkey SysRelativeAction主键.
     */
    public void removeSysRelativeAction(java.lang.String pkey) {
        SysRelativeAction sysRelativeAction = getSysRelativeAction(pkey);
        getHibernateTemplate().delete(sysRelativeAction);
    }

    /**
     *  获取SysRelativeAction对象列表.
     *  @param  sysRelativeAction SysRelativeAction对象
     *  @return List.
     */
    public List getSysRelativeActionList(SysRelativeAction sysRelativeAction) {
        Criteria criteria = getSession().createCriteria(SysRelativeAction.class).add(
                Example.create(sysRelativeAction));
        if (sysRelativeAction.getId() != null) {
            criteria.add(Expression.eq("id", sysRelativeAction.getId()));
        }
        return criteria.list();
    }

    /**
     *  根据查询条件获取SysRelativeAction对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysRelativeActionListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysRelativeAction where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysRelativeAction.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取SysRelativeAction对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysRelativeActionListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysRelativeAction where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysRelativeAction.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤SysRelativeAction对象
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

        if (queryMap.get("rule") != null) {
            criteria = criteria.add(Expression.eq("rule", queryMap.get("rule")));
        }
        if (queryMap.get("rule_like") != null) {
            criteria = criteria.add(Expression.like("rule", "%" + queryMap.get("rule_like") + "%"));
        }

        if (queryMap.get("inputField_like") != null) {
            criteria = criteria.add(Expression.like("inputField", "%" + queryMap.get("inputField_like") + "%"));
        }
        if (queryMap.get("formLayout") != null) {
            criteria = criteria.add(Expression.eq("formLayout", queryMap.get("formLayout")));
        }
        if (queryMap.get("formLayout_like") != null) {
            criteria = criteria.add(Expression.like("formLayout", "%" + queryMap.get("formLayout_like") + "%"));
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
