package cn.com.brilliance.begen.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.SysMessageDAO;
import cn.com.brilliance.begen.dao.SysUserDAO;
import cn.com.brilliance.begen.dao.SysUserRoleDAO;
import cn.com.brilliance.begen.model.SysMessage;
import cn.com.brilliance.begen.model.SysUser;
import cn.com.brilliance.begen.model.SysUserRole;
import cn.com.brilliance.begen.service.MessageManager;

public class MessageManagerImpl implements MessageManager {

	public void clear(String msgId) {
		// TODO Auto-generated method stub
		SysMessageDAO sysMessageDAO = (SysMessageDAO) Tools.getBean("sysMessageDAO");
		sysMessageDAO.removeSysMessage(msgId);
	}

	public void delete(String msgId) {
		// TODO Auto-generated method stub
		SysMessageDAO sysMessageDAO = (SysMessageDAO) Tools.getBean("sysMessageDAO");
		SysMessage sysMessage = sysMessageDAO.getSysMessage(msgId);
		if(TYPE_IN.equals(sysMessage.getType())){
			sysMessage.setType(TYPE_RECYCLED_IN);
		}
		else if (TYPE_OUT.equals(sysMessage.getType())){
			sysMessage.setType(TYPE_RECYCLED_OUT);
		}
		sysMessageDAO.saveSysMessage(sysMessage);
	}

	public SysMessage detail(String msgId) {
		// TODO Auto-generated method stub
		SysMessageDAO sysMessageDAO = (SysMessageDAO) Tools.getBean("sysMessageDAO");		
		return sysMessageDAO.getSysMessage(msgId);
	}

	public int getCount(String countType,String userId) {
		// TODO Auto-generated method stub
		SysMessageDAO sysMessageDAO = (SysMessageDAO) Tools.getBean("sysMessageDAO");
		Map queryMap = new HashMap();
		String hsql = "";
		if(COUNT_TYPE_ALL.equals(countType)){
			hsql = "read_flag = '0' and ((receiver = '" + userId + "' and type = '" + TYPE_IN + "') or (sender = '" + userId + "' and type = '" + TYPE_OUT + "'))";			
		}
		if(COUNT_TYPE_IN.equals(countType)){
			hsql = "read_flag = '0' and (receiver = '" + userId + "' and type = '" + TYPE_IN + "')";
		}
		if(COUNT_TYPE_OUT.equals(countType)){
			hsql = "read_flag = '0' and (sender = '" + userId + "' and type = '" + TYPE_OUT + "')";
		}
		if(COUNT_RECYCLED.equals(countType)){
			hsql = "type in(3,4)";
		}
		queryMap.put("_hsql", hsql);
		List list = sysMessageDAO.getSysMessageListOfNoAuthorityQuery(queryMap);		
		return list.size();
	}

	public List<SysMessage> list(String type,String userId) {
		// TODO Auto-generated method stub
		SysMessageDAO sysMessageDAO = (SysMessageDAO) Tools.getBean("sysMessageDAO");
		SysMessage sysMessage = new SysMessage();
		sysMessage.setType(type);
		if (this.TYPE_IN.equals(type) || this.TYPE_RECYCLED_IN.equals(type)){
			sysMessage.setReceiver(userId);
		}
		else{
			sysMessage.setSender(userId);
		}
		return sysMessageDAO.getSysMessageList(sysMessage);		
	}

	public void recover(String msgId) {
		// TODO Auto-generated method stub
		SysMessageDAO sysMessageDAO = (SysMessageDAO) Tools.getBean("sysMessageDAO");
		SysMessage sysMessage = sysMessageDAO.getSysMessage(msgId);
		if (TYPE_RECYCLED_IN.equals(sysMessage.getType()))			
			sysMessage.setType(TYPE_IN);
		else if (TYPE_RECYCLED_OUT.equals(sysMessage.getType()))			
			sysMessage.setType(TYPE_OUT);
		sysMessageDAO.saveSysMessage(sysMessage);
	}

	public void save(String title, String content, String sender, String type,
			String[] user, String[] role, String[] org) {
		// TODO Auto-generated method stub
		SysMessageDAO sysMessageDAO = (SysMessageDAO) Tools.getBean("sysMessageDAO");
		Map<String,String> map = new HashMap<String,String>();
		if (user != null){
			for (String userId : user)
				map.put(userId,userId);
		}
		if (role != null){
			for (String roleId : role){
				for (String userId: getUserListOfRole(roleId))
					map.put(userId,userId);
			}
		}
		if (org != null){
			for (String orgId : org)
				for(String userId : getUserListOfOrg(orgId))
					map.put(userId,userId);
		}
		for (String receiver : map.keySet()){
			SysMessage sysMessage  = new SysMessage();
			sysMessage.setReceiver(receiver);
			sysMessage.setSender(sender);
			sysMessage.setTitle(title);
			sysMessage.setContent(content);
			sysMessage.setType(type);
			sysMessage.setReadFlag(false);
			sysMessage.setSendTime(new Date());
			sysMessageDAO.saveSysMessage(sysMessage);
		}
	}
	
	
	private List<String> getUserListOfRole(String roleId){
		List<String> list = new ArrayList<String>();	
		SysUserRoleDAO sysUserRoleDAO = (SysUserRoleDAO) Tools.getBean("sysUserRoleDAO");
		SysUserRole sysUserRole = new SysUserRole();
		sysUserRole.setRoleId(roleId);
		List<SysUserRole> userRoleList = sysUserRoleDAO.getSysUserRoleList(sysUserRole);
		for(SysUserRole userRole : userRoleList){
			list.add(userRole.getUserId());
		}
		return list;
	}
	
	private List<String> getUserListOfOrg(String orgId){
		List<String> list = new ArrayList<String>();
		SysUserDAO sysUserDAO = (SysUserDAO) Tools.getBean("sysUserDAO");
		SysUser sysUser = new SysUser();
		sysUser.setOrgId(orgId);
		List<SysUser> userList = sysUserDAO.getSysUserList(sysUser);
		for(SysUser user : userList){
			list.add(user.getId());
		}
		return list;
	}

}
