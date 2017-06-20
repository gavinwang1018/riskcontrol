package cn.com.brilliance.begen.dao.hibernate;

import java.math.BigDecimal;
import java.util.ArrayList;
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

import cn.com.brilliance.begen.dao.TriskcaseDAO;
import cn.com.brilliance.begen.model.Triskcase;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;
import cn.com.brilliance.risk.ext.interfaces.DataManageController;

/**
 * TriskcaseDAO接口具体实现类.
 * @author Administrator.
 */

public class TriskcaseDAOHibernate extends BeGenHibernateDaoSupport implements TriskcaseDAO {    

    /**
     *  根据主键获得Triskcase对象.
     *  @param pkey Triskcase主键
     *  @return Triskcase.
     */
    public Triskcase getTriskcase(java.lang.String pkey) {
        Triskcase triskcase = (Triskcase) getHibernateTemplate().get(Triskcase.class, pkey);
        if (triskcase == null) {
            return triskcase;
        }
        return triskcase;

    }

    /**
     *  存储Triskcase对象.
     *  @param  triskcase Triskcase对象
     *  @return Triskcase.
     */
    public Triskcase saveTriskcase(Triskcase triskcase) {
        return (Triskcase) getHibernateTemplate().merge(triskcase);
    }

    /**
     *  删除Triskcase对象.
     *  @param pkey Triskcase主键.
     */
    public void removeTriskcase(java.lang.String pkey) {
        Triskcase triskcase = getTriskcase(pkey);
        getHibernateTemplate().delete(triskcase);
    }

    /**
     *  获取Triskcase对象列表.
     *  @param  triskcase Triskcase对象
     *  @return List.
     */
    public List getTriskcaseList(Triskcase triskcase) {
        Criteria criteria = getSession().createCriteria(Triskcase.class).add(
                Example.create(triskcase));
        if (triskcase.getId() != null) {
            criteria.add(Expression.eq("id", triskcase.getId()));
        }
        return criteria.list();
    }

    /**
     *  根据查询条件获取Triskcase对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     *  
     */
    public List getTriskcaseListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        int startRow = Integer.parseInt(((String)queryMap.get("startRow")));
        int pageSize = Integer.parseInt(((String)queryMap.get("pageSize")));
        if (hsql != null) {
        	Query query = getSession().createQuery("from cn.com.brilliance.begen.model.Triskcase triskcase where " + hsql);
        	query.setFirstResult(startRow);
        	query.setMaxResults(pageSize);
        	return query.list();
        }

        Criteria criteria = getSession().createCriteria(Triskcase.class);

        return getListFromQueryMap(queryMap, criteria);
    }
    
    public List getTriskcaseListOfQueryNoSize(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
        	Query query = getSession().createQuery("from cn.com.brilliance.begen.model.Triskcase triskcase where " + hsql);
        	return query.list();
        }

        Criteria criteria = getSession().createCriteria(Triskcase.class);

        return getListFromQueryMap(queryMap, criteria);
    }    
    
    /**
     *  根据查询条件获取Triskcase对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getTriskcaseListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");

        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.Triskcase where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(Triskcase.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤Triskcase对象
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

        if (queryMap.get("caseno") != null) {
            criteria = criteria.add(Expression.eq("caseno", queryMap.get("caseno")));
        }
        if (queryMap.get("caseno_like") != null) {
            criteria = criteria.add(Expression.like("caseno", "%" + queryMap.get("caseno_like") + "%"));
        }

        if (queryMap.get("mchntCd") != null) {
            criteria = criteria.add(Expression.eq("mchntCd", queryMap.get("mchntCd")));
        }
        if (queryMap.get("mchntCd_like") != null) {
            criteria = criteria.add(Expression.like("mchntCd", "%" + queryMap.get("mchntCd_like") + "%"));
        }

        if (queryMap.get("beginDate") != null) {
            criteria = criteria.add(Expression.eq("beginDate", java.sql.Date.valueOf((String) queryMap.get("beginDate"))));
        }
        if (queryMap.get("beginDate_min") != null) {
            criteria = criteria.add(Expression.ge("beginDate", java.sql.Date.valueOf((String) queryMap.get("beginDate_min"))));
        }
        if (queryMap.get("beginDate_max") != null) {
            criteria = criteria.add(Expression.le("beginDate", java.sql.Date.valueOf((String) queryMap.get("beginDate_max"))));
        }
        if (queryMap.get("endDate") != null) {
            criteria = criteria.add(Expression.eq("endDate", java.sql.Date.valueOf((String) queryMap.get("endDate"))));
        }
        if (queryMap.get("endDate_min") != null) {
            criteria = criteria.add(Expression.ge("endDate", java.sql.Date.valueOf((String) queryMap.get("endDate_min"))));
        }
        if (queryMap.get("endDate_max") != null) {
            criteria = criteria.add(Expression.le("endDate", java.sql.Date.valueOf((String) queryMap.get("endDate_max"))));
        }
        if (queryMap.get("belongToInst") != null) {
            criteria = criteria.add(Expression.eq("belongToInst", queryMap.get("belongToInst")));
        }
        if (queryMap.get("belongToInst_like") != null) {
            criteria = criteria.add(Expression.like("belongToInst", "%" + queryMap.get("belongToInst_like") + "%"));
        }

        if (queryMap.get("relativeTransAmt") != null) {
            criteria = criteria.add(Expression.eq("relativeTransAmt", new Double((String) queryMap.get("relativeTransAmt"))));
        }
        if (queryMap.get("relativeTransAmt_min") != null) {
            criteria = criteria.add(Expression.ge("relativeTransAmt", new Double((String) queryMap.get("relativeTransAmt_min"))));
        }
        if (queryMap.get("relativeTransAmt_max") != null) {
            criteria = criteria.add(Expression.le("relativeTransAmt", new Double((String) queryMap.get("relativeTransAmt_max"))));
        }
        if (queryMap.get("allTransAmt") != null) {
            criteria = criteria.add(Expression.eq("allTransAmt", new Double((String) queryMap.get("allTransAmt"))));
        }
        if (queryMap.get("allTransAmt_min") != null) {
            criteria = criteria.add(Expression.ge("allTransAmt", new Double((String) queryMap.get("allTransAmt_min"))));
        }
        if (queryMap.get("allTransAmt_max") != null) {
            criteria = criteria.add(Expression.le("allTransAmt", new Double((String) queryMap.get("allTransAmt_max"))));
        }
        if (queryMap.get("allTransNum") != null) {
            criteria = criteria.add(Expression.eq("allTransNum", new Long((String) queryMap.get("allTransNum"))));
        }
        if (queryMap.get("allTransNum_min") != null) {
            criteria = criteria.add(Expression.ge("allTransNum", new Long((String) queryMap.get("allTransNum_min"))));
        }
        if (queryMap.get("allTransNum_max") != null) {
            criteria = criteria.add(Expression.le("allTransNum", new Long((String) queryMap.get("allTransNum_max"))));
        }
        if (queryMap.get("createdate") != null) {
            criteria = criteria.add(Expression.eq("createdate", java.sql.Date.valueOf((String) queryMap.get("createdate"))));
        }
        if (queryMap.get("createdate_min") != null) {
            criteria = criteria.add(Expression.ge("createdate", java.sql.Date.valueOf((String) queryMap.get("createdate_min"))));
        }
        if (queryMap.get("createdate_max") != null) {
            criteria = criteria.add(Expression.le("createdate", java.sql.Date.valueOf((String) queryMap.get("createdate_max"))));
        }
        if (queryMap.get("score") != null) {
            criteria = criteria.add(Expression.eq("score", new Float((String) queryMap.get("score"))));
        }
        if (queryMap.get("score_min") != null) {
            criteria = criteria.add(Expression.ge("score", new Float((String) queryMap.get("score_min"))));
        }
        if (queryMap.get("score_max") != null) {
            criteria = criteria.add(Expression.le("score", new Float((String) queryMap.get("score_max"))));
        }
        if (queryMap.get("triggerRuleNum") != null) {
            criteria = criteria.add(Expression.eq("triggerRuleNum", new Integer((String) queryMap.get("triggerRuleNum"))));
        }
        if (queryMap.get("triggerRuleNum_min") != null) {
            criteria = criteria.add(Expression.ge("triggerRuleNum", new Integer((String) queryMap.get("triggerRuleNum_min"))));
        }
        if (queryMap.get("triggerRuleNum_max") != null) {
            criteria = criteria.add(Expression.le("triggerRuleNum", new Integer((String) queryMap.get("triggerRuleNum_max"))));
        }
        if (queryMap.get("mchntName") != null) {
            criteria = criteria.add(Expression.eq("mchntName", queryMap.get("mchntName")));
        }
        if (queryMap.get("mchntName_like") != null) {
            criteria = criteria.add(Expression.like("mchntName", "%" + queryMap.get("mchntName_like") + "%"));
        }

        if (queryMap.get("transMcc") != null) {
            criteria = criteria.add(Expression.eq("transMcc", queryMap.get("transMcc")));
        }
        if (queryMap.get("transMcc_like") != null) {
            criteria = criteria.add(Expression.like("transMcc", "%" + queryMap.get("transMcc_like") + "%"));
        }

        if (queryMap.get("processLimit") != null) {
            criteria = criteria.add(Expression.eq("processLimit", java.sql.Date.valueOf((String) queryMap.get("processLimit"))));
        }
        if (queryMap.get("processLimit_min") != null) {
            criteria = criteria.add(Expression.ge("processLimit", java.sql.Date.valueOf((String) queryMap.get("processLimit_min"))));
        }
        if (queryMap.get("processLimit_max") != null) {
            criteria = criteria.add(Expression.le("processLimit", java.sql.Date.valueOf((String) queryMap.get("processLimit_max"))));
        }
        if (queryMap.get("warnLevel") != null) {
            criteria = criteria.add(Expression.eq("warnLevel", queryMap.get("warnLevel")));
        }
        if (queryMap.get("warnLevel_like") != null) {
            criteria = criteria.add(Expression.like("warnLevel", "%" + queryMap.get("warnLevel_like") + "%"));
        }

        if (queryMap.get("otherno") != null) {
            criteria = criteria.add(Expression.eq("otherno", queryMap.get("otherno")));
        }
        if (queryMap.get("otherno_like") != null) {
            criteria = criteria.add(Expression.like("otherno", "%" + queryMap.get("otherno_like") + "%"));
        }

        if (queryMap.get("mchntMcc") != null) {
            criteria = criteria.add(Expression.eq("mchntMcc", queryMap.get("mchntMcc")));
        }
        if (queryMap.get("mchntMcc_like") != null) {
            criteria = criteria.add(Expression.like("mchntMcc", "%" + queryMap.get("mchntMcc_like") + "%"));
        }

        if (queryMap.get("triggerContent") != null) {
            criteria = criteria.add(Expression.eq("triggerContent", queryMap.get("triggerContent")));
        }
        if (queryMap.get("triggerContent_like") != null) {
            criteria = criteria.add(Expression.like("triggerContent", "%" + queryMap.get("triggerContent_like") + "%"));
        }

        if (queryMap.get("riskContent") != null) {
            criteria = criteria.add(Expression.eq("riskContent", queryMap.get("riskContent")));
        }
        if (queryMap.get("riskContent_like") != null) {
            criteria = criteria.add(Expression.like("riskContent", "%" + queryMap.get("riskContent_like") + "%"));
        }

        if (queryMap.get("acquireInstName") != null) {
            criteria = criteria.add(Expression.eq("acquireInstName", queryMap.get("acquireInstName")));
        }
        if (queryMap.get("acquireInstName_like") != null) {
            criteria = criteria.add(Expression.like("acquireInstName", "%" + queryMap.get("acquireInstName_like") + "%"));
        }

        if (queryMap.get("status") != null) {
            criteria = criteria.add(Expression.eq("status", queryMap.get("status")));
        }
        if (queryMap.get("status_like") != null) {
            criteria = criteria.add(Expression.like("status", "%" + queryMap.get("status_like") + "%"));
        }

        if (queryMap.get("comments1") != null) {
            criteria = criteria.add(Expression.eq("comments1", queryMap.get("comments1")));
        }
        if (queryMap.get("comments1_like") != null) {
            criteria = criteria.add(Expression.like("comments1", "%" + queryMap.get("comments1_like") + "%"));
        }

        if (queryMap.get("comments2") != null) {
            criteria = criteria.add(Expression.eq("comments2", queryMap.get("comments2")));
        }
        if (queryMap.get("comments2_like") != null) {
            criteria = criteria.add(Expression.like("comments2", "%" + queryMap.get("comments2_like") + "%"));
        }

        if (queryMap.get("comments3") != null) {
            criteria = criteria.add(Expression.eq("comments3", queryMap.get("comments3")));
        }
        if (queryMap.get("comments3_like") != null) {
            criteria = criteria.add(Expression.like("comments3", "%" + queryMap.get("comments3_like") + "%"));
        }

        if (queryMap.get("comments4") != null) {
            criteria = criteria.add(Expression.eq("comments4", queryMap.get("comments4")));
        }
        if (queryMap.get("comments4_like") != null) {
            criteria = criteria.add(Expression.like("comments4", "%" + queryMap.get("comments4_like") + "%"));
        }

        if (queryMap.get("comments5") != null) {
            criteria = criteria.add(Expression.eq("comments5", queryMap.get("comments5")));
        }
        if (queryMap.get("comments5_like") != null) {
            criteria = criteria.add(Expression.like("comments5", "%" + queryMap.get("comments5_like") + "%"));
        }
        if (queryMap.get("comments6") != null) {
            criteria = criteria.add(Expression.eq("comments6", queryMap.get("comments6")));
        }
        if (queryMap.get("comments6_like") != null) {
            criteria = criteria.add(Expression.like("comments6", "%" + queryMap.get("comments6_like") + "%"));
        }
        if (queryMap.get("comments7") != null) {
            criteria = criteria.add(Expression.eq("comments7", queryMap.get("comments7")));
        }
        if (queryMap.get("comments7_like") != null) {
            criteria = criteria.add(Expression.like("comments7", "%" + queryMap.get("comments7_like") + "%"));
        }
        if (queryMap.get("comments8") != null) {
            criteria = criteria.add(Expression.eq("comments8", queryMap.get("comments8")));
        }
        if (queryMap.get("comments8_like") != null) {
            criteria = criteria.add(Expression.like("comments8", "%" + queryMap.get("comments8_like") + "%"));
        }        
        if (queryMap.get("relativeTransNum") != null) {
            criteria = criteria.add(Expression.eq("relativeTransNum", new Long((String) queryMap.get("relativeTransNum"))));
        }
        if (queryMap.get("relativeTransNum_min") != null) {
            criteria = criteria.add(Expression.ge("relativeTransNum", new Long((String) queryMap.get("relativeTransNum_min"))));
        }
        if (queryMap.get("relativeTransNum_max") != null) {
            criteria = criteria.add(Expression.le("relativeTransNum", new Long((String) queryMap.get("relativeTransNum_max"))));
        }
        if (queryMap.get("trace") != null) {
            criteria = criteria.add(Expression.eq("trace", new Boolean((String) queryMap.get("trace"))));
        }
        if (queryMap.get("beenUrgent") != null) {
            criteria = criteria.add(Expression.eq("beenUrgent", new Boolean((String) queryMap.get("beenUrgent"))));
        }
        if (queryMap.get("urgentCnt") != null) {
            criteria = criteria.add(Expression.eq("urgentCnt", new Integer((String) queryMap.get("urgentCnt"))));
        }
        if (queryMap.get("urgentCnt_min") != null) {
            criteria = criteria.add(Expression.ge("urgentCnt", new Integer((String) queryMap.get("urgentCnt_min"))));
        }
        if (queryMap.get("urgentCnt_max") != null) {
            criteria = criteria.add(Expression.le("urgentCnt", new Integer((String) queryMap.get("urgentCnt_max"))));
        }
        if (queryMap.get("submit2Inst") != null) {
            criteria = criteria.add(Expression.eq("submit2Inst", queryMap.get("submit2Inst")));
        }
        if (queryMap.get("submit2Inst_like") != null) {
            criteria = criteria.add(Expression.like("submit2Inst", "%" + queryMap.get("submit2Inst_like") + "%"));
        }

        if (queryMap.get("casefrom") != null) {
            criteria = criteria.add(Expression.eq("casefrom", queryMap.get("casefrom")));
        }
        if (queryMap.get("casefrom_like") != null) {
            criteria = criteria.add(Expression.like("casefrom", "%" + queryMap.get("casefrom_like") + "%"));
        }

        if (queryMap.get("mchntId") != null) {
            criteria = criteria.add(Expression.eq("mchntId", queryMap.get("mchntId")));
        }
        if (queryMap.get("mchntId_like") != null) {
            criteria = criteria.add(Expression.like("mchntId", "%" + queryMap.get("mchntId_like") + "%"));
        }
        if (queryMap.get("backCnt") != null) {
            criteria = criteria.add(Expression.eq("backCnt", new Integer((String) queryMap.get("backCnt"))));
        }
        if (queryMap.get("backCnt_min") != null) {
            criteria = criteria.add(Expression.ge("backCnt", new Integer((String) queryMap.get("backCnt_min"))));
        }
        if (queryMap.get("backCnt_max") != null) {
            criteria = criteria.add(Expression.le("backCnt", new Integer((String) queryMap.get("backCnt_max"))));
        }
        if (queryMap.get("createInst") != null) {
            criteria = criteria.add(Expression.eq("createInst", new Long((String) queryMap.get("createInst"))));
        }
        if (queryMap.get("createInst_min") != null) {
            criteria = criteria.add(Expression.ge("createInst", new Long((String) queryMap.get("createInst_min"))));
        }
        if (queryMap.get("createInst_max") != null) {
            criteria = criteria.add(Expression.le("createInst", new Long((String) queryMap.get("createInst_max"))));
        }
        if (queryMap.get("ruleGroupId") != null) {
            criteria = criteria.add(Expression.eq("ruleGroupId", new Long((String) queryMap.get("ruleGroupId"))));
        }
        if (queryMap.get("ruleGroupIdt_min") != null) {
            criteria = criteria.add(Expression.ge("ruleGroupId", new Long((String) queryMap.get("ruleGroupId_min"))));
        }
        if (queryMap.get("ruleGroupId_max") != null) {
            criteria = criteria.add(Expression.le("ruleGroupId", new Long((String) queryMap.get("ruleGroupId_max"))));
        }         
        if (queryMap.get("startRow") != null) {
			criteria = criteria.setFirstResult(new Integer((String) queryMap
					.get("startRow")));
		}
		if (queryMap.get("pageSize") != null) {
			criteria = criteria.setMaxResults(new Integer((String) queryMap
					.get("pageSize")));
		}
        //根据查询queryMap的键值，提供排序功能,_order="域名1 asc|desc,域名2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
    
    public int getTriskcaseListOfCount(Map queryMap) {
    	
    	Criteria criteria = getSession().createCriteria(Triskcase.class);
        //根据查询queryMap的键值，过滤Triskcase对象
        Object[] keyArray = queryMap.keySet().toArray();  //转换查询字段名keySet为数组
        //遍历该数组，去除对应查询字段值为空的键值
        for (int i = 0; i < keyArray.length; i++) {
            String value = (String) queryMap.get(keyArray[i]);
            if (value == null || value.trim().length() == 0) {
                queryMap.remove(keyArray[i]);
            }
        }
        
        int totalCount = 0;
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
			Query query = getSession()
					.createQuery(
							"select count(*) from cn.com.brilliance.begen.model.Triskcase as triskcase where "
									+ hsql);
			totalCount = ((Integer) query.uniqueResult()).intValue();
        } else {
	        if (queryMap.get("id") != null) {
	            criteria = criteria.add(Expression.eq("id", queryMap.get("id")));
	        }
	        if (queryMap.get("id_like") != null) {
	            criteria = criteria.add(Expression.like("id", "%" + queryMap.get("id_like") + "%"));
	        }
	
	        if (queryMap.get("caseno") != null) {
	            criteria = criteria.add(Expression.eq("caseno", queryMap.get("caseno")));
	        }
	        if (queryMap.get("caseno_like") != null) {
	            criteria = criteria.add(Expression.like("caseno", "%" + queryMap.get("caseno_like") + "%"));
	        }
	
	        if (queryMap.get("mchntCd") != null) {
	            criteria = criteria.add(Expression.eq("mchntCd", queryMap.get("mchntCd")));
	        }
	        if (queryMap.get("mchntCd_like") != null) {
	            criteria = criteria.add(Expression.like("mchntCd", "%" + queryMap.get("mchntCd_like") + "%"));
	        }
	
	        if (queryMap.get("beginDate") != null) {
	            criteria = criteria.add(Expression.eq("beginDate", java.sql.Date.valueOf((String) queryMap.get("beginDate"))));
	        }
	        if (queryMap.get("beginDate_min") != null) {
	            criteria = criteria.add(Expression.ge("beginDate", java.sql.Date.valueOf((String) queryMap.get("beginDate_min"))));
	        }
	        if (queryMap.get("beginDate_max") != null) {
	            criteria = criteria.add(Expression.le("beginDate", java.sql.Date.valueOf((String) queryMap.get("beginDate_max"))));
	        }
	        if (queryMap.get("endDate") != null) {
	            criteria = criteria.add(Expression.eq("endDate", java.sql.Date.valueOf((String) queryMap.get("endDate"))));
	        }
	        if (queryMap.get("endDate_min") != null) {
	            criteria = criteria.add(Expression.ge("endDate", java.sql.Date.valueOf((String) queryMap.get("endDate_min"))));
	        }
	        if (queryMap.get("endDate_max") != null) {
	            criteria = criteria.add(Expression.le("endDate", java.sql.Date.valueOf((String) queryMap.get("endDate_max"))));
	        }
	        if (queryMap.get("belongToInst") != null) {
	            criteria = criteria.add(Expression.eq("belongToInst", queryMap.get("belongToInst")));
	        }
	        if (queryMap.get("belongToInst_like") != null) {
	            criteria = criteria.add(Expression.like("belongToInst", "%" + queryMap.get("belongToInst_like") + "%"));
	        }
	
	        if (queryMap.get("relativeTransAmt") != null) {
	            criteria = criteria.add(Expression.eq("relativeTransAmt", new Double((String) queryMap.get("relativeTransAmt"))));
	        }
	        if (queryMap.get("relativeTransAmt_min") != null) {
	            criteria = criteria.add(Expression.ge("relativeTransAmt", new Double((String) queryMap.get("relativeTransAmt_min"))));
	        }
	        if (queryMap.get("relativeTransAmt_max") != null) {
	            criteria = criteria.add(Expression.le("relativeTransAmt", new Double((String) queryMap.get("relativeTransAmt_max"))));
	        }
	        if (queryMap.get("allTransAmt") != null) {
	            criteria = criteria.add(Expression.eq("allTransAmt", new Double((String) queryMap.get("allTransAmt"))));
	        }
	        if (queryMap.get("allTransAmt_min") != null) {
	            criteria = criteria.add(Expression.ge("allTransAmt", new Double((String) queryMap.get("allTransAmt_min"))));
	        }
	        if (queryMap.get("allTransAmt_max") != null) {
	            criteria = criteria.add(Expression.le("allTransAmt", new Double((String) queryMap.get("allTransAmt_max"))));
	        }
	        if (queryMap.get("allTransNum") != null) {
	            criteria = criteria.add(Expression.eq("allTransNum", new Long((String) queryMap.get("allTransNum"))));
	        }
	        if (queryMap.get("allTransNum_min") != null) {
	            criteria = criteria.add(Expression.ge("allTransNum", new Long((String) queryMap.get("allTransNum_min"))));
	        }
	        if (queryMap.get("allTransNum_max") != null) {
	            criteria = criteria.add(Expression.le("allTransNum", new Long((String) queryMap.get("allTransNum_max"))));
	        }
	        if (queryMap.get("createdate") != null) {
	            criteria = criteria.add(Expression.eq("createdate", java.sql.Date.valueOf((String) queryMap.get("createdate"))));
	        }
	        if (queryMap.get("createdate_min") != null) {
	            criteria = criteria.add(Expression.ge("createdate", java.sql.Date.valueOf((String) queryMap.get("createdate_min"))));
	        }
	        if (queryMap.get("createdate_max") != null) {
	            criteria = criteria.add(Expression.le("createdate", java.sql.Date.valueOf((String) queryMap.get("createdate_max"))));
	        }
	        if (queryMap.get("score") != null) {
	            criteria = criteria.add(Expression.eq("score", new Float((String) queryMap.get("score"))));
	        }
	        if (queryMap.get("score_min") != null) {
	            criteria = criteria.add(Expression.ge("score", new Float((String) queryMap.get("score_min"))));
	        }
	        if (queryMap.get("score_max") != null) {
	            criteria = criteria.add(Expression.le("score", new Float((String) queryMap.get("score_max"))));
	        }
	        if (queryMap.get("triggerRuleNum") != null) {
	            criteria = criteria.add(Expression.eq("triggerRuleNum", new Integer((String) queryMap.get("triggerRuleNum"))));
	        }
	        if (queryMap.get("triggerRuleNum_min") != null) {
	            criteria = criteria.add(Expression.ge("triggerRuleNum", new Integer((String) queryMap.get("triggerRuleNum_min"))));
	        }
	        if (queryMap.get("triggerRuleNum_max") != null) {
	            criteria = criteria.add(Expression.le("triggerRuleNum", new Integer((String) queryMap.get("triggerRuleNum_max"))));
	        }
	        if (queryMap.get("mchntName") != null) {
	            criteria = criteria.add(Expression.eq("mchntName", queryMap.get("mchntName")));
	        }
	        if (queryMap.get("mchntName_like") != null) {
	            criteria = criteria.add(Expression.like("mchntName", "%" + queryMap.get("mchntName_like") + "%"));
	        }
	
	        if (queryMap.get("transMcc") != null) {
	            criteria = criteria.add(Expression.eq("transMcc", queryMap.get("transMcc")));
	        }
	        if (queryMap.get("transMcc_like") != null) {
	            criteria = criteria.add(Expression.like("transMcc", "%" + queryMap.get("transMcc_like") + "%"));
	        }
	
	        if (queryMap.get("processLimit") != null) {
	            criteria = criteria.add(Expression.eq("processLimit", java.sql.Date.valueOf((String) queryMap.get("processLimit"))));
	        }
	        if (queryMap.get("processLimit_min") != null) {
	            criteria = criteria.add(Expression.ge("processLimit", java.sql.Date.valueOf((String) queryMap.get("processLimit_min"))));
	        }
	        if (queryMap.get("processLimit_max") != null) {
	            criteria = criteria.add(Expression.le("processLimit", java.sql.Date.valueOf((String) queryMap.get("processLimit_max"))));
	        }
	        if (queryMap.get("warnLevel") != null) {
	            criteria = criteria.add(Expression.eq("warnLevel", queryMap.get("warnLevel")));
	        }
	        if (queryMap.get("warnLevel_like") != null) {
	            criteria = criteria.add(Expression.like("warnLevel", "%" + queryMap.get("warnLevel_like") + "%"));
	        }
	
	        if (queryMap.get("otherno") != null) {
	            criteria = criteria.add(Expression.eq("otherno", queryMap.get("otherno")));
	        }
	        if (queryMap.get("otherno_like") != null) {
	            criteria = criteria.add(Expression.like("otherno", "%" + queryMap.get("otherno_like") + "%"));
	        }
	
	        if (queryMap.get("mchntMcc") != null) {
	            criteria = criteria.add(Expression.eq("mchntMcc", queryMap.get("mchntMcc")));
	        }
	        if (queryMap.get("mchntMcc_like") != null) {
	            criteria = criteria.add(Expression.like("mchntMcc", "%" + queryMap.get("mchntMcc_like") + "%"));
	        }
	
	        if (queryMap.get("triggerContent") != null) {
	            criteria = criteria.add(Expression.eq("triggerContent", queryMap.get("triggerContent")));
	        }
	        if (queryMap.get("triggerContent_like") != null) {
	            criteria = criteria.add(Expression.like("triggerContent", "%" + queryMap.get("triggerContent_like") + "%"));
	        }
	
	        if (queryMap.get("riskContent") != null) {
	            criteria = criteria.add(Expression.eq("riskContent", queryMap.get("riskContent")));
	        }
	        if (queryMap.get("riskContent_like") != null) {
	            criteria = criteria.add(Expression.like("riskContent", "%" + queryMap.get("riskContent_like") + "%"));
	        }
	
	        if (queryMap.get("acquireInstName") != null) {
	            criteria = criteria.add(Expression.eq("acquireInstName", queryMap.get("acquireInstName")));
	        }
	        if (queryMap.get("acquireInstName_like") != null) {
	            criteria = criteria.add(Expression.like("acquireInstName", "%" + queryMap.get("acquireInstName_like") + "%"));
	        }
	
	        if (queryMap.get("status") != null) {
	            criteria = criteria.add(Expression.eq("status", queryMap.get("status")));
	        }
	        if (queryMap.get("status_like") != null) {
	            criteria = criteria.add(Expression.like("status", "%" + queryMap.get("status_like") + "%"));
	        }
	
	        if (queryMap.get("comments1") != null) {
	            criteria = criteria.add(Expression.eq("comments1", queryMap.get("comments1")));
	        }
	        if (queryMap.get("comments1_like") != null) {
	            criteria = criteria.add(Expression.like("comments1", "%" + queryMap.get("comments1_like") + "%"));
	        }
	
	        if (queryMap.get("comments2") != null) {
	            criteria = criteria.add(Expression.eq("comments2", queryMap.get("comments2")));
	        }
	        if (queryMap.get("comments2_like") != null) {
	            criteria = criteria.add(Expression.like("comments2", "%" + queryMap.get("comments2_like") + "%"));
	        }
	
	        if (queryMap.get("comments3") != null) {
	            criteria = criteria.add(Expression.eq("comments3", queryMap.get("comments3")));
	        }
	        if (queryMap.get("comments3_like") != null) {
	            criteria = criteria.add(Expression.like("comments3", "%" + queryMap.get("comments3_like") + "%"));
	        }
	
	        if (queryMap.get("comments4") != null) {
	            criteria = criteria.add(Expression.eq("comments4", queryMap.get("comments4")));
	        }
	        if (queryMap.get("comments4_like") != null) {
	            criteria = criteria.add(Expression.like("comments4", "%" + queryMap.get("comments4_like") + "%"));
	        }
	
	        if (queryMap.get("comments5") != null) {
	            criteria = criteria.add(Expression.eq("comments5", queryMap.get("comments5")));
	        }
	        if (queryMap.get("comments5_like") != null) {
	            criteria = criteria.add(Expression.like("comments5", "%" + queryMap.get("comments5_like") + "%"));
	        }
	        if (queryMap.get("comments6") != null) {
	            criteria = criteria.add(Expression.eq("comments6", queryMap.get("comments6")));
	        }
	        if (queryMap.get("comments6_like") != null) {
	            criteria = criteria.add(Expression.like("comments6", "%" + queryMap.get("comments6_like") + "%"));
	        }	
	        if (queryMap.get("comments7") != null) {
	            criteria = criteria.add(Expression.eq("comments7", queryMap.get("comments7")));
	        }
	        if (queryMap.get("comments7_like") != null) {
	            criteria = criteria.add(Expression.like("comments7", "%" + queryMap.get("comments7_like") + "%"));
	        }
	        if (queryMap.get("comments8") != null) {
	            criteria = criteria.add(Expression.eq("comments8", queryMap.get("comments8")));
	        }
	        if (queryMap.get("comments8_like") != null) {
	            criteria = criteria.add(Expression.like("comments8", "%" + queryMap.get("comments8_like") + "%"));
	        }   	        
	        if (queryMap.get("relativeTransNum") != null) {
	            criteria = criteria.add(Expression.eq("relativeTransNum", new Long((String) queryMap.get("relativeTransNum"))));
	        }
	        if (queryMap.get("relativeTransNum_min") != null) {
	            criteria = criteria.add(Expression.ge("relativeTransNum", new Long((String) queryMap.get("relativeTransNum_min"))));
	        }
	        if (queryMap.get("relativeTransNum_max") != null) {
	            criteria = criteria.add(Expression.le("relativeTransNum", new Long((String) queryMap.get("relativeTransNum_max"))));
	        }
	        if (queryMap.get("trace") != null) {
	            criteria = criteria.add(Expression.eq("trace", new Boolean((String) queryMap.get("trace"))));
	        }
	        if (queryMap.get("beenUrgent") != null) {
	            criteria = criteria.add(Expression.eq("beenUrgent", new Boolean((String) queryMap.get("beenUrgent"))));
	        }
	        if (queryMap.get("urgentCnt") != null) {
	            criteria = criteria.add(Expression.eq("urgentCnt", new Integer((String) queryMap.get("urgentCnt"))));
	        }
	        if (queryMap.get("urgentCnt_min") != null) {
	            criteria = criteria.add(Expression.ge("urgentCnt", new Integer((String) queryMap.get("urgentCnt_min"))));
	        }
	        if (queryMap.get("urgentCnt_max") != null) {
	            criteria = criteria.add(Expression.le("urgentCnt", new Integer((String) queryMap.get("urgentCnt_max"))));
	        }
	        if (queryMap.get("submit2Inst") != null) {
	            criteria = criteria.add(Expression.eq("submit2Inst", queryMap.get("submit2Inst")));
	        }
	        if (queryMap.get("submit2Inst_like") != null) {
	            criteria = criteria.add(Expression.like("submit2Inst", "%" + queryMap.get("submit2Inst_like") + "%"));
	        }
	
	        if (queryMap.get("casefrom") != null) {
	            criteria = criteria.add(Expression.eq("casefrom", queryMap.get("casefrom")));
	        }
	        if (queryMap.get("casefrom_like") != null) {
	            criteria = criteria.add(Expression.like("casefrom", "%" + queryMap.get("casefrom_like") + "%"));
	        }
	
	        if (queryMap.get("mchntId") != null) {
	            criteria = criteria.add(Expression.eq("mchntId", queryMap.get("mchntId")));
	        }
	        if (queryMap.get("mchntId_like") != null) {
	            criteria = criteria.add(Expression.like("mchntId", "%" + queryMap.get("mchntId_like") + "%"));
	        }
	        if (queryMap.get("backCnt") != null) {
	            criteria = criteria.add(Expression.eq("backCnt", new Integer((String) queryMap.get("backCnt"))));
	        }
	        if (queryMap.get("backCnt_min") != null) {
	            criteria = criteria.add(Expression.ge("backCnt", new Integer((String) queryMap.get("backCnt_min"))));
	        }
	        if (queryMap.get("backCnt_max") != null) {
	            criteria = criteria.add(Expression.le("backCnt", new Integer((String) queryMap.get("backCnt_max"))));
	        }
	        if (queryMap.get("createInst") != null) {
	            criteria = criteria.add(Expression.eq("createInst", new Long((String) queryMap.get("createInst"))));
	        }
	        if (queryMap.get("createInst_min") != null) {
	            criteria = criteria.add(Expression.ge("createInst", new Long((String) queryMap.get("createInst_min"))));
	        }
	        if (queryMap.get("createInst_max") != null) {
	            criteria = criteria.add(Expression.le("createInst", new Long((String) queryMap.get("createInst_max"))));
	        }        
	        if (queryMap.get("ruleGroupId") != null) {
	            criteria = criteria.add(Expression.eq("ruleGroupId", new Long((String) queryMap.get("ruleGroupId"))));
	        }
	        if (queryMap.get("ruleGroupIdt_min") != null) {
	            criteria = criteria.add(Expression.ge("ruleGroupId", new Long((String) queryMap.get("ruleGroupId_min"))));
	        }
	        if (queryMap.get("ruleGroupId_max") != null) {
	            criteria = criteria.add(Expression.le("ruleGroupId", new Long((String) queryMap.get("ruleGroupId_max"))));
	        } 	        
			totalCount = ((Integer) criteria.setProjection(
					Projections.rowCount()).uniqueResult()).intValue();
        }

		return totalCount;	
    }
    
}
