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

import cn.com.brilliance.begen.dao.TriskcaseRecordDAO;
import cn.com.brilliance.begen.model.TriskcaseRecord;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * TriskcaseRecordDAO接口具体实现类.
 * @author Administrator.
 */

public class TriskcaseRecordDAOHibernate extends BeGenHibernateDaoSupport implements TriskcaseRecordDAO {    

    /**
     *  根据主键获得TriskcaseRecord对象.
     *  @param pkey TriskcaseRecord主键
     *  @return TriskcaseRecord.
     */
    public TriskcaseRecord getTriskcaseRecord(java.lang.String pkey) {
        TriskcaseRecord triskcaseRecord = (TriskcaseRecord) getHibernateTemplate().get(TriskcaseRecord.class, pkey);
        if (triskcaseRecord == null) {
            return triskcaseRecord;
        }
        return triskcaseRecord;

    }

    /**
     *  存储TriskcaseRecord对象.
     *  @param  triskcaseRecord TriskcaseRecord对象
     *  @return TriskcaseRecord.
     */
    public TriskcaseRecord saveTriskcaseRecord(TriskcaseRecord triskcaseRecord) {
        return (TriskcaseRecord) getHibernateTemplate().merge(triskcaseRecord);
    }

    /**
     *  删除TriskcaseRecord对象.
     *  @param pkey TriskcaseRecord主键.
     */
    public void removeTriskcaseRecord(java.lang.String pkey) {
        TriskcaseRecord triskcaseRecord = getTriskcaseRecord(pkey);
        getHibernateTemplate().delete(triskcaseRecord);
    }

    /**
     *  获取TriskcaseRecord对象列表.
     *  @param  triskcaseRecord TriskcaseRecord对象
     *  @return List.
     */
    public List getTriskcaseRecordList(TriskcaseRecord triskcaseRecord) {
        Criteria criteria = getSession().createCriteria(TriskcaseRecord.class).add(
                Example.create(triskcaseRecord));
        if (triskcaseRecord.getId() != null) {
            criteria.add(Expression.eq("id", triskcaseRecord.getId()));
        }
        return criteria.list();
    }

    /**
     *  根据查询条件获取TriskcaseRecord对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getTriskcaseRecordListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TriskcaseRecord where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(TriskcaseRecord.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取TriskcaseRecord对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getTriskcaseRecordListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TriskcaseRecord where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(TriskcaseRecord.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤TriskcaseRecord对象
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

        if (queryMap.get("investigationDate") != null) {
            criteria = criteria.add(Expression.eq("investigationDate", java.sql.Date.valueOf((String) queryMap.get("investigationDate"))));
        }
        if (queryMap.get("investigationDate_min") != null) {
            criteria = criteria.add(Expression.ge("investigationDate", java.sql.Date.valueOf((String) queryMap.get("investigationDate_min"))));
        }
        if (queryMap.get("investigationDate_max") != null) {
            criteria = criteria.add(Expression.le("investigationDate", java.sql.Date.valueOf((String) queryMap.get("investigationDate_max"))));
        }
        if (queryMap.get("createDate") != null) {
            criteria = criteria.add(Expression.eq("createDate", java.sql.Date.valueOf((String) queryMap.get("createDate"))));
        }
        if (queryMap.get("createDate_min") != null) {
            criteria = criteria.add(Expression.ge("createDate", java.sql.Date.valueOf((String) queryMap.get("createDate_min"))));
        }
        if (queryMap.get("createDate_max") != null) {
            criteria = criteria.add(Expression.le("createDate", java.sql.Date.valueOf((String) queryMap.get("createDate_max"))));
        }
        if (queryMap.get("investigationWay") != null) {
            criteria = criteria.add(Expression.eq("investigationWay", queryMap.get("investigationWay")));
        }
        if (queryMap.get("investigationWay_like") != null) {
            criteria = criteria.add(Expression.like("investigationWay", "%" + queryMap.get("investigationWay_like") + "%"));
        }

        if (queryMap.get("isPickFlow") != null) {
            criteria = criteria.add(Expression.eq("isPickFlow", new Boolean((String) queryMap.get("isPickFlow"))));
        }
        if (queryMap.get("pickCnt") != null) {
            criteria = criteria.add(Expression.eq("pickCnt", new Integer((String) queryMap.get("pickCnt"))));
        }
        if (queryMap.get("pickCnt_min") != null) {
            criteria = criteria.add(Expression.ge("pickCnt", new Integer((String) queryMap.get("pickCnt_min"))));
        }
        if (queryMap.get("pickCnt_max") != null) {
            criteria = criteria.add(Expression.le("pickCnt", new Integer((String) queryMap.get("pickCnt_max"))));
        }
        if (queryMap.get("pickAmt") != null) {
            criteria = criteria.add(Expression.eq("pickAmt", new Double((String) queryMap.get("pickAmt"))));
        }
        if (queryMap.get("pickAmt_min") != null) {
            criteria = criteria.add(Expression.ge("pickAmt", new Double((String) queryMap.get("pickAmt_min"))));
        }
        if (queryMap.get("pickAmt_max") != null) {
            criteria = criteria.add(Expression.le("pickAmt", new Double((String) queryMap.get("pickAmt_max"))));
        }
        if (queryMap.get("pick180Cnt") != null) {
            criteria = criteria.add(Expression.eq("pick180Cnt", new Integer((String) queryMap.get("pick180Cnt"))));
        }
        if (queryMap.get("pick180Cnt_min") != null) {
            criteria = criteria.add(Expression.ge("pick180Cnt", new Integer((String) queryMap.get("pick180Cnt_min"))));
        }
        if (queryMap.get("pick180Cnt_max") != null) {
            criteria = criteria.add(Expression.le("pick180Cnt", new Integer((String) queryMap.get("pick180Cnt_max"))));
        }
        if (queryMap.get("pick180Amt") != null) {
            criteria = criteria.add(Expression.eq("pick180Amt", new Double((String) queryMap.get("pick180Amt"))));
        }
        if (queryMap.get("pick180Amt_min") != null) {
            criteria = criteria.add(Expression.ge("pick180Amt", new Double((String) queryMap.get("pick180Amt_min"))));
        }
        if (queryMap.get("pick180Amt_max") != null) {
            criteria = criteria.add(Expression.le("pick180Amt", new Double((String) queryMap.get("pick180Amt_max"))));
        }
        if (queryMap.get("pickStatus") != null) {
            criteria = criteria.add(Expression.eq("pickStatus", queryMap.get("pickStatus")));
        }
        if (queryMap.get("pickStatus_like") != null) {
            criteria = criteria.add(Expression.like("pickStatus", "%" + queryMap.get("pickStatus_like") + "%"));
        }

        if (queryMap.get("pickFlawCnt") != null) {
            criteria = criteria.add(Expression.eq("pickFlawCnt", queryMap.get("pickFlawCnt")));
        }
        if (queryMap.get("pickFlawCnt_like") != null) {
            criteria = criteria.add(Expression.like("pickFlawCnt", "%" + queryMap.get("pickFlawCnt_like") + "%"));
        }
        if (queryMap.get("pickEmptyCnt") != null) {
            criteria = criteria.add(Expression.eq("pickEmptyCnt", queryMap.get("pickEmptyCnt")));
        }
        if (queryMap.get("pickEmptyCnt_like") != null) {
            criteria = criteria.add(Expression.like("pickEmptyCnt", "%" + queryMap.get("pickEmptyCnt_like") + "%"));
        }
        if (queryMap.get("investigationResult") != null) {
            criteria = criteria.add(Expression.eq("investigationResult", queryMap.get("investigationResult")));
        }
        if (queryMap.get("investigationResult_like") != null) {
            criteria = criteria.add(Expression.like("investigationResult", "%" + queryMap.get("investigationResult_like") + "%"));
        }

        if (queryMap.get("riskLevel") != null) {
            criteria = criteria.add(Expression.eq("riskLevel", queryMap.get("riskLevel")));
        }
        if (queryMap.get("riskLevel_like") != null) {
            criteria = criteria.add(Expression.like("riskLevel", "%" + queryMap.get("riskLevel_like") + "%"));
        }

        if (queryMap.get("riskType") != null) {
            criteria = criteria.add(Expression.eq("riskType", queryMap.get("riskType")));
        }
        if (queryMap.get("riskType_like") != null) {
            criteria = criteria.add(Expression.like("riskType", "%" + queryMap.get("riskType_like") + "%"));
        }

        if (queryMap.get("processType") != null) {
            criteria = criteria.add(Expression.eq("processType", queryMap.get("processType")));
        }
        if (queryMap.get("processType_like") != null) {
            criteria = criteria.add(Expression.like("processType", "%" + queryMap.get("processType_like") + "%"));
        }
        
        if (queryMap.get("process2Type") != null) {
            criteria = criteria.add(Expression.eq("process2Type", queryMap.get("process2Type")));
        }
        if (queryMap.get("process2Type_like") != null) {
            criteria = criteria.add(Expression.like("process2Type", "%" + queryMap.get("process2Type_like") + "%"));
        }        

        if (queryMap.get("processFreezeAmt") != null) {
            criteria = criteria.add(Expression.eq("processFreezeAmt", new Double((String) queryMap.get("processFreezeAmt"))));
        }
        if (queryMap.get("processFreezeAmt_min") != null) {
            criteria = criteria.add(Expression.ge("processFreezeAmt", new Double((String) queryMap.get("processFreezeAmt_min"))));
        }
        if (queryMap.get("processFreezeAmt_max") != null) {
            criteria = criteria.add(Expression.le("processFreezeAmt", new Double((String) queryMap.get("processFreezeAmt_max"))));
        }
        if (queryMap.get("processWithdrawCnt") != null) {
            criteria = criteria.add(Expression.eq("processWithdrawCnt", new Integer((String) queryMap.get("processWithdrawCnt"))));
        }
        if (queryMap.get("processWithdrawCnt_min") != null) {
            criteria = criteria.add(Expression.ge("processWithdrawCnt", new Integer((String) queryMap.get("processWithdrawCnt_min"))));
        }
        if (queryMap.get("processWithdrawCnt_max") != null) {
            criteria = criteria.add(Expression.le("processWithdrawCnt", new Integer((String) queryMap.get("processWithdrawCnt_max"))));
        }
        if (queryMap.get("description") != null) {
            criteria = criteria.add(Expression.eq("description", queryMap.get("description")));
        }
        if (queryMap.get("description_like") != null) {
            criteria = criteria.add(Expression.like("description", "%" + queryMap.get("description_like") + "%"));
        }

        if (queryMap.get("caseno") != null) {
            criteria = criteria.add(Expression.eq("caseno", queryMap.get("caseno")));
        }
        if (queryMap.get("caseno_like") != null) {
            criteria = criteria.add(Expression.like("caseno", "%" + queryMap.get("caseno_like") + "%"));
        }

        if (queryMap.get("userId") != null) {
            criteria = criteria.add(Expression.eq("userId", queryMap.get("userId")));
        }
        if (queryMap.get("userId_like") != null) {
            criteria = criteria.add(Expression.like("userId", "%" + queryMap.get("userId_like") + "%"));
        }

        if (queryMap.get("submit") != null) {
            criteria = criteria.add(Expression.eq("submit", new Boolean((String) queryMap.get("submit"))));
        }
        if (queryMap.get("otherInvestigationWay") != null) {
            criteria = criteria.add(Expression.eq("otherInvestigationWay", queryMap.get("otherInvestigationWay")));
        }
        if (queryMap.get("otherInvestigationWay_like") != null) {
            criteria = criteria.add(Expression.like("otherInvestigationWay", "%" + queryMap.get("otherInvestigationWay_like") + "%"));
        }

        if (queryMap.get("otherRiskType") != null) {
            criteria = criteria.add(Expression.eq("otherRiskType", queryMap.get("otherRiskType")));
        }
        if (queryMap.get("otherRiskType_like") != null) {
            criteria = criteria.add(Expression.like("otherRiskType", "%" + queryMap.get("otherRiskType_like") + "%"));
        }

        if (queryMap.get("otherProcessType") != null) {
            criteria = criteria.add(Expression.eq("otherProcessType", queryMap.get("otherProcessType")));
        }
        if (queryMap.get("otherProcessType_like") != null) {
            criteria = criteria.add(Expression.like("otherProcessType", "%" + queryMap.get("otherProcessType_like") + "%"));
        }
        
        if (queryMap.get("reason") != null) {
            criteria = criteria.add(Expression.eq("reason", queryMap.get("reason")));
        }
        if (queryMap.get("reason_like") != null) {
            criteria = criteria.add(Expression.like("reason", "%" + queryMap.get("reason_like") + "%"));
        }        
        if (queryMap.get("isLocked") != null) {
            criteria = criteria.add(Expression.eq("isLocked", new Boolean((String) queryMap.get("isLocked"))));
        }
        //根据查询queryMap的键值，提供排序功能,_order="域名1 asc|desc,域名2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
