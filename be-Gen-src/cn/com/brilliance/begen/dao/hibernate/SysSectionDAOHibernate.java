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

import cn.com.brilliance.begen.dao.SysSectionDAO;
import cn.com.brilliance.begen.model.SysSection;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysSectionDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class SysSectionDAOHibernate extends BeGenHibernateDaoSupport implements SysSectionDAO {    

    /**
     *  �����������SysSection����.
     *  @param pkey SysSection����
     *  @return SysSection.
     */
    public SysSection getSysSection(java.lang.String pkey) {
        SysSection sysSection = (SysSection) getHibernateTemplate().get(SysSection.class, pkey);
        if (sysSection == null) {
            return sysSection;
        }
        return sysSection;

    }

    /**
     *  �洢SysSection����.
     *  @param  sysSection SysSection����
     *  @return SysSection.
     */
    public SysSection saveSysSection(SysSection sysSection) {
        return (SysSection) getHibernateTemplate().merge(sysSection);
    }

    /**
     *  ɾ��SysSection����.
     *  @param pkey SysSection����.
     */
    public void removeSysSection(java.lang.String pkey) {
        SysSection sysSection = getSysSection(pkey);
        getHibernateTemplate().delete(sysSection);
    }

    /**
     *  ��ȡSysSection�����б�.
     *  @param  sysSection SysSection����
     *  @return List.
     */
    public List getSysSectionList(SysSection sysSection) {
        Criteria criteria = getSession().createCriteria(SysSection.class).add(
                Example.create(sysSection));
        if (sysSection.getId() != null) {
            criteria.add(Expression.eq("id", sysSection.getId()));
        }
        criteria.addOrder(Order.asc("sysRecordOrder"));
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡSysSection�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysSectionListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysSection where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysSection.class);

        criteria.addOrder(Order.asc("sysRecordOrder"));
        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡSysSection�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getSysSectionListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysSection where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysSection.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������SysSection����
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

        if (queryMap.get("formLayout") != null) {
            criteria = criteria.add(Expression.eq("formLayout", queryMap.get("formLayout")));
        }
        if (queryMap.get("formLayout_like") != null) {
            criteria = criteria.add(Expression.like("formLayout", "%" + queryMap.get("formLayout_like") + "%"));
        }

        if (queryMap.get("name") != null) {
            criteria = criteria.add(Expression.eq("name", queryMap.get("name")));
        }
        if (queryMap.get("name_like") != null) {
            criteria = criteria.add(Expression.like("name", "%" + queryMap.get("name_like") + "%"));
        }

        if (queryMap.get("partyId") != null) {
            criteria = criteria.add(Expression.eq("partyId", queryMap.get("partyId")));
        }
        if (queryMap.get("partyId_like") != null) {
            criteria = criteria.add(Expression.like("partyId", "%" + queryMap.get("partyId_like") + "%"));
        }

        if (queryMap.get("sectionText") != null) {
            criteria = criteria.add(Expression.eq("sectionText", queryMap.get("sectionText")));
        }
        if (queryMap.get("sectionText_like") != null) {
            criteria = criteria.add(Expression.like("sectionText", "%" + queryMap.get("sectionText_like") + "%"));
        }

        if (queryMap.get("detailHeading") != null) {
            criteria = criteria.add(Expression.eq("detailHeading", queryMap.get("detailHeading")));
        }
        if (queryMap.get("detailHeading_like") != null) {
            criteria = criteria.add(Expression.like("detailHeading", "%" + queryMap.get("detailHeading_like") + "%"));
        }

        if (queryMap.get("sectionType") != null) {
            criteria = criteria.add(Expression.eq("sectionType", queryMap.get("sectionType")));
        }
        if (queryMap.get("sectionType_like") != null) {
            criteria = criteria.add(Expression.like("sectionType", "%" + queryMap.get("sectionType_like") + "%"));
        }

        if (queryMap.get("editHeading") != null) {
            criteria = criteria.add(Expression.eq("editHeading", queryMap.get("editHeading")));
        }
        if (queryMap.get("editHeading_like") != null) {
            criteria = criteria.add(Expression.like("editHeading", "%" + queryMap.get("editHeading_like") + "%"));
        }

        if (queryMap.get("numColumns") != null) {
            criteria = criteria.add(Expression.eq("numColumns", new Integer((String) queryMap.get("numColumns"))));
        }
        if (queryMap.get("numColumns_min") != null) {
            criteria = criteria.add(Expression.ge("numColumns", new Integer((String) queryMap.get("numColumns_min"))));
        }
        if (queryMap.get("numColumns_max") != null) {
            criteria = criteria.add(Expression.le("numColumns", new Integer((String) queryMap.get("numColumns_max"))));
        }
        if (queryMap.get("maxRow") != null) {
            criteria = criteria.add(Expression.eq("maxRow", new Integer((String) queryMap.get("maxRow"))));
        }
        if (queryMap.get("maxRow_min") != null) {
            criteria = criteria.add(Expression.ge("maxRow", new Integer((String) queryMap.get("maxRow_min"))));
        }
        if (queryMap.get("maxRow_max") != null) {
            criteria = criteria.add(Expression.le("maxRow", new Integer((String) queryMap.get("maxRow_max"))));
        }

        //���ݲ�ѯqueryMap�ļ�ֵ���ṩ������,_order="����1 asc|desc,����2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
