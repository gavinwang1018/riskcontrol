package cn.com.brilliance.begen.dao.hibernate;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;
import cn.com.brilliance.begen.dao.TruleGroupDAO;
import cn.com.brilliance.begen.model.TruleGroup;

/**
 * TruleGroupDAO接口具体实现类.
 * @author Administrator.
 */

public class TruleGroupDAOHibernate extends BeGenHibernateDaoSupport implements TruleGroupDAO {    

    /**
     *  根据主键获得TruleGroup对象.
     *  @param pkey TruleGroup主键
     *  @return TruleGroup.
     */
    public TruleGroup getTruleGroup(java.lang.String pkey) {
        TruleGroup truleGroup = (TruleGroup) getHibernateTemplate().get(TruleGroup.class, pkey);
        if (truleGroup == null) {
            return truleGroup;
        }
        return truleGroup;

    }

    /**
     *  存储TruleGroup对象.
     *  @param  truleGroup TruleGroup对象
     *  @return TruleGroup.
     */
    public TruleGroup saveTruleGroup(TruleGroup truleGroup) {
        return (TruleGroup) getHibernateTemplate().merge(truleGroup);
    }

    /**
     *  删除TruleGroup对象.
     *  @param pkey TruleGroup主键.
     */
    public void removeTruleGroup(java.lang.String pkey) {
        TruleGroup truleGroup = getTruleGroup(pkey);
        getHibernateTemplate().delete(truleGroup);
    }

    /**
     *  获取TruleGroup对象列表.
     *  @param  truleGroup TruleGroup对象
     *  @return List.
     */
    public List getTruleGroupList(TruleGroup truleGroup) {
        Criteria criteria = getSession().createCriteria(TruleGroup.class).add(
                Example.create(truleGroup));
        if (truleGroup.getId() != null) {
            criteria.add(Expression.eq("id", truleGroup.getId()));
        }
        criteria.addOrder(Order.asc("description"));
        return criteria.list();
    }

    /**
     *  根据查询条件获取TruleGroup对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getTruleGroupListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TruleGroup where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(TruleGroup.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取TruleGroup对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getTruleGroupListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TruleGroup where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(TruleGroup.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤TruleGroup对象
        Object[] keyArray = queryMap.keySet().toArray();  //转换查询字段名keySet为数组
        //遍历该数组，去除对应查询字段值为空的键值
        for (int i = 0; i < keyArray.length; i++) {
            String value = (String) queryMap.get(keyArray[i]);
            if (value == null || value.trim().length() == 0) {
                queryMap.remove(keyArray[i]);
            }
        }

        if (queryMap.get("id") != null) {
        	String id = (String) queryMap.get("id");
			if (!"".equals(id)) {
				criteria = criteria
						.add(Expression.eq("id", queryMap.get("id")));
			}
        }
        if (queryMap.get("id_like") != null) {
            criteria = criteria.add(Expression.like("id", "%" + queryMap.get("id_like") + "%"));
        }

        if (queryMap.get("belongToInst") != null) {
			String belongToInst = (String) queryMap.get("belongToInst");
			if (!"*".equals(belongToInst)) {
				criteria = criteria.add(Expression.eq("belongToInst", queryMap
						.get("belongToInst")));
			}
		}
        if (queryMap.get("belongToInst_like") != null) {
            criteria = criteria.add(Expression.like("belongToInst", "%" + queryMap.get("belongToInst_like") + "%"));
        }

        if (queryMap.get("description") != null) {
            criteria = criteria.add(Expression.eq("description", queryMap.get("description")));
        }
        if (queryMap.get("description_like") != null) {
            criteria = criteria.add(Expression.like("description", "%" + queryMap.get("description_like") + "%"));
        }

        if (queryMap.get("enable") != null) {
            criteria = criteria.add(Expression.eq("enable", new Boolean((String) queryMap.get("enable"))));
        }
        if (queryMap.get("status") != null) {
            criteria = criteria.add(Expression.eq("status", queryMap.get("status")));
        }
        if (queryMap.get("status_like") != null) {
            criteria = criteria.add(Expression.like("status", "%" + queryMap.get("status_like") + "%"));
        }


        //根据查询queryMap的键值，提供排序功能,_order="域名1 asc|desc,域名2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
