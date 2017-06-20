package cn.com.brilliance.begen.common.bundle;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

public class ApplicationResource {

	private static Map<String,Properties> resourceMap = null;
	
	static{
		load();
	}
	
	public static void load(){
		resourceMap = new HashMap<String,Properties>();
		for (Locale locale : Locale.getAvailableLocales()){
			Properties prop = new Properties();
			try {
				prop.load(ApplicationResource.class.getResourceAsStream("/Resource_" + locale.getLanguage() + ".properties"));
			} catch (Exception e) {
				try {
					prop.load(ApplicationResource.class.getResourceAsStream("/Resource_" + locale.toString() + ".properties"));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
				}
			}
			resourceMap.put(locale.toString(), prop);
		}
	}
	
	public static String getText(String resourceName,Locale locale){
		if (resourceMap == null)
			load();
		Properties prop = resourceMap.get(locale.toString());
		if(prop != null)
			return prop.getProperty(resourceName);
		else
			return null;
	}
}
