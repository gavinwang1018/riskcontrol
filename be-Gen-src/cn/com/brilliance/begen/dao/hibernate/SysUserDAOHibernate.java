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

import cn.com.brilliance.begen.dao.SysUserDAO;
import cn.com.brilliance.begen.model.SysUser;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysUserDAO接口具体实现类.
 * @author Administrator.
 */

public class SysUserDAOHibernate extends BeGenHibernateDaoSupport implements SysUserDAO {    

    /**
     *  根据主键获得SysUser对象.
     *  @param pkey SysUser主键
     *  @return SysUser.
     */
    public SysUser getSysUser(java.lang.String pkey) {
        SysUser sysUser = (SysUser) getHibernateTemplate().get(SysUser.class, pkey);
        if (sysUser == null) {
            return sysUser;
        }
        return sysUser;

    }

    /**
     *  存储SysUser对象.
     *  @param  sysUser SysUser对象
     *  @return SysUser.
     */
    public SysUser saveSysUser(SysUser sysUser) {
        return (SysUser) getHibernateTemplate().merge(sysUser);
    }

    /**
     *  删除SysUser对象.
     *  @param pkey SysUser主键.
     */
    public void removeSysUser(java.lang.String pkey) {
        SysUser sysUser = getSysUser(pkey);
        getHibernateTemplate().delete(sysUser);
    }

    /**
     *  获取SysUser对象列表.
     *  @param  sysUser SysUser对象
     *  @return List.
     */
    public List getSysUserList(SysUser sysUser) {
        Criteria criteria = getSession().createCriteria(SysUser.class).add(
                Example.create(sysUser));
        if (sysUser.getId() != null) {
            criteria.add(Expression.eq("id", sysUser.getId()));
        }
        return criteria.list();
    }

    /**
     *  根据查询条件获取SysUser对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysUserListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysUser where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysUser.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取SysUser对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysUserListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysUser where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysUser.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤SysUser对象
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

        if (queryMap.get("userName") != null) {
            criteria = criteria.add(Expression.eq("userName", queryMap.get("userName")));
        }
        if (queryMap.get("userName_like") != null) {
            criteria = criteria.add(Expression.like("userName", "%" + queryMap.get("userName_like") + "%"));
        }

        if (queryMap.get("password") != null) {
            criteria = criteria.add(Expression.eq("password", queryMap.get("password")));
        }
        if (queryMap.get("password_like") != null) {
            criteria = criteria.add(Expression.like("password", "%" + queryMap.get("password_like") + "%"));
        }

        if (queryMap.get("orgId") != null) {
            criteria = criteria.add(Expression.eq("orgId", queryMap.get("orgId")));
        }
        if (queryMap.get("orgId_like") != null) {
            criteria = criteria.add(Expression.like("orgId", "%" + queryMap.get("orgId_like") + "%"));
        }

        if (queryMap.get("partyId") != null) {
            criteria = criteria.add(Expression.eq("partyId", queryMap.get("partyId")));
        }
        if (queryMap.get("partyId_like") != null) {
            criteria = criteria.add(Expression.like("partyId", "%" + queryMap.get("partyId_like") + "%"));
        }

        if (queryMap.get("personSex") != null) {
            criteria = criteria.add(Expression.eq("personSex", queryMap.get("personSex")));
        }
        if (queryMap.get("personSex_like") != null) {
            criteria = criteria.add(Expression.like("personSex", "%" + queryMap.get("personSex_like") + "%"));
        }

        if (queryMap.get("email") != null) {
            criteria = criteria.add(Expression.eq("email", queryMap.get("email")));
        }
        if (queryMap.get("email_like") != null) {
            criteria = criteria.add(Expression.like("email", "%" + queryMap.get("email_like") + "%"));
        }

        if (queryMap.get("phone") != null) {
            criteria = criteria.add(Expression.eq("phone", queryMap.get("phone")));
        }
        if (queryMap.get("phone_like") != null) {
            criteria = criteria.add(Expression.like("phone", "%" + queryMap.get("phone_like") + "%"));
        }

        if (queryMap.get("adminFlag") != null) {
            criteria = criteria.add(Expression.eq("adminFlag", new Boolean((String) queryMap.get("adminFlag"))));
        }
        if (queryMap.get("remark") != null) {
            criteria = criteria.add(Expression.eq("remark", queryMap.get("remark")));
        }
        if (queryMap.get("remark_like") != null) {
            criteria = criteria.add(Expression.like("remark", "%" + queryMap.get("remark_like") + "%"));
        }


        //根据查询queryMap的键值，提供排序功能,_order="域名1 asc|desc,域名2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
