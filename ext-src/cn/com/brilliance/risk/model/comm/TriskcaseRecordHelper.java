package cn.com.brilliance.risk.model.comm;

import java.sql.Timestamp;
import java.util.Date;

import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.TorganizeInfoDAO;
import cn.com.brilliance.begen.model.TorganizeInfo;

public class TriskcaseRecordHelper {
	
	public static String getBelongInstName(String id) {
		TorganizeInfoDAO torganizeInfoDAO = (TorganizeInfoDAO)Tools.getBean("torganizeInfoDAO");
		TorganizeInfo torganizeInfo = torganizeInfoDAO.getTorganizeInfo(id);
		return torganizeInfo.getName();
	}
	
	public static String getCreateDate(Timestamp date) {
		if(date != null) {
			String str = date.toString();
			return str.substring(0,10);
		}
		return null;
		
	}
	
	public static String getCasefrom(String casefrom) {
		String casefromName = "";
		if("0".equals(casefrom)) {
			casefromName="银商集团总公司";
		} else if("1".equals(casefrom)) {
			casefromName = "银商集团分公司";
		} else if("2".equals(casefrom)) {
			casefromName = "银联集团";
		} else if("3".equals(casefrom)) {
			casefromName = "其它机构举报";
		} else if("4".equals(casefrom)) {
			casefromName = "报刊媒体广告";
		} else if("5".equals(casefrom)) {
			casefromName = "其它渠道";
		}
		return casefromName;
	}
	
	public static String getLevel(String level) {
		String levelName = "";
		if("0".equals(level)) {
			levelName = "提示";
		} else if("1".equals(level)) {
			levelName = "关注";
		} else if("2".equals(level)) {
			levelName = "预警";
		} else if("3".equals(level)) {
			levelName = "警告";
		}
		return levelName;
	}

}
