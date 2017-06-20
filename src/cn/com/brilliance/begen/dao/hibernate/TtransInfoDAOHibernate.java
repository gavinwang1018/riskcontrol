package cn.com.brilliance.begen.dao.hibernate;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Projections;

import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.common.dao.BeGenHibernateDaoSupport;
import cn.com.brilliance.begen.dao.TtransInfoDAO;
import cn.com.brilliance.begen.model.TtransInfo;

/**
 * TtransInfoDAO接口具体实现类.
 * 
 * @author Administrator.
 */

public class TtransInfoDAOHibernate extends BeGenHibernateDaoSupport implements
		TtransInfoDAO {

	/**
	 * 根据主键获得TtransInfo对象.
	 * 
	 * @param pkey
	 *            TtransInfo主键
	 * @return TtransInfo.
	 */
	public TtransInfo getTtransInfo(java.lang.String pkey) {
		TtransInfo ttransInfo = (TtransInfo) getHibernateTemplate().get(
				TtransInfo.class, pkey);
		if (ttransInfo == null) {
			return ttransInfo;
		}
		return ttransInfo;

	}

	/**
	 * 存储TtransInfo对象.
	 * 
	 * @param ttransInfo
	 *            TtransInfo对象
	 * @return TtransInfo.
	 */
	public TtransInfo saveTtransInfo(TtransInfo ttransInfo) {
		return (TtransInfo) getHibernateTemplate().merge(ttransInfo);
	}

	/**
	 * 删除TtransInfo对象.
	 * 
	 * @param pkey
	 *            TtransInfo主键.
	 */
	public void removeTtransInfo(java.lang.String pkey) {
		TtransInfo ttransInfo = getTtransInfo(pkey);
		getHibernateTemplate().delete(ttransInfo);
	}

	/**
	 * 获取TtransInfo对象列表.
	 * 
	 * @param ttransInfo
	 *            TtransInfo对象
	 * @return List.
	 */
	public List getTtransInfoList(TtransInfo ttransInfo) {
		Criteria criteria = getSession().createCriteria(TtransInfo.class).add(
				Example.create(ttransInfo));
		if (ttransInfo.getId() != null) {
			criteria.add(Expression.eq("id", ttransInfo.getId()));
		}
		return criteria.list();
	}

	/**
	 * 根据查询条件获取TtransInfo对象列表(有用户权限限制).
	 * 
	 * @param queryMap
	 *            查询条件Map
	 * @return List.
	 */
	public List getTtransInfoListOfQuery(Map queryMap) {
		String hsql = (String) queryMap.get("_hsql");
		if (hsql != null) {
			Query query = getSession().createSQLQuery(
					"select {tt.*} from  " + hsql).addEntity("tt",
					TtransInfo.class);
			return query.list();
		}

		Criteria criteria = getSession().createCriteria(TtransInfo.class);

		return getListFromQueryMap(queryMap, criteria);
	}

	/**
	 * 根据查询条件获取TtransInfo对象列表(无用户权限限制).
	 * 
	 * @param queryMap
	 *            查询条件Map
	 * @return List.
	 */
	public List getTtransInfoListOfNoAuthorityQuery(Map queryMap) {
		String hsql = (String) queryMap.get("_hsql");
		if (hsql != null) {
			Query query = getSession().createQuery(
					"from cn.com.brilliance.begen.model.TtransInfo where "
							+ hsql);
			return query.list();
		}
		Criteria criteria = getSession().createCriteria(TtransInfo.class);
		return getListFromQueryMap(queryMap, criteria);
	}

	private List getListFromQueryMap(Map queryMap, Criteria criteria) {
		// 根据查询queryMap的键值，过滤TtransInfo对象
		Object[] keyArray = queryMap.keySet().toArray(); // 转换查询字段名keySet为数组
		// 遍历该数组，去除对应查询字段值为空的键值
		for (int i = 0; i < keyArray.length; i++) {
			Object value = (Object) queryMap.get(keyArray[i]);
			if (value instanceof String) {
				if (value == null || ((String) value).trim().length() == 0) {
					queryMap.remove(keyArray[i]);
				}
			}
		}

		if (queryMap.get("id") != null) {
			criteria = criteria.add(Expression.eq("id", queryMap.get("id")));
		}
		if (queryMap.get("id_like") != null) {
			criteria = criteria.add(Expression.like("id", "%"
					+ queryMap.get("id_like") + "%"));
		}

		if (queryMap.get("settleDt") != null) {
			criteria = criteria.add(Expression.eq("settleDt", java.sql.Date
					.valueOf(Tools.getFormatDate(((java.util.Date) queryMap
							.get("settleDt")), "yyyy-MM-dd"))));
		}
		if (queryMap.get("settleDt_min") != null) {
			criteria = criteria.add(Expression.ge("settleDt", queryMap.get("settleDt_min")));
		}
		if (queryMap.get("settleDt_max") != null) {
			criteria = criteria.add(Expression.le("settleDt", queryMap.get("settleDt_max")));
		}
		if (queryMap.get("sysTraNo") != null) {
			criteria = criteria.add(Expression.eq("sysTraNo", queryMap
					.get("sysTraNo")));
		}
		if (queryMap.get("sysTraNo_like") != null) {
			criteria = criteria.add(Expression.like("sysTraNo", "%"
					+ queryMap.get("sysTraNo_like") + "%"));
		}

		if (queryMap.get("respCd4") != null) {
			criteria = criteria.add(Expression.eq("respCd4", queryMap
					.get("respCd4")));
		}
		if (queryMap.get("respCd4_like") != null) {
			criteria = criteria.add(Expression.like("respCd4", "%"
					+ queryMap.get("respCd4_like") + "%"));
		}

		if (queryMap.get("transId") != null) {
			criteria = criteria.add(Expression.eq("transId", queryMap
					.get("transId")));
		}
		if (queryMap.get("transId_like") != null) {
			criteria = criteria.add(Expression.like("transId", "%"
					+ queryMap.get("transId_like") + "%"));
		}

		if (queryMap.get("settleIn") != null) {
			criteria = criteria.add(Expression.eq("settleIn", queryMap
					.get("settleIn")));
		}
		if (queryMap.get("settleIn_like") != null) {
			criteria = criteria.add(Expression.like("settleIn", "%"
					+ queryMap.get("settleIn_like") + "%"));
		}

		if (queryMap.get("transAt") != null) {
			criteria = criteria.add(Expression.eq("transAt", new Integer(
					(String) queryMap.get("transAt"))));
		}
		if (queryMap.get("transAt_min") != null) {
			criteria = criteria.add(Expression.ge("transAt", new Integer(
					(String) queryMap.get("transAt_min"))));
		}
		if (queryMap.get("transAt_max") != null) {
			criteria = criteria.add(Expression.le("transAt", new Integer(
					(String) queryMap.get("transAt_max"))));
		}
		if (queryMap.get("msgTp") != null) {
			criteria = criteria.add(Expression.eq("msgTp", queryMap
					.get("msgTp")));
		}
		if (queryMap.get("msgTp_like") != null) {
			criteria = criteria.add(Expression.like("msgTp", "%"
					+ queryMap.get("msgTp_like") + "%"));
		}

		if (queryMap.get("locTransDtTm") != null) {
			criteria = criteria.add(Expression.eq("locTransDtTm", queryMap
					.get("locTransDtTm")));
		}
		if (queryMap.get("locTransDtTm_like") != null) {
			criteria = criteria.add(Expression.like("locTransDtTm", "%"
					+ queryMap.get("locTransDtTm_like") + "%"));
		}

		if (queryMap.get("mchntTp") != null) {
			criteria = criteria.add(Expression.eq("mchntTp", queryMap
					.get("mchntTp")));
		}
		if (queryMap.get("mchntTp_like") != null) {
			criteria = criteria.add(Expression.like("mchntTp", "%"
					+ queryMap.get("mchntTp_like") + "%"));
		}

		if (queryMap.get("retriRefNo") != null) {
			criteria = criteria.add(Expression.eq("retriRefNo", queryMap
					.get("retriRefNo")));
		}
		if (queryMap.get("retriRefNo_like") != null) {
			criteria = criteria.add(Expression.like("retriRefNo", "%"
					+ queryMap.get("retriRefNo_like") + "%"));
		}

		if (queryMap.get("priAcctNo") != null) {
			criteria = criteria.add(Expression.eq("priAcctNo", queryMap
					.get("priAcctNo")));
		}
		if (queryMap.get("priAcctNo_like") != null) {
			criteria = criteria.add(Expression.like("priAcctNo", "%"
					+ queryMap.get("priAcctNo_like") + "%"));
		}

		if (queryMap.get("bin") != null) {
			criteria = criteria.add(Expression.eq("bin", queryMap.get("bin")));
		}
		if (queryMap.get("bin_like") != null) {
			criteria = criteria.add(Expression.like("bin", "%"
					+ queryMap.get("bin_like") + "%"));
		}

		if (queryMap.get("cardAttr") != null) {
			criteria = criteria.add(Expression.eq("cardAttr", queryMap
					.get("cardAttr")));
		}
		if (queryMap.get("cardAttr_like") != null) {
			criteria = criteria.add(Expression.like("cardAttr", "%"
					+ queryMap.get("cardAttr_like") + "%"));
		}

		if (queryMap.get("cardMedia") != null) {
			criteria = criteria.add(Expression.eq("cardMedia", queryMap
					.get("cardMedia")));
		}
		if (queryMap.get("cardMedia_like") != null) {
			criteria = criteria.add(Expression.like("cardMedia", "%"
					+ queryMap.get("cardMedia_like") + "%"));
		}

		if (queryMap.get("termId") != null) {
			criteria = criteria.add(Expression.eq("termId", queryMap
					.get("termId")));
		}
		if (queryMap.get("termId_like") != null) {
			criteria = criteria.add(Expression.like("termId", "%"
					+ queryMap.get("termId_like") + "%"));
		}

		if (queryMap.get("mchntCd") != null) {
			criteria = criteria.add(Expression.eq("mchntCd", queryMap
					.get("mchntCd")));
		}
		if (queryMap.get("mchntCd_like") != null) {
			criteria = criteria.add(Expression.like("mchntCd", "%"
					+ queryMap.get("mchntCd_like") + "%"));
		}

		if (queryMap.get("cardAccptrNmLoc") != null) {
			criteria = criteria.add(Expression.eq("cardAccptrNmLoc", queryMap
					.get("cardAccptrNmLoc")));
		}
		if (queryMap.get("cardAccptrNmLoc_like") != null) {
			criteria = criteria.add(Expression.like("cardAccptrNmLoc", "%"
					+ queryMap.get("cardAccptrNmLoc_like") + "%"));
		}

		if (queryMap.get("acqInsIdCd") != null) {
			criteria = criteria.add(Expression.eq("acqInsIdCd", queryMap
					.get("acqInsIdCd")));
		}
		if (queryMap.get("acqInsIdCd_like") != null) {
			criteria = criteria.add(Expression.like("acqInsIdCd", "%"
					+ queryMap.get("acqInsIdCd_like") + "%"));
		}

		if (queryMap.get("fwdInsIdCd") != null) {
			criteria = criteria.add(Expression.eq("fwdInsIdCd", queryMap
					.get("fwdInsIdCd")));
		}
		if (queryMap.get("fwdInsIdCd_like") != null) {
			criteria = criteria.add(Expression.like("fwdInsIdCd", "%"
					+ queryMap.get("fwdInsIdCd_like") + "%"));
		}

		if (queryMap.get("rcvInsIdCd") != null) {
			criteria = criteria.add(Expression.eq("rcvInsIdCd", queryMap
					.get("rcvInsIdCd")));
		}
		if (queryMap.get("rcvInsIdCd_like") != null) {
			criteria = criteria.add(Expression.like("rcvInsIdCd", "%"
					+ queryMap.get("rcvInsIdCd_like") + "%"));
		}

		if (queryMap.get("issInsIdCd") != null) {
			criteria = criteria.add(Expression.eq("issInsIdCd", queryMap
					.get("issInsIdCd")));
		}
		if (queryMap.get("issInsIdCd_like") != null) {
			criteria = criteria.add(Expression.like("issInsIdCd", "%"
					+ queryMap.get("issInsIdCd_like") + "%"));
		}

		if (queryMap.get("origSysTraNo") != null) {
			criteria = criteria.add(Expression.eq("origSysTraNo", queryMap
					.get("origSysTraNo")));
		}
		if (queryMap.get("origSysTraNo_like") != null) {
			criteria = criteria.add(Expression.like("origSysTraNo", "%"
					+ queryMap.get("origSysTraNo_like") + "%"));
		}

		if (queryMap.get("origTransmsnDtTm") != null) {
			criteria = criteria.add(Expression.eq("origTransmsnDtTm", queryMap
					.get("origTransmsnDtTm")));
		}
		if (queryMap.get("origTransmsnDtTm_like") != null) {
			criteria = criteria.add(Expression.like("origTransmsnDtTm", "%"
					+ queryMap.get("origTransmsnDtTm_like") + "%"));
		}

		if (queryMap.get("rsnCd") != null) {
			criteria = criteria.add(Expression.eq("rsnCd", queryMap
					.get("rsnCd")));
		}
		if (queryMap.get("rsnCd_like") != null) {
			criteria = criteria.add(Expression.like("rsnCd", "%"
					+ queryMap.get("rsnCd_like") + "%"));
		}

		if (queryMap.get("authDt") != null) {
			criteria = criteria.add(Expression.eq("authDt", (String) queryMap
					.get("authDt")));
		}
		if (queryMap.get("authDt_like") != null) {
			criteria = criteria.add(Expression.ge("authDt", "%"
					+ queryMap.get("authDt_like") + "%"));
		}
		if (queryMap.get("authIdRespCd") != null) {
			criteria = criteria.add(Expression.eq("authIdRespCd", queryMap
					.get("authIdRespCd")));
		}
		if (queryMap.get("authIdRespCd_like") != null) {
			criteria = criteria.add(Expression.like("authIdRespCd", "%"
					+ queryMap.get("authIdRespCd_like") + "%"));
		}

		if (queryMap.get("posEntryMdCd") != null) {
			criteria = criteria.add(Expression.eq("posEntryMdCd", queryMap
					.get("posEntryMdCd")));
		}
		if (queryMap.get("posEntryMdCd_like") != null) {
			criteria = criteria.add(Expression.like("posEntryMdCd", "%"
					+ queryMap.get("posEntryMdCd_like") + "%"));
		}

		if (queryMap.get("posCondCd") != null) {
			criteria = criteria.add(Expression.eq("posCondCd", queryMap
					.get("posCondCd")));
		}
		if (queryMap.get("posCondCd_like") != null) {
			criteria = criteria.add(Expression.like("posCondCd", "%"
					+ queryMap.get("posCondCd_like") + "%"));
		}

		if (queryMap.get("procCd") != null) {
			criteria = criteria.add(Expression.eq("procCd", queryMap
					.get("procCd")));
		}
		if (queryMap.get("procCd_like") != null) {
			criteria = criteria.add(Expression.like("procCd", "%"
					+ queryMap.get("procCd_like") + "%"));
		}

		if (queryMap.get("settleYm") != null) {
			criteria = criteria.add(Expression.eq("settleYm", queryMap
					.get("settleYm")));
		}
		if (queryMap.get("settleYm_like") != null) {
			criteria = criteria.add(Expression.like("settleYm", "%"
					+ queryMap.get("settleYm_like") + "%"));
		}

		if (queryMap.get("fwdInsIdOriginal") != null) {
			criteria = criteria.add(Expression.eq("fwdInsIdOriginal", queryMap
					.get("fwdInsIdOriginal")));
		}
		if (queryMap.get("fwdInsIdOriginal_like") != null) {
			criteria = criteria.add(Expression.like("fwdInsIdOriginal", "%"
					+ queryMap.get("fwdInsIdOriginal_like") + "%"));
		}
		if (queryMap.get("startRow") != null) {
			criteria = criteria.setFirstResult(new Integer((String) queryMap
					.get("startRow")));
		}
		if (queryMap.get("pageSize") != null) {
			criteria = criteria.setMaxResults(new Integer((String) queryMap
					.get("pageSize")));
		}

		// 根据查询queryMap的键值，提供排序功能,_order="域名1 asc|desc,域名2 asc|desc"
		if (queryMap.get("_order") != null) {
			addOrder(queryMap, criteria);
		}
		return criteria.list();
	}

	public int getTmchntListOfQueryCount(Map queryFields) {
		Criteria criteria = getSession().createCriteria(TtransInfo.class);
		return getListFromQueryCount(queryFields, criteria);
	}

	private int getListFromQueryCount(Map queryMap, Criteria criteria) {
		// TODO Auto-generated method stub
		// 根据查询queryMap的键值，过滤TtransInfo对象
		Object[] keyArray = queryMap.keySet().toArray(); // 转换查询字段名keySet为数组
		// 遍历该数组，去除对应查询字段值为空的键值
		for (int i = 0; i < keyArray.length; i++) {
			Object value = (Object) queryMap.get(keyArray[i]);
			if (value instanceof String) {
				if (value == null || ((String) value).trim().length() == 0) {
					queryMap.remove(keyArray[i]);
				}
			}
		}

		int totalCount = 0;
		String hsql = (String) queryMap.get("_hsql");
		if (hsql != null) {
			Query query = getSession().createSQLQuery("select count(tt.id) as totalCount from " + hsql).addScalar("totalCount", Hibernate.INTEGER);
			totalCount = ((Integer) query.uniqueResult())
					.intValue();
		} else {
			if (queryMap.get("id") != null) {
				criteria = criteria
						.add(Expression.eq("id", queryMap.get("id")));
			}
			if (queryMap.get("id_like") != null) {
				criteria = criteria.add(Expression.like("id", "%"
						+ queryMap.get("id_like") + "%"));
			}

			if (queryMap.get("settleDt") != null) {
				criteria = criteria.add(Expression.eq("settleDt", java.sql.Date
						.valueOf(Tools.getFormatDate(((java.util.Date) queryMap
								.get("settleDt")), "yyyy-MM-dd"))));
			}
			if (queryMap.get("settleDt_min") != null) {
				criteria = criteria.add(Expression.ge("settleDt", queryMap.get("settleDt_min")));
			}
			if (queryMap.get("settleDt_max") != null) {
				criteria = criteria.add(Expression.le("settleDt", queryMap.get("settleDt_max")));
			}
			if (queryMap.get("sysTraNo") != null) {
				criteria = criteria.add(Expression.eq("sysTraNo", queryMap
						.get("sysTraNo")));
			}
			if (queryMap.get("sysTraNo_like") != null) {
				criteria = criteria.add(Expression.like("sysTraNo", "%"
						+ queryMap.get("sysTraNo_like") + "%"));
			}

			if (queryMap.get("respCd4") != null) {
				criteria = criteria.add(Expression.eq("respCd4", queryMap
						.get("respCd4")));
			}
			if (queryMap.get("respCd4_like") != null) {
				criteria = criteria.add(Expression.like("respCd4", "%"
						+ queryMap.get("respCd4_like") + "%"));
			}

			if (queryMap.get("transId") != null) {
				criteria = criteria.add(Expression.eq("transId", queryMap
						.get("transId")));
			}
			if (queryMap.get("transId_like") != null) {
				criteria = criteria.add(Expression.like("transId", "%"
						+ queryMap.get("transId_like") + "%"));
			}

			if (queryMap.get("settleIn") != null) {
				criteria = criteria.add(Expression.eq("settleIn", queryMap
						.get("settleIn")));
			}
			if (queryMap.get("settleIn_like") != null) {
				criteria = criteria.add(Expression.like("settleIn", "%"
						+ queryMap.get("settleIn_like") + "%"));
			}

			if (queryMap.get("transAt") != null) {
				criteria = criteria.add(Expression.eq("transAt", new Integer(
						(String) queryMap.get("transAt"))));
			}
			if (queryMap.get("transAt_min") != null) {
				criteria = criteria.add(Expression.ge("transAt", new Integer(
						(String) queryMap.get("transAt_min"))));
			}
			if (queryMap.get("transAt_max") != null) {
				criteria = criteria.add(Expression.le("transAt", new Integer(
						(String) queryMap.get("transAt_max"))));
			}
			if (queryMap.get("msgTp") != null) {
				criteria = criteria.add(Expression.eq("msgTp", queryMap
						.get("msgTp")));
			}
			if (queryMap.get("msgTp_like") != null) {
				criteria = criteria.add(Expression.like("msgTp", "%"
						+ queryMap.get("msgTp_like") + "%"));
			}

			if (queryMap.get("locTransDtTm") != null) {
				criteria = criteria.add(Expression.eq("locTransDtTm", queryMap
						.get("locTransDtTm")));
			}
			if (queryMap.get("locTransDtTm_like") != null) {
				criteria = criteria.add(Expression.like("locTransDtTm", "%"
						+ queryMap.get("locTransDtTm_like") + "%"));
			}

			if (queryMap.get("mchntTp") != null) {
				criteria = criteria.add(Expression.eq("mchntTp", queryMap
						.get("mchntTp")));
			}
			if (queryMap.get("mchntTp_like") != null) {
				criteria = criteria.add(Expression.like("mchntTp", "%"
						+ queryMap.get("mchntTp_like") + "%"));
			}

			if (queryMap.get("retriRefNo") != null) {
				criteria = criteria.add(Expression.eq("retriRefNo", queryMap
						.get("retriRefNo")));
			}
			if (queryMap.get("retriRefNo_like") != null) {
				criteria = criteria.add(Expression.like("retriRefNo", "%"
						+ queryMap.get("retriRefNo_like") + "%"));
			}

			if (queryMap.get("priAcctNo") != null) {
				criteria = criteria.add(Expression.eq("priAcctNo", queryMap
						.get("priAcctNo")));
			}
			if (queryMap.get("priAcctNo_like") != null) {
				criteria = criteria.add(Expression.like("priAcctNo", "%"
						+ queryMap.get("priAcctNo_like") + "%"));
			}

			if (queryMap.get("bin") != null) {
				criteria = criteria.add(Expression.eq("bin", queryMap
						.get("bin")));
			}
			if (queryMap.get("bin_like") != null) {
				criteria = criteria.add(Expression.like("bin", "%"
						+ queryMap.get("bin_like") + "%"));
			}

			if (queryMap.get("cardAttr") != null) {
				criteria = criteria.add(Expression.eq("cardAttr", queryMap
						.get("cardAttr")));
			}
			if (queryMap.get("cardAttr_like") != null) {
				criteria = criteria.add(Expression.like("cardAttr", "%"
						+ queryMap.get("cardAttr_like") + "%"));
			}

			if (queryMap.get("cardMedia") != null) {
				criteria = criteria.add(Expression.eq("cardMedia", queryMap
						.get("cardMedia")));
			}
			if (queryMap.get("cardMedia_like") != null) {
				criteria = criteria.add(Expression.like("cardMedia", "%"
						+ queryMap.get("cardMedia_like") + "%"));
			}

			if (queryMap.get("termId") != null) {
				criteria = criteria.add(Expression.eq("termId", queryMap
						.get("termId")));
			}
			if (queryMap.get("termId_like") != null) {
				criteria = criteria.add(Expression.like("termId", "%"
						+ queryMap.get("termId_like") + "%"));
			}

			if (queryMap.get("mchntCd") != null) {
				criteria = criteria.add(Expression.eq("mchntCd", queryMap
						.get("mchntCd")));
			}
			if (queryMap.get("mchntCd_like") != null) {
				criteria = criteria.add(Expression.like("mchntCd", "%"
						+ queryMap.get("mchntCd_like") + "%"));
			}

			if (queryMap.get("cardAccptrNmLoc") != null) {
				criteria = criteria.add(Expression.eq("cardAccptrNmLoc",
						queryMap.get("cardAccptrNmLoc")));
			}
			if (queryMap.get("cardAccptrNmLoc_like") != null) {
				criteria = criteria.add(Expression.like("cardAccptrNmLoc", "%"
						+ queryMap.get("cardAccptrNmLoc_like") + "%"));
			}

			if (queryMap.get("acqInsIdCd") != null) {
				criteria = criteria.add(Expression.eq("acqInsIdCd", queryMap
						.get("acqInsIdCd")));
			}
			if (queryMap.get("acqInsIdCd_like") != null) {
				criteria = criteria.add(Expression.like("acqInsIdCd", "%"
						+ queryMap.get("acqInsIdCd_like") + "%"));
			}

			if (queryMap.get("fwdInsIdCd") != null) {
				criteria = criteria.add(Expression.eq("fwdInsIdCd", queryMap
						.get("fwdInsIdCd")));
			}
			if (queryMap.get("fwdInsIdCd_like") != null) {
				criteria = criteria.add(Expression.like("fwdInsIdCd", "%"
						+ queryMap.get("fwdInsIdCd_like") + "%"));
			}

			if (queryMap.get("rcvInsIdCd") != null) {
				criteria = criteria.add(Expression.eq("rcvInsIdCd", queryMap
						.get("rcvInsIdCd")));
			}
			if (queryMap.get("rcvInsIdCd_like") != null) {
				criteria = criteria.add(Expression.like("rcvInsIdCd", "%"
						+ queryMap.get("rcvInsIdCd_like") + "%"));
			}

			if (queryMap.get("issInsIdCd") != null) {
				criteria = criteria.add(Expression.eq("issInsIdCd", queryMap
						.get("issInsIdCd")));
			}
			if (queryMap.get("issInsIdCd_like") != null) {
				criteria = criteria.add(Expression.like("issInsIdCd", "%"
						+ queryMap.get("issInsIdCd_like") + "%"));
			}

			if (queryMap.get("origSysTraNo") != null) {
				criteria = criteria.add(Expression.eq("origSysTraNo", queryMap
						.get("origSysTraNo")));
			}
			if (queryMap.get("origSysTraNo_like") != null) {
				criteria = criteria.add(Expression.like("origSysTraNo", "%"
						+ queryMap.get("origSysTraNo_like") + "%"));
			}

			if (queryMap.get("origTransmsnDtTm") != null) {
				criteria = criteria.add(Expression.eq("origTransmsnDtTm",
						queryMap.get("origTransmsnDtTm")));
			}
			if (queryMap.get("origTransmsnDtTm_like") != null) {
				criteria = criteria.add(Expression.like("origTransmsnDtTm", "%"
						+ queryMap.get("origTransmsnDtTm_like") + "%"));
			}

			if (queryMap.get("rsnCd") != null) {
				criteria = criteria.add(Expression.eq("rsnCd", queryMap
						.get("rsnCd")));
			}
			if (queryMap.get("rsnCd_like") != null) {
				criteria = criteria.add(Expression.like("rsnCd", "%"
						+ queryMap.get("rsnCd_like") + "%"));
			}

			if (queryMap.get("authDt") != null) {
				criteria = criteria.add(Expression.eq("authDt",
						(String) queryMap.get("authDt")));
			}
			if (queryMap.get("authDt_like") != null) {
				criteria = criteria.add(Expression.ge("authDt", "%"
						+ queryMap.get("authDt_like") + "%"));
			}
			if (queryMap.get("authIdRespCd") != null) {
				criteria = criteria.add(Expression.eq("authIdRespCd", queryMap
						.get("authIdRespCd")));
			}
			if (queryMap.get("authIdRespCd_like") != null) {
				criteria = criteria.add(Expression.like("authIdRespCd", "%"
						+ queryMap.get("authIdRespCd_like") + "%"));
			}

			if (queryMap.get("posEntryMdCd") != null) {
				criteria = criteria.add(Expression.eq("posEntryMdCd", queryMap
						.get("posEntryMdCd")));
			}
			if (queryMap.get("posEntryMdCd_like") != null) {
				criteria = criteria.add(Expression.like("posEntryMdCd", "%"
						+ queryMap.get("posEntryMdCd_like") + "%"));
			}

			if (queryMap.get("posCondCd") != null) {
				criteria = criteria.add(Expression.eq("posCondCd", queryMap
						.get("posCondCd")));
			}
			if (queryMap.get("posCondCd_like") != null) {
				criteria = criteria.add(Expression.like("posCondCd", "%"
						+ queryMap.get("posCondCd_like") + "%"));
			}

			if (queryMap.get("procCd") != null) {
				criteria = criteria.add(Expression.eq("procCd", queryMap
						.get("procCd")));
			}
			if (queryMap.get("procCd_like") != null) {
				criteria = criteria.add(Expression.like("procCd", "%"
						+ queryMap.get("procCd_like") + "%"));
			}

			if (queryMap.get("settleYm") != null) {
				criteria = criteria.add(Expression.eq("settleYm", queryMap
						.get("settleYm")));
			}
			if (queryMap.get("settleYm_like") != null) {
				criteria = criteria.add(Expression.like("settleYm", "%"
						+ queryMap.get("settleYm_like") + "%"));
			}

			if (queryMap.get("fwdInsIdOriginal") != null) {
				criteria = criteria.add(Expression.eq("fwdInsIdOriginal",
						queryMap.get("fwdInsIdOriginal")));
			}
			if (queryMap.get("fwdInsIdOriginal_like") != null) {
				criteria = criteria.add(Expression.like("fwdInsIdOriginal", "%"
						+ queryMap.get("fwdInsIdOriginal_like") + "%"));
			}
			totalCount = ((Integer) criteria.setProjection(
					Projections.rowCount()).uniqueResult()).intValue();
		}
		return totalCount;
	}
}
