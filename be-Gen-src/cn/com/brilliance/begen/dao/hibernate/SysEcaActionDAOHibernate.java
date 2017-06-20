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

import cn.com.brilliance.begen.dao.SysEcaActionDAO;
import cn.com.brilliance.begen.model.SysEcaAction;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysEcaActionDAO接口具体实现类.
 * @author Administrator.
 */

public class SysEcaActionDAOHibernate extends BeGenHibernateDaoSupport implements SysEcaActionDAO {    

    /**
     *  根据主键获得SysEcaAction对象.
     *  @param pkey SysEcaAction主键
     *  @return SysEcaAction.
     */
    public SysEcaAction getSysEcaAction(java.lang.String pkey) {
        SysEcaAction sysEcaAction = (SysEcaAction) getHibernateTemplate().get(SysEcaAction.class, pkey);
        if (sysEcaAction == null) {
            return sysEcaAction;
        }
        return sysEcaAction;

    }

    /**
     *  存储SysEcaAction对象.
     *  @param  sysEcaAction SysEcaAction对象
     *  @return SysEcaAction.
     */
    public SysEcaAction saveSysEcaAction(SysEcaAction sysEcaAction) {
        return (SysEcaAction) getHibernateTemplate().merge(sysEcaAction);
    }

    /**
     *  删除SysEcaAction对象.
     *  @param pkey SysEcaAction主键.
     */
    public void removeSysEcaAction(java.lang.String pkey) {
        SysEcaAction sysEcaAction = getSysEcaAction(pkey);
        getHibernateTemplate().delete(sysEcaAction);
    }

    /**
     *  获取SysEcaAction对象列表.
     *  @param  sysEcaAction SysEcaAction对象
     *  @return List.
     */
    public List getSysEcaActionList(SysEcaAction sysEcaAction) {
        Criteria criteria = getSession().createCriteria(SysEcaAction.class).add(
                Example.create(sysEcaAction));
        if (sysEcaAction.getId() != null) {
            criteria.add(Expression.eq("id", sysEcaAction.getId()));
        }
        return criteria.list();
    }

    /**
     *  根据查询条件获取SysEcaAction对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysEcaActionListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysEcaAction where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysEcaAction.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取SysEcaAction对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysEcaActionListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysEcaAction where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysEcaAction.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤SysEcaAction对象
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

        if (queryMap.get("actionType") != null) {
            criteria = criteria.add(Expression.eq("actionType", queryMap.get("actionType")));
        }
        if (queryMap.get("actionType_like") != null) {
            criteria = criteria.add(Expression.like("actionType", "%" + queryMap.get("actionType_like") + "%"));
        }

        if (queryMap.get("content") != null) {
            criteria = criteria.add(Expression.eq("content", queryMap.get("content")));
        }
        if (queryMap.get("content_like") != null) {
            criteria = criteria.add(Expression.like("content", "%" + queryMap.get("content_like") + "%"));
        }

        if (queryMap.get("description") != null) {
            criteria = criteria.add(Expression.eq("description", queryMap.get("description")));
        }
        if (queryMap.get("description_like") != null) {
            criteria = criteria.add(Expression.like("description", "%" + queryMap.get("description_like") + "%"));
        }

        if (queryMap.get("ecaDefId") != null) {
            criteria = criteria.add(Expression.eq("ecaDefId", queryMap.get("ecaDefId")));
        }
        if (queryMap.get("ecaDefId_like") != null) {
            criteria = criteria.add(Expression.like("ecaDefId", "%" + queryMap.get("ecaDefId_like") + "%"));
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
