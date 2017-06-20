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

import cn.com.brilliance.begen.dao.SysTemplateDAO;
import cn.com.brilliance.begen.model.SysTemplate;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysTemplateDAO接口具体实现类.
 * @author Administrator.
 */

public class SysTemplateDAOHibernate extends BeGenHibernateDaoSupport implements SysTemplateDAO {    

    /**
     *  根据主键获得SysTemplate对象.
     *  @param pkey SysTemplate主键
     *  @return SysTemplate.
     */
    public SysTemplate getSysTemplate(java.lang.String pkey) {
        SysTemplate sysTemplate = (SysTemplate) getHibernateTemplate().get(SysTemplate.class, pkey);
        if (sysTemplate == null) {
            return sysTemplate;
        }
        return sysTemplate;

    }

    /**
     *  存储SysTemplate对象.
     *  @param  sysTemplate SysTemplate对象
     *  @return SysTemplate.
     */
    public SysTemplate saveSysTemplate(SysTemplate sysTemplate) {
        return (SysTemplate) getHibernateTemplate().merge(sysTemplate);
    }

    /**
     *  删除SysTemplate对象.
     *  @param pkey SysTemplate主键.
     */
    public void removeSysTemplate(java.lang.String pkey) {
        SysTemplate sysTemplate = getSysTemplate(pkey);
        getHibernateTemplate().delete(sysTemplate);
    }

    /**
     *  获取SysTemplate对象列表.
     *  @param  sysTemplate SysTemplate对象
     *  @return List.
     */
    public List getSysTemplateList(SysTemplate sysTemplate) {
        Criteria criteria = getSession().createCriteria(SysTemplate.class).add(
                Example.create(sysTemplate));
        if (sysTemplate.getTemplateId() != null) {
            criteria.add(Expression.eq("templateId", sysTemplate.getTemplateId()));
        }
        return criteria.list();
    }

    /**
     *  根据查询条件获取SysTemplate对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysTemplateListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysTemplate where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysTemplate.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取SysTemplate对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysTemplateListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysTemplate where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysTemplate.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤SysTemplate对象
        Object[] keyArray = queryMap.keySet().toArray();  //转换查询字段名keySet为数组
        //遍历该数组，去除对应查询字段值为空的键值
        for (int i = 0; i < keyArray.length; i++) {
            String value = (String) queryMap.get(keyArray[i]);
            if (value == null || value.trim().length() == 0) {
                queryMap.remove(keyArray[i]);
            }
        }

        if (queryMap.get("templateId") != null) {
            criteria = criteria.add(Expression.eq("templateId", queryMap.get("templateId")));
        }
        if (queryMap.get("templateId_like") != null) {
            criteria = criteria.add(Expression.like("templateId", "%" + queryMap.get("templateId_like") + "%"));
        }

        if (queryMap.get("templateName") != null) {
            criteria = criteria.add(Expression.eq("templateName", queryMap.get("templateName")));
        }
        if (queryMap.get("templateName_like") != null) {
            criteria = criteria.add(Expression.like("templateName", "%" + queryMap.get("templateName_like") + "%"));
        }

        if (queryMap.get("templateDesc") != null) {
            criteria = criteria.add(Expression.eq("templateDesc", queryMap.get("templateDesc")));
        }
        if (queryMap.get("templateDesc_like") != null) {
            criteria = criteria.add(Expression.like("templateDesc", "%" + queryMap.get("templateDesc_like") + "%"));
        }

        if (queryMap.get("templateDbName") != null) {
            criteria = criteria.add(Expression.eq("templateDbName", queryMap.get("templateDbName")));
        }
        if (queryMap.get("templateDbName_like") != null) {
            criteria = criteria.add(Expression.like("templateDbName", "%" + queryMap.get("templateDbName_like") + "%"));
        }


        //根据查询queryMap的键值，提供排序功能,_order="域名1 asc|desc,域名2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
