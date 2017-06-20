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

import cn.com.brilliance.begen.dao.SysMenuDAO;
import cn.com.brilliance.begen.model.SysMenu;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysMenuDAO接口具体实现类.
 * @author Administrator.
 */

public class SysMenuDAOHibernate extends BeGenHibernateDaoSupport implements SysMenuDAO {    

    /**
     *  根据主键获得SysMenu对象.
     *  @param pkey SysMenu主键
     *  @return SysMenu.
     */
    public SysMenu getSysMenu(java.lang.String pkey) {
        SysMenu sysMenu = (SysMenu) getHibernateTemplate().get(SysMenu.class, pkey);
        if (sysMenu == null) {
            return sysMenu;
        }
        return sysMenu;

    }

    /**
     *  存储SysMenu对象.
     *  @param  sysMenu SysMenu对象
     *  @return SysMenu.
     */
    public SysMenu saveSysMenu(SysMenu sysMenu) {
        return (SysMenu) getHibernateTemplate().merge(sysMenu);
    }

    /**
     *  删除SysMenu对象.
     *  @param pkey SysMenu主键.
     */
    public void removeSysMenu(java.lang.String pkey) {
        SysMenu sysMenu = getSysMenu(pkey);
        getHibernateTemplate().delete(sysMenu);
    }

    /**
     *  获取SysMenu对象列表.
     *  @param  sysMenu SysMenu对象
     *  @return List.
     */
    public List getSysMenuList(SysMenu sysMenu) {
        Criteria criteria = getSession().createCriteria(SysMenu.class).add(
                Example.create(sysMenu));
        if (sysMenu.getId() != null) {
            criteria.add(Expression.eq("id", sysMenu.getId()));
        }
        criteria.addOrder(Order.asc("sysRecordOrder"));
        return criteria.list();
    }

    /**
     *  根据查询条件获取SysMenu对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysMenuListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysMenu where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysMenu.class);

        criteria.addOrder(Order.asc("sysRecordOrder"));
        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取SysMenu对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysMenuListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysMenu where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysMenu.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤SysMenu对象
        Object[] keyArray = queryMap.keySet().toArray();  //转换查询字段名keySet为数组
        //遍历该数组，去除对应查询字段值为空的键值
        for (int i = 0; i < keyArray.length; i++) {
            String value = (String) queryMap.get(keyArray[i]);
            if (value == null || value.trim().length() == 0) {
                queryMap.remove(keyArray[i]);
            }
        }

        if (queryMap.get("app") != null) {
            criteria = criteria.add(Expression.eq("app", queryMap.get("app")));
        }
        if (queryMap.get("app_like") != null) {
            criteria = criteria.add(Expression.like("app", "%" + queryMap.get("app_like") + "%"));
        }

        if (queryMap.get("mlevel") != null) {
            criteria = criteria.add(Expression.eq("mlevel", queryMap.get("mlevel")));
        }
        if (queryMap.get("mlevel_like") != null) {
            criteria = criteria.add(Expression.like("mlevel", "%" + queryMap.get("mlevel_like") + "%"));
        }

        if (queryMap.get("label") != null) {
            criteria = criteria.add(Expression.eq("label", queryMap.get("label")));
        }
        if (queryMap.get("label_like") != null) {
            criteria = criteria.add(Expression.like("label", "%" + queryMap.get("label_like") + "%"));
        }

        if (queryMap.get("parentMenu") != null) {
            criteria = criteria.add(Expression.eq("parentMenu", queryMap.get("parentMenu")));
        }
        if (queryMap.get("parentMenu_like") != null) {
            criteria = criteria.add(Expression.like("parentMenu", "%" + queryMap.get("parentMenu_like") + "%"));
        }

        if (queryMap.get("url") != null) {
            criteria = criteria.add(Expression.eq("url", queryMap.get("url")));
        }
        if (queryMap.get("url_like") != null) {
            criteria = criteria.add(Expression.like("url", "%" + queryMap.get("url_like") + "%"));
        }

        if (queryMap.get("authority") != null) {
            criteria = criteria.add(Expression.eq("authority", new Boolean((String) queryMap.get("authority"))));
        }
        if (queryMap.get("partyId") != null) {
            criteria = criteria.add(Expression.eq("partyId", queryMap.get("partyId")));
        }
        if (queryMap.get("partyId_like") != null) {
            criteria = criteria.add(Expression.like("partyId", "%" + queryMap.get("partyId_like") + "%"));
        }

        if (queryMap.get("id") != null) {
            criteria = criteria.add(Expression.eq("id", queryMap.get("id")));
        }
        if (queryMap.get("id_like") != null) {
            criteria = criteria.add(Expression.like("id", "%" + queryMap.get("id_like") + "%"));
        }

        if (queryMap.get("urlDescription") != null) {
            criteria = criteria.add(Expression.eq("urlDescription", queryMap.get("urlDescription")));
        }
        if (queryMap.get("urlDescription_like") != null) {
            criteria = criteria.add(Expression.like("urlDescription", "%" + queryMap.get("urlDescription_like") + "%"));
        }


        //根据查询queryMap的键值，提供排序功能,_order="域名1 asc|desc,域名2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
