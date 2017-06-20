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

import cn.com.brilliance.begen.dao.SysPartyDAO;
import cn.com.brilliance.begen.model.SysParty;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;

/**
 * SysPartyDAO接口具体实现类.
 * @author Administrator.
 */

public class SysPartyDAOHibernate extends BeGenHibernateDaoSupport implements SysPartyDAO {    

    /**
     *  根据主键获得SysParty对象.
     *  @param pkey SysParty主键
     *  @return SysParty.
     */
    public SysParty getSysParty(java.lang.String pkey) {
        SysParty sysParty = (SysParty) getHibernateTemplate().get(SysParty.class, pkey);
        if (sysParty == null) {
            return sysParty;
        }
        return sysParty;

    }

    /**
     *  存储SysParty对象.
     *  @param  sysParty SysParty对象
     *  @return SysParty.
     */
    public SysParty saveSysParty(SysParty sysParty) {
        return (SysParty) getHibernateTemplate().merge(sysParty);
    }

    /**
     *  删除SysParty对象.
     *  @param pkey SysParty主键.
     */
    public void removeSysParty(java.lang.String pkey) {
        SysParty sysParty = getSysParty(pkey);
        getHibernateTemplate().delete(sysParty);
    }

    /**
     *  获取SysParty对象列表.
     *  @param  sysParty SysParty对象
     *  @return List.
     */
    public List getSysPartyList(SysParty sysParty) {
        Criteria criteria = getSession().createCriteria(SysParty.class).add(
                Example.create(sysParty));
        if (sysParty.getPartyId() != null) {
            criteria.add(Expression.eq("partyId", sysParty.getPartyId()));
        }
        return criteria.list();
    }

    /**
     *  根据查询条件获取SysParty对象列表(有用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysPartyListOfQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysParty where " + hsql);
            return query.list();
        }

        Criteria criteria = getSession().createCriteria(SysParty.class);

        return getListFromQueryMap(queryMap, criteria);
    }

    /**
     *  根据查询条件获取SysParty对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    public List getSysPartyListOfNoAuthorityQuery(Map queryMap) {
        String hsql = (String) queryMap.get("_hsql");
        if (hsql != null) {
            Query query = getSession().createQuery("from cn.com.brilliance.begen.model.SysParty where " + hsql);
            return query.list();
        }
        Criteria criteria = getSession().createCriteria(SysParty.class);
        return getListFromQueryMap(queryMap, criteria);
    }

    private List getListFromQueryMap(Map queryMap,Criteria criteria) {
        //根据查询queryMap的键值，过滤SysParty对象
        Object[] keyArray = queryMap.keySet().toArray();  //转换查询字段名keySet为数组
        //遍历该数组，去除对应查询字段值为空的键值
        for (int i = 0; i < keyArray.length; i++) {
            String value = (String) queryMap.get(keyArray[i]);
            if (value == null || value.trim().length() == 0) {
                queryMap.remove(keyArray[i]);
            }
        }

        if (queryMap.get("partyId") != null) {
            criteria = criteria.add(Expression.eq("partyId", queryMap.get("partyId")));
        }
        if (queryMap.get("partyId_like") != null) {
            criteria = criteria.add(Expression.like("partyId", "%" + queryMap.get("partyId_like") + "%"));
        }

        if (queryMap.get("partyName") != null) {
            criteria = criteria.add(Expression.eq("partyName", queryMap.get("partyName")));
        }
        if (queryMap.get("partyName_like") != null) {
            criteria = criteria.add(Expression.like("partyName", "%" + queryMap.get("partyName_like") + "%"));
        }

        if (queryMap.get("databaseName") != null) {
            criteria = criteria.add(Expression.eq("databaseName", queryMap.get("databaseName")));
        }
        if (queryMap.get("databaseName_like") != null) {
            criteria = criteria.add(Expression.like("databaseName", "%" + queryMap.get("databaseName_like") + "%"));
        }

        if (queryMap.get("lastDeployTime") != null) {
            criteria = criteria.add(Expression.eq("lastDeployTime", java.sql.Date.valueOf((String) queryMap.get("lastDeployTime"))));
        }
        if (queryMap.get("lastDeployTime_min") != null) {
            criteria = criteria.add(Expression.ge("lastDeployTime", java.sql.Date.valueOf((String) queryMap.get("lastDeployTime_min"))));
        }
        if (queryMap.get("lastDeployTime_max") != null) {
            criteria = criteria.add(Expression.le("lastDeployTime", java.sql.Date.valueOf((String) queryMap.get("lastDeployTime_max"))));
        }
        if (queryMap.get("contractPerson") != null) {
            criteria = criteria.add(Expression.eq("contractPerson", queryMap.get("contractPerson")));
        }
        if (queryMap.get("contractPerson_like") != null) {
            criteria = criteria.add(Expression.like("contractPerson", "%" + queryMap.get("contractPerson_like") + "%"));
        }

        if (queryMap.get("email") != null) {
            criteria = criteria.add(Expression.eq("email", queryMap.get("email")));
        }
        if (queryMap.get("email_like") != null) {
            criteria = criteria.add(Expression.like("email", "%" + queryMap.get("email_like") + "%"));
        }

        if (queryMap.get("phone") != null) {
            criteria = criteria.add(Expression.eq("phone", queryMap.get("phone")));
        }
        if (queryMap.get("phone_like") != null) {
            criteria = criteria.add(Expression.like("phone", "%" + queryMap.get("phone_like") + "%"));
        }

        if (queryMap.get("userNumber") != null) {
            criteria = criteria.add(Expression.eq("userNumber", queryMap.get("userNumber")));
        }
        if (queryMap.get("userNumber_like") != null) {
            criteria = criteria.add(Expression.like("userNumber", "%" + queryMap.get("userNumber_like") + "%"));
        }

        if (queryMap.get("openFlag") != null) {
            criteria = criteria.add(Expression.eq("openFlag", new Boolean((String) queryMap.get("openFlag"))));
        }
        if (queryMap.get("remark") != null) {
            criteria = criteria.add(Expression.eq("remark", queryMap.get("remark")));
        }
        if (queryMap.get("remark_like") != null) {
            criteria = criteria.add(Expression.like("remark", "%" + queryMap.get("remark_like") + "%"));
        }

        if (queryMap.get("logo") != null) {
            criteria = criteria.add(Expression.eq("logo", queryMap.get("logo")));
        }
        if (queryMap.get("logo_like") != null) {
            criteria = criteria.add(Expression.like("logo", "%" + queryMap.get("logo_like") + "%"));
        }

        if (queryMap.get("developMode") != null) {
            criteria = criteria.add(Expression.eq("developMode", new Boolean((String) queryMap.get("developMode"))));
        }
        if (queryMap.get("enableCa") != null) {
            criteria = criteria.add(Expression.eq("enableCa", new Boolean((String) queryMap.get("enableCa"))));
        }
        if (queryMap.get("sendCa") != null) {
            criteria = criteria.add(Expression.eq("sendCa", new Boolean((String) queryMap.get("sendCa"))));
        }

        //根据查询queryMap的键值，提供排序功能,_order="域名1 asc|desc,域名2 asc|desc"
        if (queryMap.get("_order") != null) {
            addOrder(queryMap, criteria);
        }
        return criteria.list();
    }
}
