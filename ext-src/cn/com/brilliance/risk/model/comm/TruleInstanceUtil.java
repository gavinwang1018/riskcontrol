package cn.com.brilliance.risk.model.comm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.ISBNValidator;

import cn.com.brilliance.begen.common.Tools;

public class TruleInstanceUtil {
	// 判断是否为非负整数
	public static boolean isNumeric(String str) {
		if(str.length()>20){
			return false;
		}
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	// 判断是否为0~1小数
	public static boolean isDecimal(String str) {
		if(str.length()>20){
			return false;
		}
		if (str.equals("0") || str.equals("1")) {
			return true;
		}
		if (str.indexOf(".") == 1) {
			if (str.indexOf("0") == 0) {
				if (str.length() == 4 || str.length() == 3) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean isRightDatePeriod(String firstDate, String lastDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date first = sdf.parse(firstDate);
			Date last = sdf.parse(lastDate);
			if (first.before(last)) {
				return true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean isNumeric(String code, String str) {
		if (code.equals("R01") || code.equals("R15") || code.equals("R20")
				|| code.equals("R29")||code.equals("R06")||code.equals("R07")||code.equals("R10")||code.equals("R14")
				|| code.equals("R19")||code.equals("R25")||code.equals("R26")||code.equals("R28")||code.equals("R37"))
			return isNumeric(str);
		return false;
	}

	public static boolean isDecimal(String code, String str) {
		if (code.equals("R02") || code.equals("R03") || code.equals("R04")
				|| code.equals("R05") || code.equals("R08")
				|| code.equals("R09") || code.equals("R10")
				|| code.equals("R11") || code.equals("R16")
				|| code.equals("R17") || code.equals("R35")
				|| code.equals("R36")) {
			return isDecimal(str);
		}
		return false;
	}
	
	public static boolean isRightTime(String str){
		boolean flag = false;
		if(isNumeric(str)){
			int hour = Integer.parseInt(str.substring(0, 2));
			int minute = Integer.parseInt(str.substring(2, 4));
			if(hour>=0 && hour<24){
				flag = true;
			}else{
				flag = false;
				return flag;
			}
			if(minute>=0 && minute<60){
				flag = true;
			}else{
				flag = false;
				return flag;
			}
		}else{
			return flag;
		}
		return flag;
	}
	
	public static boolean resetMccBgthan1(String str){
		if(str.length()>20){
			return false;
		}
		if(isNumeric(str)){
			if(Integer.parseInt(str)>=1){
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String str="2006-03-02";
		System.out.println(str.substring(0, 4)+str.substring(5, 7)+str.substring(8, 10));
	}
}
