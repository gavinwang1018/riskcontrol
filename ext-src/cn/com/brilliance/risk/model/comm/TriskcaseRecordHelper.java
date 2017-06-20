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
			casefromName="���̼����ܹ�˾";
		} else if("1".equals(casefrom)) {
			casefromName = "���̼��ŷֹ�˾";
		} else if("2".equals(casefrom)) {
			casefromName = "��������";
		} else if("3".equals(casefrom)) {
			casefromName = "���������ٱ�";
		} else if("4".equals(casefrom)) {
			casefromName = "����ý����";
		} else if("5".equals(casefrom)) {
			casefromName = "��������";
		}
		return casefromName;
	}
	
	public static String getLevel(String level) {
		String levelName = "";
		if("0".equals(level)) {
			levelName = "��ʾ";
		} else if("1".equals(level)) {
			levelName = "��ע";
		} else if("2".equals(level)) {
			levelName = "Ԥ��";
		} else if("3".equals(level)) {
			levelName = "����";
		}
		return levelName;
	}

}
