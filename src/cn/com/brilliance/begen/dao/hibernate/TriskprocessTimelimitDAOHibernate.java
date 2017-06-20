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

import cn.com.brilliance.begen.dao.TriskprocessTimelimitDAO;
import cn.com.brilliance.begen.model.TriskprocessTimelimit;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * TriskprocessTimelimitDAO接口具体实现类.
 * @author Administrator.
 */

public class TriskprocessTimelimitDAOHibernate extends BeGenHibernateDaoSupport implements TriskprocessTimelimitDAO {    

    /**
     *  根据主键获得TriskprocessTimelimit对象.
     *  @param pkey TriskprocessTimelimit主键
     *  @return TriskprocessTimelimit.
     */
    public TriskprocessTimelimit getTriskprocessTimelimit(java.lang.String pkey) {
        TriskprocessTimelimit triskprocessTimelimit = (TriskprocessTimelimit) getHibernateTemplate().get(TriskprocessTimelimit.class, pkey);
        if (triskprocessTimelimit == null) {
            return triskprocessTimelimit;
        }
        return triskprocessTimelimit;

    }

    /**
     *  存储TriskprocessTimelimit对象.
     *  @param  triskprocessTimelimit TriskprocessTimelimit对象
     *  @return TriskprocessTimelimit.
     */
    public TriskprocessTimelimit saveTriskprocessTimelimit(TriskprocessTimelimit triskprocessTimelimit) {
        return (TriskprocessTimelimit) getHibernateTemplate().merge(triskprocessTimelimit);
    }

    /**
     *  删除TriskprocessTimelimit对象.
     *  @param pkey TriskprocessTimelimit主键.
     */
    public void removeTriskprocessTimelimit(java.lang.String pkey) {
        TriskprocessTimelimit triskprocessTimelimit = getTriskprocessTimelimit(pkey);
        getHibernateTemplate().delete(triskprocessTimelimit);
    }

    /**
     *  获取TriskprocessTimelimit对象列表.
     *  @param  triskprocessTimelimit TriskprocessTimelimit对象
     *  @return List.
     */
    public List getTriskprocessTimelimitList(TriskprocessTimelimit triskprocessTimelimit) {
        Criteria criteria = getSession().createCriteria(TriskprocessTimelimit.class).add(
                Example.create(triskprocessTimelimit));
        if (triskprocessTimelimit.getId() != null) {
            criteria.add(Expression.eq("id", triskprocessTimelimit.getId()));
        }
        return criteria.list();
    }

    /**
     *  根据查询条件获取TriskprocessTimelimit对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getTriskprocessTimelimitListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TriskprocessTimelimit where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(TriskprocessTimelimit.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取TriskprocessTimelimit对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getTriskprocessTimelimitListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TriskprocessTimelimit where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(TriskprocessTimelimit.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤TriskprocessTimelimit对象
        Object[] keyArray = queryMap.keySet().toArray();  //转换查询字段名keySet为数组
        //遍历该数组，去除对应查询字段值为空的键值
        for (int i = 0; i < keyArray.length; i++) {
            String value = (String) queryMap.get(keyArray[i]);
            if (value == null || value.trim().length() == 0) {
                queryMap.remove(keyArray[i]);
            }
        }

        if (queryMap.get("belongToInst") != null) {
            criteria = criteria.add(Expression.eq("belongToInst", queryMap.get("belongToInst")));
        }
        if (queryMap.get("belongToInst_like") != null) {
            criteria = criteria.add(Expression.like("belongToInst", "%" + queryMap.get("belongToInst_like") + "%"));
        }

        if (queryMap.get("warnLevel") != null) {
            criteria = criteria.add(Expression.eq("warnLevel", queryMap.get("warnLevel")));
        }
        if (queryMap.get("warnLevel_like") != null) {
            criteria = criteria.add(Expression.like("warnLevel", "%" + queryMap.get("warnLevel_like") + "%"));
        }

        if (queryMap.get("timeLimit") != null) {
            criteria = criteria.add(Expression.eq("timeLimit", queryMap.get("timeLimit")));
        }
        if (queryMap.get("timeLimit_like") != null) {
            criteria = criteria.add(Expression.like("timeLimit", "%" + queryMap.get("timeLimit_like") + "%"));
        }

        if (queryMap.get("id") != null) {
            criteria = criteria.add(Expression.eq("id", queryMap.get("id")));
        }
        if (queryMap.get("id_like") != null) {
            criteria = criteria.add(Expression.like("id", "%" + queryMap.get("id_like") + "%"));
        }


        //根据查询queryMap的键值，提供排序功能,_order="域名1 asc|desc,域名2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
