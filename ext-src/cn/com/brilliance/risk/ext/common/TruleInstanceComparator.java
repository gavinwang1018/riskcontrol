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
public class TruleInstanceComparator implements Comparator {

	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		TruleInstanceGroupSegment object1 = (TruleInstanceGroupSegment) arg0;
		TruleInstanceGroupSegment object2 = (TruleInstanceGroupSegment) arg1;
		String fieldValue1 = object1.getRuleInstanceIdOfTruleInstance()
				.getType();
		String fieldValue2 = object2.getRuleInstanceIdOfTruleInstance()
				.getType();
		if (fieldValue1 == null || fieldValue2 == null) {
			return -1;
		} else {
			return fieldValue2.compareTo(fieldValue1);
		}
	}

}
