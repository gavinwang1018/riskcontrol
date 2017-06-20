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

import cn.com.brilliance.begen.dao.TorganizeInfoDAO;
import cn.com.brilliance.begen.model.TorganizeInfo;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * TorganizeInfoDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class TorganizeInfoDAOHibernate extends BeGenHibernateDaoSupport implements TorganizeInfoDAO {    

    /**
     *  �����������TorganizeInfo����.
     *  @param pkey TorganizeInfo����
     *  @return TorganizeInfo.
     */
    public TorganizeInfo getTorganizeInfo(java.lang.String pkey) {
        TorganizeInfo torganizeInfo = (TorganizeInfo) getHibernateTemplate().get(TorganizeInfo.class, pkey);
        if (torganizeInfo == null) {
            return torganizeInfo;
        }
        return torganizeInfo;

    }

    /**
     *  �洢TorganizeInfo����.
     *  @param  torganizeInfo TorganizeInfo����
     *  @return TorganizeInfo.
     */
    public TorganizeInfo saveTorganizeInfo(TorganizeInfo torganizeInfo) {
        return (TorganizeInfo) getHibernateTemplate().merge(torganizeInfo);
    }

    /**
     *  ɾ��TorganizeInfo����.
     *  @param pkey TorganizeInfo����.
     */
    public void removeTorganizeInfo(java.lang.String pkey) {
        TorganizeInfo torganizeInfo = getTorganizeInfo(pkey);
        getHibernateTemplate().delete(torganizeInfo);
    }

    /**
     *  ��ȡTorganizeInfo�����б�.
     *  @param  torganizeInfo TorganizeInfo����
     *  @return List.
     */
    public List getTorganizeInfoList(TorganizeInfo torganizeInfo) {
        Criteria criteria = getSession().createCriteria(TorganizeInfo.class).add(
                Example.create(torganizeInfo));
        if (torganizeInfo.getId() != null) {
            criteria.add(Expression.eq("id", torganizeInfo.getId()));
        }
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡTorganizeInfo�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getTorganizeInfoListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TorganizeInfo where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(TorganizeInfo.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡTorganizeInfo�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getTorganizeInfoListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TorganizeInfo where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(TorganizeInfo.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������TorganizeInfo����
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

        if (queryMap.get("name") != null) {
            criteria = criteria.add(Expression.eq("name", queryMap.get("name")));
        }
        if (queryMap.get("name_like") != null) {
            criteria = criteria.add(Expression.like("name", "%" + queryMap.get("name_like") + "%"));
        }

        if (queryMap.get("dwFlag") != null) {
            criteria = criteria.add(Expression.eq("dwFlag", new Boolean((String) queryMap.get("dwFlag"))));
        }
        if (queryMap.get("originalSort") != null) {
            criteria = criteria.add(Expression.eq("originalSort", queryMap.get("originalSort")));
        }
        if (queryMap.get("originalSort_like") != null) {
            criteria = criteria.add(Expression.like("originalSort", "%" + queryMap.get("originalSort_like") + "%"));
        }

        if (queryMap.get("globalSort") != null) {
            criteria = criteria.add(Expression.eq("globalSort", queryMap.get("globalSort")));
        }
        if (queryMap.get("globalSort_like") != null) {
            criteria = criteria.add(Expression.like("globalSort", "" + queryMap.get("globalSort_like") + "%"));
        }

        if (queryMap.get("fwdInsIdCd") != null) {
            criteria = criteria.add(Expression.eq("fwdInsIdCd", queryMap.get("fwdInsIdCd")));
        }
        if (queryMap.get("fwdInsIdCd_like") != null) {
            criteria = criteria.add(Expression.like("fwdInsIdCd", "%" + queryMap.get("fwdInsIdCd_like") + "%"));
        }

        if (queryMap.get("parentId") != null) {
            criteria = criteria.add(Expression.eq("parentId", queryMap.get("parentId")));
        }
        if (queryMap.get("parentId_like") != null) {
            criteria = criteria.add(Expression.like("parentId", "%" + queryMap.get("parentId_like") + "%"));
        }

        if (queryMap.get("organizeBm") != null) {
            criteria = criteria.add(Expression.eq("organizeBm", queryMap.get("organizeBm")));
        }
        if (queryMap.get("organizeBm_like") != null) {
            criteria = criteria.add(Expression.like("organizeBm", "%" + queryMap.get("organizeBm_like") + "%"));
        }

        if (queryMap.get("organizeLevel") != null) {
            criteria = criteria.add(Expression.eq("organizeLevel", new Integer((String) queryMap.get("organizeLevel"))));
        }
        if (queryMap.get("organizeLevel_min") != null) {
            criteria = criteria.add(Expression.ge("organizeLevel", new Integer((String) queryMap.get("organizeLevel_min"))));
        }
        if (queryMap.get("organizeLevel_max") != null) {
            criteria = criteria.add(Expression.le("organizeLevel", new Integer((String) queryMap.get("organizeLevel_max"))));
        }
        if (queryMap.get("isCheck") != null) {
            criteria = criteria.add(Expression.eq("isCheck", queryMap.get("isCheck")));
        }
        if (queryMap.get("isCheck_like") != null) {
            criteria = criteria.add(Expression.like("isCheck", "%" + queryMap.get("isCheck_like") + "%"));
        }

        queryMap.put("_order", "organizeBm asc");
        
        //���ݲ�ѯqueryMap�ļ�ֵ���ṩ������,_order="����1 asc|desc,����2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
