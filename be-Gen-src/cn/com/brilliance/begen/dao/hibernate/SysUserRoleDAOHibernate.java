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

import cn.com.brilliance.begen.dao.SysUserRoleDAO;
import cn.com.brilliance.begen.model.SysUserRole;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysUserRoleDAO接口具体实现类.
 * @author Administrator.
 */

public class SysUserRoleDAOHibernate extends BeGenHibernateDaoSupport implements SysUserRoleDAO {    

    /**
     *  根据主键获得SysUserRole对象.
     *  @param pkey SysUserRole主键
     *  @return SysUserRole.
     */
    public SysUserRole getSysUserRole(java.lang.String pkey) {
        SysUserRole sysUserRole = (SysUserRole) getHibernateTemplate().get(SysUserRole.class, pkey);
        if (sysUserRole == null) {
            return sysUserRole;
        }
        return sysUserRole;

    }

    /**
     *  存储SysUserRole对象.
     *  @param  sysUserRole SysUserRole对象
     *  @return SysUserRole.
     */
    public SysUserRole saveSysUserRole(SysUserRole sysUserRole) {
        return (SysUserRole) getHibernateTemplate().merge(sysUserRole);
    }

    /**
     *  删除SysUserRole对象.
     *  @param pkey SysUserRole主键.
     */
    public void removeSysUserRole(java.lang.String pkey) {
        SysUserRole sysUserRole = getSysUserRole(pkey);
        getHibernateTemplate().delete(sysUserRole);
    }

    /**
     *  获取SysUserRole对象列表.
     *  @param  sysUserRole SysUserRole对象
     *  @return List.
     */
    public List getSysUserRoleList(SysUserRole sysUserRole) {
        Criteria criteria = getSession().createCriteria(SysUserRole.class).add(
                Example.create(sysUserRole));
        if (sysUserRole.getId() != null) {
            criteria.add(Expression.eq("id", sysUserRole.getId()));
        }
        return criteria.list();
    }

    /**
     *  根据查询条件获取SysUserRole对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysUserRoleListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysUserRole where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysUserRole.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取SysUserRole对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysUserRoleListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysUserRole where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysUserRole.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤SysUserRole对象
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

        if (queryMap.get("userId") != null) {
            criteria = criteria.add(Expression.eq("userId", queryMap.get("userId")));
        }
        if (queryMap.get("userId_like") != null) {
            criteria = criteria.add(Expression.like("userId", "%" + queryMap.get("userId_like") + "%"));
        }

        if (queryMap.get("roleId") != null) {
            criteria = criteria.add(Expression.eq("roleId", queryMap.get("roleId")));
        }
        if (queryMap.get("roleId_like") != null) {
            criteria = criteria.add(Expression.like("roleId", "%" + queryMap.get("roleId_like") + "%"));
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
