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

import cn.com.brilliance.begen.dao.TuserInfoDAO;
import cn.com.brilliance.begen.model.TuserInfo;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * TuserInfoDAO接口具体实现类.
 * @author Administrator.
 */

public class TuserInfoDAOHibernate extends BeGenHibernateDaoSupport implements TuserInfoDAO {    

    /**
     *  根据主键获得TuserInfo对象.
     *  @param pkey TuserInfo主键
     *  @return TuserInfo.
     */
    public TuserInfo getTuserInfo(java.lang.String pkey) {
        TuserInfo tuserInfo = (TuserInfo) getHibernateTemplate().get(TuserInfo.class, pkey);
        if (tuserInfo == null) {
            return tuserInfo;
        }
        return tuserInfo;

    }

    /**
     *  存储TuserInfo对象.
     *  @param  tuserInfo TuserInfo对象
     *  @return TuserInfo.
     */
    public TuserInfo saveTuserInfo(TuserInfo tuserInfo) {
        return (TuserInfo) getHibernateTemplate().merge(tuserInfo);
    }

    /**
     *  删除TuserInfo对象.
     *  @param pkey TuserInfo主键.
     */
    public void removeTuserInfo(java.lang.String pkey) {
        TuserInfo tuserInfo = getTuserInfo(pkey);
        getHibernateTemplate().delete(tuserInfo);
    }

    /**
     *  获取TuserInfo对象列表.
     *  @param  tuserInfo TuserInfo对象
     *  @return List.
     */
    public List getTuserInfoList(TuserInfo tuserInfo) {
        Criteria criteria = getSession().createCriteria(TuserInfo.class).add(
                Example.create(tuserInfo));
        if (tuserInfo.getId() != null) {
            criteria.add(Expression.eq("id", tuserInfo.getId()));
        }
        return criteria.list();
    }

    /**
     *  根据查询条件获取TuserInfo对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getTuserInfoListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TuserInfo where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(TuserInfo.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取TuserInfo对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getTuserInfoListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TuserInfo where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(TuserInfo.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤TuserInfo对象
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

        if (queryMap.get("loginName") != null) {
            criteria = criteria.add(Expression.eq("loginName", queryMap.get("loginName")));
        }
        if (queryMap.get("loginName_like") != null) {
            criteria = criteria.add(Expression.like("loginName", "%" + queryMap.get("loginName_like") + "%"));
        }

        if (queryMap.get("name") != null) {
            criteria = criteria.add(Expression.eq("name", queryMap.get("name")));
        }
        if (queryMap.get("name_like") != null) {
            criteria = criteria.add(Expression.like("name", "%" + queryMap.get("name_like") + "%"));
        }

        if (queryMap.get("password") != null) {
            criteria = criteria.add(Expression.eq("password", queryMap.get("password")));
        }
        if (queryMap.get("password_like") != null) {
            criteria = criteria.add(Expression.like("password", "%" + queryMap.get("password_like") + "%"));
        }

        if (queryMap.get("email") != null) {
            criteria = criteria.add(Expression.eq("email", queryMap.get("email")));
        }
        if (queryMap.get("email_like") != null) {
            criteria = criteria.add(Expression.like("email", "%" + queryMap.get("email_like") + "%"));
        }

        if (queryMap.get("enable") != null) {
            criteria = criteria.add(Expression.eq("enable", new Boolean((String) queryMap.get("enable"))));
        }

        if (queryMap.get("organizeId") != null) {
            criteria = criteria.add(Expression.eq("organizeId", queryMap.get("organizeId")));
        }
        if (queryMap.get("organizeId_like") != null) {//此用于匹配所属部门 --- 没用叻
//        	criteria = criteria.add(Expression.eq("organizeId", queryMap.get("organizeId_like")));        	
            criteria = criteria.add(Expression.like("organizeId", "%" + queryMap.get("organizeId_like") + "%"));
        }

        queryMap.put("_order", "organizeId asc");
        //根据查询queryMap的键值，提供排序功能,_order="域名1 asc|desc,域名2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
