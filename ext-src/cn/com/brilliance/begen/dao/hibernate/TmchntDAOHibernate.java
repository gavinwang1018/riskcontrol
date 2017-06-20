package cn.com.brilliance.begen.dao.hibernate;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.dao.DataRetrievalFailureException;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Projections;

import cn.com.brilliance.begen.dao.TmchntDAO;
import cn.com.brilliance.begen.model.Tmchnt;
import cn.com.brilliance.begen.model.TmchntApp;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * TmchntDAO接口具体实现类.
 * @author Administrator.
 */

public class TmchntDAOHibernate extends BeGenHibernateDaoSupport implements TmchntDAO {    

    /**
     *  根据主键获得Tmchnt对象.
     *  @param pkey Tmchnt主键
     *  @return Tmchnt.
     */
    public Tmchnt getTmchnt(java.lang.String pkey) {
        Tmchnt tmchnt = (Tmchnt) getHibernateTemplate().get(Tmchnt.class, pkey);
        if (tmchnt == null) {
            return tmchnt;
        }else{
        	Hibernate.initialize(tmchnt.getTmchntAppGroup());
        }
        
        
        return tmchnt;

    }

    /**
     *  存储Tmchnt对象.
     *  @param  tmchnt Tmchnt对象
     *  @return Tmchnt.
     */
    public Tmchnt saveTmchnt(Tmchnt tmchnt) {
        return (Tmchnt) getHibernateTemplate().merge(tmchnt);
    }

    /**
     *  删除Tmchnt对象.
     *  @param pkey Tmchnt主键.
     */
    public void removeTmchnt(java.lang.String pkey) {
        Tmchnt tmchnt = getTmchnt(pkey);
        getHibernateTemplate().delete(tmchnt);
    }

    /**
     *  获取Tmchnt对象列表.
     *  @param  tmchnt Tmchnt对象
     *  @return List.
     */
    public List getTmchntList(Tmchnt tmchnt) {
        Criteria criteria = getSession().createCriteria(Tmchnt.class).add(
                Example.create(tmchnt));
        if (tmchnt.getId() != null) {
            criteria.add(Expression.eq("id", tmchnt.getId()));
        }
        return criteria.list();
    }

    /**
     *  根据查询条件获取Tmchnt对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getTmchntListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.Tmchnt where " + hsql);
            List result = query.list();
            for (Iterator ti = result.iterator();ti.hasNext();){
            	Tmchnt tmchnt = (Tmchnt)ti.next();
            	Hibernate.initialize(tmchnt.getTmchntApps());
            	Hibernate.initialize(tmchnt.getTmchntAppGroup());
            }
            return result;
        }

        Criteria criteria = getSession().createCriteria(Tmchnt.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取Tmchnt对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getTmchntListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.Tmchnt where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(Tmchnt.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤Tmchnt对象
        Object[] keyArray = queryMap.keySet().toArray();  //转换查询字段名keySet为数组
        //遍历该数组，去除对应查询字段值为空的键值
        for (int i = 0; i < keyArray.length; i++) {
            String value = (String) queryMap.get(keyArray[i]);
            if (value == null || value.trim().length() == 0) {
                queryMap.remove(keyArray[i]);
            }
        }

        if (queryMap.get("merchantcategory") != null) {
            criteria = criteria.add(Expression.eq("merchantcategory", queryMap.get("merchantcategory")));
        }
        if (queryMap.get("merchantcategory_like") != null) {
            criteria = criteria.add(Expression.like("merchantcategory", "%" + queryMap.get("merchantcategory_like") + "%"));
        }

        if (queryMap.get("id") != null) {
            criteria = criteria.add(Expression.eq("id", queryMap.get("id")));
        }
        if (queryMap.get("id_like") != null) {
            criteria = criteria.add(Expression.like("id", "%" + queryMap.get("id_like") + "%"));
        }

        if (queryMap.get("foreigncard") != null) {
            criteria = criteria.add(Expression.eq("foreigncard", queryMap.get("foreigncard")));
        }
        if (queryMap.get("foreigncard_like") != null) {
            criteria = criteria.add(Expression.like("foreigncard", "%" + queryMap.get("foreigncard_like") + "%"));
        }

        if (queryMap.get("merchantnature") != null) {
            criteria = criteria.add(Expression.eq("merchantnature", queryMap.get("merchantnature")));
        }
        if (queryMap.get("merchantnature_like") != null) {
            criteria = criteria.add(Expression.like("merchantnature", "%" + queryMap.get("merchantnature_like") + "%"));
        }

        if (queryMap.get("name") != null) {
            criteria = criteria.add(Expression.eq("name", queryMap.get("name")));
        }
        if (queryMap.get("name_like") != null) {
            criteria = criteria.add(Expression.like("name", "%" + queryMap.get("name_like") + "%"));
        }

        if (queryMap.get("briefname") != null) {
            criteria = criteria.add(Expression.eq("briefname", queryMap.get("briefname")));
        }
        if (queryMap.get("briefname_like") != null) {
            criteria = criteria.add(Expression.like("briefname", "%" + queryMap.get("briefname_like") + "%"));
        }

        if (queryMap.get("engname") != null) {
            criteria = criteria.add(Expression.eq("engname", queryMap.get("engname")));
        }
        if (queryMap.get("engname_like") != null) {
            criteria = criteria.add(Expression.like("engname", "%" + queryMap.get("engname_like") + "%"));
        }

        if (queryMap.get("engbriefname") != null) {
            criteria = criteria.add(Expression.eq("engbriefname", queryMap.get("engbriefname")));
        }
        if (queryMap.get("engbriefname_like") != null) {
            criteria = criteria.add(Expression.like("engbriefname", "%" + queryMap.get("engbriefname_like") + "%"));
        }

        if (queryMap.get("contractant") != null) {
            criteria = criteria.add(Expression.eq("contractant", queryMap.get("contractant")));
        }
        if (queryMap.get("contractant_like") != null) {
            criteria = criteria.add(Expression.like("contractant", "%" + queryMap.get("contractant_like") + "%"));
        }

        if (queryMap.get("licenseno") != null) {
            criteria = criteria.add(Expression.eq("licenseno", queryMap.get("licenseno")));
        }
        if (queryMap.get("licenseno_like") != null) {
            criteria = criteria.add(Expression.like("licenseno", "%" + queryMap.get("licenseno_like") + "%"));
        }

        if (queryMap.get("registeredcapital") != null) {
            criteria = criteria.add(Expression.eq("registeredcapital", queryMap.get("registeredcapital")));
        }
        if (queryMap.get("registeredcapital_like") != null) {
            criteria = criteria.add(Expression.like("registeredcapital", "%" + queryMap.get("registeredcapital_like") + "%"));
        }

        if (queryMap.get("taxno") != null) {
            criteria = criteria.add(Expression.eq("taxno", queryMap.get("taxno")));
        }
        if (queryMap.get("taxno_like") != null) {
            criteria = criteria.add(Expression.like("taxno", "%" + queryMap.get("taxno_like") + "%"));
        }

        if (queryMap.get("merchantno") != null) {
            criteria = criteria.add(Expression.eq("merchantno", queryMap.get("merchantno")));
        }
        if (queryMap.get("merchantno_like") != null) {
            criteria = criteria.add(Expression.like("merchantno", "%" + queryMap.get("merchantno_like") + "%"));
        }

        if (queryMap.get("installdate") != null) {
            criteria = criteria.add(Expression.eq("installdate", java.sql.Date.valueOf((String) queryMap.get("installdate"))));
        }
        if (queryMap.get("installdate_min") != null) {
            criteria = criteria.add(Expression.ge("installdate", java.sql.Date.valueOf((String) queryMap.get("installdate_min"))));
        }
        if (queryMap.get("installdate_max") != null) {
            criteria = criteria.add(Expression.le("installdate", java.sql.Date.valueOf((String) queryMap.get("installdate_max"))));
        }
        if (queryMap.get("withdrawinputdate") != null) {
            criteria = criteria.add(Expression.eq("withdrawinputdate", java.sql.Date.valueOf((String) queryMap.get("withdrawinputdate"))));
        }
        if (queryMap.get("withdrawinputdate_min") != null) {
            criteria = criteria.add(Expression.ge("withdrawinputdate", java.sql.Date.valueOf((String) queryMap.get("withdrawinputdate_min"))));
        }
        if (queryMap.get("withdrawinputdate_max") != null) {
            criteria = criteria.add(Expression.le("withdrawinputdate", java.sql.Date.valueOf((String) queryMap.get("withdrawinputdate_max"))));
        }
        if (queryMap.get("subinst") != null) {
            criteria = criteria.add(Expression.eq("subinst", queryMap.get("subinst")));
        }
        if (queryMap.get("subinst_like") != null) {
            criteria = criteria.add(Expression.like("subinst", "%" + queryMap.get("subinst_like") + "%"));
        }

        if (queryMap.get("developingmethod") != null) {
            criteria = criteria.add(Expression.eq("developingmethod", queryMap.get("developingmethod")));
        }
        if (queryMap.get("developingmethod_like") != null) {
            criteria = criteria.add(Expression.like("developingmethod", "%" + queryMap.get("developingmethod_like") + "%"));
        }

        if (queryMap.get("multiacquirer") != null) {
            criteria = criteria.add(Expression.eq("multiacquirer", new Boolean((String) queryMap.get("multiacquirer"))));
        }
        if (queryMap.get("businessacceptmethod") != null) {
            criteria = criteria.add(Expression.eq("businessacceptmethod", queryMap.get("businessacceptmethod")));
        }
        if (queryMap.get("businessacceptmethod_like") != null) {
            criteria = criteria.add(Expression.like("businessacceptmethod", "%" + queryMap.get("businessacceptmethod_like") + "%"));
        }

        if (queryMap.get("state") != null) {
            criteria = criteria.add(Expression.eq("state", queryMap.get("state")));
        }
        if (queryMap.get("state_like") != null) {
            criteria = criteria.add(Expression.like("state", "%" + queryMap.get("state_like") + "%"));
        }

        if (queryMap.get("servicerate") != null) {
            criteria = criteria.add(Expression.eq("servicerate", queryMap.get("servicerate")));
        }
        if (queryMap.get("servicerate_like") != null) {
            criteria = criteria.add(Expression.like("servicerate", "%" + queryMap.get("servicerate_like") + "%"));
        }

        if (queryMap.get("legalman") != null) {
            criteria = criteria.add(Expression.eq("legalman", queryMap.get("legalman")));
        }
        if (queryMap.get("legalman_like") != null) {
            criteria = criteria.add(Expression.like("legalman", "%" + queryMap.get("legalman_like") + "%"));
        }

        if (queryMap.get("idcardtype") != null) {
            criteria = criteria.add(Expression.eq("idcardtype", queryMap.get("idcardtype")));
        }
        if (queryMap.get("idcardtype_like") != null) {
            criteria = criteria.add(Expression.like("idcardtype", "%" + queryMap.get("idcardtype_like") + "%"));
        }

        if (queryMap.get("idcardno") != null) {
            criteria = criteria.add(Expression.eq("idcardno", queryMap.get("idcardno")));
        }
        if (queryMap.get("idcardno_like") != null) {
            criteria = criteria.add(Expression.like("idcardno", "%" + queryMap.get("idcardno_like") + "%"));
        }

        if (queryMap.get("licensedeadline") != null) {
            criteria = criteria.add(Expression.eq("licensedeadline", java.sql.Date.valueOf((String) queryMap.get("licensedeadline"))));
        }
        if (queryMap.get("licensedeadline_min") != null) {
            criteria = criteria.add(Expression.ge("licensedeadline", java.sql.Date.valueOf((String) queryMap.get("licensedeadline_min"))));
        }
        if (queryMap.get("licensedeadline_max") != null) {
            criteria = criteria.add(Expression.le("licensedeadline", java.sql.Date.valueOf((String) queryMap.get("licensedeadline_max"))));
        }
        if (queryMap.get("registerAddress") != null) {
            criteria = criteria.add(Expression.eq("registerAddress", queryMap.get("registerAddress")));
        }
        if (queryMap.get("registerAddress_like") != null) {
            criteria = criteria.add(Expression.like("registerAddress", "%" + queryMap.get("registerAddress_like") + "%"));
        }

        if (queryMap.get("registerZipcode") != null) {
            criteria = criteria.add(Expression.eq("registerZipcode", queryMap.get("registerZipcode")));
        }
        if (queryMap.get("registerZipcode_like") != null) {
            criteria = criteria.add(Expression.like("registerZipcode", "%" + queryMap.get("registerZipcode_like") + "%"));
        }

        if (queryMap.get("officeAddress") != null) {
            criteria = criteria.add(Expression.eq("officeAddress", queryMap.get("officeAddress")));
        }
        if (queryMap.get("officeAddress_like") != null) {
            criteria = criteria.add(Expression.like("officeAddress", "%" + queryMap.get("officeAddress_like") + "%"));
        }

        if (queryMap.get("officeZipcode") != null) {
            criteria = criteria.add(Expression.eq("officeZipcode", queryMap.get("officeZipcode")));
        }
        if (queryMap.get("officeZipcode_like") != null) {
            criteria = criteria.add(Expression.like("officeZipcode", "%" + queryMap.get("officeZipcode_like") + "%"));
        }

        if (queryMap.get("contactperson") != null) {
            criteria = criteria.add(Expression.eq("contactperson", queryMap.get("contactperson")));
        }
        if (queryMap.get("contactperson_like") != null) {
            criteria = criteria.add(Expression.like("contactperson", "%" + queryMap.get("contactperson_like") + "%"));
        }

        if (queryMap.get("dept") != null) {
            criteria = criteria.add(Expression.eq("dept", queryMap.get("dept")));
        }
        if (queryMap.get("dept_like") != null) {
            criteria = criteria.add(Expression.like("dept", "%" + queryMap.get("dept_like") + "%"));
        }

        if (queryMap.get("tel") != null) {
            criteria = criteria.add(Expression.eq("tel", queryMap.get("tel")));
        }
        if (queryMap.get("tel_like") != null) {
            criteria = criteria.add(Expression.like("tel", "%" + queryMap.get("tel_like") + "%"));
        }

        if (queryMap.get("mobtel") != null) {
            criteria = criteria.add(Expression.eq("mobtel", queryMap.get("mobtel")));
        }
        if (queryMap.get("mobtel_like") != null) {
            criteria = criteria.add(Expression.like("mobtel", "%" + queryMap.get("mobtel_like") + "%"));
        }

        if (queryMap.get("fax") != null) {
            criteria = criteria.add(Expression.eq("fax", queryMap.get("fax")));
        }
        if (queryMap.get("fax_like") != null) {
            criteria = criteria.add(Expression.like("fax", "%" + queryMap.get("fax_like") + "%"));
        }

        if (queryMap.get("email") != null) {
            criteria = criteria.add(Expression.eq("email", queryMap.get("email")));
        }
        if (queryMap.get("email_like") != null) {
            criteria = criteria.add(Expression.like("email", "%" + queryMap.get("email_like") + "%"));
        }

        if (queryMap.get("financeperson") != null) {
            criteria = criteria.add(Expression.eq("financeperson", queryMap.get("financeperson")));
        }
        if (queryMap.get("financeperson_like") != null) {
            criteria = criteria.add(Expression.like("financeperson", "%" + queryMap.get("financeperson_like") + "%"));
        }

        if (queryMap.get("financetel") != null) {
            criteria = criteria.add(Expression.eq("financetel", queryMap.get("financetel")));
        }
        if (queryMap.get("financetel_like") != null) {
            criteria = criteria.add(Expression.like("financetel", "%" + queryMap.get("financetel_like") + "%"));
        }

        if (queryMap.get("financemotel") != null) {
            criteria = criteria.add(Expression.eq("financemotel", queryMap.get("financemotel")));
        }
        if (queryMap.get("financemotel_like") != null) {
            criteria = criteria.add(Expression.like("financemotel", "%" + queryMap.get("financemotel_like") + "%"));
        }

        if (queryMap.get("financefax") != null) {
            criteria = criteria.add(Expression.eq("financefax", queryMap.get("financefax")));
        }
        if (queryMap.get("financefax_like") != null) {
            criteria = criteria.add(Expression.like("financefax", "%" + queryMap.get("financefax_like") + "%"));
        }

        if (queryMap.get("financeemail") != null) {
            criteria = criteria.add(Expression.eq("financeemail", queryMap.get("financeemail")));
        }
        if (queryMap.get("financeemail_like") != null) {
            criteria = criteria.add(Expression.like("financeemail", "%" + queryMap.get("financeemail_like") + "%"));
        }

        if (queryMap.get("mailperson") != null) {
            criteria = criteria.add(Expression.eq("mailperson", queryMap.get("mailperson")));
        }
        if (queryMap.get("mailperson_like") != null) {
            criteria = criteria.add(Expression.like("mailperson", "%" + queryMap.get("mailperson_like") + "%"));
        }

        if (queryMap.get("mailtel") != null) {
            criteria = criteria.add(Expression.eq("mailtel", queryMap.get("mailtel")));
        }
        if (queryMap.get("mailtel_like") != null) {
            criteria = criteria.add(Expression.like("mailtel", "%" + queryMap.get("mailtel_like") + "%"));
        }

        if (queryMap.get("mailmobtel") != null) {
            criteria = criteria.add(Expression.eq("mailmobtel", queryMap.get("mailmobtel")));
        }
        if (queryMap.get("mailmobtel_like") != null) {
            criteria = criteria.add(Expression.like("mailmobtel", "%" + queryMap.get("mailmobtel_like") + "%"));
        }

        if (queryMap.get("chargereduingtime") != null) {
            criteria = criteria.add(Expression.eq("chargereduingtime", new Integer((String) queryMap.get("chargereduingtime"))));
        }
        if (queryMap.get("chargereduingtime_min") != null) {
            criteria = criteria.add(Expression.ge("chargereduingtime", new Integer((String) queryMap.get("chargereduingtime_min"))));
        }
        if (queryMap.get("chargereduingtime_max") != null) {
            criteria = criteria.add(Expression.le("chargereduingtime", new Integer((String) queryMap.get("chargereduingtime_max"))));
        }
        if (queryMap.get("guaranteemethod") != null) {
            criteria = criteria.add(Expression.eq("guaranteemethod", queryMap.get("guaranteemethod")));
        }
        if (queryMap.get("guaranteemethod_like") != null) {
            criteria = criteria.add(Expression.like("guaranteemethod", "%" + queryMap.get("guaranteemethod_like") + "%"));
        }

        if (queryMap.get("guaranteemethoddesc") != null) {
            criteria = criteria.add(Expression.eq("guaranteemethoddesc", queryMap.get("guaranteemethoddesc")));
        }
        if (queryMap.get("guaranteemethoddesc_like") != null) {
            criteria = criteria.add(Expression.like("guaranteemethoddesc", "%" + queryMap.get("guaranteemethoddesc_like") + "%"));
        }

        if (queryMap.get("approvedesc") != null) {
            criteria = criteria.add(Expression.eq("approvedesc", queryMap.get("approvedesc")));
        }
        if (queryMap.get("approvedesc_like") != null) {
            criteria = criteria.add(Expression.like("approvedesc", "%" + queryMap.get("approvedesc_like") + "%"));
        }

        if (queryMap.get("approveddate") != null) {
            criteria = criteria.add(Expression.eq("approveddate", java.sql.Date.valueOf((String) queryMap.get("approveddate"))));
        }
        if (queryMap.get("approveddate_min") != null) {
            criteria = criteria.add(Expression.ge("approveddate", java.sql.Date.valueOf((String) queryMap.get("approveddate_min"))));
        }
        if (queryMap.get("approveddate_max") != null) {
            criteria = criteria.add(Expression.le("approveddate", java.sql.Date.valueOf((String) queryMap.get("approveddate_max"))));
        }
        if (queryMap.get("addingcategory") != null) {
            criteria = criteria.add(Expression.eq("addingcategory", queryMap.get("addingcategory")));
        }
        if (queryMap.get("addingcategory_like") != null) {
            criteria = criteria.add(Expression.like("addingcategory", "%" + queryMap.get("addingcategory_like") + "%"));
        }

        if (queryMap.get("logoutinputdate") != null) {
            criteria = criteria.add(Expression.eq("logoutinputdate", java.sql.Date.valueOf((String) queryMap.get("logoutinputdate"))));
        }
        if (queryMap.get("logoutinputdate_min") != null) {
            criteria = criteria.add(Expression.ge("logoutinputdate", java.sql.Date.valueOf((String) queryMap.get("logoutinputdate_min"))));
        }
        if (queryMap.get("logoutinputdate_max") != null) {
            criteria = criteria.add(Expression.le("logoutinputdate", java.sql.Date.valueOf((String) queryMap.get("logoutinputdate_max"))));
        }
        if (queryMap.get("withdrawcategory") != null) {
            criteria = criteria.add(Expression.eq("withdrawcategory", queryMap.get("withdrawcategory")));
        }
        if (queryMap.get("withdrawcategory_like") != null) {
            criteria = criteria.add(Expression.like("withdrawcategory", "%" + queryMap.get("withdrawcategory_like") + "%"));
        }

        if (queryMap.get("withdrawoperator") != null) {
            criteria = criteria.add(Expression.eq("withdrawoperator", queryMap.get("withdrawoperator")));
        }
        if (queryMap.get("withdrawoperator_like") != null) {
            criteria = criteria.add(Expression.like("withdrawoperator", "%" + queryMap.get("withdrawoperator_like") + "%"));
        }

        if (queryMap.get("laststatechangedate") != null) {
            criteria = criteria.add(Expression.eq("laststatechangedate", java.sql.Date.valueOf((String) queryMap.get("laststatechangedate"))));
        }
        if (queryMap.get("laststatechangedate_min") != null) {
            criteria = criteria.add(Expression.ge("laststatechangedate", java.sql.Date.valueOf((String) queryMap.get("laststatechangedate_min"))));
        }
        if (queryMap.get("laststatechangedate_max") != null) {
            criteria = criteria.add(Expression.le("laststatechangedate", java.sql.Date.valueOf((String) queryMap.get("laststatechangedate_max"))));
        }
        if (queryMap.get("laststatechangeoperator") != null) {
            criteria = criteria.add(Expression.eq("laststatechangeoperator", queryMap.get("laststatechangeoperator")));
        }
        if (queryMap.get("laststatechangeoperator_like") != null) {
            criteria = criteria.add(Expression.like("laststatechangeoperator", "%" + queryMap.get("laststatechangeoperator_like") + "%"));
        }

        if (queryMap.get("province") != null) {
            criteria = criteria.add(Expression.eq("province", queryMap.get("province")));
        }
        if (queryMap.get("province_like") != null) {
            criteria = criteria.add(Expression.like("province", "%" + queryMap.get("province_like") + "%"));
        }

        if (queryMap.get("city") != null) {
            criteria = criteria.add(Expression.eq("city", queryMap.get("city")));
        }
        if (queryMap.get("city_like") != null) {
            criteria = criteria.add(Expression.like("city", "%" + queryMap.get("city_like") + "%"));
        }

        if (queryMap.get("county") != null) {
            criteria = criteria.add(Expression.eq("county", queryMap.get("county")));
        }
        if (queryMap.get("county_like") != null) {
            criteria = criteria.add(Expression.like("county", "%" + queryMap.get("county_like") + "%"));
        }

        if (queryMap.get("refusereason") != null) {
            criteria = criteria.add(Expression.eq("refusereason", queryMap.get("refusereason")));
        }
        if (queryMap.get("refusereason_like") != null) {
            criteria = criteria.add(Expression.like("refusereason", "%" + queryMap.get("refusereason_like") + "%"));
        }

        if (queryMap.get("remark") != null) {
            criteria = criteria.add(Expression.eq("remark", queryMap.get("remark")));
        }
        if (queryMap.get("remark_like") != null) {
            criteria = criteria.add(Expression.like("remark", "%" + queryMap.get("remark_like") + "%"));
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
        List result = criteria.list();
    
        return result;
    }
    
    /**
     * 根据商户id取商户主应用结算帐号
     */
    public String getTmchntAccountNo(String id){
    	TmchntApp tmchntApp = new TmchntApp();
    	 String hsql = " mchnt_id="+"'"+id+"'"+" and main=1";
         
             Query query = getSession().createQuery("from cn.com.brilliance.begen.model.TmchntApp where " + hsql);
             tmchntApp = (TmchntApp)query.uniqueResult();
             if (tmchntApp!=null){
            	 return tmchntApp.getSettlementaccntno();
             }else{
            	 return "";
             }
             
    }
    
    
    public Tmchnt getTmchntByName(String merNo,String subinst,String netWorkTransfer){
    	Tmchnt tmchnt = new Tmchnt();
    	String hsql = " merchantno=" +"'"+merNo +"'"+ " and b.organizeBm=" +"'" +subinst + "'"+ " and networktransferinst=" +"'" +netWorkTransfer + "'";
        
        Query query = getSession().createQuery("select t from cn.com.brilliance.begen.model.Tmchnt t inner join t.belongToSubinst b where " + hsql);
        tmchnt  = (Tmchnt) query.uniqueResult();
        return tmchnt ;
    
    }
    

    
    public int getMerListOfQueryNumber(Map queryFields){
    	String searchString = "";
    	String searchStr = getSearchString(queryFields,searchString);

    	if ((queryFields.get("big_mcc") != null)&&(!"".equals(queryFields.get("big_mcc")))) {
    		if (!"".equals(searchStr)){
    			searchStr = searchStr + " and ";
    		}
            searchStr = searchStr + "m.bigmccCode="+ "'"+queryFields.get("big_mcc")+"'";
        }
    	
    	if (!"".equals(searchStr)){
    		searchStr = "where " + searchStr;
    	}
    
    	Query query = getSession().createQuery("select count(*) from cn.com.brilliance.begen.model.Tmchnt a inner join a.merchantcategoryOfTmcc m "+ searchStr );
    	Object o = query.uniqueResult();
    	
		if (o != null)
			return ((Integer) o).intValue();
		else
			return 0;
		 
    }
    
    
    
    public String getSearchString(Map queryMap,String searchStr){
    	
    	if ((queryMap.get("merchantcategory") != null)&&(!"".equals(queryMap.get("merchantcategory")))) {
            searchStr = searchStr + "merchantcategory="+ "'"+queryMap.get("merchantcategory")+"'";
        }

    
        if ((queryMap.get("subinst") != null)&&(!"".equals(queryMap.get("subinst")))) {
        	if (!"".equals(searchStr)){
        		searchStr = searchStr + " and ";
        	}
        	
            searchStr = searchStr +"subinst=" +"'"+queryMap.get("subinst")+"'";
        }
        
    
        if ((queryMap.get("merchantno_like") != null)&&(!"".equals(queryMap.get("merchantno_like")))) {
        	if (!"".equals(searchStr)){
        		searchStr = searchStr + " and ";
        	}
        	
            searchStr = searchStr + "merchantno like " +"'%" + queryMap.get("merchantno_like") + "%'";
        }
      
      
        if ((queryMap.get("name_like") != null)&&(!"".equals(queryMap.get("name_like")))) {
        	if (!"".equals(searchStr)){
        		searchStr = searchStr + " and ";
        	}
        	
            searchStr = searchStr +"name like " + "'%" + queryMap.get("name_like") + "%'";
        }
        
        
           
        return searchStr;
           
    }
    
    /**
     * 
     * @param queryFields
     * @return
     */
    public List getMerListOfQuery(int firstpage, int pagesize,Map queryFields){
    	String searchString = "";
    	String searchStr = getSearchString(queryFields,searchString);
    	
    	if ((queryFields.get("big_mcc") != null)&&(!"".equals(queryFields.get("big_mcc")))) {
    		if (!"".equals(searchStr)){
    			searchStr = searchStr + " and ";
    		}
            searchStr = searchStr + "m.bigmccCode="+ "'"+queryFields.get("big_mcc")+"'";
        }
        
    	if (!"".equals(searchStr)){
    		searchStr = "where " + searchStr;
    	}
    
    	Query query = getSession().createQuery("select a from cn.com.brilliance.begen.model.Tmchnt a inner join a.merchantcategoryOfTmcc m " + searchStr);
 
    	/*int first = (1 - 1) * 50;*/
    	query.setFirstResult(firstpage);
    	query.setMaxResults(50);
    	List result = query.list();
    	
    	
    	return result ;
    }
    
    
    public int getTmchntListOfQueryCount(Map queryFields){
    	Criteria criteria = getSession().createCriteria(Tmchnt.class);
        return getListFromQueryCount(queryFields, criteria);
    }
    
    
    /**
     * 
     * @param queryMap
     * @param criteria
     * @return
     */
    private int getListFromQueryCount(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤Tmchnt对象
        Object[] keyArray = queryMap.keySet().toArray();  //转换查询字段名keySet为数组
        //遍历该数组，去除对应查询字段值为空的键值
        for (int i = 0; i < keyArray.length; i++) {
            String value = (String) queryMap.get(keyArray[i]);
            if (value == null || value.trim().length() == 0) {
                queryMap.remove(keyArray[i]);
            }
        }

        if (queryMap.get("merchantcategory") != null) {
            criteria = criteria.add(Expression.eq("merchantcategory", queryMap.get("merchantcategory")));
        }
        if (queryMap.get("merchantcategory_like") != null) {
            criteria = criteria.add(Expression.like("merchantcategory", "%" + queryMap.get("merchantcategory_like") + "%"));
        }

        if (queryMap.get("id") != null) {
            criteria = criteria.add(Expression.eq("id", queryMap.get("id")));
        }
        if (queryMap.get("id_like") != null) {
            criteria = criteria.add(Expression.like("id", "%" + queryMap.get("id_like") + "%"));
        }

        if (queryMap.get("foreigncard") != null) {
            criteria = criteria.add(Expression.eq("foreigncard", queryMap.get("foreigncard")));
        }
        if (queryMap.get("foreigncard_like") != null) {
            criteria = criteria.add(Expression.like("foreigncard", "%" + queryMap.get("foreigncard_like") + "%"));
        }

        if (queryMap.get("merchantnature") != null) {
            criteria = criteria.add(Expression.eq("merchantnature", queryMap.get("merchantnature")));
        }
        if (queryMap.get("merchantnature_like") != null) {
            criteria = criteria.add(Expression.like("merchantnature", "%" + queryMap.get("merchantnature_like") + "%"));
        }

        if (queryMap.get("name") != null) {
            criteria = criteria.add(Expression.eq("name", queryMap.get("name")));
        }
        if (queryMap.get("name_like") != null) {
            criteria = criteria.add(Expression.like("name", "%" + queryMap.get("name_like") + "%"));
        }

        if (queryMap.get("briefname") != null) {
            criteria = criteria.add(Expression.eq("briefname", queryMap.get("briefname")));
        }
        if (queryMap.get("briefname_like") != null) {
            criteria = criteria.add(Expression.like("briefname", "%" + queryMap.get("briefname_like") + "%"));
        }

        if (queryMap.get("engname") != null) {
            criteria = criteria.add(Expression.eq("engname", queryMap.get("engname")));
        }
        if (queryMap.get("engname_like") != null) {
            criteria = criteria.add(Expression.like("engname", "%" + queryMap.get("engname_like") + "%"));
        }

        if (queryMap.get("engbriefname") != null) {
            criteria = criteria.add(Expression.eq("engbriefname", queryMap.get("engbriefname")));
        }
        if (queryMap.get("engbriefname_like") != null) {
            criteria = criteria.add(Expression.like("engbriefname", "%" + queryMap.get("engbriefname_like") + "%"));
        }

        if (queryMap.get("contractant") != null) {
            criteria = criteria.add(Expression.eq("contractant", queryMap.get("contractant")));
        }
        if (queryMap.get("contractant_like") != null) {
            criteria = criteria.add(Expression.like("contractant", "%" + queryMap.get("contractant_like") + "%"));
        }

        if (queryMap.get("licenseno") != null) {
            criteria = criteria.add(Expression.eq("licenseno", queryMap.get("licenseno")));
        }
        if (queryMap.get("licenseno_like") != null) {
            criteria = criteria.add(Expression.like("licenseno", "%" + queryMap.get("licenseno_like") + "%"));
        }

        if (queryMap.get("registeredcapital") != null) {
            criteria = criteria.add(Expression.eq("registeredcapital", queryMap.get("registeredcapital")));
        }
        if (queryMap.get("registeredcapital_like") != null) {
            criteria = criteria.add(Expression.like("registeredcapital", "%" + queryMap.get("registeredcapital_like") + "%"));
        }

        if (queryMap.get("taxno") != null) {
            criteria = criteria.add(Expression.eq("taxno", queryMap.get("taxno")));
        }
        if (queryMap.get("taxno_like") != null) {
            criteria = criteria.add(Expression.like("taxno", "%" + queryMap.get("taxno_like") + "%"));
        }

        if (queryMap.get("merchantno") != null) {
            criteria = criteria.add(Expression.eq("merchantno", queryMap.get("merchantno")));
        }
        if (queryMap.get("merchantno_like") != null) {
            criteria = criteria.add(Expression.like("merchantno", "%" + queryMap.get("merchantno_like") + "%"));
        }

        if (queryMap.get("installdate") != null) {
            criteria = criteria.add(Expression.eq("installdate", java.sql.Date.valueOf((String) queryMap.get("installdate"))));
        }
        if (queryMap.get("installdate_min") != null) {
            criteria = criteria.add(Expression.ge("installdate", java.sql.Date.valueOf((String) queryMap.get("installdate_min"))));
        }
        if (queryMap.get("installdate_max") != null) {
            criteria = criteria.add(Expression.le("installdate", java.sql.Date.valueOf((String) queryMap.get("installdate_max"))));
        }
        if (queryMap.get("withdrawinputdate") != null) {
            criteria = criteria.add(Expression.eq("withdrawinputdate", java.sql.Date.valueOf((String) queryMap.get("withdrawinputdate"))));
        }
        if (queryMap.get("withdrawinputdate_min") != null) {
            criteria = criteria.add(Expression.ge("withdrawinputdate", java.sql.Date.valueOf((String) queryMap.get("withdrawinputdate_min"))));
        }
        if (queryMap.get("withdrawinputdate_max") != null) {
            criteria = criteria.add(Expression.le("withdrawinputdate", java.sql.Date.valueOf((String) queryMap.get("withdrawinputdate_max"))));
        }
        if (queryMap.get("subinst") != null) {
            criteria = criteria.add(Expression.eq("subinst", queryMap.get("subinst")));
        }
        if (queryMap.get("subinst_like") != null) {
            criteria = criteria.add(Expression.like("subinst", "%" + queryMap.get("subinst_like") + "%"));
        }

        if (queryMap.get("developingmethod") != null) {
            criteria = criteria.add(Expression.eq("developingmethod", queryMap.get("developingmethod")));
        }
        if (queryMap.get("developingmethod_like") != null) {
            criteria = criteria.add(Expression.like("developingmethod", "%" + queryMap.get("developingmethod_like") + "%"));
        }

        if (queryMap.get("multiacquirer") != null) {
            criteria = criteria.add(Expression.eq("multiacquirer", new Boolean((String) queryMap.get("multiacquirer"))));
        }
        if (queryMap.get("businessacceptmethod") != null) {
            criteria = criteria.add(Expression.eq("businessacceptmethod", queryMap.get("businessacceptmethod")));
        }
        if (queryMap.get("businessacceptmethod_like") != null) {
            criteria = criteria.add(Expression.like("businessacceptmethod", "%" + queryMap.get("businessacceptmethod_like") + "%"));
        }

        if (queryMap.get("state") != null) {
            criteria = criteria.add(Expression.eq("state", queryMap.get("state")));
        }
        if (queryMap.get("state_like") != null) {
            criteria = criteria.add(Expression.like("state", "%" + queryMap.get("state_like") + "%"));
        }

        if (queryMap.get("servicerate") != null) {
            criteria = criteria.add(Expression.eq("servicerate", queryMap.get("servicerate")));
        }
        if (queryMap.get("servicerate_like") != null) {
            criteria = criteria.add(Expression.like("servicerate", "%" + queryMap.get("servicerate_like") + "%"));
        }

        if (queryMap.get("legalman") != null) {
            criteria = criteria.add(Expression.eq("legalman", queryMap.get("legalman")));
        }
        if (queryMap.get("legalman_like") != null) {
            criteria = criteria.add(Expression.like("legalman", "%" + queryMap.get("legalman_like") + "%"));
        }

        if (queryMap.get("idcardtype") != null) {
            criteria = criteria.add(Expression.eq("idcardtype", queryMap.get("idcardtype")));
        }
        if (queryMap.get("idcardtype_like") != null) {
            criteria = criteria.add(Expression.like("idcardtype", "%" + queryMap.get("idcardtype_like") + "%"));
        }

        if (queryMap.get("idcardno") != null) {
            criteria = criteria.add(Expression.eq("idcardno", queryMap.get("idcardno")));
        }
        if (queryMap.get("idcardno_like") != null) {
            criteria = criteria.add(Expression.like("idcardno", "%" + queryMap.get("idcardno_like") + "%"));
        }

        if (queryMap.get("licensedeadline") != null) {
            criteria = criteria.add(Expression.eq("licensedeadline", java.sql.Date.valueOf((String) queryMap.get("licensedeadline"))));
        }
        if (queryMap.get("licensedeadline_min") != null) {
            criteria = criteria.add(Expression.ge("licensedeadline", java.sql.Date.valueOf((String) queryMap.get("licensedeadline_min"))));
        }
        if (queryMap.get("licensedeadline_max") != null) {
            criteria = criteria.add(Expression.le("licensedeadline", java.sql.Date.valueOf((String) queryMap.get("licensedeadline_max"))));
        }
        if (queryMap.get("registerAddress") != null) {
            criteria = criteria.add(Expression.eq("registerAddress", queryMap.get("registerAddress")));
        }
        if (queryMap.get("registerAddress_like") != null) {
            criteria = criteria.add(Expression.like("registerAddress", "%" + queryMap.get("registerAddress_like") + "%"));
        }

        if (queryMap.get("registerZipcode") != null) {
            criteria = criteria.add(Expression.eq("registerZipcode", queryMap.get("registerZipcode")));
        }
        if (queryMap.get("registerZipcode_like") != null) {
            criteria = criteria.add(Expression.like("registerZipcode", "%" + queryMap.get("registerZipcode_like") + "%"));
        }

        if (queryMap.get("officeAddress") != null) {
            criteria = criteria.add(Expression.eq("officeAddress", queryMap.get("officeAddress")));
        }
        if (queryMap.get("officeAddress_like") != null) {
            criteria = criteria.add(Expression.like("officeAddress", "%" + queryMap.get("officeAddress_like") + "%"));
        }

        if (queryMap.get("officeZipcode") != null) {
            criteria = criteria.add(Expression.eq("officeZipcode", queryMap.get("officeZipcode")));
        }
        if (queryMap.get("officeZipcode_like") != null) {
            criteria = criteria.add(Expression.like("officeZipcode", "%" + queryMap.get("officeZipcode_like") + "%"));
        }

        if (queryMap.get("contactperson") != null) {
            criteria = criteria.add(Expression.eq("contactperson", queryMap.get("contactperson")));
        }
        if (queryMap.get("contactperson_like") != null) {
            criteria = criteria.add(Expression.like("contactperson", "%" + queryMap.get("contactperson_like") + "%"));
        }

        if (queryMap.get("dept") != null) {
            criteria = criteria.add(Expression.eq("dept", queryMap.get("dept")));
        }
        if (queryMap.get("dept_like") != null) {
            criteria = criteria.add(Expression.like("dept", "%" + queryMap.get("dept_like") + "%"));
        }

        if (queryMap.get("tel") != null) {
            criteria = criteria.add(Expression.eq("tel", queryMap.get("tel")));
        }
        if (queryMap.get("tel_like") != null) {
            criteria = criteria.add(Expression.like("tel", "%" + queryMap.get("tel_like") + "%"));
        }

        if (queryMap.get("mobtel") != null) {
            criteria = criteria.add(Expression.eq("mobtel", queryMap.get("mobtel")));
        }
        if (queryMap.get("mobtel_like") != null) {
            criteria = criteria.add(Expression.like("mobtel", "%" + queryMap.get("mobtel_like") + "%"));
        }

        if (queryMap.get("fax") != null) {
            criteria = criteria.add(Expression.eq("fax", queryMap.get("fax")));
        }
        if (queryMap.get("fax_like") != null) {
            criteria = criteria.add(Expression.like("fax", "%" + queryMap.get("fax_like") + "%"));
        }

        if (queryMap.get("email") != null) {
            criteria = criteria.add(Expression.eq("email", queryMap.get("email")));
        }
        if (queryMap.get("email_like") != null) {
            criteria = criteria.add(Expression.like("email", "%" + queryMap.get("email_like") + "%"));
        }

        if (queryMap.get("financeperson") != null) {
            criteria = criteria.add(Expression.eq("financeperson", queryMap.get("financeperson")));
        }
        if (queryMap.get("financeperson_like") != null) {
            criteria = criteria.add(Expression.like("financeperson", "%" + queryMap.get("financeperson_like") + "%"));
        }

        if (queryMap.get("financetel") != null) {
            criteria = criteria.add(Expression.eq("financetel", queryMap.get("financetel")));
        }
        if (queryMap.get("financetel_like") != null) {
            criteria = criteria.add(Expression.like("financetel", "%" + queryMap.get("financetel_like") + "%"));
        }

        if (queryMap.get("financemotel") != null) {
            criteria = criteria.add(Expression.eq("financemotel", queryMap.get("financemotel")));
        }
        if (queryMap.get("financemotel_like") != null) {
            criteria = criteria.add(Expression.like("financemotel", "%" + queryMap.get("financemotel_like") + "%"));
        }

        if (queryMap.get("financefax") != null) {
            criteria = criteria.add(Expression.eq("financefax", queryMap.get("financefax")));
        }
        if (queryMap.get("financefax_like") != null) {
            criteria = criteria.add(Expression.like("financefax", "%" + queryMap.get("financefax_like") + "%"));
        }

        if (queryMap.get("financeemail") != null) {
            criteria = criteria.add(Expression.eq("financeemail", queryMap.get("financeemail")));
        }
        if (queryMap.get("financeemail_like") != null) {
            criteria = criteria.add(Expression.like("financeemail", "%" + queryMap.get("financeemail_like") + "%"));
        }

        if (queryMap.get("mailperson") != null) {
            criteria = criteria.add(Expression.eq("mailperson", queryMap.get("mailperson")));
        }
        if (queryMap.get("mailperson_like") != null) {
            criteria = criteria.add(Expression.like("mailperson", "%" + queryMap.get("mailperson_like") + "%"));
        }

        if (queryMap.get("mailtel") != null) {
            criteria = criteria.add(Expression.eq("mailtel", queryMap.get("mailtel")));
        }
        if (queryMap.get("mailtel_like") != null) {
            criteria = criteria.add(Expression.like("mailtel", "%" + queryMap.get("mailtel_like") + "%"));
        }

        if (queryMap.get("mailmobtel") != null) {
            criteria = criteria.add(Expression.eq("mailmobtel", queryMap.get("mailmobtel")));
        }
        if (queryMap.get("mailmobtel_like") != null) {
            criteria = criteria.add(Expression.like("mailmobtel", "%" + queryMap.get("mailmobtel_like") + "%"));
        }

        if (queryMap.get("chargereduingtime") != null) {
            criteria = criteria.add(Expression.eq("chargereduingtime", new Integer((String) queryMap.get("chargereduingtime"))));
        }
        if (queryMap.get("chargereduingtime_min") != null) {
            criteria = criteria.add(Expression.ge("chargereduingtime", new Integer((String) queryMap.get("chargereduingtime_min"))));
        }
        if (queryMap.get("chargereduingtime_max") != null) {
            criteria = criteria.add(Expression.le("chargereduingtime", new Integer((String) queryMap.get("chargereduingtime_max"))));
        }
        if (queryMap.get("guaranteemethod") != null) {
            criteria = criteria.add(Expression.eq("guaranteemethod", queryMap.get("guaranteemethod")));
        }
        if (queryMap.get("guaranteemethod_like") != null) {
            criteria = criteria.add(Expression.like("guaranteemethod", "%" + queryMap.get("guaranteemethod_like") + "%"));
        }

        if (queryMap.get("guaranteemethoddesc") != null) {
            criteria = criteria.add(Expression.eq("guaranteemethoddesc", queryMap.get("guaranteemethoddesc")));
        }
        if (queryMap.get("guaranteemethoddesc_like") != null) {
            criteria = criteria.add(Expression.like("guaranteemethoddesc", "%" + queryMap.get("guaranteemethoddesc_like") + "%"));
        }

        if (queryMap.get("approvedesc") != null) {
            criteria = criteria.add(Expression.eq("approvedesc", queryMap.get("approvedesc")));
        }
        if (queryMap.get("approvedesc_like") != null) {
            criteria = criteria.add(Expression.like("approvedesc", "%" + queryMap.get("approvedesc_like") + "%"));
        }

        if (queryMap.get("approveddate") != null) {
            criteria = criteria.add(Expression.eq("approveddate", java.sql.Date.valueOf((String) queryMap.get("approveddate"))));
        }
        if (queryMap.get("approveddate_min") != null) {
            criteria = criteria.add(Expression.ge("approveddate", java.sql.Date.valueOf((String) queryMap.get("approveddate_min"))));
        }
        if (queryMap.get("approveddate_max") != null) {
            criteria = criteria.add(Expression.le("approveddate", java.sql.Date.valueOf((String) queryMap.get("approveddate_max"))));
        }
        if (queryMap.get("addingcategory") != null) {
            criteria = criteria.add(Expression.eq("addingcategory", queryMap.get("addingcategory")));
        }
        if (queryMap.get("addingcategory_like") != null) {
            criteria = criteria.add(Expression.like("addingcategory", "%" + queryMap.get("addingcategory_like") + "%"));
        }

        if (queryMap.get("logoutinputdate") != null) {
            criteria = criteria.add(Expression.eq("logoutinputdate", java.sql.Date.valueOf((String) queryMap.get("logoutinputdate"))));
        }
        if (queryMap.get("logoutinputdate_min") != null) {
            criteria = criteria.add(Expression.ge("logoutinputdate", java.sql.Date.valueOf((String) queryMap.get("logoutinputdate_min"))));
        }
        if (queryMap.get("logoutinputdate_max") != null) {
            criteria = criteria.add(Expression.le("logoutinputdate", java.sql.Date.valueOf((String) queryMap.get("logoutinputdate_max"))));
        }
        if (queryMap.get("withdrawcategory") != null) {
            criteria = criteria.add(Expression.eq("withdrawcategory", queryMap.get("withdrawcategory")));
        }
        if (queryMap.get("withdrawcategory_like") != null) {
            criteria = criteria.add(Expression.like("withdrawcategory", "%" + queryMap.get("withdrawcategory_like") + "%"));
        }

        if (queryMap.get("withdrawoperator") != null) {
            criteria = criteria.add(Expression.eq("withdrawoperator", queryMap.get("withdrawoperator")));
        }
        if (queryMap.get("withdrawoperator_like") != null) {
            criteria = criteria.add(Expression.like("withdrawoperator", "%" + queryMap.get("withdrawoperator_like") + "%"));
        }

        if (queryMap.get("laststatechangedate") != null) {
            criteria = criteria.add(Expression.eq("laststatechangedate", java.sql.Date.valueOf((String) queryMap.get("laststatechangedate"))));
        }
        if (queryMap.get("laststatechangedate_min") != null) {
            criteria = criteria.add(Expression.ge("laststatechangedate", java.sql.Date.valueOf((String) queryMap.get("laststatechangedate_min"))));
        }
        if (queryMap.get("laststatechangedate_max") != null) {
            criteria = criteria.add(Expression.le("laststatechangedate", java.sql.Date.valueOf((String) queryMap.get("laststatechangedate_max"))));
        }
        if (queryMap.get("laststatechangeoperator") != null) {
            criteria = criteria.add(Expression.eq("laststatechangeoperator", queryMap.get("laststatechangeoperator")));
        }
        if (queryMap.get("laststatechangeoperator_like") != null) {
            criteria = criteria.add(Expression.like("laststatechangeoperator", "%" + queryMap.get("laststatechangeoperator_like") + "%"));
        }

        if (queryMap.get("province") != null) {
            criteria = criteria.add(Expression.eq("province", queryMap.get("province")));
        }
        if (queryMap.get("province_like") != null) {
            criteria = criteria.add(Expression.like("province", "%" + queryMap.get("province_like") + "%"));
        }

        if (queryMap.get("city") != null) {
            criteria = criteria.add(Expression.eq("city", queryMap.get("city")));
        }
        if (queryMap.get("city_like") != null) {
            criteria = criteria.add(Expression.like("city", "%" + queryMap.get("city_like") + "%"));
        }

        if (queryMap.get("county") != null) {
            criteria = criteria.add(Expression.eq("county", queryMap.get("county")));
        }
        if (queryMap.get("county_like") != null) {
            criteria = criteria.add(Expression.like("county", "%" + queryMap.get("county_like") + "%"));
        }

        if (queryMap.get("refusereason") != null) {
            criteria = criteria.add(Expression.eq("refusereason", queryMap.get("refusereason")));
        }
        if (queryMap.get("refusereason_like") != null) {
            criteria = criteria.add(Expression.like("refusereason", "%" + queryMap.get("refusereason_like") + "%"));
        }

        if (queryMap.get("remark") != null) {
            criteria = criteria.add(Expression.eq("remark", queryMap.get("remark")));
        }
        if (queryMap.get("remark_like") != null) {
            criteria = criteria.add(Expression.like("remark", "%" + queryMap.get("remark_like") + "%"));
        }

        
		int totalCount = ((Integer) criteria.setProjection(
				Projections.rowCount()).uniqueResult()).intValue();
		return totalCount;
        
      
    }
    
    
    
}
