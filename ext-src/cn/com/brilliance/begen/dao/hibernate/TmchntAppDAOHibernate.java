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

import cn.com.brilliance.begen.dao.TmchntAppDAO;
import cn.com.brilliance.begen.model.TmchntApp;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * TmchntAppDAO�ӿھ���ʵ����.
 * @author Administrator.
 */

public class TmchntAppDAOHibernate extends BeGenHibernateDaoSupport implements TmchntAppDAO {    

    /**
     *  �����������TmchntApp����.
     *  @param pkey TmchntApp����
     *  @return TmchntApp.
     */
    public TmchntApp getTmchntApp(java.lang.String pkey) {
        TmchntApp tmchntApp = (TmchntApp) getHibernateTemplate().get(TmchntApp.class, pkey);
        if (tmchntApp == null) {
            return tmchntApp;
        }
        return tmchntApp;

    }

    /**
     *  �洢TmchntApp����.
     *  @param  tmchntApp TmchntApp����
     *  @return TmchntApp.
     */
    public TmchntApp saveTmchntApp(TmchntApp tmchntApp) {
        return (TmchntApp) getHibernateTemplate().merge(tmchntApp);
    }

    /**
     *  ɾ��TmchntApp����.
     *  @param pkey TmchntApp����.
     */
    public void removeTmchntApp(java.lang.String pkey) {
        TmchntApp tmchntApp = getTmchntApp(pkey);
        getHibernateTemplate().delete(tmchntApp);
    }

    /**
     *  ��ȡTmchntApp�����б�.
     *  @param  tmchntApp TmchntApp����
     *  @return List.
     */
    public List getTmchntAppList(TmchntApp tmchntApp) {
        Criteria criteria = getSession().createCriteria(TmchntApp.class).add(
                Example.create(tmchntApp));
        if (tmchntApp.getId() != null) {
            criteria.add(Expression.eq("id", tmchntApp.getId()));
        }
        return criteria.list();
    }

    /**
     *  ���ݲ�ѯ������ȡTmchntApp�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getTmchntAppListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TmchntApp where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(TmchntApp.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  ���ݲ�ѯ������ȡTmchntApp�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    public List getTmchntAppListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TmchntApp where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(TmchntApp.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //���ݲ�ѯqueryMap�ļ�ֵ������TmchntApp����
        Object[] keyArray = queryMap.keySet().toArray();  //ת����ѯ�ֶ���keySetΪ����
        //���������飬ȥ����Ӧ��ѯ�ֶ�ֵΪ�յļ�ֵ
        for (int i = 0; i < keyArray.length; i++) {
            String value = (String) queryMap.get(keyArray[i]);
            if (value == null || value.trim().length() == 0) {
                queryMap.remove(keyArray[i]);
            }
        }

        if (queryMap.get("mchntId") != null) {
            criteria = criteria.add(Expression.eq("mchntId", queryMap.get("mchntId")));
        }
        if (queryMap.get("mchntId_like") != null) {
            criteria = criteria.add(Expression.like("mchntId", "%" + queryMap.get("mchntId_like") + "%"));
        }

        if (queryMap.get("name_like") != null) {
            criteria = criteria.add(Expression.like("name", "%" + queryMap.get("name_like") + "%"));
        }
        if (queryMap.get("merchantno_like") != null) {
            criteria = criteria.add(Expression.like("merchantno", "%" + queryMap.get("merchantno_like") + "%"));
        }
        if (queryMap.get("apptype") != null) {
            criteria = criteria.add(Expression.eq("apptype", queryMap.get("apptype")));
        }
        if (queryMap.get("apptype_like") != null) {
            criteria = criteria.add(Expression.like("apptype", "%" + queryMap.get("apptype_like") + "%"));
        }

        if (queryMap.get("main") != null) {
            criteria = criteria.add(Expression.eq("main", new Boolean((String) queryMap.get("main"))));
        }
        if (queryMap.get("acquirer") != null) {
            criteria = criteria.add(Expression.eq("acquirer", queryMap.get("acquirer")));
        }
        if (queryMap.get("acquirer_like") != null) {
            criteria = criteria.add(Expression.like("acquirer", "%" + queryMap.get("acquirer_like") + "%"));
        }

        if (queryMap.get("networktransferinst") != null) {
            criteria = criteria.add(Expression.eq("networktransferinst", queryMap.get("networktransferinst")));
        }
        if (queryMap.get("networktransferinst_like") != null) {
            criteria = criteria.add(Expression.like("networktransferinst", "%" + queryMap.get("networktransferinst_like") + "%"));
        }

        if (queryMap.get("memberinstmerno") != null) {
            criteria = criteria.add(Expression.eq("memberinstmerno", queryMap.get("memberinstmerno")));
        }
        if (queryMap.get("memberinstmerno_like") != null) {
            criteria = criteria.add(Expression.like("memberinstmerno", "%" + queryMap.get("memberinstmerno_like") + "%"));
        }

        if (queryMap.get("depositbank") != null) {
            criteria = criteria.add(Expression.eq("depositbank", queryMap.get("depositbank")));
        }
        if (queryMap.get("depositbank_like") != null) {
            criteria = criteria.add(Expression.like("depositbank", "%" + queryMap.get("depositbank_like") + "%"));
        }

        if (queryMap.get("settlementaccntname") != null) {
            criteria = criteria.add(Expression.eq("settlementaccntname", queryMap.get("settlementaccntname")));
        }
        if (queryMap.get("settlementaccntname_like") != null) {
            criteria = criteria.add(Expression.like("settlementaccntname", "%" + queryMap.get("settlementaccntname_like") + "%"));
        }

        if (queryMap.get("settlementaccntno") != null) {
            criteria = criteria.add(Expression.eq("settlementaccntno", queryMap.get("settlementaccntno")));
        }
        if (queryMap.get("settlementaccntno_like") != null) {
            criteria = criteria.add(Expression.like("settlementaccntno", "%" + queryMap.get("settlementaccntno_like") + "%"));
        }

        if (queryMap.get("belongToInst") != null) {
            criteria = criteria.add(Expression.eq("belongToInst", queryMap.get("belongToInst")));
        }
        if (queryMap.get("belongToInst_like") != null) {
            criteria = criteria.add(Expression.like("belongToInst", "%" + queryMap.get("belongToInst_like") + "%"));
        }

        if (queryMap.get("id") != null) {
            criteria = criteria.add(Expression.eq("id", queryMap.get("id")));
        }
        if (queryMap.get("id_like") != null) {
            criteria = criteria.add(Expression.like("id", "%" + queryMap.get("id_like") + "%"));
        }


        //���ݲ�ѯqueryMap�ļ�ֵ���ṩ������,_order="����1 asc|desc,����2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
    
    
    
    public String getTmchntAppMain(String id){
    	String hsql = "mchnt_id=" +"'"+ id + "'" + "and main=1";
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TmchntApp where " + hsql);
            TmchntApp app = (TmchntApp) query.uniqueResult();
            return app.getSettlementaccntno();
        
        
    }
}
