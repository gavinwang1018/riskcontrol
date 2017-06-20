package cn.com.brilliance.begen.common;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

import com.sun.jmx.snmp.Timestamp;

import cn.com.brilliance.begen.dao.SysUserDAO;
import cn.com.brilliance.begen.exception.BeGenException;
import cn.com.brilliance.begen.model.SysUser;
import cn.com.brilliance.begen.model.Tmcc;
import cn.com.brilliance.begen.webapp.listener.ContextLoaderListener;

public class Tools {
	private static Properties prop;

	private static VelocityEngine ve = null;

	private static Connection conn = null;

	private static Statement stmt = null;

	private static ResultSet rs = null;

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public Statement getStmt() {
		return stmt;
	}

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}

	public static VelocityEngine getVelocityEngine() {
		try {
			if (ve == null) {
				ve = new VelocityEngine();
				ve.init();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ve;
	}

	public static String getEnvionment(String name) {
		if (prop == null)
			try {
				prop = new Properties();
				prop.load(Tools.class
						.getResourceAsStream("/environment.properties"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		return prop.getProperty(name);
	}

	public static String getFormatDate(String format) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	public static String getDate() {
		return String.valueOf(System.currentTimeMillis());
	}

	public static String getFormatDate(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	public static String getNumString(int length, int num) {
		String rtn = "";
		for (int i = 0; i < length; i++) {
			rtn += "0";
		}
		rtn += num;
		return rtn.substring(rtn.length() - length);
	}

	public static String null2String(String str) {
		if (str == null)
			return "";
		else
			return str;
	}

	public static String makeClassName(String newStr) {
		return makeFirstLetterUpperCase(makeVarName(newStr));
	}

	// makes the first Letter UpperCase in a string

	public static String makeFirstLetterLowerCase(String newStr) {
		if (newStr.length() == 0)
			return newStr;

		char[] oneChar = new char[1];
		oneChar[0] = newStr.charAt(0);
		String firstChar = new String(oneChar);
		return (firstChar.toLowerCase() + newStr.substring(1));
	}

	// makes the first Letter UpperCase in a string

	public static String makeFirstLetterUpperCase(String newStr) {
		if (newStr.length() == 0)
			return newStr;

		char[] oneChar = new char[1];
		oneChar[0] = newStr.charAt(0);
		String firstChar = new String(oneChar);
		return (firstChar.toUpperCase() + newStr.substring(1));
	}

	// strips blank/special characters from a string and makes first char after
	// a special character
	// upper case (excluding the very first character of the string)

	public static String makeVarName(String newStr) {
		StringBuffer retstr = new StringBuffer("");
		String specialCharacters = " _/,#'%-";
		String numericCharacters = "0123456789";
		int strlen = newStr.length();
		char[] onechar = new char[1];
		boolean nextUpper = false;
		boolean firstChar = true;

		for (int i = 0; i < strlen; i++) {
			onechar[0] = newStr.charAt(i);
			String charString = new String(onechar);
			if (specialCharacters.indexOf(charString) >= 0) {
				if (charString.equals("'"))
					nextUpper = false;
				else
					nextUpper = true;
			} else {
				if (nextUpper) {
					if (!firstChar)
						retstr.append(charString.toUpperCase());
					else
						retstr.append(charString.toLowerCase());
					firstChar = false;
					nextUpper = false;
				} else {
					retstr.append(charString.toLowerCase());
					firstChar = false;
				}
			}

		}
		// if first character is numeric, insert an 'x' at the first position
		if (numericCharacters.indexOf(String.valueOf(retstr.charAt(0))) >= 0)
			retstr = retstr.insert(0, 'x');

		return retstr.toString();
	}

	public static String makeFieldName(String name) {
		name = makeFirstLetterLowerCase(name);
		String upperCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuffer retstr = new StringBuffer("");
		for (int i = 0; i < name.length(); i++) {
			if (upperCharacters.indexOf(name.charAt(i)) != -1) {
				retstr.append("_");
			}
			retstr.append(String.valueOf(name.charAt(i)).toLowerCase());
		}
		return retstr.toString();
	}

	public static Object getDataObjectBean(String dataObjectId,
			String dataObjectName) throws ClassNotFoundException,
			NoSuchMethodException, IllegalAccessException,
			InvocationTargetException {
		Object objectDAO = ContextLoaderListener.getApplicationContext()
				.getBean(Tools.makeVarName(dataObjectName) + "DAO");
		Class objectDAOClass = objectDAO.getClass();
		Class[] paramClass = new Class[1];
		paramClass[0] = String.class;
		Method method = objectDAOClass.getMethod("get"
				+ Tools.makeClassName(dataObjectName), paramClass);
		Object[] param = new Object[1];
		param[0] = dataObjectId;
		Object object = method.invoke(objectDAO, param);
		return object;
	}

	public static Object saveDataObjectBean(String dataObjectName, Object obj) {
		Object objectDAO = ContextLoaderListener.getApplicationContext()
				.getBean(Tools.makeVarName(dataObjectName) + "DAO");
		Class objectDAOClass = objectDAO.getClass();
		Class[] paramClass = new Class[1];
		paramClass[0] = obj.getClass();
		Method method;
		try {
			method = objectDAOClass.getMethod("save"
					+ Tools.makeClassName(dataObjectName), paramClass);
			Object[] param = new Object[1];
			param[0] = obj;
			Object object = method.invoke(objectDAO, param);
			return object;
		} catch (Exception e) {
			throw new BeGenException("保存数据错误", e);
		}
	}

	public static String getProperty(Object bean, String key) {
		key = Tools.makeVarName(key);
		try {
			return BeanUtils.getProperty(bean, key);
		} catch (Exception e) {
			throw new BeGenException(e);
		}
	}

	public static void setProperty(Object bean, String keyName, String keyValue) {
		keyName = Tools.makeVarName(keyName);
		try {
			BeanUtils.setProperty(bean, keyName, keyValue);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public static void setProperty(Object bean, Map map) {
		Iterator it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			setProperty(bean, key, (String) map.get(key));
			;
		}
	}

	public static Object getBean(String name) {
		return ContextLoaderListener.getApplicationContext().getBean(name);
	}

	public static String evaluateFormula(String formula, Object valueObject) {
		try {
			VelocityContext vc = new VelocityContext();
			vc.put("data", valueObject);
			StringWriter sw = new StringWriter();
			getVelocityEngine().evaluate(vc, sw, "", formula);
			vc = null;
			return sw.toString();
		} catch (ParseErrorException e) {
			// TODO Auto-generated catch block
			throw new BeGenException("解析表达式错误 formula='" + formula + "'", e);
		} catch (MethodInvocationException e) {
			// TODO Auto-generated catch block
			throw new BeGenException("解析表达式错误 formula='" + formula + "'", e);
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			throw new BeGenException("资源文件没有找到", e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new BeGenException("输出结果错误", e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BeGenException("VELOCITY 初始化错误", e);
		}
	}

	public static String list2String(List<String> list, String division) {
		String str = "";
		if (list == null) {
			return str;
		}
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			if (i == 0) {
				str = str + s;
			} else {
				str = str + division + s;
			}
		}
		return str;
	}

	public static List string2List(String str, String division) {
		List<String> list = new ArrayList<String>();
		String[] strs = StringUtils.split(str, division);
		for (int i = 0; i < strs.length; i++) {
			list.add(strs[i]);
		}
		return list;
	}

	public static String getId() {
		return "ID_" + getFormatDate("yyyyMMddhhmmssSSS");
	}

	public static String getUserName(String id) {
		SysUserDAO sysUserDAO = (SysUserDAO) getBean("sysUserDAO");
		SysUser sysUser = sysUserDAO.getSysUser(id);
		if (sysUser != null)
			return sysUser.getUserId();
		return "";
	}

	/**
	 * 判断是星期几
	 * 
	 * @see #SUNDAY 0
	 * @see #MONDAY 1
	 * @see #TUESDAY 2
	 * @see #WEDNESDAY 3
	 * @see #THURSDAY 4
	 * @see #FRIDAY 5
	 * @see #SATURDAY 6
	 * @param format
	 *            如："yyyy-MM-dd HH:mm:ss"
	 * @return
	 */
	public static int getDayOfWeek(String dateStr, String format) {
		Calendar calendar = Calendar.getInstance();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			Date date = sdf.parse(dateStr);
			calendar.setTime(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		return dayOfWeek;
	}

	public static int getDayOfWeek(String dateStr) {
		return getDayOfWeek(dateStr, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 月的最后一天
	 * 
	 * @param dateStr
	 * @param format
	 *            如："yyyy-MM-dd HH:mm:ss"
	 * @return
	 */
	public static int getLastDayOfMonth(String dateStr, String format) {
		Calendar calendar = Calendar.getInstance();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			Date date = sdf.parse(dateStr);
			calendar.setTime(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int dayOfWeek = calendar.getActualMaximum(Calendar.DATE);
		return dayOfWeek;
	}

	public static int getLastDayOfMonth(String dateStr) {
		return getLastDayOfMonth(dateStr, "yyyy-MM-dd HH:mm:ss");
	}

	public static void cloneProperties(Object dest, Object source) {
		try {
			BeanUtils.copyProperties(dest, source);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 判断是否半月
	public static boolean isHalfOneMonth(Date beginDate, Date endDate) {
		boolean flag = false;

		String beginStr[] = getFormatDate(beginDate, "yyyy-MM-dd").split("-");
		String endStr[] = getFormatDate(endDate, "yyyy-MM-dd").split("-");

		if (beginStr[0].equals(endStr[0]) && beginStr[1].equals(endStr[1])) {
			if (beginStr[2].equals("01") && endStr[2].equals("15")) {
				flag = true;
			}
			if (beginStr[2].equals("16")
					&& endStr[2].equals(Integer
							.toString(getLastDayOfMonth(getFormatDate(endDate,
									"yyyy-MM-dd")
									+ " 00:00:00")))) {
				flag = true;
			}
		}

		return flag;
	}

	public static int getDayOfWeek(Date date) {
		return getDayOfWeek(getFormatDate(date, "yyyy-MM-dd") + " 00:00:00");
	}

	public static boolean isOneMonth(Date beginDate, Date endDate) {
		boolean flag = false;

		String beginStr[] = getFormatDate(beginDate, "yyyy-MM-dd").split("-");
		String endStr[] = getFormatDate(endDate, "yyyy-MM-dd").split("-");

		if (beginStr[0].equals(endStr[0]) && beginStr[1].equals(endStr[1])) {
			if (beginStr[2].equals("01")
					&& endStr[2].equals(Integer
							.toString(getLastDayOfMonth(getFormatDate(endDate,
									"yyyy-MM-dd")
									+ " 00:00:00")))) {
				flag = true;
			}
		}
		return flag;
	}

	public static boolean isOneWeek(Date beginDate, Date endDate) {
		boolean flag = false;

		// 同年同月
		String beginStr[] = getFormatDate(beginDate, "yyyy-MM-dd").split("-");
		String endStr[] = getFormatDate(endDate, "yyyy-MM-dd").split("-");
		if (beginStr[0].equals(endStr[0]) && beginStr[1].equals(endStr[1])) {
			if (getDayOfWeek(beginDate) == 5 && getDayOfWeek(endDate) == 4) {
				if (Integer.parseInt(endStr[2]) - Integer.parseInt(beginStr[2]) == 6) {
					flag = true;
				}
			}
		}
		// 同年异月
		if (beginStr[0].equals(endStr[0])
				&& (Integer.parseInt(endStr[1]) - Integer.parseInt(beginStr[1]) == 1)) {
			if (getDayOfWeek(beginDate) == 5 && getDayOfWeek(endDate) == 4) {
				if (Integer.parseInt(endStr[2])
						+ getLastDayOfMonth(getFormatDate(beginDate,
								"yyyy-MM-dd" + " 00:00:00"))
						- Integer.parseInt(beginStr[2]) == 6) {
					flag = true;
				}
			}
		}
		// 异年异月
		if (Integer.parseInt(endStr[0]) - Integer.parseInt(beginStr[0]) == 1) {

			if (beginStr[1].equals("12") && endStr[1].equals("01")) {
				if (getDayOfWeek(beginDate) == 5 && getDayOfWeek(endDate) == 4) {
					if (31 + Integer.parseInt(endStr[2])
							- Integer.parseInt(beginStr[2]) == 6) {
						flag = true;
					}
				}
			}
		}

		return flag;
	}

	public static Connection getConnection() {
		try {
		// 获取数据库连接，利用连接池方式hibernate的
			Context initCtx = new InitialContext();
			Context ctx = (Context) initCtx.lookup("java:comp/env");
			Object obj = (Object) ctx.lookup("riskControl");
			javax.sql.DataSource ds = (javax.sql.DataSource) obj;
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static ResultSet executeQuery(String sql) {
		try {
			if (getConnection() == null)
				return null;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public static void close() {
		try {
			if (conn != null)
				conn.close();
			if (stmt != null)
				stmt.close();
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static String getDate(String dateStr) {
		String str = dateStr.substring(0, 10);
		return str;
	}
	
	public static String isEmpty(String str){
		if(str==null || ("").equals(str)){
			return null;
		}
		return "empty";
	}
	
	public int compare(Object o1, Object o2) {
		String str1 = (String) o1;
		String str2 = (String) o2;
		if (Integer.parseInt(str1) < Integer.parseInt(str2))
			return 0;
		else
			return 1;
	}

	/**
	 * 将文件名中的汉字转为UTF8编码的串,以便下载时能正确显示另存的文件名
	 * 
	 * @param s
	 *            原文件名
	 * @return 重新编码后的文件名
	 */
	public static String toUtf8String(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 0 && c <= 255) {
				sb.append(c);
			} else {
				byte[] b;
				try {
					b = Character.toString(c).getBytes("utf-8");
				} catch (Exception ex) {
					ex.printStackTrace();
					b = new byte[0];
				}
				for (int j = 0; j < b.length; j++) {
					int k = b[j];
					if (k < 0)
						k += 256;
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();
	}
	
	public static String exchangeMonthNumber(String month){
		return (month.length()==1)?"0"+month:month;
	}
}
