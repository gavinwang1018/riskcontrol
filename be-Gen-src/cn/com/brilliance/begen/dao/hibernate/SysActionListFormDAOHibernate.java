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

import cn.com.brilliance.begen.dao.SysActionListFormDAO;
import cn.com.brilliance.begen.model.SysActionListForm;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysActionListFormDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class SysActionListFormDAOHibernate extends BeGenHibernateDaoSupport implements SysActionListFormDAO {    

    /**
     *  �����������SysActionListForm����.
     *  @param pkey SysActionListForm����
     *  @return SysActionListForm.
     */
    public SysActionListForm getSysActionListForm(java.lang.String pkey) {
        SysActionListForm sysActionListForm = (SysActionListForm) getHibernateTemplate().get(SysActionListForm.class, pkey);
        if (sysActionListForm == null) {
            return sysActionListForm;
        }
        return sysActionListForm;

    }

    /**
     *  �洢SysActionListForm����.
     *  @param  sysActionListForm SysActionListForm����
     *  @return SysActionListForm.
     */
    public SysActionListForm saveSysActionListForm(SysActionListForm sysActionListForm) {
        return (SysActionListForm) getHibernateTemplate().merge(sysActionListForm);
    }

    /**
     *  ɾ��SysActionListForm����.
     *  @param pkey SysActionListForm����.
     */
    public void removeSysActionListForm(java.lang.String pkey) {
        SysActionListForm sysActionListForm = getSysActionListForm(pkey);
        getHibernateTemplate().delete(sysActionListForm);
    }

    /**
     *  ��ȡSysActionListForm�����б�.
     *  @param  sysActionListForm SysActionListForm����
     *  @return List.
     */
    public List getSysActionListFormList(SysActionListForm sysActionListForm) {
        Criteria criteria = getSession().createCriteria(SysActionListForm.class).add(
                Example.create(sysActionListForm));
        if (sysActionListForm.getId() != null) {
            criteria.add(Expression.eq("id", sysActionListForm.getId()));
        }
        criteria.addOrder(Order.asc("sysRecordOrder"));
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡSysActionListForm�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysActionListFormListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysActionListForm where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysActionListForm.class);

        criteria.addOrder(Order.asc("sysRecordOrder"));
        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡSysActionListForm�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysActionListFormListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysActionListForm where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysActionListForm.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������SysActionListForm����
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
