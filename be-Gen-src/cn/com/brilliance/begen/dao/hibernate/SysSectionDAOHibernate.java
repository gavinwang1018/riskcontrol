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

import cn.com.brilliance.begen.dao.SysSectionDAO;
import cn.com.brilliance.begen.model.SysSection;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysSectionDAO接口具体实现类.
 * @author Administrator.
 */

public class SysSectionDAOHibernate extends BeGenHibernateDaoSupport implements SysSectionDAO {    

    /**
     *  根据主键获得SysSection对象.
     *  @param pkey SysSection主键
     *  @return SysSection.
     */
    public SysSection getSysSection(java.lang.String pkey) {
        SysSection sysSection = (SysSection) getHibernateTemplate().get(SysSection.class, pkey);
        if (sysSection == null) {
            return sysSection;
        }
        return sysSection;

    }

    /**
     *  存储SysSection对象.
     *  @param  sysSection SysSection对象
     *  @return SysSection.
     */
    public SysSection saveSysSection(SysSection sysSection) {
        return (SysSection) getHibernateTemplate().merge(sysSection);
    }

    /**
     *  删除SysSection对象.
     *  @param pkey SysSection主键.
     */
    public void removeSysSection(java.lang.String pkey) {
        SysSection sysSection = getSysSection(pkey);
        getHibernateTemplate().delete(sysSection);
    }

    /**
     *  获取SysSection对象列表.
     *  @param  sysSection SysSection对象
     *  @return List.
     */
    public List getSysSectionList(SysSection sysSection) {
        Criteria criteria = getSession().createCriteria(SysSection.class).add(
                Example.create(sysSection));
        if (sysSection.getId() != null) {
            criteria.add(Expression.eq("id", sysSection.getId()));
        }
        criteria.addOrder(Order.asc("sysRecordOrder"));
        return criteria.list();
    }

    /**
     *  根据查询条件获取SysSection对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysSectionListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysSection where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysSection.class);

        criteria.addOrder(Order.asc("sysRecordOrder"));
        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取SysSection对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysSectionListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysSection where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysSection.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤SysSection对象
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

        if (queryMap.get("formLayout") != null) {
            criteria = criteria.add(Expression.eq("formLayout", queryMap.get("formLayout")));
        }
        if (queryMap.get("formLayout_like") != null) {
            criteria = criteria.add(Expression.like("formLayout", "%" + queryMap.get("formLayout_like") + "%"));
        }

        if (queryMap.get("name") != null) {
            criteria = criteria.add(Expression.eq("name", queryMap.get("name")));
        }
        if (queryMap.get("name_like") != null) {
            criteria = criteria.add(Expression.like("name", "%" + queryMap.get("name_like") + "%"));
        }

        if (queryMap.get("partyId") != null) {
            criteria = criteria.add(Expression.eq("partyId", queryMap.get("partyId")));
        }
        if (queryMap.get("partyId_like") != null) {
            criteria = criteria.add(Expression.like("partyId", "%" + queryMap.get("partyId_like") + "%"));
        }

        if (queryMap.get("sectionText") != null) {
            criteria = criteria.add(Expression.eq("sectionText", queryMap.get("sectionText")));
        }
        if (queryMap.get("sectionText_like") != null) {
            criteria = criteria.add(Expression.like("sectionText", "%" + queryMap.get("sectionText_like") + "%"));
        }

        if (queryMap.get("detailHeading") != null) {
            criteria = criteria.add(Expression.eq("detailHeading", queryMap.get("detailHeading")));
        }
        if (queryMap.get("detailHeading_like") != null) {
            criteria = criteria.add(Expression.like("detailHeading", "%" + queryMap.get("detailHeading_like") + "%"));
        }

        if (queryMap.get("sectionType") != null) {
            criteria = criteria.add(Expression.eq("sectionType", queryMap.get("sectionType")));
        }
        if (queryMap.get("sectionType_like") != null) {
            criteria = criteria.add(Expression.like("sectionType", "%" + queryMap.get("sectionType_like") + "%"));
        }

        if (queryMap.get("editHeading") != null) {
            criteria = criteria.add(Expression.eq("editHeading", queryMap.get("editHeading")));
        }
        if (queryMap.get("editHeading_like") != null) {
            criteria = criteria.add(Expression.like("editHeading", "%" + queryMap.get("editHeading_like") + "%"));
        }

        if (queryMap.get("numColumns") != null) {
            criteria = criteria.add(Expression.eq("numColumns", new Integer((String) queryMap.get("numColumns"))));
        }
        if (queryMap.get("numColumns_min") != null) {
            criteria = criteria.add(Expression.ge("numColumns", new Integer((String) queryMap.get("numColumns_min"))));
        }
        if (queryMap.get("numColumns_max") != null) {
            criteria = criteria.add(Expression.le("numColumns", new Integer((String) queryMap.get("numColumns_max"))));
        }
        if (queryMap.get("maxRow") != null) {
            criteria = criteria.add(Expression.eq("maxRow", new Integer((String) queryMap.get("maxRow"))));
        }
        if (queryMap.get("maxRow_min") != null) {
            criteria = criteria.add(Expression.ge("maxRow", new Integer((String) queryMap.get("maxRow_min"))));
        }
        if (queryMap.get("maxRow_max") != null) {
            criteria = criteria.add(Expression.le("maxRow", new Integer((String) queryMap.get("maxRow_max"))));
        }

        //根据查询queryMap的键值，提供排序功能,_order="域名1 asc|desc,域名2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
