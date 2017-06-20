package cn.com.brilliance.begen.service;

import java.util.List;

import cn.com.brilliance.begen.model.SysMessage;

public interface MessageManager {
	
	final static String COUNT_TYPE_ALL = "0";
	
	final static String COUNT_TYPE_IN = "1";
	
	final static String COUNT_TYPE_OUT = "2";
	
	final static String COUNT_RECYCLED = "3";

	final static String TYPE_IN = "1";
	
	final static String TYPE_OUT = "2";

	final static String TYPE_RECYCLED_IN = "3";
	
	final static String TYPE_RECYCLED_OUT = "4";
	
	public List<SysMessage> list(String type,String userId);

	public void delete(String msgId);
	
	public void clear(String msgId);
	
	public void recover(String msgId);

	public SysMessage detail(String msgId);
	
	public int getCount(String countType,String userId);

	public void save(String title,String content,String sender,String type,String[] user,String[] role,String[] org);

}
