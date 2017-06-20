package cn.com.brilliance.begen.common.dao;

import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public abstract class BeGenHibernateDaoSupport extends HibernateDaoSupport {
	
	protected void addOrder(Map queryMap, Criteria criteria) {
		String[] orders = ((String)queryMap.get("_order")).split(",");
		for(int i=0;i<orders.length;i++) {
			String[] order = orders[i].split(" ");
			if (order[1].equalsIgnoreCase("asc"))
				criteria.addOrder(Order.asc(order[0]));
			else if(order[1].equalsIgnoreCase("desc"))
				criteria.addOrder(Order.desc(order[0]));
		}
	}
}
