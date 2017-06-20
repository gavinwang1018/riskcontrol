package cn.com.brilliance.risk.ext.common;

import java.util.Comparator;

public class NumberComparator implements Comparator {

	public int compare(Object o1, Object o2) {
		String s1 = (String) o1;
		String s2 = (String) o2;
		if (Integer.parseInt(s1) < Integer.parseInt(s2))
			return 0;
		else
			return 1;
		
	}

}
