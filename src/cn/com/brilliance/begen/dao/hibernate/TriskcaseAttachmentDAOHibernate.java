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

import cn.com.brilliance.begen.dao.TriskcaseAttachmentDAO;
import cn.com.brilliance.begen.model.TriskcaseAttachment;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * TriskcaseAttachmentDAO接口具体实现类.
 * @author Administrator.
 */

public class TriskcaseAttachmentDAOHibernate extends BeGenHibernateDaoSupport implements TriskcaseAttachmentDAO {    

    /**
     *  根据主键获得TriskcaseAttachment对象.
     *  @param pkey TriskcaseAttachment主键
     *  @return TriskcaseAttachment.
     */
    public TriskcaseAttachment getTriskcaseAttachment(java.lang.String pkey) {
        TriskcaseAttachment triskcaseAttachment = (TriskcaseAttachment) getHibernateTemplate().get(TriskcaseAttachment.class, pkey);
        if (triskcaseAttachment == null) {
            return triskcaseAttachment;
        }
        return triskcaseAttachment;

    }

    /**
     *  存储TriskcaseAttachment对象.
     *  @param  triskcaseAttachment TriskcaseAttachment对象
     *  @return TriskcaseAttachment.
     */
    public TriskcaseAttachment saveTriskcaseAttachment(TriskcaseAttachment triskcaseAttachment) {
        return (TriskcaseAttachment) getHibernateTemplate().merge(triskcaseAttachment);
    }

    /**
     *  删除TriskcaseAttachment对象.
     *  @param pkey TriskcaseAttachment主键.
     */
    public void removeTriskcaseAttachment(java.lang.String pkey) {
        TriskcaseAttachment triskcaseAttachment = getTriskcaseAttachment(pkey);
        getHibernateTemplate().delete(triskcaseAttachment);
    }

    /**
     *  获取TriskcaseAttachment对象列表.
     *  @param  triskcaseAttachment TriskcaseAttachment对象
     *  @return List.
     */
    public List getTriskcaseAttachmentList(TriskcaseAttachment triskcaseAttachment) {
        Criteria criteria = getSession().createCriteria(TriskcaseAttachment.class).add(
                Example.create(triskcaseAttachment));
        if (triskcaseAttachment.getId() != null) {
            criteria.add(Expression.eq("id", triskcaseAttachment.getId()));
        }
        return criteria.list();
    }

    /**
     *  根据查询条件获取TriskcaseAttachment对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getTriskcaseAttachmentListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TriskcaseAttachment where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(TriskcaseAttachment.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取TriskcaseAttachment对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getTriskcaseAttachmentListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TriskcaseAttachment where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(TriskcaseAttachment.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤TriskcaseAttachment对象
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

        if (queryMap.get("riskcaseId") != null) {
            criteria = criteria.add(Expression.eq("riskcaseId", queryMap.get("riskcaseId")));
        }
        if (queryMap.get("riskcaseId_like") != null) {
            criteria = criteria.add(Expression.like("riskcaseId", "%" + queryMap.get("riskcaseId_like") + "%"));
        }

        if (queryMap.get("filename") != null) {
            criteria = criteria.add(Expression.eq("filename", queryMap.get("filename")));
        }
        if (queryMap.get("filename_like") != null) {
            criteria = criteria.add(Expression.like("filename", "%" + queryMap.get("filename_like") + "%"));
        }

        if (queryMap.get("content") != null) {
            criteria = criteria.add(Expression.eq("content", queryMap.get("content")));
        }
        if (queryMap.get("content_like") != null) {
            criteria = criteria.add(Expression.like("content", "%" + queryMap.get("content_like") + "%"));
        }

        if (queryMap.get("sortcode") != null) {
            criteria = criteria.add(Expression.eq("sortcode", new Integer((String) queryMap.get("sortcode"))));
        }
        if (queryMap.get("sortcode_min") != null) {
            criteria = criteria.add(Expression.ge("sortcode", new Integer((String) queryMap.get("sortcode_min"))));
        }
        if (queryMap.get("sortcode_max") != null) {
            criteria = criteria.add(Expression.le("sortcode", new Integer((String) queryMap.get("sortcode_max"))));
        }
        if (queryMap.get("caseno") != null) {
            criteria = criteria.add(Expression.eq("caseno", queryMap.get("caseno")));
        }
        if (queryMap.get("caseno_like") != null) {
            criteria = criteria.add(Expression.like("caseno", "%" + queryMap.get("caseno_like") + "%"));
        }


        //根据查询queryMap的键值，提供排序功能,_order="域名1 asc|desc,域名2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
