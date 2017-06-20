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

import cn.com.brilliance.begen.dao.SysOrgDAO;
import cn.com.brilliance.begen.model.SysOrg;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysOrgDAO接口具体实现类.
 * @author Administrator.
 */

public class SysOrgDAOHibernate extends BeGenHibernateDaoSupport implements SysOrgDAO {    

    /**
     *  根据主键获得SysOrg对象.
     *  @param pkey SysOrg主键
     *  @return SysOrg.
     */
    public SysOrg getSysOrg(java.lang.String pkey) {
        SysOrg sysOrg = (SysOrg) getHibernateTemplate().get(SysOrg.class, pkey);
        if (sysOrg == null) {
            return sysOrg;
        }
        return sysOrg;

    }

    /**
     *  存储SysOrg对象.
     *  @param  sysOrg SysOrg对象
     *  @return SysOrg.
     */
    public SysOrg saveSysOrg(SysOrg sysOrg) {
        return (SysOrg) getHibernateTemplate().merge(sysOrg);
    }

    /**
     *  删除SysOrg对象.
     *  @param pkey SysOrg主键.
     */
    public void removeSysOrg(java.lang.String pkey) {
        SysOrg sysOrg = getSysOrg(pkey);
        getHibernateTemplate().delete(sysOrg);
    }

    /**
     *  获取SysOrg对象列表.
     *  @param  sysOrg SysOrg对象
     *  @return List.
     */
    public List getSysOrgList(SysOrg sysOrg) {
        Criteria criteria = getSession().createCriteria(SysOrg.class).add(
                Example.create(sysOrg));
        if (sysOrg.getId() != null) {
            criteria.add(Expression.eq("id", sysOrg.getId()));
        }
        return criteria.list();
    }

    /**
     *  根据查询条件获取SysOrg对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysOrgListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysOrg where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysOrg.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取SysOrg对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysOrgListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysOrg where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysOrg.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤SysOrg对象
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

        if (queryMap.get("orgId") != null) {
            criteria = criteria.add(Expression.eq("orgId", queryMap.get("orgId")));
        }
        if (queryMap.get("orgId_like") != null) {
            criteria = criteria.add(Expression.like("orgId", "%" + queryMap.get("orgId_like") + "%"));
        }

        if (queryMap.get("orgName") != null) {
            criteria = criteria.add(Expression.eq("orgName", queryMap.get("orgName")));
        }
        if (queryMap.get("orgName_like") != null) {
            criteria = criteria.add(Expression.like("orgName", "%" + queryMap.get("orgName_like") + "%"));
        }

        if (queryMap.get("parentOrg") != null) {
            criteria = criteria.add(Expression.eq("parentOrg", queryMap.get("parentOrg")));
        }
        if (queryMap.get("parentOrg_like") != null) {
            criteria = criteria.add(Expression.like("parentOrg", "%" + queryMap.get("parentOrg_like") + "%"));
        }

        if (queryMap.get("masterOrg") != null) {
            criteria = criteria.add(Expression.eq("masterOrg", queryMap.get("masterOrg")));
        }
        if (queryMap.get("masterOrg_like") != null) {
            criteria = criteria.add(Expression.like("masterOrg", "%" + queryMap.get("masterOrg_like") + "%"));
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
