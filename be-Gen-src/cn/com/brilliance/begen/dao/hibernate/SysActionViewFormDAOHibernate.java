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

import cn.com.brilliance.begen.dao.SysActionViewFormDAO;
import cn.com.brilliance.begen.model.SysActionViewForm;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysActionViewFormDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class SysActionViewFormDAOHibernate extends BeGenHibernateDaoSupport implements SysActionViewFormDAO {    

    /**
     *  �����������SysActionViewForm����.
     *  @param pkey SysActionViewForm����
     *  @return SysActionViewForm.
     */
    public SysActionViewForm getSysActionViewForm(java.lang.String pkey) {
        SysActionViewForm sysActionViewForm = (SysActionViewForm) getHibernateTemplate().get(SysActionViewForm.class, pkey);
        if (sysActionViewForm == null) {
            return sysActionViewForm;
        }
        return sysActionViewForm;

    }

    /**
     *  �洢SysActionViewForm����.
     *  @param  sysActionViewForm SysActionViewForm����
     *  @return SysActionViewForm.
     */
    public SysActionViewForm saveSysActionViewForm(SysActionViewForm sysActionViewForm) {
        return (SysActionViewForm) getHibernateTemplate().merge(sysActionViewForm);
    }

    /**
     *  ɾ��SysActionViewForm����.
     *  @param pkey SysActionViewForm����.
     */
    public void removeSysActionViewForm(java.lang.String pkey) {
        SysActionViewForm sysActionViewForm = getSysActionViewForm(pkey);
        getHibernateTemplate().delete(sysActionViewForm);
    }

    /**
     *  ��ȡSysActionViewForm�����б�.
     *  @param  sysActionViewForm SysActionViewForm����
     *  @return List.
     */
    public List getSysActionViewFormList(SysActionViewForm sysActionViewForm) {
        Criteria criteria = getSession().createCriteria(SysActionViewForm.class).add(
                Example.create(sysActionViewForm));
        if (sysActionViewForm.getId() != null) {
            criteria.add(Expression.eq("id", sysActionViewForm.getId()));
        }
        criteria.addOrder(Order.asc("sysRecordOrder"));
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡSysActionViewForm�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysActionViewFormListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysActionViewForm where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysActionViewForm.class);

        criteria.addOrder(Order.asc("sysRecordOrder"));
        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡSysActionViewForm�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysActionViewFormListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysActionViewForm where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysActionViewForm.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������SysActionViewForm����
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

        if (queryMap.get("sysFormLayout") != null) {
            criteria = criteria.add(Expression.eq("sysFormLayout", queryMap.get("sysFormLayout")));
        }
        if (queryMap.get("sysFormLayout_like") != null) {
            criteria = criteria.add(Expression.like("sysFormLayout", "%" + queryMap.get("sysFormLayout_like") + "%"));
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
