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

import cn.com.brilliance.begen.dao.SysActionListRecDAO;
import cn.com.brilliance.begen.model.SysActionListRec;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysActionListRecDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class SysActionListRecDAOHibernate extends BeGenHibernateDaoSupport implements SysActionListRecDAO {    

    /**
     *  �����������SysActionListRec����.
     *  @param pkey SysActionListRec����
     *  @return SysActionListRec.
     */
    public SysActionListRec getSysActionListRec(java.lang.String pkey) {
        SysActionListRec sysActionListRec = (SysActionListRec) getHibernateTemplate().get(SysActionListRec.class, pkey);
        if (sysActionListRec == null) {
            return sysActionListRec;
        }
        return sysActionListRec;

    }

    /**
     *  �洢SysActionListRec����.
     *  @param  sysActionListRec SysActionListRec����
     *  @return SysActionListRec.
     */
    public SysActionListRec saveSysActionListRec(SysActionListRec sysActionListRec) {
        return (SysActionListRec) getHibernateTemplate().merge(sysActionListRec);
    }

    /**
     *  ɾ��SysActionListRec����.
     *  @param pkey SysActionListRec����.
     */
    public void removeSysActionListRec(java.lang.String pkey) {
        SysActionListRec sysActionListRec = getSysActionListRec(pkey);
        getHibernateTemplate().delete(sysActionListRec);
    }

    /**
     *  ��ȡSysActionListRec�����б�.
     *  @param  sysActionListRec SysActionListRec����
     *  @return List.
     */
    public List getSysActionListRecList(SysActionListRec sysActionListRec) {
        Criteria criteria = getSession().createCriteria(SysActionListRec.class).add(
                Example.create(sysActionListRec));
        if (sysActionListRec.getId() != null) {
            criteria.add(Expression.eq("id", sysActionListRec.getId()));
        }
        criteria.addOrder(Order.asc("sysRecordOrder"));
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡSysActionListRec�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysActionListRecListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysActionListRec where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysActionListRec.class);

        criteria.addOrder(Order.asc("sysRecordOrder"));
        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡSysActionListRec�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysActionListRecListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysActionListRec where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysActionListRec.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������SysActionListRec����
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

        if (queryMap.get("sysListLayout") != null) {
            criteria = criteria.add(Expression.eq("sysListLayout", queryMap.get("sysListLayout")));
        }
        if (queryMap.get("sysListLayout_like") != null) {
            criteria = criteria.add(Expression.like("sysListLayout", "%" + queryMap.get("sysListLayout_like") + "%"));
        }

        if (queryMap.get("name") != null) {
            criteria = criteria.add(Expression.eq("name", queryMap.get("name")));
        }
        if (queryMap.get("name_like") != null) {
            criteria = criteria.add(Expression.like("name", "%" + queryMap.get("name_like") + "%"));
        }

        if (queryMap.get("label") != null) {
            criteria = criteria.add(Expression.eq("label", queryMap.get("label")));
        }
        if (queryMap.get("label_like") != null) {
            criteria = criteria.add(Expression.like("label", "%" + queryMap.get("label_like") + "%"));
        }

        if (queryMap.get("authority") != null) {
            criteria = criteria.add(Expression.eq("authority", new Boolean((String) queryMap.get("authority"))));
        }
        if (queryMap.get("url") != null) {
            criteria = criteria.add(Expression.eq("url", queryMap.get("url")));
        }
        if (queryMap.get("url_like") != null) {
            criteria = criteria.add(Expression.like("url", "%" + queryMap.get("url_like") + "%"));
        }

        if (queryMap.get("target") != null) {
            criteria = criteria.add(Expression.eq("target", queryMap.get("target")));
        }
        if (queryMap.get("target_like") != null) {
            criteria = criteria.add(Expression.like("target", "%" + queryMap.get("target_like") + "%"));
        }

        if (queryMap.get("pageCheck") != null) {
            criteria = criteria.add(Expression.eq("pageCheck", new Boolean((String) queryMap.get("pageCheck"))));
        }
        if (queryMap.get("partyId") != null) {
            criteria = criteria.add(Expression.eq("partyId", queryMap.get("partyId")));
        }
        if (queryMap.get("partyId_like") != null) {
            criteria = criteria.add(Expression.like("partyId", "%" + queryMap.get("partyId_like") + "%"));
        }

        if (queryMap.get("urlDescription") != null) {
            criteria = criteria.add(Expression.eq("urlDescription", queryMap.get("urlDescription")));
        }
        if (queryMap.get("urlDescription_like") != null) {
            criteria = criteria.add(Expression.like("urlDescription", "%" + queryMap.get("urlDescription_like") + "%"));
        }

        if (queryMap.get("disableExpress") != null) {
            criteria = criteria.add(Expression.eq("disableExpress", queryMap.get("disableExpress")));
        }
        if (queryMap.get("disableExpress_like") != null) {
            criteria = criteria.add(Expression.like("disableExpress", "%" + queryMap.get("disableExpress_like") + "%"));
        }

        if (queryMap.get("confirmOperate") != null) {
            criteria = criteria.add(Expression.eq("confirmOperate", new Boolean((String) queryMap.get("confirmOperate"))));
        }
        if (queryMap.get("confirmMessage") != null) {
            criteria = criteria.add(Expression.eq("confirmMessage", queryMap.get("confirmMessage")));
        }
        if (queryMap.get("confirmMessage_like") != null) {
            criteria = criteria.add(Expression.like("confirmMessage", "%" + queryMap.get("confirmMessage_like") + "%"));
        }


        //���ݲ�ѯqueryMap�ļ�ֵ���ṩ������,_order="����1 asc|desc,����2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
