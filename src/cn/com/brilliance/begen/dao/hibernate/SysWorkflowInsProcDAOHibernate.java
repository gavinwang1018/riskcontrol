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

import cn.com.brilliance.begen.dao.SysWorkflowInsProcDAO;
import cn.com.brilliance.begen.model.SysWorkflowInsProc;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysWorkflowInsProcDAO接口具体实现类.
 * @author Administrator.
 */

public class SysWorkflowInsProcDAOHibernate extends BeGenHibernateDaoSupport implements SysWorkflowInsProcDAO {    

    /**
     *  根据主键获得SysWorkflowInsProc对象.
     *  @param pkey SysWorkflowInsProc主键
     *  @return SysWorkflowInsProc.
     */
    public SysWorkflowInsProc getSysWorkflowInsProc(java.lang.String pkey) {
        SysWorkflowInsProc sysWorkflowInsProc = (SysWorkflowInsProc) getHibernateTemplate().get(SysWorkflowInsProc.class, pkey);
        if (sysWorkflowInsProc == null) {
            return sysWorkflowInsProc;
        }
        return sysWorkflowInsProc;

    }

    /**
     *  存储SysWorkflowInsProc对象.
     *  @param  sysWorkflowInsProc SysWorkflowInsProc对象
     *  @return SysWorkflowInsProc.
     */
    public SysWorkflowInsProc saveSysWorkflowInsProc(SysWorkflowInsProc sysWorkflowInsProc) {
        return (SysWorkflowInsProc) getHibernateTemplate().merge(sysWorkflowInsProc);
    }

    /**
     *  删除SysWorkflowInsProc对象.
     *  @param pkey SysWorkflowInsProc主键.
     */
    public void removeSysWorkflowInsProc(java.lang.String pkey) {
        SysWorkflowInsProc sysWorkflowInsProc = getSysWorkflowInsProc(pkey);
        getHibernateTemplate().delete(sysWorkflowInsProc);
    }

    /**
     *  获取SysWorkflowInsProc对象列表.
     *  @param  sysWorkflowInsProc SysWorkflowInsProc对象
     *  @return List.
     */
    public List getSysWorkflowInsProcList(SysWorkflowInsProc sysWorkflowInsProc) {
        Criteria criteria = getSession().createCriteria(SysWorkflowInsProc.class).add(
                Example.create(sysWorkflowInsProc));
        if (sysWorkflowInsProc.getId() != null) {
            criteria.add(Expression.eq("id", sysWorkflowInsProc.getId()));
        }
        return criteria.list();
    }

    /**
     *  根据查询条件获取SysWorkflowInsProc对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysWorkflowInsProcListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysWorkflowInsProc where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysWorkflowInsProc.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取SysWorkflowInsProc对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysWorkflowInsProcListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysWorkflowInsProc where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysWorkflowInsProc.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤SysWorkflowInsProc对象
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

        if (queryMap.get("processDefId") != null) {
            criteria = criteria.add(Expression.eq("processDefId", queryMap.get("processDefId")));
        }
        if (queryMap.get("processDefId_like") != null) {
            criteria = criteria.add(Expression.like("processDefId", "%" + queryMap.get("processDefId_like") + "%"));
        }

        if (queryMap.get("processState") != null) {
            criteria = criteria.add(Expression.eq("processState", queryMap.get("processState")));
        }
        if (queryMap.get("processState_like") != null) {
            criteria = criteria.add(Expression.like("processState", "%" + queryMap.get("processState_like") + "%"));
        }

        if (queryMap.get("processStart") != null) {
            criteria = criteria.add(Expression.eq("processStart", java.sql.Date.valueOf((String) queryMap.get("processStart"))));
        }
        if (queryMap.get("processStart_min") != null) {
            criteria = criteria.add(Expression.ge("processStart", java.sql.Date.valueOf((String) queryMap.get("processStart_min"))));
        }
        if (queryMap.get("processStart_max") != null) {
            criteria = criteria.add(Expression.le("processStart", java.sql.Date.valueOf((String) queryMap.get("processStart_max"))));
        }
        if (queryMap.get("processEnd") != null) {
            criteria = criteria.add(Expression.eq("processEnd", java.sql.Date.valueOf((String) queryMap.get("processEnd"))));
        }
        if (queryMap.get("processEnd_min") != null) {
            criteria = criteria.add(Expression.ge("processEnd", java.sql.Date.valueOf((String) queryMap.get("processEnd_min"))));
        }
        if (queryMap.get("processEnd_max") != null) {
            criteria = criteria.add(Expression.le("processEnd", java.sql.Date.valueOf((String) queryMap.get("processEnd_max"))));
        }
        if (queryMap.get("dataObjectKey") != null) {
            criteria = criteria.add(Expression.eq("dataObjectKey", queryMap.get("dataObjectKey")));
        }
        if (queryMap.get("dataObjectKey_like") != null) {
            criteria = criteria.add(Expression.like("dataObjectKey", "%" + queryMap.get("dataObjectKey_like") + "%"));
        }


        //根据查询queryMap的键值，提供排序功能,_order="域名1 asc|desc,域名2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
