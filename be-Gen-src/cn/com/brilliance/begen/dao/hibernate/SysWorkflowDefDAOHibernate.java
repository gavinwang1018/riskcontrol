package cn.com.brilliance.begen.dao.hibernate;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Expression;

import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;
import cn.com.brilliance.begen.dao.SysWorkflowDefDAO;
import cn.com.brilliance.begen.model.SysWorkflowDef;

/**
 * SysWorkflowDefDAO接口具体实现类.
 * @author Administrator.
 */

public class SysWorkflowDefDAOHibernate extends BeGenHibernateDaoSupport implements SysWorkflowDefDAO {    

    /**
     *  根据主键获得SysWorkflowDef对象.
     *  @param pkey SysWorkflowDef主键
     *  @return SysWorkflowDef.
     */
    public SysWorkflowDef getSysWorkflowDef(java.lang.String pkey) {
        SysWorkflowDef sysWorkflowDef = (SysWorkflowDef) getHibernateTemplate().get(SysWorkflowDef.class, pkey);
        if (sysWorkflowDef == null) {
            return sysWorkflowDef;
        }
        return sysWorkflowDef;

    }

    /**
     *  存储SysWorkflowDef对象.
     *  @param  sysWorkflowDef SysWorkflowDef对象
     *  @return SysWorkflowDef.
     */
    public SysWorkflowDef saveSysWorkflowDef(SysWorkflowDef sysWorkflowDef) {
        return (SysWorkflowDef) getHibernateTemplate().merge(sysWorkflowDef);
    }

    /**
     *  删除SysWorkflowDef对象.
     *  @param pkey SysWorkflowDef主键.
     */
    public void removeSysWorkflowDef(java.lang.String pkey) {
        SysWorkflowDef sysWorkflowDef = getSysWorkflowDef(pkey);
        getHibernateTemplate().delete(sysWorkflowDef);
    }

    /**
     *  获取SysWorkflowDef对象列表.
     *  @param  sysWorkflowDef SysWorkflowDef对象
     *  @return List.
     */
    public List getSysWorkflowDefList(SysWorkflowDef sysWorkflowDef) {
        Criteria criteria = getSession().createCriteria(SysWorkflowDef.class).add(
                Example.create(sysWorkflowDef));
        if (sysWorkflowDef.getId() != null) {
            criteria.add(Expression.eq("id", sysWorkflowDef.getId()));
        }
        return criteria.list();
    }

    /**
     *  根据查询条件获取SysWorkflowDef对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysWorkflowDefListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.beapp.config.model.SysWorkflowDef where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysWorkflowDef.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取SysWorkflowDef对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysWorkflowDefListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.beapp.config.model.SysWorkflowDef where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysWorkflowDef.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤SysWorkflowDef对象
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

        if (queryMap.get("workflowName") != null) {
            criteria = criteria.add(Expression.eq("workflowName", queryMap.get("workflowName")));
        }
        if (queryMap.get("workflowName_like") != null) {
            criteria = criteria.add(Expression.like("workflowName", "%" + queryMap.get("workflowName_like") + "%"));
        }

        if (queryMap.get("workflowLabel") != null) {
            criteria = criteria.add(Expression.eq("workflowLabel", queryMap.get("workflowLabel")));
        }
        if (queryMap.get("workflowLabel_like") != null) {
            criteria = criteria.add(Expression.like("workflowLabel", "%" + queryMap.get("workflowLabel_like") + "%"));
        }

        if (queryMap.get("dataObject") != null) {
            criteria = criteria.add(Expression.eq("dataObject", queryMap.get("dataObject")));
        }
        if (queryMap.get("dataObject_like") != null) {
            criteria = criteria.add(Expression.like("dataObject", "%" + queryMap.get("dataObject_like") + "%"));
        }

        if (queryMap.get("rollBack") != null) {
            criteria = criteria.add(Expression.eq("rollBack", queryMap.get("rollBack")));
        }
        if (queryMap.get("rollBack_like") != null) {
            criteria = criteria.add(Expression.like("rollBack", "%" + queryMap.get("rollBack_like") + "%"));
        }

        if (queryMap.get("historyLayout") != null) {
            criteria = criteria.add(Expression.eq("historyLayout", queryMap.get("historyLayout")));
        }
        if (queryMap.get("historyLayout_like") != null) {
            criteria = criteria.add(Expression.like("historyLayout", "%" + queryMap.get("historyLayout_like") + "%"));
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
