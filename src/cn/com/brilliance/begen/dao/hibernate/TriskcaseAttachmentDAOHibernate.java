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
 * TriskcaseAttachmentDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class TriskcaseAttachmentDAOHibernate extends BeGenHibernateDaoSupport implements TriskcaseAttachmentDAO {    

    /**
     *  �����������TriskcaseAttachment����.
     *  @param pkey TriskcaseAttachment����
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
     *  �洢TriskcaseAttachment����.
     *  @param  triskcaseAttachment TriskcaseAttachment����
     *  @return TriskcaseAttachment.
     */
    public TriskcaseAttachment saveTriskcaseAttachment(TriskcaseAttachment triskcaseAttachment) {
        return (TriskcaseAttachment) getHibernateTemplate().merge(triskcaseAttachment);
    }

    /**
     *  ɾ��TriskcaseAttachment����.
     *  @param pkey TriskcaseAttachment����.
     */
    public void removeTriskcaseAttachment(java.lang.String pkey) {
        TriskcaseAttachment triskcaseAttachment = getTriskcaseAttachment(pkey);
        getHibernateTemplate().delete(triskcaseAttachment);
    }

    /**
     *  ��ȡTriskcaseAttachment�����б�.
     *  @param  triskcaseAttachment TriskcaseAttachment����
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
     *  ���ݲ�ѯ������ȡTriskcaseAttachment�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
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
     *  ���ݲ�ѯ������ȡTriskcaseAttachment�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
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
        //���ݲ�ѯqueryMap�ļ�ֵ������TriskcaseAttachment����
        Object[] keyArray = queryMap.keySet().toArray();  //ת����ѯ�ֶ���keySetΪ����
        //���������飬ȥ����Ӧ��ѯ�ֶ�ֵΪ�յļ�ֵ
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


        //���ݲ�ѯqueryMap�ļ�ֵ���ṩ������,_order="����1 asc|desc,����2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
