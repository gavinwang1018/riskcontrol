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

import cn.com.brilliance.begen.dao.SysMessageDAO;
import cn.com.brilliance.begen.model.SysMessage;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysMessageDAO接口具体实现类.
 * @author Administrator.
 */

public class SysMessageDAOHibernate extends BeGenHibernateDaoSupport implements SysMessageDAO {    

    /**
     *  根据主键获得SysMessage对象.
     *  @param pkey SysMessage主键
     *  @return SysMessage.
     */
    public SysMessage getSysMessage(java.lang.String pkey) {
        SysMessage sysMessage = (SysMessage) getHibernateTemplate().get(SysMessage.class, pkey);
        if (sysMessage == null) {
            return sysMessage;
        }
        return sysMessage;

    }

    /**
     *  存储SysMessage对象.
     *  @param  sysMessage SysMessage对象
     *  @return SysMessage.
     */
    public SysMessage saveSysMessage(SysMessage sysMessage) {
        return (SysMessage) getHibernateTemplate().merge(sysMessage);
    }

    /**
     *  删除SysMessage对象.
     *  @param pkey SysMessage主键.
     */
    public void removeSysMessage(java.lang.String pkey) {
        SysMessage sysMessage = getSysMessage(pkey);
        getHibernateTemplate().delete(sysMessage);
    }

    /**
     *  获取SysMessage对象列表.
     *  @param  sysMessage SysMessage对象
     *  @return List.
     */
    public List getSysMessageList(SysMessage sysMessage) {
        Criteria criteria = getSession().createCriteria(SysMessage.class).add(
                Example.create(sysMessage));
        if (sysMessage.getId() != null) {
            criteria.add(Expression.eq("id", sysMessage.getId()));
        }
        return criteria.list();
    }

    /**
     *  根据查询条件获取SysMessage对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysMessageListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysMessage where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysMessage.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取SysMessage对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysMessageListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysMessage where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysMessage.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤SysMessage对象
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

        if (queryMap.get("title") != null) {
            criteria = criteria.add(Expression.eq("title", queryMap.get("title")));
        }
        if (queryMap.get("title_like") != null) {
            criteria = criteria.add(Expression.like("title", "%" + queryMap.get("title_like") + "%"));
        }

        if (queryMap.get("content") != null) {
            criteria = criteria.add(Expression.eq("content", queryMap.get("content")));
        }
        if (queryMap.get("content_like") != null) {
            criteria = criteria.add(Expression.like("content", "%" + queryMap.get("content_like") + "%"));
        }

        if (queryMap.get("sendTime") != null) {
            criteria = criteria.add(Expression.eq("sendTime", java.sql.Date.valueOf((String) queryMap.get("sendTime"))));
        }
        if (queryMap.get("sendTime_min") != null) {
            criteria = criteria.add(Expression.ge("sendTime", java.sql.Date.valueOf((String) queryMap.get("sendTime_min"))));
        }
        if (queryMap.get("sendTime_max") != null) {
            criteria = criteria.add(Expression.le("sendTime", java.sql.Date.valueOf((String) queryMap.get("sendTime_max"))));
        }
        if (queryMap.get("sender") != null) {
            criteria = criteria.add(Expression.eq("sender", queryMap.get("sender")));
        }
        if (queryMap.get("sender_like") != null) {
            criteria = criteria.add(Expression.like("sender", "%" + queryMap.get("sender_like") + "%"));
        }

        if (queryMap.get("receiver") != null) {
            criteria = criteria.add(Expression.eq("receiver", queryMap.get("receiver")));
        }
        if (queryMap.get("receiver_like") != null) {
            criteria = criteria.add(Expression.like("receiver", "%" + queryMap.get("receiver_like") + "%"));
        }

        if (queryMap.get("readFlag") != null) {
            criteria = criteria.add(Expression.eq("readFlag", new Boolean((String) queryMap.get("readFlag"))));
        }
        if (queryMap.get("type") != null) {
            criteria = criteria.add(Expression.eq("type", queryMap.get("type")));
        }
        if (queryMap.get("type_like") != null) {
            criteria = criteria.add(Expression.like("type", "%" + queryMap.get("type_like") + "%"));
        }


        //根据查询queryMap的键值，提供排序功能,_order="域名1 asc|desc,域名2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
