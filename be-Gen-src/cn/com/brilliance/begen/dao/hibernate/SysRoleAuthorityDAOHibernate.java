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

import cn.com.brilliance.begen.dao.SysRoleAuthorityDAO;
import cn.com.brilliance.begen.model.SysRoleAuthority;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysRoleAuthorityDAO接口具体实现类.
 * @author Administrator.
 */

public class SysRoleAuthorityDAOHibernate extends BeGenHibernateDaoSupport implements SysRoleAuthorityDAO {    

    /**
     *  根据主键获得SysRoleAuthority对象.
     *  @param pkey SysRoleAuthority主键
     *  @return SysRoleAuthority.
     */
    public SysRoleAuthority getSysRoleAuthority(java.lang.String pkey) {
        SysRoleAuthority sysRoleAuthority = (SysRoleAuthority) getHibernateTemplate().get(SysRoleAuthority.class, pkey);
        if (sysRoleAuthority == null) {
            return sysRoleAuthority;
        }
        return sysRoleAuthority;

    }

    /**
     *  存储SysRoleAuthority对象.
     *  @param  sysRoleAuthority SysRoleAuthority对象
     *  @return SysRoleAuthority.
     */
    public SysRoleAuthority saveSysRoleAuthority(SysRoleAuthority sysRoleAuthority) {
        return (SysRoleAuthority) getHibernateTemplate().merge(sysRoleAuthority);
    }

    /**
     *  删除SysRoleAuthority对象.
     *  @param pkey SysRoleAuthority主键.
     */
    public void removeSysRoleAuthority(java.lang.String pkey) {
        SysRoleAuthority sysRoleAuthority = getSysRoleAuthority(pkey);
        getHibernateTemplate().delete(sysRoleAuthority);
    }

    /**
     *  获取SysRoleAuthority对象列表.
     *  @param  sysRoleAuthority SysRoleAuthority对象
     *  @return List.
     */
    public List getSysRoleAuthorityList(SysRoleAuthority sysRoleAuthority) {
        Criteria criteria = getSession().createCriteria(SysRoleAuthority.class).add(
                Example.create(sysRoleAuthority));
        if (sysRoleAuthority.getId() != null) {
            criteria.add(Expression.eq("id", sysRoleAuthority.getId()));
        }
        return criteria.list();
    }

    /**
     *  根据查询条件获取SysRoleAuthority对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysRoleAuthorityListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysRoleAuthority where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysRoleAuthority.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取SysRoleAuthority对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysRoleAuthorityListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysRoleAuthority where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysRoleAuthority.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤SysRoleAuthority对象
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

        if (queryMap.get("actionId") != null) {
            criteria = criteria.add(Expression.eq("actionId", queryMap.get("actionId")));
        }
        if (queryMap.get("actionId_like") != null) {
            criteria = criteria.add(Expression.like("actionId", "%" + queryMap.get("actionId_like") + "%"));
        }

        if (queryMap.get("roleId") != null) {
            criteria = criteria.add(Expression.eq("roleId", queryMap.get("roleId")));
        }
        if (queryMap.get("roleId_like") != null) {
            criteria = criteria.add(Expression.like("roleId", "%" + queryMap.get("roleId_like") + "%"));
        }

        if (queryMap.get("authorityType") != null) {
            criteria = criteria.add(Expression.eq("authorityType", queryMap.get("authorityType")));
        }
        if (queryMap.get("authorityType_like") != null) {
            criteria = criteria.add(Expression.like("authorityType", "%" + queryMap.get("authorityType_like") + "%"));
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
