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

import cn.com.brilliance.begen.dao.SysPortalDefDAO;
import cn.com.brilliance.begen.model.SysPortalDef;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysPortalDefDAO接口具体实现类.
 * @author Administrator.
 */

public class SysPortalDefDAOHibernate extends BeGenHibernateDaoSupport implements SysPortalDefDAO {    

    /**
     *  根据主键获得SysPortalDef对象.
     *  @param pkey SysPortalDef主键
     *  @return SysPortalDef.
     */
    public SysPortalDef getSysPortalDef(java.lang.String pkey) {
        SysPortalDef sysPortalDef = (SysPortalDef) getHibernateTemplate().get(SysPortalDef.class, pkey);
        if (sysPortalDef == null) {
            return sysPortalDef;
        }
        return sysPortalDef;

    }

    /**
     *  存储SysPortalDef对象.
     *  @param  sysPortalDef SysPortalDef对象
     *  @return SysPortalDef.
     */
    public SysPortalDef saveSysPortalDef(SysPortalDef sysPortalDef) {
        return (SysPortalDef) getHibernateTemplate().merge(sysPortalDef);
    }

    /**
     *  删除SysPortalDef对象.
     *  @param pkey SysPortalDef主键.
     */
    public void removeSysPortalDef(java.lang.String pkey) {
        SysPortalDef sysPortalDef = getSysPortalDef(pkey);
        getHibernateTemplate().delete(sysPortalDef);
    }

    /**
     *  获取SysPortalDef对象列表.
     *  @param  sysPortalDef SysPortalDef对象
     *  @return List.
     */
    public List getSysPortalDefList(SysPortalDef sysPortalDef) {
        Criteria criteria = getSession().createCriteria(SysPortalDef.class).add(
                Example.create(sysPortalDef));
        if (sysPortalDef.getId() != null) {
            criteria.add(Expression.eq("id", sysPortalDef.getId()));
        }
        return criteria.list();
    }

    /**
     *  根据查询条件获取SysPortalDef对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysPortalDefListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysPortalDef where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysPortalDef.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取SysPortalDef对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysPortalDefListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysPortalDef where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysPortalDef.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤SysPortalDef对象
        Object[] keyArray = queryMap.keySet().toArray();  //转换查询字段名keySet为数组
        //遍历该数组，去除对应查询字段值为空的键值
        for (int i = 0; i < keyArray.length; i++) {
            String value = (String) queryMap.get(keyArray[i]);
            if (value == null || value.trim().length() == 0) {
                queryMap.remove(keyArray[i]);
            }
        }

        if (queryMap.get("description") != null) {
            criteria = criteria.add(Expression.eq("description", queryMap.get("description")));
        }
        if (queryMap.get("description_like") != null) {
            criteria = criteria.add(Expression.like("description", "%" + queryMap.get("description_like") + "%"));
        }

        if (queryMap.get("cols") != null) {
            criteria = criteria.add(Expression.eq("cols", queryMap.get("cols")));
        }
        if (queryMap.get("cols_like") != null) {
            criteria = criteria.add(Expression.like("cols", "%" + queryMap.get("cols_like") + "%"));
        }

        if (queryMap.get("label") != null) {
            criteria = criteria.add(Expression.eq("label", queryMap.get("label")));
        }
        if (queryMap.get("label_like") != null) {
            criteria = criteria.add(Expression.like("label", "%" + queryMap.get("label_like") + "%"));
        }

        if (queryMap.get("widthFst") != null) {
            criteria = criteria.add(Expression.eq("widthFst", queryMap.get("widthFst")));
        }
        if (queryMap.get("widthFst_like") != null) {
            criteria = criteria.add(Expression.like("widthFst", "%" + queryMap.get("widthFst_like") + "%"));
        }

        if (queryMap.get("widthSec") != null) {
            criteria = criteria.add(Expression.eq("widthSec", queryMap.get("widthSec")));
        }
        if (queryMap.get("widthSec_like") != null) {
            criteria = criteria.add(Expression.like("widthSec", "%" + queryMap.get("widthSec_like") + "%"));
        }

        if (queryMap.get("widthThd") != null) {
            criteria = criteria.add(Expression.eq("widthThd", queryMap.get("widthThd")));
        }
        if (queryMap.get("widthThd_like") != null) {
            criteria = criteria.add(Expression.like("widthThd", "%" + queryMap.get("widthThd_like") + "%"));
        }

        if (queryMap.get("id") != null) {
            criteria = criteria.add(Expression.eq("id", queryMap.get("id")));
        }
        if (queryMap.get("id_like") != null) {
            criteria = criteria.add(Expression.like("id", "%" + queryMap.get("id_like") + "%"));
        }

        if (queryMap.get("partyId") != null) {
            criteria = criteria.add(Expression.eq("partyId", queryMap.get("partyId")));
        }
        if (queryMap.get("partyId_like") != null) {
            criteria = criteria.add(Expression.like("partyId", "%" + queryMap.get("partyId_like") + "%"));
        }

        if (queryMap.get("portalId") != null) {
            criteria = criteria.add(Expression.eq("portalId", queryMap.get("portalId")));
        }
        if (queryMap.get("portalId_like") != null) {
            criteria = criteria.add(Expression.like("portalId", "%" + queryMap.get("portalId_like") + "%"));
        }


        //根据查询queryMap的键值，提供排序功能,_order="域名1 asc|desc,域名2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
