/**
 * 
 */
package cn.com.brilliance.risk.ext.common;

import java.util.Comparator;

import cn.com.brilliance.begen.model.TruleInstanceGroupSegment;

/**
 * @author IBM
 * 
 */
public class LimitComparator implements Comparator {

	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		TruleInstanceGroupSegment object1 = (TruleInstanceGroupSegment) arg0;
		TruleInstanceGroupSegment object2 = (TruleInstanceGroupSegment) arg1;
		String fieldValue1 = object1.getRuleInstanceId();
		String fieldValue2 = object2.getRuleInstanceId();
		if (fieldValue1.equals(fieldValue2)) {
			Float begin1 = object1.getBegin();
			Float begin2 = object2.getBegin();
			if (begin1 == null || begin2 == null) {
				return -1;
			} else {
				return begin1.compareTo(begin2);
			}
		}
		return fieldValue1.compareTo(fieldValue2);
	}

}
