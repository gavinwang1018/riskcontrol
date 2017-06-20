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

import cn.com.brilliance.begen.dao.TbaseargDAO;
import cn.com.brilliance.begen.model.Tbasearg;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * TbaseargDAO接口具体实现类.
 * @author Administrator.
 */

public class TbaseargDAOHibernate extends BeGenHibernateDaoSupport implements TbaseargDAO {    

    /**
     *  根据主键获得Tbasearg对象.
     *  @param pkey Tbasearg主键
     *  @return Tbasearg.
     */
    public Tbasearg getTbasearg(java.lang.String pkey) {
        Tbasearg tbasearg = (Tbasearg) getHibernateTemplate().get(Tbasearg.class, pkey);
        if (tbasearg == null) {
            return tbasearg;
        }
        return tbasearg;

    }

    /**
     *  存储Tbasearg对象.
     *  @param  tbasearg Tbasearg对象
     *  @return Tbasearg.
     */
    public Tbasearg saveTbasearg(Tbasearg tbasearg) {
        return (Tbasearg) getHibernateTemplate().merge(tbasearg);
    }

    /**
     *  删除Tbasearg对象.
     *  @param pkey Tbasearg主键.
     */
    public void removeTbasearg(java.lang.String pkey) {
        Tbasearg tbasearg = getTbasearg(pkey);
        getHibernateTemplate().delete(tbasearg);
    }

    /**
     *  获取Tbasearg对象列表.
     *  @param  tbasearg Tbasearg对象
     *  @return List.
     */
    public List getTbaseargList(Tbasearg tbasearg) {
        Criteria criteria = getSession().createCriteria(Tbasearg.class).add(
                Example.create(tbasearg));
        if (tbasearg.getId() != null) {
            criteria.add(Expression.eq("id", tbasearg.getId()));
        }
        return criteria.list();
    }

    /**
     *  根据查询条件获取Tbasearg对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getTbaseargListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.Tbasearg where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(Tbasearg.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     * 根据类型查询Tbasearg对象列表(用于响应码和交易码查询页面)
     * @param  queryMap 查询条件Map
     * @param  simbol 类型
     * @return List.
     */
    public List getTbaseargByType(Map queryMap,String simbol) {
        String hsql = (String) queryMap.get("_hsql");
        
        if (hsql != null) {
        	hsql = " type="+"'"+simbol+"'and "+ hsql;
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.Tbasearg where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(Tbasearg.class);
        criteria = criteria.add(Expression.eq("type", simbol));
        
        return getList(queryMap, criteria);
    }
    
    
    /**
     *  根据查询条件获取Tbasearg对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getTbaseargListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.Tbasearg where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(Tbasearg.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤Tbasearg对象
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

        if (queryMap.get("name") != null) {
            criteria = criteria.add(Expression.eq("name", queryMap.get("name")));
        }
        if (queryMap.get("name_like") != null) {
            criteria = criteria.add(Expression.like("name", "%" + queryMap.get("name_like") + "%"));
        }

        if (queryMap.get("type") != null) {
            criteria = criteria.add(Expression.eq("type", queryMap.get("type")));
        }
        if (queryMap.get("type_like") != null) {
            criteria = criteria.add(Expression.like("type", "%" + queryMap.get("type_like") + "%"));
        }

        if (queryMap.get("code") != null) {
            criteria = criteria.add(Expression.eq("code", queryMap.get("code")));
        }
        if (queryMap.get("code_like") != null) {
            criteria = criteria.add(Expression.like("code", "%" + queryMap.get("code_like") + "%"));
        }

        if (queryMap.get("param1") != null) {
            criteria = criteria.add(Expression.eq("param1", queryMap.get("param1")));
        }
        if (queryMap.get("param1_like") != null) {
            criteria = criteria.add(Expression.like("param1", "%" + queryMap.get("param1_like") + "%"));
        }

        if (queryMap.get("param2") != null) {
            criteria = criteria.add(Expression.eq("param2", queryMap.get("param2")));
        }
        if (queryMap.get("param2_like") != null) {
            criteria = criteria.add(Expression.like("param2", "%" + queryMap.get("param2_like") + "%"));
        }

        if (queryMap.get("param3") != null) {
            criteria = criteria.add(Expression.eq("param3", queryMap.get("param3")));
        }
        if (queryMap.get("param3_like") != null) {
            criteria = criteria.add(Expression.like("param3", "%" + queryMap.get("param3_like") + "%"));
        }        

        //根据查询queryMap的键值，提供排序功能,_order="域名1 asc|desc,域名2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
    
    private List getList(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤Tbasearg对象
        Object[] keyArray = queryMap.keySet().toArray();  //转换查询字段名keySet为数组
        //遍历该数组，去除对应查询字段值为空的键值
        for (int i = 0; i < keyArray.length; i++) {
            String value = (String) queryMap.get(keyArray[i]);
            if (value == null || value.trim().length() == 0) {
                queryMap.remove(keyArray[i]);
            }
        }

        if (queryMap.get("name") != null) {
            criteria = criteria.add(Expression.eq("name", queryMap.get("name")));
        }
        if (queryMap.get("name_like") != null) {
            criteria = criteria.add(Expression.like("name", "%" + queryMap.get("name_like") + "%"));
        }

        if (queryMap.get("code") != null) {
            criteria = criteria.add(Expression.eq("code", queryMap.get("code")));
        }
        if (queryMap.get("code_like") != null) {
            criteria = criteria.add(Expression.like("code", "%" + queryMap.get("code_like") + "%"));
        }

        //根据查询queryMap的键值，提供排序功能,_order="域名1 asc|desc,域名2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
    
    
}
