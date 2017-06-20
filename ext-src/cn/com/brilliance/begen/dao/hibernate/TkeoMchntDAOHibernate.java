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
import org.hibernate.criterion.Projections;

import cn.com.brilliance.begen.dao.TkeoMchntDAO;
import cn.com.brilliance.begen.model.TkeoMchnt;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * TkeoMchntDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class TkeoMchntDAOHibernate extends BeGenHibernateDaoSupport implements TkeoMchntDAO {    

    /**
     *  �����������TkeoMchnt����.
     *  @param pkey TkeoMchnt����
     *  @return TkeoMchnt.
     */
    public TkeoMchnt getTkeoMchnt(java.lang.String pkey) {
        TkeoMchnt tkeoMchnt = (TkeoMchnt) getHibernateTemplate().get(TkeoMchnt.class, pkey);
        if (tkeoMchnt == null) {
            return tkeoMchnt;
        }
        return tkeoMchnt;

    }

    /**
     *  �洢TkeoMchnt����.
     *  @param  tkeoMchnt TkeoMchnt����
     *  @return TkeoMchnt.
     */
    public TkeoMchnt saveTkeoMchnt(TkeoMchnt tkeoMchnt) {
        return (TkeoMchnt) getHibernateTemplate().merge(tkeoMchnt);
    }

    /**
     *  ɾ��TkeoMchnt����.
     *  @param pkey TkeoMchnt����.
     */
    public void removeTkeoMchnt(java.lang.String pkey) {
        TkeoMchnt tkeoMchnt = getTkeoMchnt(pkey);
        getHibernateTemplate().delete(tkeoMchnt);
    }

    /**
     *  ��ȡTkeoMchnt�����б�.
     *  @param  tkeoMchnt TkeoMchnt����
     *  @return List.
     */
    public List getTkeoMchntList(TkeoMchnt tkeoMchnt) {
        Criteria criteria = getSession().createCriteria(TkeoMchnt.class).add(
                Example.create(tkeoMchnt));
        if (tkeoMchnt.getId() != null) {
            criteria.add(Expression.eq("id", tkeoMchnt.getId()));
        }
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡTkeoMchnt�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getTkeoMchntListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TkeoMchnt where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(TkeoMchnt.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡTkeoMchnt�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getTkeoMchntListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TkeoMchnt where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(TkeoMchnt.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������TkeoMchnt����
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

        if (queryMap.get("mchntCd") != null) {
            criteria = criteria.add(Expression.eq("mchntCd", queryMap.get("mchntCd")));
        }
        if (queryMap.get("mchntCd_like") != null) {
            criteria = criteria.add(Expression.like("mchntCd", "%" + queryMap.get("mchntCd_like") + "%"));
        }

        if (queryMap.get("reason") != null) {
            criteria = criteria.add(Expression.eq("reason", queryMap.get("reason")));
        }
        if (queryMap.get("reason_like") != null) {
            criteria = criteria.add(Expression.like("reason", "%" + queryMap.get("reason_like") + "%"));
        }

        if (queryMap.get("mchntName") != null) {
            criteria = criteria.add(Expression.eq("mchntName", queryMap.get("mchntName")));
        }
        if (queryMap.get("mchntName_like") != null) {
            criteria = criteria.add(Expression.like("mchntName", "%" + queryMap.get("mchntName_like") + "%"));
        }

        if (queryMap.get("type") != null) {
            criteria = criteria.add(Expression.eq("type", queryMap.get("type")));
        }
        if (queryMap.get("type_like") != null) {
            criteria = criteria.add(Expression.like("type", "%" + queryMap.get("type_like") + "%"));
        }

        if (queryMap.get("belongToInst") != null) {
            criteria = criteria.add(Expression.eq("belongToInst", queryMap.get("belongToInst")));
        }
        if (queryMap.get("belongToInst_like") != null) {
            criteria = criteria.add(Expression.like("belongToInst", "%" + queryMap.get("belongToInst_like") + "%"));
        }

        if (queryMap.get("settlementAccntNo") != null) {
            criteria = criteria.add(Expression.eq("settlementAccntNo", queryMap.get("settlementAccntNo")));
        }
        if (queryMap.get("settlementAccntNo_like") != null) {
            criteria = criteria.add(Expression.like("settlementAccntNo", "%" + queryMap.get("settlementAccntNo_like") + "%"));
        }

        if (queryMap.get("state") != null) {
            criteria = criteria.add(Expression.eq("state", queryMap.get("state")));
        }
        if (queryMap.get("state_like") != null) {
            criteria = criteria.add(Expression.like("state", "%" + queryMap.get("state_like") + "%"));
        }

        if (queryMap.get("approvedDate") != null) {
            criteria = criteria.add(Expression.eq("approvedDate", java.sql.Date.valueOf((String) queryMap.get("approvedDate"))));
        }
        if (queryMap.get("approvedDate_min") != null) {
            criteria = criteria.add(Expression.ge("approvedDate", java.sql.Date.valueOf((String) queryMap.get("approvedDate_min"))));
        }
        if (queryMap.get("approvedDate_max") != null) {
            criteria = criteria.add(Expression.le("approvedDate", java.sql.Date.valueOf((String) queryMap.get("approvedDate_max"))));
        }
        if (queryMap.get("withdrawInputdate") != null) {
            criteria = criteria.add(Expression.eq("withdrawInputdate", java.sql.Date.valueOf((String) queryMap.get("withdrawInputdate"))));
        }
        if (queryMap.get("withdrawInputdate_min") != null) {
            criteria = criteria.add(Expression.ge("withdrawInputdate", java.sql.Date.valueOf((String) queryMap.get("withdrawInputdate_min"))));
        }
        if (queryMap.get("withdrawInputdate_max") != null) {
            criteria = criteria.add(Expression.le("withdrawInputdate", java.sql.Date.valueOf((String) queryMap.get("withdrawInputdate_max"))));
        }
        if (queryMap.get("mchntId") != null) {
            criteria = criteria.add(Expression.eq("mchntId", queryMap.get("mchntId")));
        }
        if (queryMap.get("mchntId_like") != null) {
            criteria = criteria.add(Expression.like("mchntId", "%" + queryMap.get("mchntId_like") + "%"));
        }

        if (queryMap.get("startRow") != null) {
			criteria = criteria.setFirstResult(new Integer((String) queryMap
					.get("startRow")));
		}
		if (queryMap.get("pageSize") != null) {
			criteria = criteria.setMaxResults(new Integer((String) queryMap
					.get("pageSize")));
		}
        

        //���ݲ�ѯqueryMap�ļ�ֵ���ṩ������,_order="����1 asc|desc,����2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
    
    /**
     * �����̻�ID,���������Լ��������Ͳ�ѯ�̻������Ϣ
     */
    public TkeoMchnt getKeoMchntByMerId(String merId,String type){
    	TkeoMchnt keoMchnt = new TkeoMchnt();
    	String hsql = " mchnt_id=" +"'"+merId +"'"+ " and type=" +"'" +type + "'";
        
        Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TkeoMchnt where " + hsql);
        keoMchnt = (TkeoMchnt)query.uniqueResult();
        return keoMchnt ;
        
    }
    
    /**
     * �����¼����
     */
    public int getTkeoMchntListOfQueryCount(Map queryFields){
    	Criteria criteria = getSession().createCriteria(TkeoMchnt.class);
        return getListFromQueryCountMap(queryFields, criteria);
    }
    
    private int getListFromQueryCountMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������TkeoMchnt����
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

        if (queryMap.get("mchntCd") != null) {
            criteria = criteria.add(Expression.eq("mchntCd", queryMap.get("mchntCd")));
        }
        if (queryMap.get("mchntCd_like") != null) {
            criteria = criteria.add(Expression.like("mchntCd", "%" + queryMap.get("mchntCd_like") + "%"));
        }

        if (queryMap.get("reason") != null) {
            criteria = criteria.add(Expression.eq("reason", queryMap.get("reason")));
        }
        if (queryMap.get("reason_like") != null) {
            criteria = criteria.add(Expression.like("reason", "%" + queryMap.get("reason_like") + "%"));
        }

        if (queryMap.get("mchntName") != null) {
            criteria = criteria.add(Expression.eq("mchntName", queryMap.get("mchntName")));
        }
        if (queryMap.get("mchntName_like") != null) {
            criteria = criteria.add(Expression.like("mchntName", "%" + queryMap.get("mchntName_like") + "%"));
        }

        if (queryMap.get("type") != null) {
            criteria = criteria.add(Expression.eq("type", queryMap.get("type")));
        }
        if (queryMap.get("type_like") != null) {
            criteria = criteria.add(Expression.like("type", "%" + queryMap.get("type_like") + "%"));
        }

        if (queryMap.get("belongToInst") != null) {
            criteria = criteria.add(Expression.eq("belongToInst", queryMap.get("belongToInst")));
        }
        if (queryMap.get("belongToInst_like") != null) {
            criteria = criteria.add(Expression.like("belongToInst", "%" + queryMap.get("belongToInst_like") + "%"));
        }

        if (queryMap.get("settlementAccntNo") != null) {
            criteria = criteria.add(Expression.eq("settlementAccntNo", queryMap.get("settlementAccntNo")));
        }
        if (queryMap.get("settlementAccntNo_like") != null) {
            criteria = criteria.add(Expression.like("settlementAccntNo", "%" + queryMap.get("settlementAccntNo_like") + "%"));
        }

        if (queryMap.get("state") != null) {
            criteria = criteria.add(Expression.eq("state", queryMap.get("state")));
        }
        if (queryMap.get("state_like") != null) {
            criteria = criteria.add(Expression.like("state", "%" + queryMap.get("state_like") + "%"));
        }

        if (queryMap.get("approvedDate") != null) {
            criteria = criteria.add(Expression.eq("approvedDate", java.sql.Date.valueOf((String) queryMap.get("approvedDate"))));
        }
        if (queryMap.get("approvedDate_min") != null) {
            criteria = criteria.add(Expression.ge("approvedDate", java.sql.Date.valueOf((String) queryMap.get("approvedDate_min"))));
        }
        if (queryMap.get("approvedDate_max") != null) {
            criteria = criteria.add(Expression.le("approvedDate", java.sql.Date.valueOf((String) queryMap.get("approvedDate_max"))));
        }
        if (queryMap.get("withdrawInputdate") != null) {
            criteria = criteria.add(Expression.eq("withdrawInputdate", java.sql.Date.valueOf((String) queryMap.get("withdrawInputdate"))));
        }
        if (queryMap.get("withdrawInputdate_min") != null) {
            criteria = criteria.add(Expression.ge("withdrawInputdate", java.sql.Date.valueOf((String) queryMap.get("withdrawInputdate_min"))));
        }
        if (queryMap.get("withdrawInputdate_max") != null) {
            criteria = criteria.add(Expression.le("withdrawInputdate", java.sql.Date.valueOf((String) queryMap.get("withdrawInputdate_max"))));
        }
        if (queryMap.get("mchntId") != null) {
            criteria = criteria.add(Expression.eq("mchntId", queryMap.get("mchntId")));
        }
        if (queryMap.get("mchntId_like") != null) {
            criteria = criteria.add(Expression.like("mchntId", "%" + queryMap.get("mchntId_like") + "%"));
        }

        int totalCount = ((Integer) criteria.setProjection(
				Projections.rowCount()).uniqueResult()).intValue();
		return totalCount;
        
    }
    
    
    
}
