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

import cn.com.brilliance.begen.dao.TmccDAO;
import cn.com.brilliance.begen.model.Tmcc;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * TmccDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class TmccDAOHibernate extends BeGenHibernateDaoSupport implements TmccDAO {    

    /**
     *  �����������Tmcc����.
     *  @param pkey Tmcc����
     *  @return Tmcc.
     */
    public Tmcc getTmcc(java.lang.String pkey) {
        Tmcc tmcc = (Tmcc) getHibernateTemplate().get(Tmcc.class, pkey);
        if (tmcc == null) {
            return tmcc;
        }
        return tmcc;

    }

    /**
     *  �洢Tmcc����.
     *  @param  tmcc Tmcc����
     *  @return Tmcc.
     */
    public Tmcc saveTmcc(Tmcc tmcc) {
        return (Tmcc) getHibernateTemplate().merge(tmcc);
    }

    /**
     *  ɾ��Tmcc����.
     *  @param pkey Tmcc����.
     */
    public void removeTmcc(java.lang.String pkey) {
        Tmcc tmcc = getTmcc(pkey);
        getHibernateTemplate().delete(tmcc);
    }

    /**
     *  ��ȡTmcc�����б�.
     *  @param  tmcc Tmcc����
     *  @return List.
     */
    public List getTmccList(Tmcc tmcc) {
        Criteria criteria = getSession().createCriteria(Tmcc.class).add(
                Example.create(tmcc));
        if (tmcc.getId() != null) {
            criteria.add(Expression.eq("id", tmcc.getId()));
        }
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡTmcc�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getTmccListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.Tmcc where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(Tmcc.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    public List getTmccNames(Map queryMap){
    	 Query query = getSession().createQuery("from cn.com.brilliance.begen.model.Tmcc order by bigmcc_code"  );
         return query.list();
    	
    }
    
    
    
    /**
     *  ���ݲ�ѯ������ȡTmcc�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getTmccListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.Tmcc where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(Tmcc.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������Tmcc����
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

        if (queryMap.get("mccName") != null) {
            criteria = criteria.add(Expression.eq("mccName", queryMap.get("mccName")));
        }
        if (queryMap.get("mccName_like") != null) {
            criteria = criteria.add(Expression.like("mccName", "%" + queryMap.get("mccName_like") + "%"));
        }

        if (queryMap.get("mccCode") != null) {
            criteria = criteria.add(Expression.eq("mccCode", queryMap.get("mccCode")));
        }
       /* if (queryMap.get("mccCode_like") != null) {
            criteria = criteria.add(Expression.like("mccCode", "%" + queryMap.get("mccCode_like") + "%"));
        }*/
        if (queryMap.get("mccCode_like") != null) {
            criteria = criteria.add(Expression.like("mccCode",  queryMap.get("mccCode_like") + "%"));
        }
        
        if (queryMap.get("bigmccName") != null) {
            criteria = criteria.add(Expression.eq("bigmccName", queryMap.get("bigmccName")));
        }
        if (queryMap.get("bigmccName_like") != null) {
            criteria = criteria.add(Expression.like("bigmccName", "%" + queryMap.get("bigmccName_like") + "%"));
        }

        if (queryMap.get("bigmccCode") != null) {
            criteria = criteria.add(Expression.eq("bigmccCode", queryMap.get("bigmccCode")));
        }
        if (queryMap.get("bigmccCode_like") != null) {
            criteria = criteria.add(Expression.like("bigmccCode", "%" + queryMap.get("bigmccCode_like") + "%"));
        }

        if (queryMap.get("midmccName") != null) {
            criteria = criteria.add(Expression.eq("midmccName", queryMap.get("midmccName")));
        }
        if (queryMap.get("midmccName_like") != null) {
            criteria = criteria.add(Expression.like("midmccName", "%" + queryMap.get("midmccName_like") + "%"));
        }

        if (queryMap.get("midmccCode") != null) {
            criteria = criteria.add(Expression.eq("midmccCode", queryMap.get("midmccCode")));
        }
        if (queryMap.get("midmccCode_like") != null) {
            criteria = criteria.add(Expression.like("midmccCode", "%" + queryMap.get("midmccCode_like") + "%"));
        }


        //���ݲ�ѯqueryMap�ļ�ֵ���ṩ������,_order="����1 asc|desc,����2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
    
    public List getTmccByBigMcc(String bigmcc){
    	Criteria criteria = getSession().createCriteria(Tmcc.class);
        criteria = criteria.add(Expression.eq("bigmccCode", bigmcc));
        criteria.addOrder(Order.asc("mccCode"));
        return criteria.list();
    }
    
}
