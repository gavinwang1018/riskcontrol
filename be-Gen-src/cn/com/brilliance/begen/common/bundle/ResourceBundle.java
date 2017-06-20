package cn.com.brilliance.begen.common.bundle;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

public class ResourceBundle {
	final private static String SESSION_LOCALE = "__session_locale";
	
	public static Locale getLocale(HttpServletRequest request){
		Locale locale = (Locale)request.getSession().getAttribute(SESSION_LOCALE);
		if (locale == null)
			return request.getLocale();
		else
			return locale;
	}
	
	public static void setLocale(HttpServletRequest request,Locale locale){
		request.getSession().setAttribute(SESSION_LOCALE,locale);
	}
	
	public static void setLocale(HttpServletRequest request,String localeString){
		for (Locale locale : Locale.getAvailableLocales()){
			if (locale.toString().equals(localeString)){
				request.getSession().setAttribute(SESSION_LOCALE,locale);
			}
		}
	}
	
	public static String getText(HttpServletRequest request,String resourceName){
		return ApplicationResource.getText(resourceName, getLocale(request));
	}
	
}
