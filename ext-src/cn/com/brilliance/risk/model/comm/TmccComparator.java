package cn.com.brilliance.risk.model.comm;

import java.util.Comparator;

import cn.com.brilliance.begen.model.Tmcc;

public class TmccComparator implements Comparator {

	public int compare(Object o1, Object o2) {
		Tmcc mcc1 = (Tmcc) o1;
		Tmcc mcc2 = (Tmcc) o2;
		if (Integer.parseInt(mcc1.getBigmccCode()) < Integer.parseInt(mcc2.getBigmccCode())){
			return 0;
		}
		else
			return 1;
	}


}
