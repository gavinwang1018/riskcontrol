package cn.com.brilliance.begen.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import cn.com.brilliance.begen.common.Tools;

public class FormulaData extends HashMap {

	/**
	 * 
	 */
	private static final long serialVersionUID = -791284883959027617L;

	private Object valueObject;

	public FormulaData(Object _valueObject) {
		this.valueObject = _valueObject;
	}

	public Object get(String key) {
		try {
			return BeanUtils.getProperty(valueObject, key);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Object getParent(String parentName, String fieldName) {
		List parentList = null;
		try {
			Object dao = Tools.getBean(parentName + "DAO");
			Class clz = dao.getClass();
			Method methods = clz.getDeclaredMethod("get"
					+ Tools.makeFirstLetterUpperCase(parentName)
					+ "ListOfQuery", new Class[] { Map.class });
			Map<String, String> map = new HashMap<String, String>();
			map.put(fieldName, getParameter(fieldName, valueObject));
			parentList = (List) methods.invoke(dao, map);
			if (parentList != null && parentList.size() > 0) {
				return parentList.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private String getParameter(String fieldName, Object valueObject) {
		String parameter = "";
		try {
			parameter = BeanUtils.getProperty(valueObject, fieldName);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return parameter;
	}

}
